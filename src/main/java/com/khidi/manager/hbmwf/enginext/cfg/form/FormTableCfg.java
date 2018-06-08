/**   
* @Title: formTableCfg.java 
* @Package com.khidi.manager.hbm.enginext.cfg 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月22日 上午8:56:43 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.enginext.cfg.form;

/**
 * @author Administrator
 *
 */
public class FormTableCfg {
	private String fieldName;
	private EnumFormFieldType fieldType;
	private String fieldDispName;

	//
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public EnumFormFieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(EnumFormFieldType fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldDispName() {
		return fieldDispName;
	}

	public void setFieldDispName(String fieldDispName) {
		this.fieldDispName = fieldDispName;
	}
}
