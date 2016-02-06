CREATE TABLE `nutrition_product` (
`product_id`  int NOT NULL AUTO_INCREMENT ,
`name`  varchar(255) NOT NULL ,
`qty`  float NOT NULL ,
`dimension_id`  int NOT NULL ,
`description`  varchar(255) NULL ,
`calorie`  int NULL ,
`fat`  float NULL ,
`fat_saturated`  float NULL ,
`carbohydrates`  float NULL ,
`sugar`  float NULL ,
`protein`  float NULL ,
`salt`  float NULL ,
`day_norm_procent`  int NULL ,
PRIMARY KEY (`product_id`)
)
;

CREATE TABLE `nutrition_recipe` (
`recipe_id`  int NOT NULL AUTO_INCREMENT ,
`description`  text NULL ,
`image`  varchar(255) NULL ,
`dimension_id`  int NULL ,
`output_qty`  float NULL ,
`portions`  int NULL ,
`expire_date`  datetime NULL ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`recipe_id`)
)
;

CREATE TABLE `nutrition_dimension` (
`dimension_id`  int NOT NULL AUTO_INCREMENT ,
`name`  varchar(255) NOT NULL ,
PRIMARY KEY (`dimension_id`)
)
;

CREATE TABLE `nutrition_recipe_product` (
`recipe_id`  int NOT NULL ,
`product_id`  int NOT NULL ,
`qty`  float NULL ,
`dimension_id`  int NULL ,
PRIMARY KEY (`recipe_id`, `product_id`)
)
;

CREATE TABLE `nutrition_provision` (
`provision_id`  int NOT NULL ,
`user_id`  int NOT NULL ,
`product_id`  int NOT NULL ,
`qty`  int NULL ,
`expire_date`  datetime NULL ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`provision_id`)
)
;

CREATE TABLE `nutrition_dish` (
`dish_id`  int NOT NULL ,
`recipe_id`  int NOT NULL ,
`client_id`  int NULL ,
`qty`  float NULL ,
`date_made`  datetime NULL ON UPDATE CURRENT_TIMESTAMP ,
PRIMARY KEY (`dish_id`)
)
;

CREATE TABLE `nutrition_history` (
`dish_id`  int NOT NULL ,
`qty`  float NULL ,
`datetime`  datetime NULL ON UPDATE CURRENT_TIMESTAMP 
)
;












