package bai.javatest4.config;

import bai.javatest4.model.Page;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerInterceptor;

    @Component
    public class PageArguementResolver implements HandlerMethodArgumentResolver {


        public boolean supportsParameter(MethodParameter parameter) {
            return parameter.getParameterType().getName().equals("bai.javatest4.model.Page");
        }


        @Override
        public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

            Page page = new Page();
            page.setPage(Integer.parseInt(webRequest.getParameter("page")));
            page.setPageSize(Integer.parseInt(webRequest.getParameter("pageSize")));

            return  page;
        }
    }


