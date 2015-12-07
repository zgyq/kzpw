package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.adcooperate.Adcooperate;
import com.yf.system.base.agentroleref.Agentroleref;
import com.yf.system.base.agentvalue.Agentvalue;
import com.yf.system.base.airdelayprove.Airdelayprove;
import com.yf.system.base.biguser.Biguser;
import com.yf.system.base.biguserprice.Biguserprice;
import com.yf.system.base.creditcard.Creditcard;
import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.customercredit.Customercredit;
import com.yf.system.base.customerintegralrecord.Customerintegralrecord;
import com.yf.system.base.customerpassenger.Customerpassenger;
import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.department.Department;
import com.yf.system.base.exchrecord.Exchrecord;
import com.yf.system.base.gerenguazhanfrec.Gerenguazhanfrec;
import com.yf.system.base.helpcenter.Helpcenter;
import com.yf.system.base.helpcenterinfo.Helpcenterinfo;
import com.yf.system.base.huodonguser.Huodonguser;
import com.yf.system.base.importmureport.Importmureport;
import com.yf.system.base.infocontent.Infocontent;
import com.yf.system.base.information.Information;
import com.yf.system.base.informationinfo.Informationinfo;
import com.yf.system.base.infotype.Infotype;
import com.yf.system.base.insuranceinfo.Insuranceinfo;
import com.yf.system.base.integral.Integral;
import com.yf.system.base.liudianrecord.Liudianrecord;
import com.yf.system.base.liudianrefinfo.Liudianrefinfo;
import com.yf.system.base.logindesc.Logindesc;
import com.yf.system.base.messgroup.Messgroup;
import com.yf.system.base.miscellaneous.Miscellaneous;
import com.yf.system.base.planeservice.Planeservice;
import com.yf.system.base.prizeinfo.Prizeinfo;
import com.yf.system.base.prizetype.Prizetype;
import com.yf.system.base.qmessage.Qmessage;
import com.yf.system.base.qmoneyrecharge.Qmoneyrecharge;
import com.yf.system.base.qqinfo.Qqinfo;
import com.yf.system.base.qqinfonew.Qqinfonew;
import com.yf.system.base.qqtype.Qqtype;
import com.yf.system.base.qqtypenew.Qqtypenew;
import com.yf.system.base.rebaterecord.Rebaterecord;
import com.yf.system.base.rebaterule.Rebaterule;
import com.yf.system.base.recharge.Recharge;
import com.yf.system.base.repay.Repay;
import com.yf.system.base.settlementtype.Settlementtype;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.sysroleright.Sysroleright;
import com.yf.system.base.systemaction.Systemaction;
import com.yf.system.base.systemright.Systemright;
import com.yf.system.base.systemrole.Systemrole;
import com.yf.system.base.telephone.Telephone;
import com.yf.system.base.templet.Templet;
import com.yf.system.base.ticketnumber.Ticketnumber;
import com.yf.system.base.tickettype.Tickettype;
import com.yf.system.base.tousu.Tousu;
import com.yf.system.base.traderecord.Traderecord;
import com.yf.system.base.travelskyreport.Travelskyreport;
import com.yf.system.base.txorder.Txorder;
import com.yf.system.base.txuserinfo.Txuserinfo;
import com.yf.system.base.useraddress.Useraddress;
import com.yf.system.base.userintegral.Userintegral;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.vmoneyrecord.Vmoneyrecord;
import com.yf.system.base.wanlixing.Wanlixing;
import com.yf.system.base.withbank.Withbank;
import com.yf.system.base.ympay.Ympay;
import com.yf.system.base.ymreceive.Ymreceive;
import com.yf.system.base.ymsend.Ymsend;
import com.yf.system.base.ymuser.Ymuser;

public interface IMemberService {
	
	
	public boolean isCache() ;
	
	public void setCache(boolean cache) ;
	/**
	 * 创建 会员
	 * @param id
	 * @return deleted count 
	 */
	public Customeruser createCustomeruser(Customeruser customeruser) throws SQLException;
	
	/**
	 * 删除 会员
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomeruser(long id);
	
	
	/**
	 * 修改 会员
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomeruser(Customeruser customeruser);

		
	/**
	 * 修改 会员但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomeruserIgnoreNull(Customeruser customeruser);
		
	
	/**
	 * 查找 会员
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeruser(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 会员
	 * @param id
	 * @return
	 */
	public Customeruser findCustomeruser(long id);
	
	
	/** 
	 * 查找 会员
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomeruserForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找会员
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeruserBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 会员
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomeruserBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomeruserBySql(String sql);
		
	///////////////////
	/**
	 * 创建 加盟商信息表
	 * @param id
	 * @return deleted count 
	 */
	public Customeragent createCustomeragent(Customeragent customeragent) throws SQLException;
	
	/**
	 * 删除 加盟商信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomeragent(long id);
	
	
	/**
	 * 修改 加盟商信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomeragent(Customeragent customeragent);

		
	/**
	 * 修改 加盟商信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomeragentIgnoreNull(Customeragent customeragent);
		
	
	/**
	 * 查找 加盟商信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeragent(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 加盟商信息表
	 * @param id
	 * @return
	 */
	public Customeragent findCustomeragent(long id);
	
	
	/** 
	 * 查找 加盟商信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomeragentForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找加盟商信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeragentBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 加盟商信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomeragentBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomeragentBySql(String sql);
	/////////////////////////////
	/**
	 * 创建 证件
	 * @param id
	 * @return deleted count 
	 */
	public Customercredit createCustomercredit(Customercredit customercredit) throws SQLException;
	
	/**
	 * 删除 证件
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomercredit(long id);
	
	
	/**
	 * 修改 证件
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomercredit(Customercredit customercredit);

		
	/**
	 * 修改 证件但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomercreditIgnoreNull(Customercredit customercredit);
		
	
	/**
	 * 查找 证件
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomercredit(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 证件
	 * @param id
	 * @return
	 */
	public Customercredit findCustomercredit(long id);
	
	
	/** 
	 * 查找 证件
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomercreditForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找证件
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomercreditBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 证件
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomercreditBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomercreditBySql(String sql);
	/////////////////////////////////
	/**
	 * 创建 常用旅客
	 * @param id
	 * @return deleted count 
	 */
	public Customerpassenger createCustomerpassenger(Customerpassenger customerpassenger) throws SQLException;
	
	/**
	 * 删除 常用旅客
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomerpassenger(long id);
	
	
	/**
	 * 修改 常用旅客
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomerpassenger(Customerpassenger customerpassenger);

		
	/**
	 * 修改 常用旅客但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomerpassengerIgnoreNull(Customerpassenger customerpassenger);
		
	
	/**
	 * 查找 常用旅客
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerpassenger(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 常用旅客
	 * @param id
	 * @return
	 */
	public Customerpassenger findCustomerpassenger(long id);
	
	
	/** 
	 * 查找 常用旅客
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomerpassengerForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找常用旅客
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomerpassengerBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 常用旅客
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomerpassengerBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomerpassengerBySql(String sql);
	///////////////////////
	
	/**
	 * 创建 系统角色权限关联
	 * @param id
	 * @return deleted count 
	 */
	public Sysroleright createSysroleright(Sysroleright sysroleright) throws SQLException;
	
	/**
	 * 删除 系统角色权限关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysroleright(long id);
	
	
	/**
	 * 修改 系统角色权限关联
	 * @param id
	 * @return updated count 
	 */
	public int updateSysroleright(Sysroleright sysroleright);

		
	/**
	 * 修改 系统角色权限关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysrolerightIgnoreNull(Sysroleright sysroleright);
		
	
	/**
	 * 查找 系统角色权限关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysroleright(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 系统角色权限关联
	 * @param id
	 * @return
	 */
	public Sysroleright findSysroleright(long id);
	
	
	/** 
	 * 查找 系统角色权限关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysrolerightForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找系统角色权限关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysrolerightBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 系统角色权限关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysrolerightBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysrolerightBySql(String sql);
	////////////////////
	/**
	 * 创建 系统用户行为
	 * @param id
	 * @return deleted count 
	 */
	public Systemaction createSystemaction(Systemaction systemaction) throws SQLException;
	
	/**
	 * 删除 系统用户行为
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSystemaction(long id);
	
	
	/**
	 * 修改 系统用户行为
	 * @param id
	 * @return updated count 
	 */
	public int updateSystemaction(Systemaction systemaction);

		
	/**
	 * 修改 系统用户行为但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSystemactionIgnoreNull(Systemaction systemaction);
		
	
	/**
	 * 查找 系统用户行为
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemaction(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 系统用户行为
	 * @param id
	 * @return
	 */
	public Systemaction findSystemaction(long id);
	
	
	/** 
	 * 查找 系统用户行为
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSystemactionForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找系统用户行为
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemactionBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 系统用户行为
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSystemactionBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSystemactionBySql(String sql);
	//////////////////////////
	/**
	 * 创建 系统权限
	 * @param id
	 * @return deleted count 
	 */
	public Systemright createSystemright(Systemright systemright) throws SQLException;
	
	/**
	 * 删除 系统权限
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSystemright(long id);
	
	
	/**
	 * 修改 系统权限
	 * @param id
	 * @return updated count 
	 */
	public int updateSystemright(Systemright systemright);

		
	/**
	 * 修改 系统权限但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSystemrightIgnoreNull(Systemright systemright);
		
	
	/**
	 * 查找 系统权限
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemright(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 系统权限
	 * @param id
	 * @return
	 */
	public Systemright findSystemright(long id);
	
	
	/** 
	 * 查找 系统权限
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSystemrightForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找系统权限
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemrightBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 系统权限
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSystemrightBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSystemrightBySql(String sql);
	/////////////////
	/**
	 * 创建 系统角色
	 * @param id
	 * @return deleted count 
	 */
	public Systemrole createSystemrole(Systemrole systemrole) throws SQLException;
	
	/**
	 * 删除 系统角色
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSystemrole(long id);
	
	
	/**
	 * 修改 系统角色
	 * @param id
	 * @return updated count 
	 */
	public int updateSystemrole(Systemrole systemrole);

		
	/**
	 * 修改 系统角色但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSystemroleIgnoreNull(Systemrole systemrole);
		
	
	/**
	 * 查找 系统角色
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemrole(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 系统角色
	 * @param id
	 * @return
	 */
	public Systemrole findSystemrole(long id);
	
	
	/** 
	 * 查找 系统角色
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSystemroleForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找系统角色
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemroleBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 系统角色
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSystemroleBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSystemroleBySql(String sql);
	//////////////////////
	/**
	 * 创建 其他电话
	 * @param id
	 * @return deleted count 
	 */
	public Telephone createTelephone(Telephone telephone) throws SQLException;
	
