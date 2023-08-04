package com.final_project.stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.final_project.stock.dto.EmartPredictDto;
import com.final_project.stock.dto.ShinFoodPredictDto;
import com.final_project.stock.dto.ShinPredictDto;

@Repository
public class PredictDao {
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

	public ShinPredictDto shinPredRecent() throws Exception {
		Connection conn = open();

		ShinPredictDto shinPredict = new ShinPredictDto();

		String sql = "select * from ShinPred order by preddate desc limit 1";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			if (rs.next()) {
				shinPredict.setShinpreddate(rs.getString("preddate"));
				shinPredict.setShinpredresult(rs.getString("predresult"));
			}
			return shinPredict;
		}

	}

	public ShinFoodPredictDto shinFoodPredRecent() throws Exception {
		Connection conn = open();

		ShinFoodPredictDto shinFoodPredict = new ShinFoodPredictDto();

		String sql = "select * from ShinFoodPred order by preddate desc limit 1";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			if (rs.next()) {
				shinFoodPredict.setShinfoodpreddate(rs.getString("preddate"));
				shinFoodPredict.setShinfoodpredresult(rs.getString("predresult"));
			}
			return shinFoodPredict;
		}

	}

	public EmartPredictDto emartPredRecent() throws Exception {
		Connection conn = open();

		EmartPredictDto emartPredict = new EmartPredictDto();

		String sql = "select * from EmartPred order by preddate desc limit 1";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			if (rs.next()) {
				emartPredict.setEmartpreddate(rs.getString("preddate"));
				emartPredict.setEmartpredresult(rs.getString("predresult"));
			}
			return emartPredict;
		}

	}

}
