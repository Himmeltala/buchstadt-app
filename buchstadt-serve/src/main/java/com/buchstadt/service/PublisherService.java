package com.buchstadt.service;

import com.buchstadt.mapper.PublisherMapper;
import com.buchstadt.params.PublisherOpsData;
import com.buchstadt.pojo.Publisher;
import com.buchstadt.utils.R;
import com.buchstadt.utils.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PublisherService {

    private final PublisherMapper mapper;

    public PublisherService(PublisherMapper mapper) {
        this.mapper = mapper;
    }

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
            return R.build(Status.OK, "删除出版社成功");
        } else return R.build(Status.NO, "删除出版社失败");
    }

    public List<PublisherOpsData> queryPublisherOps() {
        return mapper.queryPublisherOps();
    }
}
