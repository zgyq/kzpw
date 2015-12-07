package com.yf.b2b2g.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;



/**
*
* 开发人：hanmenghui
* 开发日期：2012-02-01
* 功能说明：企业信息
*
*/
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	/**单位代码*/
	private String comcode;
	
	/**单位全称*/
	private String cnamecn;
	
	/**中文简称*/
	private String simnamecn;
	
	
	/**英文简称*/
	private String simnameen;
	
	
	/**所属行业*/
	private String calling;
	
	
	/**公司规模*/
	private String number;
	
	/**公司电话*/
	private String comtel;
	
	/**公司传真*/
	private String comfax;
	
	/**公司地址*/
	private String comaddr;
	
	/**所属地域*/
	private String area;
	
	/**公司邮编*/
	private String postid;
	
	/**联系人*/
	private String contactname;
	
	/**联系人电话*/
	private String contacttel;
	
	
	
	/**
	 * 签约信息
	 * 
	 */	
	/**签约人*/
	private String ispactpersonname;
	
	
	/**签约人联系方式*/
	private String ispactpersontel;
	
	
	/**签约时间*/
	private Timestamp ispacttime;
	
	
	/**合同有效期*/
	private Timestamp ispactvalidbgtime;
	
	private Timestamp ispactvalidendtime;
	
	//------------------------------
	
	private int paywayment=-1;
	
	private String paywaymentstr;
	
	
	/**最低票价状态：0:关闭，1：启用*/
	private int showlowfare=-1;
	
	/**最低票价时间。单位：小时*/
	private int lowfaretime;
	
	/**是否审批。0：否。1：是*/
	private int isapprove=-1;
	
	/**是否审批文字形式*/
	private String approve;
	
	
	/**是否发送否决短信。0：否。1：是*/
	private int isvetomessage=-1;
	
	/**是否发送否决短信。文字形式*/
	private String vetomessage;
	
	
	
	private List<Delivery> deliverylist;

	public String getCnamecn() {
		return cnamecn;
	}


	public void setCnamecn(String cnamecn) {
		this.cnamecn = cnamecn;
	}


	public String getSimnamecn() {
		return simnamecn;
	}


	public void setSimnamecn(String simnamecn) {
		this.simnamecn = simnamecn;
	}


	public String getSimnameen() {
		return simnameen;
	}


	public void setSimnameen(String simnameen) {
		this.simnameen = simnameen;
	}


	public String getCalling() {
		return calling;
	}


	public void setCalling(String calling) {
		this.calling = calling;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getComtel() {
		return comtel;
	}


	public void setComtel(String comtel) {
		this.comtel = comtel;
	}


	public String getComfax() {
		return comfax;
	}


	public void setComfax(String comfax) {
		this.comfax = comfax;
	}


	public String getComaddr() {
		return comaddr;
	}


	public void setComaddr(String comaddr) {
		this.comaddr = comaddr;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getPostid() {
		return postid;
	}


	public void setPostid(String postid) {
		this.postid = postid;
	}


	public String getContactname() {
		return contactname;
	}


	public void setContactname(String contactname) {
		this.contactname = contactname;
	}


	public String getIspactpersonname() {
		return ispactpersonname;
	}


	public void setIspactpersonname(String ispactpersonname) {
		this.ispactpersonname = ispactpersonname;
	}


	public String getIspactpersontel() {
		return ispactpersontel;
	}


	public void setIspactpersontel(String ispactpersontel) {
		this.ispactpersontel = ispactpersontel;
	}


	public Timestamp getIspacttime() {
		return ispacttime;
	}


	public void setIspacttime(Timestamp ispacttime) {
		this.ispacttime = ispacttime;
	}


	public Timestamp getIspactvalidbgtime() {
		return ispactvalidbgtime;
	}


	public void setIspactvalidbgtime(Timestamp ispactvalidbgtime) {
		this.ispactvalidbgtime = ispactvalidbgtime;
	}


	public Timestamp getIspactvalidendtime() {
		return ispactvalidendtime;
	}


	public void setIspactvalidendtime(Timestamp ispactvalidendtime) {
		this.ispactvalidendtime = ispactvalidendtime;
	}


	


	public int getShowlowfare() {
		return showlowfare;
	}


	public void setShowlowfare(int showlowfare) {
		this.showlowfare = showlowfare;
	}


	public int getLowfaretime() {
		return lowfaretime;
	}


	public void setLowfaretime(int lowfaretime) {
		this.lowfaretime = lowfaretime;
	}


	public int getIsapprove() {
		return isapprove;
	}


	public void setIsapprove(int isapprove) {
		this.isapprove = isapprove;
	}


	public int getIsvetomessage() {
		return isvetomessage;
	}


	public void setIsvetomessage(int isvetomessage) {
		this.isvetomessage = isvetomessage;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getApprove() {
		if(this.isapprove==1){
			return "是";
		}
		return "否";
	}


	public String getVetomessage() {
		if(this.isvetomessage==1){
			return "是";
		}
		return "否";
	}



	public String getPaywaymentstr() {
		switch(this.paywayment){
		case 1:return"现金";
		case 2:return"月结";
		case 3:return"预付款";
		default:return"";
		}
	}


	public int getPaywayment() {
		return paywayment;
	}


	public void setPaywayment(int paywayment) {
		System.out.println("*******setPaywayment()******");
		this.paywayment = paywayment;
	}


	public String getContacttel() {
		return contacttel;
	}


	public void setContacttel(String contacttel) {
		this.contacttel = contacttel;
	}


	public String getComcode() {
		return comcode;
	}


	public void setComcode(String comcode) {
		this.comcode = comcode;
	}


	public List<Delivery> getDeliverylist() {
		return deliverylist;
	}


	public void setDeliverylist(List<Delivery> deliverylist) {
		this.deliverylist = deliverylist;
	}





	
	
	
	
	
	
	
	
	
	
}
