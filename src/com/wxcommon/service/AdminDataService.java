package com.wxcommon.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wxcommon.dao.ScoreProvinceDao;

public class AdminDataService {
	
	public static boolean putData(HttpServletRequest request) {
		boolean flag = false;
		List<Object> params = new ArrayList<Object>();
		
		params.add(request.getParameter("province"));
		params.add(request.getParameter("year"));
		params.add(request.getParameter("score_high"));
		params.add(request.getParameter("score_average"));
		params.add(request.getParameter("score_control"));
		params.add(request.getParameter("type_student"));
		params.add(request.getParameter("batch"));
		params.add(request.getParameter("time_update"));
		
		for(int i=0;i < params.size();i++) {
			if(params.get(i).equals("")) {
				params.set(i, "0");
			}
		}
		
		ScoreProvinceDao scoreProvinceDao = new ScoreProvinceDao();
		flag = scoreProvinceDao.insertScore(params);
		
		List<String> nameList = getnameList();
		
		
		request.setAttribute("insertData", params);
		request.setAttribute("nameList", nameList);
		
		return flag;
	}

	private static List<String> getnameList() {
		List<String> nameList = new ArrayList<String>();  
     	nameList.add("所在省");
     	nameList.add("年份");
     	nameList.add("最高分");
     	nameList.add("平均分");
     	nameList.add("省控线");
     	nameList.add("学生类型");
     	nameList.add("批次");
     	nameList.add("更新时间");
     	
		return nameList;
	}

	public static void getData(HttpServletRequest request) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		Map<String, Object> lastDataMap = new HashMap<String, Object>();
		
		ScoreProvinceDao scoreProvinceDao = new ScoreProvinceDao();
		resultList = scoreProvinceDao.getScoreList();
		
		int size = resultList.size();
		
		lastDataMap = resultList.get(size - 1);
		
		
		List<Object> params = new ArrayList<Object>();  
		params.add(lastDataMap.get("province"));
		params.add(lastDataMap.get("year").toString());
		params.add(lastDataMap.get("score_high").toString());
		params.add(lastDataMap.get("score_average").toString());
		params.add(lastDataMap.get("score_control").toString());
		params.add(lastDataMap.get("type_student"));
		params.add(lastDataMap.get("batch"));
		params.add(lastDataMap.get("time_update"));
		
		List<String> nameList = getnameList();
		
		request.setAttribute("count", size + "");
		request.setAttribute("insertData", params);
		request.setAttribute("nameList", nameList);
	}
}
