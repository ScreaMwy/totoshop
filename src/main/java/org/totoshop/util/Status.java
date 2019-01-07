package org.totoshop.util;

import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"unused"})
public class Status {
	public static final String STATUS_SUCCESS = "success";
	
	public static final String STATUS_ERROR = "error";
	
	private static final int STATUS_SUCCESS_CODE = 300;
	
	private static final int STATUS_ERROR_CODE = 304;

	public Map<String, Integer> statusMap;
	
	public Status() {
		statusMap = new HashMap<String, Integer>();
	}
	
	public int getStatus(String statusKey) {
		return statusMap.get(statusKey);
	}
	
	private void setStatus() {
		statusMap.put(STATUS_SUCCESS, STATUS_SUCCESS_CODE);
		statusMap.put(STATUS_ERROR, STATUS_ERROR_CODE);
	}
}
