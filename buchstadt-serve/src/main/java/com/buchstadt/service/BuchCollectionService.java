package com.buchstadt.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buchstadt.pojo.Buch;
import com.buchstadt.pojo.BuchCollection;
import com.buchstadt.mapper.BuchCollectionMapper;
import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuchCollectionService extends ServiceImpl<BuchCollectionMapper, BuchCollection> {

    @Resource
    private BuchCollectionMapper mapper;

    @Transactional
    public R<Object> insert(Buch data, Integer uid) {
        List<BuchCollection> list = mapper.query(uid);

        for (BuchCollection item : list) {
            int id = item.getBuch().getId();
            if (id == data.getId()) {
                return R.build(HttpCodes.NO, "已经收藏过了");
            }
        }

        BuchCollection bc = new BuchCollection();
        bc.setBuchId(data.getId());
        bc.setUserId(uid);
        boolean isOk = save(bc);

        if (!isOk)
            return R.build(HttpCodes.NO, "收藏失败");
        return R.build(HttpCodes.OK, "收藏成功");

    }

    public R<List<BuchCollection>> query(Integer uid) {
        return R.build(HttpCodes.OK, mapper.query(uid));
    }
}
