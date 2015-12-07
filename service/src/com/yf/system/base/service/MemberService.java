package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yf.system.base.adcooperate.Adcooperate;
import com.yf.system.base.adcooperate.IAdcooperateComponent;
import com.yf.system.base.agentroleref.Agentroleref;
import com.yf.system.base.agentroleref.IAgentrolerefComponent;
import com.yf.system.base.agentvalue.Agentvalue;
import com.yf.system.base.agentvalue.IAgentvalueComponent;
import com.yf.system.base.airdelayprove.Airdelayprove;
import com.yf.system.base.airdelayprove.IAirdelayproveComponent;
import com.yf.system.base.biguser.Biguser;
import com.yf.system.base.biguser.IBiguserComponent;
import com.yf.system.base.biguserprice.Biguserprice;
import com.yf.system.base.biguserprice.IBiguserpriceComponent;
import com.yf.system.base.creditcard.Creditcard;
import com.yf.system.base.creditcard.ICreditcardComponent;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customeragent.ICustomeragentComponent;
import com.yf.system.base.customercredit.Customercredit;
import com.yf.system.base.customercredit.ICustomercreditComponent;
import com.yf.system.base.customerintegralrecord.Customerintegralrecord;
import com.yf.system.base.customerintegralrecord.ICustomerintegralrecordComponent;
import com.yf.system.base.customerpassenger.Customerpassenger;
import com.yf.system.base.customerpassenger.ICustomerpassengerComponent;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.customeruser.ICustomeruserComponent;
import com.yf.system.base.department.Department;
import com.yf.system.base.department.IDepartmentComponent;
import com.yf.system.base.exchrecord.Exchrecord;
import com.yf.system.base.exchrecord.IExchrecordComponent;
import com.yf.system.base.gerenguazhanfrec.Gerenguazhanfrec;
import com.yf.system.base.gerenguazhanfrec.IGerenguazhanfrecComponent;
import com.yf.system.base.helpcenter.Helpcenter;
import com.yf.system.base.helpcenter.IHelpcenterComponent;
import com.yf.system.base.helpcenterinfo.Helpcenterinfo;
import com.yf.system.base.helpcenterinfo.IHelpcenterinfoComponent;
import com.yf.system.base.huodonguser.Huodonguser;
import com.yf.system.base.huodonguser.IHuodonguserComponent;
import com.yf.system.base.importmureport.IImportmureportComponent;
import com.yf.system.base.importmureport.Importmureport;
import com.yf.system.base.infocontent.IInfocontentComponent;
import com.yf.system.base.infocontent.Infocontent;
import com.yf.system.base.information.IInformationComponent;
import com.yf.system.base.information.Information;
import com.yf.system.base.informationinfo.IInformationinfoComponent;
import com.yf.system.base.informationinfo.Informationinfo;
import com.yf.system.base.infotype.IInfotypeComponent;
import com.yf.system.base.infotype.Infotype;
import com.yf.system.base.insuranceinfo.IInsuranceinfoComponent;
import com.yf.system.base.insuranceinfo.Insuranceinfo;
import com.yf.system.base.integral.IIntegralComponent;
import com.yf.system.base.integral.Integral;
import com.yf.system.base.liudianrecord.ILiudianrecordComponent;
import com.yf.system.base.liudianrecord.Liudianrecord;
import com.yf.system.base.liudianrefinfo.ILiudianrefinfoComponent;
import com.yf.system.base.liudianrefinfo.Liudianrefinfo;
import com.yf.system.base.logindesc.ILogindescComponent;
import com.yf.system.base.logindesc.Logindesc;
import com.yf.system.base.messgroup.IMessgroupComponent;
import com.yf.system.base.messgroup.Messgroup;
import com.yf.system.base.miscellaneous.IMiscellaneousComponent;
import com.yf.system.base.miscellaneous.Miscellaneous;
import com.yf.system.base.planeservice.IPlaneserviceComponent;
import com.yf.system.base.planeservice.Planeservice;
import com.yf.system.base.prizeinfo.IPrizeinfoComponent;
import com.yf.system.base.prizeinfo.Prizeinfo;
import com.yf.system.base.prizetype.IPrizetypeComponent;
import com.yf.system.base.prizetype.Prizetype;
import com.yf.system.base.qmessage.IQmessageComponent;
import com.yf.system.base.qmessage.Qmessage;
import com.yf.system.base.qmoneyrecharge.IQmoneyrechargeComponent;
import com.yf.system.base.qmoneyrecharge.Qmoneyrecharge;
import com.yf.system.base.qqinfo.IQqinfoComponent;
import com.yf.system.base.qqinfo.Qqinfo;
import com.yf.system.base.qqinfonew.IQqinfonewComponent;
import com.yf.system.base.qqinfonew.Qqinfonew;
import com.yf.system.base.qqtype.IQqtypeComponent;
import com.yf.system.base.qqtype.Qqtype;
import com.yf.system.base.qqtypenew.IQqtypenewComponent;
import com.yf.system.base.qqtypenew.Qqtypenew;
import com.yf.system.base.rebaterecord.IRebaterecordComponent;
import com.yf.system.base.rebaterecord.Rebaterecord;
import com.yf.system.base.rebaterule.IRebateruleComponent;
import com.yf.system.base.rebaterule.Rebaterule;
import com.yf.system.base.recharge.IRechargeComponent;
import com.yf.system.base.recharge.Recharge;
import com.yf.system.base.repay.IRepayComponent;
import com.yf.system.base.repay.Repay;
import com.yf.system.base.settlementtype.ISettlementtypeComponent;
import com.yf.system.base.settlementtype.Settlementtype;
import com.yf.system.base.sysconfig.ISysconfigComponent;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.sysroleright.ISysrolerightComponent;
import com.yf.system.base.sysroleright.Sysroleright;
import com.yf.system.base.systemaction.ISystemactionComponent;
import com.yf.system.base.systemaction.Systemaction;
import com.yf.system.base.systemright.ISystemrightComponent;
import com.yf.system.base.systemright.Systemright;
import com.yf.system.base.systemrole.ISystemroleComponent;
import com.yf.system.base.systemrole.Systemrole;
import com.yf.system.base.telephone.ITelephoneComponent;
import com.yf.system.base.telephone.Telephone;
import com.yf.system.base.templet.ITempletComponent;
import com.yf.system.base.templet.Templet;
import com.yf.system.base.ticketnumber.ITicketnumberComponent;
import com.yf.system.base.ticketnumber.Ticketnumber;
import com.yf.system.base.tickettype.ITickettypeComponent;
import com.yf.system.base.tickettype.Tickettype;
import com.yf.system.base.tousu.ITousuComponent;
import com.yf.system.base.tousu.Tousu;
import com.yf.system.base.traderecord.ITraderecordComponent;
import com.yf.system.base.traderecord.Traderecord;
import com.yf.system.base.travelskyreport.ITravelskyreportComponent;
import com.yf.system.base.travelskyreport.Travelskyreport;
import com.yf.system.base.txorder.ITxorderComponent;
import com.yf.system.base.txorder.Txorder;
import com.yf.system.base.txuserinfo.ITxuserinfoComponent;
import com.yf.system.base.txuserinfo.Txuserinfo;
import com.yf.system.base.useraddress.IUseraddressComponent;
import com.yf.system.base.useraddress.Useraddress;
import com.yf.system.base.userintegral.IUserintegralComponent;
import com.yf.system.base.userintegral.Userintegral;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.vmoneyrecord.IVmoneyrecordComponent;
import com.yf.system.base.vmoneyrecord.Vmoneyrecord;
import com.yf.system.base.wanlixing.IWanlixingComponent;
import com.yf.system.base.wanlixing.Wanlixing;
import com.yf.system.base.withbank.IWithbankComponent;
import com.yf.system.base.withbank.Withbank;
import com.yf.system.base.ympay.IYmpayComponent;
import com.yf.system.base.ympay.Ympay;
import com.yf.system.base.ymreceive.IYmreceiveComponent;
import com.yf.system.base.ymreceive.Ymreceive;
import com.yf.system.base.ymsend.IYmsendComponent;
import com.yf.system.base.ymsend.Ymsend;
import com.yf.system.base.ymuser.IYmuserComponent;
import com.yf.system.base.ymuser.Ymuser;

public class MemberService implements IMemberService{
	
	
	private Map<String,Object> map;
	private boolean cache;
	
	public boolean isCache() {
		return cache;
	}
	public void setCache(boolean cache) {
		this.cache = cache;
	}
private ICustomeruserComponent customeruserComponent;
	  
 	
 	public ICustomeruserComponent getCustomeruserComponent() {
		return customeruserComponent;
	}
	public void setCustomeruserComponent(ICustomeruserComponent  customeruserComponent) {
		this.customeruserComponent = customeruserComponent;
	}
	/**
	 * 创建 会员
	 * @param id
	 * @return deleted count 
	 */
	public Customeruser createCustomeruser(Customeruser customeruser) throws SQLException{
	
		return customeruserComponent.createCustomeruser(customeruser);
	}
	/**
	 * 删除 会员
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomeruser(long id){
	
		return customeruserComponent.deleteCustomeruser(id);
	}
	
	
	/**
	 * 修改 会员
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomeruser(Customeruser customeruser){
		return customeruserComponent.updateCustomeruser(customeruser);
	
	}

		
	/**
	 * 修改 会员但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomeruserIgnoreNull(Customeruser customeruser){
			return customeruserComponent.updateCustomeruserIgnoreNull(customeruser);
	
	}
	
	/**
	 * 查找 会员
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeruser(String where, String orderby,int limit,int offset){
		return customeruserComponent.findAllCustomeruser(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 会员
	 * @param id
	 * @return
	 */
	public Customeruser findCustomeruser(long id){
		return customeruserComponent.findCustomeruser(id);
	}
	
	/** 
	 * 查找 会员
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomeruserForPageinfo(String where, String orderby,PageInfo pageinfo){
		return customeruserComponent.findAllCustomeruser(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找会员
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeruserBySql(String sql,int limit,int offset){
		return customeruserComponent.findAllCustomeruser(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 会员
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomeruserBySql(String sql){
		return customeruserComponent.excuteCustomeruserBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomeruserBySql(String sql){
		return customeruserComponent.countCustomeruserBySql(sql);
	}
	////////////////////////////////
private ICustomeragentComponent customeragentComponent;
	  
 	
 	public ICustomeragentComponent getCustomeragentComponent() {
		return customeragentComponent;
	}
	public void setCustomeragentComponent(ICustomeragentComponent  customeragentComponent) {
		this.customeragentComponent = customeragentComponent;
	}
	/**
	 * 创建 加盟商信息表
	 * @param id
	 * @return deleted count 
	 */
	public Customeragent createCustomeragent(Customeragent customeragent) throws SQLException{
	
		return customeragentComponent.createCustomeragent(customeragent);
	}
	/**
	 * 删除 加盟商信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomeragent(long id){
	
		return customeragentComponent.deleteCustomeragent(id);
	}
	
	
	/**
	 * 修改 加盟商信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomeragent(Customeragent customeragent){
		return customeragentComponent.updateCustomeragent(customeragent);
	
	}

		
	/**
	 * 修改 加盟商信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomeragentIgnoreNull(Customeragent customeragent){
			return customeragentComponent.updateCustomeragentIgnoreNull(customeragent);
	
	}
	
	/**
	 * 查找 加盟商信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeragent(String where, String orderby,int limit,int offset){
		return customeragentComponent.findAllCustomeragent(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 加盟商信息表
	 * @param id
	 * @return
	 */
	public Customeragent findCustomeragent(long id){
		return customeragentComponent.findCustomeragent(id);
	}
	
	/** 
	 * 查找 加盟商信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomeragentForPageinfo(String where, String orderby,PageInfo pageinfo){
		return customeragentComponent.findAllCustomeragent(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找加盟商信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeragentBySql(String sql,int limit,int offset){
		return customeragentComponent.findAllCustomeragent(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 加盟商信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomeragentBySql(String sql){
		return customeragentComponent.excuteCustomeragentBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomeragentBySql(String sql){
		return customeragentComponent.countCustomeragentBySql(sql);
	}
	/////////////////////////////////

	private ICustomercreditComponent customercreditComponent;
	  
 	
 	public ICustomercreditComponent getCustomercreditComponent() {
		return customercreditComponent;
	}
	public void setCustomercreditComponent(ICustomercreditComponent  customercreditComponent) {
		this.customercreditComponent = customercreditComponent;
	}
	/**
	 * 创建 证件
	 * @param id
	 * @return deleted count 
	 */
	public Customercredit createCustomercredit(Customercredit customercredit) throws SQLException{
	
		return customercreditComponent.createCustomercredit(customercredit);
	}
	/**
	 * 删除 证件
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomercredit(long id){
	
		return customercreditComponent.deleteCustomercredit(id);
	}
	
	
	/**
	 * 修改 证件
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomercredit(Customercredit customercredit){
		return customercreditComponent.updateCustomercredit(customercredit);
	
	}

		
	/**
	 * 修改 证件但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomercreditIgnoreNull(Customercredit customercredit){
			return customercreditComponent.updateCustomercreditIgnoreNull(customercredit);
	
	}
	
	/**
	 * 查找 证件
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomercredit(String where, String orderby,int limit,int offset){
		return customercreditComponent.findAllCustomercredit(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 证件
	 * @param id
	 * @return
	 */
	public Customercredit findCustomercredit(long id){
		return customercreditComponent.findCustomercredit(id);
	}
	
	/** 
	 * 查找 证件
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomercreditForPageinfo(String where, String orderby,PageInfo pageinfo){
		return customercreditComponent.findAllCustomercredit(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找证件
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomercreditBySql(String sql,int limit,int offset){
		return customercreditComponent.findAllCustomercredit(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 证件
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomercreditBySql(String sql){
		return customercreditComponent.excuteCustomercreditBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomercreditBySql(String sql){
		return customercreditComponent.countCustomercreditBySql(sql);
	}
	////////////////////////////////

	private ICustomerpassengerComponent customerpassengerComponent;
	  
 	
 	public ICustomerpassengerComponent getCustomerpassengerComponent() {
		return customerpassengerComponent;
	}
	public void setCustomerpassengerComponent(ICustomerpassengerComponent  customerpassengerComponent) {
		this.customerpassengerComponent = customerpassengerComponent;
	}
	/**
	 * 创建 常用旅客
	 * @param id
	 * @return deleted count 
	 */
	public Customerpassenger createCustomerpassenger(Customerpassenger customerpassenger) throws SQLException{
	
		return customerpassengerComponent.createCustomerpassenger(customerpassenger);
	}
	/**
	 * 删除 常用旅客
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomerpassenger(long id){
	
		return customerpassengerComponent.deleteCustomerpassenger(id);
	}
	
	
	/**
	 * 修改 常用旅客
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomerpassenger(Customerpassenger customerpassenger){
		return customerpassengerComponent.updateCustomerpassenger(customerpassenger);
	
	}

		
	/**
	 * 修改 常用旅客但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomerpassengerIgnoreNull(Customerpassenger customerpassenger){
			return customerpassengerComponent.updateCustomerpassengerIgnoreNull(customerpassenger);
	
	}
	
	/**
	 * 查找 常用旅客
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerpassenger(String where, String orderby,int limit,int offset){
		return customerpassengerComponent.findAllCustomerpassenger(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 常用旅客
	 * @param id
	 * @return
	 */
	public Customerpassenger findCustomerpassenger(long id){
		return customerpassengerComponent.findCustomerpassenger(id);
	}
	
	/** 
	 * 查找 常用旅客
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomerpassengerForPageinfo(String where, String orderby,PageInfo pageinfo){
		return customerpassengerComponent.findAllCustomerpassenger(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找常用旅客
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerpassengerBySql(String sql,int limit,int offset){
		return customerpassengerComponent.findAllCustomerpassenger(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 常用旅客
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomerpassengerBySql(String sql){
		return customerpassengerComponent.excuteCustomerpassengerBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomerpassengerBySql(String sql){
		return customerpassengerComponent.countCustomerpassengerBySql(sql);
	}
	///////////////////////////////
private ISysrolerightComponent sysrolerightComponent;
	  
 	
 	public ISysrolerightComponent getSysrolerightComponent() {
		return sysrolerightComponent;
	}
	public void setSysrolerightComponent(ISysrolerightComponent  sysrolerightComponent) {
		this.sysrolerightComponent = sysrolerightComponent;
	}
	/**
	 * 创建 系统角色权限关联
	 * @param id
	 * @return deleted count 
	 */
	public Sysroleright createSysroleright(Sysroleright sysroleright) throws SQLException{
	
		return sysrolerightComponent.createSysroleright(sysroleright);
	}
	/**
	 * 删除 系统角色权限关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysroleright(long id){
	
		return sysrolerightComponent.deleteSysroleright(id);
	}
	
	
	/**
	 * 修改 系统角色权限关联
	 * @param id
	 * @return updated count 
	 */
	public int updateSysroleright(Sysroleright sysroleright){
		return sysrolerightComponent.updateSysroleright(sysroleright);
	
	}

		
	/**
	 * 修改 系统角色权限关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysrolerightIgnoreNull(Sysroleright sysroleright){
			return sysrolerightComponent.updateSysrolerightIgnoreNull(sysroleright);
	
	}
	
	/**
	 * 查找 系统角色权限关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysroleright(String where, String orderby,int limit,int offset){
		return sysrolerightComponent.findAllSysroleright(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 系统角色权限关联
	 * @param id
	 * @return
	 */
	public Sysroleright findSysroleright(long id){
		return sysrolerightComponent.findSysroleright(id);
	}
	
