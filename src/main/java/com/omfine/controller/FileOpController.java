package com.omfine.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 这里需要尤为注意，Controller注解 ，必须用Controller，不能用原来的RestController！
 */
@Controller
@RequestMapping("/file")
public class FileOpController {

    public final static String IMG_PATH_PREFIX = "static/upload";

    @RequestMapping("/upload")
    public String uploadPage(HttpServletRequest request){
        return "update_file_page";
    }

    @ResponseBody
    @RequestMapping(value="/receives", method = RequestMethod.POST)
    public String receiveFiles(@RequestParam("files")MultipartFile files[]) throws IOException{
        if (files.length == 0){
            return "Not have any file.";
        }
        for (MultipartFile file : files){
            saveFile(file);
        }
        return "File uploaded success!";
    }

    /**
     * ResponseBody注解的意思是，这里返回的不是一个thymeleaf的模板名，就是一个简单的请求体
     * */
    @ResponseBody
    @RequestMapping(value="/receive", method = RequestMethod.POST)
    public String receiveFile(@RequestParam("file")MultipartFile file, String fileName, HttpServletRequest request) throws Exception{
        if(file.isEmpty()){
            return "没有选中任何文件！";
        }
        System.err.println("======================fileName: "  + fileName);
        //如下随便尝试几种获取module运行目录的几种方式
        //直接取相对目录的话，获取到的是project中新建的第一个module中的路径
        String directRelativePath = new String("src/main/resources" + File.separator + IMG_PATH_PREFIX);
        File directRelativeDir = new File(directRelativePath);
        System.out.println("直接写相对目录获取的路径, src/main/resources/static/upload: " + directRelativeDir.getAbsolutePath());

        //通过System.getProperty("user.dir")获取module路径
        String userDirPath = System.getProperty("user.dir");
        File userDirDir = new File(userDirPath + File.separator + IMG_PATH_PREFIX);
        System.out.println("通过系统属性user.dir获取的路径, System.getProperty(\"user.dir\") + /static/upload: "+userDirDir.getAbsolutePath());

        //request.getServletContext().getRealPath("/")获取运行时的路径
        String requestServletContextPath = request.getServletContext().getRealPath("/");
        File requestServletContextDir = new File(requestServletContextPath + File.separator + IMG_PATH_PREFIX);
        System.out.println("通过ServletContext获取的路径, request.getServletContext().getRealPath(\"/\") + /static/upload: "+requestServletContextDir.getAbsolutePath());


        //这里将文件放在resources目录的static/upload子目录下，通过ClassPathResource的方式先拿到application.properties文件的路径。
        //然后，取父目录得到resources目录。
        //先通过ClassPathResource获取application.properties的路径
        Resource applicationProperties = new ClassPathResource("application.properties");
        //然后通过取其父目录获得resources目录，设置上传文件的目录
        // String uploadFileSavePath = applicationProperties.getFile().getParentFile().getAbsolutePath() + File.separator + "static/upload";
        //存放目录
        String uploadFileSavePath = new File("D://uFiles").getAbsolutePath() + File.separator + "static/upload";

        File uploadFileSaveDir = new File(uploadFileSavePath);
        System.out.println("上传文件的存放目录："+uploadFileSaveDir.getAbsolutePath());
        if(!uploadFileSaveDir.exists()){
            // 递归生成文件夹
            uploadFileSaveDir.mkdirs();
        }

        // 拿到文件名
        String filename = file.getOriginalFilename();
        // 构建真实的文件路径
        File uploadFile = new File(uploadFileSaveDir.getAbsolutePath() + File.separator + filename);
        System.out.println("文件上传到：" + uploadFile.getAbsolutePath());
        //文件写到服务器，
        file.transferTo(uploadFile);

        return "File uploaded success!";
    }

    private boolean saveFile(MultipartFile file) throws IOException {
        //存放目录
        String uploadFileSavePath = new File("D://uFiles").getAbsolutePath() + File.separator + "static/upload";

        File uploadFileSaveDir = new File(uploadFileSavePath);
        System.out.println("上传文件的存放目录："+uploadFileSaveDir.getAbsolutePath());
        if(!uploadFileSaveDir.exists()){
            // 递归生成文件夹
            uploadFileSaveDir.mkdirs();
        }

        // 拿到文件名
        String filename = file.getOriginalFilename();
        // 构建真实的文件路径
        File uploadFile = new File(uploadFileSaveDir.getAbsolutePath() + File.separator + filename);
        System.out.println("文件上传到：" + uploadFile.getAbsolutePath());
        //文件写到服务器，
        file.transferTo(uploadFile);
        return true;
    }
}
