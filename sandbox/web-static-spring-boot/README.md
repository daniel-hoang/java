## Getting Started

This sandbox plays around with Oracle JET front-end, and how to deploy its web content to
spring boot resources/static.

I use Oracle JET 5.2.0 release to create a basic web application using JET CLI tool:

- from the root of your project, create a jet directory
- from jet directory, ```ojet create --template=basic```, and this would create a front-end development setup for a basic web application
- to build the web application, ```ojet build```, and this would create a deployable web directory.
- we need to copy the web directory to spring-root's src/main/resources/static directory
  - create src/main/resource/static directory
  - use the followings in jet/scripts/hooks/after_build.js:
    ```
    /**
      Copyright (c) 2015, 2018, Oracle and/or its affiliates.
      The Universal Permissive License (UPL), Version 1.0
    */
    'use strict';
    const fs = require('fs-extra');
    const archiver = require('archiver');
    module.exports = function (configObj) {
      return new Promise((resolve, reject) => {    
        // After ojet build, copy the web to spring-boot's resources/static
        fs.copy('web', '../src/main/resources/static', function (err) {
          if (err) {
            console.error(err);
          } else {
            console.log("success!");
          }
        });
      });
    };
    
    ```
- Now when you ```ojet build```, this would copy the web content to src/main/resources/static directory
- Browse to http://localhost:8080, and you should see the JET basic web application
- To release your web application, ```ojet build --release```.

## References

- [Spring Boot - Serving static web contents](https://www.logicbig.com/tutorials/spring-framework/spring-boot/boot-serve-static.html)
- [Oracle JET 5.2.0 - Install the Oracle JET CLI](https://docs.oracle.com/en/middleware/jet/5.2/develop/prerequisites-developing-applications-oracle-jet.html#GUID-6AEB5A00-22D8-4BC1-AAB3-4134F906C1C0)
- [Create a web application using Oracle JET CLI](https://docs.oracle.com/en/middleware/jet/5.2/develop/getting-started-oracle-jet-web-application-development.html#GUID-079D873B-5B18-4997-BD82-1B7E7095C382)