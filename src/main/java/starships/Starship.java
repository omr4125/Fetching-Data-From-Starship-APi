package starships;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Starship {

    private String name;
    private String model;
    private String manufacturer;
    @SerializedName("cost_in_credits")
    private String costInCredits;
    private String length;
    @SerializedName("max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    private String crew;
    private String passengers;
    @SerializedName("cargo_capacity")
    private String cargoCapacity;
    private String consumables;
    @SerializedName("hyperdrive_rating")
    private String hyperDriveRating;
    @SerializedName("MGLT")
    private String mglt;
    @SerializedName("starship_class")
    private String starshipClass;
    private String[] pilots;
    private String[] films;
    private String created;
    private String edited;
    private String url;
}
