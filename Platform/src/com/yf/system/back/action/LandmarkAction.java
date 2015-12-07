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
import java.util.ArrayList;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.city.City;
import com.yf.system.base.landmark.Landmark;
import com.yf.system.base.province.Province;
import com.yf.system.base.region.Region;
import com.yf.system.base.util.PageInfo;

public class LandmarkAction extends B2b2cbackAction {
	private List  listLandmark;
	private Landmark landmark = new Landmark();
	private List <  City  > listCity;
	private City city = new City();
	private List <Region> listRegion;
	private Region region = new Region();
	private List<City> allCity = new ArrayList<City>();
	private Province pc = new Province();
	private List<Region> defaultregion = new ArrayList<Region>();
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_landmark;
	
	private String s_city;
	private int s_landterm1;

	
	/**
	 * 列表查询地标
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		if (s_landmark!=null && s_landmark.trim().length()!=0) {
			if(s_landterm1 == 1)
			{
				where += " and " + Landmark.COL_name +" like '%" + s_landmark.trim()+"%'";	
			}
			if(s_landterm1 == 2)
			{
				listCity = Server.getInstance().getHotelService().findAllCity(" where " + City.COL_name +" like '%" + s_landmark.trim()+"%'"
						+ " or "  + City.COL_enname +" like '%" + s_landmark.trim().toUpperCase()+"%'"+ " or "  + City.COL_sname +" like '%" + s_landmark.trim().toUpperCase()+"%'"," ORDER BY ID",-1,0);
				if(listCity != null && listCity.size()>0)
				{
					where += " and " + Landmark.COL_cityid +" = " + listCity.get(0).getId();
				}
			}
			if(s_landterm1 == 3)
			{
				listRegion = Server.getInstance().getHotelService().findAllRegion(" where " + Region.COL_name +" like '%" + s_landmark.trim()+"%'"
						+ " or "  + Region.COL_name +" like '%" + s_landmark.trim().toUpperCase()+"%'"+ " or "  + Region.COL_name +" like '%" + s_landmark.trim().toUpperCase()+"%'"," ORDER BY ID",-1,0);
				if(listRegion != null && listRegion.size()>0)
				{
					where += " and " + Landmark.COL_regionid +" = " + listRegion.get(0).getId();
				}
			}
		}
		listLandmark = Server.getInstance().getHotelService().findAllLandmarkForPageinfo(where," ORDER BY ID",pageinfo);
		
		 if(pageinfo.getTotalrow()>0 &&   listLandmark.size()==0){
			pageinfo.setPagenum(1);
			listLandmark = Server.getInstance().getHotelService().findAllLandmarkForPageinfo(where,"  ORDER BY ID ",pageinfo);	
		}
		pageinfo = (PageInfo) listLandmark.get(0) ;
		listLandmark.remove(0) ;
		
		return SUCCESS;
	}
	/**
	 * 转向到地级市修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		
		Integer lan=landmark.getLanguage();
		Long uco=landmark.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		landmark = Server.getInstance().getHotelService().findLandmarkbylanguage(landmark.getUcode(),landmark.getLanguage());
		if(landmark==null)
		{
			landmark=new Landmark();
			landmark.setLanguage(lan);
			landmark.setUcode(uco);
			//以下是toadd参考方法
			allCity = Server.getInstance().getHotelService().findAllCity(""," ORDER BY ID",-1,0);
			listCity = Server.getInstance().getHotelService().findAllCity(" where 1=1 and " + city.COL_provinceid + " = " + allCity.get(0).getProvinceid() ," ORDER BY ID",-1,0);
			pc = Server.getInstance().getHotelService().findProvince(allCity.get(0).getProvinceid());
			defaultregion = Server.getInstance().getHotelService().findAllRegion(" where 1=1 and " + region.COL_type + "= '" + "行政区' and " + region.COL_cityid + " = " + allCity.get(0).getId() ," ORDER BY ID",-1,0);
			listRegion = Server.getInstance().getHotelService().findAllRegion(""," ORDER BY ID",-1,0);
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			
			landmark = Server.getInstance().getHotelService().findLandmark(landmark.getId());
			city = Server.getInstance().getHotelService().findCity(landmark.getCityid());
			region = Server.getInstance().getHotelService().findRegion(landmark.getCityid());
			listCity = Server.getInstance().getHotelService().findAllCity(" where 1=1 and " + city.COL_provinceid + " = " + city.getProvinceid() ," ORDER BY ID",-1,0);
			allCity = Server.getInstance().getHotelService().findAllCity(""," ORDER BY ID",-1,0);
			String retype = "行政区";
			if(region != null)
			{
				retype = region.getType();
			}
			defaultregion = Server.getInstance().getHotelService().findAllRegion(" where 1=1 and " + region.COL_type + "= '" +retype+ "' and " + region.COL_cityid + " = " + landmark.getCityid() ," ORDER BY ID",-1,0);
			listRegion = Server.getInstance().getHotelService().findAllRegion(""," ORDER BY ID",-1,0);
		}
		return EDIT;
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
	 * @param 区域id
	 * @return 区域名称
	 */
	public String getRegionIdByName(Long id)
	{
		return Server.getInstance().getHotelService().findRegion(id).getName();
	}
	/**
	 * @param 区域id
	 * @return 区域类型
	 */
	public String getRegionIdByType(Long id)
	{
		return Server.getInstance().getHotelService().findRegion(id).getType();
	}
	/**
	 * 转向到地标添加页面
	 */	
	public String toadd()throws Exception{
		allCity = Server.getInstance().getHotelService().findAllCity(""," ORDER BY ID",-1,0);
		listCity = Server.getInstance().getHotelService().findAllCity(" where 1=1 and " + city.COL_provinceid + " = " + allCity.get(0).getProvinceid() ," ORDER BY ID",-1,0);
		pc = Server.getInstance().getHotelService().findProvince(allCity.get(0).getProvinceid());
		defaultregion = Server.getInstance().getHotelService().findAllRegion(" where 1=1 and " + region.COL_type + "= '" + "行政区' and " + region.COL_cityid + " = " + allCity.get(0).getId() ," ORDER BY ID",-1,0);
		listRegion = Server.getInstance().getHotelService().findAllRegion(""," ORDER BY ID",-1,0);
		return EDIT;
	}
	/**
	 * 转向到地标修改页面
	 */	
	public String toedit()throws Exception{
		landmark = Server.getInstance().getHotelService().findLandmark(landmark.getId());
		city = Server.getInstance().getHotelService().findCity(landmark.getCityid());
		region = Server.getInstance().getHotelService().findRegion(landmark.getCityid());
		listCity = Server.getInstance().getHotelService().findAllCity(" where 1=1 and " + city.COL_provinceid + " = " + city.getProvinceid() ," ORDER BY ID",-1,0);
		allCity = Server.getInstance().getHotelService().findAllCity(""," ORDER BY ID",-1,0);
		String retype = "行政区";
		if(region != null)
		{
			retype = region.getType();
		}
		defaultregion = Server.getInstance().getHotelService().findAllRegion(" where 1=1 and " + region.COL_type + "= '" +retype+ "' and " + region.COL_cityid + " = " + landmark.getCityid() ," ORDER BY ID",-1,0);
		listRegion = Server.getInstance().getHotelService().findAllRegion(""," ORDER BY ID",-1,0);
		return EDIT;
	}
	
