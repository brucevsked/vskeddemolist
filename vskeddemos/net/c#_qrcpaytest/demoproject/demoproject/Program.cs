/*
 * Created by SharpDevelop.
 * User: brucevsked
 * Date: 2018/6/19
 * Time: 17:47
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
using System;
using System.IO;
using System.Text;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Security;
using Org.BouncyCastle.Crypto.Parameters;

namespace demoproject
{
	class Program
	{
		public static void Main(string[] args)
		{
			//公钥
			string PUBLICKKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCQyamojHDMZHwghP/UV1Qu8MfHYPfMoBe+9kJOUMhh/oWUewEtLnv/hVIia2alTZWaUOu4fSQ0rQ9l35d7qw8pNEH9fLFocENt1OD8TxvwtG3URnWpWMBNB8XAx16+rBAbj+BsA6lQnGtEj0BD+jqLA9RJoJqt/BmK5lToXjXjiQIDAQAB";
			//私钥
			string PRIVATEKEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJDJqaiMcMxkfCCE/9RXVC7wx8dg98ygF772Qk5QyGH+hZR7AS0ue/+FUiJrZqVNlZpQ67h9JDStD2Xfl3urDyk0Qf18sWhwQ23U4PxPG/C0bdRGdalYwE0HxcDHXr6sEBuP4GwDqVCca0SPQEP6OosD1Emgmq38GYrmVOheNeOJAgMBAAECgYBc4jJH4Yi/ZrtGtWvVkgx8bJUNMAToLc/t/tc8nJBgZULWpS51CLwdiS7Oy+22oBYYQE9oNEfUzyzwosbwXCXFxysbBtnXlqLuMnbSjW7DFn8fpIkgu9OYI9ecEOABZ8PkrWohAVswjaim3rwa7cDNaT8YDFzb3KLcfM24x885gQJBAMKceEX6u2WTX2BSITeAW3QCcS2BzRgoHNvDLp4rV0UCHDJkygSJXk/fh+kmT+LDkiJ7kh7soIFpp2uiIjHFe7ECQQC+dcZ51u09xXRJEGx0FeuMrUgNXEqODopUQofIRo1YM6fCwzTcQ5kgX/2DPGOLr+vw2iezJDVaZhVAutBrC9NZAkEAsWo384QLByT9FDCLe6+WsAHx78yfjuAyvt4HR8a3PoAX+JEN4mjhA+wCWTjGJzKnrKv+oBaUlKYfLO6YQcuJYQJAEgtUd3yeU2jeoIF21PSysUxFdEaXJahJALyg4p+UipOyRCh8XJXm7wNJIGLbR4OuRc5VToqSp3Ledph8YHfpWQJAcfoU/lzoRG9XdX5v49dFULuFU5Wozq70bJDCxtXB6MKsL89vfJ17bx4Vq8eyDzQygh2qKkDF4aWzKGtvSIVp2g==";
			//发送参数
			string oldData="{agentnum:\"101\",inPhone:\"\",payCode:\"100701\",outPhone:\"\",channelNum:\"100001\",outCard:\"\",settlementName:\"\",realFee:\"100\",inCard:\"\",amount:\"5000\",crpIdNo:\"\",inBankName:\"中国招商银行\",outCardExpire:\"\",outCardCvv2:\"\",appOrderId:\"10120180615140044\"}" ;
			System.Text.Encoding encode = System.Text.Encoding.UTF8;
            byte[]  bytedata = encode.GetBytes( oldData);
    
            //base64编码
            string oldData_base64 = Convert.ToBase64String(bytedata,0,bytedata.Length);
			
			Console.WriteLine("|"+oldData_base64+"|");
	/*
    //base64解码	
    byte[] bpath = Convert.FromBase64String(oldData_base64);
    string oldData_decode = System.Text.UTF8Encoding.Default.GetString(bpath);
    Console.WriteLine("|"+oldData_decode+"|");
    */
  //----------------------------
  //私钥加密
  var sign_base64 = RSASignJavaBouncyCastle(oldData_base64,PRIVATEKEY,"MD5withRSA","UTF-8");
  
 Console.WriteLine("|"+sign_base64+"|");
  //----------------------------
  
 
    byte[]  byteReqData = encode.GetBytes( oldData_base64);
    //公钥加密
    string reqData_base64=EncryptWithPublicKey(PUBLICKKEY,byteReqData,"RSA/ECB/PKCS1Padding");
   Console.WriteLine("|"+reqData_base64+"|");
   
   
     //----------------------------发送前要将数据里点替换为空将+替换为%2b
     string postData="reqParam={\"serviceCode\":\"A0350\",\"request\":{\"sign\":\"4SSSUjZ/dq/1dC1D2H8X5xPu0m0IGdnxOWZolQg3OchvN6qD7agaYGtmFfEGZQkhaQucRJ8AvhJvRtnftJKo7i+PxlZfCBmRWDwAd/zvDrj51oTaST2BXt5javscVuerWzPLucbAQ/+epBpAHgLIH974n8p/Et2KeHUz82Q3HKg=\",\"data\":\"WbaBAtwvriZVq+grdmR1CrfB8Rmefmp1Z3cdKXaPEPMaQA7C+tsBDmIrs3Cim3K8onXXi5YE/qN7KHkBGi47kJe3absKremFlYAQJ1o13ePnM6f20qrs/RN3vORF0neIRaZ63oFKUUJ8JrIUID0/J1ncGHyv7uoL141Sjb6kyg+54ESe39PL+lmqsUU9q83tejDiQg+2H52/ZGw6iTKrUgJcQJucCXgu6RUdsOdAFfz90tmQkaWLC4YzMgY8+WosP3jUh8y/jhKm1oeZFcgnV++2wcsaqW7NF9mJufPfze0Gk0ShhmicUAcg++dSbozsfFWL0XaKkGrZ+n/rbmdv82vWD1nN5bJRqhxlSow8lADRndWQIDrvPK/klvEzpa43YypYvPg3kytV0i49FRuePOyihkH833GI+ZzVUTSfpI5wISq6gLaUArxVAEkfA7ItRAkgqygYmuiXOjZff5n6Lx92dRv5GzoSC/HzV9SLJ4ptjAfUvuRy8rJ58TTT51bw\",\"account\":\"15546873642\"}}";
     postData=postData.Replace(".","");
     postData=postData.Replace("+","%2b");
     
      //----------------------------验证签名
      //{sign=El8yLAqi8r7iNoD65OHGuMGp9fezdRzU9miKiCF/gPWPleNwBSd+2EVFxsxOPaQ5QjyuvylMTlCkj+ZHO2LBLUBeYx4iOaK3KVDGKWkGjM5plvhCCrs83dWN1nm4Fmb7MNZy1/m6eFn9hSo/g8i8VzeBQdDBcUPzHLu72FwmsWI=, respCode=0000, url=https://cashier.sandpay.com.cn/fastPay/quickPay/index?charset=UTF-8&signType=0&data={"body":{"body":"电器","frontUrl":"http://www.baidu.com","currencyCode":"156","orderCode":"180621092454978","extend":"","subject":"电器批发","userId":"2If65nxeY5","totalAmount":"000000005000","orderTime":"20180621092454","notifyUrl":"http://47.106.111.38:8001/QRCodeSys/ShandeQuickBackUrl.action","clearCycle":"0"},"head":{"channelType":"07","reqTime":"20180621092454","plMid":"","method":"sandPay.fastPay.quickPay.index","mid":"11957405","accessType":"1","productId":"00000016","version":"1.0"}}&sign=dwy8qserk6TTJNioqf9tDbACVeKbFxmI%2FT%2FdijXmirkRnmA77JYKlNY0euESBLUPvaQttLKhGPiAweCnPHgF4N5TSq5XFgmn7lp2NVwlJQ43j%2BU%2BOIlqwix%2BNQ6ZRYKpgNOMRUMGjqKGsVS7IEDdTJWJDNk6oAv3uNhkZH6rmmapilMvudglltTpOCCjGWe1jYI6Jqqhk3FOF0fOBLYCN5vedJ5rEwyfAfaAXTeJGEt1FIVACqtBw6S77RkXL2mmOAz9J6JGUDeU59yPj1RdwX0CHML4HjQtLOCr83O14%2FSLaox%2BpOsn5yS3OnxLVrlVj%2BQc%2FRNJVrYttlJBFysHzw%3D%3D&extend=, respInfo=一键快捷链接获取成功}
      string respSign="El8yLAqi8r7iNoD65OHGuMGp9fezdRzU9miKiCF/gPWPleNwBSd+2EVFxsxOPaQ5QjyuvylMTlCkj+ZHO2LBLUBeYx4iOaK3KVDGKWkGjM5plvhCCrs83dWN1nm4Fmb7MNZy1/m6eFn9hSo/g8i8VzeBQdDBcUPzHLu72FwmsWI=";
       Console.WriteLine("|"+respSign+"|");
       string respMap="{respCode=0000, url=https://cashier.sandpay.com.cn/fastPay/quickPay/index?charset=UTF-8&signType=0&data={\"body\":{\"body\":\"电器\",\"frontUrl\":\"http://www.baidu.com\",\"currencyCode\":\"156\",\"orderCode\":\"180621092454978\",\"extend\":\"\",\"subject\":\"电器批发\",\"userId\":\"2If65nxeY5\",\"totalAmount\":\"000000005000\",\"orderTime\":\"20180621092454\",\"notifyUrl\":\"http://47.106.111.38:8001/QRCodeSys/ShandeQuickBackUrl.action\",\"clearCycle\":\"0\"},\"head\":{\"channelType\":\"07\",\"reqTime\":\"20180621092454\",\"plMid\":\"\",\"method\":\"sandPay.fastPay.quickPay.index\",\"mid\":\"11957405\",\"accessType\":\"1\",\"productId\":\"00000016\",\"version\":\"1.0\"}}&sign=dwy8qserk6TTJNioqf9tDbACVeKbFxmI%2FT%2FdijXmirkRnmA77JYKlNY0euESBLUPvaQttLKhGPiAweCnPHgF4N5TSq5XFgmn7lp2NVwlJQ43j%2BU%2BOIlqwix%2BNQ6ZRYKpgNOMRUMGjqKGsVS7IEDdTJWJDNk6oAv3uNhkZH6rmmapilMvudglltTpOCCjGWe1jYI6Jqqhk3FOF0fOBLYCN5vedJ5rEwyfAfaAXTeJGEt1FIVACqtBw6S77RkXL2mmOAz9J6JGUDeU59yPj1RdwX0CHML4HjQtLOCr83O14%2FSLaox%2BpOsn5yS3OnxLVrlVj%2BQc%2FRNJVrYttlJBFysHzw%3D%3D&extend=, respInfo=一键快捷链接获取成功}";
       byte[]  bytedataresp = encode.GetBytes( respMap);
       string respMap_base64=Convert.ToBase64String(bytedataresp,0,bytedataresp.Length);
       bool flag=RSASignVerifyJavaBouncyCastle(PUBLICKKEY,respSign,respMap_base64);
      Console.WriteLine("|"+flag+"|");
      
    /*
  未测试第一种方式
var request = (HttpWebRequest)WebRequest.Create("http://www.leadnt.com/recepticle.aspx");
 
var postData = "thing1=hello";
    postData += "&thing2=world";
var data = Encoding.ASCII.GetBytes(postData);
 
request.Method = "POST";
request.ContentType = "application/x-www-form-urlencoded";
request.ContentLength = data.Length;
 
using (var stream = request.GetRequestStream())
{
    stream.Write(data, 0, data.Length);
}
 
var response = (HttpWebResponse)request.GetResponse();
 
var responseString = new StreamReader(response.GetResponseStream()).ReadToEnd();

未测试第二种方式
using (var client = new HttpClient())
{
    var values = new List<KeyValuePair<string, string>>();
    values.Add(new KeyValuePair<string, string>("thing1", "hello"));
    values.Add(new KeyValuePair<string, string>("thing2 ", "world"));
 
    var content = new FormUrlEncodedContent(values);
 
    var response = await client.PostAsync("http://www.mydomain.com/recepticle.aspx", content);
 
    var responseString = await response.Content.ReadAsStringAsync();
}
     * 
     * */
  
			Console.Write("Press any key to continue . . . ");
			Console.ReadKey(true);
		}
		
		
       #region 加签      
       /// <summary>  
       /// 基于BouncyCastle的RSA签名  
       /// </summary>  
       /// <param name="data"></param>  
       /// <param name="privateKeyJava"></param>  
       /// <param name="hashAlgorithm">JAVA的和.NET的不一样，如：MD5(.NET)等同于MD5withRSA(JAVA)</param>  
       /// <param name="encoding"></param>  
       /// <returns></returns>  
       public static string RSASignJavaBouncyCastle(string data, string privateKeyJava, string hashAlgorithm = "MD5withRSA", string encoding = "UTF-8")  
       {  
           RsaKeyParameters privateKeyParam = (RsaKeyParameters)PrivateKeyFactory.CreateKey(Convert.FromBase64String(privateKeyJava));  
           ISigner signer = SignerUtilities.GetSigner(hashAlgorithm);  
           signer.Init(true, privateKeyParam);//参数为true验签，参数为false加签  
           var dataByte = Encoding.GetEncoding(encoding).GetBytes(data);  
           signer.BlockUpdate(dataByte, 0, dataByte.Length);  
           //return Encoding.GetEncoding(encoding).GetString(signer.GenerateSignature()); //签名结果 非Base64String  
           return Convert.ToBase64String(signer.GenerateSignature());  
       }  
       #endregion
       
