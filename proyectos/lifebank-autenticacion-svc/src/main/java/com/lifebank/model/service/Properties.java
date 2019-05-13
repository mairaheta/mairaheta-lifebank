package com.lifebank.model.service;

public final class Properties 
{
	
	public static class userStatus
	{
		private static final String ACTIVE  = "A";
		private static final String INACTIVE  = "I";
		private static final String BLOCKED  = "B";
		
		public static String getActive() 
		{
			return ACTIVE;
		}
		public static String getInactive() 
		{
			return INACTIVE;
		}
		public static String getBlocked() 
		{
			return BLOCKED;
		}
		
	}
	
	public static class serviceStatus
	{
		private static final String SUCCESS  = "success";
		private static final String ERROR  = "error";
		private static final String INVALID  = "invalid";
		private static final String BLOCKED  = "blocked";
		
		public static String getSuccess() 
		{
			return SUCCESS;
		}
		public static String getError() 
		{
			return ERROR;
		}
		public static String getInvalid() 
		{
			return INVALID;
		}
		public static String getBlocked() 
		{
			return BLOCKED;
		}
		

		
	}
	
	
	public static class error
	{
		private static final String ERROR_MSJ = "Error - Class: {} - Metodo: {}   en linea: {} => {}";

		public static String getErrorMsj() 
		{
			return ERROR_MSJ;
		}

	}
}
