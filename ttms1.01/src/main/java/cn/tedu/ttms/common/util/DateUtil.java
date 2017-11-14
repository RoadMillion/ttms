package cn.tedu.ttms.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @author yulc E-mail:yl1451871636@163.com
* @version create time : 2017年11月14日 上午10:16:55
* @desciption 
* ThreadLocal是java中的一个API，此对象提供了这样的一种机制，能够将对象绑定到当前线程也可以从当前线程获取某个对象，目的是保证线程内部单例（某个类的实例在当前
* 线程中只有一份）
* 静态同步方法默认使用对象名为this.class
* 
*/
public class DateUtil {
	private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat();
		}
	};
	public static String format(Date date) {
		return threadLocal.get().format(date);
	}
	public static Date parse(String dateStr) throws ParseException {
		return threadLocal.get().parse(dateStr);
	}
}
