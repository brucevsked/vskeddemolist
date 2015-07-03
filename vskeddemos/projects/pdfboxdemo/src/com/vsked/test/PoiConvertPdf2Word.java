package com.vsked.test;

import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
 
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
 
public class PoiConvertPdf2Word {
 
    public static void main(String[] args) throws IOException {
        System.out.println("Document converted started");
        XWPFDocument doc = new XWPFDocument();
        String pdf = "c:/2.pdf";
        PdfReader reader = new PdfReader(pdf);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            TextExtractionStrategy strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            String text = strategy.getResultantText();
            XWPFParagraph p = doc.createParagraph();
            XWPFRun run = p.createRun();
            run.setText(text);
            run.addBreak(BreakType.PAGE);
        }
        FileOutputStream out = new FileOutputStream("c:/2t.docx");
        doc.write(out);
        out.close();
        reader.close();
        System.out.println("Document converted successfully");
    }
}

