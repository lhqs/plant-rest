package cn.lhqs.common;

import java.util.Random;
import java.util.UUID;

/**
 * author : lhqs
 * description : 各种id生成策略
 * createTime : 2017-10-24 16:09
 * version : 1.0
 */
public class IDUtils {


	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		
		return str;
	}

	public static long genItemId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}

	/**
	 * 获取指定长度的uuid
	 * @param num
	 * @return
	 */
	public static String getUuid(int num){
		return UUID.randomUUID().toString().replace("-","").substring(0,num);
	}

	public static String getSixNum(){
		Random random = new Random();
		int end2 = random.nextInt(999999);
		return String.format("%06d", end2);

	}
	

}
