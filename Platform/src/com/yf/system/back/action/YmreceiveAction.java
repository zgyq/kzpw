/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.ymreceive.Ymreceive;


public class YmreceiveAction extends B2b2cbackAction {
	private List <  Ymreceive  >  listYmreceive;
	private Ymreceive ymreceive = new Ymreceive();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询短信接收表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Ymreceive.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllYmreceiveForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listYmreceive = list;
		  if(pageinfo.getTotalrow()>0 &&   listYmreceive.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllYmreceiveForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listYmreceive = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到短信接收表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到短信接收表修改页面
	 */	
	public String toedit()throws Exception{
	ymreceive = Server.getInstance().getMemberService().findYmreceive(ymreceive.getId());
		return EDIT;
	}
	
	/**
	 * 转向到短信接收表审核页面
	 */	
	public String tocheck()throws Exception{
	ymreceive = Server.getInstance().getMemberService().findYmreceive(ymreceive.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加短信接收表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getMemberService().createYmreceive(ymreceive);
		return LIST;
	}

	/**
	 * 审核短信接收表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateYmreceiveIgnoreNull(ymreceive);
		return LIST;
	}
	


	/**
	 * 编辑短信接收表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateYmreceiveIgnoreNull(ymreceive);
		return LIST;
	}

	/**
	 * 删除短信接收表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteYmreceive(ymreceive.getId());
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
					Server.getInstance().getMemberService().deleteYmreceive(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回短信接收表对象
	 */		
	
	public Object getModel() {
		return ymreceive;
	}
	public List < Ymreceive >   getListYmreceive() {
		return listYmreceive;
	}
	public void setListYmreceive(List <  Ymreceive  >  listYmreceive) {
		this.listYmreceive = listYmreceive;
	}
	public Ymreceive getYmreceive() {
		return ymreceive;
	}
	public void setYmreceive(Ymreceive ymreceive) {
		this.ymreceive = ymreceive;
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