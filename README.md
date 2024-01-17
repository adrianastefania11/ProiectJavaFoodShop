# ProiectJavaFoodShop

## Info
This application is a simple implementation of a shop, allows the customer to create baskets and see the invoice for the current transaction at the end.

## Business requirements
The app is structured to provide an intuitive interface that responds to the distinct roles of customers and administrators, thereby facilitating efficient management and access to the shop system.

### *For Customers* :

* Items Overview: The app gives customers the ability to browse the full range of items available, giving them full visibility of product offerings.
* Individual Item Inspection and Selection:Customers are given the functionality to review each item in detail and have the option to incorporate chosen items into their shopping cart, increasing the accuracy and personalization of their shopping experience.
* Transaction Processing: The platform supports transaction execution, whereby customers can formalise their purchases by generating an invoice.
* Update profile: Customers have the ability to make changes to their profile information.
* BAasket history: A customer possesses the functionality to access and view the shopping baskets associated with their account
  
### *For Administrators:*

* Item Addition: Administrators are provided with the tools to augment the inventory by introducing new items, ensuring the product offerings remain fresh and relevant.
* Item Modification: The system gives administrators the ability to update existing articles, allowing dynamic adjustment of details 
* Item Removal: Administrators have the authority to remove items from the inventory, facilitating efficient inventory management and the removal of obsolete products.
* View invoices: The application, when utilized by an administrator, had the capacity to access and view all invoices that had been generated.
* Manage invoices: The administrator has the ability to access and review invoices that are associated with a specific shopping basket
  
## Entity-relationship diagram:
![JavaWebAppFoodShop drawio](https://github.com/adrianastefania11/ProiectJavaFoodShop/assets/79542005/8b97537c-b4a5-4238-bb42-65321af87696)

## Swagger Documentation

![image](https://github.com/adrianastefania11/ProiectJavaFoodShop/assets/79542005/a6118949-47df-4a81-871a-798c3e2ed3f2)

## MVP features

### Basket Controller
- `GET /baskets/basketbycustomer`: Retrieve a customer's shopping basket.
- `POST /baskets/create`: Create a new shopping basket.
- `DELETE /baskets/delete`: Remove a customer's basket.
- `PUT /baskets/update`: Update the contents of a basket.

### Basket Item Controller
- `GET /basketitems`: Fetch items in a specific basket.
- `POST /basketitems/create`: Add a new item to a basket.
- `DELETE /basketitems/delete`: Remove an item from a basket.
- `PUT /basketitems/update`: Modify an item within a basket.

### Customer Controller
- `POST /customers/create`: Create a new customer record.
- `DELETE /customers/delete`: Delete a customer record.
- `GET /customers/get`: Retrieve customer details.
- `GET /customers/getCustomerBaskets`: Get all baskets linked to a customer.
- `PUT /customers/update`: Update customer information.

### Invoice Controller
- `GET /invoices/all`: Retrieve all invoices.
- `GET /invoices/basket/{id}`: Get the invoice for a specific basket/order.
- `POST /invoices/create`: Create a new invoice.
- `DELETE /invoices/delete`: Delete an invoice.
- `PUT /invoices/update`: Update an invoice.

### Item Controller
- `GET /items/all`: List all items available for purchase.
- `POST /items/create`: Add a new item to the inventory.
- `DELETE /items/delete`: Remove an item from the store.
- `GET /items/name/{name}`: Retrieve items by their name.
- `PUT /items/update`: Update item details.