       #region 加签      
       /// <summary>  
       /// 基于BouncyCastle的RSA签名  
       /// </summary>  
       /// <param name="data"></param>  
       /// <param name="privateKeyJava"></param>  
       /// <param name="hashAlgorithm">JAVA的和.NET的不一样，如：MD5(.NET)等同于MD5withRSA(JAVA)</param>  
       /// <param name="encoding"></param>  
       /// <returns></returns>  
       public static bool RSASignVerifyJavaBouncyCastle(string publicKeyJava,string sign,string reqData)  
       {  
       	
           RsaKeyParameters publicKeyParam = (RsaKeyParameters)PublicKeyFactory.CreateKey(Convert.FromBase64String(publicKeyJava));  
           ISigner signer = SignerUtilities.GetSigner("MD5withRSA");  
           signer.Init(false, publicKeyParam);//参数为true验签，参数为false加签  
           var expectedSig = Convert.FromBase64String(sign);
           var msgBytes = Encoding.UTF8.GetBytes(reqData);
           signer.BlockUpdate(msgBytes, 0, msgBytes.Length);
           return signer.VerifySignature(expectedSig);
       }  
       #endregion
       
    #region 公钥加密私钥解密  

    /// <summary>  
    /// 公钥加密  
    /// </summary>  
    /// <param name="publicKey">RSA公钥 base64格式</param>  
    /// <param name="contentData">待加密的数据</param>  
    /// <param name="algorithm">加密算法</param>  
    /// <returns></returns>  
    public static string EncryptWithPublicKey(string publicKey, byte[] contentData, string algorithm = "RSA/ECB/PKCS1Padding")  
    {  
        return Convert.ToBase64String(EncryptWithPublicKey(Convert.FromBase64String(publicKey), contentData, algorithm));  
    }  
    /// <summary>  
    /// 公钥加密  
    /// </summary>  
    /// <param name="publicKey">RSA公钥</param>  
    /// <param name="contentData">待加密的数据</param>  
    /// <param name="algorithm">加密算法</param>  
    /// <returns></returns>  
    public static byte[] EncryptWithPublicKey(byte[] publicKey, byte[] contentData, string algorithm = "RSA/ECB/PKCS1Padding")  
    {  
    	byte[] encryptedData;
        RsaKeyParameters publicKeyParam = (RsaKeyParameters)PublicKeyFactory.CreateKey(publicKey);  
        var offSet = 0;
        var inputLen = contentData.Length;
        var plaiStream = new MemoryStream(contentData);
        var crypStream = new MemoryStream();
        for (var i = 0; inputLen - offSet > 0; offSet = i*117){
        	if (inputLen - offSet > 117){
        		var buffer = new Byte[117];
                plaiStream.Read(buffer, 0, 117);
                byte[] tmp1=Transform(publicKeyParam, buffer, algorithm, true);
                crypStream.Write(tmp1, 0, tmp1.Length);
        	}else{
        		var buffer = new Byte[inputLen - offSet];
        		plaiStream.Read(buffer, 0, inputLen - offSet);
        		byte[] tmp1=Transform(publicKeyParam, buffer, algorithm, true);
                crypStream.Write(tmp1, 0, tmp1.Length);
        	}
        	++i;
        }
        
        crypStream.Position = 0;
        encryptedData = crypStream.ToArray();
        
        return encryptedData;
    }  

