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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotellandmark.Hotellandmark;
import com.yf.system.base.landmark.Landmark;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;

public class HotellandmarkAction extends B2b2cbackAction {
	private List  listHotellandmark;
	private Hotellandmark hotellandmark = new Hotellandmark();
	//private List <  Hotel  > listHotel;
	private Hotel hotel = new Hotel();
	private List <  Landmark  > listLandmark;
	private Landmark landmark = new Landmark();
	//酒店的ID
	private Long hotelId;
	
	private String hotelName;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_hotellandmark;
	

	private String forward;
	
	
	/**
	 * 列表查询酒店地标
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		if(hotelId != null && hotelId.longValue()>0){
			where += " AND " +  Hotellandmark.COL_hotelid + "=" + hotelId.longValue();
			listHotellandmark =  Server.getInstance().getHotelService().findAllHotellandmark(where," ORDER BY " + Hotellandmark.COL_id,-1,0);
		
		}
		if (s_hotellandmark!=null && s_hotellandmark.trim().length()!=0) {
			
			where += " AND " + Hotellandmark.COL_description +" like '%" + s_hotellandmark.trim()+"%'";	
		}
		
		List list= Server.getInstance().getHotelService().findAllHotellandmarkForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotellandmark =list;
		 
		 if(pageinfo.getTotalrow()>0 && listHotellandmark.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotellandmarkForPageinfo(where," ORDER BY ID ",pageinfo);	
			pageinfo = (PageInfo) list.remove(0);
			listHotellandmark = list;
			
		}
		
		
		return SUCCESS;
	}
	
	/**
	 * 转向到地级市修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		
		Integer lan=hotellandmark.getLanguage();
		Long uco=hotellandmark.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		hotellandmark = Server.getInstance().getHotelService().findHotellandmarkbylanguage(hotellandmark.getUcode(),hotellandmark.getLanguage());
		if(hotellandmark==null)
		{
			hotellandmark=new Hotellandmark();
			hotellandmark.setLanguage(lan);
			hotellandmark.setUcode(uco);
			//以下是toadd参考方法
			hotel = Server.getInstance().getHotelService().findHotel(hotelId);
			String where = " where " + Landmark.COL_cityid + " = " + hotel.getCityid();
			listLandmark = Server.getInstance().getHotelService().findAllLandmark(where," ORDER BY ID ",-1,0);
			hotelId = hotel.getId();
			hotelName = hotel.getName();
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			//hotellandmark = Server.getInstance().getHotelService().findHotellandmark(hotellandmark.getId());
			landmark = Server.getInstance().getHotelService().findLandmark(hotellandmark.getLandmarkid());
			hotel = Server.getInstance().getHotelService().findHotel(hotellandmark.getHotelid());
			//listHotel = Server.getInstance().getHotelManager().findAllHotel(""," ORDER BY ID",-1,0);
			hotelId = hotel.getId();
			hotelName = hotel.getName();
			String where = " where " + Landmark.COL_cityid + " = " + hotel.getCityid();
			listLandmark = Server.getInstance().getHotelService().findAllLandmark(where," ORDER BY ID ",-1,0);
		}
		return EDIT;
	}
	/**
	 * 转向到酒店地标添加页面
	 */	
	public String toadd()throws Exception{
		//listHotel = Server.getInstance().getHotelManager().findAllHotel("","ORDER BY ID",-1,0);
		//listLandmark = Server.getInstance().getLandmarkManager().findAllLandmark(""," ORDER BY ID",-1,0);
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		String where = " where " + Landmark.COL_cityid + " = " + hotel.getCityid()+" and "+Landmark.COL_language+" ="+hotel.getLanguage();
		listLandmark = Server.getInstance().getHotelService().findAllLandmark(where," ORDER BY ID ",-1,0);
		hotelId = hotel.getId();
		hotelName = hotel.getName();
		return EDIT;
	}
	/**
	 * 转向到酒店地标修改页面
	 */	
	public String toedit()throws Exception{
	hotellandmark = Server.getInstance().getHotelService().findHotellandmark(hotellandmark.getId());
	landmark = Server.getInstance().getHotelService().findLandmark(hotellandmark.getLandmarkid());
	hotel = Server.getInstance().getHotelService().findHotel(hotellandmark.getHotelid());
	//listHotel = Server.getInstance().getHotelManager().findAllHotel(""," ORDER BY ID",-1,0);
	hotelId = hotel.getId();
	hotelName = hotel.getName();
	String where = " where " + Landmark.COL_cityid + " = " + hotel.getCityid()+" and "+Landmark.COL_language+" ="+hotel.getLanguage();
	listLandmark = Server.getInstance().getHotelService().findAllLandmark(where," ORDER BY ID ",-1,0);
	
	return EDIT;
	}
	
