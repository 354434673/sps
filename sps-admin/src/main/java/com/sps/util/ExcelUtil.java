package com.sps.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.sun.media.sound.InvalidFormatException;


public class ExcelUtil{
    private String val = null;
    private SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd"); //日期格式yyyy-mm-dd
    private DecimalFormat    df = new DecimalFormat("0");             //数字格式，防止长数字成为科学计数法形式，或者int变为double形式
    List<ArrayList<String>>  strLists = new ArrayList<ArrayList<String>>();  //存放Excel中的数据
    private final static String xls = "xls";  
    private final static String xlsx = "xlsx";  
	  /**
	   * 创建excel文档，
	   *
	   * @param list        数据
	   * @param keys        list中map的key数组集合
	   * @param columnNames excel的列名
	 * @throws IOException 
	   */
	  public static Workbook createWorkBook(String[] keys, String columnNames[]) throws IOException {
	    // 创建excel工作簿
	    Workbook wb = new HSSFWorkbook();
	    
	    // 创建第一个sheet（页），并命名
	    Sheet sheet = wb.createSheet("模板");
	    // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
	    for (int i = 0; i < keys.length; i++) {
	      sheet.setColumnWidth((short) i, (short) (35.7 * 150));
	    }
	    // 创建第一行
	    Row row = sheet.createRow((short) 0);
	 
	    // 创建两种单元格格式
	    CellStyle cs = wb.createCellStyle();
	    CellStyle cs2 = wb.createCellStyle();
	 
	    // 创建两种字体
	    Font f = wb.createFont();
	    Font f2 = wb.createFont();
	 
	    // 创建第一种字体样式（用于列名）
	    f.setFontHeightInPoints((short) 10);
	    f.setColor(IndexedColors.BLACK.getIndex());
	    f.setBoldweight(Font.BOLDWEIGHT_BOLD);
	 
	    // 创建第二种字体样式（用于值）
	    f2.setFontHeightInPoints((short) 10);
	    f2.setColor(IndexedColors.BLACK.getIndex());
	 
	    // 设置第一种单元格的样式（用于列名）
	    cs.setFont(f);
	    cs.setBorderLeft(CellStyle.BORDER_THIN);
	    cs.setBorderRight(CellStyle.BORDER_THIN);
	    cs.setBorderTop(CellStyle.BORDER_THIN);
	    cs.setBorderBottom(CellStyle.BORDER_THIN);
	    cs.setAlignment(CellStyle.ALIGN_CENTER);
	 
	    // 设置第二种单元格的样式（用于值）
	    cs2.setFont(f2);
	    cs2.setBorderLeft(CellStyle.BORDER_THIN);
	    cs2.setBorderRight(CellStyle.BORDER_THIN);
	    cs2.setBorderTop(CellStyle.BORDER_THIN);
	    cs2.setBorderBottom(CellStyle.BORDER_THIN);
	    cs2.setAlignment(CellStyle.ALIGN_CENTER);
	    //设置列名
	    for (int i = 0; i < columnNames.length; i++) {
	      Cell cell = row.createCell(i);
	      cell.setCellValue(columnNames[i]);
	      cell.setCellStyle(cs);
	    }
	    return wb;
	  }
		public static String exportExcel(HttpServletResponse response) throws IOException{
			
			String fileName ="店主邀请模板" + ".xls";
			// 填充projects数据
			String columnNames[] = { "店主名称*", "联系电话*" };
			String keys[] = { "name", "phone" };// map中的key
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			try {
				ExcelUtil.createWorkBook(keys, columnNames).write(os);
			} catch (IOException e) {
				e.printStackTrace();
			}
			byte[] content = os.toByteArray();
			InputStream is = new ByteArrayInputStream(content);
			// 设置response参数，可以打开下载页面
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(fileName.getBytes(), "iso-8859-1"));
			ServletOutputStream out = response.getOutputStream();
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				bis = new BufferedInputStream(is);
				bos = new BufferedOutputStream(out);
				byte[] buff = new byte[2048];
				int bytesRead;
				// Simple read/write loop.
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}
			} catch (final IOException e) {
				throw e;
			} finally {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			}
		    out.close();  
			return null;
		}
		//------------------------------导入------------------------------------
		public  List<ArrayList<String>>  importExcel(MultipartFile file){
			List<ArrayList<String>> list = null;
			try {
				String filename = file.getOriginalFilename();
				
				InputStream is = file.getInputStream();  
				
				   if(filename.endsWith(xls)){  
				        //2003  
					   list = poiReadHExcel(is);
				    }else if(filename.endsWith(xlsx)){  
				        //2007  
				    	list = poiReadXExcel(is);
				    }
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}  
			return list;
		}
	    /**
	     * @author: yangningsheng
	     * 2016-8-27 下午7:04:26
	     * @return List<ArrayList<String>>
	     * @throws FileNotFoundException,IOException,InvalidFormatException
	     * POI方式解析EXCEL表格(2007以上版本，xlsx)
	     */
	    private List<ArrayList<String>> poiReadXExcel(InputStream inputStream) throws FileNotFoundException, IOException, InvalidFormatException {
	        //FileInputStream input = new FileInputStream(file); //读取的文件路径   
	    	XSSFWorkbook wb = new XSSFWorkbook(new BufferedInputStream(inputStream));
	        
	        XSSFSheet sheet = wb.getSheetAt(0); //获取第一张表

	        int rowNum = sheet.getPhysicalNumberOfRows();//得到数据的行数
	        System.out.println("行数：" + rowNum);
	        strLists.clear();

	        //遍历行
	        for (int i = 0; i < rowNum; i++) 
	        {
	            List<String> strList = new ArrayList<String>();
	            XSSFRow row = sheet.getRow(i);
	            int colNum = row.getPhysicalNumberOfCells();//得到当前行中存在数据的列数
	            //遍历列
	            for (int j = 0; j < colNum; j++) {
	                XSSFCell cell = row.getCell(j);
	                strList.add(getXCellVal(cell));
	            }
	            strLists.add(i, (ArrayList<String>) strList); //存储该行
	        }

	        //打印
	        for (ArrayList<String> stringList : strLists) {
	            for (String str : stringList) {
	                System.out.print(str + "  ");
	            }
	            System.out.println();
	        }
	        wb.close();
	        return strLists;
	    }
	    private List<ArrayList<String>> poiReadHExcel(InputStream inputStream) throws FileNotFoundException, IOException, InvalidFormatException {
	    	//FileInputStream input = new FileInputStream(file); //读取的文件路径   
	    	HSSFWorkbook wb = new HSSFWorkbook(new BufferedInputStream(inputStream));
	    	
	    	HSSFSheet sheet = wb.getSheetAt(0); //获取第一张表
	    	
	    	int rowNum = sheet.getPhysicalNumberOfRows();//得到数据的行数
	    	System.out.println("行数：" + rowNum);
	    	strLists.clear();
	    	
	    	//遍历行
	    	for (int i = 0; i < rowNum; i++) 
	    	{
	    		List<String> strList = new ArrayList<String>();
	    		HSSFRow row = sheet.getRow(i);
	    		int colNum = row.getPhysicalNumberOfCells();//得到当前行中存在数据的列数
	    		//遍历列
	    		for (int j = 0; j < colNum; j++) {
	    			HSSFCell cell = row.getCell(j);
	    			strList.add(getHCellVal(cell));
	    		}
	    		strLists.add(i, (ArrayList<String>) strList); //存储该行
	    	}
	    	
	    	//打印
	    	for (ArrayList<String> stringList : strLists) {
	    		for (String str : stringList) {
	    			System.out.print(str + "  ");
	    		}
	    		System.out.println();
	    	}
	    	wb.close();
	    	return strLists;
	    }
	    /**xslx
	     * @author: yangningsheng
	     * 2016-8-25 下午7:40:05
	     * @param cell
	     * @return String
	     * 获取单元格中的值
	     */
	    private String getXCellVal(XSSFCell cell) {
	        switch (cell.getCellType()) {
	            case XSSFCell.CELL_TYPE_NUMERIC:
	                if (DateUtil.isCellDateFormatted(cell)) {
	                    val = fmt.format(cell.getDateCellValue()); //日期型
	                } else {
	                    val = df.format(cell.getNumericCellValue()); //数字型
	                }
	                break;
	            case XSSFCell.CELL_TYPE_STRING: //文本类型
	                val = cell.getStringCellValue();
	                break;
	            case XSSFCell.CELL_TYPE_BOOLEAN: //布尔型
	                val = String.valueOf(cell.getBooleanCellValue());
	                break;
	            case XSSFCell.CELL_TYPE_BLANK: //空白
	                val = cell.getStringCellValue();
	                break;
	            case XSSFCell.CELL_TYPE_ERROR: //错误
	                val = "错误";
	                break;
	            case XSSFCell.CELL_TYPE_FORMULA: //公式
	                try {
	                    val = String.valueOf(cell.getStringCellValue());
	                } catch (IllegalStateException e) {
	                    val = String.valueOf(cell.getNumericCellValue());
	                }
	                break;
	            default:
	                val = cell.getRichStringCellValue() == null ? null : cell.getRichStringCellValue().toString();
	        }
	        return val;
	}
	    /**xsl
	     * @author: yangningsheng
	     * 2016-8-25 下午7:40:05
	     * @param cell
	     * @return String
	     * 获取单元格中的值
	     */
	    private String getHCellVal(HSSFCell cell) {
	    	switch (cell.getCellType()) {
	    	case HSSFCell.CELL_TYPE_NUMERIC:
	    		if (DateUtil.isCellDateFormatted(cell)) {
	    			val = fmt.format(cell.getDateCellValue()); //日期型
	    		} else {
	    			val = df.format(cell.getNumericCellValue()); //数字型
	    		}
	    		break;
	    	case HSSFCell.CELL_TYPE_STRING: //文本类型
	    		val = cell.getStringCellValue();
	    		break;
	    	case HSSFCell.CELL_TYPE_BOOLEAN: //布尔型
	    		val = String.valueOf(cell.getBooleanCellValue());
	    		break;
	    	case HSSFCell.CELL_TYPE_BLANK: //空白
	    		val = cell.getStringCellValue();
	    		break;
	    	case HSSFCell.CELL_TYPE_ERROR: //错误
	    		val = "错误";
	    		break;
	    	case HSSFCell.CELL_TYPE_FORMULA: //公式
	    		try {
	    			val = String.valueOf(cell.getStringCellValue());
	    		} catch (IllegalStateException e) {
	    			val = String.valueOf(cell.getNumericCellValue());
	    		}
	    		break;
	    	default:
	    		val = cell.getRichStringCellValue() == null ? null : cell.getRichStringCellValue().toString();
	    	}
	    	return val;
	    }
}
