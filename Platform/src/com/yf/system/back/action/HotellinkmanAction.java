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
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotellinkman.Hotellinkman;
import com.yf.system.base.util.PageInfo;

public class HotellinkmanAction extends B2b2cbackAction {
	private List <  Hotellinkman  >  listHotellinkman;
	private Hotellinkman hotellinkman = new Hotellinkman();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//酒店的ID
	private Long hotelId ;
	
	//酒店名字
	private String hotelName;
	
	//联系人性别
	private Integer sex;
	
	//联系人姓名
	private String h_linkname;
	//search
	//private String s_name;
	
	private Hotel hotel;
	
	private String forward;
	
	/**
	 * 根据酒店的ID列表查询酒店联系人
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if(hotelId != null && hotelId.longValue() > 0) {
			where += " AND " + Hotellinkman.COL_hotelid + "=" + hotelId.longValue() ;
			List list = Server.getInstance().getHotelService().findAllHotellinkmanForPageinfo(where, " ORDER BY " + Hotellinkman.COL_id, pageinfo) ;
			pageinfo = (PageInfo)list.remove(0);
			listHotellinkman = list;
		}if(h_linkname != null && h_linkname.trim().length() != 0) {
			where += " AND " + Hotellinkman.TABLE + "." + Hotellinkman.COL_name + " LIKE '%" + h_linkname + "%'" ;
		}
		return SUCCESS;
	}
	/**
	 * 转向到酒店联系人添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到酒店联系人修改页面
	 */	
	public String toedit()throws Exception{
		System.out.println("-----");
		hotellinkman = Server.getInstance().getHotelService().findHotellinkman(hotellinkman.getId());
		return EDIT;
	}
	
	/**
	 * 转向到酒店联系人审核页面
	 */	
	public String tocheck()throws Exception{
		String where = " where 1=1 ";
		
		if(hotelId != null && hotelId.longValue() > 0) {
			where += " AND " + Hotellinkman.COL_hotelid + "=" + hotelId.longValue() ;
			 List list= Server.getInstance().getHotelService().findAllHotellinkmanForPageinfo(where, " ORDER BY " + Hotellinkman.COL_id, pageinfo) ;
			pageinfo = (PageInfo)list.remove(0);
			listHotellinkman = list;
		}if(h_linkname != null && h_linkname.trim().length() != 0) {
			where += " AND " + Hotellinkman.TABLE + "." + Hotellinkman.COL_name + " LIKE '%" + h_linkname + "%'" ;
		}
	//hotellinkman = Server.getInstance().getHotellinkmanManager().findHotellinkman(hotellinkman.getId());
		return CHECK;
	}
	
	/**
	 * 转向到tabs
	 */		
	public String tabs()throws Exception{	
		return "tabs";
	}

	/**
	 * 转向酒店联系人查看页面
	 */
	public String tolook()throws Exception{
		String where = " where 1=1 ";
		
		if(hotelId != null && hotelId.longValue() > 0) {
			where += " AND " + Hotellinkman.COL_hotelid + "=" + hotelId.longValue() ;
			List list = Server.getInstance().getHotelService().findAllHotellinkmanForPageinfo(where, " ORDER BY " + Hotellinkman.COL_id, pageinfo) ;
			pageinfo = (PageInfo)list.remove(0);
			listHotellinkman = list;
		}if(h_linkname != null && h_linkname.trim().length() != 0) {
			where += " AND " + Hotellinkman.TABLE + "." + Hotellinkman.COL_name + " LIKE '%" + h_linkname + "%'" ;
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
	 * 添加酒店联系人
	 */		
	public String add()throws Exception{
		System.out.println("linkppman..............");
		hotelId = hotellinkman.getHotelid();
		
		System.out.println("联系人-----------add()--hotelid:"+hotelId);
		hotellinkman.setCreatetime(new Timestamp(System.currentTimeMillis()));
		hotellinkman.setCreateuser(getLoginUser().getLoginname());
		hotellinkman.setModifyuser(getLoginUser().getLoginname());
		hotellinkman.setLanguage(0);
		hotellinkman.setModifytime(new Timestamp(System.currentTimeMillis()));
		hotellinkman=Server.getInstance().getHotelService().createHotellinkman(hotellinkman);
		forward = "hotellinkman!tabs.action?remotetabs=7&hotelId="+hotelId;
		this.addActionMessage("您的操作已成功！");
		return "forward";
	}

	/**
	 * 审核酒店联系人 
	 */		
	public String check()throws Exception{
		hotellinkman.setModifyuser(getLoginUser().getLoginname());
		hotellinkman.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getHotelService().updateHotellinkmanIgnoreNull(hotellinkman);
		return LIST;
	}
	
public String toeditlanguage()throws Exception{
		
		Integer lan=hotellinkman.getLanguage();
		Long uco=hotellinkman.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		hotellinkman = Server.getInstance().getHotelService().findHotellinkmanbylanguage(hotellinkman.getUcode(),hotellinkman.getLanguage());
		if(hotellinkman==null)
		{
			hotellinkman=new Hotellinkman();
			hotellinkman.setLanguage(lan);
			hotellinkman.setUcode(uco);
			//以下是toadd参考方法
			
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			
		}
		return EDIT;
	}

	/**
	 * 编辑酒店联系人
	 */		
	public String edit()throws Exception{
		hotelId = hotellinkman.getHotelid();
		hotellinkman.setModifyuser(getLoginUser().getLoginname());
		hotellinkman.setModifytime(new Timestamp(System.currentTimeMillis()));
		hotellinkman.setLanguage(0);
		System.out.println("联系人-----------edit()--hotelid:"+hotelId);
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotel.setState(0);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		Server.getInstance().getHotelService().updateHotellinkmanIgnoreNull(hotellinkman);
		forward = "hotellinkman!tabs.action?remotetabs=7&hotelId="+hotelId;
		this.addActionMessage("您的操作已成功！");
		return "forward2";
	}

	/**
	 * 删除酒店联系人
	 */		
	public String delete()throws Exception{	
		hotelId = hotellinkman.getHotelid();
		System.out.println("联系人-----------delete()--hotelid:"+hotelId);
		hotellinkman.setModifyuser(getLoginUser().getLoginname());
		hotellinkman.setModifytime(new Timestamp(System.currentTimeMillis()));
		Server.getInstance().getHotelService().deleteHotellinkman(hotellinkman.getId());
		return LIST;
	}

	/**
	 * 返回到列表
	 */
	public String goback() throws Exception{
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
					Server.getInstance().getHotelService().deleteHotellinkman(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回酒店联系人对象
	 */		
	
	public Object getModel() {
		return hotellinkman;
	}
	public List < Hotellinkman >   getListHotellinkman() {
		return listHotellinkman;
	}
	public void setListHotellinkman(List <  Hotellinkman  >  listHotellinkman) {
		this.listHotellinkman = listHotellinkman;
	}
	public Hotellinkman getHotellinkman() {
		return hotellinkman;
	}
	public void setHotellinkman(Hotellinkman hotellinkman) {
		this.hotellinkman = hotellinkman;
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
	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
	}
	
	
}