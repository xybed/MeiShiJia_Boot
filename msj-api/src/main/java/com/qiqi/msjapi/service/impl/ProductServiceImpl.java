package com.qiqi.msjapi.service.impl;

import com.qiqi.msjmapper.enums.PCategoryLevel;
import com.qiqi.msjmapper.mapper.PCategoryCustomMapper;
import com.qiqi.msjmapper.entity.PCategory;
import com.qiqi.msjapi.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private PCategoryCustomMapper pCategoryCustomMapper;

    @Override
    public List<PCategory> getPCategory(Integer fid) {
        if(fid == 0){
            return pCategoryCustomMapper.queryByLevel(PCategoryLevel.ONE.getCode());
        }else {
            return pCategoryCustomMapper.queryByFid(fid);
        }
    }
}
