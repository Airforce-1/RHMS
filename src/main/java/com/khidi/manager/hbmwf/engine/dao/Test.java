package com.khidi.manager.hbmwf.engine.dao;

import java.sql.SQLException;

// 测试用Application
public class Test {
    public static void main( String[] args ) throws SQLException
    {
    	// 生成新 
    	IdgeneratorDao.GetNewId("fdz");
        System.out.println( "Hello World!" );
    }
}