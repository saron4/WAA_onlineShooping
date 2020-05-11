package exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidCategoryId", exception.getProductId());
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
        mav.setViewName("productNotFound");
        return mav;
    }
  @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception.getMessage());
        mav.setViewName("errorUploadImage");
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
