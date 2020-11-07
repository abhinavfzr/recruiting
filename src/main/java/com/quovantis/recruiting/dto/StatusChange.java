package com.quovantis.recruiting.dto;

public class StatusChange {
    String candidateId;
    String OfferName;

    public StatusChange() {
    }

    public StatusChange(String candidateId, String offerName) {
        this.candidateId = candidateId;
        OfferName = offerName;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getOfferName() {
        return OfferName;
    }

    public void setOfferName(String offerName) {
        OfferName = offerName;
    }
}
