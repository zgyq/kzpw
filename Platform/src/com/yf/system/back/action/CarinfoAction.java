/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.carinfo.Carinfo;
import com.yf.system.base.util.PageInfo;


public class CarinfoAction extends B2b2cbackAction {
	private List <  Carinfo  >  listCarinfo;
	private Carinfo carinfo = new Carinfo();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询车型数据
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Carinfo.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getCarService().findAllCarinfoForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCarinfo = list;
		  if(pageinfo.getTotalrow()>0 &&   listCarinfo.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getCarService().findAllCarinfoForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCarinfo = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到车型数据添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到车型数据修改页面
	 */	
	public String toedit()throws Exception{
	carinfo = Server.getInstance().getCarService().findCarinfo(carinfo.getId());
		return EDIT;
	}
	
	/**
	 * 转向到车型数据审核页面
	 */	
	public String tocheck()throws Exception{
	carinfo = Server.getInstance().getCarService().findCarinfo(carinfo.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加车型数据
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getCarService().createCarinfo(carinfo);
		return LIST;
	}

	/**
	 * 审核车型数据
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getCarService().updateCarinfoIgnoreNull(carinfo);
		return LIST;
	}
	


	/**
	 * 编辑车型数据
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getCarService().updateCarinfoIgnoreNull(carinfo);
		return LIST;
	}

	/**
	 * 删除车型数据
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getCarService().deleteCarinfo(carinfo.getId());
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
					Server.getInstance().getCarService().deleteCarinfo(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回车型数据对象
	 */		
	
	public Object getModel() {
		return carinfo;
	}
	public List < Carinfo >   getListCarinfo() {
		return listCarinfo;
	}
	public void setListCarinfo(List <  Carinfo  >  listCarinfo) {
		this.listCarinfo = listCarinfo;
	}
	public Carinfo getCarinfo() {
		return carinfo;
	}
	public void setCarinfo(Carinfo carinfo) {
		this.carinfo = carinfo;
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