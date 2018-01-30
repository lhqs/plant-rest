package cn.lhqs.iservice;

import java.util.List;
import java.util.Map;

/**
 * author : lhqs
 * description : 获取系统运行环境接口
 * createTime : 2018-01-07 10:09
 * version : 1.0
 */
public interface RuntimeService {

    Map<String, String> getRuntimeMap();

    List<String> getRuntimeList();
}
