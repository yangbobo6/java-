package com.yangbo.netty.protocoltcp;

/**
 * @Author: yangbo
 * @Date: 2022-02-05-16:20
 * @Description:  自定义的协议包，按照此要求去传输数据，避免拆包和粘包
 */
public class MessageProtocol {
    private int len;   //长度
    private byte[] content;  //文本内容

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
