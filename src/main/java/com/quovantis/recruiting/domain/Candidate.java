package com.quovantis.recruiting.domain;


import javax.persistence.*;

@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    String emailId;

    @Column(name = "name")
    String name;

    public Candidate() {
    }

    public Candidate(String emailId, String name) {
        this.emailId = emailId;
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
