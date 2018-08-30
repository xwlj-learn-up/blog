$(document).ready(function(){
    getCount();
    getSystemInfo();
    pageLoadTime();
});

function getCount() {
    $.ajax({
        url:"/manager/getCount",
        dataType:"json",
        type:"post",
        success:function (date) {
            if (date.result == "success"){
                var  mes = date.message;
                var articlCount = mes.articlCount;
                var commontCount = $(mes).attr("commontCount");
                var flinkCount = $(mes).attr("flinkCount");
                var viewCount = $(mes).attr("viewCount");
                var userName = mes.userName;
                var logined = mes.logined;
                var lastLoginTime = mes.lastLoginTime;
                var lastIp = mes.lastIp;
                $("#articleCount").text(articlCount);
                $("#commontCount").text(commontCount);
                $("#flinkCount").text(flinkCount);
                $("#viewCount").text(viewCount);
                $("#viewCount").text(viewCount);
            }
        }
    });
}

function  getSystemInfo() {
    $.ajax({
        url:"/sigar/index",
        dataType:"json",
        type:"post",
        success:function (date) {
            if ("success"==date.result){
                var mes = date.message;
                var javaVersion = mes.javaVersion;
                var loginIp= mes.loginIp;
                var useMemeory= mes.useableMemeory;
                var cpuInfo= mes.cpu;
                var servletServer= mes.servletServer;
                var runningTime= mes.runningTime;
                var encodingInfo= mes.encoding;
                var osname= mes.osname;
                var browserInfo= mes.browserInfo;
                var nowTime= mes.nowTime;
                var cpuUsed = mes.cpuUsed;
                var jvmMaxMem = mes.jvmMaxMem;
                createSystemInfo(javaVersion ,loginIp ,useMemeory ,cpuInfo ,servletServer ,runningTime ,encodingInfo ,osname ,browserInfo ,nowTime,cpuUsed,jvmMaxMem);
            }
        }
    })
}

function createSystemInfo(javaVersion ,loginIp ,useMemeory ,cpuInfo ,servletServer ,runningTime ,encodingInfo ,osname ,browserInfo ,nowTime,cpuUsed,jvmMaxMem) {
   // $("#systemInfo").clean();
    var str = "";
    str += "" +
        "            <tr>\n" +
        "              <td>jdk版本:</td>" +
        "              <td>"+javaVersion+"</td>\n" +
        "              <td>服务器软件:</td>" +
        "              <td>"+servletServer+
        "            </tr>\n" +
        "            <tr>\n" +
        "              <td>浏览器:</td>\n" +
        "              <td>"+browserInfo+"</td>\n" +
        "              <td>操作系统:</td>\n" +
        "              <td>"+osname+"</td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "              <td>CPU:</td>\n" +
        //"              <td class=\"version\">YlsatCMS 1.0 <font size=\"-6\" color=\"#BBB\">(20160108160215)</font></td>\n" +
        "                <td>"+cpuInfo+"</td>\n"+
        "              <td>cpu使用:</td>\n" +
        "              <td>"+cpuUsed+"</td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "              <td>登录者IP:</td>\n" +
        "              <td>"+loginIp+"</td>\n" +
        "              <td>项目运行时间:</td>\n" +
        "              <td>"+runningTime+"</td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "              <td>JVM内存:</td>\n" +
        //"              <td>可以 <font size=\"-6\" color=\"#BBB\">(最大文件：2M ，表单：8M )</font></td>\n" +
        "               <td>"+jvmMaxMem+"</td>"+
        "              <td>JVM内存使用:</td>\n" +
        "              <td>"+useMemeory+"</td>\n" +
        "            </tr>\n" +
        "            <tr>\n" +
        "              <td>程序编码:</td>\n" +
        "              <td>"+encodingInfo+"</td>\n" +
        "              <td>当前时间:</td>\n" +
        "              <td>"+nowTime+
        "            </tr>\n" +
        "          ";
    $("#systemInfo").append(str);
}

function pageLoadTime() {
    window.onload = function () {
        var loadTime = window.performance.timing.domContentLoadedEventEnd-window.performance.timing.navigationStart;
        console.log('Page load time is '+ loadTime/1000);
        $("#pageLoad").append("<span style=\"display:inline;width:8em\">页面加载时间  "+loadTime/1000+" s</span>  ");
    }
    
}