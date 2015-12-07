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
import com.yf.system.base.qqinfonew.Qqinfonew;
import com.yf.system.base.qqtypenew.Qqtypenew;


public class QqinfonewAction extends B2b2cbackAction {
	private List <  Qqinfonew  >  listQqinfonew;
	private List <  Qqtypenew  >  listQqtypenew;
	private Qqinfonew qqinfonew = new Qqinfonew();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询QQ号码
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		where+=" AND "+Qqinfonew.COL_userid+" ="+getLoginUser().getAgentid();
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Qqinfonew.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getMemberService().findAllQqinfonewForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listQqinfonew = list;
		  if(pageinfo.getTotalrow()>0 &&   listQqinfonew.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllQqinfonewForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listQqinfonew = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到QQ号码添加页面
	 */	
	public String toadd()throws Exception{
		listQqtypenew=Server.getInstance().getMemberService().findAllQqtypenew(" where 1=1 and "+Qqtypenew.COL_agentid+" ="+getLoginUser().getAgentid(), " order by id desc ", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到QQ号码修改页面
	 */	
	public String toedit()throws Exception{
	listQqtypenew=Server.getInstance().getMemberService().findAllQqtypenew(" where 1=1 and "+Qqtypenew.COL_agentid+" ="+getLoginUser().getAgentid(), " order by id desc ", -1, 0);
		
	qqinfonew = Server.getInstance().getMemberService().findQqinfonew(qqinfonew.getId());
		return EDIT;
	}
	
	/**
	 * 转向到QQ号码审核页面
	 */	
	public String tocheck()throws Exception{
	qqinfonew = Server.getInstance().getMemberService().findQqinfonew(qqinfonew.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加QQ号码
	 */		
	public String add()throws Exception{
		qqinfonew.setCreatetime(new Timestamp(System.currentTimeMillis()));
		qqinfonew.setUserid(getLoginUser().getAgentid());
		Server.getInstance().getMemberService().createQqinfonew(qqinfonew);
		return LIST;
	}

	/**
	 * 审核QQ号码
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateQqinfonewIgnoreNull(qqinfonew);
		return LIST;
	}
	


	/**
	 * 编辑QQ号码
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateQqinfonewIgnoreNull(qqinfonew);
		return LIST;
	}

	/**
	 * 删除QQ号码
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteQqinfonew(qqinfonew.getId());
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
					Server.getInstance().getMemberService().deleteQqinfonew(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回QQ号码对象
	 */		
	
	public Object getModel() {
		return qqinfonew;
	}
	public List < Qqinfonew >   getListQqinfonew() {
		return listQqinfonew;
	}
	public void setListQqinfonew(List <  Qqinfonew  >  listQqinfonew) {
		this.listQqinfonew = listQqinfonew;
	}
	public Qqinfonew getQqinfonew() {
		return qqinfonew;
	}
	public void setQqinfonew(Qqinfonew qqinfonew) {
		this.qqinfonew = qqinfonew;
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
	public List<Qqtypenew> getListQqtypenew() {
		return listQqtypenew;
	}
	public void setListQqtypenew(List<Qqtypenew> listQqtypenew) {
		this.listQqtypenew = listQqtypenew;
	}
	
	
}