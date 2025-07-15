package DAO;

import java.sql.*;
import DTO.Member;

public class MemberDAO {
	private MemberDAO(){
	}
	private static MemberDAO instance=new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	public Connection getConnection() throws Exception{
		Connection conn=null;
		String url="jdbc:mariadb://127.0.0.1:3306/ppl";
		String db_id="root";
		String db_pw="iotiot";
		Class.forName("org.mariadb.jdbc.Driver");
		conn=DriverManager.getConnection(url, db_id, db_pw);
		return conn;
	}
	public int userCheck(String id, String pwd) {
		int result=-1;
		String sql="select pwd from member where id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pwd").equals(pwd) && rs.getString("pwd")!=null) {
					result=1;
				}else {
					result=0;
				}
			}else {
				result=-1;
			}
		}catch(Exception e) {
			System.out.println("userCheck() 접속 중 오류 발생 : "+e);
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception ex) {
				System.out.println("userCheck() 접속 해제중 오류 발생 : "+ex);
			}
		}
		return result;
	}
	public Member getMember(String id) {
		Member m=null;
		String sql="select * from member where id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=new Member();
				m.setId(rs.getString("id"));
				m.setPwd(rs.getString("pwd"));
				m.setEmail(rs.getString("email"));
				m.setAdmin(rs.getString("admin"));
			}
		}catch(Exception e) {
			System.out.println("getMember() 접속 중 오류발생 : "+e);
		}finally {
			try {
				if(rs!=null)rs.close(); if(pstmt!=null)pstmt.close(); if(conn!=null)conn.close();
			}catch(Exception ex) {
				System.out.println("getMember() 접속 해제중 오류발생 : "+ex);
			}
		}
		return m;
	}
}
