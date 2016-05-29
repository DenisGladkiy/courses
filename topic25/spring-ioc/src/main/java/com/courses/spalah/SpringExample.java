package com.courses.spalah;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ievgen Tararaka
 */
public class SpringExample {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"application-example.xml"});

        FirstTestBean firstTestBean = context.getBean("firstTestBean", FirstTestBean.class);
        firstTestBean.foo();
    }
}
