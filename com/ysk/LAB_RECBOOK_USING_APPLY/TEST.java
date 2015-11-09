package com.ysk.LAB_RECBOOK_USING_APPLY;

//import com.ysk.bean.UserInfoViewBean;
import SomeUtils._hproc;

import com.ysk.service.ServiceMethodInvoker;


public class TEST extends _hproc {
	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value

		new ServiceMethodInvoker().invokeDoQuery(this);

		
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}