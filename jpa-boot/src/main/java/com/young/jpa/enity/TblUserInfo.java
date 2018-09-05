package com.young.jpa.enity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
@Entity
@Table(name="tbl_user_info")
public class TblUserInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1462546992515949685L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String passWord;
	
	@Column(name="TEL_NUM")
	private String telNum;
	
	private String email;
	
	private Date birthday;
	
	@Column(name="USER_LEVEL")
	private Integer userLevel;
	
	private String address;
	
	@Column(name="CREATE_TIME")
	private Date createTime;
	
	@Column(name="UPDATE_TIME")
	private Date updateTime;
	
	@Column(name="USER_STATU")
	private Character userStatu;
	
	public TblUserInfo() {
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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
