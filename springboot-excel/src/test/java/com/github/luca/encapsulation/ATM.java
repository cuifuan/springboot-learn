//package com.github.luca.encapsulation;
//
//import java.math.BigDecimal;
//
//class ATM {
//    private BigDecimal 剩余金额;
//
//    private boolean 身份验证(Object 提款卡, String 密码) {
//        // 验证逻辑
//        // 通过 返回 true
//    }
//
//    private void 吐钞() {
//        // 哒哒哒哒哒哒
//    }
//
//    public void 提款(Object 提款卡, String 密码) {
//        if (身份验证(提款卡, 密码) == true)
//            吐钞();
//    }
//
//    public BigDecimal 查询余额(Object 提款卡, String 密码) {
//        // 查询数据库余额 0
//        if (身份验证(提款卡, 密码) == true)
//            return 剩余金额;
//        else
//            return BigDecimal.ZERO;
//    }
//}
