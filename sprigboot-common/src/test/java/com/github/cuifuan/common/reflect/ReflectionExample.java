package com.github.cuifuan.common.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) {
        useSet();
    }

    public static void useSet() {
        try {
            Class<?> personClass = Class.forName("com.github.cuifuan.common.reflect.Person");

            Constructor<?> constructor = personClass.getConstructor();
            Object person = constructor.newInstance();

            Method setNameMethod = personClass.getDeclaredMethod("setName", String.class);
            setNameMethod.invoke(person, " 张三");

            Method setAgeMethod = personClass.getDeclaredMethod("setAge", int.class);
            setAgeMethod.invoke(person, 20);

            Method sayHelloMethod = personClass.getDeclaredMethod("sayHello");
            sayHelloMethod.invoke(person);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void useGet() {
        try {
            Class<?> personClass = Class.forName("com.github.cuifuan.common.reflect.Person");
            System.out.println("输出类名: " + personClass.getName());

            Field[] fields = personClass.getDeclaredFields();
            System.out.println("字段列表:");
            for (Field field : fields) {
                System.out.println("字段名称：" + field.getName() + "，字段类型: " + field.getType().getName());
            }

            Method[] methods = personClass.getDeclaredMethods();
            System.out.println("方法:");
            for (Method method : methods) {
                System.out.println("  " + method.getName() + ": " + method.getReturnType());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
