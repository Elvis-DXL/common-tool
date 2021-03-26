package com.elvis.common.util;

/**
 * @author : Elvis
 * @since : 2021/3/26 10:20
 */
public class NumberUtil {

    private NumberUtil() {
    }

    /**
     * 求源数据中最大值
     *
     * @param numbers 源数据
     * @return 最大值
     */
    public static Long max(Long... numbers) {
        if (numbers.length == 0) {
            return null;
        }
        Long max = numbers[0];
        for (Long number : numbers) {
            max = max > number ? max : number;
        }
        return max;
    }

    /**
     * 求源数据中最大值
     *
     * @param numbers 源数据
     * @return 最大值
     */
    public static Double max(Double... numbers) {
        if (numbers.length == 0) {
            return null;
        }
        Double max = numbers[0];
        for (Double number : numbers) {
            max = max > number ? max : number;
        }
        return max;
    }

    /**
     * 求源数据中最大值
     *
     * @param numbers 源数据
     * @return 最大值
     */
    public static Integer max(Integer... numbers) {
        if (numbers.length == 0) {
            return null;
        }
        Integer max = numbers[0];
        for (Integer number : numbers) {
            max = max > number ? max : number;
        }
        return max;
    }

    /**
     * 求源数据中最小值
     *
     * @param numbers 源数据
     * @return 最小值
     */
    public static Long min(Long... numbers) {
        if (numbers.length == 0) {
            return null;
        }
        Long min = numbers[0];
        for (Long number : numbers) {
            min = min < number ? min : number;
        }
        return min;
    }

    /**
     * 求源数据中最小值
     *
     * @param numbers 源数据
     * @return 最小值
     */
    public static Double min(Double... numbers) {
        if (numbers.length == 0) {
            return null;
        }
        Double min = numbers[0];
        for (Double number : numbers) {
            min = min < number ? min : number;
        }
        return min;
    }

    /**
     * 求源数据中最小值
     *
     * @param numbers 源数据
     * @return 最小值
     */
    public static Integer min(Integer... numbers) {
        if (numbers.length == 0) {
            return null;
        }
        Integer min = numbers[0];
        for (Integer number : numbers) {
            min = min < number ? min : number;
        }
        return min;
    }

}
