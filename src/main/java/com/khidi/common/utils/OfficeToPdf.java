package com.khidi.common.utils;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComFailException;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

/***
 *
 * @author
 *
 * @date
 *
 */

public class OfficeToPdf {
    private static final int wdFormatPDF = 17;
    private static final int xlTypePDF = 0;
    private static final int ppSaveAsPDF = 32;

    public static void main(String[] args) {


        Map<String,Object> map =new HashedMap();
        map.put("sorry","111111111111111");
        map.put("sorry","2222222222222");
        System.out.println(map.size());

//
//
//
//
//
//            ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("spring-redis.xml");
//            final RedisTemplate<String, Object> redisTemplate = appCtx.getBean("redisTemplate",RedisTemplate.class);
//            //添加一个 key
//            ValueOperations<String, Object> value = redisTemplate.opsForValue();
//            value.set("lp", "hello word");
//            //获取 这个 key 的值
//            System.out.println(value.get("lp"));
//            //添加 一个 hash集合
//            HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
//            Map<String,Object> map = new HashMap<String,Object>();
//            map.put("name", "lp");
//            map.put("age", "26");
//            hash.putAll("lpMap", map);
//            //获取 map
//            System.out.println(hash.entries("lpMap"));
//            //添加 一个 list 列表
//            ListOperations<String, Object> list = redisTemplate.opsForList();
//            list.rightPush("lpList", "lp");
//            list.rightPush("lpList", "26");
//            //输出 list
//            System.out.println(list.range("lpList", 0, 1));
//            //添加 一个 set 集合
//            SetOperations<String, Object> set = redisTemplate.opsForSet();
//            set.add("lpSet", "lp");
//            set.add("lpSet", "26");
//            set.add("lpSet", "178cm");
//            //输出 set 集合
//            System.out.println(set.members("lpSet"));
//            //添加有序的 set 集合
//            ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
//            zset.add("lpZset", "lp", 0);
//            zset.add("lpZset", "26", 1);
//            zset.add("lpZset", "178cm", 2);
//            //输出有序 set 集合
//            System.out.println(zset.rangeByScore("lpZset", 0, 2));
//        }
//
//            Properties pro = System.getProperties();
//            System.out.println(pro.getProperty("file.encoding"));
    }

    /***
     * 判断需要转化文件的类型（Excel、Word、ppt）
     *
     * @param inputFile
     * @param pdfFile
     */
    private static int convert2PDF(String inputFile, String pdfFile) {
        String kind = getFileSufix(inputFile);
        File file = new File(inputFile);
        if (!file.exists()) {
            return -2;//文件不存在
        }
        if (kind.equals("pdf")) {
            return -3;//原文件就是PDF文件
        }
        if (kind.equals("doc")||kind.equals("docx")||kind.equals("txt")) {
            return OfficeToPdf.word2PDF(inputFile, pdfFile);
        }else if (kind.equals("ppt")||kind.equals("pptx")) {
            return OfficeToPdf.ppt2PDF(inputFile, pdfFile);
        }else if(kind.equals("xls")||kind.equals("xlsx")){
            return OfficeToPdf.Ex2PDF(inputFile, pdfFile);
        }else {
            return -4;
        }
    }

    /***
     * 判断文件类型
     *
     * @param fileName
     * @return
     */
    public static String getFileSufix(String fileName) {
        int splitIndex = fileName.lastIndexOf(".");
        return fileName.substring(splitIndex + 1);
    }


    /***
     * 改变文件后缀为.pdf
     *
     * @param fileName
     * @return
     */
    public static String changeFileSufix(String fileName) {
        int splitIndex = fileName.lastIndexOf(".");
        return fileName.substring(0,splitIndex)+".pdf";
    }

    /***
     *
     * Word转PDF
     *
     * @param inputFile
     * @param pdfFile
     * @return
     */

