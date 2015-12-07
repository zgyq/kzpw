package com.yf.website.web.action;

import java.io.Writer;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.webwork.ServletActionContext;
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.charterorder.Charterorder;
import com.yf.system.base.city.City;
import com.yf.system.base.helpcenter.Helpcenter;
import com.yf.system.base.helpcenterinfo.Helpcenterinfo;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelimage.Hotelimage;
import com.yf.system.base.information.Information;
import com.yf.system.base.informationinfo.Informationinfo;
import com.yf.system.base.passenger.Passenger;
import com.yf.system.base.planeservice.Planeservice;
import com.yf.system.base.qzchanpin.Qzchanpin;
import com.yf.system.base.qzchanpininfo.Qzchanpininfo;
import com.yf.system.base.qzguojia.Qzguojia;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.spotline.Spotline;
import com.yf.system.base.spotlineprice.Spotlineprice;
import com.yf.system.base.spotmes.Spotmes;
import com.yf.system.base.spotticket.Spotticket;
import com.yf.website.web.server.Server;

public class IndexAction extends B2b2cbackAction {
	private List <  Qzguojia  >  listQzguojiayz;//亚洲
	private List <  Qzguojia  >  listQzguojiaoz;//欧洲
	private List <  Qzguojia  >  listQzguojiamz;//美洲
	private List <  Qzguojia  >  listQzguojiaaz;//奥洲
	private List <  Qzguojia  >  listQzguojiafz;//非洲
	
	//帮助中心首页主推用
	private List<Helpcenter> ListHelpcenterIndex;
	private List<Information> ListInformationIndex;
	//帮助信息LIST
	public List<Helpcenterinfo> Listhelpcenterinfo;
	//
	private List<Helpcenter> ListHelpcenter;
	private List<Helpcenterinfo> ListHelpcenterinfo=new ArrayList<Helpcenterinfo>();
	private List<Informationinfo> ListInformationinfo=new ArrayList<Informationinfo>();
	private List<Information> ListInformation;
	private List<Information> ListInformationtype;
	private Information information;
	private Informationinfo informationinfo;
	private Helpcenterinfo helpcenterinfo = new Helpcenterinfo();
	private Helpcenter helpcenter = new Helpcenter();
	private Planeservice planeservice = new Planeservice();
	private String forward;
	private long HelpcenterID;//类型ID
	private long HelpcenterinfoID;//信息ID
	private long Helpid;
	private long Informationid;
	private String s_name;// 检索用
	// 航空公司信息
	public List<Aircompany> listAirCompany;
	// 跳转用
	private String forword;
	// 包机服务时间
	private String s_traveltime;
	private String s_returntime;
//判断是否是首页
	
	private long isindex=0;
	// 3级栏目
	private String onename;
	private String twoname;
	private String threename;
	
	// 入住日期
	private String startDate;
	// 离店日期
	private String endDate;
	// 首页加载信息
	// 最新资讯
	private List<Informationinfo> listZX;
	// 包机服务
	private List<Informationinfo> listBJ;
	// 国内机票预订
	private List<Informationinfo> listJPYD;
	// 乘机常识
	private List<Helpcenterinfo> listCJCS;
	// 预订须知
	private List<Helpcenterinfo> listYDXZ;

	// 常见问题
	private List<Helpcenterinfo> listCJWT;
	//机票常识
	
	private List<Helpcenterinfo>  listCXBZ;
	
	// 热门推荐
	private List<Helpcenterinfo> listRMTJ;
	// 签证知识
	private List<Helpcenterinfo> listQZ;

	private List<Passenger>listpass;
	
	private List listlistpass = new ArrayList();
	private Charterorder charterorder = new Charterorder();
	private Segmentinfo segmentinfo = new Segmentinfo();
	private Segmentinfo segmentinfo2 = new Segmentinfo();
	//包机相关
	//航空公司
	private List<Aircompany> listAircompany;
	private long s_type;//航班类型  1单程 2往返
	private long s_usertype;//旅客类型  1内宾 2外宾
	private String s_startime;//出发时间
	private String s_endtime;//返程时间
	private String s_companyname;//航空公司
	private String s_flightcode;//航班号
	private String s_stime;//最早时间
	private String s_etime;//最晚时间
	private String s_maxnum;//最大乘机人数
	private String s_passtype;//乘机人类型  1成人  2儿童
	
	private String s_scity;//出发城市
	private String s_ecity;//到达城市
	
	
	private String c_idname;//乘机人姓名
	private String c_idtype;//乘机人证件类型
	private String c_idnumber;//乘机人证件号码
	
	private String s_username;//申请人姓名
	private String s_tel;//申请人电话
	private String s_qq;//申请人QQ
	private String s_remarks;//申请备注
	private long servicetype;//服务类型  1团队  2包机
	
	private int number;// 下标
	
	private int  type=0;//控制是否点击菜单用   0默认  1为点击菜单
	
	private String Address;//地图地址
	
	private String pname="五零";
	
	private String strCityID;
	
	private String c_id;//签证国家ID
	private long c_qzinfoid;//签证产品ID
	private List<Qzchanpin> ListQzchanpin;
	private List<Qzchanpininfo> ListQzchanpininfo;
	private Qzguojia qzguojia;
	private Qzchanpininfo qzchanpininfo;
	public IndexAction() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		startDate = sdf.format(calendar.getTime());
		calendar.add(Calendar.DATE, 1);
		endDate = sdf.format(calendar.getTime());
		
