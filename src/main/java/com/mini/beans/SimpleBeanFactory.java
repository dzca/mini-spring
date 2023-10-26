package com.mini.beans;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@NoArgsConstructor
public class SimpleBeanFactory implements BeanFactory{
    private List<BeanDefinition> beanDefinitions=new ArrayList<>();
    private List<String> beanNames=new ArrayList<>();
    private Map<String, Object> singletons =new HashMap<>();

    @Override
    public Object getBean(String beanName) throws NoSuchBeanDefinitionException {
        Object singleton = singletons.get(beanName);
        if (singleton == null) {
            int i = beanNames.indexOf(beanName);
            if (i == -1) {
                throw new NoSuchBeanDefinitionException("Bean not defined");
            }
            else {
                BeanDefinition bd = beanDefinitions.get(i);
                try {
                    singleton=Class.forName(bd.getClassName()).getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException |
                         NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                singletons.put(bd.getId(),singleton);
            }
        }
        return singleton;
    }

    @Override
    public void registerBeanDefinition(BeanDefinition bd) {
        this.beanDefinitions.add(bd);
        this.beanNames.add(bd.getId());
    }
}
