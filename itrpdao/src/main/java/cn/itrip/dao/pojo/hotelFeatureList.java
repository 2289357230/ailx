package cn.itrip.dao.pojo;

import java.util.List;

public class hotelFeatureList {

    private Long id;

    private String name;

    private String description;

    private double pic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPic() {
        return pic;
    }

    public void setPic(double pic) {
        this.pic = pic;
    }


    @Override
    public String toString() {
        return "hotelFeatureList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pic=" + pic +
                '}';
    }
}
