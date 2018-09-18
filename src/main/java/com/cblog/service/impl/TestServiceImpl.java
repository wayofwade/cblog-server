package com.cblog.service.impl;

import com.cblog.dao.test1.TestDao;
import com.cblog.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {
  

	TestDao testDao = new TestDao() {
		@Override
		public int saveTest(Map<String, Object> map) {
			return 0;
		}
	};
	
	@Override
	public String testMybatis() {
		Map<String, Object> map=new HashMap<>();
		map.put("userName", "yzk");
		map.put("passWord", "test");
		testDao.saveTest(map);
		return "测试";
	}
}
