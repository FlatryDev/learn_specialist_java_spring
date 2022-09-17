package yurev.lab5;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="courses")
public class Course implements Serializable{
    private int id;
    private String title;
    private int length;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }
    
    @Column(name="title")
    public String getTitle() {
        return title;
    }

    @Column(name="length")
    public int getLength() {
        return length;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%-3d %-50s %-4d", getId() , getTitle(), getLength() );
    }
    
    
    
}
