package com.yf.system.back.action;

import java.sql.Timestamp;
import java.util.List;

import com.yf.system.base.city.City;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.province.Province;
import com.yf.system.back.server.Server;

import com.yf.system.base.util.Util;

public class HoteluserAction extends B2b2cbackAction {
	private List <  Customeruser  >  listSystemuser;
	private List <  Hotel  >  listHotel;
	private Customeruser systemuser = new Customeruser();
	private Hotel hotel = new Hotel();

	//批量操作ID数组
	private int[]selectid;
	
	//所有的省
	private List<Province> listProvinces ;
	//所有的市
	private List<City> listCities ;
	
	
	private int s_city=0;
	private int s_province=0;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_name;
	
	/**
	 * 列表查询酒店
	 */	
	public String execute()throws Exception{
		
//		listCities    = Server.getInstance().getCityManager().findAllCity("","ORDER BY ID",-1,0);
//		String where = " where 1=1 ";
//		
//		if (s_name!=null && s_name.trim().length()!=0) {
//			
//			where += " and " + Hotel.COL_name +" like '%" + s_name.trim()+"%'";	
//		}
//		if(s_city >0){
//			where += " and " + Hotel.COL_cityid +"=" + s_city;	
//		}
//		listHotel = Server.getInstance().getHotelManager().findAllHotel(where,"ORDER BY ID",pageinfo);
//		
//		 if(pageinfo.getTotalrow()>0 &&   listHotel.size()==0){
//			pageinfo.setPagenum(1);
//			listHotel = Server.getInstance().getHotelManager().findAllHotel(where," ORDER BY ID ",pageinfo);	
//		}
//		
		
		return SUCCESS;
	}
	/**
	 * 转向到酒店添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到酒店修改页面
	 */	
	public String toedit()throws Exception{
	hotel = Server.getInstance().getHotelService().findHotel(hotel.getId());
		return EDIT;
	}
	
	/**
	 * 转向到酒店用记列表页
	 */	
	/*public String tocheck()throws Exception{
		String where = " where 1=1 ";
		if(hotel.getId()>0){
			where += " and " + Systemuser.COL_hotelid +"="+hotel.getId();
		}else{
			where += " and " + Systemuser.COL_hotelid +">0";
		}
		
		
		if (s_name!=null && s_name.trim().length()!=0) {
			
			where += " and " + Systemuser.COL_username +" like '%" + s_name.trim()+"%'";	
		}
	
		listSystemuser = Server.getInstance().getSystemuserManager().findAllSystemuserForPageinfo(where,"ORDER BY ID",pageinfo);
		
		 if(pageinfo.getTotalrow()>0 &&   listSystemuser.size()==0){
			pageinfo.setPagenum(1);
			listSystemuser = Server.getInstance().getSystemuserManager().findAllSystemuserForPageinfo(where," ORDER BY ID ",pageinfo);	
		}
		
		return "user";
	}
	*/
	
	/**
	 * 添加用户
	 */		
	public String add()throws Exception{
		
		//systemuser.setHotelid(hotel.getId());
		systemuser.setModifytime(new Timestamp(System.currentTimeMillis()));
		systemuser.setModifyuser(getLoginUser().getLoginname());
		systemuser.setCreatetime(new Timestamp(System.currentTimeMillis()));
		systemuser.setCreateuser(getLoginUser().getLoginname());
		systemuser.setLogpassword((Util.MD5(systemuser.getLogpassword())));
		
		Server.getInstance().getMemberService().createCustomeruser(systemuser);
	
		return LIST;
	}

	/**
	 * 审核酒店
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		return LIST;
	}
	


	/**
	 * 编辑酒店
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		return LIST;
	}

	/**
	 * 删除酒店
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteHotel(hotel.getId());
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
					Server.getInstance().getHotelService().deleteHotel(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回酒店对象
	 */		
	
	public Object getModel() {
		return hotel;
	}
	public List < Hotel >   getListHotel() {
		return listHotel;
	}
	public void setListHotel(List <  Hotel  >  listHotel) {
		this.listHotel = listHotel;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
	public List<City> getListCities() {
		return listCities;
	}
	public void setListCities(List<City> listCities) {
		this.listCities = listCities;
	}
	public List<Province> getListProvinces() {
		return listProvinces;
	}
	public void setListProvinces(List<Province> listProvinces) {
		this.listProvinces = listProvinces;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getCityName(long id){
		return Server.getInstance().getHotelService().findCity(id).getName();
	}
	
	public String getProvinceName(long id){
		return Server.getInstance().getHotelService().findProvince(id).getName();
	}
	
	public String getRegionName(long id){
		return Server.getInstance().getHotelService().findRegion(id).getName();
	}
	public int getS_city() {
		return s_city;
	}
	public void setS_city(int s_city) {
		this.s_city = s_city;
	}
	public int getS_province() {
		return s_province;
	}
	public void setS_province(int s_province) {
		this.s_province = s_province;
	}
	
	public List<Customeruser> getListSystemuser() {
		return listSystemuser;
	}
	public void setListSystemuser(List<Customeruser> listSystemuser) {
		this.listSystemuser = listSystemuser;
	}
	public Customeruser getSystemuser() {
		return systemuser;
	}
	public void setSystemuser(Customeruser systemuser) {
		this.systemuser = systemuser;
	}
	/**
	 * 取角色名称
	 */
	public String getRoleName(long id){
		return Server.getInstance().getMemberService().findSystemrole(id).getName();
	}
	/**
	 * 取酒店名称
	 * @param id
	 * @return
	 */
	public String getHotelName(long id){
		return Server.getInstance().getHotelService().findHotel(id).getName();
		
	}
}