	/**
	 * 转向到地标审核页面
	 */	
	public String tocheck()throws Exception{
	landmark = Server.getInstance().getHotelService().findLandmark(landmark.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加地标
	 */		
	public String add()throws Exception{
	
		landmark=Server.getInstance().getHotelService().createLandmark(landmark);
		this.addActionMessage("您的操作已成功！");
		return LIST;
	}

	/**
	 * 审核地标
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateLandmarkIgnoreNull(landmark);
		return LIST;
	}
	


	/**
	 * 编辑地标
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getHotelService().updateLandmarkIgnoreNull(landmark);
		this.addActionMessage("您的操作已成功！");
		return LIST;
	}

	/**
	 * 删除地标
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteLandmark(landmark.getId());
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
					Server.getInstance().getHotelService().deleteLandmark(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
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
	 * 返回省份集合
	 * @return
	 */
	public List<Province> findAllPro()
	{
		return Server.getInstance().getHotelService().findAllProvince(""," ORDER BY ID",-1,0);
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
	 *  返回地标对象
	 */		
	
	public Object getModel() {
		return landmark;
	}
	public List < Landmark >   getListLandmark() {
		return listLandmark;
	}
	public void setListLandmark(List <  Landmark  >  listLandmark) {
		this.listLandmark = listLandmark;
	}
	public Landmark getLandmark() {
		return landmark;
	}
	public void setLandmark(Landmark landmark) {
		this.landmark = landmark;
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
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public List<City> getListCity() {
		return listCity;
	}
	public void setListCity(List<City> listCity) {
		this.listCity = listCity;
	}
	public String getS_landmark() {
		return s_landmark;
	}
	public void setS_landmark(String s_landmark) {
		this.s_landmark = s_landmark;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public List<Region> getListRegion() {
		return listRegion;
	}
	public void setListRegion(List<Region> listRegion) {
		this.listRegion = listRegion;
	}
	public String getS_city() {
		return s_city;
	}
	public void setS_city(String s_city) {
		this.s_city = s_city;
	}
	public int getS_landterm1() {
		return s_landterm1;
	}
	public void setS_landterm1(int s_landterm1) {
		this.s_landterm1 = s_landterm1;
	}
	public Province getPc() {
		return pc;
	}
	public void setPc(Province pc) {
		this.pc = pc;
	}
	public List<City> getAllCity() {
		return allCity;
	}
	public void setAllCity(List<City> allCity) {
		this.allCity = allCity;
	}
	public List<Region> getDefaultregion() {
		return defaultregion;
	}
	public void setDefaultregion(List<Region> defaultregion) {
		this.defaultregion = defaultregion;
	}

	
}