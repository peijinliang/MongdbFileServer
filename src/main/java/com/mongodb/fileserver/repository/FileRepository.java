package com.mongodb.fileserver.repository;


import com.mongodb.fileserver.domain.File;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * File 存储库.
 *
 * @author Marlon
 * @since 1.0.0 2017年3月28日
 */

public interface FileRepository extends MongoRepository<File, String> {



}
