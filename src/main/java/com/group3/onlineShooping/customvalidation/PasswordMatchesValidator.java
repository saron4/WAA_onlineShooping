package com.group3.onlineShooping.customvalidation;

import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.domain.User;
import com.group3.onlineShooping.service.BuyerService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.domain.User;
import com.group3.onlineShooping.service.BuyerService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    //private BuyerService buyerService;


    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        User user = (User) obj;
        boolean isValid = user.getPassword().equals(user.getMatchingPassword());
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("matchingPassword").addConstraintViolation();
        }

        return isValid;
    }


}