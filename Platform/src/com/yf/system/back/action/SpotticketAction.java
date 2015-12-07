/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;
import com.yf.system.back.server.Server;
import com.yf.system.back.servlet.CnToSpell;
import com.yf.system.base.spotcity.Spotcity;
import com.yf.system.base.spotmes.Spotmes;
import com.yf.system.base.spotorder.Spotorder;
import com.yf.system.base.spotticket.Spotticket;
import com.yf.system.base.spotticketcity.Spotticketcity;
import com.yf.system.base.util.PageInfo;



public class SpotticketAction extends B2b2cbackAction {
	private List <  Spotticket  >  listSpotticket;
	private Spotticket spotticket = new Spotticket();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	// 开始日期
	private String startDate;
	// 结束日期
	private String endDate;
	//城市ID
	private String CityID;
	
	private String cityname;
	//搜索关键字
	private String SeachName;
	
	private String S_SeachName;
	//景区ID
	private String SpotMesID;
	
	//门票ID
	private String SpotTicketID;
	
	//景区list
	private List<Spotmes> ListSpotmes;
	
	//景区对象
	private Spotmes spotmes=new Spotmes();
	
	
	
	//门票订单对象
	private Spotorder spotorder=new Spotorder();
	
	//门票list
	private List<Spotticket>ListSpotticket=new ArrayList<Spotticket>();
	private List<Spotticket>ListSpotticket2=new ArrayList<Spotticket>();
	private List<Object>listimage=new ArrayList<Object>();
	
	//跳转用
	private String forword;
	//门票订单ID
	private long OrderID;
	
	
	
	//下单用参数
	
	//身份证号码
	private String LinkSFZ;
	//电话
	private String LinkMobile;
	//数量
	private String SpotNum;
	//价格
	private String price;
	//姓名
	private String LinkName;
	//search
	//private String s_name;
	
