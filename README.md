# jte-localizer-spring-boot-starter

This project is a custom Spring Boot starter project with auto configuration.

It is used to simplify text localization / internationalization when using the
[Java Template Engine (JTE)](https://jte.gg) with Spring Boot.

The goal of this starter is to automatically inject an instance of the interface
[gg.jte.support.LocalizationSupport](https://jte.gg/localization/) into all JTE templates
without any additional code in the Spring MVC controllers.

## Using the starter

The following needs to be done to user the starter on your project.

### Add the required dependencies

**Maven**
```xml
    <dependency>
        <groupId>gg.jte</groupId>
        <artifactId>jte-spring-boot-starter-3</artifactId>
        <version>3.1.16</version>
    </dependency>
    <dependency>
        <groupId>io.github.gadnex</groupId>
        <artifactId>jte-localizer-spring-boot-starter</artifactId>
        <version>${jtelocalizerVersion}</version>
    </dependency>
```

**Gradle**
```groovy
    plugins {
        id 'gg.jte.gradle' version '3.1.16'
    }

    dependencies {
        implementation 'gg.jte:jte-spring-boot-starter-3:3.1.16'
        implementation 'io.github.gadnex:jte-localizer-spring-boot-starter:${jtelocalizerVersion}'
    }
```

### Enable the plugin

**Spring Boot application.properties**
```properties
    gg.jte.localizer.inject: true
```

### Add gg.jte.support.LocalizationSupport param to JTE templates
```html
    @import gg.jte.support.LocalizationSupport

    @param LocalizationSupport localizer

    <h1>${localizer.localize("page.Home")}</h1>
```

### Add localization messages to messages.properties
```properties
    page.Home=Home
```

### Add localization messages to messages_nl.properties
```properties
    page.Home=Thuis
```

## What to expect

By default, Spring Boot will use files names messages.properties in the classpath
root to perform localization.

Depending on the **accept-language** request header that the Web Browser sends on
HTTP requests, the correct messages_XX.properties for the locale will be selected
for localization.

This plugin works well with the defaults of Spring Boot and should work well with
customization of the default Spring Boot behaviour.

## Project Goal

The goal of this project is to have its functionality incorporated into the
standard **jte-spring-boot-starter-3** so that this plugin will no longer be required
in the future.

This is the reason why the plugin needs to be specifically enabled in
application.properties. We want the default behaviour to be for the 
plugin to be disabled.