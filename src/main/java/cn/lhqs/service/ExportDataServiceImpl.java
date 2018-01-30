package cn.lhqs.service;

import cn.lhqs.common.TimeTools;
import cn.lhqs.iservice.DataInfoService;
import cn.lhqs.iservice.NodeZeroService;
import cn.lhqs.model.DataInfo;
import cn.lhqs.viewModel.NodeDataTime;
import cn.lhqs.viewModel.NodeDataView;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * author : lhqs
 * description : ExportDataServiceImpl.class
 * createTime : 2018-01-13 17:51
 * version : 1.0
 */
@Service
public class ExportDataServiceImpl implements ExportDataService{

    @Resource
    DataInfoService dataInfoServiceImpl;

    @Resource
    NodeZeroService nodeZeroServiceImpl;

    public OutputStream exportDataForExcel(DataInfo dataInfo,OutputStream outputStream) throws IOException {
        InputStream stream = ExportDataService.class.getResourceAsStream("/dataInfo.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(stream);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        XSSFSheet sheet = workbook.getSheetAt(0);

        String[] headTables = {"序号","湿度","温度","创建日期"};
        for(int index = 0; index < headTables.length; index++){
            sheet.getRow(0).getCell(index).setCellValue(headTables[index]);
        }

        List<DataInfo> dataInfoList = dataInfoServiceImpl.getDataInfoList();

        for(int rowIndex = 0; rowIndex < dataInfoList.size(); rowIndex++){
            int rowIndexPlus = rowIndex + 1;
            sheet.getRow(rowIndexPlus).getCell(0).setCellValue(rowIndexPlus);
            sheet.getRow(rowIndexPlus).getCell(1).setCellValue(dataInfoList.get(rowIndex).getTemperature());
            sheet.getRow(rowIndexPlus).getCell(2).setCellValue(dataInfoList.get(rowIndex).getHumidity());
            sheet.getRow(rowIndexPlus).getCell(3).setCellValue(dataInfoList.get(rowIndex).getCreateTime());
        }

        workbook.write(outputStream);
        outputStream.flush();
        workbook.close();
        return outputStream;
    }

    @Override
    public OutputStream exportNodeForExcel(DataInfo dataInfo,OutputStream outputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        XSSFSheet sheet = workbook.createSheet("节点数据");

        String[] headTables = {"序列","土壤温度","土壤湿度","叶片温度","PH值","创建日期"};
        XSSFRow row = sheet.createRow(0);
        for(int index = 0; index < headTables.length; index++){
            row.createCell(index).setCellValue(headTables[index]);
        }

        List<NodeDataView> nodeDatas = nodeZeroServiceImpl.getNodeOneDataForNum(44);

        for(int rowIndex = 1; rowIndex < nodeDatas.size() + 1; rowIndex++  ){
            XSSFRow subrow = sheet.createRow(rowIndex);

            subrow.createCell(0).setCellValue(rowIndex);
            subrow.createCell(1).setCellValue(nodeDatas.get(rowIndex-1).getGround()+"℃");
            subrow.createCell(2).setCellValue(nodeDatas.get(rowIndex-1).getHumidity()+"％");
            subrow.createCell(3).setCellValue(nodeDatas.get(rowIndex-1).getTemperature()+"℃");
            subrow.createCell(4).setCellValue(nodeDatas.get(rowIndex-1).getPh());
            subrow.createCell(5).setCellValue(TimeTools.dateFormat(nodeDatas.get(rowIndex-1).getCreateTime(),TimeTools.DATE_TYPE1));
        }
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return outputStream;
    }

    @Override
    public OutputStream exportExcelForHumidity(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        XSSFSheet sheet = workbook.createSheet("节点数据");

        String[] headTables = {"序列","土壤湿度","创建日期"};
        XSSFRow row = sheet.createRow(0);
        for(int index = 0; index < headTables.length; index++){
            row.createCell(index).setCellValue(headTables[index]);
        }

        List<NodeDataView> nodeDatas = nodeZeroServiceImpl.getNodeOneForHumidity(nodeDataTime);

        for(int rowIndex = 1; rowIndex < nodeDatas.size() + 1; rowIndex++  ){
            XSSFRow subrow = sheet.createRow(rowIndex);
            subrow.createCell(0).setCellValue(rowIndex);
            subrow.createCell(1).setCellValue(nodeDatas.get(rowIndex-1).getHumidity()+"％");
            subrow.createCell(2).setCellValue(TimeTools.dateFormat(nodeDatas.get(rowIndex-1).getCreateTime(),TimeTools.DATE_TYPE1));
        }
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return outputStream;
    }

    @Override
    public OutputStream exportExcelForGround(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        XSSFSheet sheet = workbook.createSheet("节点数据");

        String[] headTables = {"序列","土壤温度","创建日期"};
        XSSFRow row = sheet.createRow(0);
        for(int index = 0; index < headTables.length; index++){
            row.createCell(index).setCellValue(headTables[index]);
        }

        List<NodeDataView> nodeDatas = nodeZeroServiceImpl.getNodeOneForParams(nodeDataTime);

        for(int rowIndex = 1; rowIndex < nodeDatas.size() + 1; rowIndex++  ){
            XSSFRow subrow = sheet.createRow(rowIndex);
            subrow.createCell(0).setCellValue(rowIndex);
            subrow.createCell(1).setCellValue(nodeDatas.get(rowIndex-1).getGround()+"℃");
            subrow.createCell(2).setCellValue(TimeTools.dateFormat(nodeDatas.get(rowIndex-1).getCreateTime(),TimeTools.DATE_TYPE1));
        }
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return outputStream;
    }

    @Override
    public OutputStream exportExcelForTemperature(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        XSSFSheet sheet = workbook.createSheet("节点数据");

        String[] headTables = {"序列","页面温度","创建日期"};
        XSSFRow row = sheet.createRow(0);
        for(int index = 0; index < headTables.length; index++){
            row.createCell(index).setCellValue(headTables[index]);
        }

        List<NodeDataView> nodeDatas = nodeZeroServiceImpl.getNodeOneForParams(nodeDataTime);

        for(int rowIndex = 1; rowIndex < nodeDatas.size() + 1; rowIndex++  ){
            XSSFRow subrow = sheet.createRow(rowIndex);
            subrow.createCell(0).setCellValue(rowIndex);
            subrow.createCell(1).setCellValue(nodeDatas.get(rowIndex-1).getTemperature()+"℃");
            subrow.createCell(2).setCellValue(TimeTools.dateFormat(nodeDatas.get(rowIndex-1).getCreateTime(),TimeTools.DATE_TYPE1));
        }
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return outputStream;
    }

    @Override
    public OutputStream exportExcelForPh(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        XSSFSheet sheet = workbook.createSheet("节点数据");

        String[] headTables = {"序列","PH值","创建日期"};
        XSSFRow row = sheet.createRow(0);
        for(int index = 0; index < headTables.length; index++){
            row.createCell(index).setCellValue(headTables[index]);
        }

        List<NodeDataView> nodeDatas = nodeZeroServiceImpl.getNodeOneForParams(nodeDataTime);

        for(int rowIndex = 1; rowIndex < nodeDatas.size() + 1; rowIndex++  ){
            XSSFRow subrow = sheet.createRow(rowIndex);
            subrow.createCell(0).setCellValue(rowIndex);
            subrow.createCell(1).setCellValue(nodeDatas.get(rowIndex-1).getPh());
            subrow.createCell(2).setCellValue(TimeTools.dateFormat(nodeDatas.get(rowIndex-1).getCreateTime(),TimeTools.DATE_TYPE1));
        }
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return outputStream;
    }

    @Override
    public OutputStream exportExcelForGroundThree(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        XSSFSheet sheet = workbook.createSheet("节点数据");

        String[] headTables = {"序列","土壤温度","创建日期"};
        XSSFRow row = sheet.createRow(0);
        for(int index = 0; index < headTables.length; index++){
            row.createCell(index).setCellValue(headTables[index]);
        }

        List<NodeDataView> nodeDatas = nodeZeroServiceImpl.getNodeThreeForParams(nodeDataTime);

        for(int rowIndex = 1; rowIndex < nodeDatas.size() + 1; rowIndex++  ){
            XSSFRow subrow = sheet.createRow(rowIndex);

            subrow.createCell(0).setCellValue(rowIndex);
            subrow.createCell(1).setCellValue(nodeDatas.get(rowIndex-1).getGround()+"℃");
            subrow.createCell(2).setCellValue(TimeTools.dateFormat(nodeDatas.get(rowIndex-1).getCreateTime(),TimeTools.DATE_TYPE1));
        }
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return outputStream;
    }

    @Override
    public OutputStream exportExcelForHumidityThree(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        XSSFSheet sheet = workbook.createSheet("节点数据");

        String[] headTables = {"序列","土壤湿度","创建日期"};
        XSSFRow row = sheet.createRow(0);
        for(int index = 0; index < headTables.length; index++){
            row.createCell(index).setCellValue(headTables[index]);
        }

        List<NodeDataView> nodeDatas = nodeZeroServiceImpl.getNodeThreeForParams(nodeDataTime);

        for(int rowIndex = 1; rowIndex < nodeDatas.size() + 1; rowIndex++  ){
            XSSFRow subrow = sheet.createRow(rowIndex);
            subrow.createCell(0).setCellValue(rowIndex);
            subrow.createCell(1).setCellValue(nodeDatas.get(rowIndex-1).getHumidity()+"％");
            subrow.createCell(2).setCellValue(TimeTools.dateFormat(nodeDatas.get(rowIndex-1).getCreateTime(),TimeTools.DATE_TYPE1));
        }
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return outputStream;
    }

    @Override
    public OutputStream exportExcelForTemperatureThree(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        XSSFSheet sheet = workbook.createSheet("节点数据");

        String[] headTables = {"序列","页面温度","创建日期"};
        XSSFRow row = sheet.createRow(0);
        for(int index = 0; index < headTables.length; index++){
            row.createCell(index).setCellValue(headTables[index]);
        }

        List<NodeDataView> nodeDatas = nodeZeroServiceImpl.getNodeThreeForParams(nodeDataTime);

        for(int rowIndex = 1; rowIndex < nodeDatas.size() + 1; rowIndex++  ){
            XSSFRow subrow = sheet.createRow(rowIndex);
            subrow.createCell(0).setCellValue(rowIndex);
            subrow.createCell(1).setCellValue(nodeDatas.get(rowIndex-1).getTemperature()+"℃");
            subrow.createCell(2).setCellValue(TimeTools.dateFormat(nodeDatas.get(rowIndex-1).getCreateTime(),TimeTools.DATE_TYPE1));
        }
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return outputStream;
    }

    @Override
    public OutputStream exportExcelForPhThree(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        XSSFSheet sheet = workbook.createSheet("节点数据");

        String[] headTables = {"序列","PH值","创建日期"};
        XSSFRow row = sheet.createRow(0);
        for(int index = 0; index < headTables.length; index++){
            row.createCell(index).setCellValue(headTables[index]);
        }

        List<NodeDataView> nodeDatas = nodeZeroServiceImpl.getNodeThreeForParams(nodeDataTime);

        for(int rowIndex = 1; rowIndex < nodeDatas.size() + 1; rowIndex++  ){
            XSSFRow subrow = sheet.createRow(rowIndex);
            subrow.createCell(0).setCellValue(rowIndex);
            subrow.createCell(1).setCellValue(nodeDatas.get(rowIndex-1).getPh());
            subrow.createCell(2).setCellValue(TimeTools.dateFormat(nodeDatas.get(rowIndex-1).getCreateTime(),TimeTools.DATE_TYPE1));
        }
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return outputStream;
    }

    @Override
    public OutputStream exportExcelForGroundTwo(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        XSSFSheet sheet = workbook.createSheet("节点数据");

        String[] headTables = {"序列","土壤温度","创建日期"};
        XSSFRow row = sheet.createRow(0);
        for(int index = 0; index < headTables.length; index++){
            row.createCell(index).setCellValue(headTables[index]);
        }

        List<NodeDataView> nodeDatas = nodeZeroServiceImpl.getNodeTwoForParams(nodeDataTime);

        for(int rowIndex = 1; rowIndex < nodeDatas.size() + 1; rowIndex++  ){
            XSSFRow subrow = sheet.createRow(rowIndex);
            subrow.createCell(0).setCellValue(rowIndex);
            subrow.createCell(1).setCellValue(nodeDatas.get(rowIndex-1).getGround()+"℃");
            subrow.createCell(2).setCellValue(TimeTools.dateFormat(nodeDatas.get(rowIndex-1).getCreateTime(),TimeTools.DATE_TYPE1));
        }
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return outputStream;
    }

    @Override
    public OutputStream exportExcelForHumidityTwo(NodeDataTime nodeDataTime, OutputStream outputStream) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        XSSFSheet sheet = workbook.createSheet("节点数据");

        String[] headTables = {"序列","土壤湿度","创建日期"};
        XSSFRow row = sheet.createRow(0);
        for(int index = 0; index < headTables.length; index++){
            row.createCell(index).setCellValue(headTables[index]);
        }
        List<NodeDataView> nodeDatas = nodeZeroServiceImpl.getNodeTwoForParams(nodeDataTime);

        for(int rowIndex = 1; rowIndex < nodeDatas.size() + 1; rowIndex++  ){
            XSSFRow subrow = sheet.createRow(rowIndex);
            subrow.createCell(0).setCellValue(rowIndex);
            subrow.createCell(1).setCellValue(nodeDatas.get(rowIndex-1).getHumidity()+"％");
            subrow.createCell(2).setCellValue(TimeTools.dateFormat(nodeDatas.get(rowIndex-1).getCreateTime(),TimeTools.DATE_TYPE1));
        }
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return outputStream;
    }
}
