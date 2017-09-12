/**
 * 
 */
package com.shop.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shop.util.WordUtil;

/**
 * @author Administrator
 *
 */
@Controller
public class WordAddImage {
	
	@SuppressWarnings("static-access")
	@RequestMapping("/upload")
	@ResponseBody 
	public String addImage(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		
		String image = "http://localhost:8081/ssm/1.png";
        System.out.println("开始");
        String path = request.getRealPath("/") + "Upload";
        String fileName = file.getOriginalFilename();
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // 保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }   
        try {
			new WordUtil().setImageWaterMarkAndProtect(path+"/"+fileName, image);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return path+"/"+fileName;
	}
}
