package com.test.myapp;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	@Test
	public void testConnection() {
		try {
        	//oracle 접속 url
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			//oracle 접속 계정 
           	 String username = "system";
            //oracle 계정 패스워드 
			String password = "0000";
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println(conn);
							  
		} catch (Exception e) {
			fail(e.toString());
		}
	}
}
