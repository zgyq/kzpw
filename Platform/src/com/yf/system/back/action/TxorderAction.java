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
import com.yf.system.base.txorder.Txorder;


public class TxorderAction extends B2b2cbackAction {
	private List <  Txorder  >  listTxorder;
	private Txorder txorder = new Txorder();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询TX订单
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Txorder.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllTxorderForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTxorder = list;
		  if(pageinfo.getTotalrow()>0 &&   listTxorder.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllTxorderForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTxorder = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到TX订单添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到TX订单修改页面
	 */	
	public String toedit()throws Exception{
	txorder = Server.getInstance().getMemberService().findTxorder(txorder.getId());
		return EDIT;
	}
	
	/**
	 * 转向到TX订单审核页面
	 */	
	public String tocheck()throws Exception{
	txorder = Server.getInstance().getMemberService().findTxorder(txorder.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加TX订单
	 */		
	public String add()throws Exception{
	txorder.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createTxorder(txorder);
		return LIST;
	}

	/**
	 * 审核TX订单
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateTxorderIgnoreNull(txorder);
		return LIST;
	}
	


	/**
	 * 编辑TX订单
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateTxorderIgnoreNull(txorder);
		return LIST;
	}

	/**
	 * 删除TX订单
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteTxorder(txorder.getId());
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
					Server.getInstance().getMemberService().deleteTxorder(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回TX订单对象
	 */		
	
	public Object getModel() {
		return txorder;
	}
	public List < Txorder >   getListTxorder() {
		return listTxorder;
	}
	public void setListTxorder(List <  Txorder  >  listTxorder) {
		this.listTxorder = listTxorder;
	}
	public Txorder getTxorder() {
		return txorder;
	}
	public void setTxorder(Txorder txorder) {
		this.txorder = txorder;
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