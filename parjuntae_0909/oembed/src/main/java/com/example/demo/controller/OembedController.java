package com.example.demo.controller;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OembedController {

    private static JSONParser jsonParser = null;
    private static List<String> lst = null;
    private static JSONArray jsonArray = null;
    private URL url;

    // Runtime에 resources/json/providers.json 파일을 읽고,
    // 파싱하여 각 providers의 유효한 url을 읽어서 class에 static하게 저장
     private static void readJson() throws IOException {

         lst = new ArrayList<String>();
         jsonParser = new JSONParser();

         ClassPathResource classPathResource = new ClassPathResource("json/providers.json");
         BufferedReader rb = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
         try{
             Object obj = jsonParser.parse(rb);

             JSONArray jsonArr = (JSONArray) obj;

             for(int i = 0; i < jsonArr.size(); i++){
                 JSONObject provider_url = (JSONObject) jsonArr.get(i);
                 String url = (String) provider_url.get("endpoints").toString();

                 Object obj2 = jsonParser.parse(url);
                 jsonArray = new JSONArray();
                 jsonArray = (JSONArray) obj2;
                 JSONObject urlData = (JSONObject) jsonArray.get(0);

                 String value = (String) urlData.get("url");
                 lst.add(value);
             }
         } catch (Exception e){
             e.printStackTrace();
         }
     }

    @GetMapping("/oembed")
    public String oembed() throws IOException {
         readJson();
        return "oembed";
    }

    /* 
    * 1. Client에서 oembed데이터를 추출할 URL을 입력
    * 2. 사용자가 입력한 URL에서 도메인과 oembed에서 제공하는 도메인(provider_url)이 있는지 검색
    * 3. 존재한다면 provider에게 보낼 HTTP Request를 생성 ( providers.enpoints.url/oembed?url=입력url&format=json )
    * 인스타그램은 페이스북이 인증 받은 사용자만 oEmbed API를 이용할 수 있도록 정책 수정
    * 개발자 계정에서 oEmbed 공유가 가능하도록 앱을 변경하면 가능
    */
    @GetMapping("/oembed/api")
    @ResponseBody
    public String getOembed(@RequestParam String search, Model model){
        String result = "";
        try {
            String host = hostCheck(search);
            String encode = URLEncoder.encode(search, StandardCharsets.UTF_8);
            String oembedUrl = createAddr(host, encode);

            CloseableHttpClient hc = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(oembedUrl);

            httpGet.addHeader("Content-Type", "application/json");

            CloseableHttpResponse httpResponse = hc.execute(httpGet);

            result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            System.out.print("result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
            result = "";
        }

        return result;
    }

    // 호스트 체크
    public String hostCheck(String str) {
        String result = "";
        try {
            url = new URL(str);

            String[] split = url.getHost().split("\\.");

            if (split.length == 2) {
                result = split[0];
            } else if (split.length == 3) {
                result = split[1];
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // URL 생성
    public String createAddr(String host, String encode) {
        String oembedUrl = "";

        for (String str : lst) {
            
            if (str.contains(host)) {

                if (str.contains("oembed.")) {
                    if (str.contains("{format}")) {
                        str = str.replace("{format}", "json");
                    }

                    oembedUrl = str + "?url=" + encode;

                } else if (str.contains("_oembed")) {
                    oembedUrl = "";
                } else {
                    oembedUrl = str + "?format=json&url=" + encode;
                }
                break;
            }
        }
        return oembedUrl;
    }
}