package com.ysk.LAB_RECBOOK_USING_APPLY;

import com.ysp.action.GetDepNameByEmpId;

//import com.ysk.bean.UserInfoViewBean;
import SomeUtils._hproc;



public class GoToAdd extends _hproc {
	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value

		setValue("REQ_EMPID", getUser());
		setValue("REQ_EMPID_NAME",getName(getUser()));
//		setValue("REQ_DEPT_NAME",GetDepNameByEmpId(getUser()));
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}