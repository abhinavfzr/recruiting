package com.quovantis.recruiting.service;

import com.quovantis.recruiting.domain.Candidate;
import com.quovantis.recruiting.repostiory.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService {
    @Autowired
    CandidateRepository CandidateRepository;

    public List<Candidate> getAllCandidates()
    {
        List<Candidate> Candidate = new ArrayList<Candidate>();
        CandidateRepository.findAll().forEach(Candidate1 -> Candidate.add(Candidate1));
        return Candidate;
    }

    public Candidate getCandidatesById(String id)
    {
        return CandidateRepository.findById(id).get();
    }

    public void saveOrUpdate(Candidate Candidate)
    {
        CandidateRepository.save(Candidate);
    }

    public void delete(String id)
    {
        CandidateRepository.deleteById(id);
    }
    public void update(Candidate Candidate, String emailId)
    {
        CandidateRepository.save(Candidate);
    }
}