	/**
	 * 删除 其他电话
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTelephone(long id);
	
	
	/**
	 * 修改 其他电话
	 * @param id
	 * @return updated count 
	 */
	public int updateTelephone(Telephone telephone);

		
	/**
	 * 修改 其他电话但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTelephoneIgnoreNull(Telephone telephone);
		
	
	/**
	 * 查找 其他电话
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTelephone(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 其他电话
	 * @param id
	 * @return
	 */
	public Telephone findTelephone(long id);
	
	
	/** 
	 * 查找 其他电话
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTelephoneForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找其他电话
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTelephoneBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 其他电话
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTelephoneBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTelephoneBySql(String sql);
	////////////////////////////////
	/**
	 * 创建 会员角色关联
	 * @param id
	 * @return deleted count 
	 */
	public Agentroleref createAgentroleref(Agentroleref agentroleref) throws SQLException;
	
	/**
	 * 删除 会员角色关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAgentroleref(long id);
	
	
	/**
	 * 修改 会员角色关联
	 * @param id
	 * @return updated count 
	 */
	public int updateAgentroleref(Agentroleref agentroleref);

		
	/**
	 * 修改 会员角色关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAgentrolerefIgnoreNull(Agentroleref agentroleref);
		
	
	/**
	 * 查找 会员角色关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentroleref(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 会员角色关联
	 * @param id
	 * @return
	 */
	public Agentroleref findAgentroleref(long id);
	
	
	/** 
	 * 查找 会员角色关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAgentrolerefForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找会员角色关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentrolerefBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 会员角色关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAgentrolerefBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAgentrolerefBySql(String sql);
	/**
	 * 创建 系统配置表
	 * @param id
	 * @return deleted count 
	 */
	public Sysconfig createSysconfig(Sysconfig sysconfig) throws SQLException;
	
	/**
	 * 删除 系统配置表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysconfig(long id);
	
	
	/**
	 * 修改 系统配置表
	 * @param id
	 * @return updated count 
	 */
	public int updateSysconfig(Sysconfig sysconfig);

		
	/**
	 * 修改 系统配置表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysconfigIgnoreNull(Sysconfig sysconfig);
		
	
	/**
	 * 查找 系统配置表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysconfig(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 系统配置表
	 * @param id
	 * @return
	 */
	public Sysconfig findSysconfig(long id);
	
	
	/** 
	 * 查找 系统配置表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysconfigForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找系统配置表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysconfigBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 系统配置表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysconfigBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysconfigBySql(String sql);
	/**
	 * 创建 信息
	 * @param id
	 * @return deleted count 
	 */
	public Infocontent createInfocontent(Infocontent infocontent) throws SQLException;
	
	/**
	 * 删除 信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInfocontent(long id);
	
	
	/**
	 * 修改 信息
	 * @param id
	 * @return updated count 
	 */
	public int updateInfocontent(Infocontent infocontent);

		
	/**
	 * 修改 信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInfocontentIgnoreNull(Infocontent infocontent);
		
	
	/**
	 * 查找 信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfocontent(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 信息
	 * @param id
	 * @return
	 */
	public Infocontent findInfocontent(long id);
	
	
	/** 
	 * 查找 信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInfocontentForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfocontentBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInfocontentBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInfocontentBySql(String sql);
	/**
	 * 创建 信息类型
	 * @param id
	 * @return deleted count 
	 */
	public Infotype createInfotype(Infotype infotype) throws SQLException;
	
	/**
	 * 删除 信息类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteInfotype(long id);
	
	
	/**
	 * 修改 信息类型
	 * @param id
	 * @return updated count 
	 */
	public int updateInfotype(Infotype infotype);

		
	/**
	 * 修改 信息类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateInfotypeIgnoreNull(Infotype infotype);
		
	
	/**
	 * 查找 信息类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfotype(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 信息类型
	 * @param id
	 * @return
	 */
	public Infotype findInfotype(long id);
	/**
	 * 查找 信息id
	 */
	public Long findInfoId(String typename);
	
	/** 
	 * 查找 信息类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllInfotypeForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找信息类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllInfotypeBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 信息类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteInfotypeBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countInfotypeBySql(String sql);
	//粘贴到Service接口类
 	/**
	 * 创建 积分兑换纪录
	 * @param id
	 * @return deleted count 
	 */
	public Exchrecord createExchrecord(Exchrecord exchrecord) throws SQLException;
	
	/**
	 * 删除 积分兑换纪录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteExchrecord(long id);
	
	
	/**
	 * 修改 积分兑换纪录
	 * @param id
	 * @return updated count 
	 */
	public int updateExchrecord(Exchrecord exchrecord);

		
	/**
	 * 修改 积分兑换纪录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateExchrecordIgnoreNull(Exchrecord exchrecord);
		
	
	/**
	 * 查找 积分兑换纪录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllExchrecord(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 积分兑换纪录
	 * @param id
	 * @return
	 */
	public Exchrecord findExchrecord(long id);
	
	
	/** 
	 * 查找 积分兑换纪录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllExchrecordForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找积分兑换纪录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllExchrecordBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 积分兑换纪录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteExchrecordBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countExchrecordBySql(String sql);
	//粘贴到Service接口类
 	/**
	 * 创建 积分礼品信息
	 * @param id
	 * @return deleted count 
	 */
	public Prizeinfo createPrizeinfo(Prizeinfo prizeinfo) throws SQLException;
	
	/**
	 * 删除 积分礼品信息
	 * @param id
	 * @return deleted count 
	 */
	public int deletePrizeinfo(long id);
	
	
	/**
	 * 修改 积分礼品信息
	 * @param id
	 * @return updated count 
	 */
	public int updatePrizeinfo(Prizeinfo prizeinfo);

		
	/**
	 * 修改 积分礼品信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePrizeinfoIgnoreNull(Prizeinfo prizeinfo);
		
	
	/**
	 * 查找 积分礼品信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizeinfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 积分礼品信息
	 * @param id
	 * @return
	 */
	public Prizeinfo findPrizeinfo(long id);
	
	
	/** 
	 * 查找 积分礼品信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPrizeinfoForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找积分礼品信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizeinfoBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 积分礼品信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePrizeinfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPrizeinfoBySql(String sql);
	 //粘贴到Service接口类
 	/**
	 * 创建 积分礼品类型
	 * @param id
	 * @return deleted count 
	 */
	public Prizetype createPrizetype(Prizetype prizetype) throws SQLException;
	
	/**
	 * 删除 积分礼品类型
	 * @param id
	 * @return deleted count 
	 */
	public int deletePrizetype(long id);
	
	
	/**
	 * 修改 积分礼品类型
	 * @param id
	 * @return updated count 
	 */
	public int updatePrizetype(Prizetype prizetype);

		
	/**
	 * 修改 积分礼品类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePrizetypeIgnoreNull(Prizetype prizetype);
		
	
	/**
	 * 查找 积分礼品类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizetype(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 积分礼品类型
	 * @param id
	 * @return
	 */
	public Prizetype findPrizetype(long id);
	
	
	/** 
	 * 查找 积分礼品类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPrizetypeForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找积分礼品类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizetypeBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 积分礼品类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePrizetypeBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPrizetypeBySql(String sql);
	  //粘贴到Service接口类
 	/**
	 * 创建 交易记录
	 * @param id
	 * @return deleted count 
	 */
	public Traderecord createTraderecord(Traderecord traderecord) throws SQLException;
	
	/**
	 * 删除 交易记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTraderecord(long id);
	
	
	/**
	 * 修改 交易记录
	 * @param id
	 * @return updated count 
	 */
	public int updateTraderecord(Traderecord traderecord);

		
	/**
	 * 修改 交易记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTraderecordIgnoreNull(Traderecord traderecord);
		
	
	/**
	 * 查找 交易记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraderecord(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 交易记录
	 * @param id
	 * @return
	 */
	public Traderecord findTraderecord(long id);
	
	
	/** 
	 * 查找 交易记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTraderecordForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找交易记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraderecordBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 交易记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTraderecordBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTraderecordBySql(String sql);
	
	/**
	 * 创建 短信发送表
	 * @param id
	 * @return deleted count 
	 */
	public Ymsend createYmsend(Ymsend ymsend) throws SQLException;
	
	/**
	 * 删除 短信发送表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmsend(long id);
	
	
	/**
	 * 修改 短信发送表
	 * @param id
	 * @return updated count 
	 */
	public int updateYmsend(Ymsend ymsend);

		
	/**
	 * 修改 短信发送表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmsendIgnoreNull(Ymsend ymsend);
		
	
	/**
	 * 查找 短信发送表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmsend(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 短信发送表
	 * @param id
	 * @return
	 */
	public Ymsend findYmsend(long id);
	
	
	/** 
	 * 查找 短信发送表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmsendForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找短信发送表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmsendBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 短信发送表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmsendBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmsendBySql(String sql);
	
	/**
	 * 创建 短信接收表
	 * @param id
	 * @return deleted count 
	 */
	public Ymreceive createYmreceive(Ymreceive ymreceive) throws SQLException;
	
	/**
	 * 删除 短信接收表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteYmreceive(long id);
	
	
	/**
	 * 修改 短信接收表
	 * @param id
	 * @return updated count 
	 */
	public int updateYmreceive(Ymreceive ymreceive);

		
	/**
	 * 修改 短信接收表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateYmreceiveIgnoreNull(Ymreceive ymreceive);
		
	
	/**
	 * 查找 短信接收表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmreceive(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 短信接收表
	 * @param id
	 * @return
	 */
	public Ymreceive findYmreceive(long id);
	
	
	/** 
	 * 查找 短信接收表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllYmreceiveForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找短信接收表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllYmreceiveBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 短信接收表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteYmreceiveBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countYmreceiveBySql(String sql);
	/**
	 * 创建 部门
	 * @param id
	 * @return deleted count 
	 */
	public Department createDepartment(Department department) throws SQLException;
	
	/**
	 * 删除 部门
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDepartment(long id);
	
	
	/**
	 * 修改 部门
	 * @param id
	 * @return updated count 
	 */
	public int updateDepartment(Department department);

		
	/**
	 * 修改 部门但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDepartmentIgnoreNull(Department department);
		
	
	/**
	 * 查找 部门
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDepartment(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 部门
	 * @param id
	 * @return
	 */
	public Department findDepartment(long id);
	
	
	/** 
	 * 查找 部门
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDepartmentForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找部门
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDepartmentBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 部门
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDepartmentBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDepartmentBySql(String sql);
	//
	 //粘贴到Service接口类
 	/**
	 * 创建 大客户关联金额表
	 * @param id
	 * @return deleted count 
	 */
	public Biguser createBiguser(Biguser biguser) throws SQLException;
	
