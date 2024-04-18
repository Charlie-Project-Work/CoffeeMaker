package edu.ncsu.csc.CoffeeMaker.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import edu.ncsu.csc.CoffeeMaker.roles.Customer;
import edu.ncsu.csc.CoffeeMaker.roles.User;

@Entity
@Table ( name = "orders" )
public class Order extends DomainObject {
    @Id
    @GeneratedValue
    private Long     id;
    @ManyToOne
    @JoinColumn ( name = "user" )
    private Customer customer;

    @OneToOne ( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private Recipe   recipe;

    private String   status;

    public Order () {

    }

    public Order ( final Recipe recipe, final Customer customer ) {
        this.recipe = recipe;
        this.customer = customer;
    }

    // /**
    // * @param user
    // * @param recipe
    // * @param status
    // */
    // public Order(User user, Recipe recipe, String status) {
    // this.user = user;
    // this.recipe = recipe;
    // this.status = status;
    // }

    /**
     * @return the user
     */
    public User getUser () {
        return customer;
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser ( final Customer customer ) {
        this.customer = customer;
    }

    /**
     * @return the recipe
     */
    public Recipe getRecipe () {
        return recipe;
    }

    /**
     * @param recipe
     *            the recipe to set
     */
    public void setRecipe ( final Recipe recipe ) {
        this.recipe = recipe;
    }

    /**
     * @return the status
     */
    public String getStatus () {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus ( final String status ) {
        this.status = status;
    }

    /**
     * Get the ID of the Order
     *
     * @return the ID
     */
    @Override
    public Serializable getId () {
        return id;
    }

    @Override
    public String toString () {
        return "Ingredient [id=" + id + ", customer=" + customer.toString() + ", recipe=" + recipe.toString()
                + ", status=" + status + "]";
    }

    public Customer getCustomer () {
        return this.customer;
    }

}
