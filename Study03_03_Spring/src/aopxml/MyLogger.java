package aopxml;

import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * @Auther Ashen One
 * @Date 2020/12/17
 */
@Component
public class MyLogger {
    public void before(){
        System.out.println("前置通知");
    }
}
