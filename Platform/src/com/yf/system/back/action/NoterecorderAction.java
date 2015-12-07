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
import com.yf.system.base.noterecorder.Noterecorder;


public class NoterecorderAction extends B2b2cbackAction {
	private List <  Noterecorder  >  listNoterecorder;
	private Noterecorder noterecorder = new Noterecorder();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询通知记录
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Noterecorder.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllNoterecorderForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listNoterecorder = list;
		  if(pageinfo.getTotalrow()>0 &&   listNoterecorder.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllNoterecorderForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listNoterecorder = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到通知记录添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到通知记录修改页面
	 */	
	public String toedit()throws Exception{
	noterecorder = Server.getInstance().getAirService().findNoterecorder(noterecorder.getId());
		return EDIT;
	}
	
	/**
	 * 转向到通知记录审核页面
	 */	
	public String tocheck()throws Exception{
	noterecorder = Server.getInstance().getAirService().findNoterecorder(noterecorder.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加通知记录
	 */		
	public String add()throws Exception{
	noterecorder.setCreateuser(getLoginUser().getLoginname());
		noterecorder.setCreatetime(new Timestamp(System.currentTimeMillis()));
		noterecorder.setModifyuser(getLoginUser().getLoginname());
		noterecorder.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().createNoterecorder(noterecorder);
		return LIST;
	}

	/**
	 * 审核通知记录
	 */		
	public String check()throws Exception{
	noterecorder.setModifyuser(getLoginUser().getLoginname());
		noterecorder.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updateNoterecorderIgnoreNull(noterecorder);
		return LIST;
	}
	


	/**
	 * 编辑通知记录
	 */		
	public String edit()throws Exception{
	noterecorder.setModifyuser(getLoginUser().getLoginname());
		noterecorder.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updateNoterecorderIgnoreNull(noterecorder);
		return LIST;
	}

	/**
	 * 删除通知记录
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteNoterecorder(noterecorder.getId());
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
					Server.getInstance().getAirService().deleteNoterecorder(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回通知记录对象
	 */		
	
	public Object getModel() {
		return noterecorder;
	}
	public List < Noterecorder >   getListNoterecorder() {
		return listNoterecorder;
	}
	public void setListNoterecorder(List <  Noterecorder  >  listNoterecorder) {
		this.listNoterecorder = listNoterecorder;
	}
	public Noterecorder getNoterecorder() {
		return noterecorder;
	}
	public void setNoterecorder(Noterecorder noterecorder) {
		this.noterecorder = noterecorder;
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