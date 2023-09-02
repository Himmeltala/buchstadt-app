package com.buchstadt.mapper;

import com.buchstadt.pojo.Buch;
import com.buchstadt.pojo.vo.BuchQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BuchMapper {
    Buch queryOne(Buch data);

    List<Buch> queryAll(BuchQueryVo vo);

    Integer updateOne(Buch data);

    Integer insertOne(Buch data);

    Integer insertTags(List<Buch.Tag> data, Integer id);

    Integer insertAuthors(List<Buch.Author> data, Integer id);

    Integer insertPreviews(List<Buch.Preview> data, Integer id);

    Integer updateTags(List<Buch.Tag> data, Integer id);

    Integer updateAuthors(List<Buch.Author> data, Integer id);

    Integer updatePreviews(List<Buch.Preview> data, Integer id);

    Integer deleteOneTag(Buch.Tag data);

    Integer deleteOneAuthor(Buch.Author data);

    Integer deleteOnePreview(Buch.Preview data);

    Integer deleteOne(Buch data);
}
