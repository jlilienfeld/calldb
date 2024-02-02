package com.jlilienfeld.calldb.rest.repositories;

import com.jlilienfeld.calldb.rest.model.CallMethodEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "callMethods", path = "callMethods")
public interface CallMethodRepository
        extends ListPagingAndSortingRepository<CallMethodEntity, Integer>, CrudRepository<CallMethodEntity, Integer> {
    List<CallMethodEntity> findByNameContaining(@Param("name") String name);
}
