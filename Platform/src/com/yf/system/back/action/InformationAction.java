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
import com.yf.system.base.information.Information;
import com.yf.system.base.util.PageInfo;


public class InformationAction extends B2b2cbackAction {
	private List <  Information  >  listInformation;
	private Information information = new Information();
	
	//批量操作ID数组
	private int[]selectid;
	private String treestr="";
	//批量操作选项
	private int opt;
	private String iswebs;//是否主推
	//search
	//private String s_name;
	
	public String getIswebs() {
		return iswebs;
	}
	public void setIswebs(String iswebs) {
		this.iswebs = iswebs;
	}
	private void getString(long id){
		List<  Information  > listinformation = Server.getInstance().getMemberService().findAllInformation("where "+Information.COL_parentid+" ="+id,"ORDER BY ID",-1,0);
		if(!listinformation.isEmpty()){
		
			for(Information m :listinformation){
				if(id==-1){
					treestr+="var sub_"+ m.getId() 
						+" = new Ext.tree.TreeNode({ id:'"+ m.getId() +"',  text:'"+ m.getName() +"'});\n";
					
					treestr+="root.appendChild(sub_"+ m.getId() +");\n";
				}else{
					treestr+="var sub_"+ m.getId() 
					+" = new Ext.tree.TreeNode({ id:'"+ m.getId() +"', text:'"+ m.getName() +"'});\n";
			
					treestr+="sub_"+ id +".appendChild(sub_"+ m.getId() +");\n";
				
				}
				getString(m.getId());
			}
		}
	}
	/**
	 * 列表查询资讯中心
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Information.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllInformationForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listInformation = list;
		  if(pageinfo.getTotalrow()>0 &&   listInformation.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllInformationForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listInformation = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到资讯中心添加页面
	 */	
	public String toadd()throws Exception{
		getString(-1);
		return EDIT;
	}
	/**
	 * 转向到资讯中心修改页面
	 */	
	public String toedit()throws Exception{
		getString(-1);
	information = Server.getInstance().getMemberService().findInformation(information.getId());
		return EDIT;
	}
	
	/**
	 * 转向到资讯中心审核页面
	 */	
	public String tocheck()throws Exception{
	information = Server.getInstance().getMemberService().findInformation(information.getId());
		return CHECK;
	}
	
	public String getInformationName(long id){
		
		return Server.getInstance().getMemberService().findInformation(id).getName();
	}
	
	/**
	 * 添加资讯中心
	 */		
	public String add()throws Exception{
	information.setCreatetime(new Timestamp(System.currentTimeMillis()));
	information.setMemberid(getLoginUser().getId());
	if(information.getParentid()==null){
		information.setParentid(-1l);
		information.setParentstr("-1");
	}
	information.setIsweb(Long.parseLong(iswebs));	
		Server.getInstance().getMemberService().createInformation(information);
		return LIST;
	}

	/**
	 * 审核资讯中心
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateInformationIgnoreNull(information);
		return LIST;
	}
	


	/**
	 * 编辑资讯中心
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateInformationIgnoreNull(information);
		return LIST;
	}

	/**
	 * 删除资讯中心
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteInformation(information.getId());
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
					Server.getInstance().getMemberService().deleteInformation(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;	
	}





	/**
	 *  返回资讯中心对象
	 */		
	
	public Object getModel() {
		return information;
	}
	public List < Information >   getListInformation() {
		return listInformation;
	}
	public void setListInformation(List <  Information  >  listInformation) {
		this.listInformation = listInformation;
	}
	public Information getInformation() {
		return information;
	}
	public void setInformation(Information information) {
		this.information = information;
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
	public String getTreestr() {
		return treestr;
	}
	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}
	
	
}