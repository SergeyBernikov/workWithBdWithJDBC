package ru.bsa.configClass;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ClassWebXML extends AbstractAnnotationConfigDispatcherServletInitializer {     // web.xml
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ClassConfig.class};                                             // class with configuration
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
