
# How to Setup DynamoDb with Android studio (Java/Kotlin)
## Step 1. Make a Aws account 
Offcourse, you have already done.
## Step 2. Go to Aws console > Cognito console > User pools and Identity Pools 
At most cases, You don't need to create user pool
## Step 3. Make New User pool and Identity pool
For find out your identify pool id, Go to Identity pools > click on your identity pool > Go to Sample code > Here is your identity pool id in sample code.
## Step 4. Go to DynamoDb page > Click on 'Create Table' blue button > Create table 
It's always recommended to create your first demo table with above method. 
## Step 5. Provide Required Permissions to access DynamoDb > Go to Aws Console > Go to Your Security Credentials (Look at Profile at top right corner) >  Policies > Search 'AmazonDynamoDBFullAccess' > Click on it >  Policy usages > Attach blue Button > Select your project (If you unable to find your project), Then, Select all item > Then, Click on 'Attach Policy' blue button 
Lots of developers face unauthorized access to dynamoDb error, To prevent it, use above solution.
## Step 7. Go to DynamoDb.kt file > Connect to dynamoDb > finish
Go to Aws DynamoDb Java docs for more details.

