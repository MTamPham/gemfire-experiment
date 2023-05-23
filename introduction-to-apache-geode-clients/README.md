# Introduction to Geode Clients
This project provides basic starting points for a variety of Apache Geode clients, along with very rudimentary connect, put, get operations, and then examples on how to use the client.

## Starting an Apache Geode Cluster
For client tests and examples, start a simple cluster and create an example region.

Start an Apache Geoge cluster with one locator and one server. 
```
$ gfsh
    _________________________     __
   / _____/ ______/ ______/ /____/ /
  / /  __/ /___  /_____  / _____  / 
 / /__/ / ____/  _____/ / /    / /  
/______/_/      /______/_/    /_/    9.15.4

Monitor and Manage VMware GemFire
gfsh>start locator
Starting a Geode Locator in /Users/tampm/Research/Practicals/Gemfire/introduction-to-apache-geode-clients/yell-happy-book...
...........................
Locator in /Users/tampm/Research/Practicals/Gemfire/introduction-to-apache-geode-clients/yell-happy-book on 192.168.0.184[10334] as yell-happy-book is currently online.
Process ID: 4781
Uptime: 16 seconds
Geode Version: 9.15.4
Java Version: 13.0.2
Log File: /Users/tampm/Research/Practicals/Gemfire/introduction-to-apache-geode-clients/yell-happy-book/yell-happy-book.log
JVM Arguments: --add-exports=java.management/com.sun.jmx.remote.security=ALL-UNNAMED --add-exports=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED -Dgemfire.enable-cluster-configuration=true -Dgemfire.load-cluster-configuration-from-dir=false -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /usr/local/vmware-gemfire-9.15.4/lib/geode-core-9.15.4.jar:/usr/local/vmware-gemfire-9.15.4/lib/geode-server-all-9.15.4.jar

Successfully connected to: JMX Manager [host=192.168.0.184, port=1099]

Cluster configuration service is up and running.

gfsh>start server
Starting a Geode Server in /Users/tampm/Research/Practicals/Gemfire/introduction-to-apache-geode-clients/stay-zealous-cake...
...
Server in /Users/tampm/Research/Practicals/Gemfire/introduction-to-apache-geode-clients/stay-zealous-cake on 192.168.0.184[40404] as stay-zealous-cake is currently online.
Process ID: 4858
Uptime: 4 seconds
Geode Version: 9.15.4
Java Version: 13.0.2
Log File: /Users/tampm/Research/Practicals/Gemfire/introduction-to-apache-geode-clients/stay-zealous-cake/stay-zealous-cake.log
JVM Arguments: --add-exports=java.management/com.sun.jmx.remote.security=ALL-UNNAMED --add-exports=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED -Dgemfire.default.locators=192.168.0.184[10334] -Dgemfire.start-dev-rest-api=false -Dgemfire.use-cluster-configuration=true -XX:OnOutOfMemoryError=kill -KILL %p -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /usr/local/vmware-gemfire-9.15.4/lib/geode-core-9.15.4.jar:/usr/local/vmware-gemfire-9.15.4/lib/geode-server-all-9.15.4.jar
```
List the members of the cluster
```
gfsh>list members
Member Count : 2

      Name        | Id
----------------- | -----------------------------------------------------------------------
yell-happy-book   | 192.168.0.184(yell-happy-book:4781:locator)<ec><v0>:41000 [Coordinator]
stay-zealous-cake | 192.168.0.184(stay-zealous-cake:4858)<v1>:41001
```
Create a region called "helloWorld"
```
gfsh>create region --name=helloWorld --type=PARTITION
     Member       | Status | Message
----------------- | ------ | ---------------------------------------------------
stay-zealous-cake | OK     | Region "/helloWorld" created on "stay-zealous-cake"

Cluster configuration for group 'cluster' is updated.
```

## Apache Geode Java Client
An Apache Geode client is written in Java which can be found in the `apache-geode-java-client`.

## Shutting down the Apache Geode cluster
When you are through running the client tests and examples, shut down the Apache Geode cluster
```
gfsh>shutdown --include-locators=true
```