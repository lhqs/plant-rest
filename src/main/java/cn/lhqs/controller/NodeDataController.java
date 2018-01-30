package cn.lhqs.controller;

import cn.lhqs.common.ResponseResult;
import cn.lhqs.iservice.NodeZeroService;
import cn.lhqs.model.NodeZero;
import cn.lhqs.viewModel.NodeDataView;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-01-22 15:29
 * description : NodeZeroController.class
 * version : 1.0
 */

@RestController
@RequestMapping(value = "api")
public class NodeDataController {

    @Resource
    NodeZeroService nodeZeroServiceImpl;

    /**
     * 获取最近的指定数目的数据(node_one)
     * @param num
     * @return
     */
    @GetMapping(value = "nodeOneData")
    public ResponseResult getNodeOneData(@Param("num") int num){
        /*if(num == null){
        }*/
        if(num == 1){
            List<NodeDataView> nodeDataForNum = nodeZeroServiceImpl.getNodeOneDataForNum(num);
            return new ResponseResult(0,"success",nodeDataForNum.get(0));
        } else {
            List<NodeDataView> nodeDataForNum = nodeZeroServiceImpl.getNodeOneDataForNum(num);
            return new ResponseResult(0,"success",nodeDataForNum);
        }
    }

    /**
     * 获取最近的指定数目的数据(node_two)
     * @param num
     * @return
     */
    @GetMapping(value = "nodeTwoData")
    public ResponseResult getNodeTwoData(@Param("num") int num){
        if(num == 1){
            List<NodeDataView> nodeDataForNum = nodeZeroServiceImpl.getNodeZeroDataForNum(num);
            return new ResponseResult(0,"success",nodeDataForNum.get(0));
        } else {
            List<NodeDataView> nodeDataForNum = nodeZeroServiceImpl.getNodeZeroDataForNum(num);
            return new ResponseResult(0,"success",nodeDataForNum);
        }
    }

    /**
     * 获取最近的指定数目的数据(node_three)
     * @param num
     * @return
     */
    @GetMapping(value = "nodeThreeData")
    public ResponseResult getNodeThreeData(@Param("num") int num){
        if(num == 1){
            List<NodeDataView> nodeDataForNum = nodeZeroServiceImpl.getNodeThreeDataForNum(num);
            return new ResponseResult(0,"success",nodeDataForNum.get(0));
        } else {
            List<NodeDataView> nodeDataForNum = nodeZeroServiceImpl.getNodeThreeDataForNum(num);
            return new ResponseResult(0,"success",nodeDataForNum);
        }
    }
}
