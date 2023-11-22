package com.sample.tokenization.payload;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class DetokenizeResponseList {
    @JsonProperty("referenceId")
    public String referenceId;

    @JsonProperty("sensitiveDataList")
    public List<SensitiveData> sensitiveDataList;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public List<SensitiveData> getSensitiveDataList() {
        return sensitiveDataList;
    }

    public void setSensitiveDataList(List<SensitiveData> sensitiveDataList) {
        this.sensitiveDataList = sensitiveDataList;
    }
}
