/**   
* @Title: TestFormula.java 
* @Package com.khidi.manager.hbmwf.engine.wfutil 
* @Description: TODO(用一句话描述该文件做什么) 
* @author 王顺波
* @date 2018年1月4日 下午5:47:23 
* @version V1.0   
*/
package com.khidi.manager.hbmwf.engine.wfutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 *
 */
public class TestRegex {

	private static void ParsingFormula(String formula)
	{
		String pattern0 = "(\\(*+\\))";
		String pattern1 ="([Aa][Nn][Dd])|([Oo][Rr])";
		
	}
	public static void main(String[] args) {
		String str = "[FLD3] = 3 AND ([FLD4] > 1800 OR [FLD5] LIKE 's')";
		String pattern ="([Aa][Nn][Dd])|([Oo][Rr])";
		String pattern0 = "(?<=\\()[^\\)]+";
//		String pattern1 = "(?<=\\()[^\\)]+";
		//
//		Pattern r = Pattern.compile(pattern0);
		 
	      // 现在创建 matcher 对象
//	      Matcher m = r.matcher(str);
//	      if (m.find( )) {
//	         System.out.println("Found value: " + m.group(0) );
//	         System.out.println("Found value: " + m.group(1) );
//	         System.out.println("Found value: " + m.group(2) );
//	         System.out.println("Found value: " + m.group(3) ); 
//	      } else {
//	         System.out.println("NO MATCH");
//	      }
		String[] rtn0 = str.split(pattern0);
		for(String rtnItem : rtn0)
		{
			System.out.println(rtnItem);
		}
	}
}
