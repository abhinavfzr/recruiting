package com.quovantis.recruiting.controller;

import com.quovantis.recruiting.domain.Application;
import com.quovantis.recruiting.domain.Candidate;
import com.quovantis.recruiting.domain.Offer;
import com.quovantis.recruiting.service.ApplicationService;
import com.quovantis.recruiting.service.CandidateService;
import com.quovantis.recruiting.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;
    @Autowired
    OfferService offerService;
    @Autowired
    CandidateService candidateService;


    @GetMapping("/Application")
    private List<Application> getAllAppllication()
    {
        return applicationService.getAllApplications();
    }

    @GetMapping("/AppllicationByCandidateID/{Candidateid}")
    private Application getAppllicationByCandidateID(@PathVariable("Candidateid") String Candidateid)
    {
        return applicationService.getApplicationsById(Candidateid);
    }

    @GetMapping("/AppllicationByOfferId/{Applicationid}")
    private List<Application> getAppllicationByOfferId(@PathVariable("Applicationid") String Applicationid)
    {
        return applicationService.getApplicationsByOfferId(Applicationid);
    }

    @PostMapping("/Apply")
    private String saveApplication(@RequestBody Application Appllication)
    {
             Offer offerdto;
             System.out.println("related_offer "+Appllication.getRelatedOffer());
            try {
                offerdto= offerService.getOffersById(Appllication.getRelatedOffer());
                String offer =offerdto.getJobTitle();
                System.out.println("offerjob "+offer);
                if (!offer.equals(Appllication.getRelatedOffer())) {
                    System.out.println("if condition job"+offer.equals(Appllication.getRelatedOffer()));
                    return "Job Offer doesnt exist";
                }
            }catch (Exception ex)
            {
                return ("job "+ex.toString());
            }

            String candidateEmail=null;
            try {
                candidateEmail = candidateService.getCandidatesById(Appllication.getCandidateEmail()).getEmailId();
            }
            catch(Exception ex){
                   return ("candidate "+ex.toString());
                    }

            if (!candidateEmail.equals(Appllication.getCandidateEmail())) {
                 return "Candidate doesnt exist";
             }
         Appllication.setApplicationStatus("APPLIED");
         applicationService.saveOrUpdate(Appllication);
         List<Application> appllications = offerdto.getNumberOfApplication();
         System.out.println(appllications.toString());
         appllications.add(Appllication);
         offerdto.setNumberOfApplication(appllications);
         offerService.saveOrUpdate(offerdto);
         return Appllication.getRelatedOffer();
    }


}
