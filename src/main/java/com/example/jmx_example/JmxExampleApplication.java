package com.example.jmx_example;

import com.example.jmx_example.accountServer.AccountServerController;
import com.example.jmx_example.accountServer.AccountServerControllerMBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

import javax.management.*;
import java.lang.management.ManagementFactory;

@SpringBootApplication
public class JmxExampleApplication {

    public static void main(String[] args)
            throws MalformedObjectNameException, NotCompliantMBeanException,
            InstanceAlreadyExistsException, MBeanRegistrationException {
        ConfigurableApplicationContext context = SpringApplication.run(JmxExampleApplication.class, args);
        AccountServerControllerMBean serverStatistics = context.getBean(AccountServerController.class);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("ServerManager:type=AccountServerController");
        mbs.registerMBean(serverStatistics, objectName);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void ready() {

        System.out.println("Server started");
    }
}
