package edu.qc.seclass.fim.models;

public class FloorProduct {

    Integer floorID;
    String floorCategory;
    String floorType;
    String floorSpecies;
    String floorColor;
    Double price;
    Double size;
    Integer quantity;

    //Constructor
    public FloorProduct(Integer id, String category, String type, String species, String color){
        this.floorID = id;
        this.floorCategory = category;
        this.floorType = type;
        this.floorSpecies = species;
        this.floorColor = color;
    }

    //Getters and setters
    public Integer getFloorID() {
        return floorID;
    }

    public void setFloorID(Integer floorID) {
        this.floorID = floorID;
    }

    public String getFloorCategory() {
        return floorCategory;
    }

    public void setFloorCategory(String floorCategory) {
        this.floorCategory = floorCategory;
    }

    public String getFloorType() {
        return floorType;
    }

    public void setFloorType(String floorType) {
        this.floorType = floorType;
    }

    public String getFloorSpecies() {
        return floorSpecies;
    }

    public void setFloorSpecies(String floorSpecies) {
        this.floorSpecies = floorSpecies;
    }

    public String getFloorColor() {
        return floorColor;
    }

    public void setFloorColor(String floorColor) {
        this.floorColor = floorColor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
