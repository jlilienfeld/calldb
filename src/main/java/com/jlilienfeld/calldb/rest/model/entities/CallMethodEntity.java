package com.jlilienfeld.calldb.rest.model.entities;

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

@Entity(name = "callMethod")
@Table(name = "call_methods" ,
        indexes = {
                @Index(name = "call_methods_pk_2",  columnList = "call_method_name", unique = true)})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CallMethodEntity {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name="call_method_id")
    private int id;

    @Column(nullable = false, name="call_method_name")
    private String name;
}
