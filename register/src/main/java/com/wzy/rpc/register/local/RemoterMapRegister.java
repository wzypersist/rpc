package com.wzy.rpc.register.local;

import com.wzy.rpc.api.entity.URL;
import com.wzy.rpc.register.RemoteRegister;

import java.io.*;
import java.util.*;

public class RemoterMapRegister implements RemoteRegister {
    
    private Map<String, List<URL>> registerMap = new HashMap<>();
    private static final String path = "/data/register";
    
    @Override
    public void register(String interfaceName, URL host) {
        if(registerMap.containsKey(interfaceName)){
            List<URL> list = registerMap.get(interfaceName);
            list.add(host);
        }else{
            LinkedList<URL> list = new LinkedList<>();
            list.add(host);
            registerMap.put(interfaceName,list);
        }
        
        try {
            saveFile(path,registerMap);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void saveFile(String path, Object object) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
    }

    @Override
    public URL getRandomURL(String interfaceName) {
        try {
            registerMap = (Map<String, List<URL>>) readFile(path);
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        List<URL> list = registerMap.get(interfaceName);
        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i);
    }

    private Object readFile(String path) throws IOException,ClassNotFoundException{
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        return inputStream.readObject();
    }
}
