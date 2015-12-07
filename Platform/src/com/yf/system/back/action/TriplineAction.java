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
import com.yf.system.base.city.City;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.tripline.Tripline;
import com.yf.system.base.triplinesource.Triplinesource;
import com.yf.system.base.triplinetype.Triplinetype;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;
import com.opensymphony.webwork.ServletActionContext;

public class TriplineAction extends B2b2cbackAction {
	private static final long serialVersionUID = -838794684630457995L;
	public final static String FAILED_STR = "uploadfailed";
	private List<Tripline> listTripline;
	private Tripline tripline = new Tripline();
	private File[] t_image;
	private String imagerpath;
	// 城市列表
	private List<City> cityList;
	private long s_tocityid;
	private long s_fromcityid;
	private List<TriplinetypeAction> listtriplinetype;
	private List<Triplinesource> listtripsource;

	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	// search
	// private String s_name;

	/**
	 * 列表查询旅行线路
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		 if (s_tocityid!=-1 && s_tocityid!=0) {

		 where += " and " + Tripline.COL_cityid +"='" +
		 s_fromcityid+"'";
		 }
		 if (s_tocityid!=-1 && s_tocityid!=0) {

			 where += " and " + Tripline.COL_endcityid +"='" +
			 s_tocityid+"'";
			 }
		cityList=Server.getInstance().getHotelService().findAllCity("WHERE 1=1 AND "+City.COL_countryid+"=168", "ORDER BY ID", -1, 0);
		List list = Server.getInstance().getTripService()
				.findAllTriplineForPageinfo(where, " ORDER BY ID DESC", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listTripline = list;
		if (pageinfo.getTotalrow() > 0 && listTripline.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService()
					.findAllTriplineForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listTripline = list;
		}

		return SUCCESS;
	}

	/**
	 * 转向到旅行线路添加页面
	 */
	public String toadd() throws Exception {
		cityList=Server.getInstance().getHotelService().findAllCity("WHERE 1=1 AND "+City.COL_countryid+"=168", "ORDER BY ID", -1, 0);
		listtriplinetype=Server.getInstance().getTripService().findAllTriplinetype("", "Order by ID desc", -1, 0);
		listtripsource=Server.getInstance().getTripService().findAllTriplinesource("", "Order by ID desc", -1, 0);
		return EDIT;
	}

	/**
	 * 转向到旅行线路修改页面
	 */
	public String toedit() throws Exception {
		cityList=Server.getInstance().getHotelService().findAllCity("WHERE 1=1 AND "+City.COL_countryid+"=168", "ORDER BY ID", -1, 0);
		listtriplinetype=Server.getInstance().getTripService().findAllTriplinetype("", "Order by ID desc", -1, 0);
		listtripsource=Server.getInstance().getTripService().findAllTriplinesource("", "Order by ID desc", -1, 0);
		tripline = Server.getInstance().getTripService().findTripline(
				tripline.getId());
		return EDIT;
	}

	/**
	 * 转向到旅行线路审核页面
	 */
	public String tocheck() throws Exception {
		tripline = Server.getInstance().getTripService().findTripline(
				tripline.getId());
		return CHECK;
	}
	/**
	 * 根据城市名称获取城市Id
	 * @param cityName
	 * @return
	 */
	public long getCityid(String cityName) {
		String citywhere = " where 1=1 ";
		if (cityName != null && !"".equals(cityName)) {
			citywhere += " and " + City.COL_name + " like '" + cityName + "'"; 
		}
		List<City> list = Server.getInstance().getHotelService().findAllCity(citywhere, "ORDER BY ID", -1, 0);
		if (list != null && list.size() > 0) {
			City bjcity = list.get(0);
			return bjcity.getId();
		}
		return 0;
	}

	/**
	 * 添加旅行线路
	 */
	public String add() throws Exception {
		tripline.setCreateuser(getLoginUser().getLoginname());
		tripline.setCreatetime(new Timestamp(System.currentTimeMillis()));
		tripline.setModifyuser(getLoginUser().getLoginname());
		tripline.setModifytime(new Timestamp(System.currentTimeMillis()));
//		String filepath = "/"+"web"+"/" +"images" +"/";
//		String realPath =getImgPath(filepath);
		String filePath1 = "/TripImages/"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/";
		String realPath =getRealPath_tripline(filePath1);
		File s = new File(realPath);
		if(!s.exists()){
			s.mkdirs();
		}
		File f = new File("");
		if (t_image != null) {
			f = this.t_image[0];
        String w = f.getName().toLowerCase();
			
			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			}else{
			String newname = Util.getFilename(f.getName());
			
			Util.copyfile(f, new File(s.getPath() + "/" + newname));
			
			tripline.setImage(filePath1 + newname);
		}
		}
		this.addActionMessage("操作成功！");
		tripline = Server.getInstance().getTripService().createTripline(tripline);
		listtriplinetype=Server.getInstance().getTripService().findAllTriplinetype("", "Order by ID desc", -1, 0);
		listtripsource=Server.getInstance().getTripService().findAllTriplinesource("", "Order by ID desc", -1, 0);
		return EDIT;
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
	 * 审核旅行线路
	 */
	public String check() throws Exception {
		tripline.setModifyuser(getLoginUser().getLoginname());
		tripline.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getTripService()
				.updateTriplineIgnoreNull(tripline);
		return LIST;
	}

