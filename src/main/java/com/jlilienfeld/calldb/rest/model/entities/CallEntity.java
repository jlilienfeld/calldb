package com.jlilienfeld.calldb.rest.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;

@Entity(name = "call")
@Table(name = "calls" ,
        indexes = {
                @Index(name = "calls_call_date_index",  columnList = "call_date"),
                @Index(name = "calls_start_date_index", columnList = "start_date"),
                @Index(name = "calls_end_date_index", columnList = "end_date"),
                @Index(name = "calls_duration_index", columnList = "duration")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CallEntity {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name="call_id")
    private long id;

    @Column(name="call_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date callDate;

    @OneToMany(mappedBy = "call")
    private List<CallPersonAssociationEntity> persons;

    @ManyToOne
    @JoinColumn(name="call_method_id")
    private CallMethodEntity callMethod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="city_id")
    private CityEntity city;

    @Column(name="start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name="end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(name="duration")
    private int duration;

    @Column(name="unknown_number")
    private int unknownNumber;

    @Column(name="comments")
    private String comments;
}