	/** 
	 * 查找 系统角色权限关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysrolerightForPageinfo(String where, String orderby,PageInfo pageinfo){
		return sysrolerightComponent.findAllSysroleright(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找系统角色权限关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysrolerightBySql(String sql,int limit,int offset){
		return sysrolerightComponent.findAllSysroleright(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 系统角色权限关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysrolerightBySql(String sql){
		return sysrolerightComponent.excuteSysrolerightBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysrolerightBySql(String sql){
		return sysrolerightComponent.countSysrolerightBySql(sql);
	}
	///////////////////////////

	private ISystemactionComponent systemactionComponent;
	  
 	
 	public ISystemactionComponent getSystemactionComponent() {
		return systemactionComponent;
	}
	public void setSystemactionComponent(ISystemactionComponent  systemactionComponent) {
		this.systemactionComponent = systemactionComponent;
	}
	/**
	 * 创建 系统用户行为
	 * @param id
	 * @return deleted count 
	 */
	public Systemaction createSystemaction(Systemaction systemaction) throws SQLException{
	
		return systemactionComponent.createSystemaction(systemaction);
	}
	/**
	 * 删除 系统用户行为
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSystemaction(long id){
	
		return systemactionComponent.deleteSystemaction(id);
	}
	
	
	/**
	 * 修改 系统用户行为
	 * @param id
	 * @return updated count 
	 */
	public int updateSystemaction(Systemaction systemaction){
		return systemactionComponent.updateSystemaction(systemaction);
	
	}

		
	/**
	 * 修改 系统用户行为但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSystemactionIgnoreNull(Systemaction systemaction){
			return systemactionComponent.updateSystemactionIgnoreNull(systemaction);
	
	}
	
	/**
	 * 查找 系统用户行为
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemaction(String where, String orderby,int limit,int offset){
		return systemactionComponent.findAllSystemaction(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 系统用户行为
	 * @param id
	 * @return
	 */
	public Systemaction findSystemaction(long id){
		return systemactionComponent.findSystemaction(id);
	}
	
	/** 
	 * 查找 系统用户行为
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSystemactionForPageinfo(String where, String orderby,PageInfo pageinfo){
		return systemactionComponent.findAllSystemaction(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找系统用户行为
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemactionBySql(String sql,int limit,int offset){
		return systemactionComponent.findAllSystemaction(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 系统用户行为
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSystemactionBySql(String sql){
		return systemactionComponent.excuteSystemactionBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSystemactionBySql(String sql){
		return systemactionComponent.countSystemactionBySql(sql);
	}
	///////////////////////
private ISystemrightComponent systemrightComponent;
	  
 	
 	public ISystemrightComponent getSystemrightComponent() {
		return systemrightComponent;
	}
	public void setSystemrightComponent(ISystemrightComponent  systemrightComponent) {
		this.systemrightComponent = systemrightComponent;
	}
	/**
	 * 创建 系统权限
	 * @param id
	 * @return deleted count 
	 */
	public Systemright createSystemright(Systemright systemright) throws SQLException{
	
		return systemrightComponent.createSystemright(systemright);
	}
	/**
	 * 删除 系统权限
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSystemright(long id){
	
		return systemrightComponent.deleteSystemright(id);
	}
	
	
	/**
	 * 修改 系统权限
	 * @param id
	 * @return updated count 
	 */
	public int updateSystemright(Systemright systemright){
		return systemrightComponent.updateSystemright(systemright);
	
	}

		
	/**
	 * 修改 系统权限但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSystemrightIgnoreNull(Systemright systemright){
			return systemrightComponent.updateSystemrightIgnoreNull(systemright);
	
	}
	
	/**
	 * 查找 系统权限
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemright(String where, String orderby,int limit,int offset){
		return systemrightComponent.findAllSystemright(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 系统权限
	 * @param id
	 * @return
	 */
	public Systemright findSystemright(long id){
		return systemrightComponent.findSystemright(id);
	}
	
	/** 
	 * 查找 系统权限
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSystemrightForPageinfo(String where, String orderby,PageInfo pageinfo){
		return systemrightComponent.findAllSystemright(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找系统权限
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemrightBySql(String sql,int limit,int offset){
		return systemrightComponent.findAllSystemright(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 系统权限
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSystemrightBySql(String sql){
		return systemrightComponent.excuteSystemrightBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSystemrightBySql(String sql){
		return systemrightComponent.countSystemrightBySql(sql);
	}
	
	//////////////////////////////////
private ISystemroleComponent systemroleComponent;
	  
 	
 	public ISystemroleComponent getSystemroleComponent() {
		return systemroleComponent;
	}
	public void setSystemroleComponent(ISystemroleComponent  systemroleComponent) {
		this.systemroleComponent = systemroleComponent;
	}
	/**
	 * 创建 系统角色
	 * @param id
	 * @return deleted count 
	 */
	public Systemrole createSystemrole(Systemrole systemrole) throws SQLException{
	
		return systemroleComponent.createSystemrole(systemrole);
	}
	/**
	 * 删除 系统角色
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSystemrole(long id){
	
		return systemroleComponent.deleteSystemrole(id);
	}
	
	
	/**
	 * 修改 系统角色
	 * @param id
	 * @return updated count 
	 */
	public int updateSystemrole(Systemrole systemrole){
		return systemroleComponent.updateSystemrole(systemrole);
	
	}

		
	/**
	 * 修改 系统角色但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSystemroleIgnoreNull(Systemrole systemrole){
			return systemroleComponent.updateSystemroleIgnoreNull(systemrole);
	
	}
	
	/**
	 * 查找 系统角色
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemrole(String where, String orderby,int limit,int offset){
		return systemroleComponent.findAllSystemrole(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 系统角色
	 * @param id
	 * @return
	 */
	public Systemrole findSystemrole(long id){
		return systemroleComponent.findSystemrole(id);
	}
	
	/** 
	 * 查找 系统角色
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSystemroleForPageinfo(String where, String orderby,PageInfo pageinfo){
		return systemroleComponent.findAllSystemrole(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找系统角色
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemroleBySql(String sql,int limit,int offset){
		return systemroleComponent.findAllSystemrole(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 系统角色
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSystemroleBySql(String sql){
		return systemroleComponent.excuteSystemroleBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSystemroleBySql(String sql){
		return systemroleComponent.countSystemroleBySql(sql);
	}
	////////////////////
private ITelephoneComponent telephoneComponent;
	  
 	
 	public ITelephoneComponent getTelephoneComponent() {
		return telephoneComponent;
	}
	public void setTelephoneComponent(ITelephoneComponent  telephoneComponent) {
		this.telephoneComponent = telephoneComponent;
	}
	/**
	 * 创建 其他电话
	 * @param id
	 * @return deleted count 
	 */
	public Telephone createTelephone(Telephone telephone) throws SQLException{
	
		return telephoneComponent.createTelephone(telephone);
	}
	/**
	 * 删除 其他电话
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTelephone(long id){
	
		return telephoneComponent.deleteTelephone(id);
	}
	
	
	/**
	 * 修改 其他电话
	 * @param id
	 * @return updated count 
	 */
	public int updateTelephone(Telephone telephone){
		return telephoneComponent.updateTelephone(telephone);
	
	}

		
	/**
	 * 修改 其他电话但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTelephoneIgnoreNull(Telephone telephone){
			return telephoneComponent.updateTelephoneIgnoreNull(telephone);
	
	}
	
	/**
	 * 查找 其他电话
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTelephone(String where, String orderby,int limit,int offset){
		return telephoneComponent.findAllTelephone(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 其他电话
	 * @param id
	 * @return
	 */
	public Telephone findTelephone(long id){
		return telephoneComponent.findTelephone(id);
	}
	
	/** 
	 * 查找 其他电话
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTelephoneForPageinfo(String where, String orderby,PageInfo pageinfo){
		return telephoneComponent.findAllTelephone(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找其他电话
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTelephoneBySql(String sql,int limit,int offset){
		return telephoneComponent.findAllTelephone(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 其他电话
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTelephoneBySql(String sql){
		return telephoneComponent.excuteTelephoneBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTelephoneBySql(String sql){
		return telephoneComponent.countTelephoneBySql(sql);
	}
	//////////////////
private IAgentrolerefComponent agentrolerefComponent;
	  
 	
 	public IAgentrolerefComponent getAgentrolerefComponent() {
		return agentrolerefComponent;
	}
	public void setAgentrolerefComponent(IAgentrolerefComponent  agentrolerefComponent) {
		this.agentrolerefComponent = agentrolerefComponent;
	}
	/**
	 * 创建 会员角色关联
	 * @param id
	 * @return deleted count 
	 */
	public Agentroleref createAgentroleref(Agentroleref agentroleref) throws SQLException{
	
		return agentrolerefComponent.createAgentroleref(agentroleref);
	}
	/**
	 * 删除 会员角色关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAgentroleref(long id){
	
		return agentrolerefComponent.deleteAgentroleref(id);
	}
	
	
	/**
	 * 修改 会员角色关联
	 * @param id
	 * @return updated count 
	 */
	public int updateAgentroleref(Agentroleref agentroleref){
		return agentrolerefComponent.updateAgentroleref(agentroleref);
	
	}

		
	/**
	 * 修改 会员角色关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAgentrolerefIgnoreNull(Agentroleref agentroleref){
			return agentrolerefComponent.updateAgentrolerefIgnoreNull(agentroleref);
	
	}
	
	/**
	 * 查找 会员角色关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentroleref(String where, String orderby,int limit,int offset){
		return agentrolerefComponent.findAllAgentroleref(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 会员角色关联
	 * @param id
	 * @return
	 */
	public Agentroleref findAgentroleref(long id){
		return agentrolerefComponent.findAgentroleref(id);
	}
	
	/** 
	 * 查找 会员角色关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAgentrolerefForPageinfo(String where, String orderby,PageInfo pageinfo){
		return agentrolerefComponent.findAllAgentroleref(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找会员角色关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentrolerefBySql(String sql,int limit,int offset){
		return agentrolerefComponent.findAllAgentroleref(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 会员角色关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAgentrolerefBySql(String sql){
		return agentrolerefComponent.excuteAgentrolerefBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAgentrolerefBySql(String sql){
		return agentrolerefComponent.countAgentrolerefBySql(sql);
	}
	
private ISysconfigComponent sysconfigComponent;
	  
 	
 	public ISysconfigComponent getSysconfigComponent() {
		return sysconfigComponent;
	}
	public void setSysconfigComponent(ISysconfigComponent  sysconfigComponent) {
		this.sysconfigComponent = sysconfigComponent;
	}
	/**
	 * 创建 系统配置表
	 * @param id
	 * @return deleted count 
	 */
	public Sysconfig createSysconfig(Sysconfig sysconfig) throws SQLException{
	
		return sysconfigComponent.createSysconfig(sysconfig);
	}
	/**
	 * 删除 系统配置表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysconfig(long id){
	
		return sysconfigComponent.deleteSysconfig(id);
	}
	
	
	/**
	 * 修改 系统配置表
	 * @param id
	 * @return updated count 
	 */
	public int updateSysconfig(Sysconfig sysconfig){
		return sysconfigComponent.updateSysconfig(sysconfig);
	
	}

		
	/**
	 * 修改 系统配置表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysconfigIgnoreNull(Sysconfig sysconfig){
			return sysconfigComponent.updateSysconfigIgnoreNull(sysconfig);
	
	}
	
	/**
	 * 查找 系统配置表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysconfig(String where, String orderby,int limit,int offset){
		return sysconfigComponent.findAllSysconfig(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 系统配置表
	 * @param id
	 * @return
	 */
	public Sysconfig findSysconfig(long id){
		return sysconfigComponent.findSysconfig(id);
	}
	
	/** 
	 * 查找 系统配置表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysconfigForPageinfo(String where, String orderby,PageInfo pageinfo){
		return sysconfigComponent.findAllSysconfig(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找系统配置表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysconfigBySql(String sql,int limit,int offset){
		return sysconfigComponent.findAllSysconfig(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 系统配置表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysconfigBySql(String sql){
		return sysconfigComponent.excuteSysconfigBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysconfigBySql(String sql){
		return sysconfigComponent.countSysconfigBySql(sql);
	}
	
private IInfocontentComponent  infocontentComponent;
	  
 	
 	public IInfocontentComponent getInfocontentComponent() {
		return infocontentComponent;
	}
	public void setInfocontentComponent(IInfocontentComponent  infocontentComponent) {
		this.infocontentComponent = infocontentComponent;
	}
	/**
	 * 创建 信息
	 * @param id
	 * @return deleted count 
	 */
	public Infocontent createInfocontent(Infocontent infocontent) throws SQLException{
	
		return infocontentComponent.createInfocontent(infocontent);
	}
	/**
	 * 删除 信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInfocontent(long id){
	
		return infocontentComponent.deleteInfocontent(id);
	}
	
	
	/**
	 * 修改 信息
	 * @param id
	 * @return updated count 
	 */
	public int updateInfocontent(Infocontent infocontent){
		return infocontentComponent.updateInfocontent(infocontent);
	
	}

		
	/**
	 * 修改 信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInfocontentIgnoreNull(Infocontent infocontent){
			return infocontentComponent.updateInfocontentIgnoreNull(infocontent);
	
	}
	
	/**
	 * 查找 信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfocontent(String where, String orderby,int limit,int offset){
		return infocontentComponent.findAllInfocontent(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 信息
	 * @param id
	 * @return
	 */
	public Infocontent findInfocontent(long id){
		return infocontentComponent.findInfocontent(id);
	}
	
	/** 
	 * 查找 信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInfocontentForPageinfo(String where, String orderby,PageInfo pageinfo){
		return infocontentComponent.findAllInfocontent(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfocontentBySql(String sql,int limit,int offset){
		return infocontentComponent.findAllInfocontent(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInfocontentBySql(String sql){
		return infocontentComponent.excuteInfocontentBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInfocontentBySql(String sql){
		return infocontentComponent.countInfocontentBySql(sql);
	}
private IInfotypeComponent infotypeComponent;
	  
 	
 	public IInfotypeComponent getInfotypeComponent() {
		return infotypeComponent;
	}
	public void setInfotypeComponent(IInfotypeComponent  infotypeComponent) {
		this.infotypeComponent = infotypeComponent;
	}
	/**
	 * 创建 信息类型
	 * @param id
	 * @return deleted count 
	 */
	public Infotype createInfotype(Infotype infotype) throws SQLException{
	
		return infotypeComponent.createInfotype(infotype);
	}
	/**
	 * 删除 信息类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInfotype(long id){
	
		return infotypeComponent.deleteInfotype(id);
	}
	
	
	/**
	 * 修改 信息类型
	 * @param id
	 * @return updated count 
	 */
	public int updateInfotype(Infotype infotype){
		return infotypeComponent.updateInfotype(infotype);
	
	}

		
	/**
	 * 修改 信息类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInfotypeIgnoreNull(Infotype infotype){
			return infotypeComponent.updateInfotypeIgnoreNull(infotype);
	
	}
	
	/**
	 * 查找 信息类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfotype(String where, String orderby,int limit,int offset){
		return infotypeComponent.findAllInfotype(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 信息类型
	 * @param id
	 * @return
	 */
	public Infotype findInfotype(long id){
		return infotypeComponent.findInfotype(id);
	}
	/**
	 * 查找 信息id
	 */
	public Long findInfoId(String typename){
		return null;
	}
	
	/** 
	 * 查找 信息类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInfotypeForPageinfo(String where, String orderby,PageInfo pageinfo){
		return infotypeComponent.findAllInfotype(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找信息类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfotypeBySql(String sql,int limit,int offset){
		return infotypeComponent.findAllInfotype(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 信息类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInfotypeBySql(String sql){
		return infotypeComponent.excuteInfotypeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInfotypeBySql(String sql){
		return infotypeComponent.countInfotypeBySql(sql);
	}
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IExchrecordComponent exchrecordComponent;
	  
 	
 	public IExchrecordComponent getExchrecordComponent() {
		return exchrecordComponent;
	}
	public void setExchrecordComponent(IExchrecordComponent  exchrecordComponent) {
		this.exchrecordComponent = exchrecordComponent;
	}
	/**
	 * 创建 积分兑换纪录
	 * @param id
	 * @return deleted count 
	 */
	public Exchrecord createExchrecord(Exchrecord exchrecord) throws SQLException{
	
		return exchrecordComponent.createExchrecord(exchrecord);
	}
	/**
	 * 删除 积分兑换纪录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteExchrecord(long id){
	
		return exchrecordComponent.deleteExchrecord(id);
	}
	
	
	/**
	 * 修改 积分兑换纪录
	 * @param id
	 * @return updated count 
	 */
	public int updateExchrecord(Exchrecord exchrecord){
		return exchrecordComponent.updateExchrecord(exchrecord);
	
	}

		
	/**
	 * 修改 积分兑换纪录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateExchrecordIgnoreNull(Exchrecord exchrecord){
			return exchrecordComponent.updateExchrecordIgnoreNull(exchrecord);
	
	}
	
	/**
	 * 查找 积分兑换纪录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllExchrecord(String where, String orderby,int limit,int offset){
		return exchrecordComponent.findAllExchrecord(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 积分兑换纪录
	 * @param id
	 * @return
	 */
	public Exchrecord findExchrecord(long id){
		return exchrecordComponent.findExchrecord(id);
	}
	
