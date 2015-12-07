/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yf.service.ZrateServer;
import com.yf.system.back.server.Server;
import com.yf.system.back.servlet.WriteLog;
import com.yf.system.base.airbaseprice.Airbaseprice;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.cabin.Cabin;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.creditcard.Creditcard;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customercredit.Customercredit;
import com.yf.system.base.customerpassenger.Customerpassenger;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.department.Department;
import com.yf.system.base.gerenguazhanfrec.Gerenguazhanfrec;
import com.yf.system.base.insuranceinfo.Insuranceinfo;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.orderinforc.Orderinforc;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.qmessage.Qmessage;
import com.yf.system.base.scang.Scang;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.ticketnumber.Ticketnumber;
import com.yf.system.base.tickettype.Tickettype;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.ymsend.Ymsend;
import com.yf.system.base.zrate.Zrate;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;

public class OrderinfoAction extends B2b2cbackAction {
	private static final long serialVersionUID = 8908166182297986543L;
	private List<Orderinfo> listOrderinfo = new ArrayList<Orderinfo>();
	List<Passenger> passengerlist;
	private Insuranceinfo insuranceinfo;
	private Orderinfo orderinfo = new Orderinfo();
	private Orderinforc orderinforc = new Orderinforc();
	private List<Zrate> ListZrate1=new ArrayList<Zrate>();
	private List<Zrate> ListZrate2=new ArrayList<Zrate>();
	private List<Zrate> listzrate = new ArrayList<Zrate>();
	private Zrate newzrate= new Zrate();
	private Scang scang = new Scang();
	private Orderinfo orderinfo2 = new Orderinfo();
	private String strReturn = "";
	private String strticketnumber;
	private String s_printtime;
	private String s_orderid;
	private String importtype;
	private int isinter;
	private String strratePrice;
	private String strZrateHtml = "";
	private String s_tuifeireason;
	private int isfeiyou = 0;
	private int istianxuntong = 0;
	private String feiyouarr = "";
	private String tianxuntongarr = "";
	private int isshow=0;
	private List<Aircompany> listAricompany = new ArrayList<Aircompany>();
	private List<Passenger> listPassenger = new ArrayList<Passenger>();
	private List<Passenger> listPassenger2 = new ArrayList<Passenger>();
	private List<Segmentinfo> listSegment = new ArrayList<Segmentinfo>();
	private List<Segmentinfo> listSegment2 = new ArrayList<Segmentinfo>();
	private List<Segmentinfo> listseg = new ArrayList<Segmentinfo>();
	private List<Passenger> listpass = new ArrayList<Passenger>();
	private List<Orderinforc> listorderinforc = new ArrayList<Orderinforc>();
	private String s_totalotherfee;
	private String s_totalanjian;
	// 分销商返点
	private float s_zhekoubili = 0;
	// 总返点
	private float s_zongfandian = 0;
	// 票面价
	private Float s_piaomianjia = 0f;
	String BigPNR="";
	// 政策id
	private String s_zrateid;
	private String s_contactmobile;
	private List<Creditcard> creditlist = new ArrayList<Creditcard>();
	private int s_cindex;
	private String s_cvalue;
	private String s_cname;
	private String s_zonglirun = "0";
	private float totalzhekoujine = 0;
	private String z_fromdate;
	private String z_endcity;
	private String z_startcity;
	private int intflag;
	private String strAirCompany;
	private String strAirline;
	private String strCabin;
	private int ywtype = 0;
    private float segmentparvprice=0;
	private List<Customeruser> listemployees;
	private List<Cityairport> listCityairport;
	private List<Scang> listScang;
	private Customeragent listAgent = new Customeragent();
	private Customeragent listGongAgent = new Customeragent();
	private String strPNR;//PNR信息
	private String strPNRTXT;//PNR文本信息
	private String strPATTXT;//Pat文本信息
	private String strLOGINNAME;// 登录帐号
	
	private String PnrTxtPat;//PNR文本
	
	private String strCompanyCode;//企业代码
	
	private long s_agentid;
	
	private long s_userid;
	
	private String strTuikuanDesc;
	private String strNewTicNum;
	private String strNewPnr = "";
	private String strNewBigPnr = "";
	private String s_tuifeitime = "";
	private String strNMString = ""; // 最终解析出来的姓名组，以#分割
	private String strSSRString = "";// 最终解析出来的证件组，以#分割
	private String strFlightString = "";// 最终解析出来的航程组，以#分割
	private String strTicketPrice = "";
	private String strTAXPrice = "";
	private String strYQPrice = "";
	private String strTotalPrice = "";
	private String ticketprice = "";
	private String ticketquanprice = "";
	private String taxprice = "";
	private float totalPrice = 0;
	private String yqprice = "";
	private String idnumber = "";
	private String mobile = "";
	private String s_orderstatuspnr = "";
	private String s_pnrdetails;
	private String strQueryType;
	private String strTuiOrderID;
	private String strNewOrderID;
	private String strSenderID;
	private String strSenderDate;
	private String s_bigpnr;
	private String strPassengers;
	private String tuigaiindex;
	private String passids;
	private int s_money;
	private int isgroup = 0;
	private String strNewTicketNum;
	private String s_memo;
	private int paymethod;
	private int s_insurance;
	private String s_insurancevalues;
	private int typ;
	private String strSepPNR;
	private String strXuNumber;
	private String changeflight;
	private String changedate;
	private String changecabin;
	private String changepnr;
	private long s_busystatus;
	private int s_paymethods;
	private String s_paystatus;
	private int no;// 表示不通过执行
	private String beizhu;// 不通过的备注
	
	private String strTEL;// 电话号码
	
	
	private int s_send;
	private String forwork;
	private long s_employeeid;
	private int etermtype = 0;
	private int s_cashier = -1;// 是否收银
	private String ticketnumberarr;
	private String rpnumberarr;
	private String eiarr;
	private List<Customeruser> listSender;
	private String strfenliType;
	// 批量操作ID数组
	private int[] selectid;
	private String s_ticketnumber;
	private String s_rpnumber;
	private String s_eidesc;
	private String s_Paindex;
	//
	private boolean s_isexchorder;
	private String s_exchordertn;
	// 联系人姓名
	private String s_contactname;
	// 预订人姓名
	private String s_bookername;
	// 出票人姓名
	private String s_chupiaoname;
	// 废票申请人员
	private String s_feipiaoshenqingren;
	// 废票申请时间范围
	private String s_feipiaoshenqingsdate;
	// 废票申请时间范围结束
	private String s_feipiaoshenqingedate;
	//
	private String s_songpaiodanpid;
	// 废票审核时间
	private String s_feipiaoshenhesdate;
	private String s_feipiaoshenheedate;
	// 废票审核人员
	private String s_feipiaoshenheren;
	// 退票申请人员
	private String s_tuipiaoshenqingren;
	// 改签申请时间
	private String s_gaiqianshenqingsdate;
	private String s_gaiqianshenqingedate;
	// 退票审核人员
	private String s_tuipiaoshenheren;
	// 退票审核时间
	private String s_tuipiaoshenhesdate;
	private String s_tuipiaoshenheedate;
	// 改签申请人员
	private String s_gaiqianshenqingren;
	// 改签审核人员
	private String s_gaiqianshenheren;
	// 改签审核时间
	private String s_gaiqianshehesdate;
	private String s_gaiqiansheheedate;
	// 升舱申请人员
	private String s_shengcangshenqingren;
	// 升舱申请时间
	private String s_shengcangshenqingsdate;
	private String s_shengcangshenqingedate;
	// 升舱审核人员
	private String s_shengcangshenheren;
	// 升舱审核时间
	private String s_shengcangshenhesdate;
	private String s_shengcangshenheedate;

	private long temporderuserid;
	private long oid;
	private long scangid;
	private String s_peisongren;
	private String s_peisongsdate;
	private String s_peisongedate;
	private String passid;

	private int repaystate = 0;// 个人挂账还款状态0：未还款，1：已还款
	// 临时ID
	Long idtemp = 0l;
	// 换开用
	private long orderinfoid;
	private long angenid;
	private long userid;
	// '
	private String tui;
	// 批量操作选项
	private int opt;
	// 跳转用
	private int ty;
	private int s_orderstatus = 0;
	private int zhekoubili;
	private String s_zhekoujine;
	private int type;
	private String forward;
	//
	private String h_ptype;
	private String h_name;
	private String h_idtype;
	private String h_idnumber;
	private String strTravelHtml;
	private String strTotalPriceOne;
	private String strTotalPriceTwo;
	private String s_hidflag;
	// 要分离的乘机人id
	private String s_newpassid;
	private String strTNumber = "";
	private String strRPNumber = "";
	private String s_pnr;
	private String s_ordernumber;
	private String s_bengincreatetime;
	private String s_endcreatetime;
	private String s_beginchengji;
	private String s_endchengji;
	private String s_beginprinttime;
	private String s_endprinttime;
	private String s_begincity;
	private String s_endcity;
	private String s_passengername;
	private String s_passengerfet;
	private String s_flightnumber;
	private String u_id;
	private String u_idnumber;
	private String h_insurance;
	private String h_savepasenger;
	private Long s_ordertype;
	private String strExchOldOrder;
	boolean isexchorder = false;
	//
	// 预订的开始时间
	private String h_prestarttime;

	// 预订的结束时间
	private String h_preendtime;

	// pnr
	private String order_pnr;
	private String pnrstr;
	// 订单状态:1.等待支付2.支付成功3.出票完成4.申请废票5.申请退票6.取消订单7.等待审核8.审核失败9.退款成功10.订单关闭

	// 退费状态 当日作废 资源退票 非自愿退票
	private long tui_state;
	// 是否保留座位
	private long tui_iscabinsite;
	private long tui_yuanyi;
	// 退费描述
	private String tui_tuifeidesc;
	// 审核不通过原因
	private String tui_nodesc;

	private String companyname;// 单位名字
	private String s_customeragentid;// 订单所属单位Id

	private List<Tickettype> listtickettype;// 机票类型

	private long s_tickettypeid = 0;// 机票类型
	
	

	
	
	// 平台费
	private float orderPlat = 0f;

	public String getTui_nodesc() {
		return tui_nodesc;
	}

	public void setTui_nodesc(String tui_nodesc) {
		this.tui_nodesc = tui_nodesc;
	}

	public String getPnrstr() {
		return pnrstr;
	}

	public void setPnrstr(String pnrstr) {
		this.pnrstr = pnrstr;
	}

	public String getOrder_pnr() {
		return order_pnr;
	}

	public void setOrder_pnr(String order_pnr) {
		this.order_pnr = order_pnr;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_idnumber() {
		return u_idnumber;
	}

	public void setU_idnumber(String u_idnumber) {
		this.u_idnumber = u_idnumber;
	}

	public String getS_flightnumber() {
		return s_flightnumber;
	}

	public void setS_flightnumber(String s_flightnumber) {
		this.s_flightnumber = s_flightnumber;
	}

	public String getS_passengername() {
		return s_passengername;
	}

	public void setS_passengername(String s_passengername) {
		this.s_passengername = s_passengername;
	}

	public String getS_passengerfet() {
		return s_passengerfet;
	}

	public void setS_passengerfet(String s_passengerfet) {
		this.s_passengerfet = s_passengerfet;
	}

	public String getS_begincity() {
		return s_begincity;
	}

	public void setS_begincity(String s_begincity) {
		this.s_begincity = s_begincity;
	}

	public String getS_endcity() {
		return s_endcity;
	}

	public void setS_endcity(String s_endcity) {
		this.s_endcity = s_endcity;
	}

	public String getS_beginprinttime() {
		return s_beginprinttime;
	}

	public void setS_beginprinttime(String s_beginprinttime) {
		this.s_beginprinttime = s_beginprinttime;
	}

	public String getS_endprinttime() {
		return s_endprinttime;
	}

	public void setS_endprinttime(String s_endprinttime) {
		this.s_endprinttime = s_endprinttime;
	}

	public String getS_beginchengji() {
		return s_beginchengji;
	}

	public void setS_beginchengji(String s_beginchengji) {
		this.s_beginchengji = s_beginchengji;
	}

	public String getS_endchengji() {
		return s_endchengji;
	}

	public void setS_endchengji(String s_endchengji) {
		this.s_endchengji = s_endchengji;
	}

	public String getS_bengincreatetime() {
		return s_bengincreatetime;
	}

	public void setS_bengincreatetime(String s_bengincreatetime) {
		this.s_bengincreatetime = s_bengincreatetime;
	}

	public String getS_endcreatetime() {
		return s_endcreatetime;
	}

	public void setS_endcreatetime(String s_endcreatetime) {
		this.s_endcreatetime = s_endcreatetime;
	}

	public String getS_ordernumber() {
		return s_ordernumber;
	}

	public void setS_ordernumber(String s_ordernumber) {
		this.s_ordernumber = s_ordernumber;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getS_pnr() {
		return s_pnr;
	}

	public void setS_pnr(String s_pnr) {
		this.s_pnr = s_pnr;
	}
   public OrderinfoAction() {
		Sysconfig sysconfig = Server.getInstance().getMemberService()
				.findSysconfig(10022L);
		if (sysconfig != null)
			this.orderPlat = Float.parseFloat(sysconfig.getValue());
	}
   
   
   
   
   
 //PNR 或者票号导入   返回短信信息
	public String imppnrtosms(){
		
		if(beizhu!=null&&!beizhu.equals("")&&strTEL!=null&&!strTEL.equals("")){
			isinter=-1;
			isinter = Server
			.getInstance()
			.getAtomService()
			.sendSms(new String[] { converNull(strTEL, "").trim() }, beizhu.trim(),String.valueOf("-1"), "test");
			if(isinter==1){
				System.out.println("发送成功");
			}else{
				System.out.println("发送失败");
			}
			return "imppnrtosms";
		}
		
		
		
		
		
		String ret="";
		String sms="尊敬的@passenger@客户您好!@flightdate@，@flightvoyage@ @aircompanyname@@flightnumber@航班，@flighttime@@startcity@起飞，客票已出票请核对，祝您旅途愉快!客服电话:021-64967822";
		String flighttime="";
		String flightdate="";
		String passname="";
		
		String shzl="";
		String ehzl="";
		
		Segmentinfo segmentinfo=new Segmentinfo();
		
		
		if(importtype!=null&&importtype.equals("1")){//PNR
			if(strPNR!=null&&strPNR.trim().length()>0){
				ret=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strPNR, "", "");
			}
			
		}
		if(importtype!=null&&importtype.equals("2")){//票号
			if(strPNR!=null&&strPNR.trim().length()>0){
			ret=Server.getInstance().getTicketSearchService().commandFunction2("DETR:TN/"+strPNR, "", "");
			
			System.out.println("ret:"+ret);
			//DETR:TN/784-5280217754,AIR/CZ 
			//ISSUED BY:                           ORG/DST: CGO/SHA                 BSP-D 
			//E/R: 不得签转/变更退票收费  
			//TOUR CODE:   b
			//PASSENGER: 鲍银广   
			//EXCH:                               CONJ TKT:   
			//O FM:1CGO CZ    3597  Y 07JUN 1750 OK YDK85      07JUN4/07JUN4 20K USED/FLOWN        --T2 RL:HDZYN2  /MKCV65CA  
			//TO: SHA    b
			//FC:  b
			//FARE:                      |FOP:
			//TAX:                       |OI: 
			//TOTAL:                     |TKTN: 784-5280217754
			
			//String subString[]=ret.trim().split("\\r\\n");
			
			Pattern patmiles=Pattern.compile("\\n");
			String[] strFDArr=patmiles.split(ret);
			
			for(int a=0;a<strFDArr.length;a++){
				//System.out.println("序号"+a+":"+strFDArr[a]);
				
				if(strFDArr[a]!=null&&strFDArr[a].indexOf("ORG/DST")!=-1){//出发到达
					String chufadaoda=strFDArr[a];
					String citys[]=chufadaoda.split("  ");
					for(int c=0;c<citys.length;c++){
						System.out.println(citys[c]);
						if(citys[c].indexOf(":")!=-1&&citys[c].indexOf("/")!=-1){
							String scity=citys[c].split(":")[1].trim().split("/")[0];
							String ecity=citys[c].split(":")[1].trim().split("/")[1];
							System.out.println("scity:"+scity+",ecity:"+ecity);
							
							if(scity.equals("BJS")||scity.equals("bjs")){
								scity="PEK";
							}
							if(ecity.equals("BJS")||ecity.equals("bjs")){
								ecity="PEK";
							}
							
							segmentinfo.setStartairport(scity);
							segmentinfo.setEndairport(ecity);
						}
					}
					
				}
				if(strFDArr[a]!=null&&strFDArr[a].indexOf("PASSENGER")!=-1){//乘机人姓名
				  passname=strFDArr[a].split(":")[1].trim();
					System.out.println("passname:"+passname);
					
				}
				if(strFDArr[a]!=null&&strFDArr[a].indexOf("FM:")!=-1){//航程信息
					//O FM:1CGO CZ    3597  Y 07JUN 1750 OK YDK85      07JUN4/07JUN4 20K USED/FLOWN        --T2 RL:HDZYN2  /MKCV65CA
					
					System.out.println("航程:"+strFDArr[a]);
					
					String rowString=strFDArr[a];
					
					String rowStrings[]=rowString.split("OK");
					
					String seg=rowStrings[0];
					String segs[]=seg.split(" ");
					List<String> list=new ArrayList<String>();
					for(int v=0;v<segs.length;v++){
						if(segs[v]!=null&&segs[v].trim().length()>0){
							list.add(segs[v].trim());
							System.out.println("segs[v]:"+segs[v].trim());
						}
					}
					String aircode=list.get(2);
					String airno=list.get(3);
					String cabin=list.get(4);
					String sdate=list.get(5);
					String stime=list.get(6);
					
					String day=sdate.substring(0, 2);
					String muy=sdate.substring(2, 5);
					
					flighttime=stime;
					System.out.println(muy+day);
					//ChangeDateModeToInt(dateStr);
					flightdate=ChangeDateModeToInt(muy)+"月"+day;
					segmentinfo.setAircomapnycode(aircode);
					segmentinfo.setFlightnumber(aircode+airno);
					segmentinfo.setCabincode(cabin);
					//segmentinfo.set
					
					
					String hzls=rowStrings[1];
					
					String hzl[]=hzls.split(" ");
					for(int h=0;h<hzl.length;h++){
						if(hzl[h]!=null&&hzl[h].trim().length()>0&&hzl[h].trim().indexOf("--")!=-1){
							
							String hz=hzl[h];
							//shzl
							String hzs[]=hz.split("--");
							if(hzs[0]!=null&&hzs[0].trim().length()>0){
								shzl=hzs[0];
							}
							if(hzs[1]!=null&&hzs[1].trim().length()>0){
								ehzl=hzs[1];
							}
						}
						if(hzl[h]!=null&&hzl[h].trim().length()>0&&(hzl[h].trim().indexOf("T1")!=-1||hzl[h].trim().indexOf("T2")!=-1||hzl[h].trim().indexOf("T3")!=-1)){
							
							String hz=hzl[h];
							//shzl
							
								shzl=hz.substring(0, 2);
							
							
								ehzl=hz.substring(2, hz.length());
							
						}
						
					}
					
					
				}
				
				
				
			}
			
			
			}
		}
		
			System.out.println("shzl:"+shzl+",ehzl:"+ehzl);
		    sms="尊敬的@passenger@客户您好!@flightdate@，@flightvoyage@ @aircompanyname@@flightnumber@航班，@flighttime@@startcity@ @shzl@起飞，客票已出票请核对，祝您旅途愉快!客服电话:021-64967822";
			
		    sms="@flightdate@，@startcity@@shzl@-@endcity@@ehzl@的@flightnumber@航班(@flighttime@起飞)乘客@passenger@，已出票。请提前2小时到达机场办理乘机手续。客服电话021-64967822.";
		    
		    if(importtype!=null&&(importtype.equals("1")||importtype.equals("2"))&&segmentinfo.getStartairport()!=null&&segmentinfo.getEndairport()!=null){
		   
				
		    String scityname=getAirnamebySZM(segmentinfo.getStartairport());
		    String ecityname=getAirnamebySZM(segmentinfo.getEndairport());
		    String flightvoyage=scityname+"-"+ecityname;
		    String aircompanyname=getAircomapnycodeByEZM(segmentinfo.getAircomapnycode());
		    sms=sms.replace("@passenger@", passname);
		    sms=sms.replace("@flightdate@", flightdate);
		    //sms=sms.replace("@flightvoyage@", flightvoyage);
		    //sms=sms.replace("@aircompanyname@", aircompanyname);
		    sms=sms.replace("@flightnumber@", segmentinfo.getFlightnumber());
		    sms=sms.replace("@flighttime@", flighttime.substring(0, 2)+":"+flighttime.substring(2, 4));
			sms=sms.replace("@startcity@", scityname);
			sms=sms.replace("@endcity@", ecityname);
			if(shzl!=null&&shzl.trim().length()>0&&!shzl.trim().equals("--")){
			sms=sms.replace("@shzl@", shzl);
			}else{
				sms=sms.replace("@shzl@", "");	
			}
			if(ehzl!=null&&ehzl.trim().length()>0&&!ehzl.trim().equals("--")){
				sms=sms.replace("@ehzl@", ehzl);
				}else{
					sms=sms.replace("@ehzl@", "");	
			}
			
			System.out.println(sms);
		
			beizhu=sms;
			}
			
		//System.out.println(ret);
		
		
		
		return "imppnrtosms";
	}
	
   
	/**
	 * 转向到PNR匹配后最优政策页面
	 */	
	public String toGetZrateBYPnr()throws Exception{
		Segmentinfo segmentinfo = new Segmentinfo();
		
		String pnrtxt=strPNRTXT;
		String pattxt=strPATTXT;
		
		System.out.println(pnrtxt);
		String pnrtxts[]=pnrtxt.split("\r\n");
		
		System.out.println("总行数:"+pnrtxts.length);
		
		String pnr="";//PNR信息
		String strEndTime="";//到达时间
		String strFlightDate="";//出发时间
		String strFormCity="";//出发城市
		String strToCity="";//到达城市
		String strFlightNumber="";//航班号
		String strFlightInfo = "";
		String strCabin="";
		
		for(int p=0;p<pnrtxts.length;p++){
			
				System.out.println("第"+p+"行:"+pnrtxts[p]);
				String rowString=pnrtxts[p].trim();
				String regbaby = "[0-9]{1,}[\\.][\\s]{1,}[*]{0,1}(([A-Za-z]{1}[0-9]{1})|([A-Za-z]{2})|([0-9]{1}[A-Za-z]{1}))[0-9]{3,4}[\\s]{1,}[A-Za-z]{1}.{1,}([--T1]{0}|[--T2]{0,})";
				Pattern pattbaby = Pattern.compile(regbaby);
				Matcher mchildname = pattbaby.matcher(rowString);
					while (mchildname.find()) {
						
						String subString[]=rowString.trim().split(" ");
						int ca=0;// 舱位下标\
						int timeindex=0;//时间下表
						
						for(int a=0;a<subString.length;a++){
							if(subString[a]!=null&&subString[a].length()>0){
							//System.out.println(subString[a]);
								
							//解析城市对开始
								
							
							String strregCity="[A-Za-z]{6}";
							
							Pattern patcity = Pattern
							.compile(strregCity);
							Matcher mcity = patcity
									.matcher(subString[a]);
							if (mcity.find()) {
								
								System.out.println("citys:"+mcity.group());
							}
					
								
							//解析城市对结束	
								
							//解析航班号
								String strregFnumber = "([A-Za-z]{1}[0-9]{1}|[a-zA-Z]{2}|[0-9]{1}[a-zA-Z]{1})[0-9]{3,4}";
								Pattern patfnumber = Pattern
										.compile(strregFnumber);
								Matcher mfnumber = patfnumber
										.matcher(subString[a]);
								if (mfnumber.find()) {
									strFlightNumber = mfnumber.group();
									System.out.println("strFlightNumber:"+strFlightNumber);
								}
							//解析航班号结束
								
							//解析舱位开始
								if(ca==0){
									String strregCabin="[A-Za-z]";
									Pattern patfnumbercabin = Pattern
									.compile(strregCabin);
									Matcher mfnumbercabin = patfnumbercabin
									.matcher(subString[a]);
									
									if (mfnumbercabin.find()) {
										strCabin = mfnumbercabin.group();
										System.out.println("strCabin:"+strCabin);
										ca++;
									}
								}
							//解析舱位结束
							//解析时间开始
								String strregtime="([0-9]{4}[+][1])|([0-9]{4})";
								Pattern patfnumbertime = Pattern
								.compile(strregtime);
								Matcher mfnumbertime = patfnumbertime
								.matcher(subString[a]);
								
								
								if (mfnumbertime.find()&&subString[a].length()==4) {
									if(timeindex==0){
										String 	stime = mfnumbertime.group();
										System.out.println("stime:"+stime);
									}else{
										String	etime = mfnumbertime.group();
										System.out.println("etime:"+etime);
									}
									
									
									
									timeindex++;
								}
								
								
							//解析时间结束
							
						   //解析日期开始
								
								String strregFlig = "[a-zA-Z]{2}[0-9]{2}[a-zA-Z]{3}[0-9]{2}";
								Pattern patFlig = Pattern
										.compile(strregFlig);
								Matcher mFlig = patFlig
										.matcher(subString[a]);
								if (mFlig.find()) {
									
									System.out.println("date:"+mFlig.group());
									
								}
								
							//解析日期结束
							
								
								
							
							
							}
						}
						
					}
				
				
			
			
			
			
		}
		
		
		
		
		
		
				
			
			
		
		
		
		
		
		//listSegment.add(segmentinfo);
		
		
		
		return "toGetZrateBYPnr";
	}
	
	/**
	 * 列表查询订单信息表
	 */
	public String execute() throws Exception {
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);

		String where = "";
		if (getLoginUser().getAgentid() == 46) {
			where += " where 1=1  and " + Orderinfo.COL_pnr
					+ " is not null and " + Orderinfo.COL_pnr + "<>'NOPNR'";
		} else {
			where += " where 1=1 and " + Orderinfo.COL_buyagentid + " ="
					+ getLoginUser().getAgentid() + " and "
					+ Orderinfo.COL_ordertype + " =2 and " + Orderinfo.COL_pnr
					+ " is not null and " + Orderinfo.COL_pnr + "<>'NOPNR'";

		}
		System.out.println(s_begincity);
		if (s_orderstatus != 0) {
			where += " and " + Orderinfo.COL_orderstatus + "=" + s_orderstatus;
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%'";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		if (s_bengincreatetime != null
				&& s_bengincreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " >= '"
					+ s_bengincreatetime.trim() + " 00:00:00'";
		}
		if (s_endcreatetime != null && s_endcreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " <= '"
					+ s_endcreatetime.trim() + " 23:59:59'";
		}
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}

		// 联系人姓名
		if (s_contactname != null && s_contactname.trim().length() > 0) {
			where += " and " + Orderinfo.COL_contactname + " = "
					+ s_contactname;
		}
		// 预订人姓名
		if (s_bookername != null && s_bookername.trim().length() > 0) {
			where += " and "
					+ Orderinfo.COL_saleagentid
					+ " in (select ID from T_CUSTOMERUSER where C_MEMBERNAME like'%"
					+ s_bookername.trim()
					+ "%' and C_TYPE = 1 and C_AGENTID=46) ";
		}
		// 出票人姓名
		if (s_chupiaoname != null && s_chupiaoname.trim().length() > 0) {
			where += " and "
					+ Orderinfo.COL_saleagentid
					+ " in (select ID from T_CUSTOMERUSER where C_MEMBERNAME like'%"
					+ s_chupiaoname.trim()
					+ "%' and C_TYPE = 1 and C_AGENTID=46) ";
		}
		// 废票申请人员
		if (s_feipiaoshenqingren != null
				&& s_feipiaoshenqingren.trim().length() > 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (select C_ORDERINFOID from T_ORDERINFORC where C_STATE = 5 and C_CUSTOMERUSERID in (select ID from T_CUSTOMERUSER where C_MEMBERNAME like '%"
					+ s_feipiaoshenqingren + "%')) ";
		}
		// 废票申请时间范围
		if (s_feipiaoshenqingsdate != null
				&& s_feipiaoshenqingsdate.trim().length() > 0
				&& s_feipiaoshenqingedate != null
				&& s_feipiaoshenqingedate.trim().length() > 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (select C_ORDERINFOID from T_ORDERINFORC where C_STATE = 5 and C_CREATETIME between '"
					+ s_feipiaoshenqingsdate + " 00:00:00' and '"
					+ s_feipiaoshenqingedate + " 23:59:59') ";
		}
		// 废票审核时间
		if (s_feipiaoshenhesdate != null
				&& s_feipiaoshenhesdate.trim().length() > 0
				&& s_feipiaoshenheedate != null
				&& s_feipiaoshenheedate.trim().length() > 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (select C_ORDERINFOID from T_ORDERINFORC where C_STATE = 11 and C_CREATETIME between '"
					+ s_feipiaoshenhesdate + " 00:00:00' and '"
					+ s_feipiaoshenheedate + " 23:59:59') ";
		}
		// 废票审核人
		if (s_feipiaoshenheren != null
				&& s_feipiaoshenheren.trim().length() > 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (select C_ORDERINFOID from T_ORDERINFORC where C_STATE = 11 and C_CUSTOMERUSERID in (select ID from T_CUSTOMERUSER where C_MEMBERNAME like '%"
					+ s_feipiaoshenheren + "%')) ";
		}

		Customeruser user = this.getLoginUser();
		int agentType = user.getType();
		if (agentType != 1) {
			where += " and (" + Orderinfo.COL_buyagentid + "="
					+ user.getAgentid() + " or " + Orderinfo.COL_saleagentid
					+ "=" + user.getAgentid() + " ) ";
		}

		System.out.println(where);
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}

		return SUCCESS;
	}
	
	

	/**
	 * 列表查询订单信息表
	 */
	public String totuandui() throws Exception {
		type = 9;
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = "";
		if (getLoginUser().getAgentid() == 46) {
			where += " where 1=1  and " + Orderinfo.COL_ordertype + " =4";
		} else {
			where += " where 1=1 and " + Orderinfo.COL_buyagentid + " ="
					+ getLoginUser().getAgentid() + " and "
					+ Orderinfo.COL_ordertype + " =4";

		}
		System.out.println(s_begincity);
		if (s_orderstatus != 0) {
			where += " and " + Orderinfo.COL_orderstatus + "=" + s_orderstatus;
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%'";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		if (s_bengincreatetime != null
				&& s_bengincreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " >= '"
					+ s_bengincreatetime.trim() + " 00:00:00'";
		}
		if (s_endcreatetime != null && s_endcreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " <= '"
					+ s_endcreatetime.trim() + " 23:59:59'";
		}
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}

		Customeruser user = this.getLoginUser();
		int agentType = user.getType();
		if (agentType != 1) {
			where += " and (" + Orderinfo.COL_buyagentid + "="
					+ user.getAgentid() + " or " + Orderinfo.COL_saleagentid
					+ "=" + user.getAgentid() + " ) ";
		}

		System.out.println(where);
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}

		return "totuandui";
	}

	/**
	 * 列表查询订单信息表Kwei---分销商
	 */
	public String tokwei() throws Exception {
		type = 8;
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = "";
		if (getLoginUser().getAgentid() == 46) {

			where += " where 1=1 and " + Orderinfo.COL_ordertype + " =5";
		} else {

			where += " where 1=1 and " + Orderinfo.COL_buyagentid + " ="
					+ getLoginUser().getAgentid() + " and "
					+ Orderinfo.COL_ordertype + " =5";

		}

		System.out.println(s_begincity);
		if (s_orderstatus != 0) {
			where += " and " + Orderinfo.COL_orderstatus + "=" + s_orderstatus;
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%'";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		if (s_bengincreatetime != null
				&& s_bengincreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " >= '"
					+ s_bengincreatetime.trim() + " 00:00:00'";
		}
		if (s_endcreatetime != null && s_endcreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " <= '"
					+ s_endcreatetime.trim() + " 23:59:59'";
		}
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}

		Customeruser user = this.getLoginUser();
		int agentType = user.getType();
		if (agentType != 1) {
			where += " and (" + Orderinfo.COL_buyagentid + "="
					+ user.getAgentid() + " or " + Orderinfo.COL_saleagentid
					+ "=" + user.getAgentid() + " ) ";
		}

		System.out.println(where);
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}

		return "totuandui";
	}

	/**
	 * 列表查询订单信息表Kwei---分供应商
	 */
	public String tomykwei() throws Exception {
		type = 5;
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = "";
		if (getLoginUser().getAgentid() == 46) {

			where += " where 1=1 and " + Orderinfo.COL_ordertype + " =5";
		} else {

			where += " where 1=1 and " + Orderinfo.COL_buyagentid + " ="
					+ getLoginUser().getAgentid() + " and "
					+ Orderinfo.COL_ordertype + " =5";

		}
		System.out.println(s_begincity);
		if (s_orderstatus != 0) {
			where += " and " + Orderinfo.COL_orderstatus + "=" + s_orderstatus;
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%'";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		if (s_bengincreatetime != null
				&& s_bengincreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " >= '"
					+ s_bengincreatetime.trim() + " 00:00:00'";
		}
		if (s_endcreatetime != null && s_endcreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " <= '"
					+ s_endcreatetime.trim() + " 23:59:59'";
		}
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}

		Customeruser user = this.getLoginUser();
		int agentType = user.getType();
		if (agentType != 1) {
			where += " and (" + Orderinfo.COL_buyagentid + "="
					+ user.getAgentid() + " or " + Orderinfo.COL_saleagentid
					+ "=" + user.getAgentid() + " ) ";
		}

		System.out.println(where);
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}

		return "tomytuandui";
	}

	public String tomytuandui() throws Exception {

		type = 4;
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = "";
		if (getLoginUser().getAgentid() == 46) {

			where += " where 1=1 and " + Orderinfo.COL_ordertype + " =4";
		} else {

			where += " where 1=1 and " + Orderinfo.COL_buyagentid + " ="
					+ getLoginUser().getAgentid() + " and "
					+ Orderinfo.COL_ordertype + " =4";
		}

		System.out.println(s_begincity);
		if (s_orderstatus != 0) {
			where += " and " + Orderinfo.COL_orderstatus + "=" + s_orderstatus;
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%'";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		if (s_bengincreatetime != null
				&& s_bengincreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " >= '"
					+ s_bengincreatetime.trim() + " 00:00:00'";
		}
		if (s_endcreatetime != null && s_endcreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " <= '"
					+ s_endcreatetime.trim() + " 23:59:59'";
		}
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}

		/*
		 * Customeruser user = this.getLoginUser(); int agentType =
		 * user.getType(); if (agentType != 1) { where += " and (" +
		 * Orderinfo.COL_buyagentid + "=" + user.getAgentid() + " or " +
		 * Orderinfo.COL_saleagentid + "=" + user.getAgentid() + " ) "; }
		 */

		System.out.println(where);
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}

		return "tomytuandui";
	}

	/**
	 * 列表查询订单信息表==分销商
	 */
	public String today() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date());
		}
		if (h_preendtime == null) {
			h_preendtime = sdf.format(new Date());
		}
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = "";
		if (getLoginUser().getAgentid() == 46) {

			where += " where 1=1 and " + Orderinfo.COL_ordertype + " =2 and "
					+ Orderinfo.COL_createtime + ">=" + "CONVERT(datetime, '"
					+ h_prestarttime + " 00:00:00') and "
					+ Orderinfo.COL_createtime + " <=" + "CONVERT(datetime, '"
					+ h_preendtime + " 23:59:59')";
		} else {

			where += " where 1=1 and " + Orderinfo.COL_createtime + ">="
					+ "CONVERT(datetime, '" + h_prestarttime
					+ " 00:00:00') and " + Orderinfo.COL_createtime + " <="
					+ "CONVERT(datetime, '" + h_preendtime + " 23:59:59') and "
					+ Orderinfo.COL_buyagentid + " ="
					+ getLoginUser().getAgentid() + " and "
					+ Orderinfo.COL_ordertype + " =2";
		}
		// System.out.println(s_begincity);
		if (s_orderstatus != 0) {
			where += " and " + Orderinfo.COL_orderstatus + "=" + s_orderstatus;
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%'";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		/*
		 * if (s_bengincreatetime != null && s_bengincreatetime.trim().length() !=
		 * 0) { where += " and " + Orderinfo.COL_createtime + " >= '" +
		 * s_bengincreatetime.trim() + " 00:00:00'"; } if (s_endcreatetime !=
		 * null && s_endcreatetime.trim().length() != 0) { where += " and " +
		 * Orderinfo.COL_createtime + " <= '" + s_endcreatetime.trim() + "
		 * 23:59:59'"; }
		 */
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}

		/*
		 * Customeruser user = this.getLoginUser(); int agentType =
		 * user.getType(); if (agentType != 1) { where += " and (" +
		 * Orderinfo.COL_buyagentid + "=" + user.getAgentid() + " or " +
		 * Orderinfo.COL_saleagentid + "=" + user.getAgentid() + " ) "; }
		 */

		System.out.println(where);
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}

		return "today";
	}

	/**
	 * 列表查询订单信息表==分销商--取消
	 */
	public String toquxiao() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date());
		}
		if (h_preendtime == null) {
			h_preendtime = sdf.format(new Date());
		}
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = "";
		if (getLoginUser().getAgentid() == 46) {

			where += " where 1=1 and " + Orderinfo.COL_orderstatus + " =6";
		} else {
			where += " where 1=1 and " + Orderinfo.COL_orderstatus + " =6 and "
					+ Orderinfo.COL_buyagentid + " ="
					+ getLoginUser().getAgentid();
		}

		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%' or " + Orderinfo.COL_bigpnr + " like '%"
					+ s_pnr.trim() + "%'";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		/*
		 * if (s_bengincreatetime != null && s_bengincreatetime.trim().length() !=
		 * 0) { where += " and " + Orderinfo.COL_createtime + " >= '" +
		 * s_bengincreatetime.trim() + " 00:00:00'"; } if (s_endcreatetime !=
		 * null && s_endcreatetime.trim().length() != 0) { where += " and " +
		 * Orderinfo.COL_createtime + " <= '" + s_endcreatetime.trim() + "
		 * 23:59:59'"; }
		 */
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}

		if (s_bigpnr != null && s_bigpnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_bigpnr + " = '" + s_bigpnr.trim()
					+ "'";
		}

		/*
		 * Customeruser user = this.getLoginUser(); int agentType =
		 * user.getType(); if (agentType != 1) { where += " and (" +
		 * Orderinfo.COL_buyagentid + "=" + user.getAgentid() + " or " +
		 * Orderinfo.COL_saleagentid + "=" + user.getAgentid() + " ) "; }
		 */

		// System.out.println(where);
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}

		return "toquxiao";
	}

	/**
	 * 列表查询订单信息表===供应商
	 */
	public String tomyorder() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date());
		}
		if (h_preendtime == null) {
			h_preendtime = sdf.format(new Date());
		}
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);

		String where = "";
		if (getLoginUser().getAgentid() == 46) {

			where += "where 1=1 and " + Orderinfo.COL_paystatus + " =1";
		} else {
			where += " where 1=1 and " + Orderinfo.COL_paystatus + " =1 and "
					+ Orderinfo.COL_saleagentid + " ='"
					+ getLoginUser().getAgentid() + "'";

		}
		// System.out.println(s_begincity);
		if (s_orderstatus != 0) {
			where += " and " + Orderinfo.COL_orderstatus + "=" + s_orderstatus;

		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%'";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		if (s_bengincreatetime != null
				&& s_bengincreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " >= '"
					+ s_bengincreatetime.trim() + " 00:00:00'";
		}
		if (s_endcreatetime != null && s_endcreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " <= '"
					+ s_endcreatetime.trim() + " 23:59:59'";
		}
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}

		/*
		 * Customeruser user = this.getLoginUser(); int agentType =
		 * user.getType(); if (agentType != 1) { where += " and (" +
		 * Orderinfo.COL_buyagentid + "=" + user.getAgentid() + " or " +
		 * Orderinfo.COL_saleagentid + "=" + user.getAgentid() + " ) "; }
		 */

		// System.out.println(where);
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}

		return "tomyorder";
	}

	public void getUserlistByAgent() throws IOException {
		new Orderinfo().getSaleagentid();
		String agent = ServletActionContext.getRequest().getParameter("agent");
		String username = ServletActionContext.getRequest().getParameter(
				"username");
		StringBuffer str = new StringBuffer("");
		str.append("<table>");
		str
				.append("<tr><td>姓名：<input id=\"cuname\"/>&nbsp;&nbsp;<input type=\"button\" onclick=\"searchuser()\" class=\"button108\" value=\" 查 询 \"/></td></tr>");
		str.append("<table  class=\"passtable\" id=\"divtable\">");
		str.append("<thead><tr>");
		str
				.append("<th class=\"passth\" width=\"80px\">姓名</th><th class=\"passth\" width=\"100px\">手机号码</th><th class=\"passth\" width=\"200px\">邮箱</th><th class=\"passth\" width=\"150px\">部门</th>");
		str.append("</thead></tr><tbody>");
		String where = "";
		if (agent.indexOf("c") >= 0) {
			int index = agent.indexOf("c") + 1;
			int agentid = Integer.valueOf(agent.substring(index));
			// agentname = Server.getInstance().getMemberService()
			// .findCustomeragent(agentid).getAgentcompanyname();
			where = " where C_AGENTID =" + agentid;
			if (agentid == 46) {
				where = " where " + Customeruser.COL_agentid + "=46 and "
						+ Customeruser.COL_membertype + " =1";
			}
		} else if (agent.contains("@")) {
			int index = agent.indexOf("@");
			int deptid = Integer.valueOf(agent.substring(0, index));
			where = " where C_DEPTID =" + deptid;
			// Department dept = Server.getInstance().getMemberService()
			// .findDepartment(Long.valueOf(agent));
			// deptname = dept.getName();
			// agentname = Server.getInstance().getMemberService()
			// .findCustomeragent(dept.getAgentid()).getAgentcompanyname();
		}
		where += " AND " + Customeruser.COL_membertype + " =1";
		if (agent.equals("46")) {
			where = " WHERE C_AGENTID=46 AND C_MEMBERTYPE=2";
		}
		if (username != null && username.length() > 0) {
			where += " AND " + Customeruser.COL_membername + " LIKE '%"
					+ username + "%' ";
		}
		List<Customeruser> customeruserlist = new ArrayList();
		customeruserlist = Server.getInstance().getMemberService()
				.findAllCustomeruser(where, "", -1, 0);
		for (Customeruser user : customeruserlist) {
			Department deptment = Server.getInstance().getMemberService()
					.findDepartment(converNull(user.getDeptid(), 0l));
			String dname = "";
			if (deptment != null) {
				dname = deptment.getName();
			}
			if (agent.equals("46")) {
				str.append("<tr onclick=\"getGzr('" + user.getId() + "','"
						+ user.getMembername() + "')\"");
			} else {
				str.append("<tr onclick=\"getCuname('" + user.getId() + "','"
						+ user.getMembername() + "','"
						+ converNull(user.getMobile(), "") + "','"
						+ converNull(user.getMemberemail(), "") + "'" + ")\" ");
			}
			str.append("style=\"cursor:pointer\"><td class=\"passtd\">"
					+ converNull(user.getMembername(), "")
					+ "</td><td class=\"passtd\">"
					+ converNull(user.getMobile(), "")
					+ "</td><td class=\"passtd\">"
					+ converNull(user.getMemberemail(), "")
					+ "</td><td class=\"passtd\">" + dname + "</td></tr>");

		}
		str.append("</tbody></table>");
		HttpServletResponse response = ServletActionContext.getResponse();
	
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(str.toString());
		out.flush();
		out.close();

	}

	public String tob2c() throws Exception {

		String meanuwhere = "";
		boolean ispt = false;
		if (this.isAdmin() || getLoginUser().getType() == 1) {// admin或平台员工
			meanuwhere = " WHERE " + Customeragent.COL_agenttype + "=3 AND "
					+ Customeragent.COL_bigtype + " = 1";
			ispt = true;
		} else {
			meanuwhere = " WHERE " + Customeragent.COL_agenttype + "=3 AND "
					+ Customeragent.COL_bigtype + " = 1 AND "
					+ Customeragent.COL_id + "="
					+ this.getLoginUser().getAgentid();
		}
		// System.out.println(this.getCompanyname());
		List<Customeragent> listcustomeragents = Server.getInstance()
				.getMemberService().findAllCustomeragent(meanuwhere, "", -1, 0);
		long[] arrayagentid = new long[listcustomeragents.size()];
		int i = 0;
		for (Customeragent cuagen : listcustomeragents) {
			arrayagentid[i] = cuagen.getId();
			i++;
		}
		// this.getDepttreestr(3l, arrayagentid, true);
		if (ispt) {
			StringBuffer dstr = new StringBuffer(super.getDeptstr());
			dstr
					.append(" var root_46 = new Ext.tree.TreeNode({text:\"散客\",id:'c46'});root.appendChild(root_46);");
			super.setDeptstr(dstr);
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date());
		}
		if (h_preendtime == null) {
			h_preendtime = sdf.format(new Date());
		}
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);

		String where = "";

		where += "where 1=1 ";

		Customeragent agent = Server.getInstance().getMemberService()
				.findCustomeragent(getLoginUser().getAgentid());
		if (agent.getAgenttype() == 3 && agent.getBigtype() == 1) {// twocold
			where += " AND " + Orderinfo.COL_buyagentid + "="
					+ agent.getId();
		}
		if (s_cashier >= 0) {
			where += " AND  C_CASHIER=" + s_cashier
					+ " AND C_ORDERSTATUS NOT IN(2,11,12,16,27) ";
		}
		if (s_customeragentid != null && s_customeragentid.trim().length() > 0) {
			if (s_customeragentid.startsWith("c")) {
				String agentidstr = s_customeragentid.replace("c", "");
				where += " AND " + Orderinfo.COL_buyagentid + "="
						+ agentidstr;

			} else {
				String deptid = s_customeragentid.substring(0,
						s_customeragentid.indexOf("@"));
				// String
				// agentid=s_customeragentid.substring(s_customeragentid.indexOf("@")+1);
				where += " AND " + Orderinfo.COL_customeruserid
						+ " IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_DEPTID="
						+ deptid + ")";
			}
		}
		if (this.s_paymethods > 0) {
			where += " AND " + Orderinfo.COL_paymethod + "=" + s_paymethods;
		}
		if (s_orderid != null) {
			where += " and " + Orderinfo.COL_id + "=" + s_orderid;
		}

		// System.out.println(s_begincity);
		if (s_orderstatus != 0) {// 订单状态
			String orderstatus = String.valueOf(s_orderstatus);
			if (s_orderstatus == 29) {
				orderstatus += ",28";
			}
			where += " and " + Orderinfo.COL_orderstatus + " IN ("
					+ orderstatus + ")";
			if (s_orderstatus == 2) {// 等待出票 包含1，等待支付，票到付款
				where += " OR (" + Orderinfo.COL_orderstatus + "=1 AND "
						+ Orderinfo.COL_paymethod + "=3 )";
			}

		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {// pnr编号
			where += " and (RTRIM(LTRIM(" + Orderinfo.COL_pnr + "))= '"
					+ s_pnr.trim() + "' or RTRIM(LTRIM(" + Orderinfo.COL_bigpnr
					+ "))= '" + s_pnr.trim() + "')";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {// 订单编号
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		if (s_bengincreatetime != null
				&& s_bengincreatetime.trim().length() != 0) {// 预订时间
			where += " and " + Orderinfo.COL_createtime + " >= '"
					+ s_bengincreatetime.trim() + " 00:00:00'";
		}
		if (s_endcreatetime != null && s_endcreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " <= '"
					+ s_endcreatetime.trim() + " 23:59:59'";
		}
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {// 乘机日期
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {// 出票时间
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {// 出发城市
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {// 到达城市
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {// 乘机人
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {// 票号
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_TICKETNUM] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {// 航班号
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}

		// 联系人姓名
		if (s_contactname != null && s_contactname.trim().length() > 0) {
			where += " and " + Orderinfo.COL_contactname + " LIKE '%"
					+ s_contactname + "%' ";
		}
		// 预订人姓名
		if (s_bookername != null && s_bookername.trim().length() > 0) {
			where += " and "
					+ Orderinfo.COL_saleagentid
					+ " in (select ID from T_CUSTOMERUSER where C_MEMBERNAME like'%"
					+ s_bookername.trim()
					+ "%' and C_TYPE = 1 and C_AGENTID=46) ";
		}
		// 出票人姓名
		if (s_chupiaoname != null && s_chupiaoname.trim().length() > 0) {
			where += " and "
					+ Orderinfo.COL_saleagentid
					+ " in (select ID from T_CUSTOMERUSER where C_MEMBERNAME like'%"
					+ s_chupiaoname.trim()
					+ "%' and C_TYPE = 1 and C_AGENTID=46) ";
		}
		// 废票申请人员
		if (s_feipiaoshenqingren != null
				&& s_feipiaoshenqingren.trim().length() > 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (select C_ORDERINFOID from T_ORDERINFORC where C_STATE = 5 and C_CUSTOMERUSERID in (select ID from T_CUSTOMERUSER where C_MEMBERNAME like '%"
					+ s_feipiaoshenqingren + "%')) ";
		}
		// 废票申请时间范围
		if (s_feipiaoshenqingsdate != null
				&& s_feipiaoshenqingsdate.trim().length() > 0
				&& s_feipiaoshenqingedate != null
				&& s_feipiaoshenqingedate.trim().length() > 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (select C_ORDERINFOID from T_ORDERINFORC where C_STATE = 5 and C_CREATETIME between '"
					+ s_feipiaoshenqingsdate + " 00:00:00' and '"
					+ s_feipiaoshenqingedate + " 23:59:59') ";
		}
		// 废票审核时间
		if (s_feipiaoshenhesdate != null
				&& s_feipiaoshenhesdate.trim().length() > 0
				&& s_feipiaoshenheedate != null
				&& s_feipiaoshenheedate.trim().length() > 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (select C_ORDERINFOID from T_ORDERINFORC where C_STATE = 11 and C_CREATETIME between '"
					+ s_feipiaoshenhesdate + " 00:00:00' and '"
					+ s_feipiaoshenheedate + " 23:59:59') ";
		}
		// 废票审核人
		if (s_feipiaoshenheren != null
				&& s_feipiaoshenheren.trim().length() > 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (select C_ORDERINFOID from T_ORDERINFORC where C_STATE = 11 and C_CUSTOMERUSERID in (select ID from T_CUSTOMERUSER where C_MEMBERNAME like '%"
					+ s_feipiaoshenheren + "%')) ";
		}
		if (this.s_send == 1) {// 待配送
			where += " AND " + Orderinfo.COL_receipt + " IN (4,5)";
		}
		// 只查询B2C后台订单
		where += " AND " + Orderinfo.COL_ordertype + "!=2";
		/*
		 * 添加过滤条件
		 */
		// if (this.getLoginUserRoleNumber().contains(10037l)) {// 大客户管理员
		// where += " AND " + Orderinfo.COL_customeragentid + "="
		// + this.getLoginUser().getAgentid();
		// }
		// System.out.println(where);
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}

		return "tob2c";
	}

	/**
	 * 个人挂账还款
	 * 
	 * @param ca
	 * @return
	 */
	public String toguazhang() throws Exception {
		listemployees = Server.getInstance().getMemberService()
				.findAllCustomeruser(
						" WHERE C_AGENTID = 46 AND C_TYPE = 1 AND ID <> 62",
						"", -1, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date());
		}
		if (h_preendtime == null) {
			h_preendtime = sdf.format(new Date());
		}
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);

		String where = "";
		where += "where 1=1 and (" + Orderinfo.COL_ordertype + " =1 or "
				+ Orderinfo.COL_ordertype + " = 6 or "
				+ Orderinfo.COL_ordertype + " = 3)";
		where += " AND " + Orderinfo.COL_fkmethod + " =7 ";

		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%'";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		if (s_bengincreatetime != null
				&& s_bengincreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " >= '"
					+ s_bengincreatetime.trim() + " 00:00:00'";
		}
		if (s_endcreatetime != null && s_endcreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " <= '"
					+ s_endcreatetime.trim() + " 23:59:59'";
		}
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}
		String strwhere = "AND ID IN (select C_ORDERID from T_GERENGUAZHANFREC where C_STATE="
				+ repaystate;
		if (s_employeeid != 0) {
			strwhere += " AND C_EMPLOYEEID=" + s_employeeid;
		}
		strwhere += ")";
		where += strwhere;

		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}

		return "toguazhang";
	}

	// 通过航空公司二字码和仓位吗获取名称
	public String getAirCompanyName(String ca) {
		String strReturn = "";
		List<Aircompany> list = Server.getInstance().getAirService()
				.findAllAircompany(
						" where 1=1 and " + Aircompany.COL_aircomcode + " = '"
								+ ca + "' ", "", -1, 0);
		if (list != null && list.size() > 0) {
			strReturn = list.get(0).getAircomcnname();
		}
		return strReturn;
	}

	/**
	 * 列表查询订单信息表===供应商 toPaid
	 */
	public String toPaid() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date());
		}
		if (h_preendtime == null) {
			h_preendtime = sdf.format(new Date());
		}
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);

		String where = "";
		if (getLoginUser().getAgentid() == 46) {
			if (s_orderstatus != 0) {
				where += " where 1=1 and " + Orderinfo.COL_orderstatus + "="
						+ s_orderstatus;
			} else {
				where += " where 1=1 and " + Orderinfo.COL_orderstatus
						+ "!=1 and " + Orderinfo.COL_orderstatus + "!=19";
			}
		} else {
			if (s_orderstatus != 0) {
				where += " where 1=1 and " + Orderinfo.COL_saleagentid + " ="
						+ getLoginUser().getAgentid() + " and "
						+ Orderinfo.COL_orderstatus + "=" + s_orderstatus;
			} else {
				where += " where 1=1 and " + Orderinfo.COL_saleagentid + " ="
						+ getLoginUser().getAgentid() + " and "
						+ Orderinfo.COL_orderstatus + "!=1 and "
						+ Orderinfo.COL_orderstatus + "!=19";
			}
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%'";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		if (ty == 7 || ty == 8) {
			where += " and " + Orderinfo.COL_createtime + ">="
					+ "CONVERT(datetime, '" + h_prestarttime
					+ " 00:00:00') and " + Orderinfo.COL_createtime + " <="
					+ "CONVERT(datetime, '" + h_preendtime + " 23:59:59')";
		} else {
			if (s_bengincreatetime != null
					&& s_bengincreatetime.trim().length() != 0) {
				where += " and " + Orderinfo.COL_createtime + " >= '"
						+ s_bengincreatetime.trim() + " 00:00:00'";
			}
			if (s_endcreatetime != null && s_endcreatetime.trim().length() != 0) {
				where += " and " + Orderinfo.COL_createtime + " <= '"
						+ s_endcreatetime.trim() + " 23:59:59'";
			}
		}
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}

		/*
		 * Customeruser user = this.getLoginUser(); int agentType =
		 * user.getType(); if (agentType != 1) { where += " and (" +
		 * Orderinfo.COL_buyagentid + "=" + user.getAgentid() + " or " +
		 * Orderinfo.COL_saleagentid + "=" + user.getAgentid() + " ) "; }
		 */

		System.out.println(where);
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}

		return "toPaid";
	}

	/**
	 * 跳转到订单报表
	 * 
	 * @return
	 */
	public String toreport() {
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		return "report";
	}

	/**
	 * 订单报表查询
	 */
	public String report() throws Exception {
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = " where 1=1 ";
		System.out.println(s_begincity);
		if (s_orderstatus != 0) {
			where += " and " + Orderinfo.COL_orderstatus + "=" + s_orderstatus;
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%'";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		if (s_bengincreatetime != null
				&& s_bengincreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " >= '"
					+ s_bengincreatetime.trim() + " 00:00:00'";
		}
		if (s_endcreatetime != null && s_endcreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " <= '"
					+ s_endcreatetime.trim() + " 23:59:59'";
		}
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}
		Customeruser user = this.getLoginUser();
		int agentType = user.getType();
		if (agentType != 1) {
			where += " and (" + Orderinfo.COL_buyagentid + "="
					+ user.getAgentid() + " or " + Orderinfo.COL_saleagentid
					+ "=" + user.getAgentid() + " ) ";
		}

		System.out.println(where);
		listOrderinfo = Server.getInstance().getAirService().findAllOrderinfo(
				where, " ORDER BY ID DESC", -1, 0);
		System.out.println(listOrderinfo.size() + "size");
		return "report";
	}

	/**
	 * 转向到订单信息表添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到申请升舱订单--供应商
	 */
	public String toshengcang() throws Exception {
		String where = "";
		if (getLoginUser().getAgentid() == 46) {
			where += " where 1=1 ";
		} else {
			where += "where 1=1 and " + Scang.COL_orderid
					+ " in (SELECT ID FROM " + Orderinfo.TABLE + " where "
					+ Orderinfo.COL_saleagentid + " ="
					+ getLoginUser().getAgentid() + " and "
					+ Orderinfo.COL_orderstatus + " =" + s_orderstatus + ")";

		}
		System.out.println("where==" + where);
		List list = Server.getInstance().getAirService()
				.findAllScangForPageinfo(where, "", pageinfo);

		pageinfo = (PageInfo) list.remove(0);
		listScang = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllScangForPageinfo(where, "", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listScang = list;
		}

		return "toshengcang";
	}

	/**
	 * 转向到申请升舱订单--分销商
	 */
	public String tomyshengcang() throws Exception {
		String where = "";
		if (getLoginUser().getAgentid() == 46) {
			where += " where 1=1 ";
		} else {
			where += "where 1=1 and " + Scang.COL_orderid
					+ " in (SELECT ID FROM " + Orderinfo.TABLE + " where "
					+ Orderinfo.COL_buyagentid + " ="
					+ getLoginUser().getAgentid() + " and "
					+ Orderinfo.COL_orderstatus + " =" + s_orderstatus + ")";

		}
		System.out.println("where==" + where);
		List list = Server.getInstance().getAirService()
				.findAllScangForPageinfo(where, "", pageinfo);

		pageinfo = (PageInfo) list.remove(0);
		listScang = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllScangForPageinfo(where, "", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listScang = list;
		}

		return "tomyshengcang";
	}

	public String shengcang() throws Exception {// 升舱
		scang = Server.getInstance().getAirService().findScang(scangid);
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				scang.getOrderid());

		return "shengcang";
	}

	// 跳转到告知单
	public String togaozhidan() throws Exception {
		return "togaozhidan";
	}

	public String totuipiao() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date());
		}
		if (h_preendtime == null) {
			h_preendtime = sdf.format(new Date());
		}
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = "";
		if (getLoginUser().getAgentid() == 46) {

			where += " where 1=1 and " + Orderinfo.COL_ordertype + " =2 and "
					+ Orderinfo.COL_createtime + ">=" + "CONVERT(datetime, '"
					+ h_prestarttime + " 00:00:00') and "
					+ Orderinfo.COL_createtime + " <=" + "CONVERT(datetime, '"
					+ h_preendtime + " 23:59:59') and "
					+ Orderinfo.COL_orderstatus + " =12";
		} else {

			where += " where 1=1 and " + Orderinfo.COL_createtime + ">="
					+ "CONVERT(datetime, '" + h_prestarttime
					+ " 00:00:00') and " + Orderinfo.COL_createtime + " <="
					+ "CONVERT(datetime, '" + h_preendtime + " 23:59:59') and "
					+ Orderinfo.COL_buyagentid + " ="
					+ getLoginUser().getAgentid() + " and "
					+ Orderinfo.COL_ordertype + " =2 and "
					+ Orderinfo.COL_orderstatus + " =12";
		}
		// System.out.println(s_begincity);
		if (s_orderstatus != 0) {
			where += " and " + Orderinfo.COL_orderstatus + "=" + s_orderstatus;
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%'";
		}
		if (s_ordernumber != null && s_ordernumber.trim().length() != 0) {
			where += " and " + Orderinfo.COL_ordernumber + " like '%"
					+ s_ordernumber.trim() + "%'";
		}
		/*
		 * if (s_bengincreatetime != null && s_bengincreatetime.trim().length() !=
		 * 0) { where += " and " + Orderinfo.COL_createtime + " >= '" +
		 * s_bengincreatetime.trim() + " 00:00:00'"; } if (s_endcreatetime !=
		 * null && s_endcreatetime.trim().length() != 0) { where += " and " +
		 * Orderinfo.COL_createtime + " <= '" + s_endcreatetime.trim() + "
		 * 23:59:59'"; }
		 */
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}

		/*
		 * Customeruser user = this.getLoginUser(); int agentType =
		 * user.getType(); if (agentType != 1) { where += " and (" +
		 * Orderinfo.COL_buyagentid + "=" + user.getAgentid() + " or " +
		 * Orderinfo.COL_saleagentid + "=" + user.getAgentid() + " ) "; }
		 */

		System.out.println(where);
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}

		return "totuipiao";
	}

	/**
	 * 转向到订单信息表修改页面==分销商
	 */
	public String toedit() throws Exception {
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());
		String where = "WHERE " + Passenger.COL_orderid + " = "
				+ orderinfo.getId();
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, "ORDER BY ID", -1, 0);
		String whereSeg = "WHERE " + Segmentinfo.COL_orderid + " = '"
				+ orderinfo.getId() + "'";
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				whereSeg, "ORDER BY ID", -1, 0);
		return EDIT;
	}

	/**
	 * 转向到订单信息表修改页面
	 */
	public String toeditb2c() throws Exception {
		String ticketwhere = " WHERE 1=1 ";
		listtickettype = Server.getInstance().getMemberService()
				.findAllTickettype(ticketwhere, "", -1, 0);

		String meanuwhere = "";
		boolean ispt = false;
		if (this.isAdmin() || getLoginUser().getType() == 1) {// admin或平台员工
			meanuwhere = " WHERE " + Customeragent.COL_agenttype + "=3 AND "
					+ Customeragent.COL_bigtype + " = 1";
			ispt = true;
		} else {
			meanuwhere = " WHERE " + Customeragent.COL_agenttype + "=3 AND "
					+ Customeragent.COL_bigtype + " = 1 AND "
					+ Customeragent.COL_id + "="
					+ this.getLoginUser().getAgentid();
		}
		List<Customeragent> listcustomeragents = Server.getInstance()
				.getMemberService().findAllCustomeragent(meanuwhere, "", -1, 0);
		long[] arrayagentid = new long[listcustomeragents.size()];
		int i = 0;
		for (Customeragent cuagen : listcustomeragents) {
			arrayagentid[i] = cuagen.getId();
			i++;
		}
		// this.getDepttreestr(3l, arrayagentid, true);
		if (ispt) {
			StringBuffer dstr = new StringBuffer(super.getDeptstr());
			dstr
					.append(" var root_46 = new Ext.tree.TreeNode({text:\"散客\",id:'c46'});root.appendChild(root_46);");
			super.setDeptstr(dstr);
		}

		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());
		Customeragent agent = Server.getInstance().getMemberService()
				.findCustomeragent(orderinfo.getCustomeragentid());
		s_customeragentid = "c"
				+ String.valueOf(orderinfo.getCustomeragentid());
		Customeruser user = Server.getInstance().getMemberService()
				.findCustomeruser(orderinfo.getCustomeruserid());
		companyname = agent.getAgentshortname();
		if (user != null) {
			if (user.getDeptid() != null) {
				Department dept = Server.getInstance().getMemberService()
						.findDepartment(user.getDeptid());
				if (dept != null) {
					companyname = converNull(dept.getName(), "");
					s_customeragentid = dept.getId() + "@"
							+ orderinfo.getCustomeragentid();

				}
			}
		}
		// this.companyname = agent.getAgentcompanyname();
		if (orderinfo.getCustomeragentid() == 46) {
			companyname = "散客";
		}
		String where = "WHERE " + Passenger.COL_orderid + " = "
				+ orderinfo.getId() + " and " + Passenger.COL_state + "<>12";
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, "ORDER BY ID", -1, 0);
		String whereSeg = "WHERE " + Segmentinfo.COL_orderid + " = '"
				+ orderinfo.getId() + "'";
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				whereSeg, "ORDER BY ID", -1, 0);
		return "toeditb2c";
	}

	/**
	 * 转向到订单信息表修改页面
	 */
	public String toeditgys() throws Exception {
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());
		String where = "WHERE " + Passenger.COL_orderid + " = "
				+ orderinfo.getId();
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, "ORDER BY ID", -1, 0);
		String whereSeg = "WHERE " + Segmentinfo.COL_orderid + " = '"
				+ orderinfo.getId() + "'";
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				whereSeg, "ORDER BY ID", -1, 0);
		return "toeditgys";
	}

	/**
	 * 转向到订单信息表审核页面
	 */
	public String tocheck() throws Exception {
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());
		return CHECK;
	}

	/**
	 * 转向订单详细信息页面==分销商
	 */
	public String toshow() throws Exception {

		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());
		// 锁定订单
		orderinfo.setFenxiaooperstate(1l);
		orderinfo.setFenxiaouserid(getLoginUserId());
		orderinfo.setFxssuotime(new Timestamp(System.currentTimeMillis()));
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);

		String where = "WHERE " + Passenger.COL_orderid + " = "
				+ orderinfo.getId();
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, "ORDER BY ID", -1, 0);
		String whereSeg = "WHERE " + Segmentinfo.COL_orderid + " = '"
				+ orderinfo.getId() + "'";
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				whereSeg, "ORDER BY ID", -1, 0);
		String strWhere = "WHERE " + Customeragent.COL_id + " = '"
				+ orderinfo.getBuyagentid() + "'";
		List<Customeragent> list = Server.getInstance().getMemberService()
				.findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0);
		if (list != null && list.size() > 0) {
			listAgent = list.get(0);
		}

		String strWhereBuy = "WHERE " + Customeragent.COL_id + " = '"
				+ orderinfo.getSaleagentid() + "'";
		List<Customeragent> list2 = Server.getInstance().getMemberService()
				.findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0);
		if (list2 != null && list2.size() > 0) {
			listGongAgent = list2.get(0);
		}
		String loginname = Server.getInstance().getMemberService()
				.findCustomeruser(orderinfo.getFenxiaouserid()).getLoginname();
		List<Passenger> listpa = Server.getInstance().getAirService()
				.findAllPassenger(
						"where 1=1 and " + Passenger.COL_orderid + " ="
								+ orderinfo.getId(), "", -1, 0);
		if (listpa.size() > 0) {

			for (int a = 0; a < listpa.size(); a++) {
				Orderinforc orderinforc = new Orderinforc();
				orderinforc.setCustomeruserid(getLoginUserId());
				orderinforc.setOrderinfoid(orderinfo.getId());
				orderinforc.setCreatetime(new Timestamp(System
						.currentTimeMillis()));
				orderinforc.setContent("会员:" + loginname + "锁单了订单");
				orderinforc.setSuouserid(orderinfo.getUserid());
				orderinforc.setState(listpa.get(a).getState());
				orderinforc.setPassid(listpa.get(a).getId());
				orderinforc.setCustomeruserid(getLoginUserId());
				Server.getInstance().getAirService().createOrderinforc(
						orderinforc);
			}
		}
		return "show";
	}

	/**
	 * 转向订单详细信息页面==供应商
	 */
	public String toshowgys() throws Exception {

		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());
		orderinfo.setOperatingstate(1l);
		orderinfo.setUserid(getLoginUserId());

		orderinfo.setGyssuotime(new Timestamp(System.currentTimeMillis()));
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);

		String where = "WHERE " + Passenger.COL_orderid + " = "
				+ orderinfo.getId();
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, "ORDER BY ID", -1, 0);
		String whereSeg = "WHERE " + Segmentinfo.COL_orderid + " = '"
				+ orderinfo.getId() + "'";
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				whereSeg, "ORDER BY ID", -1, 0);
		String strWhere = "WHERE " + Customeragent.COL_id + " = '"
				+ orderinfo.getBuyagentid() + "'";
		List<Customeragent> list = Server.getInstance().getMemberService()
				.findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0);
		if (list != null && list.size() > 0) {
			listAgent = list.get(0);
		}

		String strWhereBuy = "WHERE " + Customeragent.COL_id + " = '"
				+ orderinfo.getSaleagentid() + "'";
		List<Customeragent> list2 = Server.getInstance().getMemberService()
				.findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0);
		if (list2 != null && list2.size() > 0) {
			listGongAgent = list2.get(0);
		}
		String loginname = Server.getInstance().getMemberService()
				.findCustomeruser(orderinfo.getUserid()).getLoginname();
		List<Passenger> listpa = Server.getInstance().getAirService()
				.findAllPassenger(
						"where 1=1 and " + Passenger.COL_orderid + " ="
								+ orderinfo.getId(), "", -1, 0);
		if (listpa.size() > 0) {

			for (int a = 0; a < listpa.size(); a++) {
				Orderinforc orderinforc = new Orderinforc();
				orderinforc.setCustomeruserid(getLoginUserId());
				orderinforc.setOrderinfoid(orderinfo.getId());
				orderinforc.setCreatetime(new Timestamp(System
						.currentTimeMillis()));
				orderinforc.setContent("会员:" + loginname + "锁单了订单");
				orderinforc.setSuouserid(orderinfo.getUserid());
				orderinforc.setState(listpa.get(a).getState());
				orderinforc.setPassid(listpa.get(a).getId());
				orderinforc.setCustomeruserid(getLoginUserId());
				Server.getInstance().getAirService().createOrderinforc(
						orderinforc);
			}
		}
		return "toshowgys";
	}

	/**
	 * 转向订单详细信息页面==供应商
	 */
	public String toshowb2c() throws Exception {
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());

		/*
		 * 时不锁定订单 orderinfo.setOperatingstate(1l);
		 * orderinfo.setUserid(getLoginUserId()); orderinfo.setGyssuotime(new
		 * Timestamp(System.currentTimeMillis()));
		 * Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		 */

		String where = "WHERE " + Passenger.COL_orderid + " = "
				+ orderinfo.getId() + " AND " + Passenger.COL_state + "<>12";
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, "ORDER BY ID", -1, 0);
		String whereSeg = "WHERE " + Segmentinfo.COL_orderid + " = '"
				+ orderinfo.getId() + "'";
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				whereSeg, "ORDER BY ID", -1, 0);
		String strWhere = "WHERE " + Customeragent.COL_id + " = '"
				+ orderinfo.getBuyagentid() + "'";
		List<Customeragent> list = Server.getInstance().getMemberService()
				.findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0);
		if (list != null && list.size() > 0) {
			listAgent = list.get(0);
		}
		// 票号
		// 错误----修改改正
		// s_ticketnumber=Server.getInstance().getTicketSearchService().getTicketNumber(orderinfo.getPnr());
		// 行程单号
		// if(s_ticketnumber.length()>0)
		// {
		// s_rpnumber=Server.getInstance().getTicketSearchService().getRpNumber(s_ticketnumber);
		// }
		String strWhereBuy = "WHERE " + Customeragent.COL_id + " = '"
				+ orderinfo.getSaleagentid() + "'";
		List<Customeragent> list2 = Server.getInstance().getMemberService()
				.findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0);
		if (list2 != null && list2.size() > 0) {
			listGongAgent = list2.get(0);
		}
		// String loginname=
		// Server.getInstance().getMemberService().findCustomeruser(orderinfo.getUserid()).getLoginname();
		// List<Passenger> listpa =
		// Server.getInstance().getAirService().findAllPassenger("where 1=1 and
		// "+Passenger.COL_orderid+" ="+orderinfo.getId(), "", -1, 0);
		// if(listpa.size()>0){
		//			
		// for(int a=0;a<listpa.size();a++){
		// Orderinforc orderinforc = new Orderinforc();
		// orderinforc.setCustomeruserid(getLoginUserId());
		// orderinforc.setOrderinfoid(orderinfo.getId());
		// orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		// orderinforc.setContent("会员:"+loginname+"锁单了订单");
		// orderinforc.setSuouserid(orderinfo.getUserid());
		// orderinforc.setState(listpa.get(a).getState());
		// orderinforc.setPassid(listpa.get(a).getId());
		// orderinforc.setCustomeruserid(getLoginUserId());
		// Server.getInstance().getAirService().createOrderinforc(orderinforc);
		// }
		// }
		// System.out.println(orderinfo.getFkmethod());
		String sql = "SELECT * FROM [T_ORDERINFORC] WHERE C_ORDERINFOID = "
				+ orderinfo.getId()
				+ " AND C_STATE!=0  ORDER BY C_CREATETIME  ";
		listorderinforc = Server.getInstance().getAirService()
				.findAllOrderinforcBySql(sql, -1, 0);
		return "toshowb2c";
	}

	/**
	 * 添加订单信息表
	 */
	public void add() throws Exception {
		// 如果会员姓名为空 则更新姓名
		if (getOrderUserLogin().getMembername() == null
				|| getOrderUserLogin().getMembername().trim().length() == 0) {
			Customeruser customeruser = new Customeruser();
			customeruser.setMembername(orderinfo.getContactname());
			customeruser.setId(getOrderUserLogin().getId());
			Server.getInstance().getMemberService()
					.updateCustomeruserIgnoreNull(customeruser);
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		// 插入乘机人
		String[] h_ptypes = h_ptype.trim().split(",");
		String[] h_names = h_name.trim().split(",");
		String[] h_idtypes = h_idtype.trim().split(",");
		String[] h_idnumbers = h_idnumber.trim().split(",");
		String[] h_insurances = h_insurance.trim().split(",");
		// 单程
		Segmentinfo segmentOne = (Segmentinfo) ActionContext.getContext()
				.getSession().get("segmentOne");
		Segmentinfo segmentTwo = (Segmentinfo) ActionContext.getContext()
				.getSession().get("segmentTwo");
		// 创建乘机人
		float subfuelfee = 0;
		float subairportfee = 0;
		float subprice = 0;

		float subfuelfee2 = 0;
		float subairportfee2 = 0;
		float subprice2 = 0;

		// pnr
		String pnr1 = "NOPNR";
		String pnr2 = "NOPNR";
		String bgpnr1 = "NOPNR";
		String bgpnr2 = "NOPNR";
		// 插入乘机人
		if (segmentOne != null) {
			for (int i = 0; i < h_names.length; i++) {
				if (h_names[i].trim().length() > 0) {

					Passenger passenger = new Passenger();
					passenger.setPtype(Integer.parseInt(h_ptypes[i].trim()));
					if (passenger.getPtype() == 1) {
						subfuelfee += segmentOne.getFuelfee();
						subairportfee += segmentOne.getAirportfee();
						subprice += segmentOne.getPrice();
						passenger.setPrice(segmentOne.getPrice());
						passenger.setAirportfee(segmentOne.getAirportfee());
						passenger.setFuelprice(segmentOne.getFuelfee());
					} else if (passenger.getPtype() == 2) {
						subfuelfee += getRoundPrice(segmentOne.getFuelfee(), 2);
						subprice += getRoundPrice(segmentOne.getYprice(), 2);
						passenger.setAirportfee(0f);
						passenger.setFuelprice(getRoundPrice(segmentOne
								.getFuelfee(), 2));
						passenger.setPrice(getRoundPrice(
								segmentOne.getYprice(), 2));
					} else {
						subprice += getRoundPrice(segmentOne.getYprice(), 10);
						passenger.setAirportfee(0f);
						passenger.setFuelprice(0f);
						passenger.setPrice(getRoundPrice(
								segmentOne.getYprice(), 10));
					}
					passenger.setName(h_names[i]);
					passenger.setIdtype(Integer.parseInt(h_idtypes[i].trim()));
					passenger.setIdnumber(h_idnumbers[i].trim());
					passenger.setFet(segmentOne.getId() + "");
					passenger.setDiscount(segmentOne.getDiscount());
					passenger.setState(0);
					passenger.setLanguage(0);
					passenger.setHkstate(1l);
					listPassenger.add(passenger);
				}
			}
			// 乘机人结束

			// 创建pNr
			List<Segmentinfo> listsegmenginf = new ArrayList<Segmentinfo>();
			listsegmenginf.add(segmentOne);
			pnr1 = Server.getInstance().getTicketSearchService()
					.CreatePNRByCmd(listsegmenginf, listPassenger,
							getcususercode(getOrderUserLogin().getId()));
			if (pnr1.equals("NOPNR")) {
				Writer writer;
				try {
					writer = response.getWriter();
					writer.write("NOPNR");
					writer.flush();
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			} else {
				if (pnr1.trim().length() > 0) {
					bgpnr1 = Server.getInstance().getTicketSearchService()
							.getBigPNRInfo(pnr1);
				}
			}
		}
		// 创建pnr结束
		if (segmentTwo != null) {
			for (int i = 0; i < h_names.length; i++) {
				if (h_names[i].trim().length() > 0) {
					Passenger passenger = new Passenger();
					passenger.setPtype(Integer.parseInt(h_ptypes[i].trim()));
					if (passenger.getPtype() == 1) {
						subfuelfee2 += segmentTwo.getFuelfee();
						subairportfee2 += segmentTwo.getAirportfee();
						subprice2 += segmentTwo.getPrice();
						passenger.setPrice(segmentTwo.getPrice());
						passenger.setAirportfee(segmentTwo.getAirportfee());
						passenger.setFuelprice(segmentTwo.getFuelfee());
					} else if (passenger.getPtype() == 2) {
						subfuelfee2 += getRoundPrice(segmentTwo.getFuelfee(), 2);
						subprice2 += getRoundPrice(segmentTwo.getYprice(), 2);
						passenger.setAirportfee(0f);
						passenger.setFuelprice(getRoundPrice(segmentTwo
								.getFuelfee(), 2));
						passenger.setPrice(getRoundPrice(
								segmentTwo.getYprice(), 2));
					} else {
						subprice2 += getRoundPrice(segmentTwo.getYprice(), 10);
						passenger.setAirportfee(0f);
						passenger.setFuelprice(0f);
						passenger.setPrice(getRoundPrice(
								segmentTwo.getYprice(), 10));
					}
					passenger.setName(h_names[i]);
					passenger.setIdtype(Integer.parseInt(h_idtypes[i].trim()));
					passenger.setIdnumber(h_idnumbers[i].trim());
					passenger.setOrderid(orderinfo.getId());
					passenger.setFet(segmentTwo.getId() + "");
					passenger.setDiscount(segmentTwo.getDiscount());
					passenger.setState(0);
					passenger.setHkstate(1l);
					passenger.setLanguage(0);
					listPassenger2.add(passenger);
				}
			}
			// 乘机人结束

			// 创建pNr
			List<Segmentinfo> listsegmenginf = new ArrayList<Segmentinfo>();
			listsegmenginf.add(segmentTwo);
			pnr2 = Server.getInstance().getTicketSearchService()
					.CreatePNRByCmd(listsegmenginf, listPassenger2,
							getcususercode(getOrderUserLogin().getId()));
			if (pnr2.equals("NOPNR")) {
				Writer writer;
				try {
					writer = response.getWriter();
					writer.write("NOPNR");
					writer.flush();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			} else {
				if (pnr2.trim().length() > 0) {
					bgpnr2 = Server.getInstance().getTicketSearchService()
							.getBigPNRInfo(pnr2);
				}
			}
		}
		if (segmentOne != null) {
			// 插入订单
			orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
			// 分销商员工ID
			orderinfo.setCustomeruserid(getOrderUserLogin().getId());
			orderinfo.setCustomeragentid(getOrderUserLogin().getAgentid());
			// 分销商单位ID
			orderinfo.setBuyagentid(getOrderUserLogin().getAgentid());
			orderinfo.setPnr(pnr1);
			orderinfo.setBigpnr(bgpnr1);
			// 邮寄金额有配送方式决定
			if (orderinfo.getReceipt() == 3) {
				orderinfo.setPostmoney(20);
			} else {
				orderinfo.setPostmoney(0);
			}
			// 配送方式 1=不需要配送 2=门市自取 3=快递行程单 4=市内配送 5=大客户协议配送

			// 订单状态
			if (orderinfo.getPaymethod() == 6) {
				orderinfo.setOrderstatus(2);
				orderinfo.setPaystatus(1);
				orderinfo.setOrdertype(6l);
			} else if (orderinfo.getPaymethod() == 5) {
				orderinfo.setOrderstatus(2);
				orderinfo.setPaystatus(1);
				orderinfo.setOrdertype(3l);
			} else if (orderinfo.getPaymethod() == 2) {
				orderinfo.setOrderstatus(2);
				orderinfo.setPaystatus(0);
				orderinfo.setOrdertype(6l);
			} else if (orderinfo.getPaymethod() == 4) {
				orderinfo.setOrderstatus(1);
				orderinfo.setPaystatus(0);
				orderinfo.setOrdertype(6l);
			}
			// 如果是票到付款，则为待确认状态
			else if (orderinfo.getPaymethod() == 3) {
				orderinfo.setOrderstatus(27);
				orderinfo.setPaystatus(0);
				orderinfo.setOrdertype(6l);
			} else {
				orderinfo.setOrderstatus(1);
				orderinfo.setPaystatus(0);
				orderinfo.setOrdertype(6l);
			}
			orderinfo.setSaleagentid(getAngenid()); //
			orderinfo.setPolicyid(segmentOne.getZrateid());
			// 支付状态
			orderinfo.setLanguage(0);

			// 机建费
			orderinfo.setTotalairportfee(subairportfee);
			// 燃油费
			orderinfo.setTotalfuelfee(subfuelfee);
			// 票面价格
			orderinfo.setTotalticketprice(subprice);
			orderinfo.setSaleagentid(getLoginUserId());
			orderinfo.setBusystatus(2l);
			orderinfo = Server.getInstance().getAirService().createOrderinfo(
					orderinfo);
			if (idtemp == 0) {
				idtemp = orderinfo.getId();
			}
			orderinfo.setOrdernumber(Server.getInstance().getServiceCenter()
					.getOrderinfoCode(orderinfo));
			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
					orderinfo);

			segmentOne.setOrderid(orderinfo.getId());
			segmentOne.setLanguage(0);
			segmentOne = Server.getInstance().getAirService()
					.createSegmentinfo(segmentOne);
			for (Passenger passenger : listPassenger) {
				passenger.setOrderid(orderinfo.getId());
				Server.getInstance().getAirService().createPassenger(passenger);
			}
			// 添加常用旅客
			for (int i = 0; i < listPassenger.size(); i++) {
				String where = " where 1=1 and "
						+ Customerpassenger.COL_customeruserid + " = "
						+ getOrderUserLogin().getId() + " and "
						+ Customerpassenger.COL_username + " = '"
						+ listPassenger.get(i).getName().trim() + "'";
				List<Customerpassenger> list = Server.getInstance()
						.getMemberService().findAllCustomerpassenger(where, "",
								-1, 0);
				if (list != null && list.size() > 0) {
					continue;
				}
				Customerpassenger customerpassenger = new Customerpassenger();
				customerpassenger.setCreatetime(new Timestamp(System
						.currentTimeMillis()));
				customerpassenger.setCreateuser(getLoginUser().getLoginname());
				customerpassenger.setUsername(listPassenger.get(i).getName()
						.trim());
				customerpassenger.setType(1);
				customerpassenger
						.setCustomeruserid(getOrderUserLogin().getId());
				customerpassenger = Server.getInstance().getMemberService()
						.createCustomerpassenger(customerpassenger);
				// 添加证件
				Customercredit customercredit = new Customercredit();
				customercredit.setCreatetime(new Timestamp(System
						.currentTimeMillis()));
				customercredit.setCreateuser(getLoginUser().getMembername());
				customercredit.setCreditnumber(listPassenger.get(i)
						.getIdnumber().trim());
				customercredit
						.setCredittypeid(listPassenger.get(i).getIdtype());
				customercredit.setModifytime(new Timestamp(System
						.currentTimeMillis()));
				customercredit.setModifyuser(getLoginUser().getMembername());
				customercredit.setRefid(customerpassenger.getId());
				customercredit.setType(1);
				Server.getInstance().getMemberService().createCustomercredit(
						customercredit);
			}
		}
		// 返程
		if (segmentTwo != null) {
			// 插入订单
			orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
			orderinfo.setCustomeruserid(getLoginUserId());
			orderinfo.setRelationorderid(orderinfo.getId());
			// 订单状态
			if (orderinfo.getPaymethod() == 6) {
				orderinfo.setOrderstatus(2);
				orderinfo.setPaystatus(1);
				orderinfo.setOrdertype(6l);
			} else if (orderinfo.getPaymethod() == 5) {
				orderinfo.setOrderstatus(2);
				orderinfo.setPaystatus(1);
				orderinfo.setOrdertype(3l);
			} else if (orderinfo.getPaymethod() == 2) {
				orderinfo.setOrderstatus(2);
				orderinfo.setPaystatus(0);
				orderinfo.setOrdertype(6l);
			} else if (orderinfo.getPaymethod() == 4) {
				orderinfo.setOrderstatus(1);
				orderinfo.setPaystatus(0);
				orderinfo.setOrdertype(6l);
			}
			// 如果是票到付款，则为待确认状态
			else if (orderinfo.getPaymethod() == 3) {
				orderinfo.setOrderstatus(27);
				orderinfo.setPaystatus(0);
				orderinfo.setOrdertype(6l);
			} else {
				orderinfo.setOrderstatus(1);
				orderinfo.setPaystatus(0);
				orderinfo.setOrdertype(6l);
			}
			// 分销商单位ID
			Customeruser customeruser = getLoginUser();
			orderinfo.setCustomeruserid(getLoginUserId());
			orderinfo.setBuyagentid(customeruser.getAgentid());
			orderinfo.setPnr(pnr2);
			orderinfo.setBigpnr(bgpnr2);
			orderinfo.setOrdernumber(null);
			// 邮寄金额有配送方式决定
			if (orderinfo.getReceipt() == 3) {
				orderinfo.setPostmoney(20);
			} else {
				orderinfo.setPostmoney(0);
			}
			orderinfo.setPolicyid(segmentTwo.getZrateid());
			orderinfo.setLanguage(0);
			orderinfo.setSaleagentid(getLoginUserId());
			// 机建费
			orderinfo.setTotalairportfee(subairportfee2);
			// 燃油费
			orderinfo.setTotalfuelfee(subfuelfee2);
			// 票面价格
			orderinfo.setTotalticketprice(subprice2);

			orderinfo.setBusystatus(2l);
			orderinfo.setId(-1);
			orderinfo.setRelationorderid(idtemp);
			orderinfo = Server.getInstance().getAirService().createOrderinfo(
					orderinfo);
			orderinfo.setOrdernumber(Server.getInstance().getServiceCenter()
					.getOrderinfoCode(orderinfo));
			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
					orderinfo);
			// 更变驱程关联id
			Orderinfo orderinfotemp = new Orderinfo();
			orderinfotemp.setId(idtemp);
			orderinfotemp.setRelationorderid(orderinfo.getId());
			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
					orderinfotemp);

			segmentTwo.setOrderid(orderinfo.getId());
			segmentTwo.setLanguage(0);
			segmentTwo = Server.getInstance().getAirService()
					.createSegmentinfo(segmentTwo);

			for (Passenger passenger : listPassenger2) {
				passenger.setOrderid(orderinfo.getId());
				Server.getInstance().getAirService().createPassenger(passenger);
			}
		}

		// 跳转
		temporderuserid = getOrderUserLogin().getId();
		ActionContext.getContext().getSession().remove("orderuserlogin");
		String smstemple = this.getSMSTemple("TOrderSuccess");
		smstemple = smstemple.replaceAll("@CustomerName@", orderinfo
				.getContactname());
		smstemple = smstemple.replaceAll("@startcityto@",
				getAirportbySZM(segmentOne.getStartairport()));
		smstemple = smstemple.replaceAll("@endcityto@",
				getAirportbySZM(segmentOne.getEndairport()));
		if (segmentTwo != null) {
			smstemple = smstemple.replaceAll("@type@", "往返");
			smstemple = smstemple.replaceAll("@OrderId@", Server.getInstance()
					.getAirService().findOrderinfo(idtemp).getOrdernumber()
					+ "-" + orderinfo.getOrdernumber());
		} else {
			smstemple = smstemple.replaceAll("@type@", "单程");
			smstemple = smstemple.replaceAll("@OrderId@", orderinfo
					.getOrdernumber());
		}
		System.out.println(smstemple);
		this.smsSend(new String[] { "" + orderinfo.getContactmobile() + "" },
				smstemple, orderinfo.getOrdernumber() + "-"
						+ orderinfo2.getOrdernumber(), getLoginUserId() + "");
		forwork = "ticketorder!searchair.action?orderinfo.id="
				+ orderinfo.getId() + "&idtemp=" + idtemp + "&temporderuserid="
				+ temporderuserid;
		Writer writer;
		try {
			writer = response.getWriter();
			writer.write(forwork);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String searchair() {
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				"where 1=1 and " + Passenger.COL_orderid + " ="
						+ orderinfo.getId(), "", -1, 0);
		listPassenger2 = Server.getInstance().getAirService().findAllPassenger(
				"where 1=1 and " + Passenger.COL_orderid + " =" + idtemp, "",
				-1, 0);
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());
		orderinfo2 = Server.getInstance().getAirService().findOrderinfo(idtemp);
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				"where 1=1 and " + Segmentinfo.COL_orderid + " ="
						+ orderinfo.getId(), "", -1, 0);
		listSegment2 = Server.getInstance().getAirService().findAllSegmentinfo(
				"where 1=1 and " + Segmentinfo.COL_orderid + " =" + idtemp, "",
				-1, 0);
		return "ticketorderinfo";
	}

	/**
	 * 审核订单信息表
	 */
	public String check() throws Exception {

		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		return LIST;
	}

	/**
	 * 编辑订单信息表
	 */
	public String edit() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		if (s_customeragentid != null && s_customeragentid.trim().length() > 0) {
			if (s_customeragentid.startsWith("c")) {
				String agentidstr = s_customeragentid.replace("c", "");
				long agentid = Long.valueOf(agentidstr);
				orderinfo.setCustomeragentid(agentid);

			} else {
				// String
				// deptid=s_customeragentid.substring(0,s_customeragentid.indexOf("@"));
				String agentid = s_customeragentid.substring(s_customeragentid
						.indexOf("@") + 1);
				orderinfo.setCustomeragentid(Long.valueOf(agentid));

			}
		}
		long gzid = converNull(orderinfo.getGuazhangrenid(), 0l);
		if (gzid > 0l) {
			String where = " WHERE C_ORDERID=" + orderinfo.getId();
			List<Gerenguazhanfrec> grgzs = Server.getInstance()
					.getMemberService().findAllGerenguazhanfrec(where, "", -1,
							0);
			if (grgzs.size() > 0) {
				Gerenguazhanfrec grgz = grgzs.get(0);
				grgz.setEmployeeid(gzid);
				Server.getInstance().getMemberService()
						.updateGerenguazhanfrecIgnoreNull(grgz);
			}

		}
		List<Passenger> listpassengers = Server.getInstance().getAirService()
				.findAllPassenger(" WHERE C_ORDERID=" + orderinfo.getId(), "",
						-1, 0);
		float allprice = 0f;
		float allfuelprice = 0f;
		float allairprice = 0f;
		float allanjianfee = 0f;
		float allotherfee = 0f;
		try {
			for (Passenger pasger : listpassengers) {

				long id = pasger.getId();
				float price = Float.valueOf(converTrim(request.getParameter(id
						+ "price"), "0"));
				float fuelprice = Float.valueOf(converTrim(request
						.getParameter(id + "fuelprice"), "0"));
				float airportfee = Float.valueOf(converTrim(request
						.getParameter(id + "airportfee"), "0"));
				float anjianfee = Float.valueOf(converTrim(request
						.getParameter(id + "anjianfee"), "0"));
				float otherfee = Float.valueOf(converTrim(request
						.getParameter(id + "otherfee"), "0"));
				float tuifee = Float.valueOf(converTrim(request.getParameter(id
						+ "tuifee"), "0"));
				String strname = request.getParameter(id + "name");
				allprice += price;
				allfuelprice += fuelprice;
				allairprice += airportfee;
				allanjianfee += anjianfee;
				allotherfee += otherfee;
				pasger.setName(strname);
				pasger.setPrice(price);
				pasger.setAirportfee(airportfee);
				pasger.setFuelprice(fuelprice);
				pasger.setAnjianfee(anjianfee);
				pasger.setOtherfee(otherfee);
				pasger.setTuifee(tuifee);
				Server.getInstance().getAirService().updatePassenger(pasger);
				orderinfo.setTotalticketprice(allprice);
				orderinfo.setTotalairportfee(allairprice);
				orderinfo.setTotalfuelfee(allfuelprice);
				orderinfo.setTotalanjian(allanjianfee);
				orderinfo.setTotalotherfee(allotherfee);
			}
		} catch (Exception ex) {

		}

		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		try {
			String[] typeid = u_id.trim().split(",");
			String[] typeidnumber = u_idnumber.trim().split(",");
			Passenger passenger = null;
			for (int i = 0; i < typeid.length; i++) {
				passenger = new Passenger();
				passenger.setTickettypeid(s_tickettypeid);
				passenger.setId(Integer.parseInt(typeid[i].trim()));
				passenger.setIdnumber(typeidnumber[i].trim());
				Server.getInstance().getAirService().updatePassengerIgnoreNull(
						passenger);
			}
		} catch (Exception ex) {

		}
		// 记录操作记录
		Orderinforc orderinforc = new Orderinforc();
		orderinforc.setCustomeruserid(getLoginUserId());
		orderinforc.setOrderinfoid(orderinfo.getId());
		orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		orderinforc.setSuouserid(orderinfo.getUserid());
		orderinforc.setState(-1);
		orderinforc.setContent("订单修改-" + getLoginUser().getMembername()
				+ "修改了订单");
		orderinforc.setCustomeruserid(getLoginUserId());
		Server.getInstance().getAirService().createOrderinforc(orderinforc);

		forward = ServletActionContext.getRequest().getHeader("Referer");

		// //////
		return "editorderinfo";
	}

	/**
	 * 编辑订单信息表--分销商
	 */
	public String editfxs() throws Exception {
		Orderinfo order = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());
		order.setAddresa(orderinfo.getAddresa());
		order.setContactemail(orderinfo.getContactemail());
		order.setContactname(orderinfo.getContactname());
		order.setContactmobile(orderinfo.getContactmobile());

		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(order);
		String[] typeid = u_id.trim().split(",");
		String[] typeidnumber = u_idnumber.trim().split(",");
		Passenger passenger = null;
		for (int i = 0; i < typeid.length; i++) {
			passenger = new Passenger();
			passenger.setId(Integer.parseInt(typeid[i].trim()));
			passenger.setIdnumber(typeidnumber[i].trim());
			Server.getInstance().getAirService().updatePassengerIgnoreNull(
					passenger);
		}
		forward = ServletActionContext.getRequest().getHeader("Referer");

		// //////
		return "editorderinfo";
	}

	/**
	 * 删除订单信息表
	 */
	public String delete() throws Exception {
		Server.getInstance().getAirService().deleteOrderinfo(orderinfo.getId());
		return LIST;
	}

	public String seachstate() {// 供应商查询订单状态
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(oid);
		if (orderinfo.getGyssuotime() == null) {// 新订单啊
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print("kong");
			/*
			 * if(orderinfo.getOperatingstate()==null){
			 * 
			 * orderinfo.setOperatingstate(0l); }
			 * 
			 * try { if(orderinfo.getOperatingstate()==1 &&
			 * orderinfo.getUserid()!=getLoginUserId()){
			 * 
			 * out = response.getWriter(); out.print("suo"); }else
			 * if(orderinfo.getUserid()==null){ out = response.getWriter();
			 * out.print("kong");
			 * 
			 * }else{ if(orderinfo.getUserid()==getLoginUserId()){ out =
			 * response.getWriter(); out.print("my"); }else{ out =
			 * response.getWriter(); out.print("she,"+orderinfo.getUserid()); } } }
			 * catch (IOException e) { e.printStackTrace(); }
			 */
			out.flush();
			out.close();
		} else {

			if (new Timestamp(System.currentTimeMillis()).getTime()
					- orderinfo.getGyssuotime().getTime() > 30 * 1000 * 60) {// 超过了30分钟
				// orderinfo.setGyssuotime(null);
				orderinfo.setOperatingstate(0l);
				// orderinfo.setUserid(null);
				Server.getInstance().getAirService().updateOrderinfo(orderinfo);
				try {
					out = response.getWriter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.print("kong");
				out.flush();
				out.close();

			} else {// 还没超过30分钟

				if (orderinfo.getOperatingstate() == null) {

					orderinfo.setOperatingstate(0l);
				}

				try {
					if (orderinfo.getOperatingstate() == 1
							&& orderinfo.getUserid() != getLoginUserId()
							&& orderinfo.getUserid() != 0) {

						out = response.getWriter();
						out.print("suo");
					} else if (orderinfo.getUserid() == null) {
						out = response.getWriter();
						out.print("kong");

					} else {
						if (orderinfo.getUserid() == getLoginUserId()) {
							out = response.getWriter();
							out.print("my");
						} else if (orderinfo.getUserid() != 0) {
							out = response.getWriter();
							out.print("she," + orderinfo.getUserid());
						} else {
							out = response.getWriter();
							out.print("my");
						}

					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				out.flush();
				out.close();
			}

		}
		return SUCCESS;
	}

	public String fenxiaoseachstate() {// 分销商查询订单状态 参照供应商的做法
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = null;
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(oid);
		if (orderinfo.getFxssuotime() == null) {// 新订单啊
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print("kong");
			/*
			 * if(orderinfo.getOperatingstate()==null){
			 * 
			 * orderinfo.setOperatingstate(0l); }
			 * 
			 * try { if(orderinfo.getOperatingstate()==1 &&
			 * orderinfo.getUserid()!=getLoginUserId()){
			 * 
			 * out = response.getWriter(); out.print("suo"); }else
			 * if(orderinfo.getUserid()==null){ out = response.getWriter();
			 * out.print("kong");
			 * 
			 * }else{ if(orderinfo.getUserid()==getLoginUserId()){ out =
			 * response.getWriter(); out.print("my"); }else{ out =
			 * response.getWriter(); out.print("she,"+orderinfo.getUserid()); } } }
			 * catch (IOException e) { e.printStackTrace(); }
			 */
			out.flush();
			out.close();
		} else {

			if (new Timestamp(System.currentTimeMillis()).getTime()
					- orderinfo.getFxssuotime().getTime() > 30 * 1000 * 60) {// 超过了30分钟
				// orderinfo.setGyssuotime(null);
				orderinfo.setFenxiaooperstate(0l);
				// orderinfo.setUserid(null);
				Server.getInstance().getAirService().updateOrderinfo(orderinfo);
				try {
					out = response.getWriter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				out.print("kong");
				out.flush();
				out.close();

			} else {// 还没超过30分钟

				if (orderinfo.getFenxiaooperstate() == null) {

					orderinfo.setFenxiaooperstate(0l);
				}

				try {
					if (orderinfo.getFenxiaooperstate() == 1
							&& orderinfo.getFenxiaouserid() != getLoginUserId()) {

						out = response.getWriter();
						out.print("suo");
					} else if (orderinfo.getFenxiaouserid() == null) {
						out = response.getWriter();
						out.print("kong");

					} else {
						if (orderinfo.getFenxiaouserid() == getLoginUserId()) {
							out = response.getWriter();
							out.print("my");
						} else {
							out = response.getWriter();
							out.print("she," + orderinfo.getFenxiaouserid());
						}

					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				out.flush();
				out.close();
			}

		}
		/*
		 * HttpServletResponse response = ServletActionContext.getResponse();
		 * PrintWriter out = null; Orderinfo orderinfo =
		 * Server.getInstance().getAirService().findOrderinfo(oid);
		 * if(orderinfo.getFxssuotime()==null){
		 * 
		 * 
		 * 
		 * if(orderinfo.getFenxiaooperstate()==null){
		 * 
		 * orderinfo.setFenxiaooperstate(0l); }
		 * 
		 * try { if(orderinfo.getFenxiaooperstate()==1 &&
		 * orderinfo.getFenxiaouserid()!=getLoginUserId()){
		 * 
		 * out = response.getWriter(); out.print("suo"); }else
		 * if(orderinfo.getFenxiaouserid()==null){ out = response.getWriter();
		 * out.print("kong");
		 * 
		 * }else{ if(orderinfo.getFenxiaouserid()==getLoginUserId()){ out =
		 * response.getWriter(); out.print("my"); }else{ out =
		 * response.getWriter(); out.print("she,"+orderinfo.getFenxiaouserid()); } } }
		 * catch (IOException e) { e.printStackTrace(); } out.flush();
		 * out.close(); }else{
		 * 
		 * if(new Timestamp(System.currentTimeMillis()).getTime() -
		 * orderinfo.getFxssuotime().getTime()>30*1000*60){
		 * orderinfo.setFxssuotime(null); orderinfo.setFenxiaooperstate(0l);
		 * orderinfo.setFenxiaouserid(null);
		 * Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		 * }else{
		 * 
		 * if(orderinfo.getFenxiaooperstate()==null){
		 * 
		 * orderinfo.setFenxiaooperstate(0l); }
		 * 
		 * try { if(orderinfo.getFenxiaooperstate()==1 &&
		 * orderinfo.getFenxiaouserid()!=getLoginUserId()){
		 * 
		 * out = response.getWriter(); out.print("suo"); }else
		 * if(orderinfo.getFenxiaouserid()==null){ out = response.getWriter();
		 * out.print("kong");
		 * 
		 * }else{ if(orderinfo.getFenxiaouserid()==getLoginUserId()){ out =
		 * response.getWriter(); out.print("my"); }else{ out =
		 * response.getWriter(); out.print("she,"+orderinfo.getFenxiaouserid()); } } }
		 * catch (IOException e) { e.printStackTrace(); } out.flush();
		 * out.close(); } }
		 */
		return SUCCESS;
	}

	/*
	 * public boolean isLockOrder(long id,long orderstatus){ Orderinfo order =
	 * Server.getInstance().getAirService() .findOrderinfo(id);
	 * 
	 * if (order.getFxssuotime() != null && order.getFenxiaouserid() != null) {
	 * long suouserid = order.getFenxiaouserid(); if (new
	 * Timestamp(System.currentTimeMillis()).getTime() -
	 * order.getFxssuotime().getTime() > 30 * 1000 * 60) { //
	 * order.setGyssuotime(null); order.setFenxiaooperstate(0l); //
	 * order.setUserid(null);
	 * Server.getInstance().getAirService().updateOrderinfo(order); String
	 * loginname = Server.getInstance().getMemberService()
	 * .findCustomeruser(order.getUserid()).getLoginname(); List<Passenger>
	 * listpa = Server.getInstance().getAirService() .findAllPassenger( "where
	 * 1=1 and " + Passenger.COL_orderid + " =" + order.getId(), "", -1, 0); if
	 * (listpa.size() > 0) {
	 * 
	 * for (int a = 0; a < listpa.size(); a++) { Orderinforc orderinforc = new
	 * Orderinforc(); orderinforc.setCustomeruserid(getLoginUserId());
	 * orderinforc.setOrderinfoid(order.getId()); orderinforc.setCreatetime(new
	 * Timestamp(System .currentTimeMillis()));
	 * orderinforc.setContent("系统自动解锁订单");
	 * orderinforc.setSuouserid(order.getUserid()); //
	 * orderinforc.setState(listpa.get(a).getState());
	 * orderinforc.setPassid(listpa.get(a).getId());
	 * orderinforc.setCustomeruserid(order.getUserid());
	 * Server.getInstance().getAirService().createOrderinforc( orderinforc); } }
	 * return false; }
	 */
	public long seachfxs(long id) throws Exception {// 分销商
		Orderinfo order = Server.getInstance().getAirService()
				.findOrderinfo(id);

		if (order.getFxssuotime() != null && order.getFenxiaouserid() != null) {
			long suouserid = order.getFenxiaouserid();
			if (new Timestamp(System.currentTimeMillis()).getTime()
					- order.getFxssuotime().getTime() > 30 * 1000 * 60) {
				// order.setGyssuotime(null);
				order.setFenxiaooperstate(0l);
				// order.setUserid(null);
				Server.getInstance().getAirService().updateOrderinfo(order);

				/*
				 * Orderinforc orderinforc = new Orderinforc();
				 * orderinforc.setCustomeruserid(getLoginUserId());
				 * orderinforc.setOrderinfoid(orderinfo.getId());
				 * orderinforc.setCreatetime(new
				 * Timestamp(System.currentTimeMillis()));
				 * orderinforc.setContent("系统自动解锁订单");
				 * orderinforc.setSuouserid(suouserid);
				 * Server.getInstance().getAirService().createOrderinforc(orderinforc);
				 */

				String loginname = Server.getInstance().getMemberService()
						.findCustomeruser(order.getUserid()).getLoginname();
				List<Passenger> listpa = Server.getInstance().getAirService()
						.findAllPassenger(
								"where 1=1 and " + Passenger.COL_orderid + " ="
										+ order.getId(), "", -1, 0);
				if (listpa.size() > 0) {

					for (int a = 0; a < listpa.size(); a++) {
						Orderinforc orderinforc = new Orderinforc();
						orderinforc.setCustomeruserid(getLoginUserId());
						orderinforc.setOrderinfoid(order.getId());
						orderinforc.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						orderinforc.setContent("系统自动解锁订单");
						orderinforc.setSuouserid(order.getUserid());
						// orderinforc.setState(listpa.get(a).getState());
						orderinforc.setPassid(listpa.get(a).getId());
						orderinforc.setCustomeruserid(order.getUserid());
						Server.getInstance().getAirService().createOrderinforc(
								orderinforc);
					}
				}

				return 1;
			} else {
				return 2;
			}

		} else {
			return 0;
		}
	}

	/**
	 * 订单状态修改==分销商
	 */
	public String orderstatusedit() throws Exception {
		// Orderinfo or =
		// Server.getInstance().getAirService().findOrderinfo(orderinfo.getId());

		if (orderinfo.getOrderstatus() == 2) {

			orderinfo.setPaystatus(1);
		}
		orderinfo.setFenxiaouserid(getLoginUserId());
		orderinfo
				.setFenxiaoupdatetime(new Timestamp(System.currentTimeMillis()));
		orderinfo.setFenxiaooperstate(1l);
		orderinfo.setFxssuotime(new Timestamp(System.currentTimeMillis()));
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		// System.out.println(or.toString());
		String loginname = Server.getInstance().getMemberService()
				.findCustomeruser(orderinfo.getFenxiaouserid()).getLoginname();
		List<Passenger> listpa = Server.getInstance().getAirService()
				.findAllPassenger(
						"where 1=1 and " + Passenger.COL_orderid + " ="
								+ orderinfo.getId(), "", -1, 0);
		if (listpa.size() > 0) {

			for (int a = 0; a < listpa.size(); a++) {
				Orderinforc orderinforc = new Orderinforc();
				orderinforc.setCustomeruserid(getLoginUserId());
				orderinforc.setOrderinfoid(orderinfo.getId());
				orderinforc.setCreatetime(new Timestamp(System
						.currentTimeMillis()));
				orderinforc.setContent("会员:" + loginname + "操作了订单");
				orderinforc.setSuouserid(orderinfo.getFenxiaouserid());
				orderinforc.setState(listpa.get(a).getState());
				orderinforc.setPassid(listpa.get(a).getId());
				orderinforc.setCustomeruserid(getLoginUserId());
				Server.getInstance().getAirService().createOrderinforc(
						orderinforc);
			}
		}
		forward = ServletActionContext.getRequest().getHeader("Referer");
		return LIST;
	}

	/**
	 * 订单解锁
	 */
	public String jiesuo() throws Exception {

		orderinfo.setOperatingstate(0l);

		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);

		forward = ServletActionContext.getRequest().getHeader("Referer");
		return "jiesuo";
	}

	public void unlockorder() throws Exception {
		orderinfo = Server.getInstance().getAirService().findOrderinfo(oid);
		orderinfo.setOperatingstate(0l);
		orderinfo.setUserid(0l);
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		String strHTML = "解锁成功！";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strHTML);
		out.print(sb);
		out.flush();
		out.close();
	}

	public long seachgys(long id) throws Exception {// 供应商

		Orderinfo order = Server.getInstance().getAirService()
				.findOrderinfo(id);
		long suouserid = order.getUserid();
		if (order.getGyssuotime() != null) {
			if (new Timestamp(System.currentTimeMillis()).getTime()
					- order.getGyssuotime().getTime() > 30 * 1000 * 60) {
				// order.setGyssuotime(null);
				order.setOperatingstate(0l);
				// order.setUserid(null);
				Server.getInstance().getAirService().updateOrderinfo(order);

				/*
				 * Orderinforc orderinforc = new Orderinforc();
				 * orderinforc.setCustomeruserid(getLoginUserId());
				 * orderinforc.setOrderinfoid(orderinfo.getId());
				 * orderinforc.setCreatetime(new
				 * Timestamp(System.currentTimeMillis()));
				 * orderinforc.setContent("系统自动解锁订单");
				 * orderinforc.setSuouserid(suouserid);
				 * Server.getInstance().getAirService().createOrderinforc(orderinforc);
				 */

				String loginname = Server.getInstance().getMemberService()
						.findCustomeruser(order.getUserid()).getLoginname();
				List<Passenger> listpa = Server.getInstance().getAirService()
						.findAllPassenger(
								"where 1=1 and " + Passenger.COL_orderid + " ="
										+ order.getId(), "", -1, 0);
				if (listpa.size() > 0) {

					for (int a = 0; a < listpa.size(); a++) {
						Orderinforc orderinforc = new Orderinforc();
						orderinforc.setCustomeruserid(getLoginUserId());
						orderinforc.setOrderinfoid(order.getId());
						orderinforc.setCreatetime(new Timestamp(System
								.currentTimeMillis()));
						orderinforc.setContent("系统自动解锁订单");
						orderinforc.setSuouserid(order.getUserid());
						// orderinforc.setState(listpa.get(a).getState());
						orderinforc.setPassid(listpa.get(a).getId());
						orderinforc.setCustomeruserid(order.getUserid());
						Server.getInstance().getAirService().createOrderinforc(
								orderinforc);
					}
				}

				return 1;
			} else {
				return 2;
			}

		} else {
			return 0;
		}

	}

	private List<Passenger> getPassengerListByOrderiId(long orderid) {
		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(
						"where " + Passenger.COL_orderid + "="
								+ orderinfo.getId() + " AND C_STATE<>12", "",
						-1, 0);
		return listpassenger;
	}

	/**
	 * 订单状态修改==供应商
	 */
	public String editorderstatus() throws Exception {
		Orderinfo orderinfoold = Server.getInstance().getAirService()
		.findOrderinfo(orderinfo.getId());
		// 乘机人票状态 0=未出票 1=已出票 2=已废票
		// 3=已退票4=申请退票5=申请废票6=申请改签7=退票失败8=废票失败9=改签成功10=改签失败11已取消
		// 订单状态 1:等待支付;2 等待出票;3
		// 出票完成";4申请退票";5申请废票";6取消订单";7废票不成功";8审核失败";9废票退款成功";10 订单完成";11已经废票";
		// 12已经退票";13申请改签";14已经改签";15改签失败";16暂不能出票";17退票不成功";18退票退款成功";19问题订单";23申请升舱";24已换开";25升舱换开成功";
		// 26升舱失败";27待确认";28在途订单";29待收银";30申请换开";
		System.out.println(this.tui_iscabinsite);

		String strOptdesc = "";
		System.out.println(orderinfo.getOrderstatus());
		if (orderinfo.getOrderstatus() == 2) {// 支付
			orderinfo.setPaystatus(1);
			strOptdesc = "等待出票-" + getLoginUser().getMembername()
					+ "执行了等待出票，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
		}
		if (orderinfo.getOrderstatus() == 28) {// 待配送

			orderinfo.setOrderstatus(28);
			strOptdesc = "在途订单-" + getLoginUser().getMembername()
					+ "执行了操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
		}
		if (orderinfo.getOrderstatus() == 29) {// 待收款

			orderinfo.setOrderstatus(29);

			strOptdesc = "待收银-" + getLoginUser().getMembername()
					+ "执行了操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
		}
		if (orderinfo.getOrderstatus() == 30) {
			// 申请换开操作--twocold
			Orderinfo neworder = new Orderinfo();
			Passenger passenger = new Passenger();
			if (strNewTicketNum != null && strNewTicketNum.trim().length() > 0) {
				String where = " WHERE " + Passenger.COL_ticketnum + "='"
						+ strNewTicketNum + "'";
				List<Passenger> orders = Server.getInstance().getAirService()
						.findAllPassenger(where, "", -1, 0);
				if (orders.size() > 0) {
					passenger = orders.get(0);
					neworder = Server.getInstance().getAirService()
							.findOrderinfo(passenger.getOrderid());
					if (neworder != null)
						orderinfo.setNewordernum(neworder.getOrdernumber());
				}
			} else if (strSepPNR != null && strSepPNR.trim().length() > 0) {
				String where = " WHERE " + Orderinfo.COL_pnr + "='" + strSepPNR
						+ "' OR C_BIGPNR ='" + strSepPNR + "'";
				List<Orderinfo> orders = Server.getInstance().getAirService()
						.findAllOrderinfo(where, "", -1, 0);
				if (orders.size() > 0) {
					neworder = orders.get(0);
					// orderinfo.setNewordernum(neworder.getOrdernumber());
				}
			}
			// System.out.println(orderinfo.getFkmethod());
			orderinfo.setNewordernum(neworder.getOrdernumber());
			String pnr = neworder.getPnr() != null
					&& neworder.getPnr().trim().length() > 0 ? neworder
					.getPnr() : neworder.getBigpnr();
			orderinfo.setNewpnr(pnr);
			orderinfo.setNewticnum(passenger.getTicketnum());
			orderinfo.setOrderstatus(30);
			// System.out.println(neworder.getId());
			orderinfo.setRelationorderid(neworder.getId());
			// orderinfo.setNewordernum(newordernum);
			strOptdesc = "申请换开-" + getLoginUser().getMembername()
					+ "执行了操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
			// 如果是升舱补差订单，自动添加备注
			if (getisshengcang(orderinfo.getId()) == 1) {
				strOptdesc += "<br /><font style='color:red'><b>此订单为升舱补差订单，原票号："
						+ getshengcangtn(orderinfo.getId()) + "</b></font>";
			}
		}
		if (orderinfo.getOrderstatus() == 24) {// 换开审核通过

			orderinfo.setOrderstatus(24);
			strOptdesc = "换开审核通过-" + getLoginUser().getMembername()
					+ "执行了操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
		}
		if (orderinfo.getOrderstatus() == 9) {// 废票退款
			for (Passenger p : this.getPassengerListByOrderiId(orderinfo
					.getId())) {
				p.setState(16);
				Server.getInstance().getAirService().updatePassenger(p);
			}
			strOptdesc = "废票退款成功-" + getLoginUser().getMembername()
					+ "执行了操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />退款信息：" + strTuikuanDesc + "(应退款)";
		}
		if (orderinfo.getOrderstatus() == 18) {// 退票退款
			strOptdesc = "退票退款成功--" + getLoginUser().getMembername()
					+ "执行了操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />退款信息：" + strTuikuanDesc + "(应退款)";
			for (Passenger p : this.getPassengerListByOrderiId(orderinfo
					.getId())) {
				p.setState(17);
				Server.getInstance().getAirService().updatePassenger(p);
			}
		}
		if (orderinfo.getOrderstatus() == 4) // 申请退票
		{
			strOptdesc = "申请退票-" + getLoginUser().getMembername()
					+ "执行了申请退票，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());

		}
		if (orderinfo.getOrderstatus() == 16) // 暂不能出票
		{
			strOptdesc = "暂不能出票-" + getLoginUser().getMembername()
					+ "执行了暂不能出票，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
		}
		if (orderinfo.getOrderstatus() == 3) {// 出票
			strOptdesc = "立即出票-" + getLoginUser().getMembername()
					+ "执行了出票操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
			orderinfo.setPrinttime(new Timestamp(System.currentTimeMillis()));
			// 调用飞友短信接口给乘机人和街机人定制短信
			// 取得行程信息
			String Flightdate = "";
			String Fno = "";
			String Dep = "";
			String Arr = "";
			String Pname = "";
			String strallPassenger = "乘机人信息：";
			List<Segmentinfo> listsegmentinfo = Server.getInstance()
					.getAirService().findAllSegmentinfo(
							"where " + Segmentinfo.COL_orderid + "="
									+ orderinfo.getId(), "", -1, 0);
			if (listsegmentinfo.size() > 0) {
				Flightdate = formatTimestamp2(listsegmentinfo.get(0)
						.getDeparttime());
				Fno = listsegmentinfo.get(0).getFlightnumber();
				Dep = listsegmentinfo.get(0).getStartairport();
				Arr = listsegmentinfo.get(0).getEndairport();
				
				// 发送接机人短信
				if (orderinfoold.getPickonephone() != null
						&& !orderinfoold.getPickonephone().equals("")) {
					// Server.getInstance().getAtomService().sendFeiyouSms(
					// orderinfoold.getPickonephone(), Flightdate, Fno,
					// Dep, Arr, orderinfoold.getPickonename(), "1",
					// orderinfoold.getOrdernumber());
				}
				// 取得乘机人信息
				List<Passenger> listpassenger = Server.getInstance()
						.getAirService().findAllPassenger(
								"where " + Passenger.COL_orderid + "="
										+ orderinfo.getId(), "", -1, 0);
				if (listpassenger.size() > 0) {
					for (int i = 0; i < listpassenger.size(); i++) {
						try {
							Pname = listpassenger.get(i).getName();
							strallPassenger += Pname + ""
									+ listpassenger.get(i).getIdnumber() + ",";
							// 发送乘机人短信

							// Server.getInstance().getAtomService()
							// .sendFeiyouSms(
							// orderinfoold.getContactmobile(),
							// Flightdate, Fno, Dep, Arr, Pname,
							// "0", orderinfoold.getOrdernumber());
						} catch (Exception ex) {
						}
					}
				}
				String smstemple = "";
				// 发送出票短信
				try {
					smstemple = this.getSMSTemple("AOrderInform");
					smstemple = smstemple.replaceAll("@aircompanyto@", this
							.getAircomapnycodeByEZM(listsegmentinfo.get(0)
									.getAircomapnycode()));
					smstemple = smstemple.replaceAll("@airlineto@",
							listsegmentinfo.get(0).getFlightnumber());
					smstemple = smstemple.replaceAll("@startcityto@",
							getAirportbySZM(listsegmentinfo.get(0)
									.getStartairport()));
					smstemple = smstemple.replaceAll("@endcityto@",
							getAirportbySZM(listsegmentinfo.get(0)
									.getEndairport()));
					if (listsegmentinfo.get(0).getBorderpointat() != null) {
						smstemple = smstemple.replaceAll("@startcityloginto@",
								listsegmentinfo.get(0).getBorderpointat());
					} else {
						smstemple = smstemple.replaceAll("@startcityloginto@",
								"");
					}
					smstemple = smstemple.replaceAll("@starttimeto@",
							formatTimestamp2(listsegmentinfo.get(0)
									.getDeparttime())
									+ " "
									+ formatTimestamp3(listsegmentinfo.get(0)
											.getDeparttime()));
					smstemple = smstemple.replaceAll("@endtimeto@",
							formatTimestamp3(listsegmentinfo.get(0)
									.getArrivaltime()));
					smstemple = smstemple.replaceAll("@allpassenger@",
							strallPassenger);
					System.out.println(smstemple);
					// 发送短信
					String[] mobiles = {};
					mobiles = new String[] { ""
							+ orderinfoold.getContactmobile() + "" };
					Server.getInstance().getAtomService().sendSms(mobiles,
							smstemple, orderinfoold.getOrdernumber(), "");
				} catch (Exception ex) {

				}
			}
		}
		if (orderinfo.getOrderstatus() == 6) {// 取消订单

			orderinfo.setQuxiaotime(new Timestamp(System.currentTimeMillis()));
			strOptdesc = "取消订单-" + getLoginUser().getMembername()
					+ "执行了取消订单，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());

		}
		orderinfo.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		// 如果是收银操作，如果有个人挂账情况
		if (orderinfo.getOrderstatus() == 10) {
			orderinfo.setCashier(1);// 已收银
			if (orderinfo.getFkmethod() > 0) {
				if (orderinfo.getFkmethod() == 7) {// 个人挂账
					orderinfo.setGuazhangrenid(s_employeeid);
					// 插入个人挂账记录
					Gerenguazhanfrec gerenguazhang = new Gerenguazhanfrec();
					gerenguazhang.setOrderid(orderinfo.getId());
					gerenguazhang.setEmployeeid(s_employeeid);
					gerenguazhang.setState(0l);
					gerenguazhang.setCreatetime(new Timestamp(System
							.currentTimeMillis()));
					gerenguazhang.setCreateuser(getLoginUserId() + "");
					Server.getInstance().getMemberService()
							.createGerenguazhanfrec(gerenguazhang);
				} else if (orderinfo.getFkmethod() != 7
						&& orderinfo.getFkmethod() != 8) {// 7,个人挂账，8， 月结挂账

					for (Passenger passenger : this
							.getPassengerListByOrderiId(orderinfo.getId())) {
						float allprice = converNull(passenger.getPrice(), 0f)
								+ converNull(passenger.getFuelprice(), 0f)
								+ converNull(passenger.getAirportfee(), 0f)+passenger.getInsurprice();
						allprice += converNull(orderinfo.getPostmoney(), 0);
						String sql = " UPDATE T_PASSENGER SET C_HKSTATE=2,C_YIHAI="
								+ allprice
								+ ",C_HAIQIAN=0 WHERE C_ORDERID="
								+ orderinfo.getId();
						Server.getInstance().getSystemService()
								.findMapResultBySql(sql, null);
					}
				}
				Orderinfo currentorderinfo = Server.getInstance()
						.getAirService().findOrderinfo(orderinfo.getId());
				if (converNull(currentorderinfo.getReceipt(), -1) == 4
						|| converNull(currentorderinfo.getReceipt(), -1) == 5) {
					orderinfo.setPeisongstatus(2l);

				}
			}

		}

		//
		/*
		 * String loginname=
		 * Server.getInstance().getMemberService().findCustomeruser(orderinfo.getUserid()).getLoginname();
		 * Orderinforc orderinforc = new Orderinforc();
		 * orderinforc.setCustomeruserid(getLoginUserId());
		 * orderinforc.setOrderinfoid(orderinfo.getId());
		 * orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		 * orderinforc.setContent("会员:"+loginname+"锁定订单");
		 * orderinforc.setSuouserid(orderinfo.getUserid());
		 * Server.getInstance().getAirService().createOrderinforc(orderinforc);
		 */
		//
		if (no == 2) {
			if (beizhu != null && beizhu.trim().length() > 0) {
				String expr = new String(beizhu.getBytes("ISO-8859-1"), "UTF-8");
				beizhu = expr;
			}
			if (tui_tuifeidesc != null && tui_tuifeidesc.trim().length() > 0) {
				String tuifeidesc = new String(tui_tuifeidesc
						.getBytes("ISO-8859-1"), "UTF-8");
				tui_tuifeidesc = tuifeidesc;
			}
			if (tui_nodesc != null && tui_nodesc.trim().length() > 0) {
				String nodesc = new String(tui_nodesc.getBytes("ISO-8859-1"),
						"UTF-8");
				tui_nodesc = nodesc;
			}

			/*
			 * String bei = encoder(beizhu);
			 * beizhu=java.net.URLDecoder.decode(bei,"UTF-8");
			 */
		}
		if (orderinfo.getOrderstatus() == 3) {// 出票
			String sql = " update " + Passenger.TABLE + " set "
					+ Passenger.COL_state + " =1," + Passenger.COL_rttime
					+ " ='" + new Timestamp(System.currentTimeMillis())
					+ "' where " + Passenger.COL_orderid + " ="
					+ orderinfo.getId();
			Server.getInstance().getAirService().excutePassengerBySql(sql);
			strOptdesc = "出票-" + getLoginUser().getMembername()
					+ "执行了出票操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
		}
		if (orderinfo.getOrderstatus() == 6) {// 取消订单
			String sql = " update " + Passenger.TABLE + " set "
					+ Passenger.COL_state + " =11  where "
					+ Passenger.COL_orderid + " =" + orderinfo.getId();
			Server.getInstance().getAirService().excutePassengerBySql(sql);
			strOptdesc = "取消订单-" + getLoginUser().getMembername()
					+ "执行了取消订单，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
		}

		if (orderinfo.getOrderstatus() == 11) {// 废票
			/*
			 * String sql =" update "+Passenger.TABLE+" set
			 * "+Passenger.COL_state+" =2,"+Passenger.COL_tuitime+" ='"+new
			 * Timestamp(System.currentTimeMillis())+"' where
			 * "+Passenger.COL_orderid+" ="+orderinfo.getId();
			 * Server.getInstance().getAirService().excutePassengerBySql(sql);
			 */
			String[] passenger = passid.split(",");
			if (passenger.toString().trim().length() > 0) {

				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(2);
					pa.setBeizhu(beizhu);
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}
			strOptdesc = "废票审核通过-" + getLoginUser().getMembername()
					+ "执行了废票操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />废票备注：" + beizhu;
		}
		if (orderinfo.getOrderstatus() == 12) {// 退票
			strOptdesc = "退票审核通过-" + getLoginUser().getMembername()
					+ "执行了退票操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());
			String[] passenger = passid.split(",");
			if (passenger.toString().trim().length() > 0) {

				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(3);
					pa.setBeizhu(beizhu);
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}
			strOptdesc = "退票-" + getLoginUser().getMembername()
					+ "执行了退票操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />退票备注：" + beizhu;
		}
		// 改签
		if (orderinfo.getOrderstatus() == 13) {
			String[] passenger = passid.split(",");
			if (passenger.toString().trim().length() > 0) {

				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(6);// 申请改签
					pa.setTuifee(Float.parseFloat(tui));
					pa.setTuiorfei(0l);
					pa.setChangedate(changedate);
					pa.setChangeflight(changeflight);
					pa.setChangecabin(changecabin);
					pa.setChangepnr(changepnr);
					pa.setTuifeidesc(tui_tuifeidesc);
					pa.setTuifeiyuanyi(tui_state);
					pa.setIscabinsite(tui_iscabinsite);
					pa.setTuifeitime(new Timestamp(System.currentTimeMillis()));
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}
			strOptdesc = "改签-" + getLoginUser().getMembername()
					+ "执行了改签操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />改签备注：" + tui_tuifeidesc;
		}
		// 申请升舱换开
		if (orderinfo.getOrderstatus() == 30) {
			String[] passenger = passid.split(",");
			if (passenger.toString().trim().length() > 0) {

				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(13);// 申请升舱换开
					pa.setTuifee(Float.parseFloat(tui));
					pa.setTuiorfei(0l);
					pa.setChangedate(changedate);
					pa.setChangeflight(changeflight);
					pa.setChangecabin(changecabin);
					pa.setChangepnr(changepnr);
					pa.setTuifeidesc(tui_tuifeidesc);
					pa.setTuifeiyuanyi(tui_state);
					pa.setIscabinsite(tui_iscabinsite);
					pa.setTuifeitime(new Timestamp(System.currentTimeMillis()));
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}

			strOptdesc = "申请升舱换开-" + getLoginUser().getMembername()
					+ "执行了申请升舱换开操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />申请升舱换开备注：" + tui_tuifeidesc;
			// 如果是升舱补差订单，自动添加备注
			if (getisshengcang(orderinfo.getId()) == 1) {
				strOptdesc += "<br /><font style='color:red'><b>此订单为升舱补差订单，原票号："
						+ getshengcangtn(orderinfo.getId()) + "</b></font>";
			}
		}
		if (orderinfo.getOrderstatus() == 4) {// 申请退票的乘机人
			String[] passenger = passid.split(",");
			if (passenger.toString().trim().length() > 0) {

				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(4);
					pa.setTuifee(Float.parseFloat(tui));
					pa.setTuiorfei(0l);
					pa.setTuifeidesc(tui_tuifeidesc);
					pa.setTuifeiyuanyi(tui_state);
					pa.setIscabinsite(tui_iscabinsite);
					pa.setTuifeitime(new Timestamp(System.currentTimeMillis()));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}

			strOptdesc = "申请退票-" + getLoginUser().getMembername()
					+ "执行了申请退票操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />申请退票备注：" + tui_tuifeidesc;
			// 如果是升舱补差订单，自动添加备注
			if (getisshengcang(orderinfo.getId()) == 1) {
				strOptdesc += "<br /><font style='color:red'><b>此订单为升舱补差订单，原票号："
						+ getshengcangtn(orderinfo.getId()) + "</b></font>";
			}
		}

		if (orderinfo.getOrderstatus() == 5) {// 申请废票的乘机人
			/*
			 * String sql =" update "+Passenger.TABLE+" set
			 * "+Passenger.COL_state+" =2,"+Passenger.COL_tuitime+" ='"+new
			 * Timestamp(System.currentTimeMillis())+"' where
			 * "+Passenger.COL_orderid+" ="+orderinfo.getId();
			 * Server.getInstance().getAirService().excutePassengerBySql(sql);
			 */
			String[] passenger = passid.split(",");
			if (passenger.toString().trim().length() > 0) {

				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(5);
					pa.setTuiorfei(1l);
					pa.setTuifeidesc(tui_tuifeidesc);
					pa.setTuifeiyuanyi(tui_state);
					pa.setIscabinsite(tui_iscabinsite);
					pa.setTuifeitime(new Timestamp(System.currentTimeMillis()));
					pa.setTuifee(Float.parseFloat(this.converTrim(tui, "0")));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}
			strOptdesc = "申请废票-" + getLoginUser().getMembername()
					+ "执行了申请废票操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />申请废票备注：" + tui_tuifeidesc;
			// 如果是升舱补差订单，自动添加备注
			if (getisshengcang(orderinfo.getId()) == 1) {
				strOptdesc += "<br /><font style='color:red'><b>此订单为升舱补差订单，原票号："
						+ getshengcangtn(orderinfo.getId()) + "</b></font>";
			}
		}

		if (orderinfo.getOrderstatus() == 17) {// 退票不通过
			String[] passenger = passid.split(",");
			if (passenger.toString().trim().length() > 0) {
				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(7);
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					pa.setBeizhu(beizhu);
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}
			strOptdesc = "退票审核不通过-" + getLoginUser().getMembername()
					+ "执行了退票审核不通过，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br>退票审核不通过备注：" + beizhu;
			/*
			 * String sql =" update "+Passenger.TABLE+" set
			 * "+Passenger.COL_state+" =3,"+Passenger.COL_tuipiaoshouxufee+"
			 * ='"+Float.parseFloat(tui)+"',"+Passenger.COL_tuitime+" ='"+new
			 * Timestamp(System.currentTimeMillis())+"' where
			 * "+Passenger.COL_orderid+" ="+orderinfo.getId();
			 * Server.getInstance().getAirService().excutePassengerBySql(sql);
			 */
		}
		if (orderinfo.getOrderstatus() == 7) {// 废票不通过
			String[] passenger = passid.split(",");
			if (passenger.toString().trim().length() > 0) {

				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(1);
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					pa.setBeizhu(beizhu);
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}

			strOptdesc = "废票审核不通过-" + getLoginUser().getMembername()
					+ "执行了废票审核不通过，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br>废票审核不通过备注：" + beizhu;
		}
		String strbeizhudesc = "";
		if (orderinfo.getOrderstatus() == 14) {// 改签通过
			
			// 改签通过将改签的信息更新到行程信息中
			List<Segmentinfo> listsegmeng = Server.getInstance()
					.getAirService().findAllSegmentinfo(
							" where " + Segmentinfo.COL_orderid + "="
									+ orderinfo.getId(), "", -1, 0);
			
			String strgaiqiancabin = getgaiqiancabin(orderinfo.getId());
			String strgaiqiandate = getgaiqiandate(orderinfo.getId());
			String strgaiqianfnumber = getgaiqianfnumber(orderinfo.getId());
			String pname="";
			String[] passenger = passid.split(",");
			if (passenger.toString().trim().length() > 0) {
				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(9);
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));

					try {
						strbeizhudesc += "<br /><font color='red'><b>改签信息：";
						String stroldcabin = "";
						String strolddate = "";
						String stroldfnumber = "";

						stroldcabin = getxingchenginfo(orderinfo.getId())
								.getCabincode();
						strolddate = formatTimestampHHmm2(getxingchenginfo(
								orderinfo.getId()).getDeparttime());
						stroldfnumber = getxingchenginfo(orderinfo.getId())
								.getFlightnumber();
						if (!strgaiqiancabin.equals("")) {
							strbeizhudesc += " 舱位从" + stroldcabin + "改签到"
									+ strgaiqiancabin + "舱";
						}
						if (!strgaiqiandate.equals("")) {
							strbeizhudesc += " 起飞时间从" + strolddate + "改签到"
									+ strgaiqiandate + " ";
						}
						if (!strgaiqianfnumber.equals("")) {
							strbeizhudesc += " 航班号从" + stroldfnumber + "改签到"
									+ strgaiqianfnumber + " ";
						}
						strbeizhudesc += "</b></font>";

					} catch (Exception ex) {

					}
					pa.setBeizhu(beizhu + "" + strbeizhudesc);
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
					pname+=pa.getName()+",";
				}
				
				if (listsegmeng.size() > 0) {
					if (strgaiqiancabin != null && !strgaiqiancabin.equals("")) {
						listsegmeng.get(0).setCabincode(
								getgaiqiancabin(orderinfo.getId()));
					}
					if (strgaiqiandate != null && !strgaiqiandate.equals("")) {
						listsegmeng.get(0).setDeparttime(
								dateToTimestamp(strgaiqiandate));
					}
					if (strgaiqianfnumber != null
							&& !strgaiqianfnumber.equals("")) {
						listsegmeng.get(0).setFlightnumber(strgaiqianfnumber);
					}
					Server.getInstance().getAirService().updateSegmentinfo(
							listsegmeng.get(0));
				}

			}

			strOptdesc = "已经改签-" + getLoginUser().getMembername()
					+ "执行了已经改签操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />改签审核通过备注：" + beizhu + " " + strbeizhudesc;
			
			String hangcheng=getCitynameByAirport(listsegmeng.get(0).getStartairport())+getCitynameByAirport(listsegmeng.get(0).getEndairport());//行程
			
			DateFormat datetimeformatHHMM = new SimpleDateFormat("HH:mm");
			String endtime=datetimeformatHHMM.format(listsegmeng.get(0).getArrivaltime());//到达时间
			
			String content="尊敬的客户:"+pname+"你好! "+listsegmeng.get(0).getDeparttime()+"，"+hangcheng+" "+strgaiqianfnumber+"航班，"+strgaiqiandate+"起飞-"+endtime+"到达，客票已成功改签，祝您旅途愉快!客服电话:4000175778【七星票务】";
			
			SendSms(orderinfoold.getContactmobile(), content, orderinfoold.getId()+"");
			
			
		}
		if (orderinfo.getOrderstatus() == 25) {// 升舱换开通过
			String[] passenger = passid.split(",");
			if (passenger.toString().trim().length() > 0) {

				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(14);
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					pa.setBeizhu(beizhu);
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}
			strOptdesc = "已升舱换开-" + getLoginUser().getMembername()
					+ "执行了已升舱换开操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br />升舱换开审核通过备注：" + beizhu;
		}

		if (orderinfo.getOrderstatus() == 26) {// 升舱换开不通过
			String[] passenger = passid.split(",");
			if (passenger.toString().trim().length() > 0) {
				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(15); // 换开不通过
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					pa.setBeizhu(beizhu);
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}
			strOptdesc = "改签不通过-" + getLoginUser().getMembername()
					+ "执行了改签不通过操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br>改签审核不通过备注：" + beizhu;
		}
		if (orderinfo.getOrderstatus() == 15) {// 改签不通过
			String[] passenger = passid.split(",");
			if (passenger.toString().trim().length() > 0) {
				for (int a = 0; a < passenger.length; a++) {
					long paid = Long.parseLong(passenger[a]);
					Passenger pa = Server.getInstance().getAirService()
							.findPassenger(paid);
					pa.setState(10);
					// pa.setTuifee(Float.parseFloat(tui));
					pa.setTuitime(new Timestamp(System.currentTimeMillis()));
					pa.setBeizhu(beizhu);
					Server.getInstance().getAirService()
							.updatePassengerIgnoreNull(pa);
				}
			}
			strOptdesc = "改签不通过-" + getLoginUser().getMembername()
					+ "执行了改签不通过操作，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus())
					+ "<br>改签审核不通过备注：" + beizhu;
		}
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);

		String loginname = Server.getInstance().getMemberService()
				.findCustomeruser(getLoginUser().getId()).getLoginname();
		List<Passenger> listpa = Server.getInstance().getAirService()
				.findAllPassenger(
						"where 1=1 and " + Passenger.COL_orderid + " ="
								+ orderinfo.getId(), "", -1, 0);

		Orderinforc orderinforc = new Orderinforc();
		orderinforc.setCustomeruserid(getLoginUserId());
		orderinforc.setOrderinfoid(orderinfo.getId());
		orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		orderinforc.setContent(strOptdesc);
		orderinforc.setSuouserid(orderinfo.getUserid());
		orderinforc.setState(orderinfo.getOrderstatus());
		orderinforc.setCustomeruserid(getLoginUserId());
		Server.getInstance().getAirService().createOrderinforc(orderinforc);
		// System.out.println(rc.getId());

		// 获取前一页面路径

		forward = ServletActionContext.getRequest().getHeader("Referer");
		if (orderinfo.getOrderstatus() == 29
				|| orderinfo.getOrderstatus() == 10) {
			orderinfo = Server.getInstance().getAirService().findOrderinfo(
					orderinfo.getId());

		}
		if (orderinfo.getOrderstatus() == 29) {
			if (forward.indexOf("s_orderstatus") >= 0) {
				forward = forward.replace("s_orderstatus",
						"s_orderstatus=29&s_ordernumber="
								+ orderinfo.getOrdernumber() + "&a");
			} else {
				if (forward.indexOf("?") > 0) {
					forward += "&s_ordernumber=" + orderinfo.getOrdernumber();
				} else {
					forward += "?s_ordernumber=" + orderinfo.getOrdernumber();
				}
			}
		} else if (orderinfo.getOrderstatus() == 10) {
			forward = forward.replace("s_orderstatus", "s_cashier=1&a");
			if (!(forward.indexOf("s_ordernumber") >= 0)) {
				if (forward.indexOf("?") > 0) {
					forward += "&s_ordernumber=" + orderinfo.getOrdernumber();
				} else {
					forward += "?s_ordernumber=" + orderinfo.getOrdernumber();
				}
			}
		}
		int status = orderinfo.getOrderstatus();
		if (status == 7 || status == 17 || status == 15 || status == 26) {
			this.resetOrderinfo(orderinfo, passid.split(","));
		}
		return "editorderstatus";

	}

	private void resetOrderinfo(Orderinfo orderinfo, String[] pids) {
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());
		String pid = "0";
		for (String pi : pids) {
			pid += "," + pi;
		}
		String where = " WHERE C_ORDERINFOID=" + orderinfo.getId()
				+ " AND C_STATE=10 ";
		List<Orderinforc> rcs = Server.getInstance().getAirService()
				.findAllOrderinforc(where, "", -1, 0);
		if (rcs.size() > 0) {
			orderinfo.setOrderstatus(10);

		} else if (orderinfo.getReceipt() != null
				&& orderinfo.getReceipt() == 4) {
			orderinfo.setOrderstatus(3);
		} else if (orderinfo.getCashier() == null
				|| orderinfo.getCashier() == 0) {
			orderinfo.setOrderstatus(29);
		}

		String sql = "UPDATE T_PASSENGER SET C_STATE=1 WHERE ID IN (" + pid
				+ ")";
		Server.getInstance().getSystemService().findMapResultBySql(sql, null);
		sql = " UPDATE T_ORDERINFO SET C_ORDERSTATUS="
				+ orderinfo.getOrderstatus() + " WHERE ID=" + orderinfo.getId();
		Server.getInstance().getSystemService().findMapResultBySql(sql, null);
	}

	// 取得是否是升舱补差订单标识
	public long getisshengcang(long id) {
		long lisshengcang = 0;
		try {
			Orderinfo temporder = Server.getInstance().getAirService()
					.findOrderinfo(orderinfo.getId());
			if (temporder.getIsshengcang() == 1) {
				lisshengcang = 1l;
			} else {
				lisshengcang = 0l;
			}
		} catch (Exception ex) {

		}
		return lisshengcang;
	}

	// 取得升舱补差前票号
	public String getshengcangtn(long id) {
		String strshengcangoldtn = "";
		Orderinfo temporder = Server.getInstance().getAirService()
				.findOrderinfo(orderinfo.getId());
		if (!temporder.getShengcangoldtn().equals("")) {
			strshengcangoldtn = temporder.getShengcangoldtn();
		}

		return strshengcangoldtn;
	}

	// 取得改签舱位
	public String getgaiqiancabin(long id) {
		String strcabincode = "";
		List<Passenger> tempass = Server.getInstance().getAirService()
				.findAllPassenger("where " + Passenger.COL_orderid + "=" + id,
						"", -1, 0);
		if (tempass.size() > 0) {
			strcabincode = tempass.get(0).getChangecabin();
		}

		return strcabincode;
	}

	// 取得改签日期
	public String getgaiqiandate(long id) {
		String strdate = "";
		List<Passenger> tempass = Server.getInstance().getAirService()
				.findAllPassenger("where " + Passenger.COL_orderid + "=" + id,
						"", -1, 0);
		if (tempass.size() > 0) {
			strdate = tempass.get(0).getChangedate();
		}

		return strdate;
	}

	// 取得改签航班号
	public String getgaiqianfnumber(long id) {
		String strnumber = "";
		List<Passenger> tempass = Server.getInstance().getAirService()
				.findAllPassenger("where " + Passenger.COL_orderid + "=" + id,
						"", -1, 0);
		if (tempass.size() > 0) {
			strnumber = tempass.get(0).getChangeflight();
		}

		return strnumber;
	}

	public Segmentinfo getxingchenginfo(long id) {
		Segmentinfo segment = new Segmentinfo();
		List<Segmentinfo> listsegmenginfo = Server.getInstance()
				.getAirService().findAllSegmentinfo(
						"where " + Segmentinfo.COL_orderid + "=" + id, "", -1,
						0);
		if (listsegmenginfo.size() > 0) {
			segment = listsegmenginfo.get(0);
		}
		return segment;
	}

	/**
	 * 订单状态修改_转向支付页面
	 */
	public String orderstatustozhifu() throws Exception {
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfo.getId());
		String where = "WHERE " + Passenger.COL_orderid + " = "
				+ orderinfo.getId();
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, "ORDER BY ID", -1, 0);
		String whereSeg = "WHERE " + Segmentinfo.COL_orderid + " = '"
				+ orderinfo.getId() + "'";
		listSegment = Server.getInstance().getAirService().findAllSegmentinfo(
				whereSeg, "ORDER BY ID", -1, 0);
		String strWhere = "WHERE " + Customeragent.COL_id + " = '"
				+ orderinfo.getBuyagentid() + "'";
		listAgent = (Customeragent) Server.getInstance().getMemberService()
				.findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0).get(0);

		String strWhereBuy = "WHERE " + Customeragent.COL_id + " = '"
				+ orderinfo.getSaleagentid() + "'";
		listGongAgent = (Customeragent) Server.getInstance().getMemberService()
				.findAllCustomeragent(strWhere, "ORDER BY ID", -1, 0).get(0);
		return "tozhifu";
	}

	/**
	 * 批量操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String batch() throws Exception {
		if (selectid != null && selectid.length > 0) {

			switch (opt) {
			case 1: // delete

				for (int i : selectid) {
					Server.getInstance().getAirService().deleteOrderinfo(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 根据订单ID获取行程数据
	 * 
	 * @param orderId
	 * @return
	 */
	public Segmentinfo getSegmentinfo(long orderId) {
		String where = "where " + Segmentinfo.COL_orderid + "=" + orderId;
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(where, "ORDER BY ID", -1, 0);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * 根据机场代码获取城市名称
	 * 
	 * @param airport
	 * @return
	 */
	public String getCitynameByAirport(String airport) {
		String where = "where " + Cityairport.COL_airportcode + "='" + airport
				+ "'";
		List<Cityairport> list = Server.getInstance().getAirService()
				.findAllCityairport(where, "ORDER BY ID", -1, 0);
		return list != null && list.size() > 0 ? list.get(0).getCityname() : "";

	}

	public String getPassengerName(Long orderid) {
		String html = "";

		List<Passenger> list = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE 1=1 AND " + Passenger.COL_state + "<>12 AND "
								+ Passenger.COL_orderid + "=" + orderid, "",
						-1, 0);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size() - 1; i++) {

				html += list.get(i).getName() + getInsurancestate(list.get(i))
						+ "<br/>";
			}
			html += list.get(list.size() - 1).getName() + ""
					+ getInsurancestate(list.get(list.size() - 1));
		}
		return html;
	}

	public String getSendImage(int orderstatus, int receit) {
		String html = "";
		if (orderstatus <= 3 && (receit == 4 || receit == 5)) {
			String path = ServletActionContext.getRequest().getContextPath();
			html = "<img style=\"text-align: center\" src='" + path
					+ "/images/send2.gif'/>";
		}
		return html;

	}

	private String getInsurancestate(Passenger p) {

			
		return "";
	}

	public String getEmployeeName(Long id) {
		String strEmployeeName = "";
		Customeruser customer = Server.getInstance().getMemberService()
				.findCustomeruser(id);
		if (customer != null) {
			strEmployeeName = customer.getMembername();
		}
		return strEmployeeName;
	}

	public int getPassengerNum(Long orderid) {
		int intcount = 0;
		List<Passenger> list = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE 1=1 AND " + Passenger.COL_state + "<>12 AND "
								+ Passenger.COL_orderid + "=" + orderid, "",
						-1, 0);
		intcount = list.size();
		return intcount;
	}

	public String getPassengersizi(Long orderid) {
		String html = "";
		List<Passenger> list = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE 1=1 AND " + Passenger.COL_orderid + "="
								+ orderid, "", -1, 0);
		if (list != null && list.size() > 0) {
			html = list.size() + "";
		}
		return html;
	}

	public String getPassengerFEThtml(Long orderid) {
		String html = "";
		List<Passenger> list = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE 1=1 AND " + Passenger.COL_orderid + "="
								+ orderid, "", -1, 0);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size() - 1; i++) {
				html += list.get(i).getFet() + "<br/>";
			}
			html += list.get(list.size() - 1).getFet();
		}
		return html;
	}

	/**
	 * 通过pnr跳转到预订页面
	 * 
	 * @param pnr
	 * @return
	 */
	private long linkid = 0;
public List editPNRTXT_new(String pnrtxt){
		
	List pnrlist= new ArrayList<String>();
		
	
	
	String pnr="";
	String pnrtxtinfo="";
	String patinfo="";
	
	
	
	String[] pnrinfos=pnrtxt.split(">");
	
	 Pattern pattern = Pattern.compile("[\\r\\n]");
	 String[] strReturnarr=pattern.split(pnrinfos[0]);
	 String [] strReturnarr2=strReturnarr[0].split(" ");
	 
	
	 for(int a=0;a<strReturnarr.length;a++){
		// [a-zA-Z0-9]{4}
		    String regEx = "[\\s]{1}[a-zA-Z0-9]{6}[\\s]{1,2}";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(strReturnarr[a]);
			if(m.find()){
				System.out.println("PNR:"+m.group().toString());
				pnr=m.group().toString();
				break;
			}
		 
	 }
	
	
	
	
	pnrlist.add(pnr);
	pnrlist.add(pnrinfos[0]);
	pnrlist.add(pnrinfos[1]);
		
		return pnrlist;
	}
	
	public List editPNRTXT(String pnrtxt){
		
		List pnrlist= new ArrayList<String>();
		
	String subrt="rt";
	String subpat="pat:a";
	if(pnrtxt.indexOf("RT")!=-1){
		
		subrt="RT";
	}
	if(pnrtxt.indexOf("rt")!=-1){
		
		subrt="rt";
	}
	
	if(pnrtxt.indexOf("rT")!=-1){
		
		subrt="rT";
	}
	if(pnrtxt.indexOf("Rt")!=-1){
		
		subrt="Rt";
	}
	if(pnrtxt.indexOf("PAT:A")!=-1){
		subpat="PAT:A";
	}
	if(pnrtxt.indexOf("pat:a")!=-1){
		subpat="pat:a";
	}
	if(pnrtxt.indexOf("pat:A")!=-1){
		subpat="pat:A";
	}
	
	if(pnrtxt.indexOf("PAT:a")!=-1){
		subpat="PAT:a";
	}
	if(pnrtxt.indexOf("Pat:a")!=-1){
		subpat="Pat:a";
	}
	if(pnrtxt.indexOf("Pat:A")!=-1){
		subpat="Pat:A";
	}
	if(pnrtxt.indexOf("pAT:A")!=-1){
		subpat="pAT:A";
	}
	if(pnrtxt.indexOf("pAT:a")!=-1){
		subpat="pAT:a";
	}
	
	if(pnrtxt.indexOf("paT:a")!=-1){
		subpat="paT:a";
	}
	if(pnrtxt.indexOf("paT:A")!=-1){
		subpat="paT:A";
	}
	
	if(pnrtxt.indexOf("PaT:A")!=-1){
		subpat="PaT:A";
	}
	if(pnrtxt.indexOf("PaT:a")!=-1){
		subpat="PaT:a";
	}
	
	
	String pnr="";
	//String pnr=	pnrtxt.split("1[.]")[0].trim().split(subrt)[1].trim();
	
	String pnrs=pnrtxt.split("1[.]")[0].trim();
	
	String[] sub=pnrs.split(" ");
	if(sub.length>0){
		for(int s=0;s<sub.length;s++){
			if(sub[s]!=null&&sub[s].length()>0&&sub[s].length()==6){
				pnr=sub[s].trim();
			}
		}
	}
	
	if(pnr==null||pnr.length()==0||pnr.equals("")){
		pnr=pnrtxt.split("1[.]")[0].trim().split(subrt)[1].trim();
	}
	
	
	String pnrtxtinfo=	pnrtxt.split(subpat)[0].trim().replace(subrt+pnr, "").trim();
	
	
	      // pnrtxtinfo=	pnrtxt.split(subpat)[0].trim().replaceFirst(subrt, "");
	
	     //  pnrtxtinfo=	pnrtxt.split(subpat)[0].trim().replaceFirst(pnr, "");
	if(pnrtxtinfo.indexOf(subrt)!=-1){
	 pnrtxtinfo=	pnrtxtinfo.replaceFirst(subrt, "").trim();
		
     pnrtxtinfo=	pnrtxtinfo.replaceFirst(pnr, "").trim();
	}
	//String pnrtxtinfo=	pnrtxt.split("1.")[1].trim().split(subpat)[0].trim();
	
	
	
	String patinfo=	pnrtxt.split(subpat)[1].trim();
	
	if(subpat.equals("PAT:A")){
		patinfo=patinfo+"PAT:A " +
				""+pnrtxt.split(subpat)[2].trim();
	}
	
	pnrlist.add(pnr);
	pnrlist.add(pnrtxtinfo);
	pnrlist.add(patinfo);
		
		return pnrlist;
	}
public List editPNRTXT2(String pnrtxt){
		
		List pnrlist= new ArrayList<String>();
		
	String subrt="rt";
	String subpat="pat:a";
	if(pnrtxt.indexOf("RT")!=-1){
		
		subrt="RT";
	}
	if(pnrtxt.indexOf("rt")!=-1){
		
		subrt="rt";
	}
	
	if(pnrtxt.indexOf("rT")!=-1){
		
		subrt="rT";
	}
	if(pnrtxt.indexOf("Rt")!=-1){
		
		subrt="Rt";
	}
	if(pnrtxt.indexOf("PAT:A")!=-1){
		subpat="PAT:A";
	}
	if(pnrtxt.indexOf("pat:a")!=-1){
		subpat="pat:a";
	}
	if(pnrtxt.indexOf("pat:A")!=-1){
		subpat="pat:A";
	}
	
	if(pnrtxt.indexOf("PAT:a")!=-1){
		subpat="PAT:a";
	}
	if(pnrtxt.indexOf("Pat:a")!=-1){
		subpat="Pat:a";
	}
	if(pnrtxt.indexOf("Pat:A")!=-1){
		subpat="Pat:A";
	}
	if(pnrtxt.indexOf("pAT:A")!=-1){
		subpat="pAT:A";
	}
	if(pnrtxt.indexOf("pAT:a")!=-1){
		subpat="pAT:a";
	}
	
	if(pnrtxt.indexOf("paT:a")!=-1){
		subpat="paT:a";
	}
	if(pnrtxt.indexOf("paT:A")!=-1){
		subpat="paT:A";
	}
	
	if(pnrtxt.indexOf("PaT:A")!=-1){
		subpat="PaT:A";
	}
	if(pnrtxt.indexOf("PaT:a")!=-1){
		subpat="PaT:a";
	}
	
	
	String pnr="";
	//String pnr=	pnrtxt.split("1[.]")[0].trim().split(subrt)[1].trim();
	
	String pnrs=pnrtxt.split("1[.]")[0].trim();
	
	String[] sub=pnrs.split(" ");
	if(sub.length>0){
		for(int s=0;s<sub.length;s++){
			if(sub[s]!=null&&sub[s].length()>0&&sub[s].length()==6){
				pnr=sub[s].trim();
			}
		}
	}
	
	if(pnr==null||pnr.length()==0||pnr.equals("")){
		pnr=pnrtxt.split("1[.]")[0].trim().split(subrt)[1].trim();
	}
	
	
	String pnrtxtinfo=	pnrtxt.split(subpat)[0].trim().replace(subrt+pnr, "").trim();
	
	
	      // pnrtxtinfo=	pnrtxt.split(subpat)[0].trim().replaceFirst(subrt, "");
	
	     //  pnrtxtinfo=	pnrtxt.split(subpat)[0].trim().replaceFirst(pnr, "");
	if(pnrtxtinfo.indexOf(subrt)!=-1){
	 pnrtxtinfo=	pnrtxtinfo.replaceFirst(subrt, "").trim();
		
     pnrtxtinfo=	pnrtxtinfo.replaceFirst(pnr, "").trim();
	}
	//String pnrtxtinfo=	pnrtxt.split("1.")[1].trim().split(subpat)[0].trim();
	
	
	
	String patinfo=	pnrtxt.split(subpat)[1].trim();
	
	if(subpat.equals("PAT:A")){
		patinfo=patinfo+"PAT:A " +
				""+pnrtxt.split(subpat)[2].trim();
	}
	
	pnrlist.add(pnr);
	pnrlist.add(pnrtxtinfo);
	pnrlist.add(patinfo);
		
		return pnrlist;
	}
public List editPNRTXT_PNR(String pnrtxt){
		
		List pnrlist= new ArrayList<String>();
		
	String subrt="RT";
	String subpat="PAT:A";
	
	String pnr=	strPNR.trim();
	String pnrtxtinfo=	pnrtxt.split(subpat)[0].trim().replace(subrt+pnr, "").trim();
	if(pnrtxtinfo.indexOf(subrt)!=-1){
	 pnrtxtinfo=	pnrtxtinfo.replaceFirst(subrt, "").trim();
		
     pnrtxtinfo=	pnrtxtinfo.replaceFirst(pnr, "").trim();
	}
	String patinfo=	"";
	if(pnrtxt.indexOf(subpat)!=-1){
	patinfo=pnrtxt.split(subpat)[1].trim();
	}
	
	pnrlist.add(pnr);
	pnrlist.add(pnrtxtinfo);
	pnrlist.add(patinfo);
		
		return pnrlist;
	}
	public String toCreateOrderByPnr() {

		
		//String sub=Server.getInstance().getTicketSearchService().commandFunction("RT"+strPNR+"", "");

		Customeragent customeragent= getLoginAgent();
		Customeruser customeruser= getLoginUser();
		s_agentid=customeragent.getId();
		s_userid=customeruser.getId();
		
		
		
		
		
		String strcmd="";
		String sub="";
		List list=new ArrayList<Object>();
		if(importtype.equals("1")){//PNR导入
		
			
			String PATinfo="PAT:A";
			sub=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strPNR+"$"+PATinfo+"", "", "");
			
			if(sub.indexOf("+")>0)
			{
				sub=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strPNR+"$PN$"+PATinfo+"", "", "");
			}
			else if(sub.indexOf("+")>0)
			{
				sub=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strPNR+"$PN$PN$"+PATinfo+"", "", "");
			}
			else if(sub.indexOf("+")>0)
			{
				sub=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strPNR+"$PN$PN$PN$"+PATinfo+"", "", "");
			}
			
			 list=	editPNRTXT_PNR(sub);
		}else{
			
			
			 sub=PnrTxtPat;
			 list=	editPNRTXT(sub);
			 //list=	editPNRTXT_new(sub);
		}
		
		
		
		// 一下为解析

		
		
		
		//List list=	editPNRTXT(strPNRTXT);
		strPNR=list.get(0).toString();
		strPNRTXT=list.get(1).toString();
		strPATTXT=list.get(2).toString();
		
		
		
		
		
		
		
		
		
		//过滤开始
		if(strPNR!=null&&strPNR.indexOf("rt")!=-1){
			
			strPNR=strPNR.split("rt")[1].trim();
		}
		
		strPATTXT=strPATTXT.trim().replace("", "");
		strPNRTXT=strPNRTXT.trim().replace("", "");
		
		//结束
		System.out.println(strPNR);
		System.out.println(strPNRTXT);
		System.out.println(strPATTXT);

		try {
			ActionContext.getContext().getSession().remove("pnrsegment");
			ActionContext.getContext().getSession().remove("pnrpassenger");
			String strReturn = "";
			String strBPnr = "";
			
				strReturn = strPNRTXT;
			
				//System.out.println(strPNRTXT.replace(" ", ""));
				
				
			if (strReturn.length() > 0) {
				String strPNameInfo = "";
				String strOtherInfo = "";
				String strFlightInfo = "";
				String strFlightNumber = "";
				String strAirCompany = "";
				String strCabin = "";
				String strFormCity = "";
				String strToCity = "";
				String strStratTime = "";
				String strEndTime = "";
				String strFlightDate = "";
				String strtempdate = "";
				String strtempday = "";
				String strtempmonth = "";
				String strtempyear = "";

				// 出票状态
				if (strReturn.toString().indexOf("SSR TKNE") >= 0
				 || strReturn.toString().indexOf("RR1") >= 0
						|| strReturn.toString().indexOf("TN/") >= 0) {
					s_orderstatuspnr = "3";
				}
				// 取消状态
				if (strReturn.toString().indexOf(
						"*THIS PNR WAS ENTIRELY CANCELLED*") >= 0
						|| strReturn.toString().indexOf("NO1") >= 0) {
					s_orderstatuspnr = "6";
				}
				// --------------------------------------________-
				if (s_orderstatuspnr.equals("6")) {
					ServletActionContext.getRequest().setAttribute("isTuiFei",
							true);
				}
				// 乘机人数量
				int intpassengerNum = 0;
				// 以PNR分割乘机人姓名和其他信息
				String[] PNRArr = null;
				if (strReturn.indexOf(strBPnr.toUpperCase().trim()) >= 0
						&& !strBPnr.equals("")) {
					PNRArr = strReturn.split(strBPnr.toUpperCase().trim());
				} else if (strReturn.indexOf(strPNR.toUpperCase().trim()) >= 0) {
					PNRArr = strReturn.split(strPNR.toUpperCase().trim());
				}

				// 证件信息
				String strIDNumbers = "";
				String strIDTYpe = ""; // 证件类型
				if (PNRArr.length >= 2) {
					// 乘机人信息
					strPNameInfo = PNRArr[0];
					Pattern pPerson = Pattern.compile("[0-9]{1,}[\\.]");
					String[] passenger = pPerson.split(strPNameInfo.replace(
							"**ELECTRONIC TICKET PNR**", "")
							.replace("<br>", ""));
					for (int i = 1; i < passenger.length; i++) {
						intpassengerNum++;
						strNMString += passenger[i].trim() + "#";
					}
					if (strNMString.equals("")) {
						for (int i = 0; i < passenger.length; i++) {
							intpassengerNum++;
							strNMString += passenger[i].trim() + "#";
						}
					}
					// 成人带小孩 30.XN/IN/周熙越INF(OCT09)/P1 start
					String strChildName = "";
					// 婴儿出生日期
					String strChildIDNum = "";
					try {
						//Pattern pOther = Pattern.compile("[<br>]");
						Pattern pOther = Pattern.compile("[<br>]");
						String[] strOrderArr = pOther.split(strReturn);
						for (int i = 0; i < strOrderArr.length; i++) {
							if (strOrderArr[i].equals("")) {
								continue;
							}
							if(strOrderArr[i].indexOf("CA/")!=-1){
							
								String[] BigPnrs= strOrderArr[i].split(" ");
								
								for(int b=0;b<BigPnrs.length;b++){
									
									if(BigPnrs[b].indexOf("CA/")!=-1){
										
										BigPNR=BigPnrs[b].replaceAll("CA/", "");
									}
								}
								
							
							}
							if(BigPNR.length()>6){
								
								BigPNR=BigPNR.substring(0, 6);
							}
							
							System.out.println("BIGPNR:"+BigPNR);
							
							String regbaby = "[0-9]{1,}[.][\\s]{0,}[X][N][/][I][N][/][\\w|\\W]{2,}[I][N][F][(][a-zA-Z]{3}[0-9]{2}[)][/][P][0-9]{1,}";
							Pattern pattbaby = Pattern.compile(regbaby);

							Matcher mchildname = pattbaby
									.matcher(strOrderArr[i].trim());
							while (mchildname.find()) {
								strChildName = mchildname.group().toString();
								if (strChildName.trim().length() > 0) {
									String[] strtempbaby = strChildName.trim()
											.split("[(]");
									if (strtempbaby.length > 0) {
										// String
										// strnewname=strtempbaby[0].split("/")[strtempbaby[0].split("/").length-1];
										// if(strNMString.indexOf(strnewname)<0)
										// {
										// strNMString+=strnewname;
										// }
										strChildIDNum = strtempbaby[1]
												.split("[)]")[0];
									}
								}
							}
							// OSI YY 1INF ZHAOYIXUAN/P1
							String regbaby1 = "[0-9]{1,}[.][\\s]{0,}[O][S][I][\\s]{0,}[Y][Y][\\s]{0,}[0-9]{1,}[\\s]{0,}[I][N][F][\\s]{0,}[\\w|\\W]{2,}[/][P][0-9]{1,}";
							Pattern pattbaby1 = Pattern.compile(regbaby1);
							Matcher mchildname1 = pattbaby1
									.matcher(strOrderArr[i].trim());
							while (mchildname1.find()) {
								strChildName = mchildname1.group().toString();
								if (strChildName.trim().length() > 0) {
									String[] strtempbaby = strChildName.trim()
											.split("\\s");
									if (strtempbaby.length >= 4) {
										String strnewname = strtempbaby[3]
												.split("/")[0];
										if (strNMString.indexOf(strnewname) < 0) {
											strNMString += strnewname + " INF";
										}
										// strChildIDNum=strtempbaby[1].split("[)]")[0];
									}
								}
							}
						}
					} catch (Exception ex) {

					}
					
					// 成人带小孩 end
					strOtherInfo = PNRArr[1];
					//Pattern pOther = Pattern.compile("\n");//往返
					Pattern pOther = Pattern.compile("[<br>]");//单程
					String[] strOrderArr = pOther.split(strOtherInfo);
					int idnumindex = 1;
					int intflag = 0;
					if (strOrderArr.length > 0)
					
					{
						
						//System.out.println("?????"+strOrderArr.length);
						for (int j = 0; j <strOrderArr.length; j++) {
							if (strOrderArr[j]!=null&&!strOrderArr[j].equals("")) {
								// 匹配证件信息
								if (strOrderArr[j].indexOf("SSR FOID") >= 0) {
									if (strOrderArr[j].indexOf("NI") >= 0) // 身份证
									{
										Pattern pidnumber = Pattern
												.compile("NI");
										String[] strIdArr = pidnumber
												.split(strOrderArr[j]);
										strIDTYpe = "1" + "#";
										if (strIdArr.length == 2) {
											if (strIdArr[1].indexOf("/") >= 0) {
												String[] strIDNumberdetail = strIdArr[1]
														.split("/");
												if (strIDNumberdetail.length == 2) {
													strIDNumbers += strIDNumberdetail[0]
															+ "#";
												}
											}

										}
									} else if (strOrderArr[j].indexOf("PP") >= 0) // 护照
									{
										Pattern pidnumber1 = Pattern
												.compile("PP");
										String[] strIdArr1 = pidnumber1
												.split(strOrderArr[j]);
										strIDTYpe = "3" + "#";
										if (strIdArr1.length == 2) {
											if (strIdArr1[1].indexOf("/") >= 0) {
												String[] strIDNumberdetail1 = strIdArr1[1]
														.split("/");
												if (strIDNumberdetail1.length == 2) {
													strIDNumbers += strIDNumberdetail1[0]
															+ "#";
												}
											}
										}
									} else if (strOrderArr[j].indexOf("ID") >= 0) // 其他证件
									{
										Pattern pidnumber2 = Pattern
												.compile("ID");
										String[] strIdArr2 = pidnumber2
												.split(strOrderArr[j]);
										strIDTYpe = "8" + "#";
										if (strIdArr2.length == 2) {
											if (strIdArr2[1].indexOf("/") >= 0) {
												String[] strIDNumberdetail2 = strIdArr2[1]
														.split("/");
												if (strIDNumberdetail2.length == 2) {
													strIDNumbers += strIDNumberdetail2[0]
															+ "#";
												}
											}
										}
									}

								}
								if (isinter == 1) {
									if (strOrderArr[j].indexOf("SSR DOCS") >= 0) {
										if (strOrderArr[j].indexOf("/") >= 0) // 护照
										{
											Pattern pidnumber = Pattern
													.compile("/");
											String[] strIdArr = pidnumber
													.split(strOrderArr[j]);
											strIDTYpe = "3" + "#";
											try {
												if (strIdArr.length >= 2) {
													strIDNumbers += strIdArr[2]
															+ "#"; // 证件号码
												}
											} catch (Exception ex) {
											}
										}
									}
								}
								// 匹配航班信息
								if (strOrderArr[j].trim().equals("")) {
									continue;
								}
								
								
								
								
								String regFlight = "[0-9]{1,}[\\.][\\s]{1,}[*]{0,1}(([A-Za-z]{1}[0-9]{1})|([A-Za-z]{2})|([0-9]{1}[A-Za-z]{1}))[0-9]{3,4}[\\s]{1,}[A-Za-z]{1}.{1,}([--T1]{0}|[--T2]{0,})";
								Pattern pattFlight = Pattern.compile(regFlight);
								Matcher mFlight = pattFlight
										.matcher(strOrderArr[j].trim());

								if (mFlight.find()
										&& strOrderArr[j].trim().indexOf(
												" UN1 ") < 0
										&& strOrderArr[j].trim().indexOf(
												" NO1 ") < 0) {

									// 航程信息
									Segmentinfo segmentinfo = new Segmentinfo();

									// 取得航站楼信息
									// 起飞城市航站楼
									// segmentinfo.setBorderpointat(getHangzhanlouInfo(strOrderArr[j].trim(),
									// 1));
									// 到达城市航站楼
									// segmentinfo.setOffpointat(getHangzhanlouInfo(strOrderArr[j].trim(),
									// 2));

									strFlightInfo = mFlight.group().toString()
											+ "#";
									
									
									//System.out.println("0:"+mFlight.group(0).toString());
									//System.out.println("0:"+mFlight.group(0).toString());
									// 航班具体字段
									Pattern pFlightDetail = Pattern
											.compile("\\s");
									String[] strFlightDetail = pFlightDetail

									.split(strFlightInfo.replace("#", ""));
									String strTempFligDet = "";
									for (int q = 0; q < strFlightDetail.length; q++) {
										if (!strFlightDetail[q].equals("")) {
											strTempFligDet += strFlightDetail[q]
													+ ",";

										}
									}
									strFlightDetail = strTempFligDet.split(",");
									for (int w = 0; w < strFlightDetail.length; w++) {
										// 航班号
										String strregFnumber = "([A-Za-z]{1}[0-9]{1}|[a-zA-Z]{2}|[0-9]{1}[a-zA-Z]{1})[0-9]{3,4}";
										Pattern patfnumber = Pattern
												.compile(strregFnumber);
										Matcher mfnumber = patfnumber
												.matcher(strFlightDetail[w]);
										if (mfnumber.find()) {
											strFlightNumber = mfnumber.group();
										}
										// 舱位代码
										if (strFlightDetail[w].length() == 1) {
											if (segmentinfo.getCabincode() == null) {
												segmentinfo
														.setCabincode(strFlightDetail[w]);
											}
										}
										// 出发机场到达机场
										if (strFlightDetail[w].length() == 6
												&& strFlightDetail[w]
														.indexOf("+1") < 0
												&& !IsNumberStr(strFlightDetail[w])
												&& strFormCity.equals("")
												&& strToCity.equals("")) {
											strFormCity = strFlightDetail[w]
													.substring(0, 3);
											strToCity = strFlightDetail[w]
													.substring(3, 6);
										} else if (strFormCity.equals("")
												|| strToCity.equals("")) {
											if (strFormCity.equals("")
													&& strToCity.equals("")) {
												try {
													if (strFlightDetail[w]
															.length() == 6
															&& !IsNumberStr(strFlightDetail[w])) {
														strFormCity = strFlightDetail[w]
																.substring(0, 3);
														strToCity = strFlightDetail[w]
																.substring(3, 6);
													}
												} catch (Exception ex) {

												}
											}
											try {
												// SU17JUL11NKGCAN
												String strregFlig = "[a-zA-Z]{2}[0-9]{2}[a-zA-Z]{3}[0-9]{2}[a-zA-Z]{6}";
												Pattern patFlig = Pattern
														.compile(strregFlig);
												Matcher mFlig = patFlig
														.matcher(strFlightDetail[w]);
												if (mFlig.find()) {

													strFormCity = strFlightDetail[3]
															.substring(
																	strFlightDetail[3]
																			.length() - 6,
																	strFlightDetail[3]
																			.length())
															.substring(0, 3);
													strToCity = strFlightDetail[3]
															.substring(
																	strFlightDetail[3]
																			.length() - 6,
																	strFlightDetail[3]
																			.length())
															.substring(3, 6);
												}

											} catch (Exception ex) {

											}
										} else if (strFormCity.equals("")
												&& strToCity.equals("")) {
											if (strFlightDetail[w].length() == 15) {
												strFormCity = strFlightDetail[w]
														.substring(9, 12);
												strToCity = strFlightDetail[w]
														.substring(12, 15);
												// 取得起飞日期
												strtempdate = strFlightDetail[w]
														.substring(2, 9);
												strtempday = strtempdate
														.substring(0, 2);
												strtempmonth = strtempdate
														.substring(2, 5);
												strtempyear = strtempdate
														.substring(5, 7);
											}
										}
										// 起飞日期
										String strFlightDateTemp = "";

										// 当前的年份
										String strYear = "";
										String strNextYear="";
										java.util.Date dt = new java.util.Date();
										//java.util.Date dtnextyear=new java.util.Date();
										//dtnextyear.setYear(dtnextyear.getYear()+1);
										SimpleDateFormat sdf = new SimpleDateFormat(
												"yyyy");
										strYear = sdf.format(dt);
										
										String strregDate = "[a-zA-Z]{2}[0-9]{2}[a-zA-Z]{3}";
										Pattern patdate = Pattern
												.compile(strregDate);
										Matcher mdate = patdate
												.matcher(strFlightDetail[w]);
										if (mdate.find()) {
											strFlightDateTemp = mdate.group();
											strFlightDate = strYear
													+ "-"
													+ ChangeDateModeToInt(strFlightDateTemp
															.subSequence(
																	4,
																	strFlightDateTemp
																			.length())
															.toString())
													+ "-"
													+ strFlightDateTemp
															.subSequence(2, 4);
											continue;
										}
										String strregDate1 = "[0-9]{4}[-][0-9]{2}[-][0-9]{2}";
										Pattern patdate1 = Pattern
												.compile(strregDate1);
										Matcher mdate1 = patdate1
												.matcher(strFlightDate);
										if (!mdate1.find()
												&& !strtempmonth.equals("")
												&& !strtempday.equals("")) {
											strFlightDate = strYear
													+ "-"
													+ ChangeDateModeToInt(strtempmonth)
													+ "-" + strtempday;
										}

										// 起飞时间降落时间
										// 出发时间
										if ((strFlightDetail[w].length() == 4 || (strFlightDetail[w]
												.length() == 6 && strFlightDetail[w]
												.indexOf("+1") >= 0))
												&& IsNumberStr(strFlightDetail[w])) {
											String regExTime = "([0-9]{4}[+][1])|([0-9]{4})";

											Pattern pattTime = Pattern
													.compile(regExTime);
											Matcher mTime = pattTime
													.matcher(strFlightDetail[w]);
											if (mTime.find()) {
												if (segmentinfo.getDeparttime() != null
														&& intflag % 2 == 1) {
													if (strFlightDetail[w]
															.length() == 6) {
														strEndTime = mTime
																.group()
																.toString();
														intflag++;
													} else {
														strEndTime = mTime
																.group()
																.toString();
														intflag++;
													}
												} else {
													strStratTime = mTime
															.group().toString();
													intflag++;
												}
											}
											if (strEndTime.equals("")) {
												strEndTime = "00:00";
											}
											if (strStratTime.equals("")) {
												strStratTime = "00:00";
											}
											String strDeptTime = strFlightDate
													+ " "
													+ strStratTime.substring(0,
															2)
													+ ":"
													+ strStratTime.substring(2,
															strStratTime
																	.length())
													+ ":00";
											// 判断是否是跨天日期
											if (strEndTime.indexOf("+1") > 0 && segmentinfo.getArrivaltime()==null) {
												strFlightDate = GetDate(
														strFlightDate, +1);
												strEndTime = strEndTime
														.replace("[+]1", "");
											}
											String strArrTime = strFlightDate
													+ " "
													+ strEndTime
															.substring(0, 2)
															.replace(":", "")
													+ ":"
													+ strEndTime
															.substring(
																	2,
																	strEndTime
																			.length())
															.replace(":", "")
													+ ":00";
											segmentinfo
													.setDeparttime(dateToTimestamp(strDeptTime));
											/*segmentinfo
													.setArrivaltime(dateToTimestamp(strArrTime));*/
											if(strArrTime.indexOf("+1")!=-1){
												strArrTime=strArrTime.toString().replaceAll("[+]1", "");
												segmentinfo.setArrivaltime(new Timestamp(dateToTimestamp(strArrTime).getTime()+1000*60*60*24));
											}else{
												segmentinfo.setArrivaltime(dateToTimestamp(strArrTime));
											}
											
											continue;
										}
									}

									segmentinfo
											.setAircomapnycode(strFlightNumber
													.substring(0, 2));
									segmentinfo
											.setAircompanyname(getAirCompanyName(strFlightNumber
													.substring(0, 2)));
									segmentinfo
											.setFlightnumber(strFlightNumber);
									segmentinfo.setStartairport(strFormCity);
									segmentinfo.setEndairport(strToCity);
									segmentinfo.setDiscount(getdiscountbycode(
											segmentinfo.getAircomapnycode(),
											segmentinfo.getCabincode()));

									//
									strFormCity = "";
									strToCity = "";
									strtempmonth = "";
									strtempday = "";

									// 全价价格
									List<Airbaseprice> listairbase = Server
											.getInstance()
											.getAirService()
											.findAllAirbaseprice(
													"where "
															+ Airbaseprice.COL_sairportcode
															+ "='"
															+ segmentinfo
																	.getStartairport()
															+ "' and "
															+ Airbaseprice.COL_eairportcode
															+ "='"
															+ segmentinfo
																	.getEndairport()
															+ "' and "
															+ Airbaseprice.COL_aircompanycode
															+ "='"
															+ segmentinfo
																	.getAircomapnycode()
															+ "'", "", -1, 0);
									// 从数据库中查询全价价格
									if (listairbase.size() > 0) {
										if (listairbase.get(0).getPrice() > 0) {
											segmentinfo.setYprice(Float
													.parseFloat(listairbase
															.get(0).getPrice()
															+ ""));
										}
									}
									// 如果数据库中没有全价价格则从黑屏中再查一下全价价格
									else {
										segmentinfo
												.setYprice(0f);
									}
									// 如果是国际票的话，价格信息全部留空
									if (isinter == 1) {
										segmentinfo.setAirportfee(0f);
										segmentinfo.setDiscount(0f);
										segmentinfo.setFuelfee(0f);
										segmentinfo.setPrice(0f);
										segmentinfo.setYprice(0f);

									}
									listSegment.add(segmentinfo);
								}
							}
						}
						
						System.out.println("---"+listSegment.size());

						// 乘机人信息
						if (strNMString.indexOf("#") > 0) {
							// 如果是团队票，重新得到乘机人姓名
							String strregroup = "";
							String strgrouppnrinfo = "";
							// 自动判断是否是团队PNR 判断格式 空格NM数字空格
							String strisgroupexp = "\\s{0,}[N][M][0-9]{1,}\\s{0,}";
							Pattern patfgroup = Pattern.compile(strisgroupexp);
							Matcher mfnumber = patfgroup.matcher(strNMString);
							if (mfnumber.find()) {
								// 是团队PNR
								isgroup = 1;
							}

							if (isgroup == 2) {
								if (etermtype == 1) {
									strregroup = Server
											.getInstance()
											.getTicketSearchService()
											.commandFunction2(
													"RTN/"
															+ strPNR.trim()
															+ "$PN$PN$PN$PN$PN$PN$PN$PN$PAT:A",
													"", "");
									strgrouppnrinfo = strregroup;
								} else if (etermtype == 2) {
									strregroup = Server
											.getInstance()
											.getTicketSearchService()
											.commandFunction(
													"RTN/"
															+ strPNR.trim()
															+ "$PN$PN$PN$PN$PN$PN$PN$PN$PAT:A",
													"");
									strgrouppnrinfo = strregroup;
								}
								// 根据第一程航班号来进行分割
								String strFlighnum = listSegment.get(0)
										.getFlightnumber();
								strregroup = strregroup.split(strFlighnum)[0];
								// 再用PNR和航空公司代码分割
								// MC115Y/MU
								if (strregroup.split(strPNR.trim()
										.toUpperCase()
										+ "/"
										+ listSegment.get(0)
												.getAircomapnycode()).length >= 2) {
									strregroup = strregroup.split(strPNR.trim()
											.toUpperCase()
											+ "/"
											+ listSegment.get(0)
													.getAircomapnycode())[1];
									Pattern ppa = Pattern
											.compile("[0-9]{1,}[\\.]");
									String[] strgrouppass = ppa
											.split(strregroup.replace("\n", ""));
									strNMString = "";
									for (int p = 0; p < strgrouppass.length; p++) {
										if (!strgrouppass[p].trim().equals("")) {
											intpassengerNum++;
											strNMString += strgrouppass[p]
													+ "#";
										}
									}

								} else if (strregroup.split(strPNR.trim()
										.toUpperCase()).length >= 2) {
									strregroup = strregroup.split(strPNR.trim()
											.toUpperCase())[1];
									Pattern ppa = Pattern
											.compile("[0-9]{1,}[\\.]");
									String[] strgrouppass = ppa
											.split(strregroup.replace("\n", ""));
									strNMString = "";
									for (int p = 0; p < strgrouppass.length; p++) {
										if (!strgrouppass[p].trim().equals("")
												&& !strgrouppass[p].trim()
														.equals("/MU")) {
											intpassengerNum++;
											strNMString += strgrouppass[p]
													+ "#";
										}
									}
								}

							}
							if (isgroup == 1) {
								try {
									// 判断是否还有婴儿
									if (strChildName.trim().length() > 0) {
										String[] strtempbaby = strChildName
												.trim().split("/");
										if (strtempbaby.length >= 2) {
											String strnewname = strtempbaby[2];
											if (strNMString.indexOf(strnewname) < 0) {
												strNMString += strnewname + "";
												// 都清樾INF(MAR10)
												String[] strbabyidarr = strnewname
														.split("[(]");
												if (strbabyidarr.length >= 1) {
													strChildIDNum += strbabyidarr[1]
															.replace(")", "");
												}
											}

										}
									}
								} catch (Exception ex) {

								}
							}

							String[] strPassengerArr = strNMString.split("#");
							if (strChildIDNum.length() > 0) {
								strIDNumbers += strChildIDNum + "#";
							}
							String[] strIDNumberArr = strIDNumbers.split("#");
							String[] strIDtype = strIDTYpe.split("#");

							String strPatPrice = "";
							for (int i = 0; i < strPassengerArr.length; i++) {
								Passenger passengerinfo = new Passenger();
								if (strPassengerArr[i] != null) {
									passengerinfo.setName(strPassengerArr[i]);
									if(strPassengerArr[i].indexOf("CHD")!=-1){
										passengerinfo.setPtype(2);
									}else{
									passengerinfo.setPtype(1);
									}
									try {
										passengerinfo.setIdtype(Integer
												.parseInt(strIDtype[i]));
									} catch (Exception ex) {
										passengerinfo.setIdtype(1);
									}
									// 证件号码
									try {
										int indexid = i + 1;
										if (isgroup == 1) {
											passengerinfo
													.setIdnumber(getIDNumberbypnr(
															strgrouppnrinfo,
															"P" + indexid));
										} else {
											passengerinfo
													.setIdnumber(getIDNumberbypnr(
															strReturn, "P"
																	+ indexid));
										}

									} catch (Exception ex) {

									}
									// 价格信息
									
									//PAT:A  >PAT:A   01 V FARE:CNY920.00 TAX:CNY50.00 YQ:CNY150.00  TOTAL:1120.00 SFC:01  
									String pattxt=strPATTXT;
									if(pattxt.trim().indexOf("FARE:")!=-1){
										
										
										
										// 用空格将每个价格分割
									
										String[] strPriceItems = pattxt
												.split(" ");
										if (strPriceItems.length > 0) {
											for (int p = 0; p < strPriceItems.length; p++) {
												if (strPriceItems[p].equals("")) {
													continue;
												}
												
												if (strPriceItems[p]
																	.toUpperCase()
																	.indexOf("FARE:") >= 0) {
																Pattern pTicketPrice = Pattern
																		.compile(":");
																String[] strTicketPriceArr = pTicketPrice
																		.split(strPriceItems[p]);
																passengerinfo
																		.setPrice(Float
																				.parseFloat(strTicketPriceArr[1]
																						.toString()
																						.replace(
																								"CNY",
																								"")
																						.trim()));
															}
												
											
													if (strPriceItems[p]
															.indexOf("TCNY") >= 0
															&& strPriceItems[p]
																	.indexOf("YQ") >= 0) {
														try {
															passengerinfo
																	.setFuelprice(Float
																			.parseFloat(strPriceItems[p]
																					.toString()
																					.replace(
																							"TCNY",
																							"")
																					.replace(
																							"YQ",
																							"")
																					.trim()));
														} catch (Exception ex) {
															continue;
														}
													}
												
												
													// 机建费
													if (strPriceItems[p]
															.toUpperCase().indexOf(
																	"TAX:") >= 0) {
														Pattern pTAXPrice = Pattern
																.compile(":");
														String[] strTAXPriceArr = pTAXPrice
																.split(strPriceItems[p]);

														if (!strTAXPriceArr[1]
																.toString()
																.replace("CNY", "")
																.trim()
																.equals("TEXEMPTCN")) {
															try {
																passengerinfo
																		.setAirportfee(Float
																				.parseFloat(strTAXPriceArr[1]
																						.toString()
																						.replace(
																								"CNY",
																								"")
																						.trim()));
															} catch (Exception ex) {
																continue;
															}
														} else {
															passengerinfo
																	.setAirportfee(0f);
														}

													}
													// 燃油费
													if (strPriceItems[p]
															.toUpperCase().indexOf(
																	"YQ:") >= 0) {
														Pattern pYQPrice = Pattern
																.compile(":");
														String[] strYQPriceArr = pYQPrice
																.split(strPriceItems[p]);

														if (!strYQPriceArr[1]
																.toString()
																.replace("CNY", "")
																.trim()
																.equals("TEXEMPTYQ")) {
															try {
																passengerinfo
																		.setFuelprice(Float
																				.parseFloat(strYQPriceArr[1]
																						.toString()
																						.replace(
																								"CNY",
																								"")
																						.trim()));
															} catch (Exception ex) {
																continue;
															}
														} else {
															passengerinfo
																	.setFuelprice(0f);
														}
													}
													
													try {
														if (passengerinfo.getPtype()==2) {
															for (int w = 0; w < strPriceItems.length; w++) {
																// 燃油费
																if (strPriceItems[w]
																		.toUpperCase()
																		.indexOf(
																				"YQ") >= 0) {
																	passengerinfo
																			.setFuelprice(Float
																					.parseFloat(strPriceItems[w]
																							.toUpperCase()
																							.replace(
																									"YQ",
																									"")));
																}
															}
														}
														if (strPassengerArr[i]
																.indexOf("INF") >= 0) {
															// SCNY80.00/
															for (int w = 0; w < strPriceItems.length; w++) {
																// 票价
																if (strPriceItems[w]
																		.toUpperCase()
																		.indexOf(
																				"SCNY") >= 0) {
																	passengerinfo
																			.setFuelprice(0f);
																	passengerinfo
																			.setAirportfee(0f);
																	passengerinfo
																			.setPrice(Float
																					.parseFloat(strPriceItems[w]
																							.toUpperCase()
																							.replace(
																									"SCNY",
																									"")
																							.replace(
																									"/",
																									"")));
																}
															}
														}
													} catch (Exception ex) {
													}
												
												
											}
											
										}
										
									}
									
									
									//票面价
									String pvalue="";
									
									
									
									listPassenger.add(passengerinfo);
								}
							}
						}
					}
				}
			}
			
			//判断是否跨年
			for(int i=0;i<listSegment.size();i++)
			{
				try
				{
					long intdays=dateDiff(formatTimestampHHmm2(new Timestamp(System.currentTimeMillis())),formatTimestampHHmm2(listSegment.get(i).getDeparttime()));
					if(intdays>7)
					{
						listSegment.get(i).setDeparttime(dateToTimestamp(GetNextYear(formatTimestampHHmm2(listSegment.get(i).getDeparttime()))));
						listSegment.get(i).setArrivaltime(dateToTimestamp(GetNextYear(formatTimestampHHmm2(listSegment.get(i).getArrivaltime()))));
					}
				}
				catch(Exception ex)
				{
					
				}
			}
			ActionContext.getContext().getSession().put("pnrsegment",
					listSegment);

			ActionContext.getContext().getSession().put("pnrpassenger",
					listPassenger);
			if (listSegment == null || listSegment.size() == 0) {
				listAricompany = Server.getInstance().getAirService()
						.findAllAircompany("", "", -1, 0);
			}
			
			//取得单航程票面价信息
			for(Passenger pass:listPassenger)
			{
				if(pass.getPtype()==1)
				{
					if(pass.getPrice()!=null)
					{
					segmentparvprice=pass.getPrice();
					break;
					}
				}
				if(pass.getPtype()==2)
				{
					if(pass.getPrice()!=null)
					{
					segmentparvprice=pass.getPrice();
					break;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		isshow=1;
		
	//匹配政策开始--接口政策
		
		Orderinfo orderinfonew= new Orderinfo();
		orderinfonew.setPnr(strPNR);
		orderinfonew.setBigpnr(BigPNR);
		orderinfonew.setPnrtxt(strPNRTXT);
		orderinfonew.setPattxt(strPATTXT);
		//orderinfonew.setPolicyagentid(5l);
		/* newzrate= Server.getInstance().getRateService().FindZrateByFlight(orderinfonew, null,null);
		 if(newzrate.getRatevalue()==null){
			 
			 
			 newzrate=Server.getInstance().getAirService().findZrate(23018l); 
		 }
		 
		System.out.println("newzrate:"+newzrate);*/
		Segmentinfo segmentinfo=listSegment.get(0);
		
		/*List<Zrate> list51=new ArrayList<Zrate>();
		try {
			list51=Server.getInstance().getRateService().FindListZrateByPNR(orderinfonew,segmentinfo,listPassenger);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		listzrate=list51;
		
		//匹配今日
		orderinfonew.setPolicyagentid(6l);
		orderinfonew.setPolicyid(-1l);//-1  说明是PNR导入用
		List<Zrate> listjr=new ArrayList<Zrate>();
		
		try {
			listjr=Server.getInstance().getRateService().FindListZrateByPNR(orderinfonew,segmentinfo,listPassenger);
			
			//FindZrateByFlight
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(listjr!=null&&listjr.size()>0){
			int in=listjr.size();
			if(in>=5){
				in=5;
			}
			for(int j=0;j<in;j++){
				if(listjr.get(j)!=null&&listjr.get(j).getRatevalue()!=null){
				listzrate.add(listjr.get(j));
				}
			}
				
		}*/
		//匹配今日结束
		
		
	//匹配政策--本地政策
		Calendar cal=Calendar.getInstance(); 
	    SimpleDateFormat formatter=new SimpleDateFormat("HH:mm"); 
	    String mDateTime=formatter.format(cal.getTime());
	    String strSP="[dbo].[sp_GetZrateByFlight] "+
		"@chufajichang = N'"+listSegment.get(0).getStartairport()+"',@daodajichang = N'"+listSegment.get(0).getEndairport()+"',"+
		"@chufariqi = N'"+formatTimestampyyyyMMdd(listSegment.get(0).getDeparttime())+"',@dangqianshijian= N'"+mDateTime+"',"+
		"@hangkonggongsi= N'"+listSegment.get(0).getAircomapnycode()+"',"+
		"@cangwei= N'"+listSegment.get(0).getCabincode()+"',@hangbanhao= N'"+listSegment.get(0).getFlightnumber().substring(2, listSegment.get(0).getFlightnumber().length())+"',@ismulity=0,@isgaofan=1,@agentid=2";
	    System.out.println(strSP);
	   List listzrate2=Server.getInstance().getSystemService().findMapResultByProcedure(strSP);
	    System.out.println("本地政策数量:"+listzrate2.size());
		if(listzrate2.size()>0){
			
			Zrate zrate= new Zrate();
			for(int s=0;s<listzrate2.size();s++){
				Map map=(Map)listzrate2.get(s);
				zrate=Server.getInstance().getAirService().findZrate(Long.parseLong(map.get("zrateid").toString().trim()));
				if(zrate.getIsenable()==1&&zrate.getRatevalue()>0){
				//zrate.setRatevalue(Getliudianvalue2(zrate.getRatevalue(), customeragent));
				//zrate.setAgentcode("SHA072");
				listzrate.add(zrate);
				}
			}
			
		}
		/*List<Zrate> listzrate2=ZrateServer.getInstance().searchZrate(listSegment.get(0).getStartairport(), listSegment.get(0).getEndairport(),
				listSegment.get(0).getAircomapnycode(), listSegment.get(0).getCabincode(), formatTimestampyyyyMMdd(listSegment.get(0).getDeparttime()), 2, listSegment.get(0).getFlightnumber().substring(2, listSegment.get(0).getFlightnumber().length()), 0);
		System.out.println("本地票盟政策:"+listzrate2.size());
	  
		for(int s=0;s<listzrate2.size();s++){
			if(listzrate2.get(s).getIsenable()==1&&listzrate2.get(s).getRatevalue()>0){
			listzrate.add(listzrate2.get(s));
			}
		}
		
		System.out.println("本地票盟政策add完");*/
		
	//匹配政策结束
	  //匹配政策
		List<Zrate> list51=new ArrayList<Zrate>();//51
		List<Zrate> listpm=new ArrayList<Zrate>();//票盟
		List<Zrate> listjr=new ArrayList<Zrate>();//今日
		List<Zrate> list8000yi=new ArrayList<Zrate>();//8000yi
		List<Zrate> list517na=new ArrayList<Zrate>();//517na
		
		Server.getInstance().setInter("http://211.149.173.11:8080/ticket_inter/service/");
		
		//票盟
		/*orderinfonew.setPolicyagentid(2l);
		try {
			listpm=Server.getInstance().getRateService().FindListZrateByPNR(orderinfonew, listSegment.get(0), listPassenger);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("票盟:"+listpm.size());*/
		//8000yi
		/*orderinfonew.setPolicyagentid(3l);
		try {
			list8000yi=Server.getInstance().getRateService().FindListZrateByPNR(orderinfonew, listSegment.get(0), listPassenger);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("8000YI:"+list8000yi.size());
*/		//今日
		orderinfonew.setPolicyagentid(6l);
		orderinfonew.setPolicyid(1l);
		try {
			listjr=Server.getInstance().getRateService().FindListZrateByPNR(orderinfonew, listSegment.get(0), listPassenger);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("今日:"+listjr.size());
		
		
		
		/*try {
					
			//517
			orderinfonew.setPolicyagentid(7l);
			list517na=Server.getInstance().getRateService().FindListZrateByPNR(orderinfonew, listSegment.get(0), listPassenger);
			System.out.println("list517na:"+list517na.get(0).getRatevalue());
					
				}catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("517:"+list517na.size());*/
				
		if(listpm!=null&&listpm.size()>0){
			for(int a=0;a<listpm.size();a++){
				if(listpm.get(a).getGeneral()==2){
					listzrate.add(listpm.get(a));
				}else{
					listzrate.add(listpm.get(a));
				}
				
			}
			}
			if(list8000yi!=null&&list8000yi.size()>0){
			for(int a=0;a<list8000yi.size();a++){
				if(list8000yi.get(a).getGeneral()==2){
					listzrate.add(list8000yi.get(a));
				}else{
					listzrate.add(list8000yi.get(a));
				}
				
			}
			}
			if(listjr!=null&&listjr.size()>0){
			for(int a=0;a<listjr.size();a++){
				if(listjr.get(a).getGeneral()==2){
					listzrate.add(listjr.get(a));
				}else{
					listzrate.add(listjr.get(a));
				}
				
			}
			}
			
			if(list517na!=null&&list517na.size()>0){
				for(int a=0;a<list517na.size();a++){
					if(list517na.get(a).getGeneral()==2){
						listzrate.add(list517na.get(a));
					}else{
						listzrate.add(list517na.get(a));
					}
					
				}
				}
			
		
		//过滤留点
		List<Zrate>listnew=new ArrayList<Zrate>();
		
		if(listzrate.size()>0){
			for(int g=0;g<listzrate.size();g++){
				Zrate e=listzrate.get(g);
				e.setRatevalue(dceimalFormat(Getliudianvalue2(e.getRatevalue(),customeragent)));
				listnew.add(e);
			}
		}
		listzrate=listnew;
		
		System.out.println("排序前");
		
		java.util.Collections.sort(listzrate);
		System.out.println("排序后");
		/*Zrate[] ts =(Zrate[]) listzrate.toArray(new Zrate[0]);
		Arrays.sort(ts);
		listzrate.clear();
		for(Zrate zrate:ts){
			listzrate.add(zrate);
		}
		*/
		
			if(listzrate.size()>0){
			newzrate=listzrate.get(0);
			}
		
		
		System.out.println("返回政策:"+listzrate.size());
		
		if(listzrate!=null&&listzrate.size()>0){
			for(int a=0;a<listzrate.size();a++){
				if(listzrate.get(a).getGeneral()==2){
					ListZrate2.add(listzrate.get(a));
				}else{
					ListZrate1.add(listzrate.get(a));
				}
				
			}
			}
		
		
		
		
	//分开政策
		/*if(list51!=null&&list51.size()>0){
			for(int a=0;a<list51.size();a++){
				if(list51.get(a).getGeneral()==2){
					ListZrate2.add(list51.get(a));
				}else{
					ListZrate1.add(list51.get(a));
				}
				
			}
			}
			if(listpm!=null&&listpm.size()>0){
			for(int a=0;a<listpm.size();a++){
				if(listpm.get(a).getGeneral()==2){
					ListZrate2.add(listpm.get(a));
				}else{
					ListZrate1.add(listpm.get(a));
				}
				
			}
			}
			if(list8000yi!=null&&list8000yi.size()>0){
			for(int a=0;a<list8000yi.size();a++){
				if(list8000yi.get(a).getGeneral()==2){
					ListZrate2.add(list8000yi.get(a));
				}else{
					ListZrate1.add(list8000yi.get(a));
				}
				
			}
			}
			if(listjr!=null&&listjr.size()>0){
			for(int a=0;a<listjr.size();a++){
				if(listjr.get(a).getGeneral()==2){
					ListZrate2.add(listjr.get(a));
				}else{
					ListZrate1.add(listjr.get(a));
				}
				
			}
			}
			if(list517na!=null&&list517na.size()>0){
				for(int a=0;a<list517na.size();a++){
					if(list517na.get(a).getGeneral()==2){
						ListZrate2.add(list517na.get(a));
					}else{
						ListZrate1.add(list517na.get(a));
					}
					
				}
				}*/
			//ListZrate1
			 java.util.Collections.sort(ListZrate1);
			 java.util.Collections.sort(ListZrate2);
			
		
		
		
		
		
		
		
		
		
		
		
		
		return "toGetZrateBYPnr";
	}
	
	public String GetNextYear(String DepDate)
	{
		
		try
		{
			String[] strarr=DepDate.split("-");
			String strDepYear=strarr[0];
			java.util.Date dtnextyear=new java.util.Date();
			dtnextyear.setYear(dtnextyear.getYear()+1);
			String strNextDepDate=formatDate(dtnextyear);
			String[] strarrNext=strNextDepDate.split("-");
			DepDate=DepDate.replace(strDepYear,strarrNext[0])+":00";
		}
		catch(Exception ex)
		{
			
		}
		return DepDate;
	}

	public boolean IsNumberStr(String str) {
		boolean isNumber = false;
		for (int i = 0; i < str.length(); i++) {
			// 循环遍历字符串
			if (Character.isDigit(str.charAt(i))) {
				// 用char包装类中的判断数字的方法判断每一个字符
				isNumber = true;
			}
		}
		return isNumber;
	}

	/**
	 * 通过pnr跳转到预订页面
	 * 
	 * @param pnr
	 * @return
	 */
	public String toCreatePnr() {
		ActionContext.getContext().getSession().remove("pnrsegment");
		ActionContext.getContext().getSession().remove("pnrpassenger");
		String strReturn = "";
		if (s_hidflag.equals("1")) {
			strReturn = Server.getInstance().getTicketSearchService()
					.getPNRInfo(strPNR);
		} else if (s_hidflag.equals("2")) {
			strReturn = s_pnrdetails;
		}
		if (strReturn.indexOf(strPNR.toUpperCase()) > 0) {
			String strPNameInfo = "";
			String strOtherInfo = "";
			String strFlightInfo = "";
			String strFlightNumber = "";
			String strAirCompany = "";
			String strCabin = "";
			String strFormCity = "";
			String strToCity = "";
			String strStratTime = "";
			String strEndTime = "";
			String strFlightDate = "";

			// 乘机人数量
			int intpassengerNum = 0;
			// 以PNR分割乘机人姓名和其他信息
			String[] PNRArr = strReturn.split(strPNR.toUpperCase());
			if (PNRArr.length == 2) {
				// 乘机人信息
				strPNameInfo = PNRArr[0];
				Pattern pPerson = Pattern.compile("[0-9]{1,}[\\.]");
				String[] passenger = pPerson.split(strPNameInfo.replace(
						"**ELECTRONIC TICKET PNR**", "").replace("<br>", ""));
				for (int i = 1; i < passenger.length; i++) {
					intpassengerNum++;
					strNMString += passenger[i].trim() + "#";
				}
				strOtherInfo = PNRArr[1];
				Pattern pOther = Pattern.compile("[<br>]");
				String[] strOrderArr = pOther.split(strOtherInfo);
				if (strOrderArr.length > 0) {
					for (int j = 0; j < strOrderArr.length; j++) {
						if (!strOrderArr[j].equals("")) {
							// 匹配航班信息
							String regFlight = "[0-9]{1,}[\\.][\\s]{1,}[*]{0,1}[A-Za-z]{1,2}[0-9]{3,4}[\\s]{1,}[A-Za-z]{1}[\\w\\s]{1,}([--T1]|[--T2]{0,})";
							Pattern pattFlight = Pattern.compile(regFlight);
							Matcher mFlight = pattFlight.matcher(strOrderArr[j]
									.trim());
							if (mFlight.find()) {
								// 航程信息
								Segmentinfo segmentinfo = new Segmentinfo();

								strFlightInfo = mFlight.group().toString()
										+ "#";
								// 航班具体字段
								Pattern pFlightDetail = Pattern.compile("\\s");
								String[] strFlightDetail = pFlightDetail
										.split(strFlightInfo);

								for (int w = 0; w < strFlightDetail.length; w++) {
									// 航班号
									String strregFnumber = "[a-zA-Z]{2}[0-9]{3,4}";
									Pattern patfnumber = Pattern
											.compile(strregFnumber);
									Matcher mfnumber = patfnumber
											.matcher(strFlightDetail[w]);
									if (mfnumber.find()) {
										strFlightNumber = mfnumber.group();
										continue;
									}

									// 舱位代码
									if (strFlightDetail[w].length() == 1) {
										if (segmentinfo.getCabincode() == null) {
											segmentinfo
													.setCabincode(strFlightDetail[w]);
										}
									}
									// 出发机场到达机场
									if (strFlightDetail[w].length() == 6) {
										strFormCity = strFlightDetail[w]
												.substring(0, 3);
										strToCity = strFlightDetail[w]
												.substring(3, 6);
										continue;
									}
									// 起飞日期
									String strFlightDateTemp = "";
									// 当前的年份
									String strYear = "";
									java.util.Date dt = new java.util.Date();
									SimpleDateFormat sdf = new SimpleDateFormat(
											"yyyy");
									strYear = sdf.format(dt);

									String strregDate = "[a-zA-Z]{2}[0-9]{2}[a-zA-Z]{3}";
									Pattern patdate = Pattern
											.compile(strregDate);
									Matcher mdate = patdate
											.matcher(strFlightDetail[w]);
									if (mdate.find()) {
										strFlightDateTemp = mdate.group();
										strFlightDate = strYear
												+ "-"
												+ ChangeDateModeToInt(strFlightDateTemp
														.subSequence(
																4,
																strFlightDateTemp
																		.length())
														.toString())
												+ "-"
												+ strFlightDateTemp
														.subSequence(2, 4);
										continue;
									}
									// 起飞时间降落时间
									// 出发时间
									if (strFlightDetail[w].length() == 4) {
										String regExTime = "[0-9]{4}";

										Pattern pattTime = Pattern
												.compile(regExTime);
										Matcher mTime = pattTime
												.matcher(strFlightDetail[w]);
										if (mTime.find()) {
											if (segmentinfo.getDeparttime() != null) {
												strEndTime = mTime.group()
														.toString();
											} else {
												strStratTime = mTime.group()
														.toString();
											}
										}
										if (strEndTime.equals("")) {
											strEndTime = "00:00";
										}
										if (strStratTime.equals("")) {
											strStratTime = "00:00";
										}
										String strDeptTime = strFlightDate
												+ " "
												+ strStratTime.substring(0, 2)
												+ ":"
												+ strStratTime.substring(2,
														strStratTime.length())
												+ ":00";
										String strArrTime = strFlightDate
												+ " "
												+ strEndTime.substring(0, 2)
												+ ":"
												+ strEndTime.substring(2,
														strEndTime.length())
												+ ":00";
										segmentinfo
												.setDeparttime(dateToTimestamp(strDeptTime));
										segmentinfo
												.setArrivaltime(dateToTimestamp(strArrTime));
										continue;
									}
								}

								segmentinfo.setAircomapnycode(strFlightNumber
										.substring(0, 2));
								segmentinfo
										.setAircompanyname(getAirCompanyName(strFlightNumber
												.substring(0, 2)));
								segmentinfo.setFlightnumber(strFlightNumber);
								segmentinfo.setStartairport(strFormCity);
								segmentinfo.setEndairport(strToCity);
								segmentinfo.setDiscount(getdiscountbycode(
										segmentinfo.getAircomapnycode(),
										segmentinfo.getCabincode()));

								listSegment.add(segmentinfo);

							}
						}
					}

					// 乘机人信息
					if (strNMString.indexOf("#") > 0) {
						String[] strPassengerArr = strNMString.split("#");
						String strPatPrice = "";
						for (int i = 0; i < strPassengerArr.length; i++) {
							Passenger passengerinfo = new Passenger();
							if (strPassengerArr[i] != null) {
								passengerinfo.setName(strPassengerArr[i]);
								passengerinfo.setPtype(1);
								// 价格信息
								String StrEx = "";
								if (strPassengerArr[i].indexOf("CHD") >= 0) {
									StrEx = "PAT:A*CH";
									strPatPrice = Server.getInstance()
											.getTicketSearchService()
											.commandFunction2(StrEx, "", "");
									passengerinfo.setPtype(2);
								} else if (strPassengerArr[i].indexOf("INF") >= 0) {
									StrEx = "PAT:*IN";
									strPatPrice = Server.getInstance()
											.getTicketSearchService()
											.commandFunction2(StrEx, "", "");
									passengerinfo.setPtype(3);
								} else {
									StrEx = "PAT:A";
									strPatPrice = strReturn;
								}
								Pattern pPrice = Pattern.compile(StrEx);

								String[] strPriceArr = pPrice
										.split(strPatPrice);
								String strPriceInfo = "";

								if (strPriceArr.length > 0) {
									if (strPriceArr.length == 2) {
										strPriceInfo = strPriceArr[1];
									} else {
										strPriceInfo = strPriceArr[0];
									}
									// 用空格将每个价格分割
									Pattern pPriceItem = Pattern.compile("\\s");
									String[] strPriceItems = pPriceItem
											.split(strPriceInfo);
									if (strPriceItems.length > 0) {
										for (int p = 0; p < strPriceItems.length; p++) {
											if (strPriceItems[p].equals("")) {
												continue;
											}
											// 票面价格
											if (strPriceItems[p].toUpperCase()
													.indexOf("FARE:") >= 0) {
												Pattern pTicketPrice = Pattern
														.compile(":");
												String[] strTicketPriceArr = pTicketPrice
														.split(strPriceItems[p]);
												passengerinfo
														.setPrice(Float
																.parseFloat(strTicketPriceArr[1]
																		.toString()
																		.replace(
																				"CNY",
																				"")
																		.trim()));
											}
											// 机建费
											if (strPriceItems[p].toUpperCase()
													.indexOf("TAX:") >= 0) {
												Pattern pTAXPrice = Pattern
														.compile(":");
												String[] strTAXPriceArr = pTAXPrice
														.split(strPriceItems[p]);
												if (!strTAXPriceArr[1]
														.toString().replace(
																"CNY", "")
														.trim().equals(
																"TEXEMPTCN")) {
													passengerinfo
															.setAirportfee(Float
																	.parseFloat(strTAXPriceArr[1]
																			.toString()
																			.replace(
																					"CNY",
																					"")
																			.trim()));
												} else {
													passengerinfo
															.setAirportfee(0f);
												}
											}
											// 燃油费
											if (strPriceItems[p].toUpperCase()
													.indexOf("YQ:") >= 0) {
												Pattern pYQPrice = Pattern
														.compile(":");
												String[] strYQPriceArr = pYQPrice
														.split(strPriceItems[p]);
												if (!strYQPriceArr[1]
														.toString().replace(
																"CNY", "")
														.trim().equals(
																"TEXEMPTYQ")) {
													passengerinfo
															.setFuelprice(Float
																	.parseFloat(strYQPriceArr[1]
																			.toString()
																			.replace(
																					"CNY",
																					"")
																			.trim()));
												} else {
													passengerinfo
															.setFuelprice(0f);
												}
											}

										}
									}
								}
								listPassenger.add(passengerinfo);
							}
						}
					}
				}
			}
		}
		
		ActionContext.getContext().getSession().put("pnrsegment", listSegment);
		ActionContext.getContext().getSession().put("pnrpassenger",
				listPassenger);

		scang = Server.getInstance().getAirService().findScang(scangid);
		return "ipnr";
	}

	// 通过航空公司名称
	public String getaircomnamebycode(String ca) {
		String strReturn = "";
		List<Aircompany> list = Server.getInstance().getAirService()
				.findAllAircompany(
						" where 1=1 and " + Aircompany.COL_aircomcode + " = '"
								+ ca + "'", "", -1, 0);
		if (list != null && list.size() > 0) {
			strReturn = list.get(0).getAircomcnname();
		}
		return strReturn;
	}

	// 通过航空公司名称和舱位码得到折扣信息
	public Float getdiscountbycode(String ca, String cabincode) {
		float strReturn = 0f;
		List<Cabin> list = Server.getInstance().getAirService().findAllCabin(
				" where 1=1 and " + Cabin.COL_aircompanycode + " = '" + ca
						+ "' and " + Cabin.COL_cabincode + "='" + cabincode
						+ "'", "", -1, 0);
		if (list != null && list.size() > 0) {
			strReturn = list.get(0).getDiscount();
		}
		return strReturn;
	}

	/**
	 * 提取PNR信息
	 */
	public void rtPNRinfo() throws Exception {
		System.out.println("rtPNRinfo------------------------");
		String strReturn = "";
		// if (etermtype == 1) {
		// strReturn = Server.getInstance().getTicketSearchService()
		// .getPNRBigInfo(strPNR);
		// } else if (etermtype == 2) {
		// strReturn = Server.getInstance().getTicketSearchService()
		// .getPNRInfo(strPNR);
		// } else {
		// strReturn = Server.getInstance().getTicketSearchService()
		// .getPNRBigInfo(strPNR);
		// }
		//strReturn = Server.getInstance().getTicketSearchService().getPNRInfo(strPNR);
		
		List<Passenger>listpa=Server.getInstance().getAirService().findAllPassenger(" WHERE 1=1 AND "+Passenger.COL_orderid+" ="+s_orderid, " ORDER BY ID ", -1, 0);
		String pat="PAT:A";
		if(listpa.get(0).getPtype()==1){
			 pat="PAT:A";
		}
		if(listpa.get(0).getPtype()==2){
			 pat="PAT:A*CH";
		}
		
		
		strReturn=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strPNR+"$"+pat, "", "");
		
		System.out.println("strReturn:"+strReturn);
		
		String ig="";
		if(strReturn.indexOf("授权")!=-1){
			ig="back";
			strReturn=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strPNR+"$"+pat, "", ig);
		}
		
		
		
		int ind=0;
		
		if(strReturn.indexOf("+")>0){
			ind=strReturn.indexOf("+");
			strReturn=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strPNR+"$PN$"+pat, "", ig);
		}
		if(strReturn.indexOf("+")>ind){
			ind=strReturn.indexOf("+");
			strReturn=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strPNR+"$PN$PN$"+pat, "", ig);
		}
		if(strReturn.indexOf("+")>ind){
			ind=strReturn.indexOf("+");
			strReturn=Server.getInstance().getTicketSearchService().commandFunction2("RT"+strPNR+"$PN$PN$PN$"+pat, "", ig);
		}
		
		
		Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo(Long.parseLong(s_orderid));
		String pntinfo=strReturn.split(">PAT:A")[0];
		orderinfo.setPnrtxt(pntinfo);
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
		
		//>PAT:A
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn.replace("<br />", "")
				.replace("缓存数据已经清除。", ""));
		//out.print(formatHTML(sb.toString()));
		out.print("<br/><pre>"+sb.toString().replaceAll(new String(new byte[]{0x20,0x62,0x0D}),new String(new byte[]{0x0D})).replaceAll(new String(new byte[]{0x20,0x0D}),"\r")+"</pre><br/>");
		
		//"<br/><pre>" +retStr.replaceAll(new String(new byte[]{0x20,0x62,0x0D}),new String(new byte[]{0x0D})).replaceAll(new String(new byte[]{0x20,0x0D}),"\r") +"</pre><br/>"
		System.out.println("PNRINFO信息:"+sb);
		out.flush();
		out.close();
		
	}
	
	
	/********创建订单***********************************************************************/
	public String toaddorder() throws Exception 
	{
		
		
		
		s_orderstatuspnr="1";
		String strreturn="";
		boolean isDeskOperator = this.isCounterPeople();// 是否为柜台人员
		listseg = (List<Segmentinfo>) ActionContext.getContext().getSession()
				.get("pnrsegment");
		listpass = (List<Passenger>) ActionContext.getContext().getSession()
				.get("pnrpassenger");
		for(Segmentinfo segment:listseg)
		{
			for(Passenger passenger:listpass)
			{
				//if(passenger.getPtype()==1)
				//{
					segment.setPrice(passenger.getPrice());
					segment.setAirportfee(passenger.getAirportfee());
					segment.setFuelfee(passenger.getFuelprice());
					segment.setParvalue(segmentparvprice);
					segment.setRatevalue(s_zhekoubili);
					
				//}
				passenger.setState(0);
				passenger.setLanguage(0);
			}
		}
		long orderidtemp = 0l;
		//创建时间
		orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		Customeruser loginemployee = getLoginUser();
		// 会员ID
		try 
		{
			Customeruser memberbook = (Customeruser) ActionContext.getContext().getSession().get("orderuserlogin");
			orderinfo.setCustomeruserid(memberbook.getId());
		 } 
		catch (Exception e) 
		{
			orderinfo.setCustomeruserid(loginemployee.getId());
		}
		//分销商员工ID,即预订人ID
		orderinfo.setSaleagentid(loginemployee.getId());
		//分销商单位ID,加盟商ID
		orderinfo.setBuyagentid(loginemployee.getAgentid());
		orderinfo.setContactname(loginemployee.getMembername());
		orderinfo.setContactmobile(s_contactmobile);
		
		//PNR信息 小
		if (etermtype == 1) {
			orderinfo.setPnr(strPNR.trim());
		}
		
		orderinfo.setBigpnr(BigPNR);
		//PNR信息 大
		if (etermtype == 1) {
			//orderinfo.setBigpnr(Server.getInstance().getTicketSearchService().getBigPNRInfo(orderinfo.getPnr()));
		} else if (etermtype == 2) {
			orderinfo.setBigpnr(strPNR.trim());
			orderinfo.setPnr(strPNR.trim());
		}
		orderinfo.setPostmoney(0);
        //是否是国际票
		if (isinter == 1) {
			orderinfo.setInternal(1l); // 1未国际票，如果是0或者NULL则为国内票
		} else {
			orderinfo.setInternal(0l);
		}
		// 等待支付
		orderinfo.setOrderstatus(1);
		/****支付方式赋值开始*****************************************/
		//1=网上支付(快钱) 2=门市付款 3=票到付款":"虚拟账户支付";
	
			// 未支付
			orderinfo.setPaystatus(0); 
			// 网上支付，未支付，等待支付
			// 在未创建外部订单之前，订单状态为待确认。
			orderinfo.setOrderstatus(1);
		
		orderinfo.setPaymethod(1);
		/****支付方式赋值开始*****************************************/
		//平台费手续费
		orderinfo.setCurrplatfee(this.orderPlat);
		orderinfo.setLanguage(0);
		//订单类型 b2b后台订单
		orderinfo.setOrdertype(2l);
		/****本地政策赋值开始*****************************************/
		List<Long> zratelist = new ArrayList<Long>();
		
		
		if(s_zrateid!=null && !s_zrateid.equals(""))
		{
			String zr[]=s_zrateid.split(",");
			for(int z=0;z<zr.length;z++){
				if(zr[z]!=null&&!zr[z].equals("")&&!zr[z].equals(" ")&&zr[z].trim().length()>0){
					if(zr[z].indexOf("@")!=-1){
						List<Zrate> listzrate=Server.getInstance().getAirService().findAllZrate(" where 1=1 and "+Zrate.COL_outid+" ='"+zr[z].split("@")[0].trim()+"' AND "+Zrate.COL_agentid+" ="+zr[z].split("@")[1].trim(), "", -1, 0);
						zratelist.add(listzrate.get(0).getId());
					}
				
				}
			}
			/*zratelist.add(Long.parseLong(s_zrateid));
			if(listseg.size()>1)
			{
				zratelist.add(Long.parseLong(s_zrateid));
			}*/
		}
		else
		{
			zratelist.add(0l);
		}
		
		/****本地政策赋值开始*****************************************/ 



		// 安检费
		if (s_totalanjian != null) {
			orderinfo.setTotalanjian(Float.parseFloat(s_totalanjian));
		} else {
			orderinfo.setTotalanjian(0f);
		}
		// 其他费用
		if (s_totalotherfee != null) {
			orderinfo.setTotalotherfee(Float.parseFloat(s_totalotherfee));
		} else {
			orderinfo.setTotalotherfee(0f);
		}
		orderinfo.setMemo(s_memo);

		orderinfo.setPnr(strPNR);
		orderinfo.setPattxt(strPATTXT.trim().replaceAll(">", "").trim());
		orderinfo.setPnrtxt(strPNRTXT.trim().replaceAll(">", "").trim());
		
		
		//创建订单信息
		forwork=CreateOrder(listseg,listpass,orderinfo,zratelist, s_insurancevalues,"",2);

		return "ticketorder";
	}
	
	public String toaddorder2() throws Exception 
	{
		
		Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(s_agentid);
		
		Customeruser loginemployee=Server.getInstance().getMemberService().findCustomeruser(s_userid);
		
		
		s_orderstatuspnr="1";
		String strreturn="";
		boolean isDeskOperator = this.isCounterPeople();// 是否为柜台人员
		listseg = (List<Segmentinfo>) ActionContext.getContext().getSession()
				.get("pnrsegment");
		listpass = (List<Passenger>) ActionContext.getContext().getSession()
				.get("pnrpassenger");
		for(Segmentinfo segment:listseg)
		{
			for(Passenger passenger:listpass)
			{
				//if(passenger.getPtype()==1)
				//{
					segment.setPrice(passenger.getPrice());
					segment.setAirportfee(passenger.getAirportfee());
					segment.setFuelfee(passenger.getFuelprice());
					segment.setParvalue(segmentparvprice);
					segment.setRatevalue(s_zhekoubili);
					
				//}
				passenger.setState(0);
				passenger.setLanguage(0);
			}
		}
		long orderidtemp = 0l;
		//创建时间
		orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
	
		
			orderinfo.setCustomeruserid(loginemployee.getId());
		
		//分销商员工ID,即预订人ID
		orderinfo.setSaleagentid(loginemployee.getId());
		//分销商单位ID,加盟商ID
		orderinfo.setBuyagentid(loginemployee.getAgentid());
		orderinfo.setContactname(loginemployee.getMembername());
		orderinfo.setContactmobile(s_contactmobile);
		
		//PNR信息 小
		if (etermtype == 1) {
			orderinfo.setPnr(strPNR.trim());
		}
		orderinfo.setBigpnr(BigPNR);
		//PNR信息 大
		if (etermtype == 1) {
			//orderinfo.setBigpnr(Server.getInstance().getTicketSearchService().getBigPNRInfo(orderinfo.getPnr()));
		} else if (etermtype == 2) {
			orderinfo.setBigpnr(strPNR.trim());
			orderinfo.setPnr(strPNR.trim());
		}
		orderinfo.setPostmoney(0);
        //是否是国际票
		if (isinter == 1) {
			orderinfo.setInternal(1l); // 1未国际票，如果是0或者NULL则为国内票
		} else {
			orderinfo.setInternal(0l);
		}
		// 等待支付
		orderinfo.setOrderstatus(1);
		/****支付方式赋值开始*****************************************/
		//1=网上支付(快钱) 2=门市付款 3=票到付款":"虚拟账户支付";
	
			// 未支付
			orderinfo.setPaystatus(0); 
			// 网上支付，未支付，等待支付
			// 在未创建外部订单之前，订单状态为待确认。
			orderinfo.setOrderstatus(1);
		
		orderinfo.setPaymethod(1);
		/****支付方式赋值开始*****************************************/
		//平台费手续费
		orderinfo.setCurrplatfee(this.orderPlat);
		orderinfo.setLanguage(0);
		//订单类型 b2b后台订单
		orderinfo.setOrdertype(2l);
		/****本地政策赋值开始*****************************************/
		List<Long> zratelist = new ArrayList<Long>();
		
		System.out.println("s_zrateid:"+s_zrateid);
		if(s_zrateid!=null && !s_zrateid.equals(""))
		{
			String zr[]=s_zrateid.split(",");
			for(int z=0;z<zr.length;z++){
				if(zr[z]!=null&&!zr[z].equals("")&&!zr[z].equals(" ")&&zr[z].trim().length()>0){
					if(zr[z].indexOf("@")!=-1){
						//List<Zrate> listzrate=Server.getInstance().getAirService().findAllZrate(" where 1=1 and "+Zrate.COL_outid+" ='"+zr[z].split("@")[0].trim()+"' AND "+Zrate.COL_agentid+" ="+zr[z].split("@")[1].trim(), "", -1, 0);
						//zratelist.add(listzrate.get(0).getId());
						
						
						//ZrateServer.getInstance().setUrl("http://219.142.105.21:28080");
						//Server.getInstance().setInter("http://219.142.105.21:8080/ticket_inter/service/");
						 Zrate redrate = ZrateServer.getInstance().findZrate(Long.parseLong(zr[z].split("@")[1].trim()), "*$"+zr[z].split("@")[0].trim());
						 zratelist.add(redrate.getId());
					}
				
				}
			}
			/*zratelist.add(Long.parseLong(s_zrateid));
			if(listseg.size()>1)
			{
				zratelist.add(Long.parseLong(s_zrateid));
			}*/
		}
		else
		{
			zratelist.add(0l);
		}
		
		/****本地政策赋值开始*****************************************/ 



		// 安检费
		if (s_totalanjian != null) {
			orderinfo.setTotalanjian(Float.parseFloat(s_totalanjian));
		} else {
			orderinfo.setTotalanjian(0f);
		}
		// 其他费用
		if (s_totalotherfee != null) {
			orderinfo.setTotalotherfee(Float.parseFloat(s_totalotherfee));
		} else {
			orderinfo.setTotalotherfee(0f);
		}
		orderinfo.setMemo(s_memo);

		orderinfo.setPnr(strPNR);
		orderinfo.setPattxt(strPATTXT.trim().replaceAll(">", "").trim());
		orderinfo.setPnrtxt(strPNRTXT.trim().replaceAll(">", "").trim());
		
		
		//创建订单信息
		forwork=CreateOrder2(listseg,listpass,orderinfo,zratelist, s_insurancevalues,"",2);

		return "ticketorder";
	}
	
	
	
	
	/*********创建订单**********************************************************************/

	/**
	 * ***************************importpnr********************************************
	 * 通过PNR生成订单 ticketquanprice
	 */
	public String createPNROrder() throws Exception {
		boolean isDeskOperator = this.isCounterPeople();// 是否为柜台人员
		listseg = (List<Segmentinfo>) ActionContext.getContext().getSession()
				.get("pnrsegment");
		listpass = (List<Passenger>) ActionContext.getContext().getSession()
				.get("pnrpassenger");
		long orderidtemp = 0l;
		orderinfo.setId(-1);
		orderinfo.setOrdernumber("");
		// 插入订单
		orderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		// 大客户会员ID
		Customeruser user =getLoginUser();
		orderinfo.setCustomeruserid(user.getId());
		orderinfo.setCustomeragentid(getLoginUserAgent().getId());
		// 小配置
		if (etermtype == 1) {
			orderinfo.setPnr(strPNR);
		}
		else if (etermtype == 2) {
			orderinfo.setBigpnr(strPNR);
		}
		// 分销商单位ID
		// 分销商单位ID
		Customeruser customeruser = getLoginUser();
		orderinfo.setBuyagentid(customeruser.getAgentid());
		orderinfo.setPostmoney(0);
		orderinfo.setContactname(user.getMembername());
		orderinfo.setContactmobile(user.getMobile());

		if (isinter == 1) {
			orderinfo.setInternal(1l); // 1未国际票，如果是0或者NULL则为国内票
		} else {
			orderinfo.setInternal(0l);
		}
		// 等待支付
		orderinfo.setOrderstatus(Integer.parseInt(s_orderstatuspnr));
//		if (s_orderstatuspnr.equals("3")) {
//			orderinfo.setPrinttime(new Timestamp(System.currentTimeMillis()));
//		}
		//机建费
		float subairportfee=0;
		//燃油费
		float subfuelfee=0;
		//票面价
		float subticketfee=0;
		for(Passenger passenger:listpass)
		{
			subairportfee+=passenger.getAirportfee();
			subfuelfee+=passenger.getFuelprice();
			subticketfee+=passenger.getPrice();
		}
		// 机建费
		orderinfo.setTotalairportfee(subairportfee);
		// 燃油费
		orderinfo.setTotalfuelfee(subfuelfee);
		// 票面价格
		orderinfo.setTotalticketprice(subticketfee);
		// 折扣比例
		orderinfo.setFenxiaoshangfandian(Float.parseFloat(zhekoubili + ""));
		orderinfo.setRatevalue(s_zongfandian);
		Float flirun = s_zongfandian / 100 * s_piaomianjia;
		int intlirun = flirun.intValue();
		orderinfo.setRebatemoney(Float.parseFloat(intlirun + ""));
//		orderinfo.setBackpointinfo(getCustomerBackPointString(
//				getLoginUserAgent(), s_zongfandian,
//				Getliudianvalue(s_zongfandian), s_piaomianjia));
		// 折扣金额
		try {
			orderinfo.setZhekoujine(Float.parseFloat(s_zhekoujine));
		} catch (Exception ex) {
			orderinfo.setZhekoujine(0f);
		}
		// 安检费
		if (s_totalanjian != null) {
			orderinfo.setTotalanjian(Float.parseFloat(s_totalanjian));
		} else {
			orderinfo.setTotalanjian(0f);
		}
		// 其他费用
		if (s_totalotherfee != null) {
			orderinfo.setTotalotherfee(Float.parseFloat(s_totalotherfee));
		} else {
			orderinfo.setTotalotherfee(0f);
		}
		
		orderinfo.setPaymethod(s_paymethods); // 支付方式
		orderinfo.setFenxiaoshangfandian(s_zhekoubili);

		Float fs_zonglirun = Float.parseFloat(s_zonglirun);
		// 如果含有保险则每张保险增加10元返佣
		if (this.s_insurance > 0) {
			fs_zonglirun = fs_zonglirun + 10 * s_insurance;
		}
		orderinfo.setRebatemoney(fs_zonglirun);
		if (s_paymethods == 2) {
			orderinfo.setPaystatus(0); // 已支付
			// 虚拟账户支付，已支付，等待出票
			orderinfo.setOrderstatus(27);
		}
		// 月结支付
		else if (s_paymethods == 5) {
			orderinfo.setPaystatus(0); // 未支付
			// 月结支付，未支付，等待出票
			orderinfo.setOrderstatus(2);
		} else {
			orderinfo.setPaystatus(0); // 未支付
			// 网上支付，未支付，等待支付
			orderinfo.setOrderstatus(1);
			if (s_paymethods == 3) {
				orderinfo.setReceipt(4);// 4：市内配送。参照东航。
			}
		}
		orderinfo.setLanguage(0);
		// 快递行程单发票收取费用20，其他不收取费用
		if (orderinfo.getReceipt() != null) {
			if (orderinfo.getReceipt() == 3) {
				orderinfo.setPostmoney(20);
			} else {
				orderinfo.setPostmoney(0);
			}
		}
		orderinfo.setOrdertype(2l);// 后台订单2
		orderinfo.setBusystatus(s_busystatus);
		orderinfo.setMemo(s_memo);
		// 员工ID
		orderinfo.setSaleagentid(getLoginUserId());
		if (orderinfo.getPrinttime() == null) {
			orderinfo.setPrinttime(dateToTimestamp(s_printtime));
		}
		// 是否是升舱补差订单
		if (s_isexchorder && s_exchordertn.length() > 0) {
			long lexcorderid;
			List<Passenger> listexcpass = Server.getInstance().getAirService()
					.findAllPassenger(
							"where " + Passenger.COL_ticketnum + "='"
									+ s_exchordertn + "'", "", -1, 0);
			if (listexcpass.size() > 0) {
				try {
					lexcorderid = listexcpass.get(0).getOrderid();
					Orderinfo excorder = Server.getInstance().getAirService()
							.findOrderinfo(lexcorderid);
					orderinfo.setShengcangorderid(excorder.getId());
				} catch (Exception e) {

				}
			}
			orderinfo.setIsshengcang(1l); // 此订单为升舱补差订单
			orderinfo.setShengcangoldtn(s_exchordertn);
		}
		// System.out.println(orderinfo.getReceipt());
		// 11：已废票，12，已退票，1,未出票 2，支付成功，等待出票 3,出票完成 6.已取消
		orderinfo.setCashier(0);
		orderinfo = Server.getInstance().getAirService().createOrderinfo(
				orderinfo);

		if (idtemp == 0) {
			idtemp = orderinfo.getId();
		}
		String strExcDesc = "";
		if (s_isexchorder && s_exchordertn.length() > 0) {
			strExcDesc = "此订单为升舱补差订单，原票号：" + s_exchordertn;
			orderinfo.setMemo(orderinfo.getMemo() + strExcDesc);
		}
		orderinfo.setOrdernumber(Server.getInstance().getServiceCenter()
				.getOrderinfoCode(orderinfo));
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);

		if (s_isexchorder && s_exchordertn.length() > 0) {
			strExcDesc = "，<font color='red'><b>此订单为升舱补差订单，原票号："
					+ s_exchordertn + "</b></font>";
		}
		orderinforc.setContent("PNR导入-" + getLoginUser().getMembername()
				+ "导入了订单,订单状态为" + getStateToString(orderinfo.getOrderstatus())
				+ strExcDesc);
		if (!s_orderstatuspnr.equals("3")) {
			orderinforc.setCustomeruserid(getLoginUserId());
		}

		// 记录操作记录结束
		for (int i = 0; i < listseg.size(); i++) {
			Segmentinfo segmentinfo = new Segmentinfo();
			segmentinfo = listseg.get(i);
			segmentinfo.setOrderid(orderinfo.getId());

			segmentinfo.setLanguage(0);
			if (listpass.size() > 0) {
				try {
					segmentinfo.setPrice(listpass.get(0).getPrice());
					float ddiscount = listpass.get(0).getPrice()
							/ segmentinfo.getYprice() * 100;
					float mdiscount = (float) Math.round(ddiscount / 10);
					segmentinfo.setDiscount(Float
							.parseFloat(formatMoney(mdiscount)));
					// 总返点
					segmentinfo.setRatevalue(s_zongfandian);
					// 票面价
					segmentinfo.setParvalue(s_piaomianjia);
					// 政策id
					segmentinfo.setZrateid(Long.parseLong(s_zrateid));
				} catch (Exception ex) {
					segmentinfo.setPrice(listpass.get(0).getPrice());
					segmentinfo.setDiscount(0.0f);
				}
			}
			segmentinfo = Server.getInstance().getAirService()
					.createSegmentinfo(segmentinfo);
		}
		int suminsurance = 0;
		int intindex = -1;
		// 插入乘机人
		Segmentinfo segment = new Segmentinfo();
		for (Segmentinfo s : listseg) {
			if (s.getOrderid() == orderinfo.getId()) {
				segment = s;
				break;
			}

		}
		String strOptdesc = "";

		/**
		 * 柜台 非柜台 柜台人员导入废票 退票后的订单默认状态应为已收银的并已审核通过的 除了柜台人员以外的人员导入废票
		 * 退票的订单状态应为申请退废票状态，已收银,需要进行退废票审核， 审核不通过的话，仍然为申请退废票状态（或可考虑增加“取消订单”按钮）
		 * 
		 */

		if (isDeskOperator) {// 即为柜台人员 导入正常PNR 票号 为订单关闭（补出票记录）
			// 导入 退票废票为审核过废票退票 补出票记录，收银记录
			orderinfo.setCashier(1);
			String strcontent = "";
			if (s_orderstatuspnr.equals("3")) {// 正常PNR，票号
				orderinfo.setOrderstatus(10);
				strcontent = "PNR导入--" + this.getLoginUser().getMembername()
						+ "导入了订单,订单状态为出票完成(补 柜台正常出票 )";
				// 补出票记录
				Orderinforc orderinforc = new Orderinforc();
				orderinforc.setCustomeruserid(getLoginUserId());
				orderinforc.setOrderinfoid(orderinfo.getId());
				orderinforc.setCreatetime(new Timestamp(System
						.currentTimeMillis()));
				orderinforc.setSuouserid(orderinfo.getUserid());
				orderinforc.setState(3);
				orderinforc.setContent(strcontent);
				orderinforc.setCustomeruserid(getLoginUserId());
				Server.getInstance().getAirService().createOrderinforc(
						orderinforc);

			}
			strOptdesc += "PNR导入--" + this.getLoginUser().getMembername()
					+ "导入了订单，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());// 订单备注；

		} else {// 非柜台
			// 待收银
			if (s_orderstatuspnr.equals("3")
					&& !(converNull(orderinfo.getReceipt(), 0) == 4)) {// 0：未支付
				// 补出票
				String strcontent = "";// 订单备注；
				Orderinforc orderinforc = new Orderinforc();
				orderinforc.setCustomeruserid(getLoginUserId());
				orderinforc.setOrderinfoid(orderinfo.getId());
				orderinforc.setCreatetime(new Timestamp(System
						.currentTimeMillis()));
				orderinforc.setSuouserid(orderinfo.getUserid());
				orderinforc.setState(3);
				orderinforc.setContent(strcontent);
				orderinforc.setCustomeruserid(getLoginUserId());
				Server.getInstance().getAirService().createOrderinforc(
						orderinforc);
				// 3：出票完成。
				orderinfo.setOrderstatus(29);// 待收银

			}
			// 需配送
			if (s_orderstatuspnr.equals("3")
					&& (converNull(orderinfo.getReceipt(), 0) == 4)) {
				orderinfo.setOrderstatus(3);
			}
			strOptdesc += "PNR导入--" + this.getLoginUser().getMembername()
					+ "导入了订单，订单状态为"
					+ getStateToString(orderinfo.getOrderstatus());// 订单备注；

		}
		// 导入废票，退票 //补出票，补收银操作记录
		if (s_orderstatuspnr.equals("11") || s_orderstatuspnr.equals("12")) {// 审核通过废票
			orderinfo.setCashier(1);// 为已收银 审核通过的
			// String strcontent = "";
			// String shouyin = "";
			if (s_orderstatuspnr.equals("11")) {// 审核通过退票
				/*
				 * strcontent = "PNR导入--" + this.getLoginUser().getMembername() +
				 * "导入了订单,订单状态为出票完成(废票导入，补出票)"; shouyin = "PNR导入--" +
				 * this.getLoginUser().getMembername() +
				 * "导入了订单,订单状态为订单关闭(废票导入，补收银)";
				 */
				if (!isDeskOperator) {
					orderinfo.setOrderstatus(5);
				}

			}
			if (s_orderstatuspnr.equals("12")) {
				/*
				 * strcontent = "PNR导入--" + this.getLoginUser().getMembername() +
				 * "导入了订单,订单状态为已出票完成(退票导入，补出票)"; shouyin = "PNR导入--" +
				 * this.getLoginUser().getMembername() +
				 * "导入了订单,订单状态为订单关闭(退票导入，补收银)";
				 */
				if (!isDeskOperator) {
					orderinfo.setOrderstatus(4);
				}
			}

		}
		// 个人挂账记录
		if (orderinfo.getFkmethod() != null && orderinfo.getFkmethod() > 0
				&& orderinfo.getFkmethod() == 7) {
			Gerenguazhanfrec grc = new Gerenguazhanfrec();
			grc.setOrderid(orderinfo.getId());
			System.out.print(orderinfo.getGuazhangrenid());
			grc.setEmployeeid(orderinfo.getGuazhangrenid());
			grc.setCreatetime(new Timestamp(System.currentTimeMillis()));
			grc.setCreateuser(String.valueOf(this.getLoginUserId()));
			grc.setState(0l);
			Server.getInstance().getMemberService().createGerenguazhanfrec(grc);
		}
		// ********操作乘机人*************
		for (Passenger passenger : listpass) {
			intindex++;
			passenger.setOrderid(orderinfo.getId());
			passenger.setTickettypeid(this.s_tickettypeid);
			passenger.setFet("");
			passenger.setDiscount(0f);
			passenger.setState(0);

			if (s_orderstatuspnr.equals("3")) {

				passenger.setState(1);
				if (passenger.getRttime() == null) {
					passenger.setRttime(new Timestamp(System
							.currentTimeMillis()));
				}
			}
			if (s_orderstatuspnr.equals("4")) {

				passenger.setState(11);
				if (passenger.getRttime() == null) {
					passenger.setRttime(new Timestamp(System
							.currentTimeMillis()));
				}
			}
			if (s_orderstatuspnr.equals("11") || s_orderstatuspnr.equals("12")) {
				String tuipricestr = ServletActionContext.getRequest()
						.getParameter("poundage");
				Float tuiprice = Float.valueOf(converTrim(converNull(
						tuipricestr, "0"), "0"));
				passenger.setTuifee(tuiprice);
				passenger.setTuifeiyuanyi(tui_yuanyi);
				passenger.setIscabinsite(tui_iscabinsite);
				if (passenger.getRttime() == null) {
					passenger.setRttime(new Timestamp(System
							.currentTimeMillis()));
				}
				if (s_tuifeitime != null && !s_tuifeitime.equals("")) {
					passenger.setTuifeitime(dateToTimestamp(s_tuifeitime));
				}
				passenger.setTuifeidesc(s_tuifeireason);
				if (s_orderstatuspnr.equals("11")) {
					if (isDeskOperator) {
						passenger.setState(2);

					} else {
						passenger.setState(5);
					}
					strOptdesc = "废票-" + getLoginUser().getMembername()
							+ "执行了废票操作，订单状态为"
							+ getStateToString(orderinfo.getOrderstatus())
							+ "<br />退票备注：柜台订单执行了废票操作";
				}
				if (s_orderstatuspnr.equals("12")) {
					if (isDeskOperator) {
						passenger.setState(3);
					} else {
						passenger.setState(4);
					}
					strOptdesc = "退票-" + getLoginUser().getMembername()
							+ "执行了退票操作，订单状态为"
							+ getStateToString(orderinfo.getOrderstatus())
							+ "<br />退票备注：柜台订单执行了退票操作";
				}
			}
			String poundage = ServletActionContext.getRequest().getParameter(
					"poundage");
			if (poundage != null && !poundage.trim().equals("")) {
				float tuifee = 0f;
				try {
					tuifee = Float.valueOf(poundage);
				} catch (Exception e) {
				}
				passenger.setTuifee(tuifee);
			}
			passenger.setIdtype(1);
			passenger.setIdnumber(idnumber.split(",")[intindex]);
			passenger.setLanguage(0);
			passenger.setHkstate(1l);
			passenger.setMobile(mobile.split(",")[intindex]);
			suminsurance = suminsurance;
		//	passenger.setInsurance(0l);

			/*
			 * 处理保险情况
			 */
			float insurprice = 0f;// 保险金额
			if (this.s_insurance > 0) {
				String inseruancetype = ServletActionContext.getRequest()
						.getParameter("insurancetype");
				String money = ServletActionContext.getRequest().getParameter(
						"baoxianjine");
				insurprice = Float.valueOf(converNull(money, "0"));
				String baodanhao = ServletActionContext.getRequest()
						.getParameter("baodanhao");
				Insuranceinfo insurance = new Insuranceinfo();
				insurance.setCompanyname(inseruancetype);
				insurance.setInsurancename(inseruancetype + "航空意外保险");
				insurance.setInsurancenum(s_insurance);
				insurance
						.setCreatetime(dateToTimestamp(formatTimestamp2(segment
								.getDeparttime())));
				Timestamp t = new Timestamp(insurance.getCreatetime().getTime());
				t.setDate(t.getDate() + 7);
				insurance.setEnddate(t);
				insurance.setOrdernumber(baodanhao);
				insurance.setInsurancefee(money);
				insurance.setInsurancestate(1);// 未录入
				insurance.setBeibaoren(passenger.getName());
				insurance.setToubaoren(passenger.getName());
				insurance = Server.getInstance().getMemberService()
						.createInsuranceinfo(insurance);
				//passenger.setInsurance(insurance.getId());
			}
			if (isDeskOperator) {// 柜台人员
				if (orderinfo.getFkmethod() != 7
						&& orderinfo.getFkmethod() != 8) {
					passenger.setHkstate(2l);
					float allprice = converNull(passenger.getPrice(), 0f)
							+ converNull(passenger.getAirportfee(), 0f)
							+ converNull(passenger.getFuelprice(), 0f)
							+ insurprice;
					passenger.setYihai(allprice);
					passenger.setHaiqian(0f);
				}
			} else {

			}

			passenger = Server.getInstance().getAirService().createPassenger(
					passenger);
			listPassenger.add(passenger);
		}

		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		String smstemple = "";
		try {
			if (s_orderstatuspnr.equals("3")) {
				// 发送出票短信
				try {

					String Pname = "";
					String strallPassenger = "";
					for (int i = 0; i < listPassenger.size(); i++) {
						Pname = listPassenger.get(i).getName();
						strallPassenger += Pname + ""
								+ listPassenger.get(i).getIdnumber() + ",";
					}
					// 给每个乘机人发送出票短信
					for (int i = 0; i < listPassenger.size(); i++) {
						HttpServletRequest request = ServletActionContext
								.getRequest();
						String[] strfeiyouarr = request
								.getParameterValues("feiyouarr_" + i);
						if (strfeiyouarr != null && strfeiyouarr.length > 0) {
							smstemple = this.getSMSTemple("AOrderInform");
							smstemple = smstemple.replaceAll("@aircompanyto@",
									this.getAircomapnycodeByEZM(listseg.get(0)
											.getAircomapnycode()));
							smstemple = smstemple.replaceAll("@airlineto@",
									listseg.get(0).getFlightnumber());
							smstemple = smstemple.replaceAll("@startcityto@",
									getAirportbySZM(listseg.get(0)
											.getStartairport()));
							smstemple = smstemple.replaceAll("@endcityto@",
									getAirportbySZM(listseg.get(0)
											.getEndairport()));
							if (listseg.get(0).getBorderpointat() != null) {
								smstemple = smstemple.replaceAll(
										"@startcityloginto@", listseg.get(0)
												.getBorderpointat());
							} else {
								smstemple = smstemple.replaceAll(
										"@startcityloginto@", "");
							}
							smstemple = smstemple.replaceAll("@starttimeto@",
									formatTimestamp2(listseg.get(0)
											.getDeparttime())
											+ " "
											+ formatTimestamp3(listseg.get(0)
													.getDeparttime()));
							smstemple = smstemple.replaceAll("@endtimeto@",
									formatTimestamp3(listseg.get(0)
											.getArrivaltime()));
							smstemple = smstemple.replaceAll("@allpassenger@",
									strallPassenger);
							System.out.println(smstemple);
							// 发送短信
							String[] mobiles = {};
							mobiles = new String[] { ""
									+ listPassenger.get(i).getMobile() + "" };
							Server.getInstance().getAtomService().sendSms(
									mobiles, smstemple,
									orderinfo.getOrdernumber(), "");
						}

					}
					// 发送接机短信
					// 调用飞友短信接口给乘机人和街机人定制短信
					// 取得行程信息
					String Flightdate = "";
					String Fno = "";
					String Dep = "";
					String Arr = "";
					String Pnamefy = "";
					String strallPassengerfy = "乘机人信息：";
					List<Segmentinfo> listsegmentinfo = Server.getInstance()
							.getAirService().findAllSegmentinfo(
									"where " + Segmentinfo.COL_orderid + "="
											+ orderinfo.getId(), "", -1, 0);
					if (listsegmentinfo.size() > 0) {
						Flightdate = formatTimestamp2(listsegmentinfo.get(0)
								.getDeparttime());
						Fno = listsegmentinfo.get(0).getFlightnumber();
						Dep = listsegmentinfo.get(0).getStartairport();
						Arr = listsegmentinfo.get(0).getEndairport();
						Orderinfo orderinfoold = Server.getInstance()
								.getAirService().findOrderinfo(
										orderinfo.getId());
						// 发送接机人短信
						if (orderinfoold.getPickonephone() != null
								&& !orderinfoold.getPickonephone().equals("")) {
							// :hanmh
							// Server.getInstance().getAtomService()
							// .sendFeiyouSms(
							// orderinfoold.getPickonephone(),
							// Flightdate, Fno, Dep, Arr,
							// orderinfoold.getPickonename(), "1",
							// orderinfoold.getOrdernumber());
						}
						// 取得乘机人信息
						List<Passenger> listpassenger = Server.getInstance()
								.getAirService().findAllPassenger(
										"where " + Passenger.COL_orderid + "="
												+ orderinfo.getId(), "", -1, 0);
						if (listpassenger.size() > 0) {
							for (int w = 0; w < listpassenger.size(); w++) {
								try {
									// 如果是联系人也在乘机人中，则不发送出票短信
									// 发送乘机人短信
									HttpServletRequest request = ServletActionContext
											.getRequest();
									String[] strtongzhismsarr = request
											.getParameterValues("tongzhismsarr_"
													+ w);
									if (strtongzhismsarr != null
											&& strtongzhismsarr.length > 0) {
										if (!orderinfo.getContactmobile()
												.equals(
														listpassenger.get(w)
																.getMobile())) {
											// hanmh：方法已改，参照东航。
											// Server
											// .getInstance()
											// .getAtomService()
											// .sendFeiyouSms(
											// listpassenger.get(w)
											// .getMobile(),
											// Flightdate,
											// Fno,
											// Dep,
											// Arr,
											// Pnamefy,
											// "0",
											// orderinfoold
											// .getOrdernumber());
										}
									}
								} catch (Exception ex) {
								}
							}
							// hanmh：方法已改，参照东航。
							// Server.getInstance().getAtomService()
							// .sendFeiyouSms(
							// orderinfoold.getContactmobile(),
							// Flightdate, Fno, Dep, Arr, Pnamefy,
							// "0", orderinfoold.getOrdernumber());
						}
						if (istianxuntong == 1) {
							// 给联系人发送出票短信
							String[] mobiles1 = {};
							mobiles1 = new String[] { ""
									+ orderinfo.getContactmobile() + "" };
							Server.getInstance().getAtomService().sendSms(
									mobiles1, smstemple,
									orderinfo.getOrdernumber(), "");
						}
					}
				} catch (Exception ex) {
				}
			}
		} catch (Exception ex) {

		}
		Orderinforc orderinforc = new Orderinforc();
		orderinforc.setCustomeruserid(getLoginUserId());
		orderinforc.setOrderinfoid(orderinfo.getId());
		orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		orderinforc.setSuouserid(orderinfo.getUserid());
		orderinforc.setState(orderinfo.getOrderstatus());
		orderinforc.setContent(strOptdesc);
		orderinforc.setCustomeruserid(getLoginUserId());
		Server.getInstance().getAirService().createOrderinforc(orderinforc);

		forwork = "b2bticketorder!payorder.action?orderinfo.id="
				+ orderinfo.getId();
		return "ticketorder";

	}

	/**
	 * ***********************importpnr end
	 * *************************************************************************
	 */

	/**
	 * @return
	 */
	public boolean isGTPeople() {
		if (super.getLoginUserRoleNumber().contains(10041l)) {
			return true;
		}
		return false;
	}

	public Customeruser getCustomeruserById(long id) {
		Customeruser user = new Customeruser();
		Customeruser u = Server.getInstance().getMemberService()
				.findCustomeruser(id);
		if (u != null)
			user = u;
		return user;
	}

	/**
	 * 是否为柜台人员
	 * 
	 * @return
	 */
	public boolean isCounterPeople() {
		List<Long> rolelist = getLoginUserRoleNumber();
		if (rolelist.contains(10041l) || rolelist.contains(10042l)
				|| rolelist.contains(10055l) || rolelist.contains(10056l)) {
			return true;
		}
		return false;
	}

	/*
	 * Ajax更新航程Session中的信息
	 */
	public void changeSessionSegByAjax() {
		listseg = (List<Segmentinfo>) ActionContext.getContext().getSession()
				.get("pnrsegment");

		if (s_cname.equals("departtime")) {
			listseg.get(s_cindex).setDeparttime(dateToTimestamp(s_cvalue+":00:00" ));
		}
		if (s_cname.equals("arrivaltime")) {
			listseg.get(s_cindex).setArrivaltime(dateToTimestamp(s_cvalue+":00:00" ));
		}
		if (s_cname.equals("cabincode")) {
			listseg.get(s_cindex).setCabincode(s_cvalue);
		}
		if (s_cname.equals("txtdiscount")) {
			listseg.get(s_cindex).setDiscount(Float.parseFloat(s_cvalue));
		}
		if (s_cname.equals("txtyprice")) {
			listseg.get(s_cindex).setYprice(Float.parseFloat(s_cvalue));
		}
		ActionContext.getContext().getSession().put("pnrsegment", listseg);
	}

	/*
	 * Ajax更新航程Session中的信息
	 */
	public void changeSessionPassByAjax() {
		listpass = (List<Passenger>) ActionContext.getContext().getSession()
				.get("pnrpassenger");
		if (s_cname.equals("idnumber")) {
			listpass.get(s_cindex).setIdnumber(s_cvalue);
		}
		if (s_cname.equals("ticketprice")) {
			if (s_cvalue.equals("")) {
				s_cvalue = "0";
			}
			listpass.get(s_cindex).setPrice(Float.parseFloat(s_cvalue));
		}
		if (s_cname.equals("taxprice")) {
			if (s_cvalue.equals("")) {
				s_cvalue = "0";
			}
			listpass.get(s_cindex).setAirportfee(Float.parseFloat(s_cvalue));
		}
		if (s_cname.equals("yqprice")) {
			if (s_cvalue.equals("")) {
				s_cvalue = "0";
			}
			listpass.get(s_cindex).setFuelprice(Float.parseFloat(s_cvalue));
		}
		if (s_cname.equals("txtticnumber")) {
			listpass.get(s_cindex).setTicketnum(s_cvalue);
		}
		if (s_cname.equals("txtrpnumber")) {
			listpass.get(s_cindex).setFet(s_cvalue);
		}
		if (s_cname.equals("anjianfee")) {
			if (s_cvalue.equals("")) {
				s_cvalue = "0";
			}
			listpass.get(s_cindex).setAnjianfee(Float.parseFloat(s_cvalue));
		}
		if (s_cname.equals("otherfee")) {
			if (s_cvalue.equals("")) {
				s_cvalue = "0";
			}
			listpass.get(s_cindex).setOtherfee(Float.parseFloat(s_cvalue));
		}
		if (s_cname.equals("ticketquanprice")) {
			if (s_cvalue.equals("")) {
				s_cvalue = "0";
			}
			listpass.get(s_cindex).setYuanprice(Float.parseFloat(s_cvalue));
		}

		ActionContext.getContext().getSession().put("pnrpassenger", listpass);
	}

	/*
	 * Ajax插入乘机人信息
	 */
	public void addSessionPassByAjax() {
		listpass = (List<Passenger>) ActionContext.getContext().getSession()
				.get("pnrpassenger");
		if (listpass.get(s_cindex) != null) {
			Passenger passenger = listpass.get(s_cindex);
			listpass.add(passenger);
		}

		ActionContext.getContext().getSession().put("pnrpassenger", listpass);
	}

	public String createPNR() throws Exception {// 换开时创建订单
		listseg = (List<Segmentinfo>) ActionContext.getContext().getSession()
				.get("pnrsegment");
		listpass = (List<Passenger>) ActionContext.getContext().getSession()
				.get("pnrpassenger");
		long orderidtemp = 0l;
		Segmentinfo segmentOne = new Segmentinfo();
		Segmentinfo segmentTwo = new Segmentinfo();
		if (listseg.size() == 1) {
			segmentOne = listseg.get(0);
		} else if (listseg.size() == 2) {
			segmentTwo = listseg.get(1);
		}

		for (int i = 0; i < listseg.size(); i++) {
			if (i == 0) {
				// 插入订单
				orderinfo.setCreatetime(new Timestamp(System
						.currentTimeMillis()));
				// 分销商员工ID
				orderinfo.setCustomeruserid(getLoginUserId());
				orderinfo.setPnr(strPNR);

				// 分销商单位ID
				// 分销商单位ID
				Customeruser customeruser = getLoginUser();
				orderinfo.setBuyagentid(angenid);// 分销商ID
				orderinfo.setPostmoney(0);
				// 送票方式 有邮寄金额决定
				if (orderinfo.getPostmoney() == 0) {
					orderinfo.setReceipt(1);
				}
				if (orderinfo.getPostmoney() == 5) {
					orderinfo.setReceipt(2);
				}
				if (orderinfo.getPostmoney() == 20) {
					orderinfo.setReceipt(3);
				}
				// 等待支付
				orderinfo.setOrderstatus(Integer.parseInt(s_orderstatuspnr));
				// 机建费
				orderinfo.setTotalairportfee(Float.parseFloat(yqprice
						.split(",")[0])
						* listpass.size());
				// 燃油费
				orderinfo.setTotalfuelfee(Float
						.parseFloat(taxprice.split(",")[0])
						* listpass.size());
				// 票面价格
				orderinfo.setTotalticketprice(Float.parseFloat(ticketprice
						.split(",")[0])
						* listpass.size());

				// 支付状态
				orderinfo.setPaystatus(0); // 未支付
				orderinfo.setLanguage(0);
				orderinfo.setOrdertype(2l);// 后台订单2
				orderinfo = Server.getInstance().getAirService()
						.createOrderinfo(orderinfo);
				idtemp = orderinfo.getId();
				orderinfo.setOrdernumber(Server.getInstance()
						.getServiceCenter().getOrderinfoCode(orderinfo));
				orderinfo.setCustomeruserid(userid);
				orderinfo.setGaiorderid(orderinfoid);
				Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
						orderinfo);

				segmentOne.setOrderid(orderinfo.getId());
				segmentOne.setLanguage(0);
				segmentOne = Server.getInstance().getAirService()
						.createSegmentinfo(segmentOne);

				int suminsurance = 0;
				int intindex = -1;
				// 插入乘机人
				for (Passenger passenger : listpass) {
					intindex++;
					passenger.setOrderid(orderinfo.getId());
					passenger.setFet("");
					passenger.setDiscount(0f);
					passenger.setState(0);
					passenger.setIdtype(1);
					passenger.setIdnumber(idnumber.split(",")[intindex]);
					passenger.setLanguage(0);
					suminsurance = suminsurance;
					passenger = Server.getInstance().getAirService()
							.createPassenger(passenger);
					listPassenger.add(passenger);
				}

				Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
						orderinfo);
			}

			if (i == 1) {
				Orderinfo orderinfotwo = new Orderinfo();
				orderinfotwo.setRelationorderid(idtemp);
				// 插入订单
				orderinfotwo.setCreatetime(new Timestamp(System
						.currentTimeMillis()));
				// 分销商员工ID
				orderinfotwo.setCustomeruserid(getLoginUserId());
				orderinfotwo.setPnr(strPNR);
				// 分销商单位ID
				// 分销商单位ID
				Customeruser customeruser1 = getLoginUser();
				orderinfotwo.setBuyagentid(customeruser1.getAgentid());
				orderinfotwo.setPostmoney(0);
				// 送票方式 有邮寄金额决定
				if (orderinfotwo.getPostmoney() == 0) {
					orderinfotwo.setReceipt(1);
				}
				if (orderinfotwo.getPostmoney() == 5) {
					orderinfotwo.setReceipt(2);
				}
				if (orderinfotwo.getPostmoney() == 20) {
					orderinfotwo.setReceipt(3);
				}
				// 等待支付
				orderinfotwo.setOrderstatus(Integer.parseInt(s_orderstatuspnr));
				// 机建费
				orderinfotwo.setTotalairportfee(Float.parseFloat(yqprice
						.split(",")[0])
						* listpass.size());
				// 燃油费
				orderinfotwo.setTotalfuelfee(Float.parseFloat(taxprice
						.split(",")[0])
						* listpass.size());
				// 票面价格
				orderinfotwo.setTotalticketprice(Float.parseFloat(ticketprice
						.split(",")[0])
						* listpass.size());

				// 支付状态
				orderinfotwo.setPaystatus(0); // 未支付
				orderinfotwo.setLanguage(0);
				orderinfotwo.setOrdertype(2l);// 后台订单2
				orderinfotwo = Server.getInstance().getAirService()
						.createOrderinfo(orderinfotwo);
				orderidtemp = orderinfotwo.getId();
				orderinfotwo.setOrdernumber(Server.getInstance()
						.getServiceCenter().getOrderinfoCode(orderinfotwo));

				Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
						orderinfotwo);

				segmentTwo.setOrderid(orderinfotwo.getId());
				segmentTwo.setLanguage(0);
				segmentTwo = Server.getInstance().getAirService()
						.createSegmentinfo(segmentTwo);

				int suminsurance1 = 0;
				int intindex1 = -1;
				// 插入乘机人
				for (Passenger passenger : listpass) {
					intindex1++;
					passenger.setOrderid(orderinfotwo.getId());
					passenger.setFet("");
					passenger.setFuelprice(Float
							.parseFloat(yqprice.split(",")[0]));
					passenger.setAirportfee(Float.parseFloat(taxprice
							.split(",")[0]));
					passenger.setDiscount(0f);
					passenger.setPrice(Float
							.parseFloat(ticketprice.split(",")[0]));
					System.out.println(ticketquanprice.split(",")[0]);
					passenger.setYuanprice(Float.parseFloat(ticketquanprice
							.split(",")[0]));
					passenger.setState(0);
					passenger.setIdtype(1);
					passenger.setIdnumber(idnumber.split(",")[intindex1]);
					passenger.setLanguage(0);
					suminsurance1 = suminsurance1;
					passenger = Server.getInstance().getAirService()
							.createPassenger(passenger);
					listPassenger.add(passenger);
				}

				Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
						orderinfotwo);
			}
		}
		Orderinfo or = Server.getInstance().getAirService().findOrderinfo(
				orderinfoid);
		or.setOrderstatus(24);// 把以前的订单改状态为已换开
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(or);
		forwork = "orderinfo!toshengcang.action?s_orderstatus=23";
		return "huankai";

	}

	/**
	 * 通过pnr预订界面创建订单
	 * 
	 * @param pnr
	 * @return
	 */
	public String createOrderByPnr() {
		return "";
	}

	public String getPassTypeToString(Integer id) {
		switch (id) {
		case 1:
			return "成人";
		case 2:
			return "儿童";
		case 3:
			return "婴儿";
		default:
			return "未知类型";
		}
	}

	public String getPayMethod(Integer id) {
		switch (id) {
		case 0:
			return "未支付";
		case 1:
			return "已支付";
		default:
			return "未知状态";
		}
	}

	public static String getIDTypeToString(int id) {
		switch (id) {
		case 1:
			return "身份证";
		case 2:
			return "驾驶证";
		case 3:
			return "护照";
		case 4:
			return "港澳通行证";
		case 5:
			return "台湾通行证";
		case 6:
			return "台胞证";
		case 7:
			return "回乡证";
		default:
			return "其他";
		}
	}

	// 订单状态:1.等待支付2.支付成功3.出票完成4.申请废票5.申请退票6.取消订单7.等待审核8.审核失败9.退款成功10.订单关闭
	// 11.已经废票12.已经退票13.申请改签14.已经改签15,改签失败，16，暂不能出票，17，退票不成功 18 "退票退款成功";
	// 19:"问题订单"; 23:n "申请升舱"; 24: "已换开";
	// 25: "升舱换开成功"; 26: "升舱失败"; 27: "待确认"; 28: "在途订单"; 29: "待收银"; 30:
	// "申请换开";defalut "新订单";
	public String getStateToString(Integer id) {
		switch (id) {
		case 1:
			return "等待支付";
		case 2:
			return "等待出票";
		case 3:
			return "出票完成";
		case 4:
			return "申请退票";
		case 5:
			return "申请废票";
		case 6:
			return "取消订单";
		case 7:
			return "废票不成功";
		case 8:
			return "审核失败";
		case 9:
			return "废票退款成功";
		case 10:
			return "订单关闭";
		case 11:
			return "废票未退款";
		case 12:
			return "退票未退款";
		case 13:
			return "申请改签";
		case 14:
			return "已经改签";
		case 15:
			return "改签失败";
		case 16:
			return "暂不能出票";
		case 17:
			return "退票不成功";
		case 18:
			return "退票退款成功";
		case 19:
			return "问题订单";
		case 23:
			return "申请升舱";
		case 24:
			return "已换开";
		case 25:
			return "升舱换开成功";
		case 26:
			return "升舱失败";
		case 27:
			return "待确认";
		case 28:
			return "在途订单";
		case 29:
			return "待收银";
		case 30:
			return "申请换开";
		case 31:
			return "换开失败";
		default:
			return "";
		}
	}

	/**
	 * 通过id获取订单
	 * 
	 * @param id
	 * @return
	 */
	public Orderinfo getorderbyid(long id) {
		return Server.getInstance().getAirService().findOrderinfo(id);
	}

	// 航班变更查询
	public String getFlightChange() {
		String strReturn = "0";
		strReturn = Server.getInstance().getTicketSearchService().QMailQS("SC");

		// 判断是否出现航班变更
		if (strReturn.indexOf("SCHEDULE CHG") >= 0) {
			// 将航班变动信息存入数据库
			try {
				Qmessage qmessage = new Qmessage();
				qmessage
						.setCreatetime(new Timestamp(System.currentTimeMillis()));
				qmessage.setMessage(strReturn);
				qmessage.setStatus(0); // 未处理
				Server.getInstance().getMemberService()
						.createQmessage(qmessage);
				Server.getInstance().getTicketSearchService().QMailQNE();
			} catch (Exception ex) {
				Server.getInstance().getTicketSearchService().QMailQNE();
			}
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(strReturn);
		} catch (IOException e) {
			e.printStackTrace();
		}

		out.flush();
		out.close();
		return strReturn;
	}

	public String gethangbanhao(long id) {// 取航班号
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where 1=1 and " + Segmentinfo.COL_orderid + " =" + id,
						"", -1, 0);
		if (list.size() > 0 && list.get(0).getFlightnumber() != null) {
			return list.get(0).getFlightnumber();

		} else {
			return "";
		}
	}

	public Timestamp geqifeitime(long id) {// 取起飞时间
		List<Segmentinfo> list = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where 1=1 and " + Segmentinfo.COL_orderid + " =" + id,
						"", -1, 0);
		// if(list.size()>0&&list.get(0).getDeparttime()!=null){
		return list.get(0).getDeparttime();

	}

	// 得到Q信箱详细信息
	public void getQMailQT() throws Exception {
		String strReturn = "";
		String strHTML = "";
		String strTable1 = "";
		String strTable2 = "";
		strReturn = Server.getInstance().getTicketSearchService().QMailQT();

		Pattern pCabintotal = Pattern.compile("\\n");
		String[] strQTarr = pCabintotal.split(strReturn);
		if (strQTarr.length > 0) {
			for (int i = 0; i < strQTarr.length; i++) {
				// 前四个
				if (strQTarr[i].indexOf("KK") >= 0) {

					// Pattern pmailinfo = Pattern.compile("\\s{3,}");
					// String[] strHeadFour=pmailinfo.split(strQTarr[i]);
					// strTable1="<table border=1 cellspacing=0
					// bordercolorlight=#a0cfee bordercolordark=white
					// cellpadding=0 width=100% align=center>";
					// if(strHeadFour.length>0)
					// {
					// for(int q=0;q<strHeadFour.length;q++)
					// {
					// Pattern pbfour = Pattern.compile("\\s");
					// String[] strFourarr=pbfour.split(strHeadFour[q]);
					//					    	 
					// strTable1+="<tr>";
					// strTable1+="<td>";
					// strTable1+="<table width='100%' border='0'
					// cellspacing='0' cellpadding='0'>";
					// strTable1+="<tr><td align='center' width='30%'><a
					// href='#'
					// onclick=\"showqsinfo('"+strFourarr[0]+"');\">"+getQTName(strFourarr[0])+"</a></td><td
					// align='center'
					// width='35%'>未处理数量:"+strFourarr[1]+"</td><td
					// align='center'
					// width='35%'>最大数量："+strFourarr[2]+"</td></tr>";
					// strTable1+="</table>";
					// strTable1+="</td>";
					// strTable1+="</tr>";
					// }
					// }
					// strTable1+="</table>";
				} else if (strQTarr[i].indexOf("SC") >= 0) {
					Pattern pmailinfo1 = Pattern.compile("\\s{3,}");
					String[] strHeadFour1 = pmailinfo1.split(strQTarr[i]);
					strTable2 = "<table border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 width=100% align=center>";
					if (strHeadFour1.length > 0) {
						// for(int q=0;q<strHeadFour1.length;q++)
						// {
						Pattern pbfour1 = Pattern.compile("\\s");
						String[] strFourarr1 = pbfour1
								.split(strHeadFour1[strHeadFour1.length - 1]);

						strTable2 += "<tr>";
						strTable2 += "<td>";
						strTable2 += "<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
						strTable2 += "<tr><td align='center' width='30%'><a href='#' onclick=\"showqsinfo('"
								+ strFourarr1[0]
								+ "');\">"
								+ getQTName(strFourarr1[0])
								+ "</a></td><td align='center' width='35%'>未处理数量:"
								+ strFourarr1[1]
								+ "</td><td align='center' width='35%'>最大数量："
								+ strFourarr1[2] + "</td></tr>";
						strTable2 += "</table>";
						strTable2 += "</td>";
						strTable2 += "</tr>";
						// }
					}
					strTable2 += "</table>";
				}
			}
		}
		strHTML = "<table width='100%'  border='0' cellspacing='0' cellpadding='0'>";
		strHTML += "<tr height='10px'><td colspan='3'></td></tr><tr><td colspan='3'><b>所有信件收件箱</b></td></tr>";
		strHTML += "<tr height='5px'><td colspan='3'></td></tr><tr ><td colspan='3' align='left'><font color='red'>提示:点击信件类型名称即可查看信件内容</font></td></tr>";
		strHTML += "<tr><td>" + strTable1 + "</td><td>&nbsp;&nbsp;</td><td>"
				+ strTable2 + "</td></tr>";
		strHTML += "</table>";

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strHTML);
		out.print(sb);
		out.flush();
		out.close();
	}

	public String getQTName(String strQueryType) throws Exception {
		String strReturn = "";
		if (strQueryType.equals("GQ")) {
			strReturn = "<b>综合QUEUE(" + strQueryType + ")</b>";
		} else if (strQueryType.equals("RP")) {
			strReturn = "<b>给主管的报告(" + strQueryType + ")</b>";
		} else if (strQueryType.equals("KK")) {
			strReturn = "<font color='red'><b>PNR回复(" + strQueryType
					+ ")</b></font>";
		} else if (strQueryType.equals("SR")) {
			strReturn = "<b>特殊服务申请(" + strQueryType + ")</b>";
		} else if (strQueryType.equals("TL")) {
			strReturn = "<b>出票时限(" + strQueryType + ")</b>";
		} else if (strQueryType.equals("SC")) {
			strReturn = "<font color='red'><b>航班更改(" + strQueryType
					+ ")</b></font>";
		} else {
			strReturn = "<b>信件类型(" + strQueryType + ")</b>";
		}
		return strReturn;
	}

	// 处理某Q信息
	public void getQMailSC() throws Exception {
		String strReturn = "";
		strReturn = Server.getInstance().getTicketSearchService().QMailQS(
				strQueryType);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(formatHTML(strReturn));
		out.print(sb);
		out.flush();
		out.close();
	}

	// 处理下一个Q信息
	public void getQMailQN() throws Exception {
		String strReturn = "";
		strReturn = Server.getInstance().getTicketSearchService().QMailQN();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(formatHTML(strReturn));
		out.print(sb);
		out.flush();
		out.close();
	}

	// 释放掉Q信息
	public void getQMailQNE() throws Exception {
		String strReturn = "";
		strReturn = Server.getInstance().getTicketSearchService().QMailQNE();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(formatHTML(strReturn));
		out.print(sb);
		out.flush();
		out.close();
	}

	// 得到订单数量--待出票
	/**
	 * @throws Exception
	 */
	public void getOrderCount() throws Exception {
		//String where9c="  AND ID IN( SELECT "+Segmentinfo.COL_orderid+" FROM T_SEGMENTINFO where "+Segmentinfo.COL_aircomapnycode+" !='9C' )";
		
		String restmsg = "";
		StringBuilder sql = new StringBuilder("");
		Customeragent loginagent = this.getLoginsessionagent();
		if (loginagent.getAgenttype() == 2 || loginagent.getAgenttype() == 1) {//供应商平台提醒
			// 待出票 采购商已支付
			String waitoutwhere = "WHERE 1=1 AND C_ORDERSTATUS=2 AND C_PAYSTATUS=1";
			
			
			// 申请退票
			 String returnwhere = " WHERE C_ORDERSTATUS =4";
			// 申请废票
			String invalidatewhere = " WHERE C_ORDERSTATUS =5 ";
			// 申请改签
			String changewhere = " WHERE C_ORDERSTATUS =13";
			// 带确认
			String daiquerenwhere = " WHERE C_ORDERSTATUS =27";
			// 带支付
			//String daizhifuwhere = " WHERE C_ORDERSTATUS =1";
			// 待出票
			
			String daichupiaowhere = " WHERE (C_ORDERSTATUS =2 OR (C_ORDERSTATUS=1 AND C_PAYMETHOD=3 ))";
			
			if(loginagent.getAgenttype() == 2){
				daichupiaowhere+=" and C_POLICYAGENTID ="+loginagent.getId();
			}
			
			
			sql.append(" ( SELECT  COUNT(ID) FROM  T_ORDERINFO " + returnwhere
					+ ") AS tuiticket,");
			
			sql.append(" ( SELECT  COUNT(ID) FROM  T_ORDERINFO " + invalidatewhere
					+ ") AS feiticket,");

			sql.append(" ( SELECT COUNT(ID)  FROM T_ORDERINFO " + changewhere
					+ ")  AS gaiqianticket ,");
			
			sql.append(" ( SELECT COUNT(ID)  FROM T_ORDERINFO " + daichupiaowhere
					+ ")  AS daichupiaoticket ,");
			
			sql.append(" ( SELECT COUNT(ID)  FROM T_ORDERINFO " + daiquerenwhere
					+ ")  AS daiquerenticket ,");
			//sql.append(" ( SELECT COUNT(ID)  FROM T_ORDERINFO " + daizhifuwhere
			//		+ ")  AS daizhifuticket ,");

		}else{//分销商.只提醒待支付
			String daizhifuwhere = " WHERE C_ORDERSTATUS =1";
					daizhifuwhere+=" and C_BUYAGENTID ="+loginagent.getId();
					
					sql.append(" ( SELECT COUNT(ID)  FROM T_ORDERINFO " + daizhifuwhere
							+ ")  AS daizhifuticket ,");
			
		}
		
		System.out.println(sql.toString());
		List list = Server.getInstance().getSystemService()
				.findMapResultBySql(
						"SELECT TOP 1 " + sql.toString() + "''"
								+ " FROM T_ORDERINFO  ", null);
		
		
		List list2=new ArrayList<Object>();
		List list3=new ArrayList<Object>();
		if (loginagent.getAgenttype() == 1 || loginagent.getAgenttype()==3) {//供应商平台提醒
			String QbSql="";
			String TelSql="";
			if(loginagent.getAgenttype() == 1){//平台   已支付
				
				 QbSql="( SELECT COUNT(ID) FROM T_QMONEYRECHARGE WHERE C_PAYSTATE=1 AND C_RECHSTATE!=1 ) AS qbnum";
				 TelSql=" ( SELECT COUNT(ID) FROM T_RECHARGE WHERE C_PAYSTATE=1 AND C_STATE!=1 ) AS telnum ";
				 
				 list2 = Server.getInstance().getSystemService()
					.findMapResultBySql(
							"SELECT TOP 1 " + QbSql.toString() + ""
							+ " FROM T_QMONEYRECHARGE  ;", null);	   
				    list3 = Server.getInstance().getSystemService()
				.findMapResultBySql(
						"SELECT TOP 1 " + TelSql.toString() + ""
						+ " FROM T_RECHARGE  ;", null);	
			}
			/*if(loginagent.getAgenttype() == 3){//采购  待支付
				
				 QbSql="( SELECT COUNT(ID) FROM T_QMONEYRECHARGE WHERE C_PAYSTATE=-1 AND C_RECHAGENTID="+loginagent.getId()+" ) AS qbnum";
				 TelSql=" ( SELECT COUNT(ID) FROM T_RECHARGE WHERE C_PAYSTATE=-1 AND C_RECHAGENTID="+loginagent.getId()+" ) AS telnum ";
			}*/
			
			
			
			
			    
	
		}
		List list4=new ArrayList<Object>();//火车票带出票
		List list5=new ArrayList<Object>();//火车票申请退票
		List list6=new ArrayList<Object>();//火车票申请改签
		if (loginagent.getAgenttype() == 1 || loginagent.getAgenttype()==2) {//供应商平台提醒
			
			String trainSql="( SELECT COUNT(ID) FROM T_TRAIN WHERE  C_ORDERSTATUS=2 ) AS trainnum";
			 list4 = Server.getInstance().getSystemService().findMapResultBySql(
						"SELECT TOP 1 " + trainSql.toString() + ""+ " FROM T_TRAIN  ;", null);
			 
			 String trainSql_tui="( SELECT COUNT(ID) FROM T_TRAIN WHERE  C_ORDERSTATUS=14 ) AS trainnum_tui";
			 list5 = Server.getInstance().getSystemService().findMapResultBySql(
						"SELECT TOP 1 " + trainSql_tui.toString() + ""+ " FROM T_TRAIN  ;", null);
			 String trainSql_gai="( SELECT COUNT(ID) FROM T_TRAIN WHERE   C_ORDERSTATUS=17 ) AS trainnum_gai";
			 list6 = Server.getInstance().getSystemService().findMapResultBySql(
						"SELECT TOP 1 " + trainSql_gai.toString() + ""+ " FROM T_TRAIN  ;", null);
		}

		//充值处理
		String qbnum="0";
		String telnum="0";
		String trainnum="0";
		String trainnum_tui="0";
		String trainnum_gai="0";
		if(list2!=null&&list2.size()>0){
			Map	map2=(Map) list2.get(0);
		 qbnum = converNull(map2.get("qbnum"), "0").toString();// QB
		}
		if(list3!=null&&list3.size()>0){
			Map map3 = (Map) list3.get(0);
		    telnum = converNull(map3.get("telnum"), "0")
		.toString();// TEL
		
		}	
		
		//火车票处理
		if(list4!=null&&list4.size()>0){
			Map map4 = (Map) list4.get(0);
			trainnum = converNull(map4.get("trainnum"), "0")
		.toString();// TEL
		
		}	
		if(list5!=null&&list5.size()>0){
			Map map5 = (Map) list5.get(0);
			trainnum_tui = converNull(map5.get("trainnum_tui"), "0")
		.toString();// TEL
		
		}	
		if(list6!=null&&list6.size()>0){
			Map map6 = (Map) list6.get(0);
			trainnum_gai = converNull(map6.get("trainnum_gai"), "0")
		.toString();// TEL
		
		}	
	   	   
		
		String tuiticket="";	
		String feiticket="";
		String gaiqianticket="";
		String daichupiaoticket="";
		String daiquerenticket="";
		String daizhifuticket="";
		if (list.size() > 0) {
			Map map = (Map) list.get(0);
			 tuiticket = converNull(map.get("tuiticket"), "0")
					.toString();// 申请退票
			 feiticket = converNull(map.get("feiticket"), "0")
					.toString();// 申请废票
			 gaiqianticket = converNull(map.get("gaiqianticket"), "0")
			.toString();// 申请改签
			
			 daichupiaoticket = converNull(map.get("daichupiaoticket"), "0")
			.toString();// 带出票
			
			 daiquerenticket = converNull(map.get("daiquerenticket"), "0")
			.toString();// 待确认
			
			 daizhifuticket = converNull(map.get("daizhifuticket"), "0")
			.toString();// 待支付
		}
		
		restmsg = "ticket={tuiticket:" + tuiticket
		+ ",feiticket:" + feiticket 
		+ ",daichupiaoticket:" + daichupiaoticket 
		+ ",daiquerenticket:" + daiquerenticket 
		+ ",daizhifuticket:" + daizhifuticket 
		+ ",gaiqianticket:" + gaiqianticket
		+ ",qbnum:" + qbnum
		+ ",telnum:" + telnum
		+ ",trainnum:" + trainnum
		+ ",trainnum_tui:" + trainnum_tui
		+ ",trainnum_gai:" + trainnum_gai
		+"}";
		
		System.out.println(restmsg);
		
		
		System.gc();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(restmsg);
		out.flush();
		out.close();
	}
	/**
	 * @throws Exception
	 */
	public void getOrderCount_9c() throws Exception {
		
		String where9c="  AND ID IN( SELECT "+Segmentinfo.COL_orderid+" FROM T_SEGMENTINFO where "+Segmentinfo.COL_aircomapnycode+" ='9C' )";
		
		String restmsg = "";
		StringBuilder sql = new StringBuilder("");
		Customeragent loginagent = this.getLoginsessionagent();
		if (loginagent.getAgenttype() == 2 || loginagent.getAgenttype() == 1) {//供应商平台提醒
			// 待出票 采购商已支付
			String waitoutwhere = "WHERE 1=1 AND C_ORDERSTATUS=2 AND C_PAYSTATUS=1"+where9c;
			
			
			// 申请退票
			 String returnwhere = " WHERE C_ORDERSTATUS =4"+where9c;
			// 申请废票
			String invalidatewhere = " WHERE C_ORDERSTATUS =5 "+where9c;
			// 申请改签
			String changewhere = " WHERE C_ORDERSTATUS =13"+where9c;
			// 带确认
			String daiquerenwhere = " WHERE C_ORDERSTATUS =27"+where9c;
			// 带支付
			//String daizhifuwhere = " WHERE C_ORDERSTATUS =1";
			// 待出票
			
			String daichupiaowhere = " WHERE (C_ORDERSTATUS =2 OR (C_ORDERSTATUS=1 AND C_PAYMETHOD=3 ))"+where9c;
			
			if(loginagent.getAgenttype() == 2){
				daichupiaowhere+=" and C_POLICYAGENTID ="+loginagent.getId();
			}
			
			
			sql.append(" ( SELECT  COUNT(ID) FROM  T_ORDERINFO " + returnwhere
					+ ") AS tuiticket,");
			
			sql.append(" ( SELECT  COUNT(ID) FROM  T_ORDERINFO " + invalidatewhere
					+ ") AS feiticket,");

			sql.append(" ( SELECT COUNT(ID)  FROM T_ORDERINFO " + changewhere
					+ ")  AS gaiqianticket ,");
			
			sql.append(" ( SELECT COUNT(ID)  FROM T_ORDERINFO " + daichupiaowhere
					+ ")  AS daichupiaoticket ,");
			
			sql.append(" ( SELECT COUNT(ID)  FROM T_ORDERINFO " + daiquerenwhere
					+ ")  AS daiquerenticket ,");
			//sql.append(" ( SELECT COUNT(ID)  FROM T_ORDERINFO " + daizhifuwhere
			//		+ ")  AS daizhifuticket ,");

		}
		
		System.out.println(sql.toString());
		List list = Server.getInstance().getSystemService()
				.findMapResultBySql(
						"SELECT TOP 1 " + sql.toString() + "''"
								+ " FROM T_ORDERINFO  ", null);
		
		

	

		
	   	   
			  
		if (list.size() > 0) {
			Map map = (Map) list.get(0);
			String tuiticket = converNull(map.get("tuiticket"), "0")
					.toString();// 申请退票
			String feiticket = converNull(map.get("feiticket"), "0")
					.toString();// 申请废票
			String gaiqianticket = converNull(map.get("gaiqianticket"), "0")
			.toString();// 申请改签
			
			String daichupiaoticket = converNull(map.get("daichupiaoticket"), "0")
			.toString();// 带出票
			
			String daiquerenticket = converNull(map.get("daiquerenticket"), "0")
			.toString();// 待确认
			
			String daizhifuticket = converNull(map.get("daizhifuticket"), "0")
			.toString();// 待支付
			
			
			String qbnum="0";
			String telnum="0";
			String trainnum="0";
			
			
			restmsg = "ticket={tuiticket:" + tuiticket
					+ ",feiticket:" + feiticket 
					+ ",daichupiaoticket:" + daichupiaoticket 
					+ ",daiquerenticket:" + daiquerenticket 
					+ ",daizhifuticket:" + daizhifuticket 
					+ ",gaiqianticket:" + gaiqianticket
					+ ",qbnum:" + qbnum
					+ ",telnum:" + telnum
					+ ",trainnum:" + trainnum
					+"}";

		}
		System.out.println(restmsg);
		
		
		System.gc();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(restmsg);
		out.flush();
		out.close();
	}
public void getOrderCount2() throws Exception {
		
		String restmsg = "";
		StringBuilder sql = new StringBuilder("");
		Customeragent loginagent = this.getLoginsessionagent();
		if (loginagent.getAgenttype() == 2 || loginagent.getAgenttype() == 1) {//供应商平台提醒
			// 待出票 采购商已支付
			String waitoutwhere = "WHERE 1=1 AND C_ORDERSTATUS=2 AND C_PAYSTATUS=1";
			
			
			// 申请退票
			 String returnwhere = " WHERE C_ORDERSTATUS =4";
			// 申请废票
			String invalidatewhere = " WHERE C_ORDERSTATUS =5 ";
			// 申请改签
			String changewhere = " WHERE C_ORDERSTATUS =13";
			// 带确认
			String daiquerenwhere = " WHERE C_ORDERSTATUS =27";
			// 带支付
			//String daizhifuwhere = " WHERE C_ORDERSTATUS =1";
			// 待出票
			
			String daichupiaowhere = " WHERE (C_ORDERSTATUS =2 OR (C_ORDERSTATUS=1 AND C_PAYMETHOD=3 ))";
			
			if(loginagent.getAgenttype() == 2){
				daichupiaowhere+=" and C_POLICYAGENTID ="+loginagent.getId();
			}
			
			
			sql.append(" ( SELECT  COUNT(ID) FROM  T_ORDERINFO " + returnwhere
					+ ") AS tuiticket,");
			
			sql.append(" ( SELECT  COUNT(ID) FROM  T_ORDERINFO " + invalidatewhere
					+ ") AS feiticket,");

			sql.append(" ( SELECT COUNT(ID)  FROM T_ORDERINFO " + changewhere
					+ ")  AS gaiqianticket ,");
			
			sql.append(" ( SELECT COUNT(ID)  FROM T_ORDERINFO " + daichupiaowhere
					+ ")  AS daichupiaoticket ,");
			
			sql.append(" ( SELECT COUNT(ID)  FROM T_ORDERINFO " + daiquerenwhere
					+ ")  AS daiquerenticket ,");
			//sql.append(" ( SELECT COUNT(ID)  FROM T_ORDERINFO " + daizhifuwhere
			//		+ ")  AS daizhifuticket ,");

		}else{//分销商.只提醒待支付
			String daizhifuwhere = " WHERE C_ORDERSTATUS =1";
					daizhifuwhere+=" and C_BUYAGENTID ="+loginagent.getId();
					
					sql.append(" ( SELECT COUNT(ID)  FROM T_ORDERINFO " + daizhifuwhere
							+ ")  AS daizhifuticket ,");
			
		}
		
		System.out.println(sql.toString());
		List list = Server.getInstance().getSystemService()
				.findMapResultBySql(
						"SELECT TOP 1 " + sql.toString() + "''"
								+ " FROM T_ORDERINFO  ", null);
		
		
		List list2=new ArrayList<Object>();
		List list3=new ArrayList<Object>();
		if (loginagent.getAgenttype() == 1 || loginagent.getAgenttype()==3) {//供应商平台提醒
			String QbSql="";
			String TelSql="";
			if(loginagent.getAgenttype() == 1){//平台   已支付
				
				 QbSql="( SELECT COUNT(ID) FROM T_QMONEYRECHARGE WHERE C_PAYSTATE=1 AND C_RECHSTATE!=1 ) AS qbnum";
				 TelSql=" ( SELECT COUNT(ID) FROM T_RECHARGE WHERE C_PAYSTATE=1 AND C_STATE!=1 ) AS telnum ";
				 
				 list2 = Server.getInstance().getSystemService()
					.findMapResultBySql(
							"SELECT TOP 1 " + QbSql.toString() + ""
							+ " FROM T_QMONEYRECHARGE  ;", null);	   
				    list3 = Server.getInstance().getSystemService()
				.findMapResultBySql(
						"SELECT TOP 1 " + TelSql.toString() + ""
						+ " FROM T_RECHARGE  ;", null);	
			}
			/*if(loginagent.getAgenttype() == 3){//采购  待支付
				
				 QbSql="( SELECT COUNT(ID) FROM T_QMONEYRECHARGE WHERE C_PAYSTATE=-1 AND C_RECHAGENTID="+loginagent.getId()+" ) AS qbnum";
				 TelSql=" ( SELECT COUNT(ID) FROM T_RECHARGE WHERE C_PAYSTATE=-1 AND C_RECHAGENTID="+loginagent.getId()+" ) AS telnum ";
			}*/
			
			
			
			
			    
	
		}
		
	

		
	   	   
			  
		if (list.size() > 0) {
			Map map = (Map) list.get(0);
			String tuiticket = converNull(map.get("tuiticket"), "0")
					.toString();// 申请退票
			String feiticket = converNull(map.get("feiticket"), "0")
					.toString();// 申请废票
			String gaiqianticket = converNull(map.get("gaiqianticket"), "0")
			.toString();// 申请改签
			
			String daichupiaoticket = converNull(map.get("daichupiaoticket"), "0")
			.toString();// 带出票
			
			String daiquerenticket = converNull(map.get("daiquerenticket"), "0")
			.toString();// 待确认
			
			String daizhifuticket = converNull(map.get("daizhifuticket"), "0")
			.toString();// 待支付
			
			
			String qbnum="0";
			String telnum="0";
						
			
			restmsg = "ticket={tuiticket:" + tuiticket
					+ ",feiticket:" + feiticket 
					+ ",daichupiaoticket:" + daichupiaoticket 
					+ ",daiquerenticket:" + daiquerenticket 
					+ ",daizhifuticket:" + daizhifuticket 
					+ ",gaiqianticket:" + gaiqianticket
					+ ",qbnum:" + qbnum
					+ ",telnum:" + telnum
					+"}";

		}
		System.out.println(restmsg);
		
		System.gc();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(restmsg);
		out.flush();
		out.close();
	}

	// 得到乘机人信息根据订单号
	public void getPassengerList() throws Exception {
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		String strReturn = "";
		if (typ == 1) {
			strReturn += "<span style='color:red' align='left'>请选择您要废票的乘机人！</span>";
		}
		if (typ == 2) {
			strReturn += "<span style='color:red' align='left'>请选择您要退票的乘机人！</span>";
		}
		if (typ == 3) {
			strReturn += "<span style='color:red' align='left'>请选择您要改签的乘机人！</span>";
		}
		if (typ == 14) {
			strReturn += "<span style='color:red' align='left'>请选择要升舱换开的乘机人！</span>";
		}
		//
		strReturn += "<table class='book_pgcontent' width='99%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tbody>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td><input type='hidden' id='checkboxflag' value='0' />";
		strReturn += "<input type='checkbox' id='chkpassenger1_all' onclick='checkallbox();'>";

		strReturn += "</td><td>机票类型</td><td>乘客类型</td><td>乘客姓名</td><td>证件类型</td><td>证件号码</td><td>票号</td><td>票价</td><td>燃油</td><td>机建</td><td>安检</td><td>其它</td>";
		strReturn += "</tr>";

		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE C_ORDERID=" + strTuiOrderID + " and "
								+ Passenger.COL_state + "<>12", "", -1, 0);
		for (int i = 0; i < listpassenger.size(); i++) {
			strReturn += "<tr>";
			strReturn += "<td align='center'><input type='hidden' id='txtpassid_"
					+ i + "' value='" + listpassenger.get(i).getId() + "' />";
			String checkbox = "<input type='checkbox' id='chkpassenger_" + i
					+ "'>";
			if (orderinfo.getOrderstatus() == 10) {
				String tiecekmessage = this.getTicketInfo(listpassenger.get(i)
						.getTicketnum());
				if (tiecekmessage.replace(" ", "").toLowerCase().indexOf(
						"openforuse") < 0) {
					checkbox = "<input type='checkbox' disabled=\"disabled\" id='chkpassenger_"
							+ i + "'>";
				}
			}
			strReturn += checkbox;
			if (i == 0) {
				strReturn += "<td rowspan=\""
						+ listpassenger.size()
						+ "\">"
						+ this.getTickettypeById(
								converNull(listpassenger.get(i)
										.getTickettypeid(), 0l)).getTypename()
						+ "</td>";
			}
			strReturn += "</td><td>"
					+ getPassTypeToString(listpassenger.get(i).getPtype())
					+ "</td>";
			strReturn += "<td>" + listpassenger.get(i).getName() + "</td>";
			strReturn += "<td>"
					+ getIDTypeToString(listpassenger.get(i).getIdtype())
					+ "</td>";
			strReturn += "<td><span id='gdvTic_ctl02_lbtnzj'>"
					+ listpassenger.get(i).getIdnumber() + "</span></td>";
			String strTicketNumber = "暂无";
			if (listpassenger.get(i).getTicketnum() != null
					&& !listpassenger.get(i).getTicketnum().equals("")) {
				strTicketNumber = listpassenger.get(i).getTicketnum();
			}
			strReturn += "<td>" + strTicketNumber + "</td>";
			strReturn += "<td>" + formatMoney(listpassenger.get(i).getPrice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getFuelprice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getAirportfee())
					+ "</td><td>"
					+ formatMoney(listpassenger.get(i).getAnjianfee())
					+ "</td><td>"
					+ formatMoney(listpassenger.get(i).getOtherfee()) + "</td>";
			strReturn += "</tr>";

		}
		if (typ == 2) {
			strReturn += "<tr><td colspan='12'>退票手续费(每人):<input type='textbox' id='txttuifee'  width='15px' /></td></tr>";
		} else if (typ == 1) {
			strReturn += "<tr><td colspan='12'>废票手续费(每人):<input type='textbox' id='txttuifee'  width='15px' /></td></tr>";
		} else if (typ == 3) {
			strReturn += "<tr><td colspan='12'>改签手续费(每人):<input type='textbox' id='txttuifee'  width='15px' /></td></tr>";
		} else if (typ == 14) {
			strReturn += "<tr><td colspan='12'>升舱换开手续费(每人):<input type='textbox' id='txttuifee'  width='15px' /></td></tr>";
		}
		strReturn += "</tbody>";
		strReturn += "</table>";
		strReturn += "<br />";
		String strReason = "";
		String strDesc = "";
		String strTishi = "";
		if (typ == 1) {
			strReason = "废票原因";
			strDesc = "废票说明";
			strTishi = "温馨提示：当日作废，请飞机起飞前两小时15分钟申请（申请前请取消位置，作废行程单。如无法取消位置，请在黑屏中取消位置）";
		} else if (typ == 2) {
			strReason = "退票原因";
			strDesc = "退票说明";
			strTishi = "温馨提示：当日作废，请飞机起飞前两小时15分钟申请（申请前请取消位置，作废行程单。如无法取消位置，请在黑屏中取消位置）";
		} else if (typ == 3) {
			strReason = "改签原因";
			strDesc = "改签说明";
			strTishi = "温馨提示：请将改签信息填写到备注说明中,如果已经生成了新的PNR请将PNR填写";
		} else if (typ == 14) {
			strReason = "升舱换开原因";
			strDesc = "升舱换开说明";
			strTishi = "温馨提示：请将改签信息填写到备注说明中,如果已经生成了新的PNR请将PNR填写";
		}

		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		if (typ == 1) {
			strReturn += "<tr><td class='table_color_r colortrin' width='60px'>"
					+ strReason
					+ ":</td><td align='left'><select id='ddlreason'><option value='1'>自愿废票</option><option value='1'>非自愿废票</option></select></td><td align='right' class='table_color_r colortrin'>保留位置:</td><td align='left'><input type='radio' id='rdoyes' name='tui_iscabinsite' value='0'  />是 <input type='radio' id='rdono' name='tui_iscabinsite'  checked='checked' value='1' />否</td></tr>";
		} else if (typ == 2) {
			if (orderinfo.getIsshengcang() == null) {
				strReturn += "<tr><td class='table_color_r colortrin' width='60px'>"
						+ strReason
						+ ":</td><td align='left'><select id='ddlreason'><option value='1'>自愿退票</option><option value='2'>非自愿退票</option></select></td><td align='right' class='table_color_r colortrin'>保留位置:</td><td align='left'><input type='radio' id='rdoyes' name='tui_iscabinsit' value='0'  />是 <input type='radio' id='rdono' name='tui_iscabinsit'  checked='checked'  value='1' />否</td></tr>";
			} else if (orderinfo.getIsshengcang() == 1) {
				strReturn += "<tr><td class='table_color_r colortrin' width='60px'>"
						+ strReason
						+ ":</td><td align='left'><select id='ddlreason'><option value='2'>非自愿退票</option><option value='1'>自愿退票</option></select></td><td align='right' class='table_color_r colortrin'>保留位置:</td><td align='left'><input type='radio' id='rdoyes' name='tui_iscabinsite'  value='0' />是 <input type='radio' id='rdono' name='tui_iscabinsite'  checked='checked' value='1' />否</td></tr>";
			}
		} else if (typ == 3) {
			strReturn += "<tr><td class='table_color_r colortrin' width='120px'>"
					+ strReason
					+ ":</td><td align='left'><select id='ddlreason'><option value='1'>自愿改签</option><option value='2'>非自愿改签</option></select></td><td align='right' class='table_color_r colortrin' width='120px'>保留位置:</td><td align='left'> <input type='radio' id='rdono' name='tui_iscabinsite' value='0'  />是 <input type='radio' id='rdoyes' name='tui_iscabinsite' checked='checked' value='1'  />否</td></tr>";

			strReturn += "<tr id='trchangedate'><td class='table_color_r colortrin' width='120px'>改签日期：</td><td align='left' colspan='3'><input type='text' onfocus=\"WdatePicker({skin:'whyGreen'})\" class='Wdate' id='txtchangedate' name='changedate' /></td></tr>";
			strReturn += "<tr id='trchangecangwei'  ><td class='table_color_r colortrin' width='120px'>改签舱位：</td><td align='left'><input type='text' id='txtchangecabin' name='changecabin' /></td><td class='table_color_r colortrin' width='120px'>改签航班：</td><td align='left'><input type='text' id='txtchangeflight' name='changeflight' /></td></tr>";
			strReturn += "<tr id='trchangecangwei' style='display:none'><td class='table_color_r colortrin' width='120px'>更改航段：</td><td align='left' colspan='3'><input type='text' style='width:100px' id='txtstartairport' name='s_startairport' />-<input type='text' id='txtendairport' name='s_endairport' style='width:100px' /><font color='red'>请输入机场城市三字码</font></td></tr>";

			strReturn += "<tr style='display:none'><td colspan='4'><span style='color:red'>PNR生成已经超过三天，请需要重新生成PNR！</span></td></tr>";
			strReturn += "<tr style='display:none' id='trchangecangwei'><td class='table_color_r colortrin' width='60px'>原订单号：</td><td align='left'><input type='text' id='txtorderid' value='"
					+ orderinfo.getOrdernumber()
					+ "' name='orderid' /></td><td class='table_color_r colortrin' width='60px'>新PNR：</td><td align='left'><input type='text' id='txtchangepnr' name='changepnr' /></td></tr>";
		} else if (typ == 14) // 升舱换开
		{
			strReturn += "<tr><td colspan='4' align='left'><span style='color:red'>请生成新的换开订单或将新生成的换开PNR导入系统中，进行查询</span></td></tr>";
			strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'><td colspan='4' align='left'><b>换开操作处理</b></td></tr>";
			strReturn += "<td class='table_color_r colortrin'>新订单号：</td><td align='left'><input type='text' id='txtordernumber' /></td><td class='table_color_r colortrin'>新PNR:</td><td align='left'><input type='text' id='txtorderpnr'  /></td>";
			strReturn += "</tr>";
			strReturn += "<tr  id='trchangecangwei' ><td class='table_color_r colortrin' width='120px'>新票号：</td><td align='left' colspan='3'><input type='text' id='txtnewticnum' name='newticnum' /> <span style='color:red'>新PNR和新票号至少填写一项</span></td></tr>";
		}
		strReturn += "<tr><td class='table_color_r colortrin' width='60px'>"
				+ strDesc
				+ ":</td><td colspan='3' align='left'><textarea id='tuifeidesc' rows='5' cols='60'></textarea></td></tr>";
		strReturn += "<tr><td colspan='4' align='left'><span style='color:red'>"
				+ strTishi + "</span></td></tr>";
		strReturn += "</table>";
		if (typ == 2) {
			strReturn += "<br /><input class='button_d font-bai' value='申请退票' onclick='tuiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
		}
		if (typ == 1) {
			strReturn += "<br /><input class='button_d font-bai' value='申请废票' onclick='feiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
		}
		if (typ == 3) {
			strReturn += "<br /><input class='button_d font-bai' value='申请改签' onclick='gaiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
		}
		if (typ == 14) {
			strReturn += "<br /><input class='button_d font-bai' value='申请升舱换开' onclick='shengcangticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	// 得到申请废退得乘机人
	public void getPassengersqList() throws Exception {
		String strReturn = "";
		String strTuipiaofeis = "";
		if (typ == 1) {
			strReturn += "<span style='color:red' align='left'>请选择审核通过废票的乘机人！</span>";
			strTuipiaofeis = "废票手续费";
		}
		if (typ == 2) {
			strReturn += "<span style='color:red' align='left'>请选择审核通过退票的乘机人！</span>";
			strTuipiaofeis = "退票手续费";
		}
		if (typ == 3) {
			strReturn += "<span style='color:red' align='left'>请选择审核通过改签的乘机人！</span>";
			strTuipiaofeis = "改签费用";
		}
		if (typ == 4) {
			strReturn += "<span style='color:red' align='left'>请选择要分离的乘机人！</span>";
		}
		if (typ == 14) {
			strReturn += "<span style='color:red' align='left'>请选择要分离的乘机人！</span>";
			strTuipiaofeis = "升舱换开费用";
		}
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tbody>";

		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td><input type='hidden' id='checkboxflag' value='0' /><input type='checkbox' style='display:none' id='chkpassenger1_all' onclick='checkallbox();'></td><td>机票类型</td><td>乘客类型</td><td>乘客姓名</td><td>证件类型</td><td>证件号码</td><td>票号</td><td>票价</td><td>燃油</td><td>机建</td><td>安检</td><td>其它</td><td>"
				+ strTuipiaofeis + "</td>";
		strReturn += "</tr>";
		String where = "WHERE C_ORDERID=" + strTuiOrderID + " and "
				+ Passenger.COL_state + "<>12";
		List<Passenger> listpassenger1 = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		int intpasscount = listpassenger1.size();
		if (typ == 1) {
			where += " and " + Passenger.COL_state + " =5";
		}
		if (typ == 2) {
			where += " and " + Passenger.COL_state + " =4";
		}
		if (typ == 3) {
			where += " and " + Passenger.COL_state + " =6";
		}
		if (typ == 14) {
			where += " and " + Passenger.COL_state + " =13";
		}

		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		System.out.println(listpassenger.size());

		for (int i = 0; i < listpassenger.size(); i++) {
			strReturn += "<tr>";
			strReturn += "<td align='center'><input type='hidden' id='txtpassid_"
					+ i
					+ "' value='"
					+ listpassenger.get(i).getId()
					+ "' /><input type='checkbox' disabled='disabled' checked='checked' id='chkpassenger_"
					+ i + "'></td>";
			if (i == 0) {
				strReturn += "<td rowspan=\""
						+ listpassenger.size()
						+ "\">"
						+ this.getTickettypeById(
								converNull(listpassenger.get(i)
										.getTickettypeid(), 0l)).getTypename()
						+ "</td>";
			}
			strReturn += "<td>"
					+ getPassTypeToString(listpassenger.get(i).getPtype())
					+ "</td>";
			strReturn += "<td>" + listpassenger.get(i).getName() + "</td>";
			strReturn += "<td>"
					+ getIDTypeToString(listpassenger.get(i).getIdtype())
					+ "</td>";
			strReturn += "<td><span id='gdvTic_ctl02_lbtnzj'>"
					+ listpassenger.get(i).getIdnumber() + "</span></td>";
			String strTicketNumber = "暂无";
			if (listpassenger.get(i).getTicketnum() != null
					&& !listpassenger.get(i).getTicketnum().equals("")) {
				strTicketNumber = listpassenger.get(i).getTicketnum();
			}
			strReturn += "<td>" + strTicketNumber + "</td>";
			strReturn += "<td>" + formatMoney(listpassenger.get(i).getPrice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getFuelprice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getAirportfee())
					+ "</td><td>"
					+ formatMoney(listpassenger.get(i).getAnjianfee())
					+ "</td><td>"
					+ formatMoney(listpassenger.get(i).getOtherfee()) + "</td>";

			if (listpassenger.get(i).getTuifee() != null) {
				strReturn += "<td style='color:red'><b>"
						+ formatMoney(listpassenger.get(i).getTuifee())
						+ "</b></td>";
			} else {
				strReturn += "<td>无</td>";
			}
			strReturn += "</tr>";

		}

		strReturn += "</tbody>";

		strReturn += "</table>";
		strReturn += "<span style='color:red' align='left'>原订单信息(点击订单号查看原订单信息)</span>";
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tbody>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td>订单编号</td>" + "<td>行程</td>" + "<td>起飞时间</td>"
				+ "<td>预订时间</td>" + "<td>航班号</td>" + "<td>航位</td>"
				+ "<td>PNR</td>";
		strReturn += "</tr>";
		strReturn += "</tr>";

		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.valueOf(strTuiOrderID));
		List<Segmentinfo> listseginfo = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where " + Segmentinfo.COL_orderid + "="
								+ strTuiOrderID + "", "", -1, 0);
		for (int i = 0; i < listseginfo.size(); i++) {
			strReturn += "<tr>";
			strReturn += "<td><a style='text-decoration:underline' href='orderinfo!toshowb2c.action?id="
					+ orderinfo.getId()
					+ "' target='_blank'>"
					+ orderinfo.getOrdernumber() + "</a></td>";
			strReturn += "<td>"
					+ getCitynameByAirport(listseginfo.get(i).getStartairport())
					+ "-"
					+ getCitynameByAirport(listseginfo.get(i).getEndairport())
					+ "</td>";
			strReturn += "<td>"
					+ formatTimestamp(listseginfo.get(i).getDeparttime())
					+ "</td>";
			strReturn += "<td>" + formatTimestamp(orderinfo.getCreatetime())
					+ "</td>";
			strReturn += "<td>" + listseginfo.get(i).getFlightnumber()
					+ "</td>";
			strReturn += "<td>" + listseginfo.get(i).getCabincode() + "</td>";
			strReturn += "<td>" + converNull(orderinfo.getPnr(), "")
					+ "(小)</br>" + converNull(orderinfo.getBigpnr(), "")
					+ "</td>";
			strReturn += "</tr>";
		}

		strReturn += "<tr><td colspan='10' height='5px'></td></tr>";
		strReturn += "</tbody>";
		strReturn += "</table>";
		// 加载升舱换开审核
		if (orderinfo.getOrderstatus() == 23
				|| orderinfo.getOrderstatus() == 30) {
			String wheresql = "WHERE ID=(" + orderinfo.getRelationorderid()
					+ ")";
			List<Orderinfo> orderinfos = Server.getInstance().getAirService()
					.findAllOrderinfo(wheresql, "", -1, 0);

			strReturn += "<span style='color:red' align='left'>新订单信息(点击订单号查看新订单信息)</span>";
			strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>"
					+ "<tr  class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
			strReturn += "<td>订单编号</td>" + "<td>行程</td>" + "<td>起飞时间</td>"
					+ "<td>预订时间</td>" + "<td>航班号</td>" + "<td>航位</td>"
					+ "<td>PNR</td>";
			strReturn += "</tr>";
			if (orderinfos.size() > 0) {
				Orderinfo neworder = orderinfos.get(0);
				String swhere = " WHERE C_ORDERID=" + neworder.getId();
				List<Segmentinfo> segmentinfos = Server.getInstance()
						.getAirService().findAllSegmentinfo(swhere, "", -1, 0);
				Segmentinfo segment = new Segmentinfo();
				if (segmentinfos.size() > 0) {
					segment = segmentinfos.get(0);
				}
				strReturn += "<tr><td><a style='text-decoration:underline' href='orderinfo!toshowb2c.action?id="
						+ neworder.getId()
						+ "' target='_blank'>"
						+ neworder.getOrdernumber() + "</a></td>";
				strReturn += "<td>"
						+ getCitynameByAirport(segment.getStartairport()) + "-"
						+ getCitynameByAirport(segment.getEndairport())
						+ "</td>";
				strReturn += "<td>" + formatTimestamp(segment.getDeparttime())
						+ "</td>";
				strReturn += "<td>" + formatTimestamp(neworder.getCreatetime())
						+ "</td>";
				strReturn += "<td>" + segment.getFlightnumber() + "</td>";
				strReturn += "<td>" + segment.getCabincode() + "</td>";
				strReturn += "<td>" + converNull(neworder.getPnr(), "")
						+ "(小)<br/>" + converNull(neworder.getBigpnr(), "")
						+ "(大)</td>";
				strReturn += "</tr>";
				strReturn += "</table>";
			} else {

				strReturn += "<tr><td colspan=\"7\">暂无</td></tr>";
			}
		}
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tr><td class='table_color_l colortrin' colspan='4' width='60px'><b>申请退废/改签原因如下</b></td></tr>";
		if (typ != 14) {
			strReturn += "<tr><td class='table_color_r colortrin' width='140px'>退废/改签原因:</td><td align='left'>";
			if (listpassenger.get(0).getTuifeiyuanyi() == 1) {
				if (typ == 3) {
					strReturn += "自愿改签";
				} else if (typ == 2) {
					strReturn += "自愿退票";
				} else {
					strReturn += "当日废票";
				}
			}
			if (listpassenger.get(0).getTuifeiyuanyi() == 2) {
				if (typ == 3) {
					strReturn += "非自愿改签";
				} else {
					strReturn += "自愿退票";
				}
			}
			if (listpassenger.get(0).getTuifeiyuanyi() == 3) {
				strReturn += "非自愿退票";
			}
			strReturn += "</td><td align='right' class='table_color_r colortrin' width='60px'>保留位置:</td><td align='left'>";
			if (listpassenger.get(0).getIscabinsite() == 0) {
				strReturn += "是";
			}
			if (listpassenger.get(0).getIscabinsite() == 1) {
				strReturn += "否";
			}
			strReturn += "</td></tr>";
		}
		// 改签信息
		if (typ == 3) {
			strReturn += "<tr >";
			strReturn += "<td class='table_color_r colortrin' width='120px' >改签时间：</td>";
			strReturn += "<td align='left' width='250px' colspan='3'>"
					+ listpassenger.get(0).getChangedate() + "</td>";

			strReturn += "</tr>";

			if ((listpassenger.get(0).getChangecabin() != null && !listpassenger
					.get(0).getChangecabin().equals(""))
					|| listpassenger.get(0).getChangeflight() != null
					&& !listpassenger.get(0).getChangeflight().equals("")) {
				strReturn += "<tr >";
				strReturn += "<td class='table_color_r colortrin' width='120px'>改签舱位：</td>";
				String strChcabin = "无";
				if (listpassenger.get(0).getChangecabin() != null
						&& !listpassenger.get(0).getChangecabin().equals("")) {
					strChcabin = listpassenger.get(0).getChangecabin();
				}
				strReturn += "<td align='left' width='250px'>" + strChcabin
						+ "</td>";
				String strChflight = "无";
				if (listpassenger.get(0).getChangeflight() != null
						&& !listpassenger.get(0).getChangeflight().equals("")) {
					strChflight = listpassenger.get(0).getChangeflight();
				}
				strReturn += "<td class='table_color_r colortrin' width='120px'>改签航班：</td>";
				strReturn += "<td align='left' width='250px'>" + strChflight
						+ "</td>";
				strReturn += "</tr>";
			}

		}
		if (typ == 14) {
			strReturn += "<tr >";
			strReturn += "<td class='table_color_r colortrin' width='120px'>新订单号：</td>";
			String strcpnr = "无";
			String strcp = "";
			if (orderinfo.getNewordernum() != null
					&& !orderinfo.getNewordernum().equals("")) {
				strcpnr = "<a style='text-decoration:underline' href='orderinfo!toshowb2c.action?id="
						+ orderinfo.getId()
						+ "' target='_blank'>"
						+ orderinfo.getNewordernum() + "</a>";
			}
			if (orderinfo.getNewpnr() != null
					&& !orderinfo.getNewpnr().equals("")) {
				strcp = orderinfo.getNewpnr();
			}
			strReturn += "<td align='left' width='250px'>" + strcpnr + "</td>";
			strReturn += "<td class='table_color_r colortrin' width='120px' >新PNR：</td>";
			strReturn += "<td align='left' width='250px' colspan='2'>" + strcp
					+ "</td>";
			strReturn += "</tr>";

			strReturn += "<tr >";
			strReturn += "<td class='table_color_r colortrin' width='120px'>新票号：</td>";
			String strTicNum = "";
			if (orderinfo.getNewticnum() != null
					&& !orderinfo.getNewticnum().equals("")) {
				strTicNum = orderinfo.getNewticnum();
			}
			strReturn += "<td align='left' width='250px'>" + strTicNum
					+ "</td>";
			strReturn += "<td class='table_color_r colortrin' width='120px' ></td>";
			strReturn += "<td align='left' width='250px' colspan='2'></td>";
			strReturn += "</tr>";
		}
		strReturn += "<tr><td class='table_color_r colortrin' width='60px'>备注说明:</td><td align='left' style='color:red' width='250px'>";
		String time = "";
		try {
			strReturn += listpassenger.get(0).getTuifeidesc();
			time = formatTimestamp(listpassenger.get(0).getTuifeitime());
		} catch (Exception e) {

		}
		strReturn += "</td><td class='table_color_r colortrin'>申请时间:</td><td align='left'>"
				+ time + "</td></tr>";
		strReturn += "<tr><td colspan='4' height='5px'></td></tr>";
		strReturn += "</table>";
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		if (typ != 3 && typ != 14) {
			if (orderinfo.getOrderstatus() == 4) {
				strReturn += "<tr><td width='140px' class='table_color_r colortrin'>暂不能退废票/改签原因：</td><td colspan='3' align='left'><input type='radio' id='rdoyes' name='radiotuifei' checked='checked' style='display:none' /> <input type='radio' checked='checked' id='rdono' name='radiotuifei' />其他原因</td></tr>";
			} else {
				strReturn += "<tr><td width='140px' class='table_color_r colortrin'>暂不能退废票/改签原因：</td><td colspan='3' align='left'><input type='radio' id='rdoyes' name='radiotuifei' checked='checked' />废票时间已过 <input type='radio' id='rdono' name='radiotuifei' />其他原因</td></tr>";
			}

		} else {
			strReturn += "<tr><td width='140px' colspan='4' style='color:red' align='left'>如果审核不通过请将不能审核通过原因填写在备注说明中</td></tr>";
		}
		strReturn += "<tr><td class='table_color_r colortrin' width='120'>备注说明</td><td colspan='3' align='left'><textarea rows='5' id='beizhu' cols='60'></textarea></td></tr>";
		strReturn += "</table>";

		if (typ == 2) {
			strReturn += "<br /><input class='button_d font-bai' value='审核通过' onclick='shenhetuiticket("
					+ strTuiOrderID
					+ ","
					+ intpasscount
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='审核不通过' onclick='noshenhetuiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			// 打印退票单按钮
			// strReturn += "<input class='button_d font-bai' value='打印退票单'
			// onclick='javascript:prn1_print();' type='button'>
			// &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		if (typ == 1) {
			strReturn += "<br /><input class='button_d font-bai' value='审核通过' onclick='shenhefeiticket("
					+ strTuiOrderID
					+ ","
					+ intpasscount
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='审核不通过' onclick='noshenhefeiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		if (typ == 3) {
			strReturn += "<br /><input class='button_d font-bai' value='审核通过' onclick='shenhegaiticket("
					+ strTuiOrderID
					+ ","
					+ intpasscount
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='审核不通过' onclick='noshenhegaiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		if (typ == 14) {
			strReturn += "<br /><input class='button_d font-bai' value='审核通过' onclick='shenheshengcangticket("
					+ strTuiOrderID
					+ ","
					+ intpasscount
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='审核不通过' onclick='noshenhegaiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	public void gettuipiaodan() throws Exception {
		// 得到订单信息
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		int state = Integer.valueOf(ServletActionContext.getRequest()
				.getParameter("orderstate"));
		int sqrcstate = 4;
		int shrcstate = 12;
		String orderstr = "退";
		if (state == 1) {
			orderstr = "废";
			sqrcstate = 5;
			shrcstate = 11;
		}

		String strCompan = "无";
		try {
			Customeruser customeruser = Server.getInstance().getMemberService()
					.findCustomeruser(orderinfo.getCustomeruserid());
			Customeragent customeragent = new Customeragent();
			customeragent = Server.getInstance().getMemberService()
					.findCustomeragent(customeruser.getAgentid());
			if (customeragent.getAgentshortname() != null) {
				strCompan = customeragent.getAgentshortname();
			}
			if (customeruser.getDeptid() != null
					&& customeruser.getDeptid() != 0) {
				strCompan += "/"
						+ getdepartmentNamebyId(customeruser.getDeptid());
			}
		} catch (Exception ex) {
		}
		// 申请人
		String strshenqingren = "";
		// 申请时间
		String strshenqingshijian = "";
		// 备注
		String strmemo = "";
		// 通过操作记录得到申请退票人信息时间
		List<Orderinforc> listorderinforc = Server.getInstance()
				.getAirService().findAllOrderinforc(
						" where " + Orderinforc.COL_orderinfoid + "="
								+ strTuiOrderID + " and "
								+ Orderinforc.COL_state + "=" + sqrcstate, "",
						-1, 0);
		if (listorderinforc.size() > 0) {
			strshenqingren = getemployeenamebyid(listorderinforc.get(0)
					.getCustomeruserid());
			strshenqingshijian = formatTimestamp(listorderinforc.get(0)
					.getCreatetime());
			if (listorderinforc.get(0).getContent().indexOf("：") >= 0) {
				if (listorderinforc.get(0).getContent().split("：").length >= 2) {
					strmemo = listorderinforc.get(0).getContent().split("：")[1];
				}

			}
		}
		// 退票人
		String strtuipiaoren = "";
		// 退票时间
		String strtuipiaoshijian = "";

		List<Orderinforc> listorderinforc2 = Server.getInstance()
				.getAirService().findAllOrderinforc(
						" where " + Orderinforc.COL_orderinfoid + "="
								+ strTuiOrderID + " and "
								+ Orderinforc.COL_state + "=" + shrcstate, "",
						-1, 0);
		if (listorderinforc2.size() > 0) {
			strtuipiaoren = getemployeenamebyid(listorderinforc2.get(0)
					.getCustomeruserid());
			strtuipiaoshijian = formatTimestamp2(listorderinforc2.get(0)
					.getCreatetime());
		}
		// 票号
		String strpiaohao = "";
		// 退款金额
		String strtuikuanjine = "";
		// 退票费
		String strtuipiaofei = "";
		// 机票类型
		String strtickettype = "";
		// 退票原因
		String strtuireason = "";

		List<Passenger> listpass = Server.getInstance().getAirService()
				.findAllPassenger(
						"where " + Passenger.COL_orderid + "=" + strTuiOrderID
								+ "", "", -1, 0);
		if (listpass.size() > 0) {
			if (listpass.get(0).getTicketnum() != null) {
				strpiaohao = listpass.get(0).getTicketnum();
			} else {
				strpiaohao = "";
			}

			if (listpass.get(0).getTuifeiyuanyi() == 1) {
				strtuireason = "客户自愿" + orderstr + "票";
			} else if (listpass.get(0).getTuifeiyuanyi() == 2) {
				strtuireason = "非自愿" + orderstr + "票";
			}
			strtuipiaofei = listpass.get(0).getTuifee() + "";
			float tuikuanjine = 0f;
			for (int i = 0; i < listpass.size(); i++) {
				tuikuanjine += converNull(listpass.get(i).getAirportfee(), 0f)
						+ converNull(listpass.get(i).getFuelprice(), 0f)
						+ converNull(listpass.get(i).getPrice(), 0f)
						+ converNull(listpass.get(i).getAnjianfee(), 0f)
						+ converNull(listpass.get(i).getOtherfee(), 0f);
			}
			strtuikuanjine = String.valueOf(tuikuanjine
					- listpass.get(0).getTuifee());
			System.out.println(listpass.get(0).getTickettypeid());
			strtickettype = this.getTickettypeById(
					listpass.get(0).getTickettypeid()).getTypename();
		}
		// 打印退票单页面
		strReturn += "<div><table border='0' width='100%' id='tbprint' style='font-size:16px;line-height:9px;font-family:Tahoma,TEC,TEE;' cellpadding='0' cellspacing='0'>";
		strReturn += "<tr>";
		strReturn += "<td style='font-size:24px;line-height:30px; text-align:center; font-weight:bold'>";
		strReturn += "<font size='5em'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;允风文化航空票务"
				+ orderstr + "票单</font></td>";
		strReturn += "</tr>";
		strReturn += "<tr>";
		strReturn += "<td height='30px'></td>";
		strReturn += "</tr>";
		strReturn += "<tr>";
		strReturn += "<td align='center'>";
		strReturn += "<table border='0' width='90%' style='font-family:Tahoma,TEC,TEE;' ellpadding='0' cellspacing='0'>";
		strReturn += "<tr>";
		strReturn += "<td align='right' width='15%'>申请人：</td><td align='left' width='40%'>"
				+ strshenqingren
				+ "</td><td align='right' width='15%'>申请时间：</td><td align='left'>"
				+ strshenqingshijian + "</td>";
		strReturn += "</tr>";
		strReturn += "<tr>";
		strReturn += "<td align='right' width='15%'>" + orderstr
				+ "票人：</td><td align='left' width='40%'>" + strtuipiaoren
				+ "</td><td align='right' width='15%'>" + orderstr
				+ "票时间：</td><td align='left'>" + strtuipiaoshijian + "</td>";
		strReturn += "</tr>";
		strReturn += "<tr>";
		strReturn += "<td align='right' width='15%'>客户名称：</td><td align='left' width='40%'>"
				+ strCompan
				+ "</td><td align='right' width='15%'>"
				+ orderstr
				+ "票原因：</td><td align='left'>" + strtuireason + "</td>";
		strReturn += "</tr>";
		strReturn += "<tr>";
		strReturn += "<td colspan='4' height='30px'></td>";
		strReturn += "</tr>";
		strReturn += "</table>";
		strReturn += "</td>";
		strReturn += "</tr>";
		strReturn += "<tr><td align='center'>";
		strReturn += "<table border='0' width='80%' style='font-family:Tahoma,TEC,TEE;' ellpadding='0' cellspacing='0'>";
		strReturn += "<tr><td align='right' width='15%'>票号：</td><td width='30%'>"
				+ strpiaohao
				+ "</td><td align='right'>退款金额：</td><td align='left'>"
				+ strtuikuanjine + "</td></tr>";
		strReturn += "<tr><td align='right' width='15%'>票种：</td><td align='left' width='30%'>"
				+ strtickettype
				+ "</td><td align='right'>"
				+ orderstr
				+ "票费：</td><td align='left'>" + strtuipiaofei + "</td></tr>";
		strReturn += "<tr><td align='right' width='15%'>备注：</td><td align='left' width='30%'>"
				+ strmemo
				+ "</td><td align='right'>订单号：</td><td align='left'>"
				+ orderinfo.getOrdernumber() + "</td></tr>";
		strReturn += "</table>";
		strReturn += "</td></tr>";
		strReturn += "</td></tr>";
		strReturn += "<tr><td height='10px'></td></tr>";
		strReturn += "</table></div>";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
		// 打印退票单页面
	}

	// 得到配送信息<a href="javascript:
	// goEdit('orderinfo!toshowb2c.action?id=12100','12100');">A22100</a>

	public void getHuanKai() throws Exception {
		String strReturn = "";
		strReturn += "<table id='tbpeisonginfo' class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tr><td colspan='6' align='left'><b>航程信息</b></td></tr>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td colspan='2'>出发城市-到达城市</td>" + "<td>航班号</td>"
				+ "<td>舱位码</td>" + "<td colspan='2'>起飞时间</td><td></td>";
		strReturn += "</tr>";

		List<Segmentinfo> listseginfo = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + strTuiOrderID, "", -1,
						0);
		for (int i = 0; i < listseginfo.size(); i++) {
			strReturn += "<tr>";
			strReturn += "<td colspan='2'>"
					+ listseginfo.get(i).getStartairport() + "-"
					+ listseginfo.get(i).getEndairport() + "</td>";
			strReturn += "<td>" + listseginfo.get(i).getFlightnumber()
					+ "</td>";
			strReturn += "<td>" + listseginfo.get(i).getCabincode() + "</td>";
			strReturn += "<td colspan='2'>"
					+ formatTimestamp(listseginfo.get(i).getDeparttime())
					+ "</td>";
			strReturn += "</tr>";
		}
		strReturn += "<tr><td colspan='6' height='5px'></td></tr>";
		strReturn += "<tr>";
		strReturn += "<td colspan='6'>";
		strReturn += "<table class='book_pgcontent' width='100%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tbody>";

		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td><input type='hidden' id='checkboxflag' value='0' /><input type='checkbox' style='display:none' id='chkpassenger1_all' onclick='checkallbox();'></td><td>乘客类型</td><td>乘客姓名</td><td>证件类型</td><td>证件号码</td><td>票号</td><td>票价</td><td>燃油</td><td>机建</td>";
		strReturn += "</tr>";
		String where = "WHERE C_ORDERID=" + strTuiOrderID + " and "
				+ Passenger.COL_state + "<>12";
		List<Passenger> listpassenger1 = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		int intpasscount = listpassenger1.size();

		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));

		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);

		for (int i = 0; i < listpassenger.size(); i++) {
			strReturn += "<tr>";
			strReturn += "<td align='center'><input type='hidden' id='txtpassid_"
					+ i
					+ "' value='"
					+ listpassenger.get(i).getId()
					+ "' /><input type='checkbox' id='chkpassenger_"
					+ i
					+ "'></td>";
			strReturn += "<td>"
					+ getPassTypeToString(listpassenger.get(i).getPtype())
					+ "</td>";
			strReturn += "<td>" + listpassenger.get(i).getName() + "</td>";
			strReturn += "<td>"
					+ getIDTypeToString(listpassenger.get(i).getIdtype())
					+ "</td>";
			strReturn += "<td><span id='gdvTic_ctl02_lbtnzj'>"
					+ listpassenger.get(i).getIdnumber() + "</span></td>";
			String strTicketNumber = "暂无";
			if (listpassenger.get(i).getTicketnum() != null
					&& !listpassenger.get(i).getTicketnum().equals("")) {
				strTicketNumber = listpassenger.get(i).getTicketnum();
			}
			strReturn += "<td>" + strTicketNumber + "</td>";
			strReturn += "<td>" + formatMoney(listpassenger.get(i).getPrice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getFuelprice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getAirportfee())
					+ "</td>";
			// if(orderinfo.getRelationorderid()!=null)
			// {
			// List<Passenger>
			// listpas=Server.getInstance().getAirService().findAllPassenger("where
			// "+Passenger.COL_orderid+"='"+orderinfo.getRelationorderid()+"'",
			// "", -1, 0);
			//			   
			// strReturn+="<td
			// style='color:red'><b>"+listpas.get(i).getTicketnum()+"</b></td>";
			// }
			// else
			// {
			// strReturn+="<td>无</td>";
			// }
			strReturn += "</tr>";

		}

		strReturn += "<tr><td colspan='10' height='5px'></td></tr>";
		strReturn += "</tbody>";

		strReturn += "</table>";
		strReturn += "</td>";
		strReturn += "</tr>";

		strReturn += "<tr height='10px'><td colspan='6'></td></tr>";
		if (typ == 1) {
			strReturn += "<tr><td colspan='6' align='left'><span style='color:red'>请生成新的换开订单或将新生成的换开PNR导入系统中，进行查询</span></td></tr>";
			strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'><td colspan='6' align='left'><b>换开操作处理</b></td></tr>";
			strReturn += "<td class='table_color_r colortrin'>新订单号：</td><td align='left'><input type='text' id='txtordernumber' /></td><td class='table_color_r colortrin'>新PNR:</td><td align='left' colspan='3'><input type='text' id='txtorderpnr' /></td>";
			strReturn += "</tr>";

			// strReturn+="<tr id='trchangecangwei' ><td class='table_color_r
			// colortrin' width='120px'>更改舱位：</td><td align='left'><input
			// type='text' id='txtchangecabin' name='changecabin' /></td><td
			// class='table_color_r colortrin' width='120px'>更改航班：</td><td
			// align='left' colspan='3'><input type='text' id='txtchangeflight'
			// name='changeflight' /></td></tr>";
			strReturn += "<tr  id='trchangecangwei' ><td class='table_color_r colortrin' width='120px'>新票号：</td><td align='left' colspan='5'><input type='text' id='txtnewticnum' name='newticnum' />  <span style='color:red'>新PNR和新票号至少填写一项</span></td></tr>";

			strReturn += "<tr><td colspan='6' align='center'><br /><input type='button' id='btnsearch' value='申请升舱换开' onclick='dohuankai("
					+ strTuiOrderID
					+ ");' class='button_d font-bai'> &nbsp;&nbsp;&nbsp;&nbsp;<input type='button' id='btnview' style='display:none' value='提取订单信息' onclick='showorderinfo();' class='button_d font-bai'></td></tr>";
			strReturn += "<tr><td colspan='6' style='color:red' align='left'>请填写新订单号或者新的PNR，进行换开操作</td></tr>";
		} else if (typ == 2) {
			strReturn += "<tr><td colspan='6' align='left'><span style='color:red'>请审核换开信息</span></td></tr>";
			strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'><td colspan='6' align='left'><b>换开操作处理</b></td></tr>";
			String strNewOrderNum = "无";
			// if(orderinfo.getRelationorderid()!=null)
			// {
			// strNewOrderNum=Server.getInstance().getAirService().findOrderinfo(orderinfo.getRelationorderid()).getOrdernumber();
			// }
			// String strNewPnR="无";
			// if(orderinfo.getNewpnr()!=null &&
			// orderinfo.getNewpnr().trim().length()>0)
			// {
			// strNewPnR=orderinfo.getNewpnr();
			// }

			strReturn += "<td class='table_color_r colortrin'>新订单号：</td><td align='left'>"
					+ orderinfo.getNewordernum()
					+ "</td>"
					+ "<td class='table_color_r colortrin'>新PNR:</td><td align='left' colspan='3'>"
					+ orderinfo.getNewpnr() + "</a>&nbsp;&nbsp;</td>";
			strReturn += "</tr>";

			strReturn += "<tr  id='trchangecangwei' ><td class='table_color_r colortrin' width='120px'>新票号：</td><td align='left' colspan='5'>"
					+ orderinfo.getNewticnum() + "</td></tr>";

			strReturn += "<tr><td colspan='6' align='center'><br /><input type='button' id='btnsearch' value='审核通过' onclick='shenhehuankaitongguo("
					+ strTuiOrderID
					+ ");' class='button_d font-bai'> &nbsp;&nbsp;&nbsp;&nbsp;<input type='button' id='btnsearch' value='审核不通过' onclick='' class='button_d font-bai'></td></tr>";
			strReturn += "<tr><td colspan='6' style='color:red' align='left'>请填写新订单号或者新的PNR，进行换开操作</td></tr>";
		}
		strReturn += "</table>";

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	// 换开操作
	public void doHuanKai() throws Exception {
		String strReturn = "";
		Orderinfo neworder = new Orderinfo();
		if ((strNewOrderID != null && !strNewOrderID.equals(""))
				|| (strSepPNR != null) && strSepPNR.length() > 0) {
			List<Orderinfo> listorderinfo = Server.getInstance()
					.getAirService().findAllOrderinfo(
							"WHERE C_ORDERNUMBER='" + strNewOrderID
									+ "' or C_PNR='" + strSepPNR + "'", "", -1,
							0);
			if (listorderinfo.size() > 0) {
				neworder = listorderinfo.get(0);
				neworder.setRelationorderid(Long.parseLong(strTuiOrderID));
				Server.getInstance().getAirService().updateOrderinfo(neworder);
			}
		}
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		// 更新旧订单
		orderinfo.setRelationorderid(neworder.getId());
		orderinfo.setNewpnr(neworder.getPnr());
		Orderinfo order = Server.getInstance().getAirService().findOrderinfo(
				Long.valueOf(strNewOrderID));
		if (order != null)
			orderinfo.setNewordernum(order.getOrdernumber());
		orderinfo.setNewticnum(strNewTicNum);
		Server.getInstance().getAirService().updateOrderinfo(orderinfo);

		strReturn = "申请换开成功";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	/**
	 * 根据订单id获得订单中所包含的票的票号
	 * 
	 * @param orderid
	 * @return
	 */
	public String getTicketnumByOrderid(long orderid) {
		String ticketnum = "";
		String where = " WHERE C_ORDERID=" + orderid + " AND "
				+ Passenger.COL_state + "<>12";
		List<Passenger> passengers = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		for (Passenger passenger : passengers) {
			if (ticketnum.length() > 0) {
				ticketnum += "<br/>" + passenger.getTicketnum();

			} else {
				ticketnum += passenger.getTicketnum();
			}
		}
		return ticketnum;

	}

	public float getTuifeeByOrderid(long orderid) {
		float price = 0f;
		String where = " WHERE C_ORDERID=" + orderid + " AND "
				+ Passenger.COL_state + "<>12";
		List<Passenger> passengers = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		for (Passenger passenger : passengers) {
			price += converNull(passenger.getTuifee(), 0f);
		}
		return price;
	}

	/**
	 * 更改订单为已打印
	 */
	public void printChange() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String orderid = request.getParameter("orderid");
		String sql = "UPDATE T_ORDERINFO SET C_ISPRINT=1 WHERE ID=" + orderid;
		Server.getInstance().getSystemService().findMapResultBySql(sql, null);

	}

	// 收银操作
	public void doShoukuan() throws Exception {
		String strReturn = "";
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(orderinfo.getCustomeruserid());
		System.out.println(orderinfo.getCustomeruserid());
		System.out.println(customeruser == null);
		Customeragent agent = Server.getInstance().getMemberService()
				.findCustomeragent(orderinfo.getCustomeragentid());
		try {
			String scripturl = "<style type=\"text/css\">.dhide{display:none;}</style><script type=\"text/javascript\" src=\"${pageContext.request.contextPath}/js/adapter/ext/ext-base.js\"></script>";
			strReturn += "<div id='shouyininfo'><table id='tbcompanyinfo' class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
			strReturn += "<tr><td colspan='8' align='left' ><b>公司信息</b></td></tr>";
			String strDeptName = "无";
			if (converNull(customeruser.getDeptid(), 0l) != 0) {
				strDeptName = getDeptNameByID(customeruser.getDeptid()
						.toString());
			}
			String strBookerName = "";
			if (orderinfo.getSaleagentid() != null) {
				strBookerName = getusername(orderinfo.getSaleagentid());
			}
			String linkname = orderinfo.getContactname();
			strReturn += "<tr><td class='table_color_r colortrin'>公司部门：</td><td width='100px' aling='left'>"
					+ strDeptName
					+ "</td><td class='table_color_r colortrin' aling='left'>预订人：</td><td>"
					+ strBookerName
					+ "</td>"
					+ "<td class='table_color_r colortrin'>所属大客户:</td><td>"
					+ converNull(agent.getAgentshortname(), agent
							.getAgentcompanyname())
					+ "</td><td class='table_color_r colortrin'>联系人:</td><td>"
					+ linkname + "</td></tr>";
			strReturn += "</table><br />";
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		strReturn += "<table id='tbpeisonginfo' class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tr><td colspan='6' align='left'><b>航程信息</b></td></tr>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td colspan='2'>出发城市-到达城市</td>" + "<td>航班号</td>"
				+ "<td>舱位码</td>" + "<td colspan='2'>起飞时间</td><td></td>";
		strReturn += "</tr>";

		List<Segmentinfo> listseginfo = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + strTuiOrderID, "", -1,
						0);
		for (int i = 0; i < listseginfo.size(); i++) {
			strReturn += "<tr>";
			strReturn += "<td colspan='2'>"
					+ listseginfo.get(i).getStartairport() + "-"
					+ listseginfo.get(i).getEndairport() + "</td>";
			strReturn += "<td>" + listseginfo.get(i).getFlightnumber()
					+ "</td>";
			strReturn += "<td>" + listseginfo.get(i).getCabincode() + "</td>";
			strReturn += "<td colspan='2'>"
					+ formatTimestamp(listseginfo.get(i).getDeparttime())
					+ "</td>";
			strReturn += "</tr>";
		}
		strReturn += "</table>";
		strReturn += "<br />";
		strReturn += "<table id='tbpassenger' class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tbody>";
		strReturn += "<tr><td colspan='12' align='left'><b>乘机人信息</b></td></tr>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td>机票类型</td><td>乘客类型</td><td>乘客姓名</td><td>证件类型</td><td>证件号码</td><td>票号</td><td>票价</td><td>燃油</td><td>机建</td><td>安检</td><td>其它</td><td>小计</td>";
		strReturn += "</tr>";
		String where = "WHERE C_ORDERID=" + strTuiOrderID + " AND C_STATE<>12";

		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		float insurprce = 0f;
		for (int i = 0; i < listpassenger.size(); i++) {
			Passenger passenger = listpassenger.get(i);
			
				insurprce += passenger.getInsurprice();
			
			strReturn += "<tr>";
			// strReturn+="<td align='center'><input type='hidden'
			// id='txtpassid_"+i+"' value='"+listpassenger.get(i).getId()+"'
			// /><input type='checkbox' checked='checked'
			// id='chkpassenger_"+i+"'></td>";
			if (i == 0) {
				strReturn += "<td rowspan=\""
						+ listpassenger.size()
						+ "\">"
						+ this.getTickettypeById(
								converNull(passenger.getTickettypeid(), 0l))
								.getTypename() + "</td>";
			}
			strReturn += "<td>"
					+ getPassTypeToString(listpassenger.get(i).getPtype())
					+ "</td>";
			strReturn += "<td>" + listpassenger.get(i).getName() + "</td>";
			strReturn += "<td>"
					+ getIDTypeToString(listpassenger.get(i).getIdtype())
					+ "</td>";
			strReturn += "<td><span id='gdvTic_ctl02_lbtnzj'>"
					+ listpassenger.get(i).getIdnumber() + "</span></td>";
			String strTicketNumber = "暂无";
			if (listpassenger.get(i).getTicketnum() != null
					&& !listpassenger.get(i).getTicketnum().equals("")) {
				strTicketNumber = listpassenger.get(i).getTicketnum();
			}
			strReturn += "<td>" + strTicketNumber + "</td>";
			strReturn += "<td>" + formatMoney(passenger.getPrice()) + "</td>";
			strReturn += "<td>" + formatMoney(passenger.getFuelprice())
					+ "</td>";
			strReturn += "<td>" + formatMoney(passenger.getAirportfee())
					+ "</td>";
			strReturn += "<td>" + formatMoney(passenger.getAnjianfee())
					+ "</td><td>" + formatMoney(passenger.getOtherfee())
					+ "</td>";

			strReturn += "<td>"
					+ formatMoney(converNull(passenger.getPrice(), 0f)
							+ converNull(passenger.getFuelprice(), 0f)
							+ converNull(passenger.getAirportfee(), 0f)
							+ converNull(passenger.getAnjianfee(), 0f)
							+ converNull(passenger.getOtherfee(), 0f))
					+ "</td>";

			strReturn += "</tr>";

		}
		strReturn += "</tbody>";

		strReturn += "</table>";

		strReturn += "<br />";
		strReturn += "<table id='tbpayinfo' class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tr><td colspan='10' align='left'><b>支付信息</b></td></tr>";
		strReturn += "<tr>";
		strReturn += "<td align='right' width='100px' class='table_color_r colortrin'><input type=\"hidden\" id=\"9\" value=\""
				+ orderinfo.getPaymethod() + "\"/>应付金额：</td>";
		strReturn += "<td align='left' width='110px' style='color:red;font-weight:bold'>"
				+ formatMoney(converNull(orderinfo.getTotalticketprice(), 0f)
						+ converNull(orderinfo.getTotalairportfee(), 0f)
						+ converNull(orderinfo.getTotalanjian(), 0f)
						+ converNull(orderinfo.getTotalotherfee(), 0f)
						+ converNull(orderinfo.getTotalfuelfee(), 0f))
				+ "</td>";
		strReturn += "<td align='right' class='table_color_r colortrin'>保险：</td><td>"
				+ insurprce + "</td>";
		strReturn += "<td align='right'  class='table_color_r colortrin'>付款方式：</td>";
		strReturn += "<td align='left' style='color:red;font-weight:bold'>";
		String strPayMethod = getPayMethodStr(orderinfo.getPaymethod());
		String strHtmlSelect = "";
		// 个人挂账员工集合
		if (orderinfo.getPaymethod() == 5) {
			strReturn += "<input type='hidden' id='sid' size='5' name='fkmethod' value='8'/>月结挂账";
		} else {
			List<Customeruser> listemployee = Server
					.getInstance()
					.getMemberService()
					.findAllCustomeruser(
							" WHERE C_AGENTID = 46 AND C_TYPE = 1 AND ID <> 62",
							"", -1, 0);
			strHtmlSelect += "<select name='guazhangrenid' id='ddlemployeeid'>";
			strHtmlSelect += "<option value='0'>--请选择个人挂账员工--</option>";
			for (int i = 0; i < listemployee.size(); i++) {

				strHtmlSelect += "<option value='"
						+ listemployee.get(i).getId() + "'>"
						+ listemployee.get(i).getMembername() + "</option>";
			}
			strHtmlSelect += "</select>";
			String opetion = "<option value='1' id='xj'>现金</option><option value='2' id='zp'>支票</option><option value='3' id='jh'>建行POS</option><option value='4' id='ylpos'>银联POS</option>"
					+ "<option value='5' id='myp '>免优票</option><option  value='6' id='lcj'>里程券</option>";
			if (!isBiguserOrder(orderinfo)) {
				opetion += "<option  value='7' ";
				if (orderinfo.getPaymethod() == 7) {
					opetion += "selected='selected'";
				}
				opetion += " id='grgz'>个人挂账</option>";
			}

			strReturn += "<select name=\"fkmethod\" id='sid' onchange=\"change()\">";
			int paymethod = orderinfo.getPaymethod();
			if (paymethod == 2 || paymethod == 3 || paymethod == 6) {
				strReturn += opetion;
			} else {
				strReturn += opetion
						+ "<option id='yjgz'  value='8'>月结挂账</option>"
						+ "<option id='wszf'  value='9'>网上支付</option>"
						+ "<option id='yhhk' value='10' >银行汇款</option>";

			}
			strReturn += "<option id='nbjs' value='11' >内部结算</option></select>";

		}
		strReturn += "</td>";
		List<Passenger> listpassenger2 = Server
				.getInstance()
				.getAirService()
				.findAllPassenger("WHERE C_ORDERID=" + strTuiOrderID, "", -1, 0);
		// 判断含有几个乘机人，如果含有多个乘机人，添加分离打印功能
		String strFenliBtn = "";
		String strPassIDs = "";
		if (listpassenger2.size() > 1) {
			for (int i = 0; i < listpassenger2.size(); i++) {
				strPassIDs += listpassenger2.get(i).getId() + "|";
			}
			strFenliBtn = "&nbsp;&nbsp;<input class='button_d font-bai' onclick='javascript:fenlidayin('"
					+ strTuiOrderID
					+ "','"
					+ strPassIDs
					+ "');' value='分离打印' type='button'>";
		}
		if (orderinfo.getPaymethod() != 5) {
			strReturn += " <td class='table_color_r colortrin divgrgz' align='right' id='divgrgz'>个人挂帐:</td><td class=\"divgrgz\" align='left'>"
					+ strHtmlSelect + "</td></div>";
		}
		strReturn += "</tr>";
		strReturn += "<tr><td colspan='10' align='center'><input class='button_d font-bai' value='收银' onclick=' if(isSelectPeople()){doshoukuan("
				+ strTuiOrderID
				+ ")};' type='button'>&nbsp;&nbsp;"
				+ "<input class='button_d font-bai' onclick='javascript:printChange("
				+ orderinfo.getId()
				+ ");prn1_print();' value='打印送票单' type='button'>&nbsp;&nbsp;<input class='button_d font-bai' onclick='closedialog(0);' value='取消' type='button'>&nbsp;&nbsp;<input class='button_d font-bai' onclick='javascript:prn1_preview();' value='预览送票单' type='button'>"
				+ strFenliBtn + "</td></tr>";
		strReturn += "</table></div>";
		String strAddress = "";
		if (orderinfo.getAddresa() != null
				&& !orderinfo.getAddresa().equals("")) {
			strAddress = orderinfo.getAddresa();
		} else {
			strAddress = "无";
		}
		String strMemo = "";
		if (orderinfo.getMemo() != null && !orderinfo.getMemo().equals("")) {
			strMemo = orderinfo.getMemo();
		} else {
			strMemo = "无";
		}

		String strPayName = getPayMethodStr(orderinfo.getPaymethod());

		strReturn += "<div id='tbpreivew'><table border='0' width='100%' id='tbprint' style='font-size:16px;line-height:9px;font-family:Tahoma,TEC,TEE;display:none;' cellpadding='0' cellspacing='0'>";
		strReturn += "<tr>";
		strReturn += "<td colspan='7' style='font-size:24px;line-height:30px; text-align:center; font-weight:bold'>";
		strReturn += "<font size='5em'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;东航国旅送票单</font></td>";
		String strTicketType = "";
		if (listpassenger2.size() > 0) {
			String strtemp = listpassenger2.get(0).getTicketnum();
			try {
				if (strtemp.trim().length() >= 3) {
					List<Ticketnumber> ticketnumberlist = Server.getInstance()
							.getMemberService().findAllTicketnumber("", "", -1,
									0);
					for (int i = 0; i < ticketnumberlist.size(); i++) {
						if (ticketnumberlist.get(i).getBeginnumber().indexOf(
								strtemp.substring(0, 3)) >= 0) {
							strTicketType = getTickettypeById(
									ticketnumberlist.get(i).getTickettypeid())
									.getTypename()
									+ "";
							break;
						}
					}
				}
			} catch (Exception ex) {

			}
		}
		try {
			strTicketType = getTickettypeById(
					listpassenger2.get(0).getTickettypeid()).getTypename();
		} catch (Exception ex) {

		}
		strReturn += "<td width='15%' valign='bottom'><font size='2em'>"
				+ strTicketType + "</font></td></tr>";
		// strReturn+="<tr><td colspan='8' height='10px'></td></tr>";
		String strCompan = "无";
		if (agent.getAgentshortname() != null) {
			strCompan = agent.getAgentshortname();
		}
		if (customeruser.getDeptid() != null && customeruser.getDeptid() != 0) {
			strCompan += "/" + getdepartmentNamebyId(customeruser.getDeptid());
		}
		String strcontactname = "无";
		String strcontacttel = "无";
		String strPnr = "";
		String strBigPnr = "";
		if (orderinfo.getContactname() != null
				&& !orderinfo.getContactname().equals("")) {
			strcontactname = orderinfo.getContactname();
		}
		// 如果联系人是散客，取散客的真实姓名
		if (orderinfo.getCustomeragentid() == 46) {
			if (orderinfo.getPostname() != null
					&& !orderinfo.getPostname().equals("")) {
				strcontactname = orderinfo.getPostname();
			}
		}
		if (orderinfo.getContacttel() != null
				&& !orderinfo.getContacttel().equals("")) {
			strcontacttel = orderinfo.getContacttel();
		}
		// 如果联系人是散客，收票人电话
		if (orderinfo.getCustomeragentid() == 46) {
			if (orderinfo.getPostmobile() != null
					&& !orderinfo.getPostmobile().equals("")) {
				strcontacttel = orderinfo.getPostmobile();
			}
		}
		if (orderinfo.getPnr() != null && !orderinfo.getPnr().equals("")) {
			strPnr = orderinfo.getPnr();
		} else if (orderinfo.getBigpnr() != null
				&& !orderinfo.getBigpnr().equals("")) {
			strPnr = orderinfo.getBigpnr();
		}
		strReturn += "<tr style='line-height:15px'><td align='right'>Customer:</font></td><td align='left'>"
				+ strCompan + "</td>";
		strReturn += "<td align='right'>Contact:</td>";
		strReturn += "<td align='left' style='height:15px;line-height:15px;'>"
				+ strcontactname + "</td><td align='right'>No:</font></td>";
		strReturn += "<td align='left' style='height:15px;line-height:15px;'>"
				+ orderinfo.getOrdernumber() + "</td>";
		strReturn += "<td align='right' style='height:15px;line-height:15px;'>PNR:</font></td><td align='left' style='height:15px;line-height:15px;'>"
				+ strPnr + "</td></tr>";
		strReturn += "<tr style=''><td  style='height:15px;line-height:15px;' align='right'><font >Tel:</font></td>";
		strReturn += "<td align='left'style='height:15px;line-height:15px;'><font >"
				+ strcontacttel + "</font></td>";
		strReturn += "<td align='right' style='height:15px;line-height:15px;'><font >Book:</font></td><td align='left' style='height:15px;line-height:15px;'>"
				+ getCustomerNameById(orderinfo.getSaleagentid()) + "</td>";
		strReturn += "<td align='right' style='height:15px;line-height:15px;'><font >Issue:</font></td><td align='left' style='height:15px;line-height:15px;'><font >"
				+ formatTimestamp(orderinfo.getPrinttime()) + "</font></td>";
		strReturn += "<td align='right' style='height:10px;line-height:10px;'><font >Payment:</font></td><td align='left' style='size:2em;height:10px;line-height:10px;'><font >"
				+ strPayName + "</font></td></tr>";
		strReturn += "<tr style='line-height:15px'><td align='right' style='height:15px;line-height:15px;'>Addr:</td><td align='left'>"
				+ strAddress + "</td>";
		strReturn += "<td align='right'></td><td align='left'></td><td align='right'>Memo:</td><td align='left'>"
				+ SubString(strMemo, 20) + "</td>";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		strReturn += "<td align='right' style='height:10px;line-height:10px;'>Print:</td><td align='left'>"
				+ dateFormat.format(new Timestamp(System.currentTimeMillis())
						.getTime()) + "</td></tr>";
		strReturn += "<tr><td colspan='8'><hr size='1px' style='height:1px; width:100%'></td></tr>";

		strReturn += "<tr><td colspan='8'>";
		// 横线以下的数据
		strReturn += "<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td width='40%'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td width='5%' valign='top' ><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td style='height:10px;line-height:10px;'>Line1:</td>";
		strReturn += "</tr>";
		strReturn += "</table>";
		strReturn += "</td>";
		strReturn += "<td width='24%' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td>&nbsp;</td>";
		strReturn += "</tr>";
		for (int i = 0; i < listseginfo.size(); i++) {
			strReturn += "<tr>";
			strReturn += "<td style='height:14px;line-height:14px;'>"
					+ listseginfo.get(i).getStartairport()
					+ listseginfo.get(i).getEndairport()
					+ "&nbsp;"
					+ listseginfo.get(i).getFlightnumber()
					+ "&nbsp;"
					+ listseginfo.get(i).getCabincode()
					+ "&nbsp;"
					+ ChangeDateMode(listseginfo.get(i).getDeparttime()
							.toString()) + "&nbsp;"
					+ formatTimestampHHmm(listseginfo.get(i).getDeparttime())
					+ "&nbsp;" + "</td>";
			strReturn += "</tr>";
		}
		strReturn += "</table></td>";
		strReturn += "<td width='76%' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += " <tr>";
		strReturn += "<td valign='top' align='left' width='50%'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		// 循环乘机人10个
		List<Passenger> listpassenger1 = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE C_ORDERID=" + strTuiOrderID + " AND "
								+ Passenger.COL_state + "<>12", "", -1, 0);
		if (listpassenger1.size() >= 10) {
			for (int j = 0; j < 10; j++) {
				strReturn += "<tr>";
				strReturn += "<td align='left' style='height:15px;line-height:15px;'>&nbsp;&nbsp;"
						+ listpassenger1.get(j).getTicketnum()
						+ "&nbsp;"
						+ SubString(listpassenger1.get(j).getName(), 6)
						+ "</td>";
				strReturn += "</tr>";
			}
		} else {
			for (int j = 0; j < listpassenger1.size(); j++) {
				strReturn += "<tr>";
				strReturn += "<td align='left' style='height:15px;line-height:15px;'>&nbsp;&nbsp;&nbsp;"
						+ listpassenger1.get(j).getTicketnum()
						+ "&nbsp;"
						+ SubString(listpassenger1.get(j).getName(), 6)
						+ "</td>";
				strReturn += "</tr>";
			}
			for (int j = 0; j < 10 - listpassenger1.size(); j++) {
				strReturn += "<tr>";
				strReturn += "<td align='left' style='height:15px;line-height:15px;'>&nbsp;&nbsp;&nbsp;"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
				strReturn += "</tr>";
			}
		}
		// 循环乘机人10个
		strReturn += " </table>";
		strReturn += "</td>";
		strReturn += "<td valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		// 循环乘机人10个
		if (listpassenger1.size() >= 10) {
			for (int j = 10; j < listpassenger1.size(); j++) {
				strReturn += "<tr>";
				strReturn += "<td style='height:15px;line-height:15px;'>"
						+ listpassenger1.get(j).getTicketnum() + "&nbsp;"
						+ SubString(listpassenger1.get(j).getName(), 6)
						+ "</td>";
				strReturn += "</tr>";
			}
		}
		// 循环乘机人10个
		strReturn += "</table></td>";
		strReturn += "</tr>";
		strReturn += "</table>";
		strReturn += "</td>";
		strReturn += "</tr>";
		strReturn += " </table></td></tr></table>";

		strReturn += "</td></tr>";
		String strfanjine = "0";
		if (orderinfo.getZhekoujine() != null && orderinfo.getZhekoujine() != 0) {
			strfanjine = converNull(orderinfo.getZhekoujine()
					* listpassenger1.size(), 0f)
					+ "";
		} else {

			try {
				strfanjine = orderinfo.getZhekoujine() * listpassenger1.size()
						+ "";
			} catch (Exception ex) {
				strfanjine = "0";
			}
		}
		strReturn += "<tr><td align='center' colspan='8'>Amt:"
				+ formatMoney(orderinfo.getTotalticketprice()
						+ orderinfo.getTotalairportfee()
						+ orderinfo.getTotalfuelfee()
						+ converNull(orderinfo.getTotalanjian(), 0f)
						+ converNull(orderinfo.getTotalotherfee(), 0f))
				+ "/返点"
				+ formatMoney_string(converNull(orderinfo
						.getFenxiaoshangfandian(), 0f)
						+ "") + "/返金额" + strfanjine + "/保险"
				+ getIssurByOrderid(orderinfo.getId())
				+ "元 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;等共：" + listpassenger1.size()
				+ "张 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收票人：</td></tr>";
		strReturn += "<tr><td height='10px'></td></tr>";
		strReturn += "</table></div>";
		strReturn += "<table id='tbbutton1' style='display:none' width='100%' valign='top' border='0'>";
		strReturn += "<tr><td colspan='8'><input class='button_d font-bai' value='打印' onclick='javascript:prn1_print();' type='button'>&nbsp;&nbsp;<input class='button_d font-bai' onclick='cancelprint();' value='取消' type='button'></td></tr>";
		strReturn += "</table>";

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	// 显示送票单信息
	public String sendticketinfo() throws Exception {
		String strReturn = "";
		String uuid = UUID.randomUUID().toString();
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		List<Segmentinfo> listseginfo = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + strTuiOrderID, "", -1,
						0);
		strReturn += "<html>";
		strReturn += "<body style='font-size:16px;line-height:9px;'>";
		strReturn += "<table border='0' width='1030' id='tbprint' style='margin:0 auto; margin-left:80px; border-collapse:collapse;border-spacing:0;'>";
		strReturn += "<tr>";
		strReturn += "<td colspan='7' style='font-size:28px; line-height:24px; text-align:center; font-weight:bold'>";
		strReturn += "东航国旅送票单</td>";
		String strTicketType = "";
		List<Passenger> listpassenger2 = Server
				.getInstance()
				.getAirService()
				.findAllPassenger("WHERE C_ORDERID=" + strTuiOrderID, "", -1, 0);
		if (listpassenger2.size() > 0) {
			String strtemp = listpassenger2.get(0).getTicketnum();
			try {
				if (strtemp.trim().length() >= 3) {
					List<Ticketnumber> ticketnumberlist = Server.getInstance()
							.getMemberService().findAllTicketnumber("", "", -1,
									0);
					for (int i = 0; i < ticketnumberlist.size(); i++) {
						if (ticketnumberlist.get(i).getBeginnumber().indexOf(
								strtemp.substring(0, 3)) >= 0) {
							strTicketType = getTickettypeById(
									ticketnumberlist.get(i).getTickettypeid())
									.getTypename()
									+ "";
							break;
						}
					}
				}
			} catch (Exception ex) {

			}
		}
		String strAddress = "";
		if (orderinfo.getAddresa() != null
				&& !orderinfo.getAddresa().equals("")) {
			strAddress = orderinfo.getAddresa();
		} else {
			strAddress = "无";
		}
		String strMemo = "";
		if (orderinfo.getMemo() != null && !orderinfo.getMemo().equals("")) {
			strMemo = orderinfo.getMemo();
		} else {
			strMemo = "无";
		}

		String strPayName = "";
		if (orderinfo.getPaymethod() == 4) {
			strPayName = "无卡支付";
		} else if (orderinfo.getPaymethod() == 1) {
			strPayName = "在线支付";
		} else if (orderinfo.getPaymethod() == 2) {
			strPayName = "门市付款";
		} else if (orderinfo.getPaymethod() == 3) {
			strPayName = "票到付款";
		} else if (orderinfo.getPaymethod() == 5) {
			strPayName = "客户挂账";
		} else if (orderinfo.getPaymethod() == 6) {
			strPayName = "柜台支付";
		}
		try {
			strTicketType = getTickettypeById(
					listpassenger2.get(0).getTickettypeid()).getTypename();
		} catch (Exception ex) {

		}
		strReturn += "<td width='15%' valign='bottom'><font size='2em'>"
				+ strTicketType + "</font></td></tr>";
		// strReturn+="<tr><td colspan='8' height='10px'></td></tr>";
		String strCompan = "无";
		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(orderinfo.getCustomeruserid());
		Customeragent customeragent = new Customeragent();
		try {
			customeragent = Server.getInstance().getMemberService()
					.findCustomeragent(customeruser.getAgentid());
		} catch (Exception ex) {

		}
		if (customeragent.getAgentshortname() != null) {
			strCompan = customeragent.getAgentshortname();
		}
		if (customeruser.getDeptid() != null && customeruser.getDeptid() != 0) {
			strCompan += "/" + getdepartmentNamebyId(customeruser.getDeptid());
		}
		String strcontactname = "无";
		String strcontacttel = "无";
		String strPnr = "";
		String strBigPnr = "";
		if (orderinfo.getContactname() != null
				&& !orderinfo.getContactname().equals("")) {
			strcontactname = orderinfo.getContactname();
		}
		// 如果联系人是散客，取散客的真实姓名
		if (orderinfo.getCustomeragentid() == 46) {
			if (orderinfo.getPostname() != null
					&& !orderinfo.getPostname().equals("")) {
				strcontactname = orderinfo.getPostname();
			}
		}
		if (orderinfo.getContacttel() != null
				&& !orderinfo.getContacttel().equals("")) {
			strcontacttel = orderinfo.getContacttel();
		}
		// 如果联系人是散客，收票人电话
		if (orderinfo.getCustomeragentid() == 46) {
			if (orderinfo.getPostmobile() != null
					&& !orderinfo.getPostmobile().equals("")) {
				strcontacttel = orderinfo.getPostmobile();
			}
		}
		if (orderinfo.getPnr() != null && !orderinfo.getPnr().equals("")) {
			strPnr = orderinfo.getPnr();
		} else if (orderinfo.getBigpnr() != null
				&& !orderinfo.getBigpnr().equals("")) {
			strPnr = orderinfo.getBigpnr();
		}
		strReturn += "<tr><td align='right'>Customer:</td><td align='left'>"
				+ strCompan + "</td>";
		strReturn += "<td align='left'>Contact:</td>";
		strReturn += "<td align='left' style='height:9px;line-height:9px;'>"
				+ strcontactname + "</td><td align='right'>No:</td>";
		strReturn += "<td align='left' style='height:9px;line-height:9px;'>"
				+ orderinfo.getOrdernumber() + "</td>";
		strReturn += "<td align='right' style='height:9px;line-height:9px;'>PNR:</td><td align='left' style='height:9px;line-height:9px;'>"
				+ strPnr + "</td></tr>";
		strReturn += "<tr><td  style='height:9px;line-height:50%;' align='right'>Tel:</td>";
		strReturn += "<td align='left'style='height:9px;line-height:50%;'>"
				+ strcontacttel + "</td>";
		strReturn += "<td align='right' style='height:9px;line-height:50%;'>Book:</td><td align='left' style='height:9px;line-height:50%;'>"
				+ getCustomerNameById(orderinfo.getSaleagentid()) + "</td>";
		strReturn += "<td align='right' style='height:9px;line-height:50%;'>Issue:</td><td align='left' style='height:9px;line-height:50%;'>"
				+ formatTimestamp(orderinfo.getPrinttime()) + "</td>";
		strReturn += "<td align='right' style='height:9px;line-height:50%;'>Payment:</td><td align='left' style=' ;height:9px;line-height:50%;'>"
				+ strPayName + "</td></tr>";
		strReturn += "<tr style='line-height:14px'><td align='right' style='height:9px;line-height:9px;'>Addr:</td><td align='left'>"
				+ strAddress + "</td>";
		strReturn += "<td align='right'></td><td align='left'></td><td align='right'>Memo:</td><td align='left'>"
				+ SubString(strMemo, 20) + "</td>";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		strReturn += "<td align='right' style='height:9px;line-height:9px;'>Print:</td><td align='left'>"
				+ dateFormat.format(new Timestamp(System.currentTimeMillis())
						.getTime()) + "</td></tr>";
		strReturn += "<tr><td colspan='8'><hr style='height:1px; width:100%'></td></tr>";

		strReturn += "<tr><td colspan='8'>";
		// 横线以下的数据
		strReturn += "<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td width='45%' valign='top' ><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td style='height:9px;line-height:9px;'>Line1:</td>";
		strReturn += "</tr>";
		for (int i = 0; i < listseginfo.size(); i++) {
			strReturn += "<tr>";
			strReturn += "<td width='2%'>&nbsp;</td><td style='height:9px;line-height:9px;'>"
					+ listseginfo.get(i).getStartairport()
					+ listseginfo.get(i).getEndairport()
					+ "&nbsp;"
					+ listseginfo.get(i).getFlightnumber()
					+ "&nbsp;"
					+ listseginfo.get(i).getCabincode()
					+ "&nbsp;"
					+ ChangeDateMode(listseginfo.get(i).getDeparttime()
							.toString())
					+ "&nbsp;"
					+ formatTimestampHHmm(listseginfo.get(i).getDeparttime())
					+ "&nbsp;" + "</td>";
			strReturn += "</tr>";
		}
		strReturn += "</table></td>";
		strReturn += "<td width='100%' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += " <tr>";
		strReturn += "<td valign='top' align='left' width='50%'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		// 循环乘机人10个
		List<Passenger> listpassenger1 = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE C_ORDERID=" + strTuiOrderID + " AND "
								+ Passenger.COL_state + "<>12", "", -1, 0);
		if (listpassenger1.size() >= 10) {
			for (int j = 0; j < 10; j++) {
				strReturn += "<tr>";
				strReturn += "<td align='left' style='height:9px;line-height:9px;'>&nbsp;&nbsp;"
						+ listpassenger1.get(j).getTicketnum()
						+ "&nbsp;"
						+ SubString(listpassenger1.get(j).getName(), 6)
						+ "</td>";
				strReturn += "</tr>";
			}
		} else {
			for (int j = 0; j < listpassenger1.size(); j++) {
				strReturn += "<tr>";
				strReturn += "<td align='left' style='height:9px;line-height:9px;'>&nbsp;&nbsp;&nbsp;"
						+ listpassenger1.get(j).getTicketnum()
						+ "&nbsp;"
						+ SubString(listpassenger1.get(j).getName(), 6)
						+ "</td>";
				strReturn += "</tr>";
			}
		}
		// 循环乘机人10个
		strReturn += " </table>";
		strReturn += "</td>";
		strReturn += "<td valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		// 循环乘机人10个
		if (listpassenger1.size() >= 10) {
			for (int j = 10; j < listpassenger1.size(); j++) {
				strReturn += "<tr>";
				strReturn += "<td style='height:9px;line-height:9px;'>"
						+ listpassenger1.get(j).getTicketnum() + "&nbsp;"
						+ SubString(listpassenger1.get(j).getName(), 6)
						+ "</td>";
				strReturn += "</tr>";
			}
		}
		// 循环乘机人10个
		strReturn += "</table></td>";
		strReturn += "</tr>";
		strReturn += "</table>";
		strReturn += "</td>";
		strReturn += "</tr>";
		strReturn += " </table></td></tr></table>";

		strReturn += "</td></tr>";

		strReturn += "<tr><td height='10px'></td></tr>";
		String strfanjine = "0";
		if (orderinfo.getZhekoujine() != null && orderinfo.getZhekoujine() != 0) {
			strfanjine = converNull(orderinfo.getZhekoujine()
					* listpassenger1.size(), 0f)
					+ "";
		} else {

			try {
				strfanjine = orderinfo.getZhekoujine() * listpassenger1.size()
						+ "";
			} catch (Exception ex) {
				strfanjine = "0";
			}
		}
		strReturn += "<tr><td align='center' colspan='8'>Amt:"
				+ formatMoney(orderinfo.getTotalticketprice()
						+ orderinfo.getTotalairportfee()
						+ orderinfo.getTotalfuelfee()
						+ converNull(orderinfo.getTotalanjian(), 0f)
						+ converNull(orderinfo.getTotalotherfee(), 0f))
				+ "/返点"
				+ formatMoney_string(converNull(orderinfo
						.getFenxiaoshangfandian(), 0f)
						+ "") + "/返金额" + strfanjine + "/保险"
				+ getIssurByOrderid(orderinfo.getId())
				+ "元  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;等共："
				+ listpassenger1.size()
				+ "张 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收票人：</td></tr>";
		strReturn += "<tr><td height='10px'></td></tr>";
		strReturn += "</table></body></html><br />";
		// 生成图片信息
		// GraphUtils.createImagebyhtml(strReturn, uuid);
		strReturn += "<table border='0' width='80%'><tr><td colspan='8' align='center'><input class='button_d font-bai' value='打印' onclick='javascript:prn1_print();' type='button'>&nbsp;&nbsp;<input class='button_d font-bai' onclick='javascript:history.go(-1);' value='取消' type='button'></td></tr>";
		return "sendticketinfo";
	}

	/**
	 * 判断是否为大客户订单
	 * 
	 * @param order
	 * @return
	 */
	private List<Customeragent> agentlist = new ArrayList<Customeragent>();

	private boolean isBiguserOrder(Orderinfo order) {
		Customeragent customeragtent = Server.getInstance().getMemberService()
				.findCustomeragent(order.getCustomeragentid());
		if (customeragtent.getBigtype() != null
				&& customeragtent.getBigtype() == 1l) {
			return true;
		}
		return false;
	}

	// 得到配送信息
	public void getPeisong() throws Exception {
		String strReturn = "";

		strReturn += "<table id='tbpeisonginfo' class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tr><td colspan='6' align='left'><b>航程信息</b></td></tr>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td colspan='2'>出发城市-到达城市</td>" + "<td>航班号</td>"
				+ "<td>舱位码</td>" + "<td colspan='2'>起飞时间</td><td></td>";
		strReturn += "</tr>";

		List<Segmentinfo> listseginfo = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + strTuiOrderID, "", -1,
						0);
		for (int i = 0; i < listseginfo.size(); i++) {
			strReturn += "<tr>";
			strReturn += "<td colspan='2'>"
					+ listseginfo.get(i).getStartairport() + "-"
					+ listseginfo.get(i).getEndairport() + "</td>";
			strReturn += "<td>" + listseginfo.get(i).getFlightnumber()
					+ "</td>";
			strReturn += "<td>" + listseginfo.get(i).getCabincode() + "</td>";
			strReturn += "<td colspan='2'>"
					+ formatTimestamp(listseginfo.get(i).getDeparttime())
					+ "</td>";
			strReturn += "</tr>";
		}
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(orderinfo.getCustomeruserid());
		Customeragent customeragent = new Customeragent();
		try {
			customeragent = Server.getInstance().getMemberService()
					.findCustomeragent(customeruser.getAgentid());
			strReturn += "<tr><td colspan='6' align='left'><b>订单配送信息</b></td></tr>";
			strReturn += "<tr>";
			strReturn += "<td align='right' class='table_color_r colortrin'>集团客户名称：</td>";
			String agentname = "";
			String strContactName = "";
			String strContactTel = "";
			if (orderinfo.getCustomeragentid() == 46l) {
				agentname = "散客";
				strContactName = converNull(orderinfo.getPostname(), "无");
				strContactTel = converNull(orderinfo.getPostmobile(), "无");
			} else {
				agentname = converNull(customeragent.getAgentshortname(), "");
				strContactName = converNull(orderinfo.getContactname(), "无");
				strContactTel = converNull(orderinfo.getContactmobile(), "无");
			}
			strReturn += "<td align='left'>" + agentname + "</td>";
			strReturn += "<td align='right' class='table_color_r colortrin'>联系人：</td>";
			strReturn += "<td align='left'>" + strContactName + "</td>";
			strReturn += "<td align='right' class='table_color_r colortrin'>联系电话：</td>";
			strReturn += "<td align='left'>" + strContactTel + "</td></tr>";
		} catch (Exception ex) {

		}
		String strAddress = "";
		if (orderinfo.getAddresa() != null
				&& !orderinfo.getAddresa().equals("")) {
			strAddress = orderinfo.getAddresa();
		} else {
			strAddress = "无";
		}
		String strMemo = "";
		if (orderinfo.getMemo() != null && !orderinfo.getMemo().equals("")) {
			strMemo = orderinfo.getMemo();
		} else {
			strMemo = "无";
		}
		strReturn += "<tr><td align='right' class='table_color_r colortrin'>配送地址：</td><td align='left' colspan='5'>"
				+ strAddress + "</td></tr>";
		strReturn += "<tr><td align='right' class='table_color_r colortrin'>备注信息：</td><td align='left' colspan='5' valign='top'>";
		strReturn += "" + strMemo + "</td></tr>";
		String strPayName = "";
		if (orderinfo.getPaymethod() == 4) {
			strPayName = "无卡支付";
		} else if (orderinfo.getPaymethod() == 1) {
			strPayName = "在线支付";
		} else if (orderinfo.getPaymethod() == 2) {
			strPayName = "门市付款";
		} else if (orderinfo.getPaymethod() == 3) {
			strPayName = "票到付款";
		} else if (orderinfo.getPaymethod() == 5) {
			strPayName = "客户挂账";
		} else if (orderinfo.getPaymethod() == 6) {
			strPayName = "柜台支付";
		}
		strReturn += "<tr><td align='right' class='table_color_r colortrin'>支付方式：</td><td align='left'>"
				+ strPayName + "</td>";
		strReturn += "<td align='right' class='table_color_r colortrin'>出票时间：</td>";
		strReturn += "<td align='left'>2010-10-01 12:30</td>";
		String strPNR = "";
		if (orderinfo.getPnr() != null && !orderinfo.getPnr().equals("")) {
			strPNR = orderinfo.getPnr() + "(小)";
		}
		if (orderinfo.getBigpnr() != null && !orderinfo.getBigpnr().equals("")) {
			strPNR += "&nbsp;&nbsp;" + orderinfo.getBigpnr() + "(大)";
		}
		strReturn += "<td align='right' class='table_color_r colortrin'>记录编码：</td><td align='left'>"
				+ strPNR + "</td></tr>";
		strReturn += "<tr><td align='right' class='table_color_r colortrin'>送票员：</td>";
		strReturn += "<td align='left'>";

		String where = "SELECT a.C_CUSTOMERUSERID as id, (select C_MEMBERNAME from T_CUSTOMERUSER b where  a.C_CUSTOMERUSERID=b.ID) as name FROM         T_AGENTROLEREF a  where C_ROLEID=10046";
		List listdeptsale = Server.getInstance().getSystemService()
				.findMapResultBySql(where, null);

		strReturn += "<select id='ddlsender'>";
		strReturn += "<option value='0'></option>";
		for (int i = 0; i < listdeptsale.size(); i++) {
			Map mapcustomer = (Map) listdeptsale.get(i);

			strReturn += "<option value='" + mapcustomer.get("id") + "'>"
					+ mapcustomer.get("name") + "</option>";
		}
		strReturn += "</select></td>";
		Timestamp tsdatenow = new Timestamp(System.currentTimeMillis());
		strReturn += "<td colspan='2' align='left'><font color='#FF0000'>请选择配送员</font></td><td align='right' class='table_color_r colortrin'>配送日期：</td><td align='left'><input class='Wdate' type='text' value='"
				+ formatTimestamp2(tsdatenow)
				+ "' name='peisongdate' onFocus=\"WdatePicker({startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'%y-%M-%d',alwaysUseStartDate:true})\" id='txtsendtime' /></td></tr>";
		strReturn += "</table><br />";
		List<Passenger> listpassenger2 = Server
				.getInstance()
				.getAirService()
				.findAllPassenger("WHERE C_ORDERID=" + strTuiOrderID, "", -1, 0);
		// 判断含有几个乘机人，如果含有多个乘机人，添加分离打印功能
		String strFenliBtn = "";
		String strPassIDs = "";
		if (listpassenger2.size() > 1) {
			for (int i = 0; i < listpassenger2.size(); i++) {
				strPassIDs += listpassenger2.get(i).getId() + "|";
			}
			strFenliBtn = "&nbsp;&nbsp;<input class='button_d font-bai' onclick='fenlidayin(\""
					+ strTuiOrderID
					+ "\",\""
					+ strPassIDs
					+ "\");' value='分离打印' type='button'>";
		}
		strReturn += "<span id='span_peisong' style='margin-top:10px'><input class='button_d font-bai' onclick='sendticket("
				+ strTuiOrderID
				+ ");' value='配送' type='button'>&nbsp;&nbsp;<input class='button_d font-bai' onclick='javascript:printChange("
				+ orderinfo.getId()
				+ ");prn1_print();' value='打印送票单' type='button'>&nbsp;&nbsp;<input class='button_d font-bai' onclick='javascript:prn1_preview();' value='预览送票单' type='button'>"
				+ strFenliBtn + "</span>";

		strReturn += "<div id='tbpreivew'><table border='0' width='100%' id='tbprint' style='font-size:16px;display:none;margin:0 auto;border-collapse:collapse;border-spacing:0;line-height:30px'>";
		strReturn += "<tr>";
		strReturn += "<td colspan='7' style='font-size:24px; text-align:center; font-weight:bold'>";
		strReturn += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size='5em'>东航国旅送票单</font></td>";
		String strTicketType = "";

		if (listpassenger2.size() > 0) {
			String strtemp = listpassenger2.get(0).getTicketnum();
			try {
				if (strtemp.trim().length() >= 3) {
					List<Ticketnumber> ticketnumberlist = Server.getInstance()
							.getMemberService().findAllTicketnumber("", "", -1,
									0);
					for (int i = 0; i < ticketnumberlist.size(); i++) {
						if (ticketnumberlist.get(i).getBeginnumber().indexOf(
								strtemp.substring(0, 3)) >= 0) {
							strTicketType = getTickettypeById(
									ticketnumberlist.get(i).getTickettypeid())
									.getTypename()
									+ "";
							break;
						}
					}
				}
			} catch (Exception ex) {

			}
		}
		try {
			strTicketType = getTickettypeById(
					listpassenger2.get(0).getTickettypeid()).getTypename();
		} catch (Exception ex) {

		}
		strReturn += "<td width='10%' valign='bottom'>" + strTicketType
				+ "</td></tr>";
		// strReturn+="<tr><td colspan='8' height='10px'></td></tr>";
		String strCompan = "无";
		if (customeragent.getAgentshortname() != null) {
			strCompan = customeragent.getAgentshortname();
		}
		if (customeruser.getDeptid() != null && customeruser.getDeptid() != 0) {
			strCompan += "/" + getdepartmentNamebyId(customeruser.getDeptid());
		}
		String strcontactname = "无";
		String strcontacttel = "无";
		String strPnr = "";
		String strBigPnr = "";
		if (orderinfo.getContactname() != null
				&& !orderinfo.getContactname().equals("")) {
			strcontactname = orderinfo.getContactname();
		}
		// 如果联系人是散客，取散客的真实姓名
		if (orderinfo.getCustomeragentid() == 46) {
			if (orderinfo.getPostname() != null
					&& !orderinfo.getPostname().equals("")) {
				strcontactname = orderinfo.getPostname();
			}
		}
		if (orderinfo.getContacttel() != null
				&& !orderinfo.getContacttel().equals("")) {
			strcontacttel = orderinfo.getContacttel();
		}
		// 如果联系人是散客，收票人电话
		if (orderinfo.getCustomeragentid() == 46) {
			if (orderinfo.getPostmobile() != null
					&& !orderinfo.getPostmobile().equals("")) {
				strcontacttel = orderinfo.getPostmobile();
			}
		}
		if (orderinfo.getPnr() != null && !orderinfo.getPnr().equals("")) {
			strPnr = orderinfo.getPnr();
		} else if (orderinfo.getBigpnr() != null
				&& !orderinfo.getBigpnr().equals("")) {
			strPnr = orderinfo.getBigpnr();
		}
		strReturn += "<tr style='line-height:15px'><td align='right'>Customer:</td><td align='left'>"
				+ strCompan + "</font></td>";
		strReturn += "<td align='right'>Contact:</td>";
		strReturn += "<td align='left' style='height:15px;line-height:15px;'>"
				+ strcontactname + "</td><td align='right'>No:</font></td>";
		strReturn += "<td align='left' style='height:15px;line-height:15px;'>"
				+ orderinfo.getOrdernumber() + "</td>";
		strReturn += "<td align='right' style='height:15px;line-height:15px;'>PNR:</font></td><td align='left' style='height:15px;line-height:15px;'>"
				+ strPnr + "</td></tr>";
		strReturn += "<tr style=''><td  style='height:15px;line-height:15px;' align='right'>Tel:</td>";
		strReturn += "<td align='left'style='height:15px;line-height:15px;'>"
				+ strcontacttel + "</td>";
		strReturn += "<td align='right' style='height:10px;line-height:10px;'>Book:</td><td align='left' style='height:10px;line-height:10px;'>"
				+ getCustomerNameById(orderinfo.getSaleagentid()) + "</td>";
		strReturn += "<td align='right' style='height:10px;line-height:10px;'>Issue:</td><td align='left' style='height:10px;line-height:10px;'>"
				+ formatTimestamp(orderinfo.getPrinttime()) + "</td>";
		strReturn += "<td align='right' style='height:10px;line-height:10px;'><font >Payment:</font></td><td align='left' style='height:10px;line-height:10px;'><font >"
				+ strPayName + "</font></td></tr>";
		strReturn += "<tr style='line-height:14px'><td align='right' style='height:10px;line-height:10px;'>Addr:</td><td align='left'>"
				+ strAddress + "</font></td>";
		strReturn += "<td align='right'></td><td align='left'></td><td align='right'>Memo:</td><td align='left'>"
				+ SubString(strMemo, 20) + "</td>";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		strReturn += "<td align='right' style='height:10px;line-height:10px;'>Print:</td><td align='left' width='10%'>"
				+ dateFormat.format(new Timestamp(System.currentTimeMillis())
						.getTime()) + "</td></tr>";
		strReturn += "<tr><td colspan='8'><hr size='1px' style='height:1px; width:100%'></td></tr>";

		strReturn += "<tr><td colspan='8'>";
		// 横线以下的数据
		strReturn += "<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td width='40%'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td width='5%' valign='top' ><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td style='height:10px;line-height:10px;'>Line1:</td>";
		strReturn += "</tr>";
		strReturn += "</table>";
		strReturn += "</td>";
		strReturn += "<td width='30%' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td>&nbsp;</td>";
		strReturn += "</tr>";
		for (int i = 0; i < listseginfo.size(); i++) {
			String strDeptTime = "";
			if (listseginfo.get(i).getDeparttime() != null
					&& !listseginfo.get(i).getDeparttime().toString()
							.equals("")) {
				strDeptTime = ChangeDateMode(listseginfo.get(i).getDeparttime()
						.toString());
			}
			strReturn += "<tr>";
			strReturn += "<td style='height:15px;line-height:15px;'>"
					+ listseginfo.get(i).getStartairport()
					+ listseginfo.get(i).getEndairport() + "&nbsp;"
					+ listseginfo.get(i).getFlightnumber() + "&nbsp;"
					+ listseginfo.get(i).getCabincode() + "&nbsp;"
					+ strDeptTime + "&nbsp;"
					+ formatTimestampHHmm(listseginfo.get(i).getDeparttime())
					+ "&nbsp;" + "</td>";
			strReturn += "</tr>";
		}
		strReturn += "</table></td>";
		strReturn += "<td width='100%' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += " <tr>";
		strReturn += "<td valign='top' align='left' width='50%'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		// 循环乘机人10个
		List<Passenger> listpassenger1 = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE C_ORDERID=" + strTuiOrderID + " AND "
								+ Passenger.COL_state + "<>12", "", -1, 0);
		if (listpassenger1.size() >= 10) {
			for (int j = 0; j < 10; j++) {
				strReturn += "<tr>";
				strReturn += "<td align='left' style='height:15px;line-height:15px;'>&nbsp;&nbsp;"
						+ listpassenger1.get(j).getTicketnum()
						+ "&nbsp;"
						+ SubString(listpassenger1.get(j).getName(), 6)
						+ "</td>";
				strReturn += "</tr>";
			}
		} else {
			for (int j = 0; j < listpassenger1.size(); j++) {
				strReturn += "<tr>";
				strReturn += "<td align='left' style='height:15px;line-height:15px;'>&nbsp;&nbsp;&nbsp;"
						+ listpassenger1.get(j).getTicketnum()
						+ "&nbsp;"
						+ SubString(listpassenger1.get(j).getName(), 6)
						+ "</td>";
				strReturn += "</tr>";
			}
			for (int j = 0; j < 10 - listpassenger1.size(); j++) {
				strReturn += "<tr>";
				strReturn += "<td align='left' style='height:15px;line-height:15px;'>&nbsp;&nbsp;&nbsp;"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
				strReturn += "</tr>";
			}

		}
		// 循环乘机人10个
		strReturn += " </table>";
		strReturn += "</td>";
		strReturn += "<td valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		// 循环乘机人10个
		if (listpassenger1.size() >= 10) {
			for (int j = 10; j < listpassenger1.size(); j++) {
				strReturn += "<tr>";
				strReturn += "<td style='height:15px;line-height:15px;'>"
						+ listpassenger1.get(j).getTicketnum() + "&nbsp;"
						+ SubString(listpassenger1.get(j).getName(), 6)
						+ "</td>";
				strReturn += "</tr>";
			}
		}
		// 循环乘机人10个
		strReturn += "</table></td>";
		strReturn += "</tr>";
		strReturn += "</table>";
		strReturn += "</td>";
		strReturn += "</tr>";
		strReturn += " </table></td></tr></table>";

		strReturn += "</td></tr>";

		strReturn += "<tr><td height='2px'></td></tr>";
		String strfanjine = "0";
		if (orderinfo.getZhekoujine() != null && orderinfo.getZhekoujine() != 0) {
			strfanjine = converNull(orderinfo.getZhekoujine()
					* listpassenger1.size(), 0f)
					+ "";
		} else {

			try {
				strfanjine = orderinfo.getZhekoujine() * listpassenger1.size()
						+ "";
			} catch (Exception ex) {
				strfanjine = "0";
			}
		}
		strReturn += "<tr><td align='center' colspan='8'>Amt:"
				+ formatMoney(orderinfo.getTotalticketprice()
						+ orderinfo.getTotalairportfee()
						+ orderinfo.getTotalfuelfee()
						+ converNull(orderinfo.getTotalanjian(), 0f)
						+ converNull(orderinfo.getTotalotherfee(), 0f))
				+ "/返点"
				+ formatMoney_string(converNull(orderinfo
						.getFenxiaoshangfandian(), 0f)
						+ "") + "/返金额" + strfanjine + "/保险"
				+ getIssurByOrderid(orderinfo.getId())
				+ "元  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;等共："
				+ listpassenger1.size()
				+ "张 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收票人：</td></tr>";
		strReturn += "</table></div>";
		strReturn += "<table id='tbbutton' style='display:none' width='100%' valign='top' border='0'>";
		strReturn += "<tr id='trbutton1'><td colspan='8'><input class='button_d font-bai' value='打印' onclick='javascript:prn1_print();' type='button'>&nbsp;&nbsp;<input class='button_d font-bai' onclick='cancelprint();' value='取消' type='button'></td></tr>";
		strReturn += "</table>";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	/**
	 * 批量打印
	 * 
	 * @throws Exception
	 */
	public void piliangdayin() throws Exception {
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		// 更改为已打印
		String sql = "UPDATE T_ORDERINFO SET C_ISPRINT=1 WHERE ID="
				+ strTuiOrderID;
		Server.getInstance().getSystemService().findMapResultBySql(sql, null);
		String strCompan = "无";
		try {
			Customeruser customeruser = Server.getInstance().getMemberService()
					.findCustomeruser(orderinfo.getCustomeruserid());
			Customeragent customeragent = new Customeragent();
			customeragent = Server.getInstance().getMemberService()
					.findCustomeragent(customeruser.getAgentid());
			if (customeragent.getAgentshortname() != null) {
				strCompan = customeragent.getAgentshortname();
			}
			if (customeruser.getDeptid() != null
					&& customeruser.getDeptid() != 0) {
				strCompan += "/"
						+ getdepartmentNamebyId(customeruser.getDeptid());
			}
		} catch (Exception ex) {
		}
		List<Segmentinfo> listseginfo = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + strTuiOrderID, "", -1,
						0);

		strReturn += "<table border='0' width='100%' style='font-size:16px;margin:0 auto;border-collapse:collapse;border-spacing:0;line-height:30px'>";
		strReturn += "<tr>";
		strReturn += "<td colspan='7' style='font-size:24px; text-align:center; font-weight:bold'>";
		strReturn += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size='5em'>东航国旅送票单</font></td>";
		String strTicketType = "";
		List<Passenger> listpassenger2 = Server
				.getInstance()
				.getAirService()
				.findAllPassenger("WHERE C_ORDERID=" + strTuiOrderID, "", -1, 0);
		if (listpassenger2.size() > 0) {
			String strtemp = listpassenger2.get(0).getTicketnum();
			try {
				if (strtemp.trim().length() >= 3) {
					List<Ticketnumber> ticketnumberlist = Server.getInstance()
							.getMemberService().findAllTicketnumber("", "", -1,
									0);
					for (int i = 0; i < ticketnumberlist.size(); i++) {
						if (ticketnumberlist.get(i).getBeginnumber().indexOf(
								strtemp.substring(0, 3)) >= 0) {
							strTicketType = getTickettypeById(
									ticketnumberlist.get(i).getTickettypeid())
									.getTypename()
									+ "";
							break;
						}
					}
				}
			} catch (Exception ex) {
			}
		}
		try {
			strTicketType = getTickettypeById(
					listpassenger2.get(0).getTickettypeid()).getTypename();
		} catch (Exception ex) {

		}
		strReturn += "<td width='10%' valign='bottom'>" + strTicketType
				+ "</td></tr>";
		// strReturn+="<tr><td colspan='8' height='10px'></td></tr>";

		String strcontactname = "无";
		String strcontacttel = "无";
		String strPnr = "";
		String strBigPnr = "";
		if (orderinfo.getContactname() != null
				&& !orderinfo.getContactname().equals("")) {
			strcontactname = orderinfo.getContactname();
		}
		// 如果联系人是散客，取散客的真实姓名
		if (orderinfo.getCustomeragentid() == 46) {
			if (orderinfo.getPostname() != null
					&& !orderinfo.getPostname().equals("")) {
				strcontactname = orderinfo.getPostname();
			}
		}
		if (orderinfo.getContacttel() != null
				&& !orderinfo.getContacttel().equals("")) {
			strcontacttel = orderinfo.getContacttel();
		}
		// 如果联系人是散客，收票人电话
		if (orderinfo.getCustomeragentid() == 46) {
			if (orderinfo.getPostmobile() != null
					&& !orderinfo.getPostmobile().equals("")) {
				strcontacttel = orderinfo.getPostmobile();
			}
		}
		if (orderinfo.getPnr() != null && !orderinfo.getPnr().equals("")) {
			strPnr = orderinfo.getPnr();
		} else if (orderinfo.getBigpnr() != null
				&& !orderinfo.getBigpnr().equals("")) {
			strPnr = orderinfo.getBigpnr();
		}
		String strPayName = getPayMethodStr(orderinfo.getPaymethod());

		String strAddress = "";
		if (orderinfo.getAddresa() != null
				&& !orderinfo.getAddresa().equals("")) {
			strAddress = orderinfo.getAddresa();
		} else {
			strAddress = "无";
		}
		String strMemo = "";
		if (orderinfo.getMemo() != null && !orderinfo.getMemo().equals("")) {
			strMemo = orderinfo.getMemo();
		} else {
			strMemo = "无";
		}
		strReturn += "<tr style='line-height:15px'><td align='right'>Customer:</td><td align='left'>"
				+ strCompan + "</font></td>";
		strReturn += "<td align='right'>Contact:</td>";
		strReturn += "<td align='left' style='height:15px;line-height:15px;'>"
				+ strcontactname + "</td><td align='right'>No:</font></td>";
		strReturn += "<td align='left' style='height:15px;line-height:15px;'>"
				+ orderinfo.getOrdernumber() + "</td>";
		strReturn += "<td align='right' style='height:15px;line-height:15px;'>PNR:</font></td><td align='left' style='height:15px;line-height:15px;'>"
				+ strPnr + "</td></tr>";
		strReturn += "<tr style=''><td  style='height:15px;line-height:15px;' align='right'>Tel:</td>";
		strReturn += "<td align='left'style='height:15px;line-height:15px;'>"
				+ strcontacttel + "</td>";
		strReturn += "<td align='right' style='height:10px;line-height:10px;'>Book:</td><td align='left' style='height:10px;line-height:10px;'>"
				+ getCustomerNameById(orderinfo.getSaleagentid()) + "</td>";
		strReturn += "<td align='right' style='height:10px;line-height:10px;'>Issue:</td><td align='left' style='height:10px;line-height:10px;'>"
				+ formatTimestamp(orderinfo.getPrinttime()) + "</td>";
		strReturn += "<td align='right' style='height:10px;line-height:10px;'><font >Payment:</font></td><td align='left' style='height:10px;line-height:10px;'><font >"
				+ strPayName + "</font></td></tr>";
		strReturn += "<tr style='line-height:14px'><td align='right' style='height:10px;line-height:10px;'>Addr:</td><td align='left'>"
				+ strAddress + "</font></td>";
		strReturn += "<td align='right'></td><td align='left'></td><td align='right'>Memo:</td><td align='left'>"
				+ SubString(strMemo, 20) + "</td>";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		strReturn += "<td align='right' style='height:10px;line-height:10px;'>Print:</td><td align='left' width='10%'>"
				+ dateFormat.format(new Timestamp(System.currentTimeMillis())
						.getTime()) + "</td></tr>";
		strReturn += "<tr><td colspan='8'><hr size='1px' style='height:1px; width:100%'></td></tr>";

		strReturn += "<tr><td colspan='8'>";
		// 横线以下的数据
		strReturn += "<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td width='40%'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td width='5%' valign='top' ><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td style='height:10px;line-height:10px;'>Line1:</td>";
		strReturn += "</tr>";
		strReturn += "</table>";
		strReturn += "</td>";
		strReturn += "<td width='24%' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += "<tr>";
		strReturn += "<td>&nbsp;</td>";
		strReturn += "</tr>";
		for (int i = 0; i < listseginfo.size(); i++) {
			strReturn += "<tr>";
			strReturn += "<td style='height:15px;line-height:15px;'>"
					+ listseginfo.get(i).getStartairport()
					+ listseginfo.get(i).getEndairport()
					+ "&nbsp;"
					+ listseginfo.get(i).getFlightnumber()
					+ "&nbsp;"
					+ listseginfo.get(i).getCabincode()
					+ "&nbsp;"
					+ ChangeDateMode(listseginfo.get(i).getDeparttime()
							.toString()) + "&nbsp;"
					+ formatTimestampHHmm(listseginfo.get(i).getDeparttime())
					+ "&nbsp;" + "</td>";
			strReturn += "</tr>";
		}
		strReturn += "</table></td>";
		strReturn += "<td width='76%' valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		strReturn += " <tr>";
		strReturn += "<td valign='top' align='left' width='50%'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		// 循环乘机人10个
		List<Passenger> listpassengernew = new ArrayList<Passenger>();

		String strpwhere = "WHERE C_ORDERID=" + strTuiOrderID;
		String strAmt = "";
		if (s_songpaiodanpid != null && !s_songpaiodanpid.equals("")) {
			strpwhere += " and " + Passenger.COL_id + "=" + s_songpaiodanpid;
			listpassengernew = Server.getInstance().getAirService()
					.findAllPassenger(
							"WHERE C_ORDERID=" + strTuiOrderID + " AND "
									+ Passenger.COL_state + "<>12", "", -1, 0);
		}
		List<Passenger> listpassenger1 = Server.getInstance().getAirService()
				.findAllPassenger(strpwhere, "", -1, 0);
		if (listpassenger1.size() >= 10) {
			for (int j = 0; j < 10; j++) {
				strReturn += "<tr>";
				strReturn += "<td align='left' style='height:15px;line-height:15px;'>&nbsp;&nbsp;"
						+ listpassenger1.get(j).getTicketnum()
						+ " "
						+ SubString(listpassenger1.get(j).getName(), 6)
						+ "</td>";
				strReturn += "</tr>";

			}
		} else {
			for (int j = 0; j < listpassenger1.size(); j++) {
				strReturn += "<tr>";
				strReturn += "<td align='left' style='height:15px;line-height:15px;'>&nbsp;&nbsp;&nbsp;"
						+ listpassenger1.get(j).getTicketnum()
						+ " "
						+ SubString(listpassenger1.get(j).getName(), 6)
						+ "</td>";
				strReturn += "</tr>";
				// 计算总机票款
				strAmt = listpassenger1.get(j).getPrice()
						+ listpassenger1.get(j).getFuelprice()

						+ listpassenger1.get(j).getAirportfee()
						+ converNull(listpassenger1.get(j).getAnjianfee(), 0f)
						+ converNull(listpassenger1.get(j).getOtherfee(), 0f)
						+ "";

			}
			for (int j = 0; j < 10 - listpassenger1.size(); j++) {
				strReturn += "<tr>";
				strReturn += "<td align='left' style='height:15px;line-height:15px;'>&nbsp;&nbsp;&nbsp;"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;" + "</td>";
				strReturn += "</tr>";
			}

		}
		// 循环乘机人10个
		strReturn += " </table>";
		strReturn += "</td>";
		strReturn += "<td valign='top'><table width='100%' border='0' cellspacing='0' cellpadding='0'>";
		// 循环乘机人10个
		if (listpassenger1.size() >= 10) {
			for (int j = 10; j < listpassenger1.size(); j++) {
				strReturn += "<tr>";
				strReturn += "<td style='height:15px;line-height:15px;'>"
						+ listpassenger1.get(j).getTicketnum() + " "
						+ SubString(listpassenger1.get(j).getName(), 6)
						+ "</td>";
				strReturn += "</tr>";

			}
		}
		// 循环乘机人10个
		strReturn += "</table></td>";
		strReturn += "</tr>";
		strReturn += "</table>";
		strReturn += "</td>";
		strReturn += "</tr>";
		strReturn += " </table></td></tr></table>";

		strReturn += "</td></tr>";

		strReturn += "<tr><td height='2px'></td></tr>";
		String strfanjine = "0";
		if (orderinfo.getZhekoujine() != null && orderinfo.getZhekoujine() != 0) {
			strfanjine = converNull(orderinfo.getZhekoujine()
					* listpassenger1.size(), 0f)
					+ "";
		} else {

			try {
				strfanjine = orderinfo.getZhekoujine() * listpassenger1.size()
						+ "";
			} catch (Exception ex) {
				strfanjine = "0";
			}
		}
		if (s_songpaiodanpid != null && !s_songpaiodanpid.equals("")) {
			strReturn += "<tr><td align='center' colspan='8'>Amt:"
					+ strAmt
					+ "/返点"
					+ formatMoney_string(converNull(orderinfo
							.getFenxiaoshangfandian(), 0f)
							+ "")
					+ "/返金额"
					+ strfanjine
					+ "/保险"
					+ getIssurByOrderid(orderinfo.getId())
					+ "元  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;等共："
					+ s_Paindex
					+ "/"
					+ listpassengernew.size()
					+ "张 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收票人：</td></tr>";
		} else {
			strReturn += "<tr><td align='center' colspan='8'>Amt:"
					+ formatMoney(orderinfo.getTotalticketprice()
							+ orderinfo.getTotalairportfee()
							+ orderinfo.getTotalfuelfee()
							+ converNull(orderinfo.getTotalanjian(), 0f)
							+ converNull(orderinfo.getTotalotherfee(), 0f))
					+ "/返点"
					+ formatMoney_string(converNull(orderinfo
							.getFenxiaoshangfandian(), 0f)
							+ "")
					+ "/返金额"
					+ strfanjine
					+ "/保险"
					+ getIssurByOrderid(orderinfo.getId())
					+ "元 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;等共："
					+ listpassenger1.size()
					+ "张 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收票人：</td></tr>";
		}

		strReturn += "</table>";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	public String getPassengerNamehtml(Long orderid) {
		String html = "";
		List<Passenger> list = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE 1=1 AND " + Passenger.COL_state + "<>12 AND "
								+ Passenger.COL_orderid + "=" + orderid, "",
						-1, 0);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size() - 1; i++) {
				html += list.get(i).getName() + "<br/>";
			}
			html += list.get(list.size() - 1).getName();
		}
		return html;
	}

	// 配送订单
	public void dealsendticket() throws Exception {
		String strReturn = "";
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		orderinfo.setPeisongrenid(Long.parseLong(strSenderID));
		orderinfo.setPeisongdate(dateToTimestamp(strSenderDate));
		orderinfo.setPeisongstatus(1l); // 0未配送，1配送中，2已配送
		orderinfo.setOrderstatus(28); // 在途订单
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		strReturn = "配送成功！";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	// 得到退费信息查看
	public void getViewTuifei() throws Exception {
		String strReturn = "";
		String strTuipiaofei = "";
		if (typ == 1) {
			strReturn += "<span style='color:red' align='left'>请选择审核通过废票的乘机人！</span>";
			strTuipiaofei = "废票手续费";
		}
		if (typ == 2) {
			strReturn += "<span style='color:red' align='left'>请选择审核通过退票的乘机人！</span>";
			strTuipiaofei = "退票费";
		}
		if (typ == 3) {
			strReturn += "<span style='color:red' align='left'>请选择审核通过改签的乘机人！</span>";
			strTuipiaofei = "改签费用";
		}
		if (typ == 4) {
			strReturn += "<span style='color:red' align='left'>查看乘机人退废信息</span>";
			strTuipiaofei = "退/废费用";
		}
		if (typ == 6 || typ == 7) {
			strReturn += "<span style='color:red' align='left'>查看乘机人退废信息</span>";
			strTuipiaofei = "退/废费用";

		}
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tbody>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td>机票类型</td><td>乘客类型</td><td>乘客姓名</td><td>证件类型</td><td>证件号码</td><td>票号</td><td>票价</td><td>燃油</td><td>机建</td><td>安检</td><td>其它</td><td>"
				+ strTuipiaofei + "</td>";
		strReturn += "</tr>";
		String where = "WHERE C_ORDERID=" + strTuiOrderID;
		if (typ == 1) {
			where += " and " + Passenger.COL_state + " =5";
		}
		if (typ == 2) {
			where += " and " + Passenger.COL_state + " =4";
		}
		if (typ == 3) {
			where += " and " + Passenger.COL_state + " =6";
		}

		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		float totaltuifee = 0f;
		for (int i = 0; i < listpassenger.size(); i++) {
			strReturn += "<tr>";
			// strReturn+="<td align='center'><input type='hidden'
			// id='txtpassid_"+i+"' value='"+listpassenger.get(i).getId()+"'
			// /><input type='checkbox' checked='checked'
			// id='chkpassenger_"+i+"'></td>";
			if (i == 0) {
				strReturn += "<td rowspan=\""
						+ listpassenger.size()
						+ "\">"
						+ this.getTickettypeById(
								converNull(listpassenger.get(i)
										.getTickettypeid(), 0l)).getTypename()
						+ "</td>";
			}
			strReturn += "<td>"
					+ getPassTypeToString(listpassenger.get(i).getPtype())
					+ "</td>";
			strReturn += "<td>" + listpassenger.get(i).getName() + "</td>";
			strReturn += "<td>"
					+ getIDTypeToString(listpassenger.get(i).getIdtype())
					+ "</td>";
			strReturn += "<td><span id='gdvTic_ctl02_lbtnzj'>"
					+ listpassenger.get(i).getIdnumber() + "</span></td>";
			String strTicketNumber = "暂无";
			if (listpassenger.get(i).getTicketnum() != null
					&& !listpassenger.get(i).getTicketnum().equals("")) {
				strTicketNumber = listpassenger.get(i).getTicketnum();
			}
			strReturn += "<td>" + strTicketNumber + "</td>";
			strReturn += "<td>" + formatMoney(listpassenger.get(i).getPrice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getFuelprice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getAirportfee())
					+ "</td><td>"
					+ formatMoney(converNull(listpassenger.get(i)
							.getAnjianfee(), 0f))
					+ "</td><td>"
					+ formatMoney(converNull(
							listpassenger.get(i).getOtherfee(), 0f)) + "</td>";
			if (listpassenger.get(i).getTuifee() != null) {
				strReturn += "<td style='color:red;'><b>"
						+ formatMoney(listpassenger.get(i).getTuifee())
						+ "</b></td>";
				totaltuifee += listpassenger.get(i).getTuifee();
			} else {
				strReturn += "<td style='color:red'></td>";
			}
			strReturn += "</tr>";

		}
		strReturn += "<tr><td colspan='10' height='5px'></td></tr>";
		strReturn += "</tbody>";

		strReturn += "</table>";
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tbody>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td>订单编号</td>" + "<td>行程</td>" + "<td>起飞时间</td>"
				+ "<td>预订时间</td>" + "<td>航班号</td>" + "<td>PNR</td>";
		strReturn += "</tr>";
		Orderinfo orderinfo = new Orderinfo();
		if (listpassenger.size() > 0) {
			orderinfo = Server.getInstance().getAirService().findOrderinfo(
					listpassenger.get(0).getOrderid());
		}
		strReturn += "<tr>";
		strReturn += "<td>" + orderinfo.getOrdernumber() + "</td>";
		strReturn += "<td>"
				+ getCitynameByAirport(getSegmentinfo(orderinfo.getId())
						.getStartairport())
				+ "--"
				+ getCitynameByAirport(getSegmentinfo(orderinfo.getId())
						.getEndairport()) + "</td>";
		strReturn += "<td>" + geqifeitime(orderinfo.getId()) + "</td>";
		strReturn += "<td>" + formatTimestamp(orderinfo.getCreatetime())
				+ "</td>";
		strReturn += "<td>" + gethangbanhao(orderinfo.getId()) + "</td>";
		strReturn += "<td>" + orderinfo.getPnr() + "</td>";

		strReturn += "</tr>";

		strReturn += "<tr><td colspan='10' height='5px'></td></tr>";
		strReturn += "</tbody>";
		strReturn += "</table>";
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tr><td class='table_color_l colortrin' colspan='4' width='60px'><b>申请退费原因如下</b></td></tr>";
		strReturn += "<tr><td class='table_color_r colortrin' width='60px'>退废原因:</td><td align='left'>";
		if (listpassenger.get(0).getTuifeiyuanyi() == null) {
			listpassenger.get(0).setTuifeiyuanyi(1l);
		}
		if (listpassenger.get(0).getIscabinsite() == null) {
			listpassenger.get(0).setIscabinsite(1l);
		}
		if (listpassenger.get(0).getTuifeiyuanyi() == 1l) {
			if (typ == 4) {
				strReturn += "自愿退票";
			} else if (typ == 6) {
				strReturn += "当日废票";
			}

		}
		if (listpassenger.get(0).getTuifeiyuanyi() == 2) {
			strReturn += "自愿退票";
		}
		if (listpassenger.get(0).getTuifeiyuanyi() == 3) {
			strReturn += "非自愿退票";
		}
		strReturn += "</td><td align='right' class='table_color_r colortrin' width='60px'>保留位置:</td><td align='left'>";
		if (listpassenger.get(0).getIscabinsite() == 0) {
			strReturn += "是";
		}
		if (listpassenger.get(0).getIscabinsite() == 1) {
			strReturn += "否";
		}
		strReturn += "</td></tr>";

		strReturn += "<tr><td class='table_color_r colortrin' width='60px'>备注说明:</td><td align='left' style='color:red'>"
				+ listpassenger.get(0).getTuifeidesc()
				+ "</td><td class='table_color_r colortrin'>申请时间:</td><td align='left'>"
				+ formatTimestamp(listpassenger.get(0).getTuifeitime())
				+ "</td></tr>";
		strReturn += "<tr><td colspan='4' height='5px'></td></tr>";
		strReturn += "</table>";
		int intiswebpay = 0;
		strReturn += "<form name='formpay' method='post'>";
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		String strbeizhushuoming = "无";
		if (listpassenger.get(0).getBeizhu() != null
				&& !listpassenger.get(0).getBeizhu().equals("undefined")) {
			strbeizhushuoming = listpassenger.get(0).getBeizhu();
		}
		strReturn += "<tr><td class='table_color_r colortrin'>备注说明：</td><td colspan='3' align='left' style='color:red'>"
				+ strbeizhushuoming + "</td></tr>";

		strReturn += "<tr><td width='120px' class='table_color_r colortrin'>退款金额：</td><td colspan='3' align='left'><span style='font-weight:bold'>"
				+ formatMoney(orderinfo.getTotalticketprice()
						+ orderinfo.getTotalairportfee()
						+ orderinfo.getTotalfuelfee()
						+ converNull(orderinfo.getTotalanjian(), 0f)
						+ converNull(orderinfo.getTotalotherfee(), 0f))
				+ "-"
				+ formatMoney(totaltuifee)
				+ "=</span><span style='font-weight:bold;color:red'>"
				+ formatMoney(orderinfo.getTotalticketprice()
						+ orderinfo.getTotalairportfee()
						+ orderinfo.getTotalfuelfee()
						+ converNull(orderinfo.getTotalanjian(), 0f)
						+ converNull(orderinfo.getTotalotherfee(), 0f)
						- totaltuifee) + "元</span></td></tr>";
		if (orderinfo.getPaymethod() == 1) {
			intiswebpay = 1;
			strReturn += "<tr><td style='color:red' colspan='4'><input type='text' name='amount' value='"
					+ formatMoney(orderinfo.getTotalticketprice()
							+ orderinfo.getTotalairportfee()
							+ orderinfo.getTotalfuelfee() - totaltuifee)
					+ "' /><input type='text' name='ordercode' value='"
					+ orderinfo.getOrdernumber()
					+ "' /><b>此订单为网上支付订单，点击退款成功将会调用退款接口进行退款</b></td></tr>";
		}

		strReturn += "<tr><td width='120px' class='table_color_r colortrin'>暂不能退票原因：</td><td colspan='3' align='left'>"
				+ converNull(listpassenger.get(0).getNotuidesc(), "无")
				+ "</td></tr>";

		strReturn += "</table>";
		if (typ == 2) {// 退票
			strReturn += "<br /><input class='button_d font-bai' value='审核通过' onclick='shenhetuiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='审核不通过' onclick='noshenhetuiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		// 废票
		if (typ == 1) {
			strReturn += "<br /><input class='button_d font-bai' value='审核通过' onclick='shenhefeiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='审核不通过' onclick='noshenhefeiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		// 改签
		if (typ == 3) {
			strReturn += "<br /><input class='button_d font-bai' value='审核通过' onclick='shenhegaiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='审核不通过' onclick='noshenhegaiticket("
					+ strTuiOrderID
					+ ");' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		// 升舱换开
		if (typ == 4) {
			strReturn += "<br /><input class='button_d font-bai' value='退款成功' onclick='tuipiaotuikuan("
					+ strTuiOrderID
					+ ");'  type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='取消' onclick='closedialog(0);' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		// 废票退款
		if (typ == 6) {
			strTuikuanDesc = formatMoney(orderinfo.getTotalticketprice()
					+ orderinfo.getTotalairportfee()
					+ orderinfo.getTotalfuelfee())
					+ "-"
					+ formatMoney(totaltuifee)
					+ "="
					+ formatMoney(orderinfo.getTotalticketprice()
							+ orderinfo.getTotalairportfee()
							+ orderinfo.getTotalfuelfee() - totaltuifee);
			strReturn += "<br /><input class='button_d font-bai' value='退款成功' onclick=\"feipiaotuikuan("
					+ strTuiOrderID
					+ ",'"
					+ strTuikuanDesc
					+ "',"
					+ intiswebpay
					+ ");\"  type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='取消' onclick='closedialog(0);' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		// 退票退款
		if (typ == 7) {
			strTuikuanDesc = formatMoney(orderinfo.getTotalticketprice()
					+ orderinfo.getTotalairportfee()
					+ orderinfo.getTotalfuelfee())
					+ "-"
					+ formatMoney(totaltuifee)
					+ "="
					+ formatMoney(orderinfo.getTotalticketprice()
							+ orderinfo.getTotalairportfee()
							+ orderinfo.getTotalfuelfee() - totaltuifee);
			strReturn += "<br /><input class='button_d font-bai' value='退款成功' onclick='tuipiaotuikuan("
					+ strTuiOrderID
					+ ","
					+ intiswebpay
					+ ");'  type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
			strReturn += "<input class='button_d font-bai' value='取消' onclick='closedialog(0);' type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		}
		strReturn += "</form>";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	/**
	 * 显示个人挂账还款
	 * 
	 * @throws Exception
	 */
	public void showguazhang() throws Exception {
		String strReturn = "";
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		Customeruser customeruser = Server.getInstance().getMemberService()
				.findCustomeruser(orderinfo.getCustomeruserid());
		Customeragent customeragent = Server.getInstance().getMemberService()
				.findCustomeragent(customeruser.getAgentid());

		strReturn += "<table id='tbpeisonginfo' class='book_pgcontent' width='99%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tr><td colspan='6' align='left'><b>航程信息</b></td></tr>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td colspan='2'>出发城市-到达城市</td>" + "<td>航班号</td>"
				+ "<td>舱位码</td>" + "<td colspan='2'>起飞时间</td><td></td>";
		strReturn += "</tr>";

		List<Segmentinfo> listseginfo = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + strTuiOrderID, "", -1,
						0);
		for (int i = 0; i < listseginfo.size(); i++) {
			strReturn += "<tr>";
			strReturn += "<td colspan='2'>"
					+ listseginfo.get(i).getStartairport() + "-"
					+ listseginfo.get(i).getEndairport() + "</td>";
			strReturn += "<td>" + listseginfo.get(i).getFlightnumber()
					+ "</td>";
			strReturn += "<td>" + listseginfo.get(i).getCabincode() + "</td>";
			strReturn += "<td colspan='2'>"
					+ formatTimestamp(listseginfo.get(i).getDeparttime())
					+ "</td>";
			strReturn += "</tr>";
		}
		strReturn += "</table>";
		strReturn += "<br />";
		strReturn += "<table id='tbpassenger' class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tbody>";
		strReturn += "<tr><td colspan='12' align='left'><b>乘机人信息</b></td></tr>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td>机票类型</td><td>乘客类型</td><td>乘客姓名</td><td>证件类型</td><td>证件号码</td><td>票号</td><td>票价</td><td>燃油</td><td>机建</td><td>安检</td><td>其它</td><td>退票手续费</td>";
		strReturn += "</tr>";
		String where = "WHERE C_ORDERID=" + strTuiOrderID + " and "
				+ Passenger.COL_state + "<>12";
		float insuranceprice = 0;
		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		for (int i = 0; i < listpassenger.size(); i++) {
			Passenger passenger = listpassenger.get(i);
		
					insuranceprice +=passenger.getInsurprice();
			
			strReturn += "<tr>";
			// strReturn+="<td align='center'><input type='hidden'
			// id='txtpassid_"+i+"' value='"+listpassenger.get(i).getId()+"'
			// /><input type='checkbox' checked='checked'
			// id='chkpassenger_"+i+"'></td>";
			if (i == 0) {
				strReturn += "<td rowspan=\""
						+ listpassenger.size()
						+ "\">"
						+ this.getTickettypeById(
								converNull(listpassenger.get(i)
										.getTickettypeid(), 0l)).getTypename()
						+ "</td>";
			}

			strReturn += "<td>"
					+ getPassTypeToString(listpassenger.get(i).getPtype())
					+ "</td>";
			strReturn += "<td>" + listpassenger.get(i).getName() + "</td>";
			strReturn += "<td>"
					+ getIDTypeToString(listpassenger.get(i).getIdtype())
					+ "</td>";
			strReturn += "<td><span id='gdvTic_ctl02_lbtnzj'>"
					+ listpassenger.get(i).getIdnumber() + "</span></td>";
			String strTicketNumber = "暂无";
			if (listpassenger.get(i).getTicketnum() != null
					&& !listpassenger.get(i).getTicketnum().equals("")) {
				strTicketNumber = listpassenger.get(i).getTicketnum();
			}
			strReturn += "<td>" + strTicketNumber + "</td>";
			strReturn += "<td>" + formatMoney(listpassenger.get(i).getPrice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getFuelprice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getAirportfee())
					+ "</td><td>"
					+ formatMoney(converNull(listpassenger.get(i)
							.getAnjianfee(), 0f))
					+ "</td><td>"
					+ formatMoney(converNull(
							listpassenger.get(i).getOtherfee(), 0f)) + "</td>";
			if (listpassenger.get(i).getTuifee() != null) {
				strReturn += "<td>"
						+ formatMoney(listpassenger.get(i).getTuifee())
						+ "</td>";
			} else {
				strReturn += "<td>无</td>";
			}
			strReturn += "</tr>";

		}

		float allmoney = orderinfo.getTotalairportfee()
				+ orderinfo.getTotalfuelfee() + orderinfo.getTotalticketprice()
				+ insuranceprice + converNull(orderinfo.getPostmoney(), 0);
		strReturn += "</tbody>";
		strReturn += "</table><br />";
		strReturn += "<table id='tbpassenger' class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tbody>";
		strReturn += "<tr><td colspan='9' align='left'><b>还款操作</b></td></tr>";
		strReturn += "<tr style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td class='table_color_r colortrin' width='120px'>挂账金额：</td><td style='background-color:#fff;color:red'>"
				+ formatMoney(allmoney) + "</td>";
		strReturn += "<td class='table_color_r colortrin' width='120px'>挂账人姓名：</td><td style='background-color:#fff'>"
				+ getusername(orderinfo.getGuazhangrenid()) + "</td>";
		strReturn += "<td class='table_color_r colortrin' width='120px'>还款方式：</td><td style='background-color:#fff' align='left'><select><option value='1'>现金</option><option>支票</option><option>建行POS</option><option>银联POS</option><option>免优票</option><option>里程券</option><option>其他</option></select></td>";
		strReturn += "</tr>";
		strReturn += "</table>";

		strReturn += "<br /><input class='button_d font-bai' value='还款成功' onclick='dohuankuan("
				+ orderinfo.getId()
				+ ","
				+ orderinfo.getGuazhangrenid()
				+ ","
				+ allmoney + ");'  type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";
		strReturn += "<input class='button_d font-bai' value='取消还款' onclick='closedialog(0);'  type='button'> &nbsp;&nbsp;&nbsp;&nbsp;";

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	public void dohuankuan() throws Exception {
		Gerenguazhanfrec gerenhuankuan = new Gerenguazhanfrec();
		List<Gerenguazhanfrec> listgerenhuankuan = Server.getInstance()
				.getMemberService().findAllGerenguazhanfrec(
						"where " + Gerenguazhanfrec.COL_orderid + "="
								+ strTuiOrderID + " and C_EMPLOYEEID="
								+ s_employeeid, "", -1, 0);
		if (listgerenhuankuan.size() > 0) {
			gerenhuankuan = listgerenhuankuan.get(0);
			gerenhuankuan.setState(1l);
			gerenhuankuan.setMidifytime(new Timestamp(System
					.currentTimeMillis()));
			gerenhuankuan.setMidifyuser(getLoginUserId() + "");
			Server.getInstance().getMemberService().updateGerenguazhanfrec(
					gerenhuankuan);
		}
		String where = " WHERE C_ORDERID= " + strTuiOrderID;
		List<Passenger> passengerlist = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		for (Passenger passenger : passengerlist) {
			passenger.setHkstate(2l);
			passenger.setHaiqian(0f);
			String yihaiprcie = ServletActionContext.getRequest().getParameter(
					"hkprice");
			float yihai = Float.valueOf(yihaiprcie);
			passenger.setYihai(yihai);
			Server.getInstance().getAirService().updatePassengerIgnoreNull(
					passenger);
		}
		String strReturn = "还款成功！";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	// 得到分离乘机人信息
	public void getPassengersqListsep() throws Exception {
		String strReturn = "";
		Orderinfo listorder = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		String strPPNR = "";
		if (listorder.getPnr() != null && !listorder.getPnr().equals("")) {
			strPPNR = listorder.getPnr();
		} else if (listorder.getBigpnr() != null
				&& !listorder.getBigpnr().equals("")) {
			strPPNR = listorder.getBigpnr();
		}
		strReturn += "<fieldset><legend>订单信息</legend> ";
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tr><td width='30%' align='left'><intput type='text' id='hidseporderid' name='strTuiOrderID' value='"
				+ strTuiOrderID
				+ "' /><b>订单号：</b>"
				+ listorder.getOrdernumber()
				+ "</td><td width='70%' rowspan='3'><div id='pnrinfo' style='text-align:left;background-color: Black; color: #00ff00; height: 123px; width: 98%; margin: 0 auto; overflow: auto;'>请选提取PNR并确认乘机人在PNR中的序号！</div></td></tr>";
		strReturn += "<tr><td align='left'><b>PNR：</b><input type='text' id='txtpnrcode' style='width:60px' value='"
				+ strPPNR
				+ "' />&nbsp;&nbsp;<input type='button' id='btnpnr' onclick='rTPnr();' class='button108' value='提取PNR' /></td></tr>";
		strReturn += "<tr><td align='left'><b>创建时间：</b>"
				+ formatTimestampHHmm2(listorder.getCreatetime())
				+ "</td></tr>";
		strReturn += "</table>";
		strReturn += "</fieldset>";
		if (typ == 4) {
			strReturn += "<fieldset><legend>乘机人信息</legend>";
		}
		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		strReturn += "<tbody>";
		strReturn += "<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>";
		strReturn += "<td><input type='hidden' id='checkboxflag' value='0' /><input style='display:none' type='checkbox' id='chkpassenger1_all' onclick='checkallbox();'></td><td>机票类型</td><td>乘客类型</td><td>乘客姓名</td><td>证件类型</td><td>证件号码</td><td>票号</td><td>票价</td><td>燃油</td><td>机建</td><td>安检</td><td>其它</td>";
		strReturn += "</tr>";
		String where = "WHERE C_ORDERID=" + strTuiOrderID + " and "
				+ Passenger.COL_state + "<>12";
		String strXuhaonumbers = "";
		int inti = 0;
		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		for (int i = 0; i < listpassenger.size(); i++) {
			String strFlag = "";
			String strBkcolor = "";
			if (passids.indexOf(listpassenger.get(i).getId() + "") >= 0) {
				strFlag = "checked='checked'";
				strBkcolor = "style='background-color:#ffffee'";
				inti = i + 1;
				strXuhaonumbers += inti + "/";
			}
			strReturn += "<tr " + strBkcolor + ">";
			strReturn += "<td align='center'><input type='hidden' id='txtpassid_"
					+ i
					+ "' value='"
					+ listpassenger.get(i).getId()
					+ "' /><input type='checkbox' id='chkpassenger_"
					+ i
					+ "' "
					+ strFlag
					+ " disabled='disabled' onclick='setpassid("
					+ i
					+ ");'></td>";
			if (i == 0) {
				strReturn += "<td rowspan=\""
						+ listpassenger.size()
						+ "\">"
						+ this.getTickettypeById(
								converNull(listpassenger.get(i)
										.getTickettypeid(), 0l)).getTypename()
						+ "</td>";
			}

			strReturn += "<td>"
					+ getPassTypeToString(listpassenger.get(i).getPtype())
					+ "</td>";
			strReturn += "<td>" + listpassenger.get(i).getName() + "</td>";
			strReturn += "<td>"
					+ getIDTypeToString(listpassenger.get(i).getIdtype())
					+ "</td>";
			strReturn += "<td><span id='gdvTic_ctl02_lbtnzj'>"
					+ listpassenger.get(i).getIdnumber() + "</span></td>";
			String strTicketNumber = "暂无";
			if (listpassenger.get(i).getTicketnum() != null
					&& !listpassenger.get(i).getTicketnum().equals("")) {
				strTicketNumber = listpassenger.get(i).getTicketnum();
			}
			strReturn += "<td>" + strTicketNumber + "</td>";
			strReturn += "<td>" + formatMoney(listpassenger.get(i).getPrice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getFuelprice())
					+ "</td>";
			strReturn += "<td>"
					+ formatMoney(listpassenger.get(i).getAirportfee())
					+ "</td><td>"
					+ formatMoney(converNull(listpassenger.get(i)
							.getAnjianfee(), 0f))
					+ "</td><td>"
					+ formatMoney(converNull(
							listpassenger.get(i).getOtherfee(), 0f)) + "</td>";

			strReturn += "</tr>";
		}
		strReturn += "</tbody>";
		strReturn += "</table>";
		strReturn += "</fieldset>";
		if (passids.split(",").length != listpassenger.size()) {
			strReturn += "<fieldset><legend>乘机人分离操作</legend> ";
		} else {
			strReturn += "<fieldset><legend>乘机人退票操作</legend> ";
		}

		strReturn += "<table class='book_pgcontent' width='98%' border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0 style='border: 1px solid #a0cfee'>";
		if (passids.split(",").length != listpassenger.size()) {
			strReturn += "<tr><td colspan='3'><input type='radio' id='rdoheipingfenli' checked='checked' name='fenlitype' value='1' />黑白屏同时分离 &nbsp;&nbsp;<input type='radio' id='rdobaipingfenli' onclick='shownewpnr();' name='fenlitype' value='2' />只在白屏分离&nbsp;&nbsp;<span style='display:none' id='span_newpnrinfo'>分离新PNR(小)<input type='text' id='txtnewpnr' style='width:60px' name='strNewPnr' /><font style='color:red'>*</font>&nbsp;&nbsp;分离新PNR(大)<input type='text' id='txtnewbigpnr' style='width:60px' name='strNewBigPnr' /><font style='color:red'>*</font></span></td></tr>";
		} else {
			strReturn += "<tr><td colspan='3'></td></tr>";
		}
		String strBName = "分离";
		String strAName = "全部废退";
		if (tuigaiindex.equals("1")) {
			strBName = "分离并废票";
			strAName = "全部废票";
		} else if (tuigaiindex.equals("2")) {
			strBName = "分离并退票";
			strAName = "全部退票";
		} else if (tuigaiindex.equals("3")) {
			strBName = "分离并改签";
			strAName = "全部改签";
		} else if (tuigaiindex.equals("14")) {
			strBName = "分离并升舱";
			strAName = "全部升舱";
		}
		if (passids.split(",").length != listpassenger.size()) {
			strReturn += "<tr id='trparpnrsep'><td align='left'><span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;请输入待分离乘机人的序号，必须要与黑屏PNR中的序号一致,否则将分离错误！</span></td><td><input type='text' id='txtxuhao' style='width:50px' value='"
					+ strXuhaonumbers
							.substring(0, strXuhaonumbers.length() - 1)
					+ "'  /></td><td align='right'><input type='hidden' id='hidpassengerid' style='width:50px' value='"
					+ passids
					+ "' name='s_newpassid'><input class='button_d font-bai' value='"
					+ strBName
					+ "' onclick='sepratePnr("
					+ tuigaiindex
					+ ");' type='button' /> </td></tr>";
		} else {
			strReturn += "<tr id='trallpnrsep'><td align='left'><span style='color:red'>&nbsp;&nbsp;&nbsp;&nbsp;如果此订单中的所有乘机人都要退/改/废票，请选择"
					+ strAName
					+ ",否则将不能执行成功！</span></td><td colspan='2' align='right'><input class='button_d font-bai' value='"
					+ strAName
					+ "' onclick='alltuifeiticket("
					+ strTuiOrderID
					+ "," + tuigaiindex + ");' type='button' /></td></tr>";
		}
		strReturn += "</table>";
		strReturn += "</fieldset>";

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	public void sepratePNR() throws Exception {
		if (strfenliType.equals("1")) {
			String strReturn = Server.getInstance().getTicketSearchService()
					.SPPNR(strSepPNR, strXuNumber);
			if (strReturn.length() > 0 && strReturn.indexOf("SPLIT FROM") >= 0) {
				// 对黑屏返回值进行解析
				Pattern pattern = Pattern.compile("[\\r\\n]");
				// 以换行符将字符串拆分
				String[] strarr = pattern.split(strReturn);

				for (int i = 0; i < strarr.length; i++) {
					if (strarr[i].indexOf("SPLIT FROM") >= 0) {
						Pattern pDetails = Pattern.compile("\\s{1,2}");
						String[] strPnrarr = pDetails.split(strarr[i]);
						for (int j = 0; j < strPnrarr.length; j++) {
							if (strPnrarr.length == 4) {
								strNewPnr = strPnrarr[0];
								strNewBigPnr = Server.getInstance()
										.getTicketSearchService()
										.getBigPNRInfo(strNewPnr);
							}
						}
					}
				}
			}
		}

		// 将分离的乘机人从原订单更改状态
		// 废票分离
		if (s_newpassid.length() > 1) {
			// 计算保险分数
			List<Passenger> listpasscount = Server.getInstance()
					.getAirService().findAllPassenger(
							" WHERE C_ORDERID=" + strTuiOrderID + " and "
									+ Passenger.COL_state + "<>12", "", -1, 0);

			List<Passenger> listpass = new ArrayList<Passenger>();
			// 插入新订单信息
			Orderinfo ordermodel = Server.getInstance().getAirService()
					.findOrderinfo(Long.parseLong(strTuiOrderID));
			ordermodel.setRelationorderid(ordermodel.getId());
			ordermodel.setId(-1l);
			ordermodel.setOrdernumber("");
			ordermodel.setPnr(strNewPnr);
			ordermodel.setBigpnr(strNewBigPnr);
			// 更新新订单价格信息
			String[] strpidsarr = s_newpassid.split(",");
			float doutotpricenew = 0f;
			float doufuelpricenew = 0f;
			float douairpricenew = 0f;
			for (int i = 0; i < strpidsarr.length; i++) {
				Passenger passenger = Server.getInstance().getAirService()
						.findPassenger(Long.parseLong(strpidsarr[i]));
				listpass.add(passenger);
				passenger.setState(12);
				passenger.setBeizhu("此乘机人已经被分离!");
				int intcount = Server.getInstance().getAirService()
						.updatePassengerIgnoreNull(passenger);
				doutotpricenew += passenger.getPrice();
				doufuelpricenew += passenger.getFuelprice();
				douairpricenew += passenger.getAirportfee();

			}
			ordermodel.setTotalticketprice(doutotpricenew);
			ordermodel.setTotalfuelfee(doufuelpricenew);
			ordermodel.setTotalairportfee(douairpricenew);
			// 保险现在乘机人表里面没有存，暂时分离的时候就认为这个人有份保险
			if (tuigaiindex.equals("1")) {
				ordermodel.setOrderstatus(11); // 废票成功
			} else if (tuigaiindex.equals("2")) {
				ordermodel.setOrderstatus(12); // 退票成功
			} else if (tuigaiindex.equals("3")) {
				ordermodel.setOrderstatus(14); // 改签成功
			}

			ordermodel = Server.getInstance().getAirService().createOrderinfo(
					ordermodel);
			// 更新订单订单号
			ordermodel.setOrdernumber(Server.getInstance().getServiceCenter()
					.getOrderinfoCode(ordermodel));
			// 数据库中插入新订单
			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
					ordermodel);
			Orderinfo orderold = Server.getInstance().getAirService()
					.findOrderinfo(Long.parseLong(strTuiOrderID));
			orderold.setRelationorderid(ordermodel.getId());
			orderold.setOrderstatus(3); // 旧订单出票完成
			// 旧订单价格信息
			orderold.setTotalticketprice(orderold.getTotalticketprice()
					- doutotpricenew);
			orderold.setTotalairportfee(orderold.getTotalairportfee()
					- douairpricenew);
			orderold.setTotalfuelfee(orderold.getTotalfuelfee()
					- doufuelpricenew);

			// 更新旧订单管理订单号
			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
					orderold);
			// 插入新订单航程信息
			// 得到航程ID
			List<Segmentinfo> listsegmentinfo = Server.getInstance()
					.getAirService().findAllSegmentinfo(
							" WHERE C_ORDERID=" + strTuiOrderID, "", -1, 0);
			if (listsegmentinfo.size() > 0) {
				Segmentinfo segmengtinfo = listsegmentinfo.get(0);
				segmengtinfo.setId(-1l);
				segmengtinfo.setOrderid(ordermodel.getId());
				segmengtinfo = Server.getInstance().getAirService()
						.createSegmentinfo(segmengtinfo);

				for (int i = 0; i < listpass.size(); i++) {
					Passenger passeng = listpass.get(i);
					// 插入新订单乘机人信息
					if (tuigaiindex.equals("1")) {
						passeng.setState(2); // 废票成功
					} else if (tuigaiindex.equals("2")) {
						passeng.setState(3);// 退票成功
					} else if (tuigaiindex.equals("3")) {
						passeng.setState(9);// 退票成功
					}

					passeng.setBeizhu("分离新订单");
					passeng.setOrderid(ordermodel.getId());
					passeng.setId(-1l);
					passeng = Server.getInstance().getAirService()
							.createPassenger(passeng);
				}

			}
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strNewPnr);
		out.print(sb);
		out.flush();
		out.close();
	}

	// 得到会员的最近订单信息
	public String getCustomerOrderlist() throws Exception {
		String strHtml = "";

		Customeruser customermodel = (Customeruser) ActionContext.getContext()
				.getSession().get("orderuserlogin");
		if (customermodel != null) {
			String where = " where " + Orderinfo.COL_customeruserid + "="
					+ customermodel.getId();
			listOrderinfo = Server.getInstance().getAirService()
					.findAllOrderinfo(where, "ORDER BY ID DESC", 3, 0);

			strHtml += "<table width='100%' cellpadding='0' cellspacing='0' border='1' bordercolor='#E96E10' style='border-collapse: collapse; text-align:center; border: 1px solid #fff; '>";
			strHtml += "<tr class='tbody_color'><th style='text-align: center;color:#AC5D16 '>订单编号</th><th style='text-align: center;color:#AC5D16 '>联系人姓名</th><th style='text-align: center;color:#AC5D16 '>创建时间</th><th style='text-align: center;color:#AC5D16 '>联系人手机号</th><th style='text-align: center;color:#AC5D16 '>订单状态</th></tr>";
			// 循环
			for (int i = 0; i < listOrderinfo.size(); i++) {
				strHtml += "<tr>";
				strHtml += "<td>"
						+ listOrderinfo.get(i).getOrdernumber()
						+ "</td><td>"
						+ listOrderinfo.get(i).getContactname()
						+ "</td><td>"
						+ listOrderinfo.get(i).getCreatetime()
						+ "</td><td>"
						+ listOrderinfo.get(i).getContactmobile()
						+ "</td><td>"
						+ getStateToString(listOrderinfo.get(i)
								.getOrderstatus()) + "</td>";
				strHtml += "</tr>";
			}
			strHtml += "<tr height='20px'><td colspan='5'>&nbsp;</td></tr>";
			strHtml += "</table>";
		} else {
			strHtml += "<table width='100%' cellpadding='0' cellspacing='0' border='1' bordercolor='#a0cfee' style='border-collapse: collapse; text-align:center; border: 1px solid #fff '>";
			strHtml += "<tr class='tbody_color' ><th style='text-align: center;'>订单编号</th><th style='text-align: center;'>订单编号</th><th style='text-align: center;'>订单编号</th><th style='text-align: center;'>订单编号</th><th style='text-align: center;'>订单编号</th></tr>";
			// 循环
			strHtml += "<tr>";
			strHtml += "<td colspan='5'>没有查询到最近订单信息！</td>";
			strHtml += "</tr>";
			strHtml += "<tr height='20px'><td colspan='5'>&nbsp;</td></tr>";
			strHtml += "</table>";
		}

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strHtml);
		out.print(sb);
		out.flush();
		out.close();

		return strHtml;
	}

	/**
	 * 查看所有锁定的订单
	 * 
	 */
	public String tolockorderinfo() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date());
		}
		if (h_preendtime == null) {
			h_preendtime = sdf.format(new Date());
		}
		listCityairport = Server.getInstance().getAirService()
				.findAllCityairport("", "", -1, 0);
		String where = "";
		where += "where 1=1 and (" + Orderinfo.COL_ordertype + " =1 or "
				+ Orderinfo.COL_ordertype + " = 6 or "
				+ Orderinfo.COL_ordertype + " = 3) and "
				+ Orderinfo.COL_operatingstate + ">0";

		if (s_orderstatus != 0) {
			where += " and " + Orderinfo.COL_orderstatus + "=" + s_orderstatus;
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%'";
		}
		if (s_pnr != null && s_pnr.trim().length() != 0) {
			where += " and " + Orderinfo.COL_pnr + " like '%" + s_pnr.trim()
					+ "%' or " + Orderinfo.COL_bigpnr + " like '%"
					+ s_pnr.trim() + "%'";
		}
		if (s_bengincreatetime != null
				&& s_bengincreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " >= '"
					+ s_bengincreatetime.trim() + " 00:00:00'";
		}
		if (s_endcreatetime != null && s_endcreatetime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_createtime + " <= '"
					+ s_endcreatetime.trim() + " 23:59:59'";
		}
		if (s_beginchengji != null && s_beginchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] >= '"
					+ s_beginchengji + " 00:00:00')";
		}
		if (s_endchengji != null && s_endchengji.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_DEPARTTIME] <= '"
					+ s_endchengji + " 23:59:59')";
		}
		if (s_beginprinttime != null && s_beginprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " >= '"
					+ s_beginprinttime.trim() + " 00:00:00'";
		}
		if (s_endprinttime != null && s_endprinttime.trim().length() != 0) {
			where += " and " + Orderinfo.COL_printtime + " <= '"
					+ s_endprinttime.trim() + " 23:59:59'";
		}
		if (s_begincity != null && s_begincity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_STARTAIRPORT] = '"
					+ s_begincity + "')";
		}
		if (s_endcity != null && s_endcity.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_SEGMENTINFO] where [C_ENDAIRPORT] = '"
					+ s_endcity + "')";
		}

		if (s_passengername != null && s_passengername.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_NAME] like '%"
					+ s_passengername + "%')";
		}
		if (s_passengerfet != null && s_passengerfet.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID] FROM [T_PASSENGER] where [C_FET] like '%"
					+ s_passengerfet + "%')";
		}
		if (s_flightnumber != null && s_flightnumber.trim().length() != 0) {
			where += " and "
					+ Orderinfo.COL_id
					+ " in (SELECT [C_ORDERID]FROM [T_SEGMENTINFO] where C_FLIGHTNUMBER like '%"
					+ s_flightnumber + "%')";
		}
		if (s_ordertype != null && s_ordertype > 0) {
			where += " and " + Orderinfo.COL_ordertype + " = " + s_ordertype;
		}
		List list = Server.getInstance().getAirService()
				.findAllOrderinfoForPageinfo(where, " ORDER BY ID DESC",
						pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listOrderinfo = list;
		if (pageinfo.getTotalrow() > 0 && listOrderinfo.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllOrderinfoForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listOrderinfo = list;
		}

		return "tolockinfo";
	}

	/**
	 * 检测是否已经过了废票时间，出票当日24点之后不能进行废票 Created by sunbin
	 */
	public boolean checkFeiPiaoValite(Timestamp tmrttime) {
		// 取得当前时间
		Timestamp tmnowtime = new Timestamp(System.currentTimeMillis());
		String strDateChupiao = formatTimestamp2(tmrttime);
		Timestamp tmRTTime = dateToTimestamp(strDateChupiao + " 24:00:00");
		Timestamp tmNowTime = dateToTimestamp(tmnowtime.toString());
		if ((tmNowTime.getTime() - tmRTTime.getTime()) > 0) {
			return false;
		}
		return true;
	}

	/**
	 * 判断PNR是否是三天前生成的
	 * 
	 * @throws Exception
	 */
	public boolean chePnrValite(Timestamp tmpnrtime) {
		// 取得当前时间
		Timestamp tmnowtime = new Timestamp(System.currentTimeMillis());
		if ((tmnowtime.getTime() - tmpnrtime.getTime()) > 60 * 1000 * 60 * 24
				* 3) {
			return false;
		}
		return true;
	}

	/*
	 * 修改时间2011-02-25 23：29 sunbin
	 */

	public void IsExistPNR() throws Exception {
		String strReturn = "";
		// 一般代理人配置PNR
		String strWhere = "where 1=1 ";
		int intcount = 0;
		boolean bolFlag = true;
		List<Orderinfo> listorder;
		if (etermtype == 1) {
			strWhere += " and RTRIM(LTRIM(" + Orderinfo.COL_pnr + "))='"
					+ strPNR + "'  and " + Orderinfo.COL_orderstatus
					+ " NOT IN (6,11,12)";
		} else if (etermtype == 2) {
			strWhere += " and RTRIM(LTRIM(" + Orderinfo.COL_bigpnr + "))='"
					+ strPNR + "'  and " + Orderinfo.COL_orderstatus
					+ " NOT IN (6,11,12)";
		}
		listorder = Server.getInstance().getAirService().findAllOrderinfo(
				strWhere, "", -1, 0);
		intcount = listorder.size();
		int intpasscount = 0;

		// if (strPassengers.trim().length() > 1 && strPassengers.indexOf(",") >
		// 0) {
		// String[] strPassArr = strPassengers.split(",");
		// intpasscount = strPassengers.split(",").length;
		// if (listorder.size() > 0) {
		// List<Passenger> listpassenger = Server.getInstance()
		// .getAirService().findAllPassenger(
		// "where " + Passenger.COL_orderid + "="
		// + listorder.get(0).getId(), "", -1, 0);
		// for (int i = 0; i < intpasscount; i++) {
		//
		// for (int j = 0; j < listpassenger.size(); j++) {
		// if (!strPassArr[i].equals(listpassenger.get(j)
		// .getName())) {
		// bolFlag = false;
		// }
		// }
		// }
		// }
		// }

		if (intcount != 0 && intpasscount == intcount && bolFlag) {
			// 存在PNR
			strReturn = "1";
		} else if (intcount == 0) {
			// 不存在PNR
			strReturn = "0";
		}

		if (strPNR.length() == 0) {
			strReturn = "0";
		}

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	/**
	 * 判断票号是否存在
	 * 
	 * @throws Exception
	 */
	public void IsExistTicketNumber() throws Exception {
		String strReturn = "";
		String strWhere = "where 1=1 ";
		strWhere += " and "
				+ Passenger.COL_ticketnum
				+ "='"
				+ ticketnumberarr
				+ "'  and C_ORDERID not in ( select ID from T_ORDERINFO where C_ORDERSTATUS=6)"; // 取消状态的订单票号，可以重复
		int intcount = 0;
		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(strWhere, "", -1, 0);
		if (listpassenger.size() > 0) {
			strReturn = listpassenger.get(0).getOrderid() + "";
		} else {
			strReturn = "0";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	/*
	 * 验证PNR或者票号是否存在
	 */
	public void IsExistPNRORTN() throws Exception {
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(oid);
		List<Passenger> listpass = Server.getInstance().getAirService()
				.findAllPassenger("where " + Passenger.COL_orderid + "=" + oid,
						"", -1, 0);
		if (listpass.size() > 0) {
			ticketnumberarr = listpass.get(0).getTicketnum();
		}
		String strReturn = "";
		String strWhere = "where 1=1 ";
		strWhere += " and "
				+ Passenger.COL_ticketnum
				+ "='"
				+ ticketnumberarr
				+ "'  and C_ORDERID not in ( select ID from T_ORDERINFO where C_ORDERSTATUS=6)"; // 取消状态的订单票号，可以重复
		int intcount = 0;
		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(strWhere, "", -1, 0);
		if (listpassenger.size() > 0) {
			strReturn = "1";
		} else {
			List<Orderinfo> listorder;
			String strWhere1 = "where 1=1   and " + Orderinfo.COL_orderstatus
					+ "<> 6 ";
			if (orderinfo.getBigpnr() != null) {
				strWhere1 += "and RTRIM(LTRIM(" + Orderinfo.COL_bigpnr + "))='"
						+ orderinfo.getBigpnr() + "' ";
			}
			if (orderinfo.getPnr() != null) {
				strWhere1 += " and RTRIM(LTRIM(" + Orderinfo.COL_pnr + "))='"
						+ orderinfo.getPnr() + "' ";
			}
			listorder = Server.getInstance().getAirService().findAllOrderinfo(
					strWhere1, "", -1, 0);
			intcount = listorder.size();
			if (intcount > 0) {
				strReturn = "1";
			} else {
				strReturn = "0";
			}
		}

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	/**
	 * @throws Exception
	 *             3:正在出票
	 */
	public void rrticket() throws Exception {
		String strReturn = "";
		String strTickNuminfo = "";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.parseLong(strTuiOrderID));
		// System.out.println(orderinfo.getOperatingstate());
		// System.out.println(this.getLoginUserId());
		// System.out.println(orderinfo.getUserid());

		if (!(converNull(orderinfo.getOperatingstate(), 0l) > 0 && orderinfo
				.getUserid() == this.getLoginUserId())
				|| orderinfo.getOrderstatus() > 2) {
			if (orderinfo.getOrderstatus() > 2) {
				sb.append("此订单已做出票处理，("
						+ this.getusername(orderinfo.getUserid())
						+ "),请您刷新页面!<script>window.refresh(); <script>");
			} else if ((converNull(orderinfo.getOperatingstate(), 0l) > 0 && orderinfo
					.getUserid() != this.getLoginUserId())) {

				sb.append("此订单已被" + this.getusername(orderinfo.getUserid())
						+ "锁定！");
			}
			sb
					.append("<input class='button_d font-bai' value=' 确   定 ' onclick='closedialog("
							+ strTuiOrderID + ");' type='button' />");
		} else {
			Customeragent agent = Server.getInstance().getMemberService()
					.findCustomeragent(orderinfo.getCustomeragentid());
			List<Segmentinfo> segments = Server.getInstance().getAirService()
					.findAllSegmentinfo(
							" WHERE " + Segmentinfo.COL_orderid + "="
									+ strTuiOrderID, "", -1, 0);
			Segmentinfo segment = new Segmentinfo();
			if (segments != null && segments.size() > 0) {
				segment = segments.get(0);
			}

			Server.getInstance().getAirService().updateOrderinfo(orderinfo);
			String ticketwhere = " WHERE 1=1 ";
			listtickettype = Server.getInstance().getMemberService()
					.findAllTickettype(ticketwhere, "", -1, 0);
			String strPNR = orderinfo.getPnr();
			// 取得票号
			List<Passenger> listpassenger = Server.getInstance()
					.getAirService().findAllPassenger(
							"WHERE C_ORDERID=" + strTuiOrderID + " and "
									+ Passenger.COL_state + "<>12",
							"ORDER BY ID", -1, 0);

			float allinsurpirce = 0f;
			for (Passenger p : listpassenger) {
				allinsurpirce += p.getInsurprice();
			}
			sb.append("<table><tr><td>基本信息</td></tr></table>");
			sb
					.append("<table class='book_pgcontent' width='100%' border='1' cellspacing='0' bordercolorlight='#a0cfee' bordercolordark='white' cellpadding='0' style='border: 1px solid #a0cfee'>");
			sb
					.append("<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>");
			sb
					.append("<th style='text-align:center'>大客户编码</th>"
							+ "<th style='text-align:center'>航空公司</th>"
							+ "<th style='text-align:center'>航班号</th>"
							+ "<th style='text-align:center'>航程</th>"
							+ "<th style='text-align:center'>起飞日期</th>"
							+ "<th style='text-align:center'>舱位</th><th style='text-align:center'>PNR</th><th style='text-align:center'>费用总计</th>");
			sb.append("</tr>");
			sb.append("<tr>");
			float allprice = converNull(orderinfo.getTotalticketprice(), 0f)
					+ converNull(orderinfo.getTotalairportfee(), 0f)
					+ converNull(orderinfo.getTotalfuelfee(), 0f)
					+ converNull(orderinfo.getTotalanjian(), 0f)
					+ converNull(orderinfo.getTotalotherfee(), 0f);
			sb.append("<td>" + agent.getCode() + "</td><td>"
					+ getAircomapnycodeByEZM(segment.getAircomapnycode())
					+ "</td>"
					+ "<td>"
					+ segment.getFlightnumber()
					+ "</td>"
					+ "<td>"
					// + new AirreportAction().getFlight(orderinfo.getId())
					+ "</td>" + "<td>"
					+ super.formatTimestamptoMinute(segment.getDeparttime())
					+ "</td>" + "<td>" + segment.getCabincode() + "</td><td>"
					+ getpnr(orderinfo.getId()) + "</td><td>" + allprice
					+ "</td>");
			sb.append("</tr>");
			sb.append("</table>");
			sb
					.append("<form name='chupiaoform' id='chupiaoform' action='orderinfo!saveticketnumber.action' method='post'>");
			sb.append("<input type=\"hidden\" name=\"corderid\" value='"
					+ strTuiOrderID + "'/>");
			sb
					.append("<span style='color:red' align='left'>请填写正确格式的票号！</span>");
			sb
					.append("<table class='book_pgcontent' width='100%' border='1' cellspacing='0' bordercolorlight='#a0cfee' bordercolordark='white' cellpadding='0' style='border: 1px solid #a0cfee'>");
			sb.append("<tbody>");
			sb
					.append("<tr class='GridViewHeaderStyle' style='font-weight: bold; font-style: normal; text-decoration: none; background-color: #ccc'>");
			sb
					.append("<td>乘客类型</td><td>乘客姓名</td><td>证件类型</td><td>证件号</td><td>票号</td><td>EI项</td><td>票价</td><td>机建</td><td>燃油</td>");

			if (orderinfo.getInternal() != null) {
				if (orderinfo.getInternal() == 1) {
					sb.append("<td>安检</td><td>其它税</td>");
				}

			}

			sb.append("<td>小计</td>");
			sb.append("</tr>");
			for (int i = 0; i < listpassenger.size(); i++) {
				sb.append("<tr id='tr" + i + "'>");

				sb.append("<td>"
						+ getPassTypeToString(listpassenger.get(i).getPtype())
						+ "</td>");
				sb
						.append("<td>"
								+ listpassenger.get(i).getName()
								+ "<br /><input type='checkbox' name='feiyouarr' value='1' />航班动态短信<br /><input type='checkbox' name='tixingsmsarr' value='1' />出票提醒短信</td>");
				Passenger passenger = listpassenger.get(i);
				long pid = passenger.getId();
				String credityp = getIDTypeToString(passenger.getIdtype());
				sb.append("<td>" + credityp + "</td>");
				sb.append("<td>" + passenger.getIdnumber() + "</td>");
				sb
						.append("<td><input size='17' id='titnum" + i
								+ "' name=\"" + pid + "ticketnumber\" value='"
								+ converNull(passenger.getTicketnum(), "")
								+ "'/></td>");
				// sb.append("<td><input name=\"" + pid + "rpnumber\" value='"
				// + passenger.getFet() + "'/></td>");
				sb.append("<td><select name='" + pid
						+ "ei'  style='width:140px'>");
				sb.append("<option value='暂无'>--请选择--</option>");
				sb.append("<option value='不得签转'>不得签转</option>");
				sb.append("<option value='不得签转-变更'>不得签转、变更</option>");
				sb.append("<option value='不得退票'>不得退票</option>");
				sb.append("<option value='不得签转-变更-退票'>不得签转、变更、退票</option>");
				sb.append("<option value='全价票' >全价票</option>");
				sb.append("<option value='退票收取5％的费用'>退票收取5％的费用</option>");
				sb.append("<option value='不得签转-退票收费'>不得签转、退票收费</option>");
				sb.append("<option value='不得签转-变更-退票收费'>不得签转、变更、退票收费</option>");
				sb.append("</select></td>");
				sb
						.append("<td><input size='7' id='price"
								+ i
								+ "' onblur='accountprice()' name='"
								+ pid
								+ "price' value='"
								+ passenger.getPrice()
								+ "'/></td><td><input  size='5' onblur='accountprice()' id='air"
								+ i
								+ "' name='"
								+ pid
								+ "airport' value='"
								+ passenger.getAirportfee()
								+ "'/></td><td><input  size='5' onblur='accountprice()' id='fuel"
								+ i + "' name='" + pid

								+ "fuel' value='" + passenger.getFuelprice()
								+ "'/></td>");
				if (orderinfo.getInternal() != null) {
					if (orderinfo.getInternal() == 1) {
						sb
								.append("<td><input size='5' name='"
										+ pid
										+ "anjian' onblur='accountprice()' id='anjian"
										+ i
										+ "' value='"
										+ converNull(passenger.getAnjianfee(),
												0f)
										+ "'/></td>"
										+ "<td><input size='5' onblur='accountprice()' id='other"
										+ i
										+ "' name='"
										+ pid
										+ "other' value='"
										+ converNull(passenger.getOtherfee(),
												0f) + "'/></td>");
					}

				}
				float xjprice = converNull(passenger.getPrice(), 0f)
						+ converNull(passenger.getFuelprice(), 0f)
						+ converNull(passenger.getAirportfee(), 0f)
						+ converNull(passenger.getAnjianfee(), 0f)
						+ converNull(passenger.getOtherfee(), 0f);
				sb.append("<td id='pprice" + i + "'>" + xjprice + "</td>");
				sb.append("</tr>");

			}
			String option = "<option value=\"-1\"></option>";
			for (Tickettype tickettype : listtickettype) {
				option += "<option value=\"" + tickettype.getId() + "\">"
						+ tickettype.getTypename() + "</option>";
			}
			sb
					.append("<tr><td align=\"right\"  class='GridViewHeaderStyle' style='color:#0356A6'>机票类型:</td><td colspan=\"12\" align='left'><select id=\"tictypeid\" name=\"s_tickettypeid\">"
							+ option + "</select></td></tr>");
			sb
					.append("<tr><td align=\"right\" class='GridViewHeaderStyle' style='color:#0356A6'>订单备注:</td>"
							+ "<td colspan=\"12\" align='left'><textarea rows=\"2\" cols=\"50\" name=\"ordermemo\">"
							+ orderinfo.getMemo() + "</textarea></td></tr>");
			sb
					.append("<tr><td align=\"right\" class='GridViewHeaderStyle' style='color:#0356A6'>联系人发送短信:</td>"
							+ "<td colspan=\"12\" align='left'><input type='checkbox' name='isfeiyou' value='1' />航班动态短信&nbsp;&nbsp;"
							+ "<input type='checkbox' name='istianxuntong' value='1' />出票提醒短信</td></tr>");
			sb.append("</tbody>");
			sb.append("</table>");
			sb.append("<br/>");

			sb
					.append("<input id='chupiaoid' type='button' onclick='valch()' class=\"button_d font-bai\" value='保存并出票'/>&nbsp;&nbsp;<input class='button_d font-bai' value='取消' onclick='closedialog("
							+ strTuiOrderID + ");' type='button' />");
			sb.append("</form>");
			sb
					.append("<script>" + "function valchupiao(){" + " "
							+ "for(i=0;i<"
							+ listpassenger.size()
							+ ";i++){"
							+ "if($('#titnum'+i).val()==\"\"){"
							+ "alert('第'+(i+1)+'行中票号不能为空！');"
							+ "$('#titnum'+i).focus(); "
							+ "return false;"
							+ ""
							+ "}"
							+ ""
							+ "if($('#titnum'+i).val().length<14){"
							+ "alert('第'+(i+1)+'行中票号格式不正确！');"
							+ "$('#titnum'+i).focus(); "
							+ " return false;"
							+ "}"
							+ "var price=$('#price'+i); var fuel=$('#fuel'+i); var air=$('#air'+i);var anjian=$('#anjian'+i);var other=$('#other'+i);"
							+

							"if(price!=null&&(price.val()==0||price.val()=='')){"
							+ "  if(confirm('是否确定第'+(i+1)+'行中票价为空！')){}else{return false}"
							+ " }"
							+ "if(air!=null&&(air.val()==0||air.val()=='')){"
							+ "  if(confirm('是否确定第'+(i+1)+'行中燃油费为空！')){}else{return false}"
							+ " }"
							+ "if(fuel!=null&&(fuel.val()==0||fuel.val()=='')){"
							+ "  if(confirm('是否确定第'+(i+1)+'行中机建费为空！')){}else{return false}"
							+ " }"
							+ "if(anjian!=null&&(anjian.val()==0||anjian.val()=='')){"
							+ "  if(confirm('是否确定第'+(i+1)+'行中安检费为空！')){}else{return false}"
							+ " }"
							+ "if(other!=null&&(other.val()==0||other.val()=='')){"
							+ "  if(confirm('是否确定第'+(i+1)+'行中其它费为空！')){}else{return false}"
							+ " }"
							+ "}"
							+ "return true;"
							+ "}"
							+ "function valch(){"
							+ "if(valchupiao()&&valtype()){"
							+ "document.chupiaoform.submit();"
							+ "}"
							+ "}"
							+ "function valtype(){"
							+ "var tid=$(\"#tictypeid\").val();"
							+ "if(tid==-1){"
							+ "alert('请选择机票类型！');"
							+ "return false;"
							+ "}"
							+ "return true;"
							+ "}"
							+ "</script>");
		}
		out.print(sb);
		out.flush();
		out.close();

	}

	/**
	 * @throws Exception
	 *             保存并出票
	 */
	public String saveticketnumber() throws Exception {

		String strReturn = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		String q = request.getParameter("corderid");
		strTuiOrderID = converNull(q, "0");
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(Long.valueOf(strTuiOrderID));

		Timestamp date = new Timestamp(System.currentTimeMillis());
		orderinfo.setPrinttime(date);
		// orderinfo.setOperatingstate(0l);//解锁
		// orderinfo.setUserid(0l);
		orderinfo.setBusystatus(1l);
		String strOptdesc = "";
		if (orderinfo.getReceipt() != null && orderinfo.getReceipt() != 4
				&& orderinfo.getReceipt() != 5) {// 如果订单非配送订单-----（此处添加：han）
			orderinfo.setOrderstatus(29);// 订单状态改为待收银

		} else if (converNull(orderinfo.getReceipt(), 0) == 4
				|| converNull(orderinfo.getReceipt(), 0) == 5) {
			orderinfo.setOrderstatus(3);
		}
		if (this.isBiguserOrder(orderinfo)) {
			if (converNull(orderinfo.getReceipt(), 0) == 5) {// 大客户协议配送
				orderinfo.setOrderstatus(29);
			}
		}
		this.orderinfo = orderinfo;
		// this.editorderstatus();
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		List<Passenger> listpassenger = Server.getInstance().getAirService()
				.findAllPassenger(
						"WHERE C_ORDERID=" + strTuiOrderID + " and "
								+ Passenger.COL_state + "<>12", "ORDER BY ID",
						-1, 0);
		float allprice = 0f;// 总票价
		float allairport = 0f;// 总机建
		float allfuel = 0f;// 总燃油
		float allanjian = 0f;// 总安检
		float allother = 0f;// 总其它

		if (listpassenger.size() > 0) {
			for (int i = 0; i < listpassenger.size(); i++) {
				Passenger passenger = listpassenger.get(i);
				passenger.setState(1);
				long paid = passenger.getId();
				String str = String.valueOf(paid);
				String titnum = request.getParameter(str + "ticketnumber");
				// String xcd = request.getParameter(str + "rpnumber");
				String ei = request.getParameter(str + "ei");
				passenger.setTicketnum(titnum);
				passenger.setTickettypeid(s_tickettypeid);
				passenger.setEi(ei);
				float price = Float.valueOf(converTrim(request.getParameter(str
						+ "price"), "0"));
				float airport = Float.valueOf(converTrim(request
						.getParameter(str + "airport"), "0"));
				float fuel = Float.valueOf(converTrim(request.getParameter(str
						+ "fuel"), "0"));
				float anjian = 0f;
				if (request.getParameter(str + "anjian") != null) {
					anjian = Float.valueOf(converTrim(request.getParameter(str
							+ "anjian"), "0"));
				}
				float other = 0f;
				if (request.getParameter(str + "other") != null) {
					other = Float.valueOf(converTrim(request.getParameter(str
							+ "other"), "0"));
				}
				allprice += price;
				allairport += airport;
				allfuel += fuel;
				allanjian += anjian;
				allother += other;
				passenger.setPrice(price);
				passenger.setAirportfee(airport);
				passenger.setFuelprice(fuel);
				passenger.setAnjianfee(anjian);
				passenger.setOtherfee(other);
				passenger.setRttime(orderinfo.getPrinttime());
				Server.getInstance().getAirService().updatePassengerIgnoreNull(
						passenger);
			}
		}
		strOptdesc = "立即出票-" + this.getLoginUser().getMembername()
				+ "执行了立即出票操作，订单状态为："
				+ this.getStateToString(orderinfo.getOrderstatus());
		orderinfo.setTotalticketprice(allprice);
		orderinfo.setTotalairportfee(allairport);
		orderinfo.setTotalfuelfee(allfuel);
		orderinfo.setTotalanjian(allanjian);
		orderinfo.setTotalotherfee(allother);
		String ordermemo = request.getParameter("ordermemo");
		orderinfo.setMemo(ordermemo);
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		Orderinforc orderinforc = new Orderinforc();
		orderinforc.setOrderinfoid(orderinfo.getId());
		orderinforc.setCustomeruserid(this.getLoginUserId());
		orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		orderinforc.setContent(strOptdesc);
		orderinforc.setSuouserid(orderinfo.getUserid());
		orderinforc.setState(orderinfo.getOrderstatus());
		Server.getInstance().getAirService().createOrderinforc(orderinforc);
		if (orderinfo.getOrderstatus() == 29) {
			Orderinforc orderinforcc = new Orderinforc();
			orderinforcc.setOrderinfoid(orderinfo.getId());
			orderinforcc.setCustomeruserid(this.getLoginUserId());
			orderinforcc
					.setCreatetime(new Timestamp(System.currentTimeMillis()));
			orderinforcc.setContent("");
			orderinforcc.setSuouserid(orderinfo.getUserid());
			orderinforcc.setState(3);
			Server.getInstance().getAirService()
					.createOrderinforc(orderinforcc);
		}
		s_orderstatus = 2;
		ty = 1;

		// 发送短信
		return tob2c();
	}

	public void candothis() throws Throwable {
		boolean result = true;
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		PrintWriter out = response.getWriter();
		long orderid = Long.valueOf(converNull(request.getParameter("orderid"),
				"0"));
		long operate = Long.valueOf(converNull(request
				.getParameter("operateid"), "-1"));
		if (orderid > 0l) {
			Orderinfo orderinfo = Server.getInstance().getAirService()
					.findOrderinfo(orderid);
			if (orderinfo != null) {
				if (orderinfo.getOperatingstate() != null) {
					if (orderinfo.getOperatingstate() == operate) {
						result = false;
					}
				}
			}
		}
		out.print(result);
		out.close();
	}

	private String converTrim(String value, String returnvalue) {
		if (value.trim().length() == 0) {
			return returnvalue;
		}
		return value;
	}

	/**
	 * 锁定订单
	 * 
	 * @throws Exception
	 */
	public void lockorder() throws Exception {
		String strReturn = "";
		try {
			orderinfo = Server.getInstance().getAirService().findOrderinfo(
					Long.parseLong(strTuiOrderID));
			// 已经为锁定状态
			if (converNull(orderinfo.getOperatingstate(), 0l) > 0l) {
				// 别人在处理的订单
				if (getLoginUserId() != orderinfo.getUserid()) {

					strReturn = getusername(orderinfo.getUserid());
				}
			} else {
				// 锁定订单
				orderinfo.setOperatingstate(1l);
				orderinfo.setUserid(getLoginUserId());
				orderinfo.setUpdatetime(new Timestamp(System
						.currentTimeMillis()));
				Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
						orderinfo);
			}
		} catch (Exception ex) {

		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	/**
	 * 锁定订单
	 * 
	 * @throws Exception
	 */
	public void isLocked() throws Exception {
		String strReturn = "";
		try {
			orderinfo = Server.getInstance().getAirService().findOrderinfo(
					Long.parseLong(strTuiOrderID));
			// 已经为锁定状态
			if (converNull(orderinfo.getOperatingstate(), 0l) > 0l) {
				// 别人在处理的订单
				if (getLoginUserId() != orderinfo.getUserid()) {

					strReturn = getusername(orderinfo.getUserid());
				}
			}
		} catch (Exception ex) {

		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(strReturn);
		out.flush();
		out.close();
	}

	/**
	 * 解锁订单
	 * 
	 * @throws Exception
	 */
	public void unlockorderinfo() throws Exception {
		String strReturn = "";
		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				Long.parseLong(strTuiOrderID));
		// 锁定订单
		orderinfo.setOperatingstate(0l);
		orderinfo.setUserid(0l);
		orderinfo.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
				orderinfo);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	public Tickettype getTickettypeById(long typeid) {
		if (typeid > 0) {
			return Server.getInstance().getMemberService().findTickettype(
					typeid);
		} else {
			Tickettype tyep = new Tickettype();
			tyep.setTypename("");
			return tyep;
		}
	}

	public Tickettype getTickettypeByOrderId(long orderid) {
		Tickettype type = new Tickettype();
		String where = " WHERE C_ORDERID=" + orderid;
		List<Passenger> passengerlist = Server.getInstance().getAirService()
				.findAllPassenger(where, "", -1, 0);
		if (passengerlist.size() > 0) {
			Passenger passenger = passengerlist.get(0);
			type = Server.getInstance().getMemberService().findTickettype(
					passenger.getTickettypeid());
		}
		return type;
	}

	// 将字符串格式化成HTML
	private String formatHTML(String strIn) {
		int bz = strIn.length();
		if (bz > 0) {
			char[] temps = strIn.toCharArray();
			String temp1 = "";
			int count = 0;
			for (int i = 0; i < temps.length; i++) {
				//System.out.println("?:"+temps[i]);
				count++;
				if (count == 80) {
					count = 0;
					temp1 = temp1 + "<br>";
					continue;
				}
				if (temps[i] == (char) 13) {
					count = 0;
					temp1 = temp1 + "<br>";
					continue;
				}
				if (temps[i] == (char) 10) {
					count = 0;
					temp1 = temp1 + "<br>";
					continue;
				}
				if (temps[i] == (char) 27) {
					temp1 = temp1 + ">>";
					continue;
				}
				if (temps[i] == (char) 0x1E) {
					temp1 = temp1 + "&&";
					continue;
				}
				if (temps[i] == (char) 0x00) {
					continue;
				}
				temp1 = temp1 + temps[i];

			}
			temp1 = temp1.replace(">>b", "");
			temp1 = temp1.replace("&&", "");
			return temp1;
		} else {
			return "";
		}
	}

	// 退款成功
	public String tuikuansuccess() {
		List<Orderinfo> orderinfolist = Server.getInstance().getAirService()
				.findAllOrderinfo(
						"where " + Orderinfo.COL_ordernumber + "='"
								+ strTuiOrderID + "'", "", -1, 0);
		try {
			orderinfo = orderinfolist.get(0);
			orderinfo.setOrderstatus(9);
			Server.getInstance().getAirService().updateOrderinfoIgnoreNull(
					orderinfo);

			String loginname = Server.getInstance().getMemberService()
					.findCustomeruser(getLoginUser().getId()).getLoginname();
			List<Passenger> listpa = Server.getInstance().getAirService()
					.findAllPassenger(
							"where 1=1 and " + Passenger.COL_orderid + " ="
									+ orderinfo.getId(), "", -1, 0);
			if (listpa.size() > 0) {
				for (int a = 0; a < listpa.size(); a++) {
					Orderinforc orderinforc = new Orderinforc();
					orderinforc.setCustomeruserid(getLoginUserId());
					orderinforc.setOrderinfoid(orderinfo.getId());
					orderinforc.setCreatetime(new Timestamp(System
							.currentTimeMillis()));
					orderinforc.setContent("退款成功！");
					orderinforc.setSuouserid(orderinfo.getUserid());
					orderinforc.setState(orderinfo.getOrderstatus());
					orderinforc.setCustomeruserid(getLoginUserId());
					Server.getInstance().getAirService().createOrderinforc(
							orderinforc);
				}
			}
		} catch (Exception ex) {
		}

		// 获取前一页面路径
		forward = ServletActionContext.getRequest().getHeader("Referer");
		return "editorderstatus";

	}

	// 退款失败
	public String tuikuanshibai() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("GB2312");
		Writer writer;
		try {
			writer = response.getWriter();
			writer.write("还款失败,请重试！");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "toaddinsurance";
	}

	/**
	 * 按照票号导入订单信息
	 * 
	 * @return
	 */
	public String toCreateOrderBytnumber() {
		Customeruser user = (Customeruser) ActionContext.getContext()
				.getSession().get("orderuserlogin");
		if (user != null) {
			linkid = user.getId();
		}
		// 小配置提取票号不加参数
		String strnoparmcmd = "DETR:TN/" + strticketnumber + "";
		// 小配置提取票号指令
		String strsmallcmd = "DETR:TN/" + strticketnumber + ",s";
		// 大配置提取票号指令
		String strbigcmd = "DETR:TN/" + strticketnumber + ",h";
		// 根据小配置取证件信息
		String strsmallfcmd = "DETR:TN/" + strticketnumber + ",f";
		// 使用小配置提取票号信息
		String strsmallReturn = Server.getInstance().getTicketSearchService()
				.commandFunction2("$IG$" + strsmallcmd + "$PN$PN$PN", "", "");
		// 使用大配置提取票号信息
		String strbigReturn = Server.getInstance().getTicketSearchService()
				.commandFunction("$IG$" + strbigcmd + "$IG", "");
		// 小配置提取票号信息
		String strsmallnopar = Server.getInstance().getTicketSearchService()
				.commandFunction2("$IG$" + strnoparmcmd, "", "");
		// 小配置提取证件信息
		String strfcmd = Server.getInstance().getTicketSearchService()
				.commandFunction2("$IG$" + strsmallfcmd, "", "");

		Segmentinfo segmentinfo = new Segmentinfo();
		Passenger passenger = new Passenger();
		Orderinfo ordermodel = new Orderinfo();
		// 解析小配置返回价格信息
		Pattern psmall = Pattern.compile("\\n");
		String[] arrPassenger = psmall.split(strsmallReturn);
		String strPassengerName = "";
		String strIdNumber = "";
		String strPrice = "";
		String strFuelPrice = "";
		String strAirPortFee = "";
		String strRTTime = "";
		float excprice = 0;

		try {
			if (arrPassenger.length > 0) {
				for (int i = 0; i < arrPassenger.length; i++) {
					// 旅客姓名
					if (arrPassenger[i].indexOf("旅客姓名") >= 0) {
						Pattern pname = Pattern.compile("\\s{2,}");
						String[] names = pname.split(arrPassenger[i]);
						if (names.length == 2) {
							strPassengerName = names[1];
						}
					}
					// 证件号
					if (strfcmd.length() > 0) {
						String[] arridnumber = strfcmd.split("[N][I]");
						if (arridnumber.length == 2) {
							strIdNumber = arridnumber[1].replace("b", "");
						}

					}
					// 票价信息
					if (arrPassenger[i].indexOf("票价") >= 0) {
						Pattern pprice = Pattern.compile("\\s{1,}");
						String[] arrprice = pprice.split(arrPassenger[i]);
						for (int z = 0; z < arrprice.length; z++) {
							if (arrprice[z].indexOf(".00") >= 0) {
								strPrice = arrprice[z];
							}
						}
					}
					// 燃油费
					if (arrPassenger[i].indexOf("税款") >= 0) {
						String strTaxinfo = "";
						Pattern pTax = Pattern.compile("\\s{1,}");
						String[] arrtax = pTax.split(arrPassenger[i]);
						if (arrtax.length > 0 && arrtax.length == 5) {
							strAirPortFee = arrtax[2].replace("CN", "");
							strFuelPrice = arrtax[4].replace("YQ", "");
						} else if (arrtax.length == 3) {
							strAirPortFee = "0";
							strFuelPrice = arrtax[2].replace("YQ", "");
						}
					}
					// 出票时间
					if (arrPassenger[i].indexOf("出票时间/地点") >= 0) {
						// 05JAN11
						strRTTime = arrPassenger[i].split("\\s{1,}")[1];
						strRTTime = "20"
								+ strRTTime.substring(5, 7)
								+ "-"
								+ ChangeDateModeToInt(strRTTime.substring(2, 5))
								+ "-" + strRTTime.substring(0, 2);
						s_printtime = strRTTime;
					}
					// 付款总额
					if (arrPassenger[i].indexOf("付款总额") >= 0) {
						// 05JAN11
						String[] strexcprice = arrPassenger[i].split("\\s{1,}");
						if (strexcprice.length >= 3) {
							try {
								excprice = Float.parseFloat(strexcprice[2]);
							} catch (Exception ex) {
								excprice = 0f;
							}
						}
					}
				}
				// 判断票的状态
				if (strsmallnopar.indexOf("OPEN FOR USE") >= 0) {
					s_orderstatuspnr = "3";
				}
				if (strsmallnopar.indexOf("USED") >= 0) {
					s_orderstatuspnr = "3";
				}
				if (strsmallnopar.indexOf("REFUNDED") >= 0) {
					Timestamp tmnowtime = new Timestamp(System
							.currentTimeMillis());
					Timestamp tmRTTime = dateToTimestamp(strRTTime
							+ " 24:00:00");
					Timestamp tmNowTime = dateToTimestamp(tmnowtime.toString());
					if ((tmNowTime.getTime() - tmRTTime.getTime()) > 0) {
						s_orderstatuspnr = "12";
					} else {
						s_orderstatuspnr = "11";
					}
				}
				// 乘机人赋值
				// 乘机人姓名
				passenger.setName(strPassengerName);
				// 价格信息
				if (strPrice != null && !strPrice.equals("")) {
					passenger.setPrice(Float.parseFloat(strPrice));
				}
				// 燃油费
				if (strFuelPrice != null && !strFuelPrice.equals("")) {
					try {
						passenger.setFuelprice(Float.parseFloat(strFuelPrice));
					} catch (Exception ex) {
						passenger.setFuelprice(0f);
					}
				} else {

					passenger.setFuelprice(70f);
				}
				// 机建费
				if (strAirPortFee != null && !strAirPortFee.equals("")) {
					try {
						passenger
								.setAirportfee(Float.parseFloat(strAirPortFee));
					} catch (Exception ex) {
						passenger.setAirportfee(0f);
					}

				} else {
					passenger.setAirportfee(50f);
				}
				// 证件信息
				passenger.setIdnumber(strIdNumber);
				if (passenger.getName().indexOf("INF") >= 0) {
					passenger.setIdtype(0);
					passenger.setPtype(3);
				} else if (passenger.getName().indexOf("CHD") >= 0) {
					passenger.setIdtype(1);
					passenger.setPtype(2);
				} else {
					passenger.setIdtype(1);
					passenger.setPtype(1);
				}

				// 出票日期
				passenger.setRttime(dateToTimestamp(strRTTime));
				passenger.setTicketnum(strticketnumber);
				// 取得行程单号
				if (strbigReturn.indexOf("RECEIPT:") >= 0) {
					String strreceipt = strbigReturn.split("RECEIPT:")[1]
							.split("\\s{1,}")[0];
					passenger.setFet(strreceipt);
				}
				listPassenger.add(passenger);
			}
			// 解析大配置返回航程信息
			Pattern pDetail = Pattern.compile("\\n");
			String[] strFlightDetail = pDetail.split(strbigReturn);
			for (int i = 0; i < strFlightDetail.length; i++) {
				// 乘机人姓名
				if (strFlightDetail[i].indexOf("NAME:") >= 0) {
					Pattern psttern = Pattern.compile("[N][A][M][E][:]");
					String[] strPassengerinfo = psttern
							.split(strFlightDetail[i].toString());
					if (strPassengerinfo.length == 2) {
						strPassengerName = strPassengerinfo[1].replace("NAME:",
								"").trim();
					}
				}
				// 航班信息
				if ((strFlightDetail[i].indexOf("EOTU") >= 0 || strFlightDetail[i]
						.indexOf("RVAL") >= 0)
						&& strFlightDetail[i].indexOf("FROM") >= 0) {
					Pattern pDetails = Pattern.compile("\\s{1,2}");
					String[] arrsegment = pDetails.split(strFlightDetail[i]);
					String strFlightinfo = "";

					if (arrsegment.length > 0) {
						if (strFlightDetail[i].indexOf("EOTU") >= 0) {
							strFlightinfo = arrsegment[10];
						} else if (strFlightDetail[i].indexOf("RVAL") >= 0) {
							strFlightinfo = arrsegment[9];
							if (listSegment.size() > 0) {
								break;
							}
						}

						String[] arrFlight = strFlightinfo.split("/");
						if (arrFlight.length == 4) {
							segmentinfo.setFlightnumber(arrFlight[0]);
							String strDeptTime = "2011-"
									+ ChangeDateModeToInt(arrFlight[1]
											.substring(2, 5)) + "-"
									+ arrFlight[1].substring(0, 2)
									+ " 00:00:00";
							String strArrTime = "2011-"
									+ ChangeDateModeToInt(arrFlight[1]
											.substring(2, 5)) + "-"
									+ arrFlight[1].substring(0, 2)
									+ " 00:00:00";
							segmentinfo
									.setDeparttime(dateToTimestamp(strDeptTime));
							segmentinfo
									.setArrivaltime(dateToTimestamp(strArrTime));
							segmentinfo.setAircomapnycode(arrFlight[0]
									.substring(0, 2));
							segmentinfo
									.setAircompanyname(getAirCompanyName(arrFlight[0]
											.substring(0, 2)));
							segmentinfo.setStartairport(arrFlight[3].substring(
									0, 3));
							segmentinfo.setEndairport(arrFlight[3].substring(3,
									6));
							segmentinfo.setCabincode(arrFlight[2]);
							segmentinfo.setAgentid(this.getLoginUser()
									.getAgentid());
							segmentinfo
									.setAirportfee(passenger.getAirportfee());
							segmentinfo.setFuelfee(passenger.getFuelprice());
							// 全价价格
							String strYPRICE = "";
							// 从黑屏中得到全价价格
							String strPriceinfo = getYPriceBycmd(segmentinfo
									.getStartairport(), segmentinfo
									.getEndairport(), segmentinfo
									.getAircomapnycode());
							// 解析Y舱价格
							Pattern patternprice = Pattern.compile(segmentinfo
									.getAircomapnycode()
									+ "/Y");
							// 以换行符将字符串拆分
							String[] strpriceinfoarr = patternprice
									.split(strPriceinfo);
							if (strpriceinfoarr.length >= 2) {
								String strPPricecabin = strpriceinfoarr[1]
										.toString();
								Pattern patcab = Pattern.compile("\\/");
								String[] strParr = patcab.split(strPPricecabin);
								String strTruePriceinfo = "";
								if (strParr.length >= 2) {
									strTruePriceinfo = strParr[1].toString()
											.trim();
									if (strTruePriceinfo.indexOf("=") >= 0) {
										Pattern patcabtemp = Pattern
												.compile("=");
										String[] strtempcab = patcabtemp
												.split(strTruePriceinfo);
										if (strtempcab.length == 2) {
											strYPRICE = strtempcab[0].trim();
										}
									} else {
										strYPRICE = strTruePriceinfo;
									}
								}
							}
							// 解析完毕
							if (!strYPRICE.equals("")) {
								try {
									float ddiscount = passenger.getPrice()
											/ Float.parseFloat(strYPRICE) * 100;
									float mdiscount = (float) Math
											.round(ddiscount / 10);
									segmentinfo
											.setDiscount(Float
													.parseFloat(formatMoney(mdiscount)));
									segmentinfo.setYprice(Float
											.parseFloat(strYPRICE));
								} catch (Exception ex) {
									segmentinfo.setPrice(listpass.get(0)
											.getPrice());
									segmentinfo.setDiscount(0.0f);
								}
							} else {
								String strwhere = "WHERE "
										+ Airbaseprice.COL_sairportcode + "='"
										+ segmentinfo.getStartairport()
										+ "' AND "
										+ Airbaseprice.COL_eairportcode + "='"
										+ segmentinfo.getEndairport()
										+ "' AND "
										+ Airbaseprice.COL_aircompanycode
										+ "='"
										+ segmentinfo.getAircomapnycode() + "'";
								List<Airbaseprice> listbaseprice = Server
										.getInstance().getAirService()
										.findAllAirbaseprice(strwhere, "", -1,
												0);
								if (listbaseprice.size() > 0) {
									try {
										float ddiscount = passenger.getPrice()
												/ listbaseprice.get(0)
														.getPrice() * 100;
										float mdiscount = (float) Math
												.round(ddiscount / 10);
										segmentinfo
												.setDiscount(Float
														.parseFloat(formatMoney(mdiscount)));
										segmentinfo.setYprice(Float
												.parseFloat(listbaseprice
														.get(0).getPrice()
														+ ""));
									} catch (Exception ex) {
										segmentinfo.setPrice(listpass.get(0)
												.getPrice());
										segmentinfo.setDiscount(0.0f);
									}
								}
							}

							listSegment.add(segmentinfo);
						}
					}

				}
				// 改签航班信息
				else if (strFlightDetail[i].indexOf("CKIN") >= 0) {
					Pattern pDetails = Pattern.compile("\\s{1,2}");
					String[] arrsegment = pDetails.split(strFlightDetail[i]);
					String strFlightinfo = "";
					if (arrsegment.length >= 7) {
						strFlightinfo = arrsegment[7];
						String[] arrFlight = strFlightinfo.split("/");
						if (arrFlight.length == 4) {
							segmentinfo.setFlightnumber(arrFlight[0]);
							String strDeptTime = "2011-"
									+ ChangeDateModeToInt(arrFlight[1]
											.substring(2, 5)) + "-"
									+ arrFlight[1].substring(0, 2)
									+ " 00:00:00";
							String strArrTime = "2011-"
									+ ChangeDateModeToInt(arrFlight[1]
											.substring(2, 5)) + "-"
									+ arrFlight[1].substring(0, 2)
									+ " 00:00:00";
							segmentinfo
									.setDeparttime(dateToTimestamp(strDeptTime));
							segmentinfo
									.setArrivaltime(dateToTimestamp(strArrTime));
							segmentinfo.setAircomapnycode(arrFlight[0]
									.substring(0, 2));
							segmentinfo
									.setAircompanyname(getAirCompanyName(arrFlight[0]
											.substring(0, 2)));
							segmentinfo.setStartairport(arrFlight[3].substring(
									0, 3));
							segmentinfo.setEndairport(arrFlight[3].substring(3,
									6));
							segmentinfo.setCabincode(arrFlight[2]);
							segmentinfo.setAgentid(this.getLoginUser()
									.getAgentid());
							segmentinfo
									.setAirportfee(passenger.getAirportfee());
							segmentinfo.setFuelfee(passenger.getFuelprice());
							// 全价价格
							String strYPRICE = "";
							// 从黑屏中得到全价价格
							String strPriceinfo = getYPriceBycmd(segmentinfo
									.getStartairport(), segmentinfo
									.getEndairport(), segmentinfo
									.getAircomapnycode());
							// 解析Y舱价格
							Pattern patternprice = Pattern.compile(segmentinfo
									.getAircomapnycode()
									+ "/Y");
							// 以换行符将字符串拆分
							String[] strpriceinfoarr = patternprice
									.split(strPriceinfo);
							if (strpriceinfoarr.length >= 2) {
								String strPPricecabin = strpriceinfoarr[1]
										.toString();
								Pattern patcab = Pattern.compile("\\/");
								String[] strParr = patcab.split(strPPricecabin);
								String strTruePriceinfo = "";
								if (strParr.length >= 2) {
									strTruePriceinfo = strParr[1].toString()
											.trim();
									if (strTruePriceinfo.indexOf("=") >= 0) {
										Pattern patcabtemp = Pattern
												.compile("=");
										String[] strtempcab = patcabtemp
												.split(strTruePriceinfo);
										if (strtempcab.length == 2) {
											strYPRICE = strtempcab[0].trim();
										}
									} else {
										strYPRICE = strTruePriceinfo;
									}
								}
							}
							// 解析完毕
							if (!strYPRICE.equals("")) {
								try {
									float ddiscount = passenger.getPrice()
											/ Float.parseFloat(strYPRICE) * 100;
									float mdiscount = (float) Math
											.round(ddiscount / 10);
									segmentinfo
											.setDiscount(Float
													.parseFloat(formatMoney(mdiscount)));
									segmentinfo.setYprice(Float
											.parseFloat(strYPRICE));
								} catch (Exception ex) {
									segmentinfo.setPrice(listpass.get(0)
											.getPrice());
									segmentinfo.setDiscount(0.0f);
								}
							} else {
								String strwhere = "WHERE "
										+ Airbaseprice.COL_sairportcode + "='"
										+ segmentinfo.getStartairport()
										+ "' AND "
										+ Airbaseprice.COL_eairportcode + "='"
										+ segmentinfo.getEndairport()
										+ "' AND "
										+ Airbaseprice.COL_aircompanycode
										+ "='"
										+ segmentinfo.getAircomapnycode() + "'";
								List<Airbaseprice> listbaseprice = Server
										.getInstance().getAirService()
										.findAllAirbaseprice(strwhere, "", -1,
												0);
								if (listbaseprice.size() > 0) {
									try {
										float ddiscount = passenger.getPrice()
												/ listbaseprice.get(0)
														.getPrice() * 100;
										float mdiscount = (float) Math
												.round(ddiscount / 10);
										segmentinfo
												.setDiscount(Float
														.parseFloat(formatMoney(mdiscount)));
										segmentinfo.setYprice(Float
												.parseFloat(listbaseprice
														.get(0).getPrice()
														+ ""));
									} catch (Exception ex) {
										segmentinfo.setPrice(listpass.get(0)
												.getPrice());
										segmentinfo.setDiscount(0.0f);
									}
								}
							}
							listSegment.add(segmentinfo);
						}
					}
				}

			}
			// 判断是否有航班信息，如果没有则使用DETR:TN/票号进行解析
			if (listSegment.size() == 0 && strsmallnopar.length() > 0) {
				Pattern pnoparm = Pattern.compile("\\n");
				String[] arrsegmentinfo = pnoparm.split(strsmallnopar);
				// System.out.println(arrsegmentinfo.length);
				String strEndairprot = "";
				for (int z = 0; z < arrsegmentinfo.length; z++) {
					if (arrsegmentinfo[z].indexOf("TO:") >= 0) {
						Pattern psegend = Pattern.compile("\\s{1,2}");
						String[] arrendairport = psegend
								.split(arrsegmentinfo[z]);
						if (strEndairprot.equals("")) {
							for (int w = 0; w < arrendairport.length; w++) {
								if (arrendairport[w].length() == 3
										&& arrendairport[w].indexOf("TO") < 0) {
									strEndairprot = arrendairport[w];
									break;

								}
							}
						}
					}
					segmentinfo.setEndairport(strEndairprot);
					// From信息
					if (arrsegmentinfo[z].indexOf("FM:") >= 0) {
						Pattern pseg = Pattern.compile("\\s{1,2}");
						String[] arrseinfo = pseg.split(arrsegmentinfo[z]);
						// System.out.println(arrseinfo[2]);
						segmentinfo
								.setFlightnumber(arrseinfo[2] + arrseinfo[4]);
						if (arrseinfo[1].indexOf("FM") >= 0) {
							segmentinfo.setStartairport(arrseinfo[1].replace(
									"FM:", "").replace("1", ""));
						}
						if (arrseinfo[6].length() == 5) {
							String strDeptTime = "2011-"
									+ ChangeDateModeToInt(arrseinfo[6]
											.substring(2, 5)) + "-"
									+ arrseinfo[6].substring(0, 2)
									+ " 00:00:00";
							String strArrTime = "2011-"
									+ ChangeDateModeToInt(arrseinfo[6]
											.substring(2, 5)) + "-"
									+ arrseinfo[6].substring(0, 2)
									+ " 00:00:00";
							segmentinfo
									.setDeparttime(dateToTimestamp(strDeptTime));
							segmentinfo
									.setArrivaltime(dateToTimestamp(strArrTime));
						}
						segmentinfo.setAircomapnycode(arrseinfo[2]);
						segmentinfo
								.setAircompanyname(getAirCompanyName(arrseinfo[2]));

						if (arrseinfo[9].length() > 1) {
							segmentinfo.setCabincode(arrseinfo[9].substring(0,
									1));
						} else if (arrseinfo[9].length() == 1) {
							segmentinfo.setCabincode(arrseinfo[9]);
						}

						segmentinfo
								.setAgentid(this.getLoginUser().getAgentid());
						segmentinfo.setAirportfee(passenger.getAirportfee());
						segmentinfo.setFuelfee(passenger.getFuelprice());
						// 全价价格
						String strYPRICE = "";
						// 从黑屏中得到全价价格
						String strPriceinfo = getYPriceBycmd(segmentinfo
								.getStartairport(),
								segmentinfo.getEndairport(), segmentinfo
										.getAircomapnycode());
						// 解析Y舱价格
						Pattern patternprice = Pattern.compile(segmentinfo
								.getAircomapnycode()
								+ "/Y");
						// 以换行符将字符串拆分
						String[] strpriceinfoarr = patternprice
								.split(strPriceinfo);
						if (strpriceinfoarr.length >= 2) {
							String strPPricecabin = strpriceinfoarr[1]
									.toString();
							Pattern patcab = Pattern.compile("\\/");
							String[] strParr = patcab.split(strPPricecabin);
							String strTruePriceinfo = "";
							if (strParr.length >= 2) {
								strTruePriceinfo = strParr[1].toString().trim();
								if (strTruePriceinfo.indexOf("=") >= 0) {
									Pattern patcabtemp = Pattern.compile("=");
									String[] strtempcab = patcabtemp
											.split(strTruePriceinfo);
									if (strtempcab.length == 2) {
										strYPRICE = strtempcab[0].trim();
									}
								} else {
									strYPRICE = strTruePriceinfo;
								}
							}
						}
						// 解析完毕
						if (!strYPRICE.equals("")) {
							try {
								float ddiscount = passenger.getPrice()
										/ Float.parseFloat(strYPRICE) * 100;
								float mdiscount = (float) Math
										.round(ddiscount / 10);
								segmentinfo.setDiscount(Float
										.parseFloat(formatMoney(mdiscount)));
								segmentinfo.setYprice(Float
										.parseFloat(strYPRICE));
							} catch (Exception ex) {
								segmentinfo
										.setPrice(listpass.get(0).getPrice());
								segmentinfo.setDiscount(0.0f);
							}
						} else {
							String strwhere = "WHERE "
									+ Airbaseprice.COL_sairportcode + "='"
									+ segmentinfo.getStartairport() + "' AND "
									+ Airbaseprice.COL_eairportcode + "='"
									+ segmentinfo.getEndairport() + "' AND "
									+ Airbaseprice.COL_aircompanycode + "='"
									+ segmentinfo.getAircomapnycode() + "'";
							List<Airbaseprice> listbaseprice = Server
									.getInstance().getAirService()
									.findAllAirbaseprice(strwhere, "", -1, 0);
							if (listbaseprice.size() > 0) {
								try {
									float ddiscount = passenger.getPrice()
											/ listbaseprice.get(0).getPrice()
											* 100;
									float mdiscount = (float) Math
											.round(ddiscount / 10);
									segmentinfo
											.setDiscount(Float
													.parseFloat(formatMoney(mdiscount)));
									segmentinfo.setYprice(Float
											.parseFloat(listbaseprice.get(0)
													.getPrice()
													+ ""));
								} catch (Exception ex) {
									segmentinfo.setPrice(listpass.get(0)
											.getPrice());
									segmentinfo.setDiscount(0.0f);
								}
							}
						}
						listSegment.add(segmentinfo);
					}
				}
			}
		} catch (Exception ex) {

		}

		// 判断是否是升舱补差
		Pattern pnoparm = Pattern.compile("\\n");
		String[] arrsegmentinfo = pnoparm.split(strsmallnopar);
		for (int z = 0; z < arrsegmentinfo.length; z++) {
			// 是否是升舱换开票
			if (arrsegmentinfo[z].indexOf("EXCH:") >= 0) {
				String[] strexch = arrsegmentinfo[z].split(":");
				if (strexch.length >= 2) {
					strExchOldOrder = strexch[1].split("\\s{1,}")[1];
					if (strExchOldOrder.trim().length() == 14
							&& strExchOldOrder.trim().indexOf("-") >= 0) {
						isexchorder = true;
					}
				}
			}
			if (isexchorder || strsmallReturn.indexOf("升舱补差") >= 0) {
				for (int y = 0; y < listPassenger.size(); y++) {
					listPassenger.get(y).setAirportfee(0f);
					listPassenger.get(y).setFuelprice(0f);
					listPassenger.get(y).setPrice(excprice);
				}
				for (int w = 0; w < listSegment.size(); w++) {
					listSegment.get(w).setPrice(0f);
					listSegment.get(w).setFuelfee(0f);
					listSegment.get(w).setAirportfee(excprice);
				}
			}
		}
		if (s_orderstatuspnr.equals("11") || s_orderstatuspnr.equals("12")) {
			ServletActionContext.getRequest().setAttribute("isTuiFei", true);
		}
		ActionContext.getContext().getSession().put("pnrsegment", listSegment);
		ActionContext.getContext().getSession().put("pnrpassenger",
				listPassenger);
		// 加载联系人信用卡信息
		creditlist = Server.getInstance().getMemberService().findAllCreditcard(
				" WHERE 1=1 AND " + Creditcard.COL_customeruserid + " = "
						+ linkid, "", -1, 0);
		String ticketwhere = " WHERE 1=1 ";
		listtickettype = Server.getInstance().getMemberService()
				.findAllTickettype(ticketwhere, "", -1, 0);
		// System.out.println(creditlist.size());
		return "importpnr";
	}

	public String topnrnav() {
		return "topnrnav";
	}

	/**
	 * 暂不能出票订单”、“取消订单”如订单中航班时间小于当前时间，软件自动关闭该订单
	 */
	public void autoCloseOrder() throws Exception {
		// 取出咱不能出票订单和取消订单
		String strwhere = " where C_ORDERID in(select ID from T_ORDERINFO where C_ORDERSTATUS=6 or C_ORDERSTATUS=16)";
		List<Segmentinfo> listcloseorder = Server.getInstance().getAirService()
				.findAllSegmentinfo(strwhere, "", -1, 0);
		if (listcloseorder.size() > 0) {
			for (int i = 0; i < listcloseorder.size(); i++) {
				Timestamp tmnowtime = new Timestamp(System.currentTimeMillis());
				String strDepTime = formatTimestamp(listcloseorder.get(i)
						.getDeparttime());
				Timestamp tmRTTime = dateToTimestamp(strDepTime);
				Timestamp tmNowTime = dateToTimestamp(tmnowtime.toString());
				// 当前的时间超过了航班起飞时间，则将订单状态改为订单关闭
				if ((tmNowTime.getTime() - tmRTTime.getTime()) > 0) {
					orderinfo = Server.getInstance().getAirService()
							.findOrderinfo(listcloseorder.get(i).getOrderid());
					orderinfo.setOrderstatus(10);
					Server.getInstance().getAirService().updateOrderinfo(
							orderinfo);
				}
			}
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append("1");
		out.print(sb);
		out.flush();
		out.close();
	}

	public String getexcorderid(long id) {
		String strId = "";
		List<Orderinfo> listexorderinfo = Server.getInstance().getAirService()
				.findAllOrderinfo(
						" where " + Orderinfo.COL_shengcangorderid + "=" + id,
						"", -1, 0);
		if (listexorderinfo.size() > 0) {
			strId = listexorderinfo.get(0).getOrdernumber();
		}

		return strId;
	}

	public String getOrdernumberbyid(long id) {
		String strId = "";
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(id);
		strId = orderinfo.getOrdernumber();
		return strId;
	}

	public Orderinforc getOrderrcByOrderIdAndOrerstate(long orderid, int state) {
		Orderinforc rc = new Orderinforc();
		String where = " WHERE C_ORDERINFOID =" + orderid + " AND C_STATE= "
				+ state;
		List<Orderinforc> orderinforclist = Server.getInstance()
				.getAirService().findAllOrderinforc(where, "", -1, 0);
		if (orderinforclist.size() > 0) {
			rc = orderinforclist.get(0);
		}
		return rc;
	}

	/**
	 * @param id
	 * @return 查询PNR
	 */
	public String getpnr(long id) {// 取订单PNR
		Orderinfo info = Server.getInstance().getAirService().findOrderinfo(id);
		String pnr = "";
		String littlepnr = info.getPnr();
		if (littlepnr != null && littlepnr.trim().length() > 0) {
			littlepnr += "(小)";
		} else {
			littlepnr = "";
		}
		String bigpnr = info.getBigpnr();
		if (bigpnr != null && bigpnr.trim().length() > 0) {
			bigpnr += "<br>(大)";
		} else {
			bigpnr = "";
		}
		return littlepnr + bigpnr;
	}

	public String getAgentNameOfOrder(Orderinfo order) {
		return new AirreportAction().getAgentNameOfOrder(order);
	}

	/**
	 * 返回订单信息表对象
	 */
	public Object getModel() {
		return orderinfo;
	}

	public List<Orderinfo> getListOrderinfo() {
		return listOrderinfo;
	}

	public void setListOrderinfo(List<Orderinfo> listOrderinfo) {
		this.listOrderinfo = listOrderinfo;
	}

	public Orderinfo getOrderinfo() {
		return orderinfo;
	}

	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}

	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
	}

	public int[] getSelectid() {
		return selectid;
	}

	public void setSelectid(int[] selectid) {
		this.selectid = selectid;
	}

	public String getH_ptype() {
		return h_ptype;
	}

	public void setH_ptype(String h_ptype) {
		this.h_ptype = h_ptype;
	}

	public String getH_name() {
		return h_name;
	}

	public void setH_name(String h_name) {
		this.h_name = h_name;
	}

	public String getH_idtype() {
		return h_idtype;
	}

	public void setH_idtype(String h_idtype) {
		this.h_idtype = h_idtype;
	}

	public String getH_idnumber() {
		return h_idnumber;
	}

	public void setH_idnumber(String h_idnumber) {
		this.h_idnumber = h_idnumber;
	}

	public List<Passenger> getListPassenger() {
		return listPassenger;
	}

	public void setListPassenger(List<Passenger> listPassenger) {
		this.listPassenger = listPassenger;
	}

	public String getStrTravelHtml() {
		return strTravelHtml;
	}

	public void setStrTravelHtml(String strTravelHtml) {
		this.strTravelHtml = strTravelHtml;
	}

	public List<Segmentinfo> getListSegmentinfo() {
		return listSegment;
	}

	public void setSegmentinfo(List<Segmentinfo> listSegment) {
		this.listSegment = listSegment;
	}

	public String getStrTotalPriceOne() {
		return strTotalPriceOne;
	}

	public void setStrTotalPriceOne(String strTotalPriceOne) {
		this.strTotalPriceOne = strTotalPriceOne;
	}

	public String getStrTotalPriceTwo() {
		return strTotalPriceTwo;
	}

	public void setStrTotalPriceTwo(String strTotalPriceTwo) {
		this.strTotalPriceTwo = strTotalPriceTwo;
	}

	public int getS_orderstatus() {
		return s_orderstatus;
	}

	public void setS_orderstatus(int s_orderstatus) {
		this.s_orderstatus = s_orderstatus;
	}

	public List<Cityairport> getListCityairport() {
		return listCityairport;
	}

	public void setListCityairport(List<Cityairport> listCityairport) {
		this.listCityairport = listCityairport;
	}

	public List<Segmentinfo> getListSegment() {
		return listSegment;
	}

	public void setListSegment(List<Segmentinfo> listSegment) {
		this.listSegment = listSegment;
	}

	public Customeragent getListAgent() {
		return listAgent;
	}

	public void setListAgent(Customeragent listAgent) {
		this.listAgent = listAgent;
	}

	public Customeragent getListGongAgent() {
		return listGongAgent;
	}

	public void setListGongAgent(Customeragent listGongAgent) {
		this.listGongAgent = listGongAgent;
	}

	public Orderinfo getOrderinfo2() {
		return orderinfo2;
	}

	public void setOrderinfo2(Orderinfo orderinfo2) {
		this.orderinfo2 = orderinfo2;
	}

	public Long getIdtemp() {
		return idtemp;
	}

	public void setIdtemp(Long idtemp) {
		this.idtemp = idtemp;
	}

	public String getForwork() {
		return forwork;
	}

	public void setForwork(String forwork) {
		this.forwork = forwork;
	}

	public String getH_insurance() {
		return h_insurance;
	}

	public void setH_insurance(String h_insurance) {
		this.h_insurance = h_insurance;
	}

	public String getH_savepasenger() {
		return h_savepasenger;
	}

	public void setH_savepasenger(String h_savepasenger) {
		this.h_savepasenger = h_savepasenger;
	}

	public List<Segmentinfo> getListSegment2() {
		return listSegment2;
	}

	public void setListSegment2(List<Segmentinfo> listSegment2) {
		this.listSegment2 = listSegment2;
	}

	public long getTemporderuserid() {
		return temporderuserid;
	}

	public void setTemporderuserid(long temporderuserid) {
		this.temporderuserid = temporderuserid;
	}

	public Long getS_ordertype() {
		return s_ordertype;
	}

	public void setS_ordertype(Long s_ordertype) {
		this.s_ordertype = s_ordertype;
	}

	public int getTy() {
		return ty;
	}

	public void setTy(int ty) {
		this.ty = ty;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String getH_prestarttime() {
		return h_prestarttime;
	}

	public void setH_prestarttime(String h_prestarttime) {
		this.h_prestarttime = h_prestarttime;
	}

	public String getH_preendtime() {
		return h_preendtime;
	}

	public void setH_preendtime(String h_preendtime) {
		this.h_preendtime = h_preendtime;
	}

	public String getStrPNR() {
		return strPNR;
	}

	public void setStrPNR(String strPNR) {
		this.strPNR = strPNR;
	}

	public String getStrNMString() {
		return strNMString;
	}

	public void setStrNMString(String strNMString) {
		this.strNMString = strNMString;
	}

	public String getStrSSRString() {
		return strSSRString;
	}

	public void setStrSSRString(String strSSRString) {
		this.strSSRString = strSSRString;
	}

	public String getStrFlightString() {
		return strFlightString;
	}

	public void setStrFlightString(String strFlightString) {
		this.strFlightString = strFlightString;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getStrTicketPrice() {
		return strTicketPrice;
	}

	public void setStrTicketPrice(String strTicketPrice) {
		this.strTicketPrice = strTicketPrice;
	}

	public String getStrTAXPrice() {
		return strTAXPrice;
	}

	public void setStrTAXPrice(String strTAXPrice) {
		this.strTAXPrice = strTAXPrice;
	}

	public String getStrYQPrice() {
		return strYQPrice;
	}

	public void setStrYQPrice(String strYQPrice) {
		this.strYQPrice = strYQPrice;
	}

	public String getStrTotalPrice() {
		return strTotalPrice;
	}

	public void setStrTotalPrice(String strTotalPrice) {
		this.strTotalPrice = strTotalPrice;
	}

	public String getTicketprice() {
		return ticketprice;
	}

	public void setTicketprice(String ticketprice) {
		this.ticketprice = ticketprice;
	}

	public String getTaxprice() {
		return taxprice;
	}

	public void setTaxprice(String taxprice) {
		this.taxprice = taxprice;
	}

	public String getYqprice() {
		return yqprice;
	}

	public void setYqprice(String yqprice) {
		this.yqprice = yqprice;
	}

	public List<Segmentinfo> getListseg() {
		return listseg;
	}

	public void setListseg(List<Segmentinfo> listseg) {
		this.listseg = listseg;
	}

	public List<Passenger> getListpass() {
		return listpass;
	}

	public void setListpass(List<Passenger> listpass) {
		this.listpass = listpass;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getS_orderstatuspnr() {
		return s_orderstatuspnr;
	}

	public void setS_orderstatuspnr(String s_orderstatuspnr) {
		this.s_orderstatuspnr = s_orderstatuspnr;
	}

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public String getS_hidflag() {
		return s_hidflag;
	}

	public void setS_hidflag(String s_hidflag) {
		this.s_hidflag = s_hidflag;
	}

	public String getS_pnrdetails() {
		return s_pnrdetails;
	}

	public void setS_pnrdetails(String s_pnrdetails) {
		this.s_pnrdetails = s_pnrdetails;
	}

	public String getStrQueryType() {
		return strQueryType;
	}

	public void setStrQueryType(String strQueryType) {
		this.strQueryType = strQueryType;
	}

	public List<Scang> getListScang() {
		return listScang;
	}

	public void setListScang(List<Scang> listScang) {
		this.listScang = listScang;
	}

	public Scang getScang() {
		return scang;
	}

	public void setScang(Scang scang) {
		this.scang = scang;
	}

	public long getScangid() {
		return scangid;
	}

	public void setScangid(long scangid) {
		this.scangid = scangid;
	}

	public long getOrderinfoid() {
		return orderinfoid;
	}

	public void setOrderinfoid(long orderinfoid) {
		this.orderinfoid = orderinfoid;
	}

	public long getAngenid() {
		return angenid;
	}

	public void setAngenid(long angenid) {
		this.angenid = angenid;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getTui() {
		return tui;
	}

	public void setTui(String tui) {
		this.tui = tui;
	}

	public String getStrTuiOrderID() {
		return strTuiOrderID;
	}

	public void setStrTuiOrderID(String strTuiOrderID) {
		this.strTuiOrderID = strTuiOrderID;
	}

	public String getPassid() {
		return passid;
	}

	public void setPassid(String passid) {
		this.passid = passid;
	}

	public int getTyp() {
		return typ;
	}

	public void setTyp(int typ) {
		this.typ = typ;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getStrSepPNR() {
		return strSepPNR;
	}

	public void setStrSepPNR(String strSepPNR) {
		this.strSepPNR = strSepPNR;
	}

	public String getStrXuNumber() {
		return strXuNumber;
	}

	public void setStrXuNumber(String strXuNumber) {
		this.strXuNumber = strXuNumber;
	}

	public String getS_newpassid() {
		return s_newpassid;
	}

	public void setS_newpassid(String s_newpassid) {
		this.s_newpassid = s_newpassid;
	}

	public Orderinforc getOrderinforc() {
		return orderinforc;
	}

	public void setOrderinforc(Orderinforc orderinforc) {
		this.orderinforc = orderinforc;
	}

	public List<Passenger> getListPassenger2() {
		return listPassenger2;
	}

	public void setListPassenger2(List<Passenger> listPassenger2) {
		this.listPassenger2 = listPassenger2;
	}

	public long getTui_state() {
		return tui_state;
	}

	public void setTui_state(long tui_state) {
		this.tui_state = tui_state;
	}

	public long getTui_iscabinsite() {
		return tui_iscabinsite;
	}

	public void setTui_iscabinsite(long tui_iscabinsite) {
		this.tui_iscabinsite = tui_iscabinsite;
	}

	public String getTui_tuifeidesc() {
		return tui_tuifeidesc;
	}

	public void setTui_tuifeidesc(String tui_tuifeidesc) {
		this.tui_tuifeidesc = tui_tuifeidesc;
	}

	public String getStrSenderID() {
		return strSenderID;
	}

	public void setStrSenderID(String strSenderID) {
		this.strSenderID = strSenderID;
	}

	public String getStrNewOrderID() {
		return strNewOrderID;
	}

	public void setStrNewOrderID(String strNewOrderID) {
		this.strNewOrderID = strNewOrderID;
	}

	public String getChangeflight() {
		return changeflight;
	}

	public void setChangeflight(String changeflight) {
		this.changeflight = changeflight;
	}

	public String getChangedate() {
		return changedate;
	}

	public void setChangedate(String changedate) {
		this.changedate = changedate;
	}

	public String getChangecabin() {
		return changecabin;
	}

	public void setChangecabin(String changecabin) {
		this.changecabin = changecabin;
	}

	public String getChangepnr() {
		return changepnr;
	}

	public void setChangepnr(String changepnr) {
		this.changepnr = changepnr;
	}

	public long getS_busystatus() {
		return s_busystatus;
	}

	public void setS_busystatus(long s_busystatus) {
		this.s_busystatus = s_busystatus;
	}

	public String getS_paystatus() {
		return s_paystatus;
	}

	public void setS_paystatus(String s_paystatus) {
		this.s_paystatus = s_paystatus;
	}

	public int getS_send() {
		return s_send;
	}

	public void setS_send(int s_send) {
		this.s_send = s_send;
	}

	public long getS_employeeid() {
		return s_employeeid;
	}

	public void setS_employeeid(long s_employeeid) {
		this.s_employeeid = s_employeeid;
	}

	public List<Customeruser> getListemployees() {
		return listemployees;
	}

	public void setListemployees(List<Customeruser> listemployees) {
		this.listemployees = listemployees;
	}

	public String getStrSenderDate() {
		return strSenderDate;
	}

	public void setStrSenderDate(String strSenderDate) {
		this.strSenderDate = strSenderDate;
	}

	public String getS_bigpnr() {
		return s_bigpnr;
	}

	public void setS_bigpnr(String s_bigpnr) {
		this.s_bigpnr = s_bigpnr;
	}

	public int getEtermtype() {
		return etermtype;
	}

	public void setEtermtype(int etermtype) {
		this.etermtype = etermtype;
	}

	public String getStrPassengers() {
		return strPassengers;
	}

	public void setStrPassengers(String strPassengers) {
		this.strPassengers = strPassengers;
	}

	public String getTuigaiindex() {
		return tuigaiindex;
	}

	public void setTuigaiindex(String tuigaiindex) {
		this.tuigaiindex = tuigaiindex;
	}

	public String getPassids() {
		return passids;
	}

	public void setPassids(String passids) {
		this.passids = passids;
	}

	public String getS_ticketnumber() {
		return s_ticketnumber;
	}

	public void setS_ticketnumber(String s_ticketnumber) {
		this.s_ticketnumber = s_ticketnumber;
	}

	public String getS_rpnumber() {
		return s_rpnumber;
	}

	public void setS_rpnumber(String s_rpnumber) {
		this.s_rpnumber = s_rpnumber;
	}

	public String getS_eidesc() {
		return s_eidesc;
	}

	public void setS_eidesc(String s_eidesc) {
		this.s_eidesc = s_eidesc;
	}

	public String getTicketnumberarr() {
		return ticketnumberarr;
	}

	public void setTicketnumberarr(String ticketnumberarr) {
		this.ticketnumberarr = ticketnumberarr;
	}

	public String getRpnumberarr() {
		return rpnumberarr;
	}

	public void setRpnumberarr(String rpnumberarr) {
		this.rpnumberarr = rpnumberarr;
	}

	public String getEiarr() {
		return eiarr;
	}

	public void setEiarr(String eiarr) {
		this.eiarr = eiarr;
	}

	public String getStrTNumber() {
		return strTNumber;
	}

	public void setStrTNumber(String strTNumber) {
		this.strTNumber = strTNumber;
	}

	public String getStrRPNumber() {
		return strRPNumber;
	}

	public void setStrRPNumber(String strRPNumber) {
		this.strRPNumber = strRPNumber;
	}

	public String getS_peisongren() {
		return s_peisongren;
	}

	public void setS_peisongren(String s_peisongren) {
		this.s_peisongren = s_peisongren;
	}

	public String getS_peisongsdate() {
		return s_peisongsdate;
	}

	public void setS_peisongsdate(String s_peisongsdate) {
		this.s_peisongsdate = s_peisongsdate;
	}

	public String getS_peisongedate() {
		return s_peisongedate;
	}

	public void setS_peisongedate(String s_peisongedate) {
		this.s_peisongedate = s_peisongedate;
	}

	public List<Customeruser> getListSender() {
		return listSender;
	}

	public void setListSender(List<Customeruser> listSender) {
		this.listSender = listSender;
	}

	public String getS_memo() {
		return s_memo;
	}

	public void setS_memo(String s_memo) {
		this.s_memo = s_memo;
	}

	public void setPaymethod(int paymethod) {
		this.paymethod = paymethod;
	}

	public int getPaymethod() {
		return paymethod;
	}

	public void setS_paymethods(int s_paymethods) {
		this.s_paymethods = s_paymethods;
	}

	public void setS_money(int s_money) {
		this.s_money = s_money;
	}

	public int getS_money() {
		return s_money;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStrNewTicketNum() {
		return strNewTicketNum;
	}

	public void setStrNewTicketNum(String strNewTicketNum) {
		this.strNewTicketNum = strNewTicketNum;
	}

	public int getS_insurance() {
		return s_insurance;
	}

	public void setS_insurance(int s_insurance) {
		this.s_insurance = s_insurance;
	}

	public String getStrfenliType() {
		return strfenliType;
	}

	public void setStrfenliType(String strfenliType) {
		this.strfenliType = strfenliType;
	}

	public String getStrNewPnr() {
		return strNewPnr;
	}

	public void setStrNewPnr(String strNewPnr) {
		this.strNewPnr = strNewPnr;
	}

	public String getStrNewBigPnr() {
		return strNewBigPnr;
	}

	public void setStrNewBigPnr(String strNewBigPnr) {
		this.strNewBigPnr = strNewBigPnr;
	}

	public String getStrNewTicNum() {
		return strNewTicNum;
	}

	public void setStrNewTicNum(String strNewTicNum) {
		this.strNewTicNum = strNewTicNum;
	}

	public List<Orderinforc> getListorderinforc() {
		return listorderinforc;
	}

	public void setListorderinforc(List<Orderinforc> listorderinforc) {
		this.listorderinforc = listorderinforc;
	}

	public String getCustomerNameById(long cid) {
		String strMemberName = "";
		try {
			if (Server.getInstance().getMemberService().findCustomeruser(cid) != null) {
				strMemberName = Server.getInstance().getMemberService()
						.findCustomeruser(cid).getMembername();
			}
		} catch (Exception ex) {
			strMemberName = "";
		}

		return strMemberName;

	}

	public String getS_contactname() {
		return s_contactname;
	}

	public void setS_contactname(String s_contactname) {
		this.s_contactname = s_contactname;
	}

	public String getS_bookername() {
		return s_bookername;
	}

	public void setS_bookername(String s_bookername) {
		this.s_bookername = s_bookername;
	}

	public String getS_chupiaoname() {
		return s_chupiaoname;
	}

	public void setS_chupiaoname(String s_chupiaoname) {
		this.s_chupiaoname = s_chupiaoname;
	}

	public String getS_feipiaoshenqingren() {
		return s_feipiaoshenqingren;
	}

	public void setS_feipiaoshenqingren(String s_feipiaoshenqingren) {
		this.s_feipiaoshenqingren = s_feipiaoshenqingren;
	}

	public String getS_feipiaoshenqingsdate() {
		return s_feipiaoshenqingsdate;
	}

	public void setS_feipiaoshenqingsdate(String s_feipiaoshenqingsdate) {
		this.s_feipiaoshenqingsdate = s_feipiaoshenqingsdate;
	}

	public String getS_feipiaoshenqingedate() {
		return s_feipiaoshenqingedate;
	}

	public void setS_feipiaoshenqingedate(String s_feipiaoshenqingedate) {
		this.s_feipiaoshenqingedate = s_feipiaoshenqingedate;
	}

	public String getS_feipiaoshenhesdate() {
		return s_feipiaoshenhesdate;
	}

	public void setS_feipiaoshenhesdate(String s_feipiaoshenhesdate) {
		this.s_feipiaoshenhesdate = s_feipiaoshenhesdate;
	}

	public String getS_feipiaoshenheedate() {
		return s_feipiaoshenheedate;
	}

	public void setS_feipiaoshenheedate(String s_feipiaoshenheedate) {
		this.s_feipiaoshenheedate = s_feipiaoshenheedate;
	}

	public String getS_feipiaoshenheren() {
		return s_feipiaoshenheren;
	}

	public void setS_feipiaoshenheren(String s_feipiaoshenheren) {
		this.s_feipiaoshenheren = s_feipiaoshenheren;
	}

	public String getS_tuipiaoshenqingren() {
		return s_tuipiaoshenqingren;
	}

	public void setS_tuipiaoshenqingren(String s_tuipiaoshenqingren) {
		this.s_tuipiaoshenqingren = s_tuipiaoshenqingren;
	}

	public String getS_gaiqianshenqingsdate() {
		return s_gaiqianshenqingsdate;
	}

	public void setS_gaiqianshenqingsdate(String s_gaiqianshenqingsdate) {
		this.s_gaiqianshenqingsdate = s_gaiqianshenqingsdate;
	}

	public String getS_gaiqianshenqingedate() {
		return s_gaiqianshenqingedate;
	}

	public void setS_gaiqianshenqingedate(String s_gaiqianshenqingedate) {
		this.s_gaiqianshenqingedate = s_gaiqianshenqingedate;
	}

	public String getS_tuipiaoshenheren() {
		return s_tuipiaoshenheren;
	}

	public void setS_tuipiaoshenheren(String s_tuipiaoshenheren) {
		this.s_tuipiaoshenheren = s_tuipiaoshenheren;
	}

	public String getS_tuipiaoshenhesdate() {
		return s_tuipiaoshenhesdate;
	}

	public void setS_tuipiaoshenhesdate(String s_tuipiaoshenhesdate) {
		this.s_tuipiaoshenhesdate = s_tuipiaoshenhesdate;
	}

	public String getS_tuipiaoshenheedate() {
		return s_tuipiaoshenheedate;
	}

	public void setS_tuipiaoshenheedate(String s_tuipiaoshenheedate) {
		this.s_tuipiaoshenheedate = s_tuipiaoshenheedate;
	}

	public String getS_gaiqianshenqingren() {
		return s_gaiqianshenqingren;
	}

	public void setS_gaiqianshenqingren(String s_gaiqianshenqingren) {
		this.s_gaiqianshenqingren = s_gaiqianshenqingren;
	}

	public String getS_gaiqianshenheren() {
		return s_gaiqianshenheren;
	}

	public void setS_gaiqianshenheren(String s_gaiqianshenheren) {
		this.s_gaiqianshenheren = s_gaiqianshenheren;
	}

	public String getS_gaiqianshehesdate() {
		return s_gaiqianshehesdate;
	}

	public void setS_gaiqianshehesdate(String s_gaiqianshehesdate) {
		this.s_gaiqianshehesdate = s_gaiqianshehesdate;
	}

	public String getS_gaiqiansheheedate() {
		return s_gaiqiansheheedate;
	}

	public void setS_gaiqiansheheedate(String s_gaiqiansheheedate) {
		this.s_gaiqiansheheedate = s_gaiqiansheheedate;
	}

	public String getS_shengcangshenqingren() {
		return s_shengcangshenqingren;
	}

	public void setS_shengcangshenqingren(String s_shengcangshenqingren) {
		this.s_shengcangshenqingren = s_shengcangshenqingren;
	}

	public String getS_shengcangshenqingsdate() {
		return s_shengcangshenqingsdate;
	}

	public void setS_shengcangshenqingsdate(String s_shengcangshenqingsdate) {
		this.s_shengcangshenqingsdate = s_shengcangshenqingsdate;
	}

	public String getS_shengcangshenqingedate() {
		return s_shengcangshenqingedate;
	}

	public void setS_shengcangshenqingedate(String s_shengcangshenqingedate) {
		this.s_shengcangshenqingedate = s_shengcangshenqingedate;
	}

	public String getS_shengcangshenheren() {
		return s_shengcangshenheren;
	}

	public void setS_shengcangshenheren(String s_shengcangshenheren) {
		this.s_shengcangshenheren = s_shengcangshenheren;
	}

	public String getS_shengcangshenhesdate() {
		return s_shengcangshenhesdate;
	}

	public void setS_shengcangshenhesdate(String s_shengcangshenhesdate) {
		this.s_shengcangshenhesdate = s_shengcangshenhesdate;
	}

	public String getS_shengcangshenheedate() {
		return s_shengcangshenheedate;
	}

	public void setS_shengcangshenheedate(String s_shengcangshenheedate) {
		this.s_shengcangshenheedate = s_shengcangshenheedate;
	}

	public String getStrTuikuanDesc() {
		return strTuikuanDesc;
	}

	public void setStrTuikuanDesc(String strTuikuanDesc) {
		this.strTuikuanDesc = strTuikuanDesc;
	}

	public int getS_paymethods() {
		return s_paymethods;
	}

	/**
	 * 升舱换开 ajax 验证
	 * 
	 * @throws IOException
	 */
	public void ajaxValidateSCHK() throws IOException {
		List<Passenger> passenger = null;
		String returmst = "true";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String ordernumber = request.getParameter("ordernum");
		String newpnr = request.getParameter("orderpnr");
		String ticketnum = request.getParameter("orderticket");
		String oldid = request.getParameter("oldorderid");
		String where = "";
		if (ordernumber != null && !ordernumber.trim().equals("")) {
			where = " WHERE " + Orderinfo.COL_ordernumber + "='" + ordernumber
					+ "'";
			List<Orderinfo> orders = Server.getInstance().getAirService()
					.findAllOrderinfo(where, "", -1, 0);
			if (orders.size() == 0) {
				returmst = "您所输入的订单号不存在！";
			} else {
				String passwhere = " WHERE " + Passenger.COL_orderid + "= "
						+ orders.get(0).getId() + "";
				passenger = Server.getInstance().getAirService()
						.findAllPassenger(passwhere, "", -1, 0);
			}
		}
		if (returmst.equals("true") && newpnr != null
				&& !newpnr.trim().equals("")) {
			where = " WHERE " + Orderinfo.COL_pnr + "='" + newpnr
					+ "' OR C_BIGPNR ='" + newpnr + "'";
			List<Orderinfo> orders = Server.getInstance().getAirService()
					.findAllOrderinfo(where, "", -1, 0);
			if (orders.size() == 0) {
				returmst = "您所输入的PNR订单不存在！";
			} else {
				String passwhere = " WHERE " + Passenger.COL_orderid + "= "
						+ orders.get(0).getId() + "";
				passenger = Server.getInstance().getAirService()
						.findAllPassenger(passwhere, "", -1, 0);
			}
		}
		if (returmst.equals("true") && ticketnum != null
				&& !ticketnum.trim().equals("")) {
			where = " WHERE " + Passenger.COL_ticketnum + "='" + ticketnum
					+ "'";
			List<Passenger> orders = Server.getInstance().getAirService()
					.findAllPassenger(where, "", -1, 0);
			if (orders.size() == 0) {
				returmst = "您所输入的票号不存在！";
			} else {
				passenger = orders;
			}
		}
		if (returmst.equals("true")) {
			if (ordernumber != null && !ordernumber.trim().equals("")
					&& newpnr != null && !newpnr.trim().equals("")) {
				where = " WHERE " + Orderinfo.COL_pnr + "='" + newpnr
						+ "' AND " + Orderinfo.COL_ordernumber + "='"
						+ ordernumber + "'";
				List<Orderinfo> orders = Server.getInstance().getAirService()
						.findAllOrderinfo(where, "", -1, 0);
				if (orders.size() == 0) {
					returmst = "您所输入的订单号和PNR不匹配！";
				} else {
					String passwhere = " WHERE " + Passenger.COL_orderid + "= "
							+ orders.get(0).getId() + "";
					passenger = Server.getInstance().getAirService()
							.findAllPassenger(passwhere, "", -1, 0);
				}
			}
		}
		if (returmst.equals("true")) {
			if (passenger != null) {
				String oldpasswhere = " WHERE " + Passenger.COL_orderid + "= "
						+ oldid + "";
				List<Passenger> oldpassenger = Server.getInstance()
						.getAirService().findAllPassenger(oldpasswhere, "", -1,
								0);
				if (oldpassenger.size() != passenger.size()) {
					returmst = "新订单与原订单乘机人信息不一致，请检查新订单乘机人姓名和证件号！";
				} else {

					for (Passenger oldpass : oldpassenger) {
						boolean resutl = false;
						for (Passenger newpass : passenger) {
							if (oldpass.getName().equals(newpass.getName())
									&& oldpass.getIdnumber().equals(
											newpass.getIdnumber())) {
								resutl = true;
								break;
							}
						}
						if (!resutl) {
							returmst = "新订单与原订单乘机人信息不一致，请检查新订单乘机人姓名和证件号！";
							break;
						}
					}
				}

			} else {
				returmst = "系统未查出匹配信息的订单！";
			}
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(returmst);
		out.flush();
		out.close();
	}

	public static String getPayMethodStr(int paymethod) {
		switch (paymethod) {
		case 1:
			return "在线支付";
		case 2:
			return "门市付款";
		case 3:
			return "票到付款";
		case 4:
			return "无卡支付";
		case 5:
			return "客户挂账";
		case 6:
			return "柜台现付";
		case 7:
			return "个人挂账";
		case 8:
			return "内部结算";// 老朱新添
		case 9:
			return "同行业务";
		}
		return "";

	}

	public static String getFkmethodstr(int state) {
		switch (state) {
		case 0:
			return "未收银";
		case 1:
			return "现金";
		case 2:
			return "支票";
		case 3:
			return "建行POS";
		case 4:
			return "银联POS";
		case 5:
			return "免优票";
		case 6:
			return "里程券";
		case 7:
			return "个人挂账";
		case 8:
			return "月结挂账";
		case 9:
			return "网上支付";
		case 10:
			return "银行汇款";
		case 11:
			return "内部结算";

		}
		return "";
	}

	public void Findallzrate() throws Exception {
		// 取得政策列表 
		
		List<Zrate> listzrate = Getallzrate(z_startcity, z_endcity, z_fromdate,
				intflag, strAirCompany, strAirline, strCabin);
        if(listzrate.size()>0)
        {
		strZrateHtml += "<input type='hidden' value='"+listzrate.size()+"' id='zratelength'><table border='0' cellpadding='0' cellspacing='0' width='100%' ><input type='hidden' id='txt_hidefirstrate' value='"
				+ listzrate.get(0).getId() + "' />";
		if (listzrate.size() > 0) {
			for (int i = 0; i < listzrate.size(); i++) {
				int index = i + 1;
				String strStyle = "";
				if (i >= 4) {
					strStyle = " style='display:none' ";
				} else {
					strStyle = "";
				}
				strZrateHtml += "<tr id='tr_rateinfo_" + i + "' " + strStyle
						+ ">";
				float reatetprice = 0f;
				if (strratePrice != null && !strratePrice.equals("")) {
					reatetprice = Float.parseFloat(strratePrice);
				}
				if (getLoginUserAgent().getId() == 46) {
					strZrateHtml += "<td style='width: 20%;border-top: 1px dashed #999999'>政策"
							+ index
							+ ""
							+ getZrateAgentName(listzrate.get(i).getAgentid())
							+ "</td>";
				} else {
					strZrateHtml += "<td style='width: 20%;border-top: 1px dashed #999999'>政策"
							+ index + "</td>";
				}
                 float ticketpareprice=reatetprice;
                 Float ticketyouhuiprice=reatetprice* Getliudianvalue(listzrate.get(i).getRatevalue())/100;
				 int intyouhuiprice=ticketyouhuiprice.intValue();
				 float ticketjiesuanjia=ticketpareprice-intyouhuiprice;
				strZrateHtml += "<td style='width: 15%;border-top: 1px dashed #999999'><input type='hidden' id='liudianvalue_"
						+ listzrate.get(i).getId()
						+ "' value='"
						+ formatZrate(Getliudianvalue(listzrate.get(i)
								.getRatevalue()))
						+ "' /><input type='hidden' id='hidzongfandian_"
						+ listzrate.get(i).getId()
						+ "' value='"
						+ listzrate.get(i).getRatevalue()
						+ "' /><span id='2_"
						+ listzrate.get(i).getId()
						+ "'>"
						+ formatMoney_short(gethuiyouprice(
								Getliudianvalue(listzrate.get(i).getRatevalue()) / 100,
								1f, reatetprice)
								+ "")
						+ "(<font color='red'>返点:"
						+ formatZrate(Getliudianvalue(listzrate.get(i)
								.getRatevalue())) + "%</font>)</span></td>";
				strZrateHtml += "<td style='width: 15%;border-top: 1px dashed #999999'>￥<span id='danzhangjiesuanjia_"
						+ listzrate.get(i).getId()
						+ "'>"
				
						+ formatMoney_string(ticketjiesuanjia+"")
						+ "</span></td>";
				strZrateHtml += "<td style='width: 15%;border-top: 1px dashed #999999'>"
						+ listzrate.get(i).getWorktime()
						+ "-"
						+ listzrate.get(i).getAfterworktime() + "</td>";
				strZrateHtml += "<td style='width: 15%;border-top: 1px dashed #999999'>"
						+ listzrate.get(i).getAfterworktime() + "</td>";
				if (listzrate.get(i).getSpeed() != null
						&& !listzrate.get(i).getSpeed().equals("")) {
					strZrateHtml += "<td style='width: 15%;border-top: 1px dashed #999999'>"
							+ listzrate.get(i).getSpeed() + "分钟</td>";
				} else {
					strZrateHtml += "<td style='width: 15%;border-top: 1px dashed #999999'>暂无数据</td>";
				}

				strZrateHtml += "<td style='border-top: 1px dashed #999999;width: 5%;'><input type='radio' id='rdozrate_"
						+ i
						+ "' onclick='showremark("
						+ listzrate.get(i).getId()
						+ ");' name='zrate_two' value='"
						+ listzrate.get(i).getId() + "'/></td>";
				strZrateHtml += "</tr>";
				strZrateHtml += "<tr id='remark_" + listzrate.get(i).getId()
						+ "' style='display: none;'>";
				String strRemark = "";
				if (listzrate.get(i).getRemark() != null
						&& !listzrate.get(i).getRemark().equals("")) {
					strRemark = listzrate.get(i).getRemark();
				} else {
					strRemark = "暂无政策描述";
				}
				strZrateHtml += "<td colspan='8' style='width: 100%;border-top: 1px dashed #999999'><span style='float:left;color:red;font-weight:bold' >&nbsp;&nbsp;&nbsp;&nbsp;"
						+ strRemark + "</span>&nbsp;</td>";
				strZrateHtml += "</tr>";

			}
			strZrateHtml += "<tr id='button_more'>";
			strZrateHtml += "<td colspan='8' style='border-top: 1px dashed #999999' align='right'><span style='cursor:pointer;' onclick='showallreate();'>+更多</span></td>";
			strZrateHtml += "</tr>";
			strZrateHtml += "<tr id='button_less' style='display:none'>";
			strZrateHtml += "<td colspan='8' style='border-top: 1px dashed #999999;' align='right'><span style='cursor:pointer;' onclick='hideallreate();'>-缩起</span></td>";
			strZrateHtml += "</tr>";
		} else {
			strZrateHtml += "<tr colspan='8' style='color:red'><td><b>暂无政策信息！</b></td></tr>";
		}
        }
        else
        {
        	strZrateHtml += "<tr colspan='8' style='color:red'><td><b>暂无政策信息！</b></td></tr>";
        }

		strZrateHtml += "</table>";

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strZrateHtml);
		out.print(sb);
		out.flush();
		out.close();
	}
	public void FindallzratePNR() throws Exception {
		// 取得政策列表 
		Orderinfo orderinfonew= new Orderinfo();
		orderinfonew.setPnr(strPNR);
		orderinfonew.setPnrtxt(strPNRTXT);
		orderinfonew.setPattxt(strPATTXT);
		
		Zrate zrate= Server.getInstance().getRateService().FindZrateByFlight(orderinfonew, null,null);
		List<Zrate> listzrate = new ArrayList<Zrate>();
		if(zrate!=null){
			listzrate.add(zrate);
		}
        if(listzrate.size()>0)
        {
		strZrateHtml += "<input type='hidden' value='"+listzrate.size()+"' id='zratelength'><table border='0' cellpadding='0' cellspacing='0' width='100%' ><input type='hidden' id='txt_hidefirstrate' value='"
				+ listzrate.get(0).getId() + "' />";
		if (listzrate.size() > 0) {
			for (int i = 0; i < listzrate.size(); i++) {
				int index = i + 1;
				String strStyle = "";
				if (i >= 4) {
					strStyle = " style='display:none' ";
				} else {
					strStyle = "";
				}
				strZrateHtml += "<tr id='tr_rateinfo_" + i + "' " + strStyle
						+ ">";
				float reatetprice = 0f;
				if (strratePrice != null && !strratePrice.equals("")) {
					reatetprice = Float.parseFloat(strratePrice);
				}
				if (getLoginUserAgent().getId() == 46) {
					strZrateHtml += "<td style='width: 20%;border-top: 1px dashed #999999'>政策"
							+ index
							+ ""
							+ getZrateAgentName(listzrate.get(i).getAgentid())
							+ "</td>";
				} else {
					strZrateHtml += "<td style='width: 20%;border-top: 1px dashed #999999'>政策"
							+ index + "</td>";
				}
                 float ticketpareprice=reatetprice;
                 Float ticketyouhuiprice=reatetprice* Getliudianvalue(listzrate.get(i).getRatevalue())/100;
				 int intyouhuiprice=ticketyouhuiprice.intValue();
				 float ticketjiesuanjia=ticketpareprice-intyouhuiprice;
				strZrateHtml += "<td style='width: 15%;border-top: 1px dashed #999999'><input type='hidden' id='liudianvalue_"
						+ listzrate.get(i).getId()
						+ "' value='"
						+ formatZrate(Getliudianvalue(listzrate.get(i)
								.getRatevalue()))
						+ "' /><input type='hidden' id='hidzongfandian_"
						+ listzrate.get(i).getId()
						+ "' value='"
						+ listzrate.get(i).getRatevalue()
						+ "' /><span id='2_"
						+ listzrate.get(i).getId()
						+ "'>"
						+ formatMoney_short(gethuiyouprice(
								Getliudianvalue(listzrate.get(i).getRatevalue()) / 100,
								1f, reatetprice)
								+ "")
						+ "(<font color='red'>返点:"
						+ formatZrate(Getliudianvalue(listzrate.get(i)
								.getRatevalue())) + "%</font>)</span></td>";
				strZrateHtml += "<td style='width: 15%;border-top: 1px dashed #999999'>￥<span id='danzhangjiesuanjia_"
						+ listzrate.get(i).getId()
						+ "'>"
				
						+ formatMoney_string(ticketjiesuanjia+"")
						+ "</span></td>";
				strZrateHtml += "<td style='width: 15%;border-top: 1px dashed #999999'>"
						+ listzrate.get(i).getWorktime()
						+ "-"
						+ listzrate.get(i).getAfterworktime() + "</td>";
				strZrateHtml += "<td style='width: 15%;border-top: 1px dashed #999999'>"
						+ listzrate.get(i).getAfterworktime() + "</td>";
				if (listzrate.get(i).getSpeed() != null
						&& !listzrate.get(i).getSpeed().equals("")) {
					strZrateHtml += "<td style='width: 15%;border-top: 1px dashed #999999'>"
							+ listzrate.get(i).getSpeed() + "分钟</td>";
				} else {
					strZrateHtml += "<td style='width: 15%;border-top: 1px dashed #999999'>暂无数据</td>";
				}

				strZrateHtml += "<td style='border-top: 1px dashed #999999;width: 5%;'><input type='radio' id='rdozrate_"
						+ i
						+ "' onclick='showremark("
						+ listzrate.get(i).getId()
						+ ");' name='zrate_two' value='"
						+ listzrate.get(i).getId() + "'/></td>";
				strZrateHtml += "</tr>";
				strZrateHtml += "<tr id='remark_" + listzrate.get(i).getId()
						+ "' style='display: none;'>";
				String strRemark = "";
				if (listzrate.get(i).getRemark() != null
						&& !listzrate.get(i).getRemark().equals("")) {
					strRemark = listzrate.get(i).getRemark();
				} else {
					strRemark = "暂无政策描述";
				}
				strZrateHtml += "<td colspan='8' style='width: 100%;border-top: 1px dashed #999999'><span style='float:left;color:red;font-weight:bold' >&nbsp;&nbsp;&nbsp;&nbsp;"
						+ strRemark + "</span>&nbsp;</td>";
				strZrateHtml += "</tr>";

			}
			strZrateHtml += "<tr id='button_more'>";
			strZrateHtml += "<td colspan='8' style='border-top: 1px dashed #999999' align='right'><span style='cursor:pointer;' onclick='showallreate();'>+更多</span></td>";
			strZrateHtml += "</tr>";
			strZrateHtml += "<tr id='button_less' style='display:none'>";
			strZrateHtml += "<td colspan='8' style='border-top: 1px dashed #999999;' align='right'><span style='cursor:pointer;' onclick='hideallreate();'>-缩起</span></td>";
			strZrateHtml += "</tr>";
		} else {
			strZrateHtml += "<tr colspan='8' style='color:red'><td><b>暂无政策信息！</b></td></tr>";
		}
        }
        else
        {
        	strZrateHtml += "<tr colspan='8' style='color:red'><td><b>暂无政策信息！</b></td></tr>";
        }

		strZrateHtml += "</table>";

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strZrateHtml);
		out.print(sb);
		out.flush();
		out.close();
	}

	/**
	 * 黑屏中查询全价价格
	 * 
	 * @param strCityPair
	 *            城市对
	 * @param strAirCompanyCode
	 *            航空公司代码
	 * @param strCabin
	 *            舱位码
	 * @return 全价价格
	 */
	public float getYPriceFormEterm(String strCityPair,
			String strAirCompanyCode, String strCabin) {
		float freturn = 0f;
		// 黑屏中查询全价价格
		String strPriceInfo = "";
		String cmd = "FD:" + strCityPair + "/" + strAirCompanyCode + "$PN$PN";
		strPriceInfo = Server.getInstance().getTicketSearchService()
				.commandFunction2(cmd, "", "");
		// 对价格进行解析
		String strCabinPrice = "0";
		Pattern patternprice = Pattern.compile(strAirCompanyCode + "/"
				+ strCabin);
		// 以换行符将字符串拆分
		String[] strpriceinfoarr = patternprice.split(strPriceInfo);
		if (strpriceinfoarr.length >= 2) {
			String strPPricecabin = strpriceinfoarr[1].toString();
			Pattern patcab = Pattern.compile("\\/");
			String[] strParr = patcab.split(strPPricecabin);
			String strTruePriceinfo = "";
			if (strParr.length >= 2) {
				strTruePriceinfo = strParr[1].toString().trim();
				if (strTruePriceinfo.indexOf("=") >= 0) {
					Pattern patcabtemp = Pattern.compile("=");
					String[] strtempcab = patcabtemp.split(strTruePriceinfo);
					if (strtempcab.length == 2) {
						strCabinPrice = strtempcab[0].trim();

					}
				} else {
					strCabinPrice = strTruePriceinfo;
				}
			}
		}
		try {
			freturn = Float.parseFloat(strCabinPrice);
		} catch (Exception ex) {
			freturn = 0f;
		}

		return freturn;
	}

	public Map<Integer, String> getFkmethodMap() {
		Map<Integer, String> fkmethodmap = new HashMap<Integer, String>();
		fkmethodmap.put(1, getFkmethodstr(1));
		fkmethodmap.put(2, getFkmethodstr(2));
		fkmethodmap.put(3, getFkmethodstr(3));
		fkmethodmap.put(4, getFkmethodstr(4));
		fkmethodmap.put(5, getFkmethodstr(5));
		fkmethodmap.put(6, getFkmethodstr(6));
		fkmethodmap.put(7, getFkmethodstr(7));
		fkmethodmap.put(8, getFkmethodstr(8));
		fkmethodmap.put(9, getFkmethodstr(9));
		fkmethodmap.put(10, getFkmethodstr(10));
		fkmethodmap.put(11, getFkmethodstr(11));

		return fkmethodmap;
	}

	public Map<Integer, String> getPaymethodMap() {
		Map<Integer, String> paymethodmap = new HashMap<Integer, String>();
		paymethodmap.put(1, getPayMethodStr(1));
		paymethodmap.put(2, getPayMethodStr(2));
		paymethodmap.put(3, getPayMethodStr(3));
		paymethodmap.put(4, getPayMethodStr(4));
		paymethodmap.put(5, getPayMethodStr(5));
		paymethodmap.put(6, getPayMethodStr(6));
		paymethodmap.put(7, getPayMethodStr(7));
		paymethodmap.put(8, getPayMethodStr(8));
		paymethodmap.put(9, getPayMethodStr(9));

		return paymethodmap;
	}

	public Insuranceinfo getInsuranceinfo() {
		return insuranceinfo;
	}

	public void setInsuranceinfo(Insuranceinfo insuranceinfo) {
		this.insuranceinfo = insuranceinfo;
	}

	public List<Passenger> getPassengerlist() {
		return passengerlist;
	}

	public void setPassengerlist(List<Passenger> passengerlist) {
		this.passengerlist = passengerlist;
	}

	public int getRepaystate() {
		return repaystate;
	}

	public void setRepaystate(int repaystate) {
		this.repaystate = repaystate;
	}

	public String getStrReturn() {
		return strReturn;
	}

	public void setStrReturn(String strReturn) {
		this.strReturn = strReturn;
	}

	public String getStrticketnumber() {
		return strticketnumber;
	}

	public void setStrticketnumber(String strticketnumber) {
		this.strticketnumber = strticketnumber;
	}

	public String getS_tuifeitime() {
		return s_tuifeitime;
	}

	public void setS_tuifeitime(String s_tuifeitime) {
		this.s_tuifeitime = s_tuifeitime;
	}

	public String getS_printtime() {
		return s_printtime;
	}

	public void setS_printtime(String s_printtime) {
		this.s_printtime = s_printtime;
	}

	public String getS_orderid() {
		return s_orderid;
	}

	public void setS_orderid(String s_orderid) {
		this.s_orderid = s_orderid;
	}

	public String getImporttype() {
		return importtype;
	}

	public void setImporttype(String importtype) {
		this.importtype = importtype;
	}

	public String getS_tuifeireason() {
		return s_tuifeireason;
	}

	public void setS_tuifeireason(String s_tuifeireason) {
		this.s_tuifeireason = s_tuifeireason;
	}

	public String getS_songpaiodanpid() {
		return s_songpaiodanpid;
	}

	public void setS_songpaiodanpid(String s_songpaiodanpid) {
		this.s_songpaiodanpid = s_songpaiodanpid;
	}

	public String getS_Paindex() {
		return s_Paindex;
	}

	public void setS_Paindex(String paindex) {
		s_Paindex = paindex;
	}

	public List<Creditcard> getCreditlist() {
		return creditlist;
	}

	public void setCreditlist(List<Creditcard> creditlist) {
		this.creditlist = creditlist;
	}

	public String getStrExchOldOrder() {
		return strExchOldOrder;
	}

	public void setStrExchOldOrder(String strExchOldOrder) {
		this.strExchOldOrder = strExchOldOrder;
	}

	public boolean isIsexchorder() {
		return isexchorder;
	}

	public void setIsexchorder(boolean isexchorder) {
		this.isexchorder = isexchorder;
	}

	public boolean isS_isexchorder() {
		return s_isexchorder;
	}

	public void setS_isexchorder(boolean s_isexchorder) {
		this.s_isexchorder = s_isexchorder;
	}

	public String getS_exchordertn() {
		return s_exchordertn;
	}

	public void setS_exchordertn(String s_exchordertn) {
		this.s_exchordertn = s_exchordertn;
	}

	public long getLinkid() {
		return linkid;
	}

	public void setLinkid(long linkid) {
		this.linkid = linkid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getS_customeragentid() {
		return s_customeragentid;
	}

	public void setS_customeragentid(String s_customeragentid) {
		this.s_customeragentid = s_customeragentid;
	}

	public int getS_cindex() {
		return s_cindex;
	}

	public void setS_cindex(int s_cindex) {
		this.s_cindex = s_cindex;
	}

	public String getS_cvalue() {
		return s_cvalue;
	}

	public void setS_cvalue(String s_cvalue) {
		this.s_cvalue = s_cvalue;
	}

	public String getS_cname() {
		return s_cname;
	}

	public void setS_cname(String s_cname) {
		this.s_cname = s_cname;
	}

	public int getIsinter() {
		return isinter;
	}

	public void setIsinter(int isinter) {
		this.isinter = isinter;
	}

	public int getS_cashier() {
		return s_cashier;
	}

	public void setS_cashier(int s_cashier) {
		this.s_cashier = s_cashier;
	}

	public List<Tickettype> getListtickettype() {
		return listtickettype;
	}

	public void setListtickettype(List<Tickettype> listtickettype) {
		this.listtickettype = listtickettype;
	}

	public long getS_tickettypeid() {
		return s_tickettypeid;
	}

	public void setS_tickettypeid(long s_tickettypeid) {
		this.s_tickettypeid = s_tickettypeid;
	}

	public int getIsgroup() {
		return isgroup;
	}

	public void setIsgroup(int isgroup) {
		this.isgroup = isgroup;
	}

	public String getS_totalotherfee() {
		return s_totalotherfee;
	}

	public void setS_totalotherfee(String s_totalotherfee) {
		this.s_totalotherfee = s_totalotherfee;
	}

	public String getS_totalanjian() {
		return s_totalanjian;
	}

	public void setS_totalanjian(String s_totalanjian) {
		this.s_totalanjian = s_totalanjian;
	}

	public int getZhekoubili() {
		return zhekoubili;
	}

	public void setZhekoubili(int zhekoubili) {
		this.zhekoubili = zhekoubili;
	}

	public String getS_zhekoujine() {
		return s_zhekoujine;
	}

	public void setS_zhekoujine(String s_zhekoujine) {
		this.s_zhekoujine = s_zhekoujine;
	}

	public String getTicketquanprice() {
		return ticketquanprice;
	}

	public void setTicketquanprice(String ticketquanprice) {
		this.ticketquanprice = ticketquanprice;
	}

	public int getIsfeiyou() {
		return isfeiyou;
	}

	public void setIsfeiyou(int isfeiyou) {
		this.isfeiyou = isfeiyou;
	}

	public int getIstianxuntong() {
		return istianxuntong;
	}

	public void setIstianxuntong(int istianxuntong) {
		this.istianxuntong = istianxuntong;
	}

	public String getFeiyouarr() {
		return feiyouarr;
	}

	public void setFeiyouarr(String feiyouarr) {
		this.feiyouarr = feiyouarr;
	}

	public String getTianxuntongarr() {
		return tianxuntongarr;
	}

	public void setTianxuntongarr(String tianxuntongarr) {
		this.tianxuntongarr = tianxuntongarr;
	}

	public long getTui_yuanyi() {
		return tui_yuanyi;
	}

	public void setTui_yuanyi(long tui_yuanyi) {
		this.tui_yuanyi = tui_yuanyi;
	}

	public String getStrZrateHtml() {
		return strZrateHtml;
	}

	public void setStrZrateHtml(String strZrateHtml) {
		this.strZrateHtml = strZrateHtml;
	}

	public String getZ_fromdate() {
		return z_fromdate;
	}

	public void setZ_fromdate(String z_fromdate) {
		this.z_fromdate = z_fromdate;
	}

	public String getZ_endcity() {
		return z_endcity;
	}

	public void setZ_endcity(String z_endcity) {
		this.z_endcity = z_endcity;
	}

	public String getZ_startcity() {
		return z_startcity;
	}

	public void setZ_startcity(String z_startcity) {
		this.z_startcity = z_startcity;
	}

	public int getIntflag() {
		return intflag;
	}

	public void setIntflag(int intflag) {
		this.intflag = intflag;
	}

	public String getStrAirCompany() {
		return strAirCompany;
	}

	public void setStrAirCompany(String strAirCompany) {
		this.strAirCompany = strAirCompany;
	}

	public String getStrAirline() {
		return strAirline;
	}

	public void setStrAirline(String strAirline) {
		this.strAirline = strAirline;
	}

	public String getStrCabin() {
		return strCabin;
	}

	public void setStrCabin(String strCabin) {
		this.strCabin = strCabin;
	}

	public List<Aircompany> getListAricompany() {
		return listAricompany;
	}

	public void setListAricompany(List<Aircompany> listAricompany) {
		this.listAricompany = listAricompany;
	}

	public String getS_zonglirun() {
		return s_zonglirun;
	}

	public void setS_zonglirun(String s_zonglirun) {
		this.s_zonglirun = s_zonglirun;
	}

	public String getStrratePrice() {
		return strratePrice;
	}

	public void setStrratePrice(String strratePrice) {
		this.strratePrice = strratePrice;
	}

	public float getS_zhekoubili() {
		return s_zhekoubili;
	}

	public void setS_zhekoubili(float s_zhekoubili) {
		this.s_zhekoubili = s_zhekoubili;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public float getTotalzhekoujine() {
		return totalzhekoujine;
	}

	public void setTotalzhekoujine(float totalzhekoujine) {
		this.totalzhekoujine = totalzhekoujine;
	}

	public int getYwtype() {
		return ywtype;
	}

	public void setYwtype(int ywtype) {
		this.ywtype = ywtype;
	}

	public float getS_zongfandian() {
		return s_zongfandian;
	}

	public void setS_zongfandian(float s_zongfandian) {
		this.s_zongfandian = s_zongfandian;
	}

	public Float getS_piaomianjia() {
		return s_piaomianjia;
	}

	public void setS_piaomianjia(Float s_piaomianjia) {
		this.s_piaomianjia = s_piaomianjia;
	}

	public String getS_zrateid() {
		return s_zrateid;
	}

	public void setS_zrateid(String s_zrateid) {
		this.s_zrateid = s_zrateid;
	}

	public float getOrderPlat() {
		return orderPlat;
	}

	public void setOrderPlat(float orderPlat) {
		this.orderPlat = orderPlat;
	}

	public float getSegmentparvprice() {
		return segmentparvprice;
	}

	public void setSegmentparvprice(float segmentparvprice) {
		this.segmentparvprice = segmentparvprice;
	}

	public String getS_contactmobile() {
		return s_contactmobile;
	}

	public void setS_contactmobile(String s_contactmobile) {
		this.s_contactmobile = s_contactmobile;
	}

	public String getS_insurancevalues() {
		return s_insurancevalues;
	}

	public void setS_insurancevalues(String s_insurancevalues) {
		this.s_insurancevalues = s_insurancevalues;
	}

	public int getIsshow() {
		return isshow;
	}

	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}

	public String getStrPNRTXT() {
		return strPNRTXT;
	}

	public void setStrPNRTXT(String strPNRTXT) {
		this.strPNRTXT = strPNRTXT;
	}

	public String getStrPATTXT() {
		return strPATTXT;
	}

	public void setStrPATTXT(String strPATTXT) {
		this.strPATTXT = strPATTXT;
	}

	public List<Customeragent> getAgentlist() {
		return agentlist;
	}

	public void setAgentlist(List<Customeragent> agentlist) {
		this.agentlist = agentlist;
	}

	public Zrate getNewzrate() {
		return newzrate;
	}

	public void setNewzrate(Zrate newzrate) {
		this.newzrate = newzrate;
	}

	public List<Zrate> getListzrate() {
		return listzrate;
	}

	public void setListzrate(List<Zrate> listzrate) {
		this.listzrate = listzrate;
	}

	public String getBigPNR() {
		return BigPNR;
	}

	public void setBigPNR(String bigPNR) {
		BigPNR = bigPNR;
	}
public static void SendSms(String strMobiles,String content,String ordercode){
		
		

		
		if(strMobiles!=null && !strMobiles.equals(""))
		{
			String ipAddress="http://http.c123.com/tx/?";
			/*String userid="192340";  //1033001
			String password="46EB801714254B5480CABD93E8851EBB";*/
			String userid="73420";  //1033001
			String password="f5aac2684357b073b718dc3b76b2ed2b";
			String sms="";
			
				try {
					sms=URLEncoder.encode(content,"GBK");
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				int intReturn=0;
				String totalurl="";
				totalurl="uid="+userid;
				totalurl+="&pwd="+password;
				totalurl+="&mobile="+strMobiles;
				
				totalurl+="&content="+sms;
				WriteLog writeLog = new WriteLog();
				
				try {
					//String totalurl="http://www.cnefang.com/index.php?act=msgsend&username=hzjhhkpw&password=hzjhhkpw&mobile="+strMobiles+"&content="+URLEncoder.encode(content,"UTF-8")+"&seq=1000&schoolnumber=1033";
					//String totalurl="http://www.cnefang.com/index.php?act=msgsend&username=hzjhhkpw121212&password=hzjhhkpw21212&mobile="+strMobiles+"&content="+URLEncoder.encode(content,"UTF-8")+"&seq=1000&schoolnumber=1033";
					totalurl=ipAddress+totalurl;
					System.out.println(totalurl);
					
					writeLog.write("七星短信_totalurl", "totalurl:"+totalurl);
					
					java.net.URL Url = new java.net.URL(totalurl);
					java.net.HttpURLConnection conn = (java.net.HttpURLConnection) Url.openConnection();

					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String s="";
					while((s=br.readLine())!=null)
					{
						System.out.println("s:"+s);
						if(s.equals("100"))
			        	{
							writeLog.write("七星短信_totalurl_OK","OK:totalurl:"+totalurl);
				        	Ymsend ymsend=new Ymsend();
							ymsend.setContent(content);
							ymsend.setCreatetime(new Timestamp(System.currentTimeMillis()));
							ymsend.setOrdercode(ordercode);
							ymsend.setPhone(strMobiles);
							ymsend.setState(1l);
							ymsend.setType(2);
							Server.getInstance().getMemberService().createYmsend(ymsend);
							intReturn=1;
			        	}
			        	else
			        	{
			        		writeLog.write("七星短信_totalurl_ERR","ERR:totalurl:"+totalurl);
			        		Ymsend ymsend=new Ymsend();
							ymsend.setContent(content);
							ymsend.setCreatetime(new Timestamp(System.currentTimeMillis()));
							ymsend.setOrdercode(ordercode);
							ymsend.setPhone(strMobiles);
							ymsend.setState(0l);
							ymsend.setType(2);
							Server.getInstance().getMemberService().createYmsend(ymsend);
			        	}
						
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		else{
			
		}
		
		
	}

public String getStrLOGINNAME() {
	return strLOGINNAME;
}

public void setStrLOGINNAME(String strLOGINNAME) {
	this.strLOGINNAME = strLOGINNAME;
}

public String getStrCompanyCode() {
	return strCompanyCode;
}

public void setStrCompanyCode(String strCompanyCode) {
	this.strCompanyCode = strCompanyCode;
}

public long getS_agentid() {
	return s_agentid;
}

public void setS_agentid(long s_agentid) {
	this.s_agentid = s_agentid;
}

public long getS_userid() {
	return s_userid;
}

public void setS_userid(long s_userid) {
	this.s_userid = s_userid;
}

public String getPnrTxtPat() {
	return PnrTxtPat;
}

public void setPnrTxtPat(String pnrTxtPat) {
	PnrTxtPat = pnrTxtPat;
}

public String getStrTEL() {
	return strTEL;
}

public void setStrTEL(String strTEL) {
	this.strTEL = strTEL;
}

public List<Zrate> getListZrate1() {
	return ListZrate1;
}

public void setListZrate1(List<Zrate> listZrate1) {
	ListZrate1 = listZrate1;
}

public List<Zrate> getListZrate2() {
	return ListZrate2;
}

public void setListZrate2(List<Zrate> listZrate2) {
	ListZrate2 = listZrate2;
}

}