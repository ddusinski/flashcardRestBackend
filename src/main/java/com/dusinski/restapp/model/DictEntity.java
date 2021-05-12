package com.dusinski.restapp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DictEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String english;
    private String polish;

    public DictEntity() {
    }

    public DictEntity(long id, String english, String polish) {
        this.id = id;
        this.english = english;
        this.polish = polish;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getPolish() {
        return polish;
    }

    public void setPolish(String polish) {
        this.polish = polish;
    }

    @Override
    public String toString() {
        return "DictEntity{" +
                "id=" + id +
                ", english='" + english + '\'' +
                ", polish='" + polish + '\'' +
                '}';
    }
}
