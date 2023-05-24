# Creating and Using a Cluster Configuration
This section provides a walk-through example of configuring a simple Apache Geode cluster and then re-using that 
configuration in a new context.
1. Set the working directory which will contain the configurations for our cluster, for example `current_geode`.
2. Start the gfsh
```
$ gfsh
    _________________________     __
   / _____/ ______/ ______/ /____/ /
  / /  __/ /___  /_____  / _____  / 
 / /__/ / ____/  _____/ / /    / /  
/______/_/      /______/_/    /_/    9.15.4

Monitor and Manage VMware GemFire
```
3. Start a locator
```
gfsh>start locator --name=locator1
Starting a Geode Locator in /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/locator1...
...........................
Locator in /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/locator1 on 192.168.0.184[10334] as locator1 is currently online.
Process ID: 6676
Uptime: 16 seconds
Geode Version: 9.15.4
Java Version: 13.0.2
Log File: /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/locator1/locator1.log
JVM Arguments: --add-exports=java.management/com.sun.jmx.remote.security=ALL-UNNAMED --add-exports=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED -Dgemfire.enable-cluster-configuration=true -Dgemfire.load-cluster-configuration-from-dir=false -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /usr/local/vmware-gemfire-9.15.4/lib/geode-core-9.15.4.jar:/usr/local/vmware-gemfire-9.15.4/lib/geode-server-all-9.15.4.jar

Successfully connected to: JMX Manager [host=192.168.0.184, port=1099]

Cluster configuration service is up and running.
```
Note that `gfsh` responds with a message indicating that the cluster configuration service is up and running. If you see 
a message indicating a problem, review the locator log file for possible errors. The path to the log file is displayed 
in the output from `gfsh`.
4. Start Apache Geode servers
```
gfsh>start server --name=server1 --groups=group-1
Starting a Geode Server in /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/server1...
...
Server in /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/server1 on 192.168.0.184[40404] as server1 is currently online.
Process ID: 6855
Uptime: 3 seconds
Geode Version: 9.15.4
Java Version: 13.0.2
Log File: /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/server1/server1.log
JVM Arguments: --add-exports=java.management/com.sun.jmx.remote.security=ALL-UNNAMED --add-exports=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED -Dgemfire.default.locators=192.168.0.184[10334] -Dgemfire.start-dev-rest-api=false -Dgemfire.use-cluster-configuration=true -Dgemfire.groups=group-1 -XX:OnOutOfMemoryError=kill -KILL %p -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /usr/local/vmware-gemfire-9.15.4/lib/geode-core-9.15.4.jar:/usr/local/vmware-gemfire-9.15.4/lib/geode-server-all-9.15.4.jar

gfsh>
gfsh>start server --name=server2 --groups=group-1 --server-port=40405
Starting a Geode Server in /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/server2...
...
Server in /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/server2 on 192.168.0.184[40405] as server2 is currently online.
Process ID: 6883
Uptime: 3 seconds
Geode Version: 9.15.4
Java Version: 13.0.2
Log File: /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/server2/server2.log
JVM Arguments: --add-exports=java.management/com.sun.jmx.remote.security=ALL-UNNAMED --add-exports=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED -Dgemfire.default.locators=192.168.0.184[10334] -Dgemfire.start-dev-rest-api=false -Dgemfire.use-cluster-configuration=true -Dgemfire.groups=group-1 -XX:OnOutOfMemoryError=kill -KILL %p -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /usr/local/vmware-gemfire-9.15.4/lib/geode-core-9.15.4.jar:/usr/local/vmware-gemfire-9.15.4/lib/geode-server-all-9.15.4.jar

gfsh>start server --name=server3 --server-port=40406
Starting a Geode Server in /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/server3...
...
Server in /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/server3 on 192.168.0.184[40406] as server3 is currently online.
Process ID: 6915
Uptime: 3 seconds
Geode Version: 9.15.4
Java Version: 13.0.2
Log File: /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/server3/server3.log
JVM Arguments: --add-exports=java.management/com.sun.jmx.remote.security=ALL-UNNAMED --add-exports=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED -Dgemfire.default.locators=192.168.0.184[10334] -Dgemfire.start-dev-rest-api=false -Dgemfire.use-cluster-configuration=true -XX:OnOutOfMemoryError=kill -KILL %p -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /usr/local/vmware-gemfire-9.15.4/lib/geode-core-9.15.4.jar:/usr/local/vmware-gemfire-9.15.4/lib/geode-server-all-9.15.4.jar
```
Note that the `gfsh` commands you used to start `server1` and `server2` specify a group named `group-1` while the command for 
`server3` did not specify a group name.
5. Create some regions
```
gfsh>create region --name=region-1 --groups=group-1 --type=REPLICATE
Member  | Status | Message
------- | ------ | ---------------------------------------
server1 | OK     | Region "/region-1" created on "server1"
server2 | OK     | Region "/region-1" created on "server2"

Cluster configuration for group 'group-1' is updated.

gfsh>
gfsh>create region --name=region-2 --type=REPLICATE
Member  | Status | Message
------- | ------ | ---------------------------------------
server1 | OK     | Region "/region-2" created on "server1"
server2 | OK     | Region "/region-2" created on "server2"
server3 | OK     | Region "/region-2" created on "server3"

Cluster configuration for group 'cluster' is updated.
```
Note that `region-1` is created on all cache servers that specified the group named `group-1` when starting the cache 
server (`server1` and `server2`, in this example). `region-2` is created on all members because no group was specified.
6. Use the `gfsh deploy` command to deploy application jar files to all members or to a specified group of members
```
gfsh>deploy --groups=group-1 --jars=/Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/lib/mx4j-3.0.2.jar

Deploying files: mx4j-3.0.2.jar
Total file size is: 0.39MB

Continue?  (Y/n): y
Member  |      JAR       | JAR Location
------- | -------------- | -------------------------------------------------------------------------------------------------------------
server1 | mx4j-3.0.2.jar | /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/server1/mx4j-3.0.2.v1.jar
server2 | mx4j-3.0.2.jar | /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/server2/mx4j-3.0.2.v1.jar

gfsh>deploy --groups=group-1 --jars=/Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/lib/activemq-ra-5.18.1.jar

Deploying files: activemq-ra-5.18.1.jar
Total file size is: 0.09MB

Continue?  (Y/n): Y
Member  |          JAR           | JAR Location
------- | ---------------------- | ---------------------------------------------------------------------------------------------------------------------
server1 | activemq-ra-5.18.1.jar | /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/server1/activemq-ra-5.18.1.v1.jar
server2 | activemq-ra-5.18.1.jar | /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/current_geode/server2/activemq-ra-5.18.1.v1.jar
```
Note that the `mx4j-3.0.2.jar` file was deployed only to the members of `group-1` and the `activemq-ra-5.18.1.jar` was 
deployed to all members.
7. Use the `gfsh export cluster-configuration` command to create a zip file that contains the cluster’s persisted 
configuration. The zip file contains a copy of the contents of the `cluster_config` directory
```
gfsh>export cluster-configuration --zip-file-name=/Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/my-cluster-config.zip
File saved to /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/my-cluster-config.zip
```
8. Shut down the cluster
```
gfsh>shutdown --include-locators=true
As a lot of data in memory will be lost, including possibly events in queues, do you really want to shutdown the entire distributed system? (Y/n): Y
Shutdown is triggered
```
9. Exit the `gfsh` command shell
```
gfsh>quit
Exiting...
```
10. Create a new working directory and switch to the new directory.
```
$ mkdir new_geode >> cd new_geode
```
11. Start the `gfsh` command shell
```
$ gfsh
    _________________________     __
   / _____/ ______/ ______/ /____/ /
  / /  __/ /___  /_____  / _____  / 
 / /__/ / ____/  _____/ / /    / /  
/______/_/      /______/_/    /_/    9.15.4

Monitor and Manage VMware GemFire
```
12. Start a new locator
```
gfsh>start locator --name=locator2 --port=10335
Starting a Geode Locator in /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/new_geode/locator2...
.......................
Locator in /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/new_geode/locator2 on 192.168.0.184[10335] as locator2 is currently online.
Process ID: 8581
Uptime: 14 seconds
Geode Version: 9.15.4
Java Version: 13.0.2
Log File: /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/new_geode/locator2/locator2.log
JVM Arguments: --add-exports=java.management/com.sun.jmx.remote.security=ALL-UNNAMED --add-exports=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED -Dgemfire.enable-cluster-configuration=true -Dgemfire.load-cluster-configuration-from-dir=false -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /usr/local/vmware-gemfire-9.15.4/lib/geode-core-9.15.4.jar:/usr/local/vmware-gemfire-9.15.4/lib/geode-server-all-9.15.4.jar

Successfully connected to: JMX Manager [host=192.168.0.184, port=1099]

Cluster configuration service is up and running.
```
13. Import the cluster configuration using the `import cluster-configuration` command
```
gfsh>import cluster-configuration --zip-file-name=/Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/my-cluster-config.zip
This command will replace the existing cluster configuration, if any, The old configuration will be backed up in the working directory.

Continue?  (Y/n): Y
Cluster configuration successfully imported.
```
Note that the `locator2` directory now contains a `cluster_config` subdirectory.
14. Start a server that does not reference a group
```
gfsh>start server --name=server4 --server-port=40414
Starting a Geode Server in /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/new_geode/server4...
...
Server in /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/new_geode/server4 on 192.168.0.184[40414] as server4 is currently online.
Process ID: 8718
Uptime: 4 seconds
Geode Version: 9.15.4
Java Version: 13.0.2
Log File: /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/new_geode/server4/server4.log
JVM Arguments: --add-exports=java.management/com.sun.jmx.remote.security=ALL-UNNAMED --add-exports=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED -Dgemfire.default.locators=192.168.0.184[10335] -Dgemfire.start-dev-rest-api=false -Dgemfire.use-cluster-configuration=true -XX:OnOutOfMemoryError=kill -KILL %p -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /usr/local/vmware-gemfire-9.15.4/lib/geode-core-9.15.4.jar:/usr/local/vmware-gemfire-9.15.4/lib/geode-server-all-9.15.4.jar
```
15. Start another server that references `group-1`
```
gfsh>start server --name=server5 --group=group-1 --server-port=40415
Starting a Geode Server in /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/new_geode/server5...
....
Server in /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/new_geode/server5 on 192.168.0.184[40415] as server5 is currently online.
Process ID: 8784
Uptime: 4 seconds
Geode Version: 9.15.4
Java Version: 13.0.2
Log File: /Users/tampm/Research/Practicals/Gemfire/creating-and-using-a-cluster-configuration/new_geode/server5/server5.log
JVM Arguments: --add-exports=java.management/com.sun.jmx.remote.security=ALL-UNNAMED --add-exports=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED -Dgemfire.default.locators=192.168.0.184[10335] -Dgemfire.start-dev-rest-api=false -Dgemfire.use-cluster-configuration=true -Dgemfire.groups=group-1 -XX:OnOutOfMemoryError=kill -KILL %p -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /usr/local/vmware-gemfire-9.15.4/lib/geode-core-9.15.4.jar:/usr/local/vmware-gemfire-9.15.4/lib/geode-server-all-9.15.4.jar
```
16. Use `list regions` command to display the configured regions
```
gfsh>list regions
List of regions
---------------
region-1
region-2
```
17. Use the `describe region` command to see which members host each region. Note that `region-1` is hosted only by 
`server5` because `server5` was started using the `group-1` configuration. `region-2` is hosted on both `server4` and 
`server5` because `region-2` was created without a group specified.
```
gfsh>describe region --name=region-1
Name            : region-1
Data Policy     : replicate
Hosting Members : server5

Non-Default Attributes Shared By Hosting Members  

 Type  |    Name     | Value
------ | ----------- | ---------------
Region | data-policy | REPLICATE
       | size        | 0
       | scope       | distributed-ack
       
gfsh>
gfsh>describe region --name=region-2
Name            : region-2
Data Policy     : replicate
Hosting Members : server5
                  server4

Non-Default Attributes Shared By Hosting Members  

 Type  |    Name     | Value
------ | ----------- | ---------------
Region | data-policy | REPLICATE
       | size        | 0
       | scope       | distributed-ack
```
This new cluster uses the same configuration as the original system. You can start any number of servers using this 
cluster configuration. All servers will receive the cluster-level configuration. Servers that specify `group-1` also 
receive the `group-1` configuration.
18. Shut down your cluster
```
gfsh>shutdown --include-locators=true
As a lot of data in memory will be lost, including possibly events in queues, do you really want to shutdown the entire distributed system? (Y/n): Y
Shutdown is triggered

gfsh>
No longer connected to 192.168.0.184[1099].
```