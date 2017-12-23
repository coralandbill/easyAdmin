package com.imory.cn.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/12/13
 */
public class ExcelUtils {

    private static final String EXCEL_XLS_NAME = ".xls";

    private static final String EXCEL_XLSX_NAME = ".xlsx";

    public static void main(String args[]) {
        System.out.println(ExcelUtils.analysisXls("/Users/jzb/Desktop/单位全称危废调查表.xls"));
    }

    public static Workbook getWorkBook(String filePath) {
        Workbook workbook = null;
        try {
            InputStream inputStream = new FileInputStream(filePath);
            if (filePath.endsWith(ExcelUtils.EXCEL_XLS_NAME)) {
                workbook = new HSSFWorkbook(inputStream);
            } else if (filePath.endsWith(ExcelUtils.EXCEL_XLSX_NAME)) {
                workbook = new XSSFWorkbook(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }

    /**
     * 解析xls格式
     *
     * @param filePath
     * @return
     */
    public static Map<String, Object> analysisXls(String filePath) {
        Map<String, Object> detailMap = new HashMap<>();
        try {
            Workbook workbook = ExcelUtils.getWorkBook(filePath);
            Sheet sheet = workbook.getSheet("一企一档管理");
            if (sheet != null) {
                int rowNums = sheet.getPhysicalNumberOfRows();

                //获取第二行数据：单位名称
                Row row = sheet.getRow(1);
                Cell cell = row.getCell(1);
                detailMap.put("companyName", getCellValue(cell));

                //获取街道
                row = sheet.getRow(2);
                cell = row.getCell(1);
                detailMap.put("street", getCellValue(cell));

                //获取地址
                row = sheet.getRow(3);
                cell = row.getCell(1);
                detailMap.put("address", getCellValue(cell));

                //法人
                row = sheet.getRow(4);
                cell = row.getCell(1);
                detailMap.put("representative", getCellValue(cell));

                //电话
                cell = row.getCell(5);
                detailMap.put("telphone", getCellValue(cell));

                //联系人
                row = sheet.getRow(5);
                cell = row.getCell(1);
                detailMap.put("contacter", getCellValue(cell));

                //联系人电话
                cell = row.getCell(5);
                detailMap.put("contactMobile", getCellValue(cell));

                //行业类别
                row = sheet.getRow(6);
                cell = row.getCell(1);
                detailMap.put("industry", getCellValue(cell));

                //占地面积
                cell = row.getCell(5);
                detailMap.put("area", getCellValue(cell));

                //组织代码
                row = sheet.getRow(7);
                cell = row.getCell(1);
                detailMap.put("code", getCellValue(cell));

                //邮编
                cell = row.getCell(5);
                detailMap.put("zip", getCellValue(cell));

                //总投资
                row = sheet.getRow(8);
                cell = row.getCell(1);
                detailMap.put("investment", getCellValue(cell));

                //职工人数
                cell = row.getCell(5);
                String employee = getCellValue(cell);
                detailMap.put("employee", employee.substring(0, employee.lastIndexOf(".")));

                //存在问题
                row = sheet.getRow(rowNums - 3);
                cell = row.getCell(1);
                detailMap.put("problem", getCellValue(cell));

                //减排措施
                row = sheet.getRow(rowNums - 2);
                cell = row.getCell(1);
                detailMap.put("measure", getCellValue(cell));

                //结论及建议
                row = sheet.getRow(rowNums - 1);
                cell = row.getCell(1);
                detailMap.put("conclusion", getCellValue(cell));

                //危废列表
                List<Map<String, Object>> wfList = new ArrayList<>();
                for (int i = 0; i < rowNums - 12; i++) {
                    Map<String, Object> map = new HashMap<>();
                    row = sheet.getRow(9 + i);
                    //危废名称
                    cell = row.getCell(1);
                    map.put("name", getCellValue(cell));

                    //危废类别
                    cell = row.getCell(2);
                    map.put("wf_type", getCellValue(cell));

                    //危废代码
                    cell = row.getCell(3);
                    map.put("wf_code", getCellValue(cell));

                    //数量
                    cell = row.getCell(4);
                    map.put("wf_ta", getCellValue(cell));

                    //去向
                    cell = row.getCell(5);
                    map.put("direction", getCellValue(cell));

                    map.put("orderNum", i);

                    wfList.add(map);
                }
                detailMap.put("wfList", wfList);
                System.out.println(detailMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return detailMap;
    }

    public static boolean updateExcel(Map<String, Object> paramsMap) {
        String filePath = (String) paramsMap.get("filePath");
        Workbook workbook = ExcelUtils.getWorkBook(filePath);
        Sheet sheet = workbook.getSheetAt(0);

        if (sheet != null) {
            //单位名称
            String companyName = getStringUtil(paramsMap, "companyName");
            Row row = sheet.getRow(1);
            Cell cell = row.getCell(1);
            cell.setCellValue(companyName);

            //街道
            String street = getStringUtil(paramsMap, "street");
            row = sheet.getRow(2);
            cell = row.getCell(1);
            cell.setCellValue(street);

            //地址
            String address = getStringUtil(paramsMap, "address");
            row = sheet.getRow(3);
            cell = row.getCell(1);
            cell.setCellValue(address);

            //法人
            String representative = getStringUtil(paramsMap, "representative");
            row = sheet.getRow(4);
            cell = row.getCell(1);
            cell.setCellValue(representative);

            //电话
            String telphone = getStringUtil(paramsMap, "telphone");
            cell = row.getCell(5);
            cell.setCellValue(telphone);

            //联系人
            String contacter = getStringUtil(paramsMap, "contacter");
            row = sheet.getRow(5);
            cell = row.getCell(1);
            cell.setCellValue(contacter);

            //联系人电话
            String contactMobile = getStringUtil(paramsMap, "contactMobile");
            cell = row.getCell(5);
            cell.setCellValue(contactMobile);

            //行业类别
            String industry = getStringUtil(paramsMap, "industry");
            row = sheet.getRow(6);
            cell = row.getCell(1);
            cell.setCellValue(industry);

            //占地面积
            if (paramsMap.get("area") != null) {
                Double area = (Double) paramsMap.get("area");
                cell = row.getCell(5);
                cell.setCellValue(area);
            }

            //组织代码
            String code = getStringUtil(paramsMap, "code");
            row = sheet.getRow(7);
            cell = row.getCell(1);
            cell.setCellValue(code);

            //邮编
            String zip = getStringUtil(paramsMap, "zip");
            cell = row.getCell(5);
            cell.setCellValue(zip);

            //总投资
            if (paramsMap.get("investment") != null) {
                Double investment = (Double) paramsMap.get("investment");
                row = sheet.getRow(8);
                cell = row.getCell(1);
                cell.setCellValue(investment);
            }
            //职工人数
            if (paramsMap.get("employee") != null) {
                int employee = (int) paramsMap.get("employee");
                cell = row.getCell(5);
                cell.setCellValue(employee);
            }

            List<Map<String, Object>> wfList = (List<Map<String, Object>>) paramsMap.get("wfList");
            List<Map<String, Object>> tfList = (List<Map<String, Object>>) paramsMap.get("tfList");
            for (int i = 0; i < wfList.size(); i++) {
                row = sheet.getRow(9 + i);
                Map wfMap = wfList.get(i);
                if (i == 0) {
                    cell = row.getCell(4);
                    cell.setCellValue(wfMap.get("totalNum") + "年统计量");
                    continue;
                }
                Map tfMap = tfList.get(i - 1);
                //危废名称
                cell = row.getCell(1);
                cell.setCellValue(getStringUtil(wfMap, "name"));
                //危废类别
                cell = row.getCell(2);
                cell.setCellValue(getStringUtil(wfMap, "wf_type"));
                //危废代码
                cell = row.getCell(3);
                cell.setCellValue(getStringUtil(wfMap, "wf_code"));
                //统计量
                cell = row.getCell(4);
                cell.setCellValue(getStringUtil(wfMap, "totalNum"));
                //最近一次转移量
                if (tfMap.get("recentlyNum") != null) {
                    cell = row.getCell(5);
                    cell.setCellValue((Double) tfMap.get("recentlyNum"));
                }
                //最近一次转移去向
                cell = row.getCell(6);
                cell.setCellValue(getStringUtil(tfMap, "recentlyDirection"));
                //最近一次转移日期
                cell = row.getCell(7);
                cell.setCellValue(getStringUtil(tfMap, "recentlyDate"));
                //年度转移量
                if (tfMap.get("yearNum") != null) {
                    cell = row.getCell(8);
                    cell.setCellValue((Double) tfMap.get("yearNum"));
                }
                //系统预计库存量
                if (tfMap.get("repertoryNum") != null) {
                    cell = row.getCell(9);
                    cell.setCellValue((Double) tfMap.get("repertoryNum"));
                }
            }
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(filePath);
                workbook.write(out);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    public static String getStringUtil(Map map, String key) {
        return map.get(key) == null ? "" : (String) map.get(key);
    }

    public static String getCellValue(Cell cell) {
        String value;
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case NUMERIC: //数字
                    value = String.valueOf(cell.getNumericCellValue());
                    //value = cell.getStringCellValue();
                    break;
                case STRING:
                    value = cell.getStringCellValue();
                    break;
                case BOOLEAN:
                    value = String.valueOf(cell.getBooleanCellValue());
                    break;
                case BLANK://空值
                    value = "";
                    break;
                case ERROR://错误
                    value = "非法字符";
                    break;
                case FORMULA://公式
                    value = cell.getCellFormula();
                    break;
                case _NONE:
                    value = "未知类型";
                    break;
                default:
                    value = "未知类型(默认)";
                    break;
            }
        } else {
            value = "";
        }
        return value;
    }

}
