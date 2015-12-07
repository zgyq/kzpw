/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yf.system.back.server.Server;
import com.yf.system.base.dnsmaintenance.Dnsmaintenance;
import com.yf.system.base.service.ISystemService;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;
import com.opensymphony.webwork.ServletActionContext;

public class DnsmaintenanceAction extends B2b2cbackAction {

	private File[] files;
	private String[] filesFileName;
	private String[] filesContentType;
	private List<Dnsmaintenance> listDnsmaintenance;
	private Dnsmaintenance dnsmaintenance = new Dnsmaintenance();
	private String[] images;
	
	
	//B2G维护图片用
	//B2Clogo以及logo旁边图片
	private File[] files1;//logo
	private File[] files2;//logo右边图片
	
	
	//B2C登录页面图片
	private File[] files3;//登录页面大图
	private File[] files4;//登录页面小图1
	private File[] files5;//登录页面小图2
	
	//B2C机票列表页面图片
	private File[] files6;//机票列表页面图片
	
	//B2C机票首页图片
	private File[] files7;//机票首页大图片
	private File[] files8;//机票首页小图片
	
	//B2C机票下单页面图片
	private File[] air_order_files1;//
	
	//B2C机票下单成功页面图片
	private File[] air_ok_files1;//
	
	
	//B2C  首页图片
	private File[] index_files1;//
	private File[] index_files2;//
	private File[] index_files3;//
	private File[] index_files4;//
	
	private long s_agentid;
	
	
	
	private String logopath;
	
