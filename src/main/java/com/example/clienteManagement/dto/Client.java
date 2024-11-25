package com.example.clienteManagement.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Client {

    private String sharedKey;

    private String businessId;

    private String email;

    private String phone;

    private String dateAdded;

    
}
