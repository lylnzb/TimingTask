package com.lylBlog.common.controller;

import com.lylBlog.admin.bean.BlogSetBean;
import com.lylBlog.common.bean.ResultObj;
import com.lylBlog.common.bean.ToEmailBean;
import com.lylBlog.common.server.CommonServer;
import com.lylBlog.common.util.CodeUtil;
import com.lylBlog.common.util.EmailSenderUtil;
import com.lylBlog.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/")
public class ToEmailController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private EmailSenderUtil mailSender;

    @Autowired
    private CommonServer commonServer;

    @RequestMapping("/toEmail")
    @ResponseBody
    public ResultObj commonEmail(@RequestBody ToEmailBean toEmail, HttpServletRequest request) {
        BlogSetBean blogSet = commonServer.getBlogConfiguration();

        String code = CodeUtil.getFour();
        //创建简单邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        //谁发的
        message.setFrom(blogSet.getEamilsetUsername());
        //谁要接收
        message.setTo(toEmail.getTos());
        //邮件标题
        message.setSubject("邮件验证码");
        //邮件内容
        message.setText(blogSet.getEamilsetVerificationCode().replace("${code}",code));
        try {
            //邮件发送
            mailSender.getJavaMailSenderImpl(blogSet).send(message);
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
