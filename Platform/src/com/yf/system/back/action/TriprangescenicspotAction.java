/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.triprangescenicspot.Triprangescenicspot;
import com.yf.system.base.util.PageInfo;


public class TriprangescenicspotAction extends B2b2cbackAction {
	private List <  Triprangescenicspot  >  listTriprangescenicspot;
	private Triprangescenicspot triprangescenicspot = new Triprangescenicspot();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询行程景点关联
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Triprangescenicspot.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllTriprangescenicspotForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTriprangescenicspot = list;
		  if(pageinfo.getTotalrow()>0 &&   listTriprangescenicspot.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllTriprangescenicspotForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTriprangescenicspot = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到行程景点关联添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到行程景点关联修改页面
	 */	
	public String toedit()throws Exception{
	triprangescenicspot = Server.getInstance().getTripService().findTriprangescenicspot(triprangescenicspot.getId());
		return EDIT;
	}
	
	/**
	 * 转向到行程景点关联审核页面
	 */	
	public String tocheck()throws Exception{
	triprangescenicspot = Server.getInstance().getTripService().findTriprangescenicspot(triprangescenicspot.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加行程景点关联
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getTripService().createTriprangescenicspot(triprangescenicspot);
		return LIST;
	}

	/**
	 * 审核行程景点关联
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateTriprangescenicspotIgnoreNull(triprangescenicspot);
		return LIST;
	}
	


	/**
	 * 编辑行程景点关联
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getTripService().updateTriprangescenicspotIgnoreNull(triprangescenicspot);
		return LIST;
	}

	/**
	 * 删除行程景点关联
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteTriprangescenicspot(triprangescenicspot.getId());
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
					Server.getInstance().getTripService().deleteTriprangescenicspot(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回行程景点关联对象
	 */		
	
	public Object getModel() {
		return triprangescenicspot;
	}
	public List < Triprangescenicspot >   getListTriprangescenicspot() {
		return listTriprangescenicspot;
	}
	public void setListTriprangescenicspot(List <  Triprangescenicspot  >  listTriprangescenicspot) {
		this.listTriprangescenicspot = listTriprangescenicspot;
	}
	public Triprangescenicspot getTriprangescenicspot() {
		return triprangescenicspot;
	}
	public void setTriprangescenicspot(Triprangescenicspot triprangescenicspot) {
		this.triprangescenicspot = triprangescenicspot;
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