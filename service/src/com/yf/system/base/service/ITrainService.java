package com.yf.system.base.service;

import java.sql.SQLException;
import java.util.List;

import com.yf.system.base.train.Train;
import com.yf.system.base.traincity.Traincity;
import com.yf.system.base.trainfare.Trainfare;
import com.yf.system.base.traininfo.Traininfo;
import com.yf.system.base.trainpassenger.Trainpassenger;
import com.yf.system.base.trainroom.Trainroom;
import com.yf.system.base.trainsch.Trainsch;
import com.yf.system.base.trainseat.Trainseat;
import com.yf.system.base.trainstation.Trainstation;
import com.yf.system.base.util.PageInfo;

public interface ITrainService {
	
	/**
	 * 创建 火车时刻表
	 * @param id
	 * @return deleted count 
	 */
	public Train createTrain(Train train) throws SQLException;
	
	/**
	 * 删除 火车时刻表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrain(long id);
	
	
	/**
	 * 修改 火车时刻表
	 * @param id
	 * @return updated count 
	 */
	public int updateTrain(Train train);

		
	/**
	 * 修改 火车时刻表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainIgnoreNull(Train train);
		
	
	/**
	 * 查找 火车时刻表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrain(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 火车时刻表
	 * @param id
	 * @return
	 */
	public Train findTrain(long id);
	
	
	/** 
	 * 查找 火车时刻表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找火车时刻表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 火车时刻表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainBySql(String sql);
	
	
	
	/**
	 * 创建 火车票乘客
	 * @param id
	 * @return deleted count 
	 */
	public Trainpassenger createTrainpassenger(Trainpassenger trainpassenger) throws SQLException;
	
	/**
	 * 删除 火车票乘客
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainpassenger(long id);
	
	
	/**
	 * 修改 火车票乘客
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainpassenger(Trainpassenger trainpassenger);

		
	/**
	 * 修改 火车票乘客但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainpassengerIgnoreNull(Trainpassenger trainpassenger);
		
	
	/**
	 * 查找 火车票乘客
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainpassenger(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 火车票乘客
	 * @param id
	 * @return
	 */
	public Trainpassenger findTrainpassenger(long id);
	
	
	/** 
	 * 查找 火车票乘客
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainpassengerForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找火车票乘客
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainpassengerBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 火车票乘客
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainpassengerBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainpassengerBySql(String sql);
	
	
	/**
	 * 创建 火车售票点
	 * @param id
	 * @return deleted count 
	 */
	public Trainroom createTrainroom(Trainroom trainroom) throws SQLException;
	
	/**
	 * 删除 火车售票点
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainroom(long id);
	
	
	/**
	 * 修改 火车售票点
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainroom(Trainroom trainroom);

		
	/**
	 * 修改 火车售票点但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainroomIgnoreNull(Trainroom trainroom);
		
	
	/**
	 * 查找 火车售票点
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainroom(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 火车售票点
	 * @param id
	 * @return
	 */
	public Trainroom findTrainroom(long id);
	
	
	/** 
	 * 查找 火车售票点
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainroomForPageinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找火车售票点
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainroomBySql(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 火车售票点
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainroomBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainroomBySql(String sql);
	
	
	
	  
	  
	   //粘贴到Service接口类
	 	/**
		 * 创建 火车票城市
		 * @param id
		 * @return deleted count 
		 */
		public Traincity createTraincity(Traincity traincity) throws SQLException;
		
		/**
		 * 删除 火车票城市
		 * @param id
		 * @return deleted count 
		 */
		public int deleteTraincity(long id);
		
		
		/**
		 * 修改 火车票城市
		 * @param id
		 * @return updated count 
		 */
		public int updateTraincity(Traincity traincity);

			
		/**
		 * 修改 火车票城市但忽略空值 
		 * @param id
		 * @return 
		 */
		public int updateTraincityIgnoreNull(Traincity traincity);
			
		
		/**
		 * 查找 火车票城市
		 * @param where
		 * @param orderby
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTraincity(String where, String orderby,int limit,int offset);
			
		
		/**
		 * 查找 火车票城市
		 * @param id
		 * @return
		 */
		public Traincity findTraincity(long id);
		
		
		/** 
		 * 查找 火车票城市
		 * @param where
		 * @param orderby
		 * @param pageinfo
		 * @return
		 */
		public List findAllTraincityForPageinfo(String where, String orderby,PageInfo pageinfo);
			
		/** 
		 * 根据Sql查找火车票城市
		 * @param sql
		 * @param limit
		 * @param offset
		 * @return
		 */
		public List findAllTraincityBySql(String sql,int limit,int offset);
		
		
		/**
		 * 执行Sql 火车票城市
		 * @param sql 
		 * @return updated count 
		 */
		public int excuteTraincityBySql(String sql);
		
