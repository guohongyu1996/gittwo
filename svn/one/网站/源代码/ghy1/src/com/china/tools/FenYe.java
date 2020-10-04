package com.china.tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FenYe extends DateBase{

	public   int getAllPerson() {

		int count = 0;
		Connection con = null;

		try {

			// 连接数据库
			con = getConnection();

			String sql = "select count(*)  from  person  ";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {

				count = rs.getInt(1);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			closeConnection(con);
		}
		return count;

}
}
