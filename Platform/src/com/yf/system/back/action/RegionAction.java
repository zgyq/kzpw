/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/14 创建
 *
 */
 
package com.yf.system.back.action;
import java.util.ArrayList;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.city.City;
import com.yf.system.base.province.Province;
import com.yf.system.base.region.Region;
import com.yf.system.base.util.PageInfo;

public class RegionAction extends B2b2cbackAction {
	private List  listRegion;
	private Region region = new Region();
	private List <City> listCity = new ArrayList<City>();
	private City city1 = new City();
	private List<City> allCity = new ArrayList<City>();
	private Province pc = new Province();
	private List<Region> listRegbytype = new ArrayList<Region>();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_region;
	private int s_hotellandterm1;
	
	/**
	 * 列表查询区县
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		if (s_region!=null && s_region.trim().length()!=0) {
			if(s_hotellandterm1 == 1){
				where += " and " + Region.COL_name +" like '%" + s_region.trim()+"%'";	
			}
			if(s_hotellandterm1 == 2){
				listCity = Server.getInstance().getHotelService().findAllCity(" where " + City.COL_name +" like '%" + s_region.trim()+"%'"
						+ " or "  + City.COL_enname +" like '%" + s_region.trim().toUpperCase()+"%'"+ " or "  + City.COL_sname +" like '%" + s_region.trim().toUpperCase()+"%'"," ORDER BY ID",-1,0);
				if(listCity != null && listCity.size()>0)
				{
					where += " and " + Region.COL_cityid +" = " + listCity.get(0).getId();
				}
			}
		}
	
		listRegion = Server.getInstance().getHotelService().findAllRegionForPageinfo(where," ORDER BY ID",pageinfo);
		
		 if(pageinfo.getTotalrow()>0 &&   listRegion.size()==0){
			pageinfo.setPagenum(1);
			listRegion = Server.getInstance().getHotelService().findAllRegionForPageinfo(where," ORDER BY ID ",pageinfo);	
		}
		pageinfo = (PageInfo) listRegion.get(0) ;
		listRegion.remove(0) ;
		return SUCCESS;
	}
	/**
	 * @param 城市id
	 * @return 城市名称
	 */
	public String getCityIdByName(Long id)
	{
		return Server.getInstance().getHotelService().findCity(id).getName();
	}
	/**
	 * 返回省份集合
	 * @return
	 */
	public List<Province> findAllPro()
	{
		return Server.getInstance().getHotelService().findAllProvince(""," ORDER BY ID",-1,0);
	}
public String toeditlanguage()throws Exception{
		
		Integer lan=region.getLanguage();
		Long uco=region.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		region = Server.getInstance().getHotelService().findRegionbylanguage(region.getUcode(),region.getLanguage());
		if(region==null)
		{
			region=new Region();
			region.setLanguage(lan);
			region.setUcode(uco);
			//以下是toadd参考方法
			allCity = Server.getInstance().getHotelService().findAllCity(""," ORDER BY ID",-1,0);
			listCity = Server.getInstance().getHotelService().findAllCity(" where 1=1 and " + City.COL_provinceid + " = " + allCity.get(0).getProvinceid() ," ORDER BY ID",-1,0);
			pc = Server.getInstance().getHotelService().findProvince(allCity.get(0).getProvinceid());
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			region = Server.getInstance().getHotelService().findRegion(region.getId());
			allCity = Server.getInstance().getHotelService().findAllCity(""," ORDER BY ID",-1,0);
			city1 = Server.getInstance().getHotelService().findCity(region.getCityid());
			listCity = Server.getInstance().getHotelService().findAllCity(" where 1=1 and " + City.COL_provinceid + " = " + city1.getProvinceid() ," ORDER BY ID",-1,0);
			listRegbytype = Server.getInstance().getHotelService().findAllRegion(" where 1=1 and " + region.COL_cityid + " = " + region.getCityid()+ " and " + region.COL_type + " = '" +"行政区'" ," ORDER BY ID",-1,0);
		}
		return EDIT;
	}
	/**
	 * 返回城市集合
	 * @return
	 */
	public List<City> findAllCity()
	{
		return Server.getInstance().getHotelService().findAllCity(""," ORDER BY ID",-1,0);
	}
	/**
	 * 转向到区县添加页面
	 */	
	public String toadd()throws Exception{
		allCity = Server.getInstance().getHotelService().findAllCity(" where 1=1 AND "+City.COL_provinceid+" is not null "," ORDER BY ID",-1,0);
		listCity = Server.getInstance().getHotelService().findAllCity(" where 1=1 and " + City.COL_provinceid + " = " + allCity.get(0).getProvinceid() ," ORDER BY ID",-1,0);
		pc = Server.getInstance().getHotelService().findProvince(allCity.get(0).getProvinceid());
		listRegbytype = Server.getInstance().getHotelService().findAllRegion(" where 1=1 and " + region.COL_cityid + " = " + region.getCityid()+ " and " + region.COL_type + " = '" +"行政区'" ," ORDER BY ID",-1,0);
		
		return EDIT;
	}
	/**
	 * 转向到区县修改页面
	 */	
	public String toedit()throws Exception{
	region = Server.getInstance().getHotelService().findRegion(region.getId());
	allCity = Server.getInstance().getHotelService().findAllCity(" where 1=1 AND "+City.COL_provinceid+" is not null "," ORDER BY ID",-1,0);
	city1 = Server.getInstance().getHotelService().findCity(region.getCityid());
	listCity = Server.getInstance().getHotelService().findAllCity(" where 1=1 and " + City.COL_provinceid + " = " + city1.getProvinceid() ," ORDER BY ID",-1,0);
	listRegbytype = Server.getInstance().getHotelService().findAllRegion(" where 1=1 and " + region.COL_cityid + " = " + region.getCityid()+ " and " + region.COL_type + " = '" +"行政区'" ," ORDER BY ID",-1,0);
	return EDIT;
	}
	
