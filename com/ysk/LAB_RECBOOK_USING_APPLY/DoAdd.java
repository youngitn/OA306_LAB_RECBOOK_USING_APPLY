package com.ysk.LAB_RECBOOK_USING_APPLY;

//import com.ysk.bean.UserInfoViewBean;
import SomeUtils._hproc;

import com.ysk.field.Flow;

/**
 * 新增資料在此設計
 * 
 * @author b0050
 *
 */
public class DoAdd extends _hproc {
	String nowTable = "LAB_RECBOOK_USING_APPLY";

	@Override
	public String action(String value) throws Throwable {

		String[][] field = { 
				{ "RECBOOK_NAME", "紀錄簿名稱" }, { "REC_START_DATE", "紀錄開始日期" },
				{ "REC_END_DATE", "紀錄節結束日期" } };
		String condition =" REQ_EMPID = '"+getValue("REQ_EMPID").trim()+"' and REC_START_DATE >= '" + getValue("REC_START_DATE").trim()
				+ "'";
		String[][] ret = selectFromWhere("PNO", nowTable, condition);
		if (checkEmpty(field)) {
			if (ret.length == 0) {
				DoInster(nowTable, "課主管");
				sendEmailAfterAdd(getValue("REQ_EMPID").trim(),"SUB:課主管","內容:課主管",null,"",Flow.FLOW_SING_LEVEL_11);
			} else {
				message("此申請者所輸入的\"紀錄開始日期\"在系統中有大於該日期的資料存在,請重新輸入!");
			}
		}
		return value;
	}

	

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}

}
