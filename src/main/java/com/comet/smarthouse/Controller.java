package com.comet.smarthouse;

import com.comet.smarthouse.model.dto.MeasureDto;
import com.comet.smarthouse.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/measure")
public class Controller {
    @Autowired
    private MeasureService measureService;

    @PostMapping
    public void createMeasure(@RequestBody MeasureDto measureDto){
        measureService.saveMeasure(measureDto);
    }

    @GetMapping
    public List<MeasureDto> getMeasuresInWindow(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
                                                @RequestParam Integer type){
        return measureService.getMeasuresInTimeWindow(start,end,type);
    }
}
