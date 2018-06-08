package com.khidi.manager.hbmwf.engine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;



/**
 * 工作流数据结构  Id生成器
 *
 * @author 王顺波
 * @email 405877884@qq.com
 * @date 2017-11-17 11:02
 */
@Component
@Qualifier("IdgeneratorDao")
public class IdgeneratorDao {
	
	// newid 生成器(根据表名生成newid)
	public static int GetNewId(String pTableName) throws SQLException
	{
		//查询tablename是否重复
		String sql = "SELECT COUNT(*) FROM HBMWF_IDGENERATOR WHERE TABLENAME = ?";
		//连接数据库  载入sql  注入变量
		
		Connection con = OracleUtil.GetConnection(HbmwfUtil.WF_DBURL, HbmwfUtil.WF_USERNAME, HbmwfUtil.WF_PWD );
		//TODO:
		PreparedStatement pre = con.prepareStatement(sql);
		pre.setString(1, pTableName);
		ResultSet rs = pre.executeQuery();
		boolean  exists = OracleUtil.CheckDataExists(rs);
				
		if(exists){
			String sql1 = "select ID from HBMWF_IDGENERATOR where TABLENAME = ?";
			String sql2 = "UPDATE HBMWF_IDGENERATOR set ID = ? where TABLENAME = ?";
			//
			PreparedStatement pre1 = con.prepareStatement(sql1);
			pre1.setString(1, pTableName);
			ResultSet rs1 = pre1.executeQuery();
			int num = OracleUtil.getIntNum(rs1);
			//
			PreparedStatement pre2 = con.prepareStatement(sql2);
			pre2.setInt(1, num + 1);
			pre2.setString(2, pTableName);
			pre2.execute();
			//
			pre.close();
			con.close();
			return  num + 1;
		}else{
			String sql3 = "INSERT INTO HBMWF_IDGENERATOR  VALUES (?, 2)";
			PreparedStatement pre3 = con.prepareStatement(sql3);
			pre3.setString(1, pTableName);
			pre3.execute();
			//
			pre.close();
			con.close();
			return 1 ;
		}
	}
}
