package com.ysk.LAB_RECBOOK_USING_APPLY;

import java.util.ArrayList;

import SomeUtils._hproc;
import SomeUtils.Bean.QueryItem;


public class DoQuery extends _hproc {
	
	public String action(String value) throws Throwable {

		
		ArrayList<QueryItem> list = new ArrayList<QueryItem>();
		list.add(new QueryItem("PNO","�ӽг渹"));
		list.add(new QueryItem("RECBOOK_NO", "����ï�s��"));
		list.add(new QueryItem("RECBOOK_NAME", "����ï�W��"));
		list.add(new QueryItem("REC_START_DATE", "�����}�l���"));
		list.add(new QueryItem("REC_END_DATE", "�����������"));
		list.add(new QueryItem("REQ_EMPID", "�ӽФH���s"));
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