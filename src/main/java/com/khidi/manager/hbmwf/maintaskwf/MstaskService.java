/**   
* @Title: MstaskService.java 
* @Package com.khidi.manager.hbmwf.maintaskwf 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2018年1月12日 上午11:52:54 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.maintaskwf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.khidi.manager.hbmwf.engine.wfutil.HbmwfUtil;
import com.khidi.manager.maintask.dao.StTargetDao;
import com.khidi.manager.maintask.dao.StTargetdetailDao;
import com.khidi.manager.maintask.dao.StTaskDao;
import com.khidi.manager.maintask.dao.StTaskdetailDao;
import com.khidi.manager.maintask.service.StCommonService;
import com.khidi.manager.maintask.entity.StTargetEntity;
import com.khidi.manager.maintask.entity.StTargetdetailEntity;
import com.khidi.manager.maintask.entity.StTargetdetailTransmitEntity;
import com.khidi.manager.maintask.entity.StTaskEntity;
import com.khidi.manager.maintask.entity.StTaskdetailEntity;
import com.khidi.manager.maintask.entity.StTaskdetailTransmitEntity;

/**
 * @author Administrator
 *
 */
@Component
@Qualifier("MstaskService")
public class MstaskService {

	@Autowired
	private StTargetDao targetDao;


	@Autowired
	private StTargetdetailDao targetDetailDao;

	@Autowired
	private StTaskDao taskDao;
	
	@Autowired
	private StTaskdetailDao taskDetailDao;
	
	@Autowired
	private StCommonService taskDetailService;

	public String GetStWf(String id, EnumWfType wfType) {
		String wfTypeStr = String.valueOf(wfType);
		switch (wfTypeStr) {
		case "target":
			return GetStTargetWf(id);
		case "task":
			return GetStTaskWf(id);
		default:
			break;
		}
		return null;
	}

	//
	private String _GetNxIdsFromTarget(StTargetEntity targetEntity) {
		List<StTargetdetailEntity> targetDetails = targetEntity.getTargetDetails();
		if (targetDetails == null || targetDetails.size() == 0) {
			return "";
		}
		//
		String rtn0 = "";
		for (StTargetdetailEntity lpTargetDetailEntity : targetDetails) {
			rtn0 += lpTargetDetailEntity.getId() + ",";
		}
		if (rtn0.endsWith(",")) {
			rtn0 = rtn0.substring(0, rtn0.length() - 1);
		}
		return rtn0;
	}
	
	//
	private String _GetNxIdsFromTask(StTaskEntity taskEntity) {
		List<StTaskdetailEntity> taskDetails = taskEntity.getTaskDetails();
		if (taskDetails == null || taskDetails.size() == 0) {
			return "";
		}
		//
		String rtn0 = "";
		for (StTaskdetailEntity lpTaskDetailEntity : taskDetails) {
			rtn0 += lpTaskDetailEntity.getId() + ",";
		}
		if (rtn0.endsWith(",")) {
			rtn0 = rtn0.substring(0, rtn0.length() - 1);
		}
		return rtn0;
	}

