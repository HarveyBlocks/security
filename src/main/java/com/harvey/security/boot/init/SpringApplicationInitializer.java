package com.harvey.security.boot.init;


import com.harvey.security.boot.config.ApplicationConfig;
import com.harvey.security.boot.config.WebConfig;
import com.harvey.security.boot.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * WebApplicationInitializer的所有实现类全部加载
 *
 * @author Harvey Blocks
 * @version 1.0
 * @className SpringApplicationInitializer
 * @date 2023-12-15 15:52
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Spring容器和Security认证的配置类
     * 加载Spring的Configuration和Security认证的配置类,都将被启动时初始化
     * @return Spring和Security配置类的类对象数组
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class, WebSecurityConfig.class};
    }

    /**
     * servletContext
     * 加载SpringMVC的Configuration
     * @return SpringMVC的Configuration的类对象
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     *
     *
     * @return 根路径
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
