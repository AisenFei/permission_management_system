package org.example.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.domain.SysLog;
import org.example.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private ISysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;

    private Date visitTime;  //访问时间
    private String method;   //获取访问方法名称(类名+方法名)

    @Before(value = "execution(* org.example.controller.*.*(..))")
    public void deBefore(JoinPoint jp){
        //获取访问的类
        method = "[类名]"+jp.getTarget().getClass().toString()+" [方法名]"+jp.getSignature().getName();
        //访问时间获取
        visitTime = new Date();
    }

    @After(value = "execution(* org.example.controller.*.*(..))")
    public void deAfter(JoinPoint jp) throws Exception{
        SysLog sysLog = new SysLog();
        sysLog.setExecutionTime((new Date().getTime())-visitTime.getTime());
        sysLog.setVisitTime(visitTime);

        //获取context，可以通过securityContext获取，也可以通过request.getSession获取
        SecurityContext context = SecurityContextHolder.getContext();
        String username = ((User) context.getAuthentication().getPrincipal()).getUsername();
        sysLog.setUsername(username);
        sysLog.setIp(request.getRemoteAddr());
        sysLog.setUrl(request.getRequestURL().toString());
        sysLog.setMethod(method);
        sysLogService.save(sysLog);
    }
}
