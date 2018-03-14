package com.wqs.root.repository;

import com.wqs.root.domian.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class UserRepositoryTest {
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;
    @Resource
    private UserRepository userRepository;
    @Before
    public void before(){
        elasticsearchTemplate.deleteIndex(User.class);
        elasticsearchTemplate.createIndex(User.class);
        User user1=new User();
        user1.setId("11");
        user1.setName("张三李四王五");
        user1.setSex("男");
        User user2=new User();
        user2.setId("11");
        user2.setName("李四");
        user2.setSex("男");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.findByName("张三李四王五", new PageRequest(0, 10));
    }
    @Test
    public void findOne(){
        List<User> users=userRepository.findUsersByNameLike("张四");
        System.out.println(users.size());
    }
    @Test
    public void save(){
        User user1=new User();
        user1.setId("11");
        user1.setName("张三");
        user1.setSex("男");
        User user2=new User();
        user2.setId("11");
        user2.setName("李四");
        user2.setSex("男");
        userRepository.save(user1);
        userRepository.findByName("张三", new PageRequest(0, 10));
    }
}
