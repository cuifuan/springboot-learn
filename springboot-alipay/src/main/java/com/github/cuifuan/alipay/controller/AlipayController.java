package com.github.cuifuan.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.github.cuifuan.alipay.config.AlipayConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
public class AlipayController {

    @GetMapping("/order")
    public String abc(String shopName) {


        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.GATEWAY_URL,
                AlipayConfig.APP_ID,
                AlipayConfig.MERCHANT_PRIVATE_KEY,
                "json",
                AlipayConfig.CHARSET,
                AlipayConfig.ALIPAY_PUBLIC_KEY,
                AlipayConfig.SIGN_TYPE);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = "1621301678234";
        //付款金额，必填
        String total_amount = "9998";
        //商品标题/交易标题/订单标题/订单关键字等，必填
        String subject = Objects.isNull(shopName) ? "双飞" : shopName;
        //商品描述，可空
        String body = "";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = "";
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 支付完成回调验证操作
     */
    @RequestMapping("notify_url")
    public void notifyUrl(HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.println("----------------------------notify_url------------------------");
        // 商户订单号
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "GBK");
        // 付款金额
        String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "GBK");
        // 支付宝交易号
        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "GBK");
        // 交易说明
        String cus = new String(request.getParameter("body").getBytes("ISO-8859-1"), "GBK");
        // 交易状态
        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "GBK");
        if (trade_status.equals("TRADE_SUCCESS")) {//支付成功商家操作
            //下面是我写的一个简单的插入操作，根据你的操作自行编写
            /*Map<Object, Object> map = new HashMap<Object, Object>();
            map.put("cuId", Integer.valueOf(cus));
            RepaymentPlan repaymentPlan = new RepaymentPlan();
            Integer id = Integer.valueOf(out_trade_no);
            double payablesCheck = Double.valueOf(total_amount);
            RepaymentPlan repayCheck = serviceMain.selectByPrimaryKey(id);
            double total = repayCheck.getPayables();
            if (Double.valueOf(total_amount) < repayCheck.getPayables()) {
                map.put("ubalance", total - Double.valueOf(total_amount));
                serviceMain.updateCusMoney(map);
            }
            repaymentPlan.setId(id);
            repaymentPlan.setActualPayment(total);
            repaymentPlan.setRepaymentStatus(1);
            int i = serviceMain.updateByPrimaryKeySelective(repaymentPlan);
            System.out.println("---------------------还款影响行数----------------------------" + i);*/
        }
    }

    /**
     * 同步通知的页面的Controller
     */
    @RequestMapping("return_url")
    public String returnUrl() throws InterruptedException {
        System.out.println("----------------------------return_url------------------------");
        return "alipayexit";
    }
}
