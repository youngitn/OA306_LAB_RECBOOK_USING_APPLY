package com.ysk.LAB_RECBOOK_USING_APPLY;

//import com.ysk.bean.UserInfoViewBean;
import SomeUtils._hproc;

import com.ysk.field.Flow;

/**
 * �s�W��Ʀb���]�p
 * 
 * @author b0050
 *
 */
public class DoAdd extends _hproc {
	String nowTable = "LAB_RECBOOK_USING_APPLY";

	@Override
	public String action(String value) throws Throwable {

		String[][] field = { 
				{ "RECBOOK_NAME", "����ï�W��" }, { "REC_START_DATE", "�����}�l���" },
				{ "REC_END_DATE", "�����`�������" } };
		String condition =" REQ_EMPID = '"+getValue("REQ_EMPID").trim()+"' and REC_START_DATE >= '" + getValue("REC_START_DATE").trim()
				+ "'";
		String[][] ret = selectFromWhere("PNO", nowTable, condition);
		if (checkEmpty(field)) {
			if (ret.length == 0) {
				DoInster(nowTable, "�ҥD��");
				sendEmailAfterAdd(getValue("REQ_EMPID").trim(),"SUB:�ҥD��","���e:�ҥD��",null,"",Flow.FLOW_SING_LEVEL_11);
			} else {
				message("���ӽЪ̩ҿ�J��\"�����}�l���\"�b�t�Τ����j��Ӥ������Ʀs�b,�Э��s��J!");
			}
		}
		return value;
	}

	

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}

}
