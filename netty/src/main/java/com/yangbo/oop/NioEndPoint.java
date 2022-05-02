package com.yangbo.oop;

import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: yangbo
 * @Date: 2022-05-02-17:58
 * @Description:
 */
public class NioEndPoint {
    private NioPoller nioPoller;
    private ServerSocketChannel server;
    
    private AtomicInteger pollerRotater = new AtomicInteger(0);
    
}
