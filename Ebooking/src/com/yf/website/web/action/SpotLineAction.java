/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.website.web.action;

import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.region.Region;
import com.yf.system.base.spotcity.Spotcity;
import com.yf.system.base.spotline.Spotline;
import com.yf.system.base.spotlineimg.Spotlineimg;
import com.yf.system.base.spotlineinfo.Spotlineinfo;
import com.yf.system.base.spotlineorder.Spotlineorder;
import com.yf.system.base.spotlineprice.Spotlineprice;
import com.yf.system.base.spotlineuser.Spotlineuser;
import com.yf.system.base.spotmes.Spotmes;
import com.yf.system.base.spotorder.Spotorder;
import com.yf.system.base.spotticket.Spotticket;
import com.yf.system.base.util.PageInfo;
import com.yf.website.web.date.CnToSpell;
import com.yf.website.web.server.Server;



/**
 *旅游门票
 * @author Administrator
 *
 */
public class SpotLineAction extends B2b2cbackAction {
	
	// 开始日期
	private String startDate;
	// 结束日期
	private String endDate;
	//城市ID--出发
	private String CityID;
	
	//城市ID--到达
	private String EndCityID;
	
	//搜索关键字
	private String SeachName;
	
	//线路ID
	private String SpotLineID;
	
	//门票ID
	private String SpotTicketID;
	
	//景区list
	private List<Spotmes> ListSpotmes;
	
	//景区对象
	private Spotmes spotmes=new Spotmes();
	
	//门票对象
	private Spotticket spotticket=new Spotticket();
	
	//门票订单对象
	private Spotorder spotorder=new Spotorder();
	
	//线路订单对象
	private Spotlineorder spotlineorder=new Spotlineorder();
	
	//线路游客
	private List<Spotlineuser>ListSpotlineuser;
	
	
	//门票list
	private List<Spotticket>ListSpotticket;
	
	private List<Object>listimage=new ArrayList<Object>();
	
	
	//线路list
	private List<Spotline>ListSpotline;
	//线路图片list
	private List<Spotlineimg>ListSpotlineimg;
	//线路详细信息list
	private List<Spotlineinfo>ListSpotlineinfo;
	//线路价格信息list
	private List<Spotlineprice>ListSpotlineprice;
	
	//线路对象
	private Spotline spotline=new Spotline();
	
	
	//跳转用
	private String forword;
	//门票订单ID
	private long OrderID;
	
	
	
	//下单用参数联系人信息
	
	//总价
	private String price;
	
	//邮箱
	private String LinkMail;
	//电话
	private String LinkMobile;
	//联系人姓名
	private String LinkName;
	//备注
	private String LinkDesc;
	
	private String SpotLineNum;
	//下单用游客信息
	
	private String pName;//游客姓名
	private String pType;//游客类型
	private String pSex;//游客性别
	private String pIdtype;//证件类型
	private String pIdNo;//证件号码
	private String pMobile;//电话
	
	
	

