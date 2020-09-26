package com.shawn.learningalways.base.constant;

/**
 * WeekDayEnum
 * 星期的枚举类
 *
 * @author Shawn Wu
 * @date 2020/5/7 16:24
 * @since v1
 */
public enum WeekDayEnum {

    /**
     * 周一 ~ 周日
     */
    MONDAY(1, "MONDAY", "monday"),
    TUESDAY(2, "TUESDAY", "tuesday"),
    WEDNESDAY(3, "WEDNESDAY", "wednesday"),
    THURSDAY(4, "THURSDAY", "thursday"),
    FRIDAY(5, "FRIDAY", "friday"),
    SATURDAY(6, "SATURDAY", "saturday"),
    SUNDAY(7, "SUNDAY", "sunday");

    /**
     * 星期x的代码
     */
    private Integer code;

    /**
     * 星期x的大写英文
     */
    private String upperCase;

    /**
     * 星期x的小写英文
     */
    private String lowerCase;

    WeekDayEnum(Integer code, String upperCase, String lowerCase) {
        this.code = code;
        this.upperCase = upperCase;
        this.lowerCase = lowerCase;
    }

    public Integer getCode() {
        return code;
    }

    public String getUpperCase() {
        return upperCase;
    }

    public String getLowerCase() {
        return lowerCase;
    }
}
