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
import com.yf.system.base.forderinfo.Forderinfo;


public class ForderinfoAction extends B2b2cbackAction {
	private List <  Forderinfo  >  listForderinfo;
	private Forderinfo forderinfo = new Forderinfo();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询国际机票订单表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Forderinfo.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getInterticketService().findAllForderinfoForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listForderinfo = list;
		  if(pageinfo.getTotalrow()>0 &&   listForderinfo.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getInterticketService().findAllForderinfoForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listForderinfo = list;
		}
		
		return SUCCESS;
	}
	
	public String getPayMethod(Integer id)
	{
		switch (id){
		case 0:
			return "未支付";
		case 1:
			return "已支付";
		default:
			return "未支付";
		}
	}
	
	//订单状态:1.等待支付2.支付成功3.出票完成4.申请废票5.申请退票6.取消订单7.等待审核8.审核失败9.退款成功10.订单关闭11.已经废票12.已经退票13.申请改签14.已经改签
	public String getStateToString(Integer id) {
		switch (id) {
		

		case 1:

			return "等待支付";

		case 2:

			return "等待出票";

		case 3:

			return "出票完成";
		case 4:

			return "申请退票";
	
		case 5:

			return "申请废票";

		case 6:

			return "取消订单";

		case 7:

			return "废票不成功";
	

		case 8:

			return "审核失败";

		case 9:

			return "废票退款成功";

		case 10:

			return "订单完成";

		case 11:

			return "已经废票";
		case 12:

			return "已经退票";
	

		case 13:

			return "申请改签";

		case 14:

			return "已经改签";

		case 15:

			return "改签失败";
		case 16:

			return "暂不能出票";
		
		case 17:

			return "退票不成功";
		case 18:

			return "退票退款成功";
		case 19:

			return "问题订单";
		case 23:

			return "申请升舱";
			
		case 24:

			return "已换开";
		case 25:

			return "升舱换开成功";
		case 26:

			return "升舱失败";
		case 27:
			return "待确认";
		case 28:
			return "在途订单";
		case 29:
			return "待收银";
		case 30:
			return "申请换开";

		default:
			return "新订单";
		}
	}
	
	
	public String toedit()throws Exception{
	forderinfo = Server.getInstance().getInterticketService().findForderinfo(forderinfo.getId());
		return EDIT;
	}
	
	/**
	 * 转向到国际机票订单表审核页面
	 */	
	public String tocheck()throws Exception{
	forderinfo = Server.getInstance().getInterticketService().findForderinfo(forderinfo.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加国际机票订单表
	 */		
	public String add()throws Exception{
	forderinfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getInterticketService().createForderinfo(forderinfo);
		return LIST;
	}

	/**
	 * 审核国际机票订单表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getInterticketService().updateForderinfoIgnoreNull(forderinfo);
		return LIST;
	}
	


	/**
	 * 编辑国际机票订单表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getInterticketService().updateForderinfoIgnoreNull(forderinfo);
		return LIST;
	}

	/**
	 * 删除国际机票订单表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getInterticketService().deleteForderinfo(forderinfo.getId());
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
					Server.getInstance().getInterticketService().deleteForderinfo(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回国际机票订单表对象
	 */		
	
	public Object getModel() {
		return forderinfo;
	}
	public List < Forderinfo >   getListForderinfo() {
		return listForderinfo;
	}
	public void setListForderinfo(List <  Forderinfo  >  listForderinfo) {
		this.listForderinfo = listForderinfo;
	}
	public Forderinfo getForderinfo() {
		return forderinfo;
	}
	public void setForderinfo(Forderinfo forderinfo) {
		this.forderinfo = forderinfo;
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