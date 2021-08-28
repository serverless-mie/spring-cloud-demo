package com.aliware.sae;

import org.springframework.web.bind.annotation.*;

/**
 * @author sae
 */
@RestController
public class EchoController {
    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return string;
    }

    @RequestMapping(value = "/echo-param", method = RequestMethod.GET)
    public String echoParam(@RequestParam String string) {
        return string;
    }

    @RequestMapping(value = "/echo-body", method = RequestMethod.POST)
    public String echoBody(@RequestBody Request request) {
        return request.getEcho();
    }
}