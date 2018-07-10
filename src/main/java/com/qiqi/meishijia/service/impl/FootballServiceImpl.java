package com.qiqi.meishijia.service.impl;

import com.qiqi.meishijia.common.Constants;
import com.qiqi.meishijia.mapper.FootballPlayerCustomMapper;
import com.qiqi.meishijia.mapper.FootballRankingCustomMapper;
import com.qiqi.meishijia.model.FootballPlayer;
import com.qiqi.meishijia.pojo.FootballPlayerCustom;
import com.qiqi.meishijia.pojo.FootballRankingCustom;
import com.qiqi.meishijia.service.FootballService;
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
        return footballRankingCustomMapper.queryRankingByLeagueId(leagueId);
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
