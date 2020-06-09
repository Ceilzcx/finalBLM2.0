package com.example.api.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Md5Util {

    public static Boolean getToken(JSONObject jsonObject,String token){
        ArrayList<String> list = new ArrayList<String>();

        Set<String> keys = jsonObject.keySet();

        for (String key: keys){
            String value = jsonObject.getString(key);
//            if (isIgnoreField(key)){
//                continue;
//            }
            if (value!=null&&!"".equals(value)){
                list.add(key+"="+value+"&");
            }
        }

        Collections.sort(list,String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();

        for (int i = 0;i<list.size();i++){
            sb.append(list.get(i));
        }

        String result = sb.toString();
        System.out.println(DigestUtils.md5Hex(result).toUpperCase());
        if(DigestUtils.md5Hex(result).toUpperCase().equals(token)){
            return true;
        }else {
            return false;
        }


    }
}
