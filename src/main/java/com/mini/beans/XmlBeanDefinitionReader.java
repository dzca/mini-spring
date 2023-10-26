package com.mini.beans;

import com.mini.core.Resource;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.dom4j.Element;

@Log
@AllArgsConstructor
public class XmlBeanDefinitionReader {
    SimpleBeanFactory beanFactory;

    public void loadBeanDefinitions(Resource res) {
        while (res.hasNext()) {
            Element element = (Element) res.next();
            String beanID = element.attributeValue("id");
            log.info("loading bean definition id=" + beanID);
            String beanClassName = element.attributeValue("class");
            log.info("loading bean class name=" + beanClassName);
            BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
            beanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}
