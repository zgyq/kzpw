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
import com.yf.system.base.qzchanpininfo.Qzchanpininfo;


public class QzchanpininfoAction extends B2b2cbackAction {
	private List <  Qzchanpininfo  >  listQzchanpininfo;
	private Qzchanpininfo qzchanpininfo = new Qzchanpininfo();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询签证产品详细信息
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Qzchanpininfo.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllQzchanpininfoForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listQzchanpininfo = list;
		  if(pageinfo.getTotalrow()>0 &&   listQzchanpininfo.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllQzchanpininfoForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listQzchanpininfo = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到签证产品详细信息添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到签证产品详细信息修改页面
	 */	
	public String toedit()throws Exception{
	qzchanpininfo = Server.getInstance().getTripService().findQzchanpininfo(qzchanpininfo.getId());
		return EDIT;
	}
	
	/**
	 * 转向到签证产品详细信息审核页面
	 */	
	public String tocheck()throws Exception{
	qzchanpininfo = Server.getInstance().getTripService().findQzchanpininfo(qzchanpininfo.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加签证产品详细信息
	 */		
	public String add()throws Exception{
	qzchanpininfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().createQzchanpininfo(qzchanpininfo);
		return LIST;
	}

	/**
	 * 审核签证产品详细信息
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateQzchanpininfoIgnoreNull(qzchanpininfo);
		return LIST;
	}
	


	/**
	 * 编辑签证产品详细信息
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getTripService().updateQzchanpininfoIgnoreNull(qzchanpininfo);
		return LIST;
	}

	/**
	 * 删除签证产品详细信息
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteQzchanpininfo(qzchanpininfo.getId());
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
					Server.getInstance().getTripService().deleteQzchanpininfo(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回签证产品详细信息对象
	 */		
	
	public Object getModel() {
		return qzchanpininfo;
	}
	public List < Qzchanpininfo >   getListQzchanpininfo() {
		return listQzchanpininfo;
	}
	public void setListQzchanpininfo(List <  Qzchanpininfo  >  listQzchanpininfo) {
		this.listQzchanpininfo = listQzchanpininfo;
	}
	public Qzchanpininfo getQzchanpininfo() {
		return qzchanpininfo;
	}
	public void setQzchanpininfo(Qzchanpininfo qzchanpininfo) {
		this.qzchanpininfo = qzchanpininfo;
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