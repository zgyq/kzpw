/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.orderinfo;

import java.util.List;

import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.passenger.Passenger;

/**
 *订单信息表
 *在此类中添加方法和属性，在第一次生成后将不会再做统一更改。
 */
public class Orderinfo extends OrderinfoBean{
	
	private float totalinsurprice;
	
	//小陈添加，关联订单
	private List<Passenger> passengerlist;
	//订单所属采购。
	private Customeragent agent;
	//总保险 此处关联不符合面向对象。待整理...
	public float getTotalinsurprice() {
		return totalinsurprice;
	}

	public void setTotalinsurprice(float totalinsurprice) {
		this.totalinsurprice = totalinsurprice;
	}

	/**
	  *0.新订单等待支付
	  */
	public static final Integer XINZENG=0;
	/**
	  *1.采购商取消交易，交易结束
	  */
	public static final Integer QUXIAO=1;
	/**
	  *2.已经付款，等待出票(自动出票则没有这一步)
	  */
	public static final Integer YIFUKUANCHUPIAO=2;
	/**
	  *3.已经出票，交易结束
	  */
	public static final Integer YICHUPIAO=3;
	/**
	  *4.取消出票，等待退款
	  */
	public static final Integer QUXIAOCHUPIAO=4;
	/**
	  *5.改签订单，等待审核
	  */
	public static final Integer GAIQIAN=5;
	/**
	  *6.改签审核通过，机票被挂起，等待支付
	  */
	public static final Integer GAIQIANSHEHETONGGUO=6;
	/**
	  *7.已经付款，等待解挂
	  */
	public static final Integer YIFUKUANJIEGUA=7;
	/**
	  *8.已经解挂，交易结束
	  */
	public static final Integer YIJIEGUAJIESHU=8;
	/**
	  *9.改签订单审核不通过，交易结束
	  */
	public static final Integer GAIQIANBUTONGGUO=9;
	/**
	  *10.退票订单，等待审核
	  */
	public static final Integer TUIPIAODINGDANDAISHENHE=10;
	/**
	  *11.已经退款，交易结束
	  */
	public static final Integer YIJINGTUIKUANJIESHU=11;
	/**
	  *12.退票订单审核不通过，交易结束
	  */
	public static final Integer TUIPIAOSHENHEBUTONGGUOJIESHU=12;
	/**
	  *13.废票订单，等待审核
	  */
	public static final Integer FEIPIAODAISHENHE=13;
	/**
	  *14.废票审核通过，交易结束
	  */
	public static final Integer FEIPIAOSHENHETONGGUO=14;
	/**
	  *15.废退票订单审核不通过，交易结束
	  */
	public static final Integer FEIPIAOSHENHEBUTONGGUO=15;
	/**
	  *16.退款订单，延迟处理
	  */
	public static final Integer TUIKUANDINGDANYANCHICHULI=16;
	/**
	  *17.线下订单待确认
	  */
	public static final Integer XIANXIADINGDANDAIQUEREN=17;
	/**
	  *18.线下订单审核不通过，交易结束
	  */
	public static final Integer XIANXIADINGDANSHENHEBUTONGGUO=18;
	/**
	  *19.暂不能出票，等待处理
	  */
	public static final Integer BUNENGCHUPIAODENGDAICHULI=19;
	
	/**
	  *20.退票审核通过，等待退款
	  */
	public static final Integer TUIPIAOSHENHETONGGUO=20;
	
	
	//送票方式
	/**
	  *1.门市自取
	  */
	public static final Integer MENSHIZIQU=1;
	/**
	  *2.票到付款
	  */
	public static final Integer PIAODAOFUKUAN=2;
	/**
	  *3.机场取票
	  */
	public static final Integer JICHANFQUPIAO=3;
	
	/**
	  *4.不需要
	  */
	public static final Integer BUXUYAOTICKET=4;
	public List<Passenger> getPassengerlist() {
		return passengerlist;
	}

	public void setPassengerlist(List<Passenger> passengerlist) {
		this.passengerlist = passengerlist;
	}

	public Customeragent getAgent() {
		return agent;
	}

	public void setAgent(Customeragent agent) {
		this.agent = agent;
	}
	

}
