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
import com.yf.system.base.spotorder.Spotorder;


public class SpotorderAction extends B2b2cbackAction {
	private List <  Spotorder  >  listSpotorder;
	private Spotorder spotorder = new Spotorder();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询门票订单
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Spotorder.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllSpotorderForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSpotorder = list;
		  if(pageinfo.getTotalrow()>0 &&   listSpotorder.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllSpotorderForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSpotorder = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到门票订单添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到门票订单修改页面
	 */	
	public String toedit()throws Exception{
	spotorder = Server.getInstance().getTripService().findSpotorder(spotorder.getId());
		return EDIT;
	}
	
	/**
	 * 转向到门票订单审核页面
	 */	
	public String tocheck()throws Exception{
	spotorder = Server.getInstance().getTripService().findSpotorder(spotorder.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加门票订单
	 */		
	public String add()throws Exception{
	spotorder.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().createSpotorder(spotorder);
		return LIST;
	}

	/**
	 * 审核门票订单
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateSpotorderIgnoreNull(spotorder);
		return LIST;
	}
	


	/**
	 * 编辑门票订单
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getTripService().updateSpotorderIgnoreNull(spotorder);
		return LIST;
	}

	/**
	 * 删除门票订单
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteSpotorder(spotorder.getId());
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
					Server.getInstance().getTripService().deleteSpotorder(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回门票订单对象
	 */		
	
	public Object getModel() {
		return spotorder;
	}
	public List < Spotorder >   getListSpotorder() {
		return listSpotorder;
	}
	public void setListSpotorder(List <  Spotorder  >  listSpotorder) {
		this.listSpotorder = listSpotorder;
	}
	public Spotorder getSpotorder() {
		return spotorder;
	}
	public void setSpotorder(Spotorder spotorder) {
		this.spotorder = spotorder;
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