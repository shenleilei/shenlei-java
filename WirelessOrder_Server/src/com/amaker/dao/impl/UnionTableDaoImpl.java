package com.amaker.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amaker.dao.UnionTableDao;
import com.amaker.entity.UnionTable;
import com.amaker.util.DBUtil;

/**
 * @author ����־
 * ʵ�ֲ�̨����
 */
public class UnionTableDaoImpl implements UnionTableDao {
	
	public List getTableList() {
		// ��ѯSQL���
		String sql =" select id,num from tabletbl where flag = 1 ";
		// ���ݿ����ӹ�����
		DBUtil util = new DBUtil();
		// �������
		Connection conn = util.openConnection();
		try {
			// ���Ԥ�������
			Statement pstmt = conn.createStatement();
			// ִ�в�ѯ
			ResultSet rs = pstmt.executeQuery(sql);
			// �ж϶�����ϸ
			List list = new ArrayList();
			while (rs.next()) {
				// ��ò˵���Ϣ
				
				int id = rs.getInt(1);
				int num = rs.getInt(2);
				
				UnionTable ut = new UnionTable();
				ut.setId(id);
				ut.setNum(num);
				
				list.add(ut);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return null;
	}


	public void updateStatus(int tableId1,int tableId2) {
		System.out.println(tableId1+"========"+tableId2);
		// ���ݿ����ӹ�����
		DBUtil util = new DBUtil();
		String sql1 = "update tabletbl set flag = 0 where id = "+tableId1;
		String sql2 = "update ordertbl set tableId = "+tableId2+" where tableId = "+tableId1;
		System.out.println(sql1+"======"+sql2);
		// �������
		Connection conn = util.openConnection();
		try {
			Statement pstmt = conn.createStatement();
			pstmt.execute(sql1);
			pstmt.execute(sql2);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}