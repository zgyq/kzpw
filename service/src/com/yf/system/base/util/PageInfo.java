/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 */
package com.yf.system.base.util;

public class PageInfo implements java.io.Serializable{
	/**
	 * 第几页
	 */
	private int pagenum;
	/**
	 * 每页行数
	 */
	private int pagerow =20;
	/**
	 * 总页数
	 */
	private int totalpage;
	/**
	 * 总行数
	 */
	
	
	private int totalrow;
	public int getPagenum() {
			if(pagenum<1)pagenum=1;
		return pagenum;
	}
	public void setTotalpage(int totalpage) {
			this.totalpage = totalpage;
		
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagerow() {
		if(pagerow<1)pagerow=15;
		return pagerow;
	}
	public void setPagerow(int pagerow) {
		this.pagerow = pagerow;
	}
	
	
	public int getTotalpage() {
		if(pagerow!=0){
			return  (totalrow + pagerow-1)/pagerow;
		}else{
			return this.totalpage;
		}
	}
	
	public int getTotalrow() {
		return totalrow;
	}
	public void setTotalrow(int totalrow) {
		this.totalrow = totalrow;
		
	}
	
	public int getLimit(){
		
		return pagerow;
		//return getPagerow() + getOffset();
	}
	public int getOffset(){
		if(pagenum <=1){
			return 0;
		}else{
			return  getPagerow() * (getPagenum()-1);
		}
	}
	
	public boolean hasFront(){
		return pagenum > 1 && getTotalpage()>1;
	}
	
	public boolean hasBack(){
		return pagenum >=0 && getTotalpage()>1 && pagenum < getTotalpage();
	}
	
}
