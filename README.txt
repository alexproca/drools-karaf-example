INSTALL PROJECT IN KARAF - FUSE ESB

addurl mvn:com.redhat.fuse/drools-karaf/1.0-SNAPSHOT/xml/features
features:install drools-module/5.3.0.Final
features:install camel

Test example

install -s mvn:com.redhat.fuse/drools-example/1.0-SNAPSHOT

addurl mvn:net.eads.astrium.adco/features/1.0-SNAPSHOT/xml/features
features:install adco-types
features:install adco-types
