package com.buchstadt.mapper;

import com.buchstadt.pojo.Buch;
import com.buchstadt.pojo.vo.BuchQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BuchMapper {
    Buch query(Buch data);

    List<Buch> queryAll(BuchQueryVo vo);

    Integer update(Buch data);

    Integer insert(Buch data);

    Integer insertTags(List<Buch.Tag> data, Integer id);

    Integer insertAuthors(List<Buch.Author> data, Integer id);

    Integer insertPreviews(List<Buch.Preview> data, Integer id);

    Integer updateTags(List<Buch.Tag> data, Integer id);

    Integer updateAuthors(List<Buch.Author> data, Integer id);

    Integer updatePreviews(List<Buch.Preview> data, Integer id);

    Integer delTag(Buch.Tag data);

    Integer delAuthor(Buch.Author data);

    Integer delPreview(Buch.Preview data);

    Integer delBuch(Buch data);
}
