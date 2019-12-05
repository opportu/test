package com.mapper;

import com.pojo.Url;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * 接口相对地址管理Mapper
 */

@Repository
public interface UrlManagerMapper {
    int addUrl(Url url);

    int deleteUrl(int id);

    int update(Url url);

    ArrayList<Url> selectUrl();

}
