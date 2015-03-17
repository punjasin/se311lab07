package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.config.SerializableResourceBundleMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;
import java.util.Properties;

/**
 * Created by Punjasin on 17/3/2558.
 */
@Controller

@RequestMapping("/messageBundle")

public class SerializebleMessageBundleController {

    @Autowired
    SerializableResourceBundleMessageSource messageBundle;
    /**
     * ReadAll
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Properties list(@RequestParam String lang){
        return messageBundle.getAllProperties(new Locale(lang));
    }

}
