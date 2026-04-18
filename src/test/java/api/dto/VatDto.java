package api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VatDto {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private Integer percent;

    @JsonProperty("reason_without")
    private String reasonWithout;


    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public String getReasonWithout() {
        return reasonWithout;
    }

    public void setReasonWithout(String reasonWithout) {
        this.reasonWithout = reasonWithout;
    }
}
