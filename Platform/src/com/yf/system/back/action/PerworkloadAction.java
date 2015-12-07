/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 *
 */
 
package com.yf.system.back.action;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.yf.system.back.server.Server;
import com.yf.system.base.department.Department;
import com.yf.system.base.perworkload.Perworkload;
import com.opensymphony.webwork.ServletActionContext;


public class PerworkloadAction extends B2b2cbackAction {
	private List <  Perworkload  >  listPerworkload;
	private Perworkload perworkload = new Perworkload();
	private String treestr="";
	private List<Department> listDepartment;
	private List<Department> deptlist;
	private String strRenJunHtml;
	
	//批量操作ID数组
	private int[]selectid;
	
	//批量操作选项
	private int opt;
	
	//search
	//private String s_name;
	
	private String s_starttime;
	private String s_endtime;
	private String i_date;
	private String s_deptid;
	private String s_employeename;
	
	public String getI_date() {
		return i_date;
	}
	public void setI_date(String i_date) {
		this.i_date = i_date;
	}
	/**
	 * 列表查询人均工作量统计
	 */	
	public String execute()throws Exception{
		//绑定部门信息
		getString(-1l);
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(s_starttime==null||s_starttime.trim().length()==0)
		{
			s_starttime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		if(s_endtime==null||s_endtime.trim().length()==0)
		{
			s_endtime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());;
		}
		getDeptSaleReport();
		return SUCCESS;
	}
	/**
	 * 取得所有部门
	 */	
	private void getString(long id){
		List<  Department  > list = Server.getInstance().getMemberService().findAllDepartment("where "+Department.COL_parentid+" ="+id+" and "+Department.COL_agentid+" ="+getLoginUser().getAgentid() ,"ORDER BY ID",-1,0);
		if(!list.isEmpty()){
		
			for(Department m :list){
				if(id==-1){
					treestr+="var sub_"+ m.getId() 
						+" = new Ext.tree.TreeNode({ id:'"+ m.getId() +"',  text:'"+ m.getName() +"'});\n";
					
					treestr+="root.appendChild(sub_"+ m.getId() +");\n";
				}else{
					treestr+="var sub_"+ m.getId() 
					+" = new Ext.tree.TreeNode({ id:'"+ m.getId() +"', text:'"+ m.getName() +"'});\n";
			
					treestr+="sub_"+ id +".appendChild(sub_"+ m.getId() +");\n";
				
				}
				getString(m.getId());
			}
		}
	}
	/**
	 * 人均工作量报表
	 */
	public String getDeptSaleReport() throws Exception 
	{
		//部门集合
		deptlist=Server.getInstance().getMemberService().findAllDepartment("where C_AGENTID=46", "", -1, 0);
		int intdeptnum=deptlist.size();
		String strHtml="<table width='98%' id='tbdeptsale' border='1' cellspacing='0' cellpadding='0' class='table_color'>";
		strHtml+="<tr><td colspan='7' align='center'><span style='font-size:24px;font-weight:blod'>人均工作量报表</span></td></tr>";
		strHtml+="<tr><td colspan='7' align='right'><b>统计日期："+s_starttime+"至"+s_endtime+"</b></td></tr>";
		strHtml+="<tr class='tbody_color'><td class='table_color'><b>部门</b></td><td class='table_color'><b>员工号</b></td><td class='table_color'><b>姓名</b></td><td class='table_color'><b>张数</b></td><td class='table_color'><b>金额</b></td><td class='table_color'><b>退废票张数</b></td><td class='table_color'><b>退废票金额</b></td></tr>";
		if(intdeptnum>0)
		{
			//循环所有查询数据
			String employeename="";
			String strDeptid="";
			if(s_employeename!=null)
			{
				employeename="@employeename='"+s_employeename+"'";
			}
			else
			{
				employeename="@employeename="+s_employeename;
			}
			if(s_deptid!=null)
			{
				strDeptid="@deptid='"+s_deptid+"'";
			}
			else
			{
				strDeptid="@deptid="+s_deptid;
			}
			String strSP="[dbo].[sp_renjungongzuoliang] @date1 = N'"+s_starttime+"',@date2=N'"+s_endtime+"',"+strDeptid+","+employeename;
	        List listdeptsale=Server.getInstance().getSystemService().findMapResultByProcedure(strSP);
	        String strRowColor="";
	        for(int i=0;i<listdeptsale.size();i++)
	        {
	        	Map listdeptsalemap=(Map)listdeptsale.get(i);
	        	String strStyleWeek="";
	        	strHtml+="<tr><td width='20%' class='table_color'>"+getDeptName(listdeptsalemap.get("bumenid").toString())+"</td><td width='20%' class='table_color'>"+listdeptsalemap.get("yuangonghao")+"</td><td width='10%' class='table_color'>"+listdeptsalemap.get("xingming")+"</td><td width='10%' class='table_color'>"+listdeptsalemap.get("chupiaoshuliang")+"</td><td width='10%' class='table_color'>"+listdeptsalemap.get("jine")+"</td><td width='10%' class='table_color'>"+listdeptsalemap.get("tuipiaoshuliang")+"</td><td class='table_color'>"+listdeptsalemap.get("tuipiaokuan")+"</td></tr>";
	        }
		}
		strHtml+="</table><br /><br />";
		
		strRenJunHtml=strHtml;
		return strRenJunHtml;
	}
	
