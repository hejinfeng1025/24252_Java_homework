package com.huawei.classroom.student.h08;

public class LoginUtil {
	private static final String VALID_USERNAME = "a";
    private static final String VALID_PASSWD = "a";
    public LoginUtil() {

    }
    public void login(String username,String passwd) throws Exception{
    	if(username!=VALID_USERNAME||passwd!=VALID_PASSWD) 
    		throw new InvalidUserException("用户名或密码错误");
    }
    
    
    
}
