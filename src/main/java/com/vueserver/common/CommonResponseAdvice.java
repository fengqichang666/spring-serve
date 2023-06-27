package com.vueserver.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

@RestControllerAdvice
public class CommonResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return filter(methodParameter);
    }

    /**
     * 根据返回类型来判断是否需要进行后续操作
     * @param methodParameter
     * @return
     */
    private boolean filter(MethodParameter methodParameter) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object returnValue, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ResultData resultData = new ResultData<>();
        //获取返回值类型
        String returnClassType = returnType.getParameterType().getSimpleName();

        //如果返回值类型为void，则默认返回成功
        if("void".equals(returnClassType)){
            resultData = resultData.success(null);
        }else if ("ResultData".equals(returnClassType)){
            resultData = (ResultData) returnValue;
        }else if ("String".equals(returnClassType)){
            ObjectMapper om = new ObjectMapper();
            //json的转换会出问题
            resultData = ResultData.success(returnValue);
            try {
                return om.writeValueAsString(resultData);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }else {
            if (Objects.isNull(returnValue)){
                resultData = ResultData.success(null);
            }else {
                resultData = ResultData.success(returnValue);
            }
        }
        //一定要转换为String，否则会报错
        return resultData;
    }

}
