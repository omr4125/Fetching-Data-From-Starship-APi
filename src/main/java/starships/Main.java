package starships;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {
    public static void main(String[] args) throws UnirestException {
        ApiFetching.fetchApi();
    }
}
