package com.buchstadt.service;

import com.buchstadt.exception.InsertException;
import com.buchstadt.exception.UpdateException;
import com.buchstadt.pojo.Buch;
import com.buchstadt.mapper.BuchMapper;
import com.buchstadt.pojo.vo.BuchQueryVo;
import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuchService {

    @Resource
    private BuchMapper mapper;

    public Buch queryOne(Buch data) {
        return mapper.queryOne(data);
    }

    public List<Buch> queryAll(BuchQueryVo vo) {
        return mapper.queryAll(vo);
    }

    @Transactional
    public R<Object> updateOne(Buch data) {
        try {
            Integer f = mapper.updateOne(data);

            if (f == 0) return R.build(HttpCodes.NO, "更新书籍表单失败！");

            List<Buch.Author> as = data.getAuthors();
            List<Buch.Preview> ps = data.getPreviews();
            List<Buch.Tag> ts = data.getTags();

            if (as == null && ps == null && ts == null) return R.build(HttpCodes.OK, "更新书籍表单成功！");

            Integer f1 = mapper.updateTags(ts, data.getId());
            Integer f2 = mapper.updatePreviews(ps, data.getId());
            Integer f3 = mapper.updateAuthors(as, data.getId());

            if (f1 == 1 && f2 == 1 && f3 == 1)
                return R.build(HttpCodes.OK, "更新书籍表单成功！");
            else
                return R.build(HttpCodes.NO, "更新书籍表单失败！");
        } catch (Exception e) {
            throw new UpdateException("更新书籍表单失败！");
        }
    }

    @Transactional
    public R<Object> insertOne(Buch data) {
        try {
            Integer f = mapper.insert(data);
            if (f == 0) return R.build(HttpCodes.NO, "插入书籍失败！");

            Integer id = data.getId();

            Integer f1 = mapper.insertAuthors(data.getAuthors(), id);
            Integer f2 = mapper.insertTags(data.getTags(), id);
            Integer f3 = mapper.insertPreviews(data.getPreviews(), id);

            if (f1 != 0 && f2 != 0 && f3 != 0)
                return R.build(HttpCodes.OK, "插入书籍成功！");
            else
                return R.build(HttpCodes.NO, "插入书籍失败！");
        } catch (Exception e) {
            throw new InsertException("插入书籍失败！");
        }
    }

    @Transactional
    public R<Object> insertOneAttach(Buch data) {
        Integer id = data.getId();

        mapper.insertAuthors(data.getAuthors(), id);
        mapper.insertTags(data.getTags(), id);
        mapper.insertPreviews(data.getPreviews(), id);

        return R.build(HttpCodes.OK, "插入数据成功！");
    }

    public R<Integer> delTag(Buch.Tag data) {
        Integer integer = mapper.delTag(data);
        if (integer != 0) {
            return R.build(HttpCodes.OK, "删除标签成功");
        } else return R.build(HttpCodes.NO, "删除标签失败");
    }

    public R<Integer> delAuthor(Buch.Author data) {
        Integer integer = mapper.delAuthor(data);
        if (integer != 0) {
            return R.build(HttpCodes.OK, "删除作者成功");
        } else return R.build(HttpCodes.NO, "删除做这个失败");
    }

    public R<Integer> delPreview(Buch.Preview data) {
        Integer integer = mapper.delPreview(data);
        if (integer != 0) {
            return R.build(HttpCodes.OK, "删除预览图成功");
        } else return R.build(HttpCodes.NO, "删除预览图失败");
    }

    public R<Object> delBuch(Buch data) {
        Integer integer = mapper.delBuch(data);
        if (integer != 0) {
            return R.build(HttpCodes.OK, "删除书籍成功");
        } else return R.build(HttpCodes.NO, "删除书籍失败");
    }

}
