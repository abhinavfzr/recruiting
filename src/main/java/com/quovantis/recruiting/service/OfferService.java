package com.quovantis.recruiting.service;

import com.quovantis.recruiting.domain.Offer;
import com.quovantis.recruiting.repostiory.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferService {
    @Autowired
    OfferRepository offerRepository;
    public List<Offer> getAllOffers()
    {
        List<Offer> Offer = new ArrayList<Offer>();
        offerRepository.findAll().forEach(Offer1 -> Offer.add(Offer1));
        return Offer;
    }
    //getting a specific record by using the method findById() of CrudRepository  
    public Offer getOffersById(String id)
    {
        return offerRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository  
    public void saveOrUpdate(Offer Offer)
    {
        offerRepository.save(Offer);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository  
    public void delete(String id)
    {
        offerRepository.deleteById(id);
    }
    //updating a record  
    public void update(Offer Offer, String emailId)
    {
        offerRepository.save(Offer);
    }

}
