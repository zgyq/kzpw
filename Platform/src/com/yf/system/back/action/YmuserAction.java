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
import com.yf.system.base.ymuser.Ymuser;


public class YmuserAction extends B2b2cbackAction {
	private List <  Ymuser  >  listYmuser;
	private Ymuser ymuser = new Ymuser();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	private String txtVMoney;//充值金额
	
	/**
	 * 列表查询短信用户账号
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Ymuser.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllYmuserForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listYmuser = list;
		  if(pageinfo.getTotalrow()>0 &&   listYmuser.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllYmuserForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listYmuser = list;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 转向到短信用户账号添加页面
	 */	
	public String torecharge()throws Exception{
		
		
		
		return "torecharge";
	}
	
	public String tocreatePay()throws Exception{
		
	Ympay ympay=new Ympay();	
	ympay.setAgentid(getLoginUser().getId()+"");
	ympay.setPrice(txtVMoney);
	
	Double duanxinnum=Double.parseDouble(txtVMoney)*100/8;
	
	
	
	ympay.setMemnum(Long.parseLong((duanxinnum+"").split("[.]")[0]));
	ympay.setCreatetime(new Timestamp(System.currentTimeMillis()));
	ympay.setCreateuser(getLoginUser().getLoginname());
	ympay.setState(1l);//1待支付
	Server.getInstance().getMemberService().createYmpay(ympay);
		return "tocreatePay";
	}
	
	/**
	 * 转向到短信用户账号添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到短信用户账号修改页面
	 */	
	public String toedit()throws Exception{
	ymuser = Server.getInstance().getMemberService().findYmuser(ymuser.getId());
		return EDIT;
	}
	
	/**
	 * 转向到短信用户账号审核页面
	 */	
	public String tocheck()throws Exception{
	ymuser = Server.getInstance().getMemberService().findYmuser(ymuser.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加短信用户账号
	 */		
	public String add()throws Exception{
	ymuser.setCreateuser(getLoginUser().getLoginname());
		ymuser.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createYmuser(ymuser);
		return LIST;
	}

	/**
	 * 审核短信用户账号
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateYmuserIgnoreNull(ymuser);
		return LIST;
	}
	


	/**
	 * 编辑短信用户账号
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateYmuserIgnoreNull(ymuser);
		return LIST;
	}

	/**
	 * 删除短信用户账号
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteYmuser(ymuser.getId());
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
					Server.getInstance().getMemberService().deleteYmuser(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回短信用户账号对象
	 */		
	
	public Object getModel() {
		return ymuser;
	}
	public List < Ymuser >   getListYmuser() {
		return listYmuser;
	}
	public void setListYmuser(List <  Ymuser  >  listYmuser) {
		this.listYmuser = listYmuser;
	}
	public Ymuser getYmuser() {
		return ymuser;
	}
	public void setYmuser(Ymuser ymuser) {
		this.ymuser = ymuser;
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

	public String getTxtVMoney() {
		return txtVMoney;
	}

	public void setTxtVMoney(String txtVMoney) {
		this.txtVMoney = txtVMoney;
	}
	
	
}