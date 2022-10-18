package org.java.reflect.cglib;


import org.java.reflect.javaproxy.UserService;
import org.java.reflect.javaproxy.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;

public class Main2 {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(cglibProxy);

        UserService o = (UserService)enhancer.create();
        o.getName(1);
        o.getAge(1);
        o.hashCode();
    }
}