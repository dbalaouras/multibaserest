/*
 * Copyright 2012-2014 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package gr.bytecode.multibaserest.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * A Controller Entity
 */
@Entity
public class Controller implements Serializable {

    /**
     * Required by the {@link Serializable} interface. Increase by 1 every time the class is
     * significantly changed on production.
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    /**
     * The list of the Agents registered and managed by this Controller.
     */
    @OneToMany(mappedBy = "controller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Agent> agents;

    /**
     * Constructor
     *
     */
    protected Controller() {

    }

    /**
     * Constructor
     *
     * @param name
     */
    public Controller(String name) {
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
     * @return the agents
     */
    public List<Agent> getAgents() {
        return agents;
    }

    /**
     * @param agents the agents to set
     */
    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }
}
