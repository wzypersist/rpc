package com.wzy.rpc.register.factory;

import com.wzy.rpc.register.RegisterType;
import com.wzy.rpc.register.RemoteRegister;
import com.wzy.rpc.register.local.RemoterMapRegister;
import com.wzy.rpc.register.zookeeper.ZookeeperClient;
import com.wzy.rpc.register.zookeeper.ZookeeperRemoteRegister;

public class RemoteRegisterFactory {
    private static RemoterMapRegister remoterMapRegister = new RemoterMapRegister();
    private static ZookeeperRemoteRegister zookeeperRemoteRegister = new ZookeeperRemoteRegister(new ZookeeperClient());
    
    public static RemoteRegister getRemoteRegister(RegisterType registerType){
        switch (registerType){
            case LOCAL: return remoterMapRegister;
            case ZOOKEEPER: return zookeeperRemoteRegister;
            default: return null;
        }
    }
}
