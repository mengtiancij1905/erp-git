package com.itqf.erp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itqf.erp.mapper.StoredetailMapper;
import com.itqf.erp.pojo.EasyUIDataGrid;
import com.itqf.erp.pojo.ErpResult;
import com.itqf.erp.pojo.Storedetail;
import com.itqf.erp.pojo.StoredetailExample;
import com.itqf.erp.service.IStoredetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 飞鸟
 * @date 2019/7/18 - 10:39
 */
@Service
public class StoredetailServiceImpl implements IStoredetailService {
    @Autowired
    private StoredetailMapper storedetailMapper;
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.from}")//SpEL
    private String from;

    @Value("${mail.to}")
    private String to;

    @Value("${mail.subject}")
    private String subject;

    @Value("${mail.content}")
    private String content;

    @Override
    public EasyUIDataGrid<Storedetail> search(Storedetail storedetail, int page, int rows) {
        PageHelper.startPage(page, rows);

        StoredetailExample example = new StoredetailExample();
        StoredetailExample.Criteria criteria = example.createCriteria();
        if (storedetail != null) {
            if (storedetail.getGoodsuuid() != null) {//设置商品编号
                criteria.andGoodsuuidEqualTo(storedetail.getGoodsuuid());
            }

            if (storedetail.getStoreuuid() != null) {//设置库存编号
                criteria.andStoreuuidEqualTo(storedetail.getStoreuuid());
            }
        }
        List<Storedetail> storedetails = storedetailMapper.selectByExample(example);

        PageInfo<Storedetail> pageInfo = new PageInfo<>(storedetails);
        EasyUIDataGrid<Storedetail> dataGrid = new EasyUIDataGrid<>();
        dataGrid.setRows(storedetails);
        dataGrid.setTotal(pageInfo.getTotal());

        return dataGrid;
    }

    @Override
    public EasyUIDataGrid<Map> storeAlertList() {
        EasyUIDataGrid<Map> dataGrid = new EasyUIDataGrid<>();
        List<Map> list = storedetailMapper.storeAlertList();
        dataGrid.setRows(list);
        dataGrid.setTotal(list.size());
        return dataGrid;
    }

    @Override
    public ErpResult sendAlertMail() {
        //创建邮件
        MimeMessage mime = javaMailSender.createMimeMessage();
        //邮件包装工具
        MimeMessageHelper helper = new MimeMessageHelper(mime);

        try {
            //发件人
            helper.setFrom(from);
            //收件人
            helper.setTo(to);
            //主题
            //将subject中定义的time替换成具体的时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time =  sdf.format(new Date());
            subject= subject.replace("time", time);
            helper.setSubject(subject);
            //内容
            //1.获取预警的商品数量
            List<Map> list = storedetailMapper.storeAlertList();

            content = content.replace("count",list.size()+"");

            helper.setText(content);
            javaMailSender.send(mime);
            return ErpResult.ok("邮件发送成功!");

        } catch (MessagingException e) {
            e.printStackTrace();
            return ErpResult.notOk("邮件发送错误！");
        }
    }
}
