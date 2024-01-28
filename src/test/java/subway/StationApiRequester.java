package subway;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.util.Map;

public class StationApiRequester {

    /** 주어진 지하철역 명으로 지하쳘역 생성 요청 후, 응답값을 반환합니다 */
    public static ExtractableResponse<Response> createStation(
        final String stationName
    ) {
        return RestAssured.given().log().all()
            .body(Map.of("name", stationName))
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .when().post("/stations")
            .then().log().all()
            .extract();
    }

    /** 지하철역 조회 요청 후, 응답값을 반환합니다 */
    public static ExtractableResponse<Response> getStations() {
        return RestAssured.given().log().all()
            .when().get("/stations")
            .then().log().all()
            .extract();
    }
}