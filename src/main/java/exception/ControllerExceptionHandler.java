package exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ProductNotORCategoryFoundException.class)
    public ModelAndView handleError(HttpServletRequest req, ProductNotORCategoryFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidCategoryId", exception.getCategoryId());
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
        mav.setViewName("error/errorAccess");
        return mav;
    }
  @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception.getMessage());
      mav.setViewName("error/errorAccess");
        return mav;
    }


}
