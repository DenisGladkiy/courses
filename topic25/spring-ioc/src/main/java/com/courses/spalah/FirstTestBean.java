package com.courses.spalah;

/**
 * @author Ievgen Tararaka
 */
public class FirstTestBean {
    private SecondTestBean secondTestBean;
    private ThirdTestBean thirdTestBean;

    public FirstTestBean(SecondTestBean secondTestBean) {
        this.secondTestBean = secondTestBean;
    }

    public void foo() {
        secondTestBean.sayHello();
        thirdTestBean.doStuff();
    }

    public void setThirdTestBean(ThirdTestBean thirdTestBean) {
        this.thirdTestBean = thirdTestBean;
    }
}
