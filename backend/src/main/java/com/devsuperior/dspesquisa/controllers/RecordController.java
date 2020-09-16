package com.devsuperior.dspesquisa.controllers;

import java.util.List;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.services.RecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