	/** 
	 * 查找 积分兑换纪录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllExchrecordForPageinfo(String where, String orderby,PageInfo pageinfo){
		return exchrecordComponent.findAllExchrecord(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找积分兑换纪录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllExchrecordBySql(String sql,int limit,int offset){
		return exchrecordComponent.findAllExchrecord(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 积分兑换纪录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteExchrecordBySql(String sql){
		return exchrecordComponent.excuteExchrecordBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countExchrecordBySql(String sql){
		return exchrecordComponent.countExchrecordBySql(sql);
	}
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IPrizeinfoComponent prizeinfoComponent;
	  
 	
 	public IPrizeinfoComponent getPrizeinfoComponent() {
		return prizeinfoComponent;
	}
	public void setPrizeinfoComponent(IPrizeinfoComponent  prizeinfoComponent) {
		this.prizeinfoComponent = prizeinfoComponent;
	}
	/**
	 * 创建 积分礼品信息
	 * @param id
	 * @return deleted count 
	 */
	public Prizeinfo createPrizeinfo(Prizeinfo prizeinfo) throws SQLException{
	
		return prizeinfoComponent.createPrizeinfo(prizeinfo);
	}
	/**
	 * 删除 积分礼品信息
	 * @param id
	 * @return deleted count 
	 */
	public int deletePrizeinfo(long id){
	
		return prizeinfoComponent.deletePrizeinfo(id);
	}
	
	
	/**
	 * 修改 积分礼品信息
	 * @param id
	 * @return updated count 
	 */
	public int updatePrizeinfo(Prizeinfo prizeinfo){
		return prizeinfoComponent.updatePrizeinfo(prizeinfo);
	
	}

		
	/**
	 * 修改 积分礼品信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePrizeinfoIgnoreNull(Prizeinfo prizeinfo){
			return prizeinfoComponent.updatePrizeinfoIgnoreNull(prizeinfo);
	
	}
	
	/**
	 * 查找 积分礼品信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizeinfo(String where, String orderby,int limit,int offset){
		return prizeinfoComponent.findAllPrizeinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 积分礼品信息
	 * @param id
	 * @return
	 */
	public Prizeinfo findPrizeinfo(long id){
		return prizeinfoComponent.findPrizeinfo(id);
	}
	
	/** 
	 * 查找 积分礼品信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPrizeinfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return prizeinfoComponent.findAllPrizeinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找积分礼品信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizeinfoBySql(String sql,int limit,int offset){
		return prizeinfoComponent.findAllPrizeinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 积分礼品信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePrizeinfoBySql(String sql){
		return prizeinfoComponent.excutePrizeinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPrizeinfoBySql(String sql){
		return prizeinfoComponent.countPrizeinfoBySql(sql);
	}
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IPrizetypeComponent prizetypeComponent;
	  
 	
 	public IPrizetypeComponent getPrizetypeComponent() {
		return prizetypeComponent;
	}
	public void setPrizetypeComponent(IPrizetypeComponent  prizetypeComponent) {
		this.prizetypeComponent = prizetypeComponent;
	}
	/**
	 * 创建 积分礼品类型
	 * @param id
	 * @return deleted count 
	 */
	public Prizetype createPrizetype(Prizetype prizetype) throws SQLException{
	
		return prizetypeComponent.createPrizetype(prizetype);
	}
	/**
	 * 删除 积分礼品类型
	 * @param id
	 * @return deleted count 
	 */
	public int deletePrizetype(long id){
	
		return prizetypeComponent.deletePrizetype(id);
	}
	
	
	/**
	 * 修改 积分礼品类型
	 * @param id
	 * @return updated count 
	 */
	public int updatePrizetype(Prizetype prizetype){
		return prizetypeComponent.updatePrizetype(prizetype);
	
	}

		
	/**
	 * 修改 积分礼品类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePrizetypeIgnoreNull(Prizetype prizetype){
			return prizetypeComponent.updatePrizetypeIgnoreNull(prizetype);
	
	}
	
	/**
	 * 查找 积分礼品类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizetype(String where, String orderby,int limit,int offset){
		return prizetypeComponent.findAllPrizetype(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 积分礼品类型
	 * @param id
	 * @return
	 */
	public Prizetype findPrizetype(long id){
		return prizetypeComponent.findPrizetype(id);
	}
	
	/** 
	 * 查找 积分礼品类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPrizetypeForPageinfo(String where, String orderby,PageInfo pageinfo){
		return prizetypeComponent.findAllPrizetype(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找积分礼品类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizetypeBySql(String sql,int limit,int offset){
		return prizetypeComponent.findAllPrizetype(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 积分礼品类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePrizetypeBySql(String sql){
		return prizetypeComponent.excutePrizetypeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPrizetypeBySql(String sql){
		return prizetypeComponent.countPrizetypeBySql(sql);
	}
//粘贴到Service实现类
	
	private ITraderecordComponent traderecordComponent;
	  
 	
 	public ITraderecordComponent getTraderecordComponent() {
		return traderecordComponent;
	}
	public void setTraderecordComponent(ITraderecordComponent  traderecordComponent) {
		this.traderecordComponent = traderecordComponent;
	}
	/**
	 * 创建 交易记录
	 * @param id
	 * @return deleted count 
	 */
	public Traderecord createTraderecord(Traderecord traderecord) throws SQLException{
	
		return traderecordComponent.createTraderecord(traderecord);
	}
	/**
	 * 删除 交易记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTraderecord(long id){
	
		return traderecordComponent.deleteTraderecord(id);
	}
	
	
	/**
	 * 修改 交易记录
	 * @param id
	 * @return updated count 
	 */
	public int updateTraderecord(Traderecord traderecord){
		return traderecordComponent.updateTraderecord(traderecord);
	
	}

		
	/**
	 * 修改 交易记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTraderecordIgnoreNull(Traderecord traderecord){
			return traderecordComponent.updateTraderecordIgnoreNull(traderecord);
	
	}
	
	/**
	 * 查找 交易记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraderecord(String where, String orderby,int limit,int offset){
		return traderecordComponent.findAllTraderecord(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 交易记录
	 * @param id
	 * @return
	 */
	public Traderecord findTraderecord(long id){
		return traderecordComponent.findTraderecord(id);
	}
	
	/** 
	 * 查找 交易记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTraderecordForPageinfo(String where, String orderby,PageInfo pageinfo){
		return traderecordComponent.findAllTraderecord(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找交易记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraderecordBySql(String sql,int limit,int offset){
		return traderecordComponent.findAllTraderecord(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 交易记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTraderecordBySql(String sql){
		return traderecordComponent.excuteTraderecordBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTraderecordBySql(String sql){
		return traderecordComponent.countTraderecordBySql(sql);
	}
	
private IYmsendComponent ymsendComponent;
	  
 	
 	public IYmsendComponent getYmsendComponent() {
		return ymsendComponent;
	}
	public void setYmsendComponent(IYmsendComponent  ymsendComponent) {
		this.ymsendComponent = ymsendComponent;
	}
	/**
	 * 创建 短信发送表
	 * @param id
	 * @return deleted count 
	 */
	public Ymsend createYmsend(Ymsend ymsend) throws SQLException{
	
		return ymsendComponent.createYmsend(ymsend);
	}
	/**
	 * 删除 短信发送表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmsend(long id){
	
		return ymsendComponent.deleteYmsend(id);
	}
	
	
	/**
	 * 修改 短信发送表
	 * @param id
	 * @return updated count 
	 */
	public int updateYmsend(Ymsend ymsend){
		return ymsendComponent.updateYmsend(ymsend);
	
	}

		
	/**
	 * 修改 短信发送表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmsendIgnoreNull(Ymsend ymsend){
			return ymsendComponent.updateYmsendIgnoreNull(ymsend);
	
	}
	
	/**
	 * 查找 短信发送表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmsend(String where, String orderby,int limit,int offset){
		return ymsendComponent.findAllYmsend(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 短信发送表
	 * @param id
	 * @return
	 */
	public Ymsend findYmsend(long id){
		return ymsendComponent.findYmsend(id);
	}
	
	/** 
	 * 查找 短信发送表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmsendForPageinfo(String where, String orderby,PageInfo pageinfo){
		return ymsendComponent.findAllYmsend(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找短信发送表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmsendBySql(String sql,int limit,int offset){
		return ymsendComponent.findAllYmsend(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 短信发送表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmsendBySql(String sql){
		return ymsendComponent.excuteYmsendBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmsendBySql(String sql){
		return ymsendComponent.countYmsendBySql(sql);
	}
	
private IYmreceiveComponent ymreceiveComponent;
	  
 	
 	public IYmreceiveComponent getYmreceiveComponent() {
		return ymreceiveComponent;
	}
	public void setYmreceiveComponent(IYmreceiveComponent  ymreceiveComponent) {
		this.ymreceiveComponent = ymreceiveComponent;
	}
	/**
	 * 创建 短信接收表
	 * @param id
	 * @return deleted count 
	 */
	public Ymreceive createYmreceive(Ymreceive ymreceive) throws SQLException{
	
		return ymreceiveComponent.createYmreceive(ymreceive);
	}
	/**
	 * 删除 短信接收表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmreceive(long id){
	
		return ymreceiveComponent.deleteYmreceive(id);
	}
	
	
	/**
	 * 修改 短信接收表
	 * @param id
	 * @return updated count 
	 */
	public int updateYmreceive(Ymreceive ymreceive){
		return ymreceiveComponent.updateYmreceive(ymreceive);
	
	}

		
	/**
	 * 修改 短信接收表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmreceiveIgnoreNull(Ymreceive ymreceive){
			return ymreceiveComponent.updateYmreceiveIgnoreNull(ymreceive);
	
	}
	
	/**
	 * 查找 短信接收表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmreceive(String where, String orderby,int limit,int offset){
		return ymreceiveComponent.findAllYmreceive(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 短信接收表
	 * @param id
	 * @return
	 */
	public Ymreceive findYmreceive(long id){
		return ymreceiveComponent.findYmreceive(id);
	}
	
	/** 
	 * 查找 短信接收表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmreceiveForPageinfo(String where, String orderby,PageInfo pageinfo){
		return ymreceiveComponent.findAllYmreceive(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找短信接收表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmreceiveBySql(String sql,int limit,int offset){
		return ymreceiveComponent.findAllYmreceive(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 短信接收表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmreceiveBySql(String sql){
		return ymreceiveComponent.excuteYmreceiveBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmreceiveBySql(String sql){
		return ymreceiveComponent.countYmreceiveBySql(sql);
	}
	
	private IDepartmentComponent departmentComponent;
	  
 	
 	public IDepartmentComponent getDepartmentComponent() {
		return departmentComponent;
	}
	public void setDepartmentComponent(IDepartmentComponent  departmentComponent) {
		this.departmentComponent = departmentComponent;
	}
	/**
	 * 创建 部门
	 * @param id
	 * @return deleted count 
	 */
	public Department createDepartment(Department department) throws SQLException{
	
		return departmentComponent.createDepartment(department);
	}
	/**
	 * 删除 部门
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDepartment(long id){
	
		return departmentComponent.deleteDepartment(id);
	}
	
	
	/**
	 * 修改 部门
	 * @param id
	 * @return updated count 
	 */
	public int updateDepartment(Department department){
		return departmentComponent.updateDepartment(department);
	
	}

		
	/**
	 * 修改 部门但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDepartmentIgnoreNull(Department department){
			return departmentComponent.updateDepartmentIgnoreNull(department);
	
	}
	
	/**
	 * 查找 部门
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDepartment(String where, String orderby,int limit,int offset){
		return departmentComponent.findAllDepartment(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 部门
	 * @param id
	 * @return
	 */
	public Department findDepartment(long id){
		return departmentComponent.findDepartment(id);
	}
	
	/** 
	 * 查找 部门
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDepartmentForPageinfo(String where, String orderby,PageInfo pageinfo){
		return departmentComponent.findAllDepartment(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找部门
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDepartmentBySql(String sql,int limit,int offset){
		return departmentComponent.findAllDepartment(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 部门
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDepartmentBySql(String sql){
		return departmentComponent.excuteDepartmentBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDepartmentBySql(String sql){
		return departmentComponent.countDepartmentBySql(sql);
	}
	//
//粘贴到Service实现类
	
	private IBiguserComponent biguserComponent;
	  
 	
 	public IBiguserComponent getBiguserComponent() {
		return biguserComponent;
	}
	public void setBiguserComponent(IBiguserComponent  biguserComponent) {
		this.biguserComponent = biguserComponent;
	}
	/**
	 * 创建 大客户关联金额表
	 * @param id
	 * @return deleted count 
	 */
	public Biguser createBiguser(Biguser biguser) throws SQLException{
	
		return biguserComponent.createBiguser(biguser);
	}
	/**
	 * 删除 大客户关联金额表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBiguser(long id){
	
		return biguserComponent.deleteBiguser(id);
	}
	
	
	/**
	 * 修改 大客户关联金额表
	 * @param id
	 * @return updated count 
	 */
	public int updateBiguser(Biguser biguser){
		return biguserComponent.updateBiguser(biguser);
	
	}

		
	/**
	 * 修改 大客户关联金额表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBiguserIgnoreNull(Biguser biguser){
			return biguserComponent.updateBiguserIgnoreNull(biguser);
	
	}
	
	/**
	 * 查找 大客户关联金额表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguser(String where, String orderby,int limit,int offset){
		return biguserComponent.findAllBiguser(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 大客户关联金额表
	 * @param id
	 * @return
	 */
	public Biguser findBiguser(long id){
		return biguserComponent.findBiguser(id);
	}
	
	/** 
	 * 查找 大客户关联金额表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBiguserForPageinfo(String where, String orderby,PageInfo pageinfo){
		return biguserComponent.findAllBiguser(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找大客户关联金额表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguserBySql(String sql,int limit,int offset){
		return biguserComponent.findAllBiguser(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 大客户关联金额表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBiguserBySql(String sql){
		return biguserComponent.excuteBiguserBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBiguserBySql(String sql){
		return biguserComponent.countBiguserBySql(sql);
	}
	//
private IBiguserpriceComponent biguserpriceComponent;
	  
 	
 	public IBiguserpriceComponent getBiguserpriceComponent() {
		return biguserpriceComponent;
	}
	public void setBiguserpriceComponent(IBiguserpriceComponent  biguserpriceComponent) {
		this.biguserpriceComponent = biguserpriceComponent;
	}
	/**
	 * 创建 大客户还款金额记录表
	 * @param id
	 * @return deleted count 
	 */
	public Biguserprice createBiguserprice(Biguserprice biguserprice) throws SQLException{
	
		return biguserpriceComponent.createBiguserprice(biguserprice);
	}
	/**
	 * 删除 大客户还款金额记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBiguserprice(long id){
	
		return biguserpriceComponent.deleteBiguserprice(id);
	}
	
	
	/**
	 * 修改 大客户还款金额记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateBiguserprice(Biguserprice biguserprice){
		return biguserpriceComponent.updateBiguserprice(biguserprice);
	
	}

		
	/**
	 * 修改 大客户还款金额记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBiguserpriceIgnoreNull(Biguserprice biguserprice){
			return biguserpriceComponent.updateBiguserpriceIgnoreNull(biguserprice);
	
	}
	
	/**
	 * 查找 大客户还款金额记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguserprice(String where, String orderby,int limit,int offset){
		return biguserpriceComponent.findAllBiguserprice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 大客户还款金额记录表
	 * @param id
	 * @return
	 */
	public Biguserprice findBiguserprice(long id){
		return biguserpriceComponent.findBiguserprice(id);
	}
	
	/** 
	 * 查找 大客户还款金额记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBiguserpriceForPageinfo(String where, String orderby,PageInfo pageinfo){
		return biguserpriceComponent.findAllBiguserprice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找大客户还款金额记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguserpriceBySql(String sql,int limit,int offset){
		return biguserpriceComponent.findAllBiguserprice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 大客户还款金额记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBiguserpriceBySql(String sql){
		return biguserpriceComponent.excuteBiguserpriceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBiguserpriceBySql(String sql){
		return biguserpriceComponent.countBiguserpriceBySql(sql);
	}
	//
//粘贴到Service实现类
	
	private IRepayComponent repayComponent;
	  
 	
 	public IRepayComponent getRepayComponent() {
		return repayComponent;
	}
	public void setRepayComponent(IRepayComponent  repayComponent) {
		this.repayComponent = repayComponent;
	}
	/**
	 * 创建 大客户还款记录表
	 * @param id
	 * @return deleted count 
	 */
	public Repay createRepay(Repay repay) throws SQLException{
	
		return repayComponent.createRepay(repay);
	}
	/**
	 * 删除 大客户还款记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRepay(long id){
	
		return repayComponent.deleteRepay(id);
	}
	
	
	/**
	 * 修改 大客户还款记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateRepay(Repay repay){
		return repayComponent.updateRepay(repay);
	
	}

		
	/**
	 * 修改 大客户还款记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRepayIgnoreNull(Repay repay){
			return repayComponent.updateRepayIgnoreNull(repay);
	
	}
	
	/**
	 * 查找 大客户还款记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRepay(String where, String orderby,int limit,int offset){
		return repayComponent.findAllRepay(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 大客户还款记录表
	 * @param id
	 * @return
	 */
	public Repay findRepay(long id){
		return repayComponent.findRepay(id);
	}
	
	/** 
	 * 查找 大客户还款记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRepayForPageinfo(String where, String orderby,PageInfo pageinfo){
		return repayComponent.findAllRepay(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找大客户还款记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRepayBySql(String sql,int limit,int offset){
		return repayComponent.findAllRepay(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 大客户还款记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRepayBySql(String sql){
		return repayComponent.excuteRepayBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRepayBySql(String sql){
		return repayComponent.countRepayBySql(sql);
	}
	
	//
//粘贴到Service实现类
	
	private IAdcooperateComponent adcooperateComponent;
	  
 	
 	public IAdcooperateComponent getAdcooperateComponent() {
		return adcooperateComponent;
	}
	public void setAdcooperateComponent(IAdcooperateComponent  adcooperateComponent) {
		this.adcooperateComponent = adcooperateComponent;
	}
	/**
	 * 创建 广告合作表
	 * @param id
	 * @return deleted count 
	 */
	public Adcooperate createAdcooperate(Adcooperate adcooperate) throws SQLException{
	
		return adcooperateComponent.createAdcooperate(adcooperate);
	}
	/**
	 * 删除 广告合作表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAdcooperate(long id){
	
		return adcooperateComponent.deleteAdcooperate(id);
	}
	
	
	/**
	 * 修改 广告合作表
	 * @param id
	 * @return updated count 
	 */
	public int updateAdcooperate(Adcooperate adcooperate){
		return adcooperateComponent.updateAdcooperate(adcooperate);
	
	}

		
	/**
	 * 修改 广告合作表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAdcooperateIgnoreNull(Adcooperate adcooperate){
			return adcooperateComponent.updateAdcooperateIgnoreNull(adcooperate);
	
	}
	
	/**
	 * 查找 广告合作表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdcooperate(String where, String orderby,int limit,int offset){
		return adcooperateComponent.findAllAdcooperate(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 广告合作表
	 * @param id
	 * @return
	 */
	public Adcooperate findAdcooperate(long id){
		return adcooperateComponent.findAdcooperate(id);
	}
	
