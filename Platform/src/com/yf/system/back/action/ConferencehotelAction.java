/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.io.File;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.conferencehotel.Conferencehotel;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;



public class ConferencehotelAction extends B2b2cbackAction {
	private List <  Conferencehotel  >  listConferencehotel;
	private Conferencehotel conferencehotel = new Conferencehotel();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_name;
	
	private File[] files;
	private String filesContentType; 
	private String filesFileName; 
	
	
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
	public File[] getFiles() {
		return files;
	}
	public void setFiles(File[] files) {
		this.files = files;
	}
	/**
	 * 列表查询会议酒店
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (s_name!=null && s_name.trim().length()!=0) {
			where += " and " + Conferencehotel.COL_name +" like '%" + s_name.trim()+"%'";	
		}
	    List list = Server.getInstance().getTripService().findAllConferencehotelForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listConferencehotel = list;
		  if(pageinfo.getTotalrow()>0 &&   listConferencehotel.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllConferencehotelForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listConferencehotel = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到会议酒店添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到会议酒店修改页面
	 */	
	public String toedit()throws Exception{
	conferencehotel = Server.getInstance().getTripService().findConferencehotel(conferencehotel.getId());
	if(conferencehotel != null){
		conferencehotel.setPic(this.getImgPath(conferencehotel.getPic()));
	}
		return EDIT;
	}
	
	/**
	 * 转向到会议酒店审核页面
	 */	
	public String tocheck()throws Exception{
	conferencehotel = Server.getInstance().getTripService().findConferencehotel(conferencehotel.getId());
		return CHECK;
	}
	/**
	 * 转向到地级市修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		
		Integer lan=conferencehotel.getLanguage();
		Long uco=conferencehotel.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		conferencehotel = Server.getInstance().getTripService().findConferencehotelbylanguage(conferencehotel.getUcode(),conferencehotel.getLanguage());
		if(conferencehotel==null)
		{
			conferencehotel=new Conferencehotel();
			conferencehotel.setLanguage(lan);
			conferencehotel.setUcode(uco);
			//以下是toadd参考方法
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			}
		return EDIT;
	}
	
	/**
	 * 添加会议酒店
	 */		
	public String add()throws Exception{
		if(files != null && files.length>0){
			String imagePath = this.saveImage(files);
			conferencehotel.setPic(imagePath);
		}
		conferencehotel=Server.getInstance().getTripService().createConferencehotel(conferencehotel);
		this.addActionMessage("添加成功！");
		return EDIT;
	}

	/**
	 * 保存图片
	 * @return	返回图片的保存路径
	 */
	private String saveImage(File[] files){
		String filePath = "/conferencehotel/" ;
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
	 * 审核会议酒店
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateConferencehotelIgnoreNull(conferencehotel);
		return LIST;
	}
	


	/**
	 * 编辑会议酒店
	 */		
	public String edit()throws Exception{
		if(files != null && files.length>0){
			String imagePath = this.saveImage(files);
			conferencehotel.setPic(imagePath);
			System.out.println("图片路径" + imagePath);
		}
		Server.getInstance().getTripService().updateConferencehotelIgnoreNull(conferencehotel);
		this.addActionMessage("添加成功！");
		return EDIT;
	}

	/**
	 * 删除会议酒店
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteConferencehotel(conferencehotel.getId());
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
					Server.getInstance().getTripService().deleteConferencehotel(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回会议酒店对象
	 */		
	
	public Object getModel() {
		return conferencehotel;
	}
	public List < Conferencehotel >   getListConferencehotel() {
		return listConferencehotel;
	}
	public void setListConferencehotel(List <  Conferencehotel  >  listConferencehotel) {
		this.listConferencehotel = listConferencehotel;
	}
	public Conferencehotel getConferencehotel() {
		return conferencehotel;
	}
	public void setConferencehotel(Conferencehotel conferencehotel) {
		this.conferencehotel = conferencehotel;
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
	
	
}