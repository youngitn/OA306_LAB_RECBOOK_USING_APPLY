package com.ysk.LAB_RECBOOK_USING_APPLY;

import java.util.ArrayList;

import SomeUtils._hproc;
import SomeUtils.Bean.QueryItem;
import SomeUtils.Bean.UserInfoViewBean;

public class DoQuery extends _hproc {
	@Override
	public String action(String value) throws Throwable {
		// 建立table header,與設計模式的表格欄位順序一致.
		ArrayList<QueryItem> list = new ArrayList<QueryItem>();
		
		// PNO必須第一個
		list.add(new QueryItem("PNO", "申請單號", 0));// 0 不做為查詢條件來源
		list.add(new QueryItem("RECBOOK_NO", "紀錄簿編號", 1));
		list.add(new QueryItem("RECBOOK_NAME", "紀錄簿名稱", 1));
		list.add(new QueryItem("REC_START_DATE", "紀錄開始日期", 2));// 2 日崎區間
		list.add(new QueryItem("REC_END_DATE", "紀錄結束日期", 2));// 2 日崎區間
		list.add(new QueryItem("REQ_EMPID", "申請人員編", 1));

		/**
		 * 以下開始為非主檔資料表資料. 查詢簽核狀態的SQL指令 直接用字串參數丟進去做為DB欄位名稱,"簽核狀態"為 table
		 * header,0表示在setQueryTable中不做為查詢條件.
		 */
		list.add(new QueryItem(
				"(select F_INP_STAT from LAB_RECBOOK_USING_APPLY_FLOWC where PNO=a.PNO)",
				"簽核狀態", 0));
		list.add(new QueryItem("'簽核紀錄'", "簽核紀錄", 0));
		list.add(new QueryItem("'詳細資訊'", "詳細資訊", 0));

		UserInfoViewBean user = getUserInfo(getUser());
		String otherConditionString = "";

		// 研發"處" 所以取ParentNo
		// 研發一 二課 的人 上一層是研發處 :13,此處用 getParentNo 涵蓋 一 ,二課 & 研發處的人
		if (user.getParentNo() == LAB_RECBOOK_USING_APPLY_FINAL_CONFIG.RD_DEPT_NO
				|| user.getDepNo() == LAB_RECBOOK_USING_APPLY_FINAL_CONFIG.RD_DEPT_NO) {

			otherConditionString += "where (RECBOOK_NO like 'YF%' OR RECBOOK_NO like 'YJ%')";

		}// 品管"課": 18 或品管課底下的理化組等...
		else if (user.getParentNo() == LAB_RECBOOK_USING_APPLY_FINAL_CONFIG.QC_DEPT_NO
				|| user.getDepNo() == LAB_RECBOOK_USING_APPLY_FINAL_CONFIG.QC_DEPT_NO) {

			otherConditionString += "where (RECBOOK_NO like 'QC%' OR RECBOOK_NO like 'AR%')";

		} else if (user.getEmpid().equals("admin")) {
			otherConditionString = "";
		} else {
			message("無查詢權限!");
			return value;
		}
		/**
		 * 參數 5,6 代表
		 * LIST當中的元素位置,會使用到含"員工編號"&"簽核狀態"的元素,各位於list第5和第6的位置.(ArrayList從0開始算)
		 * 
		 * 參數 otherConditionString 額外的查詢條件 .
		 */
		setQueryTable(list, "LAB_RECBOOK_USING_APPLY", "實驗室紀錄簿領用單", 5, 6,
				otherConditionString);
		list.clear();
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}