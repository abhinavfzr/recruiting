package com.quovantis.recruiting.controller;

import com.quovantis.recruiting.domain.Application;
import com.quovantis.recruiting.domain.Offer;
import com.quovantis.recruiting.dto.StatusChange;
import com.quovantis.recruiting.service.ApplicationService;
import com.quovantis.recruiting.service.CandidateService;
import com.quovantis.recruiting.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;
    @Autowired
    OfferService offerService;
    @Autowired
    CandidateService candidateService;


    @GetMapping("/Application")
    private List<Application> getAllAppllication() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/AppllicationByCandidateID/{Candidateid}")
    private Application getAppllicationByCandidateID(@PathVariable("Candidateid") String Candidateid) {
        return applicationService.getApplicationsById(Candidateid);
    }

    @GetMapping("/AppllicationByOfferId/{Applicationid}")
    private List<Application> getAppllicationByOfferId(@PathVariable("Applicationid") String Applicationid) {
        return applicationService.getApplicationsByOfferId(Applicationid);
    }

    @PostMapping("/Apply")
    private String saveApplication(@RequestBody Application Appllication) {
        Offer offerdto;
        System.out.println("related_offer " + Appllication.getRelatedOffer());
        try {
            offerdto = offerService.getOffersById(Appllication.getRelatedOffer());
            String offer = offerdto.getJobTitle();
            System.out.println("offerjob " + offer);
            if (!offer.equals(Appllication.getRelatedOffer())) {
                System.out.println("if condition job" + offer.equals(Appllication.getRelatedOffer()));
                return "Job Offer doesnt exist";
            }
        } catch (Exception ex) {
            return ("job " + ex.toString());
        }

        String candidateEmail = null;
        try {
            candidateEmail = candidateService.getCandidatesById(Appllication.getCandidateEmail()).getEmailId();
        } catch (Exception ex) {
            return ("candidate " + ex.toString());
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

    @PostMapping("/Invite")
    private String inviteCandidate(@RequestBody StatusChange invite) {

        Application application2 =getAppllicationByCandidateID(invite.getCandidateId());

                if(application2.getApplicationStatus().equals("APPLIED"))
                {
                    application2.setApplicationStatus("INVITED");
                    applicationService.saveOrUpdate(application2);
                    return "Invited success";
                }
                else {
                    return "cant invite";
                }
    }

    @PostMapping("/Reject")
    private String rejectCandidate(@RequestBody StatusChange reject)
    {
        Application application  = getAppllicationByCandidateID(reject.getCandidateId());
        if(application.getApplicationStatus().equals("APPLIED"))
        {
            application.setApplicationStatus("REJECTED");
            applicationService.saveOrUpdate(application);
            return "REJECTED";
        }
        else {
            return "cant reject";
        }
    }

    @PostMapping("/Hire")
    private  String hirecandidate(@RequestBody StatusChange hire)
    {
        Application application = getAppllicationByCandidateID(hire.getCandidateId());
        if(application.getApplicationStatus().equals("INVITED"))
        {
            application.setApplicationStatus("HIRED");
            applicationService.saveOrUpdate(application);
            return  "HIRED";
        }
        else {
            return "cant hire";
        }

    }

}
