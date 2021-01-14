package com.codegym.aspect;

import com.codegym.entity.Books;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.beans.ExceptionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
@Aspect
@Component
public class LibraryLogger {
    @AfterThrowing(pointcut = "execution(public * com.codegym.service.BookService.*(..))", throwing = "a")
    public void checkError(JoinPoint joinPoint, Exception a) {
//check here
    }
    @AfterReturning(pointcut = "execution(public * com.codegym.service.BookService.*(..))",returning = "books")
    public void writeLog(JoinPoint joinPoint, Books books) {
//check here
        String methodName = joinPoint.getSignature().getName();
        System.err.println( methodName);
        System.err.println(books.toString());
    }
}
