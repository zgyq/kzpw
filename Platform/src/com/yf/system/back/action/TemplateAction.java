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
import com.yf.system.base.template.Template;


public class TemplateAction extends B2b2cbackAction {
	private List <  Template  >  listTemplate;
	private Template template = new Template();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	
	/**
	 * 列表查询模板
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Template.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllTemplateForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTemplate = list;
		  if(pageinfo.getTotalrow()>0 &&   listTemplate.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllTemplateForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTemplate = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到模板添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到模板修改页面
	 */	
	public String toedit()throws Exception{
	template = Server.getInstance().getAirService().findTemplate(template.getId());
		return EDIT;
	}
	
	/**
	 * 转向到模板审核页面
	 */	
	public String tocheck()throws Exception{
	template = Server.getInstance().getAirService().findTemplate(template.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加模板
	 */		
	public String add()throws Exception{
	template.setCreateuser(getLoginUser().getLoginname());
		template.setCreatetime(new Timestamp(System.currentTimeMillis()));
		template.setModifyuser(getLoginUser().getLoginname());
		template.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().createTemplate(template);
		return LIST;
	}

	/**
	 * 审核模板
	 */		
	public String check()throws Exception{
	template.setModifyuser(getLoginUser().getLoginname());
		template.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updateTemplateIgnoreNull(template);
		return LIST;
	}
	


	/**
	 * 编辑模板
	 */		
	public String edit()throws Exception{
	template.setModifyuser(getLoginUser().getLoginname());
		template.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getAirService().updateTemplateIgnoreNull(template);
		return LIST;
	}

	/**
	 * 删除模板
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteTemplate(template.getId());
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
					Server.getInstance().getAirService().deleteTemplate(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回模板对象
	 */		
	
	public Object getModel() {
		return template;
	}
	public List < Template >   getListTemplate() {
		return listTemplate;
	}
	public void setListTemplate(List <  Template  >  listTemplate) {
		this.listTemplate = listTemplate;
	}
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
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