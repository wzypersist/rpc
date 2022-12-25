package com.wzy.rpc.server.protocol;

import com.wzy.rpc.api.entity.Invocation;
import com.wzy.rpc.api.entity.URL;

public interface Protocol {
    
    Object invokeProtocol(URL url, Invocation invocation);
    
    void start(URL url);
    
}
