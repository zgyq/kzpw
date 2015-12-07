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
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelcontract.Hotelcontract;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;

public class HotelcontractAction extends B2b2cbackAction {
	private List  listHotelcontract;
	private Hotelcontract hotelcontract = new Hotelcontract();
	private String hotelName;
	private Hotel hotel = new Hotel();
	//签约日期
	private String subDateStr;
	//终止日期
	private String availDateStr;
	private String forward;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	private File[] files;
	private Long hotelId ;
	//search
	//private String s_name;
	
	//跳转tabs的页面
	private String tabtype ;
	
	public String getTabtype() {
		return tabtype;
	}
	public void setTabtype(String tabtype) {
		this.tabtype = tabtype;
	}
	/**
	 * 根据酒店的ID列表查询酒店合同
	 */	
	public String execute()throws Exception{
		String where = " where 1=1  and "+Hotelcontract.COL_hotelid+"="+hotelId +" and "+Hotelcontract.COL_state+"="+1;
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotelName = hotel.getName();
		List list = Server.getInstance().getHotelService().findAllHotelcontractForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotelcontract =list;
		 if(pageinfo.getTotalrow()>0 &&   listHotelcontract.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotelcontractForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotelcontract = list;
		}
		
		
		return SUCCESS;
	}
	/**
	 * 查看历史记录
	 */
	public String historyLog()throws Exception{
		String where = " where 1=1  and "+Hotelcontract.COL_hotelid+"="+hotelId;
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Hotelcontract.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotelName = hotel.getName();
		List list = Server.getInstance().getHotelService().findAllHotelcontractForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotelcontract = list;
		 if(pageinfo.getTotalrow()>0 &&   listHotelcontract.size()==0){
			pageinfo.setPagenum(1);
			
			list = Server.getInstance().getHotelService().findAllHotelcontractForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotelcontract = list;
		 }
		
		
		return SUCCESS;
	}
	/**
	 * 转向到酒店合同添加页面
	 */	
	public String toadd()throws Exception{
		
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotelName = hotel.getName();
		System.out.println(hotelName);
		Calendar date= Calendar.getInstance();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
		String dateStr=df.format(new java.util.Date());
		hotelcontract.setCode(dateStr);
		return EDIT;
	}
public String toeditlanguage()throws Exception{
		
		Integer lan=hotelcontract.getLanguage();
		Long uco=hotelcontract.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		hotelcontract = Server.getInstance().getHotelService().findHotelcontractbylanguage(hotelcontract.getUcode(),hotelcontract.getLanguage());
		if(hotelcontract==null)
		{
			hotelcontract=new Hotelcontract();
			hotelcontract.setLanguage(lan);
			hotelcontract.setUcode(uco);
			//以下是toadd参考方法
			hotel = Server.getInstance().getHotelService().findHotel(hotelId);
			hotelName = hotel.getName();
			System.out.println(hotelName);
			Calendar date= Calendar.getInstance();
			SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
			String dateStr=df.format(new java.util.Date());
			hotelcontract.setCode(dateStr);
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			hotel = Server.getInstance().getHotelService().findHotel(hotelId);
			hotelName = hotel.getName();
			hotelcontract.setHotelid(hotelId);	
			hotelcontract = Server.getInstance().getHotelService().findHotelcontract(hotelcontract.getId());
			System.out.println(hotelcontract);
			subDateStr = formatDate(hotelcontract.getSigndate());
			availDateStr = formatDate(hotelcontract.getEnddate());
			hotelcontract = Server.getInstance().getHotelService().findHotelcontract(hotelcontract.getId());
		}
		return EDIT;
	}
	/**
	 * 转向到酒店合同修改页面
	 */	
	public String toedit()throws Exception{
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotelName = hotel.getName();
		hotelcontract.setHotelid(hotelId);	
		hotelcontract = Server.getInstance().getHotelService().findHotelcontract(hotelcontract.getId());
		System.out.println(hotelcontract);
		subDateStr = formatDate(hotelcontract.getSigndate());
		availDateStr = formatDate(hotelcontract.getEnddate());
		hotelcontract = Server.getInstance().getHotelService().findHotelcontract(hotelcontract.getId());
		return EDIT;
	}
	/**
	 * 转到合同信息查看页面
	 */
	public String tolook()throws Exception{
		String where = " where 1=1  and "+Hotelcontract.COL_hotelid+"="+hotelId;
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotelName = hotel.getName();
		List list = Server.getInstance().getHotelService().findAllHotelcontractForPageinfo(where," order by  ID",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listHotelcontract = list;
		 if(pageinfo.getTotalrow()>0 &&   listHotelcontract.size()==0){
			pageinfo.setPagenum(1);
			list  = Server.getInstance().getHotelService().findAllHotelcontractForPageinfo(where," ORDER BY ID ",pageinfo);	
			pageinfo = (PageInfo)list.remove(0);
			listHotelcontract = list;
		 }
		return "look";
	}
	
	/**
	 * 转向到酒店合同审核页面
	 */	
	public String tocheck()throws Exception{
		String where = " where 1=1  and "+Hotelcontract.COL_hotelid+"="+hotelId;
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotelName = hotel.getName();
		List list = Server.getInstance().getHotelService().findAllHotelcontractForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotelcontract = list;
		 if(pageinfo.getTotalrow()>0 &&   listHotelcontract.size()==0){
			pageinfo.setPagenum(1);
			
			list = Server.getInstance().getHotelService().findAllHotelcontractForPageinfo(where," ORDER BY ID ",pageinfo);	
			pageinfo = (PageInfo) list.remove(0);
			listHotelcontract = list;
		 }
		return CHECK;
	}
	
	
	/**
	 * 添加酒店合同
	 */		
	public String add()throws Exception{
		
		String where = " where 1=1  and "+Hotelcontract.COL_hotelid+"="+hotelId +" and "+Hotelcontract.COL_state+"="+1;
		listHotelcontract = Server.getInstance().getHotelService().findAllHotelcontract(where," ORDER BY ID ",-1,0);
		List<Hotelcontract> list =listHotelcontract;
		for (Hotelcontract hotelcontract : list) {
			hotelcontract.setState(0);
			Server.getInstance().getHotelService().updateHotelcontractIgnoreNull(hotelcontract);
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date subDate  =dateFormat.parse(subDateStr); 
		java.util.Date availDate =dateFormat.parse(availDateStr);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if(null != files){
			
			String filePath = "/"+df.format(new java.util.Date())+"/" +hotelId +"/";
			String realPath =this.getRealPath(filePath);
			File f = new File(realPath);
			f.mkdirs();
			Util.copyfile(files[0],new File(f.getPath()+"/"+files[0].getName()));
			hotelcontract.setFilepath(filePath+files[0].getName());	
			
		}
		System.out.println("HotelcontractAction-------------------------"+hotelId);
		hotelcontract.setSigndate(new Date(subDate.getTime()));
		hotelcontract.setEnddate(new Date(availDate.getTime()));
		hotelcontract.setState(1);
		hotelcontract.setHotelid(hotelId);
		hotelcontract.setLanguage(0);
		hotelcontract=Server.getInstance().getHotelService().createHotelcontract(hotelcontract);
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotel.setState(0);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		forward="hotelcontract!tabs.action?remotetabs=2&hotelId="+hotelId;
		return "forward";
	}
	
	public String getHeTongPath(String filePath) {
		return "preview?filepath=" + filePath; 
	}

	/**
	 * 审核酒店合同
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateHotelcontractIgnoreNull(hotelcontract);
		return LIST;
	}
	


	/**
	 * 编辑酒店合同
	 */		
	public String edit()throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date subDate  =dateFormat.parse(subDateStr); 
		java.util.Date availDate =dateFormat.parse(availDateStr);
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotel.setState(0);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if(null != files){
			
			String filePath = "/"+df.format(new java.util.Date())+"/" +hotelId +"/";
			String realPath =getRealPath(filePath);
			File f = new File(realPath);
			f.mkdirs();
			Util.copyfile(files[0],new File(f.getPath()+"/"+files[0].getName()));
			hotelcontract.setFilepath(filePath+files[0].getName());
			
		}
		hotelcontract.setLanguage(0);
		hotelcontract.setSigndate(new Date(subDate.getTime()));
		hotelcontract.setEnddate(new Date(availDate.getTime()));
		hotelcontract.setHotelid(hotelId);
		//hotelcontract.setState(1);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		System.out.println("合同action------------edit()-----hotelstate:"+hotel.getState());
		Server.getInstance().getHotelService().updateHotelcontractIgnoreNull(hotelcontract);
		forward="hotelcontract!tabs.action?remotetabs=2&hotelId="+hotelId;
		return "forward2";
	}

	/**
	 * 删除酒店合同
	 */		
	public String delete()throws Exception{	
		//System.out.println("合同-------------delect() --hotelId:"+hotelId);
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotel.setState(0);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		Server.getInstance().getHotelService().deleteHotelcontract(hotelcontract.getId());
		return LIST;
	}

	/**
	 * 转向到tabs
	 */		
	public String tabs()throws Exception{	
		return "tabs";
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
					Server.getInstance().getHotelService().deleteHotelcontract(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回酒店合同对象
	 */		
	
	public Object getModel() {
		return hotelcontract;
	}
	public List < Hotelcontract >   getListHotelcontract() {
		return listHotelcontract;
	}
	public void setListHotelcontract(List <  Hotelcontract  >  listHotelcontract) {
		this.listHotelcontract = listHotelcontract;
	}
	public Hotelcontract getHotelcontract() {
		return hotelcontract;
	}
	public void setHotelcontract(Hotelcontract hotelcontract) {
		this.hotelcontract = hotelcontract;
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
	public File[] getFiles() {
		return files;
	}
	public void setFiles(File[] files) {
		this.files = files;
	}
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getAvailDateStr() {
		return availDateStr;
	}
	public void setAvailDateStr(String availDateStr) {
		this.availDateStr = availDateStr;
	}
	public String getSubDateStr() {
		return subDateStr;
	}
	public void setSubDateStr(String subDateStr) {
		this.subDateStr = subDateStr;
	}
	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
	}

	
	
}