    public static int word2PDF(String inputFile, String pdfFile) {
        try {
            // 打开Word应用程序
            ActiveXComponent app = new ActiveXComponent("Word.Application");
            System.out.println("开始转化Word为PDF...");
            long date = new Date().getTime();
            // 设置Word不可见
            app.setProperty("Visible", new Variant(false));
            // 禁用宏
            app.setProperty("AutomationSecurity", new Variant(3));
            // 获得Word中所有打开的文档，返回documents对象
            Dispatch docs = app.getProperty("Documents").toDispatch();
            // 调用Documents对象中Open方法打开文档，并返回打开的文档对象Document
            Dispatch doc = Dispatch.call(docs, "Open", inputFile, false, true).toDispatch();
            /***
             *
             * 调用Document对象的SaveAs方法，将文档保存为pdf格式
             *
             * Dispatch.call(doc, "SaveAs", pdfFile, wdFormatPDF
             * word保存为pdf格式宏，值为17 )
             *
             */
            Dispatch.call(doc, "ExportAsFixedFormat", pdfFile, wdFormatPDF);// word保存为pdf格式宏，值为17
            System.out.println(doc);
            // 关闭文档
            long date2 = new Date().getTime();
            int time = (int) ((date2 - date) / 1000);

            Dispatch.call(doc, "Close", false);
            // 关闭Word应用程序
            app.invoke("Quit", 0);
            return time;
        } catch (Exception e) {
            // TODO: handle exception
            return -1;
        }

    }

    /***
     *
     * Excel转化成PDF
     *
     * @param inputFile
     * @param pdfFile
     * @return
     */
    public static int Ex2PDF(String inputFile, String pdfFile) {
        try {

            ComThread.InitSTA(true);
            ActiveXComponent ax = new ActiveXComponent("Excel.Application");
            System.out.println("开始转化Excel为PDF...");
            long date = new Date().getTime();
            ax.setProperty("Visible", false);
            ax.setProperty("AutomationSecurity", new Variant(3)); // 禁用宏
            Dispatch excels = ax.getProperty("Workbooks").toDispatch();

            Dispatch excel = Dispatch
                    .invoke(excels, "Open", Dispatch.Method,
                            new Object[] { inputFile, new Variant(false), new Variant(false) }, new int[9])
                    .toDispatch();
            // 转换格式
            Dispatch.invoke(excel, "ExportAsFixedFormat", Dispatch.Method, new Object[] { new Variant(0), // PDF格式=0
                    pdfFile, new Variant(xlTypePDF) // 0=标准 (生成的PDF图片不会变模糊) 1=最小文件
                    // (生成的PDF图片糊的一塌糊涂)
            }, new int[1]);

            // 这里放弃使用SaveAs
            /*
             * Dispatch.invoke(excel,"SaveAs",Dispatch.Method,new Object[]{
             * outFile, new Variant(57), new Variant(false), new Variant(57),
             * new Variant(57), new Variant(false), new Variant(true), new
             * Variant(57), new Variant(true), new Variant(true), new
             * Variant(true) },new int[1]);
             */
            long date2 = new Date().getTime();
            int time = (int) ((date2 - date) / 1000);
            Dispatch.call(excel, "Close", new Variant(false));

            if (ax != null) {
                ax.invoke("Quit", new Variant[] {});
                ax = null;
            }
            ComThread.Release();
            return time;
        } catch (Exception e) {
            // TODO: handle exception
            return -1;
        }
    }

    /***
     * ppt转化成PDF
     *
     * @param inputFile
     * @param pdfFile
     * @return
     */



    public static int ppt2PDF(String inputFile, String pdfFile) {
        try {
            ComThread.InitSTA(true);
            ActiveXComponent app = new ActiveXComponent("PowerPoint.Application");
//            app.setProperty("Visible", false);
            System.out.println("开始转化PPT为PDF...");
            long date = new Date().getTime();
            Dispatch ppts = app.getProperty("Presentations").toDispatch();
            Dispatch ppt = Dispatch.call(ppts, "Open", inputFile, true, // ReadOnly
                    //    false, // Untitled指定文件是否有标题
                    false// WithWindow指定文件是否可见
            ).toDispatch();
            Dispatch.invoke(ppt, "SaveAs", Dispatch.Method, new Object[]{
                    pdfFile,new Variant(ppSaveAsPDF)},new int[1]);
            System.out.println("PPT");
            Dispatch.call(ppt, "Close");
            long date2 = new Date().getTime();
            int time = (int) ((date2 - date) / 1000);
            app.invoke("Quit");
            return time;
        } catch (Exception e) {
            // TODO: handle exception
            return -1;
        }
    }
}