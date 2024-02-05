package com.jlilienfeld.calldb.rest.model.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "callPerson")
@Table(name = "call_person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CallPersonAssociationEntity {
    @EmbeddedId
    private CallPersonKey id;

    @ManyToOne
    @MapsId("callId")
    @JoinColumn(name = "call_id")
    private CallEntity call;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name="role_id")
    private ParticipantRoleEntity participantRole;
}
