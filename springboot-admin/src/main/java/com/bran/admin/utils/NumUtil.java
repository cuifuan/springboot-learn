package com.bran.admin.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Objects;

public class NumUtil {

    /**
     * 获取百分比
     */
    public static String getPercentage(Double v1, Double v2) {

        if (Objects.isNull(v1) || Objects.isNull(v2)) {
            return null;
        }

        Double res;
        if (v1.compareTo(0.0) == 0) {
            res = v1;
        } else if (v2.compareTo(0.0) == 0) {
            res = 1.0;
        } else {
            res = BigDecimal.valueOf(v1).divide(BigDecimal.valueOf(v2), RoundingMode.HALF_UP).doubleValue();
        }

        DecimalFormat df1 = new DecimalFormat("0.00%");    //##.00%   百分比格式，后面不足2位的用0补
        return df1.format(res);
    }
}
