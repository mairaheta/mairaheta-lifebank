package com.lifebank.pojo.menu;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Text 
{
	@JsonProperty("parent")
    private String parent;
    @JsonProperty("id")
    private String id;
    @JsonProperty("value")
    private String value;

    @JsonProperty("parent")
    public String getParent() {
        return parent;
    }

    @JsonProperty("parent")
    public void setParent(String parent) {
        this.parent = parent;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

}
