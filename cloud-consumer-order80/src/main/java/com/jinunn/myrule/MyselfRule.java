package com.jinunn.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jinunn.
 * @date 2020/10/10 9:46
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myrule(){
        //定义为随机
        return new RandomRule();
    }
}