	/**
	 * 删除 大客户关联金额表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBiguser(long id);
	
	
	/**
	 * 修改 大客户关联金额表
	 * @param id
	 * @return updated count 
	 */
	public int updateBiguser(Biguser biguser);

		
	/**
	 * 修改 大客户关联金额表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBiguserIgnoreNull(Biguser biguser);
		
	
	/**
	 * 查找 大客户关联金额表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguser(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 大客户关联金额表
	 * @param id
	 * @return
	 */
	public Biguser findBiguser(long id);
	
	
	/** 
	 * 查找 大客户关联金额表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBiguserForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找大客户关联金额表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguserBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 大客户关联金额表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBiguserBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBiguserBySql(String sql);
	//
	/**
	 * 创建 大客户还款金额记录表
	 * @param id
	 * @return deleted count 
	 */
	public Biguserprice createBiguserprice(Biguserprice biguserprice) throws SQLException;
	
	/**
	 * 删除 大客户还款金额记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBiguserprice(long id);
	
	
	/**
	 * 修改 大客户还款金额记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateBiguserprice(Biguserprice biguserprice);

		
	/**
	 * 修改 大客户还款金额记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBiguserpriceIgnoreNull(Biguserprice biguserprice);
		
	
	/**
	 * 查找 大客户还款金额记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguserprice(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 大客户还款金额记录表
	 * @param id
	 * @return
	 */
	public Biguserprice findBiguserprice(long id);
	
	
	/** 
	 * 查找 大客户还款金额记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBiguserpriceForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找大客户还款金额记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBiguserpriceBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 大客户还款金额记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBiguserpriceBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBiguserpriceBySql(String sql);
	//
	/**
	 * 创建 大客户还款记录表
	 * @param id
	 * @return deleted count 
	 */
	public Repay createRepay(Repay repay) throws SQLException;
	
	/**
	 * 删除 大客户还款记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRepay(long id);
	
	
	/**
	 * 修改 大客户还款记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateRepay(Repay repay);

		
	/**
	 * 修改 大客户还款记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRepayIgnoreNull(Repay repay);
		
	
	/**
	 * 查找 大客户还款记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRepay(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 大客户还款记录表
	 * @param id
	 * @return
	 */
	public Repay findRepay(long id);
	
	
	/** 
	 * 查找 大客户还款记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRepayForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找大客户还款记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRepayBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 大客户还款记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRepayBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRepayBySql(String sql);
	//

	   //粘贴到Service接口类
	 	/**
		 * 创建 广告合作表
		 * @param id
		 * @return deleted count 
		 */
		public Adcooperate createAdcooperate(Adcooperate adcooperate) throws SQLException;
		
		/**
		 * 删除 广告合作表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteAdcooperate(long id);
		
		
		/**
		 * 修改 广告合作表
		 * @param id
		 * @return updated count 
		 */
		public int updateAdcooperate(Adcooperate adcooperate);

			
		/**
		 * 修改 广告合作表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateAdcooperateIgnoreNull(Adcooperate adcooperate);
			
		
		/**
		 * 查找 广告合作表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllAdcooperate(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 广告合作表
		 * @param id
		 * @return
		 */
		public Adcooperate findAdcooperate(long id);
		
		
		/** 
		 * 查找 广告合作表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllAdcooperateForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找广告合作表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllAdcooperateBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 广告合作表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteAdcooperateBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countAdcooperateBySql(String sql);
		
	//
		/**
		 * 创建 投诉建议表
		 * @param id
		 * @return deleted count 
		 */
		public Tousu createTousu(Tousu tousu) throws SQLException;
		
		/**
		 * 删除 投诉建议表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteTousu(long id);
		
		
		/**
		 * 修改 投诉建议表
		 * @param id
		 * @return updated count 
		 */
		public int updateTousu(Tousu tousu);

			
		/**
		 * 修改 投诉建议表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateTousuIgnoreNull(Tousu tousu);
			
		
		/**
		 * 查找 投诉建议表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTousu(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 投诉建议表
		 * @param id
		 * @return
		 */
		public Tousu findTousu(long id);
		
		
		/** 
		 * 查找 投诉建议表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllTousuForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找投诉建议表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTousuBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 投诉建议表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteTousuBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countTousuBySql(String sql);
		//
		 //粘贴到Service接口类
	 	/**
		 * 创建 万里行申请表
		 * @param id
		 * @return deleted count 
		 */
		public Wanlixing createWanlixing(Wanlixing wanlixing) throws SQLException;
		
		/**
		 * 删除 万里行申请表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteWanlixing(long id);
		
		
		/**
		 * 修改 万里行申请表
		 * @param id
		 * @return updated count 
		 */
		public int updateWanlixing(Wanlixing wanlixing);

			
		/**
		 * 修改 万里行申请表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateWanlixingIgnoreNull(Wanlixing wanlixing);
			
		
		/**
		 * 查找 万里行申请表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllWanlixing(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 万里行申请表
		 * @param id
		 * @return
		 */
		public Wanlixing findWanlixing(long id);
		
		
		/** 
		 * 查找 万里行申请表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllWanlixingForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找万里行申请表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllWanlixingBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 万里行申请表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteWanlixingBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countWanlixingBySql(String sql);
		//粘贴到Service接口类
	 	/**
		 * 创建 东航销售明细导入
		 * @param id
		 * @return deleted count 
		 */
		public Importmureport createImportmureport(Importmureport importmureport) throws SQLException;
		
		/**
		 * 删除 东航销售明细导入
		 * @param id
		 * @return deleted count 
		 */
		public int deleteImportmureport(long id);
		
		
		/**
		 * 修改 东航销售明细导入
		 * @param id
		 * @return updated count 
		 */
		public int updateImportmureport(Importmureport importmureport);

			
		/**
		 * 修改 东航销售明细导入但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateImportmureportIgnoreNull(Importmureport importmureport);
			
		
		/**
		 * 查找 东航销售明细导入
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllImportmureport(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 东航销售明细导入
		 * @param id
		 * @return
		 */
		public Importmureport findImportmureport(long id);
		
		
		/** 
		 * 查找 东航销售明细导入
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllImportmureportForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找东航销售明细导入
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllImportmureportBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 东航销售明细导入
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteImportmureportBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countImportmureportBySql(String sql);
		public Miscellaneous createMiscellaneous(Miscellaneous miscellaneous) throws SQLException;
		
		/**
		 * 删除 客户经理杂项列表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteMiscellaneous(long id);
		
		
		/**
		 * 修改 客户经理杂项列表
		 * @param id
		 * @return updated count 
		 */
		public int updateMiscellaneous(Miscellaneous miscellaneous);

			
		/**
		 * 修改 客户经理杂项列表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateMiscellaneousIgnoreNull(Miscellaneous miscellaneous);
			
		
		/**
		 * 查找 客户经理杂项列表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllMiscellaneous(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 客户经理杂项列表
		 * @param id
		 * @return
		 */
		public Miscellaneous findMiscellaneous(long id);
		
		
		/** 
		 * 查找 客户经理杂项列表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllMiscellaneousForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找客户经理杂项列表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllMiscellaneousBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 客户经理杂项列表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteMiscellaneousBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countMiscellaneousBySql(String sql);
		/**
		 * 创建 QQ信息表
		 * @param id
		 * @return deleted count 
		 */
		public Qqinfo createQqinfo(Qqinfo qqinfo) throws SQLException;
		
		/**
		 * 删除 QQ信息表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteQqinfo(long id);
		
		
		/**
		 * 修改 QQ信息表
		 * @param id
		 * @return updated count 
		 */
		public int updateQqinfo(Qqinfo qqinfo);

			
		/**
		 * 修改 QQ信息表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateQqinfoIgnoreNull(Qqinfo qqinfo);
			
		
		/**
		 * 查找 QQ信息表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllQqinfo(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 QQ信息表
		 * @param id
		 * @return
		 */
		public Qqinfo findQqinfo(long id);
		
		
		/** 
		 * 查找 QQ信息表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllQqinfoForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找QQ信息表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllQqinfoBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql QQ信息表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteQqinfoBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countQqinfoBySql(String sql);
		/**
		 * 创建 QQ类型
		 * @param id
		 * @return deleted count 
		 */
		public Qqtype createQqtype(Qqtype qqtype) throws SQLException;
		
		/**
		 * 删除 QQ类型
		 * @param id
		 * @return deleted count 
		 */
		public int deleteQqtype(long id);
		
		
		/**
		 * 修改 QQ类型
		 * @param id
		 * @return updated count 
		 */
		public int updateQqtype(Qqtype qqtype);

			
		/**
		 * 修改 QQ类型但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateQqtypeIgnoreNull(Qqtype qqtype);
			
		
		/**
		 * 查找 QQ类型
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllQqtype(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 QQ类型
		 * @param id
		 * @return
		 */
		public Qqtype findQqtype(long id);
		
		
		/** 
		 * 查找 QQ类型
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllQqtypeForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找QQ类型
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllQqtypeBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql QQ类型
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteQqtypeBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countQqtypeBySql(String sql);
		/**
		 * 创建 机票票号
		 * @param id
		 * @return deleted count 
		 */
		public Ticketnumber createTicketnumber(Ticketnumber ticketnumber) throws SQLException;
		
		/**
		 * 删除 机票票号
		 * @param id
		 * @return deleted count 
		 */
		public int deleteTicketnumber(long id);
		
		
		/**
		 * 修改 机票票号
		 * @param id
		 * @return updated count 
		 */
		public int updateTicketnumber(Ticketnumber ticketnumber);

			
		/**
		 * 修改 机票票号但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateTicketnumberIgnoreNull(Ticketnumber ticketnumber);
			
		
		/**
		 * 查找 机票票号
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTicketnumber(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 机票票号
		 * @param id
		 * @return
		 */
		public Ticketnumber findTicketnumber(long id);
		
		
		/** 
		 * 查找 机票票号
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllTicketnumberForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找机票票号
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTicketnumberBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 机票票号
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteTicketnumberBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countTicketnumberBySql(String sql);
		/**
		 * 创建 机票类型
		 * @param id
		 * @return deleted count 
		 */
		public Tickettype createTickettype(Tickettype tickettype) throws SQLException;
		
