package com.crio.starter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.crio.starter.entity.MemeEntity;

public interface MemeRepository extends MongoRepository<MemeEntity, String> {

    Optional<MemeEntity> findByNameAndCaptionAndUrl(
        String name,
        String caption,
        String url
    );

    List<MemeEntity> findAllByOrderByIdDesc();
}