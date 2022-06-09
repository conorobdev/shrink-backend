package com.example.shrink.repo;

import com.example.shrink.model.ShortenedUrlModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends MongoRepository<ShortenedUrlModel, String> {

    List<ShortenedUrlModel> findAllBy_id(String id);

    @Query("{_id: {$regex: ?0}}")
    List<ShortenedUrlModel> findAllByShort_id(String id);
}
