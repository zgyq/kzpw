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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelspec.Hotelspec;
import com.yf.system.base.util.PageInfo;

public class HotelspecAction extends B2b2cbackAction {
	private List  listHotelspec;
	private Hotelspec hotelspec = new Hotelspec();
	private Long hotelId ;
	private String hotelName;
	private Hotel hotel;
	private String starttimeStr;
	private String endtimeStr;
	private String forward;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询酒店注意事项
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		if(hotelId != null && hotelId.longValue()>0){
			where += " AND " + hotelspec.COL_hotelid +"="+hotelId.longValue();
			List list = Server.getInstance().getHotelService().findAllHotelspecForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listHotelspec = list;
		}
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Hotelspec.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
		
		
		 if(pageinfo.getTotalrow()>0 &&   listHotelspec.size()==0){
			pageinfo.setPagenum(1);
			List list = Server.getInstance().getHotelService().findAllHotelspecForPageinfo(where," ORDER BY ID ",pageinfo);	
			pageinfo = (PageInfo) list.remove(0);
			listHotelspec = list;
		}
		
		
		return SUCCESS;
	}
	/**
	 * 转向到酒店注意事项添加页面
	 */	
	public String toadd()throws Exception{
		
		hotelName=Server.getInstance().getHotelService().findHotel(hotelId).getName();
		System.out.println(hotelName);
		System.out.println("HotelspecAction------toadd()---hotelId:--"+hotelId);
		
		return EDIT;
	}
