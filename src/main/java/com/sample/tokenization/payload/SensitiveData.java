package com.sample.tokenization.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SensitiveData {

    @JsonProperty("fieldName")
    public String fieldName;

    @JsonProperty("fieldData")
    public String fieldData;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldData() {
        return fieldData;
    }

    public void setFieldData(String fieldData) {
        this.fieldData = fieldData;
    }
}
