package com.jat.demo3;

import net.sf.cglib.proxy.Enhancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LazeBeanProperties {

    private static final Logger log = LoggerFactory.getLogger(LazeBeanProperties.class);

    private String userName;
    private int userAge;



    /**
     * 只第一次懒加载
     */
    private OnlyOne onlyOne;

    /**
     * 每次都懒加载
     */
    private EveryTime everyTime;

    public LazeBeanProperties(String userName, int userAge) {
        this.userName = userName;
        this.userAge = userAge;
        this.onlyOne=createOnlyOne();
        this.everyTime=createEveryTime();
    }

    /**
     * 只第一次懒加载
     * @return
     */
    private OnlyOne createOnlyOne() {

        /**
         * 使用cglib进行懒加载 对需要延迟加载的对象添加代理，在获取该对象属性时先通过代理类回调方法进行对象初始化。
         * 在不需要加载该对象时，只要不去获取该对象内属性，该对象就不会被初始化了（在CGLib的实现中只要去访问该对象内属性的getter方法，
         * 就会自动触发代理类回调）。
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OnlyOne.class);
        OnlyOne myOnlyOne = (OnlyOne) enhancer.create(OnlyOne.class, new ConcreteClassLazyLoader());

        return myOnlyOne;
    }

    /**
     * 每次都懒加载
     * @return
     */
    private EveryTime createEveryTime() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EveryTime.class);
        EveryTime pb = (EveryTime) enhancer.create(EveryTime.class,
                new ConcreteClassDispatcher());
        return pb;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public OnlyOne getOnlyOne() {
        return onlyOne;
    }

    public void setOnlyOne(OnlyOne onlyOne) {
        this.onlyOne = onlyOne;
    }

    public EveryTime getEveryTime() {
        return everyTime;
    }

    public void setEveryTime(EveryTime everyTime) {
        this.everyTime = everyTime;
    }
}
