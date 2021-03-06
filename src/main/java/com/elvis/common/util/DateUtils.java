package com.elvis.common.util;

import com.elvis.common.pojo.Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author : Elvis
 * @since : 2020/6/18 15:33
 */
public class DateUtils {

    private DateUtils() {
    }

    /**
     * yyyy-MM-dd
     */
    public static int yyyy_MM_dd = 0;
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static int yyyy_MM_dd_HH_mm_ss = 1;
    /**
     * HH:mm:ss
     */
    public static int HH_mm_ss = 2;
    /**
     * yyyyMMddHHmmss
     */
    public static int yyyyMMddHHmmss = 3;
    /**
     * yyyyMMddHHmmssSS
     */
    public static int yyyyMMddHHmmssSSS = 4;
    /**
     * yyyy年MM月dd日
     */
    public static int c_yyyy_MM_dd = 5;
    /**
     * yyyy年MM月dd日HH时mm分ss秒
     */
    public static int c_yyyy_MM_dd_HH_mm_ss = 6;
    /**
     * yyyy
     */
    public static int yyyy = 7;
    /**
     * MM
     */
    public static int MM = 8;
    /**
     * dd
     */
    public static int dd = 9;
    /**
     * yyyyMMdd
     */
    public static int yyyyMMdd = 10;
    /**
     * yyyy-MM
     */
    public static int yyyy_MM = 11;
    /**
     * yyyy年MM月dd日 EE
     */
    public static int c_yyyy_MM_dd_EE = 12;
    /**
     * yyyy/MM/dd HH:mm:ss
     */
    public static int x_yyyy_MM_dd_HH_mm_ss = 13;
    /**
     * HHmmss
     */
    public static int HHmmss = 14;
    /**
     * HHmmssSS
     */
    public static int HHmmssSSS = 15;
    /**
     * yyyy-MM-dd HH:mm
     */
    public static int yyyy_MM_dd_HH_mm = 16;
    /**
     * yyyy年MM月dd日HH时mm分
     */
    public static int c_yyyy_MM_dd_HH_mm = 17;
    /**
     * yyyyMM
     */
    public static int yyyyMM = 18;

    private final static String[] DAY_NAMES = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    /**
     * 格式化日期样式
     *
     * @param caseNum 样式常量
     * @return 格式工厂
     */
    public static SimpleDateFormat sdf(int caseNum) {
        SimpleDateFormat sdf = null;
        switch (caseNum) {
            case 0:
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case 1:
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                break;
            case 2:
                sdf = new SimpleDateFormat("HH:mm:ss");
                break;
            case 3:
                sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                break;
            case 4:
                sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                break;
            case 5:
                sdf = new SimpleDateFormat("yyyy年MM月dd日");
                break;
            case 6:
                sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
                break;
            case 7:
                sdf = new SimpleDateFormat("yyyy");
                break;
            case 8:
                sdf = new SimpleDateFormat("MM");
                break;
            case 9:
                sdf = new SimpleDateFormat("dd");
                break;
            case 10:
                sdf = new SimpleDateFormat("yyyyMMdd");
                break;
            case 11:
                sdf = new SimpleDateFormat("yyyy-MM");
                break;
            case 12:
                sdf = new SimpleDateFormat("yyyy年MM月dd日 EE");
                break;
            case 13:
                sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                break;
            case 14:
                sdf = new SimpleDateFormat("HHmmss");
                break;
            case 15:
                sdf = new SimpleDateFormat("HHmmssSSS");
                break;
            case 16:
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                break;
            case 17:
                sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
                break;
            case 18:
                sdf = new SimpleDateFormat("yyyyMM");
                break;
            default:
                break;
        }
        return sdf;
    }

