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

@Entity(name = "city")
@Table(name = "cities" ,
        indexes = {
                @Index(name = "cities_pk_2",  columnList="city_name", unique = true)})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityEntity {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name="city_id")
    private int id;

    @Column(nullable = false, name="city_name")
    private String name;
}
