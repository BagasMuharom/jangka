package com.smadia.jangka.Models.Online;

import com.smadia.jangka.JSON.JsonParser;
import com.smadia.jangka.Models.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Daerah extends Models<Daerah> {

    protected String table = "daerah";

    private int id;

    private String nama;

    public Daerah(int id) {

    }

    @Override
    public void setPropetyFromJsonObject(JSONObject jsonObject) {
        try {
            this.id = Integer.parseInt(jsonObject.getString("id"));
            this.nama = jsonObject.getString("nama");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Daerah> all(JSONArray jsonArray) {
        return null;
    }

    public ArrayList<Berita> daftarberita() {
        ArrayList<Berita> daftarBerita = new ArrayList<>();


        return daftarBerita;
    }

}
