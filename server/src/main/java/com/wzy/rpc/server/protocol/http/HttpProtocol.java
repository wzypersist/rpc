package com.wzy.rpc.server.protocol.http;

import com.wzy.rpc.api.entity.Invocation;
import com.wzy.rpc.api.entity.URL;
import com.wzy.rpc.server.protocol.Protocol;
import com.wzy.rpc.server.protocol.http.client.HttpClient;

public class HttpProtocol implements Protocol {
    
    @Override
    public Object invokeProtocol(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.post(url.getHost(),url.getPort(),invocation);
    }

    @Override
    public void start(URL url) {

    }
}
