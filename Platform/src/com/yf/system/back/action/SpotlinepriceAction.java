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
import com.yf.system.base.spotlineprice.Spotlineprice;


public class SpotlinepriceAction extends B2b2cbackAction {
	private List <  Spotlineprice  >  listSpotlineprice;
	private Spotlineprice spotlineprice = new Spotlineprice();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询景区线路价格信息
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Spotlineprice.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllSpotlinepriceForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSpotlineprice = list;
		  if(pageinfo.getTotalrow()>0 &&   listSpotlineprice.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllSpotlinepriceForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSpotlineprice = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到景区线路价格信息添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到景区线路价格信息修改页面
	 */	
	public String toedit()throws Exception{
	spotlineprice = Server.getInstance().getTripService().findSpotlineprice(spotlineprice.getId());
		return EDIT;
	}
	
	/**
	 * 转向到景区线路价格信息审核页面
	 */	
	public String tocheck()throws Exception{
	spotlineprice = Server.getInstance().getTripService().findSpotlineprice(spotlineprice.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加景区线路价格信息
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getTripService().createSpotlineprice(spotlineprice);
		return LIST;
	}

	/**
	 * 审核景区线路价格信息
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateSpotlinepriceIgnoreNull(spotlineprice);
		return LIST;
	}
	


	/**
	 * 编辑景区线路价格信息
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getTripService().updateSpotlinepriceIgnoreNull(spotlineprice);
		return LIST;
	}

	/**
	 * 删除景区线路价格信息
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteSpotlineprice(spotlineprice.getId());
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
					Server.getInstance().getTripService().deleteSpotlineprice(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回景区线路价格信息对象
	 */		
	
	public Object getModel() {
		return spotlineprice;
	}
	public List < Spotlineprice >   getListSpotlineprice() {
		return listSpotlineprice;
	}
	public void setListSpotlineprice(List <  Spotlineprice  >  listSpotlineprice) {
		this.listSpotlineprice = listSpotlineprice;
	}
	public Spotlineprice getSpotlineprice() {
		return spotlineprice;
	}
	public void setSpotlineprice(Spotlineprice spotlineprice) {
		this.spotlineprice = spotlineprice;
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