package com.Graduate.Po;


public class Shengciben {

	private int shengcibenid;
	private int userid;
	private String shengcibenname;
	public Shengciben() {
		super();
	}
	public Shengciben(int shengcibenid, int userid, String shengcibenname) {
		super();
		this.shengcibenid = shengcibenid;
		this.userid = userid;
		this.shengcibenname = shengcibenname;
	}
	public int getShengcibenid() {
		return shengcibenid;
	}
	public void setShengcibenid(int shengcibenid) {
		this.shengcibenid = shengcibenid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getShengcibenname() {
		return shengcibenname;
	}
	public void setShengcibenname(String shengcibenname) {
		this.shengcibenname = shengcibenname;
	}
	
}
