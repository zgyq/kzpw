/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.country.Country;


public class CountryAction extends B2b2cbackAction {
	private List <  Country  >  listCountry;
	private Country country = new Country();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询国家表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Country.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getInterHotelService().findAllCountryForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCountry = list;
		  if(pageinfo.getTotalrow()>0 &&   listCountry.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getInterHotelService().findAllCountryForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCountry = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到国家表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到国家表修改页面
	 */	
	public String toedit()throws Exception{
	country = Server.getInstance().getInterHotelService().findCountry(country.getId());
		return EDIT;
	}
	
	/**
	 * 转向到国家表审核页面
	 */	
	public String tocheck()throws Exception{
	country = Server.getInstance().getInterHotelService().findCountry(country.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加国家表
	 */		
	public String add()throws Exception{
	country.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getInterHotelService().createCountry(country);
		return LIST;
	}

	/**
	 * 审核国家表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getInterHotelService().updateCountryIgnoreNull(country);
		return LIST;
	}
	


	/**
	 * 编辑国家表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getInterHotelService().updateCountryIgnoreNull(country);
		return LIST;
	}

	/**
	 * 删除国家表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getInterHotelService().deleteCountry(country.getId());
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
					Server.getInstance().getInterHotelService().deleteCountry(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回国家表对象
	 */		
	
	public Object getModel() {
		return country;
	}
	public List < Country >   getListCountry() {
		return listCountry;
	}
	public void setListCountry(List <  Country  >  listCountry) {
		this.listCountry = listCountry;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
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
	
	
}