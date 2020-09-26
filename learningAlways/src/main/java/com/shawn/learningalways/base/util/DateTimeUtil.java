package com.shawn.learningalways.base.util;

import com.shawn.learningalways.base.constant.DateTimeConstant;
import com.shawn.learningalways.base.constant.WeekDayEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * DateTimeUtil
 * 时间处理工具类
 *
 * @author Shawn Wu
 * @date 2019/5/30 13:30
 * @since v1
 */
public class DateTimeUtil {


    private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeUtil.class);

    /**
     * 根据指定格式显示日期和时间
     */
    private static final DateTimeFormatter YYYY_MM_DD_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter YYYY_MM_DD_HH_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
    private static final DateTimeFormatter YYYY_MM_DD_HH_MM_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS_EN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter HH_MM_SS_EN = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter YYYY_MM_DD_CN = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
    private static final DateTimeFormatter YYYY_MM_DD_HH_CN = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时");
    private static final DateTimeFormatter YYYY_MM_DD_HH_MM_CN = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分");
    private static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS_CN = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分ss秒");
    private static final DateTimeFormatter HH_MM_SS_CN = DateTimeFormatter.ofPattern("HH时mm分ss秒");

    /**
     * 本地时间显示格式：区分中文和外文显示
     */
    private static final DateTimeFormatter SHORT_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
    private static final DateTimeFormatter FULL_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
    private static final DateTimeFormatter LONG_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
    private static final DateTimeFormatter MEDIUM_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);

    private DateTimeUtil() {
    }


    /**
     * 获取当前日期
     *
     * @return yyyy-MM-dd的当前日期
     * @date 2020/5/6 11:02
     * @author Shawn Wu
     */
    public static String getNowDateEN() {
        return String.valueOf(LocalDate.now());
    }

    /**
     * 获取当前日期
     *
     * @return yyyy-MM-dd HH:mm:ss格式的当前日期
     * @author Shawn Wu
     */
    public static String getNowTimeEN() {
        return LocalDateTime.now().format(YYYY_MM_DD_HH_MM_SS_EN);
    }

    /**
     * 获取当前时间
     *
     * @return yyyy-MM-dd HH格式的当前时间
     * @date 2020/5/6 11:05
     * @author Shawn Wu
     */
    public static String getNowTimeYmdhEN() {
        return LocalDateTime.now().format(YYYY_MM_DD_HH_EN);
    }

    /**
     * 获取当前时间
     *
     * @return yyyy年MM月dd日hh时格式的当前时间
     * @date 2020/5/6 11:18
     * @author Shawn Wu
     */
    public static String getNowTimeYmdhCN() {
        return LocalDateTime.now().format(YYYY_MM_DD_HH_CN);
    }

    /**
     * 获取当前时间
     *
     * @return yyyy-MM-dd HH:mm格式的当前时间
     * @date 2020/5/6 11:18
     * @author Shawn Wu
     */
    public static String getNowTimeYmdhmEN() {
        return LocalDateTime.now().format(YYYY_MM_DD_HH_MM_EN);
    }

    /**
     * 获取当前时间
     *
     * @return yyyy年MM月dd日HH时mm分格式的当前时间
     * @date 2020/5/6 11:25
     * @author Shawn Wu
     */
    public static String getNowTimeYmdhmCN() {
        return LocalDateTime.now().format(YYYY_MM_DD_HH_MM_CN);
    }

    /**
     * 获取当前时间
     *
     * @return HH时mm分ss秒格式的当前时间
     * @date 2020/5/6 11:26
     * @author Shawn Wu
     */
    public static String getNowTimeHmsCN() {
        return LocalDateTime.now().format(HH_MM_SS_CN);
    }

    /**
     * 根据日期格式，获取当前时间
     *
     * @param formatStr 日期格式<br>
     *        <li>yyyy</li>
     *        <li>yyyy-MM-dd</li>
     *        <li>yyyy-MM-dd HH:mm:ss</li>
     *        <li>HH:mm:ss</li>
     * @return 指定格式的当前时间
     * @author Shawn Wu
     */
    public static String getTime(String formatStr) {
        if(StringUtils.isEmpty(formatStr)){
            return "parameter error";
        }
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(formatStr));
    }

    /**
     * 获取中文的当前日期
     *
     * @return yyyy年mm月dd日
     * @author Shawn Wu
     */
    public static String getNowDateCN() {
        return LocalDate.now().format(YYYY_MM_DD_CN);
    }

    /**
     * 获取中文当前时间
     *
     * @return yyyy年MM月dd日HH时mm分ss秒
     * @author Shawn Wu
     */
    public static String getNowTimeCN() {
        return LocalDateTime.now().format(YYYY_MM_DD_HH_MM_SS_CN);
    }

    /**
     * 简写本地当前日期：yy-M-dd<br>
     * 例如：19-3-30为2019年3月30日
     *
     * @return yy-M-dd格式的当前日期
     * @author Shawn Wu
     */
    public static String getNowLocalTimeShort() {
        return LocalDateTime.now().format(SHORT_DATE);
    }

    /**
     * 根据当地日期显示格式：yyyy年M月dd日 星期x（中国）
     *
     * @return 形如：2019年3月30日 星期六
     * @author Shawn Wu
     */
    public static String getNowLocalTimeFull() {
        return LocalDateTime.now().format(FULL_DATE);
    }

    /**
     * 根据当地显示日期格式：yyyy年M月dd日（中国）
     *
     * @return 形如 2019年3月30日
     * @author Shawn Wu
     */
    public static String getNowLocalTimeLong() {
        return LocalDateTime.now().format(LONG_DATE);
    }

    /**
     * 根据当地显示日期格式：yyyy-M-dd（中国）
     *
     * @return 形如：2019-3-30
     * @author Shawn Wu
     */
    public static String getNowLocalTimeMedium() {
        return LocalDateTime.now().format(MEDIUM_DATE);
    }

    /**
     * 获取当前日期的节点时间（年，月，周，日，时，分，秒）
     *
     * @param node 日期中的节点元素（year，month，week，day，hour，minute，second）
     * @return 节点数字，如创建此方法的时间：年 2019，月 3，日 30，周 6
     * @author Shawn Wu
     */
    public static Integer getNodeTime(String node) {
        LocalDateTime today = LocalDateTime.now();
        Integer resultNode;
        switch (node) {
            case DateTimeConstant.YEAR:
                resultNode = today.getYear();
                break;
            case DateTimeConstant.MONTH:
                resultNode = today.getMonthValue();
                break;
            case DateTimeConstant.WEEK:
                resultNode = transformWeekEN2Num(String.valueOf(today.getDayOfWeek()));
                break;
            case DateTimeConstant.DAY:
                resultNode = today.getDayOfMonth();
                break;
            case DateTimeConstant.HOUR:
                resultNode = today.getHour();
                break;
            case DateTimeConstant.MINUTE:
                resultNode = today.getMinute();
                break;
            case DateTimeConstant.SECOND:
                resultNode = today.getSecond();
                break;
            default:
                // 当前日期是当前年的第几天。例如：2019/1/3是2019年的第三天
                resultNode = today.getDayOfYear();
                break;
        }
        return resultNode;
    }

    /**
     * 将英文星期转换成数字
     *
     * @param enWeek 大写的英文星期
     * @return int，如果数字小于0，则检查，看是否输入错误 or 入参为null
     * @author Shawn Wu
     */
    public static int transformWeekEN2Num(String enWeek) {
        for(WeekDayEnum e:WeekDayEnum.values()){
            if(e.getUpperCase().equals(enWeek)){
                return e.getCode();
            }
        }
        return -1;
    }

    /**
     * 获取与当前日期相距num个之后（之前）的日期<br>
     * <ul>
     * 比如当前时间为：2019-03-30 10:20:30的格式日期
     * <li>node="hour",num=5L:2019-03-30 15:20:30</li>
     * <li>node="day",num=1L:2019-03-31 10:20:30</li>
     * <li>node="year",num=1L:2020-03-30 10:20:30</li>
     * </ul>
     *
     * @param dtf 格式化当前时间格式
     * @param node 节点元素（“year”,"month","week","day","hour","minute","second"）
     * @param num （+：之后，-：之前）
     * @return 之后之前的日期
     * @author Shawn Wu
     */
    public static String getAfterOrPreNowTimePlus(DateTimeFormatter dtf, String node, long num) {
        if(StringUtils.isEmpty(node)){
            return "node is Error!";
        }

        // 当前时间
        LocalDateTime now = LocalDateTime.now();
        // 修改后的时间
        String newTime;

        switch (node){
            case DateTimeConstant.YEAR:
                newTime = now.plusYears(num).format(dtf);
                break;
            case DateTimeConstant.MONTH:
                newTime = now.plusMonths(num).format(dtf);
                break;
            case DateTimeConstant.WEEK:
                newTime = now.plusWeeks(num).format(dtf);
                break;
            case DateTimeConstant.DAY:
                newTime = now.plusDays(num).format(dtf);
                break;
            case DateTimeConstant.HOUR:
                newTime = now.plusHours(num).format(dtf);
                break;
            case DateTimeConstant.MINUTE:
                newTime = now.plusMinutes(num).format(dtf);
                break;
            case DateTimeConstant.SECOND:
                newTime = now.plusSeconds(num).format(dtf);
                break;
            default:
                newTime = "node is Error!";
                break;
        }
        return newTime;
    }

    /**
     * 获取当前日期之后（之后）的节点事件<br>
     * 默认时间格式：yyyy_mm_dd hh:mm:ss
     *
     * @param node 节点元素（“year”,"month","week","day","hour","minute","second"）
     * @param num 第几天（+：之后，-：之前）
     * @return num之后或之后的日期
     * @author Shawn Wu
     */
    public static String getAfterOrPreNowTime(String node, long num) {
        return getAfterOrPreNowTimePlus(YYYY_MM_DD_HH_MM_SS_EN, node, num);
    }

    /**
     * 当前时间的hour，minute，second之后（之前）的时刻
     * 默认格式：hh:mm:ss
     *
     * @param node 时间节点元素（hour，minute，second）
     * @param num 之后（之后）多久时，分，秒（+：之后，-：之前）
     * @return HH:mm:ss 字符串
     * @author Shawn Wu
     */
    public static String getAfterOrPreNowTimeSimp(String node, long num) {
        // 当前时间
        LocalDateTime now = LocalDateTime.now();
        // 修改后的时间
        String newTime;

        switch (node){
            case DateTimeConstant.HOUR:
                newTime = now.plusHours(num).format(HH_MM_SS_EN);
                break;
            case DateTimeConstant.MINUTE:
                newTime = now.plusMinutes(num).format(HH_MM_SS_EN);
                break;
            case DateTimeConstant.SECOND:
                newTime = now.plusSeconds(num).format(HH_MM_SS_EN);
                break;
            default:
                newTime = "node is Error!";
                break;
        }
        return newTime;
    }

    /**
     * 获取当前日期第index日之后(之前)的日期（yyyy-MM-dd）
     *
     * @param index 第index天
     * @return 日期字符串：yyyy-MM-dd
     * @author Shawn Wu
     */
    public static String getAfterOrPreDayDate(int index) {
        return LocalDate.now().plus(index, ChronoUnit.DAYS).format(YYYY_MM_DD_EN);
    }

    /**
     * 获取当前日期第index周之前（之后）的日期（yyyy-MM-dd）
     *
     * @param index 第index周（+：之后，-：之前）
     * @return 日期字符串：yyyy-MM-dd
     * @author Shawn Wu
     */
    public static String getAfterOrPreWeekDate(int index) {
        return LocalDate.now().plus(index, ChronoUnit.WEEKS).format(YYYY_MM_DD_EN);
    }

    /**
     * 获取当前日期第index月之前（之后）的日期（yyyy-MM-dd）
     *
     * @param index 第index月（+：之后，-：之前）
     * @return 日期字符串：yyyy-MM-dd
     * @author Shawn Wu
     */
    public static String getAfterOrPreMonthDate(int index) {
        return LocalDate.now().plus(index, ChronoUnit.MONTHS).format(YYYY_MM_DD_EN);
    }

    /**
     * 获取当前日期第index年之前（之后）的日期（yyyy-MM-dd）
     *
     * @param index 第index年（+：之后，-：之前）
     * @return 日期字符串：yyyy-MM-dd
     * @author Shawn Wu
     */
    public static String getAfterOrPreYearDate(int index) {
        return LocalDate.now().plus(index, ChronoUnit.YEARS).format(YYYY_MM_DD_EN);
    }

    /**
     * 校验时间是否能被转化
     *
     * @param date 指定时间
     * @return true为可以转化，false为不能转化
     * @date 2020/5/7 10:30
     * @author Shawn Wu
     */
    private static boolean validateDateParse(String date){
        if(StringUtils.isEmpty(date)){
            return false;
        }
        try {
            LocalDate.parse(date.trim());
        } catch (Exception e) {
            LOGGER.error("时间转化错误", e);
            return false;
        }
        return true;
    }

    /**
     * 获取指定日期之前之后的第index的日，周，月，年的日期
     *
     * @param date 指定日期，格式：yyyy-MM-dd
     * @param node 时间节点元素（日周月年）
     * @param index 之前之后第index个日期
     * @return yyyy-MM-dd 日期字符串
     * @author Shawn Wu
     */
    public static String getAfterOrPreDate(String date, String node, int index) {
        if(StringUtils.isEmpty(node)){
            return "node is Error!";
        }

        if(!validateDateParse(date)){
            return "Wrong date format!";
        }

        // 修改后的时间
        String newTime;
        date = date.trim();
        switch (node){
            case DateTimeConstant.YEAR:
                newTime = LocalDate.parse(date).plus(index, ChronoUnit.YEARS).format(YYYY_MM_DD_EN);
                break;
            case DateTimeConstant.MONTH:
                newTime = LocalDate.parse(date).plus(index, ChronoUnit.MONTHS).format(YYYY_MM_DD_EN);
                break;
            case DateTimeConstant.WEEK:
                newTime = LocalDate.parse(date).plus(index, ChronoUnit.WEEKS).format(YYYY_MM_DD_EN);
                break;
            case DateTimeConstant.DAY:
                newTime = LocalDate.parse(date).plus(index, ChronoUnit.DAYS).format(YYYY_MM_DD_EN);
                break;
            default:
                newTime = "node is Error!";
                break;
        }
        return newTime;
    }

    /**
     * 检测：输入年份是否是闰年
     *
     * @param date 指定日期，格式：yyyy-MM-dd
     * @return true：闰年，false：平年
     * @author Shawn Wu
     */
    public static boolean isLeapYear(String date) {
        return validateDateParse(date) && LocalDate.parse(date.trim()).isLeapYear();
    }

    /**
     * 计算两个日期字符串之间相差多少个周期（天，月，年）
     *
     * @param date1 yyyy-MM-dd
     * @param date2 yyyy-MM-dd
     * @param node 三者之一:(day，month,year)
     * @return date1-date2，相差多少周期
     * @author Shawn Wu
     */
    public static int periodCount(String date1, String date2, String node) {
        if(!validateDateParse(date1) || !validateDateParse(date2) || StringUtils.isEmpty(node)){
            return 0;
        }

        // 相差的周期数
        int between;
        switch (node){
            case DateTimeConstant.YEAR:
                between = Period.between(LocalDate.parse(date2), LocalDate.parse(date1)).getYears();
                break;
            case DateTimeConstant.MONTH:
                Period period = Period.between(LocalDate.parse(date2), LocalDate.parse(date1));
                between = period.getYears() * 12 + period.getMonths();
                break;
            case DateTimeConstant.DAY:
                between = (int) (LocalDate.parse(date1).toEpochDay() - LocalDate.parse(date2).toEpochDay());
                break;
            default:
                between = 0;
                break;
        }
        return between;
    }

    /**
     * 切割日期。按照周期切割成小段日期段。
     * 例如： <br>
     * <li>startDate="2019-02-28",endDate="2019-03-05",period="day"</li>
     * <li>结果为：[2019-02-28, 2019-03-01, 2019-03-02, 2019-03-03, 2019-03-04, 2019-03-05]</li>
     * <br>
     * <li>startDate="2019-02-28",endDate="2019-03-25",period="week"</li>
     * <li>结果为：[2019-02-28,2019-03-06, 2019-03-07,2019-03-13, 2019-03-14,2019-03-20, 2019-03-21,2019-03-25]</li>
     * <br>
     * <li>startDate="2019-02-28",endDate="2019-05-25",period="month"</li>
     * <li>结果为：[2019-02-28,2019-02-28, 2019-03-01,2019-03-31, 2019-04-01,2019-04-30,2019-05-01,2019-05-25]</li>
     * <br>
     * <li>startDate="2019-02-28",endDate="2020-05-25",period="year"</li>
     * <li>结果为：[2019-02-28,2019-12-31, 2020-01-01,2020-05-25]</li>
     * <br>
     *
     * @param startDate 开始日期（yyyy-MM-dd）
     * @param endDate 结束日期（yyyy-MM-dd）
     * @param period 周期（天，7天，月，年）
     * @return 切割之后的日期集合
     * @author Shawn Wu
     */
    public static List<String> getPieDateRange(String startDate, String endDate, String period) {
        List<String> result = new ArrayList<>();
        if(!validateDateParse(startDate) || !validateDateParse(endDate) || StringUtils.isEmpty(period)){
            return result;
        }

        LocalDate end = LocalDate.parse(endDate, YYYY_MM_DD_EN);
        LocalDate start = LocalDate.parse(startDate, YYYY_MM_DD_EN);
        LocalDate tmp = start;
        switch (period) {
            case DateTimeConstant.DAY:
                while (start.isBefore(end) || start.isEqual(end)) {
                    result.add(start.toString());
                    start = start.plusDays(1);
                }
                break;
            case DateTimeConstant.WEEK:
                // 7天一个周期
                while (tmp.isBefore(end) || tmp.isEqual(end)) {
                    if (tmp.plusDays(6).isAfter(end)) {
                        result.add(tmp.toString() + "," + end);
                    } else {
                        result.add(tmp.toString() + "," + tmp.plusDays(6));
                    }
                    tmp = tmp.plusDays(7);
                }
                break;
            case DateTimeConstant.MONTH:
                while (tmp.isBefore(end) || tmp.isEqual(end)) {
                    LocalDate lastDayOfMonth = tmp.with(TemporalAdjusters.lastDayOfMonth());
                    if (lastDayOfMonth.isAfter(end)) {
                        result.add(tmp.toString() + "," + end);
                    } else {
                        result.add(tmp.toString() + "," + lastDayOfMonth);
                    }
                    tmp = lastDayOfMonth.plusDays(1);
                }
                break;
            case DateTimeConstant.YEAR:
                while (tmp.isBefore(end) || tmp.isEqual(end)) {
                    LocalDate lastDayOfYear = tmp.with(TemporalAdjusters.lastDayOfYear());
                    if (lastDayOfYear.isAfter(end)) {
                        result.add(tmp.toString() + "," + end);
                    } else {
                        result.add(tmp.toString() + "," + lastDayOfYear);
                    }
                    tmp = lastDayOfYear.plusDays(1);
                }
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 指定日期在一个月的第一天或最后一天（yyyy-MM-dd）
     *
     * @param curDate 指定日期，格式：yyyy-MM-dd
     * @param firstOrLast true：第一天，false：最后一天
     * @return yyyy-MM-dd
     * @author Shawn Wu
     */
    public static String getFirstOrLastDayOfMonth(String curDate, boolean firstOrLast) {
        if(!validateDateParse(curDate)){
            return "Wrong date format!";
        }
        if (firstOrLast) {
            return LocalDate.parse(curDate, YYYY_MM_DD_EN).with(TemporalAdjusters.firstDayOfMonth()).toString();
        } else {
            return LocalDate.parse(curDate, YYYY_MM_DD_EN).with(TemporalAdjusters.lastDayOfMonth()).toString();
        }
    }

    /**
     * 指定日期在一年的第一天或最后一天（yyyy-MM-dd）
     *
     * @param curDate 指定日期（格式：yyyy-MM-dd）
     * @param firstOrLast true:第一天，false:最后一天
     * @return yyyy-MM-dd
     * @author Shawn Wu
     */
    public static String getFirstOrLastDayOfYear(String curDate, boolean firstOrLast) {
        if(!validateDateParse(curDate)){
            return "Wrong date format!";
        }
        if (firstOrLast) {
            return LocalDate.parse(curDate, YYYY_MM_DD_EN).with(TemporalAdjusters.firstDayOfYear()).toString();
        } else {
            return LocalDate.parse(curDate, YYYY_MM_DD_EN).with(TemporalAdjusters.lastDayOfYear()).toString();
        }
    }

    /**
     * 获取指定日期的下一个周x的日期
     * 例如： <br>
     * <li>curDay="2020-05-07"（周四）,dayOfWeek=1,isContainCurDay=true</li>
     * <li>结果为：2020-05-11</li>
     * <br>
     * <li>curDay="2020-05-07",dayOfWeek=1,isContainCurDay=false</li>
     * <li>结果为：2020-05-11</li>
     * <br>
     * <li>curDay="2020-05-07",dayOfWeek=4,isContainCurDay=true</li>
     * <li>结果为：2020-05-07</li>
     * <br>
     * <li>curDay="2020-05-07",dayOfWeek=4,isContainCurDay=false</li>
     * <li>结果为：2020-05-14</li>
     * <br>
     *
     * @param curDay 指定日期，格式：yyyy-MM-dd
     * @param dayOfWeek monday:1 ~ sunday:7
     * @param isContainCurDay 是否包含当天，true：是，false：不包含
     * @return 日期（yyyy-MM-dd）
     * @author Shawn Wu
     */
    public static String getNextWeekDate(String curDay, int dayOfWeek, boolean isContainCurDay) {
        if(!validateDateParse(curDay)){
            return "Wrong date format!";
        }
        dayOfWeek = dayOfWeek < 1 || dayOfWeek > 7 ? 1 : dayOfWeek;
        if (isContainCurDay) {
            return LocalDate.parse(curDay).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(dayOfWeek))).toString();
        } else {
            return LocalDate.parse(curDay).with(TemporalAdjusters.next(DayOfWeek.of(dayOfWeek))).toString();
        }
    }

    /**
     * 获取指定日期的上一个周x的日期
     * 例如： <br>
     * <li>curDay="2020-05-07"（周四）,dayOfWeek=1,isContainCurDay=true</li>
     * <li>结果为：2020-05-04</li>
     * <br>
     * <li>curDay="2020-05-07",dayOfWeek=1,isContainCurDay=false</li>
     * <li>结果为：2020-05-04</li>
     * <br>
     * <li>curDay="2020-05-07",dayOfWeek=4,isContainCurDay=true</li>
     * <li>结果为：2020-05-07</li>
     * <br>
     * <li>curDay="2020-05-07",dayOfWeek=4,isContainCurDay=false</li>
     * <li>结果为：2020-04-30</li>
     * <br>
     *
     * @param curDay 指定日期（yyyy-MM-dd）
     * @param dayOfWeek 数字范围（monday:1~sunday:7）
     * @param isCurDay 是否包含当天，true：是，false：不包含
     * @return 日期（yyyy-MM-dd）
     * @author Shawn Wu
     */
    public static String getPreWeekDate(String curDay, int dayOfWeek, boolean isCurDay) {
        if(!validateDateParse(curDay)){
            return "Wrong date format!";
        }
        dayOfWeek = dayOfWeek < 1 || dayOfWeek > 7 ? 1 : dayOfWeek;
        if (isCurDay) {
            return LocalDate.parse(curDay).with(TemporalAdjusters.previousOrSame(DayOfWeek.of(dayOfWeek))).toString();
        } else {
            return LocalDate.parse(curDay).with(TemporalAdjusters.previous(DayOfWeek.of(dayOfWeek))).toString();
        }
    }

    /**
     * 获取指定日期当月的最后或第一个星期x的日期
     *
     * @param curDay 指定日期（yyyy-MM-dd）
     * @param dayOfWeek 周几（1~7）
     * @param lastOrFirst true：最后一个，false本月第一个
     * @return 日期（yyyy-MM-dd）
     * @author Shawn Wu
     */
    public static String getFirstOrLastWeekDate(String curDay, int dayOfWeek, boolean lastOrFirst) {
        if(!validateDateParse(curDay)){
            return "Wrong date format!";
        }
        dayOfWeek = dayOfWeek < 1 || dayOfWeek > 7 ? 1 : dayOfWeek;
        if (lastOrFirst) {
            return LocalDate.parse(curDay).with(TemporalAdjusters.lastInMonth(DayOfWeek.of(dayOfWeek))).toString();
        } else {
            return LocalDate.parse(curDay).with(TemporalAdjusters.firstInMonth(DayOfWeek.of(dayOfWeek))).toString();
        }
    }

}