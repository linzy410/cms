/* 
 * Created by linzheyan at 2013-5-27 
 * Copyright HiSupplier.com 
 */

package com.his.cms.scheduler.timer;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.his.cms.scheduler.Scheduler;
import com.his.cms.scheduler.SchedulerTask;
import com.his.cms.scheduler.iterator.TimeIterator;
import com.his.cms.velocity.AllBuilder;

/**
 * @author linzheyan
 *
 * 2013-5-27
 */
public class HtmlBuilderTimer {
	
	private Log log = LogFactory.getLog(HtmlBuilderTimer.class);
	private Scheduler scheduler = new Scheduler();

	/* (non-Javadoc)
	 * @see java.util.TimerTask#run()
	 */
	public void start() {
		scheduler.schedule(new SchedulerTask() {
			@Override
			public void run() {
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				System.out.println(dateformat.format(new Date()));
				try {
					new AllBuilder().builder();
				} catch (Exception e) {
					log.error("页面生成定时器出错", e);
				}
			}
			
		}, new TimeIterator(10));
	}

	public static void main(String[] args) {
		new HtmlBuilderTimer().start();
	}
}
