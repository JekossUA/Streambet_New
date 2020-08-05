package tests;

import io.restassured.http.ContentType;
import org.junit.Test;
import io.restassured.RestAssured;

public class RestAssuredClass {
    String paymentId;
    String token;

    @Test
    public void getLastPendingWithdrawalRequest () {
        String body = "{\"where\":{\"direction\":\"WITHDRAWAL\",\"merchant\":\"PIASTRIX\",\"status\":\"PENDING\"},\"order\":{\"updatedAt\":\"DESC\"},\"skip\":0,\"take\":1}";
        String token = this.token;
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("authorization", token)
                .body(body)
                .when()
                .post("https://portal-admin.streambet.dev/api/transactions/api/payments/search")
                .then().log().all().statusCode(200);
    }

    @Test
    public void rejectLastWithdrawalRequest () {
        String url = "https://portal-admin.streambet.dev/api/transactions/api/payments/" + paymentId + "/reject";
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .header("authorization", token)
                .when()
                .post(url)
                .then().log().all().statusCode(200);
    }
}
