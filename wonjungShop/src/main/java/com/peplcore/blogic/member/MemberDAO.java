package com.peplcore.blogic.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.peplcore.web.dbconnection.MyDBConnection;

public class MemberDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private final String USER_INSERT = "insert into member(id, password, name, phone, address, ssn, email, gender, newsAgency, countrySelect)"
			+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String USER_GET = "select * from member where id=?";
	private final String USER_DELETE = "delete from member where id=?";
	private final String USER_LIST = "select * from member order by date desc";
	private final String USER_UPDATE = "update member set grade=?, role=? where id=?";
	private final String NEW_USER_COUNT = "SELECT COUNT(id)" + " FROM member"
			+ " WHERE DATEDIFF(CURRENT_DATE, date) <= 14";
	private final String USER_ALL_COUNT = "select count(id) from member where id is not null";
	private final String BLACK_USER_COUNT = "select count(role) from member where role='블랙회원'";

	// 회원정보 상세 조회
	public MemberDTO getOneMemberList(String id) {
		MemberDTO member = null;
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_GET);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setSsn(rs.getString("ssn"));
				member.setEmail(rs.getString("email"));
				member.setGender(rs.getString("gender"));
				member.setNewsAgency(rs.getString("newsAgency"));
				member.setCountrySelect(rs.getString("countrySelect"));
				member.setRole(rs.getString("role"));
				member.setGrade(rs.getString("grade"));
				member.setDate(rs.getDate("date"));
			} // end of if

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getOneMember에러");
		} finally {
			MyDBConnection.close(rs, pstmt, con);
		} // end of try-catch
		return member;
	}// end of getOneMember

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

	// 회원 목록을 가져오는 메소드
	public List<MemberDTO> getAllMemberList() {
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_LIST);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				member = new MemberDTO();

				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setSsn(rs.getString("ssn"));
				member.setEmail(rs.getString("email"));
				member.setGender(rs.getString("gender"));
				member.setNewsAgency(rs.getString("newsAgency"));
				member.setCountrySelect(rs.getString("countrySelect"));
				member.setRole(rs.getString("role"));
				member.setGrade(rs.getString("grade"));
				member.setDate(rs.getDate("date"));

				memberList.add(member);
			} // end of while
		} catch (

		SQLException e) {
			e.printStackTrace();
			System.out.println("회원목록 가져오는 메소드 에러");
		} finally {
			MyDBConnection.close(rs, pstmt, con);
		} // end of try-catch

		return memberList;
	}// end of memberGetAllList

	// 회원정보 수정하는 메소드
	public void memberEdit(MemberDTO member) {
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_UPDATE);
			pstmt.setString(1, member.getGrade());
			pstmt.setString(2, member.getRole());
			pstmt.setString(3, member.getId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("회원정보 수정하는 메소드 에러");
		} finally {
			MyDBConnection.close(rs, pstmt, con);
		} // end of try-catch

	}// end of memberEdit

	// 회원정보 삭제하는 메소드
	public void memberDelete(String id) {
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_DELETE);
			pstmt.setString(1, id);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("회원정보 수정하는 메소드 에러");
		} finally {
			MyDBConnection.close(rs, pstmt, con);
		} // end of try-catch
	}// end of memberDelete

	// 신규회원 수 가져오는 메소드
	public int newUserCount() {
		int count = 0;
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(NEW_USER_COUNT);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			} // end of if
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyDBConnection.close(rs, pstmt, con);
		} // end of try-catch

		return count;
	}// end of newUserCount

	// 블랙회원 수 가져오는 메소드
	public int blackUserCount() {
		int count = 0;
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(BLACK_USER_COUNT);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			} // end of if
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyDBConnection.close(rs, pstmt, con);
		} // end of try-catch

		return count;
	}// end of blackUserCount

	// 총 회원 수 가져오는 메소드
	public int allUserCount() {
		int count = 0;
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_ALL_COUNT);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			} // end of if
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyDBConnection.close(rs, pstmt, con);
		} // end of try-catch

		return count;
	}// end of allUserCount

}// end of class
