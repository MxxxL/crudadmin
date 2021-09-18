package com.kaiyu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mxxxl
 * @date 2020/7/29
 * @description
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 后台监控 web.xml
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        // 后台需要有人登陆，账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();
        // 增加配置
        // 登陆的key是固定的  loginUsername loginPassword

        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");

        // 允许谁可以访问
        // initParameters.put("allow","localhost");

        // 禁止谁访问
        // initParameters.put("deny","");


        // 设置初始化参数
        bean.setInitParameters(initParameters);
        return bean;
    }

    /**
     * 过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String, String> initParameters = new HashMap<>();
        // 排除
        // initParameters.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);
        return bean;
    }
}