	/** 
	 * 查找 广告合作表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAdcooperateForPageinfo(String where, String orderby,PageInfo pageinfo){
		return adcooperateComponent.findAllAdcooperate(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找广告合作表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdcooperateBySql(String sql,int limit,int offset){
		return adcooperateComponent.findAllAdcooperate(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 广告合作表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAdcooperateBySql(String sql){
		return adcooperateComponent.excuteAdcooperateBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAdcooperateBySql(String sql){
		return adcooperateComponent.countAdcooperateBySql(sql);
	}
	
	

//
//粘贴到Service实现类
	
	private ITousuComponent tousuComponent;
	  
 	
 	public ITousuComponent getTousuComponent() {
		return tousuComponent;
	}
	public void setTousuComponent(ITousuComponent  tousuComponent) {
		this.tousuComponent = tousuComponent;
	}
	/**
	 * 创建 投诉建议表
	 * @param id
	 * @return deleted count 
	 */
	public Tousu createTousu(Tousu tousu) throws SQLException{
	
		return tousuComponent.createTousu(tousu);
	}
	/**
	 * 删除 投诉建议表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTousu(long id){
	
		return tousuComponent.deleteTousu(id);
	}
	
	
	/**
	 * 修改 投诉建议表
	 * @param id
	 * @return updated count 
	 */
	public int updateTousu(Tousu tousu){
		return tousuComponent.updateTousu(tousu);
	
	}

		
	/**
	 * 修改 投诉建议表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTousuIgnoreNull(Tousu tousu){
			return tousuComponent.updateTousuIgnoreNull(tousu);
	
	}
	
	/**
	 * 查找 投诉建议表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTousu(String where, String orderby,int limit,int offset){
		return tousuComponent.findAllTousu(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 投诉建议表
	 * @param id
	 * @return
	 */
	public Tousu findTousu(long id){
		return tousuComponent.findTousu(id);
	}
	
	/** 
	 * 查找 投诉建议表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTousuForPageinfo(String where, String orderby,PageInfo pageinfo){
		return tousuComponent.findAllTousu(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找投诉建议表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTousuBySql(String sql,int limit,int offset){
		return tousuComponent.findAllTousu(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 投诉建议表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTousuBySql(String sql){
		return tousuComponent.excuteTousuBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTousuBySql(String sql){
		return tousuComponent.countTousuBySql(sql);
	}
	
	
//
//粘贴到Service实现类
	
	private IWanlixingComponent wanlixingComponent;
	  
 	
 	public IWanlixingComponent getWanlixingComponent() {
		return wanlixingComponent;
	}
	public void setWanlixingComponent(IWanlixingComponent  wanlixingComponent) {
		this.wanlixingComponent = wanlixingComponent;
	}
	/**
	 * 创建 万里行申请表
	 * @param id
	 * @return deleted count 
	 */
	public Wanlixing createWanlixing(Wanlixing wanlixing) throws SQLException{
	
		return wanlixingComponent.createWanlixing(wanlixing);
	}
	/**
	 * 删除 万里行申请表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteWanlixing(long id){
	
		return wanlixingComponent.deleteWanlixing(id);
	}
	
	
	/**
	 * 修改 万里行申请表
	 * @param id
	 * @return updated count 
	 */
	public int updateWanlixing(Wanlixing wanlixing){
		return wanlixingComponent.updateWanlixing(wanlixing);
	
	}

		
	/**
	 * 修改 万里行申请表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateWanlixingIgnoreNull(Wanlixing wanlixing){
			return wanlixingComponent.updateWanlixingIgnoreNull(wanlixing);
	
	}
	
	/**
	 * 查找 万里行申请表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWanlixing(String where, String orderby,int limit,int offset){
		return wanlixingComponent.findAllWanlixing(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 万里行申请表
	 * @param id
	 * @return
	 */
	public Wanlixing findWanlixing(long id){
		return wanlixingComponent.findWanlixing(id);
	}
	
	/** 
	 * 查找 万里行申请表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllWanlixingForPageinfo(String where, String orderby,PageInfo pageinfo){
		return wanlixingComponent.findAllWanlixing(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找万里行申请表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWanlixingBySql(String sql,int limit,int offset){
		return wanlixingComponent.findAllWanlixing(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 万里行申请表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteWanlixingBySql(String sql){
		return wanlixingComponent.excuteWanlixingBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countWanlixingBySql(String sql){
		return wanlixingComponent.countWanlixingBySql(sql);
	}
	private IImportmureportComponent importmureportComponent;
	  
 	
 	public IImportmureportComponent getImportmureportComponent() {
		return importmureportComponent;
	}
	public void setImportmureportComponent(IImportmureportComponent  importmureportComponent) {
		this.importmureportComponent = importmureportComponent;
	}
	/**
	 * 创建 东航销售明细导入
	 * @param id
	 * @return deleted count 
	 */
	public Importmureport createImportmureport(Importmureport importmureport) throws SQLException{
	
		return importmureportComponent.createImportmureport(importmureport);
	}
	/**
	 * 删除 东航销售明细导入
	 * @param id
	 * @return deleted count 
	 */
	public int deleteImportmureport(long id){
	
		return importmureportComponent.deleteImportmureport(id);
	}
	
	
	/**
	 * 修改 东航销售明细导入
	 * @param id
	 * @return updated count 
	 */
	public int updateImportmureport(Importmureport importmureport){
		return importmureportComponent.updateImportmureport(importmureport);
	
	}

		
	/**
	 * 修改 东航销售明细导入但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateImportmureportIgnoreNull(Importmureport importmureport){
			return importmureportComponent.updateImportmureportIgnoreNull(importmureport);
	
	}
	
	/**
	 * 查找 东航销售明细导入
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllImportmureport(String where, String orderby,int limit,int offset){
		return importmureportComponent.findAllImportmureport(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 东航销售明细导入
	 * @param id
	 * @return
	 */
	public Importmureport findImportmureport(long id){
		return importmureportComponent.findImportmureport(id);
	}
	
	/** 
	 * 查找 东航销售明细导入
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllImportmureportForPageinfo(String where, String orderby,PageInfo pageinfo){
		return importmureportComponent.findAllImportmureport(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找东航销售明细导入
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllImportmureportBySql(String sql,int limit,int offset){
		return importmureportComponent.findAllImportmureport(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 东航销售明细导入
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteImportmureportBySql(String sql){
		return importmureportComponent.excuteImportmureportBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countImportmureportBySql(String sql){
		return importmureportComponent.countImportmureportBySql(sql);
	}
	
	private IMiscellaneousComponent miscellaneousComponent;
	  
 	
 	public IMiscellaneousComponent getMiscellaneousComponent() {
		return miscellaneousComponent;
	}
	public void setMiscellaneousComponent(IMiscellaneousComponent  miscellaneousComponent) {
		this.miscellaneousComponent = miscellaneousComponent;
	}
	/**
	 * 创建 客户经理杂项列表
	 * @param id
	 * @return deleted count 
	 */
	public Miscellaneous createMiscellaneous(Miscellaneous miscellaneous) throws SQLException{
	
		return miscellaneousComponent.createMiscellaneous(miscellaneous);
	}
	/**
	 * 删除 客户经理杂项列表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteMiscellaneous(long id){
	
		return miscellaneousComponent.deleteMiscellaneous(id);
	}
	
	
	/**
	 * 修改 客户经理杂项列表
	 * @param id
	 * @return updated count 
	 */
	public int updateMiscellaneous(Miscellaneous miscellaneous){
		return miscellaneousComponent.updateMiscellaneous(miscellaneous);
	
	}

		
	/**
	 * 修改 客户经理杂项列表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateMiscellaneousIgnoreNull(Miscellaneous miscellaneous){
			return miscellaneousComponent.updateMiscellaneousIgnoreNull(miscellaneous);
	
	}
	
	/**
	 * 查找 客户经理杂项列表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllMiscellaneous(String where, String orderby,int limit,int offset){
		return miscellaneousComponent.findAllMiscellaneous(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 客户经理杂项列表
	 * @param id
	 * @return
	 */
	public Miscellaneous findMiscellaneous(long id){
		return miscellaneousComponent.findMiscellaneous(id);
	}
	
	/** 
	 * 查找 客户经理杂项列表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllMiscellaneousForPageinfo(String where, String orderby,PageInfo pageinfo){
		return miscellaneousComponent.findAllMiscellaneous(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找客户经理杂项列表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllMiscellaneousBySql(String sql,int limit,int offset){
		return miscellaneousComponent.findAllMiscellaneous(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 客户经理杂项列表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteMiscellaneousBySql(String sql){
		return miscellaneousComponent.excuteMiscellaneousBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countMiscellaneousBySql(String sql){
		return miscellaneousComponent.countMiscellaneousBySql(sql);
	}
private IQqinfoComponent qqinfoComponent;
	  
 	
 	public IQqinfoComponent getQqinfoComponent() {
		return qqinfoComponent;
	}
	public void setQqinfoComponent(IQqinfoComponent  qqinfoComponent) {
		this.qqinfoComponent = qqinfoComponent;
	}
	/**
	 * 创建 QQ信息表
	 * @param id
	 * @return deleted count 
	 */
	public Qqinfo createQqinfo(Qqinfo qqinfo) throws SQLException{
	
		return qqinfoComponent.createQqinfo(qqinfo);
	}
	/**
	 * 删除 QQ信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQqinfo(long id){
	
		return qqinfoComponent.deleteQqinfo(id);
	}
	
	/**
	 * 修改 QQ信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateQqinfo(Qqinfo qqinfo){
		return qqinfoComponent.updateQqinfo(qqinfo);
	
	}

		
	/**
	 * 修改 QQ信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQqinfoIgnoreNull(Qqinfo qqinfo){
			return qqinfoComponent.updateQqinfoIgnoreNull(qqinfo);
	
	}
	
	/**
	 * 查找 QQ信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfo(String where, String orderby,int limit,int offset){
		return qqinfoComponent.findAllQqinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 QQ信息表
	 * @param id
	 * @return
	 */
	public Qqinfo findQqinfo(long id){
		return qqinfoComponent.findQqinfo(id);
	}
	
	/** 
	 * 查找 QQ信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQqinfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return qqinfoComponent.findAllQqinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找QQ信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfoBySql(String sql,int limit,int offset){
		return qqinfoComponent.findAllQqinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql QQ信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQqinfoBySql(String sql){
		return qqinfoComponent.excuteQqinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQqinfoBySql(String sql){
		return qqinfoComponent.countQqinfoBySql(sql);
	}
	
private IQqtypeComponent qqtypeComponent;
	  
 	
 	public IQqtypeComponent getQqtypeComponent() {
		return qqtypeComponent;
	}
	public void setQqtypeComponent(IQqtypeComponent  qqtypeComponent) {
		this.qqtypeComponent = qqtypeComponent;
	}
	/**
	 * 创建 QQ类型
	 * @param id
	 * @return deleted count 
	 */
	public Qqtype createQqtype(Qqtype qqtype) throws SQLException{
	
		return qqtypeComponent.createQqtype(qqtype);
	}
	/**
	 * 删除 QQ类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQqtype(long id){
	
		return qqtypeComponent.deleteQqtype(id);
	}
	
	
	/**
	 * 修改 QQ类型
	 * @param id
	 * @return updated count 
	 */
	public int updateQqtype(Qqtype qqtype){
		return qqtypeComponent.updateQqtype(qqtype);
	
	}

		
	/**
	 * 修改 QQ类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQqtypeIgnoreNull(Qqtype qqtype){
			return qqtypeComponent.updateQqtypeIgnoreNull(qqtype);
	
	}
	
	/**
	 * 查找 QQ类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqtype(String where, String orderby,int limit,int offset){
		return qqtypeComponent.findAllQqtype(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 QQ类型
	 * @param id
	 * @return
	 */
	public Qqtype findQqtype(long id){
		return qqtypeComponent.findQqtype(id);
	}
	
	/** 
	 * 查找 QQ类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQqtypeForPageinfo(String where, String orderby,PageInfo pageinfo){
		return qqtypeComponent.findAllQqtype(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找QQ类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqtypeBySql(String sql,int limit,int offset){
		return qqtypeComponent.findAllQqtype(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql QQ类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQqtypeBySql(String sql){
		return qqtypeComponent.excuteQqtypeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQqtypeBySql(String sql){
		return qqtypeComponent.countQqtypeBySql(sql);
	}
private ITicketnumberComponent ticketnumberComponent;
	  
 	
 	public ITicketnumberComponent getTicketnumberComponent() {
		return ticketnumberComponent;
	}
	public void setTicketnumberComponent(ITicketnumberComponent  ticketnumberComponent) {
		this.ticketnumberComponent = ticketnumberComponent;
	}
	/**
	 * 创建 机票票号
	 * @param id
	 * @return deleted count 
	 */
	public Ticketnumber createTicketnumber(Ticketnumber ticketnumber) throws SQLException{
	
		return ticketnumberComponent.createTicketnumber(ticketnumber);
	}
	/**
	 * 删除 机票票号
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTicketnumber(long id){
	
		return ticketnumberComponent.deleteTicketnumber(id);
	}
	
	
	/**
	 * 修改 机票票号
	 * @param id
	 * @return updated count 
	 */
	public int updateTicketnumber(Ticketnumber ticketnumber){
		return ticketnumberComponent.updateTicketnumber(ticketnumber);
	
	}

		
	/**
	 * 修改 机票票号但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTicketnumberIgnoreNull(Ticketnumber ticketnumber){
			return ticketnumberComponent.updateTicketnumberIgnoreNull(ticketnumber);
	
	}
	
	/**
	 * 查找 机票票号
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTicketnumber(String where, String orderby,int limit,int offset){
		return ticketnumberComponent.findAllTicketnumber(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 机票票号
	 * @param id
	 * @return
	 */
	public Ticketnumber findTicketnumber(long id){
		return ticketnumberComponent.findTicketnumber(id);
	}
	
	/** 
	 * 查找 机票票号
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTicketnumberForPageinfo(String where, String orderby,PageInfo pageinfo){
		return ticketnumberComponent.findAllTicketnumber(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找机票票号
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTicketnumberBySql(String sql,int limit,int offset){
		return ticketnumberComponent.findAllTicketnumber(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 机票票号
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTicketnumberBySql(String sql){
		return ticketnumberComponent.excuteTicketnumberBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTicketnumberBySql(String sql){
		return ticketnumberComponent.countTicketnumberBySql(sql);
	}
private ITickettypeComponent tickettypeComponent;
	  
 	
 	public ITickettypeComponent getTickettypeComponent() {
		return tickettypeComponent;
	}
	public void setTickettypeComponent(ITickettypeComponent  tickettypeComponent) {
		this.tickettypeComponent = tickettypeComponent;
	}
	/**
	 * 创建 机票类型
	 * @param id
	 * @return deleted count 
	 */
	public Tickettype createTickettype(Tickettype tickettype) throws SQLException{
	
		return tickettypeComponent.createTickettype(tickettype);
	}
	/**
	 * 删除 机票类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTickettype(long id){
	
		return tickettypeComponent.deleteTickettype(id);
	}
	
	
	/**
	 * 修改 机票类型
	 * @param id
	 * @return updated count 
	 */
	public int updateTickettype(Tickettype tickettype){
		return tickettypeComponent.updateTickettype(tickettype);
	
	}

		
	/**
	 * 修改 机票类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTickettypeIgnoreNull(Tickettype tickettype){
			return tickettypeComponent.updateTickettypeIgnoreNull(tickettype);
	
	}
	
	/**
	 * 查找 机票类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTickettype(String where, String orderby,int limit,int offset){
		return tickettypeComponent.findAllTickettype(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 机票类型
	 * @param id
	 * @return
	 */
	public Tickettype findTickettype(long id){
		return tickettypeComponent.findTickettype(id);
	}
	
	/** 
	 * 查找 机票类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTickettypeForPageinfo(String where, String orderby,PageInfo pageinfo){
		return tickettypeComponent.findAllTickettype(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找机票类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTickettypeBySql(String sql,int limit,int offset){
		return tickettypeComponent.findAllTickettype(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 机票类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTickettypeBySql(String sql){
		return tickettypeComponent.excuteTickettypeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTickettypeBySql(String sql){
		return tickettypeComponent.countTickettypeBySql(sql);
	}
private ITravelskyreportComponent travelskyreportComponent;
	  
 	
 	public ITravelskyreportComponent getTravelskyreportComponent() {
		return travelskyreportComponent;
	}
	public void setTravelskyreportComponent(ITravelskyreportComponent  travelskyreportComponent) {
		this.travelskyreportComponent = travelskyreportComponent;
	}
	/**
	 * 创建 航空公司报表导入
	 * @param id
	 * @return deleted count 
	 */
	public Travelskyreport createTravelskyreport(Travelskyreport travelskyreport) throws SQLException{
	
		return travelskyreportComponent.createTravelskyreport(travelskyreport);
	}
	/**
	 * 删除 航空公司报表导入
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTravelskyreport(long id){
	
		return travelskyreportComponent.deleteTravelskyreport(id);
	}
	
	
	/**
	 * 修改 航空公司报表导入
	 * @param id
	 * @return updated count 
	 */
	public int updateTravelskyreport(Travelskyreport travelskyreport){
		return travelskyreportComponent.updateTravelskyreport(travelskyreport);
	
	}

		
	/**
	 * 修改 航空公司报表导入但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTravelskyreportIgnoreNull(Travelskyreport travelskyreport){
			return travelskyreportComponent.updateTravelskyreportIgnoreNull(travelskyreport);
	
	}
	
	/**
	 * 查找 航空公司报表导入
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTravelskyreport(String where, String orderby,int limit,int offset){
		return travelskyreportComponent.findAllTravelskyreport(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 航空公司报表导入
	 * @param id
	 * @return
	 */
	public Travelskyreport findTravelskyreport(long id){
		return travelskyreportComponent.findTravelskyreport(id);
	}
	
