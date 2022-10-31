package com.example.javaspringboot.pdf;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * @author hsm
 */
public class PdfboxUtil {
    public static String PDFPATH = "E:\\非技术书\\《自控力》（凯利·麦格尼格尔-著）.pdf";
    private static String FILEPATH = "D:/Maven权威指南中文版.doc";
    public static void main(String[] args) throws Exception {
        PDDocument document = PDDocument.load(new File(PDFPATH));
        if (!document.isEncrypted()) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            System.out.println("Text:" + text);
        }
        document.close();
    }
}
