/**   
* @Title: FormCfg.java 
* @Package com.khidi.manager.hbm.enginext.cfg 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月22日 上午8:55:59 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.enginext.cfg.form;

/**
 * @author Administrator
 *
 */
public class FormCfg {
	private String formType;
	private String formTable;
	private boolean enable;
	private FormTableCfg tableCfg;
	//
	private String stateFieldName;
	private String pkFieldName;
	public String getStateFieldName() {
		return stateFieldName;
	}

	public void setStateFieldName(String stateFieldName) {
		this.stateFieldName = stateFieldName;
	}

	public String getPkFieldName() {
		return pkFieldName;
	}

	public void setPkFieldName(String pkFieldName) {
		this.pkFieldName = pkFieldName;
	}

	//
	public FormTableCfg getTableCfg() {
		return tableCfg;
	}

	public void setTableCfg(FormTableCfg tableCfg) {
		this.tableCfg = tableCfg;
	}

	//
	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String getFormTable() {
		return formTable;
	}

	public void setFormTable(String formTable) {
		this.formTable = formTable;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