	/**
	 * 列表查询分销商DNSLOGO维护
	 */
	public String execute() {
		try {
			String where = " where 1=1 AND ID!=1  ";
			/*if (this.getLoginsessionagent().getAgenttype() != 1) {
				where += " AND C_AGENTID=" + this.getLoginUser().getAgentid();
			}*/
			if(s_agentid>0){
				where += " AND C_AGENTID=" +s_agentid;
			}
			System.out.println("s_agentid:"+s_agentid);
			
			System.out.println("dns-where:"+where);
			List list = getService().findAllDnsmaintenanceForPageinfo(where,
					" ORDER BY ID ", pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listDnsmaintenance = list;
			List loginpagelist=getLoginpagelist();
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("loginpagelist", loginpagelist);
		} catch (Exception e) {

		}
		return SUCCESS;
	}
	//维护B2G广告图片
	public String tob2g(){
		
		
		
		
		
		
		return "tob2g";
	}
	public String uplode(){
		
		
		String realPath =getlogoPath();
		System.out.println("realPath=="+realPath);
		
		String filesrc = ServletActionContext.getServletContext()
		.getRealPath("/testimages");
		//System.out.println("filesrc=="+filesrc);
		
		File s = new File(realPath);
		if(!s.exists()){
			s.mkdirs();
		}
		File f = new File("");
		
		try {
			//logon
			if(files1 !=null && files1[0]!=null){
				f = this.files1[0];
				System.out.println(s.getPath()+"/" + f.getName());
				
				String newname ="logo.png";
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				logopath = getlogoShowPath() + newname;
				
			}
			if(files2 !=null && files2[0]!=null){
				f = this.files2[0];
				System.out.println(s.getPath()+"/" + f.getName());
				
				String newname ="ad.jpg";
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
			}
			
			//登录页面
			if(files3 !=null && files3[0]!=null){
				f = this.files3[0];
				System.out.println(s.getPath()+"/" + f.getName());
				
				String newname ="ad_700.jpg";
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
			}
			if(files4 !=null && files4[0]!=null){
				f = this.files4	[0];
				System.out.println(s.getPath()+"/" + f.getName());
				
				String newname ="ad_sea.jpg";
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
			}
			if(files5 !=null && files5[0]!=null){
				f = this.files5[0];
				System.out.println(s.getPath()+"/" + f.getName());
				
				String newname ="ad_login.jpg";
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
			}
			
			//机票列表
			if(files6 !=null && files6[0]!=null){
				f = this.files6[0];
				System.out.println(s.getPath()+"/" + f.getName());
				
				String newname ="ad_list.jpg";
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
			}
			//机票首页
			if(files7 !=null && files7[0]!=null){
				f = this.files7[0];
				System.out.println(s.getPath()+"/" + f.getName());
				
				String newname ="ad_ticket.jpg";
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
			}
		
			if(files8 !=null && files8[0]!=null){
			f = this.files8[0];
			System.out.println(s.getPath()+"/" + f.getName());
			
			String newname ="ad_ticket_01.jpg";
			
			Util.copyfile(f, new File(s.getPath() + "/" + newname));
			
		}
			
		//首页4张
			if(index_files1 !=null && index_files1[0]!=null){
				f = this.index_files1[0];
				System.out.println(s.getPath()+"/" + f.getName());
				
				String newname ="good1.jpg";
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
			}
			if(index_files2 !=null && index_files2[0]!=null){
				f = this.index_files2[0];
				System.out.println(s.getPath()+"/" + f.getName());
				
				String newname ="good2.jpg";
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
			}
			if(index_files3 !=null && index_files3[0]!=null){
				f = this.index_files3[0];
				System.out.println(s.getPath()+"/" + f.getName());
				
				String newname ="good3.jpg";
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
			}
			if(index_files4 !=null && index_files4[0]!=null){
				f = this.index_files4[0];
				System.out.println(s.getPath()+"/" + f.getName());
				
				String newname ="good4.jpg";
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
			}
			//下单页面
			if(air_order_files1 !=null && air_order_files1[0]!=null){
				f = this.air_order_files1[0];
				System.out.println(s.getPath()+"/" + f.getName());
				
				String newname ="ad_ticket_order_01.jpg";
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
			}
			
			
			//成功页面
			if(air_ok_files1 !=null && air_ok_files1[0]!=null){
				f = this.air_ok_files1[0];
				System.out.println(s.getPath()+"/" + f.getName());
				
				String newname ="ad_ticket_ok_01.jpg";
				
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				
			}
			
		} catch (Exception e) {
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("errormessage", "域名维护出错，请检查信息输入是否正确，图片是否存在。");
			System.out.println("维护出错，请检查信息输入是否正确，图片是否存在");
		}
		
		
		return "tob2gup";
	}
	
	public String tob2clogo()throws Exception{
		
		
		return "tob2clogo";
	}
	public String tob2cindex()throws Exception{
		
		
		return "tob2cindex";
	}
public String toairindex()throws Exception{
		
		
		return "toairindex";
	}
public String toairlist()throws Exception{
	
	
	return "toairlist";
}
public String toairorder()throws Exception{
	
	
	return "toairorder";
}
public String tologin()throws Exception{
	
	
	return "tologin";
}
public String took()throws Exception{
	
	
	return "took";
}
	
	/**
	 * 
	 * @return
	 */
	public List getLoginpagelist(){
		String sql="SELECT * FROM T_LOGINPAGE";
		List loginpagelist=Server.getInstance().getSystemService().findMapResultBySql(sql, null);
		return loginpagelist;
	}
	/**
	 * 添加分销商DNSLOGO维护
	 */
	public String add() {
		Dnsmaintenance dns = null;
		try {
			if (files != null) {
				System.out.println(files.length);
				String filesrc = ServletActionContext.getServletContext()
						.getRealPath("/main/img/");
				String dnsname = dnsmaintenance.getDnsname();
				for (int i = 0; i < files.length; i++) {
					String name = dnsname + this.filesFileName[i];
					String imgsrc = filesrc + "\\" + name;
					System.out.println("name:"+name);
					System.out.println("imgsrc:"+imgsrc);
					FileOutputStream out = new FileOutputStream(imgsrc);
					FileInputStream input = new FileInputStream(files[i]);
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len = input.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					out.flush();
					out.close();
					input.close();
					
						dnsmaintenance.setLogosrc(name);
					
				}
			//	System.out.println(dnsmaintenance.getLoginpageid());
				dns = getService().createDnsmaintenance(dnsmaintenance);
			}
		} catch (Exception e) {
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("errormessage", "域名维护出错，请检查信息输入是否正确，图片是否存在。");
			try {
				if (dns != null && dns.getId() > 0) {
					this.getService().deleteDnsmaintenance(dns.getId());
					this.delLogoimg(dnsmaintenance.getLogosrc());
					//this.delLogoimg(dnsmaintenance.getLogologinsrc());
				}
			} catch (Exception ex) {

			}
		}

		return this.execute();
	}
	

	/**
	 * 转向到分销商DNSLOGO维护添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到分销商DNSLOGO维护修改页面
	 */
	public String toedit() throws Exception {
		List loginpagelist=getLoginpagelist();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("loginpagelist", loginpagelist);
		dnsmaintenance = getService()
				.findDnsmaintenance(dnsmaintenance.getId());
		return EDIT;
	}

	/**
	 * 转向到分销商DNSLOGO维护审核页面
	 */
	public String tocheck() throws Exception {
		dnsmaintenance = getService()
				.findDnsmaintenance(dnsmaintenance.getId());
		return CHECK;
	}

	/**
	 * 审核分销商DNSLOGO维护
	 */
	public String check() throws Exception {

		getService().updateDnsmaintenanceIgnoreNull(dnsmaintenance);
		return LIST;
	}

	public String edit() {
		try {
			if (files != null) {
				System.out.println(files.length);
				String filesrc = ServletActionContext.getServletContext()
						.getRealPath("/images");
				String dnsname = dnsmaintenance.getDnsname();
				dnsmaintenance.setAgentid(this.getLoginUser().getAgentid());
				for (int i = 0; i < files.length; i++) {
					String name = dnsname + this.filesFileName[i];
					String imgsrc = filesrc + "\\" + name;
					FileOutputStream out = new FileOutputStream(imgsrc);
					FileInputStream input = new FileInputStream(files[i]);
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len = input.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					out.flush();
					out.close();
					input.close();
					if (i == 0) {
						dnsmaintenance.setLogologinsrc(name);
					} else {
						dnsmaintenance.setLogosrc(name);
					}
				}
			}
			getService().updateDnsmaintenanceIgnoreNull(dnsmaintenance);
		} catch (Exception e) {
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("errormessage", "域名维护出错，请检查信息输入是否正确，图片是否存在。");
		}

		return this.execute();
	}

	/**
	 * 编辑分销商DNSLOGO维护
	 * 
	 * public String edit() throws Exception {
	 * 
	 * if (file != null) { delLogoimg(dnsmaintenance.getLogosrc()); String
	 * filesrc = ServletActionContext.getServletContext()
	 * .getRealPath("/images"); String dnsname = dnsmaintenance.getDnsname();
	 * String name = dnsname+ file.getName(); filesrc += "\\" + name;
	 * FileOutputStream out = new FileOutputStream(filesrc); FileInputStream
	 * input = new FileInputStream(file); byte[] buffer = new byte[1024]; int
	 * len = 0; while ((len = input.read(buffer)) > 0) { out.write(buffer, 0,
	 * len); } out.flush(); out.close(); input.close();
	 * dnsmaintenance.setLogosrc(name); }
	 * System.out.println(dnsmaintenance.getShortname());
	 * System.out.println(dnsmaintenance.getServiceline());
	 * getService().updateDnsmaintenanceIgnoreNull(dnsmaintenance);
	 * 
	 * return this.execute(); }
	 */

	/**
	 * 删除分销商DNSLOGO维护
	 */
	/**
	 * @return
	 * @throws Exception
	 */
	/**
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {

		getService().deleteDnsmaintenance(dnsmaintenance.getId());
		this.delLogoimg(dnsmaintenance.getLogosrc());
		this.delLogoimg(dnsmaintenance.getLogologinsrc());
		return this.execute();
	}

	public void delLogoimg(String imgname) {
		String path = ServletActionContext.getServletContext().getRealPath(
				"/images");
		path = path + "\\" + imgname;
		File file = new File(path);
		if (file.exists()) {
			boolean result = file.delete();
			System.out.println("图片删除：" + result);
		}
	}
	
	/**
	 * 判断上传文件是否合法
	 * 
	 * @param filename
	 * @return
	 */
	private static String[] fileStrs = { "gif", "jpg","png" };
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

	private ISystemService systemservice;

	public ISystemService getService() {
		if (systemservice != null) {
			return systemservice;
		} else {
			return Server.getInstance().getSystemService();
		}
	}

	/**
	 * 返回分销商DNSLOGO维护对象
	 */

	public Object getModel() {
		return dnsmaintenance;
	}

	public List<Dnsmaintenance> getListDnsmaintenance() {
		return listDnsmaintenance;
	}

	public void setListDnsmaintenance(List<Dnsmaintenance> listDnsmaintenance) {
		this.listDnsmaintenance = listDnsmaintenance;
	}

	public Dnsmaintenance getDnsmaintenance() {
		return dnsmaintenance;
	}

	public void setDnsmaintenance(Dnsmaintenance dnsmaintenance) {
		this.dnsmaintenance = dnsmaintenance;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String[] getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

	public String[] getFilesContentType() {
		return filesContentType;
	}

	public void setFilesContentType(String[] filesContentType) {
		this.filesContentType = filesContentType;
	}
	public String[] getImages() {
		return images;
	}
	public void setImages(String[] images) {
		this.images = images;
	}
	public File[] getFiles1() {
		return files1;
	}
	public void setFiles1(File[] files1) {
		this.files1 = files1;
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
	public File[] getFiles4() {
		return files4;
	}
	public void setFiles4(File[] files4) {
		this.files4 = files4;
	}
	public File[] getFiles5() {
		return files5;
	}
	public void setFiles5(File[] files5) {
		this.files5 = files5;
	}
	public String getLogopath() {
		return logopath;
	}
	public void setLogopath(String logopath) {
		this.logopath = logopath;
	}
	public File[] getFiles6() {
		return files6;
	}
	public void setFiles6(File[] files6) {
		this.files6 = files6;
	}
	public File[] getFiles7() {
		return files7;
	}
	public void setFiles7(File[] files7) {
		this.files7 = files7;
	}
	public File[] getFiles8() {
		return files8;
	}
	public void setFiles8(File[] files8) {
		this.files8 = files8;
	}
	public File[] getAir_order_files1() {
		return air_order_files1;
	}
	public void setAir_order_files1(File[] air_order_files1) {
		this.air_order_files1 = air_order_files1;
	}
	public File[] getAir_ok_files1() {
		return air_ok_files1;
	}
	public void setAir_ok_files1(File[] air_ok_files1) {
		this.air_ok_files1 = air_ok_files1;
	}
	public File[] getIndex_files1() {
		return index_files1;
	}
	public void setIndex_files1(File[] index_files1) {
		this.index_files1 = index_files1;
	}
	public File[] getIndex_files2() {
		return index_files2;
	}
	public void setIndex_files2(File[] index_files2) {
		this.index_files2 = index_files2;
	}
	public File[] getIndex_files3() {
		return index_files3;
	}
	public void setIndex_files3(File[] index_files3) {
		this.index_files3 = index_files3;
	}
	public File[] getIndex_files4() {
		return index_files4;
	}
	public void setIndex_files4(File[] index_files4) {
		this.index_files4 = index_files4;
	}
	public long getS_agentid() {
		return s_agentid;
	}
	public void setS_agentid(long s_agentid) {
		this.s_agentid = s_agentid;
	}
	

}