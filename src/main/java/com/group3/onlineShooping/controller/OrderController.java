package com.group3.onlineShooping.controller;

import com.group3.onlineShooping.domain.Order;
import com.group3.onlineShooping.domain.OrderStatus;
import com.group3.onlineShooping.domain.Payment;
import com.group3.onlineShooping.service.OrderHistoryService;
import com.group3.onlineShooping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderHistoryService orderHistoryService;

    @Autowired
    public OrderController(@Qualifier("OrderServiceImpl") OrderService orderService, @Qualifier("OrderHistoryServiceImpl") OrderHistoryService orderHistoryService) {
        this.orderService = orderService;
        this.orderHistoryService = orderHistoryService;
    }

    @GetMapping
    public String index(Model model) {
        List<Order> orders = orderService.getAll();
        model.addAttribute("orders", orders);
        return "order/index";
    }

    @GetMapping("/{id}")
    public ModelAndView details(@PathVariable("id") Long id) {
        Order order = orderService.getOrder(id);
        ModelAndView mv = new ModelAndView("order/details");
        mv.addObject("order", order);
        return mv;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        Order order = orderService.getOrder(id);
        ModelAndView modelAndView = new ModelAndView("order/delete");
        modelAndView.addObject("order", order);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(Order order) {
        orderService.deleteOrder(order.getId());
        return "redirect:/order";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView changeStatus(@PathVariable("id") Long id) {
        Order order = orderService.getOrder(id);
        ModelAndView modelAndView = new ModelAndView("order/edit");
        modelAndView.addObject("order", order);
        modelAndView.addObject("orderStatus", OrderStatus.getOrderStatus(order.getOrderStatus(), OrderStatus.EndOrderStatus()));

        return modelAndView;
    }

    @PostMapping("/edit")
    public String changeStatus(Order order) {
        Order orderUpdated = orderService.editOrder(order);
        return "redirect:/order";
    }

    @PostMapping("/export/{id}")
    public String exportPDF(@PathVariable("id") Long id) {
        //boolean order = orderService.deleteOrder(id);
        return "order/index";
    }


    @GetMapping("/hostory/{id}")
    public ModelAndView orderHistory(@PathVariable("id") Long id) {
        List<Order> orders = orderHistoryService.getAllHistory(id);
        Order order = orderService.getOrder(id);

        ModelAndView mv = new ModelAndView("order/hostoryDetails");
        mv.addObject("orders", orders);
        mv.addObject("order", order);
        return mv;
    }
}
