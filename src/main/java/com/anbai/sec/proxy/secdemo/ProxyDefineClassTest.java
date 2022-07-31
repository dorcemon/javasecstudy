package com.anbai.sec.proxy.secdemo;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static com.anbai.sec.classloader.TestClassLoader.TEST_CLASS_BYTES;
import static com.anbai.sec.classloader.TestClassLoader.TEST_CLASS_NAME;

public class ProxyDefineClassTest {

    public static void main(String[] args) {
        // 获取系统的类加载器，可以根据具体情况换成一个存在的类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        try {
            // 反射java.lang.reflect.Proxy类获取其中的defineClass0方法
            //private static native java.lang.Class java.lang.reflect.Proxy.defineClass0(java.lang.ClassLoader,java.lang.String,byte[],int,int)
            Method method = Proxy.class.getDeclaredMethod("defineClass0", new Class[]{
                    ClassLoader.class, String.class, byte[].class, int.class, int.class
            });


            // 修改方法的访问权限
            method.setAccessible(true);

            /*1、 反射调用java.lang.reflect.Proxy.defineClass0()方法，动态向JVM注册
              2、com.anbai.sec.classloader.TestHelloWorld类对象
              3、这个invoke()需要传两个参数，第一个是对象，第二个是参数
              4、为什么要传new Object[]{...}，因为调用defineClass0()，需要几个参数，第一个参数就是
                 类加载器，第二个是加载的类名，第三个加载的字节问题件，第四个是字节长度
            */
            Class helloWorldClass = (Class) method.invoke(null, new Object[]{
                    classLoader, TEST_CLASS_NAME, TEST_CLASS_BYTES, 0, TEST_CLASS_BYTES.length
            });


/*            Class helloWorldClass2 = (Class) Proxy.class.getDeclaredMethod("defineClass0", new Class[]{
                    ClassLoader.class, String.class, byte[].class, int.class, int.class
            }).invoke(null, new Object[]{
                    classLoader, TEST_CLASS_NAME, TEST_CLASS_BYTES, 0, TEST_CLASS_BYTES.length
            });*/


/*            // 使用类创建实例
            Object helloDemo = (Object) helloWorldClass.getConstructor(
                    new Class[]{InvocationHandler.class}).newInstance(new Object[]{handler}
            );*/

            // 输出TestHelloWorld类对象
            System.out.println(helloWorldClass);
            Class aClass = helloWorldClass.getClass().getConstructor().newInstance();
            System.out.println(aClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}