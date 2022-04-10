package com.comet.smarthouse.service;

import com.comet.smarthouse.model.dto.MeasureDto;
import com.comet.smarthouse.model.entity.MeasureEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public List<MeasureDto> mapEntitiesToDto(List<MeasureEntity> entities) {
        return entities.stream().map(entity -> new MeasureDto(entity.getType(),
                entity.getValue(),
                entity.getTimestamp()))
                .collect(Collectors.toList());
    }

}
