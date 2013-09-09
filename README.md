jcollectd-jboss
===============

J2E webapp for using jcollectd with the JBoss MBeanServer

## How

This minimal webapplication uses a ServletContextListener to start the MBeanSender of jcollectd such that it can access the JBoss specific MBeanServer to gather metrics. See [FORK.md from jcollectd](https://github.com/emicklei/jcollectd/blob/master/FORK.md) for its configuration.

## Requires

 [https://github.com/emicklei/jcollectd](https://github.com/emicklei/jcollectd)

## Build

 maven install

&copy; 2013, http://ernestmicklei.com. Apache V2.0 License