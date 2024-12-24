Setup Instruction for the project:
1.download the zip file (from github)
2.unzip it
3.open the project using an ide (Intelij)
4.start/run the application (application runs at port no :8080)
5.open postman (for testing api endpoints)

Technologies Used:
1.Backend-Spring-boot
2.Database-H2 SQL In memory Database (since it is not production I have used Inmemory DB)
3.Language-Java

Information to know before testing endpoints:
1.	The database is initialized with 100 sample data entries, consisting of 10 categories, each containing 10 products.
2.	To view the data (Stored in H2 DB) follow the steps:
1.open your browser(chrome)
2. http://localhost:8080/h2-console/
3.JDBC url: jdbc:h2:mem:test
4.Username: sa
5.Passsowrd: (empty)
6.you will be able to see data present under each schema


API Testing (Open Postman):
1.	Getting all trending products 

1.endpoint: GET  http://localhost:8080/api/recommendation/user
2. Query Params:
                1.pageNumber:  0(default)
                 2.pageSize:    10(default)
Note: You can provide query parameters through Postman as per your requirements.

                
2.	Get all products based on the category.

1.endpoint : GET http://localhost:8080/api/recommendation/category/{categoryId}

                    categoryId:1 to 10
sample endpoint for category 3:

http://localhost:8080/api/recommendation/category/3

2. Query Params:
                1.pageNumber:  0(default)
                2.pageSize:    10(default)
                3.sortBy: productId(default)/price/rating
                4.sortOrder:asc(default)/desc
                5.priceMin:0(default)
                6.priceMax:100000(default)
                7.minProductRating:0(default)/1/2/3/4/5
                8.productSize: empty(default)/S/M/L




3.View Product By Id:
             1.endpoint: PUT http://localhost:8080/api/events/view/{productId}
                       productid: 1 to 100 (Provided)
                       sample endpoint for product 2: http://localhost:8080/api/events/view/2


4.Like product By Id:
          1.endpoint : PUT http://localhost:8080/api/events/like/{productId}

          Sample endpoint to like a product:  http://localhost:8080/api/events/like/2

            2. Query Params:
                1.userId:  it is mandatory to provide userId (userId>=0)
                               Note: I have temporarily kept it random.

   5.Purchase Product By Id:

1.	Endpoint: PUT http://localhost:8080/api/events/purchase/{productId}

Sample endpoint to purchase a product: http://localhost:8080/api/events/purchase/4
                 2. Query Params:
                1.userId:  it is mandatory to provide userId (userId>=0)
      
                2. purchaseQuantity: 1(default)/2/3/4……..
                               Note: I have temporarily kept userId random.


Constraints for Improvement:
1.Usermanagement and Session Management
2.Authentication and Authorization
3.Replace H2 DB with Prod grade DB
4.couple of endpointsto be added like : deleteproduct,createproduct, delete category,cart feature etc….

Ref used:
Youtube, sample data obtained from llms ,my previous project…
