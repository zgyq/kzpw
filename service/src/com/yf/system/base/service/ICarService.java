package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.carbrand.Carbrand;
import com.yf.system.base.carimages.Carimages;
import com.yf.system.base.carinfo.Carinfo;
import com.yf.system.base.carorder.Carorder;
import com.yf.system.base.cars.Cars;
import com.yf.system.base.carsregion.Carsregion;
import com.yf.system.base.carstore.Carstore;
import com.yf.system.base.util.PageInfo;

public interface ICarService {

	   //粘贴到Service接口类
	 	/**
		 * 创建 汽车
		 * @param id
		 * @return deleted count 
		 */
		public Cars createCars(Cars cars) throws SQLException;
		
		/**
		 * 删除 汽车
		 * @param id
		 * @return deleted count 
		 */
		public int deleteCars(long id);
		
		
		/**
		 * 修改 汽车
		 * @param id
		 * @return updated count 
		 */
		public int updateCars(Cars cars);

			
		/**
		 * 修改 汽车但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateCarsIgnoreNull(Cars cars);
			
		
		/**
		 * 查找 汽车
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllCars(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 汽车
		 * @param id
		 * @return
		 */
		public Cars findCars(long id);
		
		
		/** 
		 * 查找 汽车
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllCarsForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找汽车
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllCarsBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 汽车
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteCarsBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countCarsBySql(String sql);
		

		   //粘贴到Service接口类
		 	/**
			 * 创建 汽车图片
			 * @param id
			 * @return deleted count 
			 */
			public Carimages createCarimages(Carimages carimages) throws SQLException;
			
			/**
			 * 删除 汽车图片
			 * @param id
			 * @return deleted count 
			 */
			public int deleteCarimages(long id);
			
			
			/**
			 * 修改 汽车图片
			 * @param id
			 * @return updated count 
			 */
			public int updateCarimages(Carimages carimages);

				
			/**
			 * 修改 汽车图片但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateCarimagesIgnoreNull(Carimages carimages);
				
			
			/**
			 * 查找 汽车图片
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllCarimages(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 汽车图片
			 * @param id
			 * @return
			 */
			public Carimages findCarimages(long id);
			
			
			/** 
			 * 查找 汽车图片
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllCarimagesForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找汽车图片
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllCarimagesBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 汽车图片
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteCarimagesBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countCarimagesBySql(String sql);
			
			 
			   //粘贴到Service接口类
			 	/**
				 * 创建 租车订单
				 * @param id
				 * @return deleted count 
				 */
				public Carorder createCarorder(Carorder carorder) throws SQLException;
				
				/**
				 * 删除 租车订单
				 * @param id
				 * @return deleted count 
				 */
				public int deleteCarorder(long id);
				
				
				/**
				 * 修改 租车订单
				 * @param id
				 * @return updated count 
				 */
				public int updateCarorder(Carorder carorder);

					
				/**
				 * 修改 租车订单但忽略空值 
				 * @param id
				 * @return 
				 */
				public int updateCarorderIgnoreNull(Carorder carorder);
					
				
				/**
				 * 查找 租车订单
				 * @param where
				 * @param orderby
				 * @param limit
				 * @param offset
				 * @return
				 */
				public List findAllCarorder(String where, String orderby,int limit,int offset);
					
				
				/**
				 * 查找 租车订单
				 * @param id
				 * @return
				 */
				public Carorder findCarorder(long id);
				
				
				/** 
				 * 查找 租车订单
				 * @param where
				 * @param orderby
				 * @param pageinfo
				 * @return
				 */
				public List findAllCarorderForPageinfo(String where, String orderby,PageInfo pageinfo);
					
				/** 
				 * 根据Sql查找租车订单
				 * @param sql
				 * @param limit
				 * @param offset
				 * @return
				 */
				public List findAllCarorderBySql(String sql,int limit,int offset);
				
				
				/**
				 * 执行Sql 租车订单
				 * @param sql 
				 * @return updated count 
				 */
				public int excuteCarorderBySql(String sql);
				
				/**
				 * 执行Sql 
				 * @param sql 
				 * @return  count 
				 */
				public int countCarorderBySql(String sql);
				

				   //粘贴到Service接口类
				 	/**
					 * 创建 租车门店
					 * @param id
					 * @return deleted count 
					 */
					public Carstore createCarstore(Carstore carstore) throws SQLException;
					
					/**
					 * 删除 租车门店
					 * @param id
					 * @return deleted count 
					 */
					public int deleteCarstore(long id);
					
					
					/**
					 * 修改 租车门店
					 * @param id
					 * @return updated count 
					 */
					public int updateCarstore(Carstore carstore);

						
					/**
					 * 修改 租车门店但忽略空值 
					 * @param id
					 * @return 
					 */
					public int updateCarstoreIgnoreNull(Carstore carstore);
						
					
					/**
					 * 查找 租车门店
					 * @param where
					 * @param orderby
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllCarstore(String where, String orderby,int limit,int offset);
						
					
					/**
					 * 查找 租车门店
					 * @param id
					 * @return
					 */
					public Carstore findCarstore(long id);
					
					
					/** 
					 * 查找 租车门店
					 * @param where
					 * @param orderby
					 * @param pageinfo
					 * @return
					 */
					public List findAllCarstoreForPageinfo(String where, String orderby,PageInfo pageinfo);
						
					/** 
					 * 根据Sql查找租车门店
					 * @param sql
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllCarstoreBySql(String sql,int limit,int offset);
					
					
					/**
					 * 执行Sql 租车门店
					 * @param sql 
					 * @return updated count 
					 */
					public int excuteCarstoreBySql(String sql);
					
					/**
					 * 执行Sql 
					 * @param sql 
					 * @return  count 
					 */
					public int countCarstoreBySql(String sql);
					
					//粘贴到Service接口类
				 	/**
					 * 创建 汽车品牌
					 * @param id
					 * @return deleted count 
					 */
					public Carbrand createCarbrand(Carbrand carbrand) throws SQLException;
					
					/**
					 * 删除 汽车品牌
					 * @param id
					 * @return deleted count 
					 */
					public int deleteCarbrand(long id);
					
					
					/**
					 * 修改 汽车品牌
					 * @param id
					 * @return updated count 
					 */
					public int updateCarbrand(Carbrand carbrand);

						
					/**
					 * 修改 汽车品牌但忽略空值 
					 * @param id
					 * @return 
					 */
					public int updateCarbrandIgnoreNull(Carbrand carbrand);
						
					
					/**
					 * 查找 汽车品牌
					 * @param where
					 * @param orderby
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllCarbrand(String where, String orderby,int limit,int offset);
						
					
					/**
					 * 查找 汽车品牌
					 * @param id
					 * @return
					 */
					public Carbrand findCarbrand(long id);
					
					
					/** 
					 * 查找 汽车品牌
					 * @param where
					 * @param orderby
					 * @param pageinfo
					 * @return
					 */
					public List findAllCarbrandForPageinfo(String where, String orderby,PageInfo pageinfo);
						
					/** 
					 * 根据Sql查找汽车品牌
					 * @param sql
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllCarbrandBySql(String sql,int limit,int offset);
					
					
					/**
					 * 执行Sql 汽车品牌
					 * @param sql 
					 * @return updated count 
					 */
					public int excuteCarbrandBySql(String sql);
					
					/**
					 * 执行Sql 
					 * @param sql 
					 * @return  count 
					 */
					public int countCarbrandBySql(String sql);
					 //粘贴到Service接口类
				 	/**
					 * 创建 送车上门区域
					 * @param id
					 * @return deleted count 
					 */
					public Carsregion createCarsregion(Carsregion carsregion) throws SQLException;
					
					/**
					 * 删除 送车上门区域
					 * @param id
					 * @return deleted count 
					 */
					public int deleteCarsregion(long id);
					
					
					/**
					 * 修改 送车上门区域
					 * @param id
					 * @return updated count 
					 */
					public int updateCarsregion(Carsregion carsregion);

						
					/**
					 * 修改 送车上门区域但忽略空值 
					 * @param id
					 * @return 
					 */
					public int updateCarsregionIgnoreNull(Carsregion carsregion);
						
					
					/**
					 * 查找 送车上门区域
					 * @param where
					 * @param orderby
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllCarsregion(String where, String orderby,int limit,int offset);
						
					
					/**
					 * 查找 送车上门区域
					 * @param id
					 * @return
					 */
					public Carsregion findCarsregion(long id);
					
					
					/** 
					 * 查找 送车上门区域
					 * @param where
					 * @param orderby
					 * @param pageinfo
					 * @return
					 */
					public List findAllCarsregionForPageinfo(String where, String orderby,PageInfo pageinfo);
						
					/** 
					 * 根据Sql查找送车上门区域
					 * @param sql
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllCarsregionBySql(String sql,int limit,int offset);
					
					
					/**
					 * 执行Sql 送车上门区域
					 * @param sql 
					 * @return updated count 
					 */
					public int excuteCarsregionBySql(String sql);
					
					/**
					 * 执行Sql 
					 * @param sql 
					 * @return  count 
					 */
					public int countCarsregionBySql(String sql);
					

					   //粘贴到Service接口类
					 	/**
						 * 创建 车型数据
						 * @param id
						 * @return deleted count 
						 */
						public Carinfo createCarinfo(Carinfo carinfo) throws SQLException;
						
						/**
						 * 删除 车型数据
						 * @param id
						 * @return deleted count 
						 */
						public int deleteCarinfo(long id);
						
						
						/**
						 * 修改 车型数据
						 * @param id
						 * @return updated count 
						 */
						public int updateCarinfo(Carinfo carinfo);

							
						/**
						 * 修改 车型数据但忽略空值 
						 * @param id
						 * @return 
						 */
						public int updateCarinfoIgnoreNull(Carinfo carinfo);
							
						
						/**
						 * 查找 车型数据
						 * @param where
						 * @param orderby
						 * @param limit
						 * @param offset
						 * @return
						 */
						public List findAllCarinfo(String where, String orderby,int limit,int offset);
							
						
						/**
						 * 查找 车型数据
						 * @param id
						 * @return
						 */
						public Carinfo findCarinfo(long id);
						
						
						/** 
						 * 查找 车型数据
						 * @param where
						 * @param orderby
						 * @param pageinfo
						 * @return
						 */
						public List findAllCarinfoForPageinfo(String where, String orderby,PageInfo pageinfo);
							
						/** 
						 * 根据Sql查找车型数据
						 * @param sql
						 * @param limit
						 * @param offset
						 * @return
						 */
						public List findAllCarinfoBySql(String sql,int limit,int offset);
						
						
						/**
						 * 执行Sql 车型数据
						 * @param sql 
						 * @return updated count 
						 */
						public int excuteCarinfoBySql(String sql);
						
						/**
						 * 执行Sql 
						 * @param sql 
						 * @return  count 
						 */
						public int countCarinfoBySql(String sql);
						
								
		
}
