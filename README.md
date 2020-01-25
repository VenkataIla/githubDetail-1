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

![image](https://user-images.githubusercontent.com/22048283/73125650-406eba00-3fcf-11ea-815a-1b48f4ae5fcd.png)


Test bussines criteria 
header “Accept: application/json” To see username's gitrepository detail
![image](https://user-images.githubusercontent.com/22048283/73125599-81b29a00-3fce-11ea-9100-8df1a9bf9e35.png)



header “Accept: application/json” To See invalid username error message (receive 404 response)

![image](https://user-images.githubusercontent.com/22048283/73125614-bc1c3700-3fce-11ea-9e9f-08a922683622.png)


given header “Accept: application/xml” Invalid username error message (receive 406 response)

![image](https://user-images.githubusercontent.com/22048283/73125621-da823280-3fce-11ea-802d-d32a4f8aa009.png)

given header “Accept: application/xml”, valid user (receive 406 response)

![image](https://user-images.githubusercontent.com/22048283/73125635-fc7bb500-3fce-11ea-8766-48681e007399.png)


Stop the service:
```bash
cntr + c
```
## API
```
http://localhost:8080/v1/gitHubDetails/{username}
```

## Maintainers

Venkata Ila

## License

// TODO: Add license
