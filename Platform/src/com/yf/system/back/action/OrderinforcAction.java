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
import com.yf.system.base.orderinforc.Orderinforc;


public class OrderinforcAction extends B2b2cbackAction {
	private List <  Orderinforc  >  listOrderinforc;
	private Orderinforc orderinforc = new Orderinforc();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询订单处理记录
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Orderinforc.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllOrderinforcForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listOrderinforc = list;
		  if(pageinfo.getTotalrow()>0 &&   listOrderinforc.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllOrderinforcForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listOrderinforc = list;
		}
		
		return SUCCESS;
	}

	
	/**
	 * 转向到订单处理记录添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到订单处理记录修改页面
	 */	
	public String toedit()throws Exception{
	orderinforc = Server.getInstance().getAirService().findOrderinforc(orderinforc.getId());
		return EDIT;
	}
	
	/**
	 * 转向到订单处理记录审核页面
	 */	
	public String tocheck()throws Exception{
	orderinforc = Server.getInstance().getAirService().findOrderinforc(orderinforc.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加订单处理记录
	 */		
	public String add()throws Exception{
	orderinforc.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().createOrderinforc(orderinforc);
		return LIST;
	}

	/**
	 * 审核订单处理记录
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateOrderinforcIgnoreNull(orderinforc);
		return LIST;
	}
	


	/**
	 * 编辑订单处理记录
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateOrderinforcIgnoreNull(orderinforc);
		return LIST;
	}

	/**
	 * 删除订单处理记录
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteOrderinforc(orderinforc.getId());
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
					Server.getInstance().getAirService().deleteOrderinforc(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回订单处理记录对象
	 */		
	
	public Object getModel() {
		return orderinforc;
	}
	public List < Orderinforc >   getListOrderinforc() {
		return listOrderinforc;
	}
	public void setListOrderinforc(List <  Orderinforc  >  listOrderinforc) {
		this.listOrderinforc = listOrderinforc;
	}
	public Orderinforc getOrderinforc() {
		return orderinforc;
	}
	public void setOrderinforc(Orderinforc orderinforc) {
		this.orderinforc = orderinforc;
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