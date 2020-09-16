package com.devsuperior.dspesquisa.services;

import java.time.Instant;
import java.util.List;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.entities.Record;
import com.devsuperior.dspesquisa.repositories.GameRepository;
import com.devsuperior.dspesquisa.repositories.RecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Transactional(readOnly = true)
	public Page<RecordDTO> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {
		return recordRepository.findByMoments(minDate,maxDate,pageRequest).map(x-> new RecordDTO(x));
	}

}
