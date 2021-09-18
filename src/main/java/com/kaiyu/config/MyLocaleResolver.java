package com.kaiyu.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author mxxxl
 * @date 2020/7/20
 * @description
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        // 解析请求
        // 获取请求中的语言参数
        String language = httpServletRequest.getParameter("l");

        Locale locale = Locale.getDefault();

        // 如果请求的链接携带了国际化的参数
        if (!StringUtils.isEmpty(language)) {
            //zh_CN
            String[] split = language.split("_");
            // 国家，地区
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse, Locale locale) {

    }
}
