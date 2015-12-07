/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.train;

import java.net.URLEncoder;
import java.sql.Timestamp;

/**
 * 火车时刻表
 */
public class TrainBean implements java.io.Serializable {

	/**
	 * 火车时刻表 表名
	 */
	public static final String TABLE = "T_TRAIN";

	/**
	 * ID 列名
	 */
	public static final String COL_id = "ID";

	/**
	 * 车次 列名
	 */
	public static final String COL_traincode = "C_TRAINCODE";
	
	/**
	 * 锁单人 列名
	 */
	public static final String COL_userid = "C_USERID";
	/**
	 * 锁单时间 列名
	 */
	public static final String COL_suotime = "C_SUOTIME";
	
	
	/**
	 * 车次-单号 列名
	 */
	public static final String COL_ordernumber = "C_ORDERNUMBER";
	
	/**
	 * 车次-支付状态 列名
	 */
	public static final String COL_paystatus = "C_PAYSTATUS";
	
	/**
	 * 车次-订单状态 列名
	 */
	public static final String COL_orderstatus = "C_ORDERSTATUS";

	/**
	 * 车型
	 */
	public static final String COL_traintype = "C_TRAINTYPE";

	/**
	 * 出发站 列名
	 */
	public static final String COL_STARTCITY = "C_STARTCITY";

	/**
	 * 到达站 列名
	 */
	public static final String COL_endcity = "C_ENDCITY";

	/**
	 * 开车时间 列名
	 */
	public static final String COL_starttime = "C_STARTTIME";

	/**
	 * 到达时间 列名
	 */
	public static final String COL_endtime = "C_ENDTIME";

	/**
	 * 用时 列名
	 */
	public static final String COL_costtime = "C_COSTTIME";

	/**
	 * 里程 列名
	 */
	public static final String COL_distance = "C_DISTANCE";

	/**
	 * 硬座价格 列名
	 */
	public static final String COL_yzprice = "C_YZPRICE";

	/**
	 * 软座价格 列名
	 */
	public static final String COL_rzprice = "C_RZPRICE";

	/**
	 * 硬卧上价格 列名
	 */
	public static final String COL_ywsprice = "C_YWSPRICE";

	/**
	 * 硬卧中价格 列名
	 */
	public static final String COL_ywzprice = "C_YWZPRICE";

	/**
	 * 硬卧下价格 列名
	 */
	public static final String COL_ywxprice = "C_YWXPRICE";

	/**
	 * 软卧上价格 列名
	 */
	public static final String COL_rwsprice = "C_RWSPRICE";

	/**
	 * 软卧下价格 列名
	 */
	public static final String COL_rwxprice = "C_RWXPRICE";

	/**
	 * 高级软卧上
	 */
	public static final String COL_gwsprice = "C_GWSPRICE";

	/**
	 * 高级软卧下
	 */
	public static final String COL_gwxprice = "C_GWXPRICE";

	/**
	 * 创建者 列名
	 */
	public static final String COL_createuid = "C_CREATEUID";

	/**
	 * 创建时间 列名
	 */
	public static final String COL_createtime = "C_CREATETIME";

	/**
	 * 硬座余票
	 */
	public static final String COL_yzyp = "C_YZYP";

	private String yzyp;
	/**
	 * 软座余票
	 */
	public static final String COL_rzyp = "C_RZYP";

	private String rzyp;
	/**
	 * 二等软座余票
	 */
	public static final String COL_rz2yp = "C_RZ2YP";

	private String rz2yp;
	/**
	 * 一等软座余票
	 */
	public static final String COL_rz1yp = "C_RZ1YP";

	private String rz1yp;
	
	/**
	 * 特等座余票
	 */
	public static final String COL_tdzyp = "C_TDZYP";

	private String tdzyp;
	
	/**
	 * 商务座余票
	 */
	public static final String COL_swzyp = "C_SWZYP";

	private String swzyp;

	/**
	 * 硬卧余票
	 */
	public static final String COL_ywyp = "C_YWYP";
	
