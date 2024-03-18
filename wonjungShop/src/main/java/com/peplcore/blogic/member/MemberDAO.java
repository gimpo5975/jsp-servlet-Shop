package com.peplcore.blogic.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.peplcore.web.dbconnection.MyDBConnection;

public class MemberDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private final String USER_INSERT = "insert into member(id, password, name, phone, address, ssn, email, gender, newsAgency, countrySelect)"
			+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	// 회원가입 메소드
	public void insertMember(MemberDTO member) {

		try {
			con = MyDBConnection.getConnection();// database연결
			pstmt = con.prepareStatement(USER_INSERT);// 쿼리문 전달

			// ?에 값 맵핑
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getSsn());
			pstmt.setString(7, member.getEmail());
			pstmt.setString(8, member.getGender());
			pstmt.setString(9, member.getNewsAgency());
			pstmt.setString(10, member.getCountrySelect());

			// 쿼리문 실행
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();// 플젝 완성후 지움
			System.out.println("insertMember에러");
		} finally {
			MyDBConnection.close(rs, pstmt, con);
		} // end of try-catch

	}// end of insertMember

}// end of class
