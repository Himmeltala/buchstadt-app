package com.buchstadt.service;

import com.buchstadt.pojo.BuchCollection;
import com.buchstadt.mapper.BuchCollectionMapper;
import com.buchstadt.service.common.LoginCallback;
import com.buchstadt.service.common.LoginValidator;
import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BuchCollectionService {

    private final BuchCollectionMapper mapper;

    public BuchCollectionService(BuchCollectionMapper mapper) {
        this.mapper = mapper;
    }

    public R<Integer> insert(Integer id, Integer uid) {
        try {
            List<BuchCollection> list = mapper.query(uid);
            for (BuchCollection item : list) {
                int buchId = item.getBuch().getId();
                if (buchId == id) {
                    return R.build(HttpCodes.NO, "已经收藏过了");
                }
            }
            int flag = mapper.insert(id, uid);
            if (flag == 0) {
                return R.build(HttpCodes.NO, "收藏失败");
            } else {
                return R.build(HttpCodes.OK, "收藏成功");
            }
        } catch (Exception e) {
            return R.build(HttpCodes.NO, e.getMessage());
        }
    }

    public R<List<BuchCollection>> query(Integer userId) {
        return new LoginValidator<List<BuchCollection>>(userId).validate(new LoginCallback<>() {
            @Override
            public R<List<BuchCollection>> success() {
                return R.build(HttpCodes.OK, "成功", mapper.query(userId));
            }

            @Override
            public R<List<BuchCollection>> failed() {
                return R.build(HttpCodes.NO, "未获取到用户 ID");
            }

            @Override
            public R<List<BuchCollection>> error() {
                return R.build(HttpCodes.ERROR, "服务器错误");
            }
        });
    }
}
