package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDTO {

    @JsonProperty("to_name")
    private String toName;

    @JsonProperty("to_address")
    private String toAddress;

    @JsonProperty("to_egn")
    private String toEgn;

    @JsonProperty("to_mol")
    private String toMol;

    @JsonProperty("to_bulstat")
    private String toBulstat;

    @JsonProperty("to_is_reg_vat")
    private Boolean toIsRegVat;

    @JsonProperty("to_vat_number")
    private String toVatNumber;

    @JsonProperty("vat")
    private VatDto vat;

    private List<ItemDTO> items;

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getToEgn() {
        return toEgn;
    }

    public void setToEgn(String toEgn) {
        this.toEgn = toEgn;
    }

    public String getToMol() {
        return toMol;
    }

    public void setToMol(String toMol) {
        this.toMol = toMol;
    }

    public String getToBulstat() {
        return toBulstat;
    }

    public void setToBulstat(String toBulstat) {
        this.toBulstat = toBulstat;
    }

    public Boolean getToIsRegVat() {
        return toIsRegVat;
    }

    public void setToIsRegVat(Boolean toIsRegVat) {
        this.toIsRegVat = toIsRegVat;
    }

    public String getToVatNumber() {
        return toVatNumber;
    }

    public void setToVatNumber(String toVatNumber) {
        this.toVatNumber = toVatNumber;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }






    public VatDto getVat() {
        return vat;
    }

    public void setVat(VatDto vat) {
        this.vat = vat;
    }
}
