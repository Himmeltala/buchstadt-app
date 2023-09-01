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
import java.util.Objects;

@Service
public class BuchCollectionService extends ServiceImpl<BuchCollectionMapper, BuchCollection> {

    @Resource
    private BuchCollectionMapper mapper;

    @Transactional
    public R<Object> insertOne(Buch data, Integer uid) {
        BuchCollection isExist = super.query().eq("user_id", uid).eq("buch_id", data.getId()).one();
        if (!Objects.isNull(isExist)) return R.build(HttpCodes.NO, "已经收藏过了");

        isExist = new BuchCollection();
        isExist.setBuchId(data.getId());
        isExist.setUserId(uid);
        boolean f = super.save(isExist);

        if (!f)
            return R.build(HttpCodes.NO, "收藏失败！");
        return R.build(HttpCodes.OK, "收藏成功！");
    }

    public R<List<BuchCollection>> queryAll(Integer uid) {
        return R.build(HttpCodes.OK, mapper.queryAll(uid));
    }

}
