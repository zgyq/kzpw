/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.fguest.Fguest;
import com.yf.system.base.util.PageInfo;


public class FguestAction extends B2b2cbackAction {
	private List <  Fguest  >  listFguest;
	private Fguest fguest = new Fguest();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询国际机票乘机人表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Fguest.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getInterticketService().findAllFguestForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listFguest = list;
		  if(pageinfo.getTotalrow()>0 &&   listFguest.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getInterticketService().findAllFguestForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listFguest = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到国际机票乘机人表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到国际机票乘机人表修改页面
	 */	
	public String toedit()throws Exception{
	fguest = Server.getInstance().getInterticketService().findFguest(fguest.getId());
		return EDIT;
	}
	
	/**
	 * 转向到国际机票乘机人表审核页面
	 */	
	public String tocheck()throws Exception{
	fguest = Server.getInstance().getInterticketService().findFguest(fguest.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加国际机票乘机人表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getInterticketService().createFguest(fguest);
		return LIST;
	}

	/**
	 * 审核国际机票乘机人表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getInterticketService().updateFguestIgnoreNull(fguest);
		return LIST;
	}
	


	/**
	 * 编辑国际机票乘机人表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getInterticketService().updateFguestIgnoreNull(fguest);
		return LIST;
	}

	/**
	 * 删除国际机票乘机人表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getInterticketService().deleteFguest(fguest.getId());
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
					Server.getInstance().getInterticketService().deleteFguest(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回国际机票乘机人表对象
	 */		
	
	public Object getModel() {
		return fguest;
	}
	public List < Fguest >   getListFguest() {
		return listFguest;
	}
	public void setListFguest(List <  Fguest  >  listFguest) {
		this.listFguest = listFguest;
	}
	public Fguest getFguest() {
		return fguest;
	}
	public void setFguest(Fguest fguest) {
		this.fguest = fguest;
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