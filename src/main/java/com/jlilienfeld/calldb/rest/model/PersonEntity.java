package com.jlilienfeld.calldb.rest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity(name = "person")
@Table(name = "persons" ,
        indexes = {
            @Index(name = "persons_person_full_name_index",  columnList="person_full_name", unique = true)})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name="person_id")
    private long id;

    @Column(nullable = false, name="person_full_name")
    private String fullName;

    @OneToMany(mappedBy = "person")
    private List<CallPersonAssociationEntity> calls;
}
