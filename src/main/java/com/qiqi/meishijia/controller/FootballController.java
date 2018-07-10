package com.qiqi.meishijia.controller;

import com.qiqi.meishijia.core.Result;
import com.qiqi.meishijia.core.ResultEnum;
import com.qiqi.meishijia.core.ResultGenerator;
import com.qiqi.meishijia.service.FootballService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/football")
public class FootballController {

    @Resource
    private FootballService footballService;

    @GetMapping("/ranking")
    public Result getRanking(@RequestParam Integer type){
        if(StringUtils.isEmpty(type)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        return ResultGenerator.genSuccessResult(footballService.getRanking(type));
    }

    @GetMapping("/team")
    public Result getTeam(@RequestParam(name = "team_id") Integer teamId){
        if(StringUtils.isEmpty(teamId)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        return ResultGenerator.genSuccessResult(footballService.getTeam(teamId));
    }
}
