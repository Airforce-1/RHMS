/**   
* @Title: HbmentDynamicForm.java 
* @Package com.khidi.manager.hbm.engine.domain 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月23日 下午1:23:36 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.enginext.domain;

import com.khidi.manager.hbmwf.enginext.cfg.form.FormCfg;

/**
 * @author Administrator
 *
 */
public class HbmentDynamicForm {
	private String formId;
	private String formType;
	private String formState;
	private FormCfg formCfg;
	
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public String getFormState() {
		return formState;
	}
	public void setFormState(String formState) {
		this.formState = formState;
	}
	public FormCfg getFormCfg() {
		return formCfg;
	}
	public void setFormCfg(FormCfg formCfg) {
		this.formCfg = formCfg;
	}
}
