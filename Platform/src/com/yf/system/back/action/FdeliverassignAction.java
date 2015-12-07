/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.fdeliverassign.Fdeliverassign;
import com.yf.system.base.util.PageInfo;


public class FdeliverassignAction extends B2b2cbackAction {
	private List <  Fdeliverassign  >  listFdeliverassign;
	private Fdeliverassign fdeliverassign = new Fdeliverassign();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询国际机票配送信息
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Fdeliverassign.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getInterticketService().findAllFdeliverassignForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listFdeliverassign = list;
		  if(pageinfo.getTotalrow()>0 &&   listFdeliverassign.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getInterticketService().findAllFdeliverassignForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listFdeliverassign = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到国际机票配送信息添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到国际机票配送信息修改页面
	 */	
	public String toedit()throws Exception{
	fdeliverassign = Server.getInstance().getInterticketService().findFdeliverassign(fdeliverassign.getId());
		return EDIT;
	}
	
	/**
	 * 转向到国际机票配送信息审核页面
	 */	
	public String tocheck()throws Exception{
	fdeliverassign = Server.getInstance().getInterticketService().findFdeliverassign(fdeliverassign.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加国际机票配送信息
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getInterticketService().createFdeliverassign(fdeliverassign);
		return LIST;
	}

	/**
	 * 审核国际机票配送信息
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getInterticketService().updateFdeliverassignIgnoreNull(fdeliverassign);
		return LIST;
	}
	


	/**
	 * 编辑国际机票配送信息
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getInterticketService().updateFdeliverassignIgnoreNull(fdeliverassign);
		return LIST;
	}

	/**
	 * 删除国际机票配送信息
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getInterticketService().deleteFdeliverassign(fdeliverassign.getId());
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
					Server.getInstance().getInterticketService().deleteFdeliverassign(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回国际机票配送信息对象
	 */		
	
	public Object getModel() {
		return fdeliverassign;
	}
	public List < Fdeliverassign >   getListFdeliverassign() {
		return listFdeliverassign;
	}
	public void setListFdeliverassign(List <  Fdeliverassign  >  listFdeliverassign) {
		this.listFdeliverassign = listFdeliverassign;
	}
	public Fdeliverassign getFdeliverassign() {
		return fdeliverassign;
	}
	public void setFdeliverassign(Fdeliverassign fdeliverassign) {
		this.fdeliverassign = fdeliverassign;
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