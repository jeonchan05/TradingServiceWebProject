package com.final_project.stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.final_project.stock.dto.ExchangeDto;

@Repository
public class ExchangeDao {
	final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	final String JDBC_URL = "jdbc:mariadb://34.64.197.181:3306/shin_db";

	// DB 연결을 가져오는 메서드, DBCP를 사용하는 것이 좋음
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "SUJIN", "SUJIN");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public ExchangeDto searchrecent() throws Exception {
		Connection conn = open();

		ExchangeDto exchange = new ExchangeDto();

		String sql = "select * from exchange_crawling order by ExchangeDate desc limit 1";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			if (rs.next()) {
				exchange.setDate(rs.getString("ExchangeDate"));
				exchange.setUSD(rs.getString("USD"));
				exchange.setCNY(rs.getString("CNY"));
			}
			return exchange;
		}
	}

	public ArrayList<ExchangeDto> searchExchangeAll() throws Exception {
		Connection conn = open();

		ExchangeDto exchange = new ExchangeDto();
		ArrayList<ExchangeDto> exchangeAll = new ArrayList<>();

		String sql = "SELECT * FROM exchange_crawling";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			if (rs.next()) {
				exchange.setDate(rs.getString("ExchangeDate"));
				exchange.setUSD(rs.getString("USD"));
				exchange.setCNY("CNY");
				exchangeAll.add(exchange);
			}
			return exchangeAll;
		}

	}
}
