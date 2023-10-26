package com.mini.beans;

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;

    void registerBean(String beanName, Object obj);

    boolean containsBean(String name);
}

