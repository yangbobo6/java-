package proxy.sendMessage;

/**
 * @Author: yangbo
 * @Date: 2022-02-21-21:48
 * @Description:
 */
public class SmsProxy implements SmsService{

    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }


    @Override
    public String send(String message) {

        System.out.println("before ...");
        smsService.send(message);
        System.out.println("after ....");
        return null;
    }
}
