/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.qqtype.Qqtype;
import com.yf.system.base.util.PageInfo;


public class QqtypeAction extends B2b2cbackAction {
	private List <  Qqtype  >  listQqtype;
	private Qqtype qqtype = new Qqtype();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询QQ类型
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Qqtype.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllQqtypeForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listQqtype = list;
		  if(pageinfo.getTotalrow()>0 &&   listQqtype.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllQqtypeForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listQqtype = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到QQ类型添加页面
	 */	
	public String toadd()throws Exception{
		
		return EDIT;
	}
	/**
	 * 转向到QQ类型修改页面
	 */	
	public String toedit()throws Exception{
	qqtype = Server.getInstance().getMemberService().findQqtype(qqtype.getId());
		return EDIT;
	}
	
	/**
	 * 转向到QQ类型审核页面
	 */	
	public String tocheck()throws Exception{
	qqtype = Server.getInstance().getMemberService().findQqtype(qqtype.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加QQ类型
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getMemberService().createQqtype(qqtype);
		return LIST;
	}

	/**
	 * 审核QQ类型
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateQqtypeIgnoreNull(qqtype);
		return LIST;
	}
	


	/**
	 * 编辑QQ类型
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateQqtypeIgnoreNull(qqtype);
		return LIST;
	}

	/**
	 * 删除QQ类型
	 */		
	public String delete()throws Exception{	
		String sql="DELETE FROM [T_QQINFO] WHERE C_QQTYPE="+qqtype.getId();
		Server.getInstance().getMemberService().deleteQqtype(qqtype.getId());
		Server.getInstance().getSystemService().findMapResultBySql(sql,null);
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
					Server.getInstance().getMemberService().deleteQqtype(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回QQ类型对象
	 */		
	
	public Object getModel() {
		return qqtype;
	}
	public List < Qqtype >   getListQqtype() {
		return listQqtype;
	}
	public void setListQqtype(List <  Qqtype  >  listQqtype) {
		this.listQqtype = listQqtype;
	}
	public Qqtype getQqtype() {
		return qqtype;
	}
	public void setQqtype(Qqtype qqtype) {
		this.qqtype = qqtype;
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