package com.group3.onlineShooping.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class CurrentUser {

    public static String loggedInUserName() {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

    public static List<String> loggedInRoles() {
        List<String> roles = new ArrayList<>();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            List<String> finalRoles = roles;
            ((UserDetails) principal).getAuthorities().forEach(x -> finalRoles.add(x.getAuthority()));
            roles = finalRoles;
        } else {
            String roles1 = principal.toString();
        }
        return roles;
    }
}
