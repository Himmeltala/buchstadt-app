package com.buchstadt.service;

import com.buchstadt.mapper.PublisherMapper;
import com.buchstadt.pojo.dto.PublisherSelectOptionDto;
import com.buchstadt.pojo.Publisher;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PublisherService {

    @Resource
    private PublisherMapper mapper;

    public Publisher queryOne(Map<String, Object> map) {
        return mapper.query(map);
    }

    public List<Publisher> queryAll() {
        return mapper.queryAll();
    }

    public R<Integer> updateOne(Publisher data) {
        return R.build(Http.OK, mapper.update(data));
    }

    public R<Integer> insertOne(Publisher data) {
        return R.build(Http.OK, mapper.insert(data));
    }

    public R<Void> deleteOne(Publisher data) {
        Integer integer = mapper.delete(data);
        if (integer != 0) {
            return R.build(Http.OK, "删除出版社成功");
        } else return R.build(Http.NO, "删除出版社失败");
    }

    public R<List<PublisherSelectOptionDto>> queryPublisherSelectOption() {
        return R.build(Http.OK, mapper.queryPublisherSelectOption());
    }

}
