package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemDTO {

    private String name;
    private Double price;

    @JsonProperty("quantity_unit")
    private String quantityUnit;

    @JsonProperty("quantity")
    private int quantity;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
