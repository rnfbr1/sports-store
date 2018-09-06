package com.todouno.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Fabricio on 04/09/2018.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Ha sobrepasado el stock")
public class StockMenorACeroException extends Exception {

    public StockMenorACeroException(String message)
    {
        super(message);
    }
}


