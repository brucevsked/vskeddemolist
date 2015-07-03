package com.vsked.test;

import java.io.InputStream;

import com.aspose.pdf.DocSaveOptions;
import com.aspose.pdf.License;

public class AsposePdfToDocx {

	public static void main(String[] args) {
		// Load source PDF file
		com.aspose.pdf.Document doc = new com.aspose.pdf.Document("c:/2.pdf");
		// Instantiate Doc SaveOptions instance
		DocSaveOptions saveOptions = new DocSaveOptions();
		// Set output file format as DOCX
		saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);
		// Save resultant DOCX file
		doc.save("c:/2t.docx", saveOptions);

	}
    public static boolean getLicense() {
        boolean result = false;
        InputStream is = AsposePdfToDocx.class.getClassLoader().getResourceAsStream("\\Aspose.Pdf.xml");

        License aposeLic = new License();
        try {
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
