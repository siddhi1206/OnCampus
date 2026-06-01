package com.oncampus.repository;

import com.oncampus.model.Notice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoticeRepository extends MongoRepository<Notice, String> {

    List<Notice> findByEducatorId(String educatorId);

}