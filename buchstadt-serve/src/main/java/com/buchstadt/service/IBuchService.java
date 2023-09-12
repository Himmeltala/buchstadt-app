package com.buchstadt.service;

import com.buchstadt.pojo.Buch;
import com.buchstadt.utils.R;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @description:
 * @package: com.buchstadt.service
 * @author: zheng
 * @date: 2023/9/12
 */
public interface IBuchService {

    R<Buch> queryOne(Integer id);

    R<PageInfo<Buch>> queryAllByCondition(Map<String, Object> map);

    R<Void> updateOne(Buch data);

    R<Void> insertOne(Buch data);

    R<Void> insertOneAttach(Buch data);

    R<Void> deleteOneTag(Integer tagId, Integer buchId);

    R<Void> deleteOneAuthor(Integer authorId, Integer buchId);

    R<Void> deleteOnePreview(Integer previewId, Integer buchId);

    R<Void> deleteOne(Integer id);

    R<PageInfo<Buch>> queryAllByPage(Integer pageSize, Integer currPage);

}
