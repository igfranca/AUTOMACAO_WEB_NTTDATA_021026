package api;

import java.util.List;

public class Produto {

  private Integer id;
  private String title;
  private Double price;
  private Double discountPercentage;
  private Integer stock;
  private Double rating;
  private List<String> images;
  private String thumbnail;
  private String description;
  private String brand;
  private String category;

  public Produto() {
  }

  public Produto(Integer id, String title, Double price, Double discountPercentage,
      Integer stock, Double rating, List<String> images, String thumbnail,
      String description, String brand, String category) {
    this.id = id;
    this.title = title;
    this.price = price;
    this.discountPercentage = discountPercentage;
    this.stock = stock;
    this.rating = rating;
    this.images = images;
    this.thumbnail = thumbnail;
    this.description = description;
    this.brand = brand;
    this.category = category;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getDiscountPercentage() {
    return discountPercentage;
  }

  public void setDiscountPercentage(Double discountPercentage) {
    this.discountPercentage = discountPercentage;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }

  public List<String> getImages() {
    return images;
  }

  public void setImages(List<String> images) {
    this.images = images;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return "Produto{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", price=" + price +
        ", discountPercentage=" + discountPercentage +
        ", stock=" + stock +
        ", rating=" + rating +
        ", images=" + images +
        ", thumbnail='" + thumbnail + '\'' +
        ", description='" + description + '\'' +
        ", brand='" + brand + '\'' +
        ", category='" + category + '\'' +
        '}';
  }
}
