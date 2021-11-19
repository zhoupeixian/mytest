package com.example.demo.com.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 上传工具类
 * spring mvn支持
 */
public class UploadUtil {
	@Autowired
	public ApplicationContext applicationContext;



	/**
	 * 图片上传
	 * @param file
	 * @return 返回相对路径
	 * @throws Exception
	 */
	public static String upload(MultipartFile file, HttpServletRequest request) throws Exception{
		// 判断是否有上传文件
		if (Objects.isNull(file) || file.isEmpty() || Objects.isNull(file.getOriginalFilename())) {
			return null;
		}

		// 保存文件的相对目录
		String savePath = "/static/img/upload";
		String fileName = file.getOriginalFilename();
		String type = fileName.substring(fileName.lastIndexOf(".")+1);
		// 获取当前系统时间字符串
		String time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		// 构建新文件名
		String newFileName = time+"."+type;
		// 按指定路径重命名构建文件
		File savefile = new File("C:\\Users\\Administrator\\Desktop\\demo2\\src\\main\\resources\\static\\img\\upload",newFileName);
		// 若保存文件的文件夹不存在则创建
		if(!savefile.getParentFile().exists()){
			savefile.getParentFile().mkdirs();
		}
		System.out.println("上传文件绝对路径: "+savefile.getPath());
		file.transferTo(savefile);
		return savePath+"/"+newFileName;
	}

}
