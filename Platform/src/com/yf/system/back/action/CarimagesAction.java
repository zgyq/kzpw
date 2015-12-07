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
import com.yf.system.base.carimages.Carimages;
import com.yf.system.base.cars.Cars;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;


public class CarimagesAction extends B2b2cbackAction {
	private List <  Carimages  >  listCarimages;
	private List <  Cars  >  listCars;
	private Carimages carimages = new Carimages();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	private int cid;
	//search
	private String s_name;
	private File[] c_image0;
	private File[] c_image1;
	private File[] c_image2;
	private File[] c_image3;
	private File[] c_image4;
	private String imagerpath;
	private String c_name0;
	private String c_name1;
	private String c_name2;
	private String c_name3;
	private String c_name4;
	/**
	 * 列表查询汽车图片
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		if(cid>0){
			where +=" AND "+Carimages.COL_carid+" ='"+cid+"'";
			
		}
		if (s_name!=null && s_name.trim().length()!=0) {
			
			where +="  AND "+Carimages.COL_carid+" in ( SELECT "+Cars.COL_id+" FROM "+Cars.TABLE+" where "+Cars.COL_name +" like '%" + s_name.trim()+"%')";	
			//where += " and " + Carimages.COL_name +" like '%" + s_name.trim()+"%'";	
		}
	
	    List list = Server.getInstance().getCarService().findAllCarimagesForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listCarimages = list;
		  if(pageinfo.getTotalrow()>0 &&   listCarimages.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getCarService().findAllCarimagesForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listCarimages = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到汽车图片添加页面
	 */	
	public String toadd()throws Exception{
		listCars = Server.getInstance().getCarService().findAllCars(" WHERE 1=1 "," ORDER BY ID DESC ", -1, 0);
		return EDIT;
	}
public String getImage(long Cid) {
		
		String where=" WHERE " + Carimages.COL_carid +" ="+Cid;
		List<Carimages> listImages = Server.getInstance().getCarService().findAllCarimages(where, "", -1, 0);
		if(listImages.size() > 0) {
			return listImages.get(0).getCarurl();
		}
		return "" ;
	}
	/**
	 * 转向到汽车图片修改页面
	 */	
	public String toedit()throws Exception{
	listCars = Server.getInstance().getCarService().findAllCars(" WHERE 1=1 "," ORDER BY ID DESC ", -1, 0);
		
	carimages = Server.getInstance().getCarService().findCarimages(carimages.getId());
		return EDIT;
	}
	
