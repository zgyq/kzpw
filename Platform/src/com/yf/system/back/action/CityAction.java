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
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.city.City;
import com.yf.system.base.province.Province;
import com.yf.system.base.util.PageInfo;




public class CityAction extends B2b2cbackAction {
	private List  listCity;
	private City city = new City();
	private List <  Province> listProvince;
	private Province province = new Province ();
	private String s_cityid;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_city;
	
	private int s_cityterm1 ;
	/**
	 * 列表查询地级市
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		if (s_city!=null && s_city.trim().length()!=0) {
			if(s_cityterm1 == 1)
			{
				where += " and " + City.COL_name +" like '%" + s_city.trim()+"%'";	
			}
			if(s_cityterm1 == 2)
			{
				listProvince = Server.getInstance().getHotelService().findAllProvince(" where " + Province.COL_name +" like '%" + s_city.trim()+"%'"
					,"ORDER BY ID",-1,0);
				if(listProvince != null && listProvince.size()>0)
				{
					where += " and " + City.COL_provinceid +" = " + listProvince.get(0).getId();
				}
			}
			if(s_cityterm1 == 3)
			{
				where += " and " + City.COL_enname +" like '%" + s_city.trim().toUpperCase()+"%'";	
			}
			if(s_cityterm1 == 4)
			{
				where += " and " + City.COL_sname +" like '%" + s_city.trim().toUpperCase()+"%'";	
			}
		}
	
		listCity = Server.getInstance().getHotelService().findAllCityForPageinfo(where,"ORDER BY ID",pageinfo);
		
		 if(pageinfo.getTotalrow()>0 &&   listCity.size()==0){
			pageinfo.setPagenum(1);
			listCity = Server.getInstance().getHotelService().findAllCityForPageinfo(where," ORDER BY ID ",pageinfo);	
		}
		pageinfo = (PageInfo) listCity.get(0);
		listCity.remove(0) ;
		return SUCCESS;
	}
	/**
	 * @param 省份id
	 * @return 省份名称
	 */
	public String getProIdByName(Long id)
	{
		return Server.getInstance().getHotelService().findProvince(id).getName();
	}
	/**
	 * 转向到地级市添加页面
	 */	
	public String toadd()throws Exception{
       
		listProvince = Server.getInstance().getHotelService().findAllProvince("","ORDER BY ID",-1,0);
		return EDIT;
	}
	/**
	 * 转向到地级市修改页面
	 */	
	public String toedit()throws Exception{
	city = Server.getInstance().getHotelService().findCity(city.getId());
	if(city.getProvinceid()!=null){
		
		province = Server.getInstance().getHotelService().findProvince(city.getProvinceid());
	}
	
	listProvince = Server.getInstance().getHotelService().findAllProvince("","ORDER BY ID",-1,0);
	return EDIT;
	}
	/**
	 * 转向到地级市修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		
		Integer lan=city.getLanguage();
		Long uco=city.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		city = Server.getInstance().getHotelService().findCitybylanguage(city.getUcode(),city.getLanguage());
		if(city==null)
		{
			city=new City();
			city.setLanguage(lan);
			city.setUcode(uco);
			//以下是toadd参考方法
			listProvince = Server.getInstance().getHotelService().findAllProvince("WHERE 1=1 AND "+Province.COL_language+" ="+lan,"ORDER BY ID",-1,0);
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			province = Server.getInstance().getHotelService().findProvince(city.getProvinceid());
			listProvince = Server.getInstance().getHotelService().findAllProvince("WHERE 1=1 AND "+Province.COL_language+" ="+lan,"ORDER BY ID",-1,0);
		}
		return EDIT;
	}
	/**
	 * 转向到地级市审核页面
	 */	
	public String tocheck()throws Exception{
	city = Server.getInstance().getHotelService().findCity(city.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加地级市
	 */		
	public String add()throws Exception{
		city.setLountryid(168l);
		city=Server.getInstance().getHotelService().createCity(city);
		this.addActionMessage("您的操作已成功！");
		return LIST;
	}

	/**
	 * 审核地级市
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateCityIgnoreNull(city);
		return LIST;
	}
	


	/**
	 * 编辑地级市
	 */		
	public String edit()throws Exception{
		Server.getInstance().getHotelService().updateCityIgnoreNull(city);
		province = Server.getInstance().getHotelService().findProvince(city.getProvinceid());
		listProvince = Server.getInstance().getHotelService().findAllProvince("","ORDER BY ID",-1,0);
		this.addActionMessage("您的操作已成功！");
		return LIST;
	}
	
	/**
	 * 删除地级市
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteCity(city.getId());
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
					Server.getInstance().getHotelService().deleteCity(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}
	
	






	/**
	 *  返回地级市对象
	 */		
	
	public Object getModel() {
		return city;
	}
	public List < City >   getListCity() {
		return listCity;
	}
	public void setListCity(List <  City  >  listCity) {
		this.listCity = listCity;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
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
	public List<Province> getListProvince() {
		return listProvince;
	}
	public void setListProvince(List<Province> listProvince) {
		this.listProvince = listProvince;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public String getS_city() {
		return s_city;
	}
	public void setS_city(String s_city) {
		this.s_city = s_city;
	}


	public int getS_cityterm1() {
		return s_cityterm1;
	}
	public void setS_cityterm1(int s_cityterm1) {
		this.s_cityterm1 = s_cityterm1;
	}
	public void setS_cityterm(int s_cityterm) {
	}
	public String getS_cityid() {
		return s_cityid;
	}
	public void setS_cityid(String s_cityid) {
		this.s_cityid = s_cityid;
	}	
}