package pojo;

import java.util.List;

public class ResponsePojo {
	private int width;
	private String id;
	private String url;
	private List<BreedsItemPojo> breeds;
	private int height;

	public int getWidth(){
		return width;
	}

	public String getId(){
		return id;
	}

	public String getUrl(){
		return url;
	}

	public List<BreedsItemPojo> getBreeds(){
		return breeds;
	}

	public int getHeight(){
		return height;
	}
}