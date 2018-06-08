package com.khidi.manager.hbmwf.engine.wfutil;

import java.io.File;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.khidi.manager.hbmwf.engine.dao.IdgeneratorDao;
import com.khidi.manager.hbmwf.enginext.cfg.receiver.WfDeptCfg;
import com.khidi.manager.hbmwf.enginext.cfg.receiver.WfRoleCfg;
import com.khidi.manager.hbmwf.enginext.cfg.receiver.WfUserCfg;

public class HbmwfUtil {
	public final static String WF_NODESTATE_NB = "NB";
	public final static String WF_NODESTATE_DO = "DO";
	public final static String WF_NODESTATE_NPD = "NPD";
	public final static String WF_NODESTATE_PSD = "PSD";
	public final static String WF_NODESTATE_NONE = "NONE";
	public final static String WF_NODESTATE_NEG = "NEG"; // 忽略

	public final static String WF_DBURL = "jdbc:oracle:thin:@10.10.1.92:1521:orcl";
	public final static String WF_USERNAME = "hzzuser";
	public final static String WF_PWD = "hzz";
	
	
	public final static String FORM_STATE_DRA = "DRA";
	public final static String FORM_STATE_VERI = "VERI";
	public final static String FORM_STATE_VERICOM = "VERICOM";
	public final static String FORM_STATE_VERINPD = "VERINPD";
	

	public final static String WF_UI_NODETYPE_START = "start round mix";
	public final static String WF_UI_NODETYPE_CMN = "task";
	public final static String WF_UI_NODETYPE_END = "end round";

	public final static String WF_NODETAG_START = "snode";
	public final static String WF_NODETAG_END = "enode";
	public final static String WF_NODETAG_CMN = "cnode";
	public final static String WF_NODETAG_COND = "condnode";
	
	public final static String WF_LINETAG_CMN = "line";

	public static String encodeBase64(byte[] input) throws Exception {
		Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
		Method mainMethod = clazz.getMethod("encode", byte[].class);
		mainMethod.setAccessible(true);
		Object retObj = mainMethod.invoke(null, new Object[] { input });
		return (String) retObj;
	}

	/***
	 * decode by Base64
	 */
	public static String decodeBase64(String input) throws Exception {
		Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
		Method mainMethod = clazz.getMethod("decode", String.class);
		mainMethod.setAccessible(true);
		Object retObj = mainMethod.invoke(null, input);
		byte[] rtn0 = (byte[]) retObj;
		//
		return new String(rtn0);
	}
	
	
	// 使用当中的方法
		// json 拼接 增加引号
		public static String dd(String pValue) {
			return "\"" + pValue + "\"";
		}

		// json拼接 增加引号 分辨 空值 数字 和 字符串
		public static Object ddex(Object pValue) {
			if (pValue == null) {
				return null;
			}
			if (pValue instanceof String) {
				return dd(pValue.toString());
			}
			return pValue;
		}
		
		
		public static int NewId(String tableName) throws SQLException
		{
			IdgeneratorDao  idDao = new IdgeneratorDao();
			return idDao.GetNewId(tableName);
		}
		
		public static String GetDateString(Date pDt) {
			SimpleDateFormat sdfDt = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.SSS");
			return sdfDt.format(pDt);
		}
		
		public static String GetDataString0(Date pDt,String format)
		{
			SimpleDateFormat sdfDt = new SimpleDateFormat(format);
			return sdfDt.format(pDt);
		}

		public static Date GetDate(String pDateStr) {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss.SSS");
			Date date = null;
			try {
				date = format.parse(pDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}
		
		public static Date GetDateNoF(String pDateStr) {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date date = null;
			try {
				date = format.parse(pDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}

		public static String GetYearString(Date pDt) {
			SimpleDateFormat sdfDt = new SimpleDateFormat("yyyy");
			return sdfDt.format(pDt);
		}

		//
		public static boolean compareDate(Date DATE1, Date DATE2) {
			try {
				if (DATE1.getTime() > DATE2.getTime()) {
					// System.out.println("dt1 在dt2前");
					return true;
				} else if (DATE1.getTime() < DATE2.getTime()) {
					// System.out.println("dt1在dt2后");
					return false;
				} else {
					return false;
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			return false;
		}

		//
		public static boolean compareDate(String DATE1, String DATE2) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			try {
				Date dt1 = df.parse(DATE1);
				Date dt2 = df.parse(DATE2);
				if (dt1.getTime() > dt2.getTime()) {
					// System.out.println("dt1 在dt2前");
					return true;
				} else if (dt1.getTime() < dt2.getTime()) {
					// System.out.println("dt1在dt2后");
					return false;
				} else {
					return false;
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			return false;
		}
		
		public static WfUserCfg GetUserCfg()
		{
			WfUserCfg rtn = new WfUserCfg();
			rtn.setDeptIdField("DEPT_ID");
			rtn.setUserIdField("USER_ID");
			rtn.setUserNameField("USERNAME");
			rtn.setUserTableName("SYS_USER");
			
			return rtn;
		}
		
		public static WfDeptCfg GetDeptCfg()
		{
			WfDeptCfg rtn = new WfDeptCfg();
			rtn.setDeptIdField("DEPT_ID");
			rtn.setDeptNameField("NAME");
			rtn.setDeptParentIdField("PARENT_ID");
			rtn.setDeptTable("SYS_DEPT");
			
			return rtn;
		}
		
		public static WfRoleCfg GetRoleCfg()
		{
			WfRoleCfg rtn = new WfRoleCfg();
			rtn.setRoleIdField("ROLE_ID");
			rtn.setRoleNameField("ROLE_NAME");
			rtn.setRoleTable("SYS_ROLE");
			
			return rtn;
		}
		public static Date NowDate()
		{
			return new Date();
		}
		
		public static String GetStrByIntlist(List<Integer> ints)
		{
			if(ints == null || ints.size() == 0)
			{
				return null;
			}
			String rtn = "";
			for(Integer lpItem : ints)
			{
				rtn += String.valueOf(lpItem) + ",";
			}
			if(rtn.endsWith(","))
			{
				rtn = rtn.substring(0, rtn.length() - 1);
			}
			//
			return rtn;
		}
		
		public static String GetStrByIntarray(int[] ints)
		{
			if(ints == null || ints.length == 0)
			{
				return null;
			}
			String rtn = "";
			for(int lpItem : ints)
			{
				rtn += String.valueOf(lpItem) + ",";
			}
			if(rtn.endsWith(","))
			{
				rtn = rtn.substring(0, rtn.length() - 1);
			}
			//
			return rtn;
		}
		
		// 读取附件保存路径
		public static String getNewsImgPath(String dataId,String pRootpath,boolean createPath) {
			String path0 = pRootpath;
			String path1 = pRootpath + "\\" + GetYearString(new Date());
			String path2 = path1 + "\\" + dataId + "\\";
			
			if (createPath) {
				CreatePath(path0);
				CreatePath(path1);
				CreatePath(path2);
			}
			//
			return "\\" + path2 + "\\" ;
		}
		
		// 创建路径
		private static void CreatePath(String pPath) {
			try {
				if (!(new File(pPath).isDirectory())) {
					new File(pPath).mkdir();
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
}
