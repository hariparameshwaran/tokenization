package com.sample.tokenization.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor

@ToString
public class TokenizeRequestList {
    //public SensitiveDataSet sensitiveDataSet;
    @JsonProperty("referenceId")
    public String referenceId;

    @JsonProperty("sensitiveDataList")
    public List<SensitiveData> sensitiveDataList;

    public String getReferenceId() {
        return referenceId;
    }

    public List<SensitiveData> getSensitiveDataList() {
        return sensitiveDataList;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public void setSensitiveDataList(List<SensitiveData> sensitiveDataList) {
        this.sensitiveDataList = sensitiveDataList;
    }
}
