package com.ysk.LAB_RECBOOK_USING_APPLY;

//import com.ysk.bean.UserInfoViewBean;
import SomeUtils._hproc;

import com.ysk.service.ServiceMethodInvoker;


public class TEST extends _hproc {
	public String action(String value) throws Throwable {
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value

		new ServiceMethodInvoker().invokeDoQuery(this);

		
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}