package com.aliware.sae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author sae
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EchoService echoService;

    @RequestMapping(value = "/echo-raw/{str}", method = RequestMethod.GET)
    public String raw(@PathVariable String str) {
        return restTemplate.getForObject("http://localhost:18081/echo/" + str,
                String.class);
    }

    // use ribbon
    // http://127.0.0.1:18082/echo-rest/name
    @RequestMapping(value = "/echo-rest/{str}", method = RequestMethod.GET)
    public String rest(@PathVariable String str) {
        return restTemplate.getForObject("http://service-provider/echo/" + str,
                String.class);
    }

    // http://127.0.0.1:18082/echo-feign/name
    @RequestMapping(value = "/echo-feign/{str}", method = RequestMethod.GET)
    public String feign(@PathVariable String str) {
        return echoService.echo(str);
    }

    // http://127.0.0.1:18082/echo-param/name
    @RequestMapping(value = "/echo-param/{str}", method = RequestMethod.GET)
    public String param(@PathVariable String str) {
        return echoService.echoParam(str);
    }

    // http://127.0.0.1:18082/echo-body/name
    @RequestMapping(value = "/echo-body/{str}", method = RequestMethod.POST)
    public String body(@PathVariable String str) {
        Request request = new Request();
        request.setEcho(str);
        return echoService.echoBody(request);
    }

}