	/**
	 * 取票类型
	 */
	public static final String COL_qptype = "C_QPTYPE";
	
	/**
	 * 配送费
	 */
	public static final String COL_psprice = "C_PSPRICE";
	
	/**
	 * 购买类型
	 */
	public static final String COL_booktype = "C_BOOKTYPE";

	private String ywyp;
	/**
	 * 软卧余票
	 */
	public static final String COL_rwyp = "C_RWYP";

	private String rwyp;

	/**
	 * 高级软卧余票
	 */
	public static final String COL_gwyp = "C_GWYP";

	private String gwyp;

	/**
	 * 站票余票
	 */
	public static final String COL_wzyp = "C_WZYP";
	
	
	
	/**
	 * 快递单位 列名
	 */
	public static final String COL_kdcomname = "C_KDCOMNAME";
	
	
	/**
	 * 快递单号 列名
	 */
	public static final String COL_kdcode = "C_KDCODE";
	
	/**
	 * 快递备注 列名
	 */
	public static final String COL_kddesc = "C_KDDESC";
	
	
	/**
	 * 出票座位 列名
	 */
	public static final String COL_cpxx = "C_CPXX";
	
	 //出票座位
	private String cpxx;
	
	 //快递备注
	private String kddesc;
	
	 //快递单号
	private String kdcode;
	
	 //快递单位
	private String kdcomname;
	
	
    //站票余票
	private String wzyp;
	
	//出发日期
	private String startdate;

	// ID
	private long id;

	// 车次
	private String traincode;
	
	

	private String traintype;

	// 出发站
	private String startcity;

	// 到达站
	private String endcity;

	// 开车时间
	private String starttime;

	// 到达时间
	private String endtime;

	// 用时
	private String costtime;

	// 里程
	private float distance;

	// 硬座价格
	private Float yzprice;

	private Float rz2price;

	private Float rz1price;
	
	private Float tdzprice;//特等座价格
	
	private Float swzprice;//商务座价格

	// 软座价格
	private Float rzprice;

	// 硬卧上价格
	private Float ywsprice;

	// 硬卧中价格
	private Float ywzprice;

	// 硬卧下价格
	private Float ywxprice;

	// 软卧上价格
	private Float rwsprice;

	// 软卧下价格
	private Float rwxprice;
	//高级 软卧上价格
	private Float gwsprice;
	
	// 高级软卧下价格
	private Float gwxprice;

	// 创建者
	private long createuid;

	// 创建时间
	private Timestamp createtime;
	
	//首发站
	private String sfz;
	
	//配送费
	private int psprice;
	
	//取票类型
	private int qptype;
	
	//购买类型 0无票购买  1有票购买
	private int booktype;
	
	//终点站
	private String zdz;
	//采购商
	private long agentid;
	private String agentname;
	//联系人
	private String contactname;
	//联系电话
	private String contactmobile;
	//订单号
	private String ordernumber;
	//数量
	private int count;
	//总价
	private float totalprice=-1;
	//坐席类型
	private int seattype;
	//配送地址
	private String deliveryadd;
	//配送类型
	private int deliverytype;
	private String deliverytypeval;
	
	private int paymethod;
	
	private int paystatus;//1。未支付 2.支付成功
	
	private String acceptseat;
	
	private String acceptseatval;
	
	private String memo;
	
	private long memberid;//会员id 表示加盟商为某个会员预定
	
	//锁单人
	private String userid;
	
	//锁单时间
	private Timestamp suotime;
	
	//邮编
	private String post;
	
	private int orderstatus;
	
	private String orderstatusval;
	
	private String paystatusval;
	
	private String seattypeval;

	public String getPaystatusval() {
		return paystatusval;
	}

	public void setPaystatusval(String paystatusval) {
		this.paystatusval = paystatusval;
	}

	public String getSeattypeval() {
		return seattypeval;
	}

	public void setSeattypeval(String seattypeval) {
		this.seattypeval = seattypeval;
	}

	public String getSfz() {
		return sfz;
	}

