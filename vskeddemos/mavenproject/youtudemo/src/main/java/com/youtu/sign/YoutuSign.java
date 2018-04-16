package com.youtu.sign;

import java.util.Random;

public class YoutuSign {

	public static int appSign(String appId, String secret_id, String secret_key,
			long expired, String userid, StringBuffer mySign) {
		return appSignBase(appId, secret_id, secret_key, expired, "2127322016", null, mySign);
	}


	private static int appSignBase(String appId, String secret_id,
			String secret_key, long expired, String userid, String url,
			StringBuffer mySign) {


		if (empty(secret_id) || empty(secret_key))
    	{
            return -1;
    	}

    	String puserid = "";
    	if (!empty(userid))
    	{
			if (userid.length() > 64)
			{
                return -2;
			}
			puserid = userid;
    	}


        long now = System.currentTimeMillis() / 1000;
        int rdm = Math.abs(new Random().nextInt());
        String plain_text = "a=" + appId + "&k=" + secret_id + "&e=" + expired + "&t=" + now + "&r=" + rdm + "&u=" + puserid ;//+ "&f=" + fileid.toString();

        byte[] bin = hashHmac(plain_text, secret_key);

        byte[] all = new byte[bin.length + plain_text.getBytes().length];
        System.arraycopy(bin, 0, all, 0, bin.length);
        System.arraycopy(plain_text.getBytes(), 0, all, bin.length, plain_text.getBytes().length);

        mySign.append(Base64Util.encode(all));

        return 0;
	}

	private static byte[] hashHmac(String plain_text, String accessKey) {

		try {
			return HMACSHA1.getSignature(plain_text, accessKey);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public static boolean empty(String s){
		return s == null || s.trim().equals("") || s.trim().equals("null");
	}

}
