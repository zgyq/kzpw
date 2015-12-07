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
import com.yf.system.base.buyingimg.Buyingimg;


public class BuyingimgAction extends B2b2cbackAction {
	private List <  Buyingimg  >  listBuyingimg;
	private Buyingimg buyingimg = new Buyingimg();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	private File[] files;
	private String filesContentType; 
	private String filesFileName; 
	private long s_buyingid;//
	private String forword; 
	//search
	//private String s_name;
	
	/**
	 * 列表查询团购图片信息
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		if(s_buyingid>0){
			where+=" AND "+Buyingimg.COL_buyingid+" ="+s_buyingid;
		}
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Buyingimg.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getTripService().findAllBuyingimgForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listBuyingimg = list;
		  if(pageinfo.getTotalrow()>0 &&   listBuyingimg.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService().findAllBuyingimgForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listBuyingimg = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到团购图片信息添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到团购图片信息修改页面
	 */	
	public String toedit()throws Exception{
	buyingimg = Server.getInstance().getTripService().findBuyingimg(buyingimg.getId());
		return EDIT;
	}
	
	/**
	 * 转向到团购图片信息审核页面
	 */	
	public String tocheck()throws Exception{
	buyingimg = Server.getInstance().getTripService().findBuyingimg(buyingimg.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加团购图片信息
	 */		
	public String add()throws Exception{
		if(null != files){
			String filePath = "/"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/" +s_buyingid +"/";
			String realPath =getRealPath_bytype("uploadbuyingpath",filePath);
			
			System.out.println("realPath:"+realPath);
			
			File f = new File(realPath);
			if(!f.exists()){
				f.mkdirs();
			}
			System.out.println("文件真实路径" + f.getPath()+"/"+this.getFilesFileName());
			Util.copyfile(files[0],new File(f.getPath()+"/"+this.getFilesFileName()));
			String imagePath =  filePath + this.getFilesFileName();
			System.out.println("图片路径" + filePath+this.getFilesFileName());
			
			buyingimg.setBuyingid(s_buyingid);
			buyingimg.setImgurl(imagePath);
		}

		
		Server.getInstance().getTripService().createBuyingimg(buyingimg);
		return LIST;
	}

	/**
	 * 审核团购图片信息
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getTripService().updateBuyingimgIgnoreNull(buyingimg);
		return LIST;
	}
	


	/**
	 * 编辑团购图片信息
	 */		
	public String edit()throws Exception{
		if(null != files){
			String filePath = "/"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/" +s_buyingid +"/";
			String realPath =getRealPath_bytype("uploadbuyingpath",filePath);
			
			System.out.println("realPath:"+realPath);
			
			File f = new File(realPath);
			if(!f.exists()){
				f.mkdirs();
			}
			System.out.println("文件真实路径" + f.getPath()+"/"+this.getFilesFileName());
			Util.copyfile(files[0],new File(f.getPath()+"/"+this.getFilesFileName()));
			String imagePath =  filePath + this.getFilesFileName();
			System.out.println("图片路径" + filePath+this.getFilesFileName());
			
			
			buyingimg.setImgurl(imagePath);
		}
		Server.getInstance().getTripService().updateBuyingimgIgnoreNull(buyingimg);
		return LIST;
	}

	/**
	 * 删除团购图片信息
	 */		
	public String delete()throws Exception{	
		Buyingimg img=Server.getInstance().getTripService().findBuyingimg(buyingimg.getId());
		forword="buyingimg.action?s_buyingid="+img.getBuyingid();
		Server.getInstance().getTripService().deleteBuyingimg(buyingimg.getId());
		
		return "forword";
	}
	public String GetBuyingnameByid(long id)throws Exception{
		return Server.getInstance().getTripService().findBuying(id).getName();
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
					Server.getInstance().getTripService().deleteBuyingimg(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回团购图片信息对象
	 */		
	
	public Object getModel() {
		return buyingimg;
	}
	public List < Buyingimg >   getListBuyingimg() {
		return listBuyingimg;
	}
	public void setListBuyingimg(List <  Buyingimg  >  listBuyingimg) {
		this.listBuyingimg = listBuyingimg;
	}
	public Buyingimg getBuyingimg() {
		return buyingimg;
	}
	public void setBuyingimg(Buyingimg buyingimg) {
		this.buyingimg = buyingimg;
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
	

	
	public long getS_buyingid() {
		return s_buyingid;
	}
	public void setS_buyingid(long s_buyingid) {
		this.s_buyingid = s_buyingid;
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
	public String getForword() {
		return forword;
	}
	public void setForword(String forword) {
		this.forword = forword;
	}
}