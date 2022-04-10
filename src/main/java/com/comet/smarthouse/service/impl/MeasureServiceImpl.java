package com.comet.smarthouse.service.impl;

import com.comet.smarthouse.model.dto.MeasureDto;
import com.comet.smarthouse.model.entity.MeasureEntity;
import com.comet.smarthouse.repository.MeasureRepository;
import com.comet.smarthouse.service.Mapper;
import com.comet.smarthouse.service.MeasureService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MeasureServiceImpl implements MeasureService {

    @Autowired
    private MeasureRepository measureRepository;
    @Autowired
    private Mapper mapper;


    @Override
    public void saveMeasure(MeasureDto measureDto) {
        measureRepository.save(new MeasureEntity(measureDto.getType(),
                measureDto.getValue(),
                measureDto.getTimestamp()));
    }

    @Override
    public List<MeasureDto> getMeasuresInTimeWindow(LocalDateTime windowStart, LocalDateTime windowEnd, Integer type) {
        return mapper.mapEntitiesToDto(measureRepository.getMeasuresInWindow(windowStart, windowEnd, type));
    }
}
