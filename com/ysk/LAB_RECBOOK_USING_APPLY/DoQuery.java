package com.ysk.LAB_RECBOOK_USING_APPLY;

//import com.ysk.bean.UserInfoViewBean;
import java.util.Enumeration;

import jcx.db.talk;
import SomeUtils._hproc;


public class DoQuery extends _hproc {
	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value
		String aString = "";
		//get all UI obj
		Enumeration<String> iterator = getAllcLabels().keys();
		while (iterator.hasMoreElements()) {
			aString  += iterator.nextElement()+"-";
			
		}
//		talk t = getTalk();
		message(aString);

		
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}