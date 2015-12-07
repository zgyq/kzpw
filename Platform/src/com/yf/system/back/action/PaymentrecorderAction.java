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
import com.yf.system.base.paymentrecorder.Paymentrecorder;


public class PaymentrecorderAction extends B2b2cbackAction {
	private List <  Paymentrecorder  >  listPaymentrecorder;
	private Paymentrecorder paymentrecorder = new Paymentrecorder();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询支付记录
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Paymentrecorder.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllPaymentrecorderForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listPaymentrecorder = list;
		  if(pageinfo.getTotalrow()>0 &&   listPaymentrecorder.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllPaymentrecorderForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listPaymentrecorder = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到支付记录添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到支付记录修改页面
	 */	
	public String toedit()throws Exception{
	paymentrecorder = Server.getInstance().getAirService().findPaymentrecorder(paymentrecorder.getId());
		return EDIT;
	}
	
	/**
	 * 转向到支付记录审核页面
	 */	
	public String tocheck()throws Exception{
	paymentrecorder = Server.getInstance().getAirService().findPaymentrecorder(paymentrecorder.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加支付记录
	 */		
	public String add()throws Exception{
	paymentrecorder.setCreateuser(getLoginUser().getLoginname());
		paymentrecorder.setCreatetime(new Timestamp(System.currentTimeMillis()));
		paymentrecorder.setModifyuser(getLoginUser().getLoginname());
		paymentrecorder.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().createPaymentrecorder(paymentrecorder);
		return LIST;
	}

	/**
	 * 审核支付记录
	 */		
	public String check()throws Exception{
	paymentrecorder.setModifyuser(getLoginUser().getLoginname());
		paymentrecorder.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updatePaymentrecorderIgnoreNull(paymentrecorder);
		return LIST;
	}
	


	/**
	 * 编辑支付记录
	 */		
	public String edit()throws Exception{
	paymentrecorder.setModifyuser(getLoginUser().getLoginname());
		paymentrecorder.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updatePaymentrecorderIgnoreNull(paymentrecorder);
		return LIST;
	}

	/**
	 * 删除支付记录
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deletePaymentrecorder(paymentrecorder.getId());
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
					Server.getInstance().getAirService().deletePaymentrecorder(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回支付记录对象
	 */		
	
	public Object getModel() {
		return paymentrecorder;
	}
	public List < Paymentrecorder >   getListPaymentrecorder() {
		return listPaymentrecorder;
	}
	public void setListPaymentrecorder(List <  Paymentrecorder  >  listPaymentrecorder) {
		this.listPaymentrecorder = listPaymentrecorder;
	}
	public Paymentrecorder getPaymentrecorder() {
		return paymentrecorder;
	}
	public void setPaymentrecorder(Paymentrecorder paymentrecorder) {
		this.paymentrecorder = paymentrecorder;
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