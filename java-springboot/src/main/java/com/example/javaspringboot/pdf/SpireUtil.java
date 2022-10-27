package com.example.javaspringboot.pdf;


import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;

import static com.example.javaspringboot.pdf.ItextpdfUtil.PDFPATH;


public class SpireUtil {

    public static void main(String[] args) throws InterruptedException {

        //创建PdfDocument实例
        PdfDocument doc = new PdfDocument();
        //加载PDF文件
        String path = "E:\\非技术书\\《自控力》（凯利·麦格尼格尔-著）.pdf";
        doc.loadFromFile(PDFPATH);

        //创建StringBuilder实例

        PdfPageBase page;
        //遍历PDF页面，获取每个页面的文本并添加到StringBuilder对象
        for (int i = 0; i < doc.getPages().getCount(); i++) {
            page = doc.getPages().get(i);
            System.out.println(page.extractText(true));

        }
        Thread.sleep(3000);
        doc.close();
    }
}
