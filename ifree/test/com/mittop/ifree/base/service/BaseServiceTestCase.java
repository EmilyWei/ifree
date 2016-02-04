package com.mittop.ifree.base.service;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@TransactionConfiguration(defaultRollback=false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/**/applicationContext*.xml"})
/**
 * Test classes can extend this manager based on a spring context.
 * This test class can be moved to the test tree.
 *
 * @author mraible
 */
public class BaseServiceTestCase extends AbstractTransactionalJUnit4SpringContextTests {

    /**
     * A simple logger
     */
    protected final Log log = LogFactory.getLog(getClass());
    /**
     * The resourceBundle
     */
    protected ResourceBundle rb;

    /**
     * Default constructor will set the ResourceBundle if needed.
     */
    public BaseServiceTestCase() {
        // Since a ResourceBundle is not required for each class, just
        // do a simple check to see if one exists
        String className = this.getClass().getName();

        try {
            rb = ResourceBundle.getBundle(className);
        } catch (MissingResourceException mre) {
            // log.warn("No resource bundle found for: " + className);
        }
    }

    /**
     * Utility method to populate an object with values from a properties file
     *
     * @param obj the model object to populate
     * @return Object populated object
     * @throws Exception if BeanUtils fails to copy properly
     */
    protected Object populate(Object obj) throws Exception {
        // loop through all the beans methods and set its properties from
        // its .properties file
//        Map map = ConvertUtil.convertBundleToMap(rb);
//
//        BeanUtils.copyProperties(obj, map);

        return obj;
    }
    
    @Test
    public void ping(){
    	String[] beanDefinitionNames = this.applicationContext.getBeanDefinitionNames();
    	for(int i=0;i<beanDefinitionNames.length;i++){
    		System.out.println(beanDefinitionNames[i]);
    	}
    }
}
