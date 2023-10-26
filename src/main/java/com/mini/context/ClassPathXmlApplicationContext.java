package com.mini.context;

import com.mini.beans.*;
import com.mini.core.ClassPathXmlResource;
import com.mini.core.Resource;

public class ClassPathXmlApplicationContext implements BeanFactory{
    BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName){
        Resource res = new ClassPathXmlResource(fileName);
        BeanFactory bf = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(res);
        this.beanFactory = bf;
    }

    @Override
    public Object getBean(String beanName) throws NoSuchBeanDefinitionException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition bd) {
        this.beanFactory.registerBeanDefinition(bd);
    }
}
