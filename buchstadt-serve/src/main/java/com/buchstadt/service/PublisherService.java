package com.buchstadt.service;

import com.buchstadt.mapper.PublisherMapper;
import com.buchstadt.params.PublisherOpsData;
import com.buchstadt.pojo.Publisher;
import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PublisherService {

    @Resource
    private PublisherMapper mapper;

    public Publisher query(Map<String, Object> map) {
        return mapper.query(map);
    }

    public List<Publisher> queryAll() {
        return mapper.queryAll();
    }

    public Integer update(Publisher publisher) {
        return mapper.update(publisher);
    }

    public Integer insert(Publisher publisher) {
        return mapper.insert(publisher);
    }


    public R<Object> delete(Publisher publisher) {
        Integer integer = mapper.delete(publisher);
        if (integer != 0) {
            return R.build(HttpCodes.OK, "删除出版社成功");
        } else return R.build(HttpCodes.NO, "删除出版社失败");
    }

    public List<PublisherOpsData> queryPublisherOps() {
        return mapper.queryPublisherOps();
    }
}
