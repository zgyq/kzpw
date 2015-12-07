package com.yf.system.back.servlet;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.yf.system.back.server.Server;
import com.yf.system.base.orderinfo.Orderinfo;
import com.yf.system.base.passenger.Passenger;





public class JobXEPNR implements Job {//
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		WriteLog writeLog = new WriteLog();
		System.out.println("开始执行XEPNR定时任务,执行前,保证连接畅通中.....");
		
		//Server.getInstance().setUrl("");
		
		Server.getInstance().getTicketSearchService().commandFunction2("AVH/PEKSHA", "", "");
		
		try {
			Thread.sleep(1000*15);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		writeLog.write("XEPNR访问", "开始");
		String daytime=	new SimpleDateFormat("yyyy-MM-dd").format(new Timestamp(System.currentTimeMillis()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		daytime = sdf.format(calendar.getTime());
		
		String where=" where 1=1 AND "+Orderinfo.COL_paystatus+" =0  AND "+Orderinfo.COL_id+" IN ( SELECT "+Passenger.COL_orderid+" FROM "+Passenger.TABLE+" WHERE "+Passenger.COL_ticketnum+" IS  NULL )";
		where+=" and ( "+Orderinfo.COL_createtime+" >='"+daytime+ " 00:00:00' and "+Orderinfo.COL_createtime+" <='"+daytime+ " 23:59:59')";
		where+=" AND ";
		List<Orderinfo>listorder=Server.getInstance().getAirService().findAllOrderinfo(where, "", -1, 0);
		writeLog.write("XEPNR访问", "记录数:"+listorder.size());
		System.out.println("???:"+listorder.size());
		
		if(listorder.size()>0){
			for(int a=0;a<listorder.size();a++){
				if(listorder.get(a).getPnr()!=null){
					writeLog.write("XEPNR访问", "PNR:"+listorder.get(a).getPnr()+",订单ID:"+listorder.get(a).getId());
					Server.getInstance().getTicketSearchService().commandFunction2("rt"+listorder.get(a).getPnr().trim()+"$xepnr@", "", "");
					try {
						Thread.sleep(1000*10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			writeLog.write("XEPNR访问", "结束");
		}
		
		
	}
}