    /// <summary>  
    /// 私钥解密  
    /// </summary>  
    /// <param name="privateKey">RSA私钥  base64格式</param>  
    /// <param name="content">待解密数据 base64格式</param>  
    /// <param name="encoding">解密出来的数据编码格式，默认UTF-8</param>  
    /// <param name="algorithm">加密算法</param>  
    /// <returns></returns>  
    public static string DecryptWithPrivateKey(string privateKey, string content, string encoding = "UTF-8", string algorithm = "RSA/ECB/PKCS1Padding")  
    {  
        return Encoding.GetEncoding(encoding).GetString(DecryptWithPrivateKey(Convert.FromBase64String(privateKey), Convert.FromBase64String(content), algorithm));  
    }  
    /// <summary>  
    /// 私钥解密  
    /// </summary>  
    /// <param name="privateKey">RSA私钥</param>  
    /// <param name="contentData">待解密数据</param>  
    /// <param name="algorithm">加密算法</param>  
    /// <returns></returns>  
    public static byte[] DecryptWithPrivateKey(byte[] privateKey, byte[] contentData, string algorithm)  
    {  
        RsaPrivateCrtKeyParameters privateKeyParam = (RsaPrivateCrtKeyParameters)PrivateKeyFactory.CreateKey(privateKey);  
        return Transform(privateKeyParam, contentData, algorithm, false);  
    }  
    private static byte[] Transform(AsymmetricKeyParameter key, byte[] contentData, string algorithm, bool forEncryption)  
    {  
        var c = CipherUtilities.GetCipher(algorithm);  
        c.Init(forEncryption, new ParametersWithRandom(key));  
        return c.DoFinal(contentData);  
    }  
    #endregion  
}
	}
	
