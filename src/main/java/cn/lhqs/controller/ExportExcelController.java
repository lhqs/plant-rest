package cn.lhqs.controller;

import cn.lhqs.common.ResponseResult;
import cn.lhqs.common.TimeTools;
import cn.lhqs.model.DataInfo;
import cn.lhqs.service.ExportDataService;
import cn.lhqs.viewModel.NodeDataTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author : lhqs
 * description : SendOperateController.class
 * createTime : 2018-01-13 15:22
 * version : 1.0
 */
@Controller
@RequestMapping(value = "api")
public class ExportExcelController {

    private static Logger logger = LoggerFactory.getLogger(ExportExcelController.class);

    @Resource
    ExportDataService exportDataServiceImpl;

    @GetMapping(value = "exportDataForExcel")
    public ResponseResult exportDataForExcel(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename=node_data("+ TimeTools.dateFormatNow(TimeTools.DATE_TYPE5)+").xlsx");
        DataInfo dataInfo = new DataInfo();
        try {
            exportDataServiceImpl.exportNodeForExcel(dataInfo,response.getOutputStream());
        } catch (IOException e) {
            logger.info("excel导出有误"+e);
            logger.info(e.getMessage());
            return ResponseResult.fail;
        }
        return ResponseResult.ok;
    }

    @GetMapping(value = "exportExcelForHumidity")
    public ResponseResult exportExcelForHumidity(NodeDataTime nodeDataTime, HttpServletResponse response){
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename=node_data("+ TimeTools.dateFormatNow(TimeTools.DATE_TYPE5)+").xlsx");
        try {
            exportDataServiceImpl.exportExcelForHumidity(nodeDataTime,response.getOutputStream());
        } catch (IOException e) {
            logger.info("excel导出有误"+e);
            logger.info(e.getMessage());
            return ResponseResult.fail;
        }
        return ResponseResult.ok;
    }

    @GetMapping(value = "exportExcelForTemperature")
    public ResponseResult exportExcelForTemperature(NodeDataTime nodeDataTime, HttpServletResponse response){
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename=node_data("+ TimeTools.dateFormatNow(TimeTools.DATE_TYPE5)+").xlsx");
        try {
            exportDataServiceImpl.exportExcelForTemperature(nodeDataTime,response.getOutputStream());
        } catch (IOException e) {
            logger.info("excel导出有误"+e);
            logger.info(e.getMessage());
            return ResponseResult.fail;
        }
        return ResponseResult.ok;
    }

    @GetMapping(value = "exportExcelForPh")
    public ResponseResult exportExcelForPh(NodeDataTime nodeDataTime, HttpServletResponse response){
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename=node_data("+ TimeTools.dateFormatNow(TimeTools.DATE_TYPE5)+").xlsx");
        try {
            exportDataServiceImpl.exportExcelForPh(nodeDataTime,response.getOutputStream());
        } catch (IOException e) {
            logger.info("excel导出有误"+e);
            logger.info(e.getMessage());
            return ResponseResult.fail;
        }
        return ResponseResult.ok;
    }

    @GetMapping(value = "exportExcelForGround")
    public ResponseResult exportExcelForGround(NodeDataTime nodeDataTime, HttpServletResponse response){
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename=node_data("+ TimeTools.dateFormatNow(TimeTools.DATE_TYPE5)+").xlsx");
        try {
            exportDataServiceImpl.exportExcelForGround(nodeDataTime,response.getOutputStream());
        } catch (IOException e) {
            logger.info("excel导出有误"+e);
            logger.info(e.getMessage());
            return ResponseResult.fail;
        }
        return ResponseResult.ok;
    }


    @GetMapping(value = "exportExcelForHumidityThree")
    public ResponseResult exportExcelForHumidityThree(NodeDataTime nodeDataTime, HttpServletResponse response){
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename=node_data("+ TimeTools.dateFormatNow(TimeTools.DATE_TYPE5)+").xlsx");
        try {
            exportDataServiceImpl.exportExcelForHumidityThree(nodeDataTime,response.getOutputStream());
        } catch (IOException e) {
            logger.info("excel导出有误"+e);
            logger.info(e.getMessage());
            return ResponseResult.fail;
        }
        return ResponseResult.ok;
    }

    @GetMapping(value = "exportExcelForTemperatureThree")
    public ResponseResult exportExcelForTemperatureThree(NodeDataTime nodeDataTime, HttpServletResponse response){
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename=node_data("+ TimeTools.dateFormatNow(TimeTools.DATE_TYPE5)+").xlsx");
        try {
            exportDataServiceImpl.exportExcelForTemperatureThree(nodeDataTime,response.getOutputStream());
        } catch (IOException e) {
            logger.info("excel导出有误"+e);
            logger.info(e.getMessage());
            return ResponseResult.fail;
        }
        return ResponseResult.ok;
    }

    @GetMapping(value = "exportExcelForPhThree")
    public ResponseResult exportExcelForPhThree(NodeDataTime nodeDataTime, HttpServletResponse response){
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename=node_data("+ TimeTools.dateFormatNow(TimeTools.DATE_TYPE5)+").xlsx");
        try {
            exportDataServiceImpl.exportExcelForPhThree(nodeDataTime,response.getOutputStream());
        } catch (IOException e) {
            logger.info("excel导出有误"+e);
            logger.info(e.getMessage());
            return ResponseResult.fail;
        }
        return ResponseResult.ok;
    }

    @GetMapping(value = "exportExcelForGroundThree")
    public ResponseResult exportExcelForGroundThree(NodeDataTime nodeDataTime, HttpServletResponse response){
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename=node_data("+ TimeTools.dateFormatNow(TimeTools.DATE_TYPE5)+").xlsx");
        try {
            exportDataServiceImpl.exportExcelForGroundThree(nodeDataTime,response.getOutputStream());
        } catch (IOException e) {
            logger.info("excel导出有误"+e);
            logger.info(e.getMessage());
            return ResponseResult.fail;
        }
        return ResponseResult.ok;
    }


    @GetMapping(value = "exportExcelForHumidityTwo")
    public ResponseResult exportExcelForHumidityTwo(NodeDataTime nodeDataTime, HttpServletResponse response){
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename=node_data("+ TimeTools.dateFormatNow(TimeTools.DATE_TYPE5)+").xlsx");
        try {
            exportDataServiceImpl.exportExcelForHumidityTwo(nodeDataTime,response.getOutputStream());
        } catch (IOException e) {
            logger.info("excel导出有误"+e);
            logger.info(e.getMessage());
            return ResponseResult.fail;
        }
        return ResponseResult.ok;
    }


    @GetMapping(value = "exportExcelForGroundTwo")
    public ResponseResult exportExcelForGroundTwo(NodeDataTime nodeDataTime, HttpServletResponse response){
        response.setHeader("Content-Type", "application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename=node_data("+ TimeTools.dateFormatNow(TimeTools.DATE_TYPE5)+").xlsx");
        try {
            exportDataServiceImpl.exportExcelForGroundTwo(nodeDataTime,response.getOutputStream());
        } catch (IOException e) {
            logger.info("excel导出有误"+e);
            logger.info(e.getMessage());
            return ResponseResult.fail;
        }
        return ResponseResult.ok;
    }

}
