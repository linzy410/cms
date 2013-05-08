/**
 * @author <a href="mailto:linzheyan@viewlinecn.com">������</a> 
 * created in 2008-10-23
 */
package com.his.cms.scheduler.iterator;

import java.util.Calendar;
import java.util.Date;

import com.his.cms.scheduler.ScheduleIterator;

/**
 * ��ÿ�����������㣬Сʱ����ɷ���
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
	 * @param interval  ʱ����������
	 */
	public TimeIterator(int interval) {
    	this.interval = interval;
        calendar.setTime(new Date());
        calendar.set(Calendar.MILLISECOND, 0);
        
        Date current = new Date();
        // �����ʱʱ���һ��ʱ�������ȵ�ǰʱ���磬���ȥһ��ʱ����
        // ԭ��Ϊ��һ��ִ��ʱ��Ҫȡһ��next����
        calendar.add(Calendar.MINUTE, -interval);
        if(calendar.before(current))
        	calendar.add(Calendar.MINUTE, interval);
        	
        setCalendar(calendar, current);
    }
    
    /**
     * ����ƻ�ʱ��ȵ�ǰʱ���磬���һ��ʱ���������жϣ�
     * �����ʱ�ƻ�ʱ��ȵ�ǰʱ���磬��ȡ����һ�μӵ�ʱ������
     * ����ȵ�ǰʱ�����ݹ���һ��ʱ�����ж�
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
