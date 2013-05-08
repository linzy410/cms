/**
 * @author <a href="mailto:linzheyan@viewlinecn.com">林哲炎</a> 
 * created in 2008-10-23
 */
package com.his.cms.scheduler.iterator;

import java.util.Calendar;
import java.util.Date;

import com.his.cms.scheduler.ScheduleIterator;

/**
 * 按每隔分钟数计算，小时折算成分钟
 * @author linzheyan
 *
 * 2013-5-8
 */
public class TimeIterator implements ScheduleIterator {
	
	private int interval;
    private final Calendar calendar = Calendar.getInstance();

	/* (non-Javadoc)
	 * @see com.viewlinecn.scheduletask.scheduling.ScheduleIterator#next()
	 */
	public Date next() {
		calendar.add(Calendar.MINUTE, interval);
		return calendar.getTime();
	}

	/**
	 * 
	 * @param startTime  
	 * @param interval  时间间隔分钟数
	 */
	public TimeIterator(int interval) {
    	this.interval = interval;
        calendar.setTime(new Date());
        calendar.set(Calendar.MILLISECOND, 0);
        
        Date current = new Date();
        // 如果计时时间减一个时间间隔还比当前时间早，则减去一个时间间隔
        // 原因为第一次执行时间要取一次next方法
        calendar.add(Calendar.MINUTE, -interval);
        if(calendar.before(current))
        	calendar.add(Calendar.MINUTE, interval);
        	
        setCalendar(calendar, current);
    }
    
    /**
     * 如果计划时间比当前时间早，则加一个时间间隔，再判断：
     * 如果此时计划时间比当前时间早，则取消上一次加的时间间隔，
     * 如果比当前时间晚，递归再一个时间间隔判断
     * @param calendar
     * @param date
     */
    private void setCalendar(Calendar calendar, Date date){
    	if (calendar.getTime().before(date)) {
    		calendar.add(Calendar.MINUTE, interval);
    		if(calendar.getTime().before(date))
    			setCalendar(calendar, date);
    		else
    			calendar.add(Calendar.MINUTE, -interval);
    	}
    }
}