		/**
		 * 删除 机票类型
		 * @param id
		 * @return deleted count 
		 */
		public int deleteTickettype(long id);
		
		
		/**
		 * 修改 机票类型
		 * @param id
		 * @return updated count 
		 */
		public int updateTickettype(Tickettype tickettype);

			
		/**
		 * 修改 机票类型但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateTickettypeIgnoreNull(Tickettype tickettype);
			
		
		/**
		 * 查找 机票类型
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTickettype(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 机票类型
		 * @param id
		 * @return
		 */
		public Tickettype findTickettype(long id);
		
		
		/** 
		 * 查找 机票类型
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllTickettypeForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找机票类型
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTickettypeBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 机票类型
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteTickettypeBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countTickettypeBySql(String sql);
		/**
		 * 创建 航空公司报表导入
		 * @param id
		 * @return deleted count 
		 */
		public Travelskyreport createTravelskyreport(Travelskyreport travelskyreport) throws SQLException;
		
		/**
		 * 删除 航空公司报表导入
		 * @param id
		 * @return deleted count 
		 */
		public int deleteTravelskyreport(long id);
		
		
		/**
		 * 修改 航空公司报表导入
		 * @param id
		 * @return updated count 
		 */
		public int updateTravelskyreport(Travelskyreport travelskyreport);

			
		/**
		 * 修改 航空公司报表导入但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateTravelskyreportIgnoreNull(Travelskyreport travelskyreport);
			
		
		/**
		 * 查找 航空公司报表导入
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTravelskyreport(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 航空公司报表导入
		 * @param id
		 * @return
		 */
		public Travelskyreport findTravelskyreport(long id);
		
		
		/** 
		 * 查找 航空公司报表导入
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllTravelskyreportForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找航空公司报表导入
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTravelskyreportBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 航空公司报表导入
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteTravelskyreportBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countTravelskyreportBySql(String sql);
		
		
		/**
		 * 创建 个人挂账记录表
		 * @param id
		 * @return deleted count 
		 */
		public Gerenguazhanfrec createGerenguazhanfrec(Gerenguazhanfrec gerenguazhanfrec) throws SQLException;
		
		/**
		 * 删除 个人挂账记录表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteGerenguazhanfrec(long id);
		
		
		/**
		 * 修改 个人挂账记录表
		 * @param id
		 * @return updated count 
		 */
		public int updateGerenguazhanfrec(Gerenguazhanfrec gerenguazhanfrec);

			
		/**
		 * 修改 个人挂账记录表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateGerenguazhanfrecIgnoreNull(Gerenguazhanfrec gerenguazhanfrec);
			
		
		/**
		 * 查找 个人挂账记录表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllGerenguazhanfrec(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 个人挂账记录表
		 * @param id
		 * @return
		 */
		public Gerenguazhanfrec findGerenguazhanfrec(long id);
		
		
		/** 
		 * 查找 个人挂账记录表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllGerenguazhanfrecForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找个人挂账记录表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllGerenguazhanfrecBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 个人挂账记录表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteGerenguazhanfrecBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countGerenguazhanfrecBySql(String sql);
		
		/**
		 * 创建 保险
		 * @param id
		 * @return deleted count 
		 */
		public Insuranceinfo createInsuranceinfo(Insuranceinfo insuranceinfo) throws SQLException;
		
		/**
		 * 删除 保险
		 * @param id
		 * @return deleted count 
		 */
		public int deleteInsuranceinfo(long id);
		
		
		/**
		 * 修改 保险
		 * @param id
		 * @return updated count 
		 */
		public int updateInsuranceinfo(Insuranceinfo insuranceinfo);

			
		/**
		 * 修改 保险但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateInsuranceinfoIgnoreNull(Insuranceinfo insuranceinfo);
			
		
		/**
		 * 查找 保险
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllInsuranceinfo(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 保险
		 * @param id
		 * @return
		 */
		public Insuranceinfo findInsuranceinfo(long id);
		
		
		/** 
		 * 查找 保险
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllInsuranceinfoForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找保险
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllInsuranceinfoBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 保险
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteInsuranceinfoBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countInsuranceinfoBySql(String sql);
		
		/**
		 * 创建 Q信箱
		 * @param id
		 * @return deleted count 
		 */
		public Qmessage createQmessage(Qmessage qmessage) throws SQLException;
		
		/**
		 * 删除 Q信箱
		 * @param id
		 * @return deleted count 
		 */
		public int deleteQmessage(long id);
		
		
		/**
		 * 修改 Q信箱
		 * @param id
		 * @return updated count 
		 */
		public int updateQmessage(Qmessage qmessage);

			
		/**
		 * 修改 Q信箱但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateQmessageIgnoreNull(Qmessage qmessage);
			
		
		/**
		 * 查找 Q信箱
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllQmessage(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 Q信箱
		 * @param id
		 * @return
		 */
		public Qmessage findQmessage(long id);
		
		
		/** 
		 * 查找 Q信箱
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllQmessageForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找Q信箱
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllQmessageBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql Q信箱
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteQmessageBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countQmessageBySql(String sql);
		
		/**
		 * 创建 信用卡记录表
		 * @param id
		 * @return deleted count 
		 */
		public Creditcard createCreditcard(Creditcard creditcard) throws SQLException;
		
		/**
		 * 删除 信用卡记录表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteCreditcard(long id);
		
		
		/**
		 * 修改 信用卡记录表
		 * @param id
		 * @return updated count 
		 */
		public int updateCreditcard(Creditcard creditcard);

			
		/**
		 * 修改 信用卡记录表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateCreditcardIgnoreNull(Creditcard creditcard);
			
		
		/**
		 * 查找 信用卡记录表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllCreditcard(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 信用卡记录表
		 * @param id
		 * @return
		 */
		public Creditcard findCreditcard(long id);
		
		
		/** 
		 * 查找 信用卡记录表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllCreditcardForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找信用卡记录表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllCreditcardBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 信用卡记录表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteCreditcardBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countCreditcardBySql(String sql);
		
		
		 //粘贴到Service接口类
	 	/**
		 * 创建 留点记录表
		 * @param id
		 * @return deleted count 
		 */
		public Liudianrecord createLiudianrecord(Liudianrecord liudianrecord) throws SQLException;
		
		/**
		 * 删除 留点记录表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteLiudianrecord(long id);
		
		
		/**
		 * 修改 留点记录表
		 * @param id
		 * @return updated count 
		 */
		public int updateLiudianrecord(Liudianrecord liudianrecord);

			
		/**
		 * 修改 留点记录表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateLiudianrecordIgnoreNull(Liudianrecord liudianrecord);
			
		
		/**
		 * 查找 留点记录表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllLiudianrecord(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 留点记录表
		 * @param id
		 * @return
		 */
		public Liudianrecord findLiudianrecord(long id);
		
		/**
		 * 查找 留点记录表 by language
		 * @param id
		 * @return
		 */
		public Liudianrecord findLiudianrecordbylanguage(long id ,Integer language);
		
		/** 
		 * 查找 留点记录表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllLiudianrecordForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找留点记录表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllLiudianrecordBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 留点记录表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteLiudianrecordBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countLiudianrecordBySql(String sql);
		
		/**
		 * 创建 留点设置关联表
		 * @param id
		 * @return deleted count 
		 */
		public Liudianrefinfo createLiudianrefinfo(Liudianrefinfo liudianrefinfo) throws SQLException;
		
		/**
		 * 删除 留点设置关联表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteLiudianrefinfo(long id);
		
		
		/**
		 * 修改 留点设置关联表
		 * @param id
		 * @return updated count 
		 */
		public int updateLiudianrefinfo(Liudianrefinfo liudianrefinfo);

			
		/**
		 * 修改 留点设置关联表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateLiudianrefinfoIgnoreNull(Liudianrefinfo liudianrefinfo);
			
		
		/**
		 * 查找 留点设置关联表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllLiudianrefinfo(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 留点设置关联表
		 * @param id
		 * @return
		 */
		public Liudianrefinfo findLiudianrefinfo(long id);
		
		/**
		 * 查找 留点设置关联表 by language
		 * @param id
		 * @return
		 */
		public Liudianrefinfo findLiudianrefinfobylanguage(long id ,Integer language);
		
		/** 
		 * 查找 留点设置关联表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllLiudianrefinfoForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找留点设置关联表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllLiudianrefinfoBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 留点设置关联表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteLiudianrefinfoBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countLiudianrefinfoBySql(String sql);
		
		/**
		 * 创建 结算分类表
		 * @param id
		 * @return deleted count 
		 */
		public Settlementtype createSettlementtype(Settlementtype settlementtype) throws SQLException;
		
		/**
		 * 删除 结算分类表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteSettlementtype(long id);
		
		
		/**
		 * 修改 结算分类表
		 * @param id
		 * @return updated count 
		 */
		public int updateSettlementtype(Settlementtype settlementtype);

			
		/**
		 * 修改 结算分类表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateSettlementtypeIgnoreNull(Settlementtype settlementtype);
			
		
		/**
		 * 查找 结算分类表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllSettlementtype(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 结算分类表
		 * @param id
		 * @return
		 */
		public Settlementtype findSettlementtype(long id);
		
		/**
		 * 查找 结算分类表 by language
		 * @param id
		 * @return
		 */
		public Settlementtype findSettlementtypebylanguage(long id ,Integer language);
		
		/** 
		 * 查找 结算分类表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllSettlementtypeForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找结算分类表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllSettlementtypeBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 结算分类表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteSettlementtypeBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countSettlementtypeBySql(String sql);
		
		/**
		 * 创建 返佣规则
		 * @param id
		 * @return deleted count 
		 */
		public Rebaterule createRebaterule(Rebaterule rebaterule) throws SQLException;
		
		/**
		 * 删除 返佣规则
		 * @param id
		 * @return deleted count 
		 */
		public int deleteRebaterule(long id);
		
		
		/**
		 * 修改 返佣规则
		 * @param id
		 * @return updated count 
		 */
		public int updateRebaterule(Rebaterule rebaterule);

			
		/**
		 * 修改 返佣规则但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateRebateruleIgnoreNull(Rebaterule rebaterule);
			
		
		/**
		 * 查找 返佣规则
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllRebaterule(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 返佣规则
		 * @param id
		 * @return
		 */
		public Rebaterule findRebaterule(long id);
		
		
		/** 
		 * 查找 返佣规则
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllRebateruleForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找返佣规则
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllRebateruleBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 返佣规则
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteRebateruleBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countRebateruleBySql(String sql);
		
		
		/**
		 * 创建 虚拟账户充值记录
		 * @param id
		 * @return deleted count 
		 */
		public Vmoneyrecord createVmoneyrecord(Vmoneyrecord vmoneyrecord) throws SQLException;
		
