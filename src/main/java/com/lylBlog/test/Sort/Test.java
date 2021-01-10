package com.lylBlog.test.Sort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: lyl
 * @Date: 2021/1/7 10:33
 */
public class Test {
    /**
     * 获取两个日期之间的日期，包括开始结束日期
     * @param start 开始日期
     * @param end 结束日期
     * @return 日期集合
     * @throws ParseException
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            if(!sdf1.format(new Date()).equals(sdf1.format(curr.getTime()))){
                result.add(sdf1.format(curr.getTime()));
            }
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(getMonthBetween("2020-01-21", "2021-01-21"));
    }
}
