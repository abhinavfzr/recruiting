package com.quovantis.recruiting.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "offer")
public class Offer
{

    @Id
    String jobTitle;

    @Column(name = "startDate")
    String startDate;

    @Column(name = "numberOfApplication")
    @OneToMany
    List<Application> numberOfApplication;

    public Offer() {
    }

    public Offer(String jobTitle, String startDate, Application numberOfApplication) {
        this.jobTitle = jobTitle;
        this.startDate = startDate;
        this.numberOfApplication = (List<Application>) numberOfApplication;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List<Application> getNumberOfApplication() {
        return numberOfApplication;
    }

    public void setNumberOfApplication(List<Application> numberOfApplication) {
        this.numberOfApplication = numberOfApplication;
    }
}
