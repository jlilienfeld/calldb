package com.jlilienfeld.calldb.rest.repositories;

import com.jlilienfeld.calldb.rest.model.entities.CityEntity;
import com.jlilienfeld.calldb.rest.model.entities.ParticipantRoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "participantRoles", path = "participantRoles")
public interface ParticipantRoleRepository
        extends ListPagingAndSortingRepository<ParticipantRoleEntity, Integer>,
                CrudRepository<ParticipantRoleEntity, Integer> {
    List<CityEntity> findByNameContaining(@Param("name") String name);
}
