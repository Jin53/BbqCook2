package entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "getAllFood",
        query = "SELECT f FROM Food AS f ORDER BY f.food_id"
    ),
    @NamedQuery(
            name = "getFoodCount",
            query = "SELECT COUNT(f) FROM Food AS f"
        ),
})
@Table(name="food")
public class Food {
    @Id
    @Column(name = "Food_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer food_id;

    @Column(name = "Food_name")
    private String food_name;

    @Column(name = "Food_image")
    private String food_image;


    public String getFood_image() {
        return food_image;
    }

    public void setFood_image(String food_image) {
        this.food_image = food_image;
    }

    public Integer getFood_id() {
        return food_id;
    }

    public void setFood_id(Integer food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }


}
