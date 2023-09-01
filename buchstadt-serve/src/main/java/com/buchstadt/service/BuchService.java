package com.buchstadt.service;

import com.buchstadt.pojo.Buch;
import com.buchstadt.mapper.BuchMapper;
import com.buchstadt.pojo.vo.BuchQueryVo;
import com.buchstadt.utils.HttpCodes;
import com.buchstadt.utils.R;
import com.buchstadt.utils.ValidateUpdatedFlag;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuchService {

    @Resource
    private BuchMapper mapper;

    public Buch queryBuch(Buch data) {
        return mapper.query(data);
    }

    public List<Buch> queryAll(BuchQueryVo vo) {
        return mapper.queryAll(vo);
    }

    @Transactional
    public R<Object> updateBuch(Buch data) {
        Integer flag1 = mapper.update(data);
        if (flag1 != 0) {
            List<Buch.Author> authors = data.getAuthors();
            List<Buch.Preview> previews = data.getPreviews();
            List<Buch.Tag> tags = data.getTags();
            if (authors != null && previews != null && tags != null) {
                Integer f1 = mapper.updateTags(tags, data.getId());
                Integer f2 = mapper.updatePreviews(previews, data.getId());
                Integer f3 = mapper.updateAuthors(authors, data.getId());
                if (f1 == 1 && f2 == 1 && f3 == 1) {
                    return R.build(HttpCodes.OK, "更新表单成功");
                } else return R.build(HttpCodes.NO, "更新表单失败");
            } else return R.build(HttpCodes.OK, "更新表单成功");
        } else return R.build(HttpCodes.NO, "更新表单失败");
    }

    @Transactional
    public R<Object> insertBuch(Buch data) {
        int f1 = mapper.insert(data);
        if (f1 != 0) {
            int id = data.getId();

            List<Buch.Author> authors = data.getAuthors();
            Integer f2 = mapper.insertAuthors(authors, id);

            List<Buch.Tag> tags = data.getTags();
            Integer f3 = mapper.insertTags(tags, id);

            List<Buch.Preview> previews = data.getPreviews();
            Integer f4 = mapper.insertPreviews(previews, id);

            if (f2 != 0 && f3 != 0 && f4 != 0) {
                return R.build(HttpCodes.OK, "提交表单成功");
            } else {
                return R.build(HttpCodes.NO, "提交表单失败");
            }
        } else return R.build(HttpCodes.NO, "提交表单失败");
    }

    @Transactional
    public R<Object> insertAttach(Buch data) {
        int buchId = data.getId();
        Integer f1 = 0, f2 = 0, f3 = 0;
        List<Buch.Tag> tags = data.getTags();
        List<Buch.Author> authors = data.getAuthors();
        List<Buch.Preview> previews = data.getPreviews();

        if (!authors.isEmpty()) {
            f1 = mapper.insertAuthors(authors, buchId);
        }
        if (!tags.isEmpty()) {
            f2 = mapper.insertTags(tags, buchId);
        }
        if (!previews.isEmpty()) {
            f3 = mapper.insertPreviews(previews, buchId);
        }

        if (new ValidateUpdatedFlag(f1, f2, f3).or()) {
            return R.build(HttpCodes.OK, "插入部分数据成功");
        } else return R.build(HttpCodes.NO, "插入数据失败");
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
