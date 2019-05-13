
package com.lifebank.pojo.authentication.response;

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
    "fare",
    "coupon"
})
public class Body {

    @JsonProperty("fare")
    private Double fare;
    @JsonProperty("coupon")
    private Integer coupon;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fare")
    public Double getFare() {
        return fare;
    }

    @JsonProperty("fare")
    public void setFare(Double fare) {
        this.fare = fare;
    }

    @JsonProperty("coupon")
    public Integer getCoupon() {
        return coupon;
    }

    @JsonProperty("coupon")
    public void setCoupon(Integer coupon) {
        this.coupon = coupon;
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
