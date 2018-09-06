package com.todouno.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "La busqueda no ha dado resultados.")
public class EntityNotFoundException extends Exception
{
    static final long serialVersionUID = -3387516993334229948L;


    public EntityNotFoundException(String message)
    {
        super(message);
    }

}
