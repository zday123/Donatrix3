package edu.gatech.donatrix.model;

import java.io.Serializable;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * A location class
 */
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
/**
 * Constructor!
 * @param name the name of the Location
 */
    public Location(String name) {
        this.name = name;
    }

    /**
     * Another constructor. Takes more data.
     * @param info The data that makes up the Location
     */
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

    /**
     * Major key alert
     * @return The key
     */
    public int getKey() {
        return key;
    }

    private void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return The name.
     */
    public String getName() {
        return name;
    }

    private void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * What is the latitude?
     * @return The lattitude.
     */
    public String getLatitude() {
        return latitude;
    }

    private void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * Getting the longitude.
     * @return The longitude.
     */
    public String getLongitude() {
        return longitude;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter.
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    private void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    private void setState(String state) {
        this.state = state;
    }

    /**
     * Getter
     * @return The state.
     */
    public String getState() {
        return state;
    }

    private void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Getter
     * @return The zip lock bag.
     */
    public String getZip() {
        return zip;
    }

    private void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    /**
     * Getter
     * @return The location type (enum).
     */
    public LocationType getLocationType() {
        return locationType;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    /**
     * Getter
     * @return The phone number.
     */
    public String getNumber() {
        return number;
    }

    private void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Getter
     * @return The website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * A method to add the item.
     * @param item The item to add to the location.
     * @param context Something.
     * @param employee The employee that is adding the item.
     */
    public void addItem(Item item, Context context, LocationEmployee employee) {
        Database.getInstance(context).addItem(item, employee);
    }

//    /**
//     * How we remove an item from this location.
//     * @param item The item to remove.
//     */
//    public void removeItem(Item item) {
//        this.inventory.removeItem(item);
//    }
    @NonNull
    @Override
    public String toString() {
        //Paul: ugly syntax
        return String.format("%s | %s | %s | %s | %s | %s | %s | %s | %s | %s", name, latitude,
                longitude, address, city, state, zip, locationType.getType(), number, website);
    }

    /**
     * equals method
     *
     * @param obj the obj to compare to
     * @return true if equal
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Location)) {
            return false;
        } else {
            //Paul: ugly syntax
            return (this.key == ((Location) obj).key) && this.address.equals(
                    ((Location) obj).address) && this.latitude.equals(((Location) obj).latitude)
                    && this.city.equals(((Location) obj).city) && (this.locationType ==
                    ((Location) obj).locationType) && this.name.equals(((Location) obj).name)
                    && this.longitude.equals(((Location) obj).longitude) && this.number
                    .equals(((Location) obj).number) && this.state.equals(((Location) obj).state) &&
                    this.website.equals(((Location) obj).website) && this.zip
                    .equals(((Location) obj).zip);

        }
    }

    @Override
    //Paul: not a proper hashcode method. Low priority
    public int hashCode() {
        return this.key * this.name.length();
    }
}
