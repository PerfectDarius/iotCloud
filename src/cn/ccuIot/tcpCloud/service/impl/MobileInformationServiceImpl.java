package cn.ccuIot.tcpCloud.service.impl;

import cn.ccuIot.tcpCloud.dao.MobileInformationMapper;
import cn.ccuIot.tcpCloud.entity.MobileInformation;
import cn.ccuIot.tcpCloud.service.MobileInformationService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MobileInformationServiceImpl implements MobileInformationService {

   private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");

    @Resource
    MobileInformationMapper mobileInformationMapper;

    @Override
    public void addMobileInformation(String message) {
        MobileInformation mobileInformation = new MobileInformation();
        mobileInformation.setMessage(message);
        String formatTime = simpleDateFormat.format(new Date());
        mobileInformation.setTime(formatTime);
        this.mobileInformationMapper.addMobileInformation(mobileInformation);
    }

}
