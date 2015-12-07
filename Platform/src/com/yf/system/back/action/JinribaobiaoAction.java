/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.yf.system.back.server.Server;
import com.yf.system.base.jinribaobiao.Jinribaobiao;
import com.yf.system.base.util.PageInfo;


public class JinribaobiaoAction extends B2b2cbackAction {
	private List <  Jinribaobiao  >  listJinribaobiao;
	private Jinribaobiao jinribaobiao = new Jinribaobiao();
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	private File[] batchfile;
	
	
	/**
	 * 列表查询今日报表
	 */	
	public String execute()throws Exception{
		String where = " where 1=1 ";
		
		//if (s_name!=null && s_name.trim().length()!=0) {
			
			//where += " and " + Jinribaobiao.COL_name +" like '%" + s_name.trim()+"%'";	
		//}
	
	    List list = Server.getInstance().getAirService().findAllJinribaobiaoForPageinfo(where," ORDER BY ID ",pageinfo);
		pageinfo = (PageInfo)list.remove(0);
		listJinribaobiao = list;
		  if(pageinfo.getTotalrow()>0 &&   listJinribaobiao.size()==0){
			pageinfo.setPagenum(1);
			list = Server.getInstance().getAirService().findAllJinribaobiaoForPageinfo(where," ORDER BY ID ",pageinfo);
			pageinfo = (PageInfo)list.remove(0);
			listJinribaobiao = list;
		}
		
		return SUCCESS;
	}
	/**
	 * 转向到今日报表添加页面
	 */	
	public String toadd()throws Exception{
		return EDIT;
	}
	public String todaoru()throws Exception{
		
		return "todaoru";
	}
	public String daoru()throws Exception{//导入今日报表
		
		
	
		DateFormat format = new SimpleDateFormat("M/d/y HH:mm");
								
	//	FileInputStream fileInputStream = new FileInputStream("D://jinribaobiao2.xls");
		try {
		Workbook hotelbook = Workbook.getWorkbook(batchfile[0]);
		
		Sheet sheetHotel = hotelbook.getSheet(0);
		for(int d=1;d<sheetHotel.getRows();d++){
			
		Jinribaobiao jinribaobiao = new Jinribaobiao();
		
		Cell ordertime = sheetHotel.getCell(0, d);
		if(ordertime.getContents()==null||ordertime.getContents().equals("0")||ordertime.getContents().equals(0)||ordertime.getContents()==""){
			return LIST;
		}else{
		Date aaaa = format.parse(ordertime.getContents());
		jinribaobiao.setOrdertime(new java.sql.Timestamp(aaaa.getTime()));
		
		
		Cell pnr = sheetHotel.getCell(1, d);
		jinribaobiao.setPnr(pnr.getContents());
		
		Cell piaohao = sheetHotel.getCell(2, d);
		jinribaobiao.setTicketcode(piaohao.getContents());
		
		Cell bianhao = sheetHotel.getCell(3, d);
		jinribaobiao.setOrdercode(bianhao.getContents());
		
		Cell username = sheetHotel.getCell(4, d);
		jinribaobiao.setUsername(username.getContents());
		
		Cell shifa = sheetHotel.getCell(5, d);
		jinribaobiao.setStartcity(shifa.getContents());
		
		Cell mudi = sheetHotel.getCell(6, d);
		jinribaobiao.setEndcity(mudi.getContents());
		
		Cell shifaszm = sheetHotel.getCell(7, d);
		jinribaobiao.setStartcityszm(shifaszm.getContents());
		
		Cell mudiszm = sheetHotel.getCell(8, d);
		jinribaobiao.setEndcityszm(mudiszm.getContents());
		
		Cell hangbanhao = sheetHotel.getCell(9, d);
		jinribaobiao.setFlightnumber(hangbanhao.getContents());
		
		Cell cangwei = sheetHotel.getCell(10, d);
		jinribaobiao.setCabincode(cangwei.getContents());
		
		Cell qifei = sheetHotel.getCell(11, d);
		Date qitime = format.parse(qifei.getContents());
		jinribaobiao.setFlightdate(new java.sql.Timestamp(qitime.getTime()));
		
		Cell piaomian = sheetHotel.getCell(12, d);
		jinribaobiao.setPrice(Double.parseDouble(piaomian.getContents()));
		
		Cell tonghang = sheetHotel.getCell(13, d);
		String[] fandian = tonghang.getContents().trim().split("%");
		String fan =fandian[0];
		jinribaobiao.setFandian(Double.parseDouble(fan));
		
		Cell jijian = sheetHotel.getCell(14, d);
		jinribaobiao.setJijianranyou(Double.parseDouble(jijian.getContents()));
		
		Cell number = sheetHotel.getCell(15, d);
		String numb = number.getContents();
		long nu = Long.parseLong(numb);
		jinribaobiao.setNumber(nu);
		
		Cell shoukuan = sheetHotel.getCell(16, d);
		jinribaobiao.setSubmoney(Double.parseDouble(shoukuan.getContents()));
		
		
		
		Cell shouxufei = sheetHotel.getCell(17, d);
		jinribaobiao.setShouxufei(Double.parseDouble(shouxufei.getContents()));
		
		Cell tuikuan = sheetHotel.getCell(18, d);
		jinribaobiao.setTuikuan(Double.parseDouble(tuikuan.getContents()));
		
		Cell yingshou = sheetHotel.getCell(19, d);
		jinribaobiao.setYingshou(Double.parseDouble(yingshou.getContents()));
		
		Cell lirun = sheetHotel.getCell(20, d);
		jinribaobiao.setLirun(Double.parseDouble(lirun.getContents()));
		
		Cell zhifu = sheetHotel.getCell(21, d);
		jinribaobiao.setPaymethod(zhifu.getContents());
		
		Cell zhifutime = sheetHotel.getCell(22, d);
		Date zhitime = format.parse(zhifutime.getContents());
		jinribaobiao.setPaytime(new java.sql.Timestamp(zhitime.getTime()));
		
		Cell feitui = sheetHotel.getCell(23, d);
		if(feitui.getContents()!=null && feitui.getContents().length()>0){
		Date feitime = format.parse(feitui.getContents());
		jinribaobiao.setFeitime(new java.sql.Timestamp(feitime.getTime()));
		}
		Cell chupiao = sheetHotel.getCell(24, d);
		Date chupiaotime = format.parse(chupiao.getContents());
		jinribaobiao.setRttime(new java.sql.Timestamp(chupiaotime.getTime()));
		
		Cell states = sheetHotel.getCell(25, d);
		String st = states.getContents();
		//long state = Long.parseLong(st);
		jinribaobiao.setState(st);
		
	
		
		Server.getInstance().getAirService().createJinribaobiao(jinribaobiao);
		}
		
		}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("完成了阿");
		return LIST;
	}
	/**
	 * 转向到今日报表修改页面
	 */	
	public String toedit()throws Exception{
	jinribaobiao = Server.getInstance().getAirService().findJinribaobiao(jinribaobiao.getId());
		return EDIT;
	}
	
	/**
	 * 转向到今日报表审核页面
	 */	
	public String tocheck()throws Exception{
	jinribaobiao = Server.getInstance().getAirService().findJinribaobiao(jinribaobiao.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加今日报表
	 */		
	public String add()throws Exception{
	
		Server.getInstance().getAirService().createJinribaobiao(jinribaobiao);
		return LIST;
	}

	/**
	 * 审核今日报表
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updateJinribaobiaoIgnoreNull(jinribaobiao);
		return LIST;
	}
	


	/**
	 * 编辑今日报表
	 */		
	public String edit()throws Exception{
	
		Server.getInstance().getAirService().updateJinribaobiaoIgnoreNull(jinribaobiao);
		return LIST;
	}

	/**
	 * 删除今日报表
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deleteJinribaobiao(jinribaobiao.getId());
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
					Server.getInstance().getAirService().deleteJinribaobiao(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回今日报表对象
	 */		
	
	public Object getModel() {
		return jinribaobiao;
	}
	public List < Jinribaobiao >   getListJinribaobiao() {
		return listJinribaobiao;
	}
	public void setListJinribaobiao(List <  Jinribaobiao  >  listJinribaobiao) {
		this.listJinribaobiao = listJinribaobiao;
	}
	public Jinribaobiao getJinribaobiao() {
		return jinribaobiao;
	}
	public void setJinribaobiao(Jinribaobiao jinribaobiao) {
		this.jinribaobiao = jinribaobiao;
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
	public File[] getBatchfile() {
		return batchfile;
	}
	public void setBatchfile(File[] batchfile) {
		this.batchfile = batchfile;
	}
	
	
}