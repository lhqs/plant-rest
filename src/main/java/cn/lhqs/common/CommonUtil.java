package cn.lhqs.common;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.UUID;

/**
 * author : lhqs
 * description : 通用工具类
 * createTime : 2018-01-08 18:54
 * version : 1.0
 */
public class CommonUtil {

    /**
     * 返回一个不重复的字符串
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 把Map转换成指定类型
     */
    @SuppressWarnings("rawtypes")
    public static <T> T toBean(Map map, Class<T> clazz) {
        try {
            T bean = clazz.newInstance();
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}