	/**
	 * 转向到景点门票首页
	 */	
	public String toindex()throws Exception{
		return "toindex";
	}
	public String tobook() throws Exception {
		
			
		
		
		System.out.println("SpotTicketID:"+SpotTicketID);
		
		
		spotticket=Server.getInstance().getTripService().findSpotticket(Long.parseLong(SpotTicketID));
		spotmes=Server.getInstance().getTripService().findSpotmes(Long.parseLong(spotticket.getSid()));	
		
		
		
		return "tobook";
	}
	public String createOrder(){
		
		spotorder=new Spotorder();
		
		Spotticket spotticket=new Spotticket();
		spotticket=Server.getInstance().getTripService().findSpotticket(Long.parseLong(SpotTicketID));
		spotmes=Server.getInstance().getTripService().findSpotmes(Long.parseLong(spotticket.getSid()));
		spotorder.setSpotticketid(SpotTicketID);
		spotorder.setName(spotticket.getName());
		spotorder.setSfz(LinkSFZ);
		spotorder.setSunm(SpotNum);
		spotorder.setPrice(price);
		spotorder.setTel(LinkMobile);
		spotorder.setAddress(spotmes.getAddress());
		spotorder.setStime(startDate);
		spotorder.setParam2(LinkName);
		spotorder.setCreatetime(new Timestamp(System.currentTimeMillis()));
		spotorder.setMemberid(getLoginUser().getId());
		spotorder.setState(0l);//0新订单  1已支付 2已完成 3已取消
		if(spotmes.getCityid()!=null){
		spotorder.setCityid(spotmes.getCityid());
		}
		try {
			spotorder=Server.getInstance().getTripService().createSpotorder(spotorder);
			spotorder.setParam1("S"+(10000+spotorder.getId()));
			Server.getInstance().getTripService().updateSpotorderIgnoreNull(spotorder);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		forword="spotticket!toShowOrder.action?OrderID="+spotorder.getId();
		
		return "toorder";
	}
public String toShowOrder(){
		
		spotorder=Server.getInstance().getTripService().findSpotorder(OrderID);
		
		if(spotorder!=null&&spotorder.getMemberid()!=null&&spotorder.getMemberid()==getLoginUser().getId()){
			
			return "toShowOrder";
		}
		
		return "toERR";
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
		
		where+=" and "+Spotmes.COL_id+" in ( SELECT "+Spotticket.COL_sid+" FROM "+Spotticket.TABLE+" )";
		
		System.out.println(where);
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
				
				
			//List<Spotticket>listticket=Server.getInstance().getTripService().findAllSpotticket(" WHERE 1=1 AND "+Spotticket.COL_sid+" ='"+ListSpotmes.get(s).getId()+"'", " ORDER BY ID ", 1, 0);
			sb.append("<tr>");
			sb.append("<td class='floatall'>");
			sb.append("<img width='80' height='70' src='http://upload.17u.com/uploadfile/"+ListSpotmes.get(s).getMinipics()+"' />");
			sb.append("<a href='spotticket!toSpotTicketInfo.action?SpotMesID="+ListSpotmes.get(s).getId()+"&startDate="+startDate+"'>");
			sb.append("<b>"+ListSpotmes.get(s).getName()+"</b>");
			sb.append("</a>");
			sb.append("</td>");
			sb.append("<td class='font-f60-del' align='center'>&yen;"+ListSpotmes.get(s).getUid().split("@")[0]+"</td>");
			sb.append("<td class='font-f60-16' align='center'>&yen;"+ListSpotmes.get(s).getUid().split("@")[1]+"</td>");
			sb.append("<td  align='center'>"+GetYouFei(ListSpotmes.get(s).getUid().split("@")[0], ListSpotmes.get(s).getUid().split("@")[1])+"</td>");
			sb.append("<td  align='center'>刷身份证</td>");
			sb.append("<td>");
			sb.append("<input type='button' class='bst' value='查询详情' onclick='bookSpotTicket();'/>");
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
				sb.append("<a href='spotticket!toSpotTicketInfo.action?SpotMesID="+ListSpotmes2.get(h).getSid()+"&startDate="+startDate+"'>");
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
	public void GetSpotByCity2() throws Exception {
		//System.out.println("酒店ID:"+strHotelCity);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		String where=" where 1=1 and "+Spotmes.COL_cityid+" ='"+CityID+"'";
		
		where+=" and "+Spotmes.COL_id+" in ( SELECT "+Spotticket.COL_sid+" FROM "+Spotticket.TABLE+" )";
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
			sb.append("<a href='spotticket!toSpotTicketInfo.action?SpotMesID="+ListSpotmes.get(s).getId()+"&startDate="+startDate+"'>");
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
				sb.append("<a href='spotticket!toSpotTicketInfo.action?SpotMesID="+ListSpotmes2.get(h).getSid()+"&startDate="+startDate+"'>");
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
	
public Float GetYouFei(String price1,String price2){
		
		
		return Float.parseFloat(price1)-Float.parseFloat(price2);
	}
	/**
	 * AJAX读取景区推荐信息 2013-08-20 陈星
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
		where+=" and "+Spotmes.COL_id+" in ( SELECT "+Spotticket.COL_sid+" FROM "+Spotticket.TABLE+" )";
		
		
		
		List<Spotmes>ListSpotmes=Server.getInstance().getTripService().findAllSpotmes(where, " ORDER BY ID DESC ", 10, 0);
		int size=ListSpotmes.size();
		sber.append("<div class='box content'>");
		for(int a=0;a<ListSpotmes.size();a++){
			if((a+1)<size){
				sber.append("<ul class='box_botm_xu'>");
				}else{
					
				sber.append("<ul class=' mt7'>");	
				}
			
		
		sber.append("<li>");
		//sber.append("<span class='f'>("+(a+1)+").</span>");
		sber.append("<img width='50' height='40' src='http://upload.17u.com/uploadfile/"+ListSpotmes.get(a).getMinipics()+"' />");
		sber.append("<a href='spotticket!toSpotTicketInfo.action?SpotMesID="+ListSpotmes.get(a).getId()+"&startDate="+startDate+"'>"+ListSpotmes.get(a).getName()+"</a>");
		sber.append("<font class='r font_f60_c'></font>");//起价
		sber.append("<div class='c'></div>");
		sber.append("</li>");
		//sber.append("<li class='content_lh'>");
		//sber.append("<span class='f pf25'>共<font class='f90'>98条</font>评论</span>");
		//sber.append("<span class='r pr20'><font class='f90'>99%</font>满意度</span>");
		//sber.append("<div class='c'></div>");
		//sber.append("</li>");
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
	 * 门票列表
	 */
	
	public String SeachSpot() {
		System.out.println("SeachName:"+SeachName);
		System.out.println("CityID:"+CityID);
		String orderStr=" ORDER BY ID ";
		String where=" WHERE 1=1 ";
		//ListSpotmes=Server.getInstance().getTripService().findAllSpotmes(where, " ORDER BY ID ", 10, 0);
		if(CityID!=null&&CityID.trim().length()>0){
			
			
			where +=" AND "+Spotmes.COL_cityid+" ='"+CityID.trim()+"'";
		}
		if(SeachName!=null&&SeachName.trim().length()>0){
			where +=" AND ( "+Spotmes.COL_name+" like '%"+SeachName.trim()+"%' OR "+Spotmes.COL_address+" like '%"+SeachName.trim()+"%'  OR "+Spotmes.COL_cityid+" in ( select "+Spotcity.COL_id+" from "+Spotcity.TABLE+" where 1=1 and "+Spotcity.COL_name+" like '%"+SeachName.trim()+"%'))";
		}
		where+=" and "+Spotmes.COL_id+" in ( SELECT "+Spotticket.COL_sid+" FROM "+Spotticket.TABLE+" )";
		
		System.out.println("wherespotticket:"+where);
		pageinfo.setPagerow(5);
		List list = Server.getInstance().getTripService()
			.findAllSpotmesForPageinfo(where.toString(), orderStr, pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		ListSpotmes = list;
		
		if(pageinfo.getTotalrow()>0 &&   ListSpotmes.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllSpotmesForPageinfo(where.toString()," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			ListSpotmes = list;
		}
		

		return "tolist";
	}
	/**
	 * 景区详细信息
	 */
	public String toSpotTicketInfo() {
		spotmes=Server.getInstance().getTripService().findSpotmes(Long.parseLong(SpotMesID));		
		ListSpotticket2=Server.getInstance().getTripService().findAllSpotticket(" WHERE 1=1 AND "+Spotticket.COL_sid+" ='"+SpotMesID+"'", " ORDER BY ID ", -1, 0);
		if(spotmes.getPics()!=null){
			String img=spotmes.getPics();
			System.out.println(img);
			String []imgs=img.split("[|]");
			System.out.println(imgs.length);
			for(int i=0;i<imgs.length;i++){
				if(imgs[i]!=null){
				listimage.add(imgs[i]);	
				}
			}
			
			
		}
		
		System.out.println(ListSpotticket2.size());
		return "toinfo";
	}
	public String ShowHTML(String info,String type){
		System.out.println(type);
		if(1==1){
			
			return info;
		}
		
		
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
public String GetTimeByMiao(String info){
		
		return formatDate(new java.util.Date(Long.parseLong(info)));
	}
	/**
	 * 列表查询景点门票
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Spotticket.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllSpotticketForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSpotticket = list;
		  if(pageinfo.getTotalrow()>0 &&   listSpotticket.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllSpotticketForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSpotticket = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到景点门票添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到景点门票修改页面
	 */	
	public String toedit()throws Exception{
	spotticket = Server.getInstance().getTripService().findSpotticket(spotticket.getId());
		return EDIT;
	}
	
	/**
	 * 转向到景点门票审核页面
	 */	
	public String tocheck()throws Exception{
	spotticket = Server.getInstance().getTripService().findSpotticket(spotticket.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加景点门票
	 */		
	public String add()throws Exception{
	spotticket.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().createSpotticket(spotticket);
		return LIST;
	}

	/**
	 * 审核景点门票
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateSpotticketIgnoreNull(spotticket);
		return LIST;
	}
	


	/**
	 * 编辑景点门票
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getTripService().updateSpotticketIgnoreNull(spotticket);
		return LIST;
	}

	/**
	 * 删除景点门票
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteSpotticket(spotticket.getId());
		return LIST;
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
		String strwhere = "WHERE 1=1 and " + Spotticketcity.COL_type+" =2";
	
		List<Spotticketcity> listSpotcity = Server.getInstance().getTripService()
				.findAllSpotticketcity(strwhere, "ORDER BY ID ", -1, 0);
		for (Spotticketcity airPort : listSpotcity) {
			sb.append(airPort.getName() + "#" + CnToSpell.getFullSpell(airPort.getName()) + "%"
					+ airPort.getPinyin() + "&" + airPort.getOutid() + ",");
		}
		// return strRetData;
		System.out.println("SB=" + sb);
		out.print(sb);
		out.flush();
		out.close();
		
	}

	public void GetSpotCity2() throws Exception {
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
	 * 批量操作
	 * @return
	 * @throws Exception
	 */
	public String batch()throws Exception{
		if(selectid!=null && selectid.length>0 ){
			
			switch(opt){
				case 1: //delete
				
				for(int i:selectid){
					Server.getInstance().getTripService().deleteSpotticket(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回景点门票对象
	 */		
	
	public Object getModel() {
		return spotticket;
	}
	public List < Spotticket >   getListSpotticket() {
		return listSpotticket;
	}
	public void setListSpotticket(List <  Spotticket  >  listSpotticket) {
		this.listSpotticket = listSpotticket;
	}
	public Spotticket getSpotticket() {
		return spotticket;
	}
	public void setSpotticket(Spotticket spotticket) {
		this.spotticket = spotticket;
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
	public String getSeachName() {
		return SeachName;
	}
	public void setSeachName(String seachName) {
		SeachName = seachName;
	}
	public String getS_SeachName() {
		return S_SeachName;
	}
	public void setS_SeachName(String seachName) {
		S_SeachName = seachName;
	}
	public String getSpotMesID() {
		return SpotMesID;
	}
	public void setSpotMesID(String spotMesID) {
		SpotMesID = spotMesID;
	}
	public String getSpotTicketID() {
		return SpotTicketID;
	}
	public void setSpotTicketID(String spotTicketID) {
		SpotTicketID = spotTicketID;
	}
	public List<Spotmes> getListSpotmes() {
		return ListSpotmes;
	}
	public void setListSpotmes(List<Spotmes> listSpotmes) {
		ListSpotmes = listSpotmes;
	}
	public Spotmes getSpotmes() {
		return spotmes;
	}
	public void setSpotmes(Spotmes spotmes) {
		this.spotmes = spotmes;
	}
	public Spotorder getSpotorder() {
		return spotorder;
	}
	public void setSpotorder(Spotorder spotorder) {
		this.spotorder = spotorder;
	}
	public List<Object> getListimage() {
		return listimage;
	}
	public void setListimage(List<Object> listimage) {
		this.listimage = listimage;
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
	public String getLinkSFZ() {
		return LinkSFZ;
	}
	public void setLinkSFZ(String linkSFZ) {
		LinkSFZ = linkSFZ;
	}
	public String getLinkMobile() {
		return LinkMobile;
	}
	public void setLinkMobile(String linkMobile) {
		LinkMobile = linkMobile;
	}
	public String getSpotNum() {
		return SpotNum;
	}
	public void setSpotNum(String spotNum) {
		SpotNum = spotNum;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getLinkName() {
		return LinkName;
	}
	public void setLinkName(String linkName) {
		LinkName = linkName;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public List<Spotticket> getListSpotticket2() {
		return ListSpotticket2;
	}
	public void setListSpotticket2(List<Spotticket> listSpotticket2) {
		ListSpotticket2 = listSpotticket2;
	}
	
	
}