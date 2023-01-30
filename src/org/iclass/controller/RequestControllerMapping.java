package org.iclass.controller;

import java.util.HashMap;
import java.util.Map;

public class RequestControllerMapping {
	
	private static final Map<RequestKeyValue, Controller> mapping = new HashMap<>();
	
	public static void init() {
		//아래 3개의 컨트롤러 구현 - Action에서 dao의 login메소드 사용
		mapping.put(new RequestKeyValue("/login.hrd", "GET"), new loginViewController());
		mapping.put(new RequestKeyValue("/login.hrd", "POST"), new IoginActionController());
		mapping.put(new RequestKeyValue("/logout.hrd", "GET"), new logoutController());
	}
	
	public static Controller getController(RequestKeyValue key) {
		return mapping.get(key);
	}
	
}
