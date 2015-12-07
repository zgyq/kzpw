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
import com.yf.system.base.spotlineorder.Spotlineorder;


public class SpotlineorderAction extends B2b2cbackAction {
	private List <  Spotlineorder  >  listSpotlineorder;
	private Spotlineorder spotlineorder = new Spotlineorder();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询线路订单
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Spotlineorder.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllSpotlineorderForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSpotlineorder = list;
		  if(pageinfo.getTotalrow()>0 &&   listSpotlineorder.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllSpotlineorderForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSpotlineorder = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到线路订单添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到线路订单修改页面
	 */	
	public String toedit()throws Exception{
	spotlineorder = Server.getInstance().getTripService().findSpotlineorder(spotlineorder.getId());
		return EDIT;
	}
	
	/**
	 * 转向到线路订单审核页面
	 */	
	public String tocheck()throws Exception{
	spotlineorder = Server.getInstance().getTripService().findSpotlineorder(spotlineorder.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加线路订单
	 */		
	public String add()throws Exception{
	spotlineorder.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().createSpotlineorder(spotlineorder);
		return LIST;
	}

	/**
	 * 审核线路订单
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateSpotlineorderIgnoreNull(spotlineorder);
		return LIST;
	}
	


	/**
	 * 编辑线路订单
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getTripService().updateSpotlineorderIgnoreNull(spotlineorder);
		return LIST;
	}

	/**
	 * 删除线路订单
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteSpotlineorder(spotlineorder.getId());
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
					Server.getInstance().getTripService().deleteSpotlineorder(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回线路订单对象
	 */		
	
	public Object getModel() {
		return spotlineorder;
	}
	public List < Spotlineorder >   getListSpotlineorder() {
		return listSpotlineorder;
	}
	public void setListSpotlineorder(List <  Spotlineorder  >  listSpotlineorder) {
		this.listSpotlineorder = listSpotlineorder;
	}
	public Spotlineorder getSpotlineorder() {
		return spotlineorder;
	}
	public void setSpotlineorder(Spotlineorder spotlineorder) {
		this.spotlineorder = spotlineorder;
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