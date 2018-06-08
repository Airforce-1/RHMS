/**   
* @Title: HbmentForm1.java 
* @Package com.khidi.manager.hbm.engine.domain.tst 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2017年11月22日 下午2:17:56 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.domain.tst;

/**
 * @author 王顺波
 *
 */
// 测试表单实体
public class HbmentForm1 {
	// 编号
	private int id;
	// 名称
	private String name;
	// 正文内容
	private String content;
	// 表单状态
	private String state;
	// 款项
	private double kx;
	
	public double getKx() {
		return kx;
	}
	public void setKx(double kx) {
		this.kx = kx;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
}
