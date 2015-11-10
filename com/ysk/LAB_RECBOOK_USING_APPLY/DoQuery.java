package com.ysk.LAB_RECBOOK_USING_APPLY;

import java.util.ArrayList;

import SomeUtils._hproc;
import SomeUtils.Bean.QueryItem;
import SomeUtils.Bean.UserInfoViewBean;

public class DoQuery extends _hproc {
	@Override
	public String action(String value) throws Throwable {

		ArrayList<QueryItem> list = new ArrayList<QueryItem>();
		// PNO�����Ĥ@��
		list.add(new QueryItem("PNO", "�ӽг渹", 0));
		list.add(new QueryItem("RECBOOK_NO", "����ï�s��", 1));
		list.add(new QueryItem("RECBOOK_NAME", "����ï�W��", 1));
		list.add(new QueryItem("REC_START_DATE", "�����}�l���", 2));
		list.add(new QueryItem("REC_END_DATE", "�����������", 2));
		list.add(new QueryItem("REQ_EMPID", "�ӽФH���s", 1));
		list.add(new QueryItem(
				"(select F_INP_STAT from LAB_RECBOOK_USING_APPLY_FLOWC where PNO=a.PNO)",
				"ñ�֪��A", 0));
		list.add(new QueryItem("'ñ�֬���'", "ñ�֬���", 0));
		list.add(new QueryItem("'�ԲӸ�T'", "�ԲӸ�T", 0));

		UserInfoViewBean user = getUserInfo(getUser());
		String otherConditionString = "";

		// ��o"�B" �ҥH��ParentNo
		if (user.getParentNo() == 13) {

			otherConditionString += "where RECBOOK_NO like 'YF%' OR RECBOOK_NO like 'YJ%'";

		}// �~��"��"
		else if (user.getDepNo() == 18) {

			otherConditionString += "where RECBOOK_NO like 'QC%' OR RECBOOK_NO like 'AR%'";

		}
		setQueryTable(list, "LAB_RECBOOK_USING_APPLY", "����Ǭ���ï��γ�", 5, 6,
				otherConditionString);
		list.clear();
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}