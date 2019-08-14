package com.enums;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-14 下午4:21
 */
public enum UserUrlEnum {
    /**
     * 新增用户url
     */
    CREATE_USER_URL("001", "https://oapi.dingtalk.com/user/create"),
    DELETE_USER_URL("002", "https://oapi.dingtalk.com/user/delete"),
    GET_USER_URL("003", "https://oapi.dingtalk.com/user/get"),
    UPDATE_USER_URL("004", "https://oapi.dingtalk.com/user/update");

    private String code;
    private String message;

    UserUrlEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static UserUrlEnum getEnum(Integer code) {
        for (UserUrlEnum userUrlEnum : UserUrlEnum.values()) {
            if (userUrlEnum.getCode().equals(code)) {
                return userUrlEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
