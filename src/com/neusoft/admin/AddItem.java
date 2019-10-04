package com.neusoft.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;
import com.neusoft.main.AdminMenu;
import com.neusoft.util.DBUtil;
import com.neusoft.util.InputUtil;

public class AddItem implements Item{

	@Override
	public Menu execute() {
		// TODO Auto-generated method stub
		System.out.println("请输入用户名");
		String username = InputUtil.getString();
		System.out.println("请输入密码");
		String password = InputUtil.getString();
		System.out.println("请输入邮箱");
		String email = InputUtil.getEmail();
		Connection conn = DBUtil.getInstance().getConn();
		String sql = "insert into userinfo(username,password,email,power,status) values (?,?,?,0,1)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.executeUpdate();
			System.out.println("添加成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, conn);
		}
		return new AdminMenu();
	}

}
