package com.buchstadt.service;

import com.buchstadt.pojo.BComment;
import com.buchstadt.utils.R;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @package: com.buchstadt.service
 * @author: zheng
 * @date: 2023/9/12
 */
public interface ICommentService {

    R<List<BComment>> queryAllComment(Map<String, Object> map);

    R<Void> insertOneComment(BComment data, Integer uid);

    R<Void> deleteOneComment(Integer id);

}
