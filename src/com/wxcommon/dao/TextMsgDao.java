package com.wxcommon.dao;

import java.sql.SQLException;
import java.util.List;

import com.wxcommon.jdbc.JdbcUtils;

public class TextMsgDao {
	private JdbcUtils utils= null;
	
	public TextMsgDao() {
		utils = new JdbcUtils();
	}

	/**
	 * 用户反馈内容存储
	 */
	public boolean feedBackSave(List<Object> params) {
		boolean flag = false;
		String sql = "insert into feedback(username,senddate,feedcontent) values(?,?,?)";
		
		try {
			utils.getConnection();
			flag = utils.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			System.out.println("feedBackSave数据存储失败----->" + e);
			e.printStackTrace();
		} finally {
			utils.releaseConn();
		}
		return flag;
	}
	
}
