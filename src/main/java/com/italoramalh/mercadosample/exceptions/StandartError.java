package com.italoramalh.mercadosample.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandartError {

    private Long timeStamp;

    private String error;

    private String message;

}
