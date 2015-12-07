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
import com.yf.system.base.ympay.Ympay;


public class YmpayAction extends B2b2cbackAction {
	private List <  Ympay  >  listYmpay;
	private Ympay ympay = new Ympay();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询短信充值记录
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Ympay.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllYmpayForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listYmpay = list;
		  if(pageinfo.getTotalrow()>0 &&   listYmpay.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllYmpayForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listYmpay = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到短信充值记录添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到短信充值记录修改页面
	 */	
	public String toedit()throws Exception{
	ympay = Server.getInstance().getMemberService().findYmpay(ympay.getId());
		return EDIT;
	}
	
	/**
	 * 转向到短信充值记录审核页面
	 */	
	public String tocheck()throws Exception{
	ympay = Server.getInstance().getMemberService().findYmpay(ympay.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加短信充值记录
	 */		
	public String add()throws Exception{
	ympay.setCreateuser(getLoginUser().getLoginname());
		ympay.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createYmpay(ympay);
		return LIST;
	}

	/**
	 * 审核短信充值记录
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateYmpayIgnoreNull(ympay);
		return LIST;
	}
	


	/**
	 * 编辑短信充值记录
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateYmpayIgnoreNull(ympay);
		return LIST;
	}

	/**
	 * 删除短信充值记录
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteYmpay(ympay.getId());
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
					Server.getInstance().getMemberService().deleteYmpay(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回短信充值记录对象
	 */		
	
	public Object getModel() {
		return ympay;
	}
	public List < Ympay >   getListYmpay() {
		return listYmpay;
	}
	public void setListYmpay(List <  Ympay  >  listYmpay) {
		this.listYmpay = listYmpay;
	}
	public Ympay getYmpay() {
		return ympay;
	}
	public void setYmpay(Ympay ympay) {
		this.ympay = ympay;
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