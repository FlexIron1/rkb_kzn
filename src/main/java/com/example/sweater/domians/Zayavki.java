package com.example.sweater.domians;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Zayavki {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id;
    private String otdel;
    private String problema;
    private String number;
    private String vremya;
    private Boolean status;

    public Zayavki(){

    }
    public Zayavki(String otdel, String problema, String number, String vremya) {
        this.otdel = otdel;
        this.problema = problema;
        this.number = number;
        this.vremya = vremya;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOtdel() {
        return otdel;
    }

    public void setOtdel(String otdel) {
        this.otdel = otdel;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVremya() {
        return vremya;
    }

    public void setVremya(String vremya) {
        this.vremya = vremya;
    }
}