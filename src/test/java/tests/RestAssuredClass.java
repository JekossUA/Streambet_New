package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import io.restassured.RestAssured;



public class RestAssuredClass {

    @Test
    public void rejectLastPaymentPortalAdmin () {
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IjlGdTdzQXlKZ21WZkgycmJWQkktcSJ9.eyJuaWNrbmFtZSI6ImRlbmlza3VkaW40MTEiLCJuYW1lIjoiZGVuaXNrdWRpbjQxMUBnbWFpbC5jb20iLCJwaWN0dXJlIjoiaHR0cHM6Ly9zLmdyYXZhdGFyLmNvbS9hdmF0YXIvOWM2ODc5MjBlNzJjOWU5MzBjY2RjYTQwY2UyZjA0YmM_cz00ODAmcj1wZyZkPWh0dHBzJTNBJTJGJTJGY2RuLmF1dGgwLmNvbSUyRmF2YXRhcnMlMkZkZS5wbmciLCJ1cGRhdGVkX2F0IjoiMjAyMC0wOC0xMFQwODowOTowMy4zOThaIiwiZW1haWwiOiJkZW5pc2t1ZGluNDExQGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiaXNzIjoiaHR0cHM6Ly9zdHJlYW1iZXQuZXUuYXV0aDAuY29tLyIsInN1YiI6ImF1dGgwfDVmMGQ5OTc1NmIyNTYxMDAxOTE3NTIyNSIsImF1ZCI6IkZxV2pJclpsVHVXS3VkcUR4dXhtd2FHSFd1aUJud2kzIiwiaWF0IjoxNTk3MDQ2OTQ0LCJleHAiOjE1OTcwODI5NDQsIm5vbmNlIjoiU0VWcFdtSXhiMDQzTW5KRGVYZDJhblpqUTNKUFZuNXFieTFpWm5kS01YaFhWamR4YjFBeGIwVXpaQT09In0.HGMDAu5sCx4SooXRzF_UdlkFdhk9IgOl6fHgA4dwwZ-G5E2K5d_ORrfBuN1VRrTB3vunre9BAX4xKdzVk5BBIiq96VhBTXuYWQhnqunpfUrE4lG5pWJDdJJJxiuPwb4RvrLa1gtBn5GdKCIIyk5YNlM69vaAdnFqMUA5RpYall0dKsSnP0gRCrJKr8U4i5tPZYT7Ir5KJA5rQMcjppOAra05KioWXZ1zHWJniyPDUN3_u41MrSzCF0a153r0vgMdF6H1T9haJukeesmAGjVF5JwYQ5ibJnzh6e5xHlKvx9FCcooGoF3nhUd-WdSFWCT-wZrtW6QEHsUFLDsn1sr9kQ";
        String paymentsBody = "{\"where\":{\"direction\":\"WITHDRAWAL\",\"merchant\":\"PIASTRIX\",\"status\":\"PENDING\"},\"order\":{\"updatedAt\":\"DESC\"},\"skip\":0,\"take\":1}";
        String rejectBody = "{\"userComment\": \"UserComment\", \"internalComment\": \"InternalComment\"}";
        String baseUrlPayments = "https://portal-admin.streambet.io/api/transactions/api/payments";
        String basePathSearch = "/search";
        String basePathReject = "/reject";

        try {
            Response response = RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)
                    .body(paymentsBody)
                    .when()
                    .post(baseUrlPayments + basePathSearch)
                    .andReturn();

            JsonPath jsonPathValidation = response.jsonPath();
            String  paymentId = jsonPathValidation.getString("rows[0].id");
            System.out.println(paymentId);

            String url = baseUrlPayments + "/" + paymentId + basePathReject;
            RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer " + token)
                    .body(rejectBody)
                    .when()
                    .post(url)
                    .then().log().all().statusCode(200);

        } catch (Exception e){
            e.printStackTrace();
            assert false;
        }
    }

    @Test
    public void runAuth0Authorization () {
        
    }
}
