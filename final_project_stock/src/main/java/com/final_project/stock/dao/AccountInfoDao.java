package com.final_project.stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.final_project.stock.dto.AccountInfoDto;

public class AccountInfoDao {
	final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	final String JDBC_URL = "jdbc:mariadb://34.64.197.181:3306/shin_db";

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
	
	public AccountInfoDto getAccountInfo() throws Exception {
		Connection conn = open();

		AccountInfoDto accountInfo = new AccountInfoDto();

		String sql = "select * from Acc_Info order by rindex desc limit 1";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			if (rs.next()) {
				accountInfo.setOdrbqty(rs.getString("odrbqty"));
				accountInfo.setTrbqty(rs.getString("trbqty"));
				accountInfo.setAvalpri(rs.getString("avalpri"));
				accountInfo.setValgalo(rs.getString("valgalo"));
				accountInfo.setGarate(rs.getString("garate"));
			}
			return accountInfo;
		}
	}
	
	
}
