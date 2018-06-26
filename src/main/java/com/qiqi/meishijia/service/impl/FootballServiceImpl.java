package com.qiqi.meishijia.service.impl;

import com.qiqi.meishijia.mapper.FootballRankingCustomMapper;
import com.qiqi.meishijia.pojo.FootballRankingCustom;
import com.qiqi.meishijia.service.FootballService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FootballServiceImpl implements FootballService {

    @Resource
    private FootballRankingCustomMapper footballRankingCustomMapper;

    @Override
//    @Cacheable(cacheNames = "football.service.getRanking")
    public List<FootballRankingCustom> getRanking(Integer leagueId) {
        return footballRankingCustomMapper.queryRankingByLeagueId(leagueId);
    }
}
