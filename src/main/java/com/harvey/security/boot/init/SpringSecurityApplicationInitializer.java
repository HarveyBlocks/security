package com.harvey.security.boot.init;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * TODO
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2023-12-17 15:49
 */
public class SpringSecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public SpringSecurityApplicationInitializer() {
        /*
            如果没有使用Spring(或SpringMVC)环境,可以用这个super(Initializer)来实现注册SecurityConfig
            super(WebSecurityConfig.class);
            如果使用了, 也可以再SpringApplicationConfig的getRootConfigClasses()里去注册SecurityConfig
        */
    }
}
