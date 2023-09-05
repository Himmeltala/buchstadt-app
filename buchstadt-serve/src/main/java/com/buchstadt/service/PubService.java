package com.buchstadt.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buchstadt.mapper.PubMapper;
import com.buchstadt.pojo.Pub;
import com.buchstadt.pojo.dto.PubSelectOptionDto;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PubService extends ServiceImpl<PubMapper, Pub> {

    @Resource
    private PubMapper mapper;

    public R<Pub> queryOne(Integer id) {
        return R.build(Http.OK, mapper.queryOne(id));
    }

    public R<List<Pub>> queryAll() {
        return R.build(Http.OK, mapper.queryAll());
    }

    public R<PageInfo<Pub>> queryAllByPage(Integer pageSize, Integer currPage) {
        try {
            PageHelper.startPage(currPage, pageSize);
            List<Pub> list = super.query().list();
            return R.build(Http.OK, new PageInfo<>(list));
        } finally {
            PageHelper.clearPage();
        }
    }

    public R<Integer> updateOne(Pub data) {
        return R.build(Http.OK, "更新出版社信息成功！", mapper.updateOne(data));
    }

    public R<Integer> insertOne(Pub data) {
        return R.build(Http.OK, "新增出版社成功！", mapper.insertOne(data));
    }

    public R<Void> deleteOne(Integer id) {
        Integer f = mapper.deleteOne(id);
        if (f != 0) {
            return R.build(Http.OK, "删除出版社成功！");
        } else return R.build(Http.NO, "删除出版社失败！");
    }

    public R<List<PubSelectOptionDto>> queryPublisherSelectOption() {
        return R.build(Http.OK, mapper.queryPublisherSelectOption());
    }

}
