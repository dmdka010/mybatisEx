package org.iclass.controller;

import java.util.Objects;

public class RequestKeyValue {
	
	private String url;
	private String method;
	
	@Override
	public int hashCode() {
		return Objects.hash(method, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestKeyValue other = (RequestKeyValue) obj;
		return Objects.equals(method, other.method) && Objects.equals(url, other.url);
	}

	public RequestKeyValue() {;}
	
	public RequestKeyValue(String url, String method) {
		super();
		this.url = url;
		this.method = method;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	@Override
	public String toString() {
		return "RequestKeyValue [url=" + url + ", method=" + method + "]";
	}
	
	
}
