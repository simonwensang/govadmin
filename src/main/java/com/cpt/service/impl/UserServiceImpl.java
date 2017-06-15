package com.cpt.service.impl;

 
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cpt.common.PageResult;
import com.cpt.common.Result;
import com.cpt.common.ResultCode;
import com.cpt.common.constant.Constants;
import com.cpt.common.constant.MessageConstants;
import com.cpt.common.constant.UserIdentity;
import com.cpt.controller.LoginController;
import com.cpt.convertor.UserConvertor;
import com.cpt.mapper.OrganizationMapper;
import com.cpt.mapper.RoleMapper;
import com.cpt.mapper.UserMapper;
import com.cpt.mapper.UserRoleMapper;
import com.cpt.mapper.ext.ModuleExtMapper;
import com.cpt.mapper.ext.RoleExtMapper;
import com.cpt.mapper.ext.UserExtMapper;
import com.cpt.model.Module;
import com.cpt.model.Organization;
import com.cpt.model.Role;
import com.cpt.model.RoleExample;
import com.cpt.model.User;
import com.cpt.model.UserExample;
import com.cpt.model.UserRole;
import com.cpt.model.UserRoleExample;
import com.cpt.req.UserQuery;
import com.cpt.service.UserCommonService;
import com.cpt.service.UserService;
import com.cpt.vo.UserVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper ;
	@Autowired
	private UserExtMapper userExtMapper ;
	@Autowired
	private UserCommonService userCommonService;
	@Autowired
	private OrganizationMapper organizationMapper;
	@Autowired
	private ModuleExtMapper moduleExtMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleExtMapper roleExtMapper;
	@Override
	public User getUser() {
		User user = get(userCommonService.getUserId());
		user.setModules(fixModule(moduleExtMapper.selectMenuByUserId(user.getId())));
		user.setRole(roleExtMapper.selectByUserId(user.getId()));
		user.setPassword("");
		return user;
	}

	private List<Module> fixModule(List<Module> modules){
		List<Module> moduleList = Lists.newArrayList();
		for(Module  module : modules){
			 if(module.getModuleType()==1){
				 moduleList.add(module);
			 }
		}
		for(Module  newmodule : moduleList){
			List<Module> subMenu = Lists.newArrayList();
			for(Module  module : modules){
				 if(module.getModuleType()==2&&module.getModuleKey().equals(newmodule.getId().toString())){
					 subMenu.add(module);
				 }
			}
			 newmodule.setSubMenu(subMenu);
		}
		
		return moduleList;
	}
	
	@Override
	public List<Role> getRoleList() {
		RoleExample example = new RoleExample();
		List<Role> roles =  roleMapper.selectByExample(example);
		return roles;
	}

	@Override
	public Result<Integer> exist(String name) {
		UserExample userExample =new UserExample();
		UserExample.Criteria criteria =userExample.createCriteria();
		criteria.andNameEqualTo(name);
		List<User> user =userMapper.selectByExample(userExample);
		if(user.size()>0){
			return new Result<Integer>(1);
		}else{
			return new Result<Integer>(ResultCode.C200.getCode(),MessageConstants.USER_EMPTY,0);
		}
	}

	@Override
	public User get(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult<User> query(UserQuery pageParam) {
		 //分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getLimit());
        //当前页列表
        List<User> users = userExtMapper.query(pageParam);
        //构造分页结果
        PageResult<User> pageResult = PageResult.newPageResult(users, ((Page<User>)users).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
	}

	@Override
	public List<UserVo> queryPriceOffer() {
		
		UserExample userExample =new UserExample();
		UserExample.Criteria criteria =userExample.createCriteria();
		criteria.andIdentityEqualTo(UserIdentity.PRICE_OFFER.getKey());
		criteria.andIsDeletedEqualTo(Constants.ISNOTDELETED);
		return UserConvertor.toUserVoList(userMapper.selectByExample(userExample));
	}

	@Override
	public PageResult<User> pageList(UserQuery pageParam) {
		 //分页
        PageHelper.startPage(pageParam.getPage(), pageParam.getLimit());
        //当前页列表
        List<User> users = userExtMapper.pageList(pageParam);
        //构造分页结果
        PageResult<User> pageResult = PageResult.newPageResult(users, ((Page<User>)users).getTotal(), pageParam.getPage(), pageParam.getRows());
        return pageResult;
		
	}

	@Override
	public PageResult<User> rolePageList( UserQuery userQuery) {
		 //分页
        PageHelper.startPage(userQuery.getPage(), userQuery.getLimit());
        //当前页列表
        List<User> users = userExtMapper.rolePageList(userQuery);
        //构造分页结果
        PageResult<User> pageResult = PageResult.newPageResult(users, ((Page<User>)users).getTotal(), userQuery.getPage(), userQuery.getRows());
        return pageResult;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> opt(UserVo userReq) {

		if(userReq.getId()==null||userReq.getIsDeleted()==null){
			return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
		}
		if(userReq.getIsDeleted()==3){
			return new Result<Integer>(this.delete(userReq.getId()));
		}
		User user = new User();
		user.setId(userReq.getId());
		user.setIsDeleted(userReq.getIsDeleted());
		return new Result<Integer>(this.update(user));
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Result<Integer> addOrEdit(User user) {
		if(user.getId()==null){
			if(StringUtils.isBlank(user.getAccount())
					||StringUtils.isBlank(user.getPassword())
					||StringUtils.isBlank(user.getConfirmPassword())
					||user.getDepartmentId()==null){
				return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
			}
			if(!user.getPassword().equals(user.getConfirmPassword())){
				return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_PASSWORD_ERROR);
			}
			
			String exitCode = (String) SecurityUtils.getSubject().getSession()
					.getAttribute(LoginController.KEY_CAPTCHA);
			if (null == user.getCaptcha() || !user.getCaptcha().equalsIgnoreCase(exitCode)) {
				return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_CAPTCHA_ERROR);
			}
			
			//查询部门名字
			Organization organization = organizationMapper.selectByPrimaryKey(user.getDepartmentId());
			user.setDepartment(organization.getName());
			//判断登录名是否重复
			UserExample example = new UserExample();
			UserExample.Criteria criteria = example.createCriteria();
			criteria.andAccountEqualTo(user.getAccount());
			List<User> old = userMapper.selectByExample(example);
			if(old.size()>0){
				return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.ACCOUNT_EXIT);
			}
			return Result.newResult(this.insert(user));
		}else{
			if( StringUtils.isNotBlank(user.getPassword())&&StringUtils.isNotBlank(user.getConfirmPassword()) ){
				if(!user.getPassword().equals(user.getConfirmPassword())){
					return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_PASSWORD_ERROR);
				}
				return Result.newResult(this.update(user));
			}else if( StringUtils.isNotBlank(user.getConfirmMobile())&&StringUtils.isNotBlank(user.getMobile()) ){
				if(!user.getMobile().equals(user.getConfirmMobile())){
					return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_MOBILE_ERROR);
				}
				return Result.newResult(this.update(user));
			}else{
				return new Result<Integer>(ResultCode.C500.getCode(),MessageConstants.PRARM_ERROR);
			}
		}
	
	}
	
	@Override
	public Result<Integer> role(UserQuery userQuery) {
		UserRole userRole = new UserRole();
		userRole.setRoleId(userQuery.getRoleId().longValue());
		UserRoleExample example = new UserRoleExample();
		UserRoleExample.Criteria  criteria  = example.createCriteria();
		criteria.andUserIdEqualTo(userQuery.getId());
		return  Result.newResult(userRoleMapper.updateByExampleSelective(userRole, example));
		 
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Integer insert(User user){
		//默认角色
		userExtMapper.insertSelective(user);
		UserRole userRole = new UserRole();
		userRole.setRoleId(Constants.USER_ROLE_ID);
		userRole.setUserId(user.getId());
		return userRoleMapper.insertSelective(userRole);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Integer update(User user){
		return userMapper.updateByPrimaryKeySelective(user);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Integer delete(Long id){
		return userMapper.deleteByPrimaryKey(id);
	}
}
