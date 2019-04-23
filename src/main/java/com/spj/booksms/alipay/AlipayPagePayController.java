package com.spj.booksms.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.spj.booksms.config.AlipayProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 支付宝-电脑网站支付.
 * <p>
 * 电脑网站支付 https://docs.open.alipay.com/270/105898/
 *
 * @author Mengday Zhang
 * @version 1.0
 * @since 2018/6/14
 */
@Controller
@RequestMapping("alipay")
public class AlipayPagePayController {

    @Autowired
    private AlipayProperties alipayProperties;

    @Autowired
    private AlipayClient alipayClient;

    @Autowired
    private AlipayController alipayController;


    @PostMapping("gotoPayPage")
    @ResponseBody //接口为纯数据
    public void gotoPayPage(HttpServletResponse response) throws AlipayApiException, IOException {
        // 订单模型
        String productCode = "FAST_INSTANT_TRADE_PAY";
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setOutTradeNo(UUID.randomUUID().toString());
        //商品名
        model.setSubject("支付测试");
        //金额
        model.setTotalAmount("0.01");
        //商品说明
        model.setBody("支付测试，共0.01元");
        //productCode
        model.setProductCode(productCode);

        AlipayTradePagePayRequest pagePayRequest =new AlipayTradePagePayRequest();
        pagePayRequest.setReturnUrl("http://s9v2cw.natappfree.cc/alipay/page/returnUrl");
        pagePayRequest.setNotifyUrl(alipayProperties.getNotifyUrl());
        pagePayRequest.setBizModel(model);

        // 调用SDK生成表单, 并直接将完整的表单html输出到页面
        String form = alipayClient.pageExecute(pagePayRequest).getBody();
        response.setContentType("text/html;charset=" + alipayProperties.getCharset());
        response.getWriter().write(form);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping("returnUrl")
    @ResponseBody
    public String returnUrl(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, AlipayApiException {
        response.setContentType("text/html;charset=" + alipayProperties.getCharset());

        boolean verifyResult = alipayController.rsaCheckV1(request);
        if(verifyResult){
            //验证成功
            //请在这里加上商户的业务逻辑程序代码，如保存支付宝交易号
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            return "pagePaySuccess";

        }else{
            return "pagePayFail";

        }
    }
}
