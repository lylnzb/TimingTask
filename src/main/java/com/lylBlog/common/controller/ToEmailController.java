package com.lylBlog.common.controller;

import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.bean.ToEmailBean;
import com.lylBlog.common.util.CodeUtil;
import com.lylBlog.common.util.RedisUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Service
@RequestMapping("/commom")
public class ToEmailController {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/toEmail")
    @ResponseBody
    public ResultObj commonEmail(@RequestBody ToEmailBean toEmail, HttpServletRequest request) {
        String code = CodeUtil.getFour();
        //创建简单邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        //谁发的
        message.setFrom(from);
        //谁要接收
        message.setTo(toEmail.getTos());
        //邮件标题
        message.setSubject("邮件验证码");
        //邮件内容
        message.setText("您的验证码为：" + code + "。若非本人操作，请忽略此邮件。");
        try {
            mailSender.send(message);
            //判断是否缓存该账号验证码
            boolean isExist = redisUtil.hasKey(toEmail.getTos() + "_lylyzm");
            if (!isExist) {
                redisUtil.setEx(toEmail.getTos() + "_smslogin", code, 60,TimeUnit.SECONDS);   //缓存验证码并设置超时时间
            }
        } catch (MailException e) {
            e.printStackTrace();
            return ResultObj.fail();
        }
        return ResultObj.ok();
    }
}
