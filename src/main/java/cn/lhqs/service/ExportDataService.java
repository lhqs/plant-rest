package cn.lhqs.service;

import cn.lhqs.model.DataInfo;
import cn.lhqs.viewModel.NodeDataTime;

import java.io.IOException;
import java.io.OutputStream;

/**
 * author : lhqs
 * description : ExportDataService.class
 * createTime : 2018-01-13 15:25
 * version : 1.0
 */
public interface ExportDataService {

    // OutputStream exportDataForExcel(DataInfo dataInfo,OutputStream outputStream) throws IOException;

    /**
     * 导出节点一的数据
     * @param dataInfo
     * @param outputStream
     * @return
     * @throws IOException
     */
    OutputStream exportNodeForExcel(DataInfo dataInfo,OutputStream outputStream) throws IOException;
    OutputStream exportExcelForHumidity(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException;
    OutputStream exportExcelForGround(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException;
    OutputStream exportExcelForTemperature(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException;
    OutputStream exportExcelForPh(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException;

    /**
     * 导出节点三的数据
     * @param nodeDataTime
     * @param outputStream
     * @return
     * @throws IOException
     */
    OutputStream exportExcelForGroundThree(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException;
    OutputStream exportExcelForHumidityThree(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException;
    OutputStream exportExcelForTemperatureThree(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException;
    OutputStream exportExcelForPhThree(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException;

    /**
     * 导出节点二的数据
     * @param nodeDataTime
     * @param outputStream
     * @return
     * @throws IOException
     */
    OutputStream exportExcelForGroundTwo(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException;
    OutputStream exportExcelForHumidityTwo(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException;

}
