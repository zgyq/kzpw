/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.eterminfo.Eterminfo;
import com.yf.system.base.util.PageInfo;


public class EterminfoAction extends B2b2cbackAction {
	private List <  Eterminfo  >  listEterminfo;
	private List<Customeragent> listCustomeragent;
	private Eterminfo eterminfo = new Eterminfo();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	private int type;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询配置表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if(getLoginUser().getAgentid()==46||getLoginUser().getAgentid()==1){
			
			where +="";
		}else {
			where +=" and "+Eterminfo.COL_agentid+" ="+getLoginUser().getAgentid();
		}
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Eterminfo.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getSystemService().findAllEterminfoForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listEterminfo = list;
		  if(pageinfo.getTotalrow()>0 &&   listEterminfo.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getSystemService().findAllEterminfoForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listEterminfo = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 启用或者禁用员工账号
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doCheck() throws Exception {
		eterminfo = Server.getInstance().getSystemService()
				.findEterminfo(eterminfo.getId());
		if (eterminfo.getStatus() == 1) {
			eterminfo.setStatus(0l);
		} else {
			eterminfo.setStatus(1l);
		}
		
		Server.getInstance().getSystemService().updateEterminfoIgnoreNull(eterminfo);
		// 获取前一页面路径
		//forward = ServletActionContext.getRequest().getHeader("Referer");
		return LIST;
	}

	
	/**
	 * 转向到配置表添加页面
	 */	
	public String toadd()throws Exception{
		listCustomeragent = Server.getInstance().getMemberService().findAllCustomeragent("where 1=1 and "+Customeragent.COL_agenttype+" =2", "", -1, 0);
		if(getLoginUser().getAgentid()==getagentId()){
			
			type=0;
		}else {
			type=1;
		}
		return EDIT;
	}
	/**
	 * 转向到配置表修改页面
	 */	
	public String toedit()throws Exception{
	eterminfo = Server.getInstance().getSystemService().findEterminfo(eterminfo.getId());
	listCustomeragent = Server.getInstance().getMemberService().findAllCustomeragent("where 1=1 and "+Customeragent.COL_agenttype+" =2", "", -1, 0);
	if(getLoginUser().getAgentid()==getagentId()){
		
		type=0;
	}else {
		type=1;
	}
		return EDIT;
	}
	
	/**
	 * 转向到配置表审核页面
	 */	
	public String tocheck()throws Exception{
	eterminfo = Server.getInstance().getSystemService().findEterminfo(eterminfo.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加配置表
	 */		
	public String add()throws Exception{
	eterminfo.setCreateuser(getLoginUser().getLoginname());
		eterminfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		//eterminfo.setModifyuser(getLoginUser().getLoginname());
		eterminfo.setModifytime(new Timestamp(System.currentTimeMillis()));
		if(getLoginUser().getAgentid()==getagentId()){
			
			eterminfo.setAgentid(eterminfo.getAgentid());
		}else {
			eterminfo.setAgentid(getLoginUser().getAgentid());
		}
		Server.getInstance().getSystemService().createEterminfo(eterminfo);
		return LIST;
	}

	/**
	 * 审核配置表
	 */		
	public String check()throws Exception{
	//eterminfo.setModifyuser(getLoginUser().getLoginname());
		eterminfo.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getSystemService().updateEterminfoIgnoreNull(eterminfo);
		return LIST;
	}
	


	/**
	 * 编辑配置表
	 */		
	public String edit()throws Exception{
	//eterminfo.setModifyuser(getLoginUser().getLoginname());
		eterminfo.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getSystemService().updateEterminfoIgnoreNull(eterminfo);
		return LIST;
	}

	/**
	 * 删除配置表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getSystemService().deleteEterminfo(eterminfo.getId());
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
					Server.getInstance().getSystemService().deleteEterminfo(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回配置表对象
	 */		
	
	public Object getModel() {
		return eterminfo;
	}
	public List < Eterminfo >   getListEterminfo() {
		return listEterminfo;
	}
	public void setListEterminfo(List <  Eterminfo  >  listEterminfo) {
		this.listEterminfo = listEterminfo;
	}
	public Eterminfo getEterminfo() {
		return eterminfo;
	}
	public void setEterminfo(Eterminfo eterminfo) {
		this.eterminfo = eterminfo;
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
	public List<Customeragent> getListCustomeragent() {
		return listCustomeragent;
	}
	public void setListCustomeragent(List<Customeragent> listCustomeragent) {
		this.listCustomeragent = listCustomeragent;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}