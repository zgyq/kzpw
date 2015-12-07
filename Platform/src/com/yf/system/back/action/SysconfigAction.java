/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.util.PageInfo;


public class SysconfigAction extends B2b2cbackAction {
	private List <  Sysconfig  >  listSysconfig;
	private Sysconfig sysconfig = new Sysconfig();
	private String strQQ1;
	private String strQQ2;
	private String strQQ3;
	private String strQQ4;
	private String strQQ5;
	private String strQQ6;
	private String strQQ7;
	private String strQQ8;
	private String strQQ9;
	private String strQQ10;
	private String strQQ11;
	private String strQQ12;
	
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询系统配置表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Sysconfig.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllSysconfigForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSysconfig = list;
		  if(pageinfo.getTotalrow()>0 &&   listSysconfig.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllSysconfigForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSysconfig = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 配置旅游车队
	 */	
	public String toedittravelcars()throws Exception{
		sysconfig=Server.getInstance().getMemberService().findSysconfig(10015);
		return "edittravelcars";
	}
	/**
	 * 提交旅游车队
	 */	
	public String edittravelcars()throws Exception{
		Server.getInstance().getMemberService().updateSysconfigIgnoreNull(sysconfig);
		return "edittravelcars";
	}
	
	/**
	 * 配置首页旅游线路
	 */	
	public String toedittravelindex()throws Exception{
		sysconfig=Server.getInstance().getMemberService().findSysconfig(10018);
		return "edittravelindex";
	}
	/**
	 * 提交首页旅游线路
	 */	
	public String edittravelindex()throws Exception{
		Server.getInstance().getMemberService().updateSysconfigIgnoreNull(sysconfig);
		return "edittravelindex";
	}
	
	/**
	 * 配置首页国内国际旅游线路
	 */	
	public String toedittravelgngj()throws Exception{
		sysconfig=Server.getInstance().getMemberService().findSysconfig(10019);
		return "edittravelgngj";
	}
	/**
	 * 提交首页国内国际旅游线路
	 */	
	public String edittravelgngj()throws Exception{
		Server.getInstance().getMemberService().updateSysconfigIgnoreNull(sysconfig);
		return "edittravelgngj";
	}
	
	
	/**
	 * 配置包机业务
	 */	
	public String toeditchartflight()throws Exception{
		sysconfig=Server.getInstance().getMemberService().findSysconfig(10016);
		return "editchartflight";
	}
	/**
	 * 提交包机业务
	 */	
	public String editchartflight()throws Exception{
		Server.getInstance().getMemberService().updateSysconfigIgnoreNull(sysconfig);
		return "editchartflight";
	}
	
	
	/**
	 * 配置自取地址
	 */	
	public String toeditaddress()throws Exception{
		sysconfig=Server.getInstance().getMemberService().findSysconfig(10012);
		return "editaddress";
	}
	/**
	 * 提交自取地址
	 */	
	public String editaddress()throws Exception{
		Server.getInstance().getMemberService().updateSysconfigIgnoreNull(sysconfig);
		return "editaddress";
	}
	/**
	 * 配置客服QQ
	 */	
	public String toqqservice() throws Exception{
		sysconfig=Server.getInstance().getMemberService().findSysconfig(10014);
		String strQQList=sysconfig.getValue();
		String[] strQQarr=strQQList.split(",");
		
		if(strQQarr.length==12)
		{
			strQQ1=strQQarr[0];
			strQQ2=strQQarr[1];
			strQQ3=strQQarr[2];
			strQQ4=strQQarr[3];
			strQQ5=strQQarr[4];
			strQQ6=strQQarr[5];
			strQQ7=strQQarr[6];
			strQQ8=strQQarr[7];	
			strQQ9=strQQarr[8];
			strQQ10=strQQarr[9];
			strQQ11=strQQarr[10];
			strQQ12=strQQarr[11];
		}
			
		return "qqservice";
	}
	/**
	 * 提交客服qq
	 */	
	public String editqqservice()throws Exception{
		String strconfigvalue="";
		strconfigvalue=strQQ1+","+strQQ2+","+strQQ3+","+strQQ4+","+strQQ5+","+strQQ6+","+strQQ7+","+strQQ8+","+strQQ9+","+strQQ10+","+strQQ11+","+strQQ12;
		sysconfig.setValue(strconfigvalue);
		Server.getInstance().getMemberService().updateSysconfigIgnoreNull(sysconfig);
		return "qqservice";
	}
	/**
	 * 转向到系统配置表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到系统配置表修改页面
	 */	
	public String toedit()throws Exception{
	sysconfig = Server.getInstance().getMemberService().findSysconfig(sysconfig.getId());
		return EDIT;
	}
	
	/**
	 * 转向到系统配置表审核页面
	 */	
	public String tocheck()throws Exception{
	sysconfig = Server.getInstance().getMemberService().findSysconfig(sysconfig.getId());
	
	
	return CHECK;
	}
	
	
	/**
	 * 添加系统配置表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getMemberService().createSysconfig(sysconfig);
		return LIST;
	}

	/**
	 * 审核系统配置表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateSysconfigIgnoreNull(sysconfig);
		return LIST;
	}
	


	/**
	 * 编辑系统配置表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateSysconfigIgnoreNull(sysconfig);
		return LIST;
	}

	/**
	 * 删除系统配置表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteSysconfig(sysconfig.getId());
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
					Server.getInstance().getMemberService().deleteSysconfig(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回系统配置表对象
	 */		
	
	public Object getModel() {
		return sysconfig;
	}
	public List < Sysconfig >   getListSysconfig() {
		return listSysconfig;
	}
	public void setListSysconfig(List <  Sysconfig  >  listSysconfig) {
		this.listSysconfig = listSysconfig;
	}
	public Sysconfig getSysconfig() {
		return sysconfig;
	}
	public void setSysconfig(Sysconfig sysconfig) {
		this.sysconfig = sysconfig;
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
	public String getStrQQ1() {
		return strQQ1;
	}
	public void setStrQQ1(String strQQ1) {
		this.strQQ1 = strQQ1;
	}
	public String getStrQQ2() {
		return strQQ2;
	}
	public void setStrQQ2(String strQQ2) {
		this.strQQ2 = strQQ2;
	}
	public String getStrQQ3() {
		return strQQ3;
	}
	public void setStrQQ3(String strQQ3) {
		this.strQQ3 = strQQ3;
	}
	public String getStrQQ4() {
		return strQQ4;
	}
	public void setStrQQ4(String strQQ4) {
		this.strQQ4 = strQQ4;
	}
	public String getStrQQ5() {
		return strQQ5;
	}
	public void setStrQQ5(String strQQ5) {
		this.strQQ5 = strQQ5;
	}
	public String getStrQQ6() {
		return strQQ6;
	}
	public void setStrQQ6(String strQQ6) {
		this.strQQ6 = strQQ6;
	}
	public String getStrQQ7() {
		return strQQ7;
	}
	public void setStrQQ7(String strQQ7) {
		this.strQQ7 = strQQ7;
	}
	public String getStrQQ8() {
		return strQQ8;
	}
	public void setStrQQ8(String strQQ8) {
		this.strQQ8 = strQQ8;
	}
	public String getStrQQ9() {
		return strQQ9;
	}
	public void setStrQQ9(String strQQ9) {
		this.strQQ9 = strQQ9;
	}
	public String getStrQQ10() {
		return strQQ10;
	}
	public void setStrQQ10(String strQQ10) {
		this.strQQ10 = strQQ10;
	}
	public String getStrQQ11() {
		return strQQ11;
	}
	public void setStrQQ11(String strQQ11) {
		this.strQQ11 = strQQ11;
	}
	public String getStrQQ12() {
		return strQQ12;
	}
	public void setStrQQ12(String strQQ12) {
		this.strQQ12 = strQQ12;
	}
	
	
}