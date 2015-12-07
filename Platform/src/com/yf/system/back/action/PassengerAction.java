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
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DefaultEditorKit.CutAction;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.opensymphony.webwork.ServletActionContext;
import com.yf.system.atom.component.WriteLog;
import com.yf.system.atom.interticket.HttpClient;
import com.yf.system.back.server.Server;
import com.yf.system.bak.excel.HthyWorkSheet;
import com.yf.system.bak.excel.HthyWritableWorkBook;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.cityairport.Cityairport;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.department.Department;
import com.yf.system.base.insuranceinfo.Insuranceinfo;
import com.yf.system.base.miscellaneous.Miscellaneous;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.orderinforc.Orderinforc;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.qqinfo.Qqinfo;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.traderecord.Traderecord;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.xcdno.Xcdno;
import com.yf.system.base.xcdnoinfo.Xcdnoinfo;

public class PassengerAction extends B2b2cbackAction {
	private List listPassenger = new ArrayList();
	private Passenger passenger = new Passenger();
	private Orderinfo orderinfo = new Orderinfo();
	private Aircompany aircompany = new Aircompany();
	private Cityairport cityairport = new Cityairport();
	private Segmentinfo segmentinfo = new Segmentinfo();
	private List<Segmentinfo> listsegmentinfo;
	private List<Cityairport> listcityairport;
	private List<Aircompany> listaircompany;
	 private String startDate;

	private List<Customeragent> listCustomeragent;
	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	// search
	private String username;
	private String ordercode;
	private long angentid;
	private int s_state;
	//
	private String ei;
	private String fet;
	private String ticketnum;
	private String pid;

	private long orderinfoid;
	private long ppid;
	private String s_ticketnumber;
	private String treestr = "";
	private String s_department;
	private String s_passenger;
	private String s_operator;
	private String hkname;// 还款人
	private String s_ordernum;// 订单号
	private String s_ticketnum;// 票号

	private String companyname;

	private String issue_begintime;// 出票日期
	private String issue_endtime;
	private String flight_begintime;
	private String flight_endtime;
	private String repay_begintime;
	private String repay_endtime;

	private int s_internal = -1;// 机票类型：0国内，国际。
	private long passid;
	private boolean isExp = false;

	private String repay;

	private List otherlistPassenger = new ArrayList();// 退废改签
	private List<Miscellaneous> listMiscellaneous = new ArrayList<Miscellaneous>();// 杂项费用

	private String s_passengername;// 乘机人
	
	//格式化收入钱数的值的形式(主要用于界面的显示，其它没什么作用了)
	private String passangerPrice;
	private String passangerAirportfee;
	private String passangerFuelprice;
	private String passangerTotalfuelfee;
	//行程单号
	private String passengerXingchengdan;
	public String topassenger()throws Exception{//到打印预览页面
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		Calendar calendar = Calendar.getInstance();
		startDate = sdf.format(calendar.getTime());
		passenger= Server.getInstance().getAirService().findPassenger(Long.parseLong(pid));
		if(passenger.getInsurprice()!=null&&passenger.getInsurprice()>0){
			passenger.setInsurprice(20f);
		}
		orderinfo=Server.getInstance().getAirService().findOrderinfo(passenger.getOrderid());
		List<Segmentinfo>list=Server.getInstance().getAirService().findAllSegmentinfo(" where 1=1 and "+Segmentinfo.COL_orderid+" ="+orderinfo.getId(), "", -1, 0);
		if(list.size()>0){
		segmentinfo=list.get(0);
		}
		System.out.println("passenger="+passenger);
		
		
		
		return "topassenger";//到白底
		
		//return "topassenger2";//到白底 航信字体
		//return "chupiao";//到底图
	}
	
	
	public void  alipay_tuifenrun() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String orderidstr = request.getParameter("strTuiOrderID");
		orderinfo=Server.getInstance().getAirService().findOrderinfo(Long.parseLong(orderidstr));
		String ret="-1";
		String whereTR=" WHERE 1=1 AND "+Traderecord.COL_state+" =1 and "+Traderecord.COL_ordercode+" ='"+orderinfo.getOrdernumber()+"'";
		whereTR+=" AND "+Traderecord.COL_retcode+" !='' AND "+Traderecord.COL_retcode+" !='返回码'";
		
		/*if(orderinfo.getRelationorderid()!=null&&orderinfo.getRelationorderid()>0){
			String orid="A"+(orderinfo.getRelationorderid()+10000);
			whereTR=" WHERE 1=1 AND "+Traderecord.COL_state+" =1 and ( "+Traderecord.COL_ordercode+" ='"+orderinfo.getOrdernumber()+"' OR "+Traderecord.COL_ordercode+" ='"+orid+"') ";
			whereTR+=" AND "+Traderecord.COL_retcode+" !='' AND "+Traderecord.COL_retcode+" !='返回码'";
		}*/
		
		List<Traderecord>listTraderecord=new ArrayList<Traderecord>();
		
