package com.quovantis.recruiting.repostiory;

import com.quovantis.recruiting.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,String>
{


    void findByrelatedOffer(String applicationid);
}

