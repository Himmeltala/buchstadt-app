package com.buchstadt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buchstadt.mapper.PubMapper;
import com.buchstadt.pojo.Pub;
import com.buchstadt.pojo.dto.PubSelectOptionDto;
import com.buchstadt.service.IPubService;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @package: com.buchstadt.service.impl
 * @author: zheng
 * @date: 2023/8/25
 */
@Service
@RequiredArgsConstructor
public class PubServiceImpl extends ServiceImpl<PubMapper, Pub> implements IPubService {

    private final PubMapper mapper;

    @Override
    public R<Pub> queryOne(Integer id) {
        return R.build(Http.OK, mapper.queryOne(id));
    }

    @Override
    public R<List<Pub>> queryAll() {
        return R.build(Http.OK, mapper.queryAll());
    }

    @Override
    public R<PageInfo<Pub>> queryAllByPage(Integer pageSize, Integer currPage) {
        try {
            PageHelper.startPage(currPage, pageSize);
            List<Pub> list = super.query().list();
            return R.build(Http.OK, new PageInfo<>(list));
        } finally {
            PageHelper.clearPage();
        }
    }

    @Override
    public R<Integer> updateOne(Pub data) {
        return R.build(Http.OK, "更新出版社信息成功！", mapper.updateOne(data));
    }

    @Override
    public R<Integer> insertOne(Pub data) {
        return R.build(Http.OK, "新增出版社成功！", mapper.insertOne(data));
    }

    @Override
    public R<Void> deleteOne(Integer id) {
        Integer f = mapper.deleteOne(id);
        if (f != 0) {
            return R.build(Http.OK, "删除出版社成功！");
        } else return R.build(Http.NO, "删除出版社失败！");
    }

    @Override
    public R<List<PubSelectOptionDto>> queryPublisherSelectOption() {
        return R.build(Http.OK, mapper.queryPublisherSelectOption());
    }

}
