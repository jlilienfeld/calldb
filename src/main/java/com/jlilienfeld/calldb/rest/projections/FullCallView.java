package com.jlilienfeld.calldb.rest.projections;

import com.jlilienfeld.calldb.rest.model.entities.CallEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.List;

@Projection(name = "fullCallView", types = { CallEntity.class })
public interface FullCallView {
    @Value("#{target.getId()}")
    String getId();

    @Value("#{target.getCity().getName()}")
    String getCityName();

    @Value("#{target.getCallMethod().getName()}")
    String getCallMethodName();

    Date getCallDate();
    Date getStartTime();
    Date getEndTime();

    int getDuration();

    List<CallParticipantView> getPersons();
}
