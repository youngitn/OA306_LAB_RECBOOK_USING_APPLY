package com.ysk.LAB_RECBOOK_USING_APPLY;

import java.util.ArrayList;

import SomeUtils._hproc;
import SomeUtils.Bean.QueryItem;
import SomeUtils.Bean.UserInfoViewBean;

public class DoQuery extends _hproc {
	@Override
	public String action(String value) throws Throwable {

		ArrayList<QueryItem> list = new ArrayList<QueryItem>();
		// PNO必須第一個
		list.add(new QueryItem("PNO", "申請單號", 0));
		list.add(new QueryItem("RECBOOK_NO", "紀錄簿編號", 1));
		list.add(new QueryItem("RECBOOK_NAME", "紀錄簿名稱", 1));
		list.add(new QueryItem("REC_START_DATE", "紀錄開始日期", 2));
		list.add(new QueryItem("REC_END_DATE", "紀錄結束日期", 2));
		list.add(new QueryItem("REQ_EMPID", "申請人員編", 1));
		list.add(new QueryItem(
				"(select F_INP_STAT from LAB_RECBOOK_USING_APPLY_FLOWC where PNO=a.PNO)",
				"簽核狀態", 0));
		list.add(new QueryItem("'簽核紀錄'", "簽核紀錄", 0));
		list.add(new QueryItem("'詳細資訊'", "詳細資訊", 0));

		UserInfoViewBean user = getUserInfo(getUser());
		String otherConditionString = "";

		// 研發"處" 所以取ParentNo
		if (user.getParentNo() == 13) {

			otherConditionString += "where RECBOOK_NO like 'YF%' OR RECBOOK_NO like 'YJ%'";

		}// 品管"課"
		else if (user.getDepNo() == 18) {

			otherConditionString += "where RECBOOK_NO like 'QC%' OR RECBOOK_NO like 'AR%'";

		}
		setQueryTable(list, "LAB_RECBOOK_USING_APPLY", "實驗室紀錄簿領用單", 5, 6,
				otherConditionString);
		list.clear();
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}