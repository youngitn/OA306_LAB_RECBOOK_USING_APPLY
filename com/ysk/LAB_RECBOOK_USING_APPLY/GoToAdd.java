package com.ysk.LAB_RECBOOK_USING_APPLY;

import com.ysp.action.GetDepNameByEmpId;


//import com.ysk.bean.UserInfoViewBean;
import SomeUtils._hproc;
import SomeUtils.Bean.UserInfoViewBean;



public class GoToAdd extends _hproc {
	public String action(String value) throws Throwable {
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value
		UserInfoViewBean nowUser = getUserInfo(getUser());
		setValue("REQ_EMPID", getUser());
		setValue("REQ_EMPID_NAME",nowUser.getHecname());
		setValue("REQ_DEPT_NAME",nowUser.getDepName());
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}