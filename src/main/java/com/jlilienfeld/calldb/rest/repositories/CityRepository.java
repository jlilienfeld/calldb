package com.jlilienfeld.calldb.rest.repositories;

import com.jlilienfeld.calldb.rest.model.entities.CityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cities", path = "cities")
public interface CityRepository
        extends ListPagingAndSortingRepository<CityEntity, Integer>, CrudRepository<CityEntity, Integer> {
    List<CityEntity> findByNameContaining(@Param("name") String name);
}
