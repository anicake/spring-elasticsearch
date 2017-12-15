package com.wqs.root.repository;

import com.wqs.root.domian.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
public interface UserRepository extends ElasticsearchRepository<User,String> {
    Page<User> findByName(String name, Pageable pageable);
    List<User> findUsersByNameLike(String name);

}
