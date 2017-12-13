package com.wqs.root.service;

import com.wqs.root.domian.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 基础的repository接口
 *
 * spring data自动生成实现类，此处集成自定义的接口是为了在自动生成的实现类中添加自定义的实现（注意：实现类是这个基础的repository接口加上Impl后缀，这样才能被spring自动扫描到）
 *
 *  ElasticsearchRepository 继承 PagingAndSortingRepository, PagingAndSortingRepository提供了分页和排序的支持
 */
public interface OrderRepository extends ElasticsearchRepository<User,Long> ,OrderEsCommonRepository {
    /**
     * spring data提供的根据方法名称的查询方式
     * @param userName
     * @param skuName
     * @return
     */
    public User findByUserNameAndSkuName(String userName, String skuName);
}
