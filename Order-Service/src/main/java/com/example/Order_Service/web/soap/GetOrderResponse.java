package com.example.Order_Service.web.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GetOrderResponse", namespace = "http://example.com/orders")
public class GetOrderResponse {

    @XmlElement(name = "id", required = true, namespace = "http://example.com/orders")
    private Long id;

    @XmlElement(name = "status", required = true, namespace = "http://example.com/orders")
    private String status;

    @XmlElement(name = "total", required = true, namespace = "http://example.com/orders")
    private Double total;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
}