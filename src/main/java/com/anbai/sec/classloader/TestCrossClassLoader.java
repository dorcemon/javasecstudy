package com.anbai.sec.classloader;

import java.lang.reflect.Method;

import static com.anbai.sec.classloader.TestClassLoader.TEST_CLASS_BYTES;
import static com.anbai.sec.classloader.TestClassLoader.TEST_CLASS_NAME;

public class TestCrossClassLoader {

    public static class ClassLoaderA extends ClassLoader {

        public ClassLoaderA(ClassLoader parent) {
            super(parent);
        }

        {
            // 加载类字节码
            //写在自定义类加载器中，先用自定义类加载器进行加载
            defineClass(TEST_CLASS_NAME, TEST_CLASS_BYTES, 0, TEST_CLASS_BYTES.length);
        }

    }

    public static class ClassLoaderB extends ClassLoader {

        public ClassLoaderB(ClassLoader parent) {
            super(parent);
        }

        {
            // 加载类字节码
            defineClass(TEST_CLASS_NAME, TEST_CLASS_BYTES, 0, TEST_CLASS_BYTES.length);
        }

    }

    public static void main(String[] args) throws Exception {
        // 父类加载器
        ClassLoader parentClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(parentClassLoader);

        // A类加载器
        //A加载器需要传入系统加载器
        ClassLoaderA aClassLoader = new ClassLoaderA(parentClassLoader);
        System.out.println(aClassLoader);

        // B类加载器
        ClassLoaderB bClassLoader = new ClassLoaderB(parentClassLoader);
        System.out.println(bClassLoader);

        // 使用A/B类加载器加载同一个类
        //使用不同类加载器加载的类加载加载同一个类对象不是同一个，但名字相同
        Class<?> aClass  = Class.forName(TEST_CLASS_NAME, true, aClassLoader);
        Class<?> aaClass = Class.forName(TEST_CLASS_NAME, true, aClassLoader);
        Class<?> bClass  = Class.forName(TEST_CLASS_NAME, true, bClassLoader);

        // 比较A类加载和B类加载器加载的类是否相等
        System.out.println(aClass);
        System.out.println(bClass);
        System.out.println("aClass == aaClass：" + (aClass == aaClass));
        System.out.println("aClass == bClass：" + (aClass == bClass));

        System.out.println("\n" + aClass.getName() + "方法清单：");

        // 获取该类所有方法
        Method[] methods = aClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method);
        }

        // 创建类实例
        Object instanceA = aClass.newInstance();

        // 获取hello方法
        Method helloMethod = aClass.getMethod("hello");

        // 调用hello方法
        String result = (String) helloMethod.invoke(instanceA);

        System.out.println("\n反射调用：" + TEST_CLASS_NAME + "类" + helloMethod.getName() + "方法，返回结果：" + result);
    }

}