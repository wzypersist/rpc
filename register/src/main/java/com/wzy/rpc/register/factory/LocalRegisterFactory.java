package com.wzy.rpc.register.factory;

import com.wzy.rpc.register.LocalRegister;
import com.wzy.rpc.register.RegisterType;
import com.wzy.rpc.register.local.LocalMapRegister;

public class LocalRegisterFactory {
    
    private static LocalMapRegister localMapRegister = new LocalMapRegister();
    
    public static LocalRegister getLocalRegister(RegisterType registerType){
        switch (registerType){
            case LOCAL: return localMapRegister;
            default: return null;
        }
    } 
    
}
