package za.ac.cput.domain;
/*
 * @Author Reanetsi Sholoko
 * @Student number: 218160402*/


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class City implements Serializable {


    @NotNull
    @Id
    private String id;

    private String cityName;
    @NotNull
    @Embedded
    private Country country;

    protected City() {
    }

    private City(Builder builder) {
        this.id = builder.id;
        this.cityName = builder.name;
        this.country = builder.country;
    }

    public String getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public Country getCountry() {
        return country;
    }

    public static class Builder {
        private String id, name;
        private Country country;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCountry(Country country) {
            this.country = country;
            return this;
        }

        public Builder copy(City city) {
            this.id = city.id;
            this.name = city.cityName;
            this.country = city.country;
            return this;
        }

        public City build() {
            return new City(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id.equals(city.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + cityName + '\'' +
                ", countryId=" + country.toString() + '\'' +

                '}';
    }
}