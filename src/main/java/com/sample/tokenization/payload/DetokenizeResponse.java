package com.sample.tokenization.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class DetokenizeResponse {

    public String sensitiveData;
}
