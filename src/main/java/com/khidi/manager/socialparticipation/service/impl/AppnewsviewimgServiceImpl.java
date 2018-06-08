package com.khidi.manager.socialparticipation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import com.khidi.manager.socialparticipation.dao.AppnewsviewimgDao;
import com.khidi.manager.socialparticipation.entity.AppnewsviewimgEntity;
import com.khidi.manager.socialparticipation.service.AppnewsviewimgService;

@Service("appnewsviewimgService")
public class AppnewsviewimgServiceImpl implements AppnewsviewimgService {
	@Autowired
	private AppnewsviewimgDao appnewsviewimgDao;

	@Override
	public AppnewsviewimgEntity queryObject(String id) {
		AppnewsviewimgEntity rtn = appnewsviewimgDao.queryObject(id);
		if (rtn != null) {
			String filePath = rtn.getFilePath();
			String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
			//
			rtn.setFileName(fileName);
		}
		return rtn;
	}

	@Override
	public List<AppnewsviewimgEntity> queryList(Map<String, Object> map) {
		List<AppnewsviewimgEntity> rtn = appnewsviewimgDao.queryList(map);
		if (rtn != null && rtn.size() > 0) {
			for (AppnewsviewimgEntity lpNewsViewImg : rtn) {
				String filePath = lpNewsViewImg.getFilePath();
				String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
				//
				lpNewsViewImg.setFileName(fileName);
			}
		}
		return rtn;
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return appnewsviewimgDao.queryTotal(map);
	}

	@Override
	public void save(AppnewsviewimgEntity appnewsviewimg) {
		appnewsviewimgDao.save(appnewsviewimg);
	}

	@Override
	public void update(AppnewsviewimgEntity appnewsviewimg) {
		appnewsviewimgDao.update(appnewsviewimg);
	}

	@Override
	public void delete(String id) {
		appnewsviewimgDao.delete(id);
	}

	@Override
	public List<AppnewsviewimgEntity> getAttachByNewsId(String newsId) {
		List<AppnewsviewimgEntity> rtn = appnewsviewimgDao.getAttachByNewsId(newsId);
		System.out.println("读取新闻附件的 新闻编号:" + newsId);
		if(newsId.equals("4f4e2752-ae48-4726-9ae1-15bab490100a"))
		{
			String bb = "aa";
		}
		if (rtn != null && rtn.size() > 0) {
			for (AppnewsviewimgEntity lpNewsViewImg : rtn) {
				String filePath = lpNewsViewImg.getFilePath();
				String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
				//
				lpNewsViewImg.setFileName(fileName);
			}
		}
		return rtn;
	}
}
