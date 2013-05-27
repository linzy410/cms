/**
 * 
 */
package com.his.cms;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.his.cms.scheduler.timer.HtmlBuilderTimer;

/**
 * @author ¡÷’‹—◊
 *
 * creat in 2013-1-30
 */
public class BootListener implements ServletContextListener {

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		new HtmlBuilderTimer().start();
	}

}
