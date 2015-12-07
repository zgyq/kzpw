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
import com.yf.system.base.systemaction.Systemaction;


public class SystemactionAction extends B2b2cbackAction {
	private List <  Systemaction  >  listSystemaction;
	private Systemaction systemaction = new Systemaction();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询系统用户行为
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Systemaction.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllSystemactionForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSystemaction = list;
		  if(pageinfo.getTotalrow()>0 &&   listSystemaction.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllSystemactionForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSystemaction = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到系统用户行为添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到系统用户行为修改页面
	 */	
	public String toedit()throws Exception{
	systemaction = Server.getInstance().getMemberService().findSystemaction(systemaction.getId());
		return EDIT;
	}
	
	/**
	 * 转向到系统用户行为审核页面
	 */	
	public String tocheck()throws Exception{
	systemaction = Server.getInstance().getMemberService().findSystemaction(systemaction.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加系统用户行为
	 */		
	public String add()throws Exception{
	systemaction.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createSystemaction(systemaction);
		return LIST;
	}

	/**
	 * 审核系统用户行为
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateSystemactionIgnoreNull(systemaction);
		return LIST;
	}
	


	/**
	 * 编辑系统用户行为
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateSystemactionIgnoreNull(systemaction);
		return LIST;
	}

	/**
	 * 删除系统用户行为
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteSystemaction(systemaction.getId());
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
					Server.getInstance().getMemberService().deleteSystemaction(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回系统用户行为对象
	 */		
	
	public Object getModel() {
		return systemaction;
	}
	public List < Systemaction >   getListSystemaction() {
		return listSystemaction;
	}
	public void setListSystemaction(List <  Systemaction  >  listSystemaction) {
		this.listSystemaction = listSystemaction;
	}
	public Systemaction getSystemaction() {
		return systemaction;
	}
	public void setSystemaction(Systemaction systemaction) {
		this.systemaction = systemaction;
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