package com.buchstadt.service;

import com.buchstadt.pojo.Admin;
import com.buchstadt.utils.R;
import com.github.pagehelper.PageInfo;

/**
 * @description:
 * @package: com.buchstadt.service
 * @author: zheng
 * @date: 2023/9/12
 */
public interface IAdminService {

    R<PageInfo<Admin>> queryAll(Integer pageSize, Integer currPage);

    R<Integer> deleteOne(Integer id);

    R<Integer> updateOne(Admin data);

    R<Integer> insertOne(Admin data);

}
