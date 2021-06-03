public class FlavorsItem{


	public void setFlavor(Flavor flavor) {
		this.flavor = flavor;
	}

	public void setPotency(Integer potency) {
		this.potency = potency;
	}

	private Flavor flavor;
	private Integer potency;

	public Flavor getFlavor(){
		return flavor;
	}

	public Integer getPotency(){
		return potency;
	}
}
