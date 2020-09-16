package com.devsuperior.dspesquisa.controllers;

import java.time.Instant;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.services.RecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/records")
public class RecordController {
    @Autowired
    private RecordService recordService;
    
    @PostMapping
    public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO recordInsertDTO){
        return ResponseEntity.ok().body(recordService.insert(recordInsertDTO));
    }

    @GetMapping
	public ResponseEntity<Page<RecordDTO>> findAll(
            @RequestParam(value = "min", defaultValue = "") String min,
            @RequestParam(value = "max", defaultValue = "") String max,        
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction) {
        
        Instant minDate = ("".equals(min))?null:Instant.parse(min);
        Instant maxDate = ("".equals(max))?null:Instant.parse(max);
        linesPerPage = linesPerPage==0? Integer.MAX_VALUE:linesPerPage;//coloca todas as linhas em uma página
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);//objeto de paginação
        Page<RecordDTO> list = recordService.findByMoments(minDate,maxDate, pageRequest);
		return ResponseEntity.ok().body(list);
	}
}
