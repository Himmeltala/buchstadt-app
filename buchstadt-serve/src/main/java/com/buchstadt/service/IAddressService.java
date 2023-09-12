package com.buchstadt.service;

import com.buchstadt.pojo.Address;
import com.buchstadt.utils.R;
import com.github.pagehelper.PageInfo;

/**
 * @description: 有关用户地址的业务
 * @package: com.buchstadt.service
 * @author: zheng
 * @date: 2023/9/12
 */
public interface IAddressService {

    R<Integer> insertOneAddress(Address data, Integer uid);

    R<Integer> updateAddressDefault(Integer id, Integer uid);

    R<Integer> updateOneAddress(Address data, Integer uid);

    R<Integer> deleteOneAddress(Integer id, Integer uid);

    R<Address> queryOneAddress(Integer uid, Integer isDefault);

    R<PageInfo<Address>> queryAllAddressByUid(Integer uid, Integer pageSize, Integer currPage);

}
