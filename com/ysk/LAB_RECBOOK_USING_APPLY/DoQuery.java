package com.ysk.LAB_RECBOOK_USING_APPLY;

import java.util.ArrayList;

import SomeUtils._hproc;
import SomeUtils.Bean.QueryItem;


public class DoQuery extends _hproc {
	
	public String action(String value) throws Throwable {

		
		ArrayList<QueryItem> list = new ArrayList<QueryItem>();
		list.add(new QueryItem("PNO","申請單號"));
		list.add(new QueryItem("RECBOOK_NO", "紀錄簿編號"));
		list.add(new QueryItem("RECBOOK_NAME", "紀錄簿名稱"));
		list.add(new QueryItem("REC_START_DATE", "紀錄開始日期"));
		list.add(new QueryItem("REC_END_DATE", "紀錄結束日期"));
		list.add(new QueryItem("REQ_EMPID", "申請人員編"));
		String selectField = "";
		String tableHeaders = "";
		String c = ",";
		for (QueryItem q : list) {
			if (list.indexOf(q) == list.size()-1){
				c = "";
			}
			selectField += q.getFieldName() + c;
			tableHeaders += q.getChineseName() + c;
		}
		 String[] HeaderArray = tableHeaders.split(",");
		
		

		String sqlString = "SELECT "+selectField+" FROM YSKHR.dbo.LAB_RECBOOK_USING_APPLY";
		String[][] ret = getTalk().queryFromPool(sqlString);
		getTalk().close();
		setTableData("QUERY_LIST", ret);
		setTableHeader("QUERY_LIST", HeaderArray);
		list.clear();
		return value;
	}

	
	
	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}