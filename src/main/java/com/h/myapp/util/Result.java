package com.h.myapp.util;

import java.util.ArrayList;
import java.util.List;

public class Result<T> {
	private List<T> resultList=new ArrayList<T>();
	private String firstPage;
	private String prePage;
	private String nextPage;
	private String lastPage;
	public Result() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resultList == null) ? 0 : resultList.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (resultList == null) {
			if (other.resultList != null)
				return false;
		} else if (!resultList.equals(other.resultList))
			return false;
		return true;
	}
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	public String getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(String firstPage) {
		this.firstPage = firstPage;
	}
	public String getPrePage() {
		return prePage;
	}
	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}
	public String getNextPage() {
		return nextPage;
	}
	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}
	public String getLastPage() {
		return lastPage;
	}
	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}
	@Override
	public String toString() {
		return "Result [resultList=" + resultList + ", firstPage=" + firstPage + ", prePage=" + prePage + ", nextPage="
				+ nextPage + ", lastPage=" + lastPage + "]";
	}
	
}
