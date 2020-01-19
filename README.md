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
To build the application:
```
mvn clean install
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
http://localhost:8080/actuator/health
```

To see swagger:
```
localhost:8080/swagger-ui.html
```

Api spec in Swagger-ui html.
![image](https://user-images.githubusercontent.com/22048283/72680942-376c7d00-3ae5-11ea-8ea3-d13f30635e19.png)

Api spec for to see gitHubDetails
![image](https://user-images.githubusercontent.com/22048283/72680967-74387400-3ae5-11ea-9ebb-9ccbf80400be.png)


Test bussines criteria 
header “Accept: application/json” To see username's gitrepository detail
![image](https://user-images.githubusercontent.com/22048283/72680999-c5486800-3ae5-11ea-8c8f-5df2c9138207.png)


header “Accept: application/json” To See invalid username error message (receive 404 response)
![image](https://user-images.githubusercontent.com/22048283/72681031-ef9a2580-3ae5-11ea-986e-a4dd0a7b8e8d.png)

given header “Accept: application/xml” Invalid username error message (receive 406 response)
![image](https://user-images.githubusercontent.com/22048283/72681055-18bab600-3ae6-11ea-801e-d3f137875d45.png)

given header “Accept: application/xml”, valid user (receive 406 response)
![image](https://user-images.githubusercontent.com/22048283/72681066-3a1ba200-3ae6-11ea-8084-9db010de5c15.png)


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