	/**
	 * 编辑旅行线路
	 */
	public String edit() throws Exception {
		tripline.setModifyuser(getLoginUser().getLoginname());
		tripline.setModifytime(new Timestamp(System.currentTimeMillis()));
		//String filepath = "/"+"web"+"/" +"images" +"/";
		String filePath1 = "/TripImages/"+new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+"/";
		String realPath =getRealPath_tripline(filePath1);
		File s = new File(realPath);
		if(!s.exists()){
			s.mkdirs();
		}
		File f = new File("");
		if (t_image != null) {
			f = this.t_image[0];
        String w = f.getName().toLowerCase();
			
			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			}else{
			String newname = Util.getFilename(f.getName());
			
			Util.copyfile(f, new File(s.getPath() + "/" + newname));
			tripline.setImage(filePath1 + newname);
		}
		}
		Server.getInstance().getTripService()
				.updateTriplineIgnoreNull(tripline);
		
		this.addActionMessage("操作成功！");
		return EDIT;
	}
	/**
	 * 根据线路ID获取线路名称
	 */
	public String getTriplineName(long triplineid)
	{
		Tripline tripline=Server.getInstance().getTripService().findTripline(triplineid);
		return tripline != null && !"".equals(tripline.getName()) ? tripline.getName() : "";
	}
	/**
	 * 根据线路来源ID获取线路来源名称
	 */
	public String getTripSourceName(long id)
	{
		Triplinesource tsource=Server.getInstance().getTripService().findTriplinesource(id);
		return tsource != null && !"".equals(tsource.getName()) ? tsource.getName() : "";
	}
	/**
	 * 根据线路类型ID获取线路类型名称
	 */
	public String getTripTypeName(long id)
	{
		Triplinetype ttype=Server.getInstance().getTripService().findTriplinetype(id);
		return ttype != null && !"".equals(ttype.getName()) ? ttype.getName() : "";
	}
	/**
	 * 删除旅行线路
	 */
	public String delete() throws Exception {
		Server.getInstance().getTripService().deleteTripline(tripline.getId());
		return LIST;
	}
	
	public String toeditlanguage()throws Exception{
		
		Integer lan=tripline.getLanguage();
		Long uco=tripline.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		cityList=Server.getInstance().getHotelService().findAllCity("WHERE 1=1 AND "+City.COL_countryid+"=168", "ORDER BY ID", -1, 0);
		listtriplinetype=Server.getInstance().getTripService().findAllTriplinetype("", "Order by ID desc", -1, 0);
		listtripsource=Server.getInstance().getTripService().findAllTriplinesource("", "Order by ID desc", -1, 0);
		tripline = Server.getInstance().getTripService().findTriplinebylanguage(tripline.getUcode(),tripline.getLanguage());
		if(tripline==null)
		{
			tripline=new Tripline();
			tripline.setLanguage(lan);
			tripline.setUcode(uco);
			//以下是toadd参考方法
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			tripline = Server.getInstance().getTripService().findTripline(tripline.getId());
		}
		return EDIT;
	}
	
	/**
	 * 上传图片
	 * 
	 * @param files
	 *            要上传的图片
	 * @param path
	 *            指定相对路径的绝对路径
	 * @param dirName
	 *            上传文件在服务器端所放的文件夹名
	 * @return	  上传文件所在项目的路径
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
		return dirName + "/" + imgFile.getName();
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
					Server.getInstance().getTripService().deleteTripline(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 返回旅行线路对象
	 */

	public Object getModel() {
		return tripline;
	}

	public List<Tripline> getListTripline() {
		return listTripline;
	}

	public void setListTripline(List<Tripline> listTripline) {
		this.listTripline = listTripline;
	}

	public Tripline getTripline() {
		return tripline;
	}

	public void setTripline(Tripline tripline) {
		this.tripline = tripline;
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

	public File[] getT_image() {
		return t_image;
	}

	public void setT_image(File[] t_image) {
		this.t_image = t_image;
	}

	public String getImagerpath() {
		return imagerpath;
	}

	public void setImagerpath(String imagerpath) {
		this.imagerpath = imagerpath;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public long getS_tocityid() {
		return s_tocityid;
	}

	public void setS_tocityid(long s_tocityid) {
		this.s_tocityid = s_tocityid;
	}

	public long getS_fromcityid() {
		return s_fromcityid;
	}

	public void setS_fromcityid(long s_fromcityid) {
		this.s_fromcityid = s_fromcityid;
	}

	public List<TriplinetypeAction> getListtriplinetype() {
		return listtriplinetype;
	}

	public void setListtriplinetype(List<TriplinetypeAction> listtriplinetype) {
		this.listtriplinetype = listtriplinetype;
	}

	public List<Triplinesource> getListtripsource() {
		return listtripsource;
	}

	public void setListtripsource(List<Triplinesource> listtripsource) {
		this.listtripsource = listtripsource;
	}

}