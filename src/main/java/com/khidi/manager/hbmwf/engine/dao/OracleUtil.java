package com.khidi.manager.hbmwf.engine.dao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Value;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.khidi.manager.hbmwf.engine.domain.HbmentWf;
import com.khidi.manager.hbmwf.engine.domain.HbmentWfHandle;
import com.khidi.manager.hbmwf.engine.domain.HbmentWftmpl;
import com.khidi.manager.hbmwf.engine.domain.ext.EnumWfReceiverType;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgDept;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgRole;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentcfgUser;
import com.khidi.manager.hbmwf.engine.domain.ext.HbmentextWfReceiver;
import com.khidi.manager.hbmwf.engine.domain.tst.HbmentForm1;
import com.khidi.manager.hbmwf.engine.wfutil.HbmXml;
import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.hbmwf.enginext.cfg.receiver.WfDeptCfg;
import com.khidi.manager.hbmwf.enginext.cfg.receiver.WfRoleCfg;
import com.khidi.manager.hbmwf.enginext.cfg.receiver.WfUserCfg;
import com.khidi.manager.hbmwf.enginext.domain.HbmentFormHandle;

/**
 * ORACLE 数据解析
 *
 * @author 王顺波
 * @email 405877884@qq.com
 * @date 2017-11-17 11:02
 */
public class OracleUtil {
	// ORACLE连接串
	@Value("${spring.wfdatasource.url}")
	public static String ORACLE_URL;

	// ORACLE用户名
	@Value("${spring.wfdatasource.username}")
	public static String ORACLE_USERNAME;

	// ORACLE密码
	@Value("${spring.wfdatasource.password}")
	public static String ORACLE_PWD;

	// 根据oracle url ,name ,pwd获取Connection
	public static Connection GetConnection(String url, String name, String pwd) throws SQLException {
		return DriverManager.getConnection(url, name, pwd);
	}

	// 根据配置文件中的oracle url , name, pwd获取Connection
	public static Connection GetWfConnection() throws SQLException {
		return DriverManager.getConnection(HbmwfUtil.WF_DBURL, HbmwfUtil.WF_USERNAME, HbmwfUtil.WF_PWD);
	}

	public static Connection GetOperationConnection() throws SQLException {
		return DriverManager.getConnection(HbmwfUtil.WF_DBURL, HbmwfUtil.WF_USERNAME, HbmwfUtil.WF_PWD);
	}

	// 读取流程模板信息集合
	public static List<HbmentWftmpl> GetWftempInfos(ResultSet rs, boolean includeContent) throws Exception {
		List<HbmentWftmpl> rtnArr = new ArrayList<HbmentWftmpl>();
		while (rs.next()) {
			HbmentWftmpl rtn = new HbmentWftmpl();
			//
			rtn.setCreateDept(rs.getString("CREATEDEPT"));
			rtn.setCreateTime(rs.getDate("CREATETIME"));
			rtn.setCreateUser(rs.getString("CREATEUSER"));
			rtn.setId(rs.getInt("ID")); //
			rtn.setLastUpdateDept(rs.getString("LASTUPDATEDEPT"));
			rtn.setLastUpdateTime(rs.getDate("LASTUPDATETIME"));
			rtn.setLastUpdateUser(rs.getString("LASTUPDATEUSER"));
			rtn.setMemo(rs.getString("MEMO"));
			rtn.setName(rs.getString("NAME"));
			rtn.setPid(rs.getInt("PID"));
			rtn.setBfld0(rs.getString("BFLD0"));
			//
			if (includeContent) {
				String rtnContent = rs.getString("THECONTENT");
				String rtnContentXml = HbmwfUtil.decodeBase64(rtnContent);
				String rtnFlow = HbmXml.GetFlowJson(rtnContentXml, rtn.getName());
				rtn.setTheContent(rtnFlow);
			} else {
				rtn.setTheContent("");
			}

			//
			rtnArr.add(rtn);
		}
		//

		return rtnArr;
	}

