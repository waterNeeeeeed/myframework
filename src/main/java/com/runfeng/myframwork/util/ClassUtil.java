package com.runfeng.myframwork.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 帝 on 2017/2/8.
 */
public class ClassUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String className, boolean isInitialized){
        Class<?> clz;
        try {
            clz = Class.forName(className, isInitialized, getClassLoader());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return clz;
    }

    public static Set<Class<?>> getClassSet(String packageName){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        try {
            Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".", "/"));
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                System.out.println(url.toString());
                if (null != url){

                }
            }
            return classSet;
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