		listTraderecord=Server.getInstance().getMemberService().findAllTraderecord(whereTR, " ORDER BY ID ", -1, 0);
		if(listTraderecord!=null&&listTraderecord.size()>0){
		//在线支付.退款
		String url="http://127.0.0.1:8080/interface/Alipaytui?orderid="+orderinfo.getId();
		WriteLog.write("申请退款信息", "订单ID:"+orderinfo.getId()+"URL:"+url);
		java.net.URL Url = new java.net.URL(url);
		java.net.HttpURLConnection conn = (java.net.HttpURLConnection) Url.openConnection();

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String s="";
		while((s=br.readLine())!=null)
		{
			WriteLog.write("申请退款信息", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
			System.out.println("申请退款返回:"+s);
			if(s.indexOf("T")!=-1)
        	{
				WriteLog.write("申请退款信息-成功", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
				ret="1";
				System.out.println("申请退款成功");
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/plain; charset=utf-8");
				PrintWriter out = response.getWriter();
				
				out.print(ret);
				out.flush();
				out.close();
        	}else{
        		System.out.println("申请退款失败");
        		WriteLog.write("申请退款信息-失败", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
        		ret="-1";
        		HttpServletResponse response = ServletActionContext.getResponse();
    			response.setContentType("text/plain; charset=utf-8");
    			PrintWriter out = response.getWriter();
    			
    			out.print(ret);
    			out.flush();
    			out.close();
        	}
			
		}
		}else{
			
			if(orderinfo.getRelationorderid()!=null&&orderinfo.getRelationorderid()>0){
			
			orderinfo=Server.getInstance().getAirService().findOrderinfo(orderinfo.getRelationorderid());
			 ret="-1";
			 whereTR=" WHERE 1=1 AND "+Traderecord.COL_state+" =1 and "+Traderecord.COL_ordercode+" ='"+orderinfo.getOrdernumber()+"'";
			whereTR+=" AND "+Traderecord.COL_retcode+" !='' AND "+Traderecord.COL_retcode+" !='返回码'";
			listTraderecord=Server.getInstance().getMemberService().findAllTraderecord(whereTR, " ORDER BY ID ", -1, 0);
			if(listTraderecord!=null&&listTraderecord.size()>0){
			//在线支付.退款
			String url="http://127.0.0.1:8080/interface/Alipaytui?orderid="+orderinfo.getId();
			WriteLog.write("申请退款信息-关联订单", "订单ID:"+orderinfo.getId()+"URL:"+url);
			java.net.URL Url = new java.net.URL(url);
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) Url.openConnection();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String s="";
			while((s=br.readLine())!=null)
			{
				WriteLog.write("申请退款信息", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
				System.out.println("申请退款返回:"+s);
				if(s.indexOf("T")!=-1)
	        	{
					WriteLog.write("申请退款信息-成功", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
					ret="1";
					System.out.println("申请退款成功");
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setContentType("text/plain; charset=utf-8");
					PrintWriter out = response.getWriter();
					
					out.print(ret);
					out.flush();
					out.close();
	        	}else{
	        		System.out.println("申请退款失败");
	        		WriteLog.write("申请退款信息-失败", "订单ID:"+orderinfo.getId()+"URL:"+url+",返回:"+s);
	        		ret="-1";
	        		HttpServletResponse response = ServletActionContext.getResponse();
	    			response.setContentType("text/plain; charset=utf-8");
	    			PrintWriter out = response.getWriter();
	    			
	    			out.print(ret);
	    			out.flush();
	    			out.close();
	        	}
				
			}
			}
			
		}
		}
		
	}
	
	/**
	 * 检测PNR名字
	 */
	
	
	public void ValadatePassName() {
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			String orderidstr = request.getParameter("strTuiOrderID");
			
			Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo(Long.parseLong(orderidstr));
			List<Passenger>listpass=Server.getInstance().getAirService().findAllPassenger(" WHERE 1=1 AND "+Passenger.COL_orderid+" ="+orderinfo.getId(), " ORDER BY ID ", -1, 0);
			String pnrtxt="";
			if(orderinfo.getPnrtxt()!=null){
				pnrtxt=orderinfo.getPnrtxt();
			}
			System.out.println(pnrtxt);
			for(int a=0;a<listpass.size();a++){
				String pname="."+listpass.get(a).getName().trim().toUpperCase();
					System.out.println("PNAME:"+pname);
				if(pnrtxt.indexOf(pname)==-1){
					System.out.println("名字不符合!");
					out.print("-1");
					out.flush();
					out.close();
					return;
				}
				
			}
			
			
			out.print("1");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	
	/**
	 * 检测是否已经过了废票时间，出票当日24点之后不能进行废票 Created by 
	 */
	public boolean checkFeiPiaoValite(Timestamp tmrttime) {
		// 取得当前时间
		Timestamp tmnowtime = new Timestamp(System.currentTimeMillis());
		String strDateChupiao = formatTimestamp2(tmrttime);
		Timestamp tmRTTime = dateToTimestamp(strDateChupiao + " 22:00:00");
		Timestamp tmNowTime = dateToTimestamp(tmnowtime.toString());
		if ((tmNowTime.getTime() - tmRTTime.getTime()) > 0) {
			return false;
		}
		return true;
	}
	/**
	 * 检测是否已经过了废票时间，出票当日24点之后不能进行废票 Created by 
	 */
	public void checkPayTimeValite() {
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			String orderidstr = request.getParameter("strTuiOrderID");//订单ID
			String checktime = request.getParameter("checktime");//验证时间
			String pretstr="-1";
		Orderinfo orderinfo = Server.getInstance().getAirService().findOrderinfo(Long.parseLong(orderidstr));
		
		
		// 取得当前时间
		Timestamp tmnowtime = new Timestamp(System.currentTimeMillis());//当前时间
		Timestamp ctime =orderinfo.getCreatetime() ;
		
		System.out.println("时间差:"+(tmnowtime.getTime() - ctime.getTime())/1000/60);
		
		if ((tmnowtime.getTime() - ctime.getTime()) >= Integer.parseInt(checktime)) {
			pretstr="-1";
		}else{
			
			pretstr="ok";
		}
		
		PrintWriter out = response.getWriter();
		System.out.println(pretstr);
		out.print(pretstr);
		out.flush();
		out.close();
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		//return true;
	}
	
public void suodan(){
		
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			String orderidstr = request.getParameter("strTuiOrderID");
			String pretstr="";
			Orderinfo orderinfo = Server.getInstance().getAirService().findOrderinfo(Long.parseLong(orderidstr));
			
			
			
			if(orderinfo.getUserid()==null||orderinfo.getUserid()==0||orderinfo.getUserid()==-1){
				pretstr="锁单成功!";
				orderinfo.setUserid(getLoginUser().getId());
				orderinfo.setFxssuotime(new Timestamp(System.currentTimeMillis()));
				Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
				
				//创建操作记录
				try{
					Orderinforc orderinforc = new Orderinforc();
					orderinforc.setCustomeruserid(getLoginUserId());
					orderinforc.setOrderinfoid(orderinfo.getId());
					orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
					orderinforc.setContent("锁定订单--" + this.getLoginUser().getMembername()+ "锁定了订单");
					orderinforc.setSuouserid(orderinfo.getUserid());
					orderinforc.setState(orderinfo.getOrderstatus());
					orderinforc.setCustomeruserid(getLoginUserId());
					Server.getInstance().getAirService().createOrderinforc(orderinforc);
				}
				catch(Exception ex){
					System.out.println("创建操作记录异常："+ex.getMessage());
				}
				
				
				
				
			}else{
				if(orderinfo.getUserid()!=getLoginUser().getId()){
					pretstr="锁单失败!当前订单已被["+getusername(orderinfo.getUserid())+"]锁定!";
					
				}else{
					pretstr="锁单成功!";
					
				}
				
			}
			
			
			PrintWriter out = response.getWriter();
			System.out.println(pretstr);
			out.print(pretstr);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}
public void tongzhi_pay(){
	
	try {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String orderidstr = request.getParameter("strTuiOrderID");
		String pretstr="";
		Orderinfo orderinfo = Server.getInstance().getAirService().findOrderinfo(Long.parseLong(orderidstr));
		
		Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(orderinfo.getBuyagentid());
		if(customeragent.getAgentother()==null){
			pretstr="通知地址为空!通知失败!";
		}else{
			String desc=URLEncoder.encode("支付成功");
				
			String url=customeragent.getAgentother()+"?type=1&OrderID="+orderinfo.getId()+"&desc="+desc;
			String ret=HttpClient.httpget(url, "UFT-8");
			WriteLog.write("通知记录", "订单号:"+orderinfo.getOrdernumber()+",通知地址:"+url+",返回:"+ret);
			if(ret.indexOf("success")!=-1){
				pretstr="通知成功!";
			}
		}
		
		
		PrintWriter out = response.getWriter();
		System.out.println(pretstr);
		out.print(pretstr);
		out.flush();
		out.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	
	
}
public void tongzhi_chu(){
	
	try {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String orderidstr = request.getParameter("strTuiOrderID");
		String pretstr="";
		Orderinfo orderinfo = Server.getInstance().getAirService().findOrderinfo(Long.parseLong(orderidstr));
		
		Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(orderinfo.getBuyagentid());
		if(customeragent.getAgentother()==null){
			pretstr="通知地址为空!通知失败!";
		}else{
			String desc=URLEncoder.encode("出票成功");
			
			
			String url=customeragent.getAgentother()+"?type=3&OrderID="+orderinfo.getId()+"&TicketNO="+orderinfo.getPnr()+"&desc="+desc;
			String ret=HttpClient.httpget(url, "UFT-8");
			WriteLog.write("通知记录", "订单号:"+orderinfo.getOrdernumber()+",通知地址:"+url+",返回:"+ret);
			if(ret.indexOf("success")!=-1){
				pretstr="通知成功!";
			}
		}
		
		
		PrintWriter out = response.getWriter();
		System.out.println(pretstr);
		out.print(pretstr);
		out.flush();
		out.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	
	
}
public void tongzhi_judan(){
	
	try {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String orderidstr = request.getParameter("strTuiOrderID");
		String strTuidesc = request.getParameter("strTuidesc");
		String pretstr="";
		Orderinfo orderinfo = Server.getInstance().getAirService().findOrderinfo(Long.parseLong(orderidstr));
		
		Customeragent customeragent=Server.getInstance().getMemberService().findCustomeragent(orderinfo.getBuyagentid());
		if(customeragent.getAgentother()==null){
			pretstr="通知地址为空!通知失败!";
		}else{
			String desc=URLEncoder.encode(strTuidesc);
			String url=customeragent.getAgentother()+"?type=4&OrderID="+orderinfo.getId()+"&desc="+desc;
			String ret=HttpClient.httpget(url, "UFT-8");
			WriteLog.write("通知记录", "订单号:"+orderinfo.getOrdernumber()+",通知地址:"+url+",返回:"+ret);
			if(ret.indexOf("success")!=-1){
				pretstr="通知成功!";
			}
		}
		
		
		
		PrintWriter out = response.getWriter();
		System.out.println(pretstr);
		out.print(pretstr);
		out.flush();
		out.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	
	
}
public void CreatePnrByID(){
	
	try {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String orderidstr = request.getParameter("strTuiOrderID");
		String pretstr="-1";//网络问题
		Orderinfo orderinfo = Server.getInstance().getAirService().findOrderinfo(Long.parseLong(orderidstr));
		if(orderinfo.getPnr()!=null&&!orderinfo.getPnr().equals("123456")&&!orderinfo.getPnr().equals("111111")){
			PrintWriter out = response.getWriter();
			
			out.print("-2");//已经有PNR
			out.flush();
			out.close();
		}else{
		
		List<Segmentinfo>listseg=Server.getInstance().getAirService().findAllSegmentinfo(" WHERE 1=1 AND "+Segmentinfo.COL_orderid+" ="+orderinfo.getId(), " ORDER BY ID ", -1, 0);
		List<Passenger>listpass=Server.getInstance().getAirService().findAllPassenger(" WHERE 1=1 AND "+Passenger.COL_orderid+" ="+orderinfo.getId(), " ORDER BY ID ", -1, 0);
		String s_returnpnr = Server.getInstance().getTicketSearchService().CreatePNRByCmd(listseg, listpass, orderinfo.getNewpnr());	
		if(s_returnpnr.equals("-1")||s_returnpnr.equals("NOPNR")){
			
			pretstr="NOPNR";
		}else{
			
			List listonrinfo=GetRtPatPNR(s_returnpnr, listpass);//0pnrinfo 1patinfo 2bigpnr
			if(listonrinfo.get(1).toString().indexOf("没有符合条件的运价")!=-1){
				System.out.println("没有符合条件的运价,订单创建失败");
				Server.getInstance().getTicketSearchService().commandFunction2("RT"+s_returnpnr+"$XEPNR@", "", "");
				pretstr= "NOPRICE";
			}else{
				orderinfo.setPnr(s_returnpnr);
				orderinfo.setPattxt(listonrinfo.get(1).toString());
				orderinfo.setPnrtxt(listonrinfo.get(0).toString());
				orderinfo.setBigpnr(listonrinfo.get(2).toString());
				Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
				
				pretstr=s_returnpnr;
			}
		}
		
		PrintWriter out = response.getWriter();
		System.out.println(pretstr);
		out.print(pretstr);
		out.flush();
		out.close();
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	
	
}


public void ajaxValadateSuoDan(){
	String pretstr="";
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setCharacterEncoding("utf-8");
	
		try {
			
			if(getLoginAgent().getAgenttype()==1||getLoginAgent().getAgenttype()==2){
			
			String orderidstr = request.getParameter("strTuiOrderID");
			
			Orderinfo orderinfo = Server.getInstance().getAirService().findOrderinfo(Long.parseLong(orderidstr));
			if(orderinfo.getUserid()==null||orderinfo.getUserid()==0||orderinfo.getUserid()==-1){
				pretstr="";
				orderinfo.setUserid(getLoginUser().getId());
				orderinfo.setFxssuotime(new Timestamp(System.currentTimeMillis()));
				Server.getInstance().getAirService().updateOrderinfoIgnoreNull(orderinfo);
			}else{
				if(orderinfo.getUserid()!=getLoginUser().getId()){
					pretstr="操作失败!当前订单已被["+getusername(orderinfo.getUserid())+"]锁定!";
					
				}else{
					
					pretstr="";
				}
				
			}
			
			
			PrintWriter out = response.getWriter();
			System.out.println(pretstr);
			out.print(pretstr);
			out.flush();
			out.close();
			
			
			}else{
				pretstr="";
				PrintWriter out = response.getWriter();
				System.out.println(pretstr);
				out.print(pretstr);
				out.flush();
				out.close();
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}
public String GetPayTimeByOrdernumber(String orderno){
	String ret="暂无支付信息";
	String where=" WHERE 1=1 AND "+Traderecord.COL_ordercode+" ='"+orderno+"' and "+Traderecord.COL_state+" =1";
	List<Traderecord>list=Server.getInstance().getMemberService().findAllTraderecord(where, "", -1, 0);
	if(list.size()>0&&list.get(0).getModifytime()!=null){
		ret=formatTimestampyyyyMMddHHmm(list.get(0).getModifytime());
	}else{
		Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo((Long.parseLong(orderno.replace("A", ""))-10000));
		if(orderinfo.getRelationorderid()!=null&&orderinfo.getRelationorderid()>0){
			Orderinfo orderinfo2=Server.getInstance().getAirService().findOrderinfo(orderinfo.getRelationorderid());
			
			String where2=" WHERE 1=1 AND "+Traderecord.COL_ordercode+" ='"+orderinfo2.getOrdernumber()+"' and "+Traderecord.COL_state+" =1";
			List<Traderecord>list2=Server.getInstance().getMemberService().findAllTraderecord(where2, "", -1, 0);
			if(list2.size()>0&&list2.get(0).getModifytime()!=null){
				ret=formatTimestampyyyyMMddHHmm(list2.get(0).getModifytime());
			}
		}
		
	}
	return ret;
}


public List<Orderinforc> GetlistorderinforcByOrderid(long id){
	
String sql = "SELECT * FROM [T_ORDERINFORC] WHERE C_ORDERINFOID = "
		+ id;
if (this.getLoginsessionagent().getAgenttype() ==3) {
	sql += " AND (C_STATE IS NOT NULL AND C_STATE !=-1) ";
}
sql += " ORDER BY C_CREATETIME  ";

System.out.println("sql:"+sql);
List<Orderinforc> listorderinforc = Server.getInstance().getAirService()
		.findAllOrderinforcBySql(sql, -1, 0);
	
System.out.println("listorderinforc:"+listorderinforc.size());
	return listorderinforc;
}

public static String getExtStateToString(Integer id) {
	switch (id) {
	case 0:
		return "待确认";
	case 1:
		return "待支付";
	case 2:
		return "已支付供应";
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
		return "拒单-等待退款";
	case 20:
		return "拒单-已经退款";
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
	
	public String topassenger_xxd()throws Exception{//到打印预览页面--信息单
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		Calendar calendar = Calendar.getInstance();
		startDate = sdf.format(calendar.getTime());
		passenger= Server.getInstance().getAirService().findPassenger(Long.parseLong(pid));
		if(passenger.getInsurprice()!=null&&passenger.getInsurprice()>0){
			passenger.setInsurprice(20f);
		}
		orderinfo=Server.getInstance().getAirService().findOrderinfo(passenger.getOrderid());
		List<Segmentinfo>list=Server.getInstance().getAirService().findAllSegmentinfo(" where 1=1 and "+Segmentinfo.COL_orderid+" ="+orderinfo.getId(), "", -1, 0);
		if(list.size()>0){
		segmentinfo=list.get(0);
		}
		System.out.println("passenger="+passenger);
		
		
		
		return "topassenger_xxd";//到白底
		
		
	}
	
	public List GetDaDanNameByID(String xcdnoin){
		System.out.println("xcdnoin:"+xcdnoin);
		List listret=new ArrayList<String>();
		String office="";
		String name="";
		
		
		List<Xcdnoinfo> list=Server.getInstance().getAirService().findAllXcdnoinfo(" WHERE 1=1 AND "+Xcdnoinfo.COL_xcdinfo+" ='"+xcdnoin+"'", " ORDER BY ID ", -1, 0);
		if(list!=null&&list.size()>0){
			Xcdno xcd=Server.getInstance().getAirService().findXcdno(list.get(0).getXcdid());
			office=xcd.getOfficecode().toUpperCase();
			name=xcd.getCompanyname();
			System.out.println("office:"+office);
			System.out.println("name:"+name);
		}
		listret.add(office);
		listret.add(name);
		
		return listret;
	}
	public String gettuifeiinfo(String id)throws Exception{
		String ret="";
		List<Passenger> listpass=Server.getInstance().getAirService().findAllPassenger(" WHERE 1=1 AND "+Passenger.COL_orderid+" ="+id+" and "+Passenger.COL_tuifeiyuanyi+" IS NOT NULL ", " ORDER BY ID DESC ", -1, 0);
		if(listpass!=null&&listpass.size()>0){
			
			ret=gettuifeiyuany(listpass.get(0).getTuifeiyuanyi());
			
		}
		
		
		return ret;
	}
	public String gettuifeiyuany(long id){
		String sub="";
		if(id==1){
			sub="当日作废,</br>扣10元手续费";
		}
		if(id==2){
			sub="其它废票情况";
		}
		if(id==3){
			sub="客人自愿退票,</br>按客规收取手续费";
		}
		if(id==4){
			sub="南航FC舱、国航FC舱,</br>东航FCY舱、海航FC舱，申请全退";
		}
		if(id==5){
			sub="因航班取消延误，</br>申请全退";
		}
		if(id==6){
			sub="升舱换开，</br>申请全退";
		}
		if(id==7){
			sub="名字错换开重出，</br>申请全退";
		}
		if(id==8){
			sub="客人因病无法乘机，</br>申请全退";
		}
		if(id==9){
			sub="其它退票情况";
		}
		if(id==10){
			sub="申请退回票款差价";
		}
		
		return sub;
	}
	
	public String toxinxidan()throws Exception{//到打印预览页面--信息单
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		Calendar calendar = Calendar.getInstance();
		startDate = sdf.format(calendar.getTime());
	passenger=Server.getInstance().getAirService().findPassenger(passenger.getId());
	if(passenger.getInsurprice()!=null&&passenger.getInsurprice()>0){
		passenger.setInsurprice(20f);
	}
	orderinfo=Server.getInstance().getAirService().findOrderinfo(passenger.getOrderid());	
	List<Segmentinfo>list=Server.getInstance().getAirService().findAllSegmentinfo(" where 1=1 and "+Segmentinfo.COL_orderid+" ="+orderinfo.getId(), "", -1, 0);
	if(list.size()>0){
	segmentinfo=list.get(0);
	}	
		return "toxinxidan";
	}
	// 异步判断是否已经打印
	public void ajaxgetpassenger() throws Exception {
		String strReturn = "-1";
		List<Qqinfo> listqqinfo=Server.getInstance().getMemberService().findAllQqinfo(" where 1=1 and "+Qqinfo.COL_qqtype+" ="+passid+" and "+Qqinfo.COL_qqnumber+" ='"+username+"'", "", -1, 0);
		if(listqqinfo.size()>0){
			 strReturn = "-1";
			
		}else{
			Qqinfo qqinfo = new Qqinfo();
			
			qqinfo.setQqtype(passid);//乘机人ID
			qqinfo.setQqnumber(username);//验证码
			qqinfo.setQqnumberindex(getLoginUser().getId());
			//qqinfo.setQqtypename(getLoginUser().getLoginname());
			Server.getInstance().getMemberService().createQqinfo(qqinfo);
			strReturn = "1";
			
			Passenger pass=Server.getInstance().getAirService().findPassenger(passid);
			// 创建操作记录
			Orderinforc orderinforc = new Orderinforc();
			orderinforc.setOrderinfoid(pass.getOrderid());
			orderinforc.setCustomeruserid(this.getLoginUserId());
			orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
			orderinforc.setContent("打印行程单-"+getLoginUser().getLoginname()+"-执行了打印行程单操作-乘机人:"+pass.getName());
			orderinforc.setSuouserid(this.getLoginUserId());
			orderinforc.setState(pass.getState());
			Server.getInstance().getAirService().createOrderinforc(orderinforc);
			
		}
		
		

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println(strReturn);
		out.print(strReturn);
		out.flush();
		out.close();

	}

	public PassengerAction() {
		/*
		 * Calendar cal = Calendar.getInstance(); // // 当前月＋1，即下个月 //
		 * cal.add(cal.MONTH, 1); // 将本月1号作为日期初始zhii cal.set(cal.DATE, 1); //
		 * ben月1号减去一天，即得到上月最后一天 cal.add(cal.DATE, -1); SimpleDateFormat df = new
		 * java.text.SimpleDateFormat("yyyy-MM-dd"); issue_endtime =
		 * df.format(cal.getTime()); Calendar c = Calendar.getInstance();
		 * c.add(cal.MONTH, -1); c.set(c.DATE, 1); issue_begintime =
		 * df.format(c.getTime());
		 */
		Date date = new Date();
		this.repay_begintime = super.formatDate(date);
		this.repay_endtime = super.formatDate(date);

	}

	/**
	 * 列表查询乘机人表
	 */
	private String sql = "";
	private String mwhere = "";

	public String execute() throws Exception {
		/*
		 * 联系人是指大客户那边的打电话订票的人员，预订人是指我公司这边帮助进行订票操作的人员
		 */
		String menuwhere = "";
		if (isAdmin() || this.getLoginUser().getType() == 1) {
			menuwhere = " WHERE 1=1 AND C_AGENTISENABLE=1 AND C_AGENTCHECKSTATUS=1 AND C_AGENTTYPE=3 AND C_BIGTYPE=1 ";
		}
		if (super.getLoginUserRoleNumber().contains(10038l)) {
			menuwhere = " where 1=1 AND C_AGENTISENABLE=1 and C_AGENTCHECKSTATUS=1 AND "
					+ Customeragent.COL_userid + " =" + getLoginUserId();
		}
		listCustomeragent = Server.getInstance().getMemberService()
				.findAllCustomeragent(menuwhere, "", -1, 0);
		long[] longarry = new long[listCustomeragent.size()];
		int i = 0;
		for (Customeragent agent : listCustomeragent) {
			longarry[i] = agent.getId();
			i++;
		}
		if (getLoginUserRoleNumber().contains(10037l)) {// 大客户管理员角色
			longarry = new long[1];
			longarry[0] = this.getLoginUser().getAgentid();
		}
		//this.getDepttreestr(3l, longarry, true);
		if (longarry.length > 0)
			this.angentid = longarry[0];
		// /乘机人票状态 0=未出票 1=已出票 2=已废票 3=已退票4=申请退票5=申请废票6=申请改签7=退票失败8=
		// /废票失败9=改签成功10=改签失败11=已取消12=已分离13=申请升舱换开14=升舱换开成功15=升舱换开失,16,废票退款成功,17,退票退款成功
		// 败
		sql = "SELECT C_ORDERID, C_ORDERNUMBER,C_TICKETNUM,C_STATE,C_TUIFEE,C_YIHAI,C_PRINTTIME,C_FENXIAOSHANGFANDIAN,C_ZHEKOUJINE,C_CONTACTNAME,(SELECT C_MEMBERNAME FROM T_CUSTOMERUSER c WHERE "
				+ "v.C_SALEAGENTID=c.ID) AS ORDERNAME,C_NAME, dbo.F_GetAgentName(C_CUSTOMERUSERID,C_CUSTOMERAGENTID) AS AGENTNAME,dbo.F_GetSegmAirCode(C_ORDERID,'C_FLIGHTNUMBER') as hangbanhao,"
				+ "(SELECT C_MEMBERNAME FROM T_CUSTOMERUSER C WHERE C.ID=prc.C_HKUSERID ) HKNAME,prc.C_HKDATETIME HKTIME,"
				+ "dbo.F_GetSegmAirCode(C_ORDERID,'C_AIRCOMAPNYCODE') as hangkonggongsi,dbo.F_GetSegmAirCode(C_ORDERID,'C_YPRICE') as YPRICE,dbo.F_GetSegmAirCode(C_ORDERID,'C_DISCOUNT') as DISCOUNT,"
				+ "dbo.F_GetSegmAirCode(C_ORDERID,'C_DEPARTTIME') as chufashijian,dbo.F_GetSegmAirCode(C_ORDERID,'C_STARTAIRPORT') as citypair,C_PRICE,"
				+ "ISNULL(C_AIRPORTFEE,0)+ISNULL(C_FUELPRICE,0)+ISNULL(C_ANJIANFEE,0)+ISNULL(C_OTHERFEE,0) AS DUTY,ISNULL(C_INSURANCEFEE,0) INSURFEE,ISNULL(C_HAIQIAN,0) HQ,C_HKSTATE ,C_MEMO "
				+ "FROM  view_pas_order_seng v  LEFT  JOIN  T_PASSENGERREPAYRC prc ON prc.C_PASSENGER=v.ID  where 1=1 ";

		String mwhere = "";
		String thiswhere = "";
		if (s_department != null && !s_department.trim().equals("")) {// 部门

			if (s_department.indexOf("c") >= 0) {
				angentid = Long.valueOf(s_department.substring(1));
				this.companyname = Server.getInstance().getMemberService()
						.findCustomeragent(angentid).getAgentcompanyname();
				String deptlist = super.getAllDeptIdByAgentId(angentid);
				thiswhere += " AND " + Orderinfo.COL_buyagentid + " IN ("
						+ deptlist + ")";
				mwhere += " AND " + Miscellaneous.COL_groupuserid + " IN ("
						+ deptlist + ")  ";

			} else {
				angentid = Long.valueOf(s_department.substring(0, s_department
						.indexOf("@")));
				this.companyname = Server.getInstance().getMemberService()
						.findDepartment(angentid).getName();
				thiswhere = " AND "
						+ Orderinfo.COL_customeruserid
						+ " IN ( SELECT ID FROM T_CUSTOMERUSER WHERE C_DEPTID ="
						+ angentid + " ) ";

				mwhere += " AND " + Miscellaneous.COL_department + "="
						+ angentid;
			}
		} else {
			thiswhere += " AND " + Orderinfo.COL_buyagentid + " IN (0)";
			mwhere += " AND " + Miscellaneous.COL_groupuserid + " IN (0)  ";
		}

		if (username != null && username.length() > 0) {// 联系人
			thiswhere += " AND " + Orderinfo.COL_contactname + " LIKE '%"
					+ username + "%'";
		}
		if (s_operator != null && s_operator.length() > 0) {// 预订人
			thiswhere += " AND " + Orderinfo.COL_saleagentid + " IN (SELECT "
					+ Customeruser.COL_id + " FROM " + Customeruser.TABLE + " "
					+ " WHERE " + Customeruser.COL_membername + " LIKE '%"
					+ s_operator + "%')";
		}
		if (this.isNotNullOrEpt(hkname)) {// 还款人
			thiswhere += " AND ID IN (SELECT C_PASSENGER FROM T_PASSENGERREPAYRC WHERE C_HKUSERID IN (SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"
					+ hkname + "%') ) ";
		}
		if (this.isNotNullOrEpt(s_ordernum)) {// 订单号
			thiswhere += " AND C_ORDERNUMBER LIKE '%" + s_ordernum + "%'";
		}
		if (this.isNotNullOrEpt(s_ticketnum)) {// 票号
			thiswhere += " AND C_TICKETNUM = '%" + s_ticketnum + "%'";
		}
		if (this.s_internal > -1) {// 类型
			thiswhere += " AND C_INTERNAL =" + s_internal;
		}
		String flittime = this.getCheckTime(flight_begintime, flight_endtime,
				"C_DEPARTTIME");// 航班日期
		if (this.isNotNullOrEpt(flittime)) {
			thiswhere += " AND " + Orderinfo.COL_id
					+ " IN ( SELECT C_ORDERID FROM T_SEGMENTINFO WHERE ("
					+ flittime + ") ";
		}
		String repqytime = this.getCheckTime(repay_begintime, repay_endtime,
				"C_HKDATETIME");// 还款日期
		if (repqytime.length() > 0) {
			thiswhere += " AND ID IN (SELECT C_PASSENGER FROM T_PASSENGERREPAYRC WHERE ("
					+ repqytime + ") )";
			mwhere += " AND ("
					+ this.getCheckTime(repay_begintime, repay_endtime,
							Miscellaneous.COL_repaytime) + " )";
		}
		if (this.s_state > 0) {
			thiswhere += " AND " + Passenger.COL_hkstate + "=" + s_state;
		}
		sql += thiswhere;
		if (this.s_passengername != null
				&& this.s_passengername.trim().length() > 0) {// 乘机人
			String strwhere = " AND " + Passenger.COL_name + " LIKE '%"
					+ s_passengername + "%'";
			sql += strwhere;
			mwhere += " AND " + Miscellaneous.COL_name + " LIKE '"
					+ s_passengername + "%'";
		}
		String insurewhere = this.getCheckTime(issue_begintime, issue_endtime,
				Passenger.COL_rttime);
		if (insurewhere.length() > 0) {
			String strwhere = " AND (" + insurewhere + ")";
			sql += strwhere;
		}
		String chupiaowhere = sql
				+ " AND  "
				+ Passenger.COL_state
				+ " NOT IN (0,2,3,9,11,12,16,17) AND  C_PAYMETHOD=5 AND (C_FKMETHOD=8 OR C_FKMETHOD IS NULL )  ";
		if (!isExp) {
			System.out.println(pageinfo == null);
			List list = Server.getInstance().getSystemService()
					.findMapResultBySql(chupiaowhere, pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listPassenger = list;
			if (pageinfo.getTotalrow() > 0 && listPassenger.size() == 0) {
				pageinfo.setPagenum(1);
				list = Server.getInstance().getAirService()
						.findAllPassengerForPageinfo(chupiaowhere,
								" ORDER BY ID ASC ", pageinfo);
				pageinfo = (PageInfo) list.remove(0);
				listPassenger = list;
			}
		} else {
			return chupiaowhere;
		}
		this.otherPassenger();
		this.miscellList(mwhere);

		// 以下 代码 用于选中按钮
		System.out.println(this.listPassenger.size());
		String repayname = ServletActionContext.getRequest().getParameter(
				"repayname");
		StringBuffer js = new StringBuffer(
				"<script>$(document).ready(function(){");
		if (repayname == null) {
			js.append("feiyong(1);");
		} else if (repayname.trim().equals("other")) {
			js.append("feiyong(2);");
		} else {
			js.append("feiyong(3);");
		}
		js.append("});</script>");
		ServletActionContext.getRequest().setAttribute("repayjs", js);
		StringBuffer sb = new StringBuffer();
		sb.append("<input type=\"hidden\" name=\"s_department\" value=\""
				+ s_department + "\" />");
		sb.append("<input type=\"hidden\" name=\"repay_begintime\"  value=\""
				+ repay_begintime + "\" />");
		sb.append("<input type=\"hidden\" name=\"repay_endtime\"  value=\""
				+ repay_endtime + "\" />");
		sb.append("<input type=\"hidden\" name=\"username\"  value=\""
				+ username + "\" />");
		sb.append("<input type=\"hidden\" name=\"s_operator\"  value=\""
				+ s_operator + "\" />");
		sb.append("<input type=\"hidden\" name=\"flight_begintime\"  value=\""
				+ flight_begintime + "\" />");
		sb.append("<input type=\"hidden\" name=\"flight_endtime\"  value=\""
				+ flight_endtime + "\" />");
		sb.append("<input type=\"hidden\" name=\"issue_begintime\"  value=\""
				+ issue_begintime + "\" />");
		sb.append("<input type=\"hidden\" name=\"issue_endtime\"  value=\""
				+ issue_endtime + "\" />");
		sb.append("<input type=\"hidden\" name=\"s_passengername\"  value=\""
				+ s_passengername + "\" />");
		sb.append("<input type=\"hidden\" name=\"s_internal\"  value=\""
				+ s_internal + "\"/>");
		sb.append("<input type=\"hidden\" name=\"hkname\"  value=\"" + hkname
				+ "\"/>");
		sb.append("<input type=\"hidden\" name=\"s_ordernum\"  value=\""
				+ s_ordernum + "\"/>");
		sb.append("<input type=\"hidden\" name=\"s_ticketnum\"  value=\""
				+ s_ticketnum + "\"/>");
		sb.append("<input type=\"hidden\" name=\"repay\"  value=\"" + repay
				+ "\"/>");
		sb.append("<input type=\"hidden\" name=\"s_state\"  value=\"" + s_state
				+ "\"/>");
		ServletActionContext.getRequest().setAttribute("checkitem", sb);
		// System.out.println(repay);
		return "torepay";
	}

	public String otherPassenger() {
		String where = sql
				+ " AND "
				+ Passenger.COL_state
				+ " IN (2,3,9,16,17) AND  C_PAYMETHOD=5 AND (C_FKMETHOD=8 OR C_FKMETHOD IS NULL )";
		System.out.println(where);
		if (!isExp) {
			List list = Server.getInstance().getSystemService()
					.findMapResultBySql(where, pageother);
			pageother = (PageInfo) list.remove(0);
			otherlistPassenger = list;
		} else {
			return where;
		}
		/*
		 * float otherallrepay = 0f; float otherneedrepay = 0f; for (Passenger
		 * passenger : otherlistPassenger) { if (passenger.getYihai() == null) {
		 * passenger.setYihai(0f); } float insure = 0f; Insuranceinfo insurance =
		 * Server .getInstance() .getMemberService()
		 * .findInsuranceinfo(converNull(passenger.getInsurance(), 0l)); if
		 * (insurance != null) { String inmoney = insurance.getInsurancefee();
		 * insure = Long.valueOf(inmoney); } if (passenger.getState() == 9) {
		 * float titcketprice = passenger.getPrice();// 票价 float buildprice =
		 * passenger.getAirportfee();// 机建费 float oilprice =
		 * passenger.getFuelprice();// 燃油费 float
		 * safetyprice=converNull(passenger.getAnjianfee(),0f);//安检费 float
		 * otherprice=converNull(passenger.getOtherfee(),0f);//其他费用
		 * 
		 * float lastprice = titcketprice + buildprice + oilprice +
		 * insure+safetyprice+otherprice; passenger.setPrice(lastprice);
		 * passenger.setHaiqian(lastprice + passenger.getTuifee() -
		 * passenger.getYihai()); } else {
		 * passenger.setHaiqian(passenger.getTuifee() + insure -
		 * passenger.getYihai()); } otherallrepay += passenger.getYihai();
		 * otherneedrepay += passenger.getHaiqian(); }
		 * ServletActionContext.getRequest().setAttribute("otherallrepay",
		 * otherallrepay);
		 * ServletActionContext.getRequest().setAttribute("otherneedrepay",
		 * otherneedrepay);
		 */

		return "";
	}

	public String miscellList(String mwhere) {
		String where = "";
		where = " where 1=1 ";
		if (mwhere != null && mwhere.trim().length() > 0) {
			where += mwhere;
		}
		if (this.s_state > 0) {
			where += " AND " + Miscellaneous.COL_state + "=" + s_state;
		}

		if (!isExp) {
			List list = Server.getInstance().getMemberService()
					.findAllMiscellaneousForPageinfo(where, " ORDER BY ID ASC",
							pagezafei);
			pagezafei = (PageInfo) list.remove(0);
			listMiscellaneous = list;
			if (pagezafei.getTotalrow() > 0 && listMiscellaneous.size() == 0) {
				pagezafei.setPagenum(1);
				list = Server.getInstance().getMemberService()
						.findAllMiscellaneousForPageinfo(where,
								" ORDER BY ID ASC", pagezafei);
				pagezafei = (PageInfo) list.remove(0);
				listMiscellaneous = list;
			}
		} else {
			return where;
		}
		/*
		 * float mallrepay = 0f; float mneedrepay = 0f; for (Miscellaneous mis :
		 * listMiscellaneous) { if (mis.getYihai() == null) { mis.setYihai(0.0); }
		 * mis.setHaiqian((mis.getPrice() - mis.getYihai())); mallrepay +=
		 * mis.getYihai(); mneedrepay += mis.getHaiqian(); }
		 * ServletActionContext.getRequest().setAttribute("mallrepay",
		 * mallrepay); ServletActionContext.getRequest()
		 * .setAttribute("mneedrepay", mneedrepay);
		 */
		return "";
	}

	public float getHQPrice(Integer hkstate, Integer state, Float jp, Float bx,
			Float hq, Float tuifee) {
		// System.out.println(jp+":"+bx+":"+hq+":"+tuifee);
		// int hkstate=Integer.valueOf(hkstatestr.toString());
		// int state=Integer.valueOf(statestr.toString());
		// float jp=Float.valueOf(jpstr.toString());
		// float bx=Float.valueOf(bxstr.toString());
		// float hq=Float.valueOf(hqstr.toString());
		// float tuifee=Float.valueOf(tuifeestr.toString());
		if (hkstate != 1) {
			return hq;
		} else {
			// 改签
			if (state == 9) {
				return jp + bx + tuifee;
			} else if (state == 2 || state == 3 || state == 16 || state == 17) {
				return tuifee + bx;
			} else {
				return jp + bx;
			}

		}

	}

	/**
	 * 导出客户已还款账单
	 * 
	 * @throws Exception
	 */
	public void expRepayedBilltoExcel() throws Exception {
		String sql = "";
		try {
			isExp = true;
			sql = execute();
			pageinfo.setPagerow(2000);
			List list = Server.getInstance().getSystemService()
					.findMapResultBySql(sql, pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listPassenger = list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] titles = { "部门", "票号", "订单号", "乘客姓名", "航空公司", "航班号", "航程",
				"起飞日期", "机票全价", "折扣率", "折扣票价", "税", "保险费", "欠款总计", "返利",
				"实际结账", "出票日期", "机票状态", "还款状态", "还款金额", "还款人", "还款时间", "订单备注" };
		String name1 = "机票费用账单";
		String name2 = "退废改签费用账单";
		String name3 = "杂项费用账单";
		String name = "大客户所有账单.xls";
		if (repay != null) {
			name = "大客户已还款账单.xls";
			name1 = "机票费用已还款账单";
			name2 = "退废改签费已还款用账单";
			name3 = "杂项费用已还款账单";
		}
		name = new String(name.getBytes("GB2312"), "ISO8859-1");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/vnd.ms-excel");
		response
				.setHeader("Content-Disposition", "attachment;filename=" + name);
		HthyWritableWorkBook book = HthyWritableWorkBook.getInstance(response
				.getOutputStream());
		HthyWorkSheet sheet = book.createHthyWorkSheet(name1,
				titles.length + 10, pageinfo.getTotalrow() + 50);
		sheet.createOneRow(name1, 3);
		sheet.createOneRow("中国东方航空公司电子客票销售报告", 5);
		sheet.createOneRow("检索条件：");
		this.addOptions(sheet);
		sheet.createOneRow(titles, HthyWorkSheet.CenterBlod);
		int totalpage = pageinfo.getTotalpage();
		int listsize = listPassenger.size();
		float price = 0f;// haiqian
		float yihaipirce = 0f;
		int num = 0;
		for (int x = 1; x <= totalpage; x++) {
			for (int i = 0; i < listsize; i++) {
				num++;
				sheet.createRow();
				Map map = (HashMap) listPassenger.remove(0);
				yihaipirce += Float.valueOf(converNull(map.get("C_YIHAI"), "0")
						.toString());
				sheet.addCell(map.get("AGENTNAME"));
				sheet.addCell(map.get("C_TICKETNUM"));
				sheet.addCell(map.get("C_ORDERNUMBER"));
				sheet.addCell(map.get("C_NAME"));// 乘客姓名
				sheet.addCell(map.get("hangkonggongsi"));// 航空公司
				sheet.addCell(map.get("hangbanhao"));
				sheet.addCell(map.get("citypair"));
				sheet.addCell(map.get("chufashijian"));
				sheet.addCell(map.get("YPRICE"));// 机票全价
				sheet.addCell(map.get("DISCOUNT") + "%");// 折扣率
				sheet.addCell(map.get("C_PRICE"));
				sheet.addCell(map.get("DUTY"));
				sheet.addCell(map.get("INSURFEE"));
				int hkstate = Integer.valueOf(map.get("C_HKSTATE").toString());
				int state = Integer.valueOf(map.get("C_STATE").toString());
				float jp = Float.valueOf(map.get("C_PRICE").toString())
						+ Float.valueOf(map.get("DUTY").toString());
				float bx = Float.valueOf(map.get("INSURFEE").toString());
				float hq = Float.valueOf(map.get("HQ").toString());
				float tuifee = Float.valueOf(converNull(map.get("C_TUIFEE"),
						"0").toString());
				float qkzj = this
						.getHQPrice(hkstate, state, jp, bx, hq, tuifee);
				sheet.addCell(qkzj);// 欠款总计
				price += qkzj;
				sheet.addCell(converNull(map.get("C_FENXIAOSHANGFANDIAN"), 0));// 返利
				sheet.addCell(map.get("C_YIHAI"));// 实际结账
				sheet.addCell(map.get("C_PRINTTIME"));
				sheet.addCell(getpassstate(state));
				String hkstateSTR = hkstate == 1 ? "未还款" : hkstate == 2 ? "已还款"
						: "部分还款";
				sheet.addCell(hkstateSTR);
				sheet.addCell(converNull(map.get("C_YIHAI"), 0));
				sheet.addCell(converNull(map.get("HKNAME"), ""));
				sheet.addCell(converNull(map.get("HKTIME"), ""));
				sheet.addCell(map.get("C_MEMO"));// 订单备注
				sheet.rowOver();
				if (num % 200 == 0) {
					book.flush();
					book.write();
				}

			}
			if (x < totalpage) {
				pageinfo.setPagenum(x + 1);
				pageinfo.setPagerow(2000);
				List list = Server.getInstance().getSystemService()
						.findMapResultBySql(sql, pageinfo);
				pageinfo = (PageInfo) list.remove(0);
				listPassenger = list;

			} else {
				break;
			}
		}
		sheet
				.createOneRow(new String[] { "机票费用已还：",
						String.valueOf(yihaipirce) });
		sheet.createOneRow(new String[] { "机票费用还欠：", String.valueOf(price) });
		sheet.sheetOver();
		// 部门、票号、订单序号、乘客姓名、航空公司、航班号、出发城市、目的城市、起飞日期、起飞时刻、机票全价、折扣率、折扣票价、机建费、燃油费、退票费、总价、返利、实际结账、出票日期、机票状态、是否付款、订单备注
		String[] titles2 = { "部门", "票号", "订单号", "乘客姓名", "航空公司", "航班号", "航程",
				"起飞日期", "机票全价", "折扣率", "折扣票价", "税", "保险费", "退改签费", "欠款总计",
				"返利", "实际结账", "出票日期", "机票状态", "还款状态", "还款金额", "还款人", "还款时间",
				"订单备注" };
		pageother.setPagerow(2000);
		String othersql = this.otherPassenger();
		List list = Server.getInstance().getSystemService().findMapResultBySql(
				othersql, pageother);
		pageother = (PageInfo) list.remove(0);
		otherlistPassenger = list;
		HthyWorkSheet sheettfg = book.createHthyWorkSheet("退废改签",
				titles2.length + 10, pageother.getTotalrow() + 50);
		sheettfg.createOneRow(name2, 3);
		sheettfg.createOneRow("中国东方航空公司电子客票销售报告", 5);
		sheettfg.createOneRow("检索条件：");
		this.addOptions(sheettfg);
		sheettfg.createOneRow(titles, HthyWorkSheet.CenterBlod);
		float tuiyihai = 0f;
		float tuihaiqian = 0f;
		int othertotalpage = pageother.getTotalpage();
		int otherlistsize = otherlistPassenger.size();
		for (int x = 1; x <= othertotalpage; x++) {
			for (int i = 0; i < otherlistsize; i++) {
				num++;
				sheettfg.createRow();
				Map map = (HashMap) otherlistPassenger.get(i);
				tuiyihai += Float.valueOf(converNull(map.get("C_YIHAI"), "0")
						.toString());
				sheettfg.addCell(map.get("AGENTNAME"));
				sheettfg.addCell(map.get("C_TICKETNUM"));
				sheettfg.addCell(map.get("C_ORDERNUMBER"));
				sheettfg.addCell(map.get("C_NAME"));// 乘客姓名
				sheettfg.addCell(map.get("hangkonggongsi"));// 航空公司
				sheettfg.addCell(map.get("hangbanhao"));
				sheettfg.addCell(map.get("citypair"));
				sheettfg.addCell(map.get("chufashijian"));
				sheettfg.addCell(map.get("YPRICE"));// 机票全价
				sheettfg.addCell(map.get("DISCOUNT") + "%");// 折扣率
				sheettfg.addCell(map.get("C_PRICE"));
				sheettfg.addCell(map.get("DUTY"));
				sheettfg.addCell(map.get("INSURFEE"));
				sheettfg.addCell(map.get("C_TUIFEE"));
				int hkstate = Integer.valueOf(map.get("C_HKSTATE").toString());
				int state = Integer.valueOf(map.get("C_STATE").toString());
				float jp = Float.valueOf(map.get("C_PRICE").toString())
						+ Float.valueOf(map.get("DUTY").toString());
				float bx = Float.valueOf(map.get("INSURFEE").toString());
				float hq = Float.valueOf(map.get("HQ").toString());
				float tuifee = Float.valueOf(map.get("C_TUIFEE").toString());
				float qkzj = this
						.getHQPrice(hkstate, state, jp, bx, hq, tuifee);
				sheettfg.addCell(qkzj);// 欠款总计
				tuihaiqian += qkzj;
				sheettfg.addCell(map.get("C_FENXIAOSHANGFANDIAN"));// 返利
				sheettfg.addCell(map.get("C_YIHAI"));// 实际结账
				sheettfg.addCell(map.get("C_PRINTTIME"));
				sheettfg.addCell(getpassstate(state));
				String hkstatestr = state == 1 ? "未还款" : state == 2 ? "已还款"
						: "部分还款";
				sheettfg.addCell(hkstatestr);
				sheettfg.addCell(converNull(map.get("C_YIHAI"), 0));
				sheettfg.addCell(converNull(map.get("HKNAME"), ""));
				sheettfg.addCell(converNull(map.get("HKTIME"), ""));
				sheettfg.addCell(map.get("C_MEMO"));
				sheettfg.rowOver();
				if (num % 200 == 0) {
					book.flush();
					book.write();
				}
			}
			if (x < totalpage) {
				pageother.setPagenum(x + 1);
				pageother.setPagerow(2000);
				list = Server.getInstance().getSystemService()
						.findMapResultBySql(sql, pageother);
				pageother = (PageInfo) list.remove(0);
				otherlistPassenger = list;

			} else {
				break;
			}
		}
		sheettfg.createOneRow(new String[] { "退废改签已还：",
				String.valueOf(tuiyihai) });
		sheettfg.createOneRow(new String[] { "退废改签还欠：",
				String.valueOf(tuihaiqian) });
		sheettfg.sheetOver();

		String[] titles3 = { "部门", "联系人", "旅客姓名", "费用", "消费时间", "备注", "还款状态" };
		List zxlist = Server.getInstance().getMemberService()
				.findAllMiscellaneousForPageinfo(mwhere, " ORDER BY ID ASC",
						pagezafei);
		pagezafei = (PageInfo) zxlist.remove(0);
		listMiscellaneous = zxlist;
		HthyWorkSheet sheetzx = book.createHthyWorkSheet("杂项费",
				titles3.length + 10, pagezafei.getTotalrow() + 50);
		sheetzx.createOneRow(name3, 3);
		sheetzx.createOneRow("中国东方航空公司电子客票销售报告", 5);
		sheetzx.createOneRow("检索条件：");
		List oplist = new ArrayList<String>();
		if (this.isNotNullOrEpt(companyname)) {
			oplist.add("大客户：");
			oplist.add(companyname);
		}
		if (this.isNotNullOrEpt(username)) {
			oplist.add("联系人：");
			oplist.add(username);
		}
		sheetzx.createOneRow(oplist);
		this.addOptions(sheetzx);
		sheetzx.createOneRow(titles3, HthyWorkSheet.CenterBlod);

		double zxyihai = 0f;
		double zxhaiqian = 0f;
		int pagezatotal = pagezafei.getTotalpage();
		int listzsize = listMiscellaneous.size();
		for (int x = 1; x <= pagezatotal; x++) {
			for (int i = 0; i < listzsize; i++) {
				num++;
				Miscellaneous m = listMiscellaneous.remove(i);
				sheetzx.createRow();
				sheetzx
						.addCell(getDeptNameByID(converNull(m.getDepartment(),
								0).toString()));
				sheetzx.addCell(this.getusername(m.getCustomerid()));
				sheetzx.addCell(m.getName());
				sheetzx.addCell(m.getPrice());
				sheetzx.addCell(m.getSpenddate());
				sheetzx.addCell(m.getDescription());
				String hkstate = m.getState() == 1 ? "未还款"
						: m.getState() == 2 ? "已还款" : "部分还款";
				sheetzx.addCell(hkstate);
				zxhaiqian += m.getState() == 1 ? m.getPrice() : m.getHaiqian();
				zxyihai = m.getYihai();
				sheetzx.rowOver();
				if (num % 200 == 0) {
					book.flush();
					book.write();
				}
				if (x < totalpage) {
					pagezafei.setPagenum(x + 1);
					pagezafei.setPagerow(2000);
					zxlist = Server.getInstance().getMemberService()
							.findAllMiscellaneousForPageinfo(mwhere,
									" ORDER BY ID ASC", pagezafei);
					pagezafei = (PageInfo) zxlist.remove(0);
					listMiscellaneous = zxlist;

				} else {
					break;
				}
			}

		}

		sheetzx
				.createOneRow(new String[] { "杂项费用已还：", String.valueOf(zxyihai) });
		sheetzx.createOneRow(new String[] { "杂项费用还欠：",
				String.valueOf(zxhaiqian) });
		sheetzx.sheetOver();
		book.write();
		book.close();
	}

	/**
	 * 为报表添加检索条件，详看expRepayedBilltoExcel
	 */
	private void addOptions(HthyWorkSheet sheet) {

		List<String> options = new ArrayList<String>();
		if (this.isNotNullOrEpt(companyname)) {
			options.add("大客户:");
			options.add(companyname);
		}
		String cptime = this.getCheckTime(issue_begintime, issue_endtime);
		if (this.isNotNullOrEpt(cptime)) {
			options.add("出票起止日期:");
			options.add(cptime);
		}
		String hktime = this.getCheckTime(repay_begintime, repay_endtime);
		if (this.isNotNullOrEpt(hktime)) {
			options.add("还款起止日期:");
			options.add(hktime);
		}
		String hbtime = this.getCheckTime(flight_begintime, flight_endtime);
		if (this.isNotNullOrEpt(hbtime)) {
			options.add("航班起止日期:");
			options.add(hbtime);
		}
		if (this.isNotNullOrEpt(hkname)) {
			options.add("还款人:");
			options.add(hkname);
		}
		if (this.isNotNullOrEpt(username)) {
			options.add("联系人:");
			options.add(username);
		}
		if (this.isNotNullOrEpt(s_operator)) {
			options.add("预订人:");
			options.add(s_operator);
		}
		if (this.isNotNullOrEpt(s_passengername)) {
			options.add("乘机人:");
			options.add(s_passengername);
		}

		if (this.isNotNullOrEpt(this.s_ordernum)) {
			options.add("订单号:");
			options.add(s_ordernum);
		}
		if (this.isNotNullOrEpt(this.s_ticketnum)) {
			options.add("票号:");
			options.add(s_ticketnum);
		}
		if (this.s_state > 0) {
			options.add("还款状态:");
			options.add(s_state == 1 ? "未还款" : s_state == 2 ? "已还款" : "部分还款");
		}
		sheet.createOneRow(options);
	}

	/**
	 * 获得订单备注信息
	 * 
	 * @param orderid
	 * @return
	 */
	private String getOrderMemo(long orderid) {
		Orderinfo orderinfo = Server.getInstance().getAirService()
				.findOrderinfo(orderid);
		if (orderinfo != null) {
			return converNull(orderinfo.getMemo(), "");
		}
		return "";
	}

	/**
	 * @param insurid
	 * @return 获得保险费
	 */
	public float getInsuranceFeeById(long insurid) {
		float insurfee = 0f;
		if (insurid > 0) {
			Insuranceinfo insruance = Server.getInstance().getMemberService()
					.findInsuranceinfo(insurid);
			if (insruance != null)
				;
			insurfee = Float.valueOf(insruance.getInsurancefee());
		}
		return insurfee;
	}

	/**
	 * @return 导出Excel
	 */
	public void expexcel(String[] titles, List<List<String>> values,
			String name, String sheetname) {
		HttpServletResponse response = ServletActionContext.getResponse();
		// response.reset();
		response.setContentType("APPLICATION/DOWNLOAD");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-disposition", "attachment; filename="
				+ name + ".xls");// 设定输出文件头
		// response.setContentType("application/msexcel");// 定义输出类型

		try {
			OutputStream os = response.getOutputStream();
			WritableWorkbook book = Workbook.createWorkbook(os);
			WritableSheet sheet = book.createSheet(sheetname, 0);
			int i = 0;
			for (String title : titles) {
				Label labeltitle = new Label(0, i, title);
				sheet.addCell(labeltitle);
				i++;
			}
			int j = 1;
			int k = 0;
			for (List<String> liststring : values) {
				for (String str : liststring) {
					Label labeltitle = new Label(j, k, str);
					sheet.addCell(labeltitle);
					k++;
				}
				j++;
			}
			// System.out.println("*******************************");
			book.write();
			book.close();
			os.close();
		} catch (IOException e) {
		} catch (RowsExceededException e) {
		} catch (WriteException e) {
		}
	}

	private void getString(long id, long agid, long flag) {
		List<Department> list = Server.getInstance().getMemberService()
				.findAllDepartment(
						"where " + Department.COL_parentid + " =" + id
								+ " and " + Department.COL_agentid + " ="
								+ agid, "ORDER BY ID", -1, 0);
		if (flag > 0) {

			treestr += "var sub_" + agid + " = new Ext.tree.TreeNode({ id:'"
					+ agid + "',  text:'" + getagentname_b2bback(agid)
					+ "'});\n";

			treestr += "root.appendChild(sub_" + agid + ");\n";
		}
		if (!list.isEmpty()) {

			for (Department m : list) {
				if (id == -1) {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "',  text:'" + m.getName() + "'});\n";

					treestr += "sub_" + agid + ".appendChild(sub_" + m.getId()
							+ ");\n";
				} else {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "', text:'" + m.getName() + "'});\n";

					treestr += "sub_" + id + ".appendChild(sub_" + m.getId()
							+ ");\n";

				}
				getString(m.getId(), agid, -1);
			}
		}

	}

	public String seach() throws Exception {
		String where = " where 1=1 and " + Passenger.COL_state
				+ " IN (1,2,3,9) ";
		if (s_department != null && s_department.trim().length() != 0) {
			where += " and " + Passenger.COL_orderid + " in (select "
					+ Orderinfo.COL_id + " from " + Orderinfo.TABLE + " where "
					+ Orderinfo.COL_customeruserid + " in (select "
					+ Customeruser.COL_id + " from " + Customeruser.TABLE
					+ " where " + Customeruser.COL_agentid + " in (select "
					+ Department.COL_agentid + " from " + Department.TABLE
					+ " where " + Department.COL_id + "=" + s_department
					+ " )))";
		}
		if (username != null && username.trim().length() != 0) {
			where += " and " + Passenger.COL_name + " like '%"
					+ username.trim() + "%'";
		}
		if (s_state > 0) {
			where += " and " + Passenger.COL_hkstate + " =" + s_state;
		}
		// System.out.println("where==" + where);

		if (s_passenger != null && s_passenger.trim().length() != 0) {

			where += " and " + Passenger.COL_name + " like '%"
					+ s_passenger.trim() + "%'";
		}

		// 预订人
		if (s_operator != null && s_operator.trim().length() != 0) {
			where += "and " + Passenger.COL_orderid + " in (select "
					+ Orderinfo.COL_id + " from " + Orderinfo.TABLE + " where "
					+ Orderinfo.COL_customeruserid + " in (select "
					+ Customeruser.COL_id + " from " + Customeruser.TABLE
					+ " where " + Customeruser.COL_membername + " like '%"
					+ s_operator + "%')";
		}

		List list = Server.getInstance().getAirService()
				.findAllPassengerForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listPassenger = list;
		if (pageinfo.getTotalrow() > 0 && listPassenger.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllPassengerForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listPassenger = list;
		}
		listCustomeragent = Server.getInstance().getMemberService()
				.findAllCustomeragent(
						"where 1=1 and " + Customeragent.COL_userid + " ="
								+ getLoginUserId(), "", -1, 0);

		String wheresql = " where " + Customeragent.COL_bigtype + " = 1";
		if (!isAdmin()) {
			wheresql += " AND " + Customeragent.COL_id + " ="
					+ this.getLoginUser().getAgentid();
		}
		List<Customeragent> list2 = Server.getInstance().getMemberService()
				.findAllCustomeragent(where, "", -1, 0);
		for (Customeragent customeragent : list2) {
			getString(-1, customeragent.getId(), 1);
		}
		return SUCCESS;
	}

	/**
	 * 转向到乘机人表添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到乘机人表修改页面
	 */
	public String toedit() throws Exception {
		passenger = Server.getInstance().getAirService().findPassenger(
				passenger.getId());
		return EDIT;
	}

	/**
	 * 转向到乘机人表审核页面
	 */
	public String tocheck() throws Exception {
		passenger = Server.getInstance().getAirService().findPassenger(
				passenger.getId());
		return CHECK;
	}

	/**
	 * 添加乘机人表
	 */
	public String add() throws Exception {

		Server.getInstance().getAirService().createPassenger(passenger);
		return LIST;
	}

	/**
	 * 添加乘机人表
	 */
	public String addpassenger() throws Exception {
		String eei = passenger.getEi();
		// eei=new String(request.getParameter("eei").getBytes("8859_1"));

		System.out.println("EI====" + eei);
		System.out.println("行程单号===" + passenger.getFet());
		System.out.println("票号===" + passenger.getTicketnum());

		String[] eiei = eei.split(",");
		String[] fetfet = passenger.getFet().toString().split(",");
		String[] tictic = passenger.getTicketnum().toString().split(",");
		String[] pppid = pid.split(",");

		/*
		 * String[] eiei = passenger.getEi().toString().split("|"); String[]
		 * fetfet =passenger.getFet().toString().split("|"); String[] tictic
		 * =passenger.getTicketnum().toString().split("|");
		 */

		for (int i = 0; i < tictic.length; i++) {
			long dd = Long.parseLong(pppid[i].toString());
			passenger = Server.getInstance().getAirService().findPassenger(dd);
			if (eiei.length != 0) {
				passenger.setEi(eiei[i]);
			} else {
				passenger.setEi("");
			}
			if (fetfet.length != 0) {
				passenger.setFet(fetfet[i]);
			} else {
				passenger.setFet("");
			}
			passenger.setTicketnum(tictic[i]);

			Server.getInstance().getAirService().updatePassengerIgnoreNull(
					passenger);

		}

		/*
		 * System.out.println("EI===="+passenger.getEi());
		 * System.out.println("行程单号==="+passenger.getFet());
		 * System.out.println("票号==="+passenger.getTicketnum());
		 * Server.getInstance().getAirService().createPassenger(passenger);
		 */
		return LIST;
	}

	/**
	 * 转向出票预览
	 */
	public String orderchupiao() throws Exception {
		orderinfo=Server.getInstance().getAirService().findOrderinfo(orderinfoid);
		String where = " where 1=1  and " + Passenger.COL_orderid + " = "
				+ orderinfoid+" AND "+Passenger.COL_state + "<>12";
		
		where+=" AND "+Passenger.COL_id+" NOT IN ( SELECT "+Qqinfo.COL_qqtype+" FROM "+Qqinfo.TABLE+" )";
		
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, " ORDER BY ID ", -1, 0);

		/*
		 * passenger =
		 * Server.getInstance().getAirService().findPassenger(orderinfoid);
		 * orderinfo =
		 * Server.getInstance().getAirService().findOrderinfo(orderinfoid);
		 */

		// Server.getInstance().getAirService().updatePassengerIgnoreNull(passenger);
		return "orderchupiao";
	}
	/**
	 * 转向出票预览-信息单
	 */
	public String orderchupiao2() throws Exception {
		orderinfo=Server.getInstance().getAirService().findOrderinfo(orderinfoid);
		String where = " where 1=1  and " + Passenger.COL_orderid + " = "
				+ orderinfoid;
		
		//where+=" AND "+Passenger.COL_id+" NOT IN ( SELECT "+Qqinfo.COL_qqtype+" FROM "+Qqinfo.TABLE+" )";
		
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, " ORDER BY ID ", -1, 0);

		/*
		 * passenger =
		 * Server.getInstance().getAirService().findPassenger(orderinfoid);
		 * orderinfo =
		 * Server.getInstance().getAirService().findOrderinfo(orderinfoid);
		 */

		// Server.getInstance().getAirService().updatePassengerIgnoreNull(passenger);
		return "orderchupiao2";
	}
	/**
	 * 转向出票预览-信息单
	 */
	public String toxxd() throws Exception {
		orderinfo=Server.getInstance().getAirService().findOrderinfo(orderinfoid);
		String where = " where 1=1  and " + Passenger.COL_orderid + " = "
				+ orderinfoid;
		
		//where+=" AND "+Passenger.COL_id+" NOT IN ( SELECT "+Qqinfo.COL_qqtype+" FROM "+Qqinfo.TABLE+" )";
		
		listPassenger = Server.getInstance().getAirService().findAllPassenger(
				where, " ORDER BY ID ", -1, 0);

		/*
		 * passenger =
		 * Server.getInstance().getAirService().findPassenger(orderinfoid);
		 * orderinfo =
		 * Server.getInstance().getAirService().findOrderinfo(orderinfoid);
		 */

		// Server.getInstance().getAirService().updatePassengerIgnoreNull(passenger);
		return "toxxd";
	}

	/**
	 * 转向出票
	 */
	public String tochupiao() throws Exception {
		String where = " where 1=1  and " + Passenger.COL_orderid + " = "
				+ orderinfoid;
		// listPassenger =
		// Server.getInstance().getAirService().findAllPassenger(where, " ORDER
		// BY ID ", -1, 0);
		passenger = Server.getInstance().getAirService().findPassenger(ppid);
		listsegmentinfo = Server.getInstance().getAirService()
				.findAllSegmentinfo(
						"where 1=1 and " + Segmentinfo.COL_orderid + " ="
								+ orderinfoid, " ORDER BY ID ", -1, 0);
		
		DecimalFormat myDf=new DecimalFormat("0.00");
		
		if(passenger.getAirportfee()!=null)
			passangerAirportfee=myDf.format(passenger.getAirportfee());
		if(passenger.getFuelprice()!=null)
			passangerFuelprice=myDf.format(passenger.getFuelprice());
		if(passenger.getFet()!=null)
		{
			passengerXingchengdan=passenger.getFet();
		}
		
		segmentinfo = listsegmentinfo.get(0);

		if(passenger.getPrice()!=null){
			passangerPrice=myDf.format(segmentinfo.getParvalue());
		}
		//总的费用
		float personprice=Float.parseFloat(passangerPrice)+converNull(passenger.getAirportfee(),0f)+converNull(passenger.getFuelprice(),0f);
		passangerTotalfuelfee=personprice+"";
		

		orderinfo = Server.getInstance().getAirService().findOrderinfo(
				orderinfoid);

		System.out.println("passenger==" + passenger);
		System.out.println("segmentinfo==" + segmentinfo);
		System.out.println("orderinfo==" + orderinfo);
		// Server.getInstance().getAirService().updatePassengerIgnoreNull(passenger);
		return "chupiao";
	}
	
	/**
	 * 审核乘机人表
	 */
	public String check() throws Exception {

		Server.getInstance().getAirService().updatePassengerIgnoreNull(
				passenger);
		return LIST;
	}

	/**
	 * 编辑乘机人表
	 */
	public String edit() throws Exception {

		Server.getInstance().getAirService().updatePassengerIgnoreNull(
				passenger);
		return LIST;
	}

	/**
	 * 删除乘机人表
	 */
	public String delete() throws Exception {
		Server.getInstance().getAirService().deletePassenger(passenger.getId());
		return LIST;
	}

	// 取机场城市名称
	public String getname(String name) {
		// Server.getInstance().getMemberroleManager().findMemberrole(id).getName();
		listcityairport = Server.getInstance().getAirService()
				.findAllCityairport(
						" where 1=1 and " + Cityairport.COL_airportcode
								+ " like '%" + name + "%'", " ORDER BY ID ",
						-1, 0);
		System.out.println(" where 1=1 and " + Cityairport.COL_airportcode
				+ " like '%" + name + "%'");
		if (listcityairport != null && listcityairport.size() > 0) {
			return listcityairport.get(0).getCityname();
		}
		return "";
	}

	// 取机场名称
	public String gethangname(String name) {
		// Server.getInstance().getMemberroleManager().findMemberrole(id).getName();
		listaircompany = Server.getInstance().getAirService()
				.findAllAircompany(
						" where 1=1 and " + Aircompany.COL_aircomcode
								+ " like '%" + name + "%'", " ORDER BY ID ",
						-1, 0);

		if (listaircompany != null && listaircompany.size() > 0) {
			return listaircompany.get(0).getAircomjname();
		}
		return "";
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
					Server.getInstance().getAirService().deletePassenger(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 批量提取行程单，每月1号、8号、15号、22号凌晨1时自动提取前两周的未提取的机票行程单号
	 */
	public String autocompRepNum() {
		String strRet = "0";
		// 每月1号、8号、15号、22号
		if (getDay() == 1 || getDay() == 8 || getDay() == 15 || getDay() == 22) {
			if (getHour() == 1 && getMinute() == 5) {
				// 开始执行自动提取行程单功能
				System.out.println("开始执行自动提取行程单功能-"
						+ new SimpleDateFormat("yyyy-MM-dd").format(new Date(
								System.currentTimeMillis())));
				// 时间范围
				String strwhere = " WHERE " + Passenger.COL_rttime
						+ " between '" + getDatestr(-14) + "' and '"
						+ getDatestr(0) + "'";
				// 有票号并且没有行程单号
				strwhere += " and " + Passenger.COL_ticketnum
						+ " is not null and " + Passenger.COL_ticketnum
						+ "<>''";
				strwhere += " and (" + Passenger.COL_fet + " is null OR "
						+ Passenger.COL_fet + "='')";
				List<Passenger> listpassenger = Server.getInstance()
						.getAirService().findAllPassenger(strwhere,
								"ORDER BY ID", -1, 0);
				for (Passenger passenger : listpassenger) {
					if (passenger.getFet().equals("")) {
						passenger
								.setFet(getReptNumber(passenger.getTicketnum()));
						Server.getInstance().getAirService()
								.updatePassengerIgnoreNull(passenger);
					}
				}
				strRet = "1";

			}
		}
		return strRet;
	}

	// 取得今天是几号
	public static int getDay() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(c.getTimeInMillis()));
		return c.get(Calendar.DAY_OF_MONTH);
	}

	// 取得现在是几点
	public static int getHour() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(c.getTimeInMillis()));
		return c.get(Calendar.HOUR_OF_DAY);
	}

	// 取得现在是几分
	public static int getMinute() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(c.getTimeInMillis()));
		return c.get(Calendar.MINUTE);
	}

	/**
	 * 返回乘机人表对象
	 */

	public Object getModel() {
		return passenger;
	}

	public List<Passenger> getListPassenger() {
		return listPassenger;
	}

	public void setListPassenger(List<Passenger> listPassenger) {
		this.listPassenger = listPassenger;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
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

	public String getEi() {
		return ei;
	}

	public void setEi(String ei) {
		this.ei = ei;
	}

	public String getFet() {
		return fet;
	}

	public void setFet(String fet) {
		this.fet = fet;
	}

	public String getTicketnum() {
		return ticketnum;
	}

	public void setTicketnum(String ticketnum) {
		this.ticketnum = ticketnum;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public long getOrderinfoid() {
		return orderinfoid;
	}

	public void setOrderinfoid(long orderinfoid) {
		this.orderinfoid = orderinfoid;
	}

	public Orderinfo getOrderinfo() {
		return orderinfo;
	}

	public void setOrderinfo(Orderinfo orderinfo) {
		this.orderinfo = orderinfo;
	}

	public Segmentinfo getSegmentinfo() {
		return segmentinfo;
	}

	public void setSegmentinfo(Segmentinfo segmentinfo) {
		this.segmentinfo = segmentinfo;
	}

	public List<Segmentinfo> getListsegmentinfo() {
		return listsegmentinfo;
	}

	public void setListsegmentinfo(List<Segmentinfo> listsegmentinfo) {
		this.listsegmentinfo = listsegmentinfo;
	}

	public long getPpid() {
		return ppid;
	}

	public void setPpid(long ppid) {
		this.ppid = ppid;
	}

	public Cityairport getCityairport() {
		return cityairport;
	}

	public void setCityairport(Cityairport cityairport) {
		this.cityairport = cityairport;
	}

	public List<Cityairport> getListcityairport() {
		return listcityairport;
	}

	public void setListcityairport(List<Cityairport> listcityairport) {
		this.listcityairport = listcityairport;
	}

	public Aircompany getAircompany() {
		return aircompany;
	}

	public void setAircompany(Aircompany aircompany) {
		this.aircompany = aircompany;
	}

	public List<Aircompany> getListaircompany() {
		return listaircompany;
	}

	public void setListaircompany(List<Aircompany> listaircompany) {
		this.listaircompany = listaircompany;
	}

	public List<Customeragent> getListCustomeragent() {
		return listCustomeragent;
	}

	public void setListCustomeragent(List<Customeragent> listCustomeragent) {
		this.listCustomeragent = listCustomeragent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrdercode() {
		return ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public long getAngentid() {
		return angentid;
	}

	public void setAngentid(int angentid) {
		this.angentid = angentid;
	}

	public int getS_state() {
		return s_state;
	}

	public void setS_state(int s_state) {
		this.s_state = s_state;
	}

	public void setAngentid(long angentid) {
		this.angentid = angentid;
	}

	public String getTreestr() {
		return treestr;
	}

	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}

	public String getS_department() {
		return s_department;
	}

	public void setS_department(String s_department) {
		this.s_department = s_department;
	}

	public String getS_passenger() {
		return s_passenger;
	}

	public void setS_passenger(String s_passenger) {
		this.s_passenger = s_passenger;
	}

	public String getS_operator() {
		return s_operator;
	}

	public void setS_operator(String s_operator) {
		this.s_operator = s_operator;
	}

	public String getCriditcardNameById(int id) {
		switch (id) {
		case 1:
			return "身份证";
		case 2:
			return "驾驶证";
		case 3:
			return "护照";
		case 4:
			return "港澳同行正";
		case 5:
			return "台湾同行证";
		case 6:
			return "台胞证";
		case 7:
			return "回乡证";
		}

		return "其它";
	}

	public List<Passenger> getOtherlistPassenger() {
		return otherlistPassenger;
	}

	public void setOtherlistPassenger(List<Passenger> otherlistPassenger) {
		this.otherlistPassenger = otherlistPassenger;
	}

	public List<Miscellaneous> getListMiscellaneous() {
		return listMiscellaneous;
	}

	public void setListMiscellaneous(List<Miscellaneous> listMiscellaneous) {
		this.listMiscellaneous = listMiscellaneous;
	}

	/**
	 * @param orderid
	 * @return 获得订单联系人
	 */
	public String getlinkManName(long orderid) {
		return Server.getInstance().getAirService().findOrderinfo(orderid)
				.getContactname();
	}

	/**
	 * @param orderid
	 * @return 获得订单预订人
	 */
	public String getOrderName(long orderid) {
		return this.getusername(Server.getInstance().getAirService()
				.findOrderinfo(orderid).getSaleagentid());
	}

	/**
	 * @param orderid
	 * @return 根据订单号获得航程
	 */
	public String getFlight(long orderid) {
		List<Segmentinfo> segments = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + orderid, "", -1, 0);
		if (segments.size() > 0) {
			Segmentinfo segment = segments.get(0);
			return getCitynameByAirport(segment.getStartairport()) + "-"
					+ getCitynameByAirport(segment.getEndairport());
		}
		return "";
	}

	public String getFlight(long orderid, int num) {
		String where = " WHERE " + Segmentinfo.COL_orderid + "=" + orderid;
		List<Segmentinfo> segments = (List<Segmentinfo>) Server.getInstance()
				.getAirService().findAllSegmentinfo(where, "", -1, 0);
		Segmentinfo segment = null;
		if (segments.size() > 0) {
			segment = segments.get(0);
			if (num == 1) {
				return getCitynameByAirport(segment.getStartairport());
			} else {

				return getCitynameByAirport(segment.getEndairport());
			}
		}
		return "";

	}

	public String getSegmentInfo(long orderid, String methoeName)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		List<Segmentinfo> segments = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + orderid, "", -1, 0);
		Method segMethod = Segmentinfo.class.getMethod(methoeName, null);
		if (segments != null && segments.size() > 0) {
			Segmentinfo segmentinfo = segments.get(0);

			return segMethod.invoke(segmentinfo, null).toString();

		}
		return "";

	}

	/**
	 * @param orderid
	 * @return 根据订单号获得航程时间
	 */
	public String getFlighttime(long orderid) {
		List<Segmentinfo> segments = Server.getInstance().getAirService()
				.findAllSegmentinfo("WHERE C_ORDERID=" + orderid, "", -1, 0);
		if (segments.size() > 0) {
			Segmentinfo segment = segments.get(0);
			return formatTimestamptoMinute(segment.getDeparttime()).toString();
		}
		return "";
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void getReptNumberByTN() throws Exception {
		String strReturn = "";
		strReturn = getReptNumber(s_ticketnumber);

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getIssue_begintime() {
		return issue_begintime;
	}

	public void setIssue_begintime(String issue_begintime) {
		this.issue_begintime = issue_begintime;
	}

	public String getIssue_endtime() {
		return issue_endtime;
	}

	public void setIssue_endtime(String issue_endtime) {
		this.issue_endtime = issue_endtime;
	}

	public String getFlight_begintime() {
		return flight_begintime;
	}

	public void setFlight_begintime(String flight_begintime) {
		this.flight_begintime = flight_begintime;
	}

	public String getFlight_endtime() {
		return flight_endtime;
	}

	public void setFlight_endtime(String flight_endtime) {
		this.flight_endtime = flight_endtime;
	}

	public String getRepay() {
		return repay;
	}

	public void setRepay(String repay) {
		this.repay = repay;
	}

	public String getRepay_begintime() {
		return repay_begintime;
	}

	public void setRepay_begintime(String repay_begintime) {
		this.repay_begintime = repay_begintime;
	}

	public String getRepay_endtime() {
		return repay_endtime;
	}

	public void setRepay_endtime(String repay_endtime) {
		this.repay_endtime = repay_endtime;
	}

	public String getS_passengername() {
		return s_passengername;
	}

	public void setS_passengername(String s_passengername) {
		this.s_passengername = s_passengername;
	}

	public String getS_ticketnumber() {
		return s_ticketnumber;
	}

	public void setS_ticketnumber(String s_ticketnumber) {
		this.s_ticketnumber = s_ticketnumber;
	}

	public int getS_internal() {
		return s_internal;
	}

	public void setS_internal(int s_internal) {
		this.s_internal = s_internal;
	}

	public String getHkname() {
		return hkname;
	}

	public void setHkname(String hkname) {
		this.hkname = hkname;
	}

	public String getS_ordernum() {
		return s_ordernum;
	}

	public void setS_ordernum(String s_ordernum) {
		this.s_ordernum = s_ordernum;
	}

	public String getS_ticketnum() {
		return s_ticketnum;
	}

	public void setS_ticketnum(String s_ticketnum) {
		this.s_ticketnum = s_ticketnum;
	}

	public String getPassangerPrice() {
		return passangerPrice;
	}

	public String getPassangerAirportfee() {
		return passangerAirportfee;
	}

	public String getPassangerFuelprice() {
		return passangerFuelprice;
	}

	public String getPassangerTotalfuelfee() {
		return passangerTotalfuelfee;
	}

	public String getPassengerXingchengdan() {
		return passengerXingchengdan;
	}

	public void setPassengerXingchengdan(String passengerXingchengdan) {
		this.passengerXingchengdan = passengerXingchengdan;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public long getPassid() {
		return passid;
	}

	public void setPassid(long passid) {
		this.passid = passid;
	}
}