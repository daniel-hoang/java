## Get Started

- New Project -> Gradle(Java)
  - GroupId(my.sandbox), ArtifactId(gradle-spring-boot)
- If src/main/java path not created in your project, File -> Settings -> Build, Execution, Deployment -> Gradle
  - check the "Create directories for empty content roots automatically"
- add to build.gradle
```
   plugins {
      ...
      id 'idea'
      id 'org.springframework.boot' version '2.0.5.RELEASE'
      id 'io.spring.dependency-management' version '0.5.3.RELEASE'
   }
   ...
   dependencies {
       compile 'org.springframework.boot:spring-boot-starter-web'
       ...
   }
```
- Refresh gradle (Gradle vertical tab on the right)
- Create a java package named hello under src/main/java 
- Then follow [Application with Spring Boot - Build with Gradle section](https://spring.io/guides/gs/spring-boot/)
to create class files and run tne main file (Ctrl-Shift-F10)

You may see

WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.springframework.cglib.core.ReflectUtils$1

this should be fixed with Spring Boot 2.1 + Spring 5.1.

## References

- [Spring Boot Gradle Plugin](https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/html/)
- [Building Spring Boot 2 Applications with Gradle](https://guides.gradle.org/building-spring-boot-2-projects-with-gradle/)
- [.gitignore for intellij's java+gradle](https://www.gitignore.io/api/java%2Cgradle%2Cintellij)
