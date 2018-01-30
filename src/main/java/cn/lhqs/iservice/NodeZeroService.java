package cn.lhqs.iservice;

import cn.lhqs.model.DataInfo;
import cn.lhqs.model.NodeZero;
import cn.lhqs.viewModel.NodeDataTime;
import cn.lhqs.viewModel.NodeDataView;

import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-01-22 15:30
 * description : NodeZeroService.class
 * version : 1.0
 */
public interface NodeZeroService {

    /**
     * 获取指定数量的最近数据(node_zero)
     * @param num
     * @return
     */
    List<NodeDataView> getNodeZeroDataForNum(int num);

    /**
     * 获取指定数量的最近数据(node_one)
     * @param num
     * @return
     */
    List<NodeDataView> getNodeOneDataForNum(int num);

    /**
     * 获取指定数量的最近数据(node_three)
     * @param num
     * @return
     */
    List<NodeDataView> getNodeThreeDataForNum(int num);

    // test
    List<NodeDataView> getNodeOneForHumidity(NodeDataTime nodeDataTime);

    List<NodeDataView> getNodeOneForParams(NodeDataTime nodeDataTime);

    List<NodeDataView> getNodeTwoForParams(NodeDataTime NodeDataTime);

    List<NodeDataView> getNodeThreeForParams(NodeDataTime nodeDataTime);

    // List<NodeDataView> getNodeOneForGroundNodeDataTime nodeDataTime);
    // List<NodeDataView> getNodeOneForTemperature(NodeDataTime nodeDataTime);
    // List<NodeDataView> getNodeOneForPh(NodeDataTime nodeDataTime);



}
