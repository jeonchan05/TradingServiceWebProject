package com.final_project.stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.final_project.stock.dto.UserTableDto;

@Repository
public class UserTableDao {
	 final String JDBC_DRIVER  = "org.mariadb.jdbc.Driver";
     final String JDBC_URL = "jdbc:mariadb://34.64.63.106:3306/big16";

	// DB 연결을 가져오는 메서드, DBCP를 사용하는 것이 좋음
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "root", "054021");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void insert(UserTableDto usertableDto) throws Exception {
		Connection conn = open();

		String sql = "INSERT INTO usertable VALUES (?,?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		try (conn; pstmt) {
			pstmt.setString(1, usertableDto.getUsername());
			pstmt.setString(2, usertableDto.getImgnm());
			pstmt.setString(3, usertableDto.getUserid());
			pstmt.setString(4, usertableDto.getUserpassword());
			pstmt.executeUpdate();
		}

	}

	public UserTableDto searchAll(String insertsession) throws Exception {
		Connection conn = open();

		UserTableDto user = new UserTableDto();

		String sql = "SELECT * FROM usertable where userid = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, insertsession);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			if (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setImgnm(rs.getString("imgnm"));
				user.setUserid(rs.getString("userid"));
				user.setUserpassword(rs.getString("userpassword"));
			}
			return user;
		}

	}
	
	public ArrayList<UserTableDto> searchuserinfo(String insertsession) throws Exception {
		Connection conn = open();

		UserTableDto user = new UserTableDto();
		ArrayList<UserTableDto> userinfo = new ArrayList<>();

		String sql = "SELECT * FROM usertable where userid = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, insertsession);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			if (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setImgnm(rs.getString("imgnm"));
				user.setUserid(rs.getString("userid"));
				user.setUserpassword(rs.getString("userpassword"));
				userinfo.add(user);
			}
			return userinfo;
		}

	}
	

	public ArrayList<UserTableDto> isexistuserid() throws Exception {
		Connection conn = open();
		ArrayList<UserTableDto> usertablelist = new ArrayList<>();

		String sql = "SELECT * FROM usertable ";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			while (rs.next()) {
				UserTableDto user = new UserTableDto();
				user.setUsername(rs.getString("username"));
				user.setImgnm(rs.getString("imgnm"));
				user.setUserid(rs.getString("userid"));
				user.setUserpassword(rs.getString("userpassword"));

				usertablelist.add(user);
			}
		}

		return usertablelist;

	}

	public ArrayList<UserTableDto> signupidcheck(String userid) throws Exception {
		Connection conn = open();
		ArrayList<UserTableDto> usertablelist = new ArrayList<>();

		String sql = "SELECT * FROM usertable where userid = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userid);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			while (rs.next()) {
				UserTableDto user = new UserTableDto();
				user.setUsername(rs.getString("username"));
				user.setImgnm(rs.getString("imgnm"));
				user.setUserid(rs.getString("userid"));
				user.setUserpassword(rs.getString("userpassword"));

				usertablelist.add(user);
			}
		}
		return usertablelist;

	}
}

