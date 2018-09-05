# DigitalPlatoon
Digital Platoon Assessment

#The following are the links that can be used
For Postting: http://localhost:8080/api/invoice
            #Json data that can be posted for example:
              {  
               "client":"myClient",
               "vatRate":9.5,
               "lineItem":[{
                "quantity" : 9,
                "description" : "description",
                "unitPrice" : 12.5
                }]
               }
For Get: http://localhost:8080/api/invoices
           # Get all the invoices

For Get: http://localhost:8080/api/invoice/{invoiceId}
           # Get the invoice of the specified id
           # {invoiceId} is the id of the invoice your getting
