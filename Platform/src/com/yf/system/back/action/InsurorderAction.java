/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.insurorder.Insurorder;
import com.yf.system.base.util.PageInfo;


public class InsurorderAction extends B2b2cbackAction {
	private List <  Insurorder  >  listInsurorder;
	private Insurorder insurorder = new Insurorder();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询订单表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Insurorder.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllInsurorderForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listInsurorder = list;
		  if(pageinfo.getTotalrow()>0 &&   listInsurorder.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllInsurorderForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listInsurorder = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到订单表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到订单表修改页面
	 */	
	public String toedit()throws Exception{
	insurorder = Server.getInstance().getAirService().findInsurorder(insurorder.getId());
		return EDIT;
	}
	
	/**
	 * 转向到订单表审核页面
	 */	
	public String tocheck()throws Exception{
	insurorder = Server.getInstance().getAirService().findInsurorder(insurorder.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加订单表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getAirService().createInsurorder(insurorder);
		return LIST;
	}

	/**
	 * 审核订单表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateInsurorderIgnoreNull(insurorder);
		return LIST;
	}
	


	/**
	 * 编辑订单表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateInsurorderIgnoreNull(insurorder);
		return LIST;
	}

	/**
	 * 删除订单表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteInsurorder(insurorder.getId());
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
					Server.getInstance().getAirService().deleteInsurorder(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回订单表对象
	 */		
	
	public Object getModel() {
		return insurorder;
	}
	public List < Insurorder >   getListInsurorder() {
		return listInsurorder;
	}
	public void setListInsurorder(List <  Insurorder  >  listInsurorder) {
		this.listInsurorder = listInsurorder;
	}
	public Insurorder getInsurorder() {
		return insurorder;
	}
	public void setInsurorder(Insurorder insurorder) {
		this.insurorder = insurorder;
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