	/** 
	 * 查找 航空公司报表导入
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTravelskyreportForPageinfo(String where, String orderby,PageInfo pageinfo){
		return travelskyreportComponent.findAllTravelskyreport(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找航空公司报表导入
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTravelskyreportBySql(String sql,int limit,int offset){
		return travelskyreportComponent.findAllTravelskyreport(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 航空公司报表导入
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTravelskyreportBySql(String sql){
		return travelskyreportComponent.excuteTravelskyreportBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTravelskyreportBySql(String sql){
		return travelskyreportComponent.countTravelskyreportBySql(sql);
	}
	
	private IGerenguazhanfrecComponent gerenguazhanfrecComponent;
	  
 	
 	public IGerenguazhanfrecComponent getGerenguazhanfrecComponent() {
		return gerenguazhanfrecComponent;
	}
	public void setGerenguazhanfrecComponent(IGerenguazhanfrecComponent  gerenguazhanfrecComponent) {
		this.gerenguazhanfrecComponent = gerenguazhanfrecComponent;
	}
	/**
	 * 创建 个人挂账记录表
	 * @param id
	 * @return deleted count 
	 */
	public Gerenguazhanfrec createGerenguazhanfrec(Gerenguazhanfrec gerenguazhanfrec) throws SQLException{
	
		return gerenguazhanfrecComponent.createGerenguazhanfrec(gerenguazhanfrec);
	}
	/**
	 * 删除 个人挂账记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGerenguazhanfrec(long id){
	
		return gerenguazhanfrecComponent.deleteGerenguazhanfrec(id);
	}
	
	
	/**
	 * 修改 个人挂账记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateGerenguazhanfrec(Gerenguazhanfrec gerenguazhanfrec){
		return gerenguazhanfrecComponent.updateGerenguazhanfrec(gerenguazhanfrec);
	
	}

		
	/**
	 * 修改 个人挂账记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGerenguazhanfrecIgnoreNull(Gerenguazhanfrec gerenguazhanfrec){
			return gerenguazhanfrecComponent.updateGerenguazhanfrecIgnoreNull(gerenguazhanfrec);
	
	}
	
	/**
	 * 查找 个人挂账记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGerenguazhanfrec(String where, String orderby,int limit,int offset){
		return gerenguazhanfrecComponent.findAllGerenguazhanfrec(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 个人挂账记录表
	 * @param id
	 * @return
	 */
	public Gerenguazhanfrec findGerenguazhanfrec(long id){
		return gerenguazhanfrecComponent.findGerenguazhanfrec(id);
	}
	
	/** 
	 * 查找 个人挂账记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGerenguazhanfrecForPageinfo(String where, String orderby,PageInfo pageinfo){
		return gerenguazhanfrecComponent.findAllGerenguazhanfrec(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找个人挂账记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGerenguazhanfrecBySql(String sql,int limit,int offset){
		return gerenguazhanfrecComponent.findAllGerenguazhanfrec(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 个人挂账记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGerenguazhanfrecBySql(String sql){
		return gerenguazhanfrecComponent.excuteGerenguazhanfrecBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGerenguazhanfrecBySql(String sql){
		return gerenguazhanfrecComponent.countGerenguazhanfrecBySql(sql);
	}
	
private IInsuranceinfoComponent insuranceinfoComponent;
	  
 	
 	public IInsuranceinfoComponent getInsuranceinfoComponent() {
		return insuranceinfoComponent;
	}
	public void setInsuranceinfoComponent(IInsuranceinfoComponent  insuranceinfoComponent) {
		this.insuranceinfoComponent = insuranceinfoComponent;
	}
	/**
	 * 创建 保险
	 * @param id
	 * @return deleted count 
	 */
	public Insuranceinfo createInsuranceinfo(Insuranceinfo insuranceinfo) throws SQLException{
	
		return insuranceinfoComponent.createInsuranceinfo(insuranceinfo);
	}
	/**
	 * 删除 保险
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInsuranceinfo(long id){
	
		return insuranceinfoComponent.deleteInsuranceinfo(id);
	}
	
	
	/**
	 * 修改 保险
	 * @param id
	 * @return updated count 
	 */
	public int updateInsuranceinfo(Insuranceinfo insuranceinfo){
		return insuranceinfoComponent.updateInsuranceinfo(insuranceinfo);
	
	}

		
	/**
	 * 修改 保险但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInsuranceinfoIgnoreNull(Insuranceinfo insuranceinfo){
			return insuranceinfoComponent.updateInsuranceinfoIgnoreNull(insuranceinfo);
	
	}
	
	/**
	 * 查找 保险
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsuranceinfo(String where, String orderby,int limit,int offset){
		return insuranceinfoComponent.findAllInsuranceinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 保险
	 * @param id
	 * @return
	 */
	public Insuranceinfo findInsuranceinfo(long id){
		return insuranceinfoComponent.findInsuranceinfo(id);
	}
	
	/** 
	 * 查找 保险
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInsuranceinfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return insuranceinfoComponent.findAllInsuranceinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找保险
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInsuranceinfoBySql(String sql,int limit,int offset){
		return insuranceinfoComponent.findAllInsuranceinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 保险
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInsuranceinfoBySql(String sql){
		return insuranceinfoComponent.excuteInsuranceinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInsuranceinfoBySql(String sql){
		return insuranceinfoComponent.countInsuranceinfoBySql(sql);
	}
	
	private IQmessageComponent qmessageComponent;
	  
 	
 	public IQmessageComponent getQmessageComponent() {
		return qmessageComponent;
	}
	public void setQmessageComponent(IQmessageComponent  qmessageComponent) {
		this.qmessageComponent = qmessageComponent;
	}
	/**
	 * 创建 Q信箱
	 * @param id
	 * @return deleted count 
	 */
	public Qmessage createQmessage(Qmessage qmessage) throws SQLException{
	
		return qmessageComponent.createQmessage(qmessage);
	}
	/**
	 * 删除 Q信箱
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQmessage(long id){
	
		return qmessageComponent.deleteQmessage(id);
	}
	
	
	/**
	 * 修改 Q信箱
	 * @param id
	 * @return updated count 
	 */
	public int updateQmessage(Qmessage qmessage){
		return qmessageComponent.updateQmessage(qmessage);
	
	}

		
	/**
	 * 修改 Q信箱但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQmessageIgnoreNull(Qmessage qmessage){
			return qmessageComponent.updateQmessageIgnoreNull(qmessage);
	
	}
	
	/**
	 * 查找 Q信箱
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQmessage(String where, String orderby,int limit,int offset){
		return qmessageComponent.findAllQmessage(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 Q信箱
	 * @param id
	 * @return
	 */
	public Qmessage findQmessage(long id){
		return qmessageComponent.findQmessage(id);
	}
	
	/** 
	 * 查找 Q信箱
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQmessageForPageinfo(String where, String orderby,PageInfo pageinfo){
		return qmessageComponent.findAllQmessage(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找Q信箱
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQmessageBySql(String sql,int limit,int offset){
		return qmessageComponent.findAllQmessage(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql Q信箱
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQmessageBySql(String sql){
		return qmessageComponent.excuteQmessageBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQmessageBySql(String sql){
		return qmessageComponent.countQmessageBySql(sql);
	}
	
private ICreditcardComponent creditcardComponent;
	  
 	
 	public ICreditcardComponent getCreditcardComponent() {
		return creditcardComponent;
	}
	public void setCreditcardComponent(ICreditcardComponent  creditcardComponent) {
		this.creditcardComponent = creditcardComponent;
	}
	/**
	 * 创建 信用卡记录表
	 * @param id
	 * @return deleted count 
	 */
	public Creditcard createCreditcard(Creditcard creditcard) throws SQLException{
	
		return creditcardComponent.createCreditcard(creditcard);
	}
	/**
	 * 删除 信用卡记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCreditcard(long id){
	
		return creditcardComponent.deleteCreditcard(id);
	}
	
	
	/**
	 * 修改 信用卡记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateCreditcard(Creditcard creditcard){
		return creditcardComponent.updateCreditcard(creditcard);
	
	}

		
	/**
	 * 修改 信用卡记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCreditcardIgnoreNull(Creditcard creditcard){
			return creditcardComponent.updateCreditcardIgnoreNull(creditcard);
	
	}
	
	/**
	 * 查找 信用卡记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCreditcard(String where, String orderby,int limit,int offset){
		return creditcardComponent.findAllCreditcard(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 信用卡记录表
	 * @param id
	 * @return
	 */
	public Creditcard findCreditcard(long id){
		return creditcardComponent.findCreditcard(id);
	}
	
	/** 
	 * 查找 信用卡记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCreditcardForPageinfo(String where, String orderby,PageInfo pageinfo){
		return creditcardComponent.findAllCreditcard(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找信用卡记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCreditcardBySql(String sql,int limit,int offset){
		return creditcardComponent.findAllCreditcard(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 信用卡记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCreditcardBySql(String sql){
		return creditcardComponent.excuteCreditcardBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCreditcardBySql(String sql){
		return creditcardComponent.countCreditcardBySql(sql);
	}
	
//粘贴到Service实现类
	
	private ILiudianrecordComponent liudianrecordComponent;
	  
 	
 	public ILiudianrecordComponent getLiudianrecordComponent() {
		return liudianrecordComponent;
	}
	public void setLiudianrecordComponent(ILiudianrecordComponent  liudianrecordComponent) {
		this.liudianrecordComponent = liudianrecordComponent;
	}
	/**
	 * 创建 留点记录表
	 * @param id
	 * @return deleted count 
	 */
	public Liudianrecord createLiudianrecord(Liudianrecord liudianrecord) throws SQLException{
	
		return liudianrecordComponent.createLiudianrecord(liudianrecord);
	}
	/**
	 * 删除 留点记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLiudianrecord(long id){
	
		return liudianrecordComponent.deleteLiudianrecord(id);
	}
	
	
	/**
	 * 修改 留点记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateLiudianrecord(Liudianrecord liudianrecord){
		return liudianrecordComponent.updateLiudianrecord(liudianrecord);
	
	}

		
	/**
	 * 修改 留点记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLiudianrecordIgnoreNull(Liudianrecord liudianrecord){
			return liudianrecordComponent.updateLiudianrecordIgnoreNull(liudianrecord);
	
	}
	
	/**
	 * 查找 留点记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLiudianrecord(String where, String orderby,int limit,int offset){
		return liudianrecordComponent.findAllLiudianrecord(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 留点记录表
	 * @param id
	 * @return
	 */
	public Liudianrecord findLiudianrecord(long id){
		return liudianrecordComponent.findLiudianrecord(id);
	}
	
	/**
	 * 查找 留点记录表
	 * @param id
	 * @return
	 */
	public Liudianrecord findLiudianrecordbylanguage(long id,Integer language){
		return liudianrecordComponent.findLiudianrecordbylanguage(id,language);
	}
	/** 
	 * 查找 留点记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLiudianrecordForPageinfo(String where, String orderby,PageInfo pageinfo){
		return liudianrecordComponent.findAllLiudianrecord(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找留点记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLiudianrecordBySql(String sql,int limit,int offset){
		return liudianrecordComponent.findAllLiudianrecord(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 留点记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLiudianrecordBySql(String sql){
		return liudianrecordComponent.excuteLiudianrecordBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLiudianrecordBySql(String sql){
		return liudianrecordComponent.countLiudianrecordBySql(sql);
	}
	
private ILiudianrefinfoComponent liudianrefinfoComponent;
	  
 	
 	public ILiudianrefinfoComponent getLiudianrefinfoComponent() {
		return liudianrefinfoComponent;
	}
	public void setLiudianrefinfoComponent(ILiudianrefinfoComponent  liudianrefinfoComponent) {
		this.liudianrefinfoComponent = liudianrefinfoComponent;
	}
	/**
	 * 创建 留点设置关联表
	 * @param id
	 * @return deleted count 
	 */
	public Liudianrefinfo createLiudianrefinfo(Liudianrefinfo liudianrefinfo) throws SQLException{
	
		return liudianrefinfoComponent.createLiudianrefinfo(liudianrefinfo);
	}
	/**
	 * 删除 留点设置关联表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLiudianrefinfo(long id){
	
		return liudianrefinfoComponent.deleteLiudianrefinfo(id);
	}
	
	
	/**
	 * 修改 留点设置关联表
	 * @param id
	 * @return updated count 
	 */
	public int updateLiudianrefinfo(Liudianrefinfo liudianrefinfo){
		return liudianrefinfoComponent.updateLiudianrefinfo(liudianrefinfo);
	
	}

		
	/**
	 * 修改 留点设置关联表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLiudianrefinfoIgnoreNull(Liudianrefinfo liudianrefinfo){
			return liudianrefinfoComponent.updateLiudianrefinfoIgnoreNull(liudianrefinfo);
	
	}
	
	/**
	 * 查找 留点设置关联表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLiudianrefinfo(String where, String orderby,int limit,int offset){
		return liudianrefinfoComponent.findAllLiudianrefinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 留点设置关联表
	 * @param id
	 * @return
	 */
	public Liudianrefinfo findLiudianrefinfo(long id){
		return liudianrefinfoComponent.findLiudianrefinfo(id);
	}
	
	/**
	 * 查找 留点设置关联表
	 * @param id
	 * @return
	 */
	public Liudianrefinfo findLiudianrefinfobylanguage(long id,Integer language){
		return liudianrefinfoComponent.findLiudianrefinfobylanguage(id,language);
	}
	/** 
	 * 查找 留点设置关联表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLiudianrefinfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return liudianrefinfoComponent.findAllLiudianrefinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找留点设置关联表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLiudianrefinfoBySql(String sql,int limit,int offset){
		return liudianrefinfoComponent.findAllLiudianrefinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 留点设置关联表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLiudianrefinfoBySql(String sql){
		return liudianrefinfoComponent.excuteLiudianrefinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLiudianrefinfoBySql(String sql){
		return liudianrefinfoComponent.countLiudianrefinfoBySql(sql);
	}
	
private ISettlementtypeComponent settlementtypeComponent;
	  
 	
 	public ISettlementtypeComponent getSettlementtypeComponent() {
		return settlementtypeComponent;
	}
	public void setSettlementtypeComponent(ISettlementtypeComponent  settlementtypeComponent) {
		this.settlementtypeComponent = settlementtypeComponent;
	}
	/**
	 * 创建 结算分类表
	 * @param id
	 * @return deleted count 
	 */
	public Settlementtype createSettlementtype(Settlementtype settlementtype) throws SQLException{
	
		return settlementtypeComponent.createSettlementtype(settlementtype);
	}
	/**
	 * 删除 结算分类表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSettlementtype(long id){
	
		return settlementtypeComponent.deleteSettlementtype(id);
	}
	
	
	/**
	 * 修改 结算分类表
	 * @param id
	 * @return updated count 
	 */
	public int updateSettlementtype(Settlementtype settlementtype){
		return settlementtypeComponent.updateSettlementtype(settlementtype);
	
	}

		
	/**
	 * 修改 结算分类表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSettlementtypeIgnoreNull(Settlementtype settlementtype){
			return settlementtypeComponent.updateSettlementtypeIgnoreNull(settlementtype);
	
	}
	
	/**
	 * 查找 结算分类表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSettlementtype(String where, String orderby,int limit,int offset){
		return settlementtypeComponent.findAllSettlementtype(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 结算分类表
	 * @param id
	 * @return
	 */
	public Settlementtype findSettlementtype(long id){
		return settlementtypeComponent.findSettlementtype(id);
	}
	
	/**
	 * 查找 结算分类表
	 * @param id
	 * @return
	 */
	public Settlementtype findSettlementtypebylanguage(long id,Integer language){
		return settlementtypeComponent.findSettlementtypebylanguage(id,language);
	}
	/** 
	 * 查找 结算分类表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSettlementtypeForPageinfo(String where, String orderby,PageInfo pageinfo){
		return settlementtypeComponent.findAllSettlementtype(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找结算分类表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSettlementtypeBySql(String sql,int limit,int offset){
		return settlementtypeComponent.findAllSettlementtype(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 结算分类表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSettlementtypeBySql(String sql){
		return settlementtypeComponent.excuteSettlementtypeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSettlementtypeBySql(String sql){
		return settlementtypeComponent.countSettlementtypeBySql(sql);
	}
	
private IRebateruleComponent rebateruleComponent;
	  
 	
 	public IRebateruleComponent getRebateruleComponent() {
		return rebateruleComponent;
	}
	public void setRebateruleComponent(IRebateruleComponent  rebateruleComponent) {
		this.rebateruleComponent = rebateruleComponent;
	}
	/**
	 * 创建 返佣规则
	 * @param id
	 * @return deleted count 
	 */
	public Rebaterule createRebaterule(Rebaterule rebaterule) throws SQLException{
	
		return rebateruleComponent.createRebaterule(rebaterule);
	}
	/**
	 * 删除 返佣规则
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRebaterule(long id){
	
		return rebateruleComponent.deleteRebaterule(id);
	}
	
	
	/**
	 * 修改 返佣规则
	 * @param id
	 * @return updated count 
	 */
	public int updateRebaterule(Rebaterule rebaterule){
		return rebateruleComponent.updateRebaterule(rebaterule);
	
	}

		
	/**
	 * 修改 返佣规则但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRebateruleIgnoreNull(Rebaterule rebaterule){
			return rebateruleComponent.updateRebateruleIgnoreNull(rebaterule);
	
	}
	
	/**
	 * 查找 返佣规则
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterule(String where, String orderby,int limit,int offset){
		return rebateruleComponent.findAllRebaterule(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 返佣规则
	 * @param id
	 * @return
	 */
	public Rebaterule findRebaterule(long id){
		return rebateruleComponent.findRebaterule(id);
	}
	