		/**
		 * 删除 虚拟账户充值记录
		 * @param id
		 * @return deleted count 
		 */
		public int deleteVmoneyrecord(long id);
		
		
		/**
		 * 修改 虚拟账户充值记录
		 * @param id
		 * @return updated count 
		 */
		public int updateVmoneyrecord(Vmoneyrecord vmoneyrecord);

			
		/**
		 * 修改 虚拟账户充值记录但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateVmoneyrecordIgnoreNull(Vmoneyrecord vmoneyrecord);
			
		
		/**
		 * 查找 虚拟账户充值记录
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllVmoneyrecord(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 虚拟账户充值记录
		 * @param id
		 * @return
		 */
		public Vmoneyrecord findVmoneyrecord(long id);
		
		
		/** 
		 * 查找 虚拟账户充值记录
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllVmoneyrecordForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找虚拟账户充值记录
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllVmoneyrecordBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 虚拟账户充值记录
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteVmoneyrecordBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countVmoneyrecordBySql(String sql);
		
		
		
		/**
		 * 创建 会员积分记录
		 * @param id
		 * @return deleted count 
		 */
		public Customerintegralrecord createCustomerintegralrecord(Customerintegralrecord customerintegralrecord) throws SQLException;
		
		/**
		 * 删除 会员积分记录
		 * @param id
		 * @return deleted count 
		 */
		public int deleteCustomerintegralrecord(long id);
		
		
		/**
		 * 修改 会员积分记录
		 * @param id
		 * @return updated count 
		 */
		public int updateCustomerintegralrecord(Customerintegralrecord customerintegralrecord);

			
		/**
		 * 修改 会员积分记录但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateCustomerintegralrecordIgnoreNull(Customerintegralrecord customerintegralrecord);
			
		
		/**
		 * 查找 会员积分记录
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllCustomerintegralrecord(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 会员积分记录
		 * @param id
		 * @return
		 */
		public Customerintegralrecord findCustomerintegralrecord(long id);
		
		
		/** 
		 * 查找 会员积分记录
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllCustomerintegralrecordForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找会员积分记录
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllCustomerintegralrecordBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 会员积分记录
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteCustomerintegralrecordBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countCustomerintegralrecordBySql(String sql);
		
		
		
		/**
		 * 创建 积分管理
		 * @param id
		 * @return deleted count 
		 */
		public Integral createIntegral(Integral integral) throws SQLException;
		
		/**
		 * 删除 积分管理
		 * @param id
		 * @return deleted count 
		 */
		public int deleteIntegral(long id);
		
		
		/**
		 * 修改 积分管理
		 * @param id
		 * @return updated count 
		 */
		public int updateIntegral(Integral integral);

			
		/**
		 * 修改 积分管理但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateIntegralIgnoreNull(Integral integral);
			
		
		/**
		 * 查找 积分管理
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllIntegral(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 积分管理
		 * @param id
		 * @return
		 */
		public Integral findIntegral(long id);
		
		
		/** 
		 * 查找 积分管理
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllIntegralForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找积分管理
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllIntegralBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 积分管理
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteIntegralBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countIntegralBySql(String sql);
		
		
		 
		   //粘贴到Service接口类
		 	/**
			 * 创建 会员积分记录表
			 * @param id
			 * @return deleted count 
			 */
			public Userintegral createUserintegral(Userintegral userintegral) throws SQLException;
			
			/**
			 * 删除 会员积分记录表
			 * @param id
			 * @return deleted count 
			 */
			public int deleteUserintegral(long id);
			
			
			/**
			 * 修改 会员积分记录表
			 * @param id
			 * @return updated count 
			 */
			public int updateUserintegral(Userintegral userintegral);

				
			/**
			 * 修改 会员积分记录表但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateUserintegralIgnoreNull(Userintegral userintegral);
				
			
			/**
			 * 查找 会员积分记录表
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllUserintegral(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 会员积分记录表
			 * @param id
			 * @return
			 */
			public Userintegral findUserintegral(long id);
			
			
			/** 
			 * 查找 会员积分记录表
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllUserintegralForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找会员积分记录表
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllUserintegralBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 会员积分记录表
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteUserintegralBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countUserintegralBySql(String sql);
			
			
			/**
			 * 创建 返佣记录表
			 * @param id
			 * @return deleted count 
			 */
			public Rebaterecord createRebaterecord(Rebaterecord rebaterecord) throws SQLException;
			
			/**
			 * 删除 返佣记录表
			 * @param id
			 * @return deleted count 
			 */
			public int deleteRebaterecord(long id);
			
			
			/**
			 * 修改 返佣记录表
			 * @param id
			 * @return updated count 
			 */
			public int updateRebaterecord(Rebaterecord rebaterecord);

				
			/**
			 * 修改 返佣记录表但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateRebaterecordIgnoreNull(Rebaterecord rebaterecord);
				
			
			/**
			 * 查找 返佣记录表
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllRebaterecord(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 返佣记录表
			 * @param id
			 * @return
			 */
			public Rebaterecord findRebaterecord(long id);
			
			
			/** 
			 * 查找 返佣记录表
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllRebaterecordForPageinfo(String where, String orderby,PageInfo pageinfo,String ...sql);
				
			/** 
			 * 根据Sql查找返佣记录表
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllRebaterecordBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 返佣记录表
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteRebaterecordBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countRebaterecordBySql(String sql);
			
			
			
					
		
			/**
			 * 创建 手机充值
			 * @param id
			 * @return deleted count 
			 */
			public Recharge createRecharge(Recharge recharge) throws SQLException;
			
			/**
			 * 删除 手机充值
			 * @param id
			 * @return deleted count 
			 */
			public int deleteRecharge(long id);
			
			
			/**
			 * 修改 手机充值
			 * @param id
			 * @return updated count 
			 */
			public int updateRecharge(Recharge recharge);

				
			/**
			 * 修改 手机充值但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateRechargeIgnoreNull(Recharge recharge);
				
			
			/**
			 * 查找 手机充值
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllRecharge(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 手机充值
			 * @param id
			 * @return
			 */
			public Recharge findRecharge(long id);
			
			
			/** 
			 * 查找 手机充值
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllRechargeForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找手机充值
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllRechargeBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 手机充值
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteRechargeBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countRechargeBySql(String sql);
			
			
			/**
			 * 创建 Q币充值表
			 * @param id
			 * @return deleted count 
			 */
			public Qmoneyrecharge createQmoneyrecharge(Qmoneyrecharge qmoneyrecharge) throws SQLException;
			
			/**
			 * 删除 Q币充值表
			 * @param id
			 * @return deleted count 
			 */
			public int deleteQmoneyrecharge(long id);
			
			
			/**
			 * 修改 Q币充值表
			 * @param id
			 * @return updated count 
			 */
			public int updateQmoneyrecharge(Qmoneyrecharge qmoneyrecharge);

				
			/**
			 * 修改 Q币充值表但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateQmoneyrechargeIgnoreNull(Qmoneyrecharge qmoneyrecharge);
				
			
			/**
			 * 查找 Q币充值表
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllQmoneyrecharge(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 Q币充值表
			 * @param id
			 * @return
			 */
			public Qmoneyrecharge findQmoneyrecharge(long id);
			
			
			/** 
			 * 查找 Q币充值表
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllQmoneyrechargeForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找Q币充值表
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllQmoneyrechargeBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql Q币充值表
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteQmoneyrechargeBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countQmoneyrechargeBySql(String sql);
		

			   //粘贴到Service接口类
			 	/**
				 * 创建 帮助中心
				 * @param id
				 * @return deleted count 
				 */
				public Helpcenter createHelpcenter(Helpcenter helpcenter) throws SQLException;
				
				/**
				 * 删除 帮助中心
				 * @param id
				 * @return deleted count 
				 */
				public int deleteHelpcenter(long id);
				
				
				/**
				 * 修改 帮助中心
				 * @param id
				 * @return updated count 
				 */
				public int updateHelpcenter(Helpcenter helpcenter);

					
				/**
				 * 修改 帮助中心但忽略空值 
				 * @param id
				 * @return 
				 */
				public int updateHelpcenterIgnoreNull(Helpcenter helpcenter);
					
				
				/**
				 * 查找 帮助中心
				 * @param where
				 * @param orderby
				 * @param limit
				 * @param offset
				 * @return
				 */
				public List findAllHelpcenter(String where, String orderby,int limit,int offset);
					
				
				/**
				 * 查找 帮助中心
				 * @param id
				 * @return
				 */
				public Helpcenter findHelpcenter(long id);
				
				
				/** 
				 * 查找 帮助中心
				 * @param where
				 * @param orderby
				 * @param pageinfo
				 * @return
				 */
				public List findAllHelpcenterForPageinfo(String where, String orderby,PageInfo pageinfo);
					
				/** 
				 * 根据Sql查找帮助中心
				 * @param sql
				 * @param limit
				 * @param offset
				 * @return
				 */
				public List findAllHelpcenterBySql(String sql,int limit,int offset);
				
				
				/**
				 * 执行Sql 帮助中心
				 * @param sql 
				 * @return updated count 
				 */
				public int excuteHelpcenterBySql(String sql);
				
				/**
				 * 执行Sql 
				 * @param sql 
				 * @return  count 
				 */
				public int countHelpcenterBySql(String sql);
				
				 //粘贴到Service接口类
			 	/**
				 * 创建 帮助中心信息
				 * @param id
				 * @return deleted count 
				 */
				public Helpcenterinfo createHelpcenterinfo(Helpcenterinfo helpcenterinfo) throws SQLException;
				
				/**
				 * 删除 帮助中心信息
				 * @param id
				 * @return deleted count 
				 */
				public int deleteHelpcenterinfo(long id);
				
				
				/**
				 * 修改 帮助中心信息
				 * @param id
				 * @return updated count 
				 */
				public int updateHelpcenterinfo(Helpcenterinfo helpcenterinfo);

					
				/**
				 * 修改 帮助中心信息但忽略空值 
				 * @param id
				 * @return 
				 */
				public int updateHelpcenterinfoIgnoreNull(Helpcenterinfo helpcenterinfo);
					
				
				/**
				 * 查找 帮助中心信息
				 * @param where
				 * @param orderby
				 * @param limit
				 * @param offset
				 * @return
				 */
				public List findAllHelpcenterinfo(String where, String orderby,int limit,int offset);
					
				
				/**
				 * 查找 帮助中心信息
				 * @param id
				 * @return
				 */
				public Helpcenterinfo findHelpcenterinfo(long id);
				
				
				/** 
				 * 查找 帮助中心信息
				 * @param where
				 * @param orderby
				 * @param pageinfo
				 * @return
				 */
				public List findAllHelpcenterinfoForPageinfo(String where, String orderby,PageInfo pageinfo);
					