public String toeditlanguage()throws Exception{
		
		Integer lan=hotelspec.getLanguage();
		Long uco=hotelspec.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		hotelspec = Server.getInstance().getHotelService().findHotelspecbylanguage(hotelspec.getUcode(),hotelspec.getLanguage());
		if(hotelspec==null)
		{
			hotelspec=new Hotelspec();
			hotelspec.setLanguage(lan);
			hotelspec.setUcode(uco);
			//以下是toadd参考方法
			hotelName=Server.getInstance().getHotelService().findHotel(hotelId).getName();
			System.out.println(hotelName);
			System.out.println("HotelspecAction------toadd()---hotelId:--"+hotelId);
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			System.out.println("toedit()======"+hotelId);
			hotel=Server.getInstance().getHotelService().findHotel(hotelId);
			hotelName = hotel.getName();
			//System.out.println("toedit()-----------------------hotelName:"+hotelName);
			hotelspec = Server.getInstance().getHotelService().findHotelspec(hotelspec.getId());
		}
		return EDIT;
	}
	
	/**
	 * 转向到酒店注意事项修改页面
	 */	
	public String toedit()throws Exception{	
		System.out.println("toedit()======"+hotelId);
		hotel=Server.getInstance().getHotelService().findHotel(hotelId);
		hotelName = hotel.getName();
		//System.out.println("toedit()-----------------------hotelName:"+hotelName);
		hotelspec = Server.getInstance().getHotelService().findHotelspec(hotelspec.getId());
		return EDIT;
	}
	
	/**
	 * 转向到酒店注意事项审核页面
	 */	
	public String tocheck()throws Exception{
		String where = " where 1=1 ";
		if(hotelId != null && hotelId.longValue()>0){
			where += " AND " + hotelspec.COL_hotelid +"="+hotelId.longValue();
			 List list = Server.getInstance().getHotelService().findAllHotelspecForPageinfo(where,"ORDER BY ID",pageinfo);
			 pageinfo =(PageInfo) list.remove(0);
			 listHotelspec = list;
		}
			
		 if(pageinfo.getTotalrow()>0 &&   listHotelspec.size()==0){
			pageinfo.setPagenum(1);
			listHotelspec = Server.getInstance().getHotelService().findAllHotelspecForPageinfo(where," ORDER BY ID ",pageinfo);	
		}
		
		return CHECK;
	}

	/**
	 * 转向到tabs
	 */		
	public String tabs()throws Exception{	
		return "tabs";
	}
	/**
	 * 转向酒店注意事项查看页面
	 */
	public String tolook()throws Exception{
		String where = " where 1=1 ";
		List list =null;
		if(hotelId != null && hotelId.longValue()>0){
			where += " AND " + hotelspec.COL_hotelid +"="+hotelId.longValue();
			 list = Server.getInstance().getHotelService().findAllHotelspecForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo =(PageInfo) list.remove(0);
			listHotelspec =list;
		}
			
		 if(pageinfo.getTotalrow()>0 &&   listHotelspec.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotelspecForPageinfo(where," ORDER BY ID ",pageinfo);	
			pageinfo =(PageInfo)list.remove(0);
			listHotelspec = list;
		 }
		return "look";
	}
	
	/**
	 * 根据酒店的id获得酒店的名称
	 */
	public String getHotelNameById(Integer id){
		hotelName = Server.getInstance().getHotelService().findHotel(id).getName();
		return hotelName;
		
	}
	/**
	 * 添加酒店注意事项
	 */		
	public String add()throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDateStr = dateFormat.parse(starttimeStr);
		Date endDateStr = dateFormat.parse(endtimeStr);
		
		hotelspec.setHotelid(hotelId);
		hotelspec.setStartdate( new Timestamp(startDateStr.getTime()));
		hotelspec.setEnddate( new Timestamp(endDateStr.getTime()));
		hotelspec.setCreateuser(getLoginUser().getLoginname());
		hotelspec.setCreatetime(new Timestamp(System.currentTimeMillis()));
		hotelspec.setModifyuser(getLoginUser().getLoginname());
		hotelspec.setModifytime(new Timestamp(System.currentTimeMillis()));
		hotelspec.setLanguage(0);
		hotelspec=Server.getInstance().getHotelService().createHotelspec(hotelspec);
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotel.setState(0);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		
		forward = "hotelspec!tabs.action?remotetabs=5&hotelId="+hotelId;
		//this.addActionMessage("您的操作已成功！");
		return "forward";
	}

	/**
	 * 审核酒店注意事项
	 */		
	public String check()throws Exception{
		hotelspec.setModifyuser(getLoginUser().getLoginname());
		hotelspec.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getHotelService().updateHotelspecIgnoreNull(hotelspec);
		return LIST;
	}
	


	/**
	 * 编辑酒店注意事项
	 */		
	public String edit()throws Exception{
		//hotelId = hotelspec.getHotelid();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDateStr = dateFormat.parse(starttimeStr);
		Date endDateStr = dateFormat.parse(endtimeStr);
		hotelspec.setHotelid(hotelId);
		hotelspec.setStartdate( new Timestamp(startDateStr.getTime()));
		hotelspec.setEnddate( new Timestamp(endDateStr.getTime()));
		hotelspec.setModifyuser(getLoginUser().getLoginname());
		hotelspec.setModifytime(new Timestamp(System.currentTimeMillis()));
		hotelspec.setLanguage(0);
		Server.getInstance().getHotelService().findHotelspec(hotelspec.getId());
		
		hotelspec.setModifyuser(getLoginUser().getLoginname());
		hotelspec.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getHotelService().updateHotelspecIgnoreNull(hotelspec);
		hotelId=hotelspec.getHotelid();
		//System.out.println("HotelspecAction--------------hotelId -------:"+hotelId);
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotel.setState(0);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		//this.addActionMessage("您的操作已成功！");
		//return EDIT;
		forward = "hotelspec!tabs.action?remotetabs=5&hotelId="+hotelId;
		//this.addActionMessage("您的操作已成功！");
		return "forward2";
	}

	/**
	 * 删除酒店注意事项
	 */		
	public String delete()throws Exception{	
		System.out.println("注意事项-----------delete()--hotelId:"+hotelId);
		Server.getInstance().getHotelService().deleteHotelspec(hotelspec.getId());
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
					Server.getInstance().getHotelService().deleteHotelspec(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回酒店注意事项对象
	 */		
	
	public Object getModel() {
		return hotelspec;
	}
	public List < Hotelspec >   getListHotelspec() {
		return listHotelspec;
	}
	public void setListHotelspec(List <  Hotelspec  >  listHotelspec) {
		this.listHotelspec = listHotelspec;
	}
	public Hotelspec getHotelspec() {
		return hotelspec;
	}
	public void setHotelspec(Hotelspec hotelspec) {
		this.hotelspec = hotelspec;
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
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String getEndtimeStr() {
		return endtimeStr;
	}
	public void setEndtimeStr(String endtimeStr) {
		this.endtimeStr = endtimeStr;
	}
	public String getStarttimeStr() {
		return starttimeStr;
	}
	public void setStarttimeStr(String starttimeStr) {
		this.starttimeStr = starttimeStr;
	}
	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
	}
	
	
}