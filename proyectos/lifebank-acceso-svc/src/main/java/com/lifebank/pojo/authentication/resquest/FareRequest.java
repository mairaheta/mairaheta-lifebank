
package com.lifebank.pojo.authentication.resquest;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "operatingAirline",
    "tpm",
    "cabin"
})
public class FareRequest {

    @JsonProperty("operatingAirline")
    private String operatingAirline;
    @JsonProperty("tpm")
    private String tpm;
    @JsonProperty("cabin")
    private String cabin;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("operatingAirline")
    public String getOperatingAirline() {
        return operatingAirline;
    }

    @JsonProperty("operatingAirline")
    public void setOperatingAirline(String operatingAirline) {
        this.operatingAirline = operatingAirline;
    }

    @JsonProperty("tpm")
    public String getTpm() {
        return tpm;
    }

    @JsonProperty("tpm")
    public void setTpm(String tpm) {
        this.tpm = tpm;
    }

    @JsonProperty("cabin")
    public String getCabin() {
        return cabin;
    }

    @JsonProperty("cabin")
    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
