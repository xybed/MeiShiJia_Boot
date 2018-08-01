package com.qiqi.msjapi.service;

import com.qiqi.msjmapper.entity.PCategory;

import java.util.List;

public interface ProductService {
    List<PCategory> getPCategory(Integer fid);
}
