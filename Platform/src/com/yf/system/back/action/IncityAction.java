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
import com.yf.system.base.incity.Incity;


public class IncityAction extends B2b2cbackAction {
	private List <  Incity  >  listIncity;
	private List <  Country  >  listCountry;
	private Incity incity = new Incity();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询国际城市表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Incity.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getInterHotelService().findAllIncityForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listIncity = list;
		  if(pageinfo.getTotalrow()>0 &&   listIncity.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getInterHotelService().findAllIncityForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listIncity = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到国际城市表添加页面
	 */	
	public String toadd()throws Exception{
		listCountry =Server.getInstance().getInterHotelService().findAllCountry(" where 1=1 and "+Country.COL_type+" =2", "", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到国际城市表修改页面
	 */	
	public String toedit()throws Exception{
		listCountry =Server.getInstance().getInterHotelService().findAllCountry(" where 1=1 and "+Country.COL_type+" =2", "", -1, 0);
	incity = Server.getInstance().getInterHotelService().findIncity(incity.getId());
		return EDIT;
	}
	
	/**
	 * 转向到国际城市表审核页面
	 */	
	public String tocheck()throws Exception{
	incity = Server.getInstance().getInterHotelService().findIncity(incity.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加国际城市表
	 */		
	public String add()throws Exception{
	incity.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getInterHotelService().createIncity(incity);
		return LIST;
	}

	/**
	 * 审核国际城市表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getInterHotelService().updateIncityIgnoreNull(incity);
		return LIST;
	}
	


	/**
	 * 编辑国际城市表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getInterHotelService().updateIncityIgnoreNull(incity);
		return LIST;
	}

	/**
	 * 删除国际城市表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getInterHotelService().deleteIncity(incity.getId());
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
					Server.getInstance().getInterHotelService().deleteIncity(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回国际城市表对象
	 */		
	
	public Object getModel() {
		return incity;
	}
	public List < Incity >   getListIncity() {
		return listIncity;
	}
	public void setListIncity(List <  Incity  >  listIncity) {
		this.listIncity = listIncity;
	}
	public Incity getIncity() {
		return incity;
	}
	public void setIncity(Incity incity) {
		this.incity = incity;
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
	public List<Country> getListCountry() {
		return listCountry;
	}
	public void setListCountry(List<Country> listCountry) {
		this.listCountry = listCountry;
	}
	
	
}