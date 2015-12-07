/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.fsendticketcity.Fsendticketcity;
import com.yf.system.base.util.PageInfo;


public class FsendticketcityAction extends B2b2cbackAction {
	private List <  Fsendticketcity  >  listFsendticketcity;
	private Fsendticketcity fsendticketcity = new Fsendticketcity();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询国际机票送票城市
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Fsendticketcity.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getInterticketService().findAllFsendticketcityForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listFsendticketcity = list;
		  if(pageinfo.getTotalrow()>0 &&   listFsendticketcity.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getInterticketService().findAllFsendticketcityForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listFsendticketcity = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到国际机票送票城市添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到国际机票送票城市修改页面
	 */	
	public String toedit()throws Exception{
	fsendticketcity = Server.getInstance().getInterticketService().findFsendticketcity(fsendticketcity.getId());
		return EDIT;
	}
	
	/**
	 * 转向到国际机票送票城市审核页面
	 */	
	public String tocheck()throws Exception{
	fsendticketcity = Server.getInstance().getInterticketService().findFsendticketcity(fsendticketcity.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加国际机票送票城市
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getInterticketService().createFsendticketcity(fsendticketcity);
		return LIST;
	}

	/**
	 * 审核国际机票送票城市
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getInterticketService().updateFsendticketcityIgnoreNull(fsendticketcity);
		return LIST;
	}
	


	/**
	 * 编辑国际机票送票城市
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getInterticketService().updateFsendticketcityIgnoreNull(fsendticketcity);
		return LIST;
	}

	/**
	 * 删除国际机票送票城市
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getInterticketService().deleteFsendticketcity(fsendticketcity.getId());
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
					Server.getInstance().getInterticketService().deleteFsendticketcity(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回国际机票送票城市对象
	 */		
	
	public Object getModel() {
		return fsendticketcity;
	}
	public List < Fsendticketcity >   getListFsendticketcity() {
		return listFsendticketcity;
	}
	public void setListFsendticketcity(List <  Fsendticketcity  >  listFsendticketcity) {
		this.listFsendticketcity = listFsendticketcity;
	}
	public Fsendticketcity getFsendticketcity() {
		return fsendticketcity;
	}
	public void setFsendticketcity(Fsendticketcity fsendticketcity) {
		this.fsendticketcity = fsendticketcity;
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