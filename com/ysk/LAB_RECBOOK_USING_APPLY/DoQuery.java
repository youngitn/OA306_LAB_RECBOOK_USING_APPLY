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
		// PNO必須第一個
		list.add(new QueryItem("PNO", "申請單號"));
		list.add(new QueryItem("RECBOOK_NO", "紀錄簿編號"));
		list.add(new QueryItem("RECBOOK_NAME", "紀錄簿名稱"));
		list.add(new QueryItem("REC_START_DATE", "紀錄開始日期"));
		list.add(new QueryItem("REC_END_DATE", "紀錄結束日期"));
		list.add(new QueryItem("REQ_EMPID", "申請人員編"));
		list.add(new QueryItem(
				"(select F_INP_STAT from LAB_RECBOOK_USING_APPLY_FLOWC where PNO=a.PNO)",
				"簽核狀態"));
		list.add(new QueryItem("'簽核紀錄'", "簽核紀錄"));
		list.add(new QueryItem("'詳細資訊'", "詳細資訊"));
		setQueryTable(list, "LAB_RECBOOK_USING_APPLY", "實驗室紀錄簿領用單", 5, 6);
		list.clear();
		return value;
	}

	

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}