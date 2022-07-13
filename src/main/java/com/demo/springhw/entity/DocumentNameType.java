package com.demo.springhw.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum DocumentNameType {
    PASSPORT("PP"),
    IDCARD("ID"),
    LICENCES("LI");

    private String value ;

    private static final Map<String,DocumentNameType> map = new HashMap<>();
    

    static {
        for(DocumentNameType documentNameType: DocumentNameType.values()){
            map.put(documentNameType.value,documentNameType);
        }
    }
    private static DocumentNameType of(String s){
        return map.get(s);
    }

}
