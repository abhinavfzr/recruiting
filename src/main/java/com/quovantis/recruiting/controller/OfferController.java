package com.quovantis.recruiting.controller;

import com.quovantis.recruiting.domain.Offer;
import com.quovantis.recruiting.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OfferController {
    @Autowired

    OfferService offerservice;

    @GetMapping("/Offer")
    private List<Offer> getAllOffers()
    {
        return offerservice.getAllOffers();
    }

    @GetMapping("/Offer/{Offerid}")
    private Offer getOffers(@PathVariable("Offerid") String Offerid)
    {
        return offerservice.getOffersById(Offerid);
    }


    @PostMapping("/CreateOffer")
    private String saveOffer(@RequestBody Offer Offers)
    {
        offerservice.saveOrUpdate(Offers);
        return Offers.getJobTitle();
    }


}
