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
import com.yf.system.base.agentroleref.Agentroleref;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customercredit.Customercredit;
import com.yf.system.base.customerpassenger.Customerpassenger;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.util.PageInfo;
import com.opensymphony.webwork.ServletActionContext;


public class CustomerpassengerAction extends B2b2cbackAction {
	private List <Customerpassenger>  listCustomerpassenger;
	private List <Customercredit>  listCustomercredit;
	private Customerpassenger customerpassenger = new Customerpassenger();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	private int credittype;
	private String creditnumber;
	
	private int credittype2;
	private String creditnumber2;
	
	private int credittype3;
	private String creditnumber3;
	
	//search
	private String s_name;
	private String s_number;
	
	private String customerusername;
	private long c_id;
	
	
	/**
	 * 列表查询常用旅客
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 and "+Customerpassenger.COL_customeruserid+"  in ( select "+Customeruser.COL_id+" from "+Customeruser.TABLE + " where "+ Customeruser.COL_agentid +" = "+getLoginUser().getAgentid() +")";
		String sql=" SELECT * FROM [T_AGENTROLEREF] WHERE C_CUSTOMERUSERID="+this.getLoginUser().getId();
		List<Agentroleref> roles=Server.getInstance().getMemberService().findAllAgentrolerefBySql(sql, -1, 0);
		if(roles!=null&&roles.size()>0){
			Agentroleref agenrole=roles.get(0);
			if(agenrole.getRoleid()==1){
				where="where 1=1";
			}
		}
		//String where = " where 1=1 ";
		if (s_name!=null && s_name.trim().length()!=0) {
			
			where += " and " + Customerpassenger.COL_username +" like '%" + s_name.trim()+"%'";	
		}
		if (s_number!=null && s_number.trim().length()!=0) {
			
			where += " and " + Customerpassenger.COL_mobile +" like '%" + s_number.trim()+"%'";	
		}
		if(customerusername!=null&&customerusername.trim().length()>0){
			where+=" AND "+Customerpassenger.COL_customeruserid+" IN ( SELECT ID FROM T_CUSTOMERUSER WHERE C_MEMBERNAME LIKE '%"+customerusername+"%')";
		}
	    List list = Server.getInstance().getMemberService().findAllCustomerpassengerForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCustomerpassenger = list;
		  if(pageinfo.getTotalrow()>0 &&   listCustomerpassenger.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllCustomerpassengerForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCustomerpassenger = list;
		}
		
		return SUCCESS;
	}
/**
 * @return
 * 根据会员ID查询常用旅客
 */
public String toCustomerpassbaseId(){
	
	try{
	int id=Integer.valueOf(ServletActionContext.getRequest().getParameter("c_id"));
	if(id>0)
	this.c_id=id;
	}catch(Exception e){
		
	}
	
	
	String where="where 1=1 and "+Customerpassenger.COL_customeruserid+"="+c_id;
	if (s_name!=null && s_name.trim().length()!=0) {
		
		where += " and " + Customerpassenger.COL_username +" like '%" + s_name.trim()+"%'";	
	}
	if (s_number!=null && s_number.trim().length()!=0) {
		
		where += " and " + Customerpassenger.COL_mobile +" like '%" + s_number.trim()+"%'";	
	}

    List list = Server.getInstance().getMemberService().findAllCustomerpassengerForPageinfo(where," ORDER BY ID ",pageinfo);
	pageinfo = (PageInfo)list.remove(0);
	listCustomerpassenger = list;
	  if(pageinfo.getTotalrow()>0 &&   listCustomerpassenger.size()==0){
		pageinfo.setPagenum(1);
		list = Server.getInstance().getMemberService().findAllCustomerpassengerForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCustomerpassenger = list;
    	}
		return SUCCESS;
	}

