import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class PoJoObject{

	private List<FlavorsItem> flavors;
	@JsonProperty("natural_gift_type")
	private NaturalGiftType naturalGiftType;
	private Item item;
	private int smoothness;
	private int size;
	@JsonProperty("natural_gift_power")
	private int naturalGiftPower;
	private Firmness firmness;
	private String name;
	@JsonProperty("growth_time")
	private int growthTime;
	@JsonProperty("soil_dryness")
	private int soilDryness;
	private int id;
	@JsonProperty("max_harvest")
	private int maxHarvest;
}
