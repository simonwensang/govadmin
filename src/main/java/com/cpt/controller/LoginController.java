package com.cpt.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cpt.common.Result;
import com.cpt.common.util.CaptchaUtil;
import com.cpt.config.shiro.ShiroAuthorizationHelper;
import com.cpt.config.shiro.UsernamePasswordCaptchaToken;
import com.cpt.model.Organization;
import com.cpt.model.User;
import com.cpt.service.MessageService;
import com.cpt.service.OrganizationService;
import com.cpt.service.UserCommonService;
import com.cpt.service.UserService;

@Controller
public class LoginController {

	private static final Logger log =  LoggerFactory.getLogger(LoginController.class);
	
	public static final String KEY_CAPTCHA = "SE_KEY_MM_CODE";
	
	@Resource
	private UserCommonService userCommonService;
	
	@Resource
	private UserService userService;
	@Autowired 
	private MessageService messageService;
	@Resource
	private ShiroAuthorizationHelper shiroAuthorizationHelper;
	
	@Autowired 
	private  OrganizationService organizationService;
	
	@RequestMapping("/queryOrganization")
	@ResponseBody
	public List<Organization> queryOrganization(){
		return organizationService.select();
	}
	
	@RequestMapping({"/regist"})
	@ResponseBody
	public Result<Integer>  regist(ModelMap map ,User user){
    	return userService.addOrEdit(user);
	}
	
	@RequestMapping({"/captcha"})
	@ResponseBody
	public Result<Integer>  regist(ModelMap map ,User user, HttpServletRequest req, HttpServletResponse resp){
		// 设置相应类型,告诉浏览器输出的内容为图片
		resp.setContentType("image/jpeg");
		// 不缓存此内容
		resp.setHeader("Pragma", "No-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expire", 0);

		HttpSession session = req.getSession();

		CaptchaUtil tool = new CaptchaUtil();
		StringBuffer code = new StringBuffer();
		BufferedImage image = tool.genRandomCodeImage(code);
		session.removeAttribute(KEY_CAPTCHA);
		session.setAttribute(KEY_CAPTCHA, code.toString());

		Session sessions = SecurityUtils.getSubject().getSession();
		sessions.setAttribute(KEY_CAPTCHA, code.toString());
		
		// 将内存中的图片通过流动形式输出到客户端
		try {
			ImageIO.write(image, "JPEG", resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Result.newResult(1);
	}
	
	@RequestMapping({"/login"})
	public String login(ModelMap map){
		return "login";
	}
	
	@RequestMapping({"/",""})
	public String main(ModelMap map){
		return "redirect:/index";
	}
	@RequestMapping({"/index"})
	public String index(ModelMap map){
		map.addAttribute("user",userCommonService.getUser());
		map.addAttribute("organizationList",organizationService.select() );
		return "index";
	}
	
    @RequestMapping(value = "unlogin")
    public String unlogin() {
        return "redirect:/login";
    }
    
    @RequestMapping(value = "/toLogin", method = RequestMethod.POST)
    public String toLogin(User user) {
    	
    	//logger.debug("Processing trade with id: {} and symbol : {} ", id, symbol);
    	log.info("toLogin");
		UsernamePasswordCaptchaToken token = new UsernamePasswordCaptchaToken(user.getAccount().toLowerCase(), user.getPassword(),false,null,user.getCaptcha());
        token.setRememberMe(false);
        try {
        	SecurityUtils.getSubject().login(token);
        	return "redirect:/event/allReport";
        }catch (Exception e) {
        	log.error("登录失败错误信息:"+e);
        	token.clear();
        	return "redirect:/login";
        }
    }
    
    @RequestMapping(value="/logout",method=RequestMethod.GET)    
    public String logout(){   
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息  
    	shiroAuthorizationHelper.clearAuthorizationInfo();
        SecurityUtils.getSubject().logout();   
        return "redirect:/login";  
    } 
    
    public static String getRealIp(HttpServletRequest req) {
        String ip = req.getHeader("X-Real-IP");
        if (ip != null) {
            if (ip.indexOf(',') == -1) {
                return ip;
            }
            return ip.split(",")[0];
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getRemoteAddr();
        }

        return ip;
    }
}
