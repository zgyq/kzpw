/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.lowestprice.Lowestprice;
import com.yf.system.base.util.PageInfo;


public class LowestpriceAction extends B2b2cbackAction {
	private List <  Lowestprice  >  listLowestprice;
	private Lowestprice lowestprice = new Lowestprice();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询机票低价数据表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Lowestprice.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllLowestpriceForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listLowestprice = list;
		  if(pageinfo.getTotalrow()>0 &&   listLowestprice.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllLowestpriceForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listLowestprice = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到机票低价数据表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到机票低价数据表修改页面
	 */	
	public String toedit()throws Exception{
	lowestprice = Server.getInstance().getAirService().findLowestprice(lowestprice.getId());
		return EDIT;
	}
	
	/**
	 * 转向到机票低价数据表审核页面
	 */	
	public String tocheck()throws Exception{
	lowestprice = Server.getInstance().getAirService().findLowestprice(lowestprice.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加机票低价数据表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getAirService().createLowestprice(lowestprice);
		return LIST;
	}

	/**
	 * 审核机票低价数据表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateLowestpriceIgnoreNull(lowestprice);
		return LIST;
	}
	


	/**
	 * 编辑机票低价数据表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateLowestpriceIgnoreNull(lowestprice);
		return LIST;
	}

	/**
	 * 删除机票低价数据表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteLowestprice(lowestprice.getId());
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
					Server.getInstance().getAirService().deleteLowestprice(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回机票低价数据表对象
	 */		
	
	public Object getModel() {
		return lowestprice;
	}
	public List < Lowestprice >   getListLowestprice() {
		return listLowestprice;
	}
	public void setListLowestprice(List <  Lowestprice  >  listLowestprice) {
		this.listLowestprice = listLowestprice;
	}
	public Lowestprice getLowestprice() {
		return lowestprice;
	}
	public void setLowestprice(Lowestprice lowestprice) {
		this.lowestprice = lowestprice;
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