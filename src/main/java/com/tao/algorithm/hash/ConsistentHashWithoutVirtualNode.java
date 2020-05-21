package com.tao.algorithm.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 不带虚拟节点的
 */
public class ConsistentHashWithoutVirtualNode {

    /**
     * 待加入环的node节点IP
     */
    private static final String[] SERVERS = {"192.168.1.0:8080","192.168.1.1:8080","192.168.1.2:8080"};

    /**
     * 存储hash与与之对应的server地址
     */
    private static SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>();

    static {
        for (String server : SERVERS) {
            //使用系统自带的hash算法，当然也可以自己实现
            int hash = Fnv32Hash.getHash(server);
            sortedMap.put(hash, server);
        }
    }

    /**
     * 根据请求key获取对应的最近的节点ip
     * @param key
     * @return
     */
    public static String getServer(String key){

        int hash = Fnv32Hash.getHash(key);

        //得到sortedMap中的key比该hash值大的所有节点
        SortedMap<Integer, String> keyMap = sortedMap.tailMap(hash);
        if (keyMap.isEmpty()) {
            //如果没有该节点，那么就取第一个节点，形成环
            return sortedMap.get(sortedMap.firstKey());
        }
        //得到离该hash值最近的下一个节点
        return sortedMap.get(keyMap.firstKey());
    }

}
