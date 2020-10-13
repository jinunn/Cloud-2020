package com.jinunn.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 *LoadBalanced 负载均衡算法
 *
 * @author jinunn.
 * @date 2020/10/10 11:34
 */
public interface LoadBalanced {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
