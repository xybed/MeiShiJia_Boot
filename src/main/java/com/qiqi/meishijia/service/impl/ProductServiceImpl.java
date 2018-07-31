package com.qiqi.meishijia.service.impl;

import com.qiqi.meishijia.common.PCategoryLevel;
import com.qiqi.meishijia.mapper.PCategoryCustomMapper;
import com.qiqi.meishijia.model.PCategory;
import com.qiqi.meishijia.service.ProductService;
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
