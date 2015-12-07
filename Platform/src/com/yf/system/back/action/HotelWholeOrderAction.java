/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/14 创建
 *
 */
 
package com.yf.system.back.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.yf.system.back.server.Server;
import com.yf.system.base.city.City;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.guest.Guest;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelorder.Hotelorder;
import com.yf.system.base.hotelorderrc.Hotelorderrc;
import com.yf.system.base.incity.Incity;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;

public class HotelWholeOrderAction extends HotelorderAction {
	private List listHotelorder;
	private List <City> listCities ;
	private List<Incity> listIncity;
	private List <Hotelorderrc> listHotelorderrc ;
	private List<Guest> listGuest;
	//private List <Guest> listGuest;
	private List<Customeragent> listCustomeragent;
	private Hotelorder hotelorder = new Hotelorder();
	
	private Hotelorder MangGohotelorder = new Hotelorder();
	
	private Hotel hotel = new Hotel() ;
	//传真
	private long s_num;
	private String rname ;
	private String rphone ;
	private String rfax ;
	private String sname ;
	private String sphone ;
	private String sfax ;
	private String senddate ;
	private String hotelname ;
	private String countty ;
	private String peoplenum ;
	private String order ;
	private String name ;
	private String begindate ;
	
	private String enddate ;
	private String roommun ;
	private String breakfast ;
	private String dateprice ;
	private String content ;
	private String paymoney ;
	private String makename ;
	//北京天河联盟商务旅行社有限公司 模板
	private String lianxiren ;
	private String shouji ;
	private String qq ;
	private String ty ;
	//
	//天津滨江万丽确认增加.doc
	private String zongprice ;
	private String dizhi ;
	private String dianhua ;
	private String yue ;
	private String ri ;
	private String shi ;
	private String jiaqi ;
	//
	private String guestid ;
	//询价函
	private String nian1 ;
	private String yue1 ;
	private String nian2 ;
	private String yue2 ;
	//
	
	private long h_angent;
	//传真
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	private int h_ordertype=-1;
	private int sta;
	private long typ;
	private int stat;
	private long hui;
	//search
	//private String s_name;
	
	//酒店城市
	private Integer h_hotelCityId ; 
	
	//订单号
	private String h_orderId ;
	//订单状态
	private String h_state=-1+"" ;
	//订单ID
	private long ordid;
	
	//联系人姓名
	private String h_linkname ;
	
	//联系人手机
	private String h_linkmobile ;
	
	//入住日期
	private String h_comedate ;
	
	//离店日期
	private String h_leavedate ;
	
	//预订的开始时间
	private String h_prestarttime ;
	
	//预订的结束时间
	private String h_preendtime ;
	
	//是否是酒店的英文名
	private Integer h_isEnglishName ;
	
	//酒店名称
	private String h_hotelName ;
	
	//是否通过
	private Integer h_auditing_pass ;
	
	//未通过的原因
	private String h_noauditing_reason ;
	
	//重定向的页面
	private String h_type ;
	
	//重定向的页面
	private String forward ;
	

	private long longtype;
	
	public void ajax_hotelorder()throws Exception{
		System.out.println("ID=="+ordid);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
			hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
			Hotel hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid());
		
			
			hotelorder.setState(2);
			Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
			
			out.print("OK");
			
	
		
