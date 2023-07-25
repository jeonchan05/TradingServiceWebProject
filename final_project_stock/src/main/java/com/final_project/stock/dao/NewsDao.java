package com.final_project.stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.final_project.stock.dto.EmartNewsDto;
import com.final_project.stock.dto.KospiDto;

public class NewsDao {
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

		public ArrayList<EmartNewsDto> EmartNews() throws Exception {
			Connection conn = open();
			ArrayList<EmartNewsDto> emartNewsList = new ArrayList<>();

			String sql = "SELECT * FROM Emartnews";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			try (conn; pstmt; rs) {
				while (rs.next()) {
					EmartNewsDto emartNewsDto = new EmartNewsDto();
					emartNewsDto.setEmartnum(rs.getInt("NewsNum"));
					emartNewsDto.setEmartdate(rs.getString("NewsDate"));;
					emartNewsDto.setEmarttitle(rs.getString("NewsTitle"));;
					emartNewsDto.setEmartcontent(rs.getString("NewsContent"));
					emartNewsDto.setEmartpn(rs.getString("NewsPN"));

					emartNewsList.add(emartNewsDto);
				}
			}
			return emartNewsList;

		}
		
		public EmartNewsDto getEmartNews(int emartnum) throws Exception {
			Connection conn = open();

			EmartNewsDto emartNewsDto = new EmartNewsDto();

			String sql = "select NewsDate,NewsTitle,NewsContent from Emartnews where NewsNum=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emartnum);
			ResultSet rs = pstmt.executeQuery();
			try (conn; pstmt; rs) {
				if (rs.next()) {
					emartNewsDto.setEmartdate(rs.getString("NewsDate"));
					emartNewsDto.setEmarttitle(rs.getString("NewsTitle"));
					emartNewsDto.setEmartcontent(rs.getString("NewsContent"));
				}
				return emartNewsDto;
			}

		}
	}
