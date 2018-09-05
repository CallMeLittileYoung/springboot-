package com.young.shutdown.entity;


import java.io.Serializable;
import java.util.Date;
	/**
	 * 
	 * @author        Young
	 * @description   
	 * @date          2018年8月14日 下午5:09:06 
	 *
	 */
public class TblUserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1462546992515949685L;
	private Integer id;
	private String userName;
	private String passWord;
	private String telNum;
	private String email;
	private Date birthday;
	private Integer userLevel;
	private String address;
	private Date createTime;
	private Date updateTime;
	private Character userStatu;
	
	public TblUserInfo() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Character getUserStatu() {
		return userStatu;
	}

	public void setUserStatu(Character userStatu) {
		this.userStatu = userStatu;
	}
	@Override
	public String toString() {
		return "TblUserInfo [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", telNum=" + telNum
				+ ", email=" + email + ", birthday=" + birthday + ", userLevel=" + userLevel + ", address=" + address
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", userStatu=" + userStatu + "]";
	}
	
}