		/*
		 * starList.put("1", "经济型"); starList.put("3", "二星级"); starList.put("4",
		 * "准三星"); starList.put("5", "三星级"); starList.put("6", "准四星");
		 * starList.put("7", "四星级"); starList.put("8", "准五星"); starList.put("9",
		 * "五星级");
		 */
	}
	
	public String toqz(){
		
		  listQzguojiayz=Server.getInstance().getTripService().findAllQzguojia(" WHERE 1=1 AND "+Qzguojia.COL_bclassid+" =6", " ORDER BY ID ", -1, 0);
		  listQzguojiaoz=Server.getInstance().getTripService().findAllQzguojia(" WHERE 1=1 AND "+Qzguojia.COL_bclassid+" =2", " ORDER BY ID ", -1, 0);
		  listQzguojiamz=Server.getInstance().getTripService().findAllQzguojia(" WHERE 1=1 AND "+Qzguojia.COL_bclassid+" =3", " ORDER BY ID ", -1, 0);
		  listQzguojiaaz=Server.getInstance().getTripService().findAllQzguojia(" WHERE 1=1 AND "+Qzguojia.COL_bclassid+" =4", " ORDER BY ID ", -1, 0);
		  listQzguojiafz=Server.getInstance().getTripService().findAllQzguojia(" WHERE 1=1 AND "+Qzguojia.COL_bclassid+" =5", " ORDER BY ID ", -1, 0);
		
		
		return "toqianzhen";
	}
	public String toqzbycont(){
		ListQzchanpininfo=Server.getInstance().getTripService().findAllQzchanpininfo(" where 1=1 and "+Qzchanpininfo.COL_param2+" ='"+c_id+"'", "", 10, 0);
		
		//qzguojia=Server.getInstance().getTripService().findQzguojia(id);
		return "toqzbycont";
	}
	public String toqzinfo(){
		//ListQzchanpininfo=Server.getInstance().getTripService().findAllQzchanpininfo(" where 1=1 and "+Qzchanpininfo.COL_param2+" ='"+c_id+"'", "", 10, 0);
		qzchanpininfo=Server.getInstance().getTripService().findQzchanpininfo(c_qzinfoid);
		//qzguojia=Server.getInstance().getTripService().findQzguojia(id);
		return "toqzinfo";
	}
	
	/**
	 * AJAX读取酒店推荐信息 2012-02-14 陈星  平台首页用
	 * 
	 * @throws
	 */
	public void GetSpotTicketByIndex() throws Exception {
		System.out.println("strCityID:"+strCityID);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		//String where=" where 1=1 and "+Hotel.COL_type+" =1 and "+Hotel.COL_state+" =3  and "+Hotel.COL_cityid+" ='"+strCityID+"'";
		//List<Hotel>ListHotel=Server.getInstance().getHotelService().findAllHotel(where, " ORDER BY C_STAR", 7, 0);
		
		String where=" where 1=1 and "+Spotticket.COL_sid+" in ( SELECT "+Spotmes.COL_id+" FROM "+Spotmes.TABLE+" where "+Spotmes.COL_cityid+" ='"+strCityID+"')";
		List<Spotticket>listticket=Server.getInstance().getTripService().findAllSpotticket(where, " ORDER BY ID ", 7, 0);
		
		StringBuilder sb = new StringBuilder();
		for(int h=0;h<listticket.size();h++){
			//List<Spotticket>listticket=Server.getInstance().getTripService().findAllSpotticket(" WHERE 1=1 AND "+Spotticket.COL_sid+" ='"+ListSpotmes.get(h).getId()+"'", " ORDER BY ID ", 1, 0);
			Spotmes spotmes=Server.getInstance().getTripService().findSpotmes(Long.parseLong(listticket.get(h).getSid()));
			if(h==0){
			sb.append("<div class='vac_item vac_item_main'>");
			sb.append("<a href='spotticket!toSpotTicketInfo.jspx?SpotMesID="+spotmes.getId()+"&startDate="+startDate+"' class='vac_thumb'>");
			sb.append("<img src='http://www.bzezt.com/uploads/"+spotmes.getMinipics()+"' alt='' width='500' height='280' /></a>");
			sb.append("<p><span class='c_price'>"+listticket.get(h).getShopprice()+"</span>起</p>");
			sb.append("<a href='spotticket!toSpotTicketInfo.jspx?SpotMesID="+spotmes.getId()+"&startDate="+startDate+"' title='"+listticket.get(h).getName()+"'>"+listticket.get(h).getName()+"</a></div>");
			}else{
			sb.append("<div class='vac_item'>");
			sb.append("<a href='spotticket!toSpotTicketInfo.jspx?SpotMesID="+spotmes.getId()+"&startDate="+startDate+"' class='vac_thumb'>");
			sb.append("<img src='http://www.bzezt.com/uploads/"+spotmes.getMinipics()+"' alt='' width='186' height='105' /></a>");
			sb.append("<p><span class='c_price'>"+listticket.get(h).getShopprice()+"</span>起</p>");
			sb.append("<a href='spotticket!toSpotTicketInfo.jspx?SpotMesID="+spotmes.getId()+"&startDate="+startDate+"' title='"+listticket.get(h).getName()+"'>"+listticket.get(h).getName()+"</a></div>");
				
			}
			
			
			}
		System.out.println("门票:"+sb.toString());

		Writer writer = response.getWriter();
		writer.write(sb.toString());
		writer.flush();
		writer.close();
	}
	
	public void GetSpotTicketByIndex_tc() throws Exception {
		System.out.println("strCityID:"+strCityID);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		
		//String where=" where 1=1 and "+Spotticket.COL_sid+" in ( SELECT "+Spotmes.COL_id+" FROM "+Spotmes.TABLE+" where "+Spotmes.COL_cityid+" ='"+strCityID+"')";
		//List<Spotticket>listticket=Server.getInstance().getTripService().findAllSpotticket(where, " ", 8, 0);
		List<Spotmes> listspotmes=Server.getInstance().getTripService().findAllSpotmes(" WHERE 1=1 AND "+Spotmes.COL_cityid+" ='"+strCityID+"' AND "+Spotmes.COL_name.length()+"<=9", "", 8, 0);
		
		StringBuilder sb = new StringBuilder();
		for(int h=0;h<listspotmes.size();h++){
			//List<Spotticket>listticket=Server.getInstance().getTripService().findAllSpotticket(" WHERE 1=1 AND "+Spotticket.COL_sid+" ="+listspotmes.get(h).getId(), " order by id ", 1, 0);
			String sname=listspotmes.get(h).getName();
			sb.append("<li class='listBoxViewLi'>");
			sb.append("<dl class='listViewDl'>");//target='_blank'
			sb.append("<dd class='listViewDd'><a title='"+sname+"' href='#'  class='listViewimg'>");
			sb.append("<img  width='159' height='120' src='http://upload.17u.com/uploadfile/"+listspotmes.get(h).getMinipics()+"' alt='"+sname+"'> </a><label class='topNum'>Top "+(h+1)+"</label></dd>");
			sb.append("<dd class='listViewInf'><a class='senicName' title='"+sname+"' href='spotticket!toSpotTicketInfo.jspx?SpotMesID="+listspotmes.get(h).getId()+"&startDate="+startDate+"' >"+sname+"</a></dd>");
			//sb.append("<dd class='listViewInf listViewBotm'>空铁价：<span class='dollar'>¥</span><span class='price'>"+listticket.get(0).getShopprice()+"</span></dd>");
			sb.append("<dd class='listViewInf listViewBotm'>"+pname+"价：<span class='dollar'>¥</span><span class='price'>"+listspotmes.get(h).getUid().split("@")[1]+"</span></dd>");
			sb.append("</dl>");
			sb.append("</li>");
			
			
			}
		//System.out.println("门票:"+sb.toString());

		Writer writer = response.getWriter();
		writer.write(sb.toString());
		writer.flush();
		writer.close();
	}
	
	
	public void GetSpotLineByIndex_tc() throws Exception {
		System.out.println("strCityID:"+strCityID);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		
		//List<Spotmes> listspotmes=Server.getInstance().getTripService().findAllSpotmes(" WHERE 1=1 AND "+Spotmes.COL_cityid+" ='"+strCityID+"' AND "+Spotmes.COL_name.length()+"<=9", "", 8, 0);
		
		List<Spotline>listSpotline=Server.getInstance().getTripService().findAllSpotline(" WHERE 1=1 AND ("+Spotline.COL_provineid+" ='"+strCityID+"' OR "+Spotline.COL_cityid+" ='"+strCityID+"') and "+Spotline.COL_stype+" =3", " ORDER BY ID DESC ", 4, 0);
		StringBuilder sb = new StringBuilder();
		for(int h=0;h<listSpotline.size();h++){
			//spotline!toSpotLineInfo.jspx?SpotLineID=23&startDate=2014-03-26
			String surl="spotline!toSpotLineInfo.jspx?SpotLineID="+listSpotline.get(h).getId();
			String sname=listSpotline.get(h).getName();
			sb.append("<li class='selfBoxViewLi selfBoxFirstLi c_selfBoxViewLi2 clearfix'>");
			sb.append("<label class='lbl_lst c_lbl_lst2'>1314<span>狂欢节</span></label>");
			sb.append("<a class='selfBoxViewA' title='"+sname+"'"); //target='_blank'
			sb.append("href='"+surl+"'  nalt=''><img src='images/spotline/spotline0"+h+".jpg' /></a>");
			sb.append("<div class='selfBoxNoteDiv'>");
			
			
			sb.append("<dl class='selfBoxNoteDl'>");
			sb.append("<dd class='selfBoxNote'><a href='"+surl+"' target='_blank' title='"+sname+"' class='selfBoxNoteA1'>"+sname+"</a></dd>");
			//sb.append("<dd class='selfBoxNote'><a href='#' target='_blank' title='"+sname+"' class='selfBoxNoteA2'>【双蛋特价预售，最后5套】【北京】【自选】北京温都水城H</a></dd>");
			sb.append("<dd class='selfBoxNote'><span class='c_selfBoxCommWidth'><span class='selfBoxCommSp selfBoxCommImg1'></span>");
			
			
			
			String goumai="10";
			//产生随机数字购买
			int Min1 = 10;
			int Max1 = 100;
			int result1 = Min1 + (int)(Math.random() * ((Max1 - Min1) + 1));
			goumai=result1+"";
			
			String pl="10";
			//产生随机数字评论
			int Min = 10;
			int Max = Integer.parseInt(goumai);
			int result = Min + (int)(Math.random() * ((Max - Min) + 1));
			pl=result+"";
			
			
			
			sb.append("<a class='fontSp' title='评论' href='#' target='_blank'>"+pl+"</a>条评论 </span> <span class='selfBoxCommSp selfBoxCommImg2'></span>");
			sb.append("<span class='fontSp personSp'>"+goumai+"</span>人购买</dd></dl>");
			
			String price="10";
			List<Spotlineprice>listprice=Server.getInstance().getTripService().findAllSpotlineprice(" WHERE 1=1 AND "+Spotlineprice.COL_spotlineid+" ="+listSpotline.get(h).getId()+" AND "+Spotlineprice.COL_ptype+" ='成人'", " ORDER BY ID DESC ", -1, 0);
			if(listprice!=null&&listprice.size()>0){
				price=listprice.get(0).getPrice();
				
			}else{
				
				//产生随机数字
				int Min2 = 200;
				int Max2 = 400;
				int result2 = Min2 + (int)(Math.random() * ((Max2 - Min2) + 1));
				price=result2+"";
				
			}
			
			sb.append("<dl class='' ><dd  class=''><b><span class='dollar' style='font-size: 12px;'>¥"+price+"</span></b>起/人</dd>");
			sb.append("</dl></div></li>");
			
			
			}
		//System.out.println("门票:"+sb.toString());

		Writer writer = response.getWriter();
		writer.write(sb.toString());
		writer.flush();
		writer.close();
	}
	
	







	/**
	 * AJAX读取酒店推荐信息 2012-02-14 陈星  平台首页用
	 * 
	 * @throws
	 */
	public void GetIndexHotelByIndex() throws Exception {
		//System.out.println("酒店ID:"+strHotelCity);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		String where=" where 1=1 and "+Hotel.COL_type+" =1 and "+Hotel.COL_state+" =3  and "+Hotel.COL_cityid+" ='"+strCityID+"'";
		List<Hotel>ListHotel=Server.getInstance().getHotelService().findAllHotel(where, " ORDER BY C_STAR", 6, 0);
		StringBuilder sb = new StringBuilder();
		for(int h=0;h<ListHotel.size();h++){
			sb.append("<dl class='hotel_item'>");
			sb.append("<dt><span class='' title=''></span>");
			sb.append("<a href='hotel!toHotelInfo.jspx?HotelId="+ListHotel.get(h).getId()+"&startDate="+startDate+"&endDate="+endDate+"' title='"+ListHotel.get(h).getName()+"'>"+ListHotel.get(h).getName()+"</a></dt>");
			sb.append("<dd class='hotel_thumb'><a href='hotel!toHotelInfo.jspx?HotelId="+ListHotel.get(h).getId()+"&startDate="+startDate+"&endDate="+endDate+"'>");
			String imgurl="";
			imgurl=getImageSRc(ListHotel.get(h).getId());
			sb.append("<img  src='"+imgurl+"' width='130' height='130'  /></a></dd>");
			int star=1;
			String cname="diamond01_half";
			if(ListHotel.get(h).getStar()!=null&&ListHotel.get(h).getStar()>0){
				cname="diamond0"+ListHotel.get(h).getStar()+"_half";
			}
			//System.out.println("cname:"+cname);
			sb.append("<dd><span class='"+cname+"'></span></dd>");
			sb.append("<dd class='hotel_item_area'>");
			String dizhi="";
			if(ListHotel.get(h).getAddress()!=null){
				dizhi=ListHotel.get(h).getAddress();
			}
			String showdz=dizhi;
			if(showdz.length()>10){
				showdz=showdz.substring(0, 10);
			}
			sb.append("<a  href='#' title='"+dizhi+"'>"+showdz+"..</a>&nbsp;</dd>");
			//sb.append("<dd class='hotel_info'><span class='c_price'>349</span>起<br /></dd>");
			//sb.append("<dd class='hotel_comment'><a href='http://hotels.ctrip.com/hotel/dianping/61999.html'><b>4</b>分&nbsp;|&nbsp;1821人点评</a></dd>");
			sb.append("</dl>");
		}
		

		Writer writer = response.getWriter();
		writer.write(sb.toString());
		writer.flush();
		writer.close();
	}
	
	
	public void GetIndexHotelByIndex_tc() throws Exception {
		//System.out.println("酒店ID:"+strHotelCity);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		String where=" where 1=1 and "+Hotel.COL_type+" =1 and "+Hotel.COL_state+" =3  and "+Hotel.COL_cityid+" ='"+strCityID+"'";
			   where+=" and "+Hotel.COL_id+" in ( SELECT "+Hotelimage.COL_hotelid+" FROM "+Hotelimage.TABLE+" where ("+Hotelimage.COL_path+" !='' and "+Hotelimage.COL_path+" is not NULL)  ) and "+Hotel.COL_name.length()+"<=8";
		List<Hotel>ListHotel=Server.getInstance().getHotelService().findAllHotel(where, " ORDER BY C_STAR", 8, 0);
		System.out.println(where);
		StringBuilder sb = new StringBuilder();
		for(int h=0;h<ListHotel.size();h++){
			String hname=ListHotel.get(h).getName();
			String sprice="110.00";
			if(ListHotel.get(h).getStartprice()!=null){
				sprice=ListHotel.get(h).getStartprice().toString();
				
			}else{
			//产生随机数字
				int Min = 100;
				int Max = 300;
				int result = Min + (int)(Math.random() * ((Max - Min) + 1));
				sprice=result+"";
			}
			if(sprice.indexOf(".")!=-1){
				sprice=sprice.split("[.]")[0];
			}
			List<Hotelimage>listimg=Server.getInstance().getHotelService().findAllHotelimage(" WHERE 1=1 AND "+Hotelimage.COL_hotelid+" ="+ListHotel.get(h).getId(), " ORDER BY ID ", -1, 0);
			String imgurl="images/NoImage.gif";
			if(listimg.get(0).getPath()!=null){
				imgurl=listimg.get(0).getPath().trim();
				imgurl=imgurl.split("@")[0];
				//System.out.println(imgurl);
				//System.out.println(imgurl.split("@")[0]);
				if(imgurl.indexOf("http")==-1){
					imgurl="http://www.elongstatic.com/imageapp/hotels/hotelimages"+imgurl.split("@")[0] ;
				}else{
					imgurl=imgurl.split("@")[0];
				}
			}else if(listimg.get(0).getDescription()!=null){
				
				imgurl=listimg.get(0).getDescription().trim();
				imgurl=imgurl.split("@")[0];
				//System.out.println(imgurl);
				if(imgurl.indexOf("http")==-1){
					imgurl="http://www.elongstatic.com/imageapp/hotels/hotelimages"+imgurl.split("@")[0] ;
				}else{
					imgurl=imgurl.split("@")[0];
				}
				
			}else{
				
				imgurl="images/NoImage.gif";
			}
			 
			sb.append("<li class='listBoxViewLi'>");
			sb.append("<dl class='listViewDl'>");//target='_blank'
			sb.append("<dd class='listViewDd'><a title='"+hname+" href='hotel!toHotelInfo.jspx?HotelId="+ListHotel.get(h).getId()+"&startDate="+startDate+"&endDate="+endDate+"' title='"+ListHotel.get(h).getName()+"'  class='listViewimg'>" +
					" <img src='"+imgurl+"' alt='"+hname+"'> </a> <label class='topNum'>Top "+(h+1)+"</label></dd>");
			sb.append("<dd class='listViewInf'><a class='senicName' title='"+hname+"' href='hotel!toHotelInfo.jspx?HotelId="+ListHotel.get(h).getId()+"&startDate="+startDate+"&endDate="+endDate+"' title='"+ListHotel.get(h).getName()+"' >"+hname+"</a></dd>");
			//sb.append("<dd class='listViewInf listViewBotm'>空铁价：<span class='dollar'>¥</span><span class='price'>"+sprice+"起</span></dd>");
			sb.append("<dd class='listViewInf listViewBotm'>"+pname+"价：<span class='dollar'>¥</span><span class='price'>"+sprice+"起</span></dd>");
			sb.append("</dl>");
			sb.append("</li>");
		}
		

		Writer writer = response.getWriter();
		writer.write(sb.toString());
		writer.flush();
		writer.close();
	}
	
	
	
	
	
	
	//跳转到地图页面
	public String  ToMap() throws Exception{
	//	String address = new String(s_remarks.getBytes("ISO-8859-1"),"gb2312");
		
	//	s_remarks=java.net.URLDecoder.decode(s_remarks,"UTF-8"); 
	/*System.out.println("Address="+Address);	
	String address = new String(Address.getBytes("ISO-8859-1"),"UTF-8");
	System.out.println("address=="+address);
	Address=address;*/	
	//	Address=address;
		System.out.println("s_remarks=="+s_remarks);
	
		return "ToMap";
	}
	
	
	//跳转到秒杀活动页面
	
	public String  tomiaosha() throws Exception{
		
		
		
		return "tomiaosha";
	}
	
	//
	
	
	
	//跳转到关于我们
	public String  toabout() throws Exception{
		return "toabout";
	}
	public String  tofalv() throws Exception{
		return "tofalv";
	}
	public String  tohezuo() throws Exception{
		return "tohezuo";
	}
	public String  tohezuodanwei() throws Exception{
		return "tohezuodanwei";
	}
	public String  tojiameng() throws Exception{
		return "tojiameng";
	}
	public String  tokehu() throws Exception{
		return "tokehu";
	}
	public String  tolianxi() throws Exception{
		return "tolianxi";
	}
	public String  totiaokuan() throws Exception{
		return "totiaokuan";
	}
	public String  tozizhi() throws Exception{
		return "tozizhi";
	}
	
	public String  toService() throws Exception{
		
		
		
		
		return "toService";
	}
	//添加包机申请--预览
	public String yulan()throws Exception{
		
		
		
		String[] idnames = c_idname.split(",");
		String[] idtypes = c_idtype.split(",");
		String[] idnumbers = c_idnumber.split(",");
		
		
		charterorder.setCreatetime(new Timestamp(System.currentTimeMillis()));
		charterorder.setType(s_type);//
		charterorder.setUsertype(s_usertype);
		charterorder.setMaxnum(s_maxnum);
		charterorder.setNum("");//实际人数
		charterorder.setName(s_username);
		charterorder.setQq(s_qq);
		charterorder.setTel(s_tel);
		charterorder.setRemarks(s_remarks);
		charterorder.setStime(s_stime);
		charterorder.setEtime(s_etime);
		charterorder.setState(1l);//1新订单待审核  2审核通过待报价  3审核不通过  4已报价待回复  5报价过高  6报价满意 7
		charterorder.setMemberid(getLoginUser().getId());
		//charterorder=Server.getInstance().getAirService().createCharterorder(charterorder);
		
		for (int i = 0; i < idtypes.length; i++) {

			if (idtypes[i] != null && !idtypes[i].toString().equals(" ")
					&& idnumbers[i] != null&& !idnumbers[i].toString().equals(" ")
					&& idnames[i] != null&& !idnames[i].toString().equals(" ")) {
				
				Passenger passenger = new Passenger();
				passenger.setName(idnames[i].trim());
				passenger.setIdtype(Integer.parseInt(idtypes[i].trim()));
				passenger.setIdnumber(idnumbers[i].trim());
				//passenger.setOrderid(charterorder.getId());
				passenger.setLanguage(5);//默认查询的是1或者null  表示机票订单乘机人   5为包机订单乘机人
				//Server.getInstance().getAirService().createPassenger(passenger);
				//listpass.add(passenger);
				listlistpass.add(passenger);
			}
		}
		//单程
		segmentinfo.setEndairport(s_ecity);
		segmentinfo.setStartairport(s_scity);
		segmentinfo.setFlightnumber(s_flightcode);
		segmentinfo.setAircomapnycode(s_companyname);
		segmentinfo.setDeparttime(dateToTimestamp(s_startime));
		segmentinfo.setLanguage(5);//默认查询的是1或者null  表示机票订单乘机人   5为包机订单乘机人
		//segmentinfo.setOrderid(charterorder.getId());
		//Server.getInstance().getAirService().createSegmentinfo(segmentinfo);
		if(s_type==2){//返程
			
			segmentinfo2.setEndairport(s_scity);
			segmentinfo2.setStartairport(s_ecity);
			segmentinfo2.setFlightnumber(s_flightcode);
			segmentinfo2.setAircompanyname(s_companyname);
			segmentinfo2.setDeparttime(dateToTimestamp(s_endtime));
			segmentinfo2.setLanguage(5);//默认查询的是1或者null  表示机票订单乘机人   5为包机订单乘机人
			//segmentinfo.setOrderid(charterorder.getId());
			//Server.getInstance().getAirService().createSegmentinfo(segmentinfo);
		}
		/*String where=" where 1=1 and "+Passenger.COL_orderid+" ="+charterorder.getId()+" and "+Passenger.COL_language+" =5";
		List<Passenger>list=Server.getInstance().getAirService().findAllPassenger(where, " ORDER BY ID  " , -1, 0);
		
		charterorder.setNum(list.size()+"");
		charterorder.setMobile("C"+(charterorder.getId()+20000));
		Server.getInstance().getAirService().updateCharterorderIgnoreNull(charterorder);
	*/	
	//	forword="login!tocharterlist.jspx";
		return "toyulan";
	}
	
	//添加包机申请
	public String addCharter()throws Exception{
		Charterorder charterorder = new Charterorder();
		Segmentinfo segmentinfo = new Segmentinfo();
		
		
		
		System.out.println("servicetype==="+servicetype);
		System.out.println("c_idname==="+c_idname);
		System.out.println("c_idtype==="+c_idtype);
		System.out.println("c_idnumber==="+c_idnumber);
		String[] idnames = c_idname.split(",");
		String[] idtypes = c_idtype.split(",");
		String[] idnumbers = c_idnumber.split(",");
		
		
		charterorder.setCreatetime(new Timestamp(System.currentTimeMillis()));
		charterorder.setType(s_type);//
		charterorder.setUsertype(s_usertype);
		charterorder.setMaxnum(s_maxnum);
		charterorder.setNum("");//实际人数
		charterorder.setName(s_username);
		charterorder.setQq(s_qq);
		charterorder.setTel(s_tel);
		charterorder.setRemarks(s_remarks);
		charterorder.setStime(s_stime);
		charterorder.setEtime(s_etime);
		charterorder.setServicetype(servicetype);
		charterorder.setState(1l);//1新订单待审核  2审核通过待报价  3审核不通过  4已报价待回复  5报价过高  6报价满意 7
		charterorder.setMemberid(getLoginUser().getId());
		charterorder=Server.getInstance().getAirService().createCharterorder(charterorder);
		if(servicetype==1&&idtypes.length>0){
		for (int i = 0; i < idtypes.length; i++) {

			if (idtypes[i] != null && !idtypes[i].toString().equals(" ")
					&& idnumbers[i] != null&& !idnumbers[i].toString().equals(" ")
					&& idnames[i] != null&& !idnames[i].toString().equals(" ")) {
				
				Passenger passenger = new Passenger();
				passenger.setName(idnames[i].trim());
				passenger.setIdtype(Integer.parseInt(idtypes[i].trim()));
				passenger.setIdnumber(idnumbers[i].trim());
				passenger.setOrderid(charterorder.getId());
				passenger.setLanguage(5);//默认查询的是1或者null  表示机票订单乘机人   5为包机订单乘机人
				Server.getInstance().getAirService().createPassenger(passenger);
			}
		}
		}
		//单程
		segmentinfo.setEndairport(s_ecity);
		segmentinfo.setStartairport(s_scity);
		segmentinfo.setFlightnumber(s_flightcode);
		segmentinfo.setAircomapnycode(s_companyname);
		segmentinfo.setDeparttime(dateToTimestamp(s_startime));
		segmentinfo.setLanguage(5);//默认查询的是1或者null  表示机票订单乘机人   5为包机订单乘机人
		segmentinfo.setOrderid(charterorder.getId());
		Server.getInstance().getAirService().createSegmentinfo(segmentinfo);
		if(s_type==2){//返程
			
			segmentinfo.setEndairport(s_scity);
			segmentinfo.setStartairport(s_ecity);
			segmentinfo.setFlightnumber(s_flightcode);
			segmentinfo.setAircompanyname(s_companyname);
			segmentinfo.setDeparttime(dateToTimestamp(s_endtime));
			segmentinfo.setLanguage(5);//默认查询的是1或者null  表示机票订单乘机人   5为包机订单乘机人
			segmentinfo.setOrderid(charterorder.getId());
			Server.getInstance().getAirService().createSegmentinfo(segmentinfo);
		}
		String where=" where 1=1 and "+Passenger.COL_orderid+" ="+charterorder.getId()+" and "+Passenger.COL_language+" =5";
		List<Passenger>list=Server.getInstance().getAirService().findAllPassenger(where, " ORDER BY ID  " , -1, 0);
		
		charterorder.setNum(list.size()+"");
		//charterorder.setMobile("C"+(charterorder.getId()+20000));
		charterorder.setOrdercode("C"+(charterorder.getId()+20000));
		Server.getInstance().getAirService().updateCharterorderIgnoreNull(charterorder);
		
		forword="login!tocharterlist.jspx";
		return "forword";
	}
	
	public String toindex() throws Exception{
		System.out.println("来到了首页");
		/*String where = " where 1=1 and " + Informationinfo.COL_typeid
				+ " in ( SELECT " + Information.COL_id + " FROM "
				+ Information.TABLE + " where " + Information.COL_name
				+ " ='最新资讯')";
		listZX = Server.getInstance().getMemberService()
				.findAllInformationinfo(where, " ORDER BY ID DESC ", 6, 0);
		String whereBJ = " where 1=1 and " + Informationinfo.COL_typeid
				+ " in ( SELECT " + Information.COL_id + " FROM "
				+ Information.TABLE + " where " + Information.COL_name
				+ " ='包机服务')";
		listBJ = Server.getInstance().getMemberService()
				.findAllInformationinfo(whereBJ, " ORDER BY ID DESC ", 2, 0);
		String whereJPYD = " where 1=1 and " + Informationinfo.COL_typeid
				+ " in ( SELECT " + Information.COL_id + " FROM "
				+ Information.TABLE + " where " + Information.COL_name
				+ " ='国内机票预订')";
		listJPYD = Server.getInstance().getMemberService()
				.findAllInformationinfo(whereJPYD, " ORDER BY ID DESC ", 10, 0);

		String wherecjcs = " where 1=1 and " + Helpcenterinfo.COL_typeid
				+ " in ( SELECT " + Helpcenter.COL_id + " FROM "
				+ Helpcenter.TABLE + " where " + Helpcenter.COL_name
				+ " ='乘机常识')";
		listCJCS = Server.getInstance().getMemberService()
				.findAllHelpcenterinfo(wherecjcs, " ORDER BY ID DESC ", 4, 0);

		String whereydxz = " where 1=1 and " + Helpcenterinfo.COL_typeid
				+ " in ( SELECT " + Helpcenter.COL_id + " FROM "
				+ Helpcenter.TABLE + " where " + Helpcenter.COL_name
				+ " ='预订须知')";
		listYDXZ = Server.getInstance().getMemberService()
				.findAllHelpcenterinfo(whereydxz, " ORDER BY ID DESC ", 4, 0);

		String wherecjwt = " where 1=1 and " + Helpcenterinfo.COL_typeid
				+ " in ( SELECT " + Helpcenter.COL_id + " FROM "
				+ Helpcenter.TABLE + " where " + Helpcenter.COL_name
				+ " ='常见问题')";
		listCJWT = Server.getInstance().getMemberService()
				.findAllHelpcenterinfo(wherecjwt, " ORDER BY ID DESC ", 7, 0);

		String whereqz = " where 1=1 and " + Helpcenterinfo.COL_typeid
				+ " in ( SELECT " + Helpcenter.COL_id + " FROM "
				+ Helpcenter.TABLE + " where " + Helpcenter.COL_name
				+ " ='益差旅博客')";
		listQZ = Server.getInstance().getMemberService().findAllHelpcenterinfo(
				whereqz, " ORDER BY ID DESC ", 2, 0);
		String whereqz = " where 1=1 and " + Helpcenterinfo.COL_typeid
		+ " in ( SELECT " + Helpcenter.COL_id + " FROM "
		+ Helpcenter.TABLE + " where " + Helpcenter.COL_name
		+ " ='益差旅博客')";
		listQZ = Server.getInstance().getMemberService().findAllHelpcenterinfo(
		whereqz, " ORDER BY ID DESC ", 2, 0);
		
		
		String whereRMTJ = " where 1=1 and " + Informationinfo.COL_typeid
		+ " in ( SELECT " + Information.COL_id + " FROM "
		+ Information.TABLE + " where " + Information.COL_name
		+ " ='热门推荐')";
		listRMTJ = Server.getInstance().getMemberService()
		.findAllInformationinfo(whereRMTJ, " ORDER BY ID DESC ", 3, 0);
		
		
		String whereCXBZ = " where 1=1 and " + Helpcenterinfo.COL_typeid
		+ " in ( SELECT " + Helpcenter.COL_id + " FROM "
		+ Helpcenter.TABLE + " where " + Helpcenter.COL_name
		+ " ='机票常识')";
		listCXBZ = Server.getInstance().getMemberService().findAllHelpcenterinfo(
				whereCXBZ, " ORDER BY ID DESC ", 2, 0);

		String whereInfo =" where 1=1 and "+Helpcenterinfo.COL_typeid+" = ( SELECT "+Helpcenter.COL_id+" FROM "+Helpcenter.TABLE+" where "+Helpcenter.COL_name+" ='相关信息')";
		Listhelpcenterinfo =Server.getInstance().getMemberService().findAllHelpcenterinfo(whereInfo, " ORDER BY ID DESC ", 8, 0);
	*/
		
		
	
		String whereInfo =" where 1=1 and "+Helpcenterinfo.COL_typeid+" = ( SELECT "+Helpcenter.COL_id+" FROM "+Helpcenter.TABLE+" where "+Helpcenter.COL_name+" ='"+pname+"热点')";
		//  String whereInfo =" where 1=1 and "+Helpcenterinfo.COL_typeid+" = ( SELECT "+Helpcenter.COL_id+" FROM "+Helpcenter.TABLE+" where "+Helpcenter.COL_name+" ='空铁热点')";
		listCJWT =Server.getInstance().getMemberService().findAllHelpcenterinfo(whereInfo, " ORDER BY ID DESC ", 8, 0);
		
		System.out.println("listCJWT:"+listCJWT.size());
		//return "toindex"; //跳转到国祥首页
		//return "tostanderindex"; //跳转到标准首页
		//return "tolexinindex"; //跳转到乐辛网首页
		return "togdindex"; //跳转到国都首页

	}
	
	
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String index() throws Exception
	{
		//从缓存中得到航空公司信息
		listAirCompany=Server.getInstance().getTicketSearchService().getAircompanyCache();
		return "tolexinindex"; //跳转到乐辛网首页
	}

	public String toplanserver() throws Exception {

		System.out.println("来到了包机服务");
		if(getLoginUser()==null){
			
			//return "tologin";
		}

		//listAircompany=Server.getInstance().getTicketSearchService().getAircompanyCache();
		String where=" where 1=1 and "+Aircompany.COL_isair+" =1";
		listAircompany=Server.getInstance().getAirService().findAllAircompany(where, " ORDER BY ID DESC", -1, 0);
		return "toplanserver";

	}

	public String tohelp() throws Exception {
		isindex=1;
		String whereHelp=" where 1=1 and "+Helpcenter.COL_isweb+" =1";
		ListHelpcenterIndex=Server.getInstance().getMemberService().findAllHelpcenter(whereHelp, " ORDER BY ID DESC ", 3, 0);
		
		System.out.println("ListHelpcenterIndex=="+ListHelpcenterIndex);
		
		System.out.println("来到了帮助中心首页");
		String where = " where 1=1 and " + Helpcenter.COL_state + " =1 and "
				+ Helpcenter.COL_parentid + " =-1";
		ListHelpcenter = Server.getInstance().getMemberService()
				.findAllHelpcenter(where, " ORDER BY ID ", -1, 0);
		if (ListHelpcenter.size() > 0) {
			helpcenter = ListHelpcenter.get(0);
			onename = "帮助中心";
			twoname = Server.getInstance().getMemberService().findHelpcenter(
					helpcenter.getId()).getName();

			String whereh = " where 1=1 and " + Helpcenter.COL_parentid + " ="
					+ helpcenter.getId();
			List<Helpcenter> list = Server.getInstance().getMemberService()
					.findAllHelpcenter(whereh, " ORDER BY ID ", -1, 0);
			if (list.size() > 0) {
				threename = list.get(0).getName();
				HelpcenterID = list.get(0).getId();
				String whereinfo = " where 1=1 and "
						+ Helpcenterinfo.COL_typeid + " =" + HelpcenterID;
				ListHelpcenterinfo = Server.getInstance().getMemberService()
						.findAllHelpcenterinfo(whereinfo, " ORDER BY ID DESC ",
								-1, 0);
			}
		}
		//System.out.println("ListHelpcenterinfo.size:"+ListHelpcenterinfo.size());
		helpcenterinfo=Server.getInstance().getMemberService().findHelpcenterinfo(HelpcenterinfoID);
		//System.out.println("helpcenterinfo:"+helpcenterinfo.toString());
		return "tohelpinfoByInfoId";
		//return "tohelp";
		
	}
	//点击咨询菜单跳转用
	public	String toInformationType(){
		type=1;
		String whereHelp=" where 1=1 and "+Information.COL_isweb+" =1";
		ListHelpcenterIndex=Server.getInstance().getMemberService().findAllInformation(whereHelp, " ORDER BY ID DESC ", 3, 0);
		
		
		String where = " where 1=1 and " + Information.COL_state + " =1 and "
		+ Information.COL_parentid + " =-1";
		ListInformation = Server.getInstance().getMemberService()
				.findAllInformation(where, " ORDER BY ID ", -1, 0);
		if (ListInformation.size() > 0) {
			
			onename = "资讯中心";
			twoname = Server.getInstance().getMemberService().findInformation(
					HelpcenterID).getName();
		
		
		}
		String wheretype = " where 1=1 and " + Information.COL_state + " =1 and "
		+ Information.COL_parentid + " ="+HelpcenterID;
		ListInformationtype=Server.getInstance().getMemberService()
		.findAllInformation(wheretype, " ORDER BY ID ", -1, 0);
		System.out.println("ListInformationtype=="+ListInformationtype.size());
		Informationid=HelpcenterID;
		
		
		return "toinformation";
	}
	public String toinformation() {
		
		isindex=1;
		String whereHelp=" where 1=1 and "+Information.COL_isweb+" =1";
		ListHelpcenterIndex=Server.getInstance().getMemberService().findAllInformation(whereHelp, " ORDER BY ID DESC ", 3, 0);
		
		
		
		System.out.println("来到了资讯中心首页");
		String where = " where 1=1 and " + Information.COL_state + " =1 and "
				+ Information.COL_parentid + " =-1";
		ListInformation = Server.getInstance().getMemberService()
				.findAllInformation(where, " ORDER BY ID ", -1, 0);
		if (ListInformation.size() > 0) {
			information = ListInformation.get(0);
			onename = "资讯中心";
			twoname = Server.getInstance().getMemberService().findInformation(
					information.getId()).getName();

			String whereh = " where 1=1 and " + Information.COL_parentid + " ="
					+ information.getId();
			List<Information> list = Server.getInstance().getMemberService()
					.findAllInformation(whereh, " ORDER BY ID ", -1, 0);
			if (list.size() > 0) {
				threename = list.get(0).getName();
			}
			HelpcenterID = list.get(0).getId();

			String whereinfo = " where 1=1 and " + Informationinfo.COL_typeid
					+ " =" + HelpcenterID;
			ListInformationinfo = Server.getInstance().getMemberService()
					.findAllInformationinfo(whereinfo, " ORDER BY ID DESC ",
							-1, 0);
		}
		return "toinformation";
	}
	//帮助中心首页,点击信息进入详细信息页面
	public String tohelpinfoByInfoId() throws Exception {
		helpcenterinfo=Server.getInstance().getMemberService().findHelpcenterinfo(HelpcenterinfoID);
		
		String wherehelp = " where 1=1 and " + Helpcenter.COL_state
		+ " =1 and " + Helpcenter.COL_parentid + " =-1";
ListHelpcenter = Server.getInstance().getMemberService()
		.findAllHelpcenter(wherehelp, " ORDER BY ID ", -1, 0);
HelpcenterID=helpcenterinfo.getTypeid();
helpcenter = Server.getInstance().getMemberService().findHelpcenter(
		helpcenterinfo.getTypeid());
Helpid = helpcenter.getParentid();
		
onename = "帮助中心";
twoname=Server.getInstance().getMemberService().findHelpcenter(helpcenter.getParentid()).getName();
threename=helpcenter.getName();;	
		return "tohelpinfoByInfoId";
	}
	//咨询中心首页,点击信息进入详细信息页面
	public String toinformationinfoByInfoId() throws Exception {

		informationinfo=Server.getInstance().getMemberService().findInformationinfo(HelpcenterinfoID);	
		
		String where = " where 1=1 and " + Information.COL_state + " =1 and "
		+ Information.COL_parentid + " =-1";
		ListInformation = Server.getInstance().getMemberService()
				.findAllInformation(where, " ORDER BY ID ", -1, 0);


//Informationid=informationinfo.getTypeid();
information = Server.getInstance().getMemberService().findInformation(
		informationinfo.getTypeid());
Informationid = information.getParentid();
		
onename = "帮助中心";
twoname=Server.getInstance().getMemberService().findInformation(information.getParentid()).getName();
threename=information.getName();;	
		return "toinformationinfoByInfoId";
	}
	
	
	public String toHelpInfo() throws Exception {
		System.out.println("来到了帮助中心详细信息首页");
		String wherehelp = " where 1=1 and " + Helpcenter.COL_state
				+ " =1 and " + Helpcenter.COL_parentid + " =-1";
		ListHelpcenter = Server.getInstance().getMemberService()
				.findAllHelpcenter(wherehelp, " ORDER BY ID ", -1, 0);

		helpcenter = Server.getInstance().getMemberService().findHelpcenter(
				HelpcenterID);
		String where = " where 1=1 and " + Helpcenterinfo.COL_typeid + " ="
				+ HelpcenterID;
		ListHelpcenterinfo = Server.getInstance().getMemberService()
				.findAllHelpcenterinfo(where, " ORDER BY ID DESC ", -1, 0);
		if (s_name != null && s_name.length() > 0) {

			ListHelpcenterinfo = Server.getInstance().getMemberService()
					.findAllHelpcenterinfo(
							" WHERE 1=1 AND " + Helpcenterinfo.COL_name
									+ " like '%" + s_name.trim() + "%' or "
									+ Helpcenterinfo.COL_info + " like '%"
									+ s_name.trim() + "%'",
							" ORDER BY ID DESC ", -1, 0);
		}
		Helpid = helpcenter.getParentid();
		for(int a=0;a<ListHelpcenterinfo.size();a++){
			
			if(HelpcenterinfoID==ListHelpcenterinfo.get(a).getId()){
				
				System.out.println("--"+a+"---");
				number=a+1;
			}
			
		}
		
		/*
		 * HttpServletRequest request = ServletActionContext.getRequest();
		 * HttpServletResponse response =ServletActionContext.getResponse();
		 * request.setAttribute("Helpid", Helpid);
		 */
		onename = "帮助中心";
		twoname = Server.getInstance().getMemberService().findHelpcenter(
				helpcenter.getParentid()).getName();
		threename = helpcenter.getName();
		return "tohelp";
	}

	public String toInformationinfo() throws Exception {

		System.out.println("来到了资讯中心详细信息首页");

		String wherehelp = " where 1=1 and " + Information.COL_state
				+ " =1 and " + Information.COL_parentid + " =-1";
		ListInformation = Server.getInstance().getMemberService()
				.findAllInformation(wherehelp, " ORDER BY ID ", -1, 0);

		information = Server.getInstance().getMemberService().findInformation(
				HelpcenterID);
		String where = " where 1=1 and " + Informationinfo.COL_typeid + " ="
				+ HelpcenterID;
		ListInformationinfo = Server.getInstance().getMemberService()
				.findAllInformationinfo(where, " ORDER BY ID DESC ", -1, 0);

		if (s_name != null && s_name.length() > 0) {

			ListInformationinfo = Server.getInstance().getMemberService()
					.findAllInformationinfo(
							" WHERE 1=1 AND " + Informationinfo.COL_name
									+ " like '%" + s_name.trim() + "%' or "
									+ Informationinfo.COL_info + " like '%"
									+ s_name.trim() + "%'",
							" ORDER BY ID DESC ", -1, 0);
		}
		Informationid = information.getParentid();
		for(int a=0;a<ListInformationinfo.size();a++){
			
			if(HelpcenterinfoID==ListInformationinfo.get(a).getId()){
				number=a+1;
			}
			
		}
		System.out.println(number);
		/*
		 * HttpServletRequest request = ServletActionContext.getRequest();
		 * HttpServletResponse response =ServletActionContext.getResponse();
		 * request.setAttribute("Helpid", Helpid);
		 */
		onename = "资讯中心";
		twoname = Server.getInstance().getMemberService().findInformation(
				information.getParentid()).getName();
		threename = information.getName();
		return "toinformation";
	}

	public String toleft() throws Exception {
		System.out.println("来到了toleft==Helpid=" + Helpid);
		String where = " where 1=1 and " + Helpcenter.COL_state + " =1 and "
				+ Helpcenter.COL_parentid + " =-1";
		ListHelpcenter = Server.getInstance().getMemberService()
				.findAllHelpcenter(where, " ORDER BY ID ", -1, 0);
		System.out.println("ListHelpcenter==" + ListHelpcenter.size());
		return "forward";

	}

	public List<Helpcenter> GetHelpLastById(long id) throws Exception {
		// System.out.println("来到了GetHelpLastById=="+id);
		String where = " where 1=1 and " + Helpcenter.COL_state + " =1 AND "
				+ Helpcenter.COL_parentid + " =" + id;
		ListHelpcenter = Server.getInstance().getMemberService()
				.findAllHelpcenter(where, " ORDER BY ID ", -1, 0);
		// System.out.println("ListHelpcenter=="+ListHelpcenter.size());
		
		
		return ListHelpcenter;
	}
	public List<Helpcenterinfo> GetHelpInfoById(long id,int len) throws Exception {
		// System.out.println("来到了GetHelpLastById=="+id);
		if(len==0){
			
			len=4;
		}
		String where = " where 1=1 and " + Helpcenterinfo.COL_state + " =1 AND "
				+ Helpcenterinfo.COL_typeid + " =" + id;
		List<Helpcenterinfo> listinfo = Server.getInstance().getMemberService()
				.findAllHelpcenterinfo(where, " ORDER BY ID ", len, 0);
		
		return listinfo;
	}

	public List<Information> getInformationLastById(long id) throws Exception {
		String where = " where 1=1 and " + Information.COL_state + " =1 and "
				+ Information.COL_parentid + " =" + id;
		ListInformation = Server.getInstance().getMemberService()
				.findAllInformation(where, "ORDER BY ID", -1, 0);
		return ListInformation;
	}
	public List<Informationinfo> GetInformInfoById(long id,int len) throws Exception {
		if(len==0){
					
					len=4;
				}
		String where = " where 1=1 and " + Informationinfo.COL_state + " =1 and "
				+ Informationinfo.COL_typeid + " =" + id;
		List<Informationinfo> list = Server.getInstance().getMemberService()
				.findAllInformationinfo(where, "ORDER BY ID", len, 0);
		return list;
	}
	
	public String AddPlanservice() throws Exception {
		// Planeservice planeservice= new Planeservice();
		planeservice.setCreatetime(new Timestamp(System.currentTimeMillis()));
		// planeservice.setCreatetime(new
		// Timestamp(System.currentTimeMillis()));
		/*
		 * if(getLoginUser()!=null){
		 * planeservice.setMemberid(getLoginUser().getId()); }
		 */
		planeservice.setReturntime(s_returntime);
		planeservice.setTraveltime(s_traveltime);
		planeservice.setState(1l);
		planeservice.setMemberid(61l);
		Server.getInstance().getMemberService()
				.createPlaneservice(planeservice);

		return this.toplanserver();
	}

	
	public String tomap() throws Exception {
		
		
		return "tomap";
	}
	public String tofuwu() throws Exception {
		
		
		return "tofuwu";
	}
