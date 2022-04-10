package com.comet.smarthouse.model.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "measure")
public class MeasureEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private Integer type;
    private Double value;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;

    public MeasureEntity(Integer type, Double value, LocalDateTime timestamp) {
        this.type = type;
        this.value = value;
        this.timestamp = timestamp;
    }

    public MeasureEntity() {
    }
}

