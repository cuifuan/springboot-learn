package com.github.cuifuan.mp.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.cuifuan.mp.domain.UserInfo;
import com.github.cuifuan.mp.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
 * desc: 用户信息的业务逻辑层
 * date 2023/8/9 14:07
 * @author cuifuan
 **/
@Service
public class UserInfoService extends ServiceImpl<UserInfoMapper, UserInfo> {

}
