package com.final_project.stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.final_project.stock.dto.TradingHistoryDto;

public class TradeHistoryDao {
		final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
		final String JDBC_URL = "jdbc:mariadb://34.64.197.181:3306/shin_db";

		// DB 연결을 가져오는 메서드, DBCP를 사용하는 것이 좋음
		public Connection open() {
			Connection conn = null;
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(JDBC_URL, "CHAN", "CHAN");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
		
		public ArrayList<TradingHistoryDto> tradingAllHistory() throws Exception {
			Connection conn = open();
			ArrayList<TradingHistoryDto> tradingAllList = new ArrayList<>();

			String sql = "SELECT * FROM Event_Trade";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			try (conn; pstmt; rs) {
				while (rs.next()) {
					TradingHistoryDto tradingHistory = new TradingHistoryDto();
					tradingHistory.setOrdertime(rs.getString("ordertime"));
					tradingHistory.setExcepttime(rs.getString("excepttime"));
					tradingHistory.setOrdernum(rs.getString("ordernum"));
					tradingHistory.setStockname(rs.getString("stockname"));
					tradingHistory.setOrderprice(rs.getString("orderprice"));
					tradingHistory.setExceptprice(rs.getString("exceptprice"));
					tradingHistory.setExceptqty(rs.getString("exceptqty"));
					tradingHistory.setGubun(rs.getString("gubun"));

					tradingAllList.add(tradingHistory);
				}
			}
			return tradingAllList;

		}
}
