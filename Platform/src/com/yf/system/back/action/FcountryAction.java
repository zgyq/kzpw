/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.fcountry.Fcountry;
import com.yf.system.base.util.PageInfo;


public class FcountryAction extends B2b2cbackAction {
	private List <  Fcountry  >  listFcountry;
	private Fcountry fcountry = new Fcountry();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询国际机票国家
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Fcountry.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getInterticketService().findAllFcountryForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listFcountry = list;
		  if(pageinfo.getTotalrow()>0 &&   listFcountry.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getInterticketService().findAllFcountryForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listFcountry = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到国际机票国家添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到国际机票国家修改页面
	 */	
	public String toedit()throws Exception{
	fcountry = Server.getInstance().getInterticketService().findFcountry(fcountry.getId());
		return EDIT;
	}
	
	/**
	 * 转向到国际机票国家审核页面
	 */	
	public String tocheck()throws Exception{
	fcountry = Server.getInstance().getInterticketService().findFcountry(fcountry.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加国际机票国家
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getInterticketService().createFcountry(fcountry);
		return LIST;
	}

	/**
	 * 审核国际机票国家
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getInterticketService().updateFcountryIgnoreNull(fcountry);
		return LIST;
	}
	


	/**
	 * 编辑国际机票国家
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getInterticketService().updateFcountryIgnoreNull(fcountry);
		return LIST;
	}

	/**
	 * 删除国际机票国家
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getInterticketService().deleteFcountry(fcountry.getId());
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
					Server.getInstance().getInterticketService().deleteFcountry(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回国际机票国家对象
	 */		
	
	public Object getModel() {
		return fcountry;
	}
	public List < Fcountry >   getListFcountry() {
		return listFcountry;
	}
	public void setListFcountry(List <  Fcountry  >  listFcountry) {
		this.listFcountry = listFcountry;
	}
	public Fcountry getFcountry() {
		return fcountry;
	}
	public void setFcountry(Fcountry fcountry) {
		this.fcountry = fcountry;
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