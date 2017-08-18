package com.github.greengerong.config;

import org.quartz.JobDetail;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import static org.quartz.SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW;
import static org.quartz.SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT;
import static org.quartz.SimpleTrigger.REPEAT_INDEFINITELY;

/******************************************
 *                                        *
 * Auth: green gerong                     *
 * Date: 2017                             *
 * blog: http://greengerong.github.io/    *
 * github: https://github.com/greengerong *
 *                                        *
 ******************************************/
public final class QuartzUtils {

    public static final String JOB_GROUP = "com.github.greengerong";
    public static final int START_DELAY = 1000;

    private QuartzUtils() {

    }

    public static SimpleTriggerFactoryBean createTrigger(JobDetail jobDetail, long frequency) {
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(START_DELAY);
        factoryBean.setRepeatInterval(frequency);
        factoryBean.setRepeatCount(REPEAT_INDEFINITELY);
        factoryBean.setMisfireInstruction(MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT);
        return factoryBean;
    }

    public static CronTriggerFactoryBean createCronTrigger(String name, JobDetail jobDetail, String cronExpression) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(START_DELAY);
        factoryBean.setName(name);
        factoryBean.setCronExpression(cronExpression);
        factoryBean.setGroup(JOB_GROUP);
        factoryBean.setMisfireInstruction(MISFIRE_INSTRUCTION_FIRE_NOW);
        return factoryBean;
    }

    public static JobDetailFactoryBean createJobDetail(Class jobClass, String name, String description) {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(jobClass);
        factoryBean.setName(name);
        factoryBean.setDescription(description);
//        factoryBean.setDurability(true);
        return factoryBean;
    }
}
