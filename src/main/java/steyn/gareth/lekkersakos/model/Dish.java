package steyn.gareth.lekkersakos.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="dish")
public class Dish {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "publish_date", nullable = false)
	private Date publishDate;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name = "is_vegetarian", nullable = false)
	private Boolean isVegetarian;
	
	@Column(name = "feeds_amount", nullable = false)
	private int feedsAmount;
	
	@Column(nullable = false)
	private String instructions;
	
	@JsonIgnore
	@Lob
	@Column(name="dish_image", columnDefinition="longblob")
	private byte[] image;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "dish")
	private List<Ingredient> ingredients;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsVegetarian() {
		return isVegetarian;
	}

	public void setIsVegetarian(Boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}

	public int getFeedsAmount() {
		return feedsAmount;
	}

	public void setFeedsAmount(int feedsAmount) {
		this.feedsAmount = feedsAmount;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
}
