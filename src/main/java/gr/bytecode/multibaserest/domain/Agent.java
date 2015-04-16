package gr.bytecode.multibaserest.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * An Agent Resource
 */
@Entity
public class Agent implements Serializable {

    /**
     * Required by the {@link Serializable} interface. Increase by 1 every time the class is
     * significantly changed on production.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Record id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Agent's name
     */
    @Column(nullable = false)
    private String name;

    /**
     * The managed {@link Controller}
     *
     * @return
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "CONTROLLER_ID", nullable = false)
    private Controller controller;

    /**
     * Default Constructor
     *
     */
    protected Agent() {

    }

    /**
     * Constructor
     *
     * @param name
     */
    public Agent(String name) {
        super();
        this.name = name;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return getName();
    }

    /**
     * @return the controller
     */
    public Controller getController() {
        return controller;
    }

    /**
     * @param controller the controller to set
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