	/**
	 * 转向到汽车图片审核页面
	 */	
	public String tocheck()throws Exception{
	carimages = Server.getInstance().getCarService().findCarimages(carimages.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加汽车图片
	 */		
	public String add()throws Exception{
		//String[] c_names = c_name.trim().split(",");
		
		if(c_name0!=null&&c_name0.length()>0){
		carimages.setCreateuser(getLoginUser().getLoginname());
		carimages.setCreatetime(new Timestamp(System.currentTimeMillis()));
		carimages.setName(c_name0);
		//
		String filePath1 = "/CarImages/"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/"+carimages.getCarid()+"/";
		String realPath =getRealPath_tripline(filePath1);
		File s = new File(realPath);
		if(!s.exists()){
			s.mkdirs();
		}
		File f = new File("");
		if (c_image0 != null) {
			f = this.c_image0[0];
        String w = f.getName().toLowerCase();
			
			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			}else{
			String newname = Util.getFilename(f.getName());
			
			Util.copyfile(f, new File(s.getPath() + "/" + newname));
			
			carimages.setCarurl(filePath1 + newname);
		}
		}
		
		
		Server.getInstance().getCarService().createCarimages(carimages);
		}
		if(c_name1!=null&&c_name1.length()>0){
			carimages.setCreateuser(getLoginUser().getLoginname());
			carimages.setCreatetime(new Timestamp(System.currentTimeMillis()));
			carimages.setName(c_name1);
			//
			String filePath1 = "/CarImages/"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/"+carimages.getCarid()+"/";
			String realPath =getRealPath_tripline(filePath1);
			File s = new File(realPath);
			if(!s.exists()){
				s.mkdirs();
			}
			File f = new File("");
			if (c_image1 != null) {
				f = this.c_image1[0];
	        String w = f.getName().toLowerCase();
				
				if (!isIllegalfile(w)) {
					System.out.println("上传的不合法");
					return "nouplogo";
				}else{
				String newname = Util.getFilename(f.getName());
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
				carimages.setCarurl(filePath1 + newname);
			}
			}
			
			
			Server.getInstance().getCarService().createCarimages(carimages);
			}
		if(c_name2!=null&&c_name2.length()>0){
			carimages.setCreateuser(getLoginUser().getLoginname());
			carimages.setCreatetime(new Timestamp(System.currentTimeMillis()));
			carimages.setName(c_name2);
			//
			String filePath1 = "/CarImages/"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/"+carimages.getCarid()+"/";
			String realPath =getRealPath_tripline(filePath1);
			File s = new File(realPath);
			if(!s.exists()){
				s.mkdirs();
			}
			File f = new File("");
			if (c_image2 != null) {
				f = this.c_image2[0];
	        String w = f.getName().toLowerCase();
				
				if (!isIllegalfile(w)) {
					System.out.println("上传的不合法");
					return "nouplogo";
				}else{
				String newname = Util.getFilename(f.getName());
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
				carimages.setCarurl(filePath1 + newname);
			}
			}
			
			
			Server.getInstance().getCarService().createCarimages(carimages);
			}
		if(c_name3!=null&&c_name3.length()>0){
			carimages.setCreateuser(getLoginUser().getLoginname());
			carimages.setCreatetime(new Timestamp(System.currentTimeMillis()));
			carimages.setName(c_name3);
			//
			String filePath1 = "/CarImages/"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/"+carimages.getCarid()+"/";
			String realPath =getRealPath_tripline(filePath1);
			File s = new File(realPath);
			if(!s.exists()){
				s.mkdirs();
			}
			File f = new File("");
			if (c_image3 != null) {
				f = this.c_image3[0];
	        String w = f.getName().toLowerCase();
				
				if (!isIllegalfile(w)) {
					System.out.println("上传的不合法");
					return "nouplogo";
				}else{
				String newname = Util.getFilename(f.getName());
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
				carimages.setCarurl(filePath1 + newname);
			}
			}
			
			
			Server.getInstance().getCarService().createCarimages(carimages);
			}
		if(c_name4!=null&&c_name4.length()>0){
			carimages.setCreateuser(getLoginUser().getLoginname());
			carimages.setCreatetime(new Timestamp(System.currentTimeMillis()));
			carimages.setName(c_name4);
			//
			String filePath1 = "/CarImages/"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/"+carimages.getCarid()+"/";
			String realPath =getRealPath_tripline(filePath1);
			File s = new File(realPath);
			if(!s.exists()){
				s.mkdirs();
			}
			File f = new File("");
			if (c_image4 != null) {
				f = this.c_image4[0];
	        String w = f.getName().toLowerCase();
				
				if (!isIllegalfile(w)) {
					System.out.println("上传的不合法");
					return "nouplogo";
				}else{
				String newname = Util.getFilename(f.getName());
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
				carimages.setCarurl(filePath1 + newname);
			}
			}
			
			
			Server.getInstance().getCarService().createCarimages(carimages);
			}
		
		/*for (int i = 0; i < c_names.length; i++) {
			if(c_names[i]!=null && !c_names[i].toString().equals(" ")){
				
				
				}
		}*/
		return LIST;
	}
	private static String[] fileStrs = { "gif", "jpg" };
	private boolean isIllegalfile(String filename) {
		int count = 0;
		for (String str : fileStrs) {
			if (!filename.endsWith(str)) {
				count++;
			}
		}
		if (count < fileStrs.length) {
			return true;
		}
		// 如果计数器等于过滤个数，放弃此次操作
		return false;
	}
	public String getimgPath()
	{
		return ((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='weppath'","",-1,0).get(0)).getValue()+"/";
	}
	/**
	 * 审核汽车图片
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getCarService().updateCarimagesIgnoreNull(carimages);
		return LIST;
	}
	


	/**
	 * 编辑汽车图片
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getCarService().updateCarimagesIgnoreNull(carimages);
		return LIST;
	}

	/**
	 * 删除汽车图片
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getCarService().deleteCarimages(carimages.getId());
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
					Server.getInstance().getCarService().deleteCarimages(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回汽车图片对象
	 */		
	
	public Object getModel() {
		return carimages;
	}
	public List < Carimages >   getListCarimages() {
		return listCarimages;
	}
	public void setListCarimages(List <  Carimages  >  listCarimages) {
		this.listCarimages = listCarimages;
	}
	public Carimages getCarimages() {
		return carimages;
	}
	public void setCarimages(Carimages carimages) {
		this.carimages = carimages;
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





	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getImagerpath() {
		return imagerpath;
	}
	public void setImagerpath(String imagerpath) {
		this.imagerpath = imagerpath;
	}
	public File[] getC_image0() {
		return c_image0;
	}
	public void setC_image0(File[] c_image0) {
		this.c_image0 = c_image0;
	}
	public File[] getC_image1() {
		return c_image1;
	}
	public void setC_image1(File[] c_image1) {
		this.c_image1 = c_image1;
	}
	public File[] getC_image2() {
		return c_image2;
	}
	public void setC_image2(File[] c_image2) {
		this.c_image2 = c_image2;
	}
	public File[] getC_image3() {
		return c_image3;
	}
	public void setC_image3(File[] c_image3) {
		this.c_image3 = c_image3;
	}
	public File[] getC_image4() {
		return c_image4;
	}
	public void setC_image4(File[] c_image4) {
		this.c_image4 = c_image4;
	}
	public String getC_name0() {
		return c_name0;
	}
	public void setC_name0(String c_name0) {
		this.c_name0 = c_name0;
	}
	public String getC_name1() {
		return c_name1;
	}
	public void setC_name1(String c_name1) {
		this.c_name1 = c_name1;
	}
	public String getC_name2() {
		return c_name2;
	}
	public void setC_name2(String c_name2) {
		this.c_name2 = c_name2;
	}
	public String getC_name3() {
		return c_name3;
	}
	public void setC_name3(String c_name3) {
		this.c_name3 = c_name3;
	}
	public String getC_name4() {
		return c_name4;
	}
	public void setC_name4(String c_name4) {
		this.c_name4 = c_name4;
	}
	public List<Cars> getListCars() {
		return listCars;
	}
	public void setListCars(List<Cars> listCars) {
		this.listCars = listCars;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	
	
}