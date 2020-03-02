package com.uge.j2ee.aquarium.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import java.util.Date;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Activity.class)
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameActivity;
    private Date dataCal;
    private String start;
    private String end;
    private String state;  //public,private


    @ManyToOne
    @JoinColumn(name ="employee_activity_id")
    @JsonIdentityReference
    private Employee responsableAct;

    @ManyToOne
    @JoinColumn(name ="pool_activity_id")
    @JsonIdentityReference
    private Pool poolActivity;

    public Pool getPoolActivity() {
        return poolActivity;
    }

    public Activity() {
    }

    public Activity(Long id, String nameActivity, String state) {
        super();
        this.id = id;
        this.nameActivity = nameActivity;
        this.state = state;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getResponsableAct() {
        return responsableAct;
    }

    public void setResponsableAct(Employee responsableAct) {
        this.responsableAct = responsableAct;
    }

    public void setPoolActivity(Pool poolActivity) {
        this.poolActivity = poolActivity;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public Date getDataCal() {
        return dataCal;
    }

    public void setDataCal(Date dataCal) {
        this.dataCal = dataCal;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
