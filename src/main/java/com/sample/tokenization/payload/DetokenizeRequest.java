package com.sample.tokenization.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DetokenizeRequest {

    public String token;

}
