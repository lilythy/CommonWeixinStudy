package com.wxcommon.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wxcommon.jdbc.JdbcUtils;

public class ScoreProvinceDao {
	private JdbcUtils utils = null;

	public ScoreProvinceDao() {
		utils = new JdbcUtils();
	}
	
	public boolean insertScore(List<Object> params) {
		boolean flag = false;
		String sql = "insert into scores_province(province,year,score_high,score_average,score_control,type_student,batch,time_update) "
				   + "values(?,?,?,?,?,?,?,?)";
		
		try {
			utils.getConnection();
			flag = utils.updateByPreparedStatement(sql, params);
			
		} catch (SQLException e) {
			System.out.println("insertScore数据存储失败----->" + e);
			e.printStackTrace();
			
		} finally {
			utils.releaseConn();
			
		}
		return flag;
	}
	
	public List<Map<String, Object>> getScoreList() {
		List<Map<String, Object>> paramsList = new ArrayList<Map<String, Object>>();
		String sql = "select * from scores_province";
		
		try {
			utils.getConnection();
			paramsList = utils.findMoreResult(sql, null);
		} catch (SQLException e) {
			System.out.println("insertScore数据存储失败----->" + e);
			e.printStackTrace();
			
		} finally {
			utils.releaseConn();
			
		}
		return paramsList;
	}
	
}
