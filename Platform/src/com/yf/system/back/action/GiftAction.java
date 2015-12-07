/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.gift.Gift;
import com.yf.system.base.giftcatalog.Giftcatalog;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;


public class GiftAction extends B2b2cbackAction {

	private static final long serialVersionUID = -6201903758059091398L;
	private List <  Gift  >  listGift;
	private Gift gift = new Gift();
	private String treestr="";
	private List<Giftcatalog> listGiftcatalog=new ArrayList<Giftcatalog>();
	private Giftcatalog giftcatalog;
	private long giftcatalogid;
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String giftname;
	
	//礼品图片
	private File[] files;
	private String filesContentType; 
	private String filesFileName; 
	
	
	/**
	 * 通过ID获取礼品目录
	 */
	public Giftcatalog getGiftcatalogbyid(long id)
	{
		return Server.getInstance().getSystemService().findGiftcatalog(id);
	}
	
	/**
	 * 列表查询礼品
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (giftname!=null && !"".equals(giftname.trim())) {
			where += " and " + Gift.COL_name +" like '%" + giftname.trim()+"%'";
		}
		System.out.println(where);
	    List list = Server.getInstance().getSystemService().findAllGiftForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listGift = list;
		  if(pageinfo.getTotalrow()>0 &&   listGift.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getSystemService().findAllGiftForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listGift = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到礼品添加页面
	 */	
	public String toadd()throws Exception{
		getString(-1l);
		//listGiftcatalog=Server.getInstance().getSystemService().findAllGiftcatalog(" where "+Giftcatalog.COL_state+" = 0", "", -1, 0);
		return EDIT;
	}
	//根据ID查询父目录名称 2011-12-27 gaoliang
	public String getContentitemName(long id) {
		return Server.getInstance().getSystemService().findGiftcatalog(id).getName();
			
	}
	
	private void getString(long id) {
		List<Giftcatalog> list;
		System.out.println("循环进来");
		String where = " WHERE  "
				+ Giftcatalog.COL_parentid + " = " + id;
    	list = Server.getInstance().getSystemService().findAllGiftcatalog(where, "ORDER BY ID", -1, 0);
		System.out.println(list.size()+"内容");
		if (!list.isEmpty()) {
			for (Giftcatalog m : list) {
				if (id == -1) {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "',text:'" + m.getName() + "'});\n";
					treestr += "root.appendChild(sub_" + m.getId() + ");\n";
				} else {
					treestr += "var sub_" + m.getId()
							+ " = new Ext.tree.TreeNode({ id:'" + m.getId()
							+ "', text:'" + m.getName() + "'});\n";

					treestr += "sub_" + id + ".appendChild(sub_" + m.getId()
							+ ");\n";

				}
				getString(m.getId());
				System.out.println(m.getId()+"ID");
			}
		}
	}
	/**
	 * 转向到礼品修改页面
	 */	
	public String toedit()throws Exception{
	getString(-1l);
	gift = Server.getInstance().getSystemService().findGift(gift.getId());
	//giftcatalog = Server.getInstance().getSystemService().findGiftcatalog(gift.getGiftcatalogid());
	//gift.setPicsrc(gift.getPicsrc());
	if(gift != null){
		gift.setPicsrc(this.getImgPath(gift.getPicsrc()));
	}
	
	return EDIT;
	}
	
