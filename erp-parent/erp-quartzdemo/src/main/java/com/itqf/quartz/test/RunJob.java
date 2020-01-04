package com.itqf.quartz.test;

import com.itqf.quartz.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author 飞鸟
 * @date 2019/7/19 - 14:31
 */
public class RunJob {
    public static void main(String[] args) throws SchedulerException {
        // Job  具体任务
        // JobDetail 任务的说明
        // Trigger  定义任务的执行频率
        // Scheduler 掉调度任务
        //1.创建具体任务对象：JobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob").build();

        //2.定义触发器：Trigger
        //SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity("simpleTriggler").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();

        //通过定义Cron表达式方式实现定时调用
        String cron = "0 0 12,14 * * ?";
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("cronTrigger").withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();

        //3.创建调度容器:Scheduler
        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();
    }
}
