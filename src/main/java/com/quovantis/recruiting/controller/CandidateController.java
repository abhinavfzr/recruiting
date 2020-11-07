package com.quovantis.recruiting.controller;

import com.quovantis.recruiting.domain.Candidate;
import com.quovantis.recruiting.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CandidateController {
    @Autowired
    CandidateService candidateService;

    @GetMapping("/Candidate")
    private List<Candidate> getAllCandidates()
    {
        return candidateService.getAllCandidates();
    }

    @GetMapping("/Candidate/{Candidateid}")
    private Candidate getCandidates(@PathVariable("Candidateid") String Candidateid)
    {
        return candidateService.getCandidatesById(Candidateid);
    }

    @PostMapping("/CreateCandidate")
    private String saveCandidate(@RequestBody Candidate Candidates)
    {
        candidateService.saveOrUpdate(Candidates);
        return Candidates.getEmailId();
    }


}
