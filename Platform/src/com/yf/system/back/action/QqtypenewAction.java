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


public class QqtypenewAction extends B2b2cbackAction {
	private List <  Qqtypenew  >  listQqtypenew;
	private Qqtypenew qqtypenew = new Qqtypenew();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询QQ类型
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Qqtypenew.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
		
		where+=" AND "+Qqtypenew.COL_agentid+" ="+getLoginUser().getAgentid();
		
	    List list = Server.getInstance().getMemberService().findAllQqtypenewForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listQqtypenew = list;
		  if(pageinfo.getTotalrow()>0 &&   listQqtypenew.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllQqtypenewForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listQqtypenew = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到QQ类型添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到QQ类型修改页面
	 */	
	public String toedit()throws Exception{
	qqtypenew = Server.getInstance().getMemberService().findQqtypenew(qqtypenew.getId());
		return EDIT;
	}
	
	/**
	 * 转向到QQ类型审核页面
	 */	
	public String tocheck()throws Exception{
	qqtypenew = Server.getInstance().getMemberService().findQqtypenew(qqtypenew.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加QQ类型
	 */		
	public String add()throws Exception{
		qqtypenew.setCreatetime(new Timestamp(System.currentTimeMillis()));
		qqtypenew.setAgentid(getLoginUser().getAgentid());
		qqtypenew.setUserid(getLoginUser().getId());
		Server.getInstance().getMemberService().createQqtypenew(qqtypenew);
		return LIST;
	}

	/**
	 * 审核QQ类型
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateQqtypenewIgnoreNull(qqtypenew);
		return LIST;
	}
	


	/**
	 * 编辑QQ类型
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getMemberService().updateQqtypenewIgnoreNull(qqtypenew);
		return LIST;
	}

	/**
	 * 删除QQ类型
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteQqtypenew(qqtypenew.getId());
		
		Server.getInstance().getMemberService().excuteQqinfonewBySql(" DELETE "+Qqinfonew.TABLE+" where "+Qqinfonew.COL_typeid+" ="+qqtypenew.getId());
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
					Server.getInstance().getMemberService().deleteQqtypenew(i);
					Server.getInstance().getMemberService().excuteQqinfonewBySql(" DELETE "+Qqinfonew.TABLE+" where "+Qqinfonew.COL_typeid+" ="+i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回QQ类型对象
	 */		
	
	public Object getModel() {
		return qqtypenew;
	}
	public List < Qqtypenew >   getListQqtypenew() {
		return listQqtypenew;
	}
	public void setListQqtypenew(List <  Qqtypenew  >  listQqtypenew) {
		this.listQqtypenew = listQqtypenew;
	}
	public Qqtypenew getQqtypenew() {
		return qqtypenew;
	}
	public void setQqtypenew(Qqtypenew qqtypenew) {
		this.qqtypenew = qqtypenew;
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