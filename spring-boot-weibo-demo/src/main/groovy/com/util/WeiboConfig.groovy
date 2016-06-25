package com.util

/**
 * util for loading properties for weibo open api url
 */
class WeiboConfig {
    def static props = new Properties()
    static {
        try {
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("weibo-config.properties"))
        } catch (FileNotFoundException e) {
            e.printStackTrace()
        }
    }

    public static String getValue(String key){
        return props.getProperty(key)
    }
}
