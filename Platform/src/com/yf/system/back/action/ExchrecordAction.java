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
import com.yf.system.base.exchrecord.Exchrecord;


public class ExchrecordAction extends B2b2cbackAction {
	private List <  Exchrecord  >  listExchrecord;
	private Exchrecord exchrecord = new Exchrecord();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询积分兑换纪录
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Exchrecord.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllExchrecordForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listExchrecord = list;
		  if(pageinfo.getTotalrow()>0 &&   listExchrecord.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllExchrecordForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listExchrecord = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到积分兑换纪录添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到积分兑换纪录修改页面
	 */	
	public String toedit()throws Exception{
	exchrecord = Server.getInstance().getMemberService().findExchrecord(exchrecord.getId());
		return EDIT;
	}
	
	/**
	 * 转向到积分兑换纪录审核页面
	 */	
	public String tocheck()throws Exception{
	exchrecord = Server.getInstance().getMemberService().findExchrecord(exchrecord.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加积分兑换纪录
	 */		
	public String add()throws Exception{
	exchrecord.setCreateuser(getLoginUser().getLoginname());
		exchrecord.setCreatetime(new Timestamp(System.currentTimeMillis()));
		exchrecord.setModifyuser(getLoginUser().getLoginname());
		exchrecord.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createExchrecord(exchrecord);
		return LIST;
	}

	/**
	 * 审核积分兑换纪录
	 */		
	public String check()throws Exception{
	exchrecord.setModifyuser(getLoginUser().getLoginname());
		exchrecord.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updateExchrecordIgnoreNull(exchrecord);
		return LIST;
	}
	


	/**
	 * 编辑积分兑换纪录
	 */		
	public String edit()throws Exception{
	exchrecord.setModifyuser(getLoginUser().getLoginname());
		exchrecord.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updateExchrecordIgnoreNull(exchrecord);
		return LIST;
	}

	/**
	 * 删除积分兑换纪录
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteExchrecord(exchrecord.getId());
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
					Server.getInstance().getMemberService().deleteExchrecord(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回积分兑换纪录对象
	 */		
	
	public Object getModel() {
		return exchrecord;
	}
	public List < Exchrecord >   getListExchrecord() {
		return listExchrecord;
	}
	public void setListExchrecord(List <  Exchrecord  >  listExchrecord) {
		this.listExchrecord = listExchrecord;
	}
	public Exchrecord getExchrecord() {
		return exchrecord;
	}
	public void setExchrecord(Exchrecord exchrecord) {
		this.exchrecord = exchrecord;
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