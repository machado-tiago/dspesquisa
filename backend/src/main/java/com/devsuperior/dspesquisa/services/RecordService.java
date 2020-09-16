package com.devsuperior.dspesquisa.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.entities.Record;
import com.devsuperior.dspesquisa.repositories.GameRepository;
import com.devsuperior.dspesquisa.repositories.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public RecordDTO insert(RecordInsertDTO recordInsertDTO){
        Record record = new Record();
        record.setAge(recordInsertDTO.getAge());
        record.setMoment(Instant.now());
        record.setName(recordInsertDTO.getName());
        record.setGame(gameRepository.getOne(recordInsertDTO.getGameId()));
        recordRepository.save(record);
        return new RecordDTO(record);
    }


}
