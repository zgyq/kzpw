package com.yf.system.back.servlet;

public class testCode {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		String[] keywords = new String[]{
				"EXCEPT",
				"EXEC",
				"ALTER",
				"EXECUTE",
				"FETCH",
				"BACKUP",
				"RESTORE",
				"GRANT",
				"REVOKE",
				"IDENTITY_INSERT",
				"COLUMN",
				"INSERT",
				"SETUSER",
				"SHUTDOWN",
				"CREATE",
				"SYSTEM_USER",
				"KILL",
				"DELETE",
				"UPDATE",
				"DROP",
				"DUMP",
				" OR",
				"OR "
				
		}; 
		String str="Recently voted the 'Wld's Leading Lifestyle Hotel' OR  f the second year running at the prestigious Wld Travel Awards, the Hilton Beijing Wangfujing hotel offers some of the largest hotel rooms in the city. Set in the heart of Beijing’s shopping district, indulge in some retail therapy either visit nearby Beijing attractions. The iconic Tiananmen Square is just a ten minute walk from the hotel. ";
		// TODO Auto-generated method stub
		if(str!=null && (!str.equals("null"))&& str.length()>0){
			for(String key : keywords){
				
				if( str.toUpperCase().contains(key) ){
					System.out.println("error:"+key+str.indexOf(key));
					break;
				}
				
			}
			
		}
	}
	
}
