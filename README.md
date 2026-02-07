Reading comma (,) separated values from file

Post => http://localhost:9090/springbootfiledata/csv/upload

body -> form-data -> key=file then select drop down and choose file option then upload sample .csv file data


filedata.csv

name,price
"kollu1",25.50
"kollu2",89.99
"kollu3",12.00
"kollu4",45.00
"kollu5",30.25
"kollu6",30.25

Get ==> http://localhost:9090/springbootfiledata/csv/readfile


Delete  ==> http://localhost:9090/springbootfiledata/csv/deletedata


===============

Sample pipeline seperated data 

PRODUCT_NAME|PRODUCT_PRICE
kollu1|25.50
kollu2|89.99
kollu3|12.00
kollu4|45.00
kollu5|30.25
kollu6|30.25


Redis Server 

<img width="1497" height="864" alt="image" src="https://github.com/user-attachments/assets/a76b4f43-0992-42b6-bdcb-0bae51e0a5ce" />


If Redis server down 

<img width="1490" height="323" alt="image" src="https://github.com/user-attachments/assets/ff1b4c72-d16d-4b26-893d-1c5588072e25" />



