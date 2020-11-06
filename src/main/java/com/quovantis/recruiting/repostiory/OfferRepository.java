package com.quovantis.recruiting.repostiory;

import com.quovantis.recruiting.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer,String>
{

}
