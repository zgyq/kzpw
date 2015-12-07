/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.carbrand.Carbrand;
import com.yf.system.base.util.PageInfo;


public class CarbrandAction extends B2b2cbackAction {
	private List <  Carbrand  >  listCarbrand;
	private Carbrand carbrand = new Carbrand();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询汽车品牌
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Carbrand.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getCarService().findAllCarbrandForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCarbrand = list;
		  if(pageinfo.getTotalrow()>0 &&   listCarbrand.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getCarService().findAllCarbrandForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCarbrand = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到汽车品牌添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到汽车品牌修改页面
	 */	
	public String toedit()throws Exception{
	carbrand = Server.getInstance().getCarService().findCarbrand(carbrand.getId());
		return EDIT;
	}
	
	/**
	 * 转向到汽车品牌审核页面
	 */	
	public String tocheck()throws Exception{
	carbrand = Server.getInstance().getCarService().findCarbrand(carbrand.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加汽车品牌
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getCarService().createCarbrand(carbrand);
		return LIST;
	}

	/**
	 * 审核汽车品牌
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getCarService().updateCarbrandIgnoreNull(carbrand);
		return LIST;
	}
	


	/**
	 * 编辑汽车品牌
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getCarService().updateCarbrandIgnoreNull(carbrand);
		return LIST;
	}

	/**
	 * 删除汽车品牌
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getCarService().deleteCarbrand(carbrand.getId());
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
					Server.getInstance().getCarService().deleteCarbrand(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回汽车品牌对象
	 */		
	
	public Object getModel() {
		return carbrand;
	}
	public List < Carbrand >   getListCarbrand() {
		return listCarbrand;
	}
	public void setListCarbrand(List <  Carbrand  >  listCarbrand) {
		this.listCarbrand = listCarbrand;
	}
	public Carbrand getCarbrand() {
		return carbrand;
	}
	public void setCarbrand(Carbrand carbrand) {
		this.carbrand = carbrand;
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