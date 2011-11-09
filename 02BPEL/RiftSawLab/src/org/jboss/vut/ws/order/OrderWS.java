package org.jboss.vut.ws.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ejb.Stateless;

import org.jboss.vut.ws.common.IDGenerator;

/**
 *
 * @author mbaluch
 */
@WebService(name = "OrderWS", targetNamespace = "http://www.jboss.org/vut/order")
@Stateless()
public class OrderWS {
	
	static Map<Long, OrderEntity> database = new HashMap<Long, OrderEntity>();
	static IDGenerator generator = new IDGenerator();
	
    @WebMethod(operationName = "createOrder")
    public long createOrder(@WebParam(name = "creator") long creator, 
    						@WebParam(name = "itemName") String itemName, 
    						@WebParam(name = "itemPrice") BigDecimal itemPrice, 
    						@WebParam(name = "quantity") int quantity) 
    {
		Long id = new Long(generator.next());
		OrderEntity order = new OrderEntity(creator, itemName, quantity, OrderStateType.NEW, new Date());
		order.setId(id);
		database.put(id, order);
		System.out.println("Created order: " + order);
		return id;
    }

    @WebMethod(operationName = "setApprover")
    @Oneway
    public void setApprover(@WebParam(name = "orderId") long orderId, @WebParam(name = "approverRole") String approverRole) {
        getOrderById(orderId).setApproverRole(approverRole);
        System.out.println("Set approver to " + approverRole + " on order " + orderId);
    }

    @WebMethod(operationName = "setOrderState")
    @Oneway
    public void setOrderState(@WebParam(name = "orderId") long orderId, @WebParam(name = "newState") OrderStateType newState) {
        getOrderById(orderId).setStateType(newState);
        System.out.println("Set order state to " + newState + " on order " + orderId);
    }
    
    public OrderEntity getOrderById(long orderId) {
    	return database.get(orderId);
    }

}
