package com.tao.algorithm.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsistentHashTest {

    String[] keys;

    @BeforeEach
    void init(){
        keys = new String[] {"上海", "北京", "天津"};
    }

    @Test
    void testWithoutVirtualNode() {

        for (String key : keys) {
            System.out.println(ConsistentHashWithoutVirtualNode.getServer(key));
        }
    }

    @Test
    void testWithVirtualNode(){
        for (String key : keys) {
            System.out.println(ConsistentHashWithVirtualNode.getServer(key));
        }
    }
}
