/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.yf.system.back.server.Server;
import com.yf.system.base.rebaterule.Rebaterule;
import com.opensymphony.webwork.ServletActionContext;


public class RebateruleAction extends B2b2cbackAction {
	private List <  Rebaterule  >  listRebaterule;
	private Rebaterule rebaterule = new Rebaterule();
	private String s_idname;
	private String s_value;
	private String s_jjrenrebate="0";
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询返佣规则
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
	
	    List list = Server.getInstance().getMemberService().findAllRebaterule(where," ORDER BY ID ",-1,0);
		listRebaterule = list;
		
		//取得酒店经纪人返佣值设置
		s_jjrenrebate=Server.getInstance().getMemberService().findSysconfig(10021).getValue();

		return SUCCESS;
	}
	/**
	 * 转向到返佣规则添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到返佣规则修改页面
	 */	
	public String toedit()throws Exception{
	rebaterule = Server.getInstance().getMemberService().findRebaterule(rebaterule.getId());
		return EDIT;
	}
	
	/**
	 * 转向到返佣规则审核页面
	 */	
	public String tocheck()throws Exception{
	rebaterule = Server.getInstance().getMemberService().findRebaterule(rebaterule.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加返佣规则
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getMemberService().createRebaterule(rebaterule);
		return LIST;
	}

	/**
	 * 审核返佣规则
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateRebateruleIgnoreNull(rebaterule);
		return LIST;
	}
	


	/**
	 * 编辑返佣规则
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateRebateruleIgnoreNull(rebaterule);
		return LIST;
	}

	/**
	 * 删除返佣规则
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteRebaterule(rebaterule.getId());
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
					Server.getInstance().getMemberService().deleteRebaterule(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}
	
	//更新返佣规则
	public void updaterule() throws Exception
	{
		System.out.println("s_value:"+s_value);
		String strReturn="";
		if(!s_value.equals(""))
		{
			String[] strarr=s_value.split("#");
			if(strarr.length>0)
			{
				for(int i=0;i<strarr.length;i++)
				{
					String[] strdetail=strarr[i].split("@");
					if(strdetail.length==2)
					{
						String[] strIndexarr=strdetail[0].split("_");
						if(strIndexarr.length==3)
						{
							String strAgentTypeIndex=strIndexarr[1];
							String strYeWuTypeIndex=strIndexarr[2];
							String strValue=strdetail[1];
							String strSql="update T_REBATERULE set C_REBATVALUE='"+strValue+"' where C_AGENTTYPEID='"+strAgentTypeIndex+"' and C_RULETYPEID='"+strYeWuTypeIndex+"'";
							System.out.println("sql:"+strSql);
							Server.getInstance().getSystemService().findMapResultBySql(strSql, null);
						}
					}
				}
			}
		}
		/*
		//更新酒店经纪人返佣值(经纪人签约酒店)
		if(!s_jjrenrebate.equals(""))
		{
			Sysconfig sysconfig=Server.getInstance().getMemberService().findSysconfig(10021);
			sysconfig.setValue(s_jjrenrebate);
			Server.getInstance().getMemberService().updateSysconfig(sysconfig);
		}
		*/
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append(strReturn);
		out.print(sb);
		out.flush();
		out.close();
	}






	/**
	 *  返回返佣规则对象
	 */		
	
	public Object getModel() {
		return rebaterule;
	}
	public List < Rebaterule >   getListRebaterule() {
		return listRebaterule;
	}
	public void setListRebaterule(List <  Rebaterule  >  listRebaterule) {
		this.listRebaterule = listRebaterule;
	}
	public Rebaterule getRebaterule() {
		return rebaterule;
	}
	public void setRebaterule(Rebaterule rebaterule) {
		this.rebaterule = rebaterule;
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
	public String getS_idname() {
		return s_idname;
	}
	public void setS_idname(String s_idname) {
		this.s_idname = s_idname;
	}
	public String getS_value() {
		return s_value;
	}
	public void setS_value(String s_value) {
		this.s_value = s_value;
	}
	public String getS_jjrenrebate() {
		return s_jjrenrebate;
	}
	public void setS_jjrenrebate(String s_jjrenrebate) {
		this.s_jjrenrebate = s_jjrenrebate;
	}
	
	
}