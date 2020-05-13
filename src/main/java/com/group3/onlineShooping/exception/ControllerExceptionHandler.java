package com.group3.onlineShooping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {



    @ExceptionHandler(ProductUnavailableException.class)
    public ModelAndView handleProductUnavailableException(HttpServletRequest req, ProductUnavailableException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", exception.getMessage());
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
        mav.setViewName("error/errorAccess");
        return mav;
    }


    @ExceptionHandler(NoProductsFoundUnderCategoryException.class)
    public ModelAndView handleErrorNoProductsFoundUnderCategory(HttpServletRequest req, NoProductsFoundUnderCategoryException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", exception.getMessage());
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
        mav.setViewName("error/errorAccess");
        return mav;
    }



    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView ProductNotFoundException(HttpServletRequest req, ProductNotFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", exception.getProductId());
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
        mav.setViewName("error/errorAccess");
        return mav;
    }





   @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception exception) {
        ModelAndView mav = new ModelAndView();
       mav.addObject("message", exception.getMessage());
        mav.addObject("exception", exception.getMessage());
        mav.setViewName("error/errorAccess");
        return mav;
    }


/*
	@ExceptionHandler(UploadImageFailException.class)
	public ModelAndView handleError(HttpServletRequest req, UploadImageFailException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.setViewName("errorUploadImage");
		return mav;
	}*/


}
