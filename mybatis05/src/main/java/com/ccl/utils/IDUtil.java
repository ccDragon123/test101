package com.ccl.utils;


import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all")
public class IDUtil {
    public static String gteId(){
        return UUID.randomUUID().toString().replaceAll("-","");

    }

    @Test
    public void test(){
        System.out.println(IDUtil.gteId());
        System.out.println(IDUtil.gteId());
        System.out.println(IDUtil.gteId());
    }
}