    /**
     * 给指定时间加上指定的时间
     * （未传入时间时默认以当前时间为计算基础）
     *
     * @param date         待计算的时间
     * @param calendarType 时间类型
     * @param num          时间长度
     * @return 计算之后的时间
     */
    public static Date addDate(Date date, int calendarType, int num) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendarType, num);
        return calendar.getTime();
    }

    /**
     * 给指定时间加上指定的时间
     *
     * @param dateStr       时间字符串
     * @param formatCaseNum 时间字符串形式
     * @param calendarType  时间类型
     * @param num           时间长度
     * @return 计算之后的时间字符串
     */
    public static String addDate(String dateStr, int formatCaseNum, int calendarType, int num) {
        SimpleDateFormat sdf = null;
        Calendar calendar = Calendar.getInstance();
        try {
            sdf = sdf(formatCaseNum);
            calendar.setTime(sdf.parse(dateStr));
            calendar.add(calendarType, num);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取日期指定日历属性
     *
     * @param date         目标时间
     * @param calendarType 日历属性
     * @return 属性值
     */
    public static int get(Date date, int calendarType) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(calendarType);
    }

    /**
     * 格式化时间为指定格式字符串
     *
     * @param date    时间
     * @param caseNum 时间格式
     * @return 时间字符串
     */
    public static String formatDate(Date date, int caseNum) {
        return sdf(caseNum).format(date);
    }

    /**
     * 格式化时间为指定格式字符串
     *
     * @param date    时间
     * @param pattern 格式
     * @return 时间字符串
     */
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 解析时间字符串为时间
     *
     * @param dateStr 时间字符串
     * @param caseNum 时间格式
     * @return 解析结果
     */
    public static Date parseDate(String dateStr, int caseNum) {
        return parseDate(dateStr, sdf(caseNum));
    }

    /**
     * 解析时间字符串为时间
     *
     * @param dateStr 时间字符串
     * @param pattern 时间格式
     * @return 解析结果
     */
    public static Date parseDate(String dateStr, String pattern) {
        return parseDate(dateStr, new SimpleDateFormat(pattern));
    }

    /**
     * 解析
     *
     * @param dateStr 时间字符串
     * @param sdf     解析类
     * @return 解析结果
     */
    private static Date parseDate(String dateStr, SimpleDateFormat sdf) {
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当前时间的字符串形式
     *
     * @param caseNum 需要的时间格式
     * @return 当前时间字符串
     */
    public static String nowDateStr(int caseNum) {
        return sdf(caseNum).format(new Date());
    }

    /**
     * 日期转日历对象（默认是当前时间）
     *
     * @param date 日期
     * @return 日历对象
     */
    public static Calendar dateToCalendar(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 通过日期获取当月天数
     *
     * @param date 日期
     * @return 当月天数
     */
    public static int monthDaysByDate(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 时间对应的星期名称
     *
     * @param date 目标时间
     * @return 星期名称
     */
    public static String dateWeekName(Date date) {
        if (null == date) {
            date = new Date();
        }
        return DAY_NAMES[dateToCalendar(date).get(Calendar.DAY_OF_WEEK) - 1];
    }

    /**
     * 时间当天的开始时间
     *
     * @param date 目标时间
     * @return 时间当天的开始时间
     */
    public static Date dateStartTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 时间当天的结束时间
     *
     * @param date 目标时间
     * @return 时间当天的结束时间
     */
    public static Date dateEndTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 时间当天的开始结束时间
     *
     * @param date 目标时间
     * @return 时间当天的开始结束时间
     */
    public static Time dateStartEndTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Time result = new Time();
        Calendar calendar = dateToCalendar(date);
        result.setStartTime(dateStartTime(calendar.getTime()));
        result.setEndTime(dateEndTime(calendar.getTime()));
        return result;
    }

    /**
     * 时间上一周的开始结束时间
     *
     * @param date 目标时间
     * @return 时间上一周的开始结束时间
     */
    public static Time dateUpWeekTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (1 == dayOfWeek) {
            dayOfWeek = 8;
        }
        Time result = new Time();
        calendar.add(Calendar.DATE, -(dayOfWeek - 2) - 1);
        result.setEndTime(dateEndTime(calendar.getTime()));
        calendar.add(Calendar.DATE, -6);
        result.setStartTime(dateStartTime(calendar.getTime()));
        return result;
    }

    /**
     * 时间本周的开始结束时间
     *
     * @param date 目标时间
     * @return 时间本周的开始结束时间
     */
    public static Time dateCurrWeekTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (1 == dayOfWeek) {
            dayOfWeek = 8;
        }
        Time result = new Time();
        calendar.add(Calendar.DATE, -(dayOfWeek - 2));
        result.setStartTime(dateStartTime(calendar.getTime()));
        calendar.add(Calendar.DATE, 6);
        result.setEndTime(dateEndTime(calendar.getTime()));
        return result;
    }

    /**
     * 时间当月的开始时间
     *
     * @param date 目标时间
     * @return 时间当月的开始时间
     */
    public static Date dateCurrMonthStartTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        calendar.set(Calendar.DATE, 1);
        return dateStartTime(calendar.getTime());
    }

    /**
     * 时间当月的结束时间
     *
     * @param date 目标时间
     * @return 时间当月的结束时间
     */
    public static Date dateCurrMonthEndTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        calendar.set(Calendar.DATE, monthDaysByDate(date));
        return dateEndTime(calendar.getTime());
    }

    /**
     * 时间当月的开始结束时间
     *
     * @param date 目标时间
     * @return 时间当月的开始结束时间
     */
    public static Time dateCurrMonthStartEndTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Time result = new Time();
        result.setStartTime(dateCurrMonthStartTime(date));
        result.setEndTime(dateCurrMonthEndTime(date));
        return result;
    }

    /**
     * 时间当年的开始时间
     *
     * @param date 目标时间
     * @return 时间当月的开始时间
     */
    public static Date dateCurrYearStartTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 1);
        return dateStartTime(calendar.getTime());
    }

    /**
     * 时间当年的结束时间
     *
     * @param date 目标时间
     * @return 时间当月的结束时间
     */
    public static Date dateCurrYearEndTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DATE, 31);
        return dateEndTime(calendar.getTime());
    }

    /**
     * 时间当年的开始结束时间
     *
     * @param date 目标时间
     * @return 时间当月的开始结束时间
     */
    public static Time dateCurrYearStartEndTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Time result = new Time();
        result.setStartTime(dateCurrYearStartTime(date));
        result.setEndTime(dateCurrYearEndTime(date));
        return result;
    }

    /**
     * 时间上月的开始时间
     *
     * @param date 目标时间
     * @return 时间上月的开始时间
     */
    public static Date dateUpMonthStartTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        calendar.add(Calendar.MONTH, -1);
        return dateCurrMonthStartTime(calendar.getTime());
    }

    /**
     * 时间上月的结束时间
     *
     * @param date 目标时间
     * @return 时间上月的结束时间
     */
    public static Date dateUpMonthEndTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        calendar.add(Calendar.MONTH, -1);
        return dateCurrMonthEndTime(calendar.getTime());
    }

    /**
     * 时间上月的开始结束时间
     *
     * @param date 目标时间
     * @return 时间上月的开始结束时间
     */
    public static Time dateUpMonthStartEndTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        calendar.add(Calendar.MONTH, -1);
        Time result = new Time();
        result.setStartTime(dateCurrMonthStartTime(calendar.getTime()));
        result.setEndTime(dateCurrMonthEndTime(calendar.getTime()));
        return result;
    }

    /**
     * 时间上年的开始时间
     *
     * @param date 目标时间
     * @return 时间上年的开始时间
     */
    public static Date dateUpYearStartTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        calendar.add(Calendar.YEAR, -1);
        return dateCurrYearStartTime(calendar.getTime());
    }

    /**
     * 时间上年的结束时间
     *
     * @param date 目标时间
     * @return 时间上年的结束时间
     */
    public static Date dateUpYearEndTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        calendar.add(Calendar.YEAR, -1);
        return dateCurrYearEndTime(calendar.getTime());
    }

    /**
     * 时间上年的开始结束时间
     *
     * @param date 目标时间
     * @return 时间上年的开始结束时间
     */
    public static Time dateUpYearStartEndTime(Date date) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        calendar.add(Calendar.YEAR, -1);
        Time result = new Time();
        result.setStartTime(dateCurrYearStartTime(calendar.getTime()));
        result.setEndTime(dateCurrYearEndTime(calendar.getTime()));
        return result;
    }

    /**
     * 时间前指定数量天的开始结束时间
     *
     * @param date      目标时间
     * @param num       指定数量
     * @param isConCurr 是否包含当前天
     * @return 时间前指定数量天的开始结束时间
     */
    public static Time dateUpManyDayTime(Date date, int num, boolean isConCurr) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        if (!isConCurr) {
            calendar.add(Calendar.DATE, -1);
        }
        Time result = new Time();
        result.setEndTime(dateEndTime(calendar.getTime()));
        calendar.add(Calendar.DATE, -(num - 1));
        result.setStartTime(dateStartTime(calendar.getTime()));
        return result;
    }

    /**
     * 时间前指定数量周的开始结束时间
     *
     * @param date 目标时间
     * @param num  指定数量
     * @return 时间前指定数量周的开始结束时间
     */
    public static Time dateUpManyWeekTime(Date date, int num) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (1 == dayOfWeek) {
            dayOfWeek = 8;
        }
        Time result = new Time();
        calendar.add(Calendar.DATE, -(dayOfWeek - 2) - 1);
        result.setEndTime(dateEndTime(calendar.getTime()));
        calendar.add(Calendar.DATE, -(7 * num) + 1);
        result.setStartTime(dateStartTime(calendar.getTime()));
        return result;
    }

    /**
     * 时间前指定数量月的开始结束时间
     *
     * @param date      目标时间
     * @param num       指定数量
     * @param isConCurr 是否包含当前月
     * @return 时间前指定数量月的开始结束时间
     */
    public static Time dateUpManyMonthTime(Date date, int num, boolean isConCurr) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        if (!isConCurr) {
            calendar.add(Calendar.MONTH, -1);
        }
        Time result = new Time();
        result.setEndTime(dateCurrMonthEndTime(calendar.getTime()));
        calendar.add(Calendar.MONTH, -(num - 1));
        result.setStartTime(dateCurrMonthStartTime(calendar.getTime()));
        return result;
    }

    /**
     * 时间前指定数量年的开始结束时间
     *
     * @param date      目标时间
     * @param num       指定数量
     * @param isConCurr 是否包含当前年
     * @return 时间前指定数量年的开始结束时间
     */
    public static Time dateUpManyYearTime(Date date, int num, boolean isConCurr) {
        if (null == date) {
            date = new Date();
        }
        Calendar calendar = dateToCalendar(date);
        if (!isConCurr) {
            calendar.add(Calendar.YEAR, -1);
        }
        Time result = new Time();
        result.setEndTime(dateCurrYearEndTime(calendar.getTime()));
        calendar.add(Calendar.YEAR, -(num - 1));
        result.setStartTime(dateCurrYearStartTime(calendar.getTime()));
        return result;
    }

    /**
     * 计算时间之间的天数，包含开始和结束当天
     *
     * @param time 时间区间
     * @return 天数
     */
    public static int countDaysByTime(Time time) {
        if (null == time || null == time.getStartTime() || null == time.getEndTime()
                || time.getStartTime().after(time.getEndTime())) {
            return 0;
        }
        Date startTime = dateStartTime(time.getStartTime());
        Date endTime = dateStartTime(addDate(time.getEndTime(), Calendar.DATE, 1));
        long countDays = (endTime.getTime() - startTime.getTime()) / 1000 / 3600 / 24;
        return (int) countDays;
    }

    /**
     * 获取两个时间之间的年月字符串集合
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param caseNum   需要的时间格式
     * @return 字符串集合
     */
    public static List<String> yearMonthStr(Date startTime, Date endTime, int caseNum) {
        if (null == startTime || null == endTime) {
            return new ArrayList<>();
        }
        if (startTime.after(endTime)) {
            Date temp = startTime;
            startTime = endTime;
            endTime = temp;
        }
        Calendar min = dateToCalendar(dateCurrMonthStartTime(startTime));
        Calendar max = dateToCalendar(dateCurrMonthEndTime(endTime));
        ArrayList<String> result = new ArrayList<>();
        while (min.getTime().getTime() <= max.getTime().getTime()) {
            result.add(formatDate(min.getTime(), caseNum));
            min.add(Calendar.MONTH, 1);
        }
        return result;
    }

    /**
     * 获取两个时间之间的年月字符串集合
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param pattern   需要的时间格式
     * @return 字符串集合
     */
    public static List<String> yearMonthStr(Date startTime, Date endTime, String pattern) {
        if (null == startTime || null == endTime) {
            return new ArrayList<>();
        }
        if (startTime.after(endTime)) {
            Date temp = startTime;
            startTime = endTime;
            endTime = temp;
        }
        Calendar max = dateToCalendar(dateCurrMonthEndTime(endTime));
        Calendar min = dateToCalendar(dateCurrMonthStartTime(startTime));
        ArrayList<String> result = new ArrayList<>();
        while (min.getTime().getTime() <= max.getTime().getTime()) {
            result.add(formatDate(min.getTime(), pattern));
            min.add(Calendar.MONTH, 1);
        }
        return result;
    }
}