	public void setSfz(String sfz) {
		this.sfz = sfz;
	}

	public String getZdz() {
		return zdz;
	}

	public void setZdz(String zdz) {
		this.zdz = zdz;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTraincode() {
		return traincode;
	}

	public void setTraincode(String traincode) {
		this.traincode = traincode;
	}

	public String getStartcity() {
		return startcity;
	}

	public void setStartcity(String startcity) {
		this.startcity = startcity;
	}

	public String getEndcity() {
		return endcity;
	}

	public void setEndcity(String endcity) {
		this.endcity = endcity;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getCosttime() {
		return costtime;
	}

	public void setCosttime(String costtime) {
		this.costtime = costtime;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public Float getYzprice() {
		return yzprice;
	}

	public void setYzprice(Float yzprice) {
		this.yzprice = yzprice;
	}

	public Float getRzprice() {
		return rzprice;
	}

	public void setRzprice(Float rzprice) {
		this.rzprice = rzprice;
	}

	public Float getYwsprice() {
		return ywsprice;
	}

	public void setYwsprice(Float ywsprice) {
		this.ywsprice = ywsprice;
	}

	public Float getYwzprice() {
		return ywzprice;
	}

	public void setYwzprice(Float ywzprice) {
		this.ywzprice = ywzprice;
	}

	public Float getYwxprice() {
		return ywxprice;
	}

	public void setYwxprice(Float ywxprice) {
		this.ywxprice = ywxprice;
	}

	public Float getRwsprice() {
		return rwsprice;
	}

	public void setRwsprice(Float rwsprice) {
		this.rwsprice = rwsprice;
	}

	public Float getRwxprice() {
		return rwxprice;
	}

	public void setRwxprice(Float rwxprice) {
		this.rwxprice = rwxprice;
	}

	public long getCreateuid() {
		return createuid;
	}

	public void setCreateuid(long createuid) {
		this.createuid = createuid;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getYzyp() {
		return yzyp;
	}

	public void setYzyp(String yzyp) {
		this.yzyp = yzyp;
	}

	public String getRzyp() {
		return rzyp;
	}

	public void setRzyp(String rzyp) {
		this.rzyp = rzyp;
	}

	public String getRz2yp() {
		return rz2yp;
	}

	public void setRz2yp(String rz2yp) {
		this.rz2yp = rz2yp;
	}

	public String getRz1yp() {
		return rz1yp;
	}

	public void setRz1yp(String rz1yp) {
		this.rz1yp = rz1yp;
	}

	public String getYwyp() {
		return ywyp;
	}

	public void setYwyp(String ywyp) {
		this.ywyp = ywyp;
	}

	public String getRwyp() {
		return rwyp;
	}

	public void setRwyp(String rwyp) {
		this.rwyp = rwyp;
	}

	public String getGwyp() {
		return gwyp;
	}

	public void setGwyp(String gwyp) {
		this.gwyp = gwyp;
	}

	public String getWzyp() {
		return wzyp;
	}

	public void setWzyp(String wzyp) {
		this.wzyp = wzyp;
	}

	public String getTraintype() {
		return traintype;
	}

	public void setTraintype(String traintype) {
		this.traintype = traintype;
	}

	public Float getRz2price() {
		return rz2price;
	}

	public void setRz2price(Float rz2price) {
		this.rz2price = rz2price;
	}

	public Float getRz1price() {
		return rz1price;
	}

	public void setRz1price(Float rz1price) {
		this.rz1price = rz1price;
	}

	public Float getGwsprice() {
		return gwsprice;
	}

	public void setGwsprice(Float gwsprice) {
		this.gwsprice = gwsprice;
	}

	public Float getGwxprice() {
		return gwxprice;
	}

	public void setGwxprice(Float gwxprice) {
		this.gwxprice = gwxprice;
	}
	
	private String json;
	
	private String urlparameter;
	
	public void setJson(String json){
		this.json=json;
	}
	
	public String getJson(){
		System.out.println("Train:json:");
		StringBuilder json=new StringBuilder("");
		json.append("{'traincode':'"+getTraincode()+ "','starttime':'"+this.getStarttime()+"',");
		json.append("'endtime':'"+this.getEndtime()+ "','startcity':'"+this.getStartcity()+"',");
		json.append("'endcity':'"+this.getEndcity()+ "','traintype':'"+this.getTraintype()+"'");
		json.append("'booktype':'"+this.getBooktype()+ "','qptype':'"+this.getQptype()+"'");
		json.append("'userid':'"+this.getUserid()+ "','suotime':'"+this.getSuotime()+"'");
		json.append("'psprice':'"+this.getPsprice()+"'");
		try{
			if(this.wzyp.equals("有")){
				json.append(",'wzyp':'"+this.wzyp+"'");
			}
		}catch(Exception e){
			
		}
		try{
			int yp=Integer.valueOf(this.yzyp);
			if(yp>0){
				json.append(",'yzyp':"+this.yzyp+",'yzprice':"+this.getYzprice());
			}
		}catch(Exception e){
			
		}
		try{
			int yp=Integer.valueOf(this.ywyp);
			if(yp>0){
				json.append(",'ywyp':"+this.ywyp+",'ywsprice':"+this.getYwsprice());
				json.append(",'ywzprice':"+this.getYwzprice()+",'ywxprice':"+this.getYwxprice());
			}
		}catch(Exception e){
			
		}
		try{
			int yp=Integer.valueOf(this.rwyp);
			if(yp>0){
				json.append(",'rwyp':"+this.rwyp+",'rwsprice':"+this.getRwsprice());
				json.append(",'rwxprice':"+this.getRwxprice());
			}
		}catch(Exception e){
			
		}
		try{
			int yp=Integer.valueOf(this.rzyp);
			if(yp>0){
				json.append(",'rzyp':"+this.rzyp+",'rzprice':"+this.getRzprice());
			}
		}catch(Exception e){
			
		}
		try{
			int yp=Integer.valueOf(this.rz2yp);
			if(yp>0){
				json.append(",'rz2yp':"+this.rz2yp+",'rz2price':"+this.getRz2price());
			}
		}catch(Exception e){
			
		}
		
		
		try{
			int yp=Integer.valueOf(this.rz1yp);
			if(yp>0){
				json.append(",'rz1yp':"+this.rz1yp+",'rz1price':"+this.getRz1price());
			}
		}catch(Exception e){
			
		}
		try{
			int yp=Integer.valueOf(this.tdzyp);
			if(yp>0){
				json.append(",'tdzyp':"+this.tdzyp+",'tdzprice':"+this.getTdzprice());
			}
		}catch(Exception e){
			
		}
		try{
			int yp=Integer.valueOf(this.swzyp);
			if(yp>0){
				json.append(",'swzyp':"+this.swzyp+",'swzprice':"+this.getSwzprice());
			}
		}catch(Exception e){
			
		}
		
		try{
			int yp=Integer.valueOf(this.gwyp);
			if(yp>0){
				json.append(",'gwyp':"+this.gwyp+",'gwsprice':"+this.getGwsprice()+",'gwxprice':"+this.getGwxprice());
			}
		}catch(Exception e){
			
		}		
		json.append("}");
		
		return json.toString();
		
	}
	
	

	public String getUrlparameter() {
//		System.out.println("Train:json:");
//		StringBuilder json=new StringBuilder("");
//	try{
//		json.append("traincode="+URLEncoder.encode(getTraincode(),"utf-8")+ "&starttime="+this.getStarttime()+"&");
//		json.append("endtime="+this.getEndtime()+ "&startcity="+URLEncoder.encode(this.getStartcity(),"utf-8")+"&");
//		json.append("endcity="+this.getEndcity()+ "&traintype="+this.getTraintype()+"&");
//		json.append("yzprice="+this.getYzprice() + "&ywsprice="+this.getYwsprice()+"&");
//		json.append("ywzprice="+this.getYwzprice()+"&ywxprice="+this.getYwxprice()+"&");
//		json.append("rwsprice="+this.getRwsprice()+"&rwxprice="+this.getRwxprice()+"&");
//		json.append("rz1price="+this.getRz1price()+"&rz2price="+this.getRz2price()+"&");
//		json.append("gwsprice="+this.getGwsprice()+"&gwxprice="+this.getGwxprice()+"");
//	}catch(Exception e){
//		
//	}
//		return json.toString();
		return "";
	}

	public void setUrlparameter(String urlparameter) {
		this.urlparameter = urlparameter;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public long getAgentid() {
		return agentid;
	}

	public void setAgentid(long agentid) {
		this.agentid = agentid;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public String getContactmobile() {
		return contactmobile;
	}

	public void setContactmobile(String contactmobile) {
		this.contactmobile = contactmobile;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}


	public int getDeliverytype() {
		return deliverytype;
	}

	public void setDeliverytype(int deliverytype) {
		this.deliverytype = deliverytype;
	}

	public int getSeattype() {
		return seattype;
	}

	public void setSeattype(int seattype) {
		this.seattype = seattype;
	}

	public String getDeliveryadd() {
		return deliveryadd;
	}

	public void setDeliveryadd(String deliveryadd) {
		this.deliveryadd = deliveryadd;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}

	public int getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(int paymethod) {
		this.paymethod = paymethod;
	}

	public int getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(int paystatus) {
		this.paystatus = paystatus;
	}

	public String getAcceptseat() {
		return acceptseat;
	}

	public void setAcceptseat(String acceptseat) {
		this.acceptseat = acceptseat;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public long getMemberid() {
		return memberid;
	}

	public void setMemberid(long memberid) {
		this.memberid = memberid;
	}

	public String getOrderstatusval() {
		return orderstatusval;
	}

	public void setOrderstatusval(String orderstatusval) {
		this.orderstatusval = orderstatusval;
	}

	public String getAcceptseatval() {
		return acceptseatval;
	}

	public void setAcceptseatval(String acceptseatval) {
		this.acceptseatval = acceptseatval;
	}

	public String getDeliverytypeval() {
		return deliverytypeval;
	}

	public void setDeliverytypeval(String deliverytypeval) {
		this.deliverytypeval = deliverytypeval;
	}

	public String getAgentname() {
		return agentname;
	}

	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}

	public String getTdzyp() {
		return tdzyp;
	}

	public void setTdzyp(String tdzyp) {
		this.tdzyp = tdzyp;
	}

	public String getSwzyp() {
		return swzyp;
	}

	public void setSwzyp(String swzyp) {
		this.swzyp = swzyp;
	}

	public Float getTdzprice() {
		return tdzprice;
	}

	public void setTdzprice(Float tdzprice) {
		this.tdzprice = tdzprice;
	}

	public Float getSwzprice() {
		return swzprice;
	}

	public void setSwzprice(Float swzprice) {
		this.swzprice = swzprice;
	}

	public int getPsprice() {
		return psprice;
	}

	public void setPsprice(int psprice) {
		this.psprice = psprice;
	}

	public int getQptype() {
		return qptype;
	}

	public void setQptype(int qptype) {
		this.qptype = qptype;
	}

	public int getBooktype() {
		return booktype;
	}

	public void setBooktype(int booktype) {
		this.booktype = booktype;
	}


	public Timestamp getSuotime() {
		return suotime;
	}

	public void setSuotime(Timestamp suotime) {
		this.suotime = suotime;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getKddesc() {
		return kddesc;
	}

	public void setKddesc(String kddesc) {
		this.kddesc = kddesc;
	}

	public String getKdcode() {
		return kdcode;
	}

	public void setKdcode(String kdcode) {
		this.kdcode = kdcode;
	}

	public String getKdcomname() {
		return kdcomname;
	}

	public void setKdcomname(String kdcomname) {
		this.kdcomname = kdcomname;
	}

	public String getCpxx() {
		return cpxx;
	}

	public void setCpxx(String cpxx) {
		this.cpxx = cpxx;
	}

	

}
