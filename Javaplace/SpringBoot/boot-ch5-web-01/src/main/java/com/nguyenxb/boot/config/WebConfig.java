package com.nguyenxb.boot.config;

import com.nguyenxb.boot.converter.NguyenMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
public class WebConfig {
    @Bean
    public HiddenHttpMethodFilter methodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        // 设置隐藏的表单访问方式 为 _m 即
        /*
        * <form action="/user" method="get">
            <input type="hidden" name="_method" value="GET">
            <input type="hidden" name="_m" value="GET"> // 下面methodFilter.setMethodParam("_m"); 这段代码修改的是这里
            <input type="submit"  value="发起get请求">
</form>
        * */
        methodFilter.setMethodParam("_m");

        return methodFilter;
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            // 自定义内容协商策略
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String, MediaType> mediaTypes = new HashMap<>();
                mediaTypes.put("json",MediaType.APPLICATION_JSON);
                mediaTypes.put("xml",MediaType.APPLICATION_XML);
                mediaTypes.put("x-nguyen",MediaType.parseMediaType("application/x-nguyen"));
                // 指定支持解析 参数对应的媒体类型.
                ParameterContentNegotiationStrategy strategy = new ParameterContentNegotiationStrategy(mediaTypes);
                HeaderContentNegotiationStrategy headerStrategy = new HeaderContentNegotiationStrategy();
                configurer.strategies(Arrays.asList(strategy,headerStrategy));
            }
            // 添加 消息转换器
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new NguyenMessageConverter());
            }
        };
    }
}
