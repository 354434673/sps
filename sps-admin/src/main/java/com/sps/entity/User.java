package com.sps.entity;

public class User {
	/*
	 * 主键,采用自增
	 */
    private Integer id;
    /*
     * 用户名
     */
    private String userName;
    /*
     * 密码
     */
    private String password;
    /*
     * 电话
     */
    private String phone;
    /*
     * 邮箱
     */
    private String email;
    /*
     * 年龄
     */
    private Integer age;
    /*
     * 盐
     */
    private String salt;
    /*
     * 创建时间
     */
    private String creatTime;
    /*
     * 更改时间
     */
    private String updateTime;
    /*
     * 状态
     */
    private Integer state;
    /*
     * 标示
     */
    private Integer mark;
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String userName, String password, String phone, String email, Integer age, String salt,
			String creatTime, String updateTime, Integer state, Integer mark) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.salt = salt;
		this.creatTime = creatTime;
		this.updateTime = updateTime;
		this.state = state;
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", phone=" + phone + ", email="
				+ email + ", age=" + age + ", salt=" + salt + ", creatTime=" + creatTime + ", updateTime=" + updateTime
				+ ", state=" + state + ", mark=" + mark + "]";
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
    
    
    
}