	//
	private String GetStTargetWf(String targetId) {
		StTargetEntity targetEntity = targetDao.queryObject(targetId);
		if(targetEntity == null)
		{
			return null;
		}
		List<StTargetdetailEntity> targetDetail = taskDetailService.queryTargetdetailByTargetId(targetId);
		//
		int oriLeft = 100;
		int oriTop = 10;
		int xPos = 0;
		int yPos = 0;
		int yDtHeight = 100;
		int y1Pos = 1;
		int xDtWidth = 220;
		int cmNodeHeight = 50;
		//
		targetEntity.setTargetDetails(targetDetail);
		//
		for (StTargetdetailEntity lpTargetDetail : targetDetail) {
			List<StTargetdetailTransmitEntity> targetDetailTransmit = taskDetailService
					.queryTargetdetailTransmitByTargetedtailId(lpTargetDetail.getId());
			lpTargetDetail.setTargetTransmit(targetDetailTransmit);
		}
		//
		String rtn = "";
		String lines = "";
		lines += HbmwfUtil.dd("lines") + ":{";
		//
		rtn += "{" + HbmwfUtil.dd("title") + ":" + HbmwfUtil.dd(targetEntity.getTargetname()) + ",";
		//
		rtn += HbmwfUtil.dd("nodes") + ":{";
		//
		rtn += HbmwfUtil.dd(targetEntity.getId()) + ": {";
		//
		rtn += HbmwfUtil.dd("alt") + ":" + HbmwfUtil.dd("true") + ",";
		rtn += HbmwfUtil.dd("height") + ":" + HbmwfUtil.dd(String.valueOf(cmNodeHeight)) + ",";
		rtn += HbmwfUtil.dd("id") + ":" + HbmwfUtil.dd(targetEntity.getId()) + ",";
		rtn += HbmwfUtil.dd("left") + ":" + HbmwfUtil.dd(String.valueOf(oriLeft + xPos * xDtWidth)) + ",";
		rtn += HbmwfUtil.dd("name") + ":" + HbmwfUtil.dd(targetEntity.getTargetname()) + ",";
		rtn += HbmwfUtil.dd("nxtids") + ":" + HbmwfUtil.dd(_GetNxIdsFromTarget(targetEntity)) + ",";
		rtn += HbmwfUtil.dd("detailid") + ":" + HbmwfUtil.dd("") + ",";
		rtn += HbmwfUtil.dd("prelogic") + ":" + HbmwfUtil.dd("and") + ",";
		rtn += HbmwfUtil.dd("receiver") + ":" + HbmwfUtil.dd("") + ",";
		rtn += HbmwfUtil.dd("state") + ":" + HbmwfUtil.dd("DOING") + ",";
		rtn += HbmwfUtil.dd("top") + ":" + HbmwfUtil.dd(String.valueOf(oriTop + yPos * yDtHeight)) + ",";
		rtn += HbmwfUtil.dd("type") + ":" + HbmwfUtil.dd("task") + ",";
		rtn += HbmwfUtil.dd("width") + ":" + HbmwfUtil.dd("123") + "},";
		//
		xPos++;
		//
		if (targetDetail != null && targetDetail.size() > 0) {
			for (StTargetdetailEntity lpTargetDetailEntity : targetDetail) {
				rtn += HbmwfUtil.dd(lpTargetDetailEntity.getId()) + ": {";
				//
				rtn += HbmwfUtil.dd("alt") + ":" + HbmwfUtil.dd("true") + ",";
				rtn += HbmwfUtil.dd("height") + ":" + HbmwfUtil.dd(String.valueOf(cmNodeHeight)) + ",";
				rtn += HbmwfUtil.dd("id") + ":" + HbmwfUtil.dd(lpTargetDetailEntity.getId()) + ",";
				rtn += HbmwfUtil.dd("left") + ":" + HbmwfUtil.dd(String.valueOf(oriLeft + xPos * xDtWidth)) + ",";
				rtn += HbmwfUtil.dd("name") + ":" + HbmwfUtil.dd("责任部门:" + lpTargetDetailEntity.getRespdeptName()) + ",";

				List<StTargetdetailTransmitEntity> targetDetailTransmit = lpTargetDetailEntity.getTargetTransmit();
				//
				String targetDetailNxtIds = "";
				if (lpTargetDetailEntity.getAcceptflag() == null || !lpTargetDetailEntity.getAcceptflag().equals("1")) {
					if (targetDetailTransmit != null && targetDetailTransmit.size() > 0) {
						targetDetailNxtIds = targetDetailTransmit.get(0).getId();
					}
				}
				//
				rtn += HbmwfUtil.dd("nxtids") + ":" + HbmwfUtil.dd(targetDetailNxtIds) + ",";
				rtn += HbmwfUtil.dd("detailid") + ":" + HbmwfUtil.dd(lpTargetDetailEntity.getId()) + ",";
				rtn += HbmwfUtil.dd("prelogic") + ":" + HbmwfUtil.dd("and") + ",";
				rtn += HbmwfUtil.dd("receiver") + ":" + HbmwfUtil.dd("") + ",";
				rtn += HbmwfUtil.dd("state") + ":" + HbmwfUtil.dd("DOING") + ",";
				rtn += HbmwfUtil.dd("top") + ":" + HbmwfUtil.dd(String.valueOf(oriTop + yPos * yDtHeight)) + ",";
				rtn += HbmwfUtil.dd("type") + ":" + HbmwfUtil.dd("task") + ",";
				rtn += HbmwfUtil.dd("width") + ":" + HbmwfUtil.dd("123") + "},";
				//

				////// line
				lines += HbmwfUtil.dd("l" + lpTargetDetailEntity.getId()) + ": {";
				lines += HbmwfUtil.dd("dash") + ": false,";
				lines += HbmwfUtil.dd("from") + ":" + HbmwfUtil.dd(targetEntity.getId()) + ",";
				lines += HbmwfUtil.dd("id") + ":" + HbmwfUtil.dd("l" + lpTargetDetailEntity.getId()) + ",";
				lines += HbmwfUtil.dd("name") + ":" + HbmwfUtil.dd("") + ",";
				lines += HbmwfUtil.dd("to") + ":" + HbmwfUtil.dd(lpTargetDetailEntity.getId()) + ",";
				lines += HbmwfUtil.dd("type") + ":" + HbmwfUtil.dd("sl") + "},";
				//

				if (targetDetailTransmit != null && targetDetailTransmit.size() > 0) {
					int __tmpPos = 0;
					for (StTargetdetailTransmitEntity lpTargetDetailTransmitEntity : targetDetailTransmit) {
						xPos++;
						rtn += HbmwfUtil.dd(lpTargetDetailTransmitEntity.getId()) + ": {";
						rtn += HbmwfUtil.dd("alt") + ":" + HbmwfUtil.dd("true") + ",";
						rtn += HbmwfUtil.dd("height") + ":" + HbmwfUtil.dd(String.valueOf(cmNodeHeight)) + ",";
						rtn += HbmwfUtil.dd("id") + ":" + HbmwfUtil.dd(lpTargetDetailTransmitEntity.getId()) + ",";
						rtn += HbmwfUtil.dd("left") + ":" + HbmwfUtil.dd(String.valueOf(oriLeft + xPos * xDtWidth))
								+ ",";
						rtn += HbmwfUtil.dd("name") + ":"
								+ HbmwfUtil.dd("转发到部门:" + lpTargetDetailTransmitEntity.getTodeptName()) + ",";

						String nxtIds = "";
						if (targetDetailTransmit.size() > __tmpPos) {
							nxtIds = targetDetailTransmit.get(__tmpPos).getId();
						}
						rtn += HbmwfUtil.dd("nxtids") + ":" + HbmwfUtil.dd(nxtIds) + ",";
						rtn += HbmwfUtil.dd("detailid") + ":" + HbmwfUtil.dd(lpTargetDetailEntity.getId()) + ",";
						rtn += HbmwfUtil.dd("prelogic") + ":" + HbmwfUtil.dd("and") + ",";
						rtn += HbmwfUtil.dd("receiver") + ":" + HbmwfUtil.dd("") + ",";
						rtn += HbmwfUtil.dd("state") + ":" + HbmwfUtil.dd("DOING") + ",";
						rtn += HbmwfUtil.dd("top") + ":" + HbmwfUtil.dd(String.valueOf(oriTop + y1Pos * yDtHeight))
								+ ",";
						rtn += HbmwfUtil.dd("type") + ":" + HbmwfUtil.dd("task") + ",";
						rtn += HbmwfUtil.dd("width") + ":" + HbmwfUtil.dd("123") + "},";
						//

						/////////////
						////// line
						if (__tmpPos == 0) {
							lines += HbmwfUtil.dd("l" + lpTargetDetailTransmitEntity.getId()) + ": {";
							lines += HbmwfUtil.dd("dash") + ": false,";
							lines += HbmwfUtil.dd("from") + ":" +  HbmwfUtil.dd(lpTargetDetailEntity.getId()) + ",";
							lines += HbmwfUtil.dd("id") + ":"
									+ HbmwfUtil.dd("l" + lpTargetDetailTransmitEntity.getId()) + ",";
							lines += HbmwfUtil.dd("name") + ":"
									+ HbmwfUtil.dd("") + ",";
							lines += HbmwfUtil.dd("to") + ":"
									+ HbmwfUtil.dd(targetDetailTransmit.get(__tmpPos).getId()) + ",";
							lines += HbmwfUtil.dd("type") + ":" + HbmwfUtil.dd("sl") + "},";

						} else {
							if (targetDetailTransmit.size() > __tmpPos) {
								lines += HbmwfUtil.dd("l" + lpTargetDetailTransmitEntity.getId()) + ": {";
								lines += HbmwfUtil.dd("dash") + ": false,";
								lines += HbmwfUtil.dd("from") + ":" + HbmwfUtil.dd(targetDetailTransmit.get(__tmpPos-1).getId()) + ",";
								lines += HbmwfUtil.dd("id") + ":"
										+ HbmwfUtil.dd("l" + lpTargetDetailTransmitEntity.getId()) + ",";
								lines += HbmwfUtil.dd("name") + ":"
										+  HbmwfUtil.dd("") + ",";
								lines += HbmwfUtil.dd("to") + ":"
										+ HbmwfUtil.dd(targetDetailTransmit.get(__tmpPos).getId()) + ",";
								lines += HbmwfUtil.dd("type") + ":" + HbmwfUtil.dd("sl") + "},";
							}
						}
						//
						////////
						__tmpPos++;
					}
					xPos -= targetDetailTransmit.size();
				}
				//
				yPos++;
			}
		}
		//
		if (lines.endsWith(",")) {
			lines = lines.substring(0, lines.length() - 1);
		}
		lines += "}";
		//
		if (rtn.endsWith(",")) {
			rtn = rtn.substring(0, rtn.length() - 1);
		}
		rtn += "}," + lines + ",";
		rtn += HbmwfUtil.dd("areas") + ": {},";
		rtn += HbmwfUtil.dd("initNum") + ":" + HbmwfUtil.dd("16") + "}";
		//

		//
		return rtn;// TODO:
	}

