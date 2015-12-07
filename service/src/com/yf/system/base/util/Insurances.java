package com.yf.system.base.util;

import java.io.Serializable;

public class Insurances implements Serializable{
	private int flag;//成功失败的标示
	private String message;//交易信息
	private String transrno;//交易流水号
	private String partnerid;//代理公司编号
	private String applicationNo;//投保号
	private String policycode;//保单号
	private String insurantname;//被保人姓名
	private String cardcode;//证件号
	private int status;//交易状态
	private String showmessage;//交易信息
    public Insurances(){}
    public Insurances(int flag,String message,String transrno,String partnerid,String applicationNo,String policycode,String insurantname,String cardcode,int status,String showmessage){
    	this.flag=flag;
    	this.message=message;
    	this.transrno=transrno;
    	this.partnerid=partnerid;
    	this.applicationNo=applicationNo;
    	this.policycode=policycode;
    	this.insurantname=insurantname;
    	this.cardcode=cardcode;
    	this.status=status;
    	this.showmessage=showmessage;
    }
    public Insurances(int flag,String message,String transrno,String partnerid,String insurantname,String cardcode,int status,String showmessage){
    	this.flag=flag;
    	this.message=message;
    	this.transrno=transrno;
    	this.partnerid=partnerid;
    	this.insurantname=insurantname;
    	this.cardcode=cardcode;
    	this.status=status;
    	this.showmessage=showmessage;
    }
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTransrno() {
		return transrno;
	}
	public void setTransrno(String transrno) {
		this.transrno = transrno;
	}
	public String getPartnerid() {
		return partnerid;
	}
	public void setPartnerid(String partnerid) {
		this.partnerid = partnerid;
	}
	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
	public String getPolicycode() {
		return policycode;
	}
	public void setPolicycode(String policycode) {
		this.policycode = policycode;
	}
	public String getInsurantname() {
		return insurantname;
	}
	public void setInsurantname(String insurantname) {
		this.insurantname = insurantname;
	}
	public String getCardcode() {
		return cardcode;
	}
	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getShowmessage() {
		return showmessage;
	}
	public void setShowmessage(String showmessage) {
		this.showmessage = showmessage;
	}
	

}
