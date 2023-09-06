package com.buchstadt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buchstadt.pojo.Buch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BuchMapper extends BaseMapper<Buch> {
    Buch queryOne(Integer id);

    List<Buch> queryAll(Map<String, Object> map);

    Integer updateOne(Buch data);

    Integer insertOne(Buch data);

    Integer insertTags(List<Buch.Tag> data, Integer id);

    Integer insertAuthors(List<Buch.Author> data, Integer id);

    Integer insertPreviews(List<Buch.Preview> data, Integer id);

    Integer updateTags(List<Buch.Tag> data, Integer id);

    Integer updateAuthors(List<Buch.Author> data, Integer id);

    Integer updatePreviews(List<Buch.Preview> data, Integer id);

    Integer deleteOneTag(Integer tagId, Integer buchId);

    Integer deleteOneAuthor(Integer authorId, Integer buchId);

    Integer deleteOnePreview(Integer previewId, Integer buchId);

    Integer deleteOne(Integer id);
}