	public SpotLineAction() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		startDate = sdf.format(calendar.getTime());
		calendar.add(Calendar.DATE, 1);
		endDate = sdf.format(calendar.getTime());
		
	}
	
	/**
	 * AJAX读取酒店城市
	 * 
	 * @throws
	 */
	public void GetSpotCity() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		String strwhere = "WHERE 1=1 and " + Spotcity.COL_parentid+ " in ( select "+Spotcity.COL_id+" from "+Spotcity.TABLE+" where "+Spotcity.COL_parentid+" =1)";
	
		List<Spotcity> listSpotcity = Server.getInstance().getTripService()
				.findAllSpotcity(strwhere, "ORDER BY ID ", -1, 0);
		for (Spotcity airPort : listSpotcity) {
			sb.append(airPort.getName() + "#" + CnToSpell.getFullSpell(airPort.getName()) + "%"
					+ CnToSpell.getFullSpell(airPort.getName()) + "&" + airPort.getId() + ",");
		}
		// return strRetData;
		System.out.println("SB=" + sb);
		out.print(sb);
		out.flush();
		out.close();
		
	}

	/**
	 * AJAX读取景区推荐信息 2012-02-14 陈星
	 * 
	 * @throws
	 */
	public void GetSpotByCity() throws Exception {
		//System.out.println("酒店ID:"+strHotelCity);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		String where=" where 1=1 and "+Spotmes.COL_cityid+" ='"+CityID+"'";
		List<Spotmes>ListSpotmes=Server.getInstance().getTripService().findAllSpotmes(where, " ORDER BY ID ", 8, 0);
		
		StringBuilder sb = new StringBuilder();

		sb.append("<div>");
		sb.append("<div>");
		sb.append("<table width='100%' border='1' cellspacing='0' cellpadding='0' class='box' >");
		sb.append("<tr>");
		sb.append("<th class='hadow' width='45%' scope='col'>&nbsp;</th>");
		sb.append("<th class='hadow' width='10%' scope='col'>门市价</th>");
		sb.append("<th class='hadow' width='10%' scope='col'>现付价</th>");
		sb.append("<th class='hadow' width='8%' scope='col'>优惠</th>");
		sb.append("<th class='hadow' width='8%' scope='col'>使用方式</th>");
		sb.append("<th class='hadow' scope='col' width='10%'>&nbsp;</th>");
		sb.append("</tr>");
		if(ListSpotmes!=null&&ListSpotmes.size()>0){
			for(int s=0;s<ListSpotmes.size();s++){
				
			List<Spotticket>listticket=Server.getInstance().getTripService().findAllSpotticket(" WHERE 1=1 AND "+Spotticket.COL_sid+" ='"+ListSpotmes.get(s).getId()+"'", " ORDER BY ID ", 1, 0);
			sb.append("<tr>");
			sb.append("<td class='floatall'>");
			sb.append("<img src='http://www.bzezt.com/uploads/"+ListSpotmes.get(s).getMinipics()+"' />");
			sb.append("<a href='spotticket!toSpotTicketInfo.jspx?SpotMesID="+ListSpotmes.get(s).getId()+"&startDate="+startDate+"'>");
			sb.append("<b>"+listticket.get(0).getName()+"</b>");
			sb.append("</a>");
			sb.append("</td>");
			sb.append("<td class='font-f60-del' align='center'>&yen;"+listticket.get(0).getMarketprice()+"</td>");
			sb.append("<td class='font-f60-16' align='center'>&yen;"+listticket.get(0).getShopprice()+"</td>");
			sb.append("<td  align='center'>"+GetYouFei(listticket.get(0).getMarketprice(), listticket.get(0).getShopprice())+"</td>");
			sb.append("<td  align='center'>刷身份证</td>");
			sb.append("<td>");
			sb.append("<input type='button' class='bst' value='立即预定' onclick='bookSpotTicket();'/>");
			sb.append("</td>");
			sb.append("</tr>");
		
			}
		}
		sb.append("</table>");
		sb.append("</div>");
		sb.append("<div class='c nohave5'></div>");
		sb.append("</ul>");
		
		
		
		sb.append("<ul class='c'>");
		sb.append("<li class='titlehot box_over box_over_top' style='background-color:#eee; color:#555454;'>");
		sb.append("<font class='f'>推荐门票</font>");
		sb.append("<span class='r mr15'>");
		sb.append("</span>");
		sb.append("<div class='c'></div>");
		sb.append("</li>");
		sb.append("</ul>");
		sb.append("<ul class='main'>");
		sb.append("<div class='nohave5'></div>");
		
		String where2=" where 1=1 and "+Spotticket.COL_sid+" in ( SELECT "+Spotmes.COL_id+" FROM "+Spotmes.TABLE+" WHERE "+Spotmes.COL_cityid+" ='"+CityID+"')";
		List<Spotticket>ListSpotmes2=Server.getInstance().getTripService().findAllSpotticket(where2, " ORDER BY ID DESC", 6, 0);
		if(ListSpotmes2.size()>0){
			for(int h=0;h<ListSpotmes2.size();h++){
				sb.append("<li class='f main_left'>");
				sb.append("<ul>");
				sb.append("<a href='spotticket!toSpotTicketInfo.jspx?SpotMesID="+ListSpotmes2.get(h).getSid()+"&startDate="+startDate+"'>");
				sb.append("<li class='f main_name'>"+ListSpotmes2.get(h).getName()+"</li>");
				sb.append("</a>");
				sb.append("<li class='f main_morny f90c'>&yen;"+ListSpotmes2.get(h).getShopprice()+"</li>");
				sb.append("</ul>");
				sb.append("</li>");
			}
		}
		sb.append("<div class='c nohave5'></div>");
		sb.append("</ul>");
		
		
		
		
		
		
		sb.append("</div>");
System.out.println(sb.toString());
		Writer writer = response.getWriter();
		writer.write(sb.toString());
		writer.flush();
		writer.close();
	}
	
	
	/**
	 * AJAX读取线路推荐信息 2013-08-20 陈星
	 * 
	 * @throws
	 */
	public void GetSpotmesByCityid() throws Exception {
		
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		StringBuilder sber = new StringBuilder();
		String where=" where 1=1 ";
		if(CityID!=null&&CityID.trim().length()>0){
		//where+=	" and "+Spotmes.COL_cityid+" ='"+CityID+"'";
		}
		List<Spotline>ListSpotline=Server.getInstance().getTripService().findAllSpotline(where, " ORDER BY ID DESC ", 18, 0);
		int size=ListSpotline.size();
		sber.append("<div class='box content'>");
		for(int a=0;a<ListSpotline.size();a++){
			if((a+1)<size){
				sber.append("<ul class='box_botm_xu'>");
				}else{
					
				sber.append("<ul class=' mt7'>");	
				}
		
		sber.append("<li>");
		//sber.append("<span class='f'>("+(a+1)+").</span>");
		//sber.append("<img width='50' height='40' src='http://www.bzezt.com/uploads/"+ListSpotmes.get(a).getMinipics()+"' />");
		sber.append("<a href='spotline!toSpotLineInfo.jspx?SpotLineID="+ListSpotline.get(a).getId()+"&startDate="+startDate+"'>"+ListSpotline.get(a).getName()+"</a>");
		sber.append("<font class='r font_f60_c'></font>");//起价
		sber.append("<div class='c'></div>");
		sber.append("</li>");
		
		if((a+1)<size){
		sber.append("<div class='nohave6 c'>&nbsp;</div>");
		}else{
			
			
			
		}
		sber.append("</ul>");
		}
		sber.append("</div>");
		
		Writer writer = response.getWriter();
		writer.write(sber.toString());
		writer.flush();
		writer.close();
	}
	
	/**
	 * 门票首页
	 */
	public String execute() {

		return "index";
	}
	/**
	 * 线路列表
	 */
	public String SeachSpotline() {
		System.out.println("SeachName:"+SeachName);
		System.out.println("CityID:"+CityID);
		System.out.println("EndCityID:"+EndCityID);
		String orderStr=" ORDER BY ID ";
		String where=" WHERE 1=1 ";
		//ListSpotmes=Server.getInstance().getTripService().findAllSpotmes(where, " ORDER BY ID ", 10, 0);
		if(CityID!=null&&CityID.trim().length()>0){
			
			
			where +=" AND "+Spotline.COL_cityid+" ='"+CityID.trim()+"'";
		}
		if(SeachName!=null&&SeachName.trim().length()>0){
			
			where +=" AND ( "+Spotline.COL_name+" like '%"+SeachName.trim()+"%' OR "+Spotline.COL_address+" like '%"+SeachName.trim()+"%' )";
		}
		
		pageinfo.setPagerow(5);
		List list = Server.getInstance().getTripService()
			.findAllSpotlineForPageinfo(where.toString(), orderStr, pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		ListSpotline = list;
		
		if(pageinfo.getTotalrow()>0 &&   ListSpotline.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllSpotlineForPageinfo(where.toString()," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			ListSpotline = list;
		}
		

		return "tolist";
	}
	/**
	 * 线路详细信息
	 */
	public String toSpotLineInfo() {
		spotline=Server.getInstance().getTripService().findSpotline(Long.parseLong(SpotLineID));		
		ListSpotlineimg=Server.getInstance().getTripService().findAllSpotlineimg(" WHERE 1=1 AND "+Spotlineimg.COL_spotlineid+" ='"+SpotLineID+"'", " order by ID", -1, 0);
		ListSpotlineinfo=Server.getInstance().getTripService().findAllSpotlineinfo(" WHERE 1=1 AND "+Spotlineinfo.COL_spotlineid+" ='"+SpotLineID+"'", " order by ID", -1, 0);
		ListSpotlineprice=Server.getInstance().getTripService().findAllSpotlineprice(" WHERE 1=1 AND "+Spotlineprice.COL_spotlineid+" ='"+SpotLineID+"'", " order by ID", -1, 0);
		
		return "toinfo";
	}
	/**
	 * 酒店预订 2012-02-13 陈星
	 * @throws Exception 
	 * 
	 * @throws
	 */

	public String tobook() throws Exception {
		if(getLoginUser()==null){
			//未登录时，保存当前参数，跳转至登录页面
			ActionContext.getContext().getSession().put("SpotLineParam",SpotLineID);
			ActionContext.getContext().getSession().put("pageUrl","spotline!tobook.jspx?SpotLineID="+SpotLineID);
		
			return "toLogin";// 从新登陆
		}else{
			
			if(ActionContext.getContext().getSession().get("SpotLineParam")!=null)
			{
				String SpotLineParam=(String)ActionContext.getContext().getSession().get("SpotLineParam");
				System.out.println("SpotLineParam=="+SpotLineParam);
				
				if(SpotLineID==null){
					SpotLineID=SpotLineParam.trim();
				}
				
				
			}
		}
		
		System.out.println("SpotLineID:"+SpotLineID);
		
		
		spotline=Server.getInstance().getTripService().findSpotline(Long.parseLong(SpotLineID));		
		ListSpotlineimg=Server.getInstance().getTripService().findAllSpotlineimg(" WHERE 1=1 AND "+Spotlineimg.COL_spotlineid+" ='"+SpotLineID+"'", " order by ID", -1, 0);
		ListSpotlineinfo=Server.getInstance().getTripService().findAllSpotlineinfo(" WHERE 1=1 AND "+Spotlineinfo.COL_spotlineid+" ='"+SpotLineID+"'", " order by ID", -1, 0);
		ListSpotlineprice=Server.getInstance().getTripService().findAllSpotlineprice(" WHERE 1=1 AND "+Spotlineprice.COL_spotlineid+" ='"+SpotLineID+"'", " order by ID", -1, 0);
		
		
		
		return "tobook";
	}
	
	
	public String createOrder(){
		Spotline spotline=Server.getInstance().getTripService().findSpotline(Long.parseLong(SpotLineID));
		ListSpotlineprice=Server.getInstance().getTripService().findAllSpotlineprice(" WHERE 1=1 AND "+Spotlineprice.COL_spotlineid+" ='"+SpotLineID+"'", " order by ID", -1, 0);
		String chengrenprice="0";//成人价格
		String ertongprice="0";//儿童价格
		for(int p=0;p<ListSpotlineprice.size();p++){
			if(ListSpotlineprice.get(p).getPtype().equals("成人")){
				chengrenprice=ListSpotlineprice.get(p).getPrice().trim();
			}
			if(ListSpotlineprice.get(p).getPtype().equals("儿童")){
				ertongprice=ListSpotlineprice.get(p).getPrice().trim();
			}
		}
		
		
		spotlineorder=new Spotlineorder();
		spotlineorder.setSpotlineid(SpotLineID);
		spotlineorder.setLinkemail(LinkMail);
		spotlineorder.setLinkname(LinkName);
		spotlineorder.setLinktel(LinkMobile);
		spotlineorder.setMemberid(getLoginUser().getId());
		spotlineorder.setBeizhu(LinkDesc);
		spotlineorder.setCreatetime(new Timestamp(System.currentTimeMillis()));
		spotlineorder.setStime(spotline.getStime());
		if(spotline.getCityid()!=null){
		spotlineorder.setCityid(spotline.getCityid()+"");
		}
		if(spotline.getProvineid()!=null){
		spotlineorder.setProvineid(spotline.getProvineid()+"");
		}
		spotlineorder.setName(spotline.getName());
		spotlineorder.setPaystate(0l);//0未支付  1已支付
		spotlineorder.setState(0l);//0新订单 1已确认 2已完成 3已取消
		spotlineorder.setPrice(price);
		spotlineorder.setSnum(SpotLineNum);
		spotlineorder.setParam1("spot");
		try {
			spotlineorder=Server.getInstance().getTripService().createSpotlineorder(spotlineorder);
			spotlineorder.setOrderno("L"+(spotlineorder.getId()+10000));
			Server.getInstance().getTripService().updateSpotlineorderIgnoreNull(spotlineorder);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//private String pName;//游客姓名
		//private String pType;//游客类型
		//private String pSex;//游客性别
		//private String pIdtype;//证件类型
		//private String pIdNo;//证件号码
		//private String pMobile;//电话
		
		String []pNames=pName.split(",");
		String []pTypes=pType.split(",");
		String []pSexs=pSex.split(",");
		String []pIdtypes=pIdtype.split(",");
		String []pIdNos=pIdNo.split(",");
		String []pMobiles=pMobile.split(",");
		
		for(int s=0;s<pNames.length;s++){
			if(pNames[s]!=null&&pNames[s].trim().length()>0){
				Spotlineuser spotlineuser=new Spotlineuser();
				spotlineuser.setOrderid(spotlineorder.getId());
				spotlineuser.setName(pNames[s].trim());
				if(pSexs[s]!=null&&pSexs[s].trim().length()>0){
				spotlineuser.setPsex(pSexs[s].trim());
				}
				if(pIdtypes[s]!=null&&pIdtypes[s].trim().length()>0){
				spotlineuser.setIdtype(Long.parseLong(pIdtypes[s].trim()));
				}
				if(pIdNos[s]!=null&&pIdNos[s].trim().length()>0){
				spotlineuser.setIdno(pIdNos[s].trim());
				}
				if(pMobiles[s]!=null&&pMobiles[s].trim().length()>0){
				spotlineuser.setTel(pMobiles[s].trim());
				}
				if(pTypes[s]!=null&&pTypes[s].trim().length()>0){
				spotlineuser.setPtype(pTypes[s].trim());
				}
				if(spotlineuser.getPtype()!=null&&spotlineuser.getPtype().equals("1")){
					spotlineuser.setPrice(chengrenprice);
				}else{
					spotlineuser.setPrice(ertongprice);
				}
				
				try {
					Server.getInstance().getTripService().createSpotlineuser(spotlineuser);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		
		
		forword="spotline!toShowOrder.jspx?OrderID="+spotlineorder.getId();
		
		return "toorder";
	}
	public String toShowOrder(){
		
		spotlineorder=Server.getInstance().getTripService().findSpotlineorder(OrderID);
		
		if(spotlineorder!=null&&spotlineorder.getMemberid()!=null&&spotlineorder.getMemberid()==getLoginUser().getId()){
			
			return "toShowOrder";
		}
		
		return "toERR";
	}

	public String GetTimeByMiao(String info){
		
		return formatDate(new java.util.Date(Long.parseLong(info)));
	}
	public Float GetYouFei(String price1,String price2){
		
		
		return Float.parseFloat(price1)-Float.parseFloat(price2);
	}
	//根据门票城市ID取名字
	public String GetSpotCityNmaeByID(String spotcityid){
		
		
		return Server.getInstance().getTripService().findSpotcity(Long.parseLong(spotcityid)).getName();
	}
	public String ShowHTML(String info,String type){
		System.out.println(type);
		String htmlStr = info; //含html标签的字符串 
        String textStr =""; 
        
        java.util.regex.Pattern p_script; 
        java.util.regex.Matcher m_script; 
        java.util.regex.Pattern p_style; 
        java.util.regex.Matcher m_style; 
        java.util.regex.Pattern p_html; 
        java.util.regex.Matcher m_html; 
     


		 try { 
	           String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> } 
	           String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> } 
	              String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式 
	          
	              p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
	              m_script = p_script.matcher(htmlStr); 
	              htmlStr = m_script.replaceAll(""); //过滤script标签 

	              p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
	              m_style = p_style.matcher(htmlStr); 
	              htmlStr = m_style.replaceAll(""); //过滤style标签 
	          
	              p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
	              m_html = p_html.matcher(htmlStr); 
	              htmlStr = m_html.replaceAll(""); //过滤html标签 
	          
	           textStr = htmlStr; 
	          
	          }catch(Exception e) { 
	                   System.err.println("Html2Text: " + e.getMessage()); 
	          } 

	          if(type.equals("list")){
	        	  
	        	  System.err.println(textStr);
	      		return textStr;
	          }else{
	        	  
	        	  return info.replaceAll("/uploads", "http://www.bzezt.com/uploads");
	          }
		
		//return info.replaceAll("/uploads", "http://www.bzezt.com/uploads");
	}
	
	

	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
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

	public String getCityID() {
		return CityID;
	}

	public void setCityID(String cityID) {
		CityID = cityID;
	}

	public List<Spotmes> getListSpotmes() {
		return ListSpotmes;
	}

	public void setListSpotmes(List<Spotmes> listSpotmes) {
		ListSpotmes = listSpotmes;
	}



	public String getSpotLineID() {
		return SpotLineID;
	}

	public void setSpotLineID(String spotLineID) {
		SpotLineID = spotLineID;
	}

	public List<Spotline> getListSpotline() {
		return ListSpotline;
	}

	public void setListSpotline(List<Spotline> listSpotline) {
		ListSpotline = listSpotline;
	}

	public List<Spotlineimg> getListSpotlineimg() {
		return ListSpotlineimg;
	}

	public void setListSpotlineimg(List<Spotlineimg> listSpotlineimg) {
		ListSpotlineimg = listSpotlineimg;
	}

	public List<Spotlineinfo> getListSpotlineinfo() {
		return ListSpotlineinfo;
	}

	public void setListSpotlineinfo(List<Spotlineinfo> listSpotlineinfo) {
		ListSpotlineinfo = listSpotlineinfo;
	}

	public List<Spotlineprice> getListSpotlineprice() {
		return ListSpotlineprice;
	}

	public void setListSpotlineprice(List<Spotlineprice> listSpotlineprice) {
		ListSpotlineprice = listSpotlineprice;
	}

	public String getSpotTicketID() {
		return SpotTicketID;
	}

	public void setSpotTicketID(String spotTicketID) {
		SpotTicketID = spotTicketID;
	}

	public List<Object> getListimage() {
		return listimage;
	}

	public void setListimage(List<Object> listimage) {
		this.listimage = listimage;
	}

	public Spotticket getSpotticket() {
		return spotticket;
	}

	public void setSpotticket(Spotticket spotticket) {
		this.spotticket = spotticket;
	}

	public String getSeachName() {
		return SeachName;
	}

	public void setSeachName(String seachName) {
		SeachName = seachName;
	}

	

	public String getLinkMobile() {
		return LinkMobile;
	}

	public void setLinkMobile(String linkMobile) {
		LinkMobile = linkMobile;
	}

	

	public String getLinkName() {
		return LinkName;
	}

	public void setLinkName(String linkName) {
		LinkName = linkName;
	}

	public Spotorder getSpotorder() {
		return spotorder;
	}

	public void setSpotorder(Spotorder spotorder) {
		this.spotorder = spotorder;
	}

	public String getForword() {
		return forword;
	}

	public void setForword(String forword) {
		this.forword = forword;
	}

	public long getOrderID() {
		return OrderID;
	}

	public void setOrderID(long orderID) {
		OrderID = orderID;
	}

	public Spotline getSpotline() {
		return spotline;
	}

	public void setSpotline(Spotline spotline) {
		this.spotline = spotline;
	}
	public Spotmes getSpotmes() {
		return spotmes;
	}

	public void setSpotmes(Spotmes spotmes) {
		this.spotmes = spotmes;
	}

	public List<Spotticket> getListSpotticket() {
		return ListSpotticket;
	}

	public void setListSpotticket(List<Spotticket> listSpotticket) {
		ListSpotticket = listSpotticket;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLinkMail() {
		return LinkMail;
	}

	public void setLinkMail(String linkMail) {
		LinkMail = linkMail;
	}

	public String getLinkDesc() {
		return LinkDesc;
	}

	public void setLinkDesc(String linkDesc) {
		LinkDesc = linkDesc;
	}

	public String getPName() {
		return pName;
	}

	public void setPName(String name) {
		pName = name;
	}

	public String getPType() {
		return pType;
	}

	public void setPType(String type) {
		pType = type;
	}

	public String getPSex() {
		return pSex;
	}

	public void setPSex(String sex) {
		pSex = sex;
	}

	public String getPIdtype() {
		return pIdtype;
	}

	public void setPIdtype(String idtype) {
		pIdtype = idtype;
	}

	public String getPIdNo() {
		return pIdNo;
	}

	public void setPIdNo(String idNo) {
		pIdNo = idNo;
	}

	public String getPMobile() {
		return pMobile;
	}

	public void setPMobile(String mobile) {
		pMobile = mobile;
	}

	public Spotlineorder getSpotlineorder() {
		return spotlineorder;
	}

	public void setSpotlineorder(Spotlineorder spotlineorder) {
		this.spotlineorder = spotlineorder;
	}

	public List<Spotlineuser> getListSpotlineuser() {
		return ListSpotlineuser;
	}

	public void setListSpotlineuser(List<Spotlineuser> listSpotlineuser) {
		ListSpotlineuser = listSpotlineuser;
	}

	public String getSpotLineNum() {
		return SpotLineNum;
	}

	public void setSpotLineNum(String spotLineNum) {
		SpotLineNum = spotLineNum;
	}

	public String getEndCityID() {
		return EndCityID;
	}

	public void setEndCityID(String endCityID) {
		EndCityID = endCityID;
	}
}