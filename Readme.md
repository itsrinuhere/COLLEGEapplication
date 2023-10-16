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