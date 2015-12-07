/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.opensymphony.webwork.ServletActionContext;
import com.yf.system.back.server.Server;
import com.yf.system.base.airdelayprove.Airdelayprove;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.segmentinfo.Segmentinfo;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;


public class AirdelayproveAction extends B2b2cbackAction {
	private List <  Airdelayprove  >  listAirdelayprove;
	private Airdelayprove airdelayprove = new Airdelayprove();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	//机票ID
	private String s_orderid="0";
	
	//search
	private String s_name;
	
	private String s_pnr;
	
	private File[] files;
	
	private String filesFileName; 
	/**
	 * 列表查询航班延误证明
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		if (s_name!=null && s_name.trim().length()!=0) {
			
			where += " and " + Airdelayprove.COL_airnum +" like '%" + s_name.trim()+"%'";	
		}
		if (s_pnr!=null && s_pnr.trim().length()!=0) {
			
			where += " and " + Airdelayprove.COL_pnr +" like '%" + s_pnr.trim()+"%'";	
		}
		if(getLoginUser().getAgentid()!=46){
			
			where+=" and "+Airdelayprove.COL_angentid+" ="+getLoginUser().getAgentid();
		}
	
		if (s_orderid!=null &&!s_orderid.equals("0")) {
			
			where += " and " + Airdelayprove.COL_state+" =" + s_orderid.trim();	
		}



	    List list = Server.getInstance().getMemberService().findAllAirdelayproveForPageinfo(where," ORDER BY ID DESC ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listAirdelayprove = list;
		  if(pageinfo.getTotalrow()>0 &&   listAirdelayprove.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getMemberService().findAllAirdelayproveForPageinfo(where," ORDER BY ID DESC ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listAirdelayprove = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到航班延误证明添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	/**
	 * 转向到航班延误证明修改页面
	 */	
	public String toedit()throws Exception{
	airdelayprove = Server.getInstance().getMemberService().findAirdelayprove(airdelayprove.getId());
		return EDIT;
	}
	
	/**
	 * 转向到航班延误证明审核页面
	 */	
	public String tocheck()throws Exception{
	airdelayprove = Server.getInstance().getMemberService().findAirdelayprove(airdelayprove.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加航班延误证明
	 */		
	public String add()throws Exception{
		airdelayprove.setCreatetime(new Timestamp(System.currentTimeMillis()));
		airdelayprove.setAngentid(getLoginUser().getAgentid());
		airdelayprove.setMemberid(getLoginUser().getId());
		airdelayprove.setState(Long.parseLong(s_orderid));//订单号
		Orderinfo orderinfo=Server.getInstance().getAirService().findOrderinfo(Long.parseLong(s_orderid));
		List<Segmentinfo>listseg=Server.getInstance().getAirService().findAllSegmentinfo(" WHERE 1=1 AND "+Segmentinfo.COL_orderid+" ="+orderinfo.getId(), " ORDER BY ID DESC ", -1, 0);
		if(orderinfo!=null){
			airdelayprove.setPnr(orderinfo.getPnr());
			if(listseg!=null&&listseg.size()>0){
				airdelayprove.setAirnum(listseg.get(0).getFlightnumber());//
				airdelayprove.setStime(formatTimestampyyyyMMddHHmm(listseg.get(0).getDeparttime()));
			}
			
		}
		
	
		
		
		//airdelayprove.set
		/*if(null != files){
			String filePath = "/"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/";
			String realPath =getRealPath_tripline(filePath);
			
			File f = new File(realPath);
			if(!f.exists()){
				f.mkdirs();
			}
			System.out.println("文件真实路径" + f.getPath()+"/"+this.getFilesFileName());
			Util.copyfile(files[0],new File(f.getPath()+"/"+this.getFilesFileName()));
			String imagePath =  filePath + this.getFilesFileName();
		
			airdelayprove.setUrldesc(imagePath);
		}
		System.out.println("imagePath:"+airdelayprove.getUrldesc());*/
		
		String realPath =getlogoPath();
		System.out.println("realPath=="+realPath);
		
		String filesrc = ServletActionContext.getServletContext()
		.getRealPath("/AirFile");
		//System.out.println("filesrc=="+filesrc);
		
		File s = new File(realPath);
		if(!s.exists()){
			s.mkdirs();
		}
			File f = new File("");
		
	
			
			if(files !=null && files[0]!=null){
				f = this.files[0];
				System.out.println(s.getPath()+"/" + f.getName());
				String oldname=this.getFilesFileName();
				String houzhui=oldname.substring(oldname.lastIndexOf(".")).toLowerCase();
				String newname=airdelayprove.getPnr()+"_"+System.currentTimeMillis()+"."+houzhui;
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				airdelayprove.setUrldesc(newname);	
			}
			
		
		
		Server.getInstance().getMemberService().createAirdelayprove(airdelayprove);
		return LIST;
	}

	/**
	 * 审核航班延误证明
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getMemberService().updateAirdelayproveIgnoreNull(airdelayprove);
		return LIST;
	}
	


	
	/**
	 * 编辑航班延误证明
	 */		
	public String edit()throws Exception{
		String realPath =getlogoPath();
		System.out.println("realPath=="+realPath);
		
		String filesrc = ServletActionContext.getServletContext()
		.getRealPath("/AirFile");
		//System.out.println("filesrc=="+filesrc);
		
		File s = new File(realPath);
		if(!s.exists()){
			s.mkdirs();
		}
			File f = new File("");
		
	
			
			if(files !=null && files[0]!=null){
				f = this.files[0];
				System.out.println(s.getPath()+"/" + f.getName());
				String oldname=this.getFilesFileName();
				String houzhui=oldname.substring(oldname.lastIndexOf(".")).toLowerCase();
				String newname=airdelayprove.getPnr()+"_"+System.currentTimeMillis()+"."+houzhui;
				Util.copyfile(f, new File(s.getPath() + "/" + newname));
				airdelayprove.setUrldesc(newname);	
			}
			
		Server.getInstance().getMemberService().updateAirdelayproveIgnoreNull(airdelayprove);
		return LIST;
	}

	/**
	 * 删除航班延误证明
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getMemberService().deleteAirdelayprove(airdelayprove.getId());
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
					Server.getInstance().getMemberService().deleteAirdelayprove(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回航班延误证明对象
	 */		
	
	public Object getModel() {
		return airdelayprove;
	}
	public List < Airdelayprove >   getListAirdelayprove() {
		return listAirdelayprove;
	}
	public void setListAirdelayprove(List <  Airdelayprove  >  listAirdelayprove) {
		this.listAirdelayprove = listAirdelayprove;
	}
	public Airdelayprove getAirdelayprove() {
		return airdelayprove;
	}
	public void setAirdelayprove(Airdelayprove airdelayprove) {
		this.airdelayprove = airdelayprove;
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
	public String getFilesFileName() {
		return filesFileName;
	}
	public void setFilesFileName(String filesFileName) {
		this.filesFileName = filesFileName;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_pnr() {
		return s_pnr;
	}
	public void setS_pnr(String s_pnr) {
		this.s_pnr = s_pnr;
	}
	public String getS_orderid() {
		return s_orderid;
	}
	public void setS_orderid(String s_orderid) {
		this.s_orderid = s_orderid;
	}
	
	
}