/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tracusa.beans;

/**
 *
 * @author alimon
 */
public class Parcel {

    private String description;
    private String hsTariffNumber;
    private String originCountry;
    private int quantity;
    private Float value;
    private Float weight;
    private Float volume;
    private String typeMerchandise;
    private String typePacking;
    private Boolean secure;
    private Boolean isMultiple;
    private Float length;
    private Float height;
    private Float width;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHsTariffNumber() {
        return hsTariffNumber;
    }

    public void setHsTariffNumber(String hsTariffNumber) {
        this.hsTariffNumber = hsTariffNumber;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public String getTypeMerchandise() {
        return typeMerchandise;
    }

    public void setTypeMerchandise(String typeMerchandise) {
        this.typeMerchandise = typeMerchandise;
    }

    public String getTypePacking() {
        return typePacking;
    }

    public void setTypePacking(String typePacking) {
        this.typePacking = typePacking;
    }

    public Boolean getSecure() {
        return secure;
    }

    public void setSecure(Boolean secure) {
        this.secure = secure;
    }

    public Boolean getIsMultiple() {
        return isMultiple;
    }

    public void setIsMultiple(Boolean isMultiple) {
        this.isMultiple = isMultiple;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }
    
    

}
