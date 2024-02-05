package com.jlilienfeld.calldb.rest.model.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class CallPersonKey implements Serializable {
    @Column(name = "call_id")
    private long callId;

    @Column(name = "person_id")
    private long personId;
}
