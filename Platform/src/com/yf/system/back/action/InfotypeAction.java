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
import com.yf.system.base.infotype.Infotype;


public class InfotypeAction extends B2b2cbackAction {
	private List <  Infotype  >  listInfotype;
	private Infotype infotype = new Infotype();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询信息类型
	 */	
	public String execute()throws Exception{
		String where = " where 1=1";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Infotype.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllInfotypeForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listInfotype = list;
		  if(pageinfo.getTotalrow()>0 &&   listInfotype.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllInfotypeForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listInfotype = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到信息类型添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到信息类型修改页面
	 */	
	public String toedit()throws Exception{
	infotype = Server.getInstance().getMemberService().findInfotype(infotype.getId());
		return EDIT;
	}
	
	
	
	/**
	 * 转向到信息类型审核页面
	 */	
	public String tocheck()throws Exception{
	infotype = Server.getInstance().getMemberService().findInfotype(infotype.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加信息类型
	 */		
	public String add()throws Exception{
	infotype.setCreateuser(getLoginUser().getLoginname());
		infotype.setCreatetime(new Timestamp(System.currentTimeMillis()));
		infotype.setModifyuser(getLoginUser().getLoginname());
		infotype.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createInfotype(infotype);
		return LIST;
	}

	/**
	 * 审核信息类型
	 */		
	public String check()throws Exception{
	infotype.setModifyuser(getLoginUser().getLoginname());
		infotype.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updateInfotypeIgnoreNull(infotype);
		return LIST;
	}
	


	/**
	 * 编辑信息类型
	 */		
	public String edit()throws Exception{
	infotype.setModifyuser(getLoginUser().getLoginname());
		infotype.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updateInfotypeIgnoreNull(infotype);
		return LIST;
	}

	/**
	 * 删除信息类型
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteInfotype(infotype.getId());
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
					Server.getInstance().getMemberService().deleteInfotype(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回信息类型对象
	 */		
	
	public Object getModel() {
		return infotype;
	}
	public List < Infotype >   getListInfotype() {
		return listInfotype;
	}
	public void setListInfotype(List <  Infotype  >  listInfotype) {
		this.listInfotype = listInfotype;
	}
	public Infotype getInfotype() {
		return infotype;
	}
	public void setInfotype(Infotype infotype) {
		this.infotype = infotype;
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