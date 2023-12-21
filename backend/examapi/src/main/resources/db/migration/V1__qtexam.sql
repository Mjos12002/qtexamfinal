CREATE TABLE departments (id UUID NOT NULL, name VARCHAR(20), status INT NOT NULL, PRIMARY KEY (id));
CREATE TABLE profiles (id UUID NOT NULL, names VARCHAR(30) NOT NULL, phonenumber VARCHAR(20) NOT NULL, status INT NOT NULL, address VARCHAR(30), PRIMARY KEY (id));
CREATE TABLE roles (id UUID NOT NULL, name VARCHAR(30) NOT NULL, status INT NOT NULL, PRIMARY KEY (id));
CREATE TABLE users (id UUID NOT NULL, email VARCHAR(50) NOT NULL, password VARCHAR(50) NOT NULL, status INT NOT NULL, profileid UUID NOT NULL, departmentid UUID NOT NULL, PRIMARY KEY (id), CONSTRAINT profileid FOREIGN KEY (profileid) REFERENCES profiles(id), CONSTRAINT departmentid FOREIGN KEY (departmentid) REFERENCES departments(id));
CREATE TABLE userprofiles (id UUID NOT NULL, userid UUID, roleid UUID, status INT NOT NULL, PRIMARY KEY (id), CONSTRAINT userid FOREIGN KEY (userid) REFERENCES users(id), CONSTRAINT roleid FOREIGN KEY(roleid) REFERENCES roles(id));
