package com.vsked.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class CryptoToolTest{

    private static final Logger log = LoggerFactory.getLogger(CryptoToolTest.class);

    @Test
    public void base64Test(){
        //base64加密测试
        String encodeBeforeString="abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
        encodeBeforeString="abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
        log.debug("encodeBeforePassword value|{}|",encodeBeforeString);
        String encodeAfterString=CryptoTool.base64Encode(encodeBeforeString.getBytes());
        log.debug("encodeAfterPassword value|{}|",encodeAfterString);

        //base64解密测试
        byte[] decodeAfterByte=CryptoTool.base64Decode(encodeAfterString);
        String decodeAfterString=new String(decodeAfterByte);
        log.debug("decodeAfterString value|{}|",decodeAfterString);
    }

    @Test
    public void md5Encode(){
        //md5加密测试
        String encodeBeforePassword="abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
        encodeBeforePassword="abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
        log.debug("encodeBeforePassword value|{}|",encodeBeforePassword);
        String encodeAfterPassword=CryptoTool.md5Encode(encodeBeforePassword);
        log.debug("encodeAfterPassword value|{}|",encodeAfterPassword);
    }

    @Test
    public void aesCBCPKCS5Encode(){
        try {
            //AES/CBC/PKCS5Padding加密测试
            String encodeBeforePassword = "abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
            encodeBeforePassword = "abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
            log.debug("encodeBeforePassword value|{}|", encodeBeforePassword);
            String encodeAfterPassword = CryptoTool.aesCBCPKCS5Encode(encodeBeforePassword);
            log.debug("encodeAfterPassword value|{}|", encodeAfterPassword);

            //AES/CBC/PKCS5Padding解密测试
            String decodeResult=CryptoTool.aesCBCPKCS5Decode(encodeAfterPassword);
            log.debug("decodeResult value|{}|", decodeResult);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Test
    public void aesGCMNoPaddingEncode(){
        try{
            String key="vskyuelaiyuehaoa";
            //AES/GCM/NoPadding加密测试
            String encodeBeforePassword = "abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
            encodeBeforePassword = "abcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_+=|\\;:'\"[]{}天下英雄出你辈";
            log.debug("encodeBeforePassword value|{}|", encodeBeforePassword);
            String encodeAfterPassword = CryptoTool.aesGCMNoPaddingEncode(encodeBeforePassword,key);
            log.debug("encodeAfterPassword value|{}|", encodeAfterPassword);

            //AES/GCM/NoPadding解密测试
            String decodeResult=CryptoTool.aesGCMNoPaddingDecode(encodeAfterPassword,key);
            log.debug("decodeResult value|{}|", decodeResult);

        }catch (Exception e){
            log.error("aes code error",e);
        }
    }
    
    
    @Test
    public void RSAEncode() {
        String publicKeyStr="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7WyrYFsxgJxSaWDGQkOpGM+IzsLG6Bbq0mIcaNwMJ/L45jJ1TXiXLUfM/+I8iGZnPN5jk3ACcCtoKnhTHEi4Ngyd2iZfEEhH7Tv1y0Zkv1WcR8rZyg1xYdqnYos1mTYeJsO97Yj1PrkhyoH6XyAQC0zu33Am7nfBEVtZXbWUX9YcPka4BqzhKET3X7x0vTJ6fEMLSbNoO1/oW3TxyVMbXvAcyDulOHhpM2avr6wJYAdN9ZRKj3YUc0qC3kMWvZtuF+p9lwgFlCeeva8Tyh7vycOe+LPyIuOHUFmNmkJZZgu8bDj2u/JkXh8kRgpFbar4kLUFiZ8gCJ6j8vYQsyEt3QIDAQAB";
        String privateKeyStr="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDtbKtgWzGAnFJpYMZCQ6kYz4jOwsboFurSYhxo3Awn8vjmMnVNeJctR8z/4jyIZmc83mOTcAJwK2gqeFMcSLg2DJ3aJl8QSEftO/XLRmS/VZxHytnKDXFh2qdiizWZNh4mw73tiPU+uSHKgfpfIBALTO7fcCbud8ERW1ldtZRf1hw+RrgGrOEoRPdfvHS9Mnp8QwtJs2g7X+hbdPHJUxte8BzIO6U4eGkzZq+vrAlgB031lEqPdhRzSoLeQxa9m24X6n2XCAWUJ569rxPKHu/Jw574s/Ii44dQWY2aQllmC7xsOPa78mReHyRGCkVtqviQtQWJnyAInqPy9hCzIS3dAgMBAAECggEAMjCMsdvVRRjGmxwoDQ38ixAkHYEzRxDBJyQyWUBbGX7VeuQjw/LAEoRhI56RqUvsewOQDTTabxfd90xkVVBSEKruG5WM9wYwnkfUl9oTphbU6KBLFdltpH/ybnR7Kh40lYE/fx06qr28FPERGlbOzXS/8l/k+vg5yg+DfrnJ2dAi/f2IPCjKMz4/87C1wOXT/FdyPfjHyvrgxNzmLOE0PF8H+YZqhp1bROV78xE1h5ig+JTKgm9URq8PT5mobNUB3N8UomKEpINy9lPaFl4KQGtjA8KhF8zeORUF3T1lbcMjd8vEJZ+h6NxlWlCj0JluQPuznMB4owtzxpluTngjAQKBgQD5789jxrUgVbBKmPqeMHMdV7f7hdg6n16agw8tvTTn4hfAAO58GnaB6gVK2xppjYo69bWNmj7dvXb6u6sqltOvj1naQSDyEICg/+JxNNkjJPQr9J92zEBbu1Zso9p6wHrQfDe2Uxre///j389zRTnguoec04MO7humTLR/KL10/QKBgQDzLydsnDFvqi26YKuQOmpYx1k7pMGuqsaCqVIV6SsUFQwFjNQWzfYK3xQjcYpCRQPO8ImRxQbl4qrOMW6kJogz36eiYnJY+VuuzkReGRhnq1JJdIvWK57PFH2DJugicO3YaDPiLk5rc6mKQ05CAN/8HIHOtC+zwnEgIRQO03tiYQKBgDU1WHFlXCoGFAHNj40dw2P7yK9DT0UrqHg8bn7OSPUUrPmzORIykAgYSgglnPnbqBHlPUFoFPof27SFP2tRsL8vRXGxa9IcsUWVNB/loFRbCaBR86DW2tyshTmbqGd5kqvPxgyKpK3U0iUxAHkJw8iT7Ur1vHDxP/GnYsWvZqYBAoGAaWDilZbteTTmUeA4F+yoTsY7rbPMVhMcqFwU/PeoOjCQoAsRkLw5RSa7xEwcHHFpoA/tnSQixBU/7M/Q4QLtfIULUDuWz2VmzE4HpDr9r1a29quxOOJ4E8YOSXnfl6UV+/PTn8xvIPLi4c4eqE1WwhncSiUckqnMeZ674VzVF6ECgYEA9s06ffgMk8lh4jyZ24xmLM5tNb9yPJ1O7jgxeWOvA2YFjZB09WLw5t9RIm4X8xLsQm0CtmmbmeIkKdC/DAM7OT60+ftJtM5MVdB0wGMuLhAPEgLaGI3stmDhcRVe/uFVYlkD0UvCkCv4rYra7icCEWGzJxzNVnnobarY4HAjVD4=";

        String contentStr="this is your user password";
        try {
        	String contentBase64Encode=CryptoTool.base64Encode(contentStr.getBytes());
			String encodeContent=CryptoTool.RSAEncode(publicKeyStr, contentBase64Encode);
			log.debug(encodeContent);
		} catch (Exception e) {
			log.error("RSA Decode error",e);
		}        

    }
    
    @Test
    public void RSADecode() {
        String publicKeyStr="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7WyrYFsxgJxSaWDGQkOpGM+IzsLG6Bbq0mIcaNwMJ/L45jJ1TXiXLUfM/+I8iGZnPN5jk3ACcCtoKnhTHEi4Ngyd2iZfEEhH7Tv1y0Zkv1WcR8rZyg1xYdqnYos1mTYeJsO97Yj1PrkhyoH6XyAQC0zu33Am7nfBEVtZXbWUX9YcPka4BqzhKET3X7x0vTJ6fEMLSbNoO1/oW3TxyVMbXvAcyDulOHhpM2avr6wJYAdN9ZRKj3YUc0qC3kMWvZtuF+p9lwgFlCeeva8Tyh7vycOe+LPyIuOHUFmNmkJZZgu8bDj2u/JkXh8kRgpFbar4kLUFiZ8gCJ6j8vYQsyEt3QIDAQAB";
        String privateKeyStr="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDtbKtgWzGAnFJpYMZCQ6kYz4jOwsboFurSYhxo3Awn8vjmMnVNeJctR8z/4jyIZmc83mOTcAJwK2gqeFMcSLg2DJ3aJl8QSEftO/XLRmS/VZxHytnKDXFh2qdiizWZNh4mw73tiPU+uSHKgfpfIBALTO7fcCbud8ERW1ldtZRf1hw+RrgGrOEoRPdfvHS9Mnp8QwtJs2g7X+hbdPHJUxte8BzIO6U4eGkzZq+vrAlgB031lEqPdhRzSoLeQxa9m24X6n2XCAWUJ569rxPKHu/Jw574s/Ii44dQWY2aQllmC7xsOPa78mReHyRGCkVtqviQtQWJnyAInqPy9hCzIS3dAgMBAAECggEAMjCMsdvVRRjGmxwoDQ38ixAkHYEzRxDBJyQyWUBbGX7VeuQjw/LAEoRhI56RqUvsewOQDTTabxfd90xkVVBSEKruG5WM9wYwnkfUl9oTphbU6KBLFdltpH/ybnR7Kh40lYE/fx06qr28FPERGlbOzXS/8l/k+vg5yg+DfrnJ2dAi/f2IPCjKMz4/87C1wOXT/FdyPfjHyvrgxNzmLOE0PF8H+YZqhp1bROV78xE1h5ig+JTKgm9URq8PT5mobNUB3N8UomKEpINy9lPaFl4KQGtjA8KhF8zeORUF3T1lbcMjd8vEJZ+h6NxlWlCj0JluQPuznMB4owtzxpluTngjAQKBgQD5789jxrUgVbBKmPqeMHMdV7f7hdg6n16agw8tvTTn4hfAAO58GnaB6gVK2xppjYo69bWNmj7dvXb6u6sqltOvj1naQSDyEICg/+JxNNkjJPQr9J92zEBbu1Zso9p6wHrQfDe2Uxre///j389zRTnguoec04MO7humTLR/KL10/QKBgQDzLydsnDFvqi26YKuQOmpYx1k7pMGuqsaCqVIV6SsUFQwFjNQWzfYK3xQjcYpCRQPO8ImRxQbl4qrOMW6kJogz36eiYnJY+VuuzkReGRhnq1JJdIvWK57PFH2DJugicO3YaDPiLk5rc6mKQ05CAN/8HIHOtC+zwnEgIRQO03tiYQKBgDU1WHFlXCoGFAHNj40dw2P7yK9DT0UrqHg8bn7OSPUUrPmzORIykAgYSgglnPnbqBHlPUFoFPof27SFP2tRsL8vRXGxa9IcsUWVNB/loFRbCaBR86DW2tyshTmbqGd5kqvPxgyKpK3U0iUxAHkJw8iT7Ur1vHDxP/GnYsWvZqYBAoGAaWDilZbteTTmUeA4F+yoTsY7rbPMVhMcqFwU/PeoOjCQoAsRkLw5RSa7xEwcHHFpoA/tnSQixBU/7M/Q4QLtfIULUDuWz2VmzE4HpDr9r1a29quxOOJ4E8YOSXnfl6UV+/PTn8xvIPLi4c4eqE1WwhncSiUckqnMeZ674VzVF6ECgYEA9s06ffgMk8lh4jyZ24xmLM5tNb9yPJ1O7jgxeWOvA2YFjZB09WLw5t9RIm4X8xLsQm0CtmmbmeIkKdC/DAM7OT60+ftJtM5MVdB0wGMuLhAPEgLaGI3stmDhcRVe/uFVYlkD0UvCkCv4rYra7icCEWGzJxzNVnnobarY4HAjVD4=";
        //js base 64 with RSA
        String jsRSAEncode="Oh54kl8Iz/tC4x5PAihhwJ4dPZ1kwu+XyRyjkH/knBa3N4rqvMDfGDEwRol1S8Wa3HHoEIgWxG4Js/rkvW5un81BopJ0Viaz4WIL2xrxAoElLNaQvM6Ur3Irbe+k3bvzjoBc00w8D4NAamA+3nwYweNNajtBjytslvUixa4rWBqesGZWiy3oR+E6Ybp3jrblKscoBIJ/RimBnfE5+TrmdL5b27zzSiGtpNnFPCizlbN3bPOpXRZaeCEb/uDrP24hdJa1ATM9lbxKLN31rZdRTneAIashfE4GI4Sm81DbJB/hItSWG0nkqZ2fUmpzf0oebZsnnEKx3CbPcrPrArmmvw==";
        try {
			String decodeContent=CryptoTool.RSADecode(privateKeyStr, jsRSAEncode);
			log.debug(decodeContent);
		} catch (Exception e) {
			log.error("RSA Decode error",e);
		}
        
    	
    }

}
