package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import io.restassured.RestAssured;



public class RestAssuredClass {
    public String baseUrlPayments = "https://portal-admin.streambet.dev/api/transactions/api/payments";
    public String basePathSearch = "/search";
    public String basePathReject = "/reject";

    @Test
    public void rejectLastPaymentPortalAdmin () {
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IjlGdTdzQXlKZ21WZkgycmJWQkktcSJ9.eyJnaXZlbl9uYW1lIjoiRXVnZW5lIiwiZmFtaWx5X25hbWUiOiJNaWhheWxvdiIsIm5pY2tuYW1lIjoibWloYXlsb3Zza2l5ZXVnZW55IiwibmFtZSI6IkV1Z2VuZSBNaWhheWxvdiIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS0vQU9oMTRHZ3VkcVY5bVVoWW1TWDZhRkNnbi1WZU4yV0lhNmpxRU9UdmJjUlMiLCJsb2NhbGUiOiJydSIsInVwZGF0ZWRfYXQiOiIyMDIwLTA4LTA3VDEzOjI3OjMxLjA2NVoiLCJlbWFpbCI6Im1paGF5bG92c2tpeWV1Z2VueUBnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiaXNzIjoiaHR0cHM6Ly9zdHJlYW1iZXQuZXUuYXV0aDAuY29tLyIsInN1YiI6Imdvb2dsZS1vYXV0aDJ8MTAyNDUwODA4Njg2NTU4NzQyNjA5IiwiYXVkIjoiRnFXaklyWmxUdVdLdWRxRHh1eG13YUdIV3VpQm53aTMiLCJpYXQiOjE1OTY4MDY4NTIsImV4cCI6MTU5Njg0Mjg1Miwibm9uY2UiOiJUVXRIV1dOeGJWQXlRVlZzUTBaa1pUTjBhMUJ3T1hCcmRHVjVNV0p5YlhOUGJHNXdZbVZoTVRock9BPT0ifQ.Ia-5cs9teqEsyKuHUkY2CfeG0YwDIjdg6fmksgmRoUVZg0tWfaa6sm7JUxp1ligCyHs5GhSstl2mWZdSJ80J96JGa3jEfwATIq_lRr1Mc_PXeygu5oObwhq_aLSOpV94lLHxtbgQac9wCPQ8onWYVxI6aubFzHUCS8ho2svOpzYhahHU0oIoILQ7h8Wm2o5HRa7rVbvZuD6BY197WxLTbNFiqvEDpqV9ALv2asH2paMTfgjOx_uy70kDXdZID__dxOpqzF3gTNYZ_YYnCYsro4vv-_KPDeHwAiNpi5V-coYVH-ov3NECqniM6WfxgSj1OhGOuRIW7Y1sazl_nkM3Zw";
        String paymentsBody = "{\"where\":{\"direction\":\"WITHDRAWAL\",\"merchant\":\"PIASTRIX\",\"status\":\"PENDING\"},\"order\":{\"updatedAt\":\"DESC\"},\"skip\":0,\"take\":1}";
        String rejectBody = "{\"userComment\": \"UserComment\", \"internalComment\": \"InternalComment\"}";

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
}
