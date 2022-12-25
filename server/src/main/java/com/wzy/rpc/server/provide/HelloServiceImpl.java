package com.wzy.rpc.server.provide;


import com.wzy.rpc.api.HelloService;

public class HelloServiceImpl implements HelloService {

    public String sayHello(String name) {
        System.out.println("hello," + name);
        return "hello " + name;
    }
}
