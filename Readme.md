# Institute API

1. faculty

    ```jsx
    {
    	"id":"#",
    	"name":"#",
    	"gender":"#",
    	"DOB":"#",
    	"department":"#",
    	"designation":"#",
    	"contact_number":"#",
    	"address":"#",
      "experience":{
    
    },
    	"socialLinks":{
    			"x":"#",
    			"facebook":"#",
    			"linkedIn":"#",
    			"Github":"#"
    },
    	"recentEducation":{
    		"type":"#",
    		"id":"#",
    		"issuedBy":"#"
    	}
    }
    ```

2. Research Paper

    ```jsx
    {
    	id:'#',
    	facultyId:'#',
    	title:'#',
    	catagory:'#',
    	uri:'#',
    	BLOBS:['#']
    }
    ```

    1. Domain of research(category)
    2. save research by faculty

   Endpoints

    1. `https://ip:port/researchpaper?category=block%chain`
    2. `https://ip:port/researchpaper?id=1a0111`
    3. `https://ip:port/researchpaper?facultyId=1a101`
    4. `/researchpaper`
        1. post the data to database
    5. get no of doctorates in each department and experiences
        1. `/faculty?deparment=cse&eduQ=doctorate&experience=required`


Test case:

```sql
insert into faculty values
('19641A05M8','srinivas','Male','1998-09-23','CSE','7780394796','Kesamudra,m telangana')
```

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/1ad0cdb1-f38f-4691-ae41-b774d45d7e8f/e50f43be-05d6-448c-969c-31ef318b2554/Untitled.png)





In SQL, executing two queries simultaneously and independently in a single statement is not natively supported. SQL databases typically process queries sequentially. However, you can use database transactions and multithreading in your application to achieve a level of concurrency, which simulates running two queries simultaneously while maintaining data integrity.

Here's an outline of how you can do it:

1. **Create a Transaction**: Start a database transaction. A transaction allows you to group a series of SQL statements and treat them as a single unit of work. This ensures that either all the statements are executed, or none of them are.

2. **Execute the Insert Query**: Inside the transaction, insert the data into one table.

3. **Check the Condition in Another Table**: Execute a SELECT query to check the condition in another table.

4. **Commit or Rollback the Transaction**: Based on the results of the queries, decide whether to commit (if both queries were successful) or rollback (if there's an error).

Here's an example using SQL syntax for a hypothetical database:

```sql
-- Start a transaction
START TRANSACTION;

-- Insert data into Table1
INSERT INTO Table1 (column1, column2) VALUES ('value1', 'value2');

-- Check the condition in Table2
SELECT * FROM Table2 WHERE some_condition;

-- If the condition is met, commit the transaction; otherwise, rollback
COMMIT; -- or ROLLBACK;
```

The actual SQL statements and the syntax will depend on your specific database system (e.g., MySQL, PostgreSQL, SQL Server), and you should use the appropriate client or language to execute these SQL statements. This example assumes that you're using a database system that supports transactions.

Keep in mind that you should handle errors and exceptions in your application code and ensure that you have a robust error-handling strategy when dealing with transactions. Additionally, please consult your database system's documentation for specific details on how to work with transactions.