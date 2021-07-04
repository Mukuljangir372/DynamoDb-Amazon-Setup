package com.mu.jan.relax.data

import android.content.Context
import android.util.Log
import androidx.constraintlayout.widget.ConstraintAttribute
import com.amazonaws.auth.CognitoCachingCredentialsProvider
import com.amazonaws.mobileconnectors.dynamodbv2.document.Table
import com.amazonaws.mobileconnectors.dynamodbv2.document.datatype.Document
import com.amazonaws.mobileconnectors.dynamodbv2.document.datatype.DynamoDBEntry
import com.amazonaws.regions.Region
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.amazonaws.services.dynamodbv2.model.*
import com.mu.jan.relax.utils.runOnBack

object DynamoDb {
    fun createTable(mContext: Context){
        runOnBack {
            //This is my region in Aws
            val region = Regions.US_EAST_2
            
            val credentials = CognitoCachingCredentialsProvider(
                mContext,"IDENTITY_POOL_ID","YOUR_REGION"
            )

            val client = AmazonDynamoDBClient(credentials)
            client.setRegion(Region.getRegion(Regions.US_EAST_2))

           //create table 
           val tableRequest = CreateTableRequest().withTableName("Demo")
               .withKeySchema(mutableListOf<KeySchemaElement>(KeySchemaElement("id",KeyType.HASH)))
               .withAttributeDefinitions(mutableListOf<AttributeDefinition>(AttributeDefinition("id",ScalarAttributeType.N)))
               .withProvisionedThroughput(ProvisionedThroughput(1000,1000))

           client.createTable(tableRequest)
           
            //loading table
            val table = Table.loadTable(client,"Demo")

            //adding item 
            val doc = Document()
            doc.put("id","1")
            try{
                table.putItem(doc)
                Log.d("ABC","successfully added item to table named Demo")
            }catch (e: Exception){
                //failed to add item
                Log.d("ABC","${e.localizedMessage}}")
            }

        }


    }

}
