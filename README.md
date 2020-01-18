# GithubDetail

[![standard-readme compliant](https://img.shields.io/badge/standard--readme-OK-green.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)


> This project is for the GithubDetail entity.

- [Install](#install)
- [Usage](#usage)
- [API](#api)
- [Maintainers](#maintainers)
- [Contribute](#contribute)
- [License](#license)

## Install

Once you have cloned this repository, simply import it into your IDE of choosing for editing.

Before using this application, you will need to [download and run version 2.3.0 of Kafka](https://kafka.apache.org/downloads).

Once downloaded, you can [check out the quickstart guide](https://kafka.apache.org/quickstart) to have your instance running.

## Usage

To compile the application:
```
mvn clean compile
```

To test the application:
```
mvn clean compile test
```

To run the integration tests:
```
mvn verify -Psurefire
```

To run the application:
```
mvn spring-boot:run
```

## Validate
To validate that your instance is running open a web browser and goto [localhost:8080](http://localhost:8080). You will see the following message.
```
Welcome to the GithubDetail microservice.
```

Additionally, you have the following endpoints already for your testing of the app.

To test the health endpoint:
```
localhost:8080/health
```

To test the metrics endpoint:
```
localhost:8080/health
```

To see swagger:
```
localhost:8080/swagger-ui.html
```


To see the H2 console:
```
localhost:8080/h2-console
```

Stop the service:
```bash
cntr + c
```
## API

For a walkthrough for extending the services functions, please [see the tutorial/dojo](docs/Dojo.md).

## Maintainers

none

## Contribute

// TODO: Contribute guidelines.

## License

// TODO: Add license