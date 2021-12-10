package com.example.task;

import com.example.service.TesterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author wanglongfei
 * @date 2021/12/3 9:09
 * @description 定时任务，每个小时清除出无效测试者
 */
@Component
@Slf4j
public class ScheduleTask {
    @Autowired
    private TesterService testerService;;
    @Scheduled(fixedRate = 1000*60*60)
    public void deleteNoResult(){
        //删除无用的测试者：没有测试结果并且离测试开始时间超过1小时的
        log.debug("删除无用的测试者：没有测试结果并且离测试开始时间超过1小时的" +new Date());
        // delete from tbl_tester where id not in (select tester_id from tbl_test_result) and TIME_TO_SEC(timediff(now(),create_time))>3600;
        testerService.deleteNoResult();
    }
}
