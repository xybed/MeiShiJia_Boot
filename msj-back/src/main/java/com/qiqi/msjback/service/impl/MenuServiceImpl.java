package com.qiqi.msjback.service.impl;

import com.qiqi.msjback.service.MenuService;
import com.qiqi.msjback.service.SessionService;
import com.qiqi.msjmapper.entity.BackUser;
import com.qiqi.msjmapper.enums.MenuType;
import com.qiqi.msjmapper.mapper.BackMenuCustomMapper;
import com.qiqi.msjmapper.pojo.BackMenuCustom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private SessionService sessionService;
    @Resource
    private BackMenuCustomMapper backMenuCustomMapper;

    @Override
    public List<BackMenuCustom> getLeftMenu() {
        BackUser backUser = sessionService.getUser();
        List<BackMenuCustom> backMenuCustomList = backMenuCustomMapper.queryMenuByFid(0, backUser.getId(), MenuType.MENU.getCode());
        for(BackMenuCustom backMenuCustom : backMenuCustomList){
            List<BackMenuCustom> children = backMenuCustomMapper.queryMenuByFid(backMenuCustom.getId(), backUser.getId(), MenuType.MENU.getCode());
            backMenuCustom.setChildren(children);
        }
        return backMenuCustomList;
    }
}
