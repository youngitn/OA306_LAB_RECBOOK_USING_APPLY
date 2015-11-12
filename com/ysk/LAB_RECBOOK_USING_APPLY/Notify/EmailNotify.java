package com.ysk.LAB_RECBOOK_USING_APPLY.Notify;
//com/ysk/LAB_RECBOOK_USING_APPLY/Notify/EmailNotify
import SomeUtils._bNotify;

import com.ysk.service.BaseService;

public class EmailNotify extends _bNotify {
	BaseService service;

	@Override
	public void actionPerformed(String arg0) throws Throwable {
		// TODO Auto-generated method stub
		service = new BaseService();
		// get sign people
		
		
		String content = "收件人:";
		String title  = "45654";
		

		//String usr[] = ((String[]) V2.toArray(new String[0]));
		String usr[] ={"b0050@yungshingroup.com"};
		String sendRS = service.sendMailbccUTF8(usr, title, content, null, "",
				"text/html");
		if (sendRS.trim().equals("")) {
			message("EMAIL已寄出通知");
		} else {
			message("EMAIL寄出失敗");
		}
	}
}
