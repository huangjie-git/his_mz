package com.neuedu.his.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 给病历数据生成主键
 */
public class CaseHistoryIdGenerator {

    //原子int
    private static AtomicInteger seq=new AtomicInteger(0);
    //dateFormat
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    //原子引用类型（String）
    private static AtomicReference<String> strRef=new AtomicReference<>(sdf.format(new Date()));

    /**
     * 生成id的方法
     */
    public static String genId(){
        updateTime();
        return strRef.get()+seq.getAndIncrement();
    }

    /**
     * 判断当前时间是否和datestr相等，不相等，就更新日期并且将seq设置为0
     */
    private static void updateTime(){
        String curr=sdf.format(new Date());
        if(!curr.equals(strRef.get())){
            //更新时间
            strRef.set(curr);
            //重新建seq设置为0
            seq.set(0);
        }
    }


}
