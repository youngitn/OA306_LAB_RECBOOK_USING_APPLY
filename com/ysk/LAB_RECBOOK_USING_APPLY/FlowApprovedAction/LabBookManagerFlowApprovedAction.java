package com.ysk.LAB_RECBOOK_USING_APPLY.FlowApprovedAction;

import SomeUtils.Bean.LabRecbookUsingApplyBean;
import SomeUtils.DAO.LabRecbookUsingApplyDAO;
//com/ysk/LAB_RECBOOK_USING_APPLY/FlowApprovedAction/LabBookManagerFlowApprovedAction;
import jcx.jform.bProcFlow;

/**
 * �b����ï�޲z�H���@��,�N�|���޲z�Hupdate RECBOOK_NO���.
 * 
 * @author YangTing
 *
 */
public class LabBookManagerFlowApprovedAction extends bProcFlow {

	@Override
	public boolean action(String arg0) throws Throwable {
		// TODO Auto-generated method stub

		if (getValue("RECBOOK_NO").trim().length() == 0) {
			message("����ï�s����줣�i����.");
			return false;
		}
		LabRecbookUsingApplyDAO lDao = new LabRecbookUsingApplyDAO(
				getTalk());
		LabRecbookUsingApplyBean bean = lDao
				.getLabRecbookUsingApplyBeanByPno(getValue("PNO"));
		bean.setRECBOOK_NO(getValue("RECBOOK_NO"));
		lDao.update(bean);
		return true;
	}

}
