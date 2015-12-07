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
import com.yf.system.base.prizetype.Prizetype;


public class PrizetypeAction extends B2b2cbackAction {
	private List <  Prizetype  >  listPrizetype;
	private Prizetype prizetype = new Prizetype();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询积分礼品类型
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Prizetype.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllPrizetypeForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listPrizetype = list;
		  if(pageinfo.getTotalrow()>0 &&   listPrizetype.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllPrizetypeForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listPrizetype = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到积分礼品类型添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到积分礼品类型修改页面
	 */	
	public String toedit()throws Exception{
	prizetype = Server.getInstance().getMemberService().findPrizetype(prizetype.getId());
		return EDIT;
	}
	
	/**
	 * 转向到积分礼品类型审核页面
	 */	
	public String tocheck()throws Exception{
	prizetype = Server.getInstance().getMemberService().findPrizetype(prizetype.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加积分礼品类型
	 */		
	public String add()throws Exception{
	prizetype.setCreateuser(getLoginUser().getLoginname());
		prizetype.setCreatetime(new Timestamp(System.currentTimeMillis()));
		prizetype.setModifyuser(getLoginUser().getLoginname());
		prizetype.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createPrizetype(prizetype);
		return LIST;
	}

	/**
	 * 审核积分礼品类型
	 */		
	public String check()throws Exception{
	prizetype.setModifyuser(getLoginUser().getLoginname());
		prizetype.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updatePrizetypeIgnoreNull(prizetype);
		return LIST;
	}
	


	/**
	 * 编辑积分礼品类型
	 */		
	public String edit()throws Exception{
	prizetype.setModifyuser(getLoginUser().getLoginname());
		prizetype.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updatePrizetypeIgnoreNull(prizetype);
		return LIST;
	}

	/**
	 * 删除积分礼品类型
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deletePrizetype(prizetype.getId());
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
					Server.getInstance().getMemberService().deletePrizetype(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回积分礼品类型对象
	 */		
	
	public Object getModel() {
		return prizetype;
	}
	public List < Prizetype >   getListPrizetype() {
		return listPrizetype;
	}
	public void setListPrizetype(List <  Prizetype  >  listPrizetype) {
		this.listPrizetype = listPrizetype;
	}
	public Prizetype getPrizetype() {
		return prizetype;
	}
	public void setPrizetype(Prizetype prizetype) {
		this.prizetype = prizetype;
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