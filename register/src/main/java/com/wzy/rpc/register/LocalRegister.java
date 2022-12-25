package com.wzy.rpc.register;

public interface LocalRegister {
    
    void register(String interfaceName,Class interfaceImplClass);
    
    Class get(String interfaceName);
    
}
