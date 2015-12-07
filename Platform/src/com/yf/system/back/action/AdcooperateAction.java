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
import com.yf.system.base.adcooperate.Adcooperate;


public class AdcooperateAction extends B2b2cbackAction {
	private List <  Adcooperate  >  listAdcooperate;
	private Adcooperate adcooperate = new Adcooperate();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询广告合作表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Adcooperate.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllAdcooperateForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listAdcooperate = list;
		  if(pageinfo.getTotalrow()>0 &&   listAdcooperate.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllAdcooperateForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listAdcooperate = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到广告合作表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到广告合作表修改页面
	 */	
	public String toedit()throws Exception{
	adcooperate = Server.getInstance().getMemberService().findAdcooperate(adcooperate.getId());
		return EDIT;
	}
	
	/**
	 * 转向到广告合作表审核页面
	 */	
	public String tocheck()throws Exception{
	adcooperate = Server.getInstance().getMemberService().findAdcooperate(adcooperate.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加广告合作表
	 */		
	public String add()throws Exception{
	adcooperate.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createAdcooperate(adcooperate);
		return LIST;
	}

	/**
	 * 审核广告合作表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateAdcooperateIgnoreNull(adcooperate);
		return LIST;
	}
	


	/**
	 * 编辑广告合作表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateAdcooperateIgnoreNull(adcooperate);
		return LIST;
	}

	/**
	 * 删除广告合作表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteAdcooperate(adcooperate.getId());
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
					Server.getInstance().getMemberService().deleteAdcooperate(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回广告合作表对象
	 */		
	
	public Object getModel() {
		return adcooperate;
	}
	public List < Adcooperate >   getListAdcooperate() {
		return listAdcooperate;
	}
	public void setListAdcooperate(List <  Adcooperate  >  listAdcooperate) {
		this.listAdcooperate = listAdcooperate;
	}
	public Adcooperate getAdcooperate() {
		return adcooperate;
	}
	public void setAdcooperate(Adcooperate adcooperate) {
		this.adcooperate = adcooperate;
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