package com.buchstadt.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buchstadt.pojo.BuchCollection;
import com.buchstadt.mapper.BuchCollectionMapper;
import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuchCollectionService extends ServiceImpl<BuchCollectionMapper, BuchCollection> {

    @Resource
    private BuchCollectionMapper mapper;

    public R<Object> insert(Integer id, Integer uid) {
        try {
            List<BuchCollection> list = mapper.query(uid);

            for (BuchCollection item : list) {
                int buchId = item.getBuch().getId();
                if (buchId == id) {
                    return R.build(HttpCodes.NO, "已经收藏过了");
                }
            }

            BuchCollection data = new BuchCollection();
            data.setBuchId(id);
            data.setUserId(uid);
            boolean isOk = save(data);

            if (!isOk)
                return R.build(HttpCodes.NO, "收藏失败");
            return R.build(HttpCodes.OK, "收藏成功");

        } catch (Exception e) {
            return R.build(HttpCodes.NO, e.getMessage());
        }
    }

    public R<List<BuchCollection>> query(Integer userId) {
        return R.build(HttpCodes.OK, mapper.query(userId));
    }
}
