package com.tao.algorithm.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 带虚拟节点的
 */
public class ConsistentHashWithVirtualNode {

    /**
     * 待加入环的node节点IP
     */
    private static final String[] SERVERS = {"192.168.1.0","192.168.1.1","192.168.1.2"};

    /**
     * 存储hash与与之对应的server地址
     */
    private static SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>();

    /**
     * 虚拟节点个数 3
     */
    private static final int VIRTUAL_NODE = 3;

    static {
        for (String server : SERVERS) {
            for (int i = 0; i < VIRTUAL_NODE; i++) {
                String vn = server + "$$VN" + i;
                int hash = Fnv32Hash.getHash(vn);
                sortedMap.put(hash, vn);
            }
        }
    }

    /**
     * 根据请求key获取对应的最近的节点ip
     * @param key
     * @return
     */
    public static String getServer(String key) {

        int hash = Fnv32Hash.getHash(key);
        //得到sortedMap中的key比该hash值大的所有节点
        SortedMap<Integer, String> keyMap = sortedMap.tailMap(hash);
        String vn;

        if (keyMap.isEmpty()){
            //如果没有该节点，那么就取第一个节点，形成环
            vn = sortedMap.get(sortedMap.firstKey());
        }else {
            //得到离该hash值最近的下一个节点
            vn = sortedMap.get(keyMap.firstKey());
        }
        //将虚拟节点转换成真实节点
        if (vn != null && !vn.equals("")) {
            vn = vn.substring(0, vn.indexOf("$$"));
        }
        return vn;
    }

}
