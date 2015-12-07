/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.carsregion.Carsregion;
import com.yf.system.base.util.PageInfo;


public class CarsregionAction extends B2b2cbackAction {
	private List <  Carsregion  >  listCarsregion;
	private Carsregion carsregion = new Carsregion();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询送车上门区域
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Carsregion.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getCarService().findAllCarsregionForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCarsregion = list;
		  if(pageinfo.getTotalrow()>0 &&   listCarsregion.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getCarService().findAllCarsregionForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCarsregion = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到送车上门区域添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到送车上门区域修改页面
	 */	
	public String toedit()throws Exception{
	carsregion = Server.getInstance().getCarService().findCarsregion(carsregion.getId());
		return EDIT;
	}
	
	/**
	 * 转向到送车上门区域审核页面
	 */	
	public String tocheck()throws Exception{
	carsregion = Server.getInstance().getCarService().findCarsregion(carsregion.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加送车上门区域
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getCarService().createCarsregion(carsregion);
		return LIST;
	}

	/**
	 * 审核送车上门区域
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getCarService().updateCarsregionIgnoreNull(carsregion);
		return LIST;
	}
	


	/**
	 * 编辑送车上门区域
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getCarService().updateCarsregionIgnoreNull(carsregion);
		return LIST;
	}

	/**
	 * 删除送车上门区域
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getCarService().deleteCarsregion(carsregion.getId());
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
					Server.getInstance().getCarService().deleteCarsregion(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回送车上门区域对象
	 */		
	
	public Object getModel() {
		return carsregion;
	}
	public List < Carsregion >   getListCarsregion() {
		return listCarsregion;
	}
	public void setListCarsregion(List <  Carsregion  >  listCarsregion) {
		this.listCarsregion = listCarsregion;
	}
	public Carsregion getCarsregion() {
		return carsregion;
	}
	public void setCarsregion(Carsregion carsregion) {
		this.carsregion = carsregion;
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