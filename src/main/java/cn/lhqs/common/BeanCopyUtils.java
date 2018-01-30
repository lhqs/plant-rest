package cn.lhqs.common;

import net.sf.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

/**
 * author : lhqs
 * description : 拷贝bean属性的工具类
 * createTime : 2018-01-08 18:54
 * version : 1.0
 */
public class BeanCopyUtils {

    public static Map<String, BeanCopier> beanCopierMap = new HashMap<String, BeanCopier>();

    /**
     * 拷贝类型、字段名都相同的属性
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        String beanKey = generateKey(source.getClass(), target.getClass());
        BeanCopier copier = null;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
    }

    /**
     * 用两个类的全路径类名称作为BeanCopier的key
     * @param class1
     * @param class2
     * @return
     */
    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }
}