	// 获取流程handles
	public static List<HbmentWfHandle> GetWfHandles(ResultSet rs) throws SQLException {
		List<HbmentWfHandle> rtnArr = new ArrayList<HbmentWfHandle>();
		while (rs.next()) {
			HbmentWfHandle rtn = new HbmentWfHandle();
			//
			rtn.setCreateDept(rs.getString("CREATEDEPT"));
			rtn.setCreateTime(rs.getDate("CREATETIME"));
			rtn.setCreateUser(rs.getString("CREATEUSER"));
			rtn.setCurrentInd(rs.getInt("CURRENTIND"));
			rtn.setDelInd(rs.getInt("DELIND"));
			rtn.setId(rs.getInt("ID")); //
			rtn.setLastUpdateDept(rs.getString("LASTUPDATEDEPT"));
			rtn.setLastUpdateTime(rs.getDate("LASTUPDATETIME"));
			rtn.setLastUpdateUser(rs.getString("LASTUPDATEUSER"));
			rtn.setMemo(rs.getString("MEMO"));
			rtn.setNodeId(rs.getString("NODEID"));
			rtn.setNodeState(rs.getString("NODESTATE"));
			rtn.setReceivers(rs.getString("RECEIVERS"));
			rtn.setWfId(rs.getInt("WFID"));

			//
			rtnArr.add(rtn);
		}
		//

		return rtnArr;
	}

	// 获取流程的handle
	public static HbmentWfHandle GetWfHandle(ResultSet rs) throws SQLException {
		while (rs.next()) {
			HbmentWfHandle rtn = new HbmentWfHandle();
			//
			rtn.setCreateDept(rs.getString("CREATEDEPT"));
			rtn.setCreateTime(rs.getDate("CREATETIME"));
			rtn.setCreateUser(rs.getString("CREATEUSER"));
			rtn.setCurrentInd(rs.getInt("CURRENTIND"));
			rtn.setDelInd(rs.getInt("DELIND"));
			rtn.setId(rs.getInt("ID")); //
			rtn.setLastUpdateDept(rs.getString("LASTUPDATEDEPT"));
			rtn.setLastUpdateTime(rs.getDate("LASTUPDATETIME"));
			rtn.setLastUpdateUser(rs.getString("LASTUPDATEUSER"));
			rtn.setMemo(rs.getString("MEMO"));
			rtn.setNodeId(rs.getString("NODEID"));
			rtn.setNodeState(rs.getString("NODESTATE"));
			rtn.setReceivers(rs.getString("RECEIVERS"));
			rtn.setWfId(rs.getInt("WFID"));

			//
			return rtn;
		}
		//
		return null;
	}

	// 读取流程模板信息
	public static HbmentWftmpl GetWftempInfo(ResultSet pRs) throws SQLException {
		while (pRs.next()) {
			HbmentWftmpl rtn = new HbmentWftmpl();
			//
			rtn.setCreateDept(pRs.getString("CREATEDEPT"));
			rtn.setCreateTime(pRs.getDate("CREATETIME"));
			rtn.setCreateUser(pRs.getString("CREATEUSER"));
			rtn.setId(pRs.getInt("ID")); //
			rtn.setLastUpdateDept(pRs.getString("LASTUPDATEDEPT"));
			rtn.setLastUpdateTime(pRs.getDate("LASTUPDATETIME"));
			rtn.setLastUpdateUser(pRs.getString("LASTUPDATEUSER"));
			rtn.setMemo(pRs.getString("MEMO"));
			rtn.setName(pRs.getString("NAME"));
			rtn.setPid(pRs.getInt("PID"));
			rtn.setBfld0(pRs.getString("BFLD0"));
			rtn.setTheContent(pRs.getString("THECONTENT"));
			//
			return rtn;
		}
		return null;
	}

	// 读取流程信息集合
	public static List<HbmentWf> GetWfInfos(ResultSet rs, boolean includeContent) throws SQLException {
		List<HbmentWf> rtnArr = new ArrayList<HbmentWf>();
		while (rs.next()) {
			HbmentWf rtn = new HbmentWf();
			//
			rtn.setCreateDept(rs.getString("CREATEDEPT"));
			rtn.setCreateTime(rs.getDate("CREATETIME"));
			rtn.setCreateUser(rs.getString("CREATEUSER"));
			rtn.setFormId(rs.getString("FORMID"));
			rtn.setFormType("FORMTYPE");
			rtn.setId(rs.getInt("ID"));
			rtn.setLastUpdateDept(rs.getString("LASTUPDATEDEPT"));
			rtn.setLastUpdateTime(rs.getDate("LASTUPDATETIME"));
			rtn.setLastUpdateUser(rs.getString("LASTUPDATEUSER"));
			rtn.setMemo(rs.getString("MEMO"));
			rtn.setName(rs.getString("NAME"));
			if (includeContent) {
				rtn.setWfContent(rs.getString("WFCONTENT"));
			}
			rtn.setWfTmplId(rs.getInt("WFTMPLID"));
			//
			rtnArr.add(rtn);
		}
		return rtnArr;
	}

