package cn.lhqs.controller;

import cn.lhqs.common.*;
import cn.lhqs.iservice.MembershipInfoService;
import cn.lhqs.model.MembershipInfo;
import cn.lhqs.viewModel.PageBO;
import cn.lhqs.viewModel.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * author : lhqs
 * description : 用户管理
 * createTime : 2017-09-09 11:01
 * version : 1.0
 */
@RestController
@RequestMapping(value = "api")
public class MembershipInfoController {

    private static Logger logger = LoggerFactory.getLogger(MembershipInfoController.class);

    @Value("${TOKEN}")
    private String TOKEN;

    @Resource
    MembershipInfoService membershipInfoServiceImpl;

    /**
     * 用户登录处理类
     * @param membershipInfo
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/user/getUserInfo")
    public ResponseResult getUserInfo(@RequestBody MembershipInfo membershipInfo, HttpServletRequest request, HttpServletResponse response) {
        logger.info(membershipInfo.getUsername()+"----"+membershipInfo.getPassword());
        MembershipInfo userInfoDetails = membershipInfoServiceImpl.getUserInfoDetails(membershipInfo);
        if (userInfoDetails != null) {
            request.getSession(true).setAttribute("username", membershipInfo.getUsername());
            String token = IDUtils.getUuid(20);
            logger.info("token--login--->"+token);
            CookieUtils.setCookie(request, response, TOKEN, token);
            return new ResponseResult(0,"success",userInfoDetails);
        } else {
            return ResponseResult.fail;
        }
    }


    /**
     * 获取所有用户信息
     * @return
     */
    /*@CrossOrigin(origins ="http:localhost:8080")*/
    @GetMapping(value = "/getAllMembership")
    public ResponseResult getAllMembership(@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                           @RequestParam(value = "pageSize",defaultValue = "10")int pageSize){
        logger.info("pageNum:"+pageNum+",  pageSize:"+pageSize);
        PageBO<MembershipInfo> allMembershipInfo = membershipInfoServiceImpl.getAllMembershipInfo(pageNum, pageSize);
        return new ResponseResult(0,"success",allMembershipInfo);
    }

    /**
     * 删除指定用户
     */
    /*@GetMapping(value = "/removeUser/{userId}")
    public ResponseResult removeUser(@PathVariable String userId,HttpServletRequest request) {
        int respCode = membershipInfoServiceImpl.removeUser(userId);
        if(respCode != 0){
            return ResponseResult.ok;
        }else{
            return ResponseResult.fail;
        }
    }*/

    /**
     * 修改指定用户信息
     * @param userInfo
     * @param request
     * @return
     */
    @PutMapping(value = "/editUserInfo")
    public ResponseResult updateUser(@RequestBody UserInfo userInfo,HttpServletRequest request) {
        String updateName = (String) request.getSession().getAttribute("username");
        logger.info("the update userInfo ----> "+userInfo);
        MembershipInfo membershipInfo = new MembershipInfo();
        BeanCopyUtils.copyProperties(userInfo,membershipInfo);
        membershipInfo.setUpdateName(updateName);
        logger.info("the update memberinfo ----> "+membershipInfo);
        int respCode = membershipInfoServiceImpl.updateUser(membershipInfo, updateName);
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
    @GetMapping(name = "/getUserCount/{username}")
    public ResponseResult getUserInfo(@PathVariable String username, HttpServletRequest request) {
        int respCode = membershipInfoServiceImpl.getUserCount(username);
        if (respCode != 0) {
            return ResponseResult.ok;
        } else {
            return ResponseResult.fail;
        }
    }

    /**
     * 添加用户信息及所分配的权限
     * @param userInfo
     * @param request
     * @return
     */
    @PostMapping(value = "addUserInfo")
    public ResponseResult addUserInfo(@RequestBody UserInfo userInfo,HttpServletRequest request){
        String createName = (String) request.getSession().getAttribute("username");
        logger.info("the userInfo ----> "+userInfo);
        MembershipInfo membershipInfo = new MembershipInfo();
        BeanCopyUtils.copyProperties(userInfo,membershipInfo);
        membershipInfo.setAuthId(IDUtils.getSixNum());
        membershipInfo.setCreateName(createName);
        membershipInfo.setUpdateName(createName);
        membershipInfo.setUpdateTime(new Date());
        logger.info("the memberinfo ----> "+membershipInfo);
        int resCode = membershipInfoServiceImpl.addUserInfo(membershipInfo,createName);
        if (resCode != 0 ){
            return ResponseResult.ok;
        }else {
            return ResponseResult.fail;
        }
    }

    /**
     * 删除用户信息及所分配的权限
     * @param authId
     * @return
     */
    @DeleteMapping(value = "removeUserInfo")
    public ResponseResult removeUserInfo(@Param("authId") String authId, @Param("username") String username, HttpServletRequest request){
        logger.info("the remove authId --->"+authId+";  the remove username --> "+ username);
        String deleteName = (String) request.getSession().getAttribute("username");
        int respCode = membershipInfoServiceImpl.removeUser(authId,deleteName,username);
        if (respCode != 0 ){
            return ResponseResult.ok;
        }else {
            return ResponseResult.fail;
        }

    }

    /**
     * 用户查询
     * @param username
     * @return
     */
    @GetMapping(value = "searchUserList")
    public ResponseResult searchUserList(@Param("username") String username){
        logger.info("the username --->" + username);
        List<MembershipInfo> allMembershipInfo = membershipInfoServiceImpl.getMembershipInfoByUsername(username);
        return new ResponseResult(0,"success",allMembershipInfo);
    }

    /**
     * 退出系统
     * @param request
     * @return
     */
    @GetMapping(value = "exitSystem")
    public ResponseResult exitSystem(HttpServletRequest request){
        request.getSession().invalidate();
        return ResponseResult.ok;
    }

    /**
     * 上传图片
     * @param file
     * @return
     */
    @PostMapping(value = "uploadOrgLogo")
    public ResponseResult uploadImage(@RequestParam("file") MultipartFile file){
        String key = null;
        try {
            if (null != file && file.getBytes().length > 0) {
                key = QiniuStorage.uploadImage(file.getBytes());
                logger.info("the file key --->"+key);
            }
        } catch (IOException e) {
            logger.warn("upload orgLogo fail",e);
            return ResponseResult.fail;
        }
        return new ResponseResult(0,"success",key);
    }
}
