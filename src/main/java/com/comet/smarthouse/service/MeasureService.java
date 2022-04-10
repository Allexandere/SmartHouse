package com.comet.smarthouse.service;

import com.comet.smarthouse.model.dto.MeasureDto;
import com.comet.smarthouse.model.entity.MeasureEntity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface MeasureService {
    void saveMeasure(MeasureDto measureDto);
    List<MeasureDto> getMeasuresInTimeWindow(LocalDateTime windowStart, LocalDateTime windowEnd, Integer type);
}
