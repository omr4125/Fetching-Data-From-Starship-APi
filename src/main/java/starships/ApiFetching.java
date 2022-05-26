package starships;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ApiFetching {

    private static final List<Starship> starshipList = new ArrayList<>();

    public static void fetchApi() throws UnirestException {
        String host = "https://swapi.dev/api/starships/";
        int pageNumber = 1;
        String page = "?page=";

            while (true) {
                HttpResponse<String> response = Unirest.get(host + page + pageNumber)
                        .header("Content-Type", "application/json")
                        .asString();
                JSONObject jo = new JSONObject(response.getBody());
                int length = jo.getJSONArray("results").length();

                if (!jo.isNull("next")){
                    mapJsonToJavaPojo(jo, length);
                }else{
                    mapJsonToJavaPojo(jo, length);
                    break;
                }
                pageNumber++;
            }
        starshipList.forEach(System.out::println);
        String name = starshipList.stream()
                .max(Comparator.comparing(x -> Double.valueOf(x.getLength().replaceAll(",", "."))))
                .get()
                .getName();
        System.out.println("Max length: " + name);
        starshipList.stream()
                .map(Starship::getName)
                .forEach(System.out::println);
    }

    private static void mapJsonToJavaPojo(JSONObject jo, int length) {

        Gson gson = new Gson();
        for (int i = 0; i < length; i++) {
            JSONObject jo2 = jo.getJSONArray("results").getJSONObject(i);
            Starship starship = gson.fromJson(jo2.toString(), Starship.class);
            starshipList.add(starship);
        }
    }
}