	// 读取流程信息
	public static HbmentWf GetWfInfo(ResultSet rs, boolean includeContent) throws SQLException {
		List<HbmentWf> rtnArr = new ArrayList<HbmentWf>();
		while (rs.next()) {
			HbmentWf rtn = new HbmentWf();
			//
			rtn.setCreateDept(rs.getString("CREATEDEPT"));
			rtn.setCreateTime(rs.getDate("CREATETIME"));
			rtn.setCreateUser(rs.getString("CREATEUSER"));
			rtn.setFormId(rs.getString("FORMID"));
			rtn.setFormType(rs.getString("FORMTYPE"));
			rtn.setId(rs.getInt("ID"));
			rtn.setLastUpdateDept(rs.getString("LASTUPDATEDEPT"));
			rtn.setLastUpdateTime(rs.getDate("LASTUPDATETIME"));
			rtn.setLastUpdateUser(rs.getString("LASTUPDATEUSER"));
			rtn.setMemo(rs.getString("MEMO"));
			rtn.setName(rs.getString("NAME"));
			if (includeContent) {
				rtn.setWfContent(rs.getString("WFCONTENT"));
			}
			rtn.setWfTmplId(rs.getInt("WFTMPLID"));
			//
			return rtn;
		}
		return null;
	}

	// 读取表单Handles信息
	public static List<HbmentFormHandle> GetFormHandles(ResultSet rs) throws SQLException {
		List<HbmentFormHandle> rtnArr = new ArrayList<HbmentFormHandle>();
		while (rs.next()) {
			HbmentFormHandle rtn = new HbmentFormHandle();
			//
			rtn.setCompletedDeptId(rs.getString("COMPLETEDDEPTID"));
			rtn.setCompletedEmpId(rs.getString("COMPLETEDEMPID"));
			rtn.setCompletedInd(rs.getString("COMPLETEDIND"));
			rtn.setCompletedTime(rs.getDate("COMPLETEDTIME"));
			rtn.setCreateDeptId(rs.getString("CREATEDEPTID"));
			rtn.setCreateTm(rs.getString("CREATETM"));
			rtn.setCreateUserId(rs.getString("CREATEUSERID"));
			rtn.setCurrentInd(rs.getString("CURRENTIND"));
			rtn.setDwState(rs.getString("DWSTATE"));
			rtn.setFormId(rs.getString("FORMID"));
			rtn.setFormType(rs.getString("FORMTYPE"));
			rtn.setHandleId(rs.getInt("ID"));
			rtn.setReadDeptId(rs.getString("READDEPTID"));
			rtn.setReadEmpId(rs.getString("READEMPID"));
			rtn.setReadInd(rs.getString("READIND"));
			rtn.setReadTime(rs.getDate("READTIME"));
			rtn.setReceiverId(rs.getString("RECEIVERID"));
			rtn.setVeriDesc(rs.getString("VERIDESC"));
			// rtn.setWfHid(rs.getInt(""));//TODO:丢弃
			rtn.setWfNodeId(rs.getString("WFNODEID"));
			//
			rtnArr.add(rtn);
		}
		return rtnArr;
	}

	// 读取表单Handle信息
	public static HbmentFormHandle GetFormHandle(ResultSet rs) throws SQLException {
		while (rs.next()) {
			HbmentFormHandle rtn = new HbmentFormHandle();
			//
			rtn.setCompletedDeptId(rs.getString("COMPLETEDDEPTID"));
			rtn.setCompletedEmpId(rs.getString("COMPLETEDEMPID"));
			rtn.setCompletedInd(rs.getString("COMPLETEDIND"));
			rtn.setCompletedTime(rs.getDate("COMPLETEDTIME"));
			rtn.setCreateDeptId(rs.getString("CREATEDEPTID"));
			rtn.setCreateTm(rs.getString("CREATETM"));
			rtn.setCreateUserId(rs.getString("CREATEUSERID"));
			rtn.setCurrentInd(rs.getString("CURRENTIND"));
			rtn.setDwState(rs.getString("DWSTATE"));
			rtn.setFormId(rs.getString("FORMID"));
			rtn.setFormType(rs.getString("FORMTYPE"));
			rtn.setHandleId(rs.getInt("ID"));
			rtn.setReadDeptId(rs.getString("READDEPTID"));
			rtn.setReadEmpId(rs.getString("READEMPID"));
			rtn.setReadInd(rs.getString("READIND"));
			rtn.setReadTime(rs.getDate("READTIME"));
			rtn.setReceiverId(rs.getString("RECEIVERID"));
			rtn.setVeriDesc(rs.getString("VERIDESC"));
			// rtn.setWfHid(rs.getInt(""));//TODO:丢弃
			rtn.setWfNodeId(rs.getString("WFNODEID"));
			//
			return rtn;
		}
		return null;
	}

