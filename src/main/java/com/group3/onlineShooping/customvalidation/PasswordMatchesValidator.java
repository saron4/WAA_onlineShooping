package com.group3.onlineShooping.customvalidation;

import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.service.BuyerService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    private BuyerService buyerService;


    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        Buyer buyer = (Buyer) obj;
        boolean isValid =buyer.getUser().getPassword().equals(buyer.getUser().getMatchingPassword());
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode( "user.matchingPassword" ).addConstraintViolation();
        }

        return isValid ;
    }

}
