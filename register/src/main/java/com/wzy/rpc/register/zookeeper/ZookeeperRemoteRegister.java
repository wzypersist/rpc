package com.wzy.rpc.register.zookeeper;

import com.alibaba.fastjson.JSON;
import com.wzy.rpc.api.entity.URL;
import com.wzy.rpc.register.RemoteRegister;

import java.util.List;
import java.util.Random;

public class ZookeeperRemoteRegister implements RemoteRegister {
    
    private ZookeeperClient client;
    
    public ZookeeperRemoteRegister(ZookeeperClient client){this.client = client;}
    
    @Override
    public void register(String interfaceName, URL host) {
        try {
            StringBuilder nodePath = new StringBuilder("/");
            nodePath.append(interfaceName).append("/").append(JSON.toJSONString(host));
            if(client.started()){
                client.createNode(nodePath.toString(),"111");
            }
        }catch (Exception e){
            
        }
    }

    @Override
    public URL getRandomURL(String interfaceName) {
        try {
            StringBuilder nodePath = new StringBuilder("/");
            nodePath.append(interfaceName);
            List<URL> urls = client.getChildNodes(nodePath.toString());
            Random random = new Random();
            int i = random.nextInt(urls.size());
            return urls.get(i);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
