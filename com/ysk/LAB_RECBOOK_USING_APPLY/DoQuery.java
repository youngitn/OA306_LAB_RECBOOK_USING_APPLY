package com.ysk.LAB_RECBOOK_USING_APPLY;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import SomeUtils._hproc;
import SomeUtils.Bean.QueryItem;
import SomeUtils.Bean.UserInfoViewBean;

public class DoQuery extends _hproc {

	public String action(String value) throws Throwable {

		ArrayList<QueryItem> list = new ArrayList<QueryItem>();
		// PNO�����Ĥ@��
		list.add(new QueryItem("PNO", "�ӽг渹"));
		list.add(new QueryItem("RECBOOK_NO", "����ï�s��"));
		list.add(new QueryItem("RECBOOK_NAME", "����ï�W��"));
		list.add(new QueryItem("REC_START_DATE", "�����}�l���"));
		list.add(new QueryItem("REC_END_DATE", "�����������"));
		list.add(new QueryItem("REQ_EMPID", "�ӽФH���s"));
		list.add(new QueryItem(
				"(select F_INP_STAT from LAB_RECBOOK_USING_APPLY_FLOWC where PNO=a.PNO)",
				"ñ�֪��A"));
		list.add(new QueryItem("'ñ�֬���'", "ñ�֬���"));
		list.add(new QueryItem("'�ԲӸ�T'", "�ԲӸ�T"));
		setQueryTable(list, "LAB_RECBOOK_USING_APPLY", "����Ǭ���ï��γ�", 5, 6);
		list.clear();
		return value;
	}

	

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}