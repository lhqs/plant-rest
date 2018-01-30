package cn.lhqs.common;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 获取异常的堆栈信息
 */
public class ExceptionUtil {

	public static String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		try {
			t.printStackTrace(pw);
			return sw.toString();
		} finally {
			pw.close();
		}
	}
}
