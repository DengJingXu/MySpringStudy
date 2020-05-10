package com.dengjingxu.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

/**
 * @author: dengjingxu
 * @date: 2020/5/4
 * @description: com.dengjingxu.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    /**
     *  javaweb传统的文件上传：
     *      前提条件：
     *          前端form表单的属性method必须为post（post请求内容大小比get大）
     *          前端form表单的属性enctype必须为multipart/form-data（指表单数据有多部分构成,既有文本数据,又有二进制）
     *          导包commons-fileupload,commons-io
     *   commons-fileupload提供的组件解析request对象，获取表单所有项，获取文件上传项，
     *          DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
     *          ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
     *          List<FileItem> fileItems = servletFileUpload.parseRequest(request);
     *          ileItems.stream().forEach(fileItem -> {
     *             //进行判断，当前item对象是否是上传文件项
     *             if(fileItem.isFormField()){
     *                 //是普通表单input项
     *             }else{
     *                 //是文件上传项
     *                 String name = fileItem.getName();
     *                 String uuid = UUID.randomUUID().toString().replace("-", "");
     *                 try {
     *                      //上传
     *                     fileItem.write(new File(realPath,uuid+name));
     *                 } catch (Exception e) {
     *                     e.printStackTrace();
     *                 }
     *                 fileItem.delete();
     *             }
     *         });
     *
     *    springmvc文件上传（需要上面说的两个包）：
     *              在springmvc配置配置文件中文件解析器CommonsMultipartResolver,
     *              在方法参数中加入参数MultipartFile对象，参数名必须与前端文件上传项的name属性值一致（请求会先到文件解析器，后返回MultipartFile对象回给方法参数）
     *              利用MultipartFile对象的transferTo方法进行文件上传
     *
     *    springmvc跨服务器文件上传（基于springmvc文件上传）：
     *              需要jar包jersey-core,jersey-client（sun公司的）
     *               //创建客户端对象
     *               Client client=Client.create();
     *               //和文件服务器连接
     *               WebResource resource = client.resource(serverPath);
     *               //上传文件
     *               resource.put(upload.getBytes());
     * @param request
     * @return
     */
    @RequestMapping("fileupload")
    public String fileUpLoad(HttpServletRequest request) throws FileUploadException, UnsupportedEncodingException {
        System.out.println("文件上传。。。");
        //使用fileupload组件完成文件上传
        request.setCharacterEncoding("utf-8");
        //上传位置
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        //创建文件夹
        File file=new File(realPath);
        if(!file.exists()){
            file.mkdirs();
            System.out.println("创建文件夹成功");
        }

        //解析request对象，获取文件上传项
        DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
        ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
        List<FileItem> fileItems = servletFileUpload.parseRequest(request);
        fileItems.stream().forEach(fileItem -> {
            //进行判断，当前item对象是否是上传文件项
            if(fileItem.isFormField()){
                //是普通表单input项
            }else{
                //是文件上传项
                String name = fileItem.getName();
                String uuid = UUID.randomUUID().toString().replace("-", "");
                try {
                    fileItem.write(new File(realPath,uuid+name));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                fileItem.delete();
            }
        });
        return "success";
    }
    @RequestMapping("fileupload2")
    public String fileUpLoad2(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("文件上传。。。");
        //使用fileupload组件完成文件上传
        request.setCharacterEncoding("utf-8");
        //上传位置
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        //创建文件夹
        File file=new File(realPath);
        if(!file.exists()){
            file.mkdirs();
            System.out.println("创建文件夹成功");
        }
        //解析request对象，获取文件上传项
        String name = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        upload.transferTo(new File(realPath,uuid+"_"+name));
        return "success";
    }
    @RequestMapping("fileupload3")
    public String fileUpLoad3( MultipartFile upload) throws IOException {
        System.out.println("跨服务器文件上传。。。");
        //获取或文件服务器的路径；
        String serverPath="http://localhost:8080/uploads/";
        //解析request对象，获取文件上传项
        String name = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");

        //创建客户端对象
        Client client=Client.create();
        //和文件服务器连接
        WebResource resource = client.resource(serverPath);
        //上传文件
        resource.put(upload.getBytes());
        return "success";
    }
}
