package com.ysk.LAB_RECBOOK_USING_APPLY;

//import com.ysk.bean.UserInfoViewBean;
import java.util.Enumeration;

import jcx.db.talk;
import SomeUtils._hproc;


public class DoQuery extends _hproc {
	public String action(String value) throws Throwable {
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value
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