package com.wqs.root.repository;

import com.wqs.root.domian.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface CityRepository extends CrudRepository<User,String> {

}
