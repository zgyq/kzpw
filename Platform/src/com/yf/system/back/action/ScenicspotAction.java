/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */

package com.yf.system.back.action;

import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.yf.system.back.server.Server;
import com.yf.system.base.city.City;
import com.yf.system.base.province.Province;
import com.yf.system.base.region.Region;
import com.yf.system.base.scenicspot.Scenicspot;
import com.yf.system.base.sysconfig.Sysconfig;
import com.yf.system.base.util.PageInfo;
import com.yf.system.base.util.Util;
import com.opensymphony.webwork.ServletActionContext;

public class ScenicspotAction extends B2b2cbackAction {
	private static final long serialVersionUID = 5828183589276410257L;
	private List<Scenicspot> listScenicspot;
	private Scenicspot scenicspot = new Scenicspot();
	// 地区列表
	private List<Region> regionlist;
	// 城市列表
	private List<City> cityList;
	// 省份列表
	private List<Province> provinceList;
	// 景点所在省份ID
	private long s_provinceId;
	private String regionid;
	private String cityid;
	
	private long s_cityid;
	private long s_regionid;
	// 近点所在城市ID
	private long s_cityId;
	// 图片
	private File[] s_image;
	public final static String FAILED_STR = "uploadfailed";
	// 批量操作ID数组
	private int[] selectid;

	// 批量操作选项
	private int opt;

	// search
	// private String s_name;

	/**
	 * 列表查询景点
	 */
	public String execute() throws Exception {
		String where = " where 1=1 ";

		cityList=Server.getInstance().getHotelService().findAllCity("WHERE 1=1 AND "+City.COL_countryid+"=168", "ORDER BY C_SORT", -1, 0);
		if (scenicspot.getName() != null && !"".equals(scenicspot.getName())) {
			where += " and " + Scenicspot.COL_name + " like '%" + scenicspot.getName() + "%'";
		}
		if(s_cityid!=-1 && s_cityid!=0)
		{
			where += " and " + Scenicspot.COL_cityid + "=" + s_cityid;
		}
		if(s_regionid!=-1 && s_regionid!=0)
		{
			where += " and " + Scenicspot.COL_regionid + "=" + s_regionid;
		}
		List list = Server.getInstance().getTripService()
				.findAllScenicspotForPageinfo(where, " ORDER BY ID DESC", pageinfo);
		pageinfo = (PageInfo) list.remove(0);
		listScenicspot = list;
		if (pageinfo.getTotalrow() > 0 && listScenicspot.size() == 0) {
			pageinfo.setPagenum(1);
			list = Server.getInstance().getTripService()
					.findAllScenicspotForPageinfo(where, " ORDER BY ID ",
							pageinfo);
			pageinfo = (PageInfo) list.remove(0);
			listScenicspot = list;
		}

		return SUCCESS;
	}

	/**
	 * 转向到景点添加页面
	 */
	public String toadd() throws Exception {
		// 获取所有省份
		provinceList = Server.getInstance().getHotelService().findAllProvince(" where 1=1", "ORDER BY C_NAME", -1, 0);
		return EDIT;
	}
	
