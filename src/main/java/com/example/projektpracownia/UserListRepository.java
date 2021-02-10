package com.example.projektpracownia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository
public interface UserListRepository extends JpaRepository<UserModel, Long> {
    List<UserModel> findByisDeletedFalse();

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE UserModel x set x.isDeleted = true where x.id = :id")
    void delete(@Param(value = "id") long id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE UserModel x set x.isDeleted = false where x.id = :id")
    void undoDelete(@Param(value = "id") long id);
}