	/**
	 * 转向到区县审核页面
	 */	
	public String tocheck()throws Exception{
	region = Server.getInstance().getHotelService().findRegion(region.getId());
		return CHECK;
	}
	/**
	 * @param cityid
	 * @return
	 * 根据城市id得到省份id
	 */
	public Long getProid(Long cityid)
	{
		return Server.getInstance().getHotelService().findCity(cityid).getProvinceid();
	}
	
	/**
	 * 添加区县
	 */		
	public String add()throws Exception{
	
		region=Server.getInstance().getHotelService().createRegion(region);
		this.addActionMessage("您的操作已成功！");
		return LIST;
	}

	/**
	 * 审核区县
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateRegionIgnoreNull(region);
		return LIST;
	}
	


	/**
	 * 编辑区县
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getHotelService().updateRegionIgnoreNull(region);
		this.addActionMessage("您的操作已成功！");
		return LIST;
	}

	/**
	 * 删除区县
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteRegion(region.getId());
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
					Server.getInstance().getHotelService().deleteRegion(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}

	//根据区域id得到区域名称
	public String getRegionNameById(long id)
	{
		if(id == 0)
		{
			return "信息不详";
		}
		return Server.getInstance().getHotelService().findRegion(id).getName();
	}




	/**
	 *  返回区县对象
	 */		
	
	public Object getModel() {
		return region;
	}
	public List < Region >   getListRegion() {
		return listRegion;
	}
	public void setListRegion(List <  Region  >  listRegion) {
		this.listRegion = listRegion;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
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
	public String getS_region() {
		return s_region;
	}
	public void setS_region(String s_region) {
		this.s_region = s_region;
	}
	public int getS_hotellandterm1() {
		return s_hotellandterm1;
	}
	public void setS_hotellandterm1(int s_hotellandterm1) {
		this.s_hotellandterm1 = s_hotellandterm1;
	}
	public List<City> getAllCity() {
		return allCity;
	}
	public void setAllCity(List<City> allCity) {
		this.allCity = allCity;
	}
	public Province getPc() {
		return pc;
	}
	public void setPc(Province pc) {
		this.pc = pc;
	}
	public List<Region> getListRegbytype() {
		return listRegbytype;
	}
	public void setListRegbytype(List<Region> listRegbytype) {
		this.listRegbytype = listRegbytype;
	}
	public City getCity1() {
		return city1;
	}
	public void setCity1(City city1) {
		this.city1 = city1;
	}
	
	
}