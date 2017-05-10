package com.cpt.convertor;


import java.util.List;

import org.springframework.cglib.beans.BeanCopier;

import com.cpt.model.UserLog;
import com.cpt.vo.UserLogVo;
import com.google.common.collect.Lists;

public class UserLogConvertor {
	
    private static final BeanCopier beanCopierForUserLogVo = BeanCopier.create(UserLog.class,UserLogVo.class,false);
    
    public static UserLogVo toUserLogVo(UserLog userLog) {
        if (userLog == null) {
            return null;
        }
        UserLogVo userLogVo = new UserLogVo();
        beanCopierForUserLogVo.copy(userLog, userLogVo, null);
        return userLogVo;
    }
    public static List<UserLogVo> toUserLogVoList(List<UserLog> userLogList) {
        if (userLogList == null) {
            return null;
        }
        List<UserLogVo> userLogVoList = Lists.newArrayList();
        for(UserLog  userLog : userLogList){
        	userLogVoList.add(toUserLogVo(userLog));
        }
        return userLogVoList;
    }
}
