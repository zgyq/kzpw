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
import com.yf.system.base.triporderrc.Triporderrc;


public class TriporderrcAction extends B2b2cbackAction {
	private List <  Triporderrc  >  listTriporderrc;
	private Triporderrc triporderrc = new Triporderrc();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询旅行订单记录
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Triporderrc.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllTriporderrcForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTriporderrc = list;
		  if(pageinfo.getTotalrow()>0 &&   listTriporderrc.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllTriporderrcForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTriporderrc = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到旅行订单记录添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到旅行订单记录修改页面
	 */	
	public String toedit()throws Exception{
	triporderrc = Server.getInstance().getTripService().findTriporderrc(triporderrc.getId());
		return EDIT;
	}
	
	/**
	 * 转向到旅行订单记录审核页面
	 */	
	public String tocheck()throws Exception{
	triporderrc = Server.getInstance().getTripService().findTriporderrc(triporderrc.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加旅行订单记录
	 */		
	public String add()throws Exception{
	triporderrc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().createTriporderrc(triporderrc);
		return LIST;
	}

	/**
	 * 审核旅行订单记录
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateTriporderrcIgnoreNull(triporderrc);
		return LIST;
	}
	


	/**
	 * 编辑旅行订单记录
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getTripService().updateTriporderrcIgnoreNull(triporderrc);
		return LIST;
	}

	/**
	 * 删除旅行订单记录
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteTriporderrc(triporderrc.getId());
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
					Server.getInstance().getTripService().deleteTriporderrc(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回旅行订单记录对象
	 */		
	
	public Object getModel() {
		return triporderrc;
	}
	public List < Triporderrc >   getListTriporderrc() {
		return listTriporderrc;
	}
	public void setListTriporderrc(List <  Triporderrc  >  listTriporderrc) {
		this.listTriporderrc = listTriporderrc;
	}
	public Triporderrc getTriporderrc() {
		return triporderrc;
	}
	public void setTriporderrc(Triporderrc triporderrc) {
		this.triporderrc = triporderrc;
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