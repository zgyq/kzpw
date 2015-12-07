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
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.yf.system.back.server.Server;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.roomtype.Roomtype;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;




public class RoomtypeAction extends B2b2cbackAction {
	private List   listRoomtype;
	private Roomtype roomtype = new Roomtype();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//酒店的ID
	private  Long hotelId;
	
	//酒店的名字
	private Hotel hotel = new Hotel();
	
	private String forward;
	
	//search
	//private String s_name;
	
	
	
	/**
	 * 列表查询酒店房型
	 */	
	public String execute()throws Exception{
		
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Roomtype.COL_name +" like '%" + s_name.trim()+"%'";	
		//}	
		if(hotelId != null && hotelId.longValue() > 0 ) {
			hotel = Server.getInstance().getHotelService().findHotel(hotelId);
			where += " AND " + Roomtype.COL_hotelid + "=" + hotelId.longValue() ;
			List list = Server.getInstance().getHotelService().findAllRoomtypeForPageinfo(where, " ORDER BY ID ", pageinfo);
			pageinfo =(PageInfo)list.remove(0);
			listRoomtype = list;
		}		
		return SUCCESS;
	}
	
	/**
	 * 房型禁用
	 */
	
	public String jinyong(){
		roomtype.setState(0);
		Server.getInstance().getHotelService().updateRoomtypeIgnoreNull(roomtype);
		return LIST;
	}
	/**
	 * 房型启用
	 */
	public String qiyong(){
		roomtype.setState(1);
		Server.getInstance().getHotelService().updateRoomtypeIgnoreNull(roomtype);
		return LIST;
	}
	/**
	 * 转向到酒店房型添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	
public String toeditlanguage()throws Exception{
		
		Integer lan=roomtype.getLanguage();
		Long uco=roomtype.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		roomtype = Server.getInstance().getHotelService().findRoomtypebylanguage(roomtype.getUcode(),roomtype.getLanguage());
		if(roomtype==null)
		{
			roomtype=new Roomtype();
			roomtype.setLanguage(lan);
			roomtype.setUcode(uco);
			//以下是toadd参考方法
		
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			
		}
		return EDIT;
	}
	/**
	 * 转向到酒店房型修改页面
	 */	
	public String toedit()throws Exception{
		
	roomtype = Server.getInstance().getHotelService().findRoomtype(roomtype.getId());
		return EDIT;
	}
	/**
	 * 转向酒店房型查看页面
	 */
	public String tolook()throws Exception{
		String where =" where 1=1 ";
		if(hotelId != null && hotelId.longValue() > 0) {
			hotel = Server.getInstance().getHotelService().findHotel(hotelId);
			where += " AND " + Roomtype.COL_hotelid + "=" + hotelId.longValue() ;
			List list = Server.getInstance().getHotelService().findAllRoomtypeForPageinfo(where,"ORDER BY "+Roomtype.COL_id,pageinfo) ;
			pageinfo =(PageInfo)list.remove(0);
			listRoomtype=list;
			
		}
		return "look";
	}
	/**
	 * 转向到酒店房型审核页面
	 */	
	public String tocheck()throws Exception{
			
		String where = " where 1=1 ";
				
		if(hotelId != null && hotelId.longValue() > 0) {
			hotel = Server.getInstance().getHotelService().findHotel(hotelId);
			where += " AND " + Roomtype.COL_hotelid + "=" + hotelId.longValue() ;
			List list = Server.getInstance().getHotelService().findAllRoomtypeForPageinfo(where,"ORDER BY "+Roomtype.COL_id,pageinfo) ;
			pageinfo =(PageInfo)list.remove(0);
			listRoomtype=list;
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
	 * 添加酒店房型
	 */		
	public String add()throws Exception{
		hotelId= roomtype.getHotelid();
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotel.setState(0);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		roomtype.setState(1);
		roomtype.setLanguage(0);
		roomtype=Server.getInstance().getHotelService().createRoomtype(roomtype);
		forward = "roomtype!tabs.action?remotetabs=3&hotelId="+hotelId;
		
		return "forward";
		//return LIST;
	}

	/**
	 * 审核酒店房型
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateRoomtypeIgnoreNull(roomtype);
		return LIST;
	}
	
	public String findByTypeName() throws Exception {

		String name = roomtype.getName().trim();
		name = new String(name.getBytes("GBK"),"UTF-8");
		name = name.substring(0,(name.length()-1));
		
		List<Roomtype> roomtypes = Server.getInstance().getHotelService().findAllRoomtype(" WHERE " + Roomtype.COL_name + 
				"='" + name + "' AND " + Roomtype.COL_hotelid + "=" + roomtype.getHotelid()
				, "" , -1, 0) ;
		HttpServletResponse response = ServletActionContext.getResponse() ;
		response.setContentType("text/blank") ;
		PrintWriter out = response.getWriter() ;
		if(roomtypes != null && roomtypes.size() > 0) {
			out.print("true") ;
		} else {
			out.print("false") ;
		}
		out.flush() ;
		out.close() ;
		return null ;
	}
	
	/**
	 * 编辑酒店房型
	 */		
	public String edit()throws Exception{
		hotelId= roomtype.getHotelid();
		roomtype.setState(1);
		roomtype.setLanguage(0);
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotel.setState(0);
		Server.getInstance().getHotelService().updateRoomtypeIgnoreNull(roomtype);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		forward = "roomtype!tabs.action?remotetabs=3&hotelId="+hotelId;
		
		return "forward2";
	}

	/**
	 * 删除酒店房型
	 */		
	public String delete()throws Exception{	
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotel.setState(0);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		Server.getInstance().getHotelService().deleteRoomtype(roomtype.getId());
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
					Server.getInstance().getHotelService().deleteRoomtype(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}

	/**
	 * 
	 *返回列表
	 */
	public String goback() throws Exception{
			return LIST;
	}



	/**
	 *  返回酒店房型对象
	 */		
	
	public Object getModel() {
		return roomtype;
	}
	public List < Roomtype >   getListRoomtype() {
		return listRoomtype;
	}
	public void setListRoomtype(List <  Roomtype  >  listRoomtype) {
		this.listRoomtype = listRoomtype;
	}
	public Roomtype getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(Roomtype roomtype) {
		this.roomtype = roomtype;
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