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
import com.yf.system.base.optrecord.Optrecord;


public class OptrecordAction extends B2b2cbackAction {
	private List <  Optrecord  >  listOptrecord;
	private Optrecord optrecord = new Optrecord();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询操作记录表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Optrecord.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getSystemService().findAllOptrecordForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listOptrecord = list;
		  if(pageinfo.getTotalrow()>0 &&   listOptrecord.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getSystemService().findAllOptrecordForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listOptrecord = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到操作记录表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到操作记录表修改页面
	 */	
	public String toedit()throws Exception{
	optrecord = Server.getInstance().getSystemService().findOptrecord(optrecord.getId());
		return EDIT;
	}
	
	/**
	 * 转向到操作记录表审核页面
	 */	
	public String tocheck()throws Exception{
	optrecord = Server.getInstance().getSystemService().findOptrecord(optrecord.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加操作记录表
	 */		
	public String add()throws Exception{
	optrecord.setCreateuser(getLoginUser().getLoginname());
		optrecord.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getSystemService().createOptrecord(optrecord);
		return LIST;
	}

	/**
	 * 审核操作记录表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getSystemService().updateOptrecordIgnoreNull(optrecord);
		return LIST;
	}
	


	/**
	 * 编辑操作记录表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getSystemService().updateOptrecordIgnoreNull(optrecord);
		return LIST;
	}

	/**
	 * 删除操作记录表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getSystemService().deleteOptrecord(optrecord.getId());
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
					Server.getInstance().getSystemService().deleteOptrecord(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回操作记录表对象
	 */		
	
	public Object getModel() {
		return optrecord;
	}
	public List < Optrecord >   getListOptrecord() {
		return listOptrecord;
	}
	public void setListOptrecord(List <  Optrecord  >  listOptrecord) {
		this.listOptrecord = listOptrecord;
	}
	public Optrecord getOptrecord() {
		return optrecord;
	}
	public void setOptrecord(Optrecord optrecord) {
		this.optrecord = optrecord;
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