	// 读取接收者信息集合
	public static List<HbmentextWfReceiver> GetWfAbsInfos(ResultSet pRs) throws SQLException {
		List<HbmentextWfReceiver> rtnArr = new ArrayList<HbmentextWfReceiver>();
		while (pRs.next()) {
			HbmentextWfReceiver rtn = new HbmentextWfReceiver();
			//
			rtn.setDeptId(pRs.getString("DEPTID"));
			rtn.setDeptRoleId(pRs.getString("DEPTROLEID"));
			rtn.setId(pRs.getInt("ABSRECEIVERID"));
			rtn.setReceiverType(EnumWfReceiverType.valueOf(pRs.getString("RECEIVERTYPECODE")));
			rtn.setRoleId(pRs.getString("ROLEID"));
			rtn.setUserId("EMPID");
			//
			rtnArr.add(rtn);
		}
		return rtnArr;
	}

	// 读取接收者信息
	public static HbmentextWfReceiver GetWfAbsInfo(ResultSet pRs) throws SQLException {
		while (pRs.next()) {
			HbmentextWfReceiver rtn = new HbmentextWfReceiver();
			//
			rtn.setDeptId(pRs.getString("DEPTID"));
			rtn.setDeptRoleId(pRs.getString("DEPTROLEID"));
			rtn.setId(pRs.getInt("ABSRECEIVERID"));
			rtn.setReceiverType(EnumWfReceiverType.valueOf(pRs.getString("RECEIVERTYPECODE")));
			rtn.setRoleId(pRs.getString("ROLEID"));
			rtn.setUserId(pRs.getString("EMPID"));
			//
			return rtn;
		}
		return null;
	}

	// 读取配置的用户信息
	public static HbmentcfgUser GetCfgUserInfo(ResultSet rs, WfUserCfg userCfg,WfDeptCfg deptCfg) throws SQLException {
		while (rs.next()) {
			HbmentcfgUser rtn = new HbmentcfgUser();
			//
			rtn.setDeptId(rs.getString(userCfg.getDeptIdField()));
			rtn.setUserId(rs.getString(userCfg.getUserIdField()));
			rtn.setUserName(rs.getString(userCfg.getUserNameField()));
			rtn.setDeptName(rs.getString("DEPTNAME"));
			//
			return rtn;
		}
		return null;
	}

	// 读取配置的用户信息集合
	public static List<HbmentcfgUser> GetCfgUserInfos(ResultSet rs, WfUserCfg userCfg,WfDeptCfg deptCfg) throws SQLException {
		List<HbmentcfgUser> rtnArr = new ArrayList<HbmentcfgUser>();
		while (rs.next()) {
			HbmentcfgUser rtn = new HbmentcfgUser();
			//
			rtn.setDeptId(rs.getString(userCfg.getDeptIdField()));
			rtn.setUserId(rs.getString(userCfg.getUserIdField()));
			rtn.setUserName(rs.getString(userCfg.getUserNameField()));
			rtn.setDeptName(rs.getString("DEPTNAME"));
			//
			rtnArr.add(rtn);
		}
		return rtnArr;
	}

	// 读取配置的部门信息集合
	public static List<HbmentcfgDept> GetCfgDeptInfos(ResultSet rs, WfDeptCfg deptCfg) throws SQLException {
		List<HbmentcfgDept> rtnArr = new ArrayList<HbmentcfgDept>();
		while (rs.next()) {
			HbmentcfgDept rtn = new HbmentcfgDept();
			//
			rtn.setDeptId(rs.getString(deptCfg.getDeptIdField()));
			rtn.setDeptName(rs.getString(deptCfg.getDeptNameField()));
			rtn.setDeptParentid(rs.getString(deptCfg.getDeptParentIdField()));
			//
			rtnArr.add(rtn);
		}
		return rtnArr;
	}

