package com.ysk.LAB_RECBOOK_USING_APPLY;

//com/ysk/LAB_RECBOOK_USING_APPLY/QueryTableButton_SignHis;
import SomeUtils._bproc;

import com.ysk.service.SignFlowHistoryService;

public class QueryTableButton_SignHis extends _bproc {

	@Override
	public String getDefaultValue(String arg0) throws Throwable {

		String functionName = this.getFunctionName();
		SignFlowHistoryService service = new SignFlowHistoryService(this);
		String key = "a.PNO='" + getValue("QUERY_LIST.PNO") + "'";
		service.doDisplaySignFlowHistory(functionName, key);
		return null;

	}
}
