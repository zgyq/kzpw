/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.text.SimpleDateFormat;
import java.util.List;
import java.io.File;
import java.sql.Timestamp;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;


import com.yf.system.back.server.Server;
import com.yf.system.base.spotlineimg.Spotlineimg;


public class SpotlineimgAction extends B2b2cbackAction {
	private List <  Spotlineimg  >  listSpotlineimg;
	private Spotlineimg spotlineimg = new Spotlineimg();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	private File[] files;
	private String filesContentType; 
	private String filesFileName; 
	
	//search
	//private String s_name;
	
	private long s_spotlineid;
	
	/**
	 * 列表查询景区线路图片信息
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if(s_spotlineid>0){
			where+=" AND "+Spotlineimg.COL_spotlineid+" ='"+s_spotlineid+"'";
			
		}
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Spotlineimg.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllSpotlineimgForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listSpotlineimg = list;
		  if(pageinfo.getTotalrow()>0 &&   listSpotlineimg.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllSpotlineimgForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listSpotlineimg = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到景区线路图片信息添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到景区线路图片信息修改页面
	 */	
	public String toedit()throws Exception{
	spotlineimg = Server.getInstance().getTripService().findSpotlineimg(spotlineimg.getId());
		return EDIT;
	}
	
	/**
	 * 转向到景区线路图片信息审核页面
	 */	
	public String tocheck()throws Exception{
	spotlineimg = Server.getInstance().getTripService().findSpotlineimg(spotlineimg.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加景区线路图片信息
	 */		
	public String add()throws Exception{
	
		if(null != files){
			String filePath = "/"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/" +s_spotlineid +"/";
			String realPath =getRealPath_bytype("uploadspotlinepath",filePath);
			
			System.out.println("realPath:"+realPath);
			
			File f = new File(realPath);
			if(!f.exists()){
				f.mkdirs();
			}
			System.out.println("文件真实路径" + f.getPath()+"/"+this.getFilesFileName());
			Util.copyfile(files[0],new File(f.getPath()+"/"+this.getFilesFileName()));
			String imagePath =  filePath + this.getFilesFileName();
			System.out.println("图片路径" + filePath+this.getFilesFileName());
			
			spotlineimg.setImgurl(imagePath);
		}
		spotlineimg.setSpotlineid(s_spotlineid+"");
		Server.getInstance().getTripService().createSpotlineimg(spotlineimg);
		return LIST;
	}

	/**
	 * 审核景区线路图片信息
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateSpotlineimgIgnoreNull(spotlineimg);
		return LIST;
	}
	


	/**
	 * 编辑景区线路图片信息
	 */		
	public String edit()throws Exception{
		if(null != files){
			String filePath = "/"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/" +s_spotlineid +"/";
			String realPath =getRealPath_bytype("uploadspotlinepath",filePath);
			
			System.out.println("realPath:"+realPath);
			File f = new File(realPath);
			if(!f.exists()){
				f.mkdirs();
			}
			System.out.println("文件真实路径" + f.getPath()+"/"+this.getFilesFileName());
			Util.copyfile(files[0],new File(f.getPath()+"/"+this.getFilesFileName()));
			String imagePath =  filePath + this.getFilesFileName();
			System.out.println("图片路径" + filePath+this.getFilesFileName());
			
			spotlineimg.setImgurl(imagePath);
		}
		
		Server.getInstance().getTripService().updateSpotlineimgIgnoreNull(spotlineimg);
		return LIST;
	}

	/**
	 * 删除景区线路图片信息
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getTripService().deleteSpotlineimg(spotlineimg.getId());
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
					Server.getInstance().getTripService().deleteSpotlineimg(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回景区线路图片信息对象
	 */		
	
	public Object getModel() {
		return spotlineimg;
	}
	public List < Spotlineimg >   getListSpotlineimg() {
		return listSpotlineimg;
	}
	public void setListSpotlineimg(List <  Spotlineimg  >  listSpotlineimg) {
		this.listSpotlineimg = listSpotlineimg;
	}
	public Spotlineimg getSpotlineimg() {
		return spotlineimg;
	}
	public void setSpotlineimg(Spotlineimg spotlineimg) {
		this.spotlineimg = spotlineimg;
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
	public long getS_spotlineid() {
		return s_spotlineid;
	}
	public void setS_spotlineid(long s_spotlineid) {
		this.s_spotlineid = s_spotlineid;
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