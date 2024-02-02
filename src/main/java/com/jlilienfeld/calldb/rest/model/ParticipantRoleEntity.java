package com.jlilienfeld.calldb.rest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "participantRole")
@Table(name = "participant_role" ,
        indexes = {
                @Index(name = "participant_role_pk_2",  columnList="participant_role_name", unique = true)})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantRoleEntity {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name="participant_role_id")
    private int id;

    @Column(nullable = false, name="participant_role_name")
    private String name;
}
