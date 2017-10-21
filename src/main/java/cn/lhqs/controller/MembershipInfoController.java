package cn.lhqs.controller;


import cn.lhqs.common.ResponseResult;
import cn.lhqs.iservice.MembershipInfoService;
import cn.lhqs.model.MembershipInfo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户管理
 */
@RestController
@RequestMapping(value = "api")
public class MembershipInfoController {

    @Resource
    MembershipInfoService membershipInfoServiceImpl;

    /**
     * 获取所有用户信息
     * @param request
     * @return
     */
    @GetMapping(value = "/getAllMembership")
    public ResponseResult getAllMembership(HttpServletRequest request){
        List<MembershipInfo> allMembershipInfo = membershipInfoServiceImpl.getAllMembershipInfo();
        return new ResponseResult(0,"success",allMembershipInfo);
    }

    /**
     * 删除指定用户
     */
    @GetMapping(value = "/removeUser/{userId}")
    public ResponseResult removeUser(@PathVariable int userId,HttpServletRequest request) {
        int respCode = membershipInfoServiceImpl.removeUser(userId);
        if(respCode != 0){
            return ResponseResult.ok;
        }else{
            return ResponseResult.fail;
        }
    }

    /**
     * 修改指定用户
     * @param membershipInfo
     * @param request
     * @return
     */
    @PostMapping(value = "/updateUser")
    public ResponseResult updateUser(@RequestBody MembershipInfo membershipInfo,HttpServletRequest request) {
        int respCode = membershipInfoServiceImpl.updateUser(membershipInfo);
        if (respCode != 0) {
            return ResponseResult.ok;
        } else {
            return ResponseResult.fail;
        }
    }

    /**
     * 用于判断用户与密码是否匹配
     */
    @PostMapping(value = "/getUserInfo")
    public ResponseResult getUserInfo(@RequestBody MembershipInfo membershipInfo, HttpServletRequest request) {
        int respCode = membershipInfoServiceImpl.getUserInfo(membershipInfo);
        if (respCode != 0) {
            return ResponseResult.ok;
        } else {
            return ResponseResult.fail;
        }
    }

    /**
     * 用户判断此用户是否存在
     * @param username
     * @param request
     * @return
     */
    @GetMapping(value = "/getUserCount/{username}")
    public ResponseResult getUserInfo(@PathVariable String username, HttpServletRequest request) {
        int respCode = membershipInfoServiceImpl.getUserCount(username);
        if (respCode != 0) {
            return ResponseResult.ok;
        } else {
            return ResponseResult.fail;
        }
    }
}
