package com.mini.context;

import com.mini.beans.*;
import com.mini.core.ClassPathXmlResource;
import com.mini.core.Resource;

public class ClassPathXmlApplicationContext implements BeanFactory{
    BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName){
        Resource res = new ClassPathXmlResource(fileName);
        SimpleBeanFactory bf = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(res);
        this.beanFactory = bf;
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBean(String beanName, Object obj) {
        beanFactory.registerBean(beanName, obj);
    }

    @Override
    public boolean containsBean(String name) {
        return beanFactory.containsBean(name);
    }
}
