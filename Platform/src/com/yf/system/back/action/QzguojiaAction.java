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
import com.yf.system.base.qzguojia.Qzguojia;


public class QzguojiaAction extends B2b2cbackAction {
	private List <  Qzguojia  >  listQzguojia;
	private Qzguojia qzguojia = new Qzguojia();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_name;
	
	
	/**
	 * 列表查询签证国家
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (s_name!=null && s_name.trim().length()!=0) {
			
			where += " and " + Qzguojia.COL_name +" like '%" + s_name.trim()+"%'";	
		}
	
	    List list = Server.getInstance().getTripService().findAllQzguojiaForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listQzguojia = list;
		  if(pageinfo.getTotalrow()>0 &&   listQzguojia.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllQzguojiaForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listQzguojia = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到签证国家添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到签证国家修改页面
	 */	
	public String toedit()throws Exception{
	qzguojia = Server.getInstance().getTripService().findQzguojia(qzguojia.getId());
		return EDIT;
	}
	
	/**
	 * 转向到签证国家审核页面
	 */	
	public String tocheck()throws Exception{
	qzguojia = Server.getInstance().getTripService().findQzguojia(qzguojia.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加签证国家
	 */		
	public String add()throws Exception{
	qzguojia.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().createQzguojia(qzguojia);
		return LIST;
	}

	/**
	 * 审核签证国家
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateQzguojiaIgnoreNull(qzguojia);
		return LIST;
	}
	


	/**
	 * 编辑签证国家
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getTripService().updateQzguojiaIgnoreNull(qzguojia);
		return LIST;
	}

	/**
	 * 删除签证国家
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteQzguojia(qzguojia.getId());
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
					Server.getInstance().getTripService().deleteQzguojia(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回签证国家对象
	 */		
	
	public Object getModel() {
		return qzguojia;
	}
	public List < Qzguojia >   getListQzguojia() {
		return listQzguojia;
	}
	public void setListQzguojia(List <  Qzguojia  >  listQzguojia) {
		this.listQzguojia = listQzguojia;
	}
	public Qzguojia getQzguojia() {
		return qzguojia;
	}
	public void setQzguojia(Qzguojia qzguojia) {
		this.qzguojia = qzguojia;
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
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	
	
}