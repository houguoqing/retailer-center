package com.kkb.retailer.center.common.http;

/**
 * 响应返回状态和信息对应关系
 */
public enum ResultEnum {
    // 数据操作定义
    SUCCESS(200, "成功"),
    TIME_OUT(130, "访问超时"),
    NO_PERMISSION(403, "拒绝访问"),
    NO_AUTH(401, "未经授权访问"),
    NOT_FOUND(404, "无法找到资源"),
    METHOD_NOT_ALLOWED(405, "不支持当前请求方法"),
    SERVER_ERROR(500, " 服务器运行异常"),
    NOT_PARAM(10001, "空指针"),
    NOT_EXIST_USER_OR_ERROR_PASSWORD(10002, "该用户不存在或密码错误"),
    NOT_PARAM_USER_OR_ERROR_PASSWORD(10003, "用户名或密码为空");
    /**
     * 响应码
     */
    private final Integer code;

    /**
     * 响应信息
     */
    private final String message;

    /**
     * 有参构造
     * @param code  响应码
     * @param message 响应信息
     */
    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
