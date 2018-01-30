package cn.lhqs.service;

import cn.lhqs.common.TimeTools;
import cn.lhqs.dao.NodeZeroMapper;
import cn.lhqs.iservice.NodeZeroService;
import cn.lhqs.model.DataInfo;
import cn.lhqs.model.NodeZero;
import cn.lhqs.viewModel.NodeDataTime;
import cn.lhqs.viewModel.NodeDataView;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-01-22 17:26
 * description : NodeZeroServiceImpl.class
 * version : 1.0
 */
@Service
public class NodeZeroServiceImpl implements NodeZeroService {

    @Resource
    NodeZeroMapper nodeZeroMapper;

    @Override
    public List<NodeDataView> getNodeZeroDataForNum(int num) {
        List<NodeZero> nodeZeros = nodeZeroMapper.selectNumByNodeZero(num);
        List<NodeDataView> nodeDataViewList = new ArrayList<>();
        for (NodeZero nodeZero : nodeZeros) {
            // if(nodeZero.getGround() != null && nodeZero.getHumidity() != null && nodeZero.getTemperature() != null && nodeZero.getPh() != null){
            NodeDataView nodeDataView = new NodeDataView();
            nodeDataView.setId(nodeZero.getId());
            nodeDataView.setCreateTime(nodeZero.getCreateTime());
            nodeDataView.setCreateUser(nodeZero.getCreateUser());
            nodeDataView.setGround(Double.parseDouble(nodeZero.getGround()));
            nodeDataView.setHumidity(Double.parseDouble(nodeZero.getHumidity().substring(0, 5)));
            nodeDataViewList.add(nodeDataView);
        }
        return nodeDataViewList;
    }


    @Override
    public List<NodeDataView> getNodeOneDataForNum(int num) {
        List<NodeZero> nodeZeros = nodeZeroMapper.selectNumByNodeOne(num);
        List<NodeDataView> nodeDataViewList = new ArrayList<>();
        for (NodeZero nodeZero : nodeZeros) {
            NodeDataView nodeDataView = new NodeDataView();
            nodeDataView.setId(nodeZero.getId());
            nodeDataView.setCreateTime(nodeZero.getCreateTime());
            nodeDataView.setCreateUser(nodeZero.getCreateUser());
            nodeDataView.setGround(Double.parseDouble(nodeZero.getGround()));
            nodeDataView.setHumidity(Double.parseDouble(nodeZero.getHumidity().substring(0, 5)));
            nodeDataView.setTemperature(Double.parseDouble(nodeZero.getTemperature()));
            nodeDataView.setPh(Double.parseDouble(nodeZero.getPh()));
            nodeDataViewList.add(nodeDataView);
        }
        return nodeDataViewList;
    }


    @Override
    public List<NodeDataView> getNodeThreeDataForNum(int num) {
        List<NodeZero> nodeZeros = nodeZeroMapper.selectNumByNodeThree(num);
        List<NodeDataView> nodeDataViewList = new ArrayList<>();
        for (NodeZero nodeZero : nodeZeros) {
            NodeDataView nodeDataView = new NodeDataView();
            nodeDataView.setId(nodeZero.getId());
            nodeDataView.setCreateTime(nodeZero.getCreateTime());
            nodeDataView.setCreateUser(nodeZero.getCreateUser());
            nodeDataView.setGround(Double.parseDouble(nodeZero.getGround()));
            nodeDataView.setHumidity(Double.parseDouble(nodeZero.getHumidity().substring(0, 5)));
            nodeDataView.setTemperature(Double.parseDouble(nodeZero.getTemperature()));
            nodeDataView.setPh(Double.parseDouble(nodeZero.getPh()));
            nodeDataViewList.add(nodeDataView);
        }
        return nodeDataViewList;
    }

