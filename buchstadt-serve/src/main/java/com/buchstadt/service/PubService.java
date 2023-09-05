package com.buchstadt.service;

import com.buchstadt.mapper.PubMapper;
import com.buchstadt.pojo.Pub;
import com.buchstadt.pojo.dto.PubSelectOptionDto;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PubService {

    @Resource
    private PubMapper mapper;

    public R<Pub> queryOne(Integer id) {
        return R.build(Http.OK, mapper.query(id));
    }

    public R<List<Pub>> queryAll() {
        return R.build(Http.OK, mapper.queryAll());
    }

    public R<Integer> updateOne(Pub data) {
        return R.build(Http.OK, "更新出版社信息成功！", mapper.update(data));
    }

    public R<Integer> insertOne(Pub data) {
        return R.build(Http.OK, "新增出版社成功！", mapper.insert(data));
    }

    public R<Void> deleteOne(Integer id) {
        Integer f = mapper.delete(id);
        if (f != 0) {
            return R.build(Http.OK, "删除出版社成功！");
        } else return R.build(Http.NO, "删除出版社失败！");
    }

    public R<List<PubSelectOptionDto>> queryPublisherSelectOption() {
        return R.build(Http.OK, mapper.queryPublisherSelectOption());
    }

}
