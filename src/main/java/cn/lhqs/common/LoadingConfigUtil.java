package cn.lhqs.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * author : lhqs
 * description : 加载配置文件工具类
 * createTime : 2017-10-24 19:51
 * version : 1.0
 */
public class LoadingConfigUtil {
    private static final Log logger = LogFactory.getLog(LoadingConfigUtil.class);

    public static String getConfigString(String key) {
        Properties props = new Properties();
        InputStream in = null;
        try {
            in = LoadingConfigUtil.class.getResourceAsStream("/config.properties");
            if (in == null) {
                throw new RuntimeException("properties.properties is not found!");
            }
            props.load(new InputStreamReader(in ,"UTF-8"));
            String str = props.getProperty(key);
            in.close();
            return str;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "";
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                logger.error(ex.getMessage());
            }
        }
    }
}
