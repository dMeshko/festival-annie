package finki.ukim.mk.festival.models;


import android.support.annotation.NonNull;

import java.util.Date;
import java.util.List;

public class Artist implements Comparable<Artist>{
    private String name;
    private String biography;
    private List<String> links;
    private Date date;
    private Date createdAt;
    private String imageUrl;
    private String country;
    private String stage;
    private Location location;

    public Artist(){
        createdAt = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public void addLink(String link){
        links.add(link);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return name + " (" + country + ")";
    }

    @Override
    public int compareTo(@NonNull Artist artist) {
        return name.compareTo(artist.getName());
    }
}
