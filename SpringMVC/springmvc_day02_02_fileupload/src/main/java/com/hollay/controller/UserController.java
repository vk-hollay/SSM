package com.hollay.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author hollay
 * @create 2021-01-29-12:28
 * @description
 */

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 传统文件上传（springmvc.xml配置文件解析器对象后会不可用）
     * @return
     */
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("传统文件上传。。。");

        // 使用 fileupload组件完成文件上传
        // 上传位置
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(realPath);

        // 判断该路径是否存在
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();//不存在则创建该文件夹
        }

        // 解析 request 对象， 获取上传文件项
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
        // 解析 request
        List<FileItem> itemList = fileUpload.parseRequest(request);
        // 遍历
        for (FileItem item : itemList) {
            // 进行判断，当前 item对象是否是上传文件项
            if (item.isFormField()) {
                //普通表单项
            } else {
                //上传文件项
                //获取上传文件的名称
                String fileName = item.getName();
                //把文件的名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" + fileName;
                //完成文件上传
                item.write(new File(realPath, fileName));
                System.out.println(fileName + "上传成功！");
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /**
     * SpringMVC文件上传，需在springmvc.xml配置文件解析器对象
     * @param request
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload/*这个对象名必须和文件表单项的name一样*/) throws Exception {
        System.out.println("springMVC文件上传。。。");
        // 上传位置
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(realPath);

        // 判断该路径是否存在
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();//不存在则创建该文件夹
        }

        //上传文件项
        //获取上传文件的名称
        String fileName = upload.getOriginalFilename();
        //把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        //完成文件上传
        upload.transferTo(new File(realPath, fileName));
        System.out.println(fileName + "上传成功");

        return "success";
    }

    /**
     * 跨服务器文件上传
     * （SpringMVC文件上传，需在springmvc.xml配置文件解析器对象）
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpload3")
    public String fileUpload3(MultipartFile upload/*这个对象名必须和文件表单项的name一样*/) throws Exception {
        System.out.println("跨服务器文件上传。。。");

        //定义上传文件服务器路径
        String path = "http://localhost:9090/fileuploadserver/uploads/";

        //上传文件项
        //获取上传文件的名称
        String fileName = upload.getOriginalFilename();

        //把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;

        //完成文件上传，跨服务器上传
        //1.创建客户端的对象
        Client client = Client.create();
        //2.和图片服务器进行连接
        WebResource webResource = client.resource(path + fileName);
        //3.上传文件
        webResource.put(upload.getBytes());
        System.out.println(fileName + "上传成功");

        return "success";
    }
}