	/** 
	 * 查找 返佣规则
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRebateruleForPageinfo(String where, String orderby,PageInfo pageinfo){
		return rebateruleComponent.findAllRebaterule(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找返佣规则
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebateruleBySql(String sql,int limit,int offset){
		return rebateruleComponent.findAllRebaterule(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 返佣规则
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRebateruleBySql(String sql){
		return rebateruleComponent.excuteRebateruleBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRebateruleBySql(String sql){
		return rebateruleComponent.countRebateruleBySql(sql);
	}
	
	

	private IVmoneyrecordComponent vmoneyrecordComponent;
	  
 	
 	public IVmoneyrecordComponent getVmoneyrecordComponent() {
		return vmoneyrecordComponent;
	}
	public void setVmoneyrecordComponent(IVmoneyrecordComponent  vmoneyrecordComponent) {
		this.vmoneyrecordComponent = vmoneyrecordComponent;
	}
	/**
	 * 创建 虚拟账户充值记录
	 * @param id
	 * @return deleted count 
	 */
	public Vmoneyrecord createVmoneyrecord(Vmoneyrecord vmoneyrecord) throws SQLException{
	
		return vmoneyrecordComponent.createVmoneyrecord(vmoneyrecord);
	}
	/**
	 * 删除 虚拟账户充值记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteVmoneyrecord(long id){
	
		return vmoneyrecordComponent.deleteVmoneyrecord(id);
	}
	
	
	/**
	 * 修改 虚拟账户充值记录
	 * @param id
	 * @return updated count 
	 */
	public int updateVmoneyrecord(Vmoneyrecord vmoneyrecord){
		return vmoneyrecordComponent.updateVmoneyrecord(vmoneyrecord);
	
	}

		
	/**
	 * 修改 虚拟账户充值记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateVmoneyrecordIgnoreNull(Vmoneyrecord vmoneyrecord){
			return vmoneyrecordComponent.updateVmoneyrecordIgnoreNull(vmoneyrecord);
	
	}
	
	/**
	 * 查找 虚拟账户充值记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllVmoneyrecord(String where, String orderby,int limit,int offset){
		return vmoneyrecordComponent.findAllVmoneyrecord(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 虚拟账户充值记录
	 * @param id
	 * @return
	 */
	public Vmoneyrecord findVmoneyrecord(long id){
		return vmoneyrecordComponent.findVmoneyrecord(id);
	}
	
	/** 
	 * 查找 虚拟账户充值记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllVmoneyrecordForPageinfo(String where, String orderby,PageInfo pageinfo){
		return vmoneyrecordComponent.findAllVmoneyrecord(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找虚拟账户充值记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllVmoneyrecordBySql(String sql,int limit,int offset){
		return vmoneyrecordComponent.findAllVmoneyrecord(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 虚拟账户充值记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteVmoneyrecordBySql(String sql){
		return vmoneyrecordComponent.excuteVmoneyrecordBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countVmoneyrecordBySql(String sql){
		return vmoneyrecordComponent.countVmoneyrecordBySql(sql);
	}
	
	
	
private ICustomerintegralrecordComponent customerintegralrecordComponent;
	  
 	
 	public ICustomerintegralrecordComponent getCustomerintegralrecordComponent() {
		return customerintegralrecordComponent;
	}
	public void setCustomerintegralrecordComponent(ICustomerintegralrecordComponent  customerintegralrecordComponent) {
		this.customerintegralrecordComponent = customerintegralrecordComponent;
	}
	/**
	 * 创建 会员积分记录
	 * @param id
	 * @return deleted count 
	 */
	public Customerintegralrecord createCustomerintegralrecord(Customerintegralrecord customerintegralrecord) throws SQLException{
	
		return customerintegralrecordComponent.createCustomerintegralrecord(customerintegralrecord);
	}
	/**
	 * 删除 会员积分记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomerintegralrecord(long id){
	
		return customerintegralrecordComponent.deleteCustomerintegralrecord(id);
	}
	
	
	/**
	 * 修改 会员积分记录
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomerintegralrecord(Customerintegralrecord customerintegralrecord){
		return customerintegralrecordComponent.updateCustomerintegralrecord(customerintegralrecord);
	
	}

		
	/**
	 * 修改 会员积分记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomerintegralrecordIgnoreNull(Customerintegralrecord customerintegralrecord){
			return customerintegralrecordComponent.updateCustomerintegralrecordIgnoreNull(customerintegralrecord);
	
	}
	
	/**
	 * 查找 会员积分记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerintegralrecord(String where, String orderby,int limit,int offset){
		return customerintegralrecordComponent.findAllCustomerintegralrecord(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 会员积分记录
	 * @param id
	 * @return
	 */
	public Customerintegralrecord findCustomerintegralrecord(long id){
		return customerintegralrecordComponent.findCustomerintegralrecord(id);
	}
	
	/** 
	 * 查找 会员积分记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomerintegralrecordForPageinfo(String where, String orderby,PageInfo pageinfo){
		return customerintegralrecordComponent.findAllCustomerintegralrecord(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找会员积分记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerintegralrecordBySql(String sql,int limit,int offset){
		return customerintegralrecordComponent.findAllCustomerintegralrecord(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 会员积分记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomerintegralrecordBySql(String sql){
		return customerintegralrecordComponent.excuteCustomerintegralrecordBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomerintegralrecordBySql(String sql){
		return customerintegralrecordComponent.countCustomerintegralrecordBySql(sql);
	}
	
	
private IIntegralComponent integralComponent;
	  
 	
 	public IIntegralComponent getIntegralComponent() {
		return integralComponent;
	}
	public void setIntegralComponent(IIntegralComponent  integralComponent) {
		this.integralComponent = integralComponent;
	}
	/**
	 * 创建 积分管理
	 * @param id
	 * @return deleted count 
	 */
	public Integral createIntegral(Integral integral) throws SQLException{
	
		return integralComponent.createIntegral(integral);
	}
	/**
	 * 删除 积分管理
	 * @param id
	 * @return deleted count 
	 */
	public int deleteIntegral(long id){
	
		return integralComponent.deleteIntegral(id);
	}
	
	
	/**
	 * 修改 积分管理
	 * @param id
	 * @return updated count 
	 */
	public int updateIntegral(Integral integral){
		return integralComponent.updateIntegral(integral);
	
	}

		
	/**
	 * 修改 积分管理但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateIntegralIgnoreNull(Integral integral){
			return integralComponent.updateIntegralIgnoreNull(integral);
	
	}
	
	/**
	 * 查找 积分管理
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntegral(String where, String orderby,int limit,int offset){
		return integralComponent.findAllIntegral(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 积分管理
	 * @param id
	 * @return
	 */
	public Integral findIntegral(long id){
		return integralComponent.findIntegral(id);
	}
	
	/** 
	 * 查找 积分管理
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllIntegralForPageinfo(String where, String orderby,PageInfo pageinfo){
		return integralComponent.findAllIntegral(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找积分管理
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIntegralBySql(String sql,int limit,int offset){
		return integralComponent.findAllIntegral(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 积分管理
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteIntegralBySql(String sql){
		return integralComponent.excuteIntegralBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countIntegralBySql(String sql){
		return integralComponent.countIntegralBySql(sql);
	}
	
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IUserintegralComponent userintegralComponent;
	  
 	
 	public IUserintegralComponent getUserintegralComponent() {
		return userintegralComponent;
	}
	public void setUserintegralComponent(IUserintegralComponent  userintegralComponent) {
		this.userintegralComponent = userintegralComponent;
	}
	/**
	 * 创建 会员积分记录表
	 * @param id
	 * @return deleted count 
	 */
	public Userintegral createUserintegral(Userintegral userintegral) throws SQLException{
	
		return userintegralComponent.createUserintegral(userintegral);
	}
	/**
	 * 删除 会员积分记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteUserintegral(long id){
	
		return userintegralComponent.deleteUserintegral(id);
	}
	
	
	/**
	 * 修改 会员积分记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateUserintegral(Userintegral userintegral){
		return userintegralComponent.updateUserintegral(userintegral);
	
	}

		
	/**
	 * 修改 会员积分记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateUserintegralIgnoreNull(Userintegral userintegral){
			return userintegralComponent.updateUserintegralIgnoreNull(userintegral);
	
	}
	
	/**
	 * 查找 会员积分记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllUserintegral(String where, String orderby,int limit,int offset){
		return userintegralComponent.findAllUserintegral(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 会员积分记录表
	 * @param id
	 * @return
	 */
	public Userintegral findUserintegral(long id){
		return userintegralComponent.findUserintegral(id);
	}
	
	/** 
	 * 查找 会员积分记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllUserintegralForPageinfo(String where, String orderby,PageInfo pageinfo){
		return userintegralComponent.findAllUserintegral(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找会员积分记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllUserintegralBySql(String sql,int limit,int offset){
		return userintegralComponent.findAllUserintegral(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 会员积分记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteUserintegralBySql(String sql){
		return userintegralComponent.excuteUserintegralBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countUserintegralBySql(String sql){
		return userintegralComponent.countUserintegralBySql(sql);
	}
	
	

	private IRebaterecordComponent rebaterecordComponent;
	  
 	
 	public IRebaterecordComponent getRebaterecordComponent() {
		return rebaterecordComponent;
	}
	public void setRebaterecordComponent(IRebaterecordComponent  rebaterecordComponent) {
		this.rebaterecordComponent = rebaterecordComponent;
	}
	/**
	 * 创建 返佣记录表
	 * @param id
	 * @return deleted count 
	 */
	public Rebaterecord createRebaterecord(Rebaterecord rebaterecord) throws SQLException{
	
		return rebaterecordComponent.createRebaterecord(rebaterecord);
	}
	/**
	 * 删除 返佣记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRebaterecord(long id){
	
		return rebaterecordComponent.deleteRebaterecord(id);
	}
	
	
	/**
	 * 修改 返佣记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateRebaterecord(Rebaterecord rebaterecord){
		return rebaterecordComponent.updateRebaterecord(rebaterecord);
	
	}

		
	/**
	 * 修改 返佣记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRebaterecordIgnoreNull(Rebaterecord rebaterecord){
			return rebaterecordComponent.updateRebaterecordIgnoreNull(rebaterecord);
	
	}
	
	/**
	 * 查找 返佣记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterecord(String where, String orderby,int limit,int offset){
		return rebaterecordComponent.findAllRebaterecord(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 返佣记录表
	 * @param id
	 * @return
	 */
	public Rebaterecord findRebaterecord(long id){
		return rebaterecordComponent.findRebaterecord(id);
	}
	
	/** 
	 * 查找 返佣记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRebaterecordForPageinfo(String where, String orderby,PageInfo pageinfo,String...sql){
		return rebaterecordComponent.findAllRebaterecord(where, orderby,pageinfo,sql);
	}
		
	/** 
	 * 根据Sql查找返佣记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterecordBySql(String sql,int limit,int offset){
		return rebaterecordComponent.findAllRebaterecord(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 返佣记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRebaterecordBySql(String sql){
		return rebaterecordComponent.excuteRebaterecordBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRebaterecordBySql(String sql){
		return rebaterecordComponent.countRebaterecordBySql(sql);
	}
	
	
	
private IRechargeComponent rechargeComponent;
	  
 	
 	public IRechargeComponent getRechargeComponent() {
		return rechargeComponent;
	}
	public void setRechargeComponent(IRechargeComponent  rechargeComponent) {
		this.rechargeComponent = rechargeComponent;
	}
	/**
	 * 创建 手机充值
	 * @param id
	 * @return deleted count 
	 */
	public Recharge createRecharge(Recharge recharge) throws SQLException{
	
		return rechargeComponent.createRecharge(recharge);
	}
	/**
	 * 删除 手机充值
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRecharge(long id){
	
		return rechargeComponent.deleteRecharge(id);
	}
	
	
	/**
	 * 修改 手机充值
	 * @param id
	 * @return updated count 
	 */
	public int updateRecharge(Recharge recharge){
		return rechargeComponent.updateRecharge(recharge);
	
	}

		
	/**
	 * 修改 手机充值但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRechargeIgnoreNull(Recharge recharge){
			return rechargeComponent.updateRechargeIgnoreNull(recharge);
	
	}
	
	/**
	 * 查找 手机充值
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRecharge(String where, String orderby,int limit,int offset){
		return rechargeComponent.findAllRecharge(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 手机充值
	 * @param id
	 * @return
	 */
	public Recharge findRecharge(long id){
		return rechargeComponent.findRecharge(id);
	}
	
	/** 
	 * 查找 手机充值
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRechargeForPageinfo(String where, String orderby,PageInfo pageinfo){
		return rechargeComponent.findAllRecharge(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找手机充值
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRechargeBySql(String sql,int limit,int offset){
		return rechargeComponent.findAllRecharge(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 手机充值
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRechargeBySql(String sql){
		return rechargeComponent.excuteRechargeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRechargeBySql(String sql){
		return rechargeComponent.countRechargeBySql(sql);
	}
	
	
private IQmoneyrechargeComponent qmoneyrechargeComponent;
	  
 	
 	public IQmoneyrechargeComponent getQmoneyrechargeComponent() {
		return qmoneyrechargeComponent;
	}
	public void setQmoneyrechargeComponent(IQmoneyrechargeComponent  qmoneyrechargeComponent) {
		this.qmoneyrechargeComponent = qmoneyrechargeComponent;
	}
	/**
	 * 创建 Q币充值表
	 * @param id
	 * @return deleted count 
	 */
	public Qmoneyrecharge createQmoneyrecharge(Qmoneyrecharge qmoneyrecharge) throws SQLException{
	
		return qmoneyrechargeComponent.createQmoneyrecharge(qmoneyrecharge);
	}
	/**
	 * 删除 Q币充值表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQmoneyrecharge(long id){
	
		return qmoneyrechargeComponent.deleteQmoneyrecharge(id);
	}
	
	
	/**
	 * 修改 Q币充值表
	 * @param id
	 * @return updated count 
	 */
	public int updateQmoneyrecharge(Qmoneyrecharge qmoneyrecharge){
		return qmoneyrechargeComponent.updateQmoneyrecharge(qmoneyrecharge);
	
	}

		
	/**
	 * 修改 Q币充值表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQmoneyrechargeIgnoreNull(Qmoneyrecharge qmoneyrecharge){
			return qmoneyrechargeComponent.updateQmoneyrechargeIgnoreNull(qmoneyrecharge);
	
	}
	
	/**
	 * 查找 Q币充值表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQmoneyrecharge(String where, String orderby,int limit,int offset){
		return qmoneyrechargeComponent.findAllQmoneyrecharge(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 Q币充值表
	 * @param id
	 * @return
	 */
	public Qmoneyrecharge findQmoneyrecharge(long id){
		return qmoneyrechargeComponent.findQmoneyrecharge(id);
	}
	
	/** 
	 * 查找 Q币充值表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQmoneyrechargeForPageinfo(String where, String orderby,PageInfo pageinfo){
		return qmoneyrechargeComponent.findAllQmoneyrecharge(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找Q币充值表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQmoneyrechargeBySql(String sql,int limit,int offset){
		return qmoneyrechargeComponent.findAllQmoneyrecharge(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql Q币充值表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQmoneyrechargeBySql(String sql){
		return qmoneyrechargeComponent.excuteQmoneyrechargeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQmoneyrechargeBySql(String sql){
		return qmoneyrechargeComponent.countQmoneyrechargeBySql(sql);
	}
//	@Override
//	public Customeragent findCustomeragent(long id, String where,
//			String... colum) {
//		return null;
//	}
	

	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IHelpcenterComponent helpcenterComponent;
	  
 	
 	public IHelpcenterComponent getHelpcenterComponent() {
		return helpcenterComponent;
	}
	public void setHelpcenterComponent(IHelpcenterComponent  helpcenterComponent) {
		this.helpcenterComponent = helpcenterComponent;
	}
	/**
	 * 创建 帮助中心
	 * @param id
	 * @return deleted count 
	 */
	public Helpcenter createHelpcenter(Helpcenter helpcenter) throws SQLException{
	
		return helpcenterComponent.createHelpcenter(helpcenter);
	}
	/**
	 * 删除 帮助中心
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHelpcenter(long id){
	
		return helpcenterComponent.deleteHelpcenter(id);
	}
	
	
	/**
	 * 修改 帮助中心
	 * @param id
	 * @return updated count 
	 */
	public int updateHelpcenter(Helpcenter helpcenter){
		return helpcenterComponent.updateHelpcenter(helpcenter);
	
	}

		
	/**
	 * 修改 帮助中心但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHelpcenterIgnoreNull(Helpcenter helpcenter){
			return helpcenterComponent.updateHelpcenterIgnoreNull(helpcenter);
	
	}
	
	/**
	 * 查找 帮助中心
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenter(String where, String orderby,int limit,int offset){
		return helpcenterComponent.findAllHelpcenter(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 帮助中心
	 * @param id
	 * @return
	 */
	public Helpcenter findHelpcenter(long id){
		return helpcenterComponent.findHelpcenter(id);
	}
	