		out.flush();
	    out.close();
		
	}
	public void ajax_canhotelorder()throws Exception{
		System.out.println("ID=="+ordid);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
		String ret="网络错误";
		if(hotelorder.getWaicode()!=null){
			System.out.println("有外部订单ID,取消外部订单");
			
			String sub=	Server.getInstance().getHotelInterService().CancelHotelOrder(hotelorder);
			
			if(sub.equals("1")){
				System.out.println("取消成功");
				hotelorder.setState(6);
				ret="1";
			}else{
				
				System.out.println("取消失败");
				ret=sub;
			}
			
		}else{
			System.out.println("没有外部订单ID,取消本地订单");
			hotelorder.setState(6);
		}
		
		
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		out.print(ret);
			
	
		
		out.flush();
	    out.close();
		
	}
	
	/**
	 * 列表查询酒店订单
	 */	
	public String execute()throws Exception{
		if(h_type != null && "ce".equals(h_type.trim())) {
			h_linkname = this.getUrlDecode(h_linkname) ;
			h_hotelName = this.getUrlDecode(h_hotelName) ;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		if(h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date()) ;
		}
		if(h_preendtime == null) {
			h_preendtime = sdf.format(new Date()) ;
		}
		//查询所有的城市
		listCities = Server.getInstance().getHotelService().findAllCity("", "ORDER BY " + City.COL_sort, -1, 0) ;
		//查询酒店订单
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0 and "+Hotelorder.COL_property+"=1" );
		List<Sysconfig>list=Server.getInstance().getSystemService().findAllSysconfig(" where 1=1 and "+Sysconfig.COL_name+" ='agentid'", "", -1, 0);
		
		if(getLoginUser().getAgentid()==46||getLoginUser().getAgentid()==1){//龙泰得员工
			longtype=0;
			where.append("  ");
			System.out.println("0000");
				if(h_angent>0){//
					
					where.append(" AND "+Hotelorder.COL_createuserid+" IN( SELECT "+Customeruser.COL_id+" FROM " +Customeruser.TABLE+" WHERE "+Customeruser.COL_agentid+" ="+h_angent+")");
						
				}
			
			listCustomeragent=Server.getInstance().getMemberService().findAllCustomeragent(" WHERE 1=1 ", " ORDER BY ID DESC ", -1, 0);
		}else{
			longtype=1;
			listCustomeragent=Server.getInstance().getMemberService().findAllCustomeragent(" WHERE 1=1 AND "+Customeragent.COL_parentid+" ="+getLoginUser().getAgentid(), " ORDER BY ID DESC ", -1, 0);
		where.append(" AND "+Hotelorder.COL_memberid+" IN ( SELECT "+Customeruser.COL_id+" FROM " +Customeruser.TABLE+" WHERE "+Customeruser.COL_agentid+" ="+getLoginUser().getAgentid()+")");
		}
	
		if(h_orderId != null && h_orderId.trim().length() != 0) {
			where.append(" AND " + Hotelorder.COL_orderid + "='"  + h_orderId.trim() + "'") ;
		}
		if(!h_state.equals("-1")&& h_state.trim().length() !=0) {
			where.append(" AND ").append(Hotelorder.COL_state).append("='")
				.append(h_state.trim()).append("'") ;
		}
		if(h_linkname != null && h_linkname.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkname).append(" LIKE '%")
				.append(h_linkname.trim()).append("%'") ;
		}
		if(h_linkmobile != null && h_linkmobile.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkmobile).append(" LIKE '% ")
				.append(h_linkmobile.trim()).append("%'") ;
		}
		if(h_prestarttime != null && h_prestarttime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + ">=" + "CONVERT(datetime, '" + h_prestarttime + " 00:00:00')") ;
		}
		if(h_preendtime != null && h_preendtime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + h_preendtime + " 23:59:59')") ;
		}
		if(h_hotelName != null && h_hotelName.trim().length() !=0 && h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ").append(Hotel.TABLE).append(" WHERE 1=1 ") ;
			if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
				//按英文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_enname).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			} else {
				//按中文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_name).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			}
			where.append(" AND " + Hotel.TABLE + "." + Hotel.COL_cityid+ "=" + h_hotelCityId + ") ") ;
		} else {
			if(h_hotelName != null && !"".equals(h_hotelName.trim())) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE 1=1 ")  ;
				if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
					//按英文名称查询
					where.append(" AND ").append(Hotel.COL_enname).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				} else {
					//按中文名称查询
					where.append(" AND ").append(Hotel.COL_name).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				}
				where.append(")") ;
			}
			if(h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
					.append(Hotel.COL_cityid).append("=").append(h_hotelCityId) ;
				where.append(")") ;
			}
			
		}
		if(h_ordertype != -1) {
			where.append(" AND ").append(Hotelorder.COL_type).append(" =").append(h_ordertype);
			
		}
		
		//long confighotelid = 0 ;
		List<Sysconfig> configs = Server.getInstance().getSystemService().findAllSysconfig("WHERE " + Sysconfig.COL_name + "='hotelroleid'", "", -1, 0) ;
	/*	if(configs.size() > 0) {
			confighotelid = Long.parseLong(configs.get(0).getValue().trim()) ;
		}*/
		/*if(this.getLoginRole().getId() == confighotelid) {
			where.append(" AND (" + Hotelorder.COL_systemuserid + "=" + this.getLoginUserId() + " OR " + Hotelorder.COL_systemuserid + "=0 OR " +
					Hotelorder.COL_systemuserid + " IS NULL" + ")") ;
		}*/
	/*	if(confighotelid==0) {
			where.append(" AND (" + Hotelorder.COL_systemuserid + "=" + this.getLoginUserId() + " OR " + Hotelorder.COL_systemuserid + "=0 OR " +
					Hotelorder.COL_systemuserid + " IS NULL" + ")") ;
		}*/
		listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString(),"order by ID DESC" ,pageinfo);
		if(pageinfo.getTotalrow()>0 && listHotelorder.size()==0){
			pageinfo.setPagenum(1);
			listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString()," order by DESC",pageinfo);	
		}
		System.out.println("where=="+where);
		pageinfo = (PageInfo) listHotelorder.get(0) ;
		listHotelorder.remove(0) ;
		return "toorder";
	}
	/**
	 * 列表查询酒店订单--国际
	 */	
	public String interhotelorder()throws Exception{
		
		//查询所有的城市
		//listIncity = Server.getInstance().getInterHotelService().findAllIncity("", "", -1, 0);
		//System.out.println("listIncity=="+listIncity);
		//查询酒店订单
		StringBuffer where = new StringBuffer(" where 1=1 and "+Hotelorder.COL_property+" =2" );
	
		if(!h_state.equals("-1")&& h_state.trim().length() !=0) {
			where.append(" AND ").append(Hotelorder.COL_state).append("='")
				.append(h_state.trim()).append("'") ;
		}

		listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString(),"order by ID DESC" ,pageinfo);
		if(pageinfo.getTotalrow()>0 && listHotelorder.size()==0){
			pageinfo.setPagenum(1);
			listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString()," order by DESC",pageinfo);	
		}
		System.out.println("where=="+where);
		pageinfo = (PageInfo) listHotelorder.get(0) ;
		listHotelorder.remove(0) ;
		
		longtype=1;
		return "tointerorder";
	}
	/**
	 * 列表查询酒店订单--夜审
	 */	
	public String toauditing()throws Exception{
		if(h_type != null && "ce".equals(h_type.trim())) {
			h_linkname = this.getUrlDecode(h_linkname) ;
			h_hotelName = this.getUrlDecode(h_hotelName) ;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		/*if(h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date()) ;
		}
		if(h_preendtime == null) {
			h_preendtime = sdf.format(new Date()) ;
		}*/
		//查询所有的城市
		listCities = Server.getInstance().getHotelService().findAllCity("", "ORDER BY " + City.COL_sort, -1, 0) ;
		//查询酒店订单
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0 and "+Hotelorder.COL_paytype+"=1" );
		if(h_orderId != null && h_orderId.trim().length() != 0) {
			where.append(" AND " + Hotelorder.COL_orderid + "='"  + h_orderId.trim() + "'") ;
		}
		if(!h_state.equals("-1")&& h_state.trim().length() !=0) {
			where.append(" AND ").append(Hotelorder.COL_state).append("='")
				.append(h_state.trim()).append("'") ;
		}
		if(h_linkname != null && h_linkname.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkname).append("='")
				.append(h_linkname.trim()).append("'") ;
		}
		if(h_linkmobile != null && h_linkmobile.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkmobile).append("='")
				.append(h_linkmobile.trim()).append("'") ;
		}
		if(h_prestarttime != null && h_prestarttime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + ">=" + "CONVERT(datetime, '" + h_prestarttime + " 00:00:00')") ;
		}
		if(h_preendtime != null && h_preendtime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + h_preendtime + " 23:59:59')") ;
		}
		if(h_hotelName != null && h_hotelName.trim().length() !=0 && h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ").append(Hotel.TABLE).append(" WHERE 1=1 ") ;
			if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
				//按英文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_enname).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			} else {
				//按中文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_name).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			}
			where.append(" AND " + Hotel.TABLE + "." + Hotel.COL_cityid+ "=" + h_hotelCityId + ") ") ;
		} else {
			if(h_hotelName != null && !"".equals(h_hotelName.trim())) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE 1=1 ")  ;
				if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
					//按英文名称查询
					where.append(" AND ").append(Hotel.COL_enname).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				} else {
					//按中文名称查询
					where.append(" AND ").append(Hotel.COL_name).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				}
				where.append(")") ;
			}
			if(h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
					.append(Hotel.COL_cityid).append("=").append(h_hotelCityId) ;
				where.append(")") ;
			}
			
		}
		if(h_ordertype != -1) {
			where.append(" AND ").append(Hotelorder.COL_type).append(" =").append(h_ordertype);
			
		}
		//long confighotelid = 0 ;
		List<Sysconfig> configs = Server.getInstance().getSystemService().findAllSysconfig("WHERE " + Sysconfig.COL_name + "='hotelroleid'", "", -1, 0) ;
	/*	if(configs.size() > 0) {
			confighotelid = Long.parseLong(configs.get(0).getValue().trim()) ;
		}*/
		/*if(this.getLoginRole().getId() == confighotelid) {
			where.append(" AND (" + Hotelorder.COL_systemuserid + "=" + this.getLoginUserId() + " OR " + Hotelorder.COL_systemuserid + "=0 OR " +
					Hotelorder.COL_systemuserid + " IS NULL" + ")") ;
		}*/
	/*	if(confighotelid==0) {
			where.append(" AND (" + Hotelorder.COL_systemuserid + "=" + this.getLoginUserId() + " OR " + Hotelorder.COL_systemuserid + "=0 OR " +
					Hotelorder.COL_systemuserid + " IS NULL" + ")") ;
		}*/
		listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString(),"order by ID DESC" ,pageinfo);
		if(pageinfo.getTotalrow()>0 && listHotelorder.size()==0){
			pageinfo.setPagenum(1);
			listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString()," order by DESC",pageinfo);	
		}
		System.out.println("where=="+where);
		pageinfo = (PageInfo) listHotelorder.get(0) ;
		listHotelorder.remove(0) ;
		return "toauditing";
	}
	
	public String xianjie()throws Exception{
		if(h_type != null && "ce".equals(h_type.trim())) {
			h_linkname = this.getUrlDecode(h_linkname) ;
			h_hotelName = this.getUrlDecode(h_hotelName) ;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		/*if(h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date()) ;
		}
		if(h_preendtime == null) {
			h_preendtime = sdf.format(new Date()) ;
		}*/
		//查询所有的城市
		listCities = Server.getInstance().getHotelService().findAllCity("", "ORDER BY " + City.COL_sort, -1, 0) ;
		//查询酒店订单
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0 and "+Hotelorder.COL_paytype+"=1 and "+Hotelorder.COL_ishotelpay+" IS NULL" );
		if(h_orderId != null && h_orderId.trim().length() != 0) {
			where.append(" AND " + Hotelorder.COL_orderid + "='"  + h_orderId.trim() + "'") ;
		}
		if(!h_state.equals("-1")&& h_state.trim().length() !=0) {
			where.append(" AND ").append(Hotelorder.COL_state).append("='")
				.append(h_state.trim()).append("'") ;
		}
		if(h_linkname != null && h_linkname.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkname).append("='")
				.append(h_linkname.trim()).append("'") ;
		}
		if(h_linkmobile != null && h_linkmobile.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkmobile).append("='")
				.append(h_linkmobile.trim()).append("'") ;
		}
		if(h_prestarttime != null && h_prestarttime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + ">=" + "CONVERT(datetime, '" + h_prestarttime + " 00:00:00')") ;
		}
		if(h_preendtime != null && h_preendtime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + h_preendtime + " 23:59:59')") ;
		}
		if(h_hotelName != null && h_hotelName.trim().length() !=0 && h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ").append(Hotel.TABLE).append(" WHERE 1=1 ") ;
			if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
				//按英文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_enname).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			} else {
				//按中文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_name).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			}
			where.append(" AND " + Hotel.TABLE + "." + Hotel.COL_cityid+ "=" + h_hotelCityId + ") ") ;
		} else {
			if(h_hotelName != null && !"".equals(h_hotelName.trim())) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE 1=1 ")  ;
				if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
					//按英文名称查询
					where.append(" AND ").append(Hotel.COL_enname).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				} else {
					//按中文名称查询
					where.append(" AND ").append(Hotel.COL_name).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				}
				where.append(")") ;
			}
			if(h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
					.append(Hotel.COL_cityid).append("=").append(h_hotelCityId) ;
				where.append(")") ;
			}
			
		}
		if(h_ordertype != -1) {
			where.append(" AND ").append(Hotelorder.COL_type).append(" =").append(h_ordertype);
			
		}
		//long confighotelid = 0 ;
		List<Sysconfig> configs = Server.getInstance().getSystemService().findAllSysconfig("WHERE " + Sysconfig.COL_name + "='hotelroleid'", "", -1, 0) ;
	/*	if(configs.size() > 0) {
			confighotelid = Long.parseLong(configs.get(0).getValue().trim()) ;
		}*/
		/*if(this.getLoginRole().getId() == confighotelid) {
			where.append(" AND (" + Hotelorder.COL_systemuserid + "=" + this.getLoginUserId() + " OR " + Hotelorder.COL_systemuserid + "=0 OR " +
					Hotelorder.COL_systemuserid + " IS NULL" + ")") ;
		}*/
	/*	if(confighotelid==0) {
			where.append(" AND (" + Hotelorder.COL_systemuserid + "=" + this.getLoginUserId() + " OR " + Hotelorder.COL_systemuserid + "=0 OR " +
					Hotelorder.COL_systemuserid + " IS NULL" + ")") ;
		}*/
		listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString(),"order by ID DESC" ,pageinfo);
		if(pageinfo.getTotalrow()>0 && listHotelorder.size()==0){
			pageinfo.setPagenum(1);
			listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString()," order by DESC",pageinfo);	
		}
		System.out.println("where=="+where);
		pageinfo = (PageInfo) listHotelorder.get(0) ;
		listHotelorder.remove(0) ;
		return "xianjie";
	}
	public String yihui()throws Exception{
		if(h_type != null && "ce".equals(h_type.trim())) {
			h_linkname = this.getUrlDecode(h_linkname) ;
			h_hotelName = this.getUrlDecode(h_hotelName) ;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		/*if(h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date()) ;
		}
		if(h_preendtime == null) {
			h_preendtime = sdf.format(new Date()) ;
		}*/
		//查询所有的城市
		listCities = Server.getInstance().getHotelService().findAllCity("", "ORDER BY " + City.COL_sort, -1, 0) ;
		//查询酒店订单
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0 and "+Hotelorder.COL_paytype+"=1 and "+Hotelorder.COL_ishotelpay+" =1" );
		if(h_orderId != null && h_orderId.trim().length() != 0) {
			where.append(" AND " + Hotelorder.COL_orderid + "='"  + h_orderId.trim() + "'") ;
		}
		if(!h_state.equals("-1")&& h_state.trim().length() !=0) {
			where.append(" AND ").append(Hotelorder.COL_state).append("='")
				.append(h_state.trim()).append("'") ;
		}
		if(h_linkname != null && h_linkname.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkname).append("='")
				.append(h_linkname.trim()).append("'") ;
		}
		if(h_linkmobile != null && h_linkmobile.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkmobile).append("='")
				.append(h_linkmobile.trim()).append("'") ;
		}
		if(h_prestarttime != null && h_prestarttime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + ">=" + "CONVERT(datetime, '" + h_prestarttime + " 00:00:00')") ;
		}
		if(h_preendtime != null && h_preendtime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + h_preendtime + " 23:59:59')") ;
		}
		if(h_hotelName != null && h_hotelName.trim().length() !=0 && h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ").append(Hotel.TABLE).append(" WHERE 1=1 ") ;
			if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
				//按英文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_enname).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			} else {
				//按中文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_name).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			}
			where.append(" AND " + Hotel.TABLE + "." + Hotel.COL_cityid+ "=" + h_hotelCityId + ") ") ;
		} else {
			if(h_hotelName != null && !"".equals(h_hotelName.trim())) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE 1=1 ")  ;
				if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
					//按英文名称查询
					where.append(" AND ").append(Hotel.COL_enname).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				} else {
					//按中文名称查询
					where.append(" AND ").append(Hotel.COL_name).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				}
				where.append(")") ;
			}
			if(h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
					.append(Hotel.COL_cityid).append("=").append(h_hotelCityId) ;
				where.append(")") ;
			}
			
		}
		if(h_ordertype != -1) {
			where.append(" AND ").append(Hotelorder.COL_type).append(" =").append(h_ordertype);
			
		}
		//long confighotelid = 0 ;
		List<Sysconfig> configs = Server.getInstance().getSystemService().findAllSysconfig("WHERE " + Sysconfig.COL_name + "='hotelroleid'", "", -1, 0) ;
	/*	if(configs.size() > 0) {
			confighotelid = Long.parseLong(configs.get(0).getValue().trim()) ;
		}*/
		/*if(this.getLoginRole().getId() == confighotelid) {
			where.append(" AND (" + Hotelorder.COL_systemuserid + "=" + this.getLoginUserId() + " OR " + Hotelorder.COL_systemuserid + "=0 OR " +
					Hotelorder.COL_systemuserid + " IS NULL" + ")") ;
		}*/
	/*	if(confighotelid==0) {
			where.append(" AND (" + Hotelorder.COL_systemuserid + "=" + this.getLoginUserId() + " OR " + Hotelorder.COL_systemuserid + "=0 OR " +
					Hotelorder.COL_systemuserid + " IS NULL" + ")") ;
		}*/
		listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString(),"order by ID DESC" ,pageinfo);
		if(pageinfo.getTotalrow()>0 && listHotelorder.size()==0){
			pageinfo.setPagenum(1);
			listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString()," order by DESC",pageinfo);	
		}
		System.out.println("where=="+where);
		pageinfo = (PageInfo) listHotelorder.get(0) ;
		listHotelorder.remove(0) ;
		return "yihui";
	}
	
	public String toyufu()throws Exception{
		if(h_type != null && "ce".equals(h_type.trim())) {
			h_linkname = this.getUrlDecode(h_linkname) ;
			h_hotelName = this.getUrlDecode(h_hotelName) ;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		/*if(h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date()) ;
		}
		if(h_preendtime == null) {
			h_preendtime = sdf.format(new Date()) ;
		}*/
		//查询所有的城市
		listCities = Server.getInstance().getHotelService().findAllCity("", "ORDER BY " + City.COL_sort, -1, 0) ;
		//查询酒店订单
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0 and "+Hotelorder.COL_paytype+"=2" );
		if(h_orderId != null && h_orderId.trim().length() != 0) {
			where.append(" AND " + Hotelorder.COL_orderid + "='"  + h_orderId.trim() + "'") ;
		}
		if(!h_state.equals("-1")&& h_state.trim().length() !=0) {
			where.append(" AND ").append(Hotelorder.COL_state).append("='")
				.append(h_state.trim()).append("'") ;
		}
		if(h_linkname != null && h_linkname.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkname).append("='")
				.append(h_linkname.trim()).append("'") ;
		}
		if(h_linkmobile != null && h_linkmobile.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkmobile).append("='")
				.append(h_linkmobile.trim()).append("'") ;
		}
		if(h_prestarttime != null && h_prestarttime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + ">=" + "CONVERT(datetime, '" + h_prestarttime + " 00:00:00')") ;
		}
		if(h_preendtime != null && h_preendtime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + h_preendtime + " 23:59:59')") ;
		}
		if(h_hotelName != null && h_hotelName.trim().length() !=0 && h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ").append(Hotel.TABLE).append(" WHERE 1=1 ") ;
			if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
				//按英文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_enname).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			} else {
				//按中文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_name).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			}
			where.append(" AND " + Hotel.TABLE + "." + Hotel.COL_cityid+ "=" + h_hotelCityId + ") ") ;
		} else {
			if(h_hotelName != null && !"".equals(h_hotelName.trim())) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE 1=1 ")  ;
				if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
					//按英文名称查询
					where.append(" AND ").append(Hotel.COL_enname).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				} else {
					//按中文名称查询
					where.append(" AND ").append(Hotel.COL_name).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				}
				where.append(")") ;
			}
			if(h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
					.append(Hotel.COL_cityid).append("=").append(h_hotelCityId) ;
				where.append(")") ;
			}
			
		}
		if(h_ordertype != -1) {
			where.append(" AND ").append(Hotelorder.COL_type).append(" =").append(h_ordertype);
			
		}
		long confighotelid = 0 ;
		List<Sysconfig> configs = Server.getInstance().getSystemService().findAllSysconfig("WHERE " + Sysconfig.COL_name + "='hotelroleid'", "", -1, 0) ;
		if(configs.size() > 0) {
			confighotelid = Long.parseLong(configs.get(0).getValue().trim()) ;
		}
		/*if(this.getLoginRole().getId() == confighotelid) {
			where.append(" AND (" + Hotelorder.COL_systemuserid + "=" + this.getLoginUserId() + " OR " + Hotelorder.COL_systemuserid + "=0 OR " +
					Hotelorder.COL_systemuserid + " IS NULL" + ")") ;
		}*/

		listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString(),"order by ID DESC" ,pageinfo);
		if(pageinfo.getTotalrow()>0 && listHotelorder.size()==0){
			pageinfo.setPagenum(1);
			listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString()," order by DESC",pageinfo);	
		}
		pageinfo = (PageInfo) listHotelorder.get(0) ;
		listHotelorder.remove(0) ;
		return "toyufu";
	}
	public String yujie()throws Exception{
		if(h_type != null && "ce".equals(h_type.trim())) {
			h_linkname = this.getUrlDecode(h_linkname) ;
			h_hotelName = this.getUrlDecode(h_hotelName) ;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		/*if(h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date()) ;
		}
		if(h_preendtime == null) {
			h_preendtime = sdf.format(new Date()) ;
		}*/
		//查询所有的城市
		listCities = Server.getInstance().getHotelService().findAllCity("", "ORDER BY " + City.COL_sort, -1, 0) ;
		//查询酒店订单
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0 and "+Hotelorder.COL_paytype+"=2 and "+Hotelorder.COL_ishotelpay+" IS NULL");
		if(h_orderId != null && h_orderId.trim().length() != 0) {
			where.append(" AND " + Hotelorder.COL_orderid + "='"  + h_orderId.trim() + "'") ;
		}
		if(!h_state.equals("-1")&& h_state.trim().length() !=0) {
			where.append(" AND ").append(Hotelorder.COL_state).append("='")
				.append(h_state.trim()).append("'") ;
		}
		if(h_linkname != null && h_linkname.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkname).append("='")
				.append(h_linkname.trim()).append("'") ;
		}
		if(h_linkmobile != null && h_linkmobile.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkmobile).append("='")
				.append(h_linkmobile.trim()).append("'") ;
		}
		if(h_prestarttime != null && h_prestarttime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + ">=" + "CONVERT(datetime, '" + h_prestarttime + " 00:00:00')") ;
		}
		if(h_preendtime != null && h_preendtime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + h_preendtime + " 23:59:59')") ;
		}
		if(h_hotelName != null && h_hotelName.trim().length() !=0 && h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ").append(Hotel.TABLE).append(" WHERE 1=1 ") ;
			if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
				//按英文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_enname).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			} else {
				//按中文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_name).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			}
			where.append(" AND " + Hotel.TABLE + "." + Hotel.COL_cityid+ "=" + h_hotelCityId + ") ") ;
		} else {
			if(h_hotelName != null && !"".equals(h_hotelName.trim())) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE 1=1 ")  ;
				if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
					//按英文名称查询
					where.append(" AND ").append(Hotel.COL_enname).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				} else {
					//按中文名称查询
					where.append(" AND ").append(Hotel.COL_name).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				}
				where.append(")") ;
			}
			if(h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
					.append(Hotel.COL_cityid).append("=").append(h_hotelCityId) ;
				where.append(")") ;
			}
			
		}
		if(h_ordertype != -1) {
			where.append(" AND ").append(Hotelorder.COL_type).append(" =").append(h_ordertype);
			
		}
		long confighotelid = 0 ;
		List<Sysconfig> configs = Server.getInstance().getSystemService().findAllSysconfig("WHERE " + Sysconfig.COL_name + "='hotelroleid'", "", -1, 0) ;
		if(configs.size() > 0) {
			confighotelid = Long.parseLong(configs.get(0).getValue().trim()) ;
		}
		/*if(this.getLoginRole().getId() == confighotelid) {
			where.append(" AND (" + Hotelorder.COL_systemuserid + "=" + this.getLoginUserId() + " OR " + Hotelorder.COL_systemuserid + "=0 OR " +
					Hotelorder.COL_systemuserid + " IS NULL" + ")") ;
		}*/

		listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString(),"order by ID DESC" ,pageinfo);
		if(pageinfo.getTotalrow()>0 && listHotelorder.size()==0){
			pageinfo.setPagenum(1);
			listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString()," order by DESC",pageinfo);	
		}
		pageinfo = (PageInfo) listHotelorder.get(0) ;
		listHotelorder.remove(0) ;
		return "yujie";
	}
	public String yuyihui()throws Exception{
		if(h_type != null && "ce".equals(h_type.trim())) {
			h_linkname = this.getUrlDecode(h_linkname) ;
			h_hotelName = this.getUrlDecode(h_hotelName) ;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		/*if(h_prestarttime == null) {
			h_prestarttime = sdf.format(new Date()) ;
		}
		if(h_preendtime == null) {
			h_preendtime = sdf.format(new Date()) ;
		}*/
		//查询所有的城市
		listCities = Server.getInstance().getHotelService().findAllCity("", "ORDER BY " + City.COL_sort, -1, 0) ;
		//查询酒店订单
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0 and "+Hotelorder.COL_paytype+"=2 and "+Hotelorder.COL_ishotelpay+" =1");
		if(h_orderId != null && h_orderId.trim().length() != 0) {
			where.append(" AND " + Hotelorder.COL_orderid + "='"  + h_orderId.trim() + "'") ;
		}
		if(!h_state.equals("-1")&& h_state.trim().length() !=0) {
			where.append(" AND ").append(Hotelorder.COL_state).append("='")
				.append(h_state.trim()).append("'") ;
		}
		if(h_linkname != null && h_linkname.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkname).append("='")
				.append(h_linkname.trim()).append("'") ;
		}
		if(h_linkmobile != null && h_linkmobile.trim().length() != 0) {
			where.append(" AND ").append(Hotelorder.COL_linkmobile).append("='")
				.append(h_linkmobile.trim()).append("'") ;
		}
		if(h_prestarttime != null && h_prestarttime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + ">=" + "CONVERT(datetime, '" + h_prestarttime + " 00:00:00')") ;
		}
		if(h_preendtime != null && h_preendtime.length() != 0) {
			where.append(" AND " + Hotelorder.COL_pretime + "<=" + "CONVERT(datetime, '" + h_preendtime + " 23:59:59')") ;
		}
		if(h_hotelName != null && h_hotelName.trim().length() !=0 && h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
			where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ").append(Hotel.TABLE).append(" WHERE 1=1 ") ;
			if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
				//按英文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_enname).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			} else {
				//按中文名称查询
				where.append(" AND ").append(Hotel.TABLE).append(".").append(Hotel.COL_name).append(" LIKE '%")
					.append(h_hotelName.trim()).append("%'") ;
			}
			where.append(" AND " + Hotel.TABLE + "." + Hotel.COL_cityid+ "=" + h_hotelCityId + ") ") ;
		} else {
			if(h_hotelName != null && !"".equals(h_hotelName.trim())) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE 1=1 ")  ;
				if(h_isEnglishName !=null && h_isEnglishName.intValue() > 0) {
					//按英文名称查询
					where.append(" AND ").append(Hotel.COL_enname).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				} else {
					//按中文名称查询
					where.append(" AND ").append(Hotel.COL_name).append(" LIKE '%").append(h_hotelName.trim()).append("%'") ;
				}
				where.append(")") ;
			}
			if(h_hotelCityId != null && h_hotelCityId.intValue() > 0) {
				where.append(" AND ").append(Hotelorder.COL_hotelid).append(" IN( SELECT ").append(Hotel.TABLE).append(".")
				.append(Hotel.COL_id).append(" FROM ")
					.append(Hotel.TABLE).append(" WHERE ").append(Hotel.TABLE).append(".")
					.append(Hotel.COL_cityid).append("=").append(h_hotelCityId) ;
				where.append(")") ;
			}
			
		}
		if(h_ordertype != -1) {
			where.append(" AND ").append(Hotelorder.COL_type).append(" =").append(h_ordertype);
			
		}
		long confighotelid = 0 ;
		List<Sysconfig> configs = Server.getInstance().getSystemService().findAllSysconfig("WHERE " + Sysconfig.COL_name + "='hotelroleid'", "", -1, 0) ;
		if(configs.size() > 0) {
			confighotelid = Long.parseLong(configs.get(0).getValue().trim()) ;
		}
		/*if(this.getLoginRole().getId() == confighotelid) {
			where.append(" AND (" + Hotelorder.COL_systemuserid + "=" + this.getLoginUserId() + " OR " + Hotelorder.COL_systemuserid + "=0 OR " +
					Hotelorder.COL_systemuserid + " IS NULL" + ")") ;
		}*/

		listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString(),"order by ID DESC" ,pageinfo);
		if(pageinfo.getTotalrow()>0 && listHotelorder.size()==0){
			pageinfo.setPagenum(1);
			listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString()," order by DESC",pageinfo);	
		}
		pageinfo = (PageInfo) listHotelorder.get(0) ;
		listHotelorder.remove(0) ;
		return "yuyihui";
	}
	/**
	 * 转向到酒店订单添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	//夜审订单修改方法
	public String editguest()throws Exception{
		if(guestid.trim().indexOf(",")!=-1){
			
		String[] sGuestid=guestid.trim().split(",");
			for(int a=0;a<sGuestid.length;a++){
				if(sGuestid[a]!=null && !sGuestid[a].toString().equals(" "))
				{
					
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
					
				
					
					Guest gu = Server.getInstance().getHotelService().findGuest(Long.parseLong(sGuestid[a].trim()));
					if(ty.equals("1")){
						//订单操作日志
						Hotelorderrc  hotelorderrc = new Hotelorderrc();
						hotelorderrc.setContent("正常离店!!!!");
						hotelorderrc.setOrderid(gu.getOrderid());
						hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis()));
						hotelorderrc.setHandleuser(getLoginUser().getId()+"");
						hotelorderrc.setState(1);
						hotelorderrc.setLanguage(0);
						Server.getInstance().getHotelService().createHotelorderrc(hotelorderrc);
						//
						Hotelorder hr = Server.getInstance().getHotelService().findHotelorder(gu.getOrderid());
						hr.setYestate(1);
						Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hr);
						gu.setShijitime(gu.getLikaitime());
					}else{
						if(h_prestarttime!=null&&h_prestarttime.length()>0){
						gu.setShijitime(dateToTimestamp(h_prestarttime));
						}
						if(ty.equals("3")){//延住
							s_num = dateDiff(h_prestarttime.trim(), formatTimestampyyyyMMdd(gu.getLikaitime()).trim());
							
							String pra = gu.getPrice();
							if(pra.trim().indexOf(",")!=-1){
								
								String[] pras=pra.trim().split(",");
								Double pric =Double.parseDouble(pras[0].trim());
								
								Double p =pric*s_num;
								
								Hotelorder hr = Server.getInstance().getHotelService().findHotelorder(gu.getOrderid());
								String pp=hr.getPrice();
								hr.setPrice((Double.parseDouble(pp)+p)+"");
								hr.setActualmount(Double.parseDouble(pp)+p);
								hr.setYestate(2);
								Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hr);
								//订单操作日志
								Hotelorderrc  hotelorderrc = new Hotelorderrc();
								hotelorderrc.setContent("延住!!!!");
								hotelorderrc.setOrderid(gu.getOrderid());
								hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis()));
								hotelorderrc.setHandleuser(getLoginUser().getId()+"");
								hotelorderrc.setState(3);
								hotelorderrc.setLanguage(0);
								hotelorderrc.setContent("延住到:"+h_prestarttime+",延住前订单总价为:"+pp+",延住期间价格为:"+p.toString()+",延住后价格总计为:"+hr.getPrice());
								Server.getInstance().getHotelService().createHotelorderrc(hotelorderrc);
								//
							}else{
								
								Double pric =Double.parseDouble(gu.getPrice());
								
								Double p =pric*s_num;
								
								Hotelorder hr = Server.getInstance().getHotelService().findHotelorder(gu.getOrderid());
								String pp=hr.getPrice();
								hr.setPrice((Double.parseDouble(pp)-p)+"");
								hr.setActualmount(Double.parseDouble(pp)-p);
								hr.setYestate(2);
								Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hr);
								//订单操作日志
								Hotelorderrc  hotelorderrc = new Hotelorderrc();
								hotelorderrc.setContent("延住!!!!");
								hotelorderrc.setOrderid(gu.getOrderid());
								hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis()));
								hotelorderrc.setHandleuser(getLoginUser().getId()+"");
								hotelorderrc.setState(3);
								hotelorderrc.setLanguage(0);
								hotelorderrc.setContent("延住到:"+h_prestarttime+",延住前订单总价为:"+pp+",延住期间价格为:"+p.toString()+",延住后价格总计为:"+hr.getPrice());
								Server.getInstance().getHotelService().createHotelorderrc(hotelorderrc);
								//
							}
							
							
						}
						if(ty.equals("2")){//提前离店
							s_num = dateDiff(formatTimestampyyyyMMdd(gu.getLikaitime()).trim(),h_prestarttime.trim());
							
							String pra = gu.getPrice();
							if(pra.trim().indexOf(",")!=-1){
								
								String[] pras=pra.trim().split(",");
								Double pric =Double.parseDouble(pras[0].trim());
								
								Double p =pric*s_num;
								
								Hotelorder hr = Server.getInstance().getHotelService().findHotelorder(gu.getOrderid());
								String pp=hr.getPrice();
								hr.setPrice((Double.parseDouble(pp)-p)+"");
								hr.setActualmount(Double.parseDouble(pp)-p);
								hr.setYestate(2);
								Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hr);
								//订单操作日志
								Hotelorderrc  hotelorderrc = new Hotelorderrc();
								hotelorderrc.setContent("提前离店!!!!");
								hotelorderrc.setOrderid(gu.getOrderid());
								hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis()));
								hotelorderrc.setHandleuser(getLoginUser().getId()+"");
								hotelorderrc.setState(3);
								hotelorderrc.setLanguage(0);
								hotelorderrc.setContent("离店日期为:"+h_prestarttime+",离店前订单总价为:"+pp+",延住期间价格为:"+p.toString()+",离店后价格总计为:"+hr.getPrice());
								Server.getInstance().getHotelService().createHotelorderrc(hotelorderrc);
								//
							}else{
								
								Double pric =Double.parseDouble(gu.getPrice());
								
								Double p =pric*s_num;
								
								Hotelorder hr = Server.getInstance().getHotelService().findHotelorder(gu.getOrderid());
								String pp=hr.getPrice();
								hr.setPrice((Double.parseDouble(pp)-p)+"");
								hr.setActualmount(Double.parseDouble(pp)-p);
								hr.setYestate(2);
								Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hr);
								//订单操作日志
								Hotelorderrc  hotelorderrc = new Hotelorderrc();
								hotelorderrc.setContent("提前离店!!!!");
								hotelorderrc.setOrderid(gu.getOrderid());
								hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis()));
								hotelorderrc.setHandleuser(getLoginUser().getId()+"");
								hotelorderrc.setState(3);
								hotelorderrc.setLanguage(0);
								hotelorderrc.setContent("离店日期为:"+h_prestarttime+",离店前订单总价为:"+pp+",延住期间价格为:"+p.toString()+",离店后价格总计为:"+hr.getPrice());
								Server.getInstance().getHotelService().createHotelorderrc(hotelorderrc);
								//
							}
							
						}
						
						
					}
					
					gu.setState(Long.parseLong(ty));
					Server.getInstance().getHotelService().updateGuestIgnoreNull(gu);
					
					
				}
				
				
			}
		
		}else{
			

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
			
		
			
			Guest gu = Server.getInstance().getHotelService().findGuest(Long.parseLong(guestid.trim()));
			if(ty.equals("1")){
				Hotelorder hr = Server.getInstance().getHotelService().findHotelorder(gu.getOrderid());
				hr.setYestate(1);
				Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hr);
				
				gu.setShijitime(gu.getLikaitime());
			}else{
				if(h_prestarttime!=null&&h_prestarttime.length()>0){
				gu.setShijitime(dateToTimestamp(h_prestarttime));
				}
				if(ty.equals("3")){//延住
					s_num = dateDiff(h_prestarttime.trim(), formatTimestampyyyyMMdd(gu.getLikaitime()).trim());
					
					String pra = gu.getPrice();
					if(pra.trim().indexOf(",")!=-1){
						
						String[] pras=pra.trim().split(",");
						Double pric =Double.parseDouble(pras[0].trim());
						
						Double p =pric*s_num;
						
						Hotelorder hr = Server.getInstance().getHotelService().findHotelorder(gu.getOrderid());
						String pp=hr.getPrice();
						hr.setPrice((Double.parseDouble(pp)+p)+"");
						hr.setActualmount(Double.parseDouble(pp)+p);
						hr.setYestate(2);
						Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hr);
						//订单操作日志
						Hotelorderrc  hotelorderrc = new Hotelorderrc();
						hotelorderrc.setContent("延住!!!!");
						hotelorderrc.setLanguage(0);
						hotelorderrc.setOrderid(gu.getOrderid());
						hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis()));
						hotelorderrc.setHandleuser(getLoginUser().getId()+"");
						hotelorderrc.setState(3);
						hotelorderrc.setContent("延住到:"+h_prestarttime+",延住前订单总价为:"+pp+",延住期间价格为:"+p.toString()+",延住后价格总计为:"+hr.getPrice());
						Server.getInstance().getHotelService().createHotelorderrc(hotelorderrc);
						//
					}else{
						
						Double pric =Double.parseDouble(gu.getPrice());
						
						Double p =pric*s_num;
						
						Hotelorder hr = Server.getInstance().getHotelService().findHotelorder(gu.getOrderid());
						String pp=hr.getPrice();
						hr.setPrice((Double.parseDouble(pp)+p)+"");
						hr.setActualmount(Double.parseDouble(pp)+p);
						hr.setYestate(2);
						Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hr);
						//订单操作日志
						Hotelorderrc  hotelorderrc = new Hotelorderrc();
						hotelorderrc.setContent("延住!!!!");
						hotelorderrc.setOrderid(gu.getOrderid());
						hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis()));
						hotelorderrc.setHandleuser(getLoginUser().getId()+"");
						hotelorderrc.setState(3);
						hotelorderrc.setLanguage(0);
						hotelorderrc.setContent("延住到:"+h_prestarttime+",延住前订单总价为:"+pp+",延住期间价格为:"+p.toString()+",延住后价格总计为:"+hr.getPrice());
						Server.getInstance().getHotelService().createHotelorderrc(hotelorderrc);
						//
					}
					
				}
				if(ty.equals("2")){//提前离店
					s_num = dateDiff(formatTimestampyyyyMMdd(gu.getLikaitime()).trim(),h_prestarttime.trim());
					
					String pra = gu.getPrice();
					if(pra.trim().indexOf(",")!=-1){
						
						String[] pras=pra.trim().split(",");
						Double pric =Double.parseDouble(pras[0].trim());
						
						Double p =pric*s_num;
						
						Hotelorder hr = Server.getInstance().getHotelService().findHotelorder(gu.getOrderid());
						String pp=hr.getPrice();
						hr.setPrice((Double.parseDouble(pp)-p)+"");
						hr.setActualmount(Double.parseDouble(pp)-p);
						hr.setYestate(2);
						Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hr);
						//订单操作日志
						Hotelorderrc  hotelorderrc = new Hotelorderrc();
						hotelorderrc.setContent("提前离店!!!!");
						hotelorderrc.setOrderid(gu.getOrderid());
						hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis()));
						hotelorderrc.setHandleuser(getLoginUser().getId()+"");
						hotelorderrc.setState(3);
						hotelorderrc.setLanguage(0);
						hotelorderrc.setContent("离店日期为:"+h_prestarttime+",离店前订单总价为:"+pp+",延住期间价格为:"+p.toString()+",离店后价格总计为:"+hr.getPrice());
						Server.getInstance().getHotelService().createHotelorderrc(hotelorderrc);
						//
					}else{
						
						Double pric =Double.parseDouble(gu.getPrice());
						
						Double p =pric*s_num;
						
						Hotelorder hr = Server.getInstance().getHotelService().findHotelorder(gu.getOrderid());
						String pp=hr.getPrice();
						hr.setPrice((Double.parseDouble(pp)-p)+"");
						hr.setActualmount(Double.parseDouble(pp)-p);
						hr.setYestate(2);
						Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hr);
						//订单操作日志
						Hotelorderrc  hotelorderrc = new Hotelorderrc();
						hotelorderrc.setContent("提前离店!!!!");
						hotelorderrc.setOrderid(gu.getOrderid());
						hotelorderrc.setCreatetime(new Timestamp(System.currentTimeMillis()));
						hotelorderrc.setHandleuser(getLoginUser().getId()+"");
						hotelorderrc.setState(3);
						hotelorderrc.setLanguage(0);
						hotelorderrc.setContent("离店日期为:"+h_prestarttime+",离店前订单总价为:"+pp+",延住期间价格为:"+p.toString()+",离店后价格总计为:"+hr.getPrice());
						Server.getInstance().getHotelService().createHotelorderrc(hotelorderrc);
						//
					}
					
				}
				
				
			}
			
			gu.setState(Long.parseLong(ty));
			Server.getInstance().getHotelService().updateGuestIgnoreNull(gu);
			
			
			
			
			
		}
		h_prestarttime = null;
		return toauditing();
	}
	/**
	 * 转向到酒店订单详细信息页面--国际
	 */	
	public String tointerdetails()throws Exception{
		
		if(getLoginUser().getAgentid()==46){//龙泰得员工
			longtype=0;
		}else{
			longtype=1;
		}
		
		
		hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
		listHotelorderrc = Server.getInstance().getHotelService().findAllHotelorderrc(" WHERE " 
				+ Hotelorderrc.COL_orderid + " IN( SELECT " + Hotelorder.COL_id + " FROM " + Hotelorder.TABLE + 
			" WHERE " + Hotelorder.COL_orderid + "='" + hotelorder.getOrderid() + "')", " ORDER BY " + Hotelorderrc.COL_id, 
				-1, 0) ;
		
		
		return "tointerdetails";
	}
	/**
	 * 转向到酒店订单详细信息页面
	 */	
	public String todetails()throws Exception{
		
		if(getLoginUser().getAgentid()==46){//龙泰得员工
			longtype=0;
		}else{
			longtype=1;
		}
		
		
		hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
		listHotelorderrc = Server.getInstance().getHotelService().findAllHotelorderrc(" WHERE " 
				+ Hotelorderrc.COL_orderid + " IN( SELECT " + Hotelorder.COL_id + " FROM " + Hotelorder.TABLE + 
			" WHERE " + Hotelorder.COL_orderid + "='" + hotelorder.getOrderid() + "')", " ORDER BY " + Hotelorderrc.COL_id, 
				-1, 0) ;
		
		
		return "todetails";
	}
	/**
	 * 转向到酒店订单详细信息页面--夜审
	 */	
	public String toyeshen()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
		listHotelorderrc = Server.getInstance().getHotelService().findAllHotelorderrc(" WHERE " 
				+ Hotelorderrc.COL_orderid + " IN( SELECT " + Hotelorder.COL_id + " FROM " + Hotelorder.TABLE + 
			" WHERE " + Hotelorder.COL_orderid + "='" + hotelorder.getOrderid() + "')", " ORDER BY " + Hotelorderrc.COL_id, 
				-1, 0) ;
		listGuest = Server.getInstance().getHotelService().findAllGuest(" where 1=1 and "+Guest.COL_orderid+" ="+hotelorder.getId(), "", -1, 0);
		
		return "toyeshen";
	}
	/**
	 * 转向到酒店订单详细信息页面
	 */	
	public String toyufudetails()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
		listHotelorderrc = Server.getInstance().getHotelService().findAllHotelorderrc(" WHERE " 
				+ Hotelorderrc.COL_orderid + " IN( SELECT " + Hotelorder.COL_id + " FROM " + Hotelorder.TABLE + 
			" WHERE " + Hotelorder.COL_orderid + "='" + hotelorder.getOrderid() + "')", " ORDER BY " + Hotelorderrc.COL_id, 
				-1, 0) ;
		return "toyufudetails";
	}
	/**
	 * 转向到酒店订单修改页面
	 */	
	public String toedit()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(hotelorder.getId());
		return EDIT;
	}
	
	/**
	 * 转向到酒店订单审核页面
	 */	
	public String tocheck()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(hotelorder.getId());
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid()) ;
		listHotelorderrc = Server.getInstance().getHotelService().findAllHotelorderrc(" WHERE " 
				+ Hotelorderrc.COL_orderid + " IN( SELECT " + Hotelorder.COL_id + " FROM " + Hotelorder.TABLE + 
				" WHERE " + Hotelorder.COL_orderid + "='" + hotelorder.getOrderid() + "')", " ORDER BY " + Hotelorderrc.COL_id, 
				-1, 0) ;
		return CHECK;
	}
	
	
	/**
	 * 添加酒店订单
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getHotelService().createHotelorder(hotelorder);
		return LIST;
	}

	/**
	 * 审核酒店订单
	 */		
	public String check()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
		int stt = hotelorder.getState();
		
		hotelorder.setState(sta);
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid());
		
		
	
		
		//下单结束
		
		if(sta==6){
			
				
				hotelorder.setState(6);
				Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
				
				/*//取消订单.发短信
				String smstemple="";
				smstemple=this.getSMSTemple("CancelHotelOrder");
				smstemple=smstemple.replaceAll("@CustomerName@", hotelorder.getLinkname());
				smstemple=smstemple.replaceAll("@reserve_date@",formatDate(hotelorder.getComedate()).toString());
				smstemple=smstemple.replaceAll("@hotel_name@",hotelorder.getName()+"("+hotelorder.getRoomtypename()+")");
				smstemple=smstemple.replaceAll("@room_type_rmdy@",hotelorder.getManyday()+"间"+hotelorder.getManyday());
				
				this.smsSend(new String[]{""+hotelorder.getLinkmobile()+""}, smstemple,hotelorder.getOrderid()+"","");
				*/
				String ret=	Server.getInstance().getHotelInterService().CancelHotelOrder(hotelorder);
				
				if(ret.equals("1")){
					System.out.println("取消成功");
				}else{
					
					System.out.println("取消失败");
				}
		}
		if(sta==9){//已入住
			
			//调用分润方法
			
		}
	
		
		
		if(hotelorder.getProperty().equals("1")){////1,国内 2,国际
		forward = "hotel/hotelwholeorder.action?h_state="+stt;
		}

		if(hotelorder.getProperty().equals("2")){
		forward = "interhotelorder/hotelwholeorder!interhotelorder.action?h_state="+stt;
		}
		return LIST;
	}
	
	/**
	 * 审核酒店订单
	 */		
	public String checkhui()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
		int stt = hotelorder.getState();
		hotelorder.setIshotelpay(1l);
		
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid());
		
		
		if(hotelorder.getPaytype()==2){
		forward = "hotel/hotelwholeorder!toyufu.action?h_state=14";
		}
		if(hotelorder.getPaytype()==1){
		forward = "hotel/hotelwholeorder.action?h_state=9";
			}
		return LIST;
	}
	
	

	/**
	 * 审核酒店订单
	 */		
	public String checkyufu()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
		int stt = hotelorder.getState();
		//hotelorder.setState(sta);
		long st = hotelorder.getPaytype();
		
		hotelorder.setPaytype(typ);
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		hotel = Server.getInstance().getHotelService().findHotel(hotelorder.getHotelid());

		if(st==2){
		forward = "hotel/hotelwholeorder!toyufu.action?h_state="+stt;
		}
		if(st==1){
		forward = "hotel/hotelwholeorder.action?h_state="+stt;
			}
		return LIST;
	}
	
	
	
	
	
	
	
	
	
	String guestname="";
	/**
	 * 发传真
	 */		
	public String tochuanzhen()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
		//hotelorder.setState(sta);
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		long hid = hotelorder.getHotelid();
		hotel = Server.getInstance().getHotelService().findHotel(hid);
		listGuest = Server.getInstance().getHotelService().findAllGuest("where 1=1 and "+Guest.COL_orderid+" ="+ordid, " ORDER BY ID ", -1, 0);
		
		for(int i=0;i<listGuest.size();i++){
			guestname+= listGuest.get(i).getName()+"/";
		}
		
		return "tochuanzhen";
	}
	/**
	 * 结算中心
	 */		
	public String tojiesuan()throws Exception{
		StringBuffer where = new StringBuffer(" where 1=1 AND " + Hotelorder.COL_version + ">0 and "+Hotelorder.COL_paytype+"=1 and "+Hotelorder.COL_state+" =9" );
		listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString(),"order by ID DESC" ,pageinfo);
		if(pageinfo.getTotalrow()>0 && listHotelorder.size()==0){
			pageinfo.setPagenum(1);
			listHotelorder = Server.getInstance().getHotelService().findAllHotelorderForPageinfo(where.toString()," order by DESC",pageinfo);	
		}
		pageinfo = (PageInfo) listHotelorder.get(0) ;
		listHotelorder.remove(0) ;
		
		return "tojiesuan";
	}
	public String toxunjiahan()throws Exception{
		
		return "toxunjiahan";
	}
	public String toshangjin()throws Exception{
		
		return "toshangjin";
	}
	public String totianjin()throws Exception{
		
		return "totianjin";
	}
	public String toyft()throws Exception{
		
		return "toyft";
	}
	public String tojiudian()throws Exception{
		
		return "tojiudian";
	}
	/**
	 * 审核酒店订单
	 */		
	public String chuanzhen()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
		int stt = hotelorder.getState();
		hotelorder.setState(sta);
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		
		Map<String, String> map=new HashMap<String, String>();

		map.put("newfax", "D://tomcat/webapps/sj_home/hotel/hotelfax/hotelfax"+order+".html");//创建新传真的路径html
		map.put("newfaxpdf", "D://tomcat/webapps/sj_home/hotel/hotelfax"+order+".pdf");//创建新传真的pdf
		map.put("faxtemple", "D://tomcat/webapps/sj_home/hotel/hotelfax/hotel.html");//传真模板的路径
		map.put("rname", rname);//收件人
		map.put("rphone", rphone);//收件人电话
		map.put("rfax", rfax);//收件人传真
		map.put("sname", sname);//发件人
		map.put("sphone", sphone);//发件人电话
		map.put("sfax", sfax);//发件人传真
		map.put("senddate", senddate);//日期
		map.put("hotelname", hotelname);//入住酒店名称
		map.put("countty", countty);//客人国籍
		map.put("peoplenum", peoplenum);//人数
		map.put("order", order);//单号
		map.put("name", "name");//客人姓名/团号
		map.put("begindate", begindate);//入住日期
		map.put("enddate", enddate);//离店日期
		map.put("roommun", roommun);//房型房数
		map.put("breakfast", breakfast);//早餐
		map.put("price", dateprice);//房价单价
		map.put("content", content);//特殊要求
		map.put("paymoney", paymoney);//付款方式
		map.put("makename", makename);//制单人
		
		String filename=Server.getInstance().getAtomService().getHotelTemple(map);
		int i = Server.getInstance().getAtomService().sendFax("01084977053",filename);
		if(hotelorder.getPaytype()==2){
			forward = "hotel/hotelwholeorder!toyufu.action?h_state="+stt;
			}
			if(hotelorder.getPaytype()==1){
			forward = "hotel/hotelwholeorder.action?h_state="+stt;
				}
		return LIST;
	}
	/**
	 * 北京天河联盟商务旅行社有限公司
	 */		
	public String shangjin()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
		int stt = hotelorder.getState();
		hotelorder.setState(sta);
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		
		Map<String, String> map=new HashMap<String, String>();

		map.put("newfax", "D://tomcat/webapps/sj_home/hotel/hotelfax/hotelfax"+order+".html");//创建新传真的路径html
		map.put("newfaxpdf", "D://tomcat/webapps/sj_home/hotel/hotelfax"+order+".pdf");//创建新传真的pdf
		map.put("faxtemple", "D://tomcat/webapps/sj_home/hotel/hotelfax/sj.html");//传真模板的路径
		map.put("lianxiren", lianxiren);//联系人
		map.put("shouji", shouji);//联系人手机
		map.put("qq", qq);//联系人QQ
		
		
		String filename=Server.getInstance().getAtomService().getHotelTemple(map);
		int i = Server.getInstance().getAtomService().sendFax("01084977053",filename);
		if(hotelorder.getPaytype()==2){
			forward = "hotel/hotelwholeorder!toyufu.action?h_state="+stt;
			}
			if(hotelorder.getPaytype()==1){
			forward = "hotel/hotelwholeorder.action?h_state="+stt;
				}
		return LIST;
	}
	/**
	 * 天津滨江万丽确认增加.doc
	 */		
	public String tianj()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
		int stt = hotelorder.getState();
		hotelorder.setState(sta);
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		
		Map<String, String> map=new HashMap<String, String>();

		map.put("newfax", "D://tomcat/webapps/sj_home/hotel/hotelfax/hotelfax"+order+".html");//创建新传真的路径html
		map.put("newfaxpdf", "D://tomcat/webapps/sj_home/hotel/hotelfax"+order+".pdf");//创建新传真的pdf
		map.put("faxtemple", "D://tomcat/webapps/sj_home/hotel/hotelfax/tianjin.html");//传真模板的路径
		map.put("rname", rname);//收件人
		map.put("rphone", rphone);//收件人电话
		map.put("rfax", rfax);//收件人传真
		map.put("sname", sname);//发件人
		map.put("sphone", sphone);//发件人电话
		map.put("sfax", sfax);//发件人传真
		map.put("senddate", senddate);//日期
		map.put("hotelname", hotelname);//入住酒店名称
		map.put("name", "name");//客人姓名/团号
		map.put("begindate", begindate);//入住日期
		map.put("enddate", enddate);//离店日期
		map.put("roommun", roommun);//房型房数
		map.put("dateprice", dateprice);//房价单价
		map.put("zongprice", zongprice);//总价
		map.put("paymoney", paymoney);//付款方式
		map.put("makename", makename);//制单人
		
		String filename=Server.getInstance().getAtomService().getHotelTemple(map);
		int i = Server.getInstance().getAtomService().sendFax("01084977053",filename);
		if(hotelorder.getPaytype()==2){
			forward = "hotel/hotelwholeorder!toyufu.action?h_state="+stt;
			}
			if(hotelorder.getPaytype()==1){
			forward = "hotel/hotelwholeorder.action?h_state="+stt;
				}
		return LIST;
	}
	/**
	 * 询价函
	 */		
	public String xunjiahan()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
		int stt = hotelorder.getState();
		hotelorder.setState(sta);
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		
		Map<String, String> map=new HashMap<String, String>();

		map.put("newfax", "D://tomcat/webapps/sj_home/hotel/hotelfax/hotelfax"+order+".html");//创建新传真的路径html
		map.put("newfaxpdf", "D://tomcat/webapps/sj_home/hotel/hotelfax"+order+".pdf");//创建新传真的pdf
		map.put("faxtemple", "D://tomcat/webapps/sj_home/hotel/hotelfax/xjhan.html");//传真模板的路径
		map.put("rphone", rphone);//收件人电话
		map.put("rfax", rfax);//收件人传真
		map.put("name", "name");//客人姓名
		map.put("nian1", nian1);//
		map.put("yue1", yue1);//
		map.put("nian2", nian2);//
		map.put("yue2", yue2);//
		
		
		String filename=Server.getInstance().getAtomService().getHotelTemple(map);
		int i = Server.getInstance().getAtomService().sendFax("01084977053",filename);
		if(hotelorder.getPaytype()==2){
			forward = "hotel/hotelwholeorder!toyufu.action?h_state="+stt;
			}
			if(hotelorder.getPaytype()==1){
			forward = "hotel/hotelwholeorder.action?h_state="+stt;
				}
		return LIST;
	}
	/**
	 * 源丰通预订单.doc
	 */		
	public String yuanfengtong()throws Exception{
		hotelorder = Server.getInstance().getHotelService().findHotelorder(ordid);
		int stt = hotelorder.getState();
		hotelorder.setState(sta);
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		
		Map<String, String> map=new HashMap<String, String>();

		map.put("newfax", "D://tomcat/webapps/sj_home/hotel/hotelfax/hotelfax"+order+".html");//创建新传真的路径html
		map.put("newfaxpdf", "D://tomcat/webapps/sj_home/hotel/hotelfax"+order+".pdf");//创建新传真的pdf
		map.put("faxtemple", "D://tomcat/webapps/sj_home/hotel/hotelfax/yft.html");//传真模板的路径
		map.put("sname", sname);//发件人
		map.put("senddate", senddate);//日期
		map.put("hotelname", hotelname);//入住酒店名称
		map.put("countty", countty);//客人国籍
		map.put("peoplenum", peoplenum);//人数
		map.put("order", order);//单号
		map.put("name", "name");//客人姓名/团号
		map.put("begindate", begindate);//入住日期
		map.put("enddate", enddate);//离店日期
		map.put("roommun", roommun);//房型房数
		map.put("breakfast", breakfast);//早餐
		map.put("dateprice", dateprice);//房价单价
		map.put("content", content);//特殊要求
		
		String filename=Server.getInstance().getAtomService().getHotelTemple(map);
		int i = Server.getInstance().getAtomService().sendFax("01084977053",filename);
		if(hotelorder.getPaytype()==2){
			forward = "hotel/hotelwholeorder!toyufu.action?h_state="+stt;
			}
			if(hotelorder.getPaytype()==1){
			forward = "hotel/hotelwholeorder.action?h_state="+stt;
				}
		return LIST;
	}
	/**
	 * 发送确认传真
	 */
	public String sendConfirmFax() throws Exception{
		System.out.println("发送确认传真-------------------------------------") ;
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		return LIST ;
	}
	
	/**
	 * 发送入住确认传真
	 */
	public String sendPutupConfirmFax() throws Exception{
		System.out.println("发送入住确认传真-------------------------------------") ;
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		return LIST ;
	}
	
	/**
	 * 编辑酒店订单
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getHotelService().updateHotelorderIgnoreNull(hotelorder);
		return LIST;
	}

	/**
	 * 删除酒店订单
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteHotelorder(hotelorder.getId());
		return LIST;
	}


	/**
	 * 批量操作
	 * @return
	 * @throws Exception
	 */
	public String batch()throws Exception{
		if(selectid!=null && selectid.length>0 ){
			
			switch(opt){
				case 1: //delete
				
				for(int i:selectid){
					Server.getInstance().getHotelService().deleteHotelorder(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}


	/**
	 *  返回酒店订单对象
	 */		
	
	public Object getModel() {
		return hotelorder;
	}
	public List < Hotelorder >   getListHotelorder() {
		return listHotelorder;
	}

	public Hotelorder getHotelorder() {
		return hotelorder;
	}
	public void setHotelorder(Hotelorder hotelorder) {
		this.hotelorder = hotelorder;
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

	public String getH_comedate() {
		return h_comedate;
	}

	public void setH_comedate(String h_comedate) {
		this.h_comedate = h_comedate;
	}

	public Integer getH_isEnglishName() {
		return h_isEnglishName;
	}

	public void setH_isEnglishName(Integer englishName) {
		h_isEnglishName = englishName;
	}

	public Integer getH_hotelCityId() {
		return h_hotelCityId;
	}

	public void setH_hotelCityId(Integer cityId) {
		h_hotelCityId = cityId;
	}

	public String getH_hotelName() {
		return h_hotelName;
	}

	public void setH_hotelName(String name) {
		h_hotelName = name;
	}

	public String getH_leavedate() {
		return h_leavedate;
	}

	public void setH_leavedate(String h_leavedate) {
		this.h_leavedate = h_leavedate;
	}

	public String getH_linkmobile() {
		return h_linkmobile;
	}

	public void setH_linkmobile(String h_linkmobile) {
		this.h_linkmobile = h_linkmobile;
	}

	public String getH_linkname() {
		return h_linkname;
	}

	public void setH_linkname(String h_linkname) {
		this.h_linkname = h_linkname;
	}

	public String getH_orderId() {
		return h_orderId;
	}

	public void setH_orderId(String id) {
		h_orderId = id;
	}

	public List<City> getListCities() {
		return listCities;
	}

	public void setListCities(List<City> listCities) {
		this.listCities = listCities;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Integer getH_auditing_pass() {
		return h_auditing_pass;
	}

	public void setH_auditing_pass(Integer h_auditing_pass) {
		this.h_auditing_pass = h_auditing_pass;
	}

	public String getH_noauditing_reason() {
		return h_noauditing_reason;
	}

	public void setH_noauditing_reason(String h_noauditing_reason) {
		this.h_noauditing_reason = h_noauditing_reason;
	}

	public String getH_preendtime() {
		return h_preendtime;
	}

	public void setH_preendtime(String h_preendtime) {
		this.h_preendtime = h_preendtime;
	}

	public String getH_prestarttime() {
		return h_prestarttime;
	}

	public void setH_prestarttime(String h_prestarttime) {
		this.h_prestarttime = h_prestarttime;
	}

	public List<Hotelorderrc> getListHotelorderrc() {
		return listHotelorderrc;
	}

	public void setListHotelorderrc(List<Hotelorderrc> listHotelorderrc) {
		this.listHotelorderrc = listHotelorderrc;
	}

	public String getH_type() {
		return h_type;
	}

	public void setH_type(String h_type) {
		this.h_type = h_type;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public int getH_ordertype() {
		return h_ordertype;
	}

	public void setH_ordertype(int h_ordertype) {
		this.h_ordertype = h_ordertype;
	}

	public String getH_state() {
		return h_state;
	}

	public void setH_state(String h_state) {
		this.h_state = h_state;
	}
	public long getOrdid() {
		return ordid;
	}
	public void setOrdid(long ordid) {
		this.ordid = ordid;
	}
	public int getSta() {
		return sta;
	}
	public void setSta(int sta) {
		this.sta = sta;
	}
	public List<Guest> getListGuest() {
		return listGuest;
	}
	public void setListGuest(List<Guest> listGuest) {
		this.listGuest = listGuest;
	}
	public String getGuestname() {
		return guestname;
	}
	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	public String getRfax() {
		return rfax;
	}
	public void setRfax(String rfax) {
		this.rfax = rfax;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSfax() {
		return sfax;
	}
	public void setSfax(String sfax) {
		this.sfax = sfax;
	}
	public String getSenddate() {
		return senddate;
	}
	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getCountty() {
		return countty;
	}
	public void setCountty(String countty) {
		this.countty = countty;
	}
	public String getPeoplenum() {
		return peoplenum;
	}
	public void setPeoplenum(String peoplenum) {
		this.peoplenum = peoplenum;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getRoommun() {
		return roommun;
	}
	public void setRoommun(String roommun) {
		this.roommun = roommun;
	}
	public String getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getDateprice() {
		return dateprice;
	}
	public void setDateprice(String dateprice) {
		this.dateprice = dateprice;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(String paymoney) {
		this.paymoney = paymoney;
	}
	public String getMakename() {
		return makename;
	}
	public void setMakename(String makename) {
		this.makename = makename;
	}
	public void setListHotelorder(List listHotelorder) {
		this.listHotelorder = listHotelorder;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public long getTyp() {
		return typ;
	}
	public void setTyp(long typ) {
		this.typ = typ;
	}

	public String getLianxiren() {
		return lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}

	public String getShouji() {
		return shouji;
	}

	public void setShouji(String shouji) {
		this.shouji = shouji;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getZongprice() {
		return zongprice;
	}

	public void setZongprice(String zongprice) {
		this.zongprice = zongprice;
	}

	public String getDizhi() {
		return dizhi;
	}

	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}

	public String getDianhua() {
		return dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	public String getYue() {
		return yue;
	}

	public void setYue(String yue) {
		this.yue = yue;
	}

	public String getRi() {
		return ri;
	}

	public void setRi(String ri) {
		this.ri = ri;
	}

	public String getShi() {
		return shi;
	}

	public void setShi(String shi) {
		this.shi = shi;
	}

	public String getJiaqi() {
		return jiaqi;
	}

	public void setJiaqi(String jiaqi) {
		this.jiaqi = jiaqi;
	}

	public String getNian1() {
		return nian1;
	}

	public void setNian1(String nian1) {
		this.nian1 = nian1;
	}

	public String getYue1() {
		return yue1;
	}

	public void setYue1(String yue1) {
		this.yue1 = yue1;
	}

	public String getNian2() {
		return nian2;
	}

	public void setNian2(String nian2) {
		this.nian2 = nian2;
	}

	public String getYue2() {
		return yue2;
	}

	public void setYue2(String yue2) {
		this.yue2 = yue2;
	}

	public long getHui() {
		return hui;
	}

	public void setHui(long hui) {
		this.hui = hui;
	}
	public String getGuestid() {
		return guestid;
	}
	public void setGuestid(String guestid) {
		this.guestid = guestid;
	}
	public String getTy() {
		return ty;
	}
	public void setTy(String ty) {
		this.ty = ty;
	}
	public Hotelorder getMangGohotelorder() {
		return MangGohotelorder;
	}
	public void setMangGohotelorder(Hotelorder mangGohotelorder) {
		MangGohotelorder = mangGohotelorder;
	}
	public List<Customeragent> getListCustomeragent() {
		return listCustomeragent;
	}
	public void setListCustomeragent(List<Customeragent> listCustomeragent) {
		this.listCustomeragent = listCustomeragent;
	}
	public long getS_num() {
		return s_num;
	}
	public void setS_num(long s_num) {
		this.s_num = s_num;
	}
	public long getH_angent() {
		return h_angent;
	}
	public void setH_angent(long h_angent) {
		this.h_angent = h_angent;
	}
	public long getLongtype() {
		return longtype;
	}
	public void setLongtype(long longtype) {
		this.longtype = longtype;
	}


	public List<Incity> getListIncity() {
		return listIncity;
	}


	public void setListIncity(List<Incity> listIncity) {
		this.listIncity = listIncity;
	}


	
}