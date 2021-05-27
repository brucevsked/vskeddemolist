package com.vsked.common;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

public class Dom4JTest {

    private static final Logger log= LoggerFactory.getLogger(Dom4JTest.class);

    @Test
    public void successTest(){
        try {
            String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"urn:PFTMX\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"><SOAP-ENV:Body><ns1:OrderPreCheckResponse><OrderPreCheck xsi:type=\"xsd:string\"><?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<Data>\n" +
                    "  <Rec ID=\"UU1\">\n" +
                    "    <UUdone>100</UUdone>\n" +
                    "  </Rec>\n" +
                    "</Data>\n" +
                    "</OrderPreCheck></ns1:OrderPreCheckResponse></SOAP-ENV:Body></SOAP-ENV:Envelope>";
            //String charset="utf-8";
            //log.info(xmlStr.indexOf("<?xml version=\"1.0\" encoding=\"utf-8\"?>")+"");
            xmlStr=xmlStr.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>","");
            //xmlStr=xmlStr;
            log.info(xmlStr);
            SAXReader reader = new SAXReader();
            Document doc = reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")));

            Element root = doc.getRootElement();
            log.info(root.elements().size()+"");
            log.info("root element name:"+root.getName()+"");

            Element rootBody=root.element("Body");
            log.info(rootBody.elements().size()+"");

            Element OrderPreCheckResponse=rootBody.element("OrderPreCheckResponse");

            Element OrderPreCheck=OrderPreCheckResponse.element("OrderPreCheck");

            Element dataElement=OrderPreCheck.element("Data");

            Element recElement=dataElement.element("Rec");
            Element UUdoneElement=recElement.element("UUdone");//第一种情况，成功有UUdone元素
            String uudoneValue=UUdoneElement.getText();
            log.info(uudoneValue);

        }catch (Exception e){
            log.error("test error",e);
        }

    }


    @Test
    public void failTest(){
        try {
            String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns1=\"urn:PFTMX\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"><SOAP-ENV:Body><ns1:OrderPreCheckResponse><OrderPreCheck xsi:type=\"xsd:string\"><?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<Data>\n" +
                    "  <Rec ID=\"UU1\">\n" +
                    "    <UUerrorcode>1066</UUerrorcode>\n" +
                    "    <UUerrorinfo>商品票类数据出错</UUerrorinfo>\n" +
                    "  </Rec>\n" +
                    "</Data>\n" +
                    "</OrderPreCheck></ns1:OrderPreCheckResponse></SOAP-ENV:Body></SOAP-ENV:Envelope>";
            //String charset="utf-8";
            //log.info(xmlStr.indexOf("<?xml version=\"1.0\" encoding=\"utf-8\"?>")+"");
            xmlStr=xmlStr.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>","");
            //xmlStr=xmlStr;
            log.info(xmlStr);
            SAXReader reader = new SAXReader();
            Document doc = reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")));

            Element root = doc.getRootElement();
            log.info(root.elements().size()+"");
            log.info("root element name:"+root.getName()+"");

            Element rootBody=root.element("Body");
            log.info(rootBody.elements().size()+"");

            Element OrderPreCheckResponse=rootBody.element("OrderPreCheckResponse");

            Element OrderPreCheck=OrderPreCheckResponse.element("OrderPreCheck");

            Element dataElement=OrderPreCheck.element("Data");

            Element recElement=dataElement.element("Rec");

            Element UUerrorcodeElement=recElement.element("UUerrorcode");
            Element UUerrorinfoElement=recElement.element("UUerrorinfo");

            String errorCode=UUerrorcodeElement.getText();
            String errorInfo=UUerrorinfoElement.getText();

            log.info(errorCode+":"+errorInfo);


        }catch (Exception e){
            log.error("test error",e);
        }

    }


}
