/**   
* @Title: BaseParaBean.java
* @Package com.cshg.common.bean
* @Description: 
* @author yuanshuai
* @date Jan 4, 2017 10:45:43 AM
* @version V1.0
*/
package com.lylBlog.common.bean;


import com.lylBlog.common.util.FunctionUtil;

/**
 * @author YShuai
 *
 */
public class ParaBean {
	//分页选项
	protected int page=1; //页码
	protected int limit=10; //每页记录数
	//操作选项
	protected String operator; //操作人员
	protected String operaterTime; //操作时间
	protected String t1; //参数1
	protected String t2; //参数2
	protected String t3; //参数3
	protected String t4; //参数4

	protected String userId; //用户编码

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperaterTime() {
		return operaterTime;
	}
	public void setOperaterTime(String operaterTime) {
		this.operaterTime = operaterTime;
	}
	public String getT1() {
		return t1;
	}
	public void setT1(String t1) {
		this.t1 = t1;
	}
	public String getT2() {
		return t2;
	}
	public void setT2(String t2) {
		this.t2 = t2;
	}
	public String getT3() {
		return t3;
	}
	public void setT3(String t3) {
		this.t3 = t3;
	}
	public String getT4() {
		return t4;
	}
	public void setT4(String t4) {
		this.t4 = t4;
	}
	
	//分页参数
	public int getOffset() {
		return (page - 1) * limit;
	}
	public int getRows() {
		return limit;
	}
	public int getBegin() {
		return (page - 1) * limit + 1;
	}
	public int getEnd() {
		return page * limit;
	}
	
	/**
	 * 设置操作信息
	 * @param operator
	 */
	public void setOperationInfo(String operator) {
		this.operator = operator;
		this.operaterTime = FunctionUtil.getCurrentTimeStr();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
