CREATE TABLE EMPLOYEE(
    id long not null AUTO_INCREMENT,
    primary key(id),
    name varchar(200),
    age int,
    nationality varchar(200)
);


-- facing issues with generating ID's using @generated annotation
-- issues with sequences
--@Mockbean is giving NULL error
--in update -> we using repo.save only