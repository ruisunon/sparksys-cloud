package com.sparksys.activiti.interfaces.controller.process;

import com.sparksys.activiti.application.service.act.IProcessHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * description: 历史流程前端控制器
 *
 * @author: zhouxinlei
 * @date: 2020-07-17 16:01:50
 */
@Slf4j
@RestController
@RequestMapping("/process")
@Api(tags = "历史流程管理")
public class ProcessHistoryController {

    private final IProcessHistoryService processHistoryService;

    public ProcessHistoryController(IProcessHistoryService processHistoryService) {
        this.processHistoryService = processHistoryService;
    }

    @ApiOperation("获取流程图并显示")
    @GetMapping("/history/processImg/{processInstanceId}")
    public void getProcessImg(@ApiParam("流程实例id") @PathVariable String processInstanceId, HttpServletResponse response) {
        processHistoryService.getProcessImage(processInstanceId, response);
    }

}
