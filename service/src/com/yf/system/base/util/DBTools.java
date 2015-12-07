
package com.yf.system.base.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 数据库功能类
 *     
 * @author 
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class DBTools{
	
	
	/**
	 * 关闭数据库操作资源
	 * @param conn
	 * @param rs
	 * @param sm
	 */

	public static void close(Connection conn, ResultSet rs, Statement sm){
		try{
			if(rs!=null){rs.close();rs=null;}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		try{
			if(sm!=null){sm.close();sm=null;}
		}catch(SQLException e2){
			e2.printStackTrace();
		}
		try{
			if(conn!=null){conn.close();conn=null;}
		}catch(SQLException e3){
			e3.printStackTrace();
		}
	}

	
	/**
	 * 取出对应名称的序列
	 * @param cloum
	 * @return
	 * @throws Exception
	 */
	

	public static synchronized long getID(Connection conn,String cloum)throws SQLException{
		long id = 0;
		
		String sql =   "SELECT * FROM T_B2BSEQUENCE WHERE C_NAME= ?";
		
		ResultSet  rs = null;
		PreparedStatement ps = null;

		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,cloum);
			rs = ps.executeQuery();
			
			if(rs.next()){
				id = rs.getInt("c_value");
				ps.close();
				ps = null;
				ps = conn.prepareStatement("UPDATE T_B2BSEQUENCE SET C_VALUE = ? WHERE C_NAME = ?" );
				ps.setLong(1,++id);
				ps.setString(2,cloum);
				ps.executeUpdate();
		   }else{
				ps.close();
				ps = null;
				ps = conn.prepareStatement("INSERT INTO T_B2BSEQUENCE VALUES(?,?)");
				ps.setLong(2,++id);
				ps.setString(1,cloum);
				ps.execute();
				
			}
			return id;
			
		} catch (SQLException e) {

			throw e;
		}finally{
			
			DBTools.close(conn, rs,ps);
		}
		
	}

	public static synchronized int DBUpdate(Connection conn,String sql)throws SQLException{
		
		
		
		PreparedStatement ps = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			return  ps.executeUpdate();
			
			
		} catch (SQLException e) {

			throw e;
		}finally{
			DBTools.close(conn,null,ps);
		}
		
	}
	

}
