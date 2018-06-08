package com.khidi.manager.sys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by admin on 2017/12/13.
 */
@ApiModel
public class FileUploadEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //编码
    @ApiModelProperty(value = "编码", required = false, hidden = false)
    private String Id;
    //文件名
    @ApiModelProperty(value = "文件名", required = false, hidden = false)
    private String fileName;
    //文件大小
    @ApiModelProperty(value = "文件大小", required = false, hidden = false)
    private long fileSize;
    //文件相对地址
    @ApiModelProperty(value = "文件相对地址", required = false, hidden = false)
    private String filePath;
    //文件绝对地址
    @ApiModelProperty(value = "文件绝对地址", required = false, hidden = false)
    private String fileAbsolutePath;
    //文件类型
    @ApiModelProperty(value = "文件类型", required = false, hidden = false)
    private String fileType;
    //业务类型
    @ApiModelProperty(value = "业务类型", required = false, hidden = false)
    private String opType;

    /**
     * 获取：业务类型
     */
    public String getOpType() {
        return opType;
    }


    /**
     * 设置：业务类型
     */
    public void setOpType(String opType) {
        this.opType = opType;
    }

    /**
     * 获取：编码
     */
    public String getId() {
        return Id;
    }

    /**
     * 设置：编码
     */
    public void setId(String id) {
        Id = id;
    }

    /**
     * 获取：文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置：文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取：文件大小
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * 设置：文件大小
     */
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 获取：文件相对地址
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 设置：文件相对地址
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 获取：文件绝对地址
     */
    public String getFileAbsolutePath() {
        return fileAbsolutePath;
    }

    /**
     * 设置：文件绝对地址
     */
    public void setFileAbsolutePath(String fileAbsolutePath) {
        this.fileAbsolutePath = fileAbsolutePath;
    }

    /**
     * 获取：文件类型
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 设置：文件类型
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
