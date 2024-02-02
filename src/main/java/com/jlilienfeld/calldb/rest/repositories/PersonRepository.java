package com.jlilienfeld.calldb.rest.repositories;

import com.jlilienfeld.calldb.rest.model.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "persons", path = "persons")
public interface PersonRepository
        extends ListPagingAndSortingRepository<PersonEntity, Long>, CrudRepository<PersonEntity, Long> {
    List<PersonEntity> findByFullNameContaining(@Param("fullName") String fullName);
}
