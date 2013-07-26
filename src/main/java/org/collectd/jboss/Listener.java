package org.collectd.jboss;

import java.lang.management.ManagementFactory;
import java.util.logging.Logger;

import javax.management.MBeanServerConnection;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.collectd.mx.MBeanSender;

public class Listener implements ServletContextListener {
    private static final Logger LOG = java.util.logging.Logger.getLogger(Listener.class.getName());

    MBeanSender _sender;

    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("Initializing");
        _sender = new MBeanSender();
        MBeanServerConnection con = null;
        try {
            con = org.jboss.mx.util.MBeanServerLocator.locateJBoss();
        } catch (Throwable ex) {
            LOG.warning("Unable to locate JBOSS MBeanServer); fallback to platform");
            // fallback to platform
            con = ManagementFactory.getPlatformMBeanServer();
        }
        _sender.setMBeanServerConnection(con);
        _sender.configure();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        LOG.info("Destroying");
        if (_sender == null) {
            _sender.shutdown();
        }
    }
}