	// 读取配置的部门信息
	public static HbmentcfgDept GetCfgDeptInfo(ResultSet rs, WfDeptCfg deptCfg) throws SQLException {
		List<HbmentcfgDept> rtnArr = new ArrayList<HbmentcfgDept>();
		while (rs.next()) {
			HbmentcfgDept rtn = new HbmentcfgDept();
			//
			rtn.setDeptId(rs.getString(deptCfg.getDeptIdField()));
			rtn.setDeptName(rs.getString(deptCfg.getDeptNameField()));
			rtn.setDeptParentid(rs.getString(deptCfg.getDeptParentIdField()));
			//
			return rtn;
		}
		return null;
	}

	// 读取配置的角色信息集合
	public static List<HbmentcfgRole> GetCfgRoleInfos(ResultSet rs, WfRoleCfg roleCfg) throws SQLException {
		List<HbmentcfgRole> rtnArr = new ArrayList<HbmentcfgRole>();
		while (rs.next()) {
			HbmentcfgRole rtn = new HbmentcfgRole();
			//
			rtn.setRoleId(rs.getString(roleCfg.getRoleIdField()));
			rtn.setRoleName(rs.getString(roleCfg.getRoleNameField()));
			//
			rtnArr.add(rtn);
		}
		return rtnArr;
	}

	// 读取配置的角色信息
	public static HbmentcfgRole GetCfgRoleInfo(ResultSet rs, WfRoleCfg roleCfg) throws SQLException {
		List<HbmentcfgRole> rtnArr = new ArrayList<HbmentcfgRole>();
		while (rs.next()) {
			HbmentcfgRole rtn = new HbmentcfgRole();
			//
			rtn.setRoleId(rs.getString(roleCfg.getRoleIdField()));
			rtn.setRoleName(rs.getString(roleCfg.getRoleNameField()));
			//
			return rtn;
		}
		return null;
	}

	// 读取测试表单数据
	public static HbmentForm1 GetForm1(ResultSet rs) throws SQLException {
		HbmentForm1 rtn = new HbmentForm1();
		while (rs.next()) {
			rtn.setContent(rs.getString("THECONTENT"));
			rtn.setId(rs.getInt("ID"));
			rtn.setName(rs.getString("NAME"));
			rtn.setState(rs.getString("STATE"));
			rtn.setKx(rs.getDouble("KX"));
			//
			return rtn;
		}
		return null;
	}

	// 读取测试表单数据
	public static List<HbmentForm1> GetForm1s(ResultSet rs) throws SQLException {
		List<HbmentForm1> rtn = new ArrayList<HbmentForm1>();
		while (rs.next()) {
			HbmentForm1 rtnItem = new HbmentForm1();
			rtnItem.setContent(rs.getString("THECONTENT"));
			rtnItem.setId(rs.getInt("ID"));
			rtnItem.setName(rs.getString("NAME"));
			rtnItem.setState(rs.getString("STATE"));
			rtnItem.setKx(rs.getDouble("KX"));
			//
			rtn.add(rtnItem);
		}
		return rtn;
	}

	// 检查是否有数据
	public static boolean CheckDataExists(ResultSet rs) throws SQLException {
		while (rs.next()) {
			int rtn = rs.getInt(1);
			return rtn > 0;
		}
		return false;
	}

	// 获取整型参数
	public static int getIntNum(ResultSet rs) throws SQLException {
		while (rs.next()) {
			int rtn = rs.getInt("ID");
			return rtn;
		}
		return 0;
	}
	
	public static String getSingleValue(ResultSet rs) throws SQLException
	{
		while (rs.next()) {
			String rtn = rs.getString(1);
			return rtn;
		}
		return null;
	}

	// 读取流程XML内容
	public static String GetWfXmlContent(String content) throws Exception {
		String rtnContentXml = HbmwfUtil.decodeBase64(content);
		//
		return rtnContentXml;
	}

	// 读取流程Json内容
	public static String GetWfJsonContent(String content, String title) throws Exception {
		String rtnContentXml = HbmwfUtil.decodeBase64(content);
		String rtnFlow = HbmXml.GetFlowJson(rtnContentXml, title);
		//
		return rtnFlow;
	}

	// 通过XML读取流程Json内容
	public static String GetWfJsonContentByXml(String wfXml, String title)
			throws UnsupportedEncodingException, ParserConfigurationException, SAXException, IOException {
		String rtnFlow = HbmXml.GetFlowJson(wfXml, title);
		//
		return rtnFlow;
	}

	// 把DOC转换为Base64
	public static String Getbase64codeFromDocument(Document doc) throws Exception {
		String xml = HbmXml.GetXmlFromDoc(doc);
		String wfContent = HbmwfUtil.encodeBase64(xml.getBytes()).replace(" ", "+");
		//
		return wfContent;
	}
}