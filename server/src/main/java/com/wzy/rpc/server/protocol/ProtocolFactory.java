package com.wzy.rpc.server.protocol;

import com.wzy.rpc.server.protocol.http.HttpProtocol;

public class ProtocolFactory {
    
    private static HttpProtocol httpProtocol = new HttpProtocol();
    
    public static Protocol getProtocol(ProtocolType protocolType){
        switch (protocolType){
            case HTTP: return httpProtocol;
            default: return null;
        }
    }
    
}
