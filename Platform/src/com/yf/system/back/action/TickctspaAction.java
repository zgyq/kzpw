/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.io.File;
import java.sql.Timestamp;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.tickctspa.Tickctspa;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;


public class TickctspaAction extends B2b2cbackAction {
	private List <  Tickctspa  >  listTickctspa;
	private Tickctspa tickctspa = new Tickctspa();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_name;
	
	private File[] files;
	private File[] files2;
	private File[] files3;
	private String filesContentType; 
	private String filesFileName; 
	
	
	/**
	 * 列表查询票务温泉
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (s_name!=null && s_name.trim().length()!=0) {
			
			where += " and " + Tickctspa.COL_name +" like '%" + s_name.trim()+"%'";	
		}
	
	    List list = Server.getInstance().getTripService().findAllTickctspaForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listTickctspa = list;
		  if(pageinfo.getTotalrow()>0 &&   listTickctspa.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllTickctspaForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listTickctspa = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到票务温泉添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到票务温泉修改页面
	 */	
	public String toedit()throws Exception{
		
	tickctspa = Server.getInstance().getTripService().findTickctspa(tickctspa.getId());
	/*if(tickctspa != null&&tickctspa.getPic()!=null){
		tickctspa.setPic(this.getImgPath(tickctspa.getPic()));
	}
	if(tickctspa != null&&tickctspa.getPic2()!=null){
		tickctspa.setPic2(this.getImgPath(tickctspa.getPic2()));
	}
	if(tickctspa != null&&tickctspa.getPic3()!=null){
		tickctspa.setPic3(this.getImgPath(tickctspa.getPic3()));
	}*/
		return EDIT;
	}
	
	/**
	 * 转向到票务温泉审核页面
	 */	
	public String tocheck()throws Exception{
	tickctspa = Server.getInstance().getTripService().findTickctspa(tickctspa.getId());
		return CHECK;
	}
	
	/**
	 * 转向到地级市修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		
		Integer lan=tickctspa.getLanguage();
		Long uco=tickctspa.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		tickctspa = Server.getInstance().getTripService().findTickctspabylanguage(tickctspa.getUcode(),tickctspa.getLanguage());
		if(tickctspa==null)
		{
			tickctspa=new Tickctspa();
			tickctspa.setLanguage(lan);
			tickctspa.setUcode(uco);
			//以下是toadd参考方法
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			}
		return EDIT;
	}
	/**
	 * 添加票务温泉
	 */		
	public String add()throws Exception{
		if(files != null && files.length>0){
			String imagePath = this.saveImage(files);
			tickctspa.setPic(imagePath);
		}
		if(files2 != null && files2.length>0){
			String imagePath = this.saveImage(files2);
			tickctspa.setPic2(imagePath);
		}
		if(files3 != null && files3.length>0){
			String imagePath = this.saveImage(files3);
			tickctspa.setPic3(imagePath);
		}
		tickctspa.setCreatetime(new Timestamp(System.currentTimeMillis()));
		tickctspa.setCreateuser(getLoginUser().getLoginname());
		tickctspa.setModifytime(new Timestamp(System.currentTimeMillis()));
		tickctspa.setModifyuser(getLoginUser().getLoginname());
		
		tickctspa=Server.getInstance().getTripService().createTickctspa(tickctspa);
		this.addActionMessage("添加成功！");
		return EDIT;
	}
	/**
	 * 保存图片
	 * @return	返回图片的保存路径
	 */
	private String saveImage(File[] files){
		
		String filePath = "/tickctspa/" ;
		String realPath =getRealPath(filePath);
		File f = new File(realPath);
		if(!f.exists()){
			f.mkdirs();
		}
		String filetype=files[0].getName().substring(files[0].getName().lastIndexOf('.'));
		String newname=new Timestamp(System.currentTimeMillis()).getTime()+filetype;
		Util.copyfile(files[0],new File(f.getPath()+"/"+newname));
		
		return filePath + newname;
	}
	/**
	 * 审核票务温泉
	 */		
	public String check()throws Exception{
	tickctspa.setModifytime(new Timestamp(System.currentTimeMillis()));
		tickctspa.setModifyuser(getLoginUser().getLoginname());
		
		Server.getInstance().getTripService().updateTickctspaIgnoreNull(tickctspa);
		return LIST;
	}
	


	/**
	 * 编辑票务温泉
	 */		
	public String edit()throws Exception{
		if(files != null && files.length>0){
			String imagePath = this.saveImage(files);
			tickctspa.setPic(imagePath);
		}
		if(files2 != null && files3.length>0){
			String imagePath2 = this.saveImage(files2);
			tickctspa.setPic2(imagePath2);
		}
		if(files3 != null && files3.length>0){
			String imagePath3 = this.saveImage(files3);
			tickctspa.setPic3(imagePath3);
		}
		tickctspa.setModifytime(new Timestamp(System.currentTimeMillis()));
		tickctspa.setModifyuser(getLoginUser().getLoginname());
		
		Server.getInstance().getTripService().updateTickctspaIgnoreNull(tickctspa);
		this.addActionMessage("添加成功！");
		return EDIT;
	}

	/**
	 * 删除票务温泉
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteTickctspa(tickctspa.getId());
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
					Server.getInstance().getTripService().deleteTickctspa(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回票务温泉对象
	 */		
	
	public Object getModel() {
		return tickctspa;
	}
	public List < Tickctspa >   getListTickctspa() {
		return listTickctspa;
	}
	public void setListTickctspa(List <  Tickctspa  >  listTickctspa) {
		this.listTickctspa = listTickctspa;
	}
	public Tickctspa getTickctspa() {
		return tickctspa;
	}
	public void setTickctspa(Tickctspa tickctspa) {
		this.tickctspa = tickctspa;
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
	public File[] getFiles2() {
		return files2;
	}
	public void setFiles2(File[] files2) {
		this.files2 = files2;
	}
	public File[] getFiles3() {
		return files3;
	}
	public void setFiles3(File[] files3) {
		this.files3 = files3;
	}
	
	
}