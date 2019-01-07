package org.totoshop.pojo;

import java.util.Date;

public class User {
	private String uId;
	
	private String uName;
	
	private String uPassword;
	
	private String uPhone;
	
	private String uAddress;
	
	private String uSex;
	
	private Date uCreateTime;
	
	private Date uEditTime;
	
	public User() {}

	public User(String uId, String uName, String uPassword, String uPhone, String uAddress, String uSex, Date uCreateTime, Date uEditTime) {
		this.uId = uId;
		this.uName = uName;
		this.uPassword = uPassword;
		this.uPhone = uPhone;
		this.uAddress = uAddress;
		this.uSex = uSex;
		this.uCreateTime = uCreateTime;
		this.uEditTime = uEditTime;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public String getuSex() {
		return uSex;
	}

	public void setuSex(String uSex) {
		this.uSex = uSex;
	}

	public Date getuCreateTime() {
		return uCreateTime;
	}

	public void setuCreateTime(Date uCreateTime) {
		this.uCreateTime = uCreateTime;
	}

	public Date getuEditTime() {
		return uEditTime;
	}

	public void setuEditTime(Date uEditTime) {
		this.uEditTime = uEditTime;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uPassword=" + uPassword + ", uPhone=" + uPhone
				+ ", uAddress=" + uAddress + ", uSex=" + uSex + ", uCreateTime=" + uCreateTime + ", uEditTime="
				+ uEditTime + "]";
	}	
}
