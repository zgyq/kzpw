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
import com.yf.system.base.zhefan.Zhefan;


public class ZhefanAction extends B2b2cbackAction {
	private List <  Zhefan  >  listZhefan;
	private Zhefan zhefan = new Zhefan();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	
	private int isadd=0;
	
	//search
	//private String s_name;
	
	private Zhefan zhefan2;
	/**
	 * 列表查询折返
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Zhefan.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllZhefanForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listZhefan = list;
		  if(pageinfo.getTotalrow()>0 &&   listZhefan.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllZhefanForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listZhefan = list;
		}
		  isadd=0;
		return SUCCESS;
	}
	/**
	 * 转向到折返添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到折返修改页面
	 */	
	public String toedit()throws Exception{
	zhefan2 = Server.getInstance().getAirService().findZhefan(zhefan.getId());
	isadd=1;
		return EDIT;
	}
	
	/**
	 * 转向到折返审核页面
	 */	
	public String tocheck()throws Exception{
	zhefan = Server.getInstance().getAirService().findZhefan(zhefan.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加折返
	 */		
	public String add()throws Exception{
	zhefan.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().createZhefan(zhefan);
		return LIST;
	}

	/**
	 * 审核折返
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateZhefanIgnoreNull(zhefan);
		return LIST;
	}
	


	/**
	 * 编辑折返
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateZhefanIgnoreNull(zhefan);
		return LIST;
	}

	/**
	 * 删除折返
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteZhefan(zhefan.getId());
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
					Server.getInstance().getAirService().deleteZhefan(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回折返对象
	 */		
	
	public Object getModel() {
		return zhefan;
	}
	public List < Zhefan >   getListZhefan() {
		return listZhefan;
	}
	public void setListZhefan(List <  Zhefan  >  listZhefan) {
		this.listZhefan = listZhefan;
	}
	public Zhefan getZhefan() {
		return zhefan;
	}
	public void setZhefan(Zhefan zhefan) {
		this.zhefan = zhefan;
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
	public int getIsadd() {
		return isadd;
	}
	public void setIsadd(int isadd) {
		this.isadd = isadd;
	}
	public Zhefan getZhefan2() {
		return zhefan2;
	}
	public void setZhefan2(Zhefan zhefan2) {
		this.zhefan2 = zhefan2;
	}
	
	
}