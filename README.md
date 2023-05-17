# Read me

This application was written with using Java 17, Gradle, JAX2B, Junit by Elizaveta Stoliarova
The task is to develop a Java application that transforms XML files containing build reports into Wiki Markup formatted files, which can be imported into an internal wiki. The application should run as a service, monitoring an input folder for new XML files and generating corresponding Wiki Markup files in an output folder. The input and output folders should be specified as command-line arguments.

## How to start

### IDE

Build with gradle tool if necessary. Configure an Application by InteliJ tool, specify main
class (```com.test.wiki.markup.wiki.markupTestReportApp```)

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