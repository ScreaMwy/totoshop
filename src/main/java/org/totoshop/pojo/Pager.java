package org.totoshop.pojo;

import java.util.List;

public class Pager<T> {
	private int pageSize; // 每頁顯的記錄數
	
	private int currentPage; // 當前頁數 
	
	private int totalRecord; // 總記錄
	
	private int totalPage; // 總頁數
	
	private List<T> dataList; // 要顯示的數據
	
	public Pager() {}

	public Pager(int pageSize, int currentPage, List<T> pageList) {
		if (null == pageList) {
			return;
		}
		this.totalRecord = pageList.size();
		this.pageSize = pageSize;
		this.totalPage = (this.totalPage / this.pageSize);
		if ((this.totalPage % this.pageSize) != 0) {
			this.totalPage++;
		}
		this.currentPage = (currentPage > this.totalPage) ? this.totalPage : currentPage;
		int fromIndex = this.pageSize * (this.currentPage - 1);
		int toIndex = (this.pageSize * this.currentPage > this.totalRecord) ? this.totalRecord : this.pageSize * this.currentPage;
		this.dataList = pageList.subList(fromIndex, toIndex);
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "Pager [pageSize=" + pageSize + ", currentPage=" + currentPage + ", totalRecord=" + totalRecord
				+ ", totalPage=" + totalPage + ", dataList=" + dataList + "]";
	}
}
