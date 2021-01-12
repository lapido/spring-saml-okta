package com.auth.saml.saml.controller;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.saml.SAMLConstants;
import org.springframework.security.saml.SAMLDiscovery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

/**
 * created by victor abidoye on 1/12/2021
 **/
@Controller
@RequestMapping("/idpselection")
public class IdPSelectionController {
    @RequestMapping
    public ModelAndView idpSelection(HttpServletRequest request) {

        if (comesFromDiscoveryFilter(request)) {
            ModelAndView idpSelection = new ModelAndView("idpselection");
            idpSelection.addObject(SAMLDiscovery.RETURN_URL, request.getAttribute(SAMLDiscovery.RETURN_URL));
            idpSelection.addObject(SAMLDiscovery.RETURN_PARAM, request.getAttribute(SAMLDiscovery.RETURN_PARAM));
            idpSelection.addObject("idpNameAliasMap",
                    Collections.singletonMap("http://www.okta.com/exk62w7tqv0xkRl9p0h7", "Okta"));
            return idpSelection;
        }
        throw new AuthenticationServiceException("SP Discovery flow not detected");
    }

    private boolean comesFromDiscoveryFilter(HttpServletRequest request) {
        return request.getAttribute(SAMLConstants.LOCAL_ENTITY_ID) != null &&
                request.getAttribute(SAMLDiscovery.RETURN_URL) != null &&
                request.getAttribute(SAMLDiscovery.RETURN_PARAM) != null;
    }

}
