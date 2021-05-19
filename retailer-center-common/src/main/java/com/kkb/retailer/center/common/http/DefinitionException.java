package com.kkb.retailer.center.common.http;

public class DefinitionException extends RuntimeException {
    private Integer code;
    private String message;


    public DefinitionException(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    public DefinitionException(Integer code,String message){
        this.code = code;
        this.message = message;
    }



    public DefinitionException(String message){
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