    @Override
    public List<NodeDataView> getNodeOneForHumidity(NodeDataTime nodeDataTime) {
        LocalDateTime startTime = TimeTools.dataTypeTransform(nodeDataTime.getStartDatetime(), TimeTools.DATE_TYPE1);
        LocalDateTime endTime = TimeTools.dataTypeTransform(nodeDataTime.getEndDatetime(), TimeTools.DATE_TYPE1);

        List<NodeZero> nodeZeros = nodeZeroMapper.selectDataForNodeOne(startTime, endTime);
        List<NodeDataView> nodeDList = new ArrayList<>();
        for (NodeZero nodeZero : nodeZeros) {
            NodeDataView nodeDataView = new NodeDataView();
            nodeDataView.setCreateTime(nodeZero.getCreateTime());
            nodeDataView.setHumidity(Double.parseDouble(nodeZero.getHumidity().substring(0, 5)));
            nodeDList.add(nodeDataView);
        }
        return nodeDList;
    }

    @Override
    public List<NodeDataView> getNodeOneForParams(NodeDataTime nodeDataTime) {
        LocalDateTime startTime = TimeTools.dataTypeTransform(nodeDataTime.getStartDatetime(), TimeTools.DATE_TYPE1);
        LocalDateTime endTime = TimeTools.dataTypeTransform(nodeDataTime.getEndDatetime(), TimeTools.DATE_TYPE1);

        List<NodeZero> nodeZeros = nodeZeroMapper.selectDataForNodeOne(startTime, endTime);
        List<NodeDataView> nodeDList = new ArrayList<>();
        for (NodeZero nodeZero : nodeZeros) {
            NodeDataView nodeDataView = new NodeDataView();
            nodeDataView.setCreateTime(nodeZero.getCreateTime());
            nodeDataView.setHumidity(Double.parseDouble(nodeZero.getHumidity().substring(0, 5)));
            nodeDataView.setGround(Double.parseDouble(nodeZero.getGround()));
            nodeDataView.setTemperature(Double.parseDouble(nodeZero.getTemperature()));
            nodeDataView.setPh(Double.parseDouble(nodeZero.getPh()));
            nodeDList.add(nodeDataView);
        }
        return nodeDList;
    }

    @Override
    public List<NodeDataView> getNodeTwoForParams(NodeDataTime nodeDataTime) {
        LocalDateTime startTime = TimeTools.dataTypeTransform(nodeDataTime.getStartDatetime(), TimeTools.DATE_TYPE1);
        LocalDateTime endTime = TimeTools.dataTypeTransform(nodeDataTime.getEndDatetime(), TimeTools.DATE_TYPE1);

        List<NodeZero> nodeZeros = nodeZeroMapper.selectDataForNodeTwo(startTime, endTime);
        List<NodeDataView> nodeDList = new ArrayList<>();
        for (NodeZero nodeZero : nodeZeros) {
            NodeDataView nodeDataView = new NodeDataView();
            nodeDataView.setCreateTime(nodeZero.getCreateTime());
            nodeDataView.setHumidity(Double.parseDouble(nodeZero.getHumidity().substring(0, 5)));
            nodeDataView.setGround(Double.parseDouble(nodeZero.getGround()));
            nodeDataView.setTemperature(Double.parseDouble(nodeZero.getTemperature()));
            nodeDataView.setPh(Double.parseDouble(nodeZero.getPh()));
            nodeDList.add(nodeDataView);
        }
        return nodeDList;
    }

    @Override
    public List<NodeDataView> getNodeThreeForParams(NodeDataTime nodeDataTime) {
        LocalDateTime startTime = TimeTools.dataTypeTransform(nodeDataTime.getStartDatetime(), TimeTools.DATE_TYPE1);
        LocalDateTime endTime = TimeTools.dataTypeTransform(nodeDataTime.getEndDatetime(), TimeTools.DATE_TYPE1);

        List<NodeZero> nodeZeros = nodeZeroMapper.selectDataForNodeThree(startTime, endTime);
        List<NodeDataView> nodeDList = new ArrayList<>();
        for (NodeZero nodeZero : nodeZeros) {
            NodeDataView nodeDataView = new NodeDataView();
            nodeDataView.setCreateTime(nodeZero.getCreateTime());
            nodeDataView.setHumidity(Double.parseDouble(nodeZero.getHumidity().substring(0, 5)));
            nodeDataView.setGround(Double.parseDouble(nodeZero.getGround()));
            nodeDataView.setTemperature(Double.parseDouble(nodeZero.getTemperature()));
            nodeDataView.setPh(Double.parseDouble(nodeZero.getPh()));
            nodeDList.add(nodeDataView);
        }
        return nodeDList;
    }
}