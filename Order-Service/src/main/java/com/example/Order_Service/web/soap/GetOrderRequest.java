package com.example.Order_Service.web.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "getOrderRequest", namespace = "http://example.com/orders")
public class GetOrderRequest {

    @XmlElement(name = "id", required = true, namespace = "http://example.com/orders")
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}