package com.liu.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by liuneng on 2016/12/28.
 */
@Component
public class ServiceInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = methodInvocation.proceed();
        System.out.println(methodInvocation.getMethod().getName() + " used "+String.valueOf(System.currentTimeMillis()-start));
        return result;
    }
}
