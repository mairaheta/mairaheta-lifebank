package com.lifebank.pojo.menu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OptionsMenuResponse 
{
	@JsonProperty("texts")
    private List<Text> texts = null;
    
    @JsonProperty("texts")
    public List<Text> getTexts() {
        return texts;
    }

    @JsonProperty("texts")
    public void setTexts(List<Text> texts) {
        this.texts = texts;
    }
}
