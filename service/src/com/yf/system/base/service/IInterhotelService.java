package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.country.Country;
import com.yf.system.base.incity.Incity;
import com.yf.system.base.util.PageInfo;

public interface IInterhotelService {

	   //粘贴到Service接口类
	 	/**
		 * 创建 国际城市表
		 * @param id
		 * @return deleted count 
		 */
		public Incity createIncity(Incity incity) throws SQLException;
		
		/**
		 * 删除 国际城市表
		 * @param id
		 * @return deleted count 
		 */
		public int deleteIncity(long id);
		
		
		/**
		 * 修改 国际城市表
		 * @param id
		 * @return updated count 
		 */
		public int updateIncity(Incity incity);

			
		/**
		 * 修改 国际城市表但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateIncityIgnoreNull(Incity incity);
			
		
		/**
		 * 查找 国际城市表
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllIncity(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 国际城市表
		 * @param id
		 * @return
		 */
		public Incity findIncity(long id);
		
		
		/** 
		 * 查找 国际城市表
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllIncityForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找国际城市表
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllIncityBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 国际城市表
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteIncityBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countIncityBySql(String sql);
		
		//

		   //粘贴到Service接口类
		 	/**
			 * 创建 国家表
			 * @param id
			 * @return deleted count 
			 */
			public Country createCountry(Country country) throws SQLException;
			
			/**
			 * 删除 国家表
			 * @param id
			 * @return deleted count 
			 */
			public int deleteCountry(long id);
			
			
			/**
			 * 修改 国家表
			 * @param id
			 * @return updated count 
			 */
			public int updateCountry(Country country);

				
			/**
			 * 修改 国家表但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateCountryIgnoreNull(Country country);
				
			
			/**
			 * 查找 国家表
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllCountry(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 国家表
			 * @param id
			 * @return
			 */
			public Country findCountry(long id);
			
			
			/** 
			 * 查找 国家表
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllCountryForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找国家表
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllCountryBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 国家表
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteCountryBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countCountryBySql(String sql);
			
			
}
