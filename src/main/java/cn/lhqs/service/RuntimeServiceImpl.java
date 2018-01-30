package cn.lhqs.service;

import cn.lhqs.common.SigarUtil;
import cn.lhqs.iservice.RuntimeService;
import org.hyperic.sigar.SigarException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * author : lhqs
 * description : 获取系统运行环境实现类
 * createTime : 2018-01-07 10:09
 * version : 1.0
 */
@Service
public class RuntimeServiceImpl implements RuntimeService{

    @Override
    public Map<String, String> getRuntimeMap() {
        Map<String, String> hardwareInfo = null;
        try {
            hardwareInfo = SigarUtil.getHardwareInfo();
        } catch (SigarException e) {
            hardwareInfo.put("系统运行警告","系统运行环境暂时无法获取");
        }
        return hardwareInfo;
    }

    @Override
    public List<String> getRuntimeList() {
        List<String> hardwareList = null;
        try {
            hardwareList = SigarUtil.getHardwareInfoList();
        } catch (SigarException e) {
            hardwareList.add("系统运行环境暂时无法获取");
        }
        return hardwareList;
    }

}
