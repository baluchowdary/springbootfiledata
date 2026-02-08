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


<img width="1468" height="469" alt="image" src="https://github.com/user-attachments/assets/27efe8e0-9e4c-4fe9-8591-3b27bf0bea4e" />


-Added redis cache,  to improve the performance.


-Added normal way of exception handing for redis server down.


-Added Circuit breaker with relisence4J skip the exception while redis server down to avoid API request abnormal termination then continue application flow as we expected.

<img width="1477" height="490" alt="image" src="https://github.com/user-attachments/assets/9d455c76-b28d-45f2-8cf6-b35fd3734fcf" />

