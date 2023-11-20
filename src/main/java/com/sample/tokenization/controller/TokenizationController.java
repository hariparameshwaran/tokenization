package com.sample.tokenization.controller;

import com.sample.tokenization.payload.DetokenizeRequest;
import com.sample.tokenization.payload.DetokenizeResponse;
import com.sample.tokenization.payload.TokenizeResponse;
import com.sample.tokenization.service.TokenDetokenService;
import com.sample.tokenization.payload.TokenizeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenizationController {

    @Autowired
    TokenDetokenService tokenDetokenService;

    @PostMapping("/tokenize")
    public TokenizeResponse tokenize(@RequestBody TokenizeRequest tokenizeRequest) {
        System.out.println("Tokenize Request :" + tokenizeRequest.getSensitiveData());
        String token = tokenDetokenService.tokenize(tokenizeRequest.getSensitiveData());
        System.out.println("Token is :" + token);
        TokenizeResponse tokenizeResponse = new TokenizeResponse();
        tokenizeResponse.setToken(token);
        return tokenizeResponse;
    }

    @PostMapping("/detokenize")
    public DetokenizeResponse tokenize(@RequestBody DetokenizeRequest detokenizeRequest) {
        System.out.println("DeTokenize Request :" + detokenizeRequest.getToken());
        String sensitiveData = tokenDetokenService.deTokenize(detokenizeRequest.getToken());
        System.out.println("sensitiveData is :" + sensitiveData);
        DetokenizeResponse detokenizeResponse = new DetokenizeResponse();
        detokenizeResponse.setSensitiveData(sensitiveData);
        return detokenizeResponse;
    }

}
