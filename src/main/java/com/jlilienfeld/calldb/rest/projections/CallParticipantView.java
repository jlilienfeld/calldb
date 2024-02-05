package com.jlilienfeld.calldb.rest.projections;

import com.jlilienfeld.calldb.rest.model.entities.CallPersonAssociationEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "callParticipantView", types = { CallPersonAssociationEntity.class })
public interface CallParticipantView {
    @Value("#{target.getParticipantRole().getName()}")
    String getPersonRole();
    @Value("#{target.getPerson().getFullName()}")
    String getPersonName();
    @Value("#{target.getPerson().getId()}")
    long getId();
}
