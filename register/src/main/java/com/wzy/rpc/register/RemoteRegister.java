package com.wzy.rpc.register;

import com.wzy.rpc.api.entity.URL;

public interface RemoteRegister {
    
    void register(String interfaceName, URL host);
    
    URL getRandomURL(String interfaceName);
    
}
