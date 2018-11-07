package com.qiqi.msjfootball.service.impl;

import com.qiqi.commonconfig.common.Constants;
import com.qiqi.msjfootball.service.FootballService;
import com.qiqi.msjmapper.mapper.FootballPlayerCustomMapper;
import com.qiqi.msjmapper.mapper.FootballRankingCustomMapper;
import com.qiqi.msjmapper.pojo.FootballPlayerCustom;
import com.qiqi.msjmapper.pojo.FootballRankingCustom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FootballServiceImpl implements FootballService {

    @Resource
    private FootballRankingCustomMapper footballRankingCustomMapper;
    @Resource
    private FootballPlayerCustomMapper footballPlayerCustomMapper;

    @Override
//    @Cacheable(cacheNames = "football.service.getRanking")
    public List<FootballRankingCustom> getRanking(Integer leagueId) {
        List<FootballRankingCustom> rankingList = footballRankingCustomMapper.queryRankingByLeagueId(leagueId);
        for(FootballRankingCustom ranking : rankingList){
            ranking.setLogo(Constants.URL_PREFIX + ranking.getLogo());
        }
        return rankingList;
    }

    @Override
    public List<FootballPlayerCustom> getTeam(Integer teamId) {
        List<FootballPlayerCustom> playerList = footballPlayerCustomMapper.selectByTeamId(teamId);
        for(FootballPlayerCustom player : playerList){
            player.setAvatar(Constants.URL_PREFIX + player.getAvatar());
        }
        return playerList;
    }
}