	/** 
	 * 查找 帮助中心
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHelpcenterForPageinfo(String where, String orderby,PageInfo pageinfo){
		return helpcenterComponent.findAllHelpcenter(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找帮助中心
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenterBySql(String sql,int limit,int offset){
		return helpcenterComponent.findAllHelpcenter(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 帮助中心
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHelpcenterBySql(String sql){
		return helpcenterComponent.excuteHelpcenterBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHelpcenterBySql(String sql){
		return helpcenterComponent.countHelpcenterBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IHelpcenterinfoComponent helpcenterinfoComponent;
	  
 	
 	public IHelpcenterinfoComponent getHelpcenterinfoComponent() {
		return helpcenterinfoComponent;
	}
	public void setHelpcenterinfoComponent(IHelpcenterinfoComponent  helpcenterinfoComponent) {
		this.helpcenterinfoComponent = helpcenterinfoComponent;
	}
	/**
	 * 创建 帮助中心信息
	 * @param id
	 * @return deleted count 
	 */
	public Helpcenterinfo createHelpcenterinfo(Helpcenterinfo helpcenterinfo) throws SQLException{
	
		return helpcenterinfoComponent.createHelpcenterinfo(helpcenterinfo);
	}
	/**
	 * 删除 帮助中心信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHelpcenterinfo(long id){
	
		return helpcenterinfoComponent.deleteHelpcenterinfo(id);
	}
	
	
	/**
	 * 修改 帮助中心信息
	 * @param id
	 * @return updated count 
	 */
	public int updateHelpcenterinfo(Helpcenterinfo helpcenterinfo){
		return helpcenterinfoComponent.updateHelpcenterinfo(helpcenterinfo);
	
	}

		
	/**
	 * 修改 帮助中心信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHelpcenterinfoIgnoreNull(Helpcenterinfo helpcenterinfo){
			return helpcenterinfoComponent.updateHelpcenterinfoIgnoreNull(helpcenterinfo);
	
	}
	
	/**
	 * 查找 帮助中心信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenterinfo(String where, String orderby,int limit,int offset){
		return helpcenterinfoComponent.findAllHelpcenterinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 帮助中心信息
	 * @param id
	 * @return
	 */
	public Helpcenterinfo findHelpcenterinfo(long id){
		return helpcenterinfoComponent.findHelpcenterinfo(id);
	}
	
	/** 
	 * 查找 帮助中心信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHelpcenterinfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return helpcenterinfoComponent.findAllHelpcenterinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找帮助中心信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenterinfoBySql(String sql,int limit,int offset){
		return helpcenterinfoComponent.findAllHelpcenterinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 帮助中心信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHelpcenterinfoBySql(String sql){
		return helpcenterinfoComponent.excuteHelpcenterinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHelpcenterinfoBySql(String sql){
		return helpcenterinfoComponent.countHelpcenterinfoBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IInformationComponent informationComponent;
	  
 	
 	public IInformationComponent getInformationComponent() {
		return informationComponent;
	}
	public void setInformationComponent(IInformationComponent  informationComponent) {
		this.informationComponent = informationComponent;
	}
	/**
	 * 创建 资讯中心
	 * @param id
	 * @return deleted count 
	 */
	public Information createInformation(Information information) throws SQLException{
	
		return informationComponent.createInformation(information);
	}
	/**
	 * 删除 资讯中心
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInformation(long id){
	
		return informationComponent.deleteInformation(id);
	}
	
	
	/**
	 * 修改 资讯中心
	 * @param id
	 * @return updated count 
	 */
	public int updateInformation(Information information){
		return informationComponent.updateInformation(information);
	
	}

		
	/**
	 * 修改 资讯中心但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInformationIgnoreNull(Information information){
			return informationComponent.updateInformationIgnoreNull(information);
	
	}
	
	/**
	 * 查找 资讯中心
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInformation(String where, String orderby,int limit,int offset){
		return informationComponent.findAllInformation(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 资讯中心
	 * @param id
	 * @return
	 */
	public Information findInformation(long id){
		return informationComponent.findInformation(id);
	}
	
	/** 
	 * 查找 资讯中心
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInformationForPageinfo(String where, String orderby,PageInfo pageinfo){
		return informationComponent.findAllInformation(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找资讯中心
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInformationBySql(String sql,int limit,int offset){
		return informationComponent.findAllInformation(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 资讯中心
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInformationBySql(String sql){
		return informationComponent.excuteInformationBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInformationBySql(String sql){
		return informationComponent.countInformationBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IInformationinfoComponent informationinfoComponent;
	  
 	
 	public IInformationinfoComponent getInformationinfoComponent() {
		return informationinfoComponent;
	}
	public void setInformationinfoComponent(IInformationinfoComponent  informationinfoComponent) {
		this.informationinfoComponent = informationinfoComponent;
	}
	/**
	 * 创建 资讯中心详细信息
	 * @param id
	 * @return deleted count 
	 */
	public Informationinfo createInformationinfo(Informationinfo informationinfo) throws SQLException{
	
		return informationinfoComponent.createInformationinfo(informationinfo);
	}
	/**
	 * 删除 资讯中心详细信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInformationinfo(long id){
	
		return informationinfoComponent.deleteInformationinfo(id);
	}
	
	
	/**
	 * 修改 资讯中心详细信息
	 * @param id
	 * @return updated count 
	 */
	public int updateInformationinfo(Informationinfo informationinfo){
		return informationinfoComponent.updateInformationinfo(informationinfo);
	
	}

		
	/**
	 * 修改 资讯中心详细信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInformationinfoIgnoreNull(Informationinfo informationinfo){
			return informationinfoComponent.updateInformationinfoIgnoreNull(informationinfo);
	
	}
	
	/**
	 * 查找 资讯中心详细信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInformationinfo(String where, String orderby,int limit,int offset){
		return informationinfoComponent.findAllInformationinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 资讯中心详细信息
	 * @param id
	 * @return
	 */
	public Informationinfo findInformationinfo(long id){
		return informationinfoComponent.findInformationinfo(id);
	}
	
	/** 
	 * 查找 资讯中心详细信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInformationinfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return informationinfoComponent.findAllInformationinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找资讯中心详细信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInformationinfoBySql(String sql,int limit,int offset){
		return informationinfoComponent.findAllInformationinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 资讯中心详细信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInformationinfoBySql(String sql){
		return informationinfoComponent.excuteInformationinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInformationinfoBySql(String sql){
		return informationinfoComponent.countInformationinfoBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IPlaneserviceComponent planeserviceComponent;
	  
 	
 	public IPlaneserviceComponent getPlaneserviceComponent() {
		return planeserviceComponent;
	}
	public void setPlaneserviceComponent(IPlaneserviceComponent  planeserviceComponent) {
		this.planeserviceComponent = planeserviceComponent;
	}
	/**
	 * 创建 包机服务
	 * @param id
	 * @return deleted count 
	 */
	public Planeservice createPlaneservice(Planeservice planeservice) throws SQLException{
	
		return planeserviceComponent.createPlaneservice(planeservice);
	}
	/**
	 * 删除 包机服务
	 * @param id
	 * @return deleted count 
	 */
	public int deletePlaneservice(long id){
	
		return planeserviceComponent.deletePlaneservice(id);
	}
	
	
	/**
	 * 修改 包机服务
	 * @param id
	 * @return updated count 
	 */
	public int updatePlaneservice(Planeservice planeservice){
		return planeserviceComponent.updatePlaneservice(planeservice);
	
	}

		
	/**
	 * 修改 包机服务但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePlaneserviceIgnoreNull(Planeservice planeservice){
			return planeserviceComponent.updatePlaneserviceIgnoreNull(planeservice);
	
	}
	
	/**
	 * 查找 包机服务
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPlaneservice(String where, String orderby,int limit,int offset){
		return planeserviceComponent.findAllPlaneservice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 包机服务
	 * @param id
	 * @return
	 */
	public Planeservice findPlaneservice(long id){
		return planeserviceComponent.findPlaneservice(id);
	}
	
	/** 
	 * 查找 包机服务
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPlaneserviceForPageinfo(String where, String orderby,PageInfo pageinfo){
		return planeserviceComponent.findAllPlaneservice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找包机服务
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPlaneserviceBySql(String sql,int limit,int offset){
		return planeserviceComponent.findAllPlaneservice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 包机服务
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePlaneserviceBySql(String sql){
		return planeserviceComponent.excutePlaneserviceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPlaneserviceBySql(String sql){
		return planeserviceComponent.countPlaneserviceBySql(sql);
	}
	
	

//
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IUseraddressComponent useraddressComponent;
	  
 	
 	public IUseraddressComponent getUseraddressComponent() {
		return useraddressComponent;
	}
	public void setUseraddressComponent(IUseraddressComponent  useraddressComponent) {
		this.useraddressComponent = useraddressComponent;
	}
	/**
	 * 创建 会员常用配送地址
	 * @param id
	 * @return deleted count 
	 */
	public Useraddress createUseraddress(Useraddress useraddress) throws SQLException{
	
		return useraddressComponent.createUseraddress(useraddress);
	}
	/**
	 * 删除 会员常用配送地址
	 * @param id
	 * @return deleted count 
	 */
	public int deleteUseraddress(long id){
	
		return useraddressComponent.deleteUseraddress(id);
	}
	
	
	/**
	 * 修改 会员常用配送地址
	 * @param id
	 * @return updated count 
	 */
	public int updateUseraddress(Useraddress useraddress){
		return useraddressComponent.updateUseraddress(useraddress);
	
	}

		
	/**
	 * 修改 会员常用配送地址但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateUseraddressIgnoreNull(Useraddress useraddress){
			return useraddressComponent.updateUseraddressIgnoreNull(useraddress);
	
	}
	
	/**
	 * 查找 会员常用配送地址
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllUseraddress(String where, String orderby,int limit,int offset){
		return useraddressComponent.findAllUseraddress(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 会员常用配送地址
	 * @param id
	 * @return
	 */
	public Useraddress findUseraddress(long id){
		return useraddressComponent.findUseraddress(id);
	}
	
	/** 
	 * 查找 会员常用配送地址
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllUseraddressForPageinfo(String where, String orderby,PageInfo pageinfo){
		return useraddressComponent.findAllUseraddress(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找会员常用配送地址
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllUseraddressBySql(String sql,int limit,int offset){
		return useraddressComponent.findAllUseraddress(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 会员常用配送地址
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteUseraddressBySql(String sql){
		return useraddressComponent.excuteUseraddressBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countUseraddressBySql(String sql){
		return useraddressComponent.countUseraddressBySql(sql);
	}
	
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ITempletComponent templetComponent;
	  
 	
 	public ITempletComponent getTempletComponent() {
		return templetComponent;
	}
	public void setTempletComponent(ITempletComponent  templetComponent) {
		this.templetComponent = templetComponent;
	}
	/**
	 * 创建 模板
	 * @param id
	 * @return deleted count 
	 */
	public Templet createTemplet(Templet templet) throws SQLException{
	
		return templetComponent.createTemplet(templet);
	}
	/**
	 * 删除 模板
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTemplet(long id){
	
		return templetComponent.deleteTemplet(id);
	}
	
	
	/**
	 * 修改 模板
	 * @param id
	 * @return updated count 
	 */
	public int updateTemplet(Templet templet){
		return templetComponent.updateTemplet(templet);
	
	}

		
	/**
	 * 修改 模板但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTempletIgnoreNull(Templet templet){
			return templetComponent.updateTempletIgnoreNull(templet);
	
	}
	
	/**
	 * 查找 模板
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTemplet(String where, String orderby,int limit,int offset){
		return templetComponent.findAllTemplet(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 模板
	 * @param id
	 * @return
	 */
	public Templet findTemplet(long id){
		return templetComponent.findTemplet(id);
	}
	
	/** 
	 * 查找 模板
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTempletForPageinfo(String where, String orderby,PageInfo pageinfo){
		return templetComponent.findAllTemplet(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找模板
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTempletBySql(String sql,int limit,int offset){
		return templetComponent.findAllTemplet(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 模板
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTempletBySql(String sql){
		return templetComponent.excuteTempletBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTempletBySql(String sql){
		return templetComponent.countTempletBySql(sql);
	}
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IMessgroupComponent messgroupComponent;
	  
 	
 	public IMessgroupComponent getMessgroupComponent() {
		return messgroupComponent;
	}
	public void setMessgroupComponent(IMessgroupComponent  messgroupComponent) {
		this.messgroupComponent = messgroupComponent;
	}
	/**
	 * 创建 短信用户组
	 * @param id
	 * @return deleted count 
	 */
	public Messgroup createMessgroup(Messgroup messgroup) throws SQLException{
	
		return messgroupComponent.createMessgroup(messgroup);
	}
	/**
	 * 删除 短信用户组
	 * @param id
	 * @return deleted count 
	 */
	public int deleteMessgroup(long id){
	
		return messgroupComponent.deleteMessgroup(id);
	}
	
	
	/**
	 * 修改 短信用户组
	 * @param id
	 * @return updated count 
	 */
	public int updateMessgroup(Messgroup messgroup){
		return messgroupComponent.updateMessgroup(messgroup);
	
	}

		
	/**
	 * 修改 短信用户组但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateMessgroupIgnoreNull(Messgroup messgroup){
			return messgroupComponent.updateMessgroupIgnoreNull(messgroup);
	
	}
	
	/**
	 * 查找 短信用户组
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllMessgroup(String where, String orderby,int limit,int offset){
		return messgroupComponent.findAllMessgroup(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 短信用户组
	 * @param id
	 * @return
	 */
	public Messgroup findMessgroup(long id){
		return messgroupComponent.findMessgroup(id);
	}
	
	/** 
	 * 查找 短信用户组
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllMessgroupForPageinfo(String where, String orderby,PageInfo pageinfo){
		return messgroupComponent.findAllMessgroup(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找短信用户组
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllMessgroupBySql(String sql,int limit,int offset){
		return messgroupComponent.findAllMessgroup(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 短信用户组
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteMessgroupBySql(String sql){
		return messgroupComponent.excuteMessgroupBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countMessgroupBySql(String sql){
		return messgroupComponent.countMessgroupBySql(sql);
	}

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IAgentvalueComponent agentvalueComponent;
	  
 	
 	public IAgentvalueComponent getAgentvalueComponent() {
		return agentvalueComponent;
	}
	public void setAgentvalueComponent(IAgentvalueComponent  agentvalueComponent) {
		this.agentvalueComponent = agentvalueComponent;
	}
	/**
	 * 创建 加盟商固定返点
	 * @param id
	 * @return deleted count 
	 */
	public Agentvalue createAgentvalue(Agentvalue agentvalue) throws SQLException{
	
		return agentvalueComponent.createAgentvalue(agentvalue);
	}
	/**
	 * 删除 加盟商固定返点
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAgentvalue(long id){
	
		return agentvalueComponent.deleteAgentvalue(id);
	}
	
	
	/**
	 * 修改 加盟商固定返点
	 * @param id
	 * @return updated count 
	 */
	public int updateAgentvalue(Agentvalue agentvalue){
		return agentvalueComponent.updateAgentvalue(agentvalue);
	
	}

		
	/**
	 * 修改 加盟商固定返点但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAgentvalueIgnoreNull(Agentvalue agentvalue){
			return agentvalueComponent.updateAgentvalueIgnoreNull(agentvalue);
	
	}
	
	/**
	 * 查找 加盟商固定返点
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentvalue(String where, String orderby,int limit,int offset){
		return agentvalueComponent.findAllAgentvalue(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 加盟商固定返点
	 * @param id
	 * @return
	 */
	public Agentvalue findAgentvalue(long id){
		return agentvalueComponent.findAgentvalue(id);
	}
	
	/** 
	 * 查找 加盟商固定返点
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAgentvalueForPageinfo(String where, String orderby,PageInfo pageinfo){
		return agentvalueComponent.findAllAgentvalue(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找加盟商固定返点
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentvalueBySql(String sql,int limit,int offset){
		return agentvalueComponent.findAllAgentvalue(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 加盟商固定返点
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAgentvalueBySql(String sql){
		return agentvalueComponent.excuteAgentvalueBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAgentvalueBySql(String sql){
		return agentvalueComponent.countAgentvalueBySql(sql);
	}
	
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ILogindescComponent logindescComponent;
	  
 	
 	public ILogindescComponent getLogindescComponent() {
		return logindescComponent;
	}
	public void setLogindescComponent(ILogindescComponent  logindescComponent) {
		this.logindescComponent = logindescComponent;
	}
	/**
	 * 创建 登录信息
	 * @param id
	 * @return deleted count 
	 */
	public Logindesc createLogindesc(Logindesc logindesc) throws SQLException{
	
		return logindescComponent.createLogindesc(logindesc);
	}
	/**
	 * 删除 登录信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLogindesc(long id){
	
		return logindescComponent.deleteLogindesc(id);
	}
	
	
	/**
	 * 修改 登录信息
	 * @param id
	 * @return updated count 
	 */
	public int updateLogindesc(Logindesc logindesc){
		return logindescComponent.updateLogindesc(logindesc);
	
	}

		
	/**
	 * 修改 登录信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLogindescIgnoreNull(Logindesc logindesc){
			return logindescComponent.updateLogindescIgnoreNull(logindesc);
	
	}
	
	/**
	 * 查找 登录信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLogindesc(String where, String orderby,int limit,int offset){
		return logindescComponent.findAllLogindesc(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 登录信息
	 * @param id
	 * @return
	 */
	public Logindesc findLogindesc(long id){
		return logindescComponent.findLogindesc(id);
	}
	
