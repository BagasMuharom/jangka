package com.smadia.jangka.Models.Online;

import android.graphics.Bitmap;

import com.smadia.jangka.JSON.AsyncTaskListener;
import com.smadia.jangka.JSON.JsonFetcher;
import com.smadia.jangka.JSON.JsonParser;
import com.smadia.jangka.Models.Models;
import com.smadia.jangka.Models.Online.Relationship.Komentar;
import com.smadia.jangka.Util.DateFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Berita extends Models<Berita> {

    protected String table = "berita";

    private int id;

    private String judul = "";

    private String isi = "";

    private Daerah lokasi;

    private boolean berita_nasional;

    private DateFormat created_at;

    private DateFormat updated_at;

    private int dilihat;

    private int like;

    private int dislike;

    private int bookmark;

    private String thumbnailUrl;

    private String url;

    private Bitmap thumbnail;

    public Berita() {}

    public Berita(int id) {
        this.url = this.table + "/" + id;
    }

    public static Berita find(int id) {
        return new Berita(id);
    }

    public ArrayList<Berita> all(JsonFetcher jsonFetcher) {
        JSONArray jsonArray = jsonFetcher.getJsonArray();
        ArrayList<Berita> daftarBerita = new ArrayList<>();
        JsonParser jsonParser = new JsonParser(jsonArray);
        ArrayList<JSONObject> jsonObjects = jsonParser.getJsonObjects();

        for (int i = 0; i < jsonObjects.size(); i++) {
            Berita berita = new Berita();
            berita.setPropetyFromJsonObject(jsonObjects.get(i));
            daftarBerita.add(berita);
        }

        return daftarBerita;
    }

    public ArrayList<Berita> all(JSONArray jsonArray) {
        ArrayList<Berita> daftarBerita = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {
            try {
                Berita berita = new Berita();
                berita.setPropetyFromJsonObject(jsonArray.getJSONObject(i));
                daftarBerita.add(berita);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return daftarBerita;
    }

    public void setPropetyFromJsonObject(JSONObject jsonObject) {
        try {
            this.judul = jsonObject.getString("judul");
            this.id = Integer.parseInt(jsonObject.getString("id"));
            if(jsonObject.has("isi"))
                this.isi = jsonObject.getString("isi");
            this.berita_nasional = Boolean.parseBoolean(jsonObject.getString("berita_nasional"));
            this.dilihat = Integer.parseInt(jsonObject.getString("dilihat"));
            this.thumbnailUrl = jsonObject.getString("thumbnail");
//            this.lokasi = ;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Komentar> daftarKomentar() {
        ArrayList<Komentar> daftarKomentar = new ArrayList<>();

        return daftarKomentar;
    }

    public ArrayList<Kategori> daftarKategori(JSONArray jsonArray) {
        ArrayList<Kategori> daftarKategori = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            Kategori kategori = new Kategori();
            try {
                kategori.setPropetyFromJsonObject(jsonArray.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            daftarKategori.add(kategori);
        }

        return daftarKategori;
    }

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getIsi() {
        return isi;
    }

    public Daerah getLokasi() {
        return this.lokasi;
    }

    public boolean isBerita_nasional() {
        return berita_nasional;
    }

    public DateFormat getCreated_at() {
        return created_at;
    }

    public DateFormat getUpdated_at() {
        return updated_at;
    }

    public int getDilihat() {
        return dilihat;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public boolean addBookmarker(User user, Berita berita) {
        return true;
    }

    public JsonFetcher getJsonFetcher() {
        return new JsonFetcher(this.url);
    }

    public Bitmap getThumbnail() {
        return thumbnail;
    }

}
