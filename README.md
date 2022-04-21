# Read me

This application was written for Astraia interview with using Java 17, Gradle, JAX2B, Junit by Elizaveta Stoliarova

## How to start

### IDE

Build with gradle tool if necessary. Configure an Application by InteliJ tool, specify main
class (```com.test.astraia.AstraiaTestReportApp```)

### Command line

To build jar run ```./gradlew build``` task from project directory. To run user command ```java -jar astraia.jar```
from folder build/libs.

<details><summary>And follow instruction</summary>
<p>
Input source folder with xml files
Input output folder 
Type exit for finishing program. The program listen input directory and formant any new xml files until it is finished.
</p>
</details>

## Note

*Logging:*
For better visibility there was user console output for logging process. However, it is possible to use any other
logging framework or build-in java classes.

*Test units:*
There were not used mock for mocking some functionality because there is no necessity however for bigger system mocking
objects is rather relevant.

*Questions:*
Formatting of examples a bit confusing because we save formatting as xml for some strings and change the format for
others. It is needed more examples to understand a pattern.