				/** 
				 * 根据Sql查找帮助中心信息
				 * @param sql
				 * @param limit
				 * @param offset
				 * @return
				 */
				public List findAllHelpcenterinfoBySql(String sql,int limit,int offset);
				
				
				/**
				 * 执行Sql 帮助中心信息
				 * @param sql 
				 * @return updated count 
				 */
				public int excuteHelpcenterinfoBySql(String sql);
				
				/**
				 * 执行Sql 
				 * @param sql 
				 * @return  count 
				 */
				public int countHelpcenterinfoBySql(String sql);
				

				   //粘贴到Service接口类
				 	/**
					 * 创建 资讯中心
					 * @param id
					 * @return deleted count 
					 */
					public Information createInformation(Information information) throws SQLException;
					
					/**
					 * 删除 资讯中心
					 * @param id
					 * @return deleted count 
					 */
					public int deleteInformation(long id);
					
					
					/**
					 * 修改 资讯中心
					 * @param id
					 * @return updated count 
					 */
					public int updateInformation(Information information);

						
					/**
					 * 修改 资讯中心但忽略空值 
					 * @param id
					 * @return 
					 */
					public int updateInformationIgnoreNull(Information information);
						
					
					/**
					 * 查找 资讯中心
					 * @param where
					 * @param orderby
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllInformation(String where, String orderby,int limit,int offset);
						
					
					/**
					 * 查找 资讯中心
					 * @param id
					 * @return
					 */
					public Information findInformation(long id);
					
					
					/** 
					 * 查找 资讯中心
					 * @param where
					 * @param orderby
					 * @param pageinfo
					 * @return
					 */
					public List findAllInformationForPageinfo(String where, String orderby,PageInfo pageinfo);
						
					/** 
					 * 根据Sql查找资讯中心
					 * @param sql
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllInformationBySql(String sql,int limit,int offset);
					
					
					/**
					 * 执行Sql 资讯中心
					 * @param sql 
					 * @return updated count 
					 */
					public int excuteInformationBySql(String sql);
					
					/**
					 * 执行Sql 
					 * @param sql 
					 * @return  count 
					 */
					public int countInformationBySql(String sql);
					
					 //粘贴到Service接口类
				 	/**
					 * 创建 资讯中心详细信息
					 * @param id
					 * @return deleted count 
					 */
					public Informationinfo createInformationinfo(Informationinfo informationinfo) throws SQLException;
					
					/**
					 * 删除 资讯中心详细信息
					 * @param id
					 * @return deleted count 
					 */
					public int deleteInformationinfo(long id);
					
					
					/**
					 * 修改 资讯中心详细信息
					 * @param id
					 * @return updated count 
					 */
					public int updateInformationinfo(Informationinfo informationinfo);

						
					/**
					 * 修改 资讯中心详细信息但忽略空值 
					 * @param id
					 * @return 
					 */
					public int updateInformationinfoIgnoreNull(Informationinfo informationinfo);
						
					
					/**
					 * 查找 资讯中心详细信息
					 * @param where
					 * @param orderby
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllInformationinfo(String where, String orderby,int limit,int offset);
						
					
					/**
					 * 查找 资讯中心详细信息
					 * @param id
					 * @return
					 */
					public Informationinfo findInformationinfo(long id);
					
					
					/** 
					 * 查找 资讯中心详细信息
					 * @param where
					 * @param orderby
					 * @param pageinfo
					 * @return
					 */
					public List findAllInformationinfoForPageinfo(String where, String orderby,PageInfo pageinfo);
						
					/** 
					 * 根据Sql查找资讯中心详细信息
					 * @param sql
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllInformationinfoBySql(String sql,int limit,int offset);
					
					
					/**
					 * 执行Sql 资讯中心详细信息
					 * @param sql 
					 * @return updated count 
					 */
					public int excuteInformationinfoBySql(String sql);
					
					/**
					 * 执行Sql 
					 * @param sql 
					 * @return  count 
					 */
					public int countInformationinfoBySql(String sql);
					

					   //粘贴到Service接口类
					 	/**
						 * 创建 包机服务
						 * @param id
						 * @return deleted count 
						 */
						public Planeservice createPlaneservice(Planeservice planeservice) throws SQLException;
						
						/**
						 * 删除 包机服务
						 * @param id
						 * @return deleted count 
						 */
						public int deletePlaneservice(long id);
						
						
						/**
						 * 修改 包机服务
						 * @param id
						 * @return updated count 
						 */
						public int updatePlaneservice(Planeservice planeservice);

							
						/**
						 * 修改 包机服务但忽略空值 
						 * @param id
						 * @return 
						 */
						public int updatePlaneserviceIgnoreNull(Planeservice planeservice);
							
						
						/**
						 * 查找 包机服务
						 * @param where
						 * @param orderby
						 * @param limit
						 * @param offset
						 * @return
						 */
						public List findAllPlaneservice(String where, String orderby,int limit,int offset);
							
						
						/**
						 * 查找 包机服务
						 * @param id
						 * @return
						 */
						public Planeservice findPlaneservice(long id);
						
						
						/** 
						 * 查找 包机服务
						 * @param where
						 * @param orderby
						 * @param pageinfo
						 * @return
						 */
						public List findAllPlaneserviceForPageinfo(String where, String orderby,PageInfo pageinfo);
							
						/** 
						 * 根据Sql查找包机服务
						 * @param sql
						 * @param limit
						 * @param offset
						 * @return
						 */
						public List findAllPlaneserviceBySql(String sql,int limit,int offset);
						
						
						/**
						 * 执行Sql 包机服务
						 * @param sql 
						 * @return updated count 
						 */
						public int excutePlaneserviceBySql(String sql);
						
						/**
						 * 执行Sql 
						 * @param sql 
						 * @return  count 
						 */
						public int countPlaneserviceBySql(String sql);
						
						 
						  
						   //粘贴到Service接口类
						 	/**
							 * 创建 会员常用配送地址
							 * @param id
							 * @return deleted count 
							 */
							public Useraddress createUseraddress(Useraddress useraddress) throws SQLException;
							
							/**
							 * 删除 会员常用配送地址
							 * @param id
							 * @return deleted count 
							 */
							public int deleteUseraddress(long id);
							
							
							/**
							 * 修改 会员常用配送地址
							 * @param id
							 * @return updated count 
							 */
							public int updateUseraddress(Useraddress useraddress);

								
							/**
							 * 修改 会员常用配送地址但忽略空值 
							 * @param id
							 * @return 
							 */
							public int updateUseraddressIgnoreNull(Useraddress useraddress);
								
							
							/**
							 * 查找 会员常用配送地址
							 * @param where
							 * @param orderby
							 * @param limit
							 * @param offset
							 * @return
							 */
							public List findAllUseraddress(String where, String orderby,int limit,int offset);
								
							
							/**
							 * 查找 会员常用配送地址
							 * @param id
							 * @return
							 */
							public Useraddress findUseraddress(long id);
							
							
							/** 
							 * 查找 会员常用配送地址
							 * @param where
							 * @param orderby
							 * @param pageinfo
							 * @return
							 */
							public List findAllUseraddressForPageinfo(String where, String orderby,PageInfo pageinfo);
								
							/** 
							 * 根据Sql查找会员常用配送地址
							 * @param sql
							 * @param limit
							 * @param offset
							 * @return
							 */
							public List findAllUseraddressBySql(String sql,int limit,int offset);
							
							
							/**
							 * 执行Sql 会员常用配送地址
							 * @param sql 
							 * @return updated count 
							 */
							public int excuteUseraddressBySql(String sql);
							
							/**
							 * 执行Sql 
							 * @param sql 
							 * @return  count 
							 */
							public int countUseraddressBySql(String sql);
							
							
							//粘贴到Service接口类
						 	/**
							 * 创建 模板
							 * @param id
							 * @return deleted count 
							 */
							public Templet createTemplet(Templet templet) throws SQLException;
							
							/**
							 * 删除 模板
							 * @param id
							 * @return deleted count 
							 */
							public int deleteTemplet(long id);
							
							
							/**
							 * 修改 模板
							 * @param id
							 * @return updated count 
							 */
							public int updateTemplet(Templet templet);

								
							/**
							 * 修改 模板但忽略空值 
							 * @param id
							 * @return 
							 */
							public int updateTempletIgnoreNull(Templet templet);
								
							
							/**
							 * 查找 模板
							 * @param where
							 * @param orderby
							 * @param limit
							 * @param offset
							 * @return
							 */
							public List findAllTemplet(String where, String orderby,int limit,int offset);
								
							
							/**
							 * 查找 模板
							 * @param id
							 * @return
							 */
							public Templet findTemplet(long id);
							
							
							/** 
							 * 查找 模板
							 * @param where
							 * @param orderby
							 * @param pageinfo
							 * @return
							 */
							public List findAllTempletForPageinfo(String where, String orderby,PageInfo pageinfo);
								
							/** 
							 * 根据Sql查找模板
							 * @param sql
							 * @param limit
							 * @param offset
							 * @return
							 */
							public List findAllTempletBySql(String sql,int limit,int offset);
							
							
							/**
							 * 执行Sql 模板
							 * @param sql 
							 * @return updated count 
							 */
							public int excuteTempletBySql(String sql);
							
							/**
							 * 执行Sql 
							 * @param sql 
							 * @return  count 
							 */
							public int countTempletBySql(String sql);
							
							
							
							//粘贴到Service接口类
						 	/**
							 * 创建 短信用户组
							 * @param id
							 * @return deleted count 
							 */
							public Messgroup createMessgroup(Messgroup messgroup) throws SQLException;
							
							/**
							 * 删除 短信用户组
							 * @param id
							 * @return deleted count 
							 */
							public int deleteMessgroup(long id);
							
							
							/**
							 * 修改 短信用户组
							 * @param id
							 * @return updated count 
							 */
							public int updateMessgroup(Messgroup messgroup);

								
							/**
							 * 修改 短信用户组但忽略空值 
							 * @param id
							 * @return 
							 */
							public int updateMessgroupIgnoreNull(Messgroup messgroup);
								
							
							/**
							 * 查找 短信用户组
							 * @param where
							 * @param orderby
							 * @param limit
							 * @param offset
							 * @return
							 */
							public List findAllMessgroup(String where, String orderby,int limit,int offset);
								
							
							/**
							 * 查找 短信用户组
							 * @param id
							 * @return
							 */
							public Messgroup findMessgroup(long id);
							
							
							/** 
							 * 查找 短信用户组
							 * @param where
							 * @param orderby
							 * @param pageinfo
							 * @return
							 */
							public List findAllMessgroupForPageinfo(String where, String orderby,PageInfo pageinfo);
								
							/** 
							 * 根据Sql查找短信用户组
							 * @param sql
							 * @param limit
							 * @param offset
							 * @return
							 */
							public List findAllMessgroupBySql(String sql,int limit,int offset);
							
							
							/**
							 * 执行Sql 短信用户组
							 * @param sql 
							 * @return updated count 
							 */
							public int excuteMessgroupBySql(String sql);
							
							/**
							 * 执行Sql 
							 * @param sql 
							 * @return  count 
							 */
							public int countMessgroupBySql(String sql);
							
							 
							   //粘贴到Service接口类
							 	/**
								 * 创建 加盟商固定返点
								 * @param id
								 * @return deleted count 
								 */
								public Agentvalue createAgentvalue(Agentvalue agentvalue) throws SQLException;
								
								/**
								 * 删除 加盟商固定返点
								 * @param id
								 * @return deleted count 
								 */
								public int deleteAgentvalue(long id);
								
								
								/**
								 * 修改 加盟商固定返点
								 * @param id
								 * @return updated count 
								 */
								public int updateAgentvalue(Agentvalue agentvalue);

									
								/**
								 * 修改 加盟商固定返点但忽略空值 
								 * @param id
								 * @return 
								 */
								public int updateAgentvalueIgnoreNull(Agentvalue agentvalue);
									
								
								/**
								 * 查找 加盟商固定返点
								 * @param where
								 * @param orderby
								 * @param limit
								 * @param offset
								 * @return
								 */
								public List findAllAgentvalue(String where, String orderby,int limit,int offset);
									
								
								/**
								 * 查找 加盟商固定返点
								 * @param id
								 * @return
								 */
								public Agentvalue findAgentvalue(long id);
								
								
								/** 
								 * 查找 加盟商固定返点
								 * @param where
								 * @param orderby
								 * @param pageinfo
								 * @return
								 */
								public List findAllAgentvalueForPageinfo(String where, String orderby,PageInfo pageinfo);
									
								/** 
								 * 根据Sql查找加盟商固定返点
								 * @param sql
								 * @param limit
								 * @param offset
								 * @return
								 */
								public List findAllAgentvalueBySql(String sql,int limit,int offset);
								
								
								/**
								 * 执行Sql 加盟商固定返点
								 * @param sql 
								 * @return updated count 
								 */
								public int excuteAgentvalueBySql(String sql);
								
								/**
								 * 执行Sql 
								 * @param sql 
								 * @return  count 
								 */
								public int countAgentvalueBySql(String sql);
								

								   //粘贴到Service接口类
								 	/**
									 * 创建 登录信息
									 * @param id
									 * @return deleted count 
									 */
									public Logindesc createLogindesc(Logindesc logindesc) throws SQLException;
									
									/**
									 * 删除 登录信息
									 * @param id
									 * @return deleted count 
									 */
									public int deleteLogindesc(long id);
									
									
									/**
									 * 修改 登录信息
									 * @param id
									 * @return updated count 
									 */
									public int updateLogindesc(Logindesc logindesc);

										
									/**
									 * 修改 登录信息但忽略空值 
									 * @param id
									 * @return 
									 */
									public int updateLogindescIgnoreNull(Logindesc logindesc);
										
									
									/**
									 * 查找 登录信息
									 * @param where
									 * @param orderby
									 * @param limit
									 * @param offset
									 * @return
									 */
									public List findAllLogindesc(String where, String orderby,int limit,int offset);
										
									
									/**
									 * 查找 登录信息
									 * @param id
									 * @return
									 */
									public Logindesc findLogindesc(long id);
									
									
									/** 
									 * 查找 登录信息
									 * @param where
									 * @param orderby
									 * @param pageinfo
									 * @return
									 */
									public List findAllLogindescForPageinfo(String where, String orderby,PageInfo pageinfo);
										
									/** 
									 * 根据Sql查找登录信息
									 * @param sql
									 * @param limit
									 * @param offset
									 * @return
									 */
									public List findAllLogindescBySql(String sql,int limit,int offset);
									
									
									/**
									 * 执行Sql 登录信息
									 * @param sql 
									 * @return updated count 
									 */
									public int excuteLogindescBySql(String sql);
									
									/**
									 * 执行Sql 
									 * @param sql 
									 * @return  count 
									 */
									public int countLogindescBySql(String sql);
									
									 
									   //粘贴到Service接口类
									 	/**
										 * 创建 航班延误证明
										 * @param id
										 * @return deleted count 
										 */
										public Airdelayprove createAirdelayprove(Airdelayprove airdelayprove) throws SQLException;
										
										/**
										 * 删除 航班延误证明
										 * @param id
										 * @return deleted count 
										 */
										public int deleteAirdelayprove(long id);
										
										
										/**
										 * 修改 航班延误证明
										 * @param id
										 * @return updated count 
										 */
										public int updateAirdelayprove(Airdelayprove airdelayprove);

											
										/**
										 * 修改 航班延误证明但忽略空值 
										 * @param id
										 * @return 
										 */
										public int updateAirdelayproveIgnoreNull(Airdelayprove airdelayprove);
											
										
										/**
										 * 查找 航班延误证明
										 * @param where
										 * @param orderby
										 * @param limit
										 * @param offset
										 * @return
										 */
										public List findAllAirdelayprove(String where, String orderby,int limit,int offset);
											
										
										/**
										 * 查找 航班延误证明
										 * @param id
										 * @return
										 */
										public Airdelayprove findAirdelayprove(long id);
										
										
										/** 
										 * 查找 航班延误证明
										 * @param where
										 * @param orderby
										 * @param pageinfo
										 * @return
										 */
										public List findAllAirdelayproveForPageinfo(String where, String orderby,PageInfo pageinfo);
											
										/** 
										 * 根据Sql查找航班延误证明
										 * @param sql
										 * @param limit
										 * @param offset
										 * @return
										 */
										public List findAllAirdelayproveBySql(String sql,int limit,int offset);
										
										
										/**
										 * 执行Sql 航班延误证明
										 * @param sql 
										 * @return updated count 
										 */
										public int excuteAirdelayproveBySql(String sql);
										
										/**
										 * 执行Sql 
										 * @param sql 
										 * @return  count 
										 */
										public int countAirdelayproveBySql(String sql);
										
										 //粘贴到Service接口类
									 	/**
										 * 创建 活动会员
										 * @param id
										 * @return deleted count 
										 */
										public Huodonguser createHuodonguser(Huodonguser huodonguser) throws SQLException;
										
										/**
										 * 删除 活动会员
										 * @param id
										 * @return deleted count 
										 */
										public int deleteHuodonguser(long id);
										
										
										/**
										 * 修改 活动会员
										 * @param id
										 * @return updated count 
										 */
										public int updateHuodonguser(Huodonguser huodonguser);

											
										/**
										 * 修改 活动会员但忽略空值 
										 * @param id
										 * @return 
										 */
										public int updateHuodonguserIgnoreNull(Huodonguser huodonguser);
											
										
										/**
										 * 查找 活动会员
										 * @param where
										 * @param orderby
										 * @param limit
										 * @param offset
										 * @return
										 */
										public List findAllHuodonguser(String where, String orderby,int limit,int offset);
											
										
										/**
										 * 查找 活动会员
										 * @param id
										 * @return
										 */
										public Huodonguser findHuodonguser(long id);
										
										
										/** 
										 * 查找 活动会员
										 * @param where
										 * @param orderby
										 * @param pageinfo
										 * @return
										 */
										public List findAllHuodonguserForPageinfo(String where, String orderby,PageInfo pageinfo);
											
										/** 
										 * 根据Sql查找活动会员
										 * @param sql
										 * @param limit
										 * @param offset
										 * @return
										 */
										public List findAllHuodonguserBySql(String sql,int limit,int offset);
										
										
										/**
										 * 执行Sql 活动会员
										 * @param sql 
										 * @return updated count 
										 */
										public int excuteHuodonguserBySql(String sql);
										
										/**
										 * 执行Sql 
										 * @param sql 
										 * @return  count 
										 */
										public int countHuodonguserBySql(String sql);
										
										
										  
										  
										   //粘贴到Service接口类
										 	/**
											 * 创建 QQ号码
											 * @param id
											 * @return deleted count 
											 */
											public Qqinfonew createQqinfonew(Qqinfonew qqinfonew) throws SQLException;
											
											/**
											 * 删除 QQ号码
											 * @param id
											 * @return deleted count 
											 */
											public int deleteQqinfonew(long id);
											
											
											/**
											 * 修改 QQ号码
											 * @param id
											 * @return updated count 
											 */
											public int updateQqinfonew(Qqinfonew qqinfonew);

												
											/**
											 * 修改 QQ号码但忽略空值 
											 * @param id
											 * @return 
											 */
											public int updateQqinfonewIgnoreNull(Qqinfonew qqinfonew);
												
											
											/**
											 * 查找 QQ号码
											 * @param where
											 * @param orderby
											 * @param limit
											 * @param offset
											 * @return
											 */
											public List findAllQqinfonew(String where, String orderby,int limit,int offset);
												
											
											/**
											 * 查找 QQ号码
											 * @param id
											 * @return
											 */
											public Qqinfonew findQqinfonew(long id);
											
											
											/** 
											 * 查找 QQ号码
											 * @param where
											 * @param orderby
											 * @param pageinfo
											 * @return
											 */
											public List findAllQqinfonewForPageinfo(String where, String orderby,PageInfo pageinfo);
												
											/** 
											 * 根据Sql查找QQ号码
											 * @param sql
											 * @param limit
											 * @param offset
											 * @return
											 */
											public List findAllQqinfonewBySql(String sql,int limit,int offset);
											
											
											/**
											 * 执行Sql QQ号码
											 * @param sql 
											 * @return updated count 
											 */
											public int excuteQqinfonewBySql(String sql);
											
											/**
											 * 执行Sql 
											 * @param sql 
											 * @return  count 
											 */
											public int countQqinfonewBySql(String sql);
											
											  
											  
											   //粘贴到Service接口类
											 	/**
												 * 创建 QQ类型
												 * @param id
												 * @return deleted count 
												 */
												public Qqtypenew createQqtypenew(Qqtypenew qqtypenew) throws SQLException;
												
