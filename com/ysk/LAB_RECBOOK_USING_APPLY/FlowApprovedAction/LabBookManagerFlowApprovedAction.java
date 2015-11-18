package com.ysk.LAB_RECBOOK_USING_APPLY.FlowApprovedAction;
import SomeUtils.Bean.LabRecbookUsingApplyBean;
import SomeUtils.DAO.LabRecbookUsingApplyDAO;
//com/ysk/LAB_RECBOOK_USING_APPLY/FlowApprovedAction/LabBookManagerFlowApprovedAction;
import jcx.jform.bProcFlow;

/**
 * 在紀錄簿管理人那一關,將會讓管理人update RECBOOK_NO欄位.
 * @author YangTing
 *
 */
public class LabBookManagerFlowApprovedAction extends bProcFlow{

	@Override
	public boolean action(String arg0) throws Throwable {
		// TODO Auto-generated method stub
		
		LabRecbookUsingApplyDAO lDao = new LabRecbookUsingApplyDAO(getTalk()); 
		LabRecbookUsingApplyBean bean = lDao.getLabRecbookUsingApplyBeanByPno(getValue("PNO"));
		bean.setRECBOOK_NO(getValue("RECBOOK_NO"));
		lDao.update(bean);
		
		return true;
	}

}
