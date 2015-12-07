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
import com.yf.system.base.agentvalue.Agentvalue;


public class AgentvalueAction extends B2b2cbackAction {
	private List <  Agentvalue  >  listAgentvalue;
	private Agentvalue agentvalue = new Agentvalue();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询加盟商固定返点
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Agentvalue.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllAgentvalueForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listAgentvalue = list;
		  if(pageinfo.getTotalrow()>0 &&   listAgentvalue.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllAgentvalueForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listAgentvalue = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到加盟商固定返点添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到加盟商固定返点修改页面
	 */	
	public String toedit()throws Exception{
	agentvalue = Server.getInstance().getMemberService().findAgentvalue(agentvalue.getId());
		return EDIT;
	}
	
	/**
	 * 转向到加盟商固定返点审核页面
	 */	
	public String tocheck()throws Exception{
	agentvalue = Server.getInstance().getMemberService().findAgentvalue(agentvalue.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加加盟商固定返点
	 */		
	public String add()throws Exception{
	agentvalue.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createAgentvalue(agentvalue);
		return LIST;
	}

	/**
	 * 审核加盟商固定返点
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateAgentvalueIgnoreNull(agentvalue);
		return LIST;
	}
	


	/**
	 * 编辑加盟商固定返点
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateAgentvalueIgnoreNull(agentvalue);
		return LIST;
	}

	/**
	 * 删除加盟商固定返点
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteAgentvalue(agentvalue.getId());
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
					Server.getInstance().getMemberService().deleteAgentvalue(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回加盟商固定返点对象
	 */		
	
	public Object getModel() {
		return agentvalue;
	}
	public List < Agentvalue >   getListAgentvalue() {
		return listAgentvalue;
	}
	public void setListAgentvalue(List <  Agentvalue  >  listAgentvalue) {
		this.listAgentvalue = listAgentvalue;
	}
	public Agentvalue getAgentvalue() {
		return agentvalue;
	}
	public void setAgentvalue(Agentvalue agentvalue) {
		this.agentvalue = agentvalue;
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