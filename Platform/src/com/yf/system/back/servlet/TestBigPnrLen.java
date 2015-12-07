package com.yf.system.back.servlet;

public class TestBigPnrLen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String bigpnr="MZKGJV 10.XMN345";
		System.out.println(bigpnr.length());
		System.out.println(bigpnr.substring(0, 6));
		
		
		/*String forwork="b2bticketorder!payorder.action?orderinfo.id=111111&s_oldzratevalue=1000&s_bestzratevalue=";
		String orderid=	forwork.split("&")[0].trim().split("=")[1].trim();
		System.out.println(orderid);*/
		
		String username="12 345,";
		
		username=username.substring(0, username.length()-1);
		System.out.println(username);
	}

}
