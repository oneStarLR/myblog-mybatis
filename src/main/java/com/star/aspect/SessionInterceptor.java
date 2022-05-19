package com.star.aspect;

import com.alibaba.fastjson.JSONObject;
import com.star.annotation.AccessLimit;
import com.star.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: SessionInterceptor
 * @Description: TODO
 * @Author ONESTAR
 * @Date: 2021/1/22 21:18
 * @微信：YXK-ONESTAR
 * @URL：https://onestar.newstar.net.cn/
 * @Version 1.0
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if (null == accessLimit) {
                return true;
            }
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            boolean needLogin = accessLimit.needLogin();

            if (needLogin) {
                //判断是否登录
            }
            String ip=request.getRemoteAddr();
            String key = request.getServletPath() + ":" + ip ;
            Integer count = (Integer) redisTemplate.opsForValue().get(key);

            if (null == count || -1 == count) {
                redisTemplate.opsForValue().set(key, 1,seconds, TimeUnit.SECONDS);
                return true;
            }

            if (count < maxCount) {
                count = count+1;
                redisTemplate.opsForValue().set(key, count,0);
                return true;
            }

            if (count >= maxCount) {
//                response 返回 json 请求过于频繁请稍后再试


                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                Response result = new Response<>();
                result.setCode("9999");
                result.setMsg("操作过于频繁,请稍后再提交");
                Object obj = JSONObject.toJSON(result);
                response.getWriter().write(JSONObject.toJSONString(obj));


                return false;
            }
        }

        return true;
    }
}
