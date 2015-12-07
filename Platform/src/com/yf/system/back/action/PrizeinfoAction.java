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
import com.yf.system.base.prizeinfo.Prizeinfo;


public class PrizeinfoAction extends B2b2cbackAction {
	private List <  Prizeinfo  >  listPrizeinfo;
	private Prizeinfo prizeinfo = new Prizeinfo();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询积分礼品信息
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Prizeinfo.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllPrizeinfoForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listPrizeinfo = list;
		  if(pageinfo.getTotalrow()>0 &&   listPrizeinfo.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllPrizeinfoForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listPrizeinfo = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到积分礼品信息添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到积分礼品信息修改页面
	 */	
	public String toedit()throws Exception{
	prizeinfo = Server.getInstance().getMemberService().findPrizeinfo(prizeinfo.getId());
		return EDIT;
	}
	
	/**
	 * 转向到积分礼品信息审核页面
	 */	
	public String tocheck()throws Exception{
	prizeinfo = Server.getInstance().getMemberService().findPrizeinfo(prizeinfo.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加积分礼品信息
	 */		
	public String add()throws Exception{
	prizeinfo.setCreateuser(getLoginUser().getLoginname());
		prizeinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		prizeinfo.setModifyuser(getLoginUser().getLoginname());
		prizeinfo.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createPrizeinfo(prizeinfo);
		return LIST;
	}

	/**
	 * 审核积分礼品信息
	 */		
	public String check()throws Exception{
	prizeinfo.setModifyuser(getLoginUser().getLoginname());
		prizeinfo.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updatePrizeinfoIgnoreNull(prizeinfo);
		return LIST;
	}
	


	/**
	 * 编辑积分礼品信息
	 */		
	public String edit()throws Exception{
	prizeinfo.setModifyuser(getLoginUser().getLoginname());
		prizeinfo.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updatePrizeinfoIgnoreNull(prizeinfo);
		return LIST;
	}

	/**
	 * 删除积分礼品信息
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deletePrizeinfo(prizeinfo.getId());
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
					Server.getInstance().getMemberService().deletePrizeinfo(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回积分礼品信息对象
	 */		
	
	public Object getModel() {
		return prizeinfo;
	}
	public List < Prizeinfo >   getListPrizeinfo() {
		return listPrizeinfo;
	}
	public void setListPrizeinfo(List <  Prizeinfo  >  listPrizeinfo) {
		this.listPrizeinfo = listPrizeinfo;
	}
	public Prizeinfo getPrizeinfo() {
		return prizeinfo;
	}
	public void setPrizeinfo(Prizeinfo prizeinfo) {
		this.prizeinfo = prizeinfo;
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