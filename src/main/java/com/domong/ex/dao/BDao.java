package com.domong.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.domong.ex.dto.BDto;

public class BDao {
	//----- ������ �ҽ� ����
	DataSource datasource;
	
	//------ ����Ŭ(DB)�� �����ϱ�
	public BDao() {  
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//----- �Խñ� �ۼ��ϱ�
	public void write(String bname, String btitle, String bcontent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into mvc_board (bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent) "
				+ "values(mvc_board_seq.nextval,?,?,?,0,mvc_board_seq.currval,0,0)";
		
		try {	
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, bname);
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);
			
			int rn = preparedStatement.executeUpdate(); //�� ���� ������ �����ϸ� rn=1
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {	
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//----- �Խñ� �����ֱ�
	public ArrayList<BDto> list() {
		
		//BDto dto = new BDto(); //dto��ü ����
		ArrayList<BDto> dtos = new ArrayList<BDto>(); //BDto���� �迭�� �����;� �Խñ� �����ֱ� ����
		Connection connection = null; //�����ϱ�
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		
		String query = "select * from mvc_board order by -bid, bstep asc"; // id������ �������� ����
		
		try {	
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) { //�������� �� ���Ϲ�
				//dto.setBid(resultSet.getInt("bid"));
				int bid = resultSet.getInt("bid");
				String bname = resultSet.getString("bname");
				String btitle =resultSet.getString("btitle");
				String bcontent =resultSet.getString("bcontent");
				Timestamp bdate =resultSet.getTimestamp("bdate");
				int bhit =resultSet.getInt("bhit");
				int bgroup =resultSet.getInt("bgroup");
				int bstep =resultSet.getInt("bstep");
				int bindent =resultSet.getInt("bindent");
				
				BDto dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {	
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return dtos;
	}
	
	//----- �Խñ� ��Ͽ��� �� ���� �����ֱ�
	public BDto contentView(String sid) {
		
		BDto dto = null; 
		Connection connection = null; //�����ϱ�
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		
		String query = "select * from mvc_board where bid = ?"; // id������ �������� ����
		
		try {	
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(sid));
			
			resultSet = preparedStatement.executeQuery();
			
			
			if(resultSet.next()) { //�ѳ��� �� ������
				//dto.setBid(resultSet.getInt("bid"));
				int bid = resultSet.getInt("bid");
				String bname = resultSet.getString("bname");
				String btitle =resultSet.getString("btitle");
				String bcontent =resultSet.getString("bcontent");
				Timestamp bdate =resultSet.getTimestamp("bdate");
				int bhit =resultSet.getInt("bhit");
				int bgroup =resultSet.getInt("bgroup");
				int bstep =resultSet.getInt("bstep");
				int bindent =resultSet.getInt("bindent");
				
				dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { //�ݴ°� �� ������ֱ� ���̳ʸ� ����!
				try {	
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		return dto;
	}
	
	//----- 
	
}
