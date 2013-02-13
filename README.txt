
-  monitors changes in ADCO rules in Guvnor and activates latest package snapshot automatically 
  --> holds the drools knowledge base
- Compiling is left in Guvnor though so that user has better control and needs to tackle compiler errors
-  feeds telemetry from activmq into drools knowledge base
  - by doing so, it may evaluate the rules to subscribe only to the relevant streams. Subscriptions might therefore be dynamic
- fires all rules in drools every second

INSTALL PROJECT IN KARAF - FUSE ESB

addurl mvn:com.redhat.fuse/drools-karaf/1.0-SNAPSHOT/xml/features
features:install drools-module/5.3.0.Final
features:install camel

Test example

install -s mvn:com.redhat.fuse/drools-example/1.0-SNAPSHOT

addurl mvn:net.eads.astrium.adco/features/1.0-SNAPSHOT/xml/features
features:install adco-types
features:install adco-types