	// 取会员名称
	public String getmembername(long id) {
		// Server.getInstance().getMemberroleManager().findMemberrole(id).getName();
		Customeruser customeruser= Server.getInstance().getMemberService().findCustomeruser(id);
		String membername=customeruser.getMembername();
		Customeragent agent=Server.getInstance().getMemberService().findCustomeragent(customeruser.getAgentid());
		String agentname=agent.getAgentcompanyname();
		return  membername+" / "+agentname;
	}
	/**
	 * 列表查询酒店常用旅客
	 */	
	public String hotel()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Customerpassenger.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllCustomerpassengerForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCustomerpassenger = list;
		  if(pageinfo.getTotalrow()>0 &&   listCustomerpassenger.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllCustomerpassengerForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCustomerpassenger = list;
		}
		 
		
		return "hotel";
	}
	/**
	 * 列表查询机票常用旅客
	 */	
	public String air()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Customerpassenger.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllCustomerpassengerForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCustomerpassenger = list;
		  if(pageinfo.getTotalrow()>0 &&   listCustomerpassenger.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllCustomerpassengerForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCustomerpassenger = list;
		}
		
		return "air";
	}
	
	/**
	 * 转向到常用旅客添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到常用旅客修改页面
	 */	
	public String toedit()throws Exception{
	customerpassenger = Server.getInstance().getMemberService().findCustomerpassenger(customerpassenger.getId());
	String where = " where 1=1 and "+Customercredit.COL_refid +" = "+customerpassenger.getId();
	listCustomercredit = Server.getInstance().getMemberService().findAllCustomercredit(where, " ORDER BY ID ", -1, 0);
		return EDIT;
	}
	

	
	/**
	 * 转向到常用旅客审核页面
	 */	
	public String tocheck()throws Exception{
	customerpassenger = Server.getInstance().getMemberService().findCustomerpassenger(customerpassenger.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加常用旅客
	 */		
	public String add()throws Exception{
		customerpassenger.setCreateuser(getLoginUser().getLoginname());
		customerpassenger.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customerpassenger.setModifyuser(getLoginUser().getLoginname());
		customerpassenger.setModifytime(new Timestamp(System.currentTimeMillis()));
		customerpassenger.setType(1);
		customerpassenger=Server.getInstance().getMemberService().createCustomerpassenger(customerpassenger);
		Customercredit customercredit  = new Customercredit() ;
		if(creditnumber.toString().length()!=0){
		customercredit.setCreditnumber(creditnumber);
		customercredit.setCredittypeid(credittype);
		customercredit.setCreateuser(getLoginUser().getLoginname());
		customercredit.setCreatetime(new Timestamp(System.currentTimeMillis()));
		customercredit.setModifyuser(getLoginUser().getLoginname());
		customercredit.setModifytime(new Timestamp(System.currentTimeMillis()));
		customercredit.setType(1);
		customercredit.setRefid(customerpassenger.getId());
		
		Server.getInstance().getMemberService().createCustomercredit(customercredit);
		}
		if(credittype2!=0){
			
			customercredit.setCreditnumber(creditnumber2);
			customercredit.setCredittypeid(credittype2);
			customercredit.setCreateuser(getLoginUser().getLoginname());
			customercredit.setCreatetime(new Timestamp(System.currentTimeMillis()));
			customercredit.setModifyuser(getLoginUser().getLoginname());
			customercredit.setModifytime(new Timestamp(System.currentTimeMillis()));
			customercredit.setType(1);
			customercredit.setRefid(customerpassenger.getId());
			
			Server.getInstance().getMemberService().createCustomercredit(customercredit);
		}
		if(credittype3!=0){
			
			customercredit.setCreditnumber(creditnumber3);
			customercredit.setCredittypeid(credittype3);
			customercredit.setCreateuser(getLoginUser().getLoginname());
			customercredit.setCreatetime(new Timestamp(System.currentTimeMillis()));
			customercredit.setModifyuser(getLoginUser().getLoginname());
			customercredit.setModifytime(new Timestamp(System.currentTimeMillis()));
			customercredit.setType(1);
			customercredit.setRefid(customerpassenger.getId());
			
			Server.getInstance().getMemberService().createCustomercredit(customercredit);
		}		
		
	
		if(customerpassenger.getCustomeruserid()>0){
			this.c_id=customerpassenger.getCustomeruserid();
			return toCustomerpassbaseId();
		}
		return LIST;
	}

	/**
	 * 审核常用旅客
	 */		
	public String check()throws Exception{
	customerpassenger.setModifyuser(getLoginUser().getLoginname());
		customerpassenger.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updateCustomerpassengerIgnoreNull(customerpassenger);
		return LIST;
	}
	
	
	


	/**
	 * 编辑常用旅客
	 */		
	public String edit()throws Exception{
		/*customerpassenger.setModifyuser(getLoginUser().getLoginname());
		customerpassenger.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updateCustomerpassengerIgnoreNull(customerpassenger);
		String str=ServletActionContext.getRequest().getParameter("c_id");
		if(str!=null&&Integer.valueOf(str)>0){
			this.c_id=Long.valueOf(str);
			return toCustomerpassbaseId();
		}*/
		Customerpassenger cusp=Server.getInstance().getMemberService().findCustomerpassenger(customerpassenger.getId());
		cusp.setModifyuser(getLoginUser().getLoginname());
		cusp.setModifytime(new Timestamp(System.currentTimeMillis()));
		//cusp.setc
		Server.getInstance().getMemberService().updateCustomerpassengerIgnoreNull(customerpassenger);
		
		Customercredit  cuedit= new Customercredit();
		List <Customercredit> list=Server.getInstance().getMemberService().findAllCustomercredit(" where 1=1 and "+Customercredit.COL_refid+" ="+cusp.getId(), "", -1, 0);
		if(list.size()>0){
			
			cuedit=list.get(0);
		}
		
		
		cuedit.setRefid(cusp.getId());
		cuedit.setCreditnumber(creditnumber);
		cuedit.setCredittypeid(credittype);
		if(list.size()>0){
			
			Server.getInstance().getMemberService().updateCustomercreditIgnoreNull(cuedit);
		}else{
			Server.getInstance().getMemberService().createCustomercredit(cuedit);
			
		}
		
		
		String str=ServletActionContext.getRequest().getParameter("c_id");
		if(str!=null&&Integer.valueOf(str)>0){
			this.c_id=Long.valueOf(str);
			return toCustomerpassbaseId();
		}
		return LIST;
	}

	/**
	 * 删除常用旅客
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteCustomerpassenger(customerpassenger.getId());
		String str=ServletActionContext.getRequest().getParameter("c_id");
		if(str!=null&&Integer.valueOf(str)>0){
			this.c_id=Long.valueOf(str);
			return toCustomerpassbaseId();
		}
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
					Server.getInstance().getMemberService().deleteCustomerpassenger(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		String str=ServletActionContext.getRequest().getParameter("c_id");
		if(str!=null&&Integer.valueOf(str)>0){
			this.c_id=Long.valueOf(str);
			return toCustomerpassbaseId();
		}
		return LIST;
	}






	/**
	 *  返回常用旅客对象
	 */		
	
	public Object getModel() {
		return customerpassenger;
	}
	public List < Customerpassenger >   getListCustomerpassenger() {
		return listCustomerpassenger;
	}
	public void setListCustomerpassenger(List <  Customerpassenger  >  listCustomerpassenger) {
		this.listCustomerpassenger = listCustomerpassenger;
	}
	public Customerpassenger getCustomerpassenger() {
		return customerpassenger;
	}
	public void setCustomerpassenger(Customerpassenger customerpassenger) {
		this.customerpassenger = customerpassenger;
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

	public int getCredittype() {
		return credittype;
	}

	public void setCredittype(int credittype) {
		this.credittype = credittype;
	}

	public String getCreditnumber() {
		return creditnumber;
	}

	public void setCreditnumber(String creditnumber) {
		this.creditnumber = creditnumber;
	}

	public int getCredittype2() {
		return credittype2;
	}

	public void setCredittype2(int credittype2) {
		this.credittype2 = credittype2;
	}

	public String getCreditnumber2() {
		return creditnumber2;
	}

	public void setCreditnumber2(String creditnumber2) {
		this.creditnumber2 = creditnumber2;
	}

	public int getCredittype3() {
		return credittype3;
	}

	public void setCredittype3(int credittype3) {
		this.credittype3 = credittype3;
	}

	public String getCreditnumber3() {
		return creditnumber3;
	}

	public void setCreditnumber3(String creditnumber3) {
		this.creditnumber3 = creditnumber3;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_number() {
		return s_number;
	}

	public void setS_number(String s_number) {
		this.s_number = s_number;
	}

	public List<Customercredit> getListCustomercredit() {
		return listCustomercredit;
	}

	public void setListCustomercredit(List<Customercredit> listCustomercredit) {
		this.listCustomercredit = listCustomercredit;
	}
	public long getC_id() {
		return c_id;
	}
	public void setC_id(long c_id) {
		this.c_id = c_id;
	}
	public String getCustomerusername() {
		return customerusername;
	}
	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}

	
	
	
}