package com.wzy.rpc.server.protocol.http;

import com.wzy.rpc.api.entity.Invocation;
import com.wzy.rpc.register.RegisterType;
import com.wzy.rpc.register.factory.LocalRegisterFactory;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

public class HttpHandler {
    
    public void handler(HttpServletRequest req, HttpServletResponse resp){
        try {
            InputStream is = req.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(is);
            Invocation invocation = (Invocation) objectInputStream.readObject();
            String interfaceName = invocation.getInterfaceName();
            
            Object[] objects = invocation.getObjects();
            Class interfaceImplClass = LocalRegisterFactory.getLocalRegister(RegisterType.LOCAL).get(interfaceName);
            Method method = interfaceImplClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String) method.invoke(interfaceImplClass.newInstance(), invocation.getObjects());
            IOUtils.write(result,resp.getOutputStream(), Charset.defaultCharset());
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    
}
