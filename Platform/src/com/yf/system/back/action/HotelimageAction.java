/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/14 创建
 *
 */
 
package com.yf.system.back.action;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import com.yf.system.back.server.Server;
import com.yf.system.base.hotel.Hotel;
import com.yf.system.base.hotelimage.Hotelimage;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;
import com.opensymphony.webwork.ServletActionContext;

public class HotelimageAction extends B2b2cbackAction {
	private List  listHotelimage;
	private Hotelimage hotelimage = new Hotelimage();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	//酒店id
	private Long hotelId ;
	private String hotelName;
	private Hotel hotel;
	private File[] files;
	private String forward;
	private String filesContentType; 
	private String filesFileName; 
	/**
	 * 列表查询酒店图片
	 */	
	
	public String execute()throws Exception{
		String where = " where 1=1 and "+Hotelimage.COL_hotelid+"="+hotelId;
		
		List list = Server.getInstance().getHotelService().findAllHotelimageForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listHotelimage = list;
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotelName = hotel.getName();
		 if(pageinfo.getTotalrow()>0 &&   listHotelimage.size()==0 && hotelId != null && hotelId.longValue() > 0){
			 where += "AND" + hotelimage.COL_hotelid + "=" + hotelId;
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotelimageForPageinfo(where," ORDER BY " + hotelimage.COL_id,pageinfo);			
			pageinfo = (PageInfo)list.remove(0);
			listHotelimage =list;
		 }
		
		
		return SUCCESS;
	}
	/**
	 * 转向到酒店图片添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
public String toeditlanguage()throws Exception{
		
		Integer lan=hotelimage.getLanguage();
		Long uco=hotelimage.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		hotelimage = Server.getInstance().getHotelService().findHotelimagebylanguage(hotelimage.getUcode(),hotelimage.getLanguage());
		if(hotelimage==null)
		{
			hotelimage=new Hotelimage();
			hotelimage.setLanguage(lan);
			hotelimage.setUcode(uco);
			//以下是toadd参考方法
			
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			
		}
		return EDIT;
	}
	/**
	 * 转向到酒店图片修改页面
	 */	
	public String toedit()throws Exception{
	hotelimage = Server.getInstance().getHotelService().findHotelimage(hotelimage.getId());
		return EDIT;
	}
	
	/**
	 * 转向到酒店图片审核页面
	 */	
	public String tocheck()throws Exception{
		String where = " where 1=1 and "+Hotelimage.COL_hotelid+"="+hotelId;
		List list = Server.getInstance().getHotelService().findAllHotelimageForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo =(PageInfo)list.remove(0);
		listHotelimage = list;
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotelName = hotel.getName();
		 if(pageinfo.getTotalrow()>0 &&   listHotelimage.size()==0 && hotelId != null && hotelId.longValue() > 0){
			 where += "AND" + hotelimage.COL_hotelid + "=" + hotelId;
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotelimageForPageinfo(where," ORDER BY " + hotelimage.COL_id,pageinfo);			
			pageinfo = (PageInfo)list.remove(0);
			listHotelimage =list;
		 }
	//hotelimage = Server.getInstance().getHotelimageManager().findHotelimage(hotelimage.getId());
		return CHECK;
	}
	
	/**
	 * 转向到tabs
	 */		
	public String tabs()throws Exception{	
		return "tabs";
	}
	
