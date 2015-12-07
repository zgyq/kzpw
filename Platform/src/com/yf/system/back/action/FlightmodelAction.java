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
import com.yf.system.base.flightmodel.Flightmodel;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;
import com.opensymphony.webwork.ServletActionContext;

public class FlightmodelAction extends B2b2cbackAction {
	private static final long serialVersionUID = 3048109192241927546L;
	private List<Flightmodel> listFlightmodel;
	private Flightmodel flightmodel = new Flightmodel();

	// 批量操作ID数组
	private int[] selectid;

	public final static String FAILED_STR = "uploadfailed";
	// 飞机图标
	private File[] plaImg;
	// 批量操作选项
	private int opt;

	// search
	// private String s_name;

	/**
	 * 列表查询机型信息表
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		// if (s_name!=null && s_name.trim().length()!=0) {

		// where += " and " + Flightmodel.COL_name +" like '%" +
		// s_name.trim()+"%'";
		// }

		
		if (flightmodel.getModelnum() != null
				&& !"".equals(flightmodel.getModelnum())) {
			where += " and " + Flightmodel.COL_modelnum + " like '%"
					+ flightmodel.getModelnum() + "%'";
		}
		
		if (flightmodel.getModelname()!= null
				&& !"".equals(flightmodel.getModelname())) {
			where += " and " + Flightmodel.COL_modelname+ " like '%"
					+ flightmodel.getModelname() + "%'";
		}
		
		List list = Server
				.getInstance()
				.getAirService()
				.findAllFlightmodelForPageinfo(where, " ORDER BY ID ", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listFlightmodel = list;
		if (pageinfo.getTotalrow() > 0 && listFlightmodel.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService()
					.findAllFlightmodelForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listFlightmodel = list;
		}

		return SUCCESS;
	}

	/**
	 * 转向到机型信息表添加页面
	 */
	public String toadd() throws Exception {
		return EDIT;
	}

	/**
	 * 转向到机型信息表修改页面
	 */
	public String toedit() throws Exception {
		flightmodel = Server.getInstance().getAirService().findFlightmodel(
				flightmodel.getId());
		return EDIT;
	}
	/**
	 * 转向到地级市修改页面 by
	 * 多语言
	 */	
	public String toeditlanguage()throws Exception{
		
		Integer lan=flightmodel.getLanguage();
		Long uco=flightmodel.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		flightmodel = Server.getInstance().getAirService().findFlightmodelbylanguage(flightmodel.getUcode(),flightmodel.getLanguage());
		if(flightmodel==null)
		{
			flightmodel=new Flightmodel();
			flightmodel.setLanguage(lan);
			flightmodel.setUcode(uco);
			//以下是toadd参考方法
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
		}
		return EDIT;
	}


	/**
	 * 转向到机型信息表审核页面
	 */
	public String docheck() throws Exception {
		flightmodel = Server.getInstance().getAirService().findFlightmodel(
				flightmodel.getId());
		return CHECK;
	}

	/**
	 * 添加机型信息表
	 */
	public String add() throws Exception {
		String picpath = uploadImage(plaImg, "/", "skin/plainimg/");
		if (plaImg != null) {
			if (!FAILED_STR.equals(picpath)) {
				flightmodel.setPicpath(picpath);
			}
		}
		flightmodel=Server.getInstance().getAirService().createFlightmodel(flightmodel);
		this.addActionMessage("您的操作已成功！");
		return EDIT;
	}

	/**
	 * 审核机型信息表
	 */
	public String check() throws Exception {

		Server.getInstance().getAirService().updateFlightmodelIgnoreNull(
				flightmodel);
		return LIST;
	}

	/**
	 * 编辑机型信息表
	 */
	public String edit() throws Exception {
		if (plaImg != null) {
			String picpath = uploadImage(plaImg, "/", "skin/plainimg/");
			if (!FAILED_STR.equals(picpath)) {
				flightmodel.setPicpath(picpath);
			}
		}
		Server.getInstance().getAirService().updateFlightmodelIgnoreNull(
				flightmodel);
		this.addActionMessage("您的操作已成功！");
		return EDIT;
	}

	/**
	 * 删除机型信息表
	 */
	public String delete() throws Exception {
		Server.getInstance().getAirService().deleteFlightmodel(
				flightmodel.getId());
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
					Server.getInstance().getAirService().deleteFlightmodel(i);
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
	 * 返回机型信息表对象
	 */

	public Object getModel() {
		return flightmodel;
	}

	public List<Flightmodel> getListFlightmodel() {
		return listFlightmodel;
	}

	public void setListFlightmodel(List<Flightmodel> listFlightmodel) {
		this.listFlightmodel = listFlightmodel;
	}

	public Flightmodel getFlightmodel() {
		return flightmodel;
	}

	public void setFlightmodel(Flightmodel flightmodel) {
		this.flightmodel = flightmodel;
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

	public File[] getPlaImg() {
		return plaImg;
	}

	public void setPlaImg(File[] plaImg) {
		this.plaImg = plaImg;
	}

}