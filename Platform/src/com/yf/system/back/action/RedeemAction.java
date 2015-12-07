/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.redeem.Redeem;
import com.yf.system.base.util.PageInfo;


public class RedeemAction extends B2b2cbackAction {
	private List <  Redeem  >  listRedeem;
	private Redeem redeem = new Redeem();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String c_giftname;
	
	
	/**
	 * 获取兑换订单状态
	 * @param state
	 * @return
	 */
	public String getredeemstate(int state)
	{
		switch(state) {
		case 1:
			return "待审核";
		case 2:
			return "已审核";
		case 3:
			return "待发货";
		case 4:
			return "发货中";
		case 5:
			return "已收货";
		default:
			break;
		}
		return "未知状态";
	}
	/**
	 * 列表查询积分兑换
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (c_giftname!=null && c_giftname.trim().length()!=0) {
			where += " and " + Redeem.COL_giftname +" like '%" + c_giftname.trim()+"%'";	
		}
	    List list = Server.getInstance().getSystemService().findAllRedeemForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listRedeem = list;
		  if(pageinfo.getTotalrow()>0 &&   listRedeem.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getSystemService().findAllRedeemForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listRedeem = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到积分兑换添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到积分兑换修改页面
	 */	
	public String toedit()throws Exception{
	redeem = Server.getInstance().getSystemService().findRedeem(redeem.getId());
		return EDIT;
	}
	
	/**
	 * 转向到积分兑换审核页面
	 */	
	public String tocheck()throws Exception{
	redeem = Server.getInstance().getSystemService().findRedeem(redeem.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加积分兑换
	 */		
	public String add()throws Exception{
	redeem.setCreateuser(getLoginUser().getLoginname());
		redeem.setCreatetime(new Timestamp(System.currentTimeMillis()));
		redeem.setModifyuser(getLoginUser().getLoginname());
		redeem.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getSystemService().createRedeem(redeem);
		return LIST;
	}

	/**
	 * 审核积分兑换
	 */		
	public String check()throws Exception{
	redeem.setModifyuser(getLoginUser().getLoginname());
		redeem.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getSystemService().updateRedeemIgnoreNull(redeem);
		return LIST;
	}
	


	/**
	 * 编辑积分兑换
	 */		
	public String edit()throws Exception{
	redeem.setModifyuser(getLoginUser().getLoginname());
		redeem.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getSystemService().updateRedeemIgnoreNull(redeem);
		return LIST;
	}

	/**
	 * 删除积分兑换
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getSystemService().deleteRedeem(redeem.getId());
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
					Server.getInstance().getSystemService().deleteRedeem(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回积分兑换对象
	 */		
	
	public Object getModel() {
		return redeem;
	}
	public List < Redeem >   getListRedeem() {
		return listRedeem;
	}
	public void setListRedeem(List <  Redeem  >  listRedeem) {
		this.listRedeem = listRedeem;
	}
	public Redeem getRedeem() {
		return redeem;
	}
	public void setRedeem(Redeem redeem) {
		this.redeem = redeem;
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
	public String getC_giftname() {
		return c_giftname;
	}
	public void setC_giftname(String c_giftname) {
		this.c_giftname = c_giftname;
	}
}