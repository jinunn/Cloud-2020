package com.jinunn.springcloud.lb.impl;

import com.jinunn.springcloud.lb.LoadBalanced;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jinunn.
 * @date 2020/10/10 11:39
 */
@Component
public class LoadBalancedImpl implements LoadBalanced {

    /*一个提供原子操作的Integer的类*/
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current=this.atomicInteger.get();
            System.out.println("current的值是："+current);
            next=current >=2147483647 ? 0: current+1;
            System.out.println("next的值是："+next);
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("第几次访问next:"+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
