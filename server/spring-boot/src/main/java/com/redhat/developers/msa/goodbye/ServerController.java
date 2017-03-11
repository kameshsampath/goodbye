/**
 * JBoss, Home of Professional Open Source
 * Copyright 2016, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.developers.msa.goodbye;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class ServerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerController.class);

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/goodbye", produces = "text/plain")
    public String goodbye() throws ServletException {
        String msg = "Goodbye on " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(new Date());
        LOGGER.info(msg);
        return msg;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/nap", produces = "text/plain")
    public String goodbyeNap() throws ServletException, InterruptedException {
        LOGGER.info("Received request on Thread: " + Thread.currentThread().getName());
        // Sleep 30 seconds
         Thread.sleep(30000);
        //Pi.computePi(20000);
        LOGGER.info("Back from the nap");
        return "Nap from " + new Date().toString();
    }

}
