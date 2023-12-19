package com.harvey.security.boot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Security的配置类
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2023-12-17 14:56
 */
@Configuration
public abstract class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 密码编码器, 比对密码的方法<br>
     * PasswordEncoder的各种实现类, 都是一种密码的编码方式<br>
     * NoOpPasswordEncoder就是依据字符串比较密码;
     *
     * @return 密码编码器的Bean对象
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 安全拦截机制(怎么拦截, 怎么授权)
     *
     * @param http 设置拦截机制
     * @throws Exception 请求时可能出现的异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()// 取消对CSRF的保护
                .sessionManagement().sessionCreationPolicy(
                        SessionCreationPolicy.IF_REQUIRED
                )//配置会话机制
            .and()
                .authorizeRequests()
                .antMatchers("/resource/r0").hasAnyAuthority("r0")
                .antMatchers("/resource/r1").hasAnyAuthority("r1")
                .antMatchers("/resource/**")
                .authenticated()// 这个目录下的需要验证
                .anyRequest().permitAll()// 其余的可以通过
                // 配置权限
            .and()
                // 配置资源页面和URL
                .formLogin()//允许表单登录
                .loginPage("/login-view")//自定义登录页面
                .loginProcessingUrl("/login")//指定登录处理的URL
                .successForwardUrl("/login-success")// 自定义登录成功的页面地址
            .and()
                .logout().logoutUrl("/logout")//自定义登出处理的URL, 默认使Session无效,清理上下文
                .logoutSuccessUrl("/logout-view?logout")//自定义登出成功的端点
        ;


    }

}

