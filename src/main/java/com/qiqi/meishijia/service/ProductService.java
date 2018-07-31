package com.qiqi.meishijia.service;

import com.qiqi.meishijia.model.PCategory;

import java.util.List;

public interface ProductService {
    List<PCategory> getPCategory(Integer fid);
}