		/**
		 * 执行Sql 
		 * @param sql 
		 * @return  count 
		 */
		public int countTraincityBySql(String sql);
		
		
		  
		  
		   //粘贴到Service接口类
		 	/**
			 * 创建 火车站信息
			 * @param id
			 * @return deleted count 
			 */
			public Trainstation createTrainstation(Trainstation trainstation) throws SQLException;
			
			/**
			 * 删除 火车站信息
			 * @param id
			 * @return deleted count 
			 */
			public int deleteTrainstation(long id);
			
			
			/**
			 * 修改 火车站信息
			 * @param id
			 * @return updated count 
			 */
			public int updateTrainstation(Trainstation trainstation);

				
			/**
			 * 修改 火车站信息但忽略空值 
			 * @param id
			 * @return 
			 */
			public int updateTrainstationIgnoreNull(Trainstation trainstation);
				
			
			/**
			 * 查找 火车站信息
			 * @param where
			 * @param orderby
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllTrainstation(String where, String orderby,int limit,int offset);
				
			
			/**
			 * 查找 火车站信息
			 * @param id
			 * @return
			 */
			public Trainstation findTrainstation(long id);
			
			
			/** 
			 * 查找 火车站信息
			 * @param where
			 * @param orderby
			 * @param pageinfo
			 * @return
			 */
			public List findAllTrainstationForPageinfo(String where, String orderby,PageInfo pageinfo);
				
			/** 
			 * 根据Sql查找火车站信息
			 * @param sql
			 * @param limit
			 * @param offset
			 * @return
			 */
			public List findAllTrainstationBySql(String sql,int limit,int offset);
			
			
			/**
			 * 执行Sql 火车站信息
			 * @param sql 
			 * @return updated count 
			 */
			public int excuteTrainstationBySql(String sql);
			
			/**
			 * 执行Sql 
			 * @param sql 
			 * @return  count 
			 */
			public int countTrainstationBySql(String sql);
			
			
			  
			  
			   //粘贴到Service接口类
			 	/**
				 * 创建 火车席别
				 * @param id
				 * @return deleted count 
				 */
				public Trainseat createTrainseat(Trainseat trainseat) throws SQLException;
				
				/**
				 * 删除 火车席别
				 * @param id
				 * @return deleted count 
				 */
				public int deleteTrainseat(long id);
				
				
				/**
				 * 修改 火车席别
				 * @param id
				 * @return updated count 
				 */
				public int updateTrainseat(Trainseat trainseat);

					
				/**
				 * 修改 火车席别但忽略空值 
				 * @param id
				 * @return 
				 */
				public int updateTrainseatIgnoreNull(Trainseat trainseat);
					
				
				/**
				 * 查找 火车席别
				 * @param where
				 * @param orderby
				 * @param limit
				 * @param offset
				 * @return
				 */
				public List findAllTrainseat(String where, String orderby,int limit,int offset);
					
				
				/**
				 * 查找 火车席别
				 * @param id
				 * @return
				 */
				public Trainseat findTrainseat(long id);
				
				
				/** 
				 * 查找 火车席别
				 * @param where
				 * @param orderby
				 * @param pageinfo
				 * @return
				 */
				public List findAllTrainseatForPageinfo(String where, String orderby,PageInfo pageinfo);
					
				/** 
				 * 根据Sql查找火车席别
				 * @param sql
				 * @param limit
				 * @param offset
				 * @return
				 */
				public List findAllTrainseatBySql(String sql,int limit,int offset);
				
				
				/**
				 * 执行Sql 火车席别
				 * @param sql 
				 * @return updated count 
				 */
				public int excuteTrainseatBySql(String sql);
				
				/**
				 * 执行Sql 
				 * @param sql 
				 * @return  count 
				 */
				public int countTrainseatBySql(String sql);
				
				
				  
				  
				   //粘贴到Service接口类
				 	/**
					 * 创建 列车时刻
					 * @param id
					 * @return deleted count 
					 */
					public Trainsch createTrainsch(Trainsch trainsch) throws SQLException;
					
					/**
					 * 删除 列车时刻
					 * @param id
					 * @return deleted count 
					 */
					public int deleteTrainsch(long id);
					
					
					/**
					 * 修改 列车时刻
					 * @param id
					 * @return updated count 
					 */
					public int updateTrainsch(Trainsch trainsch);

						
					/**
					 * 修改 列车时刻但忽略空值 
					 * @param id
					 * @return 
					 */
					public int updateTrainschIgnoreNull(Trainsch trainsch);
						
					
					/**
					 * 查找 列车时刻
					 * @param where
					 * @param orderby
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllTrainsch(String where, String orderby,int limit,int offset);
						
					
					/**
					 * 查找 列车时刻
					 * @param id
					 * @return
					 */
					public Trainsch findTrainsch(long id);
					
					
					/** 
					 * 查找 列车时刻
					 * @param where
					 * @param orderby
					 * @param pageinfo
					 * @return
					 */
					public List findAllTrainschForPageinfo(String where, String orderby,PageInfo pageinfo);
						
