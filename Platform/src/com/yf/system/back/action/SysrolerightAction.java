/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.ArrayList;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.sysroleright.Sysroleright;
import com.yf.system.base.systemright.Systemright;
import com.yf.system.base.util.PageInfo;


public class SysrolerightAction extends B2b2cbackAction {
	private List <  Sysroleright  >  listSysroleright;
	private Sysroleright sysroleright = new Sysroleright();
	private List <  Systemright  >  listSysright;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
private String treestr="";
	
	private List<Systemright> listSelect = new ArrayList<Systemright>();
	private List<Systemright> listSelect2 = new ArrayList<Systemright>();

	
	public List<Systemright> getListSelect(long id) {
		listSelect.clear();
		List<Systemright> cs = Server.getInstance().getMemberService().findAllSystemright(
				" where " + Systemright.COL_parentid + " = " + id,
				"order by " + Systemright.COL_id + " desc ", -1, 0);
		for (Systemright c : cs) {
			listSelect.add(c);
		}

		return listSelect;
	}

	public List<Systemright> getListSelect2(long id) {
		listSelect2.clear();
		List<Systemright> cs = Server.getInstance().getMemberService().findAllSystemright(
				" where " + Systemright.COL_parentid + "=" + id,
				"order by " + Systemright.COL_id + " desc ", -1, 0);
		for (Systemright c : cs) {
			listSelect2.add(c);
		}

		return listSelect2;
	}
	
	//search
	//private String s_name;
	private void getString(long id){
		List<  Systemright  > list = Server.getInstance().getMemberService().findAllSystemright("where "+Systemright.COL_parentid+ " = "+ id ,"ORDER BY ID",-1,0);
		if(!list.isEmpty()){
		
			for(Systemright m :list){
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
	public String getSysrightName(long id){
		return Server.getInstance().getMemberService().findSystemright(id).getName();
	}
	
	/**
	 * 列表查询系统角色权限关联
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Sysroleright.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllSysrolerightForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSysroleright = list;
		  if(pageinfo.getTotalrow()>0 &&   listSysroleright.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllSysrolerightForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSysroleright = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 根据上级查下级查询服务项
	 */
	public List<Systemright> getsysright(Long id) {
		String where = " WHERE " + Systemright.COL_parentid + "=" + id  ;
		return Server.getInstance().getMemberService().findAllSystemright(where, " ORDER BY ID" , -1, 0) ;
	}
	//取较色名称
	public String getRolername(long id){
				//Server.getInstance().getMemberroleManager().findMemberrole(id).getName();
		return Server.getInstance().getMemberService().findSystemrole(id).getName();
	}
	/**
	 * 转到给角色赋权的页面
	 */	
	public String tofuquan()throws Exception{
		String where = " where 1=1 and "+ Systemright.COL_parentid + " = -1";
		getString(-1l);
	
	    List list = Server.getInstance().getMemberService().findAllSystemrightForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSysright = list;
		  if(pageinfo.getTotalrow()>0 &&   listSysright.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllSystemrightForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSysright = list;
		}
		
		return "tofuquan";
	}
	public boolean hasRight(long roleid,long rightid){
System.out.println("00000000000000000000");
		String where = " where "+ Sysroleright.COL_rightid + " = " + rightid + " and " + Sysroleright.COL_roleid + "="+roleid;
		if(Server.getInstance().getMemberService().findAllSysroleright(where,"",-1,0).size()<=0){
			return false;
			
		}else{
			return true;
		}
			
	}
	/**
	 * 增加角色权限关连
	 */		
	public String enable()throws Exception{	
	
		//	if(!hasRight(memroleright.getRoleid() ,memroleright.getId())){
		Sysroleright t_roleright = new Sysroleright();
			t_roleright.setRightid(sysroleright.getId());
			t_roleright.setRoleid(sysroleright.getRoleid() );
			Server.getInstance().getMemberService().createSysroleright(t_roleright);
	//	}
		
		return "fuquan";
	}
	/**
	 * 删除角色权限关连
	 */		
	public String unable()throws Exception{	
		
		Server.getInstance().getMemberService().excuteSysrolerightBySql("delete from "+Sysroleright.TABLE+
				" where "+Sysroleright.COL_rightid +" = " + sysroleright.getId() 
				+ " and "+ Sysroleright.COL_roleid+" = "+ sysroleright.getRoleid());
		return "fuquan";
	}

	/**
	 * 转向到系统角色权限关联添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到系统角色权限关联修改页面
	 */	
	public String toedit()throws Exception{
	sysroleright = Server.getInstance().getMemberService().findSysroleright(sysroleright.getId());
		return EDIT;
	}
	
	/**
	 * 转向到系统角色权限关联审核页面
	 */	
	public String tocheck()throws Exception{
	sysroleright = Server.getInstance().getMemberService().findSysroleright(sysroleright.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加系统角色权限关联
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getMemberService().createSysroleright(sysroleright);
		return LIST;
	}

	/**
	 * 审核系统角色权限关联
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateSysrolerightIgnoreNull(sysroleright);
		return LIST;
	}
	


	/**
	 * 编辑系统角色权限关联
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateSysrolerightIgnoreNull(sysroleright);
		return LIST;
	}

	/**
	 * 删除系统角色权限关联
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteSysroleright(sysroleright.getId());
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
					Server.getInstance().getMemberService().deleteSysroleright(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回系统角色权限关联对象
	 */		
	
	public Object getModel() {
		return sysroleright;
	}
	public List < Sysroleright >   getListSysroleright() {
		return listSysroleright;
	}
	public void setListSysroleright(List <  Sysroleright  >  listSysroleright) {
		this.listSysroleright = listSysroleright;
	}
	public Sysroleright getSysroleright() {
		return sysroleright;
	}
	public void setSysroleright(Sysroleright sysroleright) {
		this.sysroleright = sysroleright;
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
	public List<Systemright> getListSysright() {
		return listSysright;
	}
	public void setListSysright(List<Systemright> listSysright) {
		this.listSysright = listSysright;
	}

	public String getTreestr() {
		return treestr;
	}

	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}

	public List<Systemright> getListSelect() {
		return listSelect;
	}

	public void setListSelect(List<Systemright> listSelect) {
		this.listSelect = listSelect;
	}

	public List<Systemright> getListSelect2() {
		return listSelect2;
	}

	public void setListSelect2(List<Systemright> listSelect2) {
		this.listSelect2 = listSelect2;
	}
	
	
}