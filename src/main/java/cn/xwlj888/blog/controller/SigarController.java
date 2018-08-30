package cn.xwlj888.blog.controller;

import cn.xwlj888.blog.common.UserEnum;
import cn.xwlj888.blog.util.DateUtil;
import cn.xwlj888.blog.util.IpAdrressUtil;
import cn.xwlj888.blog.util.JsonResultUtil;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import lombok.extern.slf4j.Slf4j;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @create 2018-08-29 13:52
 **/
@Slf4j
@Controller
@RequestMapping("sigar")
public class SigarController {
    /**
     * 管理台首页
     */
    @RequestMapping("/index")
    @ResponseBody
    public String index(HttpServletRequest request) throws IOException {
        Sigar sigar;
        Runtime runtime;
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            sigar = new Sigar();
           // runtime = Runtime.getRuntime();
            //管理员个数
            //应用服务器
            ServletContext servletContext = request.getSession().getServletContext();
            map.put("servletServer", servletContext.getServerInfo());
            //JDK版本
            map.put("javaVersion", System.getProperty("java.version"));
            //操作系统
            map.put("osname", System.getProperty("os.name"));
            //当前时间
            map.put("nowTime", DateUtil.getZH_Date());
            //系统编码格式
            map.put("encoding", System.getProperty("file.encoding"));
            long pid = sigar.getPid();
            long startTime = sigar.getProcTime(pid).getStartTime();
            //系统运行时长
            map.put("runningTime", DateUtil.friendDuration(System.currentTimeMillis() - startTime));
            //获取浏览器信息
            String ua = request.getHeader("User-Agent");
            UserAgent userAgent = UserAgent.parseUserAgentString(ua);
            Browser browser = userAgent.getBrowser();
            //获取浏览器版本号
            Version version = browser.getVersion(request.getHeader("User-Agent"));
            map.put("browserInfo", browser.getName() + " " + version.getVersion());

            map.put("loginIp", IpAdrressUtil.getIpAdrress(request));
            org.hyperic.sigar.CpuInfo[] cpuInfoList = sigar.getCpuInfoList();
            //CPU信息
            map.put("cpu", cpuInfoList[0].getVendor() + "(" + cpuInfoList[0].getModel() + ") " + cpuInfoList[0].getMhz() + "MHz x " + cpuInfoList.length + "核");

            //服务器内存
            //Mem freeMemory = sigar.getMem();
            // map.put("mem", String.format("%.2fG", new Object[]{Double.valueOf((double) freeMemory.getTotal() / 1.073741824E9D)}));
            //JVM内存
            map.put("jvmMaxMem", String.format("%.2fM", new Object[]{Float.valueOf((float) Runtime.getRuntime().maxMemory() / 1048576.0F)}));
            //
            //map.put("memUsedPercent", String.format("%.2f", new Object[]{Double.valueOf(freeMemory.getUsedPercent())}));
            //CPU使用
            map.put("cpuUsed", String.format("%.2f", new Object[]{Double.valueOf(CpuPerc.format(sigar.getCpuPerc().getCombined()).replace("%", ""))})+"%");

            //系统内存使用
            //JVM可以使用的总内存
            long maxMemory2 = Runtime.getRuntime().totalMemory();
            //JVM可以使用的剩余内存
            long freeMemory1 = Runtime.getRuntime().freeMemory();
            //JVM内存使用
            map.put("useableMemeory", String.format("%.2f", new Object[]{Double.valueOf((double) (maxMemory2 - freeMemory1) / ((double) maxMemory2 * 1.0D) * 100.0D)})+"%");
        } catch (SigarException e) {
            log.error("使用sigar获取服务器信息错误：", e.getMessage());
        }
        return JsonResultUtil.mapToString("success", map);
    }
}
