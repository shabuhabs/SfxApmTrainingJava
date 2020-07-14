SignalFX Java Training example

Assumes properly setup SignalFx Smart Agent as described here: https://docs.signalfx.com/en/latest/apm2/apm2-getting-started/apm2-smart-agent.html

How to build: ( linux )

1. Git Clone this Repository

2. Install Maven:

    sudo apt-get install maven 
    
3. Build from Local Repository directory ( where pom.xml is )

    sudo mvn install
    
4. Set Environment Variables

    Set the following Jvm parameters:
    
    signalfx.service.name=MyJavaService
    
    You can change your service name by modifying this Jvm Configuration file in your local cloned copy  of https://github.com/shabuhabs/SfxApmTrainingJava/blob/master/.mvn/jvm.config as follows:
    
    Change the last parameter from -Dsignalfx.service.name=MyJavaService to -Dsignalfx.service.name=NyNewServiceName

5. Run the Example:

     # JMX + Auto-Instrumnentation of Custom Methods:
    
     mvn exec:java -Dexec.mainClass="com.signalfx.training.SfxCurrencyConverterServerAutoJmx"
     
     Then Goto:  http://localhost:8888/?amt=amountToConvert. example http://localhost:8888/?amt=100

6. View Traces in SignalFx
