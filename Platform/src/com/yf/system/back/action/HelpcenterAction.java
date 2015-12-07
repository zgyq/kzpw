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
import com.yf.system.base.helpcenter.Helpcenter;
import com.yf.system.base.util.PageInfo;


public class HelpcenterAction extends B2b2cbackAction {
	private List <  Helpcenter  >  listHelpcenter;
	private Helpcenter helpcenter = new Helpcenter();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	private String treestr="";
	//search
	//private String s_name;
	private String iswebs;//是否主推
	
	
	public String getIswebs() {
		return iswebs;
	}
	public void setIswebs(String iswebs) {
		this.iswebs = iswebs;
	}
	/**
	 * 列表查询帮助中心
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Helpcenter.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllHelpcenterForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listHelpcenter = list;
		  if(pageinfo.getTotalrow()>0 &&   listHelpcenter.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllHelpcenterForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listHelpcenter = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到帮助中心添加页面
	 */	
	public String toadd()throws Exception{
		getString(-1l);
		return EDIT;
	}
	/**
	 * 转向到帮助中心修改页面
	 */	
	public String toedit()throws Exception{
		getString(-1l);
	helpcenter = Server.getInstance().getMemberService().findHelpcenter(helpcenter.getId());
		return EDIT;
	}
	
	/**
	 * 转向到帮助中心审核页面
	 */	
	public String tocheck()throws Exception{
	helpcenter = Server.getInstance().getMemberService().findHelpcenter(helpcenter.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加帮助中心
	 */		
	public String add()throws Exception{
		helpcenter.setCreatetime(new Timestamp(System.currentTimeMillis()));
		helpcenter.setMemberid(getLoginUser().getId());
		if(helpcenter.getParentid()==null){
			helpcenter.setParentid(-1l);
			helpcenter.setParentstr("-1");
		}
		helpcenter.setIsweb(Long.parseLong(iswebs));
		helpcenter=Server.getInstance().getMemberService().createHelpcenter(helpcenter);
		
		/*if(helpcenter.getParentid()!=-1){
			Helpcenter hel=Server.getInstance().getMemberService().findHelpcenter(helpcenter.getParentid());
			String pastr=hel.getParentstr()+","+hel.getId();
			helpcenter.setParentstr(pastr);
			Server.getInstance().getMemberService().updateHelpcenterIgnoreNull(helpcenter);
		}*/
		
		return LIST;
	}

	/**
	 * 审核帮助中心
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateHelpcenterIgnoreNull(helpcenter);
		return LIST;
	}
	
	public String getHelpcenterName(long id){
		
		return Server.getInstance().getMemberService().findHelpcenter(id).getName();
	}

	/**
	 * 编辑帮助中心
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateHelpcenterIgnoreNull(helpcenter);
		return LIST;
	}

	/**
	 * 删除帮助中心
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteHelpcenter(helpcenter.getId());
		return LIST;
	}
	
	private void getString(long id){
		List<  Helpcenter  > listhelp = Server.getInstance().getMemberService().findAllHelpcenter("where "+Helpcenter.COL_parentid+" ="+id,"ORDER BY ID",-1,0);
		if(!listhelp.isEmpty()){
		
			for(Helpcenter m :listhelp){
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
	 * 批量操作
	 * @return
	 * @throws Exception
	 */
	public String batch()throws Exception{
		if(selectid!=null && selectid.length>0 ){
			
			switch(opt){
				case 1: //delete
				
				for(int i:selectid){
					Server.getInstance().getMemberService().deleteHelpcenter(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回帮助中心对象
	 */		
	
	public Object getModel() {
		return helpcenter;
	}
	public List < Helpcenter >   getListHelpcenter() {
		return listHelpcenter;
	}
	public void setListHelpcenter(List <  Helpcenter  >  listHelpcenter) {
		this.listHelpcenter = listHelpcenter;
	}
	public Helpcenter getHelpcenter() {
		return helpcenter;
	}
	public void setHelpcenter(Helpcenter helpcenter) {
		this.helpcenter = helpcenter;
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