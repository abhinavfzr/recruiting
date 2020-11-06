package com.quovantis.recruiting.domain;


import javax.persistence.*;

@Entity
@Table(name = "application")
public class Application
{
    @Column(name="relatedOffer")
    String relatedOffer;

    @Id
    @Column(name ="candidateEmail")
    String candidateEmail;

    @Column(name ="resumeText")
    String resumeText;

    @Column(name = "applicationStatus")
    String applicationStatus;

    public Application() {
    }

    public Application(String relatedOffer, String candidateEmail, String resumeText, String applicationStatus) {
        this.relatedOffer = relatedOffer;
        this.candidateEmail = candidateEmail;
        this.resumeText = resumeText;
        this.applicationStatus = applicationStatus;
    }

    public String getRelatedOffer() {
        return relatedOffer;
    }

    public void setRelatedOffer(String relatedOffer) {
        this.relatedOffer = relatedOffer;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getResumeText() {
        return resumeText;
    }

    public void setResumeText(String resumeText) {
        this.resumeText = resumeText;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