												/**
												 * 删除 QQ类型
												 * @param id
												 * @return deleted count 
												 */
												public int deleteQqtypenew(long id);
												
												
												/**
												 * 修改 QQ类型
												 * @param id
												 * @return updated count 
												 */
												public int updateQqtypenew(Qqtypenew qqtypenew);

													
												/**
												 * 修改 QQ类型但忽略空值 
												 * @param id
												 * @return 
												 */
												public int updateQqtypenewIgnoreNull(Qqtypenew qqtypenew);
													
												
												/**
												 * 查找 QQ类型
												 * @param where
												 * @param orderby
												 * @param limit
												 * @param offset
												 * @return
												 */
												public List findAllQqtypenew(String where, String orderby,int limit,int offset);
													
												
												/**
												 * 查找 QQ类型
												 * @param id
												 * @return
												 */
												public Qqtypenew findQqtypenew(long id);
												
												
												/** 
												 * 查找 QQ类型
												 * @param where
												 * @param orderby
												 * @param pageinfo
												 * @return
												 */
												public List findAllQqtypenewForPageinfo(String where, String orderby,PageInfo pageinfo);
													
												/** 
												 * 根据Sql查找QQ类型
												 * @param sql
												 * @param limit
												 * @param offset
												 * @return
												 */
												public List findAllQqtypenewBySql(String sql,int limit,int offset);
												
												
												/**
												 * 执行Sql QQ类型
												 * @param sql 
												 * @return updated count 
												 */
												public int excuteQqtypenewBySql(String sql);
												
												/**
												 * 执行Sql 
												 * @param sql 
												 * @return  count 
												 */
												public int countQqtypenewBySql(String sql);
												
												
												  
												  
												   //粘贴到Service接口类
												 	/**
													 * 创建 用户信息
													 * @param id
													 * @return deleted count 
													 */
													public Txuserinfo createTxuserinfo(Txuserinfo txuserinfo) throws SQLException;
													
													/**
													 * 删除 用户信息
													 * @param id
													 * @return deleted count 
													 */
													public int deleteTxuserinfo(long id);
													
													
													/**
													 * 修改 用户信息
													 * @param id
													 * @return updated count 
													 */
													public int updateTxuserinfo(Txuserinfo txuserinfo);

														
													/**
													 * 修改 用户信息但忽略空值 
													 * @param id
													 * @return 
													 */
													public int updateTxuserinfoIgnoreNull(Txuserinfo txuserinfo);
														
													
													/**
													 * 查找 用户信息
													 * @param where
													 * @param orderby
													 * @param limit
													 * @param offset
													 * @return
													 */
													public List findAllTxuserinfo(String where, String orderby,int limit,int offset);
														
													
													/**
													 * 查找 用户信息
													 * @param id
													 * @return
													 */
													public Txuserinfo findTxuserinfo(long id);
													
													
													/** 
													 * 查找 用户信息
													 * @param where
													 * @param orderby
													 * @param pageinfo
													 * @return
													 */
													public List findAllTxuserinfoForPageinfo(String where, String orderby,PageInfo pageinfo);
														
													/** 
													 * 根据Sql查找用户信息
													 * @param sql
													 * @param limit
													 * @param offset
													 * @return
													 */
													public List findAllTxuserinfoBySql(String sql,int limit,int offset);
													
													
													/**
													 * 执行Sql 用户信息
													 * @param sql 
													 * @return updated count 
													 */
													public int excuteTxuserinfoBySql(String sql);
													
													/**
													 * 执行Sql 
													 * @param sql 
													 * @return  count 
													 */
													public int countTxuserinfoBySql(String sql);
													
													
													  
													  
													   //粘贴到Service接口类
													 	/**
														 * 创建 TX订单
														 * @param id
														 * @return deleted count 
														 */
														public Txorder createTxorder(Txorder txorder) throws SQLException;
														
														/**
														 * 删除 TX订单
														 * @param id
														 * @return deleted count 
														 */
														public int deleteTxorder(long id);
														
														
														/**
														 * 修改 TX订单
														 * @param id
														 * @return updated count 
														 */
														public int updateTxorder(Txorder txorder);

															
														/**
														 * 修改 TX订单但忽略空值 
														 * @param id
														 * @return 
														 */
														public int updateTxorderIgnoreNull(Txorder txorder);
															
														
														/**
														 * 查找 TX订单
														 * @param where
														 * @param orderby
														 * @param limit
														 * @param offset
														 * @return
														 */
														public List findAllTxorder(String where, String orderby,int limit,int offset);
															
														
														/**
														 * 查找 TX订单
														 * @param id
														 * @return
														 */
														public Txorder findTxorder(long id);
														
														
														/** 
														 * 查找 TX订单
														 * @param where
														 * @param orderby
														 * @param pageinfo
														 * @return
														 */
														public List findAllTxorderForPageinfo(String where, String orderby,PageInfo pageinfo);
															
														/** 
														 * 根据Sql查找TX订单
														 * @param sql
														 * @param limit
														 * @param offset
														 * @return
														 */
														public List findAllTxorderBySql(String sql,int limit,int offset);
														
														
														/**
														 * 执行Sql TX订单
														 * @param sql 
														 * @return updated count 
														 */
														public int excuteTxorderBySql(String sql);
														
														/**
														 * 执行Sql 
														 * @param sql 
														 * @return  count 
														 */
														public int countTxorderBySql(String sql);
														
														
														
														  
														  
														   //粘贴到Service接口类
														 	/**
															 * 创建 提现
															 * @param id
															 * @return deleted count 
															 */
															public Withbank createWithbank(Withbank withbank) throws SQLException;
															
															/**
															 * 删除 提现
															 * @param id
															 * @return deleted count 
															 */
															public int deleteWithbank(long id);
															
															
															/**
															 * 修改 提现
															 * @param id
															 * @return updated count 
															 */
															public int updateWithbank(Withbank withbank);

																
															/**
															 * 修改 提现但忽略空值 
															 * @param id
															 * @return 
															 */
															public int updateWithbankIgnoreNull(Withbank withbank);
																
															
															/**
															 * 查找 提现
															 * @param where
															 * @param orderby
															 * @param limit
															 * @param offset
															 * @return
															 */
															public List findAllWithbank(String where, String orderby,int limit,int offset);
																
															
															/**
															 * 查找 提现
															 * @param id
															 * @return
															 */
															public Withbank findWithbank(long id);
															
															
															/** 
															 * 查找 提现
															 * @param where
															 * @param orderby
															 * @param pageinfo
															 * @return
															 */
															public List findAllWithbankForPageinfo(String where, String orderby,PageInfo pageinfo);
																
															/** 
															 * 根据Sql查找提现
															 * @param sql
															 * @param limit
															 * @param offset
															 * @return
															 */
															public List findAllWithbankBySql(String sql,int limit,int offset);
															
															
															/**
															 * 执行Sql 提现
															 * @param sql 
															 * @return updated count 
															 */
															public int excuteWithbankBySql(String sql);
															
															/**
															 * 执行Sql 
															 * @param sql 
															 * @return  count 
															 */
															public int countWithbankBySql(String sql);
															
															
															  
															  
															   //粘贴到Service接口类
															 	/**
																 * 创建 短信用户账号
																 * @param id
																 * @return deleted count 
																 */
																public Ymuser createYmuser(Ymuser ymuser) throws SQLException;
																
																/**
																 * 删除 短信用户账号
																 * @param id
																 * @return deleted count 
																 */
																public int deleteYmuser(long id);
																
																
																/**
																 * 修改 短信用户账号
																 * @param id
																 * @return updated count 
																 */
																public int updateYmuser(Ymuser ymuser);

																	
																/**
																 * 修改 短信用户账号但忽略空值 
																 * @param id
																 * @return 
																 */
																public int updateYmuserIgnoreNull(Ymuser ymuser);
																	
																
																/**
																 * 查找 短信用户账号
																 * @param where
																 * @param orderby
																 * @param limit
																 * @param offset
																 * @return
																 */
																public List findAllYmuser(String where, String orderby,int limit,int offset);
																	
																
																/**
																 * 查找 短信用户账号
																 * @param id
																 * @return
																 */
																public Ymuser findYmuser(long id);
																
																
																/** 
																 * 查找 短信用户账号
																 * @param where
																 * @param orderby
																 * @param pageinfo
																 * @return
																 */
																public List findAllYmuserForPageinfo(String where, String orderby,PageInfo pageinfo);
																	
																/** 
																 * 根据Sql查找短信用户账号
																 * @param sql
																 * @param limit
																 * @param offset
																 * @return
																 */
																public List findAllYmuserBySql(String sql,int limit,int offset);
																
																
																/**
																 * 执行Sql 短信用户账号
																 * @param sql 
																 * @return updated count 
																 */
																public int excuteYmuserBySql(String sql);
																
																/**
																 * 执行Sql 
																 * @param sql 
																 * @return  count 
																 */
																public int countYmuserBySql(String sql);
		
																
																  
																  
																   //粘贴到Service接口类
																 	/**
																	 * 创建 短信充值记录
																	 * @param id
																	 * @return deleted count 
																	 */
																	public Ympay createYmpay(Ympay ympay) throws SQLException;
																	
																	/**
																	 * 删除 短信充值记录
																	 * @param id
																	 * @return deleted count 
																	 */
																	public int deleteYmpay(long id);
																	
																	
																	/**
																	 * 修改 短信充值记录
																	 * @param id
																	 * @return updated count 
																	 */
																	public int updateYmpay(Ympay ympay);

																		
																	/**
																	 * 修改 短信充值记录但忽略空值 
																	 * @param id
																	 * @return 
																	 */
																	public int updateYmpayIgnoreNull(Ympay ympay);
																		
																	
																	/**
																	 * 查找 短信充值记录
																	 * @param where
																	 * @param orderby
																	 * @param limit
																	 * @param offset
																	 * @return
																	 */
																	public List findAllYmpay(String where, String orderby,int limit,int offset);
																		
																	
																	/**
																	 * 查找 短信充值记录
																	 * @param id
																	 * @return
																	 */
																	public Ympay findYmpay(long id);
																	
																	
																	/** 
																	 * 查找 短信充值记录
																	 * @param where
																	 * @param orderby
																	 * @param pageinfo
																	 * @return
																	 */
																	public List findAllYmpayForPageinfo(String where, String orderby,PageInfo pageinfo);
																		
																	/** 
																	 * 根据Sql查找短信充值记录
																	 * @param sql
																	 * @param limit
																	 * @param offset
																	 * @return
																	 */
																	public List findAllYmpayBySql(String sql,int limit,int offset);
																	
																	
																	/**
																	 * 执行Sql 短信充值记录
																	 * @param sql 
																	 * @return updated count 
																	 */
																	public int excuteYmpayBySql(String sql);
																	
																	/**
																	 * 执行Sql 
																	 * @param sql 
																	 * @return  count 
																	 */
																	public int countYmpayBySql(String sql);
																												
}


