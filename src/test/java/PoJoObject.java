import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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

	public List<FlavorsItem> getFlavors(){
		return flavors;
	}

	public NaturalGiftType getNaturalGiftType(){
		return naturalGiftType;
	}

	public Item getItem(){
		return item;
	}

	public int getSmoothness(){
		return smoothness;
	}

	public int getSize(){
		return size;
	}

	public int getNaturalGiftPower(){
		return naturalGiftPower;
	}

	public Firmness getFirmness(){
		return firmness;
	}

	public String getName(){
		return name;
	}

	public int getGrowthTime(){
		return growthTime;
	}

	public int getSoilDryness(){
		return soilDryness;
	}

	public int getId(){
		return id;
	}

	public int getMaxHarvest(){
		return maxHarvest;
	}
}
