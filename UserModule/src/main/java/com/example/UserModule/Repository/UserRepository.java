package com.example.UserModule.Repository;

import com.example.UserModule.Entity.UserModule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModule,String> {

    @Query(value = "SELECT user_id from USERDETAILS WHERE email_id=?1",nativeQuery = true)
    String getUserId(String emailId);
}