	private String GetStTaskWf(String taskId) {
		// StTaskEntity taskEntity = taskDao.queryList(map)
		StTaskEntity taskEntity = taskDao.queryObject(taskId);
		if(taskEntity == null)
		{
			return null;
		}
		List<StTaskdetailEntity> taskDetail = taskDetailDao.queryTaskdetailListByTaskId(taskId);
		//
		int oriLeft = 100;
		int oriTop = 10;
		int xPos = 0;
		int yPos = 0;
		int yDtHeight = 100;
		int y1Pos = 1;
		int xDtWidth = 220;
		int cmNodeHeight = 50;
		//
		taskEntity.setTaskDetails(taskDetail);
		//
		for (StTaskdetailEntity lpTaskDetail : taskDetail) {
			List<StTaskdetailTransmitEntity> taskDetailTransmit = taskDetailService.queryTaskdetailTransmitByTaskdetailId(lpTaskDetail.getId());
			lpTaskDetail.setTaskTransmit(taskDetailTransmit);
		}
		//
		String rtn = "";
		String lines = "";
		lines += HbmwfUtil.dd("lines") + ":{";
		//
		rtn += "{" + HbmwfUtil.dd("title") + ":" + HbmwfUtil.dd(taskEntity.getTaskname()) + ",";
		//
		rtn += HbmwfUtil.dd("nodes") + ":{";
		//
		rtn += HbmwfUtil.dd(taskEntity.getId()) + ": {";
		//
		rtn += HbmwfUtil.dd("alt") + ":" + HbmwfUtil.dd("true") + ",";
		rtn += HbmwfUtil.dd("height") + ":" + HbmwfUtil.dd(String.valueOf(cmNodeHeight)) + ",";
		rtn += HbmwfUtil.dd("id") + ":" + HbmwfUtil.dd(taskEntity.getId()) + ",";
		rtn += HbmwfUtil.dd("left") + ":" + HbmwfUtil.dd(String.valueOf(oriLeft + xPos * xDtWidth)) + ",";
		rtn += HbmwfUtil.dd("name") + ":" + HbmwfUtil.dd(taskEntity.getTaskname()) + ",";
		rtn += HbmwfUtil.dd("nxtids") + ":" + HbmwfUtil.dd(_GetNxIdsFromTask(taskEntity)) + ",";
		rtn += HbmwfUtil.dd("detailid") + ":" + HbmwfUtil.dd("") + ",";
		rtn += HbmwfUtil.dd("prelogic") + ":" + HbmwfUtil.dd("and") + ",";
		rtn += HbmwfUtil.dd("receiver") + ":" + HbmwfUtil.dd("") + ",";
		rtn += HbmwfUtil.dd("state") + ":" + HbmwfUtil.dd("DOING") + ",";
		rtn += HbmwfUtil.dd("top") + ":" + HbmwfUtil.dd(String.valueOf(oriTop + yPos * yDtHeight)) + ",";
		rtn += HbmwfUtil.dd("type") + ":" + HbmwfUtil.dd("task") + ",";
		rtn += HbmwfUtil.dd("width") + ":" + HbmwfUtil.dd("123") + "},";
		//
		xPos++;
		//
		if (taskDetail != null && taskDetail.size() > 0) {
			for (StTaskdetailEntity lpTaskDetailEntity : taskDetail) {
				rtn += HbmwfUtil.dd(lpTaskDetailEntity.getId()) + ": {";
				//
				rtn += HbmwfUtil.dd("alt") + ":" + HbmwfUtil.dd("true") + ",";
				rtn += HbmwfUtil.dd("height") + ":" + HbmwfUtil.dd(String.valueOf(cmNodeHeight)) + ",";
				rtn += HbmwfUtil.dd("id") + ":" + HbmwfUtil.dd(lpTaskDetailEntity.getId()) + ",";
				rtn += HbmwfUtil.dd("left") + ":" + HbmwfUtil.dd(String.valueOf(oriLeft + xPos * xDtWidth)) + ",";
				rtn += HbmwfUtil.dd("name") + ":" + HbmwfUtil.dd("责任部门:" + lpTaskDetailEntity.getRespdeptName()) + ",";

				List<StTaskdetailTransmitEntity> taskDetailTransmit = lpTaskDetailEntity.getTaskTransmit();
				//
				String taskDetailNxtIds = "";
				if (lpTaskDetailEntity.getAcceptflag() == null || !lpTaskDetailEntity.getAcceptflag().equals("1")) {
					if (taskDetailTransmit != null && taskDetailTransmit.size() > 0) {
						taskDetailNxtIds = taskDetailTransmit.get(0).getId();
					}
				}
				//
				rtn += HbmwfUtil.dd("nxtids") + ":" + HbmwfUtil.dd(taskDetailNxtIds) + ",";
				rtn += HbmwfUtil.dd("detailid") + ":" + HbmwfUtil.dd(lpTaskDetailEntity.getId()) + ",";
				rtn += HbmwfUtil.dd("prelogic") + ":" + HbmwfUtil.dd("and") + ",";
				rtn += HbmwfUtil.dd("receiver") + ":" + HbmwfUtil.dd("") + ",";
				rtn += HbmwfUtil.dd("state") + ":" + HbmwfUtil.dd("DOING") + ",";
				rtn += HbmwfUtil.dd("top") + ":" + HbmwfUtil.dd(String.valueOf(oriTop + yPos * yDtHeight)) + ",";
				rtn += HbmwfUtil.dd("type") + ":" + HbmwfUtil.dd("task") + ",";
				rtn += HbmwfUtil.dd("width") + ":" + HbmwfUtil.dd("123") + "},";
				//

				////// line
				lines += HbmwfUtil.dd("l" + lpTaskDetailEntity.getId()) + ": {";
				lines += HbmwfUtil.dd("dash") + ": false,";
				lines += HbmwfUtil.dd("from") + ":" + HbmwfUtil.dd(taskEntity.getId()) + ",";
				lines += HbmwfUtil.dd("id") + ":" + HbmwfUtil.dd("l" + lpTaskDetailEntity.getId()) + ",";
				lines += HbmwfUtil.dd("name") + ":" + HbmwfUtil.dd("") + ",";
				lines += HbmwfUtil.dd("to") + ":" + HbmwfUtil.dd(lpTaskDetailEntity.getId()) + ",";
				lines += HbmwfUtil.dd("type") + ":" + HbmwfUtil.dd("sl") + "},";
				//

				if (taskDetailTransmit != null && taskDetailTransmit.size() > 0) {
					int __tmpPos = 0;
					for (StTaskdetailTransmitEntity lpTargetDetailTransmitEntity : taskDetailTransmit) {
						xPos++;
						rtn += HbmwfUtil.dd(lpTargetDetailTransmitEntity.getId()) + ": {";
						rtn += HbmwfUtil.dd("alt") + ":" + HbmwfUtil.dd("true") + ",";
						rtn += HbmwfUtil.dd("height") + ":" + HbmwfUtil.dd(String.valueOf(cmNodeHeight)) + ",";
						rtn += HbmwfUtil.dd("id") + ":" + HbmwfUtil.dd(lpTargetDetailTransmitEntity.getId()) + ",";
						rtn += HbmwfUtil.dd("left") + ":" + HbmwfUtil.dd(String.valueOf(oriLeft + xPos * xDtWidth))
								+ ",";
						rtn += HbmwfUtil.dd("name") + ":"
								+ HbmwfUtil.dd("转发到部门:" + lpTargetDetailTransmitEntity.getTodeptName()) + ",";

						String nxtIds = "";
						if (taskDetailTransmit.size() > __tmpPos) {
							nxtIds = taskDetailTransmit.get(__tmpPos).getId();
						}
						rtn += HbmwfUtil.dd("nxtids") + ":" + HbmwfUtil.dd(nxtIds) + ",";
						rtn += HbmwfUtil.dd("detailid") + ":" + HbmwfUtil.dd(lpTaskDetailEntity.getId()) + ",";
						rtn += HbmwfUtil.dd("prelogic") + ":" + HbmwfUtil.dd("and") + ",";
						rtn += HbmwfUtil.dd("receiver") + ":" + HbmwfUtil.dd("") + ",";
						rtn += HbmwfUtil.dd("state") + ":" + HbmwfUtil.dd("DOING") + ",";
						rtn += HbmwfUtil.dd("top") + ":" + HbmwfUtil.dd(String.valueOf(oriTop + y1Pos * yDtHeight))
								+ ",";
						rtn += HbmwfUtil.dd("type") + ":" + HbmwfUtil.dd("task") + ",";
						rtn += HbmwfUtil.dd("width") + ":" + HbmwfUtil.dd("123") + "},";
						//

						/////////////
						////// line
						if (__tmpPos == 0) {
							lines += HbmwfUtil.dd("l" + lpTargetDetailTransmitEntity.getId()) + ": {";
							lines += HbmwfUtil.dd("dash") + ": false,";
							lines += HbmwfUtil.dd("from") + ":" +  HbmwfUtil.dd(lpTaskDetailEntity.getId()) + ",";
							lines += HbmwfUtil.dd("id") + ":"
									+ HbmwfUtil.dd("l" + lpTargetDetailTransmitEntity.getId()) + ",";
							lines += HbmwfUtil.dd("name") + ":"
									+ HbmwfUtil.dd("") + ",";
							lines += HbmwfUtil.dd("to") + ":"
									+ HbmwfUtil.dd(taskDetailTransmit.get(__tmpPos).getId()) + ",";
							lines += HbmwfUtil.dd("type") + ":" + HbmwfUtil.dd("sl") + "},";

						} else {
							if (taskDetailTransmit.size() > __tmpPos) {
								lines += HbmwfUtil.dd("l" + lpTargetDetailTransmitEntity.getId()) + ": {";
								lines += HbmwfUtil.dd("dash") + ": false,";
								lines += HbmwfUtil.dd("from") + ":" + HbmwfUtil.dd(taskDetailTransmit.get(__tmpPos-1).getId()) + ",";
								lines += HbmwfUtil.dd("id") + ":"
										+ HbmwfUtil.dd("l" + lpTargetDetailTransmitEntity.getId()) + ",";
								lines += HbmwfUtil.dd("name") + ":"
										+  HbmwfUtil.dd("") + ",";
								lines += HbmwfUtil.dd("to") + ":"
										+ HbmwfUtil.dd(taskDetailTransmit.get(__tmpPos).getId()) + ",";
								lines += HbmwfUtil.dd("type") + ":" + HbmwfUtil.dd("sl") + "},";
							}
						}
						//
						////////
						__tmpPos++;
					}
					xPos -= taskDetailTransmit.size();
				}
				//
				yPos++;
			}
		}
		//
		if (lines.endsWith(",")) {
			lines = lines.substring(0, lines.length() - 1);
		}
		lines += "}";
		//
		if (rtn.endsWith(",")) {
			rtn = rtn.substring(0, rtn.length() - 1);
		}
		rtn += "}," + lines + ",";
		rtn += HbmwfUtil.dd("areas") + ": {},";
		rtn += HbmwfUtil.dd("initNum") + ":" + HbmwfUtil.dd("16") + "}";
		//

		//
		return rtn;
	}
}