					/** 
					 * 根据Sql查找列车时刻
					 * @param sql
					 * @param limit
					 * @param offset
					 * @return
					 */
					public List findAllTrainschBySql(String sql,int limit,int offset);
					
					
					/**
					 * 执行Sql 列车时刻
					 * @param sql 
					 * @return updated count 
					 */
					public int excuteTrainschBySql(String sql);
					
					/**
					 * 执行Sql 
					 * @param sql 
					 * @return  count 
					 */
					public int countTrainschBySql(String sql);
					
					
					  
					  
					   //粘贴到Service接口类
					 	/**
						 * 创建 车次信息
						 * @param id
						 * @return deleted count 
						 */
						public Traininfo createTraininfo(Traininfo traininfo) throws SQLException;
						
						/**
						 * 删除 车次信息
						 * @param id
						 * @return deleted count 
						 */
						public int deleteTraininfo(long id);
						
						
						/**
						 * 修改 车次信息
						 * @param id
						 * @return updated count 
						 */
						public int updateTraininfo(Traininfo traininfo);

							
						/**
						 * 修改 车次信息但忽略空值 
						 * @param id
						 * @return 
						 */
						public int updateTraininfoIgnoreNull(Traininfo traininfo);
							
						
						/**
						 * 查找 车次信息
						 * @param where
						 * @param orderby
						 * @param limit
						 * @param offset
						 * @return
						 */
						public List findAllTraininfo(String where, String orderby,int limit,int offset);
							
						
						/**
						 * 查找 车次信息
						 * @param id
						 * @return
						 */
						public Traininfo findTraininfo(long id);
						
						
						/** 
						 * 查找 车次信息
						 * @param where
						 * @param orderby
						 * @param pageinfo
						 * @return
						 */
						public List findAllTraininfoForPageinfo(String where, String orderby,PageInfo pageinfo);
							
						/** 
						 * 根据Sql查找车次信息
						 * @param sql
						 * @param limit
						 * @param offset
						 * @return
						 */
						public List findAllTraininfoBySql(String sql,int limit,int offset);
						
						
						/**
						 * 执行Sql 车次信息
						 * @param sql 
						 * @return updated count 
						 */
						public int excuteTraininfoBySql(String sql);
						
						/**
						 * 执行Sql 
						 * @param sql 
						 * @return  count 
						 */
						public int countTraininfoBySql(String sql);
						
						
						  
						  
						   //粘贴到Service接口类
						 	/**
							 * 创建 火车票价
							 * @param id
							 * @return deleted count 
							 */
							public Trainfare createTrainfare(Trainfare trainfare) throws SQLException;
							
							/**
							 * 删除 火车票价
							 * @param id
							 * @return deleted count 
							 */
							public int deleteTrainfare(long id);
							
							
							/**
							 * 修改 火车票价
							 * @param id
							 * @return updated count 
							 */
							public int updateTrainfare(Trainfare trainfare);

								
							/**
							 * 修改 火车票价但忽略空值 
							 * @param id
							 * @return 
							 */
							public int updateTrainfareIgnoreNull(Trainfare trainfare);
								
							
							/**
							 * 查找 火车票价
							 * @param where
							 * @param orderby
							 * @param limit
							 * @param offset
							 * @return
							 */
							public List findAllTrainfare(String where, String orderby,int limit,int offset);
								
							
							/**
							 * 查找 火车票价
							 * @param id
							 * @return
							 */
							public Trainfare findTrainfare(long id);
							
							
							/** 
							 * 查找 火车票价
							 * @param where
							 * @param orderby
							 * @param pageinfo
							 * @return
							 */
							public List findAllTrainfareForPageinfo(String where, String orderby,PageInfo pageinfo);
								
							/** 
							 * 根据Sql查找火车票价
							 * @param sql
							 * @param limit
							 * @param offset
							 * @return
							 */
							public List findAllTrainfareBySql(String sql,int limit,int offset);
							
							
							/**
							 * 执行Sql 火车票价
							 * @param sql 
							 * @return updated count 
							 */
							public int excuteTrainfareBySql(String sql);
							
							/**
							 * 执行Sql 
							 * @param sql 
							 * @return  count 
							 */
							public int countTrainfareBySql(String sql);
							
																								
}
