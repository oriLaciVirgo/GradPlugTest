package hu.virgo.ninjalib;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class NetworkAspect {

    private static final String TAG = NetworkAspect.class.getName();

    @Pointcut("call(void java.net.HttpURLConnection.*(..))")
    public void onClickEntryPoint() {
        Log.d(TAG, "onClickEntryPoint");
    }

    @Before("onClickEntryPoint()")
    public void onClickBefore(JoinPoint joinPoint) {
        Log.d(TAG, "Before Advice ==>  on : " + joinPoint);
    }

    @Around("onClickEntryPoint()")
    public void onClickAround(ProceedingJoinPoint joinPoint) {
        Log.d(TAG, "Around Advice ==>  on : " + joinPoint);

        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @After("onClickEntryPoint()")
    public void onClickAfter(JoinPoint joinPoint) {
        Log.d(TAG, "After Advice ==>  on : " + joinPoint);
    }

    @AfterReturning(pointcut = "onClickEntryPoint()")
    public void onClickAfterReturning() {
        Log.d(TAG, "AfterReturning Advice ==>");
    }

}
