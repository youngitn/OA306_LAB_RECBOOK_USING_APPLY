package com.ysk.LAB_RECBOOK_USING_APPLY;

//import com.ysk.bean.UserInfoViewBean;
import SomeUtils._hproc;

public class DoAdd extends _hproc {
	String nowTable = "LAB_RECBOOK_USING_APPLY";

	public String action(String value) throws Throwable {
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value

		// new ServiceMethodInvoker().invokeDoQuery(this);
		// message(getAllcLabels().keys().toString());
		String[][] field = { {"RECBOOK_NO","����ï�s��"}, {"RECBOOK_NAME","����ï�W��"}, {"REC_START_DATE","�����}�l���"},
				{"REC_END_DATE","�����`�������"} };
		String condition = "RECBOOK_NO = '" + getValue("RECBOOK_NO")
				+ "' and REC_START_DATE <= '" + getValue("REC_START_DATE")
				+ "'";
		String[][] ret = selectFromWhere("PNO", nowTable, condition);
		if (checkEmpty(field)) {
			if (ret.length == 0) {
				DoInster(nowTable);
			} else {
				message("������ï �s��:" + getValue("RECBOOK_NO") + " �w���H����ӽ�!");
			}
		}
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}

}