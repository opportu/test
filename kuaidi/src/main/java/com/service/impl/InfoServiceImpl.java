package com.service.impl;
import com.mapper.InfoMapper;

import com.pojo.Info;
import com.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoMapper infoMapper;

    @Override
    public void add(Info info){

         infoMapper.addinfo(info);

    }

    /**
     * 查找发过的单的所有信息，包含接单人的电话
     * @param telephone
     * @return
     */
    @Override
    public List<Info> find(String telephone)
    {
        return infoMapper.findInfo(telephone);
    }


    @Override
    public List<Info> findall(){

      return infoMapper.findAllInfo();
//
//         //查询
//                int pageNum = params.getPageNum();
//                int pageSize = params.getPageSize();
//              //  表示开始分页查询
//                PageHelper.startPage(pageNum, pageSize);
//                List<Info> blogs = infoMapper.findAllInfo();
//              //  用PageInfo对结果进行包装
//                PageInfo<Info> pageInfo = new PageInfo<Info>(blogs);
//
//                return pageInfo;

    }

    @Override
    public int deleteinfo(int id){
        return infoMapper.delete(id);
    }

    @Override
    public int updateinfo(int id){

        return infoMapper.update(id);
    }

    @Override
    public Info check(int id){
        Info a = infoMapper.checkInfo(id);
        return a;

    }
    @Override
    public int alter(int i){

        return infoMapper.alterinfo(i);
    }

    @Override
    public List<Info> findget(String telephone){

        return infoMapper.findgetInfo(telephone);
    }

    @Override

    public void confirms(Info info){
         infoMapper.confirm(info);
    }

    @Override
    public void pageconfirms(Info info){
         infoMapper.pageconfirm(info);
    }

    @Override
    public void confirmshim(Info info){
        infoMapper.confirmhim(info);
    }

    @Override
    public void deletereceives_tel(int id){

        infoMapper.deletereceive_tel(id);
    }
}
