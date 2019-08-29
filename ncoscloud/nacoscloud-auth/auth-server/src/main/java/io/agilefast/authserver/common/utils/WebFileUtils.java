/*******************************************************
 *Copyright (c) 2017 All Rights Reserved.
 *JDK版本： 1.8
 *公司名称：
 *命名空间：io.agilefast.common.utils
 *文件名：  WebFileUtils 
 *版本号：  V1.0.0.0
 *创建人：  daixirui
 *电子邮箱：daixirui@live.com
 *创建时间：2019-01-05 11:11
 *描述：
 *
 *=====================================================
 *修改标记
 *修改时间：2019-01-05 11:11
 *修改人：  daixirui
 *版本号：  V1.0.0.0
 *描述：
 *
 /******************************************************/
package io.agilefast.authserver.common.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebFileUtils {
    private static Logger logger = LoggerFactory.getLogger("WebFileUtils");
    /**
     * @param file    controller层获取到的web文件对象，暂时只处理了单文件
     * @param request 这个都熟悉了
     * @return 保存文件的绝对路径
     * 描述：
     * ** 不提供自定义文件名功能，在下载时可以自定义输出文件名，此处自定义文件名功能无意义
     * ** 文件名组成--->当前时间毫秒数_上传的文件名，没有做相同文件内容的文件重复检测，防止上传文件名冲突
     */
    public static String saveFile(MultipartFile file, String webFileUrl, HttpServletRequest request) {
        System.out.println();
        String realPath, rootPath = webFileUrl;

        if (webFileUrl.equals("")) {
            //设置主路径
            realPath = request.getServletContext().getRealPath("");
            //将路径设置到当前项目同级，并创建upload文件夹
            rootPath = new File(realPath).getParent() + "\\upload\\";
        }
        //组合文件名
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("\\") + 1);
        String filePath = rootPath + filename;
        File localFile = new File(filePath);

        // 检测是否存在目录，不存在则创建
        if (!localFile.getParentFile().exists()) {
            localFile.getParentFile().mkdirs();
        }
        try {
            //保存文件
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //返回文件的绝对路径
        return localFile.getAbsolutePath();
    }

    /**
     * @param file    controller层获取到的web文件对象，暂时只处理了单文件
     * @param request 这个都熟悉了
     * @return 保存文件的绝对路径
     * 描述：
     * ** 不提供自定义文件名功能，在下载时可以自定义输出文件名，此处自定义文件名功能无意义
     * ** 文件名组成--->当前时间毫秒数_上传的文件名，没有做相同文件内容的文件重复检测，防止上传文件名冲突
     */
    public static String saveFile(MultipartFile file, String webFileUrl,String fileFolder, HttpServletRequest request) {
        System.out.println();
        String realPath, rootPath = webFileUrl;

        if (webFileUrl.equals("")) {
            //设置主路径
            realPath = request.getServletContext().getRealPath("");
            //将路径设置到当前项目同级，并创建upload文件夹
            rootPath = new File(realPath).getParent() + "\\upload\\";
        }
        //组合文件名
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("\\") + 1);
        String filePath = rootPath + filename;
        File localFile = new File(filePath);

        // 检测是否存在目录，不存在则创建
        if (!localFile.getParentFile().exists()) {
            localFile.getParentFile().mkdirs();
        }
        try {
            //保存文件
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //返回文件的绝对路径
        return localFile.getAbsolutePath();
    }

    /**
     * @param fileAbsolutePath 下载文件的绝对路径
     * @param outputFileName   web浏览器下载文件框显示的文件名，tip：请将文件扩展名加载，本方法不处理文件类型
     * @param response         这个都熟悉了
     */
    public static void downFile(String fileAbsolutePath, String outputFileName, HttpServletResponse response) throws IOException {
        FileInputStream input=null;
        InputStream inputStream=null;
        try {
            input=new FileInputStream(fileAbsolutePath);
            //下载文件输入流
            inputStream = new BufferedInputStream(input);
            byte[] buffer = new byte[inputStream.available()];
            //转换字节码
            //inputStream.read(buffer);
            int count=0;
            while (count != -1) {//不能一次性读完，大文件会内存溢出（不能直接fis.read(buffer);
                count = inputStream.read(buffer);
            }
            inputStream.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" +
                    URLEncoder.encode(outputFileName, "UTF-8"));

            OutputStream outputStream  = new BufferedOutputStream(response.getOutputStream());
            //输出文件
            outputStream.write(buffer);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }finally {
            try {
                if (input!=null)
                {
                    input.close();
                }

            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            try {
                if (inputStream!=null)
                {
                    inputStream.close();
                }

            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }

    /**
     * 删除附件
     * @param filePath 附件路径
     */
    public static void deleteFile(String filePath)
    {
        File file = new File(filePath);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    /**
     * 下载文件
     * @param fileAbsolutePath 文件存储的绝对路径
     * @param response
     */
    public static void downloadFile(String fileAbsolutePath, HttpServletResponse response){
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("UTF-8");
        File file = new File(fileAbsolutePath);
        try (
                OutputStream out = response.getOutputStream();
                FileInputStream inputStream = new FileInputStream(file)) {
            int b = 0;
            byte[] buffer = new byte[1024];
            while (b != -1) {//不能一次性读完，大文件会内存溢出（不能直接fis.read(buffer);
                b = inputStream.read(buffer);
                out.write(buffer, 0, b);
            }
            out.flush();
        } catch (IOException e) {
            //logger.error("读取文件失败", e);
        }
    }

}
