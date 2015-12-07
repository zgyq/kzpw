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
import com.yf.system.base.infocontent.Infocontent;
import com.yf.system.base.infotype.Infotype;


public class InfocontentAction extends B2b2cbackAction {
	private List <  Infocontent  >  listInfocontent;
	private Infocontent infocontent = new Infocontent();
	private List<Infocontent> listhelpcenter;
	private List<Infotype> infotypelist;
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	//获得帮助信息的编号
	private Long hid;
	//search
	//private String s_name;
	
	
	public Long getHid() {
		return hid;
	}
	public void setHid(Long hid) {
		this.hid = hid;
	}
	/**
	 * 列表查询信息
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Infocontent.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllInfocontentForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listInfocontent = list;
		  if(pageinfo.getTotalrow()>0 &&   listInfocontent.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllInfocontentForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listInfocontent = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 列表查询信息加盟商登录后查看
	 *赵晓晓
	 */
	public String searchhelpcenter(){
		String where = " where 1=1 ";
		StringBuilder sb=new StringBuilder(" ");
		if(infocontent.getTitle()!=null&&!infocontent.getTitle().equals("")){
			sb.append("and C_TITLE like '%"+infocontent.getTitle()+"%'");
		}
		if(infocontent.getTypeid()!=null&&!infocontent.getTypeid().equals("")){
			sb.append(" and C_TYPEID="+infocontent.getTypeid());
		}
		 List list = Server.getInstance().getMemberService().findAllInfocontentForPageinfo(where+sb," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listhelpcenter = list;
			  if(pageinfo.getTotalrow()>0 &&listhelpcenter.size()==0){
				pageinfo.setPagenum(1);
				list = Server.getInstance().getMemberService().findAllInfocontentForPageinfo(where+sb," ORDER BY ID ",pageinfo);
				pageinfo = (PageInfo)list.remove(0);
				listhelpcenter = list;
			}
		return "searchhelpcenter";
	}
	/**
	 * 根据标题查看详细信息
	 * 赵晓晓
	 * @throws Exception
	 */
	public String helpcount(){
		//根据id获得详细信息
		this.setInfocontent(Server.getInstance().getMemberService().findInfocontent(hid));
		return "helpcount";
	}
	public String helplist() throws Exception
	{
        String where = " where 1=1";
	    List list = Server.getInstance().getMemberService().findAllInfocontentForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listhelpcenter = list;
		  if(pageinfo.getTotalrow()>0 &&   listhelpcenter.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllInfocontentForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listhelpcenter = list;
		}
		return "helplistinfo";
	}
	
	public String tohelpadd() throws Exception
	{
		infotypelist=Server.getInstance().getMemberService().findAllInfotype("where 1=1", "", -1, 0);
		
		return "helptoadd";
	}
	/**
	 * 添加信息
	 */		
	public String addhelpinfo()throws Exception{
	infocontent.setCreateuser(getLoginUser().getLoginname());
		infocontent.setCreatetime(new Timestamp(System.currentTimeMillis()));
		infocontent.setModifyuser(getLoginUser().getLoginname());
		infocontent.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createInfocontent(infocontent);
		return "helpaddok";
	}
	
	/**
	 * 编辑信息
	 */		
	public String edithelpinfo()throws Exception{
	infocontent.setModifyuser(getLoginUser().getLoginname());
		infocontent.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updateInfocontentIgnoreNull(infocontent);
		return "helpaddok";
	}
	
	public String tohelpedit() throws Exception
	{
        infotypelist=Server.getInstance().getMemberService().findAllInfotype("where 1=1", "", -1, 0);
        infocontent = Server.getInstance().getMemberService().findInfocontent(infocontent.getId());
		return "helptoedit";
	}
	
	/**
	 * 删除信息
	 */		
	public String todeletehelp()throws Exception{	
		Server.getInstance().getMemberService().deleteInfocontent(infocontent.getId());
		return "helpaddok";
	}

	
	/**
	 * 转向到信息添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到信息修改页面
	 */	
	public String toedit()throws Exception{
	infocontent = Server.getInstance().getMemberService().findInfocontent(infocontent.getId());
		return EDIT;
	}
	
	/**
	 * 转向到信息审核页面
	 */	
	public String tocheck()throws Exception{
	infocontent = Server.getInstance().getMemberService().findInfocontent(infocontent.getId());
		return CHECK;
	}
	
	/**
	 * 根据帮助类型名称
	 */
	public String getHTypeName(long idnumber)
	{
		//Infotype infotypeinfo=Server.getInstance().getMemberService().findInfotype(idnumber);
		Infotype helptinfo=Server.getInstance().getMemberService().findInfotype(idnumber);
		return helptinfo != null && !"".equals(helptinfo.getTypename()) ? helptinfo.getTypename() : "";
	}
	/**
	 * 根据名称获得id
	 */
	public String getHtypeId(String name){
		return null;
	}
	/**
	 * 添加信息
	 */		
	public String add()throws Exception{
	infocontent.setCreateuser(getLoginUser().getLoginname());
		infocontent.setCreatetime(new Timestamp(System.currentTimeMillis()));
		infocontent.setModifyuser(getLoginUser().getLoginname());
		infocontent.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createInfocontent(infocontent);
		return LIST;
	}

	/**
	 * 审核信息
	 */		
	public String check()throws Exception{
	infocontent.setModifyuser(getLoginUser().getLoginname());
		infocontent.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updateInfocontentIgnoreNull(infocontent);
		return LIST;
	}
	


	/**
	 * 编辑信息
	 */		
	public String edit()throws Exception{
	infocontent.setModifyuser(getLoginUser().getLoginname());
		infocontent.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().updateInfocontentIgnoreNull(infocontent);
		return LIST;
	}

	/**
	 * 删除信息
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteInfocontent(infocontent.getId());
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
					Server.getInstance().getMemberService().deleteInfocontent(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}
	
	/**
	 * 批量操作
	 * @return
	 * @throws Exception
	 */
	public String batchhelp()throws Exception{
		if(selectid!=null && selectid.length>0 ){
			
			switch(opt){
				case 1: //delete
				
				for(int i:selectid){
					Server.getInstance().getMemberService().deleteInfocontent(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return "helpaddok";
	}






	/**
	 *  返回信息对象
	 */		
	
	public Object getModel() {
		return infocontent;
	}
	public List < Infocontent >   getListInfocontent() {
		return listInfocontent;
	}
	public void setListInfocontent(List <  Infocontent  >  listInfocontent) {
		this.listInfocontent = listInfocontent;
	}
	public Infocontent getInfocontent() {
		return infocontent;
	}
	public void setInfocontent(Infocontent infocontent) {
		this.infocontent = infocontent;
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

	public List<Infocontent> getListhelpcenter() {
		return listhelpcenter;
	}

	public void setListhelpcenter(List<Infocontent> listhelpcenter) {
		this.listhelpcenter = listhelpcenter;
	}

	public List<Infotype> getInfotypelist() {
		return infotypelist;
	}

	public void setInfotypelist(List<Infotype> infotypelist) {
		this.infotypelist = infotypelist;
	}
	
	
}