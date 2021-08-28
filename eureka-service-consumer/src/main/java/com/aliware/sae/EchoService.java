package com.aliware.sae;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author sae
 */
@FeignClient(name = "service-provider")
public interface EchoService {
    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    String echo(@PathVariable("str") String str);

    @RequestMapping(value = "/echo-param", method = RequestMethod.GET)
    String echoParam(@RequestParam String string);

    @RequestMapping(value = "/echo-body", method = RequestMethod.POST)
    String echoBody(@RequestBody Request request);
}