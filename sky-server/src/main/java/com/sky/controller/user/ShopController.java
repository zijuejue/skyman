package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("userShopController")
@RequestMapping("/user/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {

    public static final String KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取店铺的营业状态
     *
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result<Integer> getStatus() {
        // 1. 从 Redis 取值
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);

        // 2. 判空处理（如果 Redis 挂了或 Key 没了，默认显示打烊）
        if (status == null) {
            status = 0;
        }

        // 3. 安全打印日志（此时 status 肯定不为 null，不会报错）
        log.info("获取到店铺的营业状态为：{}", status == 1 ? "营业中" : "打烊中");

        return Result.success(status);
    }
}
