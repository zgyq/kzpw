package com.yf.b2b2g.bean;

import java.io.Serializable;

/**
*
* 开发人：hanmenghui
* 开发日期：2012-02-01
* 功能说明：配送信息
*
*/
public class Delivery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**企业ID */
	private long comid;
	
	/**签收人 */
	private String receivename;
	
	/**联系电话 */
	private String receivetel;

	/**配送时间 */
	private String delitime;
	
	/**配送地址 */
	private String deliaddr;
	
	/**配送邮编 */
	private String delipost;

	public long getComid() {
		return comid;
	}

	public void setComid(long comid) {
		this.comid = comid;
	}

	public String getReceivename() {
		return receivename;
	}

	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}

	public String getReceivetel() {
		return receivetel;
	}

	public void setReceivetel(String receivetel) {
		this.receivetel = receivetel;
	}

	public String getDelitime() {
		return delitime;
	}

	public void setDelitime(String delitime) {
		this.delitime = delitime;
	}

	

	public String getDelipost() {
		return delipost;
	}

	public void setDelipost(String delipost) {
		this.delipost = delipost;
	}

	public String getDeliaddr() {
		return deliaddr;
	}

	public void setDeliaddr(String deliaddr) {
		this.deliaddr = deliaddr;
	}
	
	
	
	
	
	

}