	/**
	 * 转向到礼品审核页面
	 */	
	public String tocheck()throws Exception{
	gift = Server.getInstance().getSystemService().findGift(gift.getId());
		return CHECK;
	}
	/**
	 * 转向到地级市修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		
		Integer lan=gift.getLanguage();
		Long uco=gift.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		gift = Server.getInstance().getSystemService().findGiftbylanguage(gift.getUcode(),gift.getLanguage());
		if(gift==null)
		{
			gift=new Gift();
			gift.setLanguage(lan);
			gift.setUcode(uco);
			listGiftcatalog=Server.getInstance().getSystemService().findAllGiftcatalog(" where "+Giftcatalog.COL_state+" = 0", "", -1, 0);
			//以下是toadd参考方法
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			if(gift != null){
				gift.setPicsrc(this.getImgPath(gift.getPicsrc()));
			}
			listGiftcatalog=Server.getInstance().getSystemService().findAllGiftcatalog(" where "+Giftcatalog.COL_state+" = 0", "", -1, 0);
		}
		return EDIT;
	}
	
	/**
	 * 添加礼品
	 */		
	public String add()throws Exception{
	    gift.setCreateuser(getLoginUser().getLoginname());
		gift.setCreatetime(new Timestamp(System.currentTimeMillis()));
		gift.setModifyuser(getLoginUser().getLoginname());
		gift.setModifytime(new Timestamp(System.currentTimeMillis()));
		//设置图片
		
		if(files != null && files.length>0){
			String imagePath = this.saveImage(files);
			gift.setPicsrc(imagePath);
		}
		gift=Server.getInstance().getSystemService().createGift(gift);
		//this.addActionMessage("添加成功！");
		return this.execute();
	}
	/**
	 * 保存图片
	 * @return	返回图片的保存路径
	 */
	private String saveImage(File[] files){
		String filePath = "/giftimage/" ;
		String realPath =getRealPath(filePath);
		File f = new File(realPath);
		if(!f.exists()){
			f.mkdirs();
		}
		System.out.println("文件真实路径" + f.getPath()+"/"+this.getFilesFileName());
		Util.copyfile(files[0],new File(f.getPath()+"/"+this.getFilesFileName()));
		//System.out.println("图片路径" + filePath+this.getFilesFileName());
		return filePath + this.getFilesFileName();
	}

	/**
	 * 审核礼品
	 */		
	public String check()throws Exception{
	gift.setModifyuser(getLoginUser().getLoginname());
		gift.setModifytime(new Timestamp(System.currentTimeMillis()));
		
		Server.getInstance().getSystemService().updateGiftIgnoreNull(gift);
		return LIST;
	}
	


	/**
	 * 编辑礼品
	 */		
	public String edit()throws Exception{
	gift.setModifyuser(getLoginUser().getLoginname());
		gift.setModifytime(new Timestamp(System.currentTimeMillis()));
		if(files != null && files.length>0){
			String imagePath = this.saveImage(files);
			gift.setPicsrc(imagePath);
			System.out.println("图片路径" + imagePath);
		}
		Server.getInstance().getSystemService().updateGiftIgnoreNull(gift);
		this.addActionMessage("添加成功！");
		return this.execute();
	}

	/**
	 * 删除礼品
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getSystemService().deleteGift(gift.getId());
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
					Server.getInstance().getSystemService().deleteGift(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回礼品对象
	 */		
	
	public Object getModel() {
		return gift;
	}
	public List < Gift >   getListGift() {
		return listGift;
	}
	public void setListGift(List <  Gift  >  listGift) {
		this.listGift = listGift;
	}
	public Gift getGift() {
		return gift;
	}
	public void setGift(Gift gift) {
		this.gift = gift;
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
	public List<Giftcatalog> getListGiftcatalog() {
		return listGiftcatalog;
	}
	public void setListGiftcatalog(List<Giftcatalog> listGiftcatalog) {
		this.listGiftcatalog = listGiftcatalog;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String getFilesContentType() {
		return filesContentType;
	}

	public void setFilesContentType(String filesContentType) {
		this.filesContentType = filesContentType;
	}

	public String getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String filesFileName) {
		this.filesFileName = filesFileName;
	}

	public String getGiftname() {
		return giftname;
	}

	public void setGiftname(String giftname) {
		this.giftname = giftname;
	}

	public String getTreestr() {
		return treestr;
	}

	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}

	public Giftcatalog getGiftcatalog() {
		return giftcatalog;
	}

	public void setGiftcatalog(Giftcatalog giftcatalog) {
		this.giftcatalog = giftcatalog;
	}

	public long getGiftcatalogid() {
		return giftcatalogid;
	}

	public void setGiftcatalogid(long giftcatalogid) {
		this.giftcatalogid = giftcatalogid;
	}
}