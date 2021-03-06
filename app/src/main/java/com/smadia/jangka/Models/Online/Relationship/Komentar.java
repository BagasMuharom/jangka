package com.smadia.jangka.Models.Online.Relationship;

import com.smadia.jangka.Models.Online.Berita;
import com.smadia.jangka.Models.Online.User;
import com.smadia.jangka.Util.DateFormat;

public class Komentar {

    private Berita berita;

    private User user;

    private int id;

    private DateFormat created_at;

    private DateFormat updated_at;

    private String isi;

    public Komentar(Berita berita, User user, String isi, int id) {
        this.berita = berita;
        this.user = user;
        this.isi = isi;
        this.id = id;
    }

    public Berita getBerita() {
        return this.berita;
    }

    public User getUser() {
        return this.user;
    }

    public DateFormat getCreated_at() {
        return this.created_at;
    }

    public DateFormat getUpdated_at() {
        return this.updated_at;
    }

    public String getIsi() {
        return isi;
    }

    public int getId() {
        return id;
    }
}
