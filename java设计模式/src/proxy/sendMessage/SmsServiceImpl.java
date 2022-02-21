package proxy.sendMessage;

/**
 * @Author: yangbo
 * @Date: 2022-02-21-21:47
 * @Description:
 */
public class SmsServiceImpl implements SmsService{
    public String send(String message){
        System.out.println("send message"+message);
        return message;
    }
}
