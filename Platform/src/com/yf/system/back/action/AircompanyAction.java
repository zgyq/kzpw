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
import com.yf.system.base.aircompany.Aircompany;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;
import com.opensymphony.webwork.ServletActionContext;

public class AircompanyAction extends B2b2cbackAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1339352671657811702L;
	private List<Aircompany> listAircompany;
	private Aircompany aircompany = new Aircompany();
	
	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;
	// 航空公司图标
	private File[] logo;
	public final static String FAILED_STR = "uploadfailed";

	private long s_type;
	// search
	// private String s_name;

	/**
	 * 列表查询航空公司基础信息表
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Aircompany.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }
		if (aircompany.getAircomcnname() != null && !"".equals(aircompany.getAircomcnname())) {
			where += " and " + Aircompany.COL_aircomcnname + " like '%" + aircompany.getAircomcnname() + "%'";
		}
		
		if (aircompany.getAircomenname() != null && !"".equals(aircompany.getAircomenname())) {
			where += " and " + Aircompany.COL_aircomenname + " like '%" + aircompany.getAircomenname() + "%'";
		}
		
		if (aircompany.getAircomcode() != null && !"".equals(aircompany.getAircomcode())) {
			where += " and " + Aircompany.COL_aircomcode + " like '%" + aircompany.getAircomcode() + "%'";
		}
		
		if (aircompany.getAircomjname() != null && !"".equals(aircompany.getAircomjname())) {
			where += " and " + Aircompany.COL_aircomjname + " like '%" + aircompany.getAircomjname() + "%'";
		}
		
		List list = Server.getInstance().getAirService()
				.findAllAircompanyForPageinfo(where, " ORDER BY ID DESC ", pageinfo);
		
		
		pageinfo = (PageInfo) list.remove(0);
		listAircompany = list;
		if (pageinfo.getTotalrow() > 0 && listAircompany.size() == 0) {
			if (pageinfo.getPagenum() <= 1) {
				pageinfo.setPagenum(1);
			}
			list = Server.getInstance().getAirService()
					.findAllAircompanyForPageinfo(where, " ORDER BY ID DESC ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listAircompany = list;
		}

		return SUCCESS;
	}
	

	public String CancelService()throws Exception{
		aircompany = Server.getInstance().getAirService().findAircompany(
				aircompany.getId());
		
		aircompany.setIsair(s_type);
		
		Server.getInstance().getAirService().updateAircompanyIgnoreNull(aircompany);
		
		return LIST;
	}
	
	/**
	 * 转向到航空公司基础信息表添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到航空公司基础信息表修改页面
	 */
	public String toedit() throws Exception {
		aircompany = Server.getInstance().getAirService().findAircompany(
				aircompany.getId());
		return EDIT;
	}
	/**
	 * 转向到地级市修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		
		Integer lan=aircompany.getLanguage();
		Long uco=aircompany.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		aircompany = Server.getInstance().getAirService().findAircompanybylanguage(aircompany.getUcode(),aircompany.getLanguage());
		if(aircompany==null)
		{
			aircompany=new Aircompany();
			aircompany.setLanguage(lan);
			aircompany.setUcode(uco);
			//以下是toadd参考方法
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
		}
		return EDIT;
	}

	/**
	 * 转向到航空公司基础信息表审核页面
	 */
	public String docheck() throws Exception {
		aircompany = Server.getInstance().getAirService().findAircompany(
				aircompany.getId());
		if (aircompany.getIsenable() == 0) {
			aircompany.setIsenable(1);
		} else {
			aircompany.setIsenable(0);
		}
		Server.getInstance().getAirService().updateAircompanyIgnoreNull(aircompany);
		return "list2";
	}

	/**
	 * 添加航空公司基础信息表
	 */
	public String add() throws Exception {
		aircompany.setCreateuser(getLoginUser().getLoginname());
		aircompany.setCreatetime(new Timestamp(System.currentTimeMillis()));
		aircompany.setModifyuser(getLoginUser().getLoginname());
		aircompany.setModifytime(new Timestamp(System.currentTimeMillis()));

		String logopath = uploadImage(logo, "/", getRealPath("/skin/airwayslogo/"));
		if (!FAILED_STR.equals(logopath)) {
			aircompany.setAircomlogo("/skin/airwayslogo/"+logopath);
		}
		aircompany.setLanguage(0);
		System.out.println(aircompany);
		
		Server.getInstance().getAirService().createAircompany(aircompany);
		this.addActionMessage("您的操作已成功！");
		return EDIT;
	}

	/**
	 * 审核航空公司基础信息表
	 */
	public String check() throws Exception {
		aircompany.setModifyuser(getLoginUser().getLoginname());
		aircompany.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getAirService().updateAircompanyIgnoreNull(
				aircompany);
		return LIST;
	}

	/**
	 * 编辑航空公司基础信息表
	 */
	public String edit() throws Exception {
		aircompany.setModifyuser(getLoginUser().getLoginname());
		aircompany.setModifytime(new Timestamp(System.currentTimeMillis()));
		if (logo != null) {
			String logopath = uploadImage(logo, "/", getRealPath("/skin/airwayslogo/"));
			if (!FAILED_STR.equals(logopath)) {
				aircompany.setAircomlogo("/skin/airwayslogo/"+logopath);
			}
		} 
		aircompany.setLanguage(0);
		
		Server.getInstance().getAirService().updateAircompanyIgnoreNull(
				aircompany);
		this.addActionMessage("您的操作已成功！");
		return EDIT;
	}

	/**
	 * 删除航空公司基础信息表
	 */
	public String delete() throws Exception {
		Server.getInstance().getAirService().deleteAircompany(
				aircompany.getId());
		return LIST;
	}

	/**
	 * 批量操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String batch() throws Exception {
		if (selectid != null && selectid.length > 0) {

			switch (opt) {
			case 1: // delete

				for (int i : selectid) {
					Server.getInstance().getAirService().deleteAircompany(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 上传图片
	 * 
	 * @param files
	 *            要上传的图片
	 * @param realpath
	 *            文件绝对路径
	 * @param dirName
	 *            上传文件的所放的文件夹名
	 * @return
	 */
	public String uploadImage(File[] files, String path, String dirName) {
		String realpath = ServletActionContext.getServletContext().getRealPath(
				path);

		File dir = new File(realpath + "/" + dirName);
		File imgFile;
		if (!dir.exists()) {
			dir.mkdirs();
		}
		if (files != null && files[0] != null) {
			if (isIllegalImage(files[0].getName())) {
				return FAILED_STR;
			} else {
				imgFile = new File(dir.getPath() + "/" + files[0].getName());
				Util.copyfile(files[0], new File(dir.getPath() + "/"
						+ files[0].getName()));
			}
		} else {
			return FAILED_STR;
		}
		return imgFile.getName();
	}

	/**
	 * 判断上传文件是否合法
	 * 
	 * @param filename
	 * @return true:不合法 false：合法
	 */
	private boolean isIllegalImage(String filename) {
		int count = 0;
		String[] fileStrs = { "jpg", "gif", "bmp", "png" };
		for (String str : fileStrs) {
			if (filename.endsWith(str.toLowerCase())) {
				count++;
				break;
			}
		}
		// count等于0表示此文件不合法
		if (count == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 返回航空公司基础信息表对象
	 */

	public Object getModel() {
		return aircompany;
	}

	public List<Aircompany> getListAircompany() {
		return listAircompany;
	}

	public void setListAircompany(List<Aircompany> listAircompany) {
		this.listAircompany = listAircompany;
	}

	public Aircompany getAircompany() {
		return aircompany;
	}

	public void setAircompany(Aircompany aircompany) {
		this.aircompany = aircompany;
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

	public void setLogo(File[] logo) {
		this.logo = logo;
	}

	public File[] getLogo() {
		return logo;
	}

	public long getS_type() {
		return s_type;
	}

	public void setS_type(long s_type) {
		this.s_type = s_type;
	}



}