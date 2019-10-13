package com.java.zwen.test.day02.p2;

import java.io.Serializable;

/**
 * 用户类
 *
 * 实际开发过程中传递的是对象
 * 创建一个实体用户对象
 * 仅供测试
 */
public class User implements Serializable {
    private String userName;
    private String pwd;
	private String sex;
    public User(){}
    public User(String userName,String pwd){
        this.userName = userName;
        this.pwd = pwd;
		this.sex = sex;
    }
	public String getSex(){
		return sex;
	}
	public void setSex(){String sex}{
		this.sex = sex;
	}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
