/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;


import com.yf.system.back.server.Server;
import com.yf.system.base.qzchanpin.Qzchanpin;


public class QzchanpinAction extends B2b2cbackAction {
	private List <  Qzchanpin  >  listQzchanpin;
	private Qzchanpin qzchanpin = new Qzchanpin();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询签证产品
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Qzchanpin.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllQzchanpinForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listQzchanpin = list;
		  if(pageinfo.getTotalrow()>0 &&   listQzchanpin.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllQzchanpinForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listQzchanpin = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到签证产品添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到签证产品修改页面
	 */	
	public String toedit()throws Exception{
	qzchanpin = Server.getInstance().getTripService().findQzchanpin(qzchanpin.getId());
		return EDIT;
	}
	
	/**
	 * 转向到签证产品审核页面
	 */	
	public String tocheck()throws Exception{
	qzchanpin = Server.getInstance().getTripService().findQzchanpin(qzchanpin.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加签证产品
	 */		
	public String add()throws Exception{
	qzchanpin.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().createQzchanpin(qzchanpin);
		return LIST;
	}

	/**
	 * 审核签证产品
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateQzchanpinIgnoreNull(qzchanpin);
		return LIST;
	}
	


	/**
	 * 编辑签证产品
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getTripService().updateQzchanpinIgnoreNull(qzchanpin);
		return LIST;
	}

	/**
	 * 删除签证产品
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteQzchanpin(qzchanpin.getId());
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
					Server.getInstance().getTripService().deleteQzchanpin(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回签证产品对象
	 */		
	
	public Object getModel() {
		return qzchanpin;
	}
	public List < Qzchanpin >   getListQzchanpin() {
		return listQzchanpin;
	}
	public void setListQzchanpin(List <  Qzchanpin  >  listQzchanpin) {
		this.listQzchanpin = listQzchanpin;
	}
	public Qzchanpin getQzchanpin() {
		return qzchanpin;
	}
	public void setQzchanpin(Qzchanpin qzchanpin) {
		this.qzchanpin = qzchanpin;
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