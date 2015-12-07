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
import com.yf.system.base.wanlixing.Wanlixing;


public class WanlixingAction extends B2b2cbackAction {
	private List <  Wanlixing  >  listWanlixing;
	private Wanlixing wanlixing = new Wanlixing();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询万里行申请表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Wanlixing.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllWanlixingForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listWanlixing = list;
		  if(pageinfo.getTotalrow()>0 &&   listWanlixing.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllWanlixingForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listWanlixing = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到万里行申请表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到万里行申请表修改页面
	 */	
	public String toedit()throws Exception{
	wanlixing = Server.getInstance().getMemberService().findWanlixing(wanlixing.getId());
		return EDIT;
	}
	
	/**
	 * 转向到万里行申请表审核页面
	 */	
	public String tocheck()throws Exception{
	wanlixing = Server.getInstance().getMemberService().findWanlixing(wanlixing.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加万里行申请表
	 */		
	public String add()throws Exception{
	wanlixing.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createWanlixing(wanlixing);
		return LIST;
	}

	/**
	 * 审核万里行申请表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateWanlixingIgnoreNull(wanlixing);
		return LIST;
	}
	


	/**
	 * 编辑万里行申请表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateWanlixingIgnoreNull(wanlixing);
		return LIST;
	}

	/**
	 * 删除万里行申请表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteWanlixing(wanlixing.getId());
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
					Server.getInstance().getMemberService().deleteWanlixing(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回万里行申请表对象
	 */		
	
	public Object getModel() {
		return wanlixing;
	}
	public List < Wanlixing >   getListWanlixing() {
		return listWanlixing;
	}
	public void setListWanlixing(List <  Wanlixing  >  listWanlixing) {
		this.listWanlixing = listWanlixing;
	}
	public Wanlixing getWanlixing() {
		return wanlixing;
	}
	public void setWanlixing(Wanlixing wanlixing) {
		this.wanlixing = wanlixing;
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