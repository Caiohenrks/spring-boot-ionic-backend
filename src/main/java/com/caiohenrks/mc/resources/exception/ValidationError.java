
package com.caiohenrks.mc.resources.exception;

import java.util.ArrayList;
import java.util.List;


public class ValidationError extends StandardError{
    private static final long serialVersionUID = 1l;
    
    private List<FieldMessage> erros = new ArrayList<>();
    
    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<FieldMessage> getErrors() {
        return erros;
    }

    public void addError(String fieldName, String message){
        erros.add(new FieldMessage(fieldName, message));
    }
    
    
}
