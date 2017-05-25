# SharpSpring API for Spring

This library provides an interface to the SpringSource API for use with the Spring Framework.

## Versioning

We intend to use semantic versioning. Breaking changes are possible and highly likely until a version 1.0.

## Contributions

Contributions are welcome. This is Ken Cook Co.'s first project available as open source, so we'll be learning and tweaking the process as we go. If some part of the project is not clear, please pull an issue.

## Usage

1. Set sharpspring properties in your application.properties file.
   ```
   sharpspring.account-id=add-your-account
   sharpspring.secret-key=add-your-key
   sharpspring.url=https://api.sharpspring.com/pubapi/v1/
   ```

1. Autowire one of the services into your project.
1. Enjoy!

Low level access is available through the SharpspringOperations class.
