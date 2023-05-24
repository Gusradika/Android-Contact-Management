package com.aedeo.applicationmaintenancename;

public class Contact {
    public Integer id;
    public String nama, noHp;

    public Contact() {
    }

    public Contact(Integer id, String nama, String noHp) {
        this.id = id;
        this.nama = nama;
        this.noHp = noHp;
    }

    public Contact(String nama, String noHp) {
        this.nama = nama;
        this.noHp = noHp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
}
