package com.khidi.manager.sys.redis;

import com.jacob.com.STA;
import com.khidi.common.exception.RRException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by admin on 2017/12/15.
 */

@Configuration
public class UploadCfg {
    //新闻管理文件上传
    @Value("${app.news.location}")
    private String appNewsPath;
    //新闻版本文件上传
    @Value("${app.install.location}")
    private String appInstallPath;
    //水功能区文件上传
    @Value("${file.waterability}")
    private String waterabilityPath;
    //默认
    @Value("${file.upload.location}")
    private String defPath;
    @Value("${file.intake}")
    private String intakePath;
    @Value("${fileUploaderror.code}")
    private int fileUploadErrorCode;
    @Value("${fileUploaderror.message}")
    private String fileUploadErrorMessage;
    @Value("${file.publicitycard}")
    private String publicitycardPath;
    @Value("${file.meetingm}")
    private String meetingmPath;
    @Value("${file.station}")
    private String stationPath;
    @Value("${file.maintask}")
    private String maintaskPath;
    @Value("${file.appeven}")
    private String appevenPath;

    private String[] allowWaterability = {"jpg", "jpeg", "png"};

    public boolean allowfile(EnumUploadOpType opType, String fileType) {
        String _opType = opType.toString();
        boolean allowUpload = false;
        switch (_opType) {
            case "newsapp":

                break;
            case "appver":

                break;
            case "waterability":
                for (int i = 0; i < allowWaterability.length; i++) {
                    if (allowWaterability[i].equals(fileType)) {
                        allowUpload = true;
                    }
                }
                if (!allowUpload) {
                    throw new RRException(fileUploadErrorCode, fileUploadErrorMessage);
                }
                break;
            case "intake":

                break;
            case "def":

                break;
            default:
                break;

        }
        return true;
    }


    public String GetRootPath(EnumUploadOpType opType) {
        String _opType = opType.toString();
        String _rootPath = "";
        switch (_opType) {
            case "newsapp":
                _rootPath = appNewsPath;
                break;
            case "appver":
                _rootPath = appInstallPath;
                break;
            case "waterability":
                _rootPath = waterabilityPath;
                break;
            case "intake":
                _rootPath = intakePath;
                break;
            case "publicitycard":
                _rootPath = publicitycardPath;
                break;
            case "meetingm":
                _rootPath = meetingmPath;
                break;
            case "station":
                _rootPath = stationPath;
                break;
            case "maintask":
                _rootPath = maintaskPath;
                break;
            case"appeven":
                _rootPath = appevenPath;
                break;
            case "def":
                _rootPath = defPath;
                break;
            default:
                break;
        }

        return _rootPath;
    }


}
