/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.util.List;
import java.io.File;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;


import com.yf.system.back.server.Server;
import com.yf.system.base.conferencehall.Conferencehall;
import com.yf.system.base.conferencehotel.Conferencehotel;


public class ConferencehallAction extends B2b2cbackAction {
	private List <  Conferencehall  >  listConferencehall;
	private Conferencehall conferencehall = new Conferencehall();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private String s_name;
	
	private File[] files;
	private String filesContentType; 
	private String filesFileName; 
	
	private List<Conferencehotel> listConferencehotel;
	
	public List<Conferencehotel> getListConferencehotel() {
		return listConferencehotel;
	}
	public void setListConferencehotel(List<Conferencehotel> listConferencehotel) {
		this.listConferencehotel = listConferencehotel;
	}
	/**
	 * 列表查询会议厅
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (s_name!=null && s_name.trim().length()!=0) {
			where += " and " + Conferencehall.COL_type +" like '%" + s_name.trim()+"%'";	
		}
	
	    List list = Server.getInstance().getTripService().findAllConferencehallForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listConferencehall = list;
		  if(pageinfo.getTotalrow()>0 &&   listConferencehall.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllConferencehallForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listConferencehall = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到会议厅添加页面
	 */	
	public String toadd()throws Exception{
		listConferencehotel=Server.getInstance().getTripService().findAllConferencehotel("", "", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到会议厅修改页面
	 */	
	public String toedit()throws Exception{
		listConferencehotel=Server.getInstance().getTripService().findAllConferencehotel("", "", -1, 0);
		conferencehall = Server.getInstance().getTripService().findConferencehall(conferencehall.getId());
		/*if(conferencehall != null){
			conferencehall.setPic(this.getImgPath(conferencehall.getPic()));
		}*/
		return EDIT;
	}
	
	/**
	 * 转向到会议厅审核页面
	 */	
	public String tocheck()throws Exception{
	conferencehall = Server.getInstance().getTripService().findConferencehall(conferencehall.getId());
		return CHECK;
	}
	/**
	 * 转向到地级市修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		
		Integer lan=conferencehall.getLanguage();
		Long uco=conferencehall.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		conferencehall = Server.getInstance().getTripService().findConferencehallbylanguage(conferencehall.getUcode(),conferencehall.getLanguage());
		if(conferencehall==null)
		{
			listConferencehotel=Server.getInstance().getTripService().findAllConferencehotel("", "", -1, 0);
			conferencehall=new Conferencehall();
			conferencehall.setLanguage(lan);
			conferencehall.setUcode(uco);
			//以下是toadd参考方法
		}else
		{
			listConferencehotel=Server.getInstance().getTripService().findAllConferencehotel("", "", -1, 0);
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			}
		return EDIT;
	}
	
	/**
	 * 添加会议厅
	 */		
	public String add()throws Exception{
		if(files != null && files.length>0){
			String imagePath = this.saveImage(files);
			conferencehall.setPic(imagePath);
		}
		conferencehall.setCreatetime(new Timestamp(System.currentTimeMillis()));
		conferencehall.setCreateuser(getLoginUser().getLoginname());
		conferencehall.setModifytime(new Timestamp(System.currentTimeMillis()));
		conferencehall.setModifyuser(getLoginUser().getLoginname());
		
		conferencehall=Server.getInstance().getTripService().createConferencehall(conferencehall);
		this.addActionMessage("添加成功！");
		return EDIT;
	}
	/**
	 * 保存图片
	 * @return	返回图片的保存路径
	 */
	private String saveImage(File[] files){
		String filePath = "/conferencehall/" ;
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
	 * 审核会议厅
	 */		
	public String check()throws Exception{
	conferencehall.setModifytime(new Timestamp(System.currentTimeMillis()));
		conferencehall.setModifyuser(getLoginUser().getLoginname());
		
		Server.getInstance().getTripService().updateConferencehallIgnoreNull(conferencehall);
		return LIST;
	}
	


	/**
	 * 编辑会议厅
	 */		
	public String edit()throws Exception{
		if(files != null && files.length>0){
			String imagePath = this.saveImage(files);
			conferencehall.setPic(imagePath);
			System.out.println("图片路径" + imagePath);
		}
	conferencehall.setModifytime(new Timestamp(System.currentTimeMillis()));
		conferencehall.setModifyuser(getLoginUser().getLoginname());
		
		Server.getInstance().getTripService().updateConferencehallIgnoreNull(conferencehall);
		this.addActionMessage("添加成功！");
		return EDIT;
	}

	/**
	 * 删除会议厅
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteConferencehall(conferencehall.getId());
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
					Server.getInstance().getTripService().deleteConferencehall(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回会议厅对象
	 */		
	
	public Object getModel() {
		return conferencehall;
	}
	public List < Conferencehall >   getListConferencehall() {
		return listConferencehall;
	}
	public void setListConferencehall(List <  Conferencehall  >  listConferencehall) {
		this.listConferencehall = listConferencehall;
	}
	public Conferencehall getConferencehall() {
		return conferencehall;
	}
	public void setConferencehall(Conferencehall conferencehall) {
		this.conferencehall = conferencehall;
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
	
	
}