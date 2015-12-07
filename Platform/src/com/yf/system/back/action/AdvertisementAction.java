/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.advertisement.Advertisement;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;


public class AdvertisementAction extends B2b2cbackAction {
	private List <  Advertisement  >  listAdvertisement;
	private Advertisement advertisement = new Advertisement();
	
	//批量操作ID数组
	private int[]selectid;
	

	
	
	//批量操作选项
	private int opt;
	
	private File[] imgfile;
	//search
	//private String s_name;
	
	
	
	/**
	 * 列表查询广告表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Advertisement.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getSystemService().findAllAdvertisementForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listAdvertisement = list;
		  if(pageinfo.getTotalrow()>0 &&   listAdvertisement.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getSystemService().findAllAdvertisementForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listAdvertisement = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到广告表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到广告表修改页面
	 */	
	public String toedit()throws Exception{
	advertisement = Server.getInstance().getSystemService().findAdvertisement(advertisement.getId());
		return EDIT;
	}
	
	/**
	 * 转向到广告表审核页面
	 */	
	public String tocheck()throws Exception{
	advertisement = Server.getInstance().getSystemService().findAdvertisement(advertisement.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加广告表
	 */		
	public String add()throws Exception{
	
		String s=this.getlogoPath();
		if(imgfile !=null && imgfile[0]!=null){
			File file = imgfile[0];
			String filetype=file.getName().substring(file.getName().lastIndexOf('.'));
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddhhmmsss");
			String newname=dateFormat.format(new Timestamp(System.currentTimeMillis()))+filetype;
			System.out.println(newname);
			Util.copyfile(file, new File(s+ "/" + newname));
			advertisement.setPicsrc(newname);
		}
		Server.getInstance().getSystemService().createAdvertisement(advertisement);
		return LIST;
	}

	/**
	 * 审核广告表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getSystemService().updateAdvertisementIgnoreNull(advertisement);
		return LIST;
	}
	


	/**
	 * 编辑广告表
	 */		
	public String edit()throws Exception{
	
		String s=this.getlogoPath();
		if(imgfile !=null && imgfile[0]!=null){
			File file = imgfile[0];
			String filetype=file.getName().substring(file.getName().lastIndexOf('.'));
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddhhmmsss");
			String newname=dateFormat.format(new Timestamp(System.currentTimeMillis()))+getLoginUserId()+filetype;
			System.out.println(newname);
			Util.copyfile(file, new File(s+ "/" + newname));
			advertisement.setPicsrc(newname);
		}
		Server.getInstance().getSystemService().updateAdvertisementIgnoreNull(advertisement);
		return LIST;
	}

	/**
	 * 删除广告表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getSystemService().deleteAdvertisement(advertisement.getId());
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
					Server.getInstance().getSystemService().deleteAdvertisement(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回广告表对象
	 */		
	
	public Object getModel() {
		return advertisement;
	}
	public List < Advertisement >   getListAdvertisement() {
		return listAdvertisement;
	}
	public void setListAdvertisement(List <  Advertisement  >  listAdvertisement) {
		this.listAdvertisement = listAdvertisement;
	}
	public Advertisement getAdvertisement() {
		return advertisement;
	}
	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
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
	public File[] getImgfile() {
		return imgfile;
	}
	public void setImgfile(File[] imgfile) {
		this.imgfile = imgfile;
	}
	
	
}