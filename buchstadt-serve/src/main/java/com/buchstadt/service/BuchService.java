package com.buchstadt.service;

import com.buchstadt.pojo.Buch;
import com.buchstadt.mapper.BuchMapper;
import com.buchstadt.utils.Http;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuchService {

    @Resource
    private BuchMapper mapper;

    public R<Buch> queryOne(Integer id) {
        return R.build(Http.OK, mapper.queryOne(id));
    }

    public R<List<Buch>> queryAll(Integer isPrime, String name, String type) {
        return R.build(Http.OK, mapper.queryAll(isPrime, name, type));
    }

    @Transactional
    public R<Void> updateOne(Buch data) {
        try {
            Integer f = mapper.updateOne(data);

            if (f == 0) return R.build(Http.NO, "更新书籍表单失败！");

            var as = data.getAuthors();
            var ps = data.getPreviews();
            var ts = data.getTags();

            if (as == null && ps == null && ts == null) return R.build(Http.OK, "更新书籍表单成功！");

            Integer f1 = mapper.updateTags(ts, data.getId());
            Integer f2 = mapper.updatePreviews(ps, data.getId());
            Integer f3 = mapper.updateAuthors(as, data.getId());

            if (f1 == 1 && f2 == 1 && f3 == 1)
                return R.build(Http.OK, "更新书籍表单成功！");
            else
                return R.build(Http.NO, "更新书籍表单失败！");
        } catch (Exception e) {
            throw new RuntimeException("更新书籍表单失败！");
        }
    }

    @Transactional
    public R<Void> insertOne(Buch data) {
        try {
            Integer f = mapper.insertOne(data);
            if (f == 0) return R.build(Http.NO, "插入书籍失败！");

            Integer id = data.getId();

            Integer f1 = mapper.insertAuthors(data.getAuthors(), id);
            Integer f2 = mapper.insertTags(data.getTags(), id);
            Integer f3 = mapper.insertPreviews(data.getPreviews(), id);

            if (f1 != 0 && f2 != 0 && f3 != 0)
                return R.build(Http.OK, "插入书籍成功！");
            else
                return R.build(Http.NO, "插入书籍失败！");
        } catch (Exception e) {
            throw new RuntimeException("插入书籍失败！");
        }
    }

    @Transactional
    public R<Void> insertOneAttach(Buch data) {
        Integer id = data.getId();

        var as = data.getAuthors();
        var ts = data.getTags();
        var ps = data.getPreviews();

        try {
            if (!as.isEmpty()) mapper.insertAuthors(as, id);
            if (!ts.isEmpty()) mapper.insertTags(ts, id);
            if (!ps.isEmpty()) mapper.insertPreviews(ps, id);

            return R.build(Http.OK, "插入附表数据成功！");
        } catch (Exception e) {
            throw new RuntimeException("插入附表数据失败！");
        }
    }

    public R<Void> deleteOneTag(Integer tagId, Integer buchId) {
        Integer integer = mapper.deleteOneTag(tagId, buchId);
        if (integer != 0) {
            return R.build(Http.OK, "删除标签成功");
        } else return R.build(Http.NO, "删除标签失败");
    }

    public R<Void> deleteOneAuthor(Integer authorId, Integer buchId) {
        Integer integer = mapper.deleteOneAuthor(authorId, buchId);
        if (integer != 0) {
            return R.build(Http.OK, "删除作者成功");
        } else return R.build(Http.NO, "删除做这个失败");
    }

    public R<Void> deleteOnePreview(Integer previewId, Integer buchId) {
        Integer integer = mapper.deleteOnePreview(previewId, buchId);
        if (integer != 0) {
            return R.build(Http.OK, "删除预览图成功");
        } else return R.build(Http.NO, "删除预览图失败");
    }

    public R<Void> deleteOne(Integer id) {
        Integer integer = mapper.deleteOne(id);
        if (integer != 0) {
            return R.build(Http.OK, "删除书籍成功");
        } else return R.build(Http.NO, "删除书籍失败");
    }

}
