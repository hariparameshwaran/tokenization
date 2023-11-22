package com.sample.tokenization.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DetokenizeRequestList {

    @JsonProperty("referenceId")
    public String referenceId;

    @JsonProperty("tokenizedDataList")
    public List<TokenizedData> tokenizedDataList;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public List<TokenizedData> getTokenizedDataList() {
        return tokenizedDataList;
    }

    public void setTokenizedDataList(List<TokenizedData> tokenizedDataList) {
        this.tokenizedDataList = tokenizedDataList;
    }
}
