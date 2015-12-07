package com.yf.system.back.services.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yf.system.back.action.B2b2cbackAction;
import com.yf.system.back.action.CustomeruserAction;
import com.yf.system.back.server.Server;
import com.yf.system.back.services.CustomeragentService;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.rebaterecord.Rebaterecord;
import com.yf.system.base.rebaterule.Rebaterule;
import com.yf.system.base.service.IMemberService;
import com.yf.system.base.systemrole.Systemrole;
import com.yf.system.framework.service.ServiceSupport;

public class CustomeragentServiceImpl extends ServiceSupport implements
		CustomeragentService {

	//private Customeragent customeragent;

	private IMemberService memberservice;

	/**
	 * @param money
	 * @return
	 */
	public float addAgentvmoney(long agentid,float money){
		
		String sql="UPDATE T_CUSTOMERAGENT SET C_VMONEY=C_VMONEY+"+money+" WHERE ID="+agentid+";" +
				"SELECT C_VMONEY FROM T_CUSTOMERAGENT WHERE ID="+agentid;
		Map map=(Map)Server.getInstance().getSystemService().findMapResultBySql(sql, null).get(0);
		
		return Float.valueOf(map.get("C_VMONEY").toString());
		
		
	}

	@Override
	public void add(Customeragent agent) {
	}

	@Override
	public void add(Customeragent customeragent, Customeruser user,String[]business,long  createagentid) {
		try {
			customeragent.setCreatetime(this.getCurrentTime());
			customeragent.setModifytime(this.getCurrentTime());
			customeragent.setVmoney(0f);
			// 创建加盟商。
			System.out.println(customeragent.getAgenttype());
			
			
			
			Customeragent agent = this.getMemberservice().createCustomeragent(customeragent);
		/*	if(agent.getAgenttype()==2){//供应商
				agent.setCode("CVGY"+(agent.getId()+10000));
			}
			if(agent.getAgenttype()==3){//分销商
				agent.setCode("CVCG"+(agent.getId()+10000));
			}
			System.out.println("code:"+agent.getCode());
			this.getMemberservice().updateCustomeragentIgnoreNull(agent);*/
			
			
			//执行加盟费分配
			List<Rebaterule>list=Server.getInstance().getMemberService().findAllRebaterule(" WHERE 1=1 ", " ORDER BY ID ", -1, 0);
			
			if(list!=null&&list.size()>3){
			Float fuwufei=Server.getInstance().getMemberService().findRebaterule(4l).getRebatvalue();
			Float yiji=Server.getInstance().getMemberService().findRebaterule(1l).getRebatvalue();
			Float erji=Server.getInstance().getMemberService().findRebaterule(2l).getRebatvalue();
			Float sanji=Server.getInstance().getMemberService().findRebaterule(3l).getRebatvalue();
			
			
			 if(agent!=null&&agent.getParentid()!=46){
				  Customeragent agen_sanji=Server.getInstance().getMemberService().findCustomeragent(agent.getParentid());
				  Float pr=fuwufei*sanji/100;
				  //agen_t.setVmoney(agen_t.getVmoney()+pr);
				 // Server.getInstance().getMemberService().updateCustomeragentIgnoreNull(agen_t);
				  new CustomeragentServiceImpl().addAgentvmoney(agent.getParentid(), pr);
				  
				  	Customeragent agen_ad=Server.getInstance().getMemberService().findCustomeragent(createagentid);
				  	
					Rebaterecord record = new Rebaterecord();
					record.setOrdernumber("");
					record.setRebatemoney(pr);
					record.setCustomerid(46);
					record.setRebatetype(2);
					record.setYewutype(9);
					// record.setRebateagentjibie(getrebatagent.getAgentjibie());
					record.setRebateagentid(agent.getParentid());
					record.setChildagentid(agent.getId());
					record.setRebatetime(this.getCurrentTime());
					record.setChildagentid(0);
					String memo = "通过加盟开户获得" + pr + "元(执行操作的代理为:"+agen_ad.getAgentcompanyname()+",新开代理:"+agent.getAgentcompanyname()+")";
					record.setRebatememo(memo);
					Server.getInstance().getMemberService().createRebaterecord(record);
					
					
					if(agen_sanji!=null&&agen_sanji.getParentid()!=46){
						  Customeragent agen_erji=Server.getInstance().getMemberService().findCustomeragent(agen_sanji.getParentid());
						  Float pr_erji=fuwufei*erji/100;
						  //agen_t.setVmoney(agen_t.getVmoney()+pr);
						 // Server.getInstance().getMemberService().updateCustomeragentIgnoreNull(agen_t);
						  new CustomeragentServiceImpl().addAgentvmoney(agen_sanji.getParentid(), pr_erji);
						  
						  	
							Rebaterecord record2 = new Rebaterecord();
							record2.setOrdernumber("");
							record2.setRebatemoney(pr_erji);
							record2.setCustomerid(46);
							record2.setRebatetype(2);
							record2.setYewutype(9);
							// record.setRebateagentjibie(getrebatagent.getAgentjibie());
							record2.setRebateagentid(agen_sanji.getParentid());
							record2.setChildagentid(agent.getId());
							record2.setRebatetime(this.getCurrentTime());
							record2.setChildagentid(0);
							String memo2 = "通过加盟开户获得" + pr + "元(执行操作的代理为:"+agen_ad.getAgentcompanyname()+",新开代理:"+agent.getAgentcompanyname()+")";
							record.setRebatememo(memo2);
							Server.getInstance().getMemberService().createRebaterecord(record2);
							
							if(agen_erji!=null&&agen_erji.getParentid()!=46){
								  Customeragent agen_yi=Server.getInstance().getMemberService().findCustomeragent(agen_erji.getParentid());
								  Float pr_yiji=fuwufei*erji/100;
								  //agen_t.setVmoney(agen_t.getVmoney()+pr);
								 // Server.getInstance().getMemberService().updateCustomeragentIgnoreNull(agen_t);
								  new CustomeragentServiceImpl().addAgentvmoney(agen_erji.getParentid(), pr_yiji);
								  
								  	
									Rebaterecord record3 = new Rebaterecord();
									record3.setOrdernumber("");
									record3.setRebatemoney(pr_yiji);
									record3.setCustomerid(46);
									record3.setRebatetype(2);
									record3.setYewutype(9);
									// record.setRebateagentjibie(getrebatagent.getAgentjibie());
									record3.setRebateagentid(agen_erji.getParentid());
									record3.setChildagentid(agent.getId());
									record3.setRebatetime(this.getCurrentTime());
									record3.setChildagentid(0);
									String memo3 = "通过加盟开户获得" + pr + "元(执行操作的代理为:"+agen_ad.getAgentcompanyname()+",新开代理:"+agent.getAgentcompanyname()+")";
									record.setRebatememo(memo3);
									Server.getInstance().getMemberService().createRebaterecord(record3);
									
									
									
									
									
							   }
							
							
							
					   }
					
					
			   }
			
			
			
		
			
			}
			
			
			customeragent.setId(agent.getId());
			System.out.println(customeragent.getAgenttype());
			user.setAgentid(customeragent.getId());
			user.setCreatetime(this.getCurrentTime());
			user.setModifytime(this.getCurrentTime());
			user.setIsadmin(1);
			user.setIsenable(1);// 是否启用。
			user.setMembertype(-1);// 用于区分默认管理员
			// 创建用户
			user=this.getMemberservice().createCustomeruser(user);			
			granRole(business,user.getId(),customeragent,createagentid);
			
		} catch (SQLException e) {
			
		}
	}
	
	
	/**
	 * @param business 业务
	 * @param uid  用户id
	 * @param customeragent 当前操作加盟商
	 * @param createagentid  登录着agentid
	 */
	public void granRole(String[]business,long uid,Customeragent customeragent,long createagentid){
		String[] btype =business ;
		StringBuilder builder=new StringBuilder("-1");
		StringBuilder bussinesssql=new StringBuilder("");
		for (String s : btype) {
			builder.append(","+s);
			bussinesssql.append(";INSERT INTO T_AGENTREFBUSSINESS VALUES ("+customeragent.getId()+","+s+")");
		}
			String where="WHERE C_BUSSINESSID IN("+builder+")  AND C_TYPE="+customeragent.getAgenttype();//+" AND C_CUSTOMERAGENTID="+createagentid;
			Server.getInstance().getSystemService().findMapResultBySql(bussinesssql.toString(), null);
			System.out.println("where:"+where);
			List<Systemrole> roles=	Server.getInstance().getMemberService().findAllSystemrole(where, "", -1, 0);
			
			System.out.println("roles:"+roles);
			if(customeragent.getBigtype()!=null&&customeragent.getBigtype()==8){
			 List<Systemrole> roles2=	Server.getInstance().getMemberService().findAllSystemrole(" where 1=1 and "+Systemrole.COL_name+" ='终端代理管理员'", "", -1, 0);
				new CustomeruserAction().grantRolestoUser(uid, roles2);
			}else{
				new CustomeruserAction().grantRolestoUser(uid, roles);
			}
	}
	

	public IMemberService getMemberservice() {
		if (memberservice == null) {
			memberservice = Server.getInstance().getMemberService();
		}
		return memberservice;
	}

	@Override
	public float getTotalVmoney(long id) {
		String sql="SELECT C_VMONEY AS VMONEY FROM T_CUSTOMERAGENT WHERE ID="+id;
		List list=Server.getInstance().getSystemService().findMapResultBySql(sql, null);
		if(list.size()>0){
			Map m=(Map)list.get(0);
			float vmoney=Float.valueOf(m.get("VMONEY").toString());
			return vmoney;
		}
		
		return 0;
	}
	
	

	@Override
	public void editAgent(Customeragent agent, Customeruser user,
			String[] bussiness, long createagentid) {
		getMemberservice().updateCustomeragentIgnoreNull(agent);
		if(user.getId()==0){
			user.setAgentid(agent.getId());
			user.setCreatetime(this.getCurrentTime());
			user.setModifytime(this.getCurrentTime());
			user.setIsadmin(1);
			user.setIsenable(1);// 是否启用。
			user.setMembertype(-1);// 用于区分默认管理员
			// 创建用户
			try {
				user=this.getMemberservice().createCustomeruser(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		getMemberservice().updateCustomeruserIgnoreNull(user);
		if(bussiness!=null){
			String sql="DELETE T_AGENTREFBUSSINESS WHERE C_AGENTID="+agent.getId()+";DELETE T_AGENTROLEREF WHERE C_CUSTOMERUSERID="+user.getId();
			Server.getInstance().getSystemService().findMapResultBySql(sql, null);
			granRole(bussiness,user.getId(),agent,createagentid);
		}
		
	}

}