	public String getimgPath()
	{
		return ((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='weppath'","",-1,0).get(0)).getValue()+"/";
	}
	public void getRegionDataById() throws Exception {
		String strRetData = "";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=GB2312");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		List<Region> listRegion = Server.getInstance().getHotelService().findAllRegion("WHERE 1=1 AND "+Region.COL_cityid+"="+s_cityid, "", -1, 0);
		sb.append("<select name='s_regionid' id='regionid'>");
		sb.append("<option value='-1'>----请选择----</option>");
		String strChecked="";
		
		for (Region region : listRegion) {
			if(region.getId()==s_regionid)
			{
				strChecked="selected='selected'";
			}
			sb.append("<option value="+region.getId()+" "+strChecked+">"+region.getName()+"</option>");
		}
		sb.append("</select>");
		// return strRetData;
		System.out.println(sb);
		out.print(sb);
		out.flush();
		out.close();
	}
	/**
	 * 转向到景点修改页面
	 */
	public String toedit() throws Exception {
		// 获取所有省份
		provinceList = Server.getInstance().getHotelService().findAllProvince(" where 1=1", "ORDER BY C_NAME", -1, 0);
		scenicspot = Server.getInstance().getTripService().findScenicspot(
				scenicspot.getId());
		City city = Server.getInstance().getHotelService().findCity(scenicspot.getCityid());
		if(city!=null){
		s_provinceId = city.getProvinceid();
		}
		return EDIT;
	}

	/**
	 * 转向到景点审核页面
	 */
	public String tocheck() throws Exception {
		scenicspot = Server.getInstance().getTripService().findScenicspot(
				scenicspot.getId());
		City city = Server.getInstance().getHotelService().findCity(scenicspot.getCityid());
		s_provinceId = city.getProvinceid();
		return CHECK;
	}

	/**
	 * 添加景点
	 */
	public String add() throws Exception {
		scenicspot.setCreateuser(getLoginUser().getLoginname());
		scenicspot.setCreatetime(new Timestamp(System.currentTimeMillis()));
		scenicspot.setModifyuser(getLoginUser().getLoginname());
		scenicspot.setModifytime(new Timestamp(System.currentTimeMillis()));
		scenicspot.setPrice(scenicspot.getPrice());
//		if ( != null) {
//			String imagePath = uploadImage(s_image, "/", "scenicspots");
//			scenicspot.setImage(imagePath);
//		}
		//String filepath = "/"+"web"+"/" +"images" +"/";
		String filePath1 = "/scenicspots/";
		String realPath =getRealPath(filePath1);
		
		File s = new File(realPath);
		if(!s.exists()){
			s.mkdirs();
		}
		File f = new File("");
		if (s_image != null) {
			f = this.s_image[0];
        String w = f.getName().toLowerCase();
			
			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			}else{
			String newname = Util.getFilename(f.getName());
			
			Util.copyfile(f, new File(s.getPath() + "/" + newname));
			
			scenicspot.setImage(filePath1 + newname);
		}
		}
		scenicspot = Server.getInstance().getTripService().createScenicspot(scenicspot);
		this.addActionMessage("您的操作已成功！");
		return EDIT;
	}
	
	private static String[] fileStrs = { "gif", "jpg", "png" };
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

	/**
	 * 审核景点
	 */
	public String check() throws Exception {
		scenicspot.setModifyuser(getLoginUser().getLoginname());
		scenicspot.setModifytime(new Timestamp(System.currentTimeMillis()));

		Server.getInstance().getTripService().updateScenicspotIgnoreNull(
				scenicspot);
		return LIST;
	}

	/**
	 * 编辑景点
	 */
	public String edit() throws Exception {
		scenicspot.setModifyuser(getLoginUser().getLoginname());
		scenicspot.setModifytime(new Timestamp(System.currentTimeMillis()));
//		if (s_image != null) {
//			String imagePath = uploadImage(s_image, "/", "scenicspots");
//			scenicspot.setImage(imagePath);
//		}
		String filePath1 = "/scenicspots/";
		String realPath =getRealPath(filePath1);
		File s = new File(realPath);
		if(!s.exists()){
			s.mkdirs();
		}
		File f = new File("");
		if (s_image != null) {
			f = this.s_image[0];
        String w = f.getName().toLowerCase();
			
			if (!isIllegalfile(w)) {
				System.out.println("上传的不合法");
				return "nouplogo";
			}else{
			String newname = Util.getFilename(f.getName());
			
			Util.copyfile(f, new File(s.getPath() + "/" + newname));
			
			scenicspot.setImage(filePath1 + newname);
		}
		}
		Server.getInstance().getTripService().updateScenicspotIgnoreNull(
				scenicspot);
		this.addActionMessage("您的操作已成功！");
		return "list1";
	}

	/**
	 * 删除景点
	 */
	public String delete() throws Exception {
		Server.getInstance().getTripService().deleteScenicspot(
				scenicspot.getId());
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
					Server.getInstance().getTripService().deleteScenicspot(i);
				}

				break;
			default:
				break;

			}
		}
		return LIST;
	}

	/**
	 * 根据省份Id获取省份名称
	 * 
	 * @param areaId
	 * @return
	 */
	public String getProvinceName(long regionId) {
		Province pro = Server.getInstance().getHotelService().findProvince(
				regionId);
		return pro != null ? pro.getName() : "";
	}


	/**
	 * 根据区域ID获取区域名称
	 * 
	 * @param regionId
	 * @return
	 */
	public String getRegionName(long regionId) {
		Region region = Server.getInstance().getHotelService().findRegion(
				regionId);
		return region != null ? region.getName() : "";
	}
	
	/**
	 * ajax输出城市列表组成的字符串
	 * @return
	 * @throws Exception
	 */
	public String ajaxGetCityList() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		String where = " where " + City.COL_provinceid + "=" + s_provinceId+" and "+City.COL_countryid+" =168"; 
		cityList = Server.getInstance().getHotelService().findAllCity(where, "ORDER BY C_NAME", -1, 0);
		StringBuffer sb = new StringBuffer();
		for (City city : cityList) {
			String temp = city.getId() + "_" + city.getName();
			if (sb.length() == 0) {
				sb.append(temp);
			} else {
				sb.append("," + temp);
			}
		}
		System.out.println("sb2=="+sb);
		Writer writer = response.getWriter();
		writer.write(sb.toString());
		writer.flush();
		writer.close();
		return SUCCESS;
	}
	
	/**
	 * ajax输出城市列表组成的字符串
	 * @return
	 * @throws Exception
	 */
	public String ajaxGetRegionList() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		String where = " where " + Region.COL_cityid + "=" + s_cityId + " and " + Region.COL_type + "='行政区'"; 
		regionlist = Server.getInstance().getHotelService().findAllRegion(where, "ORDER BY C_NAME", -1, 0);
		StringBuffer sb = new StringBuffer();
		for (Region region : regionlist) {
			String temp = region.getId() + "_" + region.getName();
			if (sb.length() == 0) {
				sb.append(temp);
			} else {
				sb.append("," + temp);
			}
		}
		
		System.out.println("sb=="+sb);
		Writer writer = response.getWriter();
		writer.write(sb.toString());
		writer.flush();
		writer.close();
		return SUCCESS;
	}
	
	public String toeditlanguage()throws Exception{
		
		Integer lan=scenicspot.getLanguage();
		Long uco=scenicspot.getUcode();
		//调用此方法时需在service项目中对应的service添加方法
		provinceList = Server.getInstance().getHotelService().findAllProvince(" where 1=1", "ORDER BY C_NAME", -1, 0);
		scenicspot = Server.getInstance().getTripService().findScenicspotbylanguage(scenicspot.getUcode(),scenicspot.getLanguage());
		if(scenicspot==null)
		{
			scenicspot=new Scenicspot();
			scenicspot.setLanguage(lan);
			scenicspot.setUcode(uco);
			//以下是toadd参考方法
			provinceList = Server.getInstance().getHotelService().findAllProvince(" where 1=1", "ORDER BY C_NAME", -1, 0);
		}else
		{
			//以下是toedit参考方法 注：通过对象id获取对象方法前面已经此处不用添加如果toedit里面只有通过id获取对象 else可以不写
			provinceList = Server.getInstance().getHotelService().findAllProvince(" where 1=1", "ORDER BY C_NAME", -1, 0);
			City city = Server.getInstance().getHotelService().findCity(scenicspot.getCityid());
			s_provinceId = city.getProvinceid();
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
	 * 返回景点对象
	 */

	public Object getModel() {
		return scenicspot;
	}

	public List<Scenicspot> getListScenicspot() {
		return listScenicspot;
	}

	public void setListScenicspot(List<Scenicspot> listScenicspot) {
		this.listScenicspot = listScenicspot;
	}

	public Scenicspot getScenicspot() {
		return scenicspot;
	}

	public void setScenicspot(Scenicspot scenicspot) {
		this.scenicspot = scenicspot;
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

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public List<Region> getRegionlist() {
		return regionlist;
	}

	public void setRegionlist(List<Region> regionlist) {
		this.regionlist = regionlist;
	}

	public List<Province> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Province> provinceList) {
		this.provinceList = provinceList;
	}

	public long getS_provinceId() {
		return s_provinceId;
	}

	public void setS_provinceId(long id) {
		s_provinceId = id;
	}

	public long getS_cityId() {
		return s_cityId;
	}

	public void setS_cityId(long id) {
		s_cityId = id;
	}

	public File[] getS_image() {
		return s_image;
	}

	public void setS_image(File[] s_image) {
		this.s_image = s_image;
	}

	public String getRegionid() {
		return regionid;
	}

	public void setRegionid(String regionid) {
		this.regionid = regionid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public long getS_cityid() {
		return s_cityid;
	}

	public void setS_cityid(long s_cityid) {
		this.s_cityid = s_cityid;
	}

	public long getS_regionid() {
		return s_regionid;
	}

	public void setS_regionid(long s_regionid) {
		this.s_regionid = s_regionid;
	}

}