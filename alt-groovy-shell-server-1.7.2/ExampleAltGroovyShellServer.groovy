// #!/usr/bin/env groovy

/*
@Grapes([
    @Grab(group='ch.qos.logback', module='logback-classic', version='1.1.7'),
    @Grab(group='me.bazhenov.groovy-shell', module='groovy-shell-server', version='1.7.2')
])
*/

import me.bazhenov.groovysh.GroovyShellService;

/*
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

wget https://github.com/bazhenov/groovy-shell-server/archive/master.zip
unzip master.zip

## find jars and copy flat to lib
## preview
## find ~ |grep '\.jar$' |xargs -I{} echo cp {} lib
## if above looks alright remove echo
## mkdir lib; find ~ |grep '\.jar$' |xargs -I{}      cp {} lib ;

https://github.com/bazhenov/groovy-shell-server/blob/master/groovy-shell-server/src/main/java/me/bazhenov/groovysh/GroovyShellCommand.java
line 80 is too verbose

*/

/*
import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Level;
*/

import org.slf4j.LoggerFactory;
// import static groovy.inspect.swingui.ObjectBrowser.inspect as gi;

// :set verbosity INFO


def nop() {}

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import ch.qos.logback.classic.Level;

// import static groovy.inspect.swingui.ObjectBrowser.inspect as gi;

// def theLogger = org.slf4j.LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
// gi theLogger;
// gi theLogger.level;
// theLogger.level = Level.INFO;
// theLogger.level = Level.ERROR;

GroovyShellService service = new GroovyShellService();

// :set verbosity INFO

service.setPort(6789);
service.setBindings(new HashMap<String, Object>() {{
	//put("foo", obj1);
	//put("bar", obj2);
}});

service.start();

while( 'q' !=  { 
	println "### Press q and enter to quit...";	
	( System.in.read() ) as char;
}.call() );

service.destroy();
