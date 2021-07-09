# authentication-spring-mongo-basic

## Authentication Using Spring Security and MongoDB

### This project uses the Spring Security module to enable custom user based authentication.
The verification of the user is done with the help of mongoDB.
Roles of the user are specified while creating the user.
Here there is no controller method mapped for creating the user, so user creation has to be done in the database itself.

A single user in the MongoDB user's collection looks like:
{
	username:"sai", &nbsp;
	password:"-- encode the password using bcrypt encoder and place it here in the db", &nbsp;
	roles: {  &nbsp;
			{ &nbsp;
		name:"ADMIN", &nbsp;
			}, &nbsp;
			{ &nbsp;
		name:"USER"	 &nbsp;
	} &nbsp;
	} &nbsp;
} &nbsp;

Since user creation is not implemented we won't be able to encode the password. So wihle creating the user in the database itself we need to encode the password.

Make sure to create a user in the database before starting this project to test this.
