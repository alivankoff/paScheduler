package com.ivankoff.pschedule.repository;


import org.springframework.data.repository.CrudRepository;

import com.ivankoff.pschedule.entities.Post;


public interface PostRepository  extends CrudRepository<Post, Long> {
}
