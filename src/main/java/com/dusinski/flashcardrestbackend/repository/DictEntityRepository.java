package com.dusinski.flashcardrestbackend.repository;

import com.dusinski.flashcardrestbackend.model.DictEntity;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface DictEntityRepository extends CrudRepository<DictEntity,Long> {
    DictEntity findById(long id);
    List<DictEntity> findAll();

}
