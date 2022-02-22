package proxy.sendMessage;

/**
 * @Author: yangbo
 * @Date: 2022-02-22-10:16
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsService smsProxy = new SmsProxy(smsService);

        smsProxy.send("java");
    }



}
