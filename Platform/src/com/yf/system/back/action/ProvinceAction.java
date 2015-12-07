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
import com.yf.system.base.province.Province;
import com.yf.system.base.util.PageInfo;

public class ProvinceAction extends B2b2cbackAction {
	private List  listProvince;
	private Province province = new Province();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_province;
	private int s_proterm = 0;
	
	
	/**
	 * 列表查询省份
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		if (s_province!=null && s_province.trim().length()!=0) {
			if(s_proterm == 1)
			{
			where += " and " + Province.COL_name+" like '%" + s_province.trim()+"%'";	
			}
			if(s_proterm == 2)
			{
			where += " and " + Province.COL_enname+" like '%" + s_province.trim().toUpperCase()+"%'";	
			}
			if(s_proterm == 3)
			{
			where += " and " + Province.COL_code+" like '%" + s_province.trim().toUpperCase()+"%'";	
			}
		}
	
		listProvince = Server.getInstance().getHotelService().findAllProvinceForPageinfo(where," ORDER BY ID",pageinfo);
		
		 if(pageinfo.getTotalrow()>0 &&   listProvince.size()==0){
			pageinfo.setPagenum(1);
			listProvince = Server.getInstance().getHotelService().findAllProvinceForPageinfo(where," ORDER BY ID ",pageinfo);	
		}
		pageinfo = (PageInfo) listProvince.get(0) ;
		listProvince.remove(0) ;
		
		return SUCCESS;
	}
	/**
	 * 转向到省份添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到省份修改页面
	 */	
	public String toedit()throws Exception{
	province = Server.getInstance().getHotelService().findProvince(province.getId());
	System.err.println(province);
		return EDIT;
	}
	/**
	 * 转向到省份修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		Integer lan=province.getLanguage();
		Long uco=province.getUcode();
		province = Server.getInstance().getHotelService().findProvincebylanguage(province.getUcode(),province.getLanguage());
		if(province==null)
		{
			province=new Province();
			province.setLanguage(lan);
			province.setUcode(uco);
		}
		return EDIT;
	}
	/**
	 * 转向到省份审核页面
	 */	
	public String tocheck()throws Exception{
	province = Server.getInstance().getHotelService().findProvince(province.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加省份
	 */		
	public String add()throws Exception{
		province=Server.getInstance().getHotelService().createProvince(province);
		this.addActionMessage("您的操作已成功！");
		return LIST;
	}

	/**
	 * 审核省份
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateProvinceIgnoreNull(province);
		return LIST;
	}
	


	/**
	 * 编辑省份
	 */		
	public String edit()throws Exception{
	
		System.out.println("edit:"+province);
		Server.getInstance().getHotelService().updateProvinceIgnoreNull(province);
		this.addActionMessage("您的操作已成功！");
		return LIST;
	}

	/**
	 * 删除省份
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteProvince(province.getId());
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
					Server.getInstance().getHotelService().deleteProvince(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回省份对象
	 */		
	
	public Object getModel() {
		return province;
	}
	public List < Province >   getListProvince() {
		return listProvince;
	}
	public void setListProvince(List <  Province  >  listProvince) {
		this.listProvince = listProvince;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
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
	public String getS_province() {
		return s_province;
	}
	public void setS_province(String s_province) {
		this.s_province = s_province;
	}
	public int getS_proterm() {
		return s_proterm;
	}
	public void setS_proterm(int s_proterm) {
		this.s_proterm = s_proterm;
	}

	
	
}