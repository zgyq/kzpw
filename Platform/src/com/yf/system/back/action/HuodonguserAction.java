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
import com.yf.system.base.huodonguser.Huodonguser;


public class HuodonguserAction extends B2b2cbackAction {
	private List <  Huodonguser  >  listHuodonguser;
	private Huodonguser huodonguser = new Huodonguser();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_name;
	
	private String s_mobile;
	
	private String s_isnumber;
	
	private String s_time;
	/**
	 * 列表查询活动会员
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (s_name!=null && s_name.trim().length()!=0) {
			
			where += " and " + Huodonguser.COL_name +" like '%" + s_name.trim()+"%'";	
		}
		if (s_mobile!=null && s_mobile.trim().length()!=0) {
			
			where += " and " + Huodonguser.COL_mobile +" like '%" + s_mobile.trim()+"%'";	
		}
		if (s_isnumber!=null && s_isnumber.trim().length()!=0) {
			
			where += " and " + Huodonguser.COL_idnumber +" like '%" + s_isnumber.trim()+"%'";	
		}
		if (s_time!=null && s_time.trim().length()!=0) {
			
			where += " and " + Huodonguser.COL_createtime +" >='" + s_time.trim()+" 00:00:000' AND "+Huodonguser.COL_createtime +" <='" + s_time.trim()+" 23:59:000' ";	
		}
		System.out.println(where);
		
	    List list = Server.getInstance().getMemberService().findAllHuodonguserForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listHuodonguser = list;
		  if(pageinfo.getTotalrow()>0 &&   listHuodonguser.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllHuodonguserForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listHuodonguser = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到活动会员添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到活动会员修改页面
	 */	
	public String toedit()throws Exception{
	huodonguser = Server.getInstance().getMemberService().findHuodonguser(huodonguser.getId());
		return EDIT;
	}
	
	/**
	 * 转向到活动会员审核页面
	 */	
	public String tocheck()throws Exception{
	huodonguser = Server.getInstance().getMemberService().findHuodonguser(huodonguser.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加活动会员
	 */		
	public String add()throws Exception{
	huodonguser.setCreatetime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getMemberService().createHuodonguser(huodonguser);
		return LIST;
	}

	/**
	 * 审核活动会员
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateHuodonguserIgnoreNull(huodonguser);
		return LIST;
	}
	


	/**
	 * 编辑活动会员
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateHuodonguserIgnoreNull(huodonguser);
		return LIST;
	}

	/**
	 * 删除活动会员
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteHuodonguser(huodonguser.getId());
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
					Server.getInstance().getMemberService().deleteHuodonguser(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回活动会员对象
	 */		
	
	public Object getModel() {
		return huodonguser;
	}
	public List < Huodonguser >   getListHuodonguser() {
		return listHuodonguser;
	}
	public void setListHuodonguser(List <  Huodonguser  >  listHuodonguser) {
		this.listHuodonguser = listHuodonguser;
	}
	public Huodonguser getHuodonguser() {
		return huodonguser;
	}
	public void setHuodonguser(Huodonguser huodonguser) {
		this.huodonguser = huodonguser;
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
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_mobile() {
		return s_mobile;
	}
	public void setS_mobile(String s_mobile) {
		this.s_mobile = s_mobile;
	}
	public String getS_isnumber() {
		return s_isnumber;
	}
	public void setS_isnumber(String s_isnumber) {
		this.s_isnumber = s_isnumber;
	}
	public String getS_time() {
		return s_time;
	}
	public void setS_time(String s_time) {
		this.s_time = s_time;
	}
	
	
}