package com.comet.smarthouse.repository;

import com.comet.smarthouse.model.entity.MeasureEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface MeasureRepository extends CrudRepository<MeasureEntity, UUID> {
    @Query("from MeasureEntity measure where measure.timestamp >= :start and measure.timestamp <= :end and measure.type = :type")
    List<MeasureEntity> getMeasuresInWindow(@Param("start") LocalDateTime start,
                                            @Param("end") LocalDateTime end,
                                            @Param("type") Integer type);
}
