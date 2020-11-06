package com.quovantis.recruiting.service;

import com.quovantis.recruiting.domain.Application;
import com.quovantis.recruiting.repostiory.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService{
    @Autowired
    ApplicationRepository applicationRepository;
    
    public List<Application> getAllApplications()
    {
        List<Application> Application = new ArrayList<Application>();
        applicationRepository.findAll().forEach(Application1 -> Application.add(Application1));
        return Application;
    }

    public Application getApplicationsById(String id)
    {
        return applicationRepository.findById(id).get();
    }

    public void saveOrUpdate(Application Application)
    {
        applicationRepository.save(Application);
    }

    public void delete(String id)
    {
        applicationRepository.deleteById(id);
    }

    public void update(Application Application, String emailId)
    {
        applicationRepository.save(Application);
    }

    public List<Application> getApplicationsByOfferId(String applicationid) {
        List<Application> Application  = applicationRepository.findAll();
        List<Application> Application1 = new ArrayList<Application>();
        for (Application element: Application){
          if(element.getRelatedOffer().equals(applicationid))
          {
              Application1.add(element);
          }
        }
        return Application1;
    }
}
