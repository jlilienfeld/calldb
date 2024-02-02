package com.jlilienfeld.calldb.rest.repositories;

import com.jlilienfeld.calldb.rest.model.CallEntity;
import com.jlilienfeld.calldb.rest.projections.FullCallView;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = FullCallView.class,
        collectionResourceRel = "calls", path = "calls")
public interface CallRepository
        extends ListPagingAndSortingRepository<CallEntity, Integer>, CrudRepository<CallEntity, Integer> {
}
