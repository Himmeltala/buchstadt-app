package com.buchstadt.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buchstadt.mapper.BCollectionMapper;
import com.buchstadt.pojo.BCollection;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class CollectionService extends ServiceImpl<BCollectionMapper, BCollection> {

    @Resource
    private BCollectionMapper mapper;

    @Transactional
    public R<Void> insertOneCollection(Integer buchId, Integer uid) {
        BCollection isExist = super.query().eq("user_id", uid).eq("buch_id", buchId).one();
        if (!Objects.isNull(isExist)) return R.build(Http.NO, "已经收藏过了！");

        isExist = new BCollection();
        isExist.setBuchId(buchId);
        isExist.setUserId(uid);
        boolean f = super.save(isExist);

        if (!f)
            return R.build(Http.NO, "收藏失败！");
        return R.build(Http.OK, "收藏成功！");
    }

    public R<List<BCollection>> queryAllCollection(Integer uid) {
        return R.build(Http.OK, mapper.queryAll(uid));
    }

}