	/** 
	 * 查找 登录信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLogindescForPageinfo(String where, String orderby,PageInfo pageinfo){
		return logindescComponent.findAllLogindesc(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找登录信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLogindescBySql(String sql,int limit,int offset){
		return logindescComponent.findAllLogindesc(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 登录信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLogindescBySql(String sql){
		return logindescComponent.excuteLogindescBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLogindescBySql(String sql){
		return logindescComponent.countLogindescBySql(sql);
	}
	
	

//粘贴到Service实现类
	
	private IAirdelayproveComponent airdelayproveComponent;
	  
 	
 	public IAirdelayproveComponent getAirdelayproveComponent() {
		return airdelayproveComponent;
	}
	public void setAirdelayproveComponent(IAirdelayproveComponent  airdelayproveComponent) {
		this.airdelayproveComponent = airdelayproveComponent;
	}
	/**
	 * 创建 航班延误证明
	 * @param id
	 * @return deleted count 
	 */
	public Airdelayprove createAirdelayprove(Airdelayprove airdelayprove) throws SQLException{
	
		return airdelayproveComponent.createAirdelayprove(airdelayprove);
	}
	/**
	 * 删除 航班延误证明
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirdelayprove(long id){
	
		return airdelayproveComponent.deleteAirdelayprove(id);
	}
	
	
	/**
	 * 修改 航班延误证明
	 * @param id
	 * @return updated count 
	 */
	public int updateAirdelayprove(Airdelayprove airdelayprove){
		return airdelayproveComponent.updateAirdelayprove(airdelayprove);
	
	}

		
	/**
	 * 修改 航班延误证明但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirdelayproveIgnoreNull(Airdelayprove airdelayprove){
			return airdelayproveComponent.updateAirdelayproveIgnoreNull(airdelayprove);
	
	}
	
	/**
	 * 查找 航班延误证明
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirdelayprove(String where, String orderby,int limit,int offset){
		return airdelayproveComponent.findAllAirdelayprove(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 航班延误证明
	 * @param id
	 * @return
	 */
	public Airdelayprove findAirdelayprove(long id){
		return airdelayproveComponent.findAirdelayprove(id);
	}
	
	/** 
	 * 查找 航班延误证明
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirdelayproveForPageinfo(String where, String orderby,PageInfo pageinfo){
		return airdelayproveComponent.findAllAirdelayprove(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找航班延误证明
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirdelayproveBySql(String sql,int limit,int offset){
		return airdelayproveComponent.findAllAirdelayprove(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 航班延误证明
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirdelayproveBySql(String sql){
		return airdelayproveComponent.excuteAirdelayproveBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirdelayproveBySql(String sql){
		return airdelayproveComponent.countAirdelayproveBySql(sql);
	}
	
	
	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IHuodonguserComponent huodonguserComponent;
	  
 	
 	public IHuodonguserComponent getHuodonguserComponent() {
		return huodonguserComponent;
	}
	public void setHuodonguserComponent(IHuodonguserComponent  huodonguserComponent) {
		this.huodonguserComponent = huodonguserComponent;
	}
	/**
	 * 创建 活动会员
	 * @param id
	 * @return deleted count 
	 */
	public Huodonguser createHuodonguser(Huodonguser huodonguser) throws SQLException{
	
		return huodonguserComponent.createHuodonguser(huodonguser);
	}
	/**
	 * 删除 活动会员
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHuodonguser(long id){
	
		return huodonguserComponent.deleteHuodonguser(id);
	}
	
	
	/**
	 * 修改 活动会员
	 * @param id
	 * @return updated count 
	 */
	public int updateHuodonguser(Huodonguser huodonguser){
		return huodonguserComponent.updateHuodonguser(huodonguser);
	
	}

		
	/**
	 * 修改 活动会员但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHuodonguserIgnoreNull(Huodonguser huodonguser){
			return huodonguserComponent.updateHuodonguserIgnoreNull(huodonguser);
	
	}
	
	/**
	 * 查找 活动会员
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHuodonguser(String where, String orderby,int limit,int offset){
		return huodonguserComponent.findAllHuodonguser(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 活动会员
	 * @param id
	 * @return
	 */
	public Huodonguser findHuodonguser(long id){
		return huodonguserComponent.findHuodonguser(id);
	}
	
	/** 
	 * 查找 活动会员
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHuodonguserForPageinfo(String where, String orderby,PageInfo pageinfo){
		return huodonguserComponent.findAllHuodonguser(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找活动会员
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHuodonguserBySql(String sql,int limit,int offset){
		return huodonguserComponent.findAllHuodonguser(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 活动会员
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHuodonguserBySql(String sql){
		return huodonguserComponent.excuteHuodonguserBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHuodonguserBySql(String sql){
		return huodonguserComponent.countHuodonguserBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IQqinfonewComponent qqinfonewComponent;
	  
 	
 	public IQqinfonewComponent getQqinfonewComponent() {
		return qqinfonewComponent;
	}
	public void setQqinfonewComponent(IQqinfonewComponent  qqinfonewComponent) {
		this.qqinfonewComponent = qqinfonewComponent;
	}
	/**
	 * 创建 QQ号码
	 * @param id
	 * @return deleted count 
	 */
	public Qqinfonew createQqinfonew(Qqinfonew qqinfonew) throws SQLException{
	
		return qqinfonewComponent.createQqinfonew(qqinfonew);
	}
	/**
	 * 删除 QQ号码
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQqinfonew(long id){
	
		return qqinfonewComponent.deleteQqinfonew(id);
	}
	
	
	/**
	 * 修改 QQ号码
	 * @param id
	 * @return updated count 
	 */
	public int updateQqinfonew(Qqinfonew qqinfonew){
		return qqinfonewComponent.updateQqinfonew(qqinfonew);
	
	}

		
	/**
	 * 修改 QQ号码但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQqinfonewIgnoreNull(Qqinfonew qqinfonew){
			return qqinfonewComponent.updateQqinfonewIgnoreNull(qqinfonew);
	
	}
	
	/**
	 * 查找 QQ号码
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfonew(String where, String orderby,int limit,int offset){
		return qqinfonewComponent.findAllQqinfonew(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 QQ号码
	 * @param id
	 * @return
	 */
	public Qqinfonew findQqinfonew(long id){
		return qqinfonewComponent.findQqinfonew(id);
	}
	
	/** 
	 * 查找 QQ号码
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQqinfonewForPageinfo(String where, String orderby,PageInfo pageinfo){
		return qqinfonewComponent.findAllQqinfonew(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找QQ号码
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqinfonewBySql(String sql,int limit,int offset){
		return qqinfonewComponent.findAllQqinfonew(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql QQ号码
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQqinfonewBySql(String sql){
		return qqinfonewComponent.excuteQqinfonewBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQqinfonewBySql(String sql){
		return qqinfonewComponent.countQqinfonewBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IQqtypenewComponent qqtypenewComponent;
	  
 	
 	public IQqtypenewComponent getQqtypenewComponent() {
		return qqtypenewComponent;
	}
	public void setQqtypenewComponent(IQqtypenewComponent  qqtypenewComponent) {
		this.qqtypenewComponent = qqtypenewComponent;
	}
	/**
	 * 创建 QQ类型
	 * @param id
	 * @return deleted count 
	 */
	public Qqtypenew createQqtypenew(Qqtypenew qqtypenew) throws SQLException{
	
		return qqtypenewComponent.createQqtypenew(qqtypenew);
	}
	/**
	 * 删除 QQ类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteQqtypenew(long id){
	
		return qqtypenewComponent.deleteQqtypenew(id);
	}
	
	
	/**
	 * 修改 QQ类型
	 * @param id
	 * @return updated count 
	 */
	public int updateQqtypenew(Qqtypenew qqtypenew){
		return qqtypenewComponent.updateQqtypenew(qqtypenew);
	
	}

		
	/**
	 * 修改 QQ类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateQqtypenewIgnoreNull(Qqtypenew qqtypenew){
			return qqtypenewComponent.updateQqtypenewIgnoreNull(qqtypenew);
	
	}
	
	/**
	 * 查找 QQ类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqtypenew(String where, String orderby,int limit,int offset){
		return qqtypenewComponent.findAllQqtypenew(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 QQ类型
	 * @param id
	 * @return
	 */
	public Qqtypenew findQqtypenew(long id){
		return qqtypenewComponent.findQqtypenew(id);
	}
	
	/** 
	 * 查找 QQ类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllQqtypenewForPageinfo(String where, String orderby,PageInfo pageinfo){
		return qqtypenewComponent.findAllQqtypenew(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找QQ类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllQqtypenewBySql(String sql,int limit,int offset){
		return qqtypenewComponent.findAllQqtypenew(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql QQ类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteQqtypenewBySql(String sql){
		return qqtypenewComponent.excuteQqtypenewBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countQqtypenewBySql(String sql){
		return qqtypenewComponent.countQqtypenewBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ITxuserinfoComponent txuserinfoComponent;
	  
 	
 	public ITxuserinfoComponent getTxuserinfoComponent() {
		return txuserinfoComponent;
	}
	public void setTxuserinfoComponent(ITxuserinfoComponent  txuserinfoComponent) {
		this.txuserinfoComponent = txuserinfoComponent;
	}
	/**
	 * 创建 用户信息
	 * @param id
	 * @return deleted count 
	 */
	public Txuserinfo createTxuserinfo(Txuserinfo txuserinfo) throws SQLException{
	
		return txuserinfoComponent.createTxuserinfo(txuserinfo);
	}
	/**
	 * 删除 用户信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTxuserinfo(long id){
	
		return txuserinfoComponent.deleteTxuserinfo(id);
	}
	
	
	/**
	 * 修改 用户信息
	 * @param id
	 * @return updated count 
	 */
	public int updateTxuserinfo(Txuserinfo txuserinfo){
		return txuserinfoComponent.updateTxuserinfo(txuserinfo);
	
	}

		
	/**
	 * 修改 用户信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTxuserinfoIgnoreNull(Txuserinfo txuserinfo){
			return txuserinfoComponent.updateTxuserinfoIgnoreNull(txuserinfo);
	
	}
	
	/**
	 * 查找 用户信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTxuserinfo(String where, String orderby,int limit,int offset){
		return txuserinfoComponent.findAllTxuserinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 用户信息
	 * @param id
	 * @return
	 */
	public Txuserinfo findTxuserinfo(long id){
		return txuserinfoComponent.findTxuserinfo(id);
	}
	
	/** 
	 * 查找 用户信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTxuserinfoForPageinfo(String where, String orderby,PageInfo pageinfo){
		return txuserinfoComponent.findAllTxuserinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找用户信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTxuserinfoBySql(String sql,int limit,int offset){
		return txuserinfoComponent.findAllTxuserinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 用户信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTxuserinfoBySql(String sql){
		return txuserinfoComponent.excuteTxuserinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTxuserinfoBySql(String sql){
		return txuserinfoComponent.countTxuserinfoBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private ITxorderComponent txorderComponent;
	  
 	
 	public ITxorderComponent getTxorderComponent() {
		return txorderComponent;
	}
	public void setTxorderComponent(ITxorderComponent  txorderComponent) {
		this.txorderComponent = txorderComponent;
	}
	/**
	 * 创建 TX订单
	 * @param id
	 * @return deleted count 
	 */
	public Txorder createTxorder(Txorder txorder) throws SQLException{
	
		return txorderComponent.createTxorder(txorder);
	}
	/**
	 * 删除 TX订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTxorder(long id){
	
		return txorderComponent.deleteTxorder(id);
	}
	
	
	/**
	 * 修改 TX订单
	 * @param id
	 * @return updated count 
	 */
	public int updateTxorder(Txorder txorder){
		return txorderComponent.updateTxorder(txorder);
	
	}

		
	/**
	 * 修改 TX订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTxorderIgnoreNull(Txorder txorder){
			return txorderComponent.updateTxorderIgnoreNull(txorder);
	
	}
	
	/**
	 * 查找 TX订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTxorder(String where, String orderby,int limit,int offset){
		return txorderComponent.findAllTxorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 TX订单
	 * @param id
	 * @return
	 */
	public Txorder findTxorder(long id){
		return txorderComponent.findTxorder(id);
	}
	
	/** 
	 * 查找 TX订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTxorderForPageinfo(String where, String orderby,PageInfo pageinfo){
		return txorderComponent.findAllTxorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找TX订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTxorderBySql(String sql,int limit,int offset){
		return txorderComponent.findAllTxorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql TX订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTxorderBySql(String sql){
		return txorderComponent.excuteTxorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTxorderBySql(String sql){
		return txorderComponent.countTxorderBySql(sql);
	}
	
	


	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IWithbankComponent withbankComponent;
	  
 	
 	public IWithbankComponent getWithbankComponent() {
		return withbankComponent;
	}
	public void setWithbankComponent(IWithbankComponent  withbankComponent) {
		this.withbankComponent = withbankComponent;
	}
	/**
	 * 创建 提现
	 * @param id
	 * @return deleted count 
	 */
	public Withbank createWithbank(Withbank withbank) throws SQLException{
	
		return withbankComponent.createWithbank(withbank);
	}
	/**
	 * 删除 提现
	 * @param id
	 * @return deleted count 
	 */
	public int deleteWithbank(long id){
	
		return withbankComponent.deleteWithbank(id);
	}
	
	
	/**
	 * 修改 提现
	 * @param id
	 * @return updated count 
	 */
	public int updateWithbank(Withbank withbank){
		return withbankComponent.updateWithbank(withbank);
	
	}

		
	/**
	 * 修改 提现但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateWithbankIgnoreNull(Withbank withbank){
			return withbankComponent.updateWithbankIgnoreNull(withbank);
	
	}
	
	/**
	 * 查找 提现
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWithbank(String where, String orderby,int limit,int offset){
		return withbankComponent.findAllWithbank(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 提现
	 * @param id
	 * @return
	 */
	public Withbank findWithbank(long id){
		return withbankComponent.findWithbank(id);
	}
	
	/** 
	 * 查找 提现
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllWithbankForPageinfo(String where, String orderby,PageInfo pageinfo){
		return withbankComponent.findAllWithbank(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找提现
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWithbankBySql(String sql,int limit,int offset){
		return withbankComponent.findAllWithbank(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 提现
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteWithbankBySql(String sql){
		return withbankComponent.excuteWithbankBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countWithbankBySql(String sql){
		return withbankComponent.countWithbankBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IYmuserComponent ymuserComponent;
	  
 	
 	public IYmuserComponent getYmuserComponent() {
		return ymuserComponent;
	}
	public void setYmuserComponent(IYmuserComponent  ymuserComponent) {
		this.ymuserComponent = ymuserComponent;
	}
	/**
	 * 创建 短信用户账号
	 * @param id
	 * @return deleted count 
	 */
	public Ymuser createYmuser(Ymuser ymuser) throws SQLException{
	
		return ymuserComponent.createYmuser(ymuser);
	}
	/**
	 * 删除 短信用户账号
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmuser(long id){
	
		return ymuserComponent.deleteYmuser(id);
	}
	
	
	/**
	 * 修改 短信用户账号
	 * @param id
	 * @return updated count 
	 */
	public int updateYmuser(Ymuser ymuser){
		return ymuserComponent.updateYmuser(ymuser);
	
	}

		
	/**
	 * 修改 短信用户账号但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmuserIgnoreNull(Ymuser ymuser){
			return ymuserComponent.updateYmuserIgnoreNull(ymuser);
	
	}
	
	/**
	 * 查找 短信用户账号
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmuser(String where, String orderby,int limit,int offset){
		return ymuserComponent.findAllYmuser(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 短信用户账号
	 * @param id
	 * @return
	 */
	public Ymuser findYmuser(long id){
		return ymuserComponent.findYmuser(id);
	}
	
	/** 
	 * 查找 短信用户账号
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmuserForPageinfo(String where, String orderby,PageInfo pageinfo){
		return ymuserComponent.findAllYmuser(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找短信用户账号
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmuserBySql(String sql,int limit,int offset){
		return ymuserComponent.findAllYmuser(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 短信用户账号
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmuserBySql(String sql){
		return ymuserComponent.excuteYmuserBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmuserBySql(String sql){
		return ymuserComponent.countYmuserBySql(sql);
	}
	
	

	//------------------------------------------------------------------------
	//粘贴到Service实现类
	
	private IYmpayComponent ympayComponent;
	  
 	
 	public IYmpayComponent getYmpayComponent() {
		return ympayComponent;
	}
	public void setYmpayComponent(IYmpayComponent  ympayComponent) {
		this.ympayComponent = ympayComponent;
	}
	/**
	 * 创建 短信充值记录
	 * @param id
	 * @return deleted count 
	 */
	public Ympay createYmpay(Ympay ympay) throws SQLException{
	
		return ympayComponent.createYmpay(ympay);
	}
	/**
	 * 删除 短信充值记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmpay(long id){
	
		return ympayComponent.deleteYmpay(id);
	}
	
	
	/**
	 * 修改 短信充值记录
	 * @param id
	 * @return updated count 
	 */
	public int updateYmpay(Ympay ympay){
		return ympayComponent.updateYmpay(ympay);
	
	}

		
	/**
	 * 修改 短信充值记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmpayIgnoreNull(Ympay ympay){
			return ympayComponent.updateYmpayIgnoreNull(ympay);
	
	}
	
	/**
	 * 查找 短信充值记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmpay(String where, String orderby,int limit,int offset){
		return ympayComponent.findAllYmpay(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 短信充值记录
	 * @param id
	 * @return
	 */
	public Ympay findYmpay(long id){
		return ympayComponent.findYmpay(id);
	}
	
	/** 
	 * 查找 短信充值记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmpayForPageinfo(String where, String orderby,PageInfo pageinfo){
		return ympayComponent.findAllYmpay(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找短信充值记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmpayBySql(String sql,int limit,int offset){
		return ympayComponent.findAllYmpay(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 短信充值记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmpayBySql(String sql){
		return ympayComponent.excuteYmpayBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmpayBySql(String sql){
		return ympayComponent.countYmpayBySql(sql);
	}
	
	
	
}