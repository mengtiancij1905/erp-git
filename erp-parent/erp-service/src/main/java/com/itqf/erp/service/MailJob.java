package com.itqf.erp.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 飞鸟
 * @date 2019/7/19 - 16:03
 */
public class MailJob {
    @Autowired
    private IStoredetailService storedetailService;

    /**
     * 发送库存报警邮件
     */
    public void sendStoreAlertMail() {
        storedetailService.sendAlertMail();
    }

    public void setStoredetailService(IStoredetailService storedetailService) {
        this.storedetailService = storedetailService;
    }
}
