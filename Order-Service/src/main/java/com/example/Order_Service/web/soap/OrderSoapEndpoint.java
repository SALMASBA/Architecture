package com.example.Order_Service.web.soap;






import com.example.Order_Service.model.Order;
import com.example.Order_Service.service.OrderService;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
public class OrderSoapEndpoint {

    private static final String NAMESPACE = "http://example.com/orders";
    private final OrderService service;

    public OrderSoapEndpoint(OrderService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getOrderRequest")
    @ResponsePayload
    public GetOrderResponse getOrder(@RequestPayload GetOrderRequest request) {
        Order order = service.updateStatus(request.getId(), "SOAP-CALLED");

        GetOrderResponse response = new GetOrderResponse();
        response.setId(order.getId());
        response.setStatus(order.getStatus());
        response.setTotal(order.getTotal());
        return response;
    }
}
