package com.shashi.microservices.limitsservice.aop;

import com.shashi.microservices.limitsservice.controller.FileController;
import com.shashi.microservices.limitsservice.service.FileService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ConnectJ {
 private Logger log= LoggerFactory.getLogger(ConnectJ.class);
    @Pointcut("execution(* com.shashi.microservices.limitsservice.controller.*.*(..))")
    public void connection(){}

//    @After("connecting()")
//    public void after(JoinPoint joinPoint){
//    log.info("Connect SuccessFully::"+joinPoint.getSignature());
//    }
//   @AfterReturning(value = "execution(* com.shashi.microservices.limitsservice.controller.*.*(..))",returning = "controller")
//    public void after(JoinPoint joinPoint, FileController controller){
//        log.info("Connecting After::"+controller);
//   }
//   @AfterThrowing(value = "execution(* com.shashi.microservices.limitsservice.controller.*.*(..))",throwing = "e")
//    public void after(JoinPoint joinPoint,Exception e){
//        log.info("Through Exception::"+e.getMessage());
//   }

    @Around("connection()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("After Connection::"+joinPoint.getSignature());
        Object object=joinPoint.proceed();
        if (object instanceof FileController){
            log.info("Successfully Connection::"+joinPoint.getSignature());
        } else if (object instanceof FileService) {
            log.info("Not Connection::"+joinPoint.getSignature());
        }
        return object;
    }
}
