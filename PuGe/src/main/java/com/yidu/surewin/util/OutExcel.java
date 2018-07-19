package com.yidu.surewin.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.yidu.surewin.base.domain.Area;

/**
 * 导出工具类
 * mySql导入到excel
 * @author crank
 * 
 */
public class OutExcel {
	/**
	 * 将数据导出到Excel表格
	 * @param areaList 区域集合
	 * @param path 接收的路径
	 * @return 字符串 String
	 */
	 @SuppressWarnings("deprecation")
		public static String outExcel(List<Area> areaList, String path){
			//创建工作簿
		 	HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
			//创建一个表单对象并赋值
			HSSFSheet hssfSheet =  hssfWorkbook.createSheet("区域表");
			//设置单元格的长度
			hssfSheet.setDefaultColumnWidth((short)16);
			//创建行
			HSSFRow hssfRow = hssfSheet.createRow(0);
			//创建列
			HSSFCell hssfCell = hssfRow.createCell((short)0);
			//为单元格取值为区域Id
			hssfCell.setCellValue("区域ID");
			//为第一行的单元格赋值
			hssfCell = hssfRow.createCell((short)1);
			//为单元格取值为省
			hssfCell.setCellValue("省");
			//为第二行的单元格赋值
			hssfCell = hssfRow.createCell((short)2);
			//为单元格取值为市
			hssfCell.setCellValue("市");
			//为第三行的单元格赋值
			hssfCell = hssfRow.createCell((short)3);
			//为单元格取值为区(县)
			hssfCell.setCellValue("区(县)");
			//为第四行的单元格赋值
			hssfCell = hssfRow.createCell((short)4);
			//为单元格取值为邮编
			hssfCell.setCellValue("邮编");
			//为第五行的单元格赋值
			hssfCell = hssfRow.createCell((short)5);
			//为单元格取值为简码
			hssfCell.setCellValue("简码");
			//为第六行的单元格赋值
			hssfCell = hssfRow.createCell((short)6);
			//为单元格取值为城市编码
			hssfCell.setCellValue("城市编码");
			//为第七行的单元格赋值
			hssfCell = hssfRow.createCell((short)7);
			//为单元格取值为状态
			hssfCell.setCellValue("是否操作");
			//为第八行的单元格赋值
			hssfCell = hssfRow.createCell((short)8);
			//为单元格取值为出港单位
			hssfCell.setCellValue("出港单位");
			//为第九行的单元格赋值
			hssfCell = hssfRow.createCell((short)9);
			//为单元格取值为进港单位
			hssfCell.setCellValue("进港单位");
			//为第十行的单元格赋值
			hssfCell = hssfRow.createCell((short)10);
			//为单元格取值为可服务区域
			hssfCell.setCellValue("可服务区域");
			//为第十一行的单元格赋值
			hssfCell = hssfRow.createCell((short)11);
			//为单元格取值为不可服务区域
			hssfCell.setCellValue("不可服务区域");
			//为第十二行的单元格赋值
			hssfCell = hssfRow.createCell((short)12);
			//为单元格取值为特殊区域
			hssfCell.setCellValue("特殊区域");
			//为第十三行的单元格赋值
			hssfCell = hssfRow.createCell((short)13);
			//为单元格取值为是否外网
			hssfCell.setCellValue("是否外网");
			//为第十四行的单元格赋值
			hssfCell = hssfRow.createCell((short)14);
			//为单元格取值为是否郊区县
			hssfCell.setCellValue("是否郊区县");
			//为第十五行的单元格赋值
			hssfCell = hssfRow.createCell((short)15);
			//为单元格取值为性质
			hssfCell.setCellValue("描述");
			//为第十六行的单元格赋值
			hssfCell = hssfRow.createCell((short)16);
			//为单元格取值为所属区域
			hssfCell.setCellValue("所属区域");
			//为第十七行的单元格赋值
			hssfCell = hssfRow.createCell((short)17);
			//为单元格取值为普运城市级别
			hssfCell.setCellValue("普运城市级别");
			//使用普通for循环进行遍历
			for(int i = 0;i<areaList.size();i++){
				//自动创建单元格
				hssfRow = hssfSheet.createRow(i+1);
				//创建区域Id的单元格
				hssfRow.createCell(0).setCellValue(areaList.get(i).getAreaId());
				//创建省的单元格
				hssfRow.createCell(1).setCellValue(areaList.get(i).getProvince());
				//创建市的单元格
				hssfRow.createCell(2).setCellValue(areaList.get(i).getCity());
				//创建区(县)的单元格
				hssfRow.createCell(3).setCellValue(areaList.get(i).getCounty());
				//创建邮编的单元格
				hssfRow.createCell(4).setCellValue(areaList.get(i).getPostCode());
				//创建简码的单元格
				hssfRow.createCell(5).setCellValue(areaList.get(i).getSimpleCode());
				//创建城市编码的单元格
				hssfRow.createCell(6).setCellValue(areaList.get(i).getCityCode());
				//创建状态的单元格
				hssfRow.createCell(7).setCellValue(areaList.get(i).getUseable());
				//创建出港单位的单元格
				hssfRow.createCell(8).setCellValue(areaList.get(i).getOutPort());
				//创建进港单位的单元格
				hssfRow.createCell(9).setCellValue(areaList.get(i).getInPort());
				//创建可服务区域的单元格
				hssfRow.createCell(10).setCellValue(areaList.get(i).getSerciceArea());
				//创建不可服务区域的单元格
				hssfRow.createCell(11).setCellValue(areaList.get(i).getUnserciceArea());
				//创建特殊区域的单元格
				hssfRow.createCell(12).setCellValue(areaList.get(i).getSpecialArea());
				//创建是否外网的单元格
				hssfRow.createCell(13).setCellValue(areaList.get(i).getOuterNet());
				//创建是否郊区县的单元格
				hssfRow.createCell(14).setCellValue(areaList.get(i).getSuburbs());
				//创建性质的单元格
				hssfRow.createCell(15).setCellValue(areaList.get(i).getDescription());
				//创建所属区域的单元格
				hssfRow.createCell(16).setCellValue(areaList.get(i).getZone());
				//创建普运城市级别的单元格
				hssfRow.createCell(17).setCellValue(areaList.get(i).getCityLevel());
			}
			//定义输入流
			FileOutputStream fileOutputStream;
			//定义一个空的字符串
			String result = "";
			try {
				//创建输入流将地址放入
				fileOutputStream = new FileOutputStream(path);
				//将输入流添加到工作簿中
				hssfWorkbook.write(fileOutputStream);
				//刷新
				fileOutputStream.flush();
				//关闭
				fileOutputStream.close();
				//返回成功
				result="success";
			} catch (FileNotFoundException e) {
				//返回失败
				result="file";
				e.printStackTrace();
			} catch (IOException e) {
				//返回失败
				result="file";
				e.printStackTrace();
			}
			//返回结果集
			return result;
		}
	 
}