public String todaohang() throws Exception {
		
		
		return "todaohang";
	}
public String toyinsi() throws Exception {
	
	
	return "toyinsi";
}	
public String tozhifu() throws Exception {
	
	
	return "tozhifu";
}
public String toyouqing() throws Exception {
	
	
	return "toyouqing";
}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return planeservice;
	}

	public List<Helpcenter> getListHelpcenter() {
		return ListHelpcenter;
	}

	public void setListHelpcenter(List<Helpcenter> listHelpcenter) {
		ListHelpcenter = listHelpcenter;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public Helpcenterinfo getHelpcenterinfo() {
		return helpcenterinfo;
	}

	public void setHelpcenterinfo(Helpcenterinfo helpcenterinfo) {
		this.helpcenterinfo = helpcenterinfo;
	}

	public long getHelpcenterID() {
		return HelpcenterID;
	}

	public void setHelpcenterID(long helpcenterID) {
		HelpcenterID = helpcenterID;
	}

	public List<Helpcenterinfo> getListHelpcenterinfo() {
		return ListHelpcenterinfo;
	}

	public void setListHelpcenterinfo(List<Helpcenterinfo> listHelpcenterinfo) {
		ListHelpcenterinfo = listHelpcenterinfo;
	}

	public Helpcenter getHelpcenter() {
		return helpcenter;
	}

	public void setHelpcenter(Helpcenter helpcenter) {
		this.helpcenter = helpcenter;
	}

	public long getHelpid() {
		return Helpid;
	}

	public void setHelpid(long helpid) {
		Helpid = helpid;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getOnename() {
		return onename;
	}

	public void setOnename(String onename) {
		this.onename = onename;
	}

	public String getTwoname() {
		return twoname;
	}

	public void setTwoname(String twoname) {
		this.twoname = twoname;
	}

	public String getThreename() {
		return threename;
	}

	public void setThreename(String threename) {
		this.threename = threename;
	}

	public List<Information> getListInformation() {
		return ListInformation;
	}

	public void setListInformation(List<Information> listInformation) {
		ListInformation = listInformation;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public List<Informationinfo> getListInformationinfo() {
		return ListInformationinfo;
	}

	public void setListInformationinfo(List<Informationinfo> listInformationinfo) {
		ListInformationinfo = listInformationinfo;
	}

	public long getInformationid() {
		return Informationid;
	}

	public void setInformationid(long informationid) {
		Informationid = informationid;
	}

	public Planeservice getPlaneservice() {
		return planeservice;
	}

	public void setPlaneservice(Planeservice planeservice) {
		this.planeservice = planeservice;
	}

	public String getS_traveltime() {
		return s_traveltime;
	}

	public void setS_traveltime(String s_traveltime) {
		this.s_traveltime = s_traveltime;
	}

	public String getS_returntime() {
		return s_returntime;
	}

	public void setS_returntime(String s_returntime) {
		this.s_returntime = s_returntime;
	}

	public List<Informationinfo> getListZX() {
		return listZX;
	}

	public void setListZX(List<Informationinfo> listZX) {
		this.listZX = listZX;
	}

	public List<Informationinfo> getListBJ() {
		return listBJ;
	}

	public void setListBJ(List<Informationinfo> listBJ) {
		this.listBJ = listBJ;
	}

	public List<Informationinfo> getListJPYD() {
		return listJPYD;
	}

	public void setListJPYD(List<Informationinfo> listJPYD) {
		this.listJPYD = listJPYD;
	}

	public List<Helpcenterinfo> getListCJCS() {
		return listCJCS;
	}

	public void setListCJCS(List<Helpcenterinfo> listCJCS) {
		this.listCJCS = listCJCS;
	}

	public List<Helpcenterinfo> getListYDXZ() {
		return listYDXZ;
	}

	public void setListYDXZ(List<Helpcenterinfo> listYDXZ) {
		this.listYDXZ = listYDXZ;
	}

	public List<Helpcenterinfo> getListCJWT() {
		return listCJWT;
	}

	public void setListCJWT(List<Helpcenterinfo> listCJWT) {
		this.listCJWT = listCJWT;
	}

	public List<Helpcenterinfo> getListQZ() {
		return listQZ;
	}

	public void setListQZ(List<Helpcenterinfo> listQZ) {
		this.listQZ = listQZ;
	}
	public List<Aircompany> getListAircompany() {
		return listAircompany;
	}
	public void setListAircompany(List<Aircompany> listAircompany) {
		this.listAircompany = listAircompany;
	}

	public long getHelpcenterinfoID() {
		return HelpcenterinfoID;
	}

	public void setHelpcenterinfoID(long helpcenterinfoID) {
		HelpcenterinfoID = helpcenterinfoID;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public long getS_type() {
		return s_type;
	}

	public void setS_type(long s_type) {
		this.s_type = s_type;
	}

	public long getS_usertype() {
		return s_usertype;
	}

	public void setS_usertype(long s_usertype) {
		this.s_usertype = s_usertype;
	}

	public String getS_startime() {
		return s_startime;
	}

	public void setS_startime(String s_startime) {
		this.s_startime = s_startime;
	}

	public String getS_endtime() {
		return s_endtime;
	}

	public void setS_endtime(String s_endtime) {
		this.s_endtime = s_endtime;
	}

	public String getS_companyname() {
		return s_companyname;
	}

	public void setS_companyname(String s_companyname) {
		this.s_companyname = s_companyname;
	}

	public String getS_flightcode() {
		return s_flightcode;
	}

	public void setS_flightcode(String s_flightcode) {
		this.s_flightcode = s_flightcode;
	}

	public String getS_stime() {
		return s_stime;
	}

	public void setS_stime(String s_stime) {
		this.s_stime = s_stime;
	}

	public String getS_etime() {
		return s_etime;
	}

	public void setS_etime(String s_etime) {
		this.s_etime = s_etime;
	}

	public String getS_maxnum() {
		return s_maxnum;
	}

	public void setS_maxnum(String s_maxnum) {
		this.s_maxnum = s_maxnum;
	}

	public String getS_passtype() {
		return s_passtype;
	}

	public void setS_passtype(String s_passtype) {
		this.s_passtype = s_passtype;
	}

	public String getS_scity() {
		return s_scity;
	}

	public void setS_scity(String s_scity) {
		this.s_scity = s_scity;
	}

	public String getS_ecity() {
		return s_ecity;
	}

	public void setS_ecity(String s_ecity) {
		this.s_ecity = s_ecity;
	}

	public String getC_idname() {
		return c_idname;
	}

	public void setC_idname(String c_idname) {
		this.c_idname = c_idname;
	}

	public String getC_idtype() {
		return c_idtype;
	}

	public void setC_idtype(String c_idtype) {
		this.c_idtype = c_idtype;
	}

	public String getC_idnumber() {
		return c_idnumber;
	}

	public void setC_idnumber(String c_idnumber) {
		this.c_idnumber = c_idnumber;
	}

	public String getS_username() {
		return s_username;
	}

	public void setS_username(String s_username) {
		this.s_username = s_username;
	}

	public String getS_tel() {
		return s_tel;
	}

	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}

	public String getS_qq() {
		return s_qq;
	}

	public void setS_qq(String s_qq) {
		this.s_qq = s_qq;
	}

	public String getS_remarks() {
		return s_remarks;
	}

	public void setS_remarks(String s_remarks) {
		this.s_remarks = s_remarks;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public List<Passenger> getListpass() {
		return listpass;
	}

	public void setListpass(List<Passenger> listpass) {
		this.listpass = listpass;
	}

	public Charterorder getCharterorder() {
		return charterorder;
	}

	public void setCharterorder(Charterorder charterorder) {
		this.charterorder = charterorder;
	}

	public Segmentinfo getSegmentinfo() {
		return segmentinfo;
	}

	public void setSegmentinfo(Segmentinfo segmentinfo) {
		this.segmentinfo = segmentinfo;
	}

	public Segmentinfo getSegmentinfo2() {
		return segmentinfo2;
	}

	public void setSegmentinfo2(Segmentinfo segmentinfo2) {
		this.segmentinfo2 = segmentinfo2;
	}

	public List getListlistpass() {
		return listlistpass;
	}

	public void setListlistpass(List listlistpass) {
		this.listlistpass = listlistpass;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<Information> getListInformationtype() {
		return ListInformationtype;
	}
	public void setListInformationtype(List<Information> listInformationtype) {
		ListInformationtype = listInformationtype;
	}
	public List<Helpcenterinfo> getListRMTJ() {
		return listRMTJ;
	}
	public void setListRMTJ(List<Helpcenterinfo> listRMTJ) {
		this.listRMTJ = listRMTJ;
	}
	public List<Helpcenterinfo> getListCXBZ() {
		return listCXBZ;
	}
	public void setListCXBZ(List<Helpcenterinfo> listCXBZ) {
		this.listCXBZ = listCXBZ;
	}
	public long getIsindex() {
		return isindex;
	}
	public void setIsindex(long isindex) {
		this.isindex = isindex;
	}
	public List<Helpcenter> getListHelpcenterIndex() {
		return ListHelpcenterIndex;
	}
	public void setListHelpcenterIndex(List<Helpcenter> listHelpcenterIndex) {
		ListHelpcenterIndex = listHelpcenterIndex;
	}
	public List<Information> getListInformationIndex() {
		return ListInformationIndex;
	}
	public void setListInformationIndex(List<Information> listInformationIndex) {
		ListInformationIndex = listInformationIndex;
	}
	public Informationinfo getInformationinfo() {
		return informationinfo;
	}
	public void setInformationinfo(Informationinfo informationinfo) {
		this.informationinfo = informationinfo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}


	public long getServicetype() {
		return servicetype;
	}


	public void setServicetype(long servicetype) {
		this.servicetype = servicetype;
	}



	public List<Helpcenterinfo> getListhelpcenterinfo() {
		return Listhelpcenterinfo;
	}


	public void setListhelpcenterinfo(List<Helpcenterinfo> listhelpcenterinfo) {
		Listhelpcenterinfo = listhelpcenterinfo;
	}



	public List<Aircompany> getListAirCompany() {
		return listAirCompany;
	}


	public void setListAirCompany(List<Aircompany> listAirCompany) {
		this.listAirCompany = listAirCompany;
	}
	public String getStrCityID() {
		return strCityID;
	}

	public void setStrCityID(String strCityID) {
		this.strCityID = strCityID;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public List<Qzchanpin> getListQzchanpin() {
		return ListQzchanpin;
	}

	public void setListQzchanpin(List<Qzchanpin> listQzchanpin) {
		ListQzchanpin = listQzchanpin;
	}

	public List<Qzchanpininfo> getListQzchanpininfo() {
		return ListQzchanpininfo;
	}

	public void setListQzchanpininfo(List<Qzchanpininfo> listQzchanpininfo) {
		ListQzchanpininfo = listQzchanpininfo;
	}

	public long getC_qzinfoid() {
		return c_qzinfoid;
	}

	public void setC_qzinfoid(long c_qzinfoid) {
		this.c_qzinfoid = c_qzinfoid;
	}

	public Qzguojia getQzguojia() {
		return qzguojia;
	}

	public void setQzguojia(Qzguojia qzguojia) {
		this.qzguojia = qzguojia;
	}

	public Qzchanpininfo getQzchanpininfo() {
		return qzchanpininfo;
	}

	public void setQzchanpininfo(Qzchanpininfo qzchanpininfo) {
		this.qzchanpininfo = qzchanpininfo;
	}

	public List<Qzguojia> getListQzguojiayz() {
		return listQzguojiayz;
	}

	public void setListQzguojiayz(List<Qzguojia> listQzguojiayz) {
		this.listQzguojiayz = listQzguojiayz;
	}

	public List<Qzguojia> getListQzguojiaoz() {
		return listQzguojiaoz;
	}

	public void setListQzguojiaoz(List<Qzguojia> listQzguojiaoz) {
		this.listQzguojiaoz = listQzguojiaoz;
	}

	public List<Qzguojia> getListQzguojiamz() {
		return listQzguojiamz;
	}

	public void setListQzguojiamz(List<Qzguojia> listQzguojiamz) {
		this.listQzguojiamz = listQzguojiamz;
	}

	public List<Qzguojia> getListQzguojiaaz() {
		return listQzguojiaaz;
	}

	public void setListQzguojiaaz(List<Qzguojia> listQzguojiaaz) {
		this.listQzguojiaaz = listQzguojiaaz;
	}

	public List<Qzguojia> getListQzguojiafz() {
		return listQzguojiafz;
	}

	public void setListQzguojiafz(List<Qzguojia> listQzguojiafz) {
		this.listQzguojiafz = listQzguojiafz;
	}

}
