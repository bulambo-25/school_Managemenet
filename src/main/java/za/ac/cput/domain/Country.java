/*Country.java
 Entity Country
 Author: Kululo Mangcunyana (219387117)
 Date: 18 June 2022
 */

package za.ac.cput.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity

public class Country {

    @NotNull
    @Id private String id;
    @NotNull private String  name;

    protected Country(){}

    private Country(Builder builder){
        this.id= builder.id;
        this.name= builder.name;

    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return  name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "country{" +
                "id='" + id+ '\'' +
                ",name='" + name+
                '}';
    }
    public static class Builder{

        private String id;
        private String  name;



        public Builder setId(String id) {
            this.id = id;
            return this;
        }


        public  Builder setName(String name) {
            this.name= name;
            return this;
        }


        public Builder copy(Country country) {
            this.id = country.id;
            this.name = country.name;

            return this;
        }
        public Country build(){
            return new Country(this);
        }


    }
}