organization := "com.micronautics"

name := "Implicitly Fun"

version := "0.0.1"

scalaVersion := "2.10.2"

logLevel := Level.Error

// Optional settings from https://github.com/harrah/xsbt/wiki/Quick-Configuration-Examples follow

// define the statements initially evaluated when entering 'console', 'console-quick', or 'console-project'
initialCommands := """
"""

// Only show warnings and errors on the screen for compilations.
// This applies to both test:compile and compile and is Info by default
logLevel in compile := Level.Warn