	/**
	 * 转向酒店图片查看页面
	 */
	public String tolook()throws Exception{
		String where = " where 1=1 and "+Hotelimage.COL_hotelid+"="+hotelId;
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Hotelimage.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
		
		List list = Server.getInstance().getHotelService().findAllHotelimageForPageinfo(where,"ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listHotelimage =list;
		hotel = Server.getInstance().getHotelService().findHotel(hotelId);
		hotelName = hotel.getName();
		 if(pageinfo.getTotalrow()>0 &&   listHotelimage.size()==0 && hotelId != null && hotelId.longValue() > 0){
			 where += "AND" + hotelimage.COL_hotelid + "=" + hotelId;
			pageinfo.setPagenum(1);
			list = Server.getInstance().getHotelService().findAllHotelimageForPageinfo(where," ORDER BY " + hotelimage.COL_id,pageinfo);	
			pageinfo = (PageInfo)list.remove(0);
			listHotelimage =list;
		}
		
		
		return "look";
	}

	/**
	 * 添加酒店图片
	 */		
	public String add()throws Exception{
		
		String flag = ServletActionContext.getRequest().getParameter("flag");
		Long hid = hotelimage.getHotelid();
		if(flag!=null){
			String where =" where 1=1 and "+Hotelimage.COL_hotelid+"="+this.hotelimage.getHotelid()+" and "+Hotelimage.COL_type+"="+hotelimage.getType();
			List <Hotelimage> listHotelimage = Server.getInstance().getHotelService().findAllHotelimage(where,"",-1,0);
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			if(listHotelimage.size()>0){
				out.print("exist");
			}else{
				out.print("inexistence");
			}
			out.flush();
			out.close();
		}else{
			if(hotelimage.getType()==1){
				String where =" where 1=1 and "+Hotelimage.COL_hotelid+"="+hotelimage.getHotelid()+" and "+Hotelimage.COL_type+"="+hotelimage.getType();
				List <Hotelimage> listHotelimage = Server.getInstance().getHotelService().findAllHotelimage(where,"",-1,0);
				if(listHotelimage.size()>0){
					Server.getInstance().getHotelService().deleteHotelimage(listHotelimage.get(0).getId());
				}
			}
			if(null != files){
				String filePath = "/"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/" +hotelimage.getHotelid() +"/";
				String realPath =getRealPath_tripline(filePath);
				
				File f = new File(realPath);
				if(!f.exists()){
					f.mkdirs();
				}
				System.out.println("文件真实路径" + f.getPath()+"/"+this.getFilesFileName());
				Util.copyfile(files[0],new File(f.getPath()+"/"+this.getFilesFileName()));
				String imagePath =  filePath + this.getFilesFileName();
				//System.out.println("图片路径" + filePath+this.getFilesFileName());
				
				
				
				/*File f = new File(realPath);
				if(!f.exists()){
					f.mkdirs();
				}
*/				//Util.copyfile(files[0],new File(f.getPath()+"/"+files[0].getName()));
				//hotelimage.setPath(filePath+files[0].getName());
				
				hotelimage.setPath(imagePath);
			}
			System.out.println(hotelimage.getPath());
			hotelimage.setHotelid(hid);
			hotelimage.setLanguage(0);
			hotelimage=Server.getInstance().getHotelService().createHotelimage(hotelimage);
			hotel = Server.getInstance().getHotelService().findHotel(hid); 
			hotel.setState(0);
			Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
			forward = "hotelimage!tabs.action?remotetabs=8&hotelId="+hotelId;
			this.addActionMessage("您的操作已成功！");
				return "forward";
		}	
	
			return "";
	}
	/**
	 * 保存图片
	 * @return	返回图片的保存路径
	 */
	private String saveImage(File[] files){
		String filePath = "/giftimage/" ;
		String realPath =getRealPath_tripline(filePath);
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
	 * 审核酒店图片
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getHotelService().updateHotelimageIgnoreNull(hotelimage);
		return LIST;
	}
	


	/**
	 * 编辑酒店图片
	 */		
	public String edit()throws Exception{
		if(this.hotelimage.getType()==1){
			String where =" where 1=1 and "+Hotelimage.COL_hotelid+"="+hotelimage.getHotelid()+" and "+Hotelimage.COL_type+"="+hotelimage.getType()+" and "+Hotelimage.COL_id+"!="+hotelimage.getId();
			List<Hotelimage> list = Server.getInstance().getHotelService().findAllHotelimage(where,"",-1,0);
			
			if(list.size()>0){
				Server.getInstance().getHotelService().deleteHotelimage(list.get(0).getId());
			}
		}
		return commonality();
	}
	
	private String commonality(){
		Hotelimage tempImage = Server.getInstance().getHotelService().findHotelimage(hotelimage.getId());

		this.hotelimage.setPath(tempImage.getPath());
		if(this.files!=null){
			String tempStr = tempImage.getPath().substring(0,tempImage.getPath().lastIndexOf("/"));
			String path = this.getRealPath_tripline(tempStr);
			String tempFileName = this.getRealPath_tripline(tempImage.getPath());
			/*Util.copyfile(files[0],new File(path+"/"+files[0].getName()));
			this.hotelimage.setPath(tempStr+"/"+files[0].getName());*/
			
			String filePath = "/"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/" +hotelimage.getHotelid() +"/";
			String realPath =getRealPath_tripline(filePath);
			
			File f = new File(realPath);
			if(!f.exists()){
				f.mkdirs();
			}
			System.out.println("文件真实路径" + f.getPath()+"/"+this.getFilesFileName());
			Util.copyfile(files[0],new File(f.getPath()+"/"+this.getFilesFileName()));
			String imagePath =  filePath + this.getFilesFileName();
			
			this.hotelimage.setPath(imagePath);
			new File(tempFileName).delete();
		}
		this.hotelimage.setLanguage(0);
		this.hotelimage.setHotelid(tempImage.getHotelid());
		Server.getInstance().getHotelService().updateHotelimage(this.hotelimage);
		hotel = Server.getInstance().getHotelService().findHotel(hotelimage.getHotelid());
		hotel.setState(0);
		Server.getInstance().getHotelService().updateHotelIgnoreNull(hotel);
		this.addActionMessage("您的操作已成功！");
	//	return EDIT ;
		forward = "hotelimage!tabs.action?remotetabs=8&hotelId="+hotelId;
		this.addActionMessage("您的操作已成功！");
			return "forward2";
	}

	/**
	 * 删除酒店图片
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getHotelService().deleteHotelimage(hotelimage.getId());
		return LIST;
	}
	/**
	 * 
	 * 返回到列表
	 */
	public String goback() throws Exception{
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
					Server.getInstance().getHotelService().deleteHotelimage(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}
	
	

	/**
	 *  返回酒店图片对象
	 */		
	
	public Object getModel() {
		return hotelimage;
	}
	public List < Hotelimage >   getListHotelimage() {
		return listHotelimage;
	}
	public void setListHotelimage(List <  Hotelimage  >  listHotelimage) {
		this.listHotelimage = listHotelimage;
	}
	public Hotelimage getHotelimage() {
		return hotelimage;
	}
	public void setHotelimage(Hotelimage hotelimage) {
		this.hotelimage = hotelimage;
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
	public File[] getFiles() {
		return files;
	}
	public void setFiles(File[] files) {
		this.files = files;
	}
	public Long getHotelId() {
		return hotelId;
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
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
	}
	
	
}