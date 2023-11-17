package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ParticipantRepository;
import com.example.demo.models.Participant;
import java.util.List;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public Participant findParticipantById(Long id) {
        return participantRepository.findById(id).orElse(null);
    }

    public List<Participant> findAllParticipants() {
        return participantRepository.findAll();
    }

    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }
}
