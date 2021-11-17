package com.sample.Authentication.Repository;

import com.sample.Authentication.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findAllByEmailId(String email,String password);
}
