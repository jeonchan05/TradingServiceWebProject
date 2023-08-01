package com.final_project.stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.final_project.stock.dto.AccountInfoDto;
import com.final_project.stock.dto.StockProfitDto;
import com.final_project.stock.dto.TotalProfitDto;

@Repository
public class StockProfitDao {
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
	
	public List<StockProfitDto> searchShinProfitChart() throws Exception {
		Connection conn = open();
		List<StockProfitDto> shinProfitChart = new ArrayList<>();

		String sql = "SELECT * FROM Stock_Profit order by rindex desc limit 30";

		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				StockProfitDto shinProfit = new StockProfitDto();
				shinProfit.setDatetime(rs.getString("Datetime"));
				shinProfit.setShinprofit(rs.getString("shinprofit"));
				shinProfitChart.add(shinProfit);
			}
		}
		return shinProfitChart;
	}
	
	public List<StockProfitDto> searchShinFoodProfitChart() throws Exception {
		Connection conn = open();
		List<StockProfitDto> shinfoodProfitChart = new ArrayList<>();

		String sql = "SELECT * FROM Stock_Profit order by rindex desc limit 30";

		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				StockProfitDto shinfoodProfit = new StockProfitDto();
				shinfoodProfit.setDatetime(rs.getString("Datetime"));
				shinfoodProfit.setShinfoodprofit(rs.getString("foodprofit"));
				shinfoodProfitChart.add(shinfoodProfit);
			}
		}
		return shinfoodProfitChart;
	}
	
	public List<StockProfitDto> searchEmartProfitChart() throws Exception {
		Connection conn = open();
		List<StockProfitDto> emartProfitChart = new ArrayList<>();

		String sql = "SELECT * FROM Stock_Profit order by rindex desc limit 30";

		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				StockProfitDto emartProfit = new StockProfitDto();
				emartProfit.setDatetime(rs.getString("Datetime"));
				emartProfit.setEmartprofit(rs.getString("emartprofit"));
				emartProfitChart.add(emartProfit);
			}
		}
		return emartProfitChart;
	}
	
	public List<TotalProfitDto> totalProfitChart() throws Exception {
		Connection conn = open();
		List<TotalProfitDto> totalProfitChart = new ArrayList<>();

		String sql = "SELECT profitrate, Datetime FROM Acc_Info order by rindex desc limit 30";

		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				TotalProfitDto totalProfit = new TotalProfitDto();
				totalProfit.setDatetime(rs.getString("Datetime"));
				totalProfit.setTotalProfit(rs.getString("profitrate"));
				totalProfitChart.add(totalProfit);
			}
		}
		return totalProfitChart;
	}

}
