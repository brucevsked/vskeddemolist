package com.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public final class Demo {

    public static void main(String[] args) throws IOException {
        String ip = "58.20.184.187"; // 代理主机地址
        int port = 9091; // 代理主机端口

        // 使用OKHttp库
        OKHttpProxy.build(ip, port).test();
        // OKHttpProxy.build(ip, port, "aaaaaa", "bbbbbb").test(); // 代理认证

        // 使用HttpClient库
        // HttpClientProxy.build(ip, port).test();
        // HttpClientProxy.build(ip, port, "aaaaaa", "bbbbbb").test(); // 代理认证
    }

    /**
     * OKHttp库使用代理
     */
    static class OKHttpProxy {

        String proxyHost;
        int proxyPort;
        String proxyAccount;
        String proxyPwd;

        /**
         * @param host 代理主机地址
         * @param port 代理主机端口
         */
        public static OKHttpProxy build(String host, int port) {
            OKHttpProxy proxy = new OKHttpProxy();
            proxy.proxyHost = host;
            proxy.proxyPort = port;
            return proxy;
        }

        /**
         * @param host 代理主机地址
         * @param port 代理主机端口
         * @param acc 代理认证账号
         * @param pwd 代理认证口令
         */
        public static OKHttpProxy build(String host, int port, String acc, String pwd) {
            OKHttpProxy proxy = new OKHttpProxy();
            proxy.proxyHost = host;
            proxy.proxyPort = port;
            proxy.proxyAccount = acc;
            proxy.proxyPwd = pwd;
            return proxy;
        }

        public void test() throws IOException {
            String targetUrl = "http://myip.ipip.net";

            OkHttpClient client = null;
            if (proxyAccount == null || proxyPwd == null) {
                client = getHttpClient(proxyHost, proxyPort);
            } else {
                // 账号密码验证
                client = getHttpClient(proxyHost, proxyPort, proxyAccount, proxyPwd);
            }

            Request request = new Request.Builder()
                    .url(targetUrl)
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        }

        /**
         * 代理不需要账号密码认证的httpClient
         */
        private static OkHttpClient getHttpClient(String proxyHost, int proxyPort) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
            return new OkHttpClient.Builder()
                    .proxy(proxy)
                    .build();
        }

        /**
         * 代理需要账号密码认证的httpClient
         */
        private static OkHttpClient getHttpClient(String proxyHost, int proxyPort, String acc, String pwd) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
            // 账号密码验证
            Authenticator authenticator = new Authenticator() {
                @Override
                public Request authenticate(Route route, Response resp) throws IOException {
                    String credential = Credentials.basic(acc, pwd);
                    return resp.request().newBuilder().header("Proxy-Authorization", credential).build();
                }
            };
            return new OkHttpClient.Builder()
                    .proxy(proxy)
                    .proxyAuthenticator(authenticator)
                    .build();
        }

    }
    
    /**
     * HttpClient库使用代理
     */
    static class HttpClientProxy {
        String proxyHost;
        int proxyPort;
        String proxyAccount;
        String proxyPwd;

        /**
         * @param host 代理主机地址
         * @param port 代理主机端口
         */
        public static HttpClientProxy build(String host, int port) {
            HttpClientProxy proxy = new HttpClientProxy();
            proxy.proxyHost = host;
            proxy.proxyPort = port;
            return proxy;
        }

        /**
         * @param host 代理主机地址
         * @param port 代理主机端口
         * @param acc 代理认证账号
         * @param pwd 代理认证口令
         */
        public static HttpClientProxy build(String host, int port, String acc, String pwd) {
            HttpClientProxy proxy = new HttpClientProxy();
            proxy.proxyHost = host;
            proxy.proxyPort = port;
            proxy.proxyAccount = acc;
            proxy.proxyPwd = pwd;
            return proxy;
        }

        public void test() throws IOException {
            String targetUrl = "http://myip.ipip.net";

            CloseableHttpClient client = null;
            if (proxyAccount == null || proxyPwd == null) {
                client = getHttpClient(proxyHost, proxyPort);
            } else {
                // 账号密码验证
                client = getHttpClient(proxyHost, proxyPort, proxyAccount, proxyPwd);
            }
            HttpGet httpGet = new HttpGet(targetUrl);
            CloseableHttpResponse response = client.execute(httpGet);
            String resultStr = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            System.out.println(resultStr);
        }

        /**
         * 代理不需要账号密码认证的httpClient
         */
        private static CloseableHttpClient getHttpClient(String proxyHost, int proxyPort) {
            HttpHost proxy = new HttpHost(proxyHost, proxyPort, "HTTP");
            return HttpClients.custom()
                    .setProxy(proxy)
                    .build();
        }

        /**
         * 代理需要账号密码认证的httpClient
         */
        private static CloseableHttpClient getHttpClient(String proxyHost, int proxyPort, String acc, String pwd) {
            HttpHost proxy = new HttpHost(proxyHost, proxyPort, "HTTP");
            CredentialsProvider provider = new BasicCredentialsProvider();
            provider.setCredentials(new AuthScope(proxy), new UsernamePasswordCredentials(acc, pwd));

            return HttpClients.custom()
                    .setProxy(proxy)
                    .setDefaultCredentialsProvider(provider)
                    .build();
        }

    }

}
