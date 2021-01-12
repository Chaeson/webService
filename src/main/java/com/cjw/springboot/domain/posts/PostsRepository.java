package com.cjw.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {

    @Query("SELECT P FROM Posts P ORDER BY P.id DESC")
    List<Posts> findAllDesc();

}