	/**
	 * 转向到酒店地标审核页面
	 */	
	public String tocheck()throws Exception{

		String where = " where 1=1 ";
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		if(hotelId != null && hotelId.longValue()>0){
			where += " AND " +  Hotellandmark.COL_hotelid + "=" + hotelId.longValue();
			listHotellandmark =  Server.getInstance().getHotelService().findAllHotellandmark(where," ORDER BY " + Hotellandmark.COL_id,-1,0);
		}
		if (s_hotellandmark!=null && s_hotellandmark.trim().length()!=0) {
			
			where += " AND " + Hotellandmark.COL_description +" like '%" + s_hotellandmark.trim()+"%'";	
		}
	
		List list = Server.getInstance().getHotelService().findAllHotellandmarkForPageinfo(where,"ORDER BY ID ",pageinfo);
		 pageinfo =(PageInfo)list.remove(0);
		 listHotellandmark =list;
		 if(pageinfo.getTotalrow()>0 && listHotellandmark.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotellandmarkForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo =(PageInfo)list.remove(0);
			listHotellandmark =list;
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
	 * 转向酒店地标查看页面
	 */
	public String tolook()throws Exception{
		String where = " where 1=1 ";
		if(hotelId != null && hotelId.longValue()>0){
			where += " AND " +  Hotellandmark.COL_hotelid + "=" + hotelId.longValue();
			listHotellandmark =  Server.getInstance().getHotelService().findAllHotellandmark(where," ORDER BY " + Hotellandmark.COL_id,-1,0);
		}
		if (s_hotellandmark!=null && s_hotellandmark.trim().length()!=0) {
			
			where += " AND " + Hotellandmark.COL_description +" like '%" + s_hotellandmark.trim()+"%'";	
		}
	
		List list = Server.getInstance().getHotelService().findAllHotellandmarkForPageinfo(where,"ORDER BY ID ",pageinfo);
		pageinfo =(PageInfo)list.remove(0);
		listHotellandmark =list;
		 if(pageinfo.getTotalrow()>0 && listHotellandmark.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotellandmarkForPageinfo(where," ORDER BY ID ",pageinfo);	
			pageinfo =(PageInfo)list.remove(0);
			listHotellandmark =list;
		}
		
		return "look";
	}
	
	/**
	 * 添加酒店地标
	 */		
	public String add()throws Exception{
		
		
		System.out.println("地标-----------------add():"+hotelId);
		hotellandmark.setHotelid(hotelId);	
		hotellandmark.setLanguage(0);
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotel.setState(0);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);		
		hotellandmark=Server.getInstance().getHotelService().createHotellandmark(hotellandmark);
		forward = "hotellandmark!tabs.action?remotetabs=6&hotelId="+hotelId;
		this.addActionMessage("您的操作已成功！");
		return "forward";
	}

	/**
	 * 审核酒店地标
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateHotellandmarkIgnoreNull(hotellandmark);
		return LIST;
	}
	


	/**
	 * 编辑酒店地标
	 */		
	public String edit()throws Exception{
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotel.setState(0);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		hotellandmark.setLanguage(0);
		Server.getInstance().getHotelService().updateHotellandmarkIgnoreNull(hotellandmark);
		forward = "hotellandmark!tabs.action?remotetabs=6&hotelId="+hotelId;
		this.addActionMessage("您的操作已成功！");
		return "forward2";
	}

	/**
	 * 删除酒店地标
	 */		
	public String delete()throws Exception{	
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotel.setState(0);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		Server.getInstance().getHotelService().deleteHotellandmark(hotellandmark.getId());
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
					Server.getInstance().getHotelService().deleteHotellandmark(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}
	
	/**
	 * 根据id查询酒店地标名称
	 * @param id
	 * @return 酒店地标名称
	 */
	public String getHotelLandNameById(Long id)
	{
		hotellandmark = Server.getInstance().getHotelService().findHotellandmark(id);
		return Server.getInstance().getHotelService().findLandmark(hotellandmark.getLandmarkid()).getName();
	}
	
	/**
	 * 判断酒店地标是否存在
	 * @throws IOException 
	 */
	
	public void IsExistLandMark() throws IOException{
		
		long mid = hotellandmark.getLandmarkid();
		long hid = hotellandmark.getHotelid();
		System.out.println("地标id:"+mid+",酒店id:"+hid);
		String where = " where "+ Hotellandmark.COL_hotelid +"="+hid+" AND "+Hotellandmark.COL_landmarkid  +"="+mid;
		List<Hotellandmark> list = Server.getInstance().getHotelService().findAllHotellandmark(where, "", -1, 0);
		System.out.print(list.size()+"$$$$$$$");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if(list != null && list.size() >0){
			out.print("t");
		}else{
			out.print("f");
		}
		
	}
	
	/**
	 * 根据酒店id查询酒店名称
	 */
	public String gethotelNamebyId(long id){
		return Server.getInstance().getHotelService().findHotel(id).getName();
	}
	
	/**
	 *  返回酒店地标对象
	 */		
	
	public Object getModel() {
		return hotellandmark;
	}
	public List < Hotellandmark >   getListHotellandmark() {
		return listHotellandmark;
	}
	public void setListHotellandmark(List <  Hotellandmark  >  listHotellandmark) {
		this.listHotellandmark = listHotellandmark;
	}
	public Hotellandmark getHotellandmark() {
		return hotellandmark;
	}
	public void setHotellandmark(Hotellandmark hotellandmark) {
		this.hotellandmark = hotellandmark;
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
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
//	public List<Hotel> getListHotel() {
//		return listHotel;
//	}
//	public void setListHotel(List<Hotel> listHotel) {
//		this.listHotel = listHotel;
//	}
	public Landmark getLandmark() {
		return landmark;
	}
	public void setLandmark(Landmark landmark) {
		this.landmark = landmark;
	}
	public List<Landmark> getListLandmark() {
		return listLandmark;
	}
	public void setListLandmark(List<Landmark> listLandmark) {
		this.listLandmark = listLandmark;
	}
	public String getS_hotellandmark() {
		return s_hotellandmark;
	}
	public void setS_hotellandmark(String s_hotellandmark) {
		this.s_hotellandmark = s_hotellandmark;
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
	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
	}

	
	
}