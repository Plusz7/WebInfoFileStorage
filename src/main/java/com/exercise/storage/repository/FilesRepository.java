package com.exercise.storage.repository;

import com.exercise.storage.model.persistent.DbFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends CrudRepository<DbFile, Long> {
}
