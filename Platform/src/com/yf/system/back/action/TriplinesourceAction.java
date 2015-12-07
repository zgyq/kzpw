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
import com.yf.system.base.triplinesource.Triplinesource;


public class TriplinesourceAction extends B2b2cbackAction {
	private List <  Triplinesource  >  listTriplinesource;
	private Triplinesource triplinesource = new Triplinesource();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询旅游线路来源
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Triplinesource.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllTriplinesourceForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTriplinesource = list;
		  if(pageinfo.getTotalrow()>0 &&   listTriplinesource.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllTriplinesourceForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTriplinesource = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到旅游线路来源添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到旅游线路来源修改页面
	 */	
	public String toedit()throws Exception{
	triplinesource = Server.getInstance().getTripService().findTriplinesource(triplinesource.getId());
		return EDIT;
	}
	
	/**
	 * 转向到旅游线路来源审核页面
	 */	
	public String tocheck()throws Exception{
	triplinesource = Server.getInstance().getTripService().findTriplinesource(triplinesource.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加旅游线路来源
	 */		
	public String add()throws Exception{
	triplinesource.setCreateuser(getLoginUser().getLoginname());
		triplinesource.setCreatetime(new Timestamp(System.currentTimeMillis()));
		triplinesource.setModifyuser(getLoginUser().getLoginname());
		triplinesource.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().createTriplinesource(triplinesource);
		return LIST;
	}

	/**
	 * 审核旅游线路来源
	 */		
	public String check()throws Exception{
	triplinesource.setModifyuser(getLoginUser().getLoginname());
		triplinesource.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().updateTriplinesourceIgnoreNull(triplinesource);
		return LIST;
	}
	


	/**
	 * 编辑旅游线路来源
	 */		
	public String edit()throws Exception{
	triplinesource.setModifyuser(getLoginUser().getLoginname());
		triplinesource.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getTripService().updateTriplinesourceIgnoreNull(triplinesource);
		return LIST;
	}

	/**
	 * 删除旅游线路来源
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteTriplinesource(triplinesource.getId());
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
					Server.getInstance().getTripService().deleteTriplinesource(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回旅游线路来源对象
	 */		
	
	public Object getModel() {
		return triplinesource;
	}
	public List < Triplinesource >   getListTriplinesource() {
		return listTriplinesource;
	}
	public void setListTriplinesource(List <  Triplinesource  >  listTriplinesource) {
		this.listTriplinesource = listTriplinesource;
	}
	public Triplinesource getTriplinesource() {
		return triplinesource;
	}
	public void setTriplinesource(Triplinesource triplinesource) {
		this.triplinesource = triplinesource;
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