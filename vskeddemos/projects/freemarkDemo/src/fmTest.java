import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import sun.misc.BASE64Encoder;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 使用freemark生成word
 * @author stormwy
 *
 */
public class fmTest {
	
	public static void main(String[] args){
		fmTest freemark = new fmTest("template/");
		freemark.setTemplateName("wordTemplate.ftl");
		freemark.setFileName("doc_"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date())+".doc");
		freemark.setFilePath("bin\\doc\\");
		freemark.createWord();
	}
	
	private void createWord(){
		
		Template t = null;
		try {
			t = configuration.getTemplate(templateName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File outFile = new File(filePath+fileName);
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Map map = new HashMap<String, Object>();
		map.put("name", "aaaaaaaaaaaa");
		map.put("country", "bbbbbb美丽");
		map.put("city", "ccccccc天下");
		map.put("time",new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()));
		map.put("image", getImageStr());
		try {
			t.process(map, out);
			out.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * freemark初始化
	 * @param templatePath 模板文件位置
	 */
	public fmTest(String templatePath) {
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setClassForTemplateLoading(this.getClass(),templatePath);		
	}	
	/**
	 * freemark模板配置
	 */
	private Configuration configuration;
	/**
	 * freemark模板的名字
	 */
	private String templateName;
	/**
	 * 生成文件名
	 */
	private String fileName;
	/**
	 * 生成文件路径
	 */
	private String filePath;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
	private String getImageStr() {
	     String imgFile = "d:/bbkk1.png";
	     InputStream in = null;
	     byte[] data = null;
	     try {
	       in = new FileInputStream(imgFile);
	       data = new byte[in.available()];
	       in.read(data);
	       in.close();
	     } catch (IOException e) {
	       e.printStackTrace();
	     }
	     BASE64Encoder encoder = new BASE64Encoder();
	     return encoder.encode(data);
	   }
	
}
