package com.china.a.dao;
 
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.china.a.vo.Person;
import com.china.tools.DateBase;
import com.china.tools.log;
import com.sun.org.apache.regexp.internal.recompile;

public class Logindao extends DateBase{
	public int savePerson(Person person) {
		Connection con = null;
		int count=0;

			// ������ݿ���jar��
			try {
				con=getConnection();
				
				String sql="insert into person values(person_seq.nextval,?,?,?,?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, person.getUname());
				st.setString(2, person.getPwd());
				st.setString(3, person.getSex());
				st.setString(4, person.getBrithday());
				st.setString(5, person.getLikes());
				st.setDate(6, new Date(person.getBiye().getTime()));
				st.setString(7, person.getPicurl());
				count = st.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.logger.error(e.getMessage());
			}finally{
				closeConnection(con);
			}
		return count;
}
	public List <Person> getAllPerson() {
		Connection con = null;
		int count=0;
		List <Person> list=new  ArrayList<Person>();
			
			try {
				con=getConnection();
				String sql="select * from person";
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs= st.executeQuery();
				while (rs.next()) {
					Person p=new Person();
					p.setPid(rs.getInt(1));
					p.setUname(rs.getString(2));
					p.setPwd(rs.getString(3));
					p.setSex(rs.getString(4));
					p.setBrithday(rs.getString(5));
					p.setLikes(rs.getString(6));
					p.setBiye(rs.getDate(7));
					p.setPicurl(rs.getString(8));
					
					list.add(p);
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeConnection(con);
			}
		return list;
}
	public int deletePersonByPid(int pid) {
		Connection con = null;
		int count=0;
		
			
			try {
				con=getConnection();
				String sql="delete from person where pid=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, pid);
				count=ps.executeUpdate();
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeConnection(con);
			}
		return count;
}
	
	public Person getPersonByid(int pid) {
		Connection con = null;
		
		Person p=null;
			
			try {
				con=getConnection();
				String sql="select * from person where pid=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, pid);
				ResultSet rs1 = ps.executeQuery();
				if (rs1.next()) {
					 p=new Person();
					p.setPid(rs1.getInt(1));
					p.setUname(rs1.getString(2));
					p.setPwd(rs1.getString(3));
					p.setSex(rs1.getString(4));
					p.setBrithday(rs1.getString(5));
					p.setLikes(rs1.getString(6));
					
					
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeConnection(con);
			}
		return p;
}
	
	public int updatePersonByID(Person person) {
		Connection con = null;
		
		int count=0;
			
			try {
				con=getConnection();
				String sql=" update person set UNAME=?,PWD=?,SEX=?,BIRTHDAY=?,LIKES=? where pid=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, person.getUname());
				ps.setString(2, person.getPwd());
				ps.setString(3, person.getSex());
				ps.setString(4, person.getBrithday());
				ps.setString(5, person.getLikes());
				ps.setInt(6, person.getPid());
				count = ps.executeUpdate();
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
					closeConnection(con);
			}
		return count;
}
	 
	public boolean getPersonByUnameandPwd(String uname,String pwd) {
		Connection con = null;
		boolean b=false;
		
			
			try {
				con=getConnection();
				String sql="select * from person where uname=? and pwd=?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, uname);
				st.setString(2, pwd);
				ResultSet rs= st.executeQuery();
				b= (rs.next());
					
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeConnection(con);
			}
		return b;
		
}
	public int saveShu(int i) {
		Connection con = null;
		int count=0;
			// ������ݿ���jar��
			try {
				con=getConnection();
				String sql="update shu set count=?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, i);
				count = st.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeConnection(con);
			}
		return count;
}
	public int getShu() {
		Connection con = null;
		
		int count=0;
			
			try {
				con=getConnection();
				String sql="select * from shu";
				PreparedStatement ps = con.prepareStatement(sql);
				
				ResultSet rs1 = ps.executeQuery();
				while (rs1.next()) {
					count=rs1.getInt(1);
					
					
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeConnection(con);
			}
		return count;
}
	public List<Person> getFenyePerson(int start ,int end) {

		// 连接数据库
		Connection con = null;
		List<Person> list = new ArrayList<Person>();
		try {

			con = getConnection();
			Statement st = con.createStatement();

			String sql = "select * from ( "
					+ "select rownum rn,tb.* from (   select * from person order by pid  asc )tb "
					+ ")a " + "where rn>="+start+" and rn<"+end;

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Person p = new Person();

				 
					p.setPid(rs.getInt(1));
					p.setUname(rs.getString(2));
					p.setPwd(rs.getString(3));
					p.setSex(rs.getString(4));
					p.setBrithday(rs.getString(5));
					p.setLikes(rs.getString(6));

				list.add(p);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;
	}

}

	


