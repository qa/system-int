package org.jboss.vut.ws.order;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author mbaluch
 */
@Entity
public class OrderEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long creator;
    private String itemName;
    private int quantity;
    @Enumerated(value = EnumType.STRING)
    private OrderStateType stateType;
    private String approverRole;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    public OrderEntity() {
    }

    public OrderEntity(long creator, String itemName, int quantity, OrderStateType stateType, Date createdDate) {
        this.creator = creator;
        this.itemName = itemName;
        this.quantity = quantity;
        this.stateType = stateType;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getApproverRole() {
        return approverRole;
    }

    public void setApproverRole(String approverRole) {
        this.approverRole = approverRole;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof OrderEntity)) {
            return false;
        }
        OrderEntity other = (OrderEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.muni.fi.entities.Order[id=" + id + "]";
    }

    public OrderStateType getStateType() {
        return stateType;
    }

    public void setStateType(OrderStateType stateType) {
        this.stateType = stateType;
    }

}
