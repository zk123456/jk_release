package cn.itcast.jk.controller.cargo.contract;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.service.OutProductService;
import cn.itcast.jk.vo.OutProductVO;
import cn.itcast.util.UtilFuns;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-7
 */
@Controller
public class OutProductController {
	@Autowired
	OutProductService outProductService;

	@RequestMapping("/cargo/outproduct/toedit.action")
	public String toedit(){			//项目中规定对于一个页面的它就成为edit
		
		return "/cargo/outproduct/jOutProduct.jsp";
	}
	
	@RequestMapping("/cargo/outproduct/print.action")
	public void print(String inputDate) throws IOException, ParseException{
		//获取数据
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("shipTime", inputDate);
		List<OutProductVO> oList = outProductService.find(paraMap);
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		
		int rowNo = 0;			//行号
		int colNo = 1;			//列号
		
		Row nRow = null;
		Cell cell = null;
		
		CellStyle curStyle = wb.createCellStyle();
		Font titleFont = wb.createFont();
		
		
		//标题	样式：横向居中、纵向居中、字体为宋体，字体为16号
		nRow = sheet.createRow(rowNo++);
		cell = nRow.createCell(1);
		cell.setCellValue(inputDate.replaceFirst("-0", "-").replaceFirst("-", "年") + "月份出货表");			//2014-12 2015-02
		nRow.setHeightInPoints(36);								//设置行高
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 9));		//合并单元格
		sheet.setColumnWidth(0, 1*256);
		sheet.setColumnWidth(1, 26*256);						//bug  当前值*256,精度不够
		
		CellStyle bigTitleStyle = wb.createCellStyle();			//创建样式对象
		bigTitleStyle.setAlignment(CellStyle.ALIGN_CENTER);		//横向居中
		bigTitleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中
		
		Font curFont = wb.createFont();							//创建字体对象
		curFont.setFontName("宋体");								//设置字体	
		curFont.setFontHeightInPoints((short)16);						//设置字体大小
		
		cell.setCellStyle(bigTitleStyle);
		
		bigTitleStyle.setFont(curFont);
		
		//小标题
		String[] titles = new String[]{"客户","订单号","货号","数量","工厂","附件","工厂交期","船期","贸易条款",};
		nRow = sheet.createRow(rowNo++);
		nRow.setHeightInPoints(26);
		for(int i=0;i<titles.length;i++){
			cell =  nRow.createCell(colNo++);
			cell.setCellValue(titles[i]);
			cell.setCellStyle(this.titleStyle(wb));
		}
		
		for(OutProductVO op : oList){
			colNo = 1;			//初始化
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(24);
			
			cell =  nRow.createCell(colNo++);
			cell.setCellValue(op.getCustomName());
			cell.setCellStyle(this.textStyle(wb,curStyle,titleFont));
			
			cell =  nRow.createCell(colNo++);
			cell.setCellValue(op.getContractNo());
			cell.setCellStyle(this.textStyle(wb,curStyle,titleFont));
			
			cell =  nRow.createCell(colNo++);
			cell.setCellValue(op.getProductNo());
			cell.setCellStyle(this.textStyle(wb,curStyle,titleFont));
			
			cell =  nRow.createCell(colNo++);
			cell.setCellValue(op.getCnumber());
			cell.setCellStyle(this.textStyle(wb,curStyle,titleFont));
			
			cell =  nRow.createCell(colNo++);
			cell.setCellValue(op.getFactoryName());
			cell.setCellStyle(this.textStyle(wb,curStyle,titleFont));
			
			cell =  nRow.createCell(colNo++);
			cell.setCellValue(outProductService.findExt(op.getContractProductId()));		//附件
			cell.setCellStyle(this.extStyle(wb,curStyle,titleFont));
			
			cell =  nRow.createCell(colNo++);
			cell.setCellValue(UtilFuns.dateTimeFormat(op.getDeliveryPeriod()));		//转换日期类型为字符类型，同时格式其样式yyyy-MM-dd
			cell.setCellStyle(this.textStyle(wb,curStyle,titleFont));
			
			cell =  nRow.createCell(colNo++);
			cell.setCellValue(UtilFuns.dateTimeFormat(op.getShipTime()));
			cell.setCellStyle(this.textStyle(wb,curStyle,titleFont));
			
			cell =  nRow.createCell(colNo++);
			cell.setCellValue(UtilFuns.convertNull(op.getTradeTerms()));
			cell.setCellStyle(this.textStyle(wb,curStyle,titleFont));
		}
		
		OutputStream os = new FileOutputStream(new File("c:\\testpoi.xls"));
		wb.write(os);	
	}
	
	public void print1() throws IOException{
		/*
		 * Excel 
		 * 1、创建一个Excel文件（工作簿）
		 * 2、创建一个Sheet（工作表）
		 * 3、创建一个行
		 * 4、创建一个列
		 * 5、定位到一个单元格，填写数据
		 * 6、修饰美化（不是必须）
		 * 7、写文件
		 */
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row nRow = sheet.createRow(4);			//下标从0开始，创建第五行
		Cell cell =  nRow.createCell(2);		//第三列
		
		cell.setCellValue("传智播客万年长!");
		
		OutputStream os = new FileOutputStream(new File("c:\\testpoi.xls"));
		wb.write(os);	
	}
	
	//小标题样式
	private CellStyle titleStyle(Workbook wb){
		CellStyle curStyle = wb.createCellStyle();
		curStyle.setAlignment(CellStyle.ALIGN_CENTER);
		curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		
		Font titleFont = wb.createFont();
		titleFont.setFontName("黑体");
		titleFont.setFontHeightInPoints((short)12);
		
		curStyle.setFont(titleFont);
		
		curStyle.setBorderTop(CellStyle.BORDER_THIN);			//上细线
		curStyle.setBorderBottom(CellStyle.BORDER_THIN);
		curStyle.setBorderLeft(CellStyle.BORDER_THIN);
		curStyle.setBorderRight(CellStyle.BORDER_THIN);
		
		return curStyle;
	}
	
	//文字样式
	private CellStyle textStyle(Workbook wb,CellStyle curStyle,Font titleFont){
		curStyle.setAlignment(CellStyle.ALIGN_LEFT);			//横向居左
		curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		
		titleFont.setFontName("Times New Roman");
		titleFont.setFontHeightInPoints((short)10);
		
		curStyle.setFont(titleFont);
		
		curStyle.setBorderTop(CellStyle.BORDER_THIN);			//上细线
		curStyle.setBorderBottom(CellStyle.BORDER_THIN);
		curStyle.setBorderLeft(CellStyle.BORDER_THIN);
		curStyle.setBorderRight(CellStyle.BORDER_THIN);
		
		return curStyle;
	}
	
	//附件样式
	private CellStyle extStyle(Workbook wb,CellStyle curStyle,Font titleFont){
		curStyle.setWrapText(true);
		curStyle.setAlignment(CellStyle.ALIGN_LEFT);			//横向居左
		curStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		
		titleFont.setFontName("Times New Roman");
		titleFont.setFontHeightInPoints((short)10);
		
		curStyle.setFont(titleFont);
		
		curStyle.setBorderTop(CellStyle.BORDER_THIN);			//上细线
		curStyle.setBorderBottom(CellStyle.BORDER_THIN);
		curStyle.setBorderLeft(CellStyle.BORDER_THIN);
		curStyle.setBorderRight(CellStyle.BORDER_THIN);
		
		return curStyle;
	}
}
