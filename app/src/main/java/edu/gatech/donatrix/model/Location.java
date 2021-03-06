package edu.gatech.donatrix.model;

import java.io.Serializable;
import edu.gatech.donatrix.dao.Database;
import android.content.Context;
import android.support.annotation.NonNull;


public class Location implements Serializable {
    private int key; //Paul rename to id or uid
    private String name; //Paul: rename to title
    private String latitude; //Paul: extract into coordinate object
    private String longitude; //Paul: extract into coordinate object
    private String address; //Paul: extract into address object
    private String city; //Paul: extract into address object
    private String state; //Paul: extract into address object
    private String zip; //Paul: extract into address object
    private LocationType locationType;
    private String number; //Paul: rename to phoneNumber or telephone
    private String website;
    private ItemManager inventory;

    public Location(String name) {
        this.name = name;
    }

    //Paul: info needs to be of type HashMap<String><String>
    public Location(String[] info) {
        this.key = Integer.parseInt(info[0]);
        this.setName(info[1]);
        this.setLatitude(info[2]);
        this.setLongitude(info[3]);
        this.setAddress(info[4]);
        this.setCity(info[5]);
        this.setState(info[6]);
        this.setZip(info[7]);
        //Paul: the line below violates LOD, changes in LocationType can break this file:
        this.setLocationType(LocationType.valueOf(info[8].replace(" ", "").toUpperCase()));
        this.setNumber(info[9]);
        this.setWebsite(info[10]);
    }

    public int getKey() {
        return key;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLatitude() {
        return latitude;
    }

    private void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLongitude() {
        return longitude;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    private void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    private void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    private void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    private void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    private void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void addItem(Item item, Context context, LocationEmployee employee) {
        Database.getInstance(context).addItem(item, employee);
    }

    public void removeItem(Item item) {
        this.inventory.removeItem(item);
    }
    @NonNull
    @Override
    public String toString() {
        //Paul: ugly syntax
        return String.format("%s | %s | %s | %s | %s | %s | %s | %s | %s | %s", name, latitude, longitude, address, city, state, zip, locationType.getType(), number, website);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Location)) {
            return false;
        } else {
            //Paul: ugly syntax
            return (this.key == ((Location) obj).key) && this.address.equals(((Location) obj).address) && this.latitude.equals(((Location) obj).latitude) && this.city.equals(((Location) obj).city) && (this.locationType == ((Location) obj).locationType) && this.name.equals(((Location) obj).name) && this.longitude.equals(((Location) obj).longitude) && this.number.equals(((Location) obj).number) && this.state.equals(((Location) obj).state) && this.website.equals(((Location) obj).website) && this.zip.equals(((Location) obj).zip);
        }
    }

    @Override
    //Paul: not a proper hashcode method. Low priority
    public int hashCode() {
        return this.key * this.name.length();
    }
}
