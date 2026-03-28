package cn.yan.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 单元测试
 */
public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/15554842812552/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie", "zsxq_access_token=9F3E0181-24A7-4346-A056-80ABA4772D4B_2A15F2448854CF3F; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2251184281848284%22%2C%22first_id%22%3A%2219d34b0d73a10a6-0eb5f965e88ac8-4c657b58-1024000-19d34b0d73b206b%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTlkMzRiMGQ3M2ExMGE2LTBlYjVmOTY1ZTg4YWM4LTRjNjU3YjU4LTEwMjQwMDAtMTlkMzRiMGQ3M2IyMDZiIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNTExODQyODE4NDgyODQifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%2251184281848284%22%7D%7D; abtest_env=beta");
        get.addHeader("Content-Type", "application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void anwser() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("");
        post.addHeader("cookie", "zsxq_access_token=9F3E0181-24A7-4346-A056-80ABA4772D4B_2A15F2448854CF3F; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2251184281848284%22%2C%22first_id%22%3A%2219d34b0d73a10a6-0eb5f965e88ac8-4c657b58-1024000-19d34b0d73b206b%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTlkMzRiMGQ3M2ExMGE2LTBlYjVmOTY1ZTg4YWM4LTRjNjU3YjU4LTEwMjQwMDAtMTlkMzRiMGQ3M2IyMDZiIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNTExODQyODE4NDgyODQifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%2251184281848284%22%7D%7D; abtest_env=beta");
        post.addHeader("Content-Type", "application/json; charset=UTF-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson);
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
