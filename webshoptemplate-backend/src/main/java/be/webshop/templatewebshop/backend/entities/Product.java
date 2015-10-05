package be.webshop.templatewebshop.backend.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by tmaes on 20/09/2015.
 */
@MappedSuperclass
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long id;

    @NotNull
    private String name;

    @NotNull
    private Double priceExclVat;

    @Transient
    private Double priceInclVat;

    @NotNull
    private String description;

    @NotNull
    private String origin;

    @NotNull
    private String shortDescription;

    private byte image;

    private byte thumbnail;

    @Transient
    private static final int IMG_WIDTH = 100;

    @Transient
    private static final int IMG_HEIGHT = 100;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPriceExclVat() {
        return priceExclVat;
    }

    public void setPriceExclVat(Double priceInclVat) {
        this.priceExclVat = priceInclVat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getImage() {
        return image;
    }

    public void setImage(byte image) {
        this.image = resizeImage(image);
    }

    public byte getThumbnail() {
        return resizeThumbnail(thumbnail);
    }

    public void setThumbnail(byte thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    private byte resizeImage(byte image) {
        return 0;
    }

    private byte resizeThumbnail(byte thumbnail) {
        return 0;
    }
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Double getPriceInclVat() {
        return priceExclVat*1.21;
    }
}