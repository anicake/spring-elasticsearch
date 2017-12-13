package com.wqs.root.service.impl;

import com.wqs.root.domian.User;
import com.wqs.root.service.OrderEsCommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.HashMap;
import java.util.Map;

public class OrderRepositoryImpl implements OrderEsCommonRepository {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    public boolean createOrderIndex() {
         return elasticsearchTemplate.createIndex(User.class);
    }
    //自定义实现可以使用ElasticsearchTemplate做复杂的查询，例如：分组、聚合等，
    //增加了spring data elasticsearch的灵活度，使用方法名定义和Query注解实现困难的查询操作，可借助ElasticsearchTemplate实现自定义的查询
    public void setElasticsearchTemplate(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

}
