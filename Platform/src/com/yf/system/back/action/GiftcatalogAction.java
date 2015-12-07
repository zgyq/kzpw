/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.giftcatalog.Giftcatalog;
import com.yf.system.base.systemright.Systemright;
import com.yf.system.base.util.PageInfo;


public class GiftcatalogAction extends B2b2cbackAction {
	private List <  Giftcatalog  >  listGiftcatalog;
	private Giftcatalog giftcatalog = new Giftcatalog();
	private String treestr="";
	private String str1="";
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String giftcatalog_name;
	
	
	/**
	 * 列表查询礼品目录
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if(giftcatalog_name != null && !"".equals(giftcatalog_name.trim())){
			where += " and " + Giftcatalog.COL_name + " like '%" + this.giftcatalog_name.trim() + "%'" ;
		}
		
	    List list = Server.getInstance().getSystemService().findAllGiftcatalogForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listGiftcatalog = list;
		  if(pageinfo.getTotalrow()>0 &&   listGiftcatalog.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getSystemService().findAllGiftcatalogForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listGiftcatalog = list;
		}
		
		return SUCCESS;
	}
   //生成目录编号
	public String createcode(){
		listGiftcatalog=Server.getInstance().getSystemService().findAllGiftcatalog("", "order by ID desc", -1, 0);
		String str ="";
		if(listGiftcatalog.size()>0){
			str=String.valueOf(listGiftcatalog.get(0).getId());
		}
		for(int i=0;i<5-str.length();i++){
			str1+="0";
		}
		str1+=str;
		return str1;
		}
	/**
	 * 转向到礼品目录添加页面
	 */	
	public String toadd()throws Exception{
		createcode();
		getString(-1l);
		return EDIT;
	}
	
	//根据ID查询父目录名称 2011-12-27 gaoliang
	public String getContentitemName(long id) {
		return Server.getInstance().getSystemService().findGiftcatalog(id).getName();
			
	}
	
	
	private void getString(long id) {
		List<Giftcatalog> list;
		String where = " WHERE  "
				+ Giftcatalog.COL_parentid + " = " + id;
      
    	list = Server.getInstance().getSystemService().findAllGiftcatalog(where, "ORDER BY ID", -1, 0);     
		if (!list.isEmpty()) {
			for (Giftcatalog m : list) {
				if (id == -1) {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "',  text:'" + m.getName() + "'});\n";
					treestr += "root.appendChild(sub_" + m.getId() + ");\n";
				} else {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "', text:'" + m.getName() + "'});\n";

					treestr += "sub_" + id + ".appendChild(sub_" + m.getId()
							+ ");\n";

				}
				getString(m.getId());
			}
		}
	}

	
	/**
	 * 转向到礼品目录修改页面
	 */	
	public String toedit()throws Exception{
		getString(-1l);
	    giftcatalog = Server.getInstance().getSystemService().findGiftcatalog(giftcatalog.getId());
	    str1=giftcatalog.getCode();
		return EDIT;
	}
	
	/**
	 * 转向到礼品目录审核页面
	 */	
	public String tocheck()throws Exception{
	giftcatalog = Server.getInstance().getSystemService().findGiftcatalog(giftcatalog.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加礼品目录
	 */		
	public String add()throws Exception{
	giftcatalog.setCreateuser(getLoginUser().getLoginname());
		giftcatalog.setCreatetime(new Timestamp(System.currentTimeMillis()));
		giftcatalog.setModifyuser(getLoginUser().getLoginname());
		giftcatalog.setModifytime(new Timestamp(System.currentTimeMillis()));
		if(giftcatalog.getParentid()==null){
			giftcatalog.setParentid(-1l);
		}
		giftcatalog=Server.getInstance().getSystemService().createGiftcatalog(giftcatalog);
		this.addActionMessage("您的操作已成功！");
		return EDIT;
	}

	/**
	 * 审核礼品目录
	 */		
	public String check()throws Exception{
	giftcatalog.setModifyuser(getLoginUser().getLoginname());
		giftcatalog.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getSystemService().updateGiftcatalogIgnoreNull(giftcatalog);
		return LIST;
	}
	
	/**
	 * 转向到地级市修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		
		Integer lan=giftcatalog.getLanguage();
		Long uco=giftcatalog.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		giftcatalog = Server.getInstance().getSystemService().findGiftcatalogbylanguage(giftcatalog.getUcode(),giftcatalog.getLanguage());
		if(giftcatalog==null)
		{
			giftcatalog=new Giftcatalog();
			giftcatalog.setLanguage(lan);
			giftcatalog.setUcode(uco);
			//以下是toadd参考方法
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
		}
		return EDIT;
	}

	/**
	 * 编辑礼品目录
	 */		
	public String edit()throws Exception{
	giftcatalog.setModifyuser(getLoginUser().getLoginname());
		giftcatalog.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getSystemService().updateGiftcatalogIgnoreNull(giftcatalog);
		this.addActionMessage("您的操作已成功！");
		return EDIT;
	}

	/**
	 * 删除礼品目录
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getSystemService().deleteGiftcatalog(giftcatalog.getId());
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
					Server.getInstance().getSystemService().deleteGiftcatalog(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回礼品目录对象
	 */		
	
	public Object getModel() {
		return giftcatalog;
	}
	public List < Giftcatalog >   getListGiftcatalog() {
		return listGiftcatalog;
	}
	public void setListGiftcatalog(List <  Giftcatalog  >  listGiftcatalog) {
		this.listGiftcatalog = listGiftcatalog;
	}
	public Giftcatalog getGiftcatalog() {
		return giftcatalog;
	}
	public void setGiftcatalog(Giftcatalog giftcatalog) {
		this.giftcatalog = giftcatalog;
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
	public String getGiftcatalog_name() {
		return giftcatalog_name;
	}
	public void setGiftcatalog_name(String giftcatalog_name) {
		this.giftcatalog_name = giftcatalog_name;
	}
	public String getTreestr() {
		return treestr;
	}
	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}
	public String getStr1() {
		return str1;
	}
	public void setStr1(String str1) {
		this.str1 = str1;
	}
	
	
}