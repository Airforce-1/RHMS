/**   
* @Title: HbmentNewForm.java 
* @Package com.khidi.manager.hbm.engine.domain.tst 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月22日 下午1:54:02 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.domain.tst;

/**
 * @author 王顺波
 *
 */
// 新版本测试表单
public class HbmentNewForm {
	// 编号
	private String id;
	// 名称
	private String name;
	// 内容
	private String content;
	// 流程模板编号
	private int wfTmplId;
	// 表单类型
	private String formType;
	
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getWfTmplId() {
		return wfTmplId;
	}
	public void setWfTmplId(int wfTmplId) {
		this.wfTmplId = wfTmplId;
	}
}
