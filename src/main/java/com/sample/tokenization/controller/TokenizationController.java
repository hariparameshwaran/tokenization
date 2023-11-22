package com.sample.tokenization.controller;

import com.sample.tokenization.payload.*;
import com.sample.tokenization.service.TokenDetokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TokenizationController {

    @Autowired
    TokenDetokenService tokenDetokenService;

    @PostMapping("/tokenize")
    public TokenizeResponse tokenize(@RequestBody TokenizeRequest tokenizeRequest) {
        System.out.println("Tokenize Request :" + tokenizeRequest.getSensitiveData());
        String token = tokenDetokenService.tokenize(tokenizeRequest.getSensitiveData(), "9999", "abc");
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

    @PostMapping("/tokenizelist")
    public TokenizeResponseList tokenizeSet(@RequestBody TokenizeRequestList tokenizeRequestList) {
        TokenizeResponseList tokenizeResponseList = new TokenizeResponseList();
        System.out.println(tokenizeRequestList);
        //System.out.println("Size Is :" + tokenizeRequestList.getSensitiveDataSet().size());
        // Iterate the list
        List<TokenizedData> tokenizedDataList  = new ArrayList<TokenizedData>();
        List<SensitiveData> sensitiveDataList = tokenizeRequestList.getSensitiveDataList();
        for(SensitiveData sensitiveDataItem : sensitiveDataList) {
           System.out.println("field name : " + sensitiveDataItem.getFieldName()) ;
            System.out.println("field Data : " + sensitiveDataItem.getFieldData()) ;
            TokenizedData tokenizedDataItem = new TokenizedData();
            tokenizedDataItem.setFieldName(sensitiveDataItem.getFieldName());
            String token = tokenDetokenService.tokenize(sensitiveDataItem.getFieldData(),
                                tokenizeRequestList.getReferenceId(),
                                sensitiveDataItem.getFieldName());
            tokenizedDataItem.setToken(token);
            tokenizedDataList.add(tokenizedDataItem);
        }
        tokenizeResponseList.setTokenizedDataList(tokenizedDataList);
        tokenizeResponseList.setReferenceId(tokenizeRequestList.getReferenceId());
        return tokenizeResponseList;

    }

    @PostMapping("/detokenizelist")
    public DetokenizeResponseList tokenizeSet(@RequestBody DetokenizeRequestList detokenizeRequestList) {
        DetokenizeResponseList detokenizeResponseList = new DetokenizeResponseList();

        List<TokenizedData> tokenizedDataList  = detokenizeRequestList.getTokenizedDataList();
        List<SensitiveData> sensitiveDataList = new ArrayList<SensitiveData>();
        for(TokenizedData tokenizedDataItem : tokenizedDataList) {
            System.out.println("field name : " + tokenizedDataItem.getFieldName()) ;
            System.out.println("field Data : " + tokenizedDataItem.getToken()) ;
            SensitiveData sensitiveDataItem = new SensitiveData();
            sensitiveDataItem.setFieldName(tokenizedDataItem.getFieldName());
            String sensitiveData = tokenDetokenService.deTokenize(tokenizedDataItem.getToken());
            sensitiveDataItem.setFieldData(sensitiveData);
            sensitiveDataList.add(sensitiveDataItem);
        }
        detokenizeResponseList.setSensitiveDataList(sensitiveDataList);
        detokenizeResponseList.setReferenceId(detokenizeRequestList.getReferenceId());
        return detokenizeResponseList;

    }

}