	public String getDeptName(String strDeptID)
	{
		String strDeptName="";
		
			Department depart=Server.getInstance().getMemberService().findDepartment(Long.parseLong(strDeptID));
			if(depart!=null)
			{
				strDeptName=depart.getName();
			}
		return strDeptName;
	}
	
	/**
	 * 导出xls
	 */	
	public void down()throws Exception{
		String fileName="人均工作量表.xls";   
		HttpServletResponse response=ServletActionContext.getResponse();                      
		response.setContentType("application/vnd.ms-excel");                      
		response.setHeader("Content-Disposition", "attachment;filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ));                   
		WritableWorkbook workbook=Workbook.createWorkbook(response.getOutputStream()); 
		WritableSheet sheet = workbook.createSheet("人均工作量表", 0);
		Label labelmerge = new Label(0, 0, "人均工作量表");
		sheet.addCell(labelmerge);
		sheet.mergeCells(0, 0, 6, 0);
		sheet.setColumnView(0, 20);
		sheet.setColumnView(1, 20);
		sheet.setColumnView(2, 20);
		sheet.setColumnView(3, 20);
		sheet.setColumnView(4, 20);
		sheet.setColumnView(5, 20);
		sheet.setColumnView(6, 20);
		Label labeldatestr = new Label(4,1, "统计日期：");
		sheet.addCell(labeldatestr);
		Label labeldate = new Label(5,1, s_starttime+"到"+s_endtime);
		sheet.addCell(labeldate);
		Label label0 = new Label(0, 2, "部门");
		sheet.addCell(label0);
		Label label1 = new Label(1, 2, "员工号");
		sheet.addCell(label1);
		Label label2 = new Label(2, 2, "姓名");
		sheet.addCell(label2);
		Label label3 = new Label(3, 2, "张数");
		sheet.addCell(label3);
		Label label4 = new Label(4, 2, "金额");
		sheet.addCell(label4);
		Label label5 = new Label(5, 2, "退废票张数");
		sheet.addCell(label5);
		Label label6 = new Label(6, 2, "退废票金额");
		sheet.addCell(label6);
		List list = reportlist();
		int x=3;
		int y=3;
		String departmentstr="";
		String departmentname="";
		 for(int i=0;i<list.size();i++)
		 {
			 Map map=(Map) list.get(i);
			 String label0_0="";
			 if(map.get("C_DEPARTMENT")!=null)
			 {
				 label0_0=map.get("C_DEPARTMENT").toString();
				 if(map.get("C_DEPARTMENT").toString().trim().equals(departmentstr))
				 {
					 label0_0=departmentname;
				 }else
				 {
					departmentstr=map.get("C_DEPARTMENT").toString().trim();
					Department department= Server.getInstance().getMemberService().findDepartment(Long.parseLong(map.get("C_DEPARTMENT").toString().trim()));
					if(department!=null)
					{
						departmentname=department.getName();
						label0_0=department.getName();
					}else
					{
						departmentname="未知";
						label0_0="未知";
					}
				 }
			 }
			 Label label00 = new Label(0, i+3, label0_0);    
	         sheet.addCell(label00); 
	         String label1_1="";
			 if(map.get("C_USERNUMBER")!=null)
			 {
				 label1_1=map.get("C_USERNUMBER").toString();
			 }
	         Label label11 = new Label(1, i+3, label1_1);    
	         sheet.addCell(label11);
	         String label2_2="";
			 if(map.get("C_NAME")!=null)
			 {
				 label2_2=map.get("C_NAME").toString();
			 }
	         Label label22 = new Label(2, i+3, label2_2);    
	         sheet.addCell(label22);
	         String label3_3="";
			 if(map.get("C_TICKETNUMBER")!=null)
			 {
				 label3_3=map.get("C_TICKETNUMBER").toString();
			 }
	         Label label33 = new Label(3, i+3, label3_3);    
	         sheet.addCell(label33);
	         String label4_4="";
			 if(map.get("C_TICKETMONEY")!=null)
			 {
				 label4_4=map.get("C_TICKETMONEY").toString();
			 }
	         Label label44 = new Label(4, i+3, label4_4);    
	         sheet.addCell(label44);
	         String label5_5="";
			 if(map.get("C_TUINUMBER")!=null)
			 {
				 label5_5=map.get("C_TUINUMBER").toString();
			 }
	         Label label55 = new Label(5, i+3, label5_5);    
	         sheet.addCell(label55);
	         String label6_6="";
			 if(map.get("C_TUIMONEY")!=null)
			 {
				 label6_6=map.get("C_TUIMONEY").toString();
			 }
	         Label label66 = new Label(6, i+3, label6_6);    
	         sheet.addCell(label66);
	        
		 }
		 for(int i=0;i<list.size();i++)
		 {
			 Map map=(Map) list.get(i);
			 if(map.get("C_DEPARTMENT")!=null)
	         {
	        	 if(departmentstr.equals(map.get("C_DEPARTMENT").toString().trim()))
				 {
					 y++;
				 }else
				 {
					 
					 departmentstr=map.get("C_DEPARTMENT").toString().trim();
					 if(x!=y)
					 {
						 sheet.mergeCells(0, x, 0, y);
					 }
					 x=y;
				 }
	         }
		 }
        workbook.write();    
        workbook.close();   
	}
	
	public List reportlist()
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(s_starttime==null||s_starttime.trim().length()==0)
		{
			s_starttime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());
		}
		if(s_endtime==null||s_endtime.trim().length()==0)
		{
			s_endtime=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime());;
		}
		String sql = "SELECT C_USERNUMBER,C_NAME,"
				+ "SUM(C_TICKETNUMBER)as C_TICKETNUMBER "
				+ ",SUM(C_TICKETMONEY) as C_TICKETMONEY "
				+ ",SUM(C_TUINUMBER) as C_TUINUMBER "
				+ ",SUM(C_TUIMONEY) as C_TUIMONEY "
				+ ",C_DEPARTMENT "
				+ "FROM [DFHK_DB].[dbo].[T_PERWORKLOAD] where C_DATETIME  between  '"
				+ s_starttime + "' and '" + s_endtime + "'"
				+ " group by C_DEPARTMENT,C_USERNUMBER,C_NAME";
		System.out.println(sql);
		return Server.getInstance().getSystemService().findMapResultBySql(sql, null);
	}
	/**
	 * 转向到人均工作量统计添加页面
	 */	
	public String toadd()throws Exception{
		listDepartment=Server.getInstance().getMemberService().findAllDepartment("", "", -1, 0);
		return EDIT;
	}
	/**
	 * 转向到人均工作量统计修改页面
	 */	
	public String toedit()throws Exception{
	listDepartment=Server.getInstance().getMemberService().findAllDepartment("", "", -1, 0);
	perworkload = Server.getInstance().getAirService().findPerworkload(perworkload.getId());
	i_date=formatTimestampyyyyMMdd(perworkload.getDatetime());
		return EDIT;
	}
	
	/**
	 * 转向到人均工作量统计审核页面
	 */	
	public String tocheck()throws Exception{
	perworkload = Server.getInstance().getAirService().findPerworkload(perworkload.getId());
		return CHECK;
	}
	
	
	/**
	 * 添加人均工作量统计
	 */		
	public String add()throws Exception{
		perworkload.setDatetime(dateToTimestamp(i_date));
		Server.getInstance().getAirService().createPerworkload(perworkload);
		return LIST;
	}

	/**
	 * 审核人均工作量统计
	 */		
	public String check()throws Exception{
	
		Server.getInstance().getAirService().updatePerworkloadIgnoreNull(perworkload);
		return LIST;
	}
	


	/**
	 * 编辑人均工作量统计
	 */		
	public String edit()throws Exception{
		perworkload.setDatetime(dateToTimestamp(i_date));
		Server.getInstance().getAirService().updatePerworkloadIgnoreNull(perworkload);
		return LIST;
	}

	/**
	 * 删除人均工作量统计
	 */		
	public String delete()throws Exception{	
		Server.getInstance().getAirService().deletePerworkload(perworkload.getId());
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
					Server.getInstance().getAirService().deletePerworkload(i);
				}
			
				break;
			default:
				break;
			
			}
		}
		return LIST;
	}






	/**
	 *  返回人均工作量统计对象
	 */		
	
	public Object getModel() {
		return perworkload;
	}
	public List < Perworkload >   getListPerworkload() {
		return listPerworkload;
	}
	public void setListPerworkload(List <  Perworkload  >  listPerworkload) {
		this.listPerworkload = listPerworkload;
	}
	public Perworkload getPerworkload() {
		return perworkload;
	}
	public void setPerworkload(Perworkload perworkload) {
		this.perworkload = perworkload;
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
	public String getS_starttime() {
		return s_starttime;
	}
	public void setS_starttime(String s_starttime) {
		this.s_starttime = s_starttime;
	}
	public String getS_endtime() {
		return s_endtime;
	}
	public void setS_endtime(String s_endtime) {
		this.s_endtime = s_endtime;
	}
	public List<Department> getListDepartment() {
		return listDepartment;
	}
	public void setListDepartment(List<Department> listDepartment) {
		this.listDepartment = listDepartment;
	}
	public String getTreestr() {
		return treestr;
	}
	public void setTreestr(String treestr) {
		this.treestr = treestr;
	}
	public String getS_deptid() {
		return s_deptid;
	}
	public void setS_deptid(String s_deptid) {
		this.s_deptid = s_deptid;
	}
	public String getS_employeename() {
		return s_employeename;
	}
	public void setS_employeename(String s_employeename) {
		this.s_employeename = s_employeename;
	}
	public List<Department> getDeptlist() {
		return deptlist;
	}
	public void setDeptlist(List<Department> deptlist) {
		this.deptlist = deptlist;
	}
	public String getStrRenJunHtml() {
		return strRenJunHtml;
	}
	public void setStrRenJunHtml(String strRenJunHtml) {
		this.strRenJunHtml = strRenJunHtml;
	}
	
	
}