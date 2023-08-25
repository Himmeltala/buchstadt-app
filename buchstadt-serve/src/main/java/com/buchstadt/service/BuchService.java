package com.buchstadt.service;

import com.buchstadt.pojo.Buch;
import com.buchstadt.mapper.BuchMapper;
import com.buchstadt.utils.R;
import com.buchstadt.utils.Status;
import com.buchstadt.utils.ValidateUpdatedFlag;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BuchService {

    private final BuchMapper mapper;

    public BuchService(BuchMapper mapper) {
        this.mapper = mapper;
    }

    public Buch query(Map<String, Object> map) {
        return mapper.query(map);
    }

    public List<Buch> queryAll(Map<String, Object> map) {
        return mapper.queryAll(map);
    }

    public R<Object> update(Buch buch) {
        try {
            Integer flag1 = mapper.update(buch);
            if (flag1 != 0) {
                List<Buch.Author> authors = buch.getAuthors();
                List<Buch.Preview> previews = buch.getPreviews();
                List<Buch.Tag> tags = buch.getTags();
                if (authors != null && previews != null && tags != null) {
                    Integer flag2 = mapper.updateTags(tags, buch.getId());
                    Integer flag3 = mapper.updatePreviews(previews, buch.getId());
                    Integer flag4 = mapper.updateAuthors(authors, buch.getId());
                    if (flag2 == 1 && flag3 == 1 && flag4 == 1) {
                        return R.build(Status.OK, "更新表单成功");
                    } else return R.build(Status.NO, "更新表单失败");
                } else return R.build(Status.OK, "更新表单成功");
            } else return R.build(Status.NO, "更新表单失败");
        } catch (Exception e) {
            e.printStackTrace();
            return R.build(Status.ERROR, "服务器错误");
        }
    }

    public R<Object> insert(Buch buch) {
        try {
            int flag1 = mapper.insert(buch);
            if (flag1 != 0) {
                int buchId = buch.getId();
                List<Buch.Author> authors = buch.getAuthors();
                Integer flag2 = mapper.insertAuthors(authors, buchId);
                List<Buch.Tag> tags = buch.getTags();
                Integer flag3 = mapper.insertTags(tags, buchId);
                List<Buch.Preview> previews = buch.getPreviews();
                Integer flag4 = mapper.insertPreviews(previews, buchId);

                if (flag2 != 0 && flag3 != 0 && flag4 != 0) {
                    return R.build(Status.OK, "提交表单成功");
                } else {
                    return R.build(Status.NO, "提交表单失败");
                }
            } else return R.build(Status.NO, "提交表单失败");
        } catch (Exception e) {
            e.printStackTrace();
            return R.build(Status.ERROR, "服务器错误");
        }
    }

    public R<Object> insertAttach(Buch buch) {
        System.out.println(buch);
        try {
            int buchId = buch.getId();
            Integer flag1 = 0, flag2 = 0, flag3 = 0;
            List<Buch.Tag> tags = buch.getTags();
            List<Buch.Author> authors = buch.getAuthors();
            List<Buch.Preview> previews = buch.getPreviews();

            if (!authors.isEmpty()) {
                flag1 = mapper.insertAuthors(authors, buchId);
            }
            if (!tags.isEmpty()) {
                flag2 = mapper.insertTags(tags, buchId);
            }
            if (!previews.isEmpty()) {
                flag3 = mapper.insertPreviews(previews, buchId);
            }

            if (new ValidateUpdatedFlag(flag1, flag2, flag3).or()) {
                return R.build(Status.OK, "插入部分数据成功");
            } else return R.build(Status.NO, "插入数据失败");
        } catch (Exception e) {
            e.printStackTrace();
            return R.build(Status.ERROR, "服务器错误");
        }
    }

    public R<Integer> delTag(Buch.Tag tag) {
        Integer integer = mapper.delTag(tag);
        if (integer != 0) {
            return R.build(Status.OK, "删除标签成功");
        } else return R.build(Status.NO, "删除标签失败");
    }

    public R<Integer> delAuthor(Buch.Author author) {
        Integer integer = mapper.delAuthor(author);
        if (integer != 0) {
            return R.build(Status.OK, "删除作者成功");
        } else return R.build(Status.NO, "删除做这个失败");
    }

    public R<Integer> delPreview(Buch.Preview preview) {
        Integer integer = mapper.delPreview(preview);
        if (integer != 0) {
            return R.build(Status.OK, "删除预览图成功");
        } else return R.build(Status.NO, "删除预览图失败");
    }

    public R<Object> delBuch(Buch buch) {
        Integer integer = mapper.delBuch(buch);
        if (integer != 0) {
            return R.build(Status.OK, "删除书籍成功");
        } else return R.build(Status.NO, "删除书籍失败");
    }


}
