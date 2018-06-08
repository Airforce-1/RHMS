package com.khidi.manager.sys.redis;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by admin on 2017/12/15.
 */
public class PathUtil {
    // 读取附件保存路径
    public static String getPath(String dataId, String pRootpath, boolean createPath) {
        String path0 = pRootpath;
        String path1 = pRootpath + "\\" + GetYearString(new Date()) ;
        String path2 = path1 + "\\" + GetMouthString(new Date());
        String path3 = path2 + "\\" + GetDayString(new Date());
        String path4 = path3 + "\\" + dataId + "\\";

        if (createPath) {
            File file = new File(path4);
            if(!file.exists()){
                file.mkdirs();
            }
        }
        //
        return path4 ;
    }

    private static String GetYearString(Date date) {
        SimpleDateFormat sdfDt = new SimpleDateFormat("yyyy");
        return sdfDt.format(date);
    }

    private static String GetMouthString(Date date) {
        SimpleDateFormat sdfDt = new SimpleDateFormat("MM");
        return sdfDt.format(date);
    }

    public static String GetDayString(Date date) {
        SimpleDateFormat sdfDt1 = new SimpleDateFormat("dd");
        return sdfDt1.format(date);
    }

//
//    // 创建路径
//    private static void CreatePath(String pPath) {
//        try {
//            if (!(new File(pPath).isDirectory())) {
//                new File(pPath).mkdir();
//            }
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        }
//    }

}
