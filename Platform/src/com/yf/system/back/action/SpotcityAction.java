/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.spotcity.Spotcity;


public class SpotcityAction extends B2b2cbackAction {
	private List <  Spotcity  >  listSpotcity;
	private Spotcity spotcity = new Spotcity();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询景区城市
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Spotcity.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllSpotcityForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSpotcity = list;
		  if(pageinfo.getTotalrow()>0 &&   listSpotcity.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllSpotcityForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSpotcity = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到景区城市添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到景区城市修改页面
	 */	
	public String toedit()throws Exception{
	spotcity = Server.getInstance().getTripService().findSpotcity(spotcity.getId());
		return EDIT;
	}
	
	/**
	 * 转向到景区城市审核页面
	 */	
	public String tocheck()throws Exception{
	spotcity = Server.getInstance().getTripService().findSpotcity(spotcity.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加景区城市
	 */		
	public String add()throws Exception{
	spotcity.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().createSpotcity(spotcity);
		return LIST;
	}

	/**
	 * 审核景区城市
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateSpotcityIgnoreNull(spotcity);
		return LIST;
	}
	


	/**
	 * 编辑景区城市
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getTripService().updateSpotcityIgnoreNull(spotcity);
		return LIST;
	}

	/**
	 * 删除景区城市
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteSpotcity(spotcity.getId());
		return LIST;
	}

	
	public String GetSoptCityNameByID(String id){
		
		
		return Server.getInstance().getTripService().findSpotcity(Long.parseLong(id)).getName();
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
					Server.getInstance().getTripService().deleteSpotcity(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回景区城市对象
	 */		
	
	public Object getModel() {
		return spotcity;
	}
	public List < Spotcity >   getListSpotcity() {
		return listSpotcity;
	}
	public void setListSpotcity(List <  Spotcity  >  listSpotcity) {
		this.listSpotcity = listSpotcity;
	}
	public Spotcity getSpotcity() {
		return spotcity;
	}
	public void setSpotcity(Spotcity spotcity) {
		this.spotcity = spotcity;
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