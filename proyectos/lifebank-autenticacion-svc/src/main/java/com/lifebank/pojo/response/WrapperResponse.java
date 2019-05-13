package com.lifebank.pojo.response;

public class WrapperResponse<U> implements IResponse<WrapperHeaderResponse, U> {
	private WrapperHeaderResponse header;
	private U u;
	
	public WrapperResponse(){
		this.header = new WrapperHeaderResponse();
	}
	
	@Override
	public void setHeader(WrapperHeaderResponse header) {
		this.header = header;
	}

	@Override
	public WrapperHeaderResponse getHeader() {
		return this.header;
	}

	@Override
	public void setBody(U u) {
		this.u = u;
	}

	@Override
	public U getBody() {
		return this.u;
	}
}
