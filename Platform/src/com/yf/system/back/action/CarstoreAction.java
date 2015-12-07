/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.carstore.Carstore;
import com.yf.system.base.city.City;
import com.yf.system.base.region.Region;
import com.yf.system.base.util.PageInfo;


public class CarstoreAction extends B2b2cbackAction {
	private List <  Carstore  >  listCarstore;
	private Carstore carstore = new Carstore();
	private List <  City  >  listCity;
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_name;
	private long C_ScityId;
	private String s_abbname;
	private String s_regionname;
	/**
	 * 列表查询租车门店
	 */	
	public String execute()throws Exception{
		//查询所有的城市
		listCity = Server.getInstance().getHotelService().findAllCity(" where 1=1 and "+City.COL_type+" =2", "ORDER BY " + City.COL_sort, -1, 0) ;
	
		String where = " where 1=1 ";
		
		if (s_name!=null && s_name.trim().length()!=0) {
			
			where += " and " + Carstore.COL_name +" like '%" + s_name.trim()+"%'";	
		}
		if (s_abbname!=null && s_abbname.trim().length()!=0) {
			
			where += " and " + Carstore.COL_abbrname +" like '%" + s_abbname.trim()+"%'";	
		}
		if (s_regionname!=null && s_regionname.trim().length()!=0) {
			where +=" AND "+Carstore.COL_district+" in ( SELECT "+Region.COL_id+" FROM "+Region.TABLE+" where "+Region.COL_name+" like '%" + s_regionname.trim()+"%')";	
			
			//where +="  AND "+Carimages.COL_carid+" in ( SELECT "+Cars.COL_id+" FROM "+Cars.TABLE+" where "+Cars.COL_name +" like '%" + s_name.trim()+"%')";	
			
			//where += " and " + Carstore.COL_abbrname +" like '%" + s_abbname.trim()+"%'";	
		}
		

		if(C_ScityId>0){
		where +=" and "+Carstore.COL_cityid+" ='"+C_ScityId+"'";
		}
	    List list = Server.getInstance().getCarService().findAllCarstoreForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCarstore = list;
		  if(pageinfo.getTotalrow()>0 &&   listCarstore.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getCarService().findAllCarstoreForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCarstore = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到租车门店添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到租车门店修改页面
	 */	
	public String toedit()throws Exception{
	carstore = Server.getInstance().getCarService().findCarstore(carstore.getId());
		return EDIT;
	}
	
	/**
	 * 转向到租车门店审核页面
	 */	
	public String tocheck()throws Exception{
	carstore = Server.getInstance().getCarService().findCarstore(carstore.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加租车门店
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getCarService().createCarstore(carstore);
		return LIST;
	}

	/**
	 * 审核租车门店
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getCarService().updateCarstoreIgnoreNull(carstore);
		return LIST;
	}
	


	/**
	 * 编辑租车门店
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getCarService().updateCarstoreIgnoreNull(carstore);
		return LIST;
	}

	/**
	 * 删除租车门店
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getCarService().deleteCarstore(carstore.getId());
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
					Server.getInstance().getCarService().deleteCarstore(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回租车门店对象
	 */		
	
	public Object getModel() {
		return carstore;
	}
	public List < Carstore >   getListCarstore() {
		return listCarstore;
	}
	public void setListCarstore(List <  Carstore  >  listCarstore) {
		this.listCarstore = listCarstore;
	}
	public Carstore getCarstore() {
		return carstore;
	}
	public void setCarstore(Carstore carstore) {
		this.carstore = carstore;
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
	public List<City> getListCity() {
		return listCity;
	}
	public void setListCity(List<City> listCity) {
		this.listCity = listCity;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public long getC_ScityId() {
		return C_ScityId;
	}
	public void setC_ScityId(long scityId) {
		C_ScityId = scityId;
	}
	public String getS_abbname() {
		return s_abbname;
	}
	public void setS_abbname(String s_abbname) {
		this.s_abbname = s_abbname;
	}
	public String getS_regionname() {
		return s_regionname;
	}
	public void setS_regionname(String s_regionname) {
		this.s_regionname = s_regionname;
	}
	
	
}