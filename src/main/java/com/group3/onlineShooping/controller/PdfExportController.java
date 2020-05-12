package com.group3.onlineShooping.controller;

import com.group3.onlineShooping.domain.Order;
import com.group3.onlineShooping.service.OrderService;
import com.group3.onlineShooping.util.GeneratePdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
public class PdfExportController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/orderreceipt/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> orderReceipt(@PathVariable("id") Long id) throws IOException {
        Order order = orderService.getOrder(id);
        List<Order> orders = new ArrayList<>();
        orders.add(order);

        ByteArrayInputStream bis = GeneratePdf.orderReport(orders);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=orderreceipt.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}