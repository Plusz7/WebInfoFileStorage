package com.exercise.storage.repository;

import com.exercise.storage.model.persistent.DbWebInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebInfoRepository  extends CrudRepository<DbWebInfo, Long> {
}
