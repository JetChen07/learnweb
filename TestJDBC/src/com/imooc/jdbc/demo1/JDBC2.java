package com.imooc.jdbc.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class JDBC2 {
	
	public void demo1(){
		
		try {
			// 1.加载驱动
//			DriverManager.registerDriver(new Driver());// 会导致驱动注册两次。
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			// 2.获得连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8", "root", "123456");
			// 3.创建执行SQL语句的对象，并且执行SQL
			// 3.1创建执行sql的对象
			String sql = "select * from goods where price<3500";
			Statement stmt = conn.createStatement();
			// 3.2执行sql
			ResultSet resultSet = stmt.executeQuery(sql);
			while(resultSet.next()){
				int uid = resultSet.getInt("uid");
				String name = resultSet.getString("name");
				float price = resultSet.getFloat("price");
				String desp = resultSet.getString("desp");
				
				System.out.println("demo1:"+uid+"   "+name+"   "+price+"   "+desp);
			}
			// 4.释放资源
			resultSet.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void demo2() {
		try {
			// 1.加载驱动
//			DriverManager.registerDriver(new Driver());// 会导致驱动注册两次。
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			// 2.获得连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8", "root", "123456");
			// 3.创建执行SQL语句的对象，并且执行SQL
			// 3.1创建执行sql的对象
			String sql = "insert goods(name,price,desp) VALUES(\"耳机\",200.0,\"蓝牙耳机\")";
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			if(i > 0){
				System.out.println("添加成功!");
			}
			// 3.2执行sql
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void demo3() {
		try {
			// 1.加载驱动
//			DriverManager.registerDriver(new Driver());// 会导致驱动注册两次。
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			// 2.获得连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8", "root", "123456");
			// 3.创建执行SQL语句的对象，并且执行SQL
			// 3.1创建执行sql的对象
			String sql = "UPDATE goods SET name=\"哈哈\" WHERE uid=5";
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			if(i > 0){
				System.out.println("修改成功!");
			}
			// 3.2执行sql
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void demo4() {
		try {
			// 1.加载驱动
//			DriverManager.registerDriver(new Driver());// 会导致驱动注册两次。
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			// 2.获得连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8", "root", "123456");
			// 3.创建执行SQL语句的对象，并且执行SQL
			// 3.1创建执行sql的对象
			String sql = "delete from goods WHERE uid=5";
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate(sql);
			if(i > 0){
				System.out.println("删除成功!");
			}
			// 3.2执行sql
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
