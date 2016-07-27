# Bassan Tokenizer
Application to manage application properties in a centralized way

## Project wish list

The next are the features that we want to add to tokenizer project.

* Gradle plugin
* The plugin must work correctly in Maven projects too
* Possibility to manage different values for each different environments
* Set of values to switch between they in test environments
* Server exposing restful web services with the information to replace on the token
* Web UI to manage the values
* User and roles to the server and the web app
* Kind of tokens, no just a simple value (paragraph or a segment)
* CDI annotation to use the values on runtime

## Executing the example
This initial example just show a message in the build log taking 2 values
from the build.gradle file.
  
1. cd $PROJECT_HOME/plugin
2. gradle uploadArchive
3. cd ../example
4. gradle hello
  
The 1st and 2nd step are for compile an create a repo with the plugin, 
the 3th and 4th step are for execute the plugin in the example project.

Once the example is run (step 4th) you should see the next output.

    ---------- Message ------------
    Hi from Gradle
    ---------- Message ------------
    
    BUILD SUCCESSFUL

## Uploading the plugin to Nexus

To upload the plugin to Bassan's Nexus, you have to create 2 attributes in your
~/.gradle/gradle.properties. Those attributes are:

    bassanNexusUser=username_to_upload_artifacts
    bassanNexusPass=password_for user_to_upload_artifacts
