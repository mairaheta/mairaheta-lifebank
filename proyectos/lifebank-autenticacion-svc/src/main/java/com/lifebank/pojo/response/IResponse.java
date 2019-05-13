package com.lifebank.pojo.response;

public interface IResponse<T, U> {
	public void setHeader(T t);
	
	public T getHeader();
	
	public void setBody(U u);
	
	public U getBody();
}
