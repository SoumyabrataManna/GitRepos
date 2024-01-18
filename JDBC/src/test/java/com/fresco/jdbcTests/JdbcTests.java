package com.fresco.jdbcTests;

import util.DbUtil;
import util.RunningScripts;
import code.DbOperations;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.mysql.cj.protocol.Resultset;



@RunWith(JUnit4.class)
public class JdbcTests {

	DbOperations ops=new DbOperations();
	
	@BeforeClass
	public static void test1() throws Exception {
		RunningScripts scr=new RunningScripts();
		scr.runDbScript();
	}
	@org.junit.Test
	public void test2() throws Exception{
		ops.insertSubject("Maths");
		ops.insertSubject("Since");
		ops.insertSubject("English");
		
		ArrayList record= ops.getSubjectById(2);
		assertEquals(record.get(0), 2);
		assertEquals(record.get(1), "Since");
		ResultSet rs=  ops.getAllSubjects();
		rs.next();
		assertEquals(rs.getInt("id"), 1);
		assertEquals(rs.getString("name"), "Maths");
		rs.next();
		assertEquals(rs.getInt("id"), 2);
		assertEquals(rs.getString("name"), "Since");
		rs.next();
		assertEquals(rs.getInt("id"), 3);
		assertEquals(rs.getString("name"), "English");
	}
	
	@org.junit.Test
	public  void test3() throws Exception{
		ResultSet rs = DbUtil.getConnection().createStatement().executeQuery("select id, name from subject");
		rs.next();
		assertEquals(rs.getInt("id"), 1);
		assertEquals(rs.getString("name"), "Maths");
		rs.next();
		assertEquals(rs.getInt("id"), 2);
		assertEquals(rs.getString("name"), "Since");
		rs.next();
		assertEquals(rs.getInt("id"), 3);
		assertEquals(rs.getString("name"), "English");
		
	}
	public void helper1(ResultSet rs) throws SQLException{
		rs.next();
		assertEquals(rs.getInt("id"), 1);
		assertEquals(rs.getString("student_name"), "john");
		assertEquals((int)rs.getFloat("score"), 67);
		assertEquals(rs.getInt("subject_id"), 1);
		
		rs.next();
		assertEquals(rs.getInt("id"), 2);
		assertEquals(rs.getString("student_name"), "Smith");
		assertEquals((int)rs.getFloat("score"), 87);
		assertEquals(rs.getInt("subject_id"), 2);
	}
	@org.junit.Test
	public void test4() throws Exception{
		ops.insertStudent("john", 67, "Maths");
		ops.insertStudent("Smith", 87, "Since");
		ArrayList record=ops.getStudentyId(1);
		assertEquals(record.get(0), 1);
		assertEquals(record.get(1), "john");
		assertEquals(record.get(2), 67.0f);
		assertEquals(record.get(3), 1);
		ResultSet rs=  ops.getAllStudents();
		helper1(rs);
	}
	
}
