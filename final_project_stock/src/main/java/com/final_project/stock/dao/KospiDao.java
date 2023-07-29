package com.final_project.stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.final_project.stock.dto.KospiDto;
import com.final_project.stock.dto.KospiIntDto;
import com.final_project.stock.dto.KospiDto;

@Repository
public class KospiDao {
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

	public KospiDto searchrecent() throws Exception {
		Connection conn = open();

		KospiDto kospi = new KospiDto();

		String sql = "select * from kospi_crawling order by kospiDate desc limit 1";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			if (rs.next()) {
				kospi.setDate(rs.getString("KospiDate"));
				kospi.setValue(rs.getString("KospiValue"));
			}
			return kospi;
		}

	}

	public List<KospiDto> searchKospiAll() throws Exception {
		Connection conn = open();

		List<KospiDto> kospiAll = new ArrayList<>();

		String sql = "SELECT * FROM kospi_crawling";

		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				KospiDto kospi = new KospiDto();
				kospi.setDate(rs.getString("KospiDate"));
				kospi.setValue(rs.getString("KospiValue"));
				kospiAll.add(kospi);
			}
		}

		return kospiAll;
	}

	public KospiIntDto searchrecentInt() throws Exception {
		Connection conn = open();

		KospiIntDto kospi = new KospiIntDto();

		String sql = "select * from kospi_crawling order by kospiDate desc limit 1";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			if (rs.next()) {
				kospi.setDate(rs.getString("KospiDate"));
				kospi.setValue(rs.getFloat("KospiValue"));
			}
			return kospi;
		}
	}
	
	
	public List<KospiDto> searchKospiChart() throws Exception {
		Connection conn = open();
		List<KospiDto> kospiChart = new ArrayList<>();

		String sql = "SELECT * FROM kospi_crawling order by kospiDate desc limit 30";

		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				KospiDto kospi = new KospiDto();
				kospi.setDate(rs.getString("KospiDate"));
				kospi.setValue(rs.getString("KospiValue"));
				kospiChart.add(kospi);
			}
		}
		return kospiChart;
	}

}
