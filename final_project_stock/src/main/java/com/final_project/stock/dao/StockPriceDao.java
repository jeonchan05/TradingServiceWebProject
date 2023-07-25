package com.final_project.stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.final_project.stock.dto.KospiDto;
import com.final_project.stock.dto.StockPriceEmartDto;
import com.final_project.stock.dto.StockPriceShinDto;
import com.final_project.stock.dto.StockPriceShinFood;

public class StockPriceDao {
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
	
	public StockPriceShinDto searchShinRecent() throws Exception {
		Connection conn = open();

		StockPriceShinDto shin = new StockPriceShinDto();

		String sql = "select close from New_004170 order by Datetime desc limit 1";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			if (rs.next()) {
				shin.setShinClosePrice(rs.getString("close"));
			}
			return shin;
		}

	}
	
	public StockPriceShinFood searchShinFoodRecent() throws Exception {
		Connection conn = open();

		StockPriceShinFood shinFood = new StockPriceShinFood();

		String sql = "select close from New_031440 order by Datetime desc limit 1";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			if (rs.next()) {
				shinFood.setShinFoodClosePrice(rs.getString("close"));
			}
			return shinFood;
		}

	}
	
	public StockPriceEmartDto searchEmartRecent() throws Exception {
		Connection conn = open();

		StockPriceEmartDto emart = new StockPriceEmartDto();

		String sql = "select close from New_139480 order by Datetime desc limit 1";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			if (rs.next()) {
				emart.setEmartClosePrice(rs.getString("close"));
			}
			return emart;
		}

	}
	
	
}
