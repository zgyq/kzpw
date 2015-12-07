/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.forderdelrec.Forderdelrec;
import com.yf.system.base.util.PageInfo;


public class ForderdelrecAction extends B2b2cbackAction {
	private List <  Forderdelrec  >  listForderdelrec;
	private Forderdelrec forderdelrec = new Forderdelrec();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询国际机票订单操作记录
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Forderdelrec.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getInterticketService().findAllForderdelrecForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listForderdelrec = list;
		  if(pageinfo.getTotalrow()>0 &&   listForderdelrec.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getInterticketService().findAllForderdelrecForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listForderdelrec = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到国际机票订单操作记录添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到国际机票订单操作记录修改页面
	 */	
	public String toedit()throws Exception{
	forderdelrec = Server.getInstance().getInterticketService().findForderdelrec(forderdelrec.getId());
		return EDIT;
	}
	
	/**
	 * 转向到国际机票订单操作记录审核页面
	 */	
	public String tocheck()throws Exception{
	forderdelrec = Server.getInstance().getInterticketService().findForderdelrec(forderdelrec.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加国际机票订单操作记录
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getInterticketService().createForderdelrec(forderdelrec);
		return LIST;
	}

	/**
	 * 审核国际机票订单操作记录
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getInterticketService().updateForderdelrecIgnoreNull(forderdelrec);
		return LIST;
	}
	


	/**
	 * 编辑国际机票订单操作记录
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getInterticketService().updateForderdelrecIgnoreNull(forderdelrec);
		return LIST;
	}

	/**
	 * 删除国际机票订单操作记录
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getInterticketService().deleteForderdelrec(forderdelrec.getId());
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
					Server.getInstance().getInterticketService().deleteForderdelrec(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回国际机票订单操作记录对象
	 */		
	
	public Object getModel() {
		return forderdelrec;
	}
	public List < Forderdelrec >   getListForderdelrec() {
		return listForderdelrec;
	}
	public void setListForderdelrec(List <  Forderdelrec  >  listForderdelrec) {
		this.listForderdelrec = listForderdelrec;
	}
	public Forderdelrec getForderdelrec() {
		return forderdelrec;
	}
	public void setForderdelrec(Forderdelrec forderdelrec) {
		this.forderdelrec = forderdelrec;
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