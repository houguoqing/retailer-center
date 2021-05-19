package com.kkb.retailer.center.common.http;

public class HttpResult<T> {


    private Integer code;//状态码
    private String message;//提示消息
    private T data;//数据

    public HttpResult() {
    }

    /**
     * @param code 响应码
     * @param message 响应信息
     */
    public HttpResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @param code 响应码
     * @param message 响应信息
     * @param data 数据
     */
    public HttpResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * @param resultEnum 自定义枚举类，包含 code 和 message
     */
    public HttpResult(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }

    /**
     * @param resultEnum 自定义枚举类，包含 code 和 message
     * @param data 数据
     */
    public HttpResult(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }

    /**
     * 自定义异常返回的结果
     * @param definitionException 自定义异常处理类
     * @return 返回自定义异常
     */
    public static HttpResult<Object> defineError(DefinitionException definitionException) {
        return new HttpResult<>(definitionException.getCode(), definitionException.getMessage());
    }

    /**
     * 其他异常处理方法返回的结果
     * @param resultEnum 自定义枚举类，包含 code 和 message
     * @return 返回其他异常
     */
    public static HttpResult<Object> otherError(ResultEnum resultEnum) {
        return new HttpResult<>(resultEnum);
    }

    public static HttpResult<Object> success(Object data){
        return new HttpResult<>(ResultEnum.SUCCESS,data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
