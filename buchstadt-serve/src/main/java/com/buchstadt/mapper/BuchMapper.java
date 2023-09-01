package com.buchstadt.mapper;

import com.buchstadt.pojo.Buch;
import com.buchstadt.pojo.vo.BuchVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BuchMapper {
    Buch query(Integer id);

    List<Buch> queryAll(BuchVo vo);

    Integer update(Buch buch);

    Integer insert(Buch buch);

    Integer insertTags(@Param("tags") List<Buch.Tag> tags, @Param("buchId") Integer buchId);

    Integer insertAuthors(@Param("authors") List<Buch.Author> authors, @Param("buchId") Integer buchId);

    Integer insertPreviews(@Param("previews") List<Buch.Preview> previews, @Param("buchId") Integer buchId);

    Integer updateTags(@Param("tags") List<Buch.Tag> tags, @Param("buchId") Integer buchId);

    Integer updateAuthors(@Param("authors") List<Buch.Author> authors, @Param("buchId") Integer buchId);

    Integer updatePreviews(@Param("previews") List<Buch.Preview> previews, @Param("buchId") Integer buchId);

    Integer delTag(Buch.Tag tag);

    Integer delAuthor(Buch.Author author);

    Integer delPreview(Buch.Preview preview);

    Integer delBuch(Buch buch);
}
