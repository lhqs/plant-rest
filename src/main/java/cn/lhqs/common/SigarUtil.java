package cn.lhqs.common;


import java.util.*;

import java.util.Map;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;


/**
 * author : lhqs
 * description : 获取硬件工具类
 * createTime : 2018-01-06 14:49
 * version : 1.0
 */
public class SigarUtil {

    public static List<String> getHardwareInfoList() throws SigarException {
            List<String> info = new ArrayList<String>();
            Sigar sigar = new Sigar();
            Mem mem = sigar.getMem();
            Swap swap = sigar.getSwap();
            // 内存信息
            info.add(mem.getTotal() / 1024L + "K av");
            info.add(mem.getUsed() / 1024L + "K used");
            info.add( mem.getFree() / 1024L + "K free");
            info.add( swap.getTotal() / 1024L + "K av");
            info.add( swap.getUsed() / 1024L + "K used");
            info.add(swap.getFree() / 1024L + "K free");

            // CPU信息
            CpuInfo infos[] = sigar.getCpuInfoList();
            CpuPerc cpuList[] = sigar.getCpuPercList();
            CpuInfo cpuInfo = infos[0];  // 这里仅考虑到购买的服务器为一核
            info.add(sigar.getCpu() + "");
            info.add( sigar.getCpuPerc() + "");
            info.add(cpuInfo.getMhz() + "");
            info.add(cpuInfo.getVendor() + "");
            info.add(cpuInfo.getModel() + "");
            info.add(cpuInfo.getCacheSize() + "");
            info.add(CpuPerc.format(cpuList[0].getUser()));
            info.add(CpuPerc.format(cpuList[0].getSys()));
            info.add(CpuPerc.format(cpuList[0].getWait()));
            info.add(CpuPerc.format(cpuList[0].getNice()));
            info.add(CpuPerc.format(cpuList[0].getIdle()));
            info.add(CpuPerc.format(cpuList[0].getCombined()));

            // OS信息
            OperatingSystem OS = OperatingSystem.getInstance();
            info.add(OS.getDescription());
            info.add(OS.getVendorName());
            info.add(OS.getVersion());

            // 网络信息
            String ifNames[] = sigar.getNetInterfaceList();
            String name = ifNames[0];  // 这里只考虑本地网络lo
            NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
            info.add(name);
            info.add(ifconfig.getAddress());
            info.add(ifconfig.getNetmask());
            NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
            info.add(ifstat.getRxPackets()+"");
            info.add(ifstat.getTxPackets()+"");
            info.add(ifstat.getRxBytes()+"");
            info.add(ifstat.getTxBytes()+"");
            info.add(ifstat.getRxErrors()+"");
            info.add(ifstat.getTxErrors()+"");
            info.add(ifstat.getRxDropped()+"");
            info.add(ifstat.getTxDropped()+"");

            // ethernet 以太网信息
            String[] ifaces = sigar.getNetInterfaceList();
            NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[0]); // 这里只考虑一块
            info.add(cfg.getAddress());
            info.add(cfg.getBroadcast());
            info.add(cfg.getHwaddr());
            info.add(cfg.getNetmask());
            info.add(cfg.getDescription());
            info.add(cfg.getType());
            return info;
    }

    public static Map<String, String> getHardwareInfo() throws SigarException {
        Map<String, String> info = new HashMap<String, String>();
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        Swap swap = sigar.getSwap();
        // 内存信息
        info.put("内存总量", mem.getTotal() / 1024L + "K av");
        info.put("当前内存使用量", mem.getUsed() / 1024L + "K used");
        info.put("当前内存剩余量", mem.getFree() / 1024L + "K free");
        info.put("交换区总量", swap.getTotal() / 1024L + "K av");
        info.put("当前交换区使用量", swap.getUsed() / 1024L + "K used");
        info.put("当前交换区剩余量", swap.getFree() / 1024L + "K free");

        // CPU信息
        CpuInfo infos[] = sigar.getCpuInfoList();
        CpuPerc cpuList[] = sigar.getCpuPercList();
        CpuInfo cpuInfo = infos[0];  // 这里仅考虑到购买的服务器为一核
        info.put("cpu 总量参数情况", sigar.getCpu() + "");
        info.put("cpu 总百分比情况", sigar.getCpuPerc() + "");
        info.put("CPU的总量MHz", cpuInfo.getMhz() + "");
        info.put("CPU生产商", cpuInfo.getVendor() + "");
        info.put("CPU类别", cpuInfo.getModel() + "");
        info.put("CPU缓存数量", cpuInfo.getCacheSize() + "");
        info.put("CPU用户使用率", CpuPerc.format(cpuList[0].getUser()));
        info.put("CPU系统使用率", CpuPerc.format(cpuList[0].getSys()));
        info.put("CPU当前等待率", CpuPerc.format(cpuList[0].getWait()));
        info.put("CPU当前错误率", CpuPerc.format(cpuList[0].getNice()));
        info.put("CPU当前空闲率", CpuPerc.format(cpuList[0].getIdle()));
        info.put("CPU总的使用率", CpuPerc.format(cpuList[0].getCombined()));

        // OS信息
        OperatingSystem OS = OperatingSystem.getInstance();
        info.put("操作系统的描述", OS.getDescription());
        info.put("操作系统名称", OS.getVendorName());
        info.put("操作系统的版本号", OS.getVersion());

        // 网络信息
        String ifNames[] = sigar.getNetInterfaceList();
        String name = ifNames[0];  // 这里只考虑本地网络lo
        NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
        info.put("网络设备名", name);
        info.put("IP地址", ifconfig.getAddress());
        info.put("子网掩码", ifconfig.getNetmask());
        NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
        info.put("接收的总包裹数", ifstat.getRxPackets()+"");
        info.put("发送的总包裹数", ifstat.getTxPackets()+"");
        info.put("接收到的总字节数", ifstat.getRxBytes()+"");
        info.put("发送的总字节数", ifstat.getTxBytes()+"");
        info.put("接收到的错误包数", ifstat.getRxErrors()+"");
        info.put("发送数据包时的错误数", ifstat.getTxErrors()+"");
        info.put("接收时丢弃的包数", ifstat.getRxDropped()+"");
        info.put("发送时丢弃的包数", ifstat.getTxDropped()+"");

        // ethernet 以太网信息
        String[] ifaces = sigar.getNetInterfaceList();
        NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[0]); // 这里只考虑一块
        info.put("IP地址", cfg.getAddress());
        info.put("网关广播地址", cfg.getBroadcast());
        info.put("网卡MAC地址", cfg.getHwaddr());
        info.put("子网掩码", cfg.getNetmask());
        info.put("网卡描述信息", cfg.getDescription());
        info.put("网卡类型", cfg.getType());
        return info;
    }

}
