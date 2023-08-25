package com.buchstadt.service;

import com.buchstadt.pojo.BuchCollection;
import com.buchstadt.mapper.BuchCollectionMapper;
import com.buchstadt.service.common.LoginCallback;
import com.buchstadt.service.common.LoginValidator;
import com.buchstadt.utils.R;
import com.buchstadt.utils.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BuchCollectionService {

    private final BuchCollectionMapper mapper;

    public BuchCollectionService(BuchCollectionMapper mapper) {
        this.mapper = mapper;
    }

    public R<Integer> insert(Map<String, Object> map) {
        try {
            List<BuchCollection> list = mapper.query((Integer) map.get("userId"));
            for (BuchCollection item : list) {
                int buchId = item.getBuch().getId();
                if (buchId == (Integer) map.get("buchId")) {
                    return R.build(Status.NO, "已经收藏过了");
                }
            }
            int flag = mapper.insert(map);
            if (flag == 0) {
                return R.build(Status.NO, "收藏失败");
            } else {
                return R.build(Status.OK, "收藏成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.build(Status.NO, "服务器错误");
        }
    }

    public R<List<BuchCollection>> query(Integer userId) {
        return new LoginValidator<List<BuchCollection>>(userId).validate(new LoginCallback<>() {
            @Override
            public R<List<BuchCollection>> success() {
                return R.build(Status.OK, "成功", mapper.query(userId));
            }

            @Override
            public R<List<BuchCollection>> failed() {
                return R.build(Status.NO, "未获取到用户 ID");
            }

            @Override
            public R<List<BuchCollection>> error() {
                return R.build(Status.ERROR, "服务器错误");
            }
        });
    }
}
