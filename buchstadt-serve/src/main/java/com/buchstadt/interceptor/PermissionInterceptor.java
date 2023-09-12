package com.buchstadt.interceptor;

import com.alibaba.fastjson2.JSON;
import com.buchstadt.constant.KeyVals;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.JwtUtil;
import com.buchstadt.utils.R;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @description:
 * @package: com.buchstadt.interceptor
 * @author: zheng
 * @date: 2023/9/3
 */
@Component
public class PermissionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        String token = request.getHeader(KeyVals.TOKEN_HEADER);
        Claims claims = JwtUtil.parseJwt(token);

        if (claims == null) {
            String json = JSON.toJSONString(R.build(Http.NO, "您没有登录！"));
            response.getWriter().write(json);
            return false;
        }

        return true;
    }

}
