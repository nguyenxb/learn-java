package com.nguyenxb.test;

import com.nguyenxb.utils.MD5Util;
import org.junit.Test;

public class MyTest {
    // md5 加密测试
    @Test
    public void testMD5(){
        String md5 = MD5Util.getMD5("123456");
        System.out.println(md5);
    }
}
