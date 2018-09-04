package cn.xwlj888.blog.util;

import cn.xwlj888.blog.common.AjaxResultCodeEnum;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @create 2018-08-22 16:40
 **/

public class JsonResultUtil implements Serializable {
    private static final SerializeConfig config;

    static {
        config = new SerializeConfig();
        // 使用和json-lib兼容的日期输出格式
        config.put(java.util.Date.class, new JSONLibDataFormatSerializer());
        // 使用和json-lib兼容的日期输出格式
        config.put(java.sql.Date.class, new JSONLibDataFormatSerializer());
    }

    private static final SerializerFeature[] features = {
            // 输出空置字段
            SerializerFeature.WriteMapNullValue,
            // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullListAsEmpty,
            // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullNumberAsZero,
            // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullBooleanAsFalse,
            // 字符类型字段如果为null，输出为""，而不是null
            SerializerFeature.WriteNullStringAsEmpty
    };


    public static String toJSONString(Object object) {
        return JSON.toJSONString(object, config, features);
    }

    public static String toJSONNoFeatures(Object object) {
        return JSON.toJSONString(object, config);
    }



    public static Object toBean(String text) {
        return JSON.parse(text);
    }

    public static <T> T toBean(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    // 转换为数组
    public static <T> Object[] toArray(String text) {
        return toArray(text, null);
    }

    // 转换为数组
    public static <T> Object[] toArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz).toArray();
    }

    // 转换为List
    public static <T> List<T> toList(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    /**
     * 将javabean转化为序列化的json字符串
     * @param keyvalue
     * @return
     */
    public static Object beanToJson(KeyValue keyvalue) {
        String textJson = JSON.toJSONString(keyvalue);
        Object objectJson  = JSON.parse(textJson);
        return objectJson;
    }

    /**
     * 将string转化为序列化的json字符串
     * @return
     */
    public static Object textToJson(String text) {
        Object objectJson  = JSON.parse(text);
        return objectJson;
    }

    /**
     * json字符串转化为map
     * @param s
     * @return
     */
    public static Map stringToMap(String code,String s) {
        Map m = JSONObject.parseObject(s);
        return m;
    }

    /**
     * 将map转化为string
     * @param m
     * @return
     */
    public static String mapToString(String code,Map m) {
        String s = JSONObject.toJSONString(m);
        return StringUtils.join("{\"result\":\"",code, "\",\"message\":" + s + "}");
    }

     protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String RESPONSE_SUCCESS_CODE = "0";

    public static final String RESPONSE_FAIL_CODE = "-1";

    public static final String RESPONSE_NULL_MESSAGE = "返回数据为空";


    /**
     * 获取传输到页面的Json对象
     *
     * @param code 功能模块编号
     * @param data 消息体
     * @return Json对象
     */
    public static String getJsonResult(AjaxResultCodeEnum code, Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code.getCode());
        map.put("msg", code.getMessage());
        map.put("data", data);
        String result = JSONObject.toJSONString(map);
        return result;
    }

    public static String getJsonResult(AjaxResultCodeEnum code, Object data,Object total) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code.getCode());
        map.put("msg", code.getMessage());
        map.put("data", data);
        map.put("total",total);
        String result = JSONObject.toJSONString(map);
        return result;
    }

    public static String getJsonResult(AjaxResultCodeEnum code) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code.getCode());
        map.put("msg", code.getMessage());
        map.put("data", "");
        String result;
        try {
            result = JSONObject.toJSONString(map);
        } catch (Exception e) {
            result = "{'code':" + AjaxResultCodeEnum.ERROR.getCode() + ",'msg':" + AjaxResultCodeEnum.ERROR.getCode() + ",'data':{}}";
        }
        return result;
    }

    public static String getJsonResult(String code, String msg, Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        String result;
        try {
            result = JSONObject.toJSONString(map);
        } catch (Exception e) {
            result = "{'code':" + AjaxResultCodeEnum.ERROR.getCode() + ",'msg':" + AjaxResultCodeEnum.ERROR.getCode() + ",'data':{}}";
        }
        return result;
    }

    public static String getJsonResult(String code, String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("msg", msg);
        String result;
        try {
            result = JSONObject.toJSONString(map);
        } catch (Exception e) {
            result = "{'code':" + AjaxResultCodeEnum.ERROR.getCode() + ",'msg':" + AjaxResultCodeEnum.ERROR.getCode() + "}";
        }
        return result;
    }

}
