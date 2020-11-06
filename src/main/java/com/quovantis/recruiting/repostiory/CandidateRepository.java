package com.quovantis.recruiting.repostiory;

import com.quovantis.recruiting.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String>
{

}
