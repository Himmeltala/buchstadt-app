package com.buchstadt.controller;

import com.buchstadt.annotaion.GlobalUrl;
import com.buchstadt.pojo.Address;
import com.buchstadt.pojo.User;
import com.buchstadt.pojo.vo.UpdatePwdVo;
import com.buchstadt.service.IAddressService;
import com.buchstadt.service.IUserService;
import com.buchstadt.utils.R;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @package: com.buchstadt.controller
 * @author: zheng
 * @date: 2023/8/25
 */
@GlobalUrl("/user")
@Validated
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    private final IAddressService addressService;

    /**
     * 获取所有的用户
     */
    @GetMapping("/auth/query/all")
    public R<PageInfo<User>> queryAll(@RequestParam Integer pageSize,
                                      @RequestParam Integer currPage) {
        return userService.queryAll(pageSize, currPage);
    }

    /**
     * 查询一个用户信息
     *
     * @param id 用户 id
     */
    @GetMapping("/auth/query/one")
    public R<User> queryOne(@RequestParam Integer id) {
        return userService.queryOne(id);
    }

    @PostMapping("/auth/insert/one")
    public R<Integer> insertOne(@RequestBody User data) {
        return userService.insertOne(data);
    }

    /**
     * 更新用户信息
     *
     * @param data 用户实体类
     */
    @PutMapping("/auth/update/one")
    public R<Integer> updateOne(@RequestBody User data) {
        return userService.updateOne(data);
    }

    @PostMapping("/auth/delete/one")
    public R<Void> deleteOne(@RequestBody User data) {
        return userService.deleteOne(data);
    }

    /**
     * 修改用户密码
     *
     * @param vo  修改用户密码实体类
     * @param uid 用户 id
     */
    @PutMapping("/auth/update/pwd")
    public R<Void> updatePwd(@RequestBody UpdatePwdVo vo,
                             @RequestHeader("Uid") Integer uid) {
        return userService.updatePwd(vo, uid);
    }

    // ------------------------------------------- start Address start -------------------------------------------

    /**
     * 保存一个地址
     *
     * @param data 地址实体类
     * @param uid  用户 id
     */
    @PostMapping("/auth/insert/one-address")
    public R<Integer> insertOneAddress(@RequestBody Address data,
                                       @RequestParam Integer uid) {
        return addressService.insertOneAddress(data, uid);
    }

    /**
     * 修改收货地址为默认地址
     *
     * @param id  地址 id
     * @param uid 用户 id
     */
    @PutMapping("/auth/update/address-default")
    public R<Integer> updateAddressIsDefault(@RequestParam Integer id,
                                             @RequestParam Integer uid) {
        return addressService.updateAddressDefault(id, uid);
    }

    /**
     * 更新收货地址信息
     *
     * @param data 收货地址实体类
     * @param uid  用户 id
     */
    @PutMapping("/auth/update/one-address")
    public R<Integer> updateOneAddress(@RequestBody Address data,
                                       @RequestParam Integer uid) {
        return addressService.updateOneAddress(data, uid);
    }

    /**
     * 删除一个收货地址
     *
     * @param id  地址 id
     * @param uid 用户 id
     */
    @DeleteMapping("/auth/delete/one-address")
    public R<Integer> deleteOneAddress(@RequestParam Integer id,
                                       @RequestParam Integer uid) {
        return addressService.deleteOneAddress(id, uid);
    }

    /**
     * 分页查询该用户的所有地址
     *
     * @param uid      用户 id
     * @param pageSize 一页数量
     * @param currPage 页码
     */
    @GetMapping("/auth/query/all-address-by-uid")
    public R<PageInfo<Address>> queryAllAddressByUid(@RequestParam Integer uid,
                                                     @RequestParam(required = false) Integer pageSize,
                                                     @RequestParam(required = false) Integer currPage) {
        return addressService.queryAllAddressByUid(uid, pageSize, currPage);
    }

    /**
     * 查询用户的某一个地址
     *
     * @param uid       用户 id
     * @param isDefault 是否为默认地址
     */
    @GetMapping("/auth/query/one-address")
    public R<Address> queryOneAddress(@RequestParam Integer uid, @RequestParam Integer isDefault) {
        return addressService.queryOneAddress(uid, isDefault);
    }

    // ------------------------------------------- end Address end -------------------------